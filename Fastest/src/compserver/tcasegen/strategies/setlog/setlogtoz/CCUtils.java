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
	
}
