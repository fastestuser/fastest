package compserver.tcasegen.strategies.setlog.setlogtoz;

import java.util.HashMap;
import java.util.Iterator;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import compserver.tcasegen.strategies.setlog.SetLogUtils;
import compserver.tcasegen.strategies.setlog.TypeManagerLexer;
import compserver.tcasegen.strategies.setlog.TypeManagerParser;

public final class CCUtils {
	
	public static HashMap<String,String> invertHashMap(HashMap<String,String> m){
		Iterator<String> iterator = m.keySet().iterator();  
		HashMap<String,String> s = new HashMap<String,String>();

		while (iterator.hasNext()) {  
			String key = iterator.next().toString();  
			String value = m.get(key).toString();  
			s.put(value,key);
		} 	
		return s;
	} 
	
	protected static boolean esVariable(String expr){
		char c = expr.charAt(0);
		return (expr.startsWith("_")|| Character.isUpperCase(c));
	}
	
	protected static boolean esCteSimple(String expr){
		char c = expr.charAt(0);
		return (Character.isLowerCase(c) || Character.isDigit(c) || c == '-');
	}
	
	protected static void refrescarValoresProhibidos(String var, String expr,HashMap<String,String> vp){
		Iterator<String> it = vp.keySet().iterator();
		String key,value;
		while (it.hasNext()) {  
			key = it.next().toString();
			value = vp.get(key);
			value = value.replace(var, expr);
			vp.put(key, value);
		}
	}
	
	//devuelve una cte distinta a todos 
	protected static String getCteDesigual(DefaultMutableTreeNode nodo,String var,HashMap<String,String> vp,HashMap<String,StringPointer> vars,HashMap<String,String> tipos){
		String salida = null;
		ExprIterator exprs = new ExprIterator("{"+vp.get(var)+"}");
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
		String tipo = SetLogUtils.tipoNoParentesis(nodo);
		
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
		refrescarValoresProhibidos(var,salida,vp);
		
		return salida;
	}
	
	//cardinalidad del tipo libre
		private static int cardOfFreeType(String tipo){
			String aux[] = tipo.split(":");
			aux = aux[2].split(",");
			return aux.length;
		}

		// devuelve la cardinalidad del tipo finito, por ahora solo formado por tipos libres.
		// si el numero es mayor al maximo del int devuelve 0.
		public static int cardinalidadTipoFinito(HashMap<String, String> tipos, DefaultMutableTreeNode nodo){
			String ct = nodo.toString();
			int c=0;
			
			if (ct.equals("\\power")){
				c = cardinalidadTipoFinito(tipos,(DefaultMutableTreeNode) nodo.getChildAt(0));
				c = (2<<(c-1));
			}
			else if (ct.equals("()")){
				c = cardinalidadTipoFinito(tipos,(DefaultMutableTreeNode) nodo.getChildAt(0));
			}
			else if(ct.equals("\\cross")){
				c = cardinalidadTipoFinito(tipos,(DefaultMutableTreeNode) nodo.getChildAt(0));
				c = c * cardinalidadTipoFinito(tipos,(DefaultMutableTreeNode) nodo.getChildAt(1));
			}
			else
				c = cardOfFreeType(tipos.get(ct));
			return c;
		}
		//devuelve el numero que corresponde a la posicion, ej bitFromFreeType(FT::=a|b|c , a)
		// 4 en decimal
		public static  int numFromFreeType(String tipo,String elem){
			String s;
			String aux[] = tipo.split(":");
			s = aux[2].substring(1, aux[2].length()-1);
			aux = s.split(",");
			for(int i=0;i<aux.length;i++){
				if (aux[i].equals(elem))
					return i+1;
			}
			return 0;
		}
	
}
