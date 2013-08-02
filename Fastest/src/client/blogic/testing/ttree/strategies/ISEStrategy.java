package client.blogic.testing.ttree.strategies;

import java.util.*;
import java.io.*;

import client.blogic.management.Controller;
import client.presentation.ClientTextUI;
import client.presentation.commands.AddTacticCommand;
import client.presentation.commands.Command;
import client.presentation.commands.GenAllTTCommand;
import client.presentation.commands.PruneTreeCommand;

import net.sourceforge.czt.base.ast.Term;
import net.sourceforge.czt.z.ast.AxPara;
import net.sourceforge.czt.z.ast.ParaList;
import net.sourceforge.czt.z.ast.Sect;
import net.sourceforge.czt.z.ast.Spec;
import net.sourceforge.czt.z.ast.ZParaList;
import net.sourceforge.czt.z.ast.ZSect;
import net.sourceforge.czt.util.Visitor;

import common.z.SpecUtils;
import common.repository.AbstractRepository;
import common.z.czt.visitors.ISEExpressionExtractor;
import common.z.czt.visitors.SchemeUnfolder;


/**
 * Implementation of the strategy In Set Extention (ISE).
 */
public class ISEStrategy{

	protected ClientTextUI clientTextUI;
	protected String unitToTestName;
	protected String option;
	protected String strategyName;

	/**
	 * Creates instances of SPStrategy.
	 */
	public ISEStrategy() {
		this.strategyName = "ISE";
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

		//Buscamos las expresiones de la forma "var \in \{...\}" que se encuentran en la definicion de la operacion,
		Spec spec = controller.getUnfoldedSpec();
		AbstractRepository<String> opNames = controller.getOpsToTestRep();
		AbstractRepository<String> schPredNames = controller.getSchemaPredicatesRep();
		spec = (Spec) spec.accept(new SchemeUnfolder(opNames,schPredNames));

		AxPara axPara = null;
		for (Sect sect : spec.getSect()) {
			if (sect instanceof ZSect) {
				ParaList paraList = ((ZSect) sect).getParaList();
				if (paraList instanceof ZParaList) {
					axPara = SpecUtils.axParaSearch(unitToTestName, (ZParaList) paraList);
				}
			}
		}

		Visitor<Map<Term, String>> searcher = new ISEExpressionExtractor();
		Map<Term, String> expressions;
		expressions = axPara.accept(searcher);
		Iterator<Term> expressionsIt = expressions.keySet().iterator();
		
		boolean aplied = false;

		while (expressionsIt.hasNext()) {

			Term exp = expressionsIt.next();
			String expString = SpecUtils.termToLatex(exp);
			aplied = false;
			
			if (option.equals("Full")) { //Si se desea aplicar de forma completa, no se pregunta para cada expr
				output.println("Applying: " + unitToTestName + " " + strategyName + " " + expString);
				addtactic.run(clientTextUI, unitToTestName + " " + strategyName + " " + expString);
				aplied = true;
			} else {
				output.println("Apply tactic: " + unitToTestName + " " + strategyName + " " + expString + " ? y/n");
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
