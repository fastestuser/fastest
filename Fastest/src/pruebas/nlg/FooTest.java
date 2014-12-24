package pruebas.nlg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import nlg.base.designation.DesignationRepo;
import nlg.base.expr.ExprZ;
import nlg.util.ExprZToString;
import nlg.util.ExprZUtils;
import client.blogic.management.Controller;
import client.blogic.testing.ttree.TClassNode;
import client.blogic.testing.ttree.visitors.SchemeTTreeFinder;
import client.presentation.ClientTextUI;
import common.z.TClass;

public class FooTest {
	public static void main(String args[])throws IOException {
		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter output = new PrintWriter(System.out, true); // with autoflush

		ClientTextUI ui = new ClientTextUI(input, output);
		for (String line : getScript()) {
			String parts[] = line.split(" +", 2);
			ui.processCmd(parts[0], parts.length > 1 ? parts[1] : "");
		}
		
		//printExprZSchema(ui, "LookUp_SP_1");
		//printExprZSchema(ui, "Update_SP_6");
		//DesignationRepo repo = ui.getMyController().getDesigRepo();
		//System.out.println("debug");
		
		/*
		Controller controller = ui.getMyController();
		StringSource sc = new StringSource("s \\in SYM");
		try {
			Pred asd = ParseUtils.parsePred(sc, null, controller.getTypeCheckerManager());
			ExprZ asd2 = asd.accept(new ASTToExprZVisitor());
			System.out.println("debug");
		} catch (CommandException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
	
	private static void printExprZSchema(ClientTextUI clientTextUI, String schName) throws Exception {
		TClass tClass;
		ExprZToString visitor = new ExprZToString();
		
		// Recupero map operation names -> associated test trees
        Controller controller = clientTextUI.getMyController();
        Map<String, TClassNode> opTTreeMap = controller.getOpTTreeMap();
        
		// Busco la operacion recursivamente en el arbol de prueba
        for (String key : opTTreeMap.keySet()) {
            TClassNode opTTreeRoot = opTTreeMap.get(key);
            
            tClass = (TClass) opTTreeRoot.acceptVisitor(new SchemeTTreeFinder(schName, -1));
            
            if (null != tClass) {
            	List<ExprZ> asd = ExprZUtils.extractSchemaExpr(tClass);
            	
            	for (ExprZ exp : asd) {
            		System.out.println(exp.accept(visitor));
            		System.out.println("\n");
            	}
            	
            }
        }
	}
	
	private static List<String> getScript() {
		List<String> comandos = new ArrayList();
		//comandos.add("loadspec /home/julian/Dropbox/tesina/z_latex/scheduler.tex");
		comandos.add("loadspec /home/julian/Dropbox/Tesina/tmp/test.tex");
		
		/*
		comandos.add("selop LookUp");
		comandos.add("addtactic LookUp SP \\in s? \\in \\dom st");
		comandos.add("genalltt");
		comandos.add("prunebelow LookUp_DNF_2");
		comandos.add("genalltca");
		comandos.add("showsch LookUp_SP_1 -u -1");
		*/
		
		comandos.add("selop Update");
		comandos.add("addtactic Update SP \\oplus st \\oplus \\{s? \\mapsto v?\\}");
		comandos.add("genalltt");
		comandos.add("genalltca");
		comandos.add("showsch Update_SP_6 -u -1");
		
		/*
		comandos.add("selop Update");
		comandos.add("addtactic Update SP \\oplus st \\oplus \\{s? \\mapsto v?\\}");
		
		comandos.add("selop Delete");
		comandos.add("addtactic Delete SP \\ndres \\{s?\\} \\ndres st");
		comandos.add("genalltt");
		
		//
		//comandos.add("prunebelow Delete_DNF_1");
		//comandos.add("unprune Delete_SP_2");
		//comandos.add("unprune Delete_SP_3");
		//comandos.add("prunebelow Delete_DNF_2");
		
		//comandos.add("selopall");
		comandos.add("genalltca");
		//comandos.add("showsch -tcl -u -1");
		
		comandos.add("showsch LookUp_SP_1 -u -1");
		comandos.add("showdesc LookUp_SP_1");
		
		comandos.add("showsch LookUp_SP_4 -u -1");
		comandos.add("showdesc LookUp_SP_4");
		
		comandos.add("showsch Update_SP_2 -u -1");
		comandos.add("showdesc Update_SP_2");
		
		comandos.add("showsch Update_SP_3 -u -1");
		comandos.add("showdesc Update_SP_3");
		
		comandos.add("showsch Update_SP_4 -u -1");
		comandos.add("showdesc Update_SP_4");
		*/
		//comandos.add("quit");
		
		return comandos;
	}
	
}