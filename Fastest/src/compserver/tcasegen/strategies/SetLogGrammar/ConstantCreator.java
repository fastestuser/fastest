package compserver.tcasegen.strategies.SetLogGrammar;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;

public class ConstantCreator {
	
	private DefaultMutableTreeNode arbol;
	private String expr;
	private HashMap<String,String> tipos;
	private HashMap<String,String> zName;
	//estructura de datos para la recursion
	private class scte{
		String s;
		int i;
		public scte(String s, int i){
			this.s = s; this.i = i;
		}
	}
	public String fullCte(TreeNode nodo,String var) {
		String ct = nodo.toString();
		if (ct.equals("\\num") || ct.equals("\\nat") ) {
			return "666";
		} else if(ct == "()"){
			return fullCte(nodo.getChildAt(0),var);
		} else if (ct.equals("\\cross") || ct.equals("\\pfun") || ct.equals("\\fun") || ct.equals("\\rel")) {
			return "\\{ "+"(" + fullCte(nodo.getChildAt(0),var) + " \\mapsto " + fullCte(nodo.getChildAt(1),var) + ")" + " \\}";
		} else if (ct.equals("\\power")) {
			return "\\{ " + fullCte(nodo.getChildAt(0),var) + " \\}";
		} else if (ct.equals("\\seq")) {
			return "\\langle " + fullCte(nodo.getChildAt(0),var) + " \\rangle";
		}else { 
			String nodoType = tipos.get(ct);
			//si es EnumerationType
			if (nodoType.startsWith("EnumerationType")){
				//si nodoType == EnumerationType:FT:{elem1,elem2}
				// aux = EnumerationType:FT: , elem1 , elem2}
				String[] aux = nodoType.split("[{,]");
				return aux[1];
			}
			//si es basicType
			return ct.toLowerCase()+var;
		}
	}

	public scte cte(TreeNode nodo, int iexpr) {
		//obtengo la proxima variable o constante en aux
		Pattern patron = Pattern.compile("(\\w+)");
		Matcher m = patron.matcher(expr);
		m.find(iexpr);
		//aux va a ir tomando nombre de variables o ctes del estilo:
		//_G333 variables auxiliares de setlog
		//444    cte
		//XX    variables, ??que pueden ser auxiliares o no??
		//sensor1  conte de un freeType o basicType
		String aux = m.group();
		
		char c = expr.charAt(iexpr);
		String ct = nodo.toString();
		scte salida;
		
		
		
		
		// si es variable auxiliar de {log} genero
		if (Character.isUpperCase(c) || c == '_') {
			String  s = fullCte(nodo,aux);
			salida = new scte(s,iexpr + aux.length());//la longitud que va es la original, no la inventada
													  //porque siempre me muevo en el string expr original
			return salida;
		}
		// si es constante la meto
		else if (Character.isLowerCase(c) || Character.isDigit(c) || c == '-') {
			if (c == '-') aux = "-" + aux;
			salida = new scte(aux,iexpr + aux.length());
			return salida;
		} 
		else if (ct.equals("()")){
			salida = cte(nodo.getChildAt(0),iexpr);
			return salida;
		}
		/*no se traducen los los tipos en si
		 * else if (ct.equals("BasicType")){
			String zname = zName.get(aux);
			String tipo = tipos.get(zname);
			salida = new scte("{"+ tipo.toLowerCase() + aux + "}",("{"+ tipo + aux + "}").length());
			return salida;
		}*/
		else if (ct.equals("\\cross")  || ct.equals("\\fun") ||ct.equals("\\pfun")|| ct.equals("\\rel")) {
			//caso {?} donde ?=[X,X] ó ?=X
			if (c == '{'){
				salida = cte(nodo,iexpr+1);
			}
			//caso [X,Y]
			else {
				scte si1 = cte(nodo.getChildAt(0), iexpr + 1);
				scte si2 = cte(nodo.getChildAt(1), si1.i + 1); 
				// 	s2.i+1 va a ser igual a length("[" + s1.s + "," + s2.s + "]")
				salida = new scte("\\{ " + "(" + si1.s + " \\mapsto " + si2.s + ")"+ "}",si2.i+1);
			}
			//si tiene mas de un elemento
			iexpr = salida.i;
			c = expr.charAt(iexpr);
			if (c==','){
				scte si2 = cte(nodo, iexpr+1);
				salida.s = salida.s.replace('}',',') + si2.s.substring(1);
				iexpr = si2.i;
				c = expr.charAt(iexpr);
			}
			salida.s.replace("}"," \\}");
			salida.i = iexpr;
			return salida;
		} 
		
		else if (ct.equals("\\power") ) {
			scte s1 = cte(nodo.getChildAt(0), iexpr+1);
			salida = new scte("\\{ " + s1.s ,s1.i);
			
			iexpr = s1.i;
			c = expr.charAt(iexpr);
			while (c == ','){
				s1 = cte(nodo.getChildAt(0), iexpr+1);
				salida.s = salida.s + "," + s1.s;
				iexpr = s1.i;
				c = expr.charAt(iexpr);
			}
			salida.s = salida.s + " \\}";
			salida.i = iexpr;
			return salida;
		}
		
		else if (ct.equals("\\seq")) {
			scte s1 = cte(nodo.getChildAt(0), iexpr+1);
			salida = new scte("\\langle " + s1.s ,s1.i);
			
			iexpr = s1.i;
			c = expr.charAt(iexpr);
			while (c == ','){
				s1 = cte(nodo.getChildAt(0), iexpr+1);
				salida.s = salida.s + "," + s1.s;
				iexpr = s1.i;
				c = expr.charAt(iexpr);
			}
			salida.s = salida.s + " \\rangle";
			salida.i = iexpr;
			return salida;
		}
		
		
		return new scte("errpr",0);
	}

	public ConstantCreator(String s, DefaultMutableTreeNode root,HashMap t,HashMap zn) {
		arbol = root;
		expr = s;
		tipos = t;
		zName = zn;
	}

	public String getCte() {
		return cte(arbol, 0).s;
	}
}
