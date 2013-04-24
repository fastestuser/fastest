package compserver.tcasegen.strategies.SetLogGrammar;


import javax.swing.tree.DefaultMutableTreeNode;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

public class Test {

	
	
	public static void main(String[] args) {
		
		ANTLRInputStream input = new ANTLRInputStream("\\power (\\num \\cross (\\power A))");
        TypeManagerLexer lexer = new TypeManagerLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        TypeManagerParser parser = new TypeManagerParser(tokens);
        parser.typeManage();
        DefaultMutableTreeNode root =  parser.getRoot();
        
        
		String s = "[{X}]";
		
        ConstantCreator cc = new ConstantCreator(null, null, null, null);
		String salida = cc.getCte(s,root);
		
		System.out.println("ENTRADA\n" + s);
		System.out.println("SALIDA\n" + salida);
		//System.out.println("\nasdssssssss\n" + getNotEqType("aaa,bbb,ccc,ddd","bbb,aaa,ddd"));
	}

}
