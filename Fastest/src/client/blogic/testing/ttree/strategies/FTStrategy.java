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
import common.z.czt.visitors.FreetypeVarsExtractor;


/**
 * Implementation of the strategy Numeric Ranges (NR).
 * @author Joaquin Cuenca
 */
public class FTStrategy{

	protected ClientTextUI clientTextUI;
	protected String unitToTestName;
	protected String option;
	protected String strategyName;

	/**
	 * Creates instances of SPStrategy.
	 */
	public FTStrategy() {
		this.strategyName = "FT";
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

		//Buscamos las variables de tipo libre que se encuentran en el VIS de la operacion,
		Map<String, TClassNode> opTTreeMap = controller.getOpTTreeMap();
		Map<Term, String> freetypeVars = null;
		if(!opTTreeMap.isEmpty()){
			Set<Map.Entry<String, TClassNode>> set = opTTreeMap.entrySet();
			Iterator<Map.Entry<String, TClassNode>> iterator = set.iterator();
			while(iterator.hasNext()){
				Map.Entry<String, TClassNode> mapEntry = iterator.next();
				TClassNode opTTreeRoot = mapEntry.getValue();

				if (opTTreeRoot.getValue().getSchName().equals(unitToTestName + "_VIS")) {
					DeclList declList = SpecUtils.getAxParaListOfDecl(opTTreeRoot.getValue().getMyAxPara());
					freetypeVars = declList.accept(new FreetypeVarsExtractor(clientTextUI));
					break;
				}
			}
		}

		Iterator<Term> freeTypeVarsIt = freetypeVars.keySet().iterator();

		boolean aplied = false;

		while (freeTypeVarsIt.hasNext()) {

			Term exp = freeTypeVarsIt.next();
			String expString = SpecUtils.termToLatex(exp);
			aplied = false;

			if (option.equals("Full")) { //Si se desea aplicar de forma completa, no se pregunta para cada expr
				output.println("Applying: " + unitToTestName + " " + strategyName + " " + expString);
				addtactic.run(clientTextUI, unitToTestName + " " + strategyName + " " + expString);
				aplied = true;
			} else {
				output.println("Apply tactic: " + unitToTestName + " " + strategyName + " " + expString + " ? y\n");
				try {
					option = input.readLine();
					if (option.equalsIgnoreCase("y") || option.equalsIgnoreCase("yes")){
						output.println("Applying: " + unitToTestName + " " + strategyName + " " + expString);
						addtactic.run(clientTextUI, unitToTestName + " " + strategyName + " " + expString);
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
}
