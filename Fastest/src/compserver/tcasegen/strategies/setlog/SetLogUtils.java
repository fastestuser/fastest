package compserver.tcasegen.strategies.setlog;

import java.util.HashMap;
import java.util.Iterator;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import compserver.tcasegen.strategies.setlog.setlogtoz.ExprIterator;
import compserver.tcasegen.strategies.setlog.setlogtoz.StringPointer;

public final class SetLogUtils {

	private static HashMap<String,String> tipos;
	private static HashMap<String, String> zNames;
	private static HashMap<String, StringPointer> slvars;
	
	public static void setLogToLatexCharsReplacerInit(HashMap<String,String> t,HashMap<String, StringPointer> slv,HashMap<String, String> zN){
		tipos = t;
		slvars = slv;
		zNames = zN;
	}
	//cambia los caracteres de setlog [] por langlerangle, etc...
	public static String setLogToLatexCharsReplacer(DefaultMutableTreeNode nodo,String exprS) throws Exception{
		if (exprS.equals("ValueNotAssigned") ){
			return exprS;
		}

		if (tipos.containsKey(exprS) && tipos.get(exprS).startsWith("BasicConstant"))
			return exprS;

		if(SetLogUtils.esSLVariableSimple(exprS) && slvars.get(exprS) != null && slvars.get(exprS).toString().equals("ValueNotAssigned")){
			return zNames.get(exprS)!=null?zNames.get(exprS):exprS;
		}

		ExprIterator expr = new ExprIterator(exprS);

		String ct = nodo.toString();

		if(exprS.startsWith("int(")){
			String aux[] = exprS.substring(4,exprS.length()-1).split(",");
			return aux[0] + " \\upto " + aux[1];
		}

		if (ct.equals("()")) 
			return "(" + setLogToLatexCharsReplacer((DefaultMutableTreeNode) nodo.getChildAt(0),exprS) + ")";

		if (ct.equals("\\pfun")||ct.equals("\\fun")||ct.equals("\\ffun")||ct.equals("\\rel")){
			String salida = "";
			String coma = ct.equals("\\rel")?",":"\\mapsto ";
			ExprIterator exprAux;
			while(expr.hasNext()){
				exprAux = new ExprIterator(expr.next());
				salida += "," + "(" + setLogToLatexCharsReplacer((DefaultMutableTreeNode) nodo.getChildAt(0),exprAux.next()) + coma + setLogToLatexCharsReplacer((DefaultMutableTreeNode) nodo.getChildAt(1),exprAux.next()) + ")";
			}
			if (!salida.isEmpty())
				return "\\{" + salida.substring(1) + "\\}";
			return "\\emptyset";
		}

		if (ct.equals("\\cross")){
			String salida = "";
			String coma = nodo.getChildCount()>2?",":" \\mapsto ";
			int i = 0;
			while(expr.hasNext()){
				salida += coma + setLogToLatexCharsReplacer((DefaultMutableTreeNode) nodo.getChildAt(i),expr.next());
				i++;
			}
			return "(" + salida.substring(coma.length()) + ")";
		}

		if (ct.equals("\\power")){
			String salida = "";
			while(expr.hasNext()){
				salida += "," + setLogToLatexCharsReplacer((DefaultMutableTreeNode) nodo.getChildAt(0),expr.next());
			}
			if (!salida.isEmpty())
				return "\\{" + salida.substring(1) + "\\}";
			return "\\emptyset";
		}

		if (ct.equals("\\seq")){
			String salida = "";
			while(expr.hasNext())
				salida += "," + setLogToLatexCharsReplacer((DefaultMutableTreeNode) nodo.getChildAt(0),expr.next());

			if (!salida.isEmpty())
				return "\\langle " + salida.substring(1) + "\\rangle";
			return "\\langle\\rangle";
		}


		String tipocompleto = tipos.get(ct);

		if (tipocompleto !=null){

			if (tipocompleto.startsWith("SchemaType")){
				ExprIterator tiposDecl = SetLogUtils.schemaToTypeExprIterator(ct, tipocompleto);
				ExprIterator varsDecl = SetLogUtils.schemaToVarExprIterator(ct, tipocompleto);
				String c,v,salida="";
				while(tiposDecl.hasNext()){
					c = tiposDecl.next();
					v = varsDecl.next();
					salida += "," + v + "==" + setLogToLatexCharsReplacer(SetLogUtils.toTreeNorm(c),v); 
				}
				if (!salida.isEmpty())
					return "\\lblot " + salida.substring(1) + " \\rblot";
				return "\\lblot\\rblot";
			}


			if (tipocompleto.startsWith("EnumerationType"))
				return exprS;


			if (tipocompleto.startsWith("BasicType")){
				//String salida = zNames.get(exprS);
				//salida = ct.toLowerCase() + (salida!=null?salida:getNumber());
				//String salida = ct.toLowerCase() + getNumber();
				//salida = salida.replace("?","");
				return exprS;
			}
		}

		return exprS;
	}

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

	public static void printHashMap(HashMap map){
		Iterator iterator = map.keySet().iterator();

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
		if (expr.startsWith("int(")) return false;
		return (Character.isLowerCase(c) || Character.isDigit(c) || c == '-');
	}

	public static boolean esSLNum(String expr){
		char c = expr.charAt(0);
		return (Character.isDigit(c) || c == '-');
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
			//System.out.println(elem);
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
			//System.out.println(elem);
		}
		salida = "{" + salida.substring(1) + "}";
		return new ExprIterator(salida);
	}
}
