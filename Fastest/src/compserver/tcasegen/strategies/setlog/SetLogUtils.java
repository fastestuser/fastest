package compserver.tcasegen.strategies.setlog;

import java.util.HashMap;
import java.util.Iterator;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import compserver.tcasegen.strategies.setlog.setlogtoz.ExprIterator;

public final class SetLogUtils {
	
	
	
	//por que se hace varias veces
	public static DefaultMutableTreeNode toTree(String tipo){
		ANTLRInputStream input = new ANTLRInputStream(tipo);
		TypeManagerLexer lexer = new TypeManagerLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		TypeManagerParser TMP = new TypeManagerParser(tokens);
		TMP.typeManage();
		return TMP.getRoot();
	}
	
	public static DefaultMutableTreeNode toTreeNorm(String tipo){
		ANTLRInputStream input = new ANTLRInputStream(tipo);
		TypeManagerLexer lexer = new TypeManagerLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		TypeManagerParser TMP = new TypeManagerParser(tokens);
		TMP.typeManageNorm();
		return TMP.getRoot();
	}
	
	public static DefaultMutableTreeNode toTreeNCross(String tipo){
		ANTLRInputStream input = new ANTLRInputStream(tipo);
		TypeManagerLexer lexer = new TypeManagerLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		TypeManagerParser TMP = new TypeManagerParser(tokens);
		TMP.typeManageNCross();
		return TMP.getRoot();
	}
	
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
	
	//devuelve el tipo del proximo hijo que no es "()", es frecuente hacer esto
	public static String tipoNoParentesis(TreeNode nodo){
		while(nodo.toString().equals("()"))
			nodo = nodo.getChildAt(0);
		return nodo.toString();
	}
	
	public static void printHashMap(HashMap<String, String> map){
		Iterator<String> iterator = map.keySet().iterator();
		
		String key,value;
		while (iterator.hasNext()) {  
			key = iterator.next().toString();
			if (map.get(key) == null)
				value = "nullc";
			else 
				value = map.get(key).toString();
			System.out.println(key + " = " + value);  
		} 
	}
	
	public static boolean esSLVariableSimple(String expr){
		char c = expr.charAt(0);
		return (expr.startsWith("_")|| Character.isUpperCase(c));
	}

	public static boolean esSLCteSimple(String expr){
		char c = expr.charAt(0);
		return (Character.isLowerCase(c) || Character.isDigit(c) || c == '-');
	}
	
	public static ExprIterator schemaToVarExprIterator(String nomTipo,String tipoCompleto){
		// ej SchemaType:Estado:[var1:\num,var2:E] -> {var1,var2}
		// "SchemaType:".length() = 11 + :.lingth()
		tipoCompleto = tipoCompleto.substring(12+nomTipo.length());
		ExprIterator expr = new ExprIterator(tipoCompleto);
		String elem,aux[],salida="";
		while(expr.hasNext()){
			elem = expr.next();
			aux = elem.split(":");
			salida += "," + aux[0];
			System.out.println(elem);
		}
		salida = "{" + salida.substring(1) + "}";
		return new ExprIterator(salida);
	}
	
	public static ExprIterator schemaToTypeExprIterator(String nomTipo,String tipoCompleto){
		// ej SchemaType:Estado:[var1:\num,var2:E]-> {\num,E}
		// "SchemaType:".length() = 11 + :.lingth()
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
}
