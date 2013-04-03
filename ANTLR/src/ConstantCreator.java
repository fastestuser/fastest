import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;

public class ConstantCreator {
	

	/* version iterativa
	static final int ARRIBA = 1;
	static final int ABAJO = 2;
	public class SProc {
		private DefaultMutableTreeNode nodo;
		private String salida;
		private int indice;

		public SProc(DefaultMutableTreeNode n, String s, int i) {
			this.nodo = n;
			this.salida = s;
			this.indice = i;
		}

		public String getValor() {
			return salida;
		}

		public DefaultMutableTreeNode getNodo() {
			return nodo;
		}

		public int getIndice() {
			return indice;
		}
	}

	public class Proc {
		private int dir;
		private String error;

		public Proc(int d) {
			dir = d;
			if (d != ARRIBA && d != ABAJO) {
				error = "Direccion no valida";
			} else
				error = "Ok";
		}

		private String variable(String s, int i, String tipo) {
			Pattern patron = Pattern.compile("(\\w+)");
			Matcher m = patron.matcher(s);
			m.find(i);

			String salida = null;
			if (tipo == "\\num" || tipo == "\\nat") {
				salida = "666";
			} else
				salida = "elchancho";

			return salida;
		}
		public SProc consumir(DefaultMutableTreeNode arbol, String expr,
				int iexpr, char cond, int child) {

			DefaultMutableTreeNode aux = arbol;
			String v = "";
			int indice = iexpr;

			if (arbol.isLeaf()) {
				String tipo = aux.toString();
				v = variable(expr, iexpr, tipo);
				indice = indice + v.length() - 1;
				System.out.println("genera para el tipo: " + tipo);
			}

			if (dir == ARRIBA) {
				aux = (DefaultMutableTreeNode) arbol.getParent();
				System.out.println(arbol.toString() + " ARRIBA "
						+ aux.toString());
			} else if (dir == ABAJO) {
				if (cond == '[')
					aux = (DefaultMutableTreeNode) arbol.getChildAt(child);
				else
					aux = (DefaultMutableTreeNode) arbol.getChildAt(0);
				System.out.println(arbol.toString() + " ABAJO "
						+ aux.toString());
			} else {
				System.out.println(error);
			}

			SProc sp = new SProc(aux, v, indice + 1);
			return sp;
		}

		public String toString() {
			return error;
		}
	}
*/
	//private HashMap<String, Proc> tabla; ver iterativa
	private DefaultMutableTreeNode arbol;
	private String expr;
	
	//estructura de datos para la recursion
	private class scte{
		String s;
		int i;
		public scte(String s, int i){
			this.s = s; this.i = i;
		}
	}
	public String fullCte(TreeNode nodo) {
		String ct = nodo.toString();
		if (ct == "\\num" || ct == "\\nat" ) {
			return "666";
		} else if (ct == "\\cross" || ct == "\\cpfun" || ct == "\\fun" || ct == "\\rel") {
			return "[" + fullCte(nodo.getChildAt(0)) + "," + fullCte(nodo.getChildAt(1)) + "]";
		} else if (ct == "\\power") {
			return "{" + fullCte(nodo.getChildAt(0)) + "}";
		} else if (ct == "\\seq") {
			return "[" + fullCte(nodo.getChildAt(0)) + "]";
		}
		return "error";
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
			String  s = fullCte(nodo);
			salida = new scte(s,iexpr + aux.length());
			return salida;
		}
		// si es constante la meto
		else if (Character.isLowerCase(c) || Character.isDigit(c)) {
			String  s = aux;
			System.out.println("aux: " + aux);
			salida = new scte(aux,iexpr + aux.length());
			return salida;
		} 
		
		else if (ct == "\\cross" || ct == "\\cpfun" || ct == "\\fun" || ct == "\\rel") {
			scte s1 = cte(nodo.getChildAt(0), iexpr + 1);
			System.out.println();
			scte s2 = cte(nodo.getChildAt(1), s1.i + 2);
			salida = new scte("[" + s1.s + "," + s2.s + "]",s2.i);
			return salida;
		} 
		
		else if (ct == "\\power") {
			scte s1 = cte(nodo.getChildAt(0), iexpr+1);
			salida = new scte("{" + s1.s ,s1.i);
			
			iexpr = s1.i;
			c = expr.charAt(iexpr);
			while (c == ','){
				s1 = cte(nodo.getChildAt(0), iexpr+1);
				salida.s = salida.s + "," + s1.s;
				iexpr = s1.i;
				c = expr.charAt(iexpr);
			}
			salida.s = salida.s + "}";
			salida.i = iexpr;
			return salida;
		}
		
		else if (ct == "\\seq") {
			scte s1 = cte(nodo.getChildAt(0), iexpr+1);
			salida = new scte("[" + s1.s ,s1.i);
			
			iexpr = s1.i;
			c = expr.charAt(iexpr);
			while (c == ','){
				s1 = cte(nodo.getChildAt(0), iexpr+1);
				salida.s = salida.s + "," + s1.s;
				iexpr = s1.i;
				c = expr.charAt(iexpr);
			}
			salida.s = salida.s + "]";
			salida.i = iexpr;
			return salida;
		}
		
		return new scte("errpr",0);
	}

	public ConstantCreator(String s, DefaultMutableTreeNode root) {
		arbol = root;
		expr = s;
		

		/*version iterativa
		 * tabla = new HashMap<String, Proc>();
		 * Proc p = new Proc(ABAJO); tabla.put(",{", p); tabla.put(",[", p);
		 * tabla.put(",c", p); tabla.put("{{", p); tabla.put("{[", p);
		 * tabla.put("{c", p); tabla.put("[{", p); tabla.put("[[", p);
		 * tabla.put("[c", p);
		 * 
		 * p = new Proc(ARRIBA); tabla.put("],", p); tabla.put("},", p);
		 * tabla.put("c,", p); tabla.put("]]", p); tabla.put("]}", p);
		 * tabla.put("}]", p); tabla.put("}}", p); tabla.put("c]", p);
		 * tabla.put("c}", p);
		 */
	}

	public String getSalida() {
		return cte(arbol, 0).s;
		/* version iterativa
		 * char pilac[] = new char[100]; int pilai[] = new int[100]; int ppila =
		 * 0;
		 * 
		 * int iexprF,iexpr; iexpr = iexprF = 0; String exprF =
		 * expr.replaceAll("(\\w+)", "c"); int m = exprF.length(); String key;
		 * Proc p; SProc sp; String salida = new String(); while(iexprF+1<m){
		 * char c = exprF.charAt(iexprF); if (c == '{' | c == '['){ ppila++;
		 * pilac[ppila] = c; pilai[ppila] = 0; } else if (c == '}' | c == ']')
		 * ppila--;
		 * 
		 * if (c == ',') pilai[ppila]++;
		 * 
		 * key = exprF.substring(iexprF,iexprF+2); p = (Proc) tabla.get(key);
		 * 
		 * sp = p.consumir(arbol,expr,iexpr,pilac[ppila],pilai[ppila]);
		 * 
		 * salida = salida + ((c=='c')?"":c) + sp.getValor(); arbol =
		 * sp.getNodo();
		 * 
		 * iexprF++; iexpr = sp.getIndice(); } return salida; }
		 */

	}
}
