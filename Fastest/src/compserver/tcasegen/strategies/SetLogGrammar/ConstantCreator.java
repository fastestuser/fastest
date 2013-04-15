package compserver.tcasegen.strategies.SetLogGrammar;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;
import compserver.tcasegen.strategies.SetLogGrammar.StringPointer;


public class ConstantCreator {
	
	private DefaultMutableTreeNode arbol;
	private String expr;
	private HashMap<String,String> tipos;
	private HashMap<String,String> zName;
	private HashMap<String,StringPointer> valores;
	
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
		} else if (ct.equals("\\pfun") || ct.equals("\\fun") || ct.equals("\\rel")) {
			return "\\{ "+"(" + fullCte(nodo.getChildAt(0),var) + " \\mapsto " + fullCte(nodo.getChildAt(1),var) + ")" + " \\}";
		} else if(ct.equals("\\cross")){
			return fullCte(nodo.getChildAt(0),var) + " \\mapsto " + fullCte(nodo.getChildAt(1),var)  ;
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
			return ct.toLowerCase()+zName.get(var);
		}
	}

	public scte cte(TreeNode nodo, int iexpr) {
		//obtengo la proxima variable o constante en aux
		Pattern patron = Pattern.compile("(\\w+)");
		Matcher m = patron.matcher(expr);
		m.find(iexpr);
		String aux = m.group();
		
		char c = expr.charAt(iexpr);
		String ct = nodo.toString();
		scte salida;
		// si es variable auxiliar de {log} genero
		if (Character.isUpperCase(c) || c == '_') {
			String s;
			if (valores.get(aux).toString() != null)
				s = valores.get(aux).toString();
			else
				s = fullCte(nodo,aux);
			salida = new scte(s,iexpr + aux.length());//la longitud que va es la original, no la inventada
													  //porque siempre me muevo en el string expr original
			return salida;
		}
		// si es constante la meto
		else if (Character.isLowerCase(c) || Character.isDigit(c) || c == '-') {
			String s;
			if (c == '-') 
				s = "\\neg " + aux;
			else 
				s = aux;
			salida = new scte(s,iexpr + aux.length());
			return salida;
		} 
		else if (ct.equals("()")){
			salida = cte(nodo.getChildAt(0),iexpr);
			return salida;
		}
		else if (ct.equals("\\fun") ||ct.equals("\\pfun")|| ct.equals("\\rel")) {
			//puede venir X ó {X} ó {[X,X]}
			//pir que c esta en "{"
			iexpr++; 
			c = expr.charAt(iexpr);
			scte si1,si2;
			if (c=='[')	{
				si1 = cte(nodo.getChildAt(0), iexpr + 1);
				si2 = cte(nodo.getChildAt(1), si1.i + 1); 
				si2.i ++;
			}
			else{
				si1 = cte(nodo.getChildAt(0), iexpr );
				si2 = cte(nodo.getChildAt(1), iexpr );
			}
			salida = new scte("\\{ " + "(" + si1.s + " \\mapsto " + si2.s + ")",si2.i);
			//aca abajo, va un while y algo parecido a lo de arriba
			//si tiene mas de un elemento
			iexpr = salida.i;
			c = expr.charAt(iexpr);
			while (c==','){
				iexpr++;c = expr.charAt(iexpr);
				if (c=='[')	{
					si1 = cte(nodo.getChildAt(0), iexpr + 1);
					si2 = cte(nodo.getChildAt(1), si1.i + 1);
					si2.i++;
				}
				else{
					si1 = cte(nodo.getChildAt(0), iexpr );
					si2 = cte(nodo.getChildAt(1), iexpr );
				}
				salida.s = salida.s+ "," +  " ("+ si1.s + " \\mapsto " + si2.s + ")";
				iexpr = si2.i;
				c = expr.charAt(iexpr);
			}
			salida.s = salida.s + " \\}";
			salida.i = iexpr+1;
			return salida;
			
		} 
		else if (ct.equals("\\cross")){
			//caso [X,Y]
			scte s1 = cte(nodo.getChildAt(0), iexpr + 1);
			scte s2 = cte(nodo.getChildAt(1), s1.i + 1); 
			salida = new scte( s1.s + " \\mapsto " + s2.s ,s2.i+1);
			return salida;
		}
		else if (ct.equals("\\power") ) {
			//pinta {X,X,X}
			scte s1 = cte(nodo.getChildAt(0), iexpr+1);
			salida = new scte("\\{ " + s1.s ,s1.i);
			
			iexpr = salida.i;
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
			//pinta [X,X,X]
			scte s1 = cte(nodo.getChildAt(0), iexpr+1);
			salida = new scte("\\langle " + s1.s ,s1.i);
			
			iexpr = salida.i;
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

	public ConstantCreator(String s, DefaultMutableTreeNode root,HashMap<String, String> t,HashMap<String, String> zn,HashMap<String,StringPointer> vars) {
		arbol = root;
		expr = s;
		tipos = t;
		zName = zn;
		valores = vars;
	}

	public String getCte() {
		return cte(arbol, 0).s;
	}
}