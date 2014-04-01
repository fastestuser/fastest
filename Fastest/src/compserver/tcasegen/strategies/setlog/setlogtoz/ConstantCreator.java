package compserver.tcasegen.strategies.setlog.setlogtoz;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;

import common.util.ExprIterator;
import common.z.SpecUtils;
import common.z.czt.UniqueZLive;
import common.z.czt.visitors.StringToNumReplacer;
import compserver.tcasegen.strategies.setlog.SetLogUtils;
import compserver.tcasegen.strategies.setlog.TypeManagerParser;
import net.sourceforge.czt.animation.eval.ZLive;
import net.sourceforge.czt.parser.oz.ParseUtils;
import net.sourceforge.czt.session.StringSource;
import net.sourceforge.czt.z.ast.Pred;

/* La diferencia entre cte() , cteCanonica() , cteRestringuida() y cteDesigual().
 * cte() -> cteRestringuida() ->  cteCanonica() || cteDesigual() || cteInfinita() -> cteCanonica()
 * cte() toma expresiones con estructura (ej: {[A,14],Y}), que respeta para generar una cte.
 *  
 * cuando la expresion es un VARNAME (ej: X), es decir crea una cte armando la estructura, 
 * si esta en constraint y es de tipo finito se usa cteDesigual() 
 * si esta en constraint y tiene un tipo infinito se usa cteInfinita() la cual usa varias veces cteCanonica()
 * si no esta en constraint se usa solo una vez cteCanonica().
 * */

public final class ConstantCreator {

	private HashMap<String, String> tipos;
	private HashMap<String, String> valoresProhibidos;
	private HashMap<String, StringPointer> slVars;
	private List<String> basicTypes;
	private List<String> schemaTypes;
	private HashMap<String, String> zNames;
	private int postfijo;
	private int MAXTRYCTEINF = 100;

	protected String getNumber() {
		return String.valueOf(postfijo++);
	}

	/*
	 * llena la estructura basicTypes, la cual se usa para saber si una
	 * expresion tiene como parte de su tipo un tipo basico, el cual entonces no
	 * es finito
	 */
	private void llenarBasicTypes() {
		basicTypes = new LinkedList<String>();
		Iterator<String> iterator = tipos.keySet().iterator();
		String key, valor;
		while (iterator.hasNext()) {
			key = iterator.next().toString();
			valor = tipos.get(key);
			// EnumerationType:FT:{elem1,elem2}
			if (valor.startsWith("BasicType"))
				basicTypes.add(key);
		}
	}
	
	/*
	 * llena la estructura schemaTypes, la cual se usa para saber si una
	 * expresion tiene como parte de su tipo un tipo schema
	 */
	private void llenarSchemaTypes() {
		schemaTypes = new LinkedList<String>();
		Iterator<String> iterator = tipos.keySet().iterator();
		String key, valor;
		while (iterator.hasNext()) {
			key = iterator.next().toString();
			valor = tipos.get(key);
			// EnumerationType:FT:{elem1,elem2}
			if (valor.startsWith("SchemaType"))
				schemaTypes.add(key);
		}
	}

	/*
	 * mantiene el invariante de valoresProhibidos. Reemplaza en todos los
	 * values la variable por la expresion instanciada.
	 */
	private void refrescarValoresProhibidos(String var, String expr) {
		Iterator<String> it = valoresProhibidos.keySet().iterator();
		String key, value;
		while (it.hasNext()) {
			key = it.next().toString();
			value = valoresProhibidos.get(key);
			value = value.replace(var, expr);
			valoresProhibidos.put(key, value);
		}
	}

	/* Determina si un nodo solo tiene nodos de tipo finito o no */
	private boolean soloTipoFinito(DefaultMutableTreeNode nodo) {
		String tipo = TypeManagerParser.printTree(nodo);
		if (tipo.contains("num") || tipo.contains("nat"))
			return false;
		if (basicTypes == null)
			llenarBasicTypes();
		if (basicTypes != null) {
			Iterator<String> it = basicTypes.iterator();
			while (it.hasNext()) {
				if (tipo.contains(it.next()))
					return false;
			}
		}
		if (schemaTypes == null)
			llenarSchemaTypes();
		if (schemaTypes != null) {
			Iterator<String> it = schemaTypes.iterator();
			while (it.hasNext()) {
				String schemaType = it.next();
				if (tipo.contains(schemaType)) { //Si tiene un tipo schema
					String schemaTypeComplete = tipos.get(schemaType);
					//String schemaNode = SetLogUtils.toTreeNorm(schemaTypeComplete).toString();
					ExprIterator tiposDecl = SetLogUtils.schemaToTypeExprIterator(schemaTypeComplete);
					boolean out = true;
					while ((out == true) && (tiposDecl.hasNext())) 
						out = soloTipoFinito(SetLogUtils.toTreeNorm(tiposDecl.next()));
					if (out == false)
						return false;
				}
			}
		}
		
		return true;
	}

	/*
	 * instancia un valor para var, de tal manera que respete las desigualdades
	 * de valoresProhibidos esto es, no darle ningun valor que este como value
	 * en valoresProhibidos, para la key var los valores que esquiva son los que
	 * corresponden a ctes, las variables las ignora. ej: valoresProhibidos: var
	 * -> A,B,{1,2,3},{1,2}, se tiene que generar un valor para var distinto a
	 * A,B,{1,2,3} y {1,2}. como A y B no estan instanciados los ignora, mapea
	 * {1,2,3} y {1,2} a un numero y genera un numero distinto, el menor posible
	 * distinto a los mapeos de esos dos, despues lo transforma a una expresion
	 */
	private String cteDesigual(DefaultMutableTreeNode nodo, String var) {
		String salida = null;
		ExprIterator exprs = new ExprIterator("{" + valoresProhibidos.get(var)+ "}");
		int nats[] = new int[exprs.cardinalidad()];
		int i = 0;
		String expresion = null;
		IntExprMap varMap = new IntExprMap(tipos);
		while (exprs.hasNext()) {
			expresion = exprs.next();
			// si no es varaible convierto la expresion a nat
			if (!SetLogUtils.esSLVariableSimple(expresion)) {
				nats[i] = varMap.toNum(nodo, expresion);
				i++;
			}
		}
		String tipo = nodo.toString();

		// el 0 de tipo power y seq es {},el resto de los tipos empieza en 1
		int varNat = 0; // int que sera transformado a una expresion
		if (!tipo.equals("\\power") && !tipo.equals("\\seq"))
			varNat = 1;

		// consigo el valor final para varNat. buscando el minimo posible
		int m = i; // m es la cantidad de constantes que fueron mapeadas a nat,
		// y a las cuales var debe ser distinta.
		i = 0; // ahora i se usa como iterador comun.
		while (i < m) {
			if (varNat == nats[i]) {
				varNat++;
				i = 0;
			} else
				i++;
		}
		salida = varMap.toExpr(nodo, varNat);
		refrescarValoresProhibidos(var, salida);

		return salida;
	}

	/*Retorna falso si el valor de la variable var es distinto a todos los valores que hay en el iterador ei*/
	private boolean esProhibida(DefaultMutableTreeNode nodo,String var,ExprIterator ei) {
		try {
			ZLive zLive = UniqueZLive.getInstance();
			SetLogUtils.setLogToLatexCharsReplacerInit(tipos, slVars, zNames);
			String v,varz,vz;
			Pred pred;
			ei.reiniciar();
			while(ei.hasNext()){
				v = ei.next();
				varz = SetLogUtils.setLogToLatexCharsReplacer(nodo, var);
				vz = SetLogUtils.setLogToLatexCharsReplacer(nodo,v);
				pred = ParseUtils.parsePred(new StringSource(varz + " = " + vz), zLive.getCurrentSection(), zLive.getSectionManager());
				pred = (Pred)pred.accept(new StringToNumReplacer());
				pred = zLive.evalPred(pred);
				if (SpecUtils.termToLatex(pred).equals("true")) 
					return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	/* Dado un tipo y una variable, genera un terminal canonico para el tipo de tal manera que no sea
	 * ninunga de las constantes que estan asociadas en valoresProhibidos, prueba MAXTRYCTEINF veces como maximo.*/
	private String cteInfinita(DefaultMutableTreeNode nodo, String var) {
		boolean esProhibida = true;
		String cte = null;
		int i = 0;
		ExprIterator it = new ExprIterator("{" + valoresProhibidos.get(var) + "}");
		while (esProhibida && i < MAXTRYCTEINF) {
			cte = cteCanonica(nodo, var);
			esProhibida = esProhibida(nodo,cte,it);
			i++;
		}
		cte = (i == 100)? "" : cte;
		return cte;
	}

	/*
	 * Dado un tipo y una variable, instsancia una variable del tipo y se lo
	 * asigna a la variable Si está en valoresProhibidos y es de tipo finito,
	 * respeta y los refresca. Si no genera una cte generica
	 */
	private String cteRestringuida(DefaultMutableTreeNode nodo, String var) {
		String salida = null;

		// si no tiene desigualdades
		if (valoresProhibidos == null)
			return cteCanonica(nodo, var);
		if (valoresProhibidos.get(var) == null)
			return cteCanonica(nodo, var);

		// si esta formados por al menos un tipo no finito
		if (!soloTipoFinito(nodo)) {
			salida = cteInfinita(nodo, var);
			// salida = cteCanonica(nodo,var);
			refrescarValoresProhibidos(var, salida);
			return salida;
		}

		// si esta formado solo por tipos finitos
		salida = cteDesigual(nodo, var);
		return salida;
	}

	/* Dado un tipo y una variable, genera un terminal canonico para el tipo */
	private String cteCanonica(TreeNode nodo, String var) {
		String ct = nodo.toString();

		if (ct.equals("\\num") || ct.contains("nat"))
			return this.getNumber();

		if (ct.equals("\\cross"))
			return "[" + cteCanonica(nodo.getChildAt(0), var) + ","	+ cteCanonica(nodo.getChildAt(1), var) + "]";

		if (ct.equals("\\power"))
			return "{" + cteCanonica(nodo.getChildAt(0), var) + "}";

		if (ct.contains("seq"))
			return "[" + cteCanonica(nodo.getChildAt(0), var) + "]";

		if (ct.contains("upto")) {
			String aux[] = var.split("\\\\upto");
			String l1 = aux[0];
			if (slVars != null) {
				if (SetLogUtils.esSLVariableSimple(l1)) {
					if (slVars.get(l1) != null)
						l1 = slVars.get(l1).toString();
					else {
						slVars.put(l1, new StringPointer(this.getNumber()));
						l1 = this.getNumber();
					}
				}
			}
			return l1;
		}
		// Si el tipo es hecho por el usuario, tengo que ir a buscar el tipo
		// unfoldeado a tipos.
		String tipoCompleto = tipos.get(ct);
		if (tipoCompleto.startsWith("SchemaType")) {
			ExprIterator tiposDecl = SetLogUtils.schemaToTypeExprIterator(tipoCompleto);
			ExprIterator varsDecl = SetLogUtils.schemaToVarExprIterator(tipoCompleto);
			StringBuilder salida = new StringBuilder();
			while (tiposDecl.hasNext())
				salida.append(","+ cteCanonica(SetLogUtils.toTreeNorm(tiposDecl.next()),varsDecl.next()));

			if (!salida.toString().isEmpty())
				return "[" + salida.substring(1) + "]";
			return "[]";
		}
		// si es EnumerationType
		if (tipoCompleto.startsWith("EnumerationType")) {
			// si nodoType == EnumerationType:FT:{elem1,elem2}
			// aux = EnumerationType:FT: , elem1 , elem2}
			String[] aux = tipoCompleto.split("[{,]");
			return aux[1];
		}
		if (tipoCompleto.startsWith("BasicType")) {
			String salida = ct.toLowerCase() + getNumber();
			return salida;
		}
		return var;
	}
	
	boolean esProhibido(String var, String cte){
		ExprIterator it = new ExprIterator("{" + valoresProhibidos.get(var) + "}");
		return it.contains(cte);
	}

	/*
	 * Dada una expresion y un tipo, genera un terminal cte para el tipo
	 * respetando la estructura de la expresion ej. expr = {[a,X]} y tipo = FT
	 * \pfun \num genera {[a,1]} las variables dentro de la expresion pueden
	 * tener valores prohibidos, o valores ya calculados
	 */
	private String cte(DefaultMutableTreeNode nodo, String exprS) {

		ExprIterator expr = new ExprIterator(exprS);

		char c = exprS.charAt(0);
		String ct = nodo.toString();
		StringBuilder salida = new StringBuilder();

		if (exprS.startsWith("int(")) {

			String aux[] = exprS.substring(4, exprS.length() - 1).split(",");
			String a = cte(new DefaultMutableTreeNode("\\num"),aux[0]);
			String b = cte(new DefaultMutableTreeNode("\\num"),aux[1]);
			if (!a.equals("ValueNotAssigned") && !b.equals("ValueNotAssigned") && Integer.valueOf(b) < Integer.valueOf(a))
				return "{}";

			return "int(" + a + "," + b + ")";
		}

		if (SetLogUtils.esSLVariableSimple(exprS)) {
			String cte = null;
			StringPointer sp;
			if (slVars != null) {
				sp = slVars.get(exprS);
				// no cambiar el orden de la conjuncion, para que pueda chequear
				// el lado derecho, el izquierdo debe ser falso
				if (sp != null && sp.toString() != null	&& sp.toString().equals("ValueNotAssigned"))
					return exprS;
				if (sp != null && sp.toString() != null && !esProhibido(exprS,sp.toString()) && !sp.toString().equals(""))
					return sp.toString();
			}
			cte = cteRestringuida(nodo, exprS);
			if (slVars != null)
				slVars.put(exprS, new StringPointer(cte));
			return cte;
		}
		// si es constante la meto
		if (SetLogUtils.esSLCteSimple(exprS)) {
			return exprS;
		}
		if (ct.equals("\\cross")) {
			// caso [X,Y]
			int i = 0;
			while (expr.hasNext()) {
				salida.append(","+ cte((DefaultMutableTreeNode) nodo.getChildAt(i),	expr.next()));
				i++;
			}
			while (i < nodo.getChildCount()) {
				salida.append(","+ cte((DefaultMutableTreeNode) nodo.getChildAt(i), "X"	+ i));
				i++;
			}

			if (!salida.toString().isEmpty())
				return "(" + salida.substring(1) + ")";
			return "()";
		}
		if (ct.equals("\\power")) {
			// es por que el tipo \\powe(\\num\\pfun\\A) es equivalente a \\seq
			// A
			if (c == '[') {
				DefaultMutableTreeNode naux = new DefaultMutableTreeNode("\\seq");
				// powe->()->x->A (der)
				// ->NUM|NAT (izq)
				DefaultMutableTreeNode nauxHijo = (DefaultMutableTreeNode) ((nodo.getChildAt(0)).getChildAt(0)).getChildAt(1);
				naux.add(nauxHijo);
				return cte(naux, exprS);
			}

			while (expr.hasNext())
				salida.append(","+ cte((DefaultMutableTreeNode) nodo.getChildAt(0),	expr.next()));

			if (!salida.toString().isEmpty())
				return "{" + salida.substring(1) + "}";
			return "{}";

		}
		if (ct.equals("\\seq")) {
			while (expr.hasNext())
				salida.append(","+ cte((DefaultMutableTreeNode) nodo.getChildAt(0),	expr.next()));

			if (!salida.toString().isEmpty())
				return "[" + salida.substring(1) + "]";
			return "[]";
		}
		/* es tipo esquema, porque tiene estructura y no es ningun tipo anterior */
		// pinta [X,X,X]
		ExprIterator tiposDecl = SetLogUtils.schemaToTypeExprIterator(tipos.get(ct));
		ExprIterator varsDecl = SetLogUtils.schemaToVarExprIterator(tipos.get(ct));
		while (expr.hasNext()) {
			varsDecl.next();
			salida.append(","+ cte(SetLogUtils.toTreeNorm(tiposDecl.next()), expr.next()));
		}
		while (tiposDecl.hasNext())
			salida.append(","+ cte(SetLogUtils.toTreeNorm(tiposDecl.next()), varsDecl.next().toUpperCase())); // Se pasa a mayus para que
		// lo tome como variable

		if (!salida.toString().isEmpty())
			return "[" + salida.substring(1) + "]";
		return "[]";

	}

	/*
	 * No resulve el siguiente estilo de casos {a,C} donde el tipo es \power FT.
	 * Es decir no genera CONJUNTOS donde los valores del mismo es solo
	 * construcciones de tipos finitos. Esto no deberia ser necesario.
	 */
	ConstantCreator(HashMap<String, String> tipos,
			HashMap<String, StringPointer> slVars,
			HashMap<String, String> zNames,
			HashMap<String, String> valoresProhibidos) {
		this.tipos = tipos;
		this.slVars = slVars;
		this.valoresProhibidos = valoresProhibidos;
		this.basicTypes = null;
		this.postfijo = 1;
		this.zNames = zNames;
	}

	String getCte(String expr, DefaultMutableTreeNode root) {
		expr = expr.replaceAll("\\s+", ""); // quita los espacios en blanco.
		return cte(root, expr);
	}

}
