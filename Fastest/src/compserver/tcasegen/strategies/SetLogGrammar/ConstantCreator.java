package compserver.tcasegen.strategies.SetLogGrammar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;

import compserver.tcasegen.strategies.SetLogGrammar.StringPointer;


public class ConstantCreator {

	private final int MAXDESIGUALDADES = 10;
	private DefaultMutableTreeNode arbol;
	private HashMap<String,String> tipos;
	private HashMap<String,String> zNames;
	private HashMap<String,String> notEquals;
	private HashMap<String,StringPointer> slVars;
	private List<String> basicTypes;
	
	//static al pedo???
	private int postfijo;
	private String getNumber(){
		return String.valueOf(postfijo++);
	}

	
	private String printTree(DefaultMutableTreeNode tree){
		if (tree.isLeaf()) 
			return (String) tree.toString();
		else if (tree.getChildCount() == 1)
			if ( tree.toString().equals("()")) //REVISAR
				return "(" + printTree((DefaultMutableTreeNode) tree.getChildAt(0)) + ")";
			else
				return tree.toString()+ printTree((DefaultMutableTreeNode) tree.getChildAt(0));
		else //tiene dos hijos
			return printTree((DefaultMutableTreeNode) tree.getChildAt(0)) + tree.toString() + printTree((DefaultMutableTreeNode) tree.getChildAt(1));
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
	
	private boolean soloTipoFinito(DefaultMutableTreeNode nodo){
		String tipo = printTree(nodo);
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
	
	private void refrescarNotEquals(String var, String expr){
		Iterator<String> it = notEquals.keySet().iterator();
		String key,value;
		while (it.hasNext()) {  
			key = it.next().toString();
			value = notEquals.get(key);
			value = value.replace(var, expr);
			notEquals.put(key, value);
		}
	}
	
	private String fullCte(DefaultMutableTreeNode nodo, String var){
		String salida = null;
		
		//si no tiene desigualdades
		if(notEquals == null)
			return  cteCanonica(nodo,var);
		
		if(notEquals.get(var) == null)
			return  cteCanonica(nodo,var);
		
		if(!soloTipoFinito(nodo))
			return cteCanonica(nodo,var);
		
		//si esta solo formado por tipos finitos
		ExprIterator exprs = new ExprIterator("{"+notEquals.get(var)+"}");
		String expresion = null;
		int varNat = 1;
		int nats[] = new int[MAXDESIGUALDADES];
		int i = 0;
		IntExprMap varMap = new IntExprMap(tipos);
		while(exprs.hasNext()){
			expresion = exprs.next();
			//si no es varaible convierto la expresion a nat
			if (!expresion.startsWith("_")){
				nats[i] = varMap.toNum(nodo,expresion);
				i++;
			}
		}
		
		//si no tiene expresiones en desigualdad constantes, solo variables.
		if (i == 0)
			return varMap.toExpr(nodo, varNat);
		
		//m es la cantidad de constantes que fueron mapeadas a nat.
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
		refrescarNotEquals(var,salida);
		
		return salida;
	}
	
	private String cteCanonica(TreeNode nodo,String var) {
		String ct = nodo.toString();
		if (ct.equals("\\num") || ct.equals("\\nat") ) {
			return this.getNumber();
		} else if(ct == "()"){
			return cteCanonica(nodo.getChildAt(0),var);
		} else if (ct.equals("\\pfun") || ct.equals("\\fun") || ct.equals("\\rel")) {
			return "\\{ "+"(" + cteCanonica(nodo.getChildAt(0),var) + " \\mapsto " + cteCanonica(nodo.getChildAt(1),var) + ")" + " \\}";
		} else if(ct.equals("\\cross")){
			return cteCanonica(nodo.getChildAt(0),var) + " \\mapsto " + cteCanonica(nodo.getChildAt(1),var)  ;
		} else if (ct.equals("\\power")) {
			return "\\{ " + cteCanonica(nodo.getChildAt(0),var) + " \\}";
		} else if (ct.equals("\\seq")) {
			return "\\langle " + cteCanonica(nodo.getChildAt(0),var) + " \\rangle";
		}else { 
			String nodoType = tipos.get(ct);
			String cte;
			//si es EnumerationType
			if (nodoType.startsWith("EnumerationType")){
				//si nodoType == EnumerationType:FT:{elem1,elem2}
				// aux = EnumerationType:FT: , elem1 , elem2}
				String[] aux = nodoType.split("[{,]");
				cte =  aux[1];
			}else{
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
				
				
			}
			return cte;
		}
		
	}

	public String cte(DefaultMutableTreeNode nodo, String exprS) {
		
		ExprIterator expr = new ExprIterator(exprS);
		
		char c = exprS.charAt(0);
		String ct = nodo.toString();
		String salida = "error";
		
		// si es variable auxiliar de {log} genero
		if (Character.isUpperCase(c) || c == '_') {
			String cte = null;
			StringPointer sp;
			
			if (slVars!=null){
				sp = slVars.get(exprS);
				//no cambiar el orden de la conjuncion, para que pueda chequear el lado derecho, el izquierdo debe ser falso
				if (sp != null && sp.toString() != null)
					cte = sp.toString();
				else
					cte = fullCte(nodo,exprS);
			}
			else
				cte = fullCte(nodo,exprS);
			
			if (slVars!=null)
				slVars.put(exprS, new StringPointer(cte));
			salida = cte;//la longitud que va es la original, no la inventada
			//porque siempre me muevo en el string expr original
			return salida;
		}
		// si es constante la meto
		else if (Character.isLowerCase(c) || Character.isDigit(c) || c == '-') {
			salida = (c=='-')?("\\neg " + exprS):exprS;
			return salida;
		} 
		else if (ct.equals("()")){
			salida = cte((DefaultMutableTreeNode) nodo.getChildAt(0),exprS);
			return salida;
		}
		else if (ct.equals("\\fun") ||ct.equals("\\pfun")|| ct.equals("\\rel")) {
			//puede venir X ó {X} ó {[X,X]}
			//se hace de esta manera por que add saca el nodo del arbol original
			DefaultMutableTreeNode cross = new DefaultMutableTreeNode("\\cross");
			cross.add((MutableTreeNode) nodo.getChildAt(0));
			cross.add((MutableTreeNode) nodo.getChildAt(0));
			nodo.setUserObject("\\power");
			nodo.add(cross);
			salida = cte(nodo,exprS);
			return salida;
		} 
		else if (ct.equals("\\cross")){
			//caso [X,Y]
			salida = "(" + cte((DefaultMutableTreeNode) nodo.getChildAt(0),expr.next()) + "\\mapsto " + cte((DefaultMutableTreeNode) nodo.getChildAt(1),expr.next()) + ")"; 
			return salida;
		}
		else if (ct.equals("\\power") ) {
			//es por que el tipo \\powe(\\num\\pfun\\A) es equivalente a \\seq A
			if(c == '['){
				DefaultMutableTreeNode naux = new DefaultMutableTreeNode("\\seq");
				// powe->()->x->A        (der)
				//			  ->NUM|NAT  (izq)
				DefaultMutableTreeNode nauxHijo = (DefaultMutableTreeNode) ((nodo.getChildAt(0)).getChildAt(0)).getChildAt(1);
				naux.add(nauxHijo);
				return salida = cte(naux,exprS);
			}
			else{
					//pinta {X,X,X}
					if(	exprS.charAt(1)=='}')
						return "\\{\\}";
					
					String elem;
					salida = "{";
					while(expr.hasNext()){
						elem = expr.next();
						salida = salida + cte((DefaultMutableTreeNode) nodo.getChildAt(0),elem) + ","; 
					}
					//le quito la coma final
					if (salida.charAt(salida.length()-1) == ',')
						salida = salida.substring(0, salida.length()-1);
					return salida + "}";
				}
		}
		else if (ct.equals("\\seq") ) {
					//pinta [X,X,X]
					if(	exprS.charAt(1)==']')
						return "\\langle\\rangle}";
					
					String elem;
					salida = "\\langle,";
					while(expr.hasNext()){
						elem = expr.next();
						salida = salida + cte((DefaultMutableTreeNode) nodo.getChildAt(0),elem) + ","; 
					}
					//le quito la coma final
					if (salida.charAt(salida.length()-1) == ',')
						salida = salida.substring(0, salida.length()-1);
					return salida + "\\rangle";
		}
		
		return salida;
	}

	public ConstantCreator(HashMap<String, String> tipos,HashMap<String, String> znames,HashMap<String,StringPointer> slvars,HashMap<String,String> notEquals) {
		this.tipos = tipos;
		this.zNames = znames;
		this.slVars = slvars;
		this.notEquals = notEquals;
		this.basicTypes = null;
		this.postfijo = 1;
	}

	public String getCte(String expr, DefaultMutableTreeNode root){
		this.arbol = root;
		return cte(arbol, expr);
	}
	
}