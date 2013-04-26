package compserver.tcasegen.strategies.SetLogGrammar;


import java.util.HashMap;

import javax.swing.tree.DefaultMutableTreeNode;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import compserver.tcasegen.strategies.SetLogGrammar.Temp;

public class Test {
	
		
	
	public static void main(String[] args) {
		
		ANTLRInputStream input = new ANTLRInputStream("\\power FT");
        TypeManagerLexer lexer = new TypeManagerLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        TypeManagerParser parser = new TypeManagerParser(tokens);
        parser.typeManage();
        DefaultMutableTreeNode root =  parser.getRoot();
//        
//        
//		String s = "[{X}]";
//		
//        ConstantCreator cc = new ConstantCreator(null, null, null, null);
//		String salida = cc.getCte(s,root);
//		
//		System.out.println("ENTRADA\n" + s);
//		System.out.println("SALIDA\n" + salida);
		
		HashMap<String,String> tipos = new HashMap<String, String>();
		tipos.put("FT", "EnumerationType:FT:{a,b,c}");
		System.out.println("\naaaaaaaaaa " + Temp.f(root,1,tipos));
		//System.out.println("\nasdssssssss\n" + getNotEqType("aaa,bbb,ccc,ddd","bbb,aaa,ddd"));
	}

}
