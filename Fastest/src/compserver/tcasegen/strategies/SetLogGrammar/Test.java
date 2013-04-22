package compserver.tcasegen.strategies.SetLogGrammar;


import javax.swing.tree.DefaultMutableTreeNode;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

public class Test {

	
	
	public static void main(String[] args) {
		
		ANTLRInputStream input = new ANTLRInputStream("\\seq \\num");
        TypeManagerLexer lexer = new TypeManagerLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        TypeManagerParser parser = new TypeManagerParser(tokens);
        parser.typeManage();
        DefaultMutableTreeNode root =  parser.getRoot();
        
        
		String s = "[1,2,3]";
		
        ConstantCreator cc = new ConstantCreator(s,root, null, null, null);
		String salida = cc.getCte();
		
		System.out.println("ENTRADA\n" + s);
		System.out.println("SALIDA\n" + salida);
		System.out.println("\nasdssssssss\n" + getNotEqType("aaa,bbb,ccc,ddd","bbb,aaa,ddd"));
	}

}
