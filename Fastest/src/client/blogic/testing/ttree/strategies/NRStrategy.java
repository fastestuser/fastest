package client.blogic.testing.ttree.strategies;

import java.util.*;
import java.io.*;

import client.blogic.management.Controller;
import client.blogic.testing.ttree.TClassNode;
import client.presentation.ClientTextUI;
import client.presentation.commands.AddTacticCommand;
import client.presentation.commands.Command;
import client.presentation.commands.GenAllTTCommand;
import client.presentation.commands.PruneTreeCommand;

import net.sourceforge.czt.base.ast.Term;
import net.sourceforge.czt.z.ast.DeclList;

import common.z.SpecUtils;
import common.z.czt.visitors.NumVarsExtractor;


/**
 * Implementation of the strategy Numeric Ranges (NR).
 */
public class NRStrategy{

	protected ClientTextUI clientTextUI;
	protected String unitToTestName;
	protected String option;
	protected String strategyName;

	/**
	 * Creates instances of SPStrategy.
	 */
	public NRStrategy() {
		this.strategyName = "NR";
	}

	/**
	 * Applies this strategy to the specified test class and returns the list with
	 * the generated test classes.
	 */
	public void applyStrategy(ClientTextUI clientTextUI, String unitToTestName, String option){

		this.clientTextUI = clientTextUI;
		this.unitToTestName = unitToTestName;
		this.option = option;

		Controller controller = clientTextUI.getMyController();
		BufferedReader input = clientTextUI.getInput();
		PrintWriter output = clientTextUI.getOutput();

		Command addtactic = new AddTacticCommand();
		Command genalltt = new GenAllTTCommand();
		Command prunett = new PruneTreeCommand();

		genalltt.run(clientTextUI, "");

		//Buscamos las variables numericas que se encuentran en el VIS de la operacion,
		Map<String, TClassNode> opTTreeMap = controller.getOpTTreeMap();
		Map<Term, String> numVars = null;
		if(!opTTreeMap.isEmpty()){
			Set<Map.Entry<String, TClassNode>> set = opTTreeMap.entrySet();
			Iterator<Map.Entry<String, TClassNode>> iterator = set.iterator();
			while(iterator.hasNext()){
				Map.Entry<String, TClassNode> mapEntry = iterator.next();
				TClassNode opTTreeRoot = mapEntry.getValue();

				if (opTTreeRoot.getValue().getSchName().equals(unitToTestName + "_VIS")) {
					DeclList declList = SpecUtils.getAxParaListOfDecl(opTTreeRoot.getValue().getMyAxPara());
					numVars = declList.accept(new NumVarsExtractor());
					break;
				}
			}
		}

		Iterator<Term> numVarsIt = numVars.keySet().iterator();

		boolean aplied = false;

		String language = "";
		HashMap<String, String> ranges = new HashMap<String, String>(8);

		while (numVarsIt.hasNext()) {

			Term exp = numVarsIt.next();
			String expString = SpecUtils.termToLatex(exp);
			String type = "";
			String range = null;
			aplied = false;

			//Chequeamos el lenguaje en el que se implementa la especificacion
			while (language.equals("")) {
				output.println("Choose the programming language:");
				try {
					language = input.readLine();
					if (language.equalsIgnoreCase("java")) {
						output.println("Language: " + language);
						ranges.put("int", "\\langle -2147483648, 2147483647 \\rangle");
						ranges.put("short", "\\langle -32768, 32767 \\rangle");
						ranges.put("long", "\\langle -9223372036854775808, 9223372036854775807 \\rangle");
						ranges.put("float", "\\langle " + minFloat +", " + maxFloat + " \\rangle");
						ranges.put("double", "\\langle " + minDouble +", " + maxDouble + " \\rangle");
					} else if (language.equalsIgnoreCase("C") || language.equalsIgnoreCase("C++")) {
						output.println("Language: " + language);
						ranges.put("int", "\\langle -32768, 32767 \\rangle");
						ranges.put("short", "\\langle -32768, 32767 \\rangle");
						ranges.put("long", "\\langle -2147483648, 2147483647 \\rangle");
						ranges.put("unsigned int", "\\langle 0, 65535 \\rangle");
						ranges.put("unsigned short", "\\langle 0, 65535 \\rangle");
						ranges.put("unsigned long", "\\langle 0, 4294967295 \\rangle");
						ranges.put("float", "\\langle " + minFloat +", " + maxFloat + " \\rangle");
						ranges.put("double", "\\langle " + minDouble +", " + maxDouble + " \\rangle");
						ranges.put("long double", "\\langle " + minDouble +", " + maxDouble + " \\rangle");
					} else {
						output.println("Invalid language. Choose between: java, C or C++");
						language = "";
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			//Chequeamos el tipo en el que se implemento
			while (range == null) {
				output.println("Choose the type of the variable: " + expString);
				try {
					type = input.readLine();
					range = ranges.get(type);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (option.equals("Full")) { //Si se desea aplicar de forma completa, no se pregunta para cada expr
				output.println("Applying: " + unitToTestName + " " + strategyName + " " + expString + " " + range);
				addtactic.run(clientTextUI, unitToTestName + " " + strategyName + " " + expString + " " + range);
				aplied = true;
			} else {
				output.println("Apply tactic: " + unitToTestName + " " + strategyName + " " + expString + " " + range + " ? y/n");
				try {
					option = input.readLine();
					if (option.equalsIgnoreCase("y") || option.equalsIgnoreCase("yes")){
						output.println("Applying: " + unitToTestName + " " + strategyName + " " + expString + " " + range);
						addtactic.run(clientTextUI, unitToTestName + " " + strategyName + " " + expString + " " + range);
						aplied = true;
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (aplied) {
				genalltt.run(clientTextUI, "");
				//pruneamos
				prunett.run(clientTextUI, "");
			}
		}
	}

	private static String generateRepeatingString(char c, int n) {
	    StringBuilder b = new StringBuilder();
	    for (int x = 0; x < n; x++)
	        b.append(c);
	    return b.toString();
	}
	
	private String maxFloat = "34028234663852886" + generateRepeatingString('0', 22);
	private String minFloat = "-34028234663852886" + generateRepeatingString('0', 22);
	private String maxDouble = "34028234663852886" + generateRepeatingString('0', 60);
	private String minDouble = "-34028234663852886" + generateRepeatingString('0', 60);
}
