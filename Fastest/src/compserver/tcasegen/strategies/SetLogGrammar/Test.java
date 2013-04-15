package compserver.tcasegen.strategies.SetLogGrammar;


import javax.swing.tree.DefaultMutableTreeNode;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

public class Test {

	
	
	public static void main(String[] args) {
		
		ANTLRInputStream input = new ANTLRInputStream("SENSORS \\pfun \\num");
        TypeManagerLexer lexer = new TypeManagerLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        TypeManagerParser parser = new TypeManagerParser(tokens);
        parser.typeManage();
        DefaultMutableTreeNode root =  parser.getRoot();
        
        
		String s = "UID = {U\\_G1152},\nACCNUM = {N\\_G1165},\nNAT = int(0, 10000000000),\nNUM = int(-10000000000, 10000000000),\nX = -10000000000,\nM = 0,\nBalances = {[N, 0]},\nVAR0 = 0,\nClients = Owners, Owners = {},";
		
        ConstantCreator cc = new ConstantCreator(s,root, null, null, null);
		String salida = cc.getCte();
		
		System.out.println("ENTRADA\n" + s);
		System.out.println("SALIDA\n" + salida);
	}

}
