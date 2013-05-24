package compserver.tcasegen.strategies.setlog.setlogtoz;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;

import compserver.tcasegen.strategies.setlog.SetLogUtils;
import compserver.tcasegen.strategies.setlog.TypeManagerParser;

public final class ConstantCreator {

	private DefaultMutableTreeNode arbol;
	private HashMap<String,String> tipos;
	private HashMap<String,String> zNames;
	private HashMap<String,String> valoresProhibidos;
	private HashMap<String,StringPointer> slVars;
	private List<String> basicTypes;

	private int postfijo;
	protected String getNumber(){
		return String.valueOf(postfijo++);
	}

	//llena la estructura freeTypes, la cual se usa para saber el tipo de una variabla
	//que no figura en slvars, a partir de un elemento que esta en desigualdad en contraint
	private void llenarBasicTypes(){
		basicTypes = new LinkedList<String>();
		Iterator<String> iterator = tipos.keySet().iterator();
		String key,valor;
		while (iterator.hasNext()) { 
			key = iterator.next().toString();
			valor = tipos.get(key);
			//EnumerationType:FT:{elem1,elem2}
			if (valor.startsWith("BasicType"))
				basicTypes.add(key);
		}
	}

	private boolean esVariable(String expr){
		char c = expr.charAt(0);
		return (expr.startsWith("_")|| Character.isUpperCase(c));
	}

	private boolean esCteSimple(String expr){
		char c = expr.charAt(0);
		return (Character.isLowerCase(c) || Character.isDigit(c) || c == '-');
	}

	private void refrescarValoresProhibidos(String var, String expr){
		Iterator<String> it = valoresProhibidos.keySet().iterator();
		String key,value;
		while (it.hasNext()) {  
			key = it.next().toString();
			value = valoresProhibidos.get(key);
			value = value.replace(var, expr);
			valoresProhibidos.put(key, value);
		}
	}

	private boolean soloTipoFinito(DefaultMutableTreeNode nodo){
		String tipo = TypeManagerParser.printTree(nodo);
		if(tipo.contains("num") || tipo.contains("nat"))
			return false;
		if (basicTypes == null)
			llenarBasicTypes();
		if (basicTypes!=null){
			Iterator<String> it = basicTypes.iterator();
			while(it.hasNext()){
				if (tipo.contains(it.next()))
					return false;
			}
		}
		return true;
	}

	//devuelve una cte distinta a todos 
	private String getCteDesigual(DefaultMutableTreeNode nodo,String var){
		String salida = null;
		ExprIterator exprs = new ExprIterator("{"+valoresProhibidos.get(var)+"}");
		int nats[] = new int[exprs.cardinalidad()];
		int i = 0;
		String expresion = null;
		IntExprMap varMap = new IntExprMap(tipos);
		while(exprs.hasNext()){
			expresion = exprs.next();
			//si no es varaible convierto la expresion a nat
			if (!esVariable(expresion)){
				nats[i] = varMap.toNum(nodo,expresion);
				i++;
			}
		}
		String tipo = nodo.toString();

		//el 0 de tipo power y seq es {},el resto de los tipos empieza en 1
		int varNat = 0 ;
		if (!tipo.equals("\\power") && !tipo.equals("\\seq")){
			varNat = 1;
		}

		//m es la cantidad de constantes que fueron mapeadas a nat, y  a las cuales var debe ser distinta.
		int m = i;
		i = 0;
		while (i<m){
			if(varNat==nats[i]){
				varNat++;
				i = 0;
			}
			else
				i++;
		}
		salida = varMap.toExpr(nodo, varNat);
		refrescarValoresProhibidos(var,salida);

		return salida;
	}



	/* Dado un tipo y una variable, crea un terminal del tipo y se lo asigna a la variable
	 * Refresca valoresProhibidos, reemplaza el nombre de la variable por el valor cte generado*/
	private String cteRestringuida(DefaultMutableTreeNode nodo, String var){
		String salida = null;

		//si no tiene desigualdades
		if(valoresProhibidos == null)
			return  cteCanonica(nodo,var);
		if(valoresProhibidos.get(var) == null)
			return  cteCanonica(nodo,var);

		//si esta formados por al menos un tipo no finito
		if(!soloTipoFinito(nodo)){
			salida = cteCanonica(nodo,var);
			refrescarValoresProhibidos(var,salida);
			return salida;
		}

		//si esta formado solo por tipos finitos
		salida = getCteDesigual(nodo, var);

		return salida;
	}

	/*Dado un tipo y una variable, genera un terminal canonico para el tipo*/
	private String cteCanonica(TreeNode nodo,String var) {
		String ct = nodo.toString();

		if (ct.equals("\\num") || ct.equals("\\nat") ) 
			return this.getNumber();

		if(ct.equals("\\cross"))
			return cteCanonica(nodo.getChildAt(0),var) + "," + cteCanonica(nodo.getChildAt(1),var)  ;

		if (ct.equals("\\power")) 
			return "{" + cteCanonica(nodo.getChildAt(0),var) + "}";

		if (ct.equals("\\seq")) 
			return "[" + cteCanonica(nodo.getChildAt(0),var) + "]";

		String tipoCompleto = tipos.get(ct);
		if (tipoCompleto.startsWith("SchemaType")){
			ExprIterator tiposDecl = schemaTypeToExprIterator(ct,tipoCompleto);
			String salida = "";
			int i = 1;
			while(tiposDecl.hasNext()){
				salida += "," + cteCanonica(SetLogUtils.toTreeNorm(tiposDecl.next()),"X"+i);
			}
			if (!salida.isEmpty())
				return "[" + salida.substring(1) + "]";
			return "[]";
		}
		String cte;
		//si es EnumerationType
		if (tipoCompleto.startsWith("EnumerationType")){
			//si nodoType == EnumerationType:FT:{elem1,elem2}
			// aux = EnumerationType:FT: , elem1 , elem2}
			String[] aux = tipoCompleto.split("[{,]");
			cte =  aux[1];
			return cte;
		}
		//si es basicType
		//para cuando se llama con la lista de zName vacia, cuando var ya es una variable Z.
		cte = ct.toLowerCase();
		if(zNames == null)
			cte = cte + var;
		else
		{
			String zname = zNames.get(var);
			if (zname == null)
				cte = cte + this.getNumber();
			else
				cte = cte + zname.replace("?","");
		}
		return cte;
	}

	/* Dada una expresion y un tipo, genera un terminal cte para el tipo respetando la estructura de la expresion
	 * ej. expr = {[a,X]} y tipo = FT \pfun \num    genera     {[a,1]}	
	 * las variables dentro de la expresion pueden tener valores prohibidos, o valores ya calculados */
	private String cte(DefaultMutableTreeNode nodo, String exprS) {

		ExprIterator expr = new ExprIterator(exprS);

		char c = exprS.charAt(0);
		String ct = nodo.toString();
		String salida = "";

		// si es variable auxiliar de {log} genero
		if (esVariable(exprS)) {
			String cte = null;
			StringPointer sp;

			if (slVars!=null){
				sp = slVars.get(exprS);
				//no cambiar el orden de la conjuncion, para que pueda chequear el lado derecho, el izquierdo debe ser falso
				if (sp != null && sp.toString() != null)
					cte = sp.toString();
				else
					cte = cteRestringuida(nodo,exprS);
			}
			else
				cte = cteRestringuida(nodo,exprS);

			if (slVars!=null)
				slVars.put(exprS, new StringPointer(cte));
			salida = cte;//la longitud que va es la original, no la inventada
			//porque siempre me muevo en el string expr original
			return salida;
		}
		// si es constante la meto
		if (esCteSimple(exprS)) {
			salida = (c=='-')?("\\neg " + exprS):exprS;
			return salida;
		} 
		if (ct.equals("\\cross")){
			//caso [X,Y]
			salida = "[" + cte((DefaultMutableTreeNode) nodo.getChildAt(0),expr.next()) + "," + cte((DefaultMutableTreeNode) nodo.getChildAt(1),expr.next()) + "]"; 
			return salida;
		}
		if (ct.equals("\\power") ) {
			//es por que el tipo \\powe(\\num\\pfun\\A) es equivalente a \\seq A
			if(c == '['){
				DefaultMutableTreeNode naux = new DefaultMutableTreeNode("\\seq");
				// powe->()->x->A        (der)
				//			  ->NUM|NAT  (izq)
				DefaultMutableTreeNode nauxHijo = (DefaultMutableTreeNode) ((nodo.getChildAt(0)).getChildAt(0)).getChildAt(1);
				naux.add(nauxHijo);
				return salida = cte(naux,exprS);
			}

			String elem;
			while(expr.hasNext()){
				elem = expr.next();
				salida += "," + cte((DefaultMutableTreeNode) nodo.getChildAt(0),elem); 
			}
			if (!salida.isEmpty())
				return "{" + salida.substring(1) + "}";
			return "{}";

		}
		if (ct.equals("\\seq") ) {
			String elem;
			while(expr.hasNext()){
				elem = expr.next();
				salida += "," + cte((DefaultMutableTreeNode) nodo.getChildAt(0),elem); 
			}
			if (!salida.isEmpty())
				return "[" + salida.substring(1) + "]";
			return "[]";
		}
		/*es tipo esquema, porque tiene estructura y no es ningun tipo anterior */
		//pinta [X,X,X]
		ExprIterator tiposDecl = schemaTypeToExprIterator(ct,tipos.get(ct));
		String elem;
		while(expr.hasNext()){
			elem = expr.next();
			salida += "," + cte(SetLogUtils.toTreeNorm(tiposDecl.next()),elem); 
		}
		if (!salida.isEmpty())
			return "[" + salida.substring(1) + "]";
		return "[]";

	}

	private ExprIterator schemaTypeToExprIterator(String nomTipo,String tipoCompleto){
		// ej SchemaType:Estado:[var1:\num,var2:E]
		// "SchemaType:".length() = 
		tipoCompleto = tipoCompleto.substring(12+nomTipo.length());
		ExprIterator expr = new ExprIterator(tipoCompleto);
		String elem,aux[],salida="";
		while(expr.hasNext()){
			elem = expr.next();
			aux = elem.split(":");
			salida += "," + aux[1];
			System.out.println(elem);
		}
		salida = "{" + salida.substring(1) + "}";
		return new ExprIterator(salida);
	}

	/*No resulve el siguiente estilo de casos {a,C} donde el tipo es \power FT. Es decir no genera conjuntos donde los valores del mismo es solo
	 * construcciones de tipos finitos. */
	ConstantCreator(HashMap<String, String> tipos,HashMap<String, String> znames,HashMap<String,StringPointer> slVars,HashMap<String,String> valoresProhibidos) {
		this.tipos = tipos;
		this.zNames = znames;
		this.slVars = slVars;
		this.valoresProhibidos = valoresProhibidos;
		this.basicTypes = null;
		this.postfijo = 1;
	}

	String getCte(String expr, DefaultMutableTreeNode root){
		expr = expr.replaceAll("\\s+",""); 
		this.arbol = root;
		String s = cte(arbol, expr);
		return s;
	}

}
