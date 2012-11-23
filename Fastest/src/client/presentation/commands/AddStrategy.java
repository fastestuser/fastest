package client.presentation.commands;

import java.io.*;
import java.util.*;


import net.sourceforge.czt.z.ast.ParaList;
import net.sourceforge.czt.z.ast.ZParaList;
import net.sourceforge.czt.z.ast.Sect;
import net.sourceforge.czt.z.ast.ZSect;
import net.sourceforge.czt.z.ast.Spec;
import net.sourceforge.czt.z.ast.AxPara;


import client.presentation.ClientTextUI;
import client.blogic.management.Controller;
import common.repository.AbstractRepository;
import common.z.SpecUtils;
import client.blogic.testing.ttree.*;
import common.fastest.FastestUtils;

import net.sourceforge.czt.base.ast.Term;
import net.sourceforge.czt.util.Visitor;
import common.z.czt.visitors.AtomicPredExtractor;
import common.z.czt.visitors.SchemeUnfolder;


/**
 * An instance of this class makes possible the addition of a new strategy (together
 * with its parameters, if neccesary) to an operation to be tested.
 * @author Joaquín Cuenca
 */
public class AddStrategy implements Command{

	/**
	 * Runs this command.
	 * @param clientTextUI
	 * @param args
	 */
	@Override
	public void run(ClientTextUI clientTextUI, String args) {

		PrintWriter output = clientTextUI.getOutput();
		// unitToTestName is the name of an operation or the name of a previously
		// generated test class
		String unitToTestName = "";
		String strategyName = "";
		// We make a little check of the parameters
		if (args == null || "".equals(args)) {
			output.println("Invalid parameters.  Try 'help'.");
			return;
		}

		final String parts[] = args.split(" ", 3);
		if (parts.length != 2 && parts.length != 3) {
			output.println("Invalid parameters.  Try 'help'.");
			return;
		}

		// We obtain the parameters
		unitToTestName = parts[0];
		strategyName = parts[1];
		Controller controller = clientTextUI.getMyController();

		// We check if unitToTestName is the name of a selected operation,
		// the name of an operation with a previously generated test tree or
		// the name of a test class previously generated
		boolean isOp = FastestUtils.isLoadedOperation(controller, unitToTestName);
		String opName = null;
		if (isOp) {

			System.out.println("Corriendo la estrategia: " + strategyName + " sobre: " + unitToTestName);
			// unitToTestName is an operation
			// Now we check if this operation either have a testing tree
			// associated or have been selected to be tested
			opName = unitToTestName;
			Map<String, TClassNode> opTTreeMap = controller.getOpTTreeMap();
			TClassNode tClassRoot = opTTreeMap.get(unitToTestName);
			if (tClassRoot == null) {
				// It does not have a testing tree associated,
				// so it must have been selected
				boolean isSelOp = FastestUtils.isSelectedOperation(
						controller, unitToTestName);
				// If not, we finish returning an error message
				if (!isSelOp) {
					output.println("'" + unitToTestName + "' is not the name of "
							+ "a selected operation.");
					return;
				}
			}
		} else {
			// unitToTestName is not an operation
			// Now we check if unitToTestName is the name of a test class
			// contained/ in a test tree

			opName = FastestUtils.getOpAssociated(controller, unitToTestName);
			// If unitToTest is not a test class, we finish returning
			// an error message
			if (opName == null) {
				output.println("'" + unitToTestName + "' is not the name of a "
						+ "loaded operation nor a test class.");
				return;
			}


		}

		// If the user try to apply DNF tactic we return because this
		// tactic is applied by default
		if (strategyName.equals("DNF")) {
			return;
		}
		
		//Corremos genalltt
//		Command genalltt = new GenAllTTCommand();
//		genalltt.run(clientTextUI, "");
		
		//Instancia de prune para cuando haga falta
		Command prunett = new PruneTreeCommand();
		
		//Buscamos las apariciones de "\in" en la definiciones de la operación,
		//la cual deberá tomarse de forma unfoldeada
		
		Map<Term, String> expressions;// = new ConcreteRepository<AxPara>();
		//ExpressionsSPVisitor searcher = new ExpressionsSPVisitor();
		
		//Buscamos las expresiones que se encuentran en la operacion unfoldeada,
		// y las almacenamos en expressions
		
		Spec spec = controller.getUnfoldedSpec();
		AbstractRepository<String> opNames = controller.getOpsToTestRep();
    	AbstractRepository<String> schPredNames = controller.getSchemaPredicatesRep();
    	spec = (Spec) spec.accept(new SchemeUnfolder(opNames,schPredNames));
		
        AxPara axPara = null;
        for (Sect sect : spec.getSect()) {
            if (sect instanceof ZSect) {
                ParaList paraList = ((ZSect) sect).getParaList();
                if (paraList instanceof ZParaList) {
                    axPara = SpecUtils.axParaSearch(opName, (ZParaList) paraList);
                }
            }
        }
        
        System.out.println("AXPARA: " + SpecUtils.termToLatex(axPara));
        Visitor<Map<Term, String>> searcher = new AtomicPredExtractor();
		expressions = axPara.accept(searcher);
		
		Iterator<Term> expressionsIt = expressions.keySet().iterator();

		while (expressionsIt.hasNext()) {
			Term exp = expressionsIt.next();
			
			Command command = new AddTacticCommand();
			System.out.println("Aplicamos: " + opName + " SP " + expressions.get(exp) + " " + SpecUtils.termToLatex(exp));
			//command.run(clientTextUI, opName + " SP " + expressions.get(exp) + " " + SpecUtils.termToLatex(exp));
			//genalltt.run(clientTextUI, "");
			//pruneamos
			//prunett.run(clientTextUI, "");
		}
	}
}