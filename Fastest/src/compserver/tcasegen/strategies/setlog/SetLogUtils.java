package compserver.tcasegen.strategies.setlog;

import java.util.HashMap;
import java.util.Iterator;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

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
}
