package pruebas.nlg;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import client.presentation.ClientTextUI;

public class TestPipeline {
	public static void main(String args[]) throws Exception {
		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter output = new PrintWriter(System.out, true); // with autoflush

		ClientTextUI ui = new ClientTextUI(input, output);
		for (String line : getScript()) {
			String parts[] = line.split(" +", 2);
			ui.processCmd(parts[0], parts.length > 1 ? parts[1] : "");
		}
	}
	
	private static List<String> getScript() {
		List<String> comandos = new ArrayList<String>();
		comandos.add("loadspec /home/julian/Dropbox/Tesina/tmp/test.tex");
		
		comandos.add("selop Update");
		comandos.add("addtactic Update SP \\oplus st \\oplus \\{s? \\mapsto v?\\}");
		comandos.add("genalltt");
		comandos.add("genalltca");
		comandos.add("showsch -tcl");
		comandos.add("showdesc Update_SP_5");
		
		return comandos;
	}
}
