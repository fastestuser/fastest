package pruebas.nlg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import nlg.expr.base.ExprDom;
import nlg.expr.base.ExprIn;
import nlg.expr.base.ExprName;
import nlg.expr.base.ExprZ;
import nlg.expr.visitors.Verbalizador;
import client.blogic.management.Controller;
import client.presentation.ClientTextUI;

public class TestVerbalizador {
public static void main(String args[]) throws IOException {
		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter output = new PrintWriter(System.out, true); // with autoflush

		// Cargo la especificacion solo para parsear las designaciones
		ClientTextUI ui = new ClientTextUI(input, output);
		for (String line : getScript()) {
			String parts[] = line.split(" +", 2);
			ui.processCmd(parts[0], parts.length > 1 ? parts[1] : "");
		}
		
		// Intento describir una expresion
		ExprZ edp = new ExprIn(
				new ExprName("p?"), 
				new ExprDom(
						new ExprName("procs")));
		
		System.out.println(edp.accept(new Verbalizador(ui.getMyController().getDesigRepo())));
	}
	
	private static void printDocumentPlan(Controller controller) {
		// NLGen sys = new NLGen(new DocumentPlannerImpl(), new LingRealizerES(), new ASCIIRealizer());
		/*DocumentPlanner dp = new DocumentPlannerImpl();
		DocumentPlan nlgDP = 
				dp.plan(
						Arrays.asList(
								NLGUtils.getTClass("Del_SP_17", controller)), 
						controller);
		
		System.out.println(NLGUtils.nlgDocumentPlanToString(nlgDP));*/
		
	}
	
	private static List<String> getScript() {
		List<String> comandos = new ArrayList();
		comandos.add("loadspec /home/julian/Dropbox/Tesina/tmp/test2.tex");

		return comandos;
	}
}
