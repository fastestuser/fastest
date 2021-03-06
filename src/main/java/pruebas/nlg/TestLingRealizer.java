package pruebas.nlg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import nlg.base.documentPlan.DocumentPlan;
import nlg.base.textSpecification.PhraseSpec;
import nlg.base.textSpecification.TSDocument;
import nlg.base.textSpecification.TSItemisedList;
import nlg.pipeline.documentPlanner.DocumentPlanner;
import nlg.pipeline.microplanner.MicroPlanner;
import nlg.pipeline.realizer.LinguisticRealizer;
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
		
		DocumentPlan doc = null;
		DocumentPlanner dp = new DocumentPlanner(ui.getMyController());
		try {
			doc = dp.createDP(Arrays.asList("Update_SP_5"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		MicroPlanner microPlanner = new MicroPlanner(ui.getMyController());
		TSDocument ts = microPlanner.createTSDocument(doc);
		
		LinguisticRealizer lr = new LinguisticRealizer();
		
		List<PhraseSpec> pss = ((TSItemisedList) ts.getParagraphs().get(0)).getElements();
		for (PhraseSpec ps : pss) {
			System.out.println(lr.realise(ps));
		}
		
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