package pruebas.nlg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import client.blogic.management.Controller;
import client.presentation.ClientTextUI;

public class TestLingRealizer {
	
	public static void main(String args[]) throws IOException {
		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter output = new PrintWriter(System.out, true); // with autoflush

		ClientTextUI ui = new ClientTextUI(input, output);
		for (String line : getScript()) {
			String parts[] = line.split(" +", 2);
			ui.processCmd(parts[0], parts.length > 1 ? parts[1] : "");
		}
		
		printDocumentPlan(ui.getMyController());
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
		
		comandos.add("selop Del");
		comandos.add("addtactic Del SP \\ndres \\{ p? \\} \\ndres procs");
		comandos.add("genalltt");
		comandos.add("genalltca");
		comandos.add("showsch Del_SP_17 -u -1");
		
		return comandos;
	}
}
