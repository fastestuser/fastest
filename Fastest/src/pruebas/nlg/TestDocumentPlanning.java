package pruebas.nlg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import nlg.base.NLGDocumentPlan;
import nlg.base.NLGUtils;
import nlg.pipeline.DocumentPlanner;
import nlg.pipeline.DocumentPlannerImpl;
import client.blogic.management.Controller;
import client.blogic.testing.ttree.TClassNode;
import client.blogic.testing.ttree.visitors.TClassLeavesFinder;
import client.presentation.ClientTextUI;

import common.repository.AbstractIterator;
import common.repository.AbstractRepository;
import common.z.TClass;

public class TestDocumentPlanning {
	
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
		DocumentPlanner dp = new DocumentPlannerImpl();
		NLGDocumentPlan nlgDP = dp.plan(NLGUtils.getAllTClassLeaves(controller), controller);
		System.out.println(NLGUtils.nlgDocumentPlanToString(nlgDP));
		
	}
	
	private static List<String> getScript() {
		List<String> comandos = new ArrayList();
		comandos.add("loadspec /home/julian/Dropbox/Tesina/tmp/test.tex");
		
		comandos.add("selop Update");
		comandos.add("addtactic Update SP \\oplus st \\oplus \\{s? \\mapsto v?\\}");
		comandos.add("genalltt");
		comandos.add("genalltca");
		comandos.add("showsch -tcl");
		
		return comandos;
	}
}
