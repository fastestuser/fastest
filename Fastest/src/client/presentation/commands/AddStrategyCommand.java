package client.presentation.commands;

import java.io.*;
import java.util.*;

import client.presentation.ClientTextUI;
import client.blogic.management.Controller;
import client.blogic.testing.ttree.*;
import client.blogic.testing.ttree.strategies.FTStrategy;
import client.blogic.testing.ttree.strategies.ISEStrategy;
import client.blogic.testing.ttree.strategies.NRStrategy;
import client.blogic.testing.ttree.strategies.SPStrategy;
import common.fastest.FastestUtils;

/**
 * An instance of this class makes possible the addition of a new strategy (together
 * with its parameters, if neccesary) to an operation to be tested.
 * @author Joaquín Cuenca
 */
public class AddStrategyCommand implements Command{

	/**
	 * Runs this command.
	 * @param clientTextUI
	 * @param args
	 */
	@Override
	public void run(ClientTextUI clientTextUI, String args) {
		PrintWriter output = clientTextUI.getOutput();
		String strategyName = "";
		try {
			// unitToTestName is the name of an operation or the name of a previously
			// generated test class
			String unitToTestName = "";
			// We make a little check of the parameters
			if (args == null || "".equals(args)) {
				output.println("Invalid parameters.  Try 'help'.");
				return;
			}

			String parts[] = args.split(" ", 0);
			
			if (parts.length < 2) {
				output.println("Invalid parameters.  Try 'help'.");
				return;
			}

			// We obtain the operation
			unitToTestName = parts[0];
			Controller controller = clientTextUI.getMyController();

			// We check if unitToTestName is the name of a selected operation,
			// the name of an operation with a previously generated test tree or
			// the name of a test class previously generated
			boolean isOp = FastestUtils.isLoadedOperation(controller, unitToTestName);
			String opName = null;
			if (isOp) {

				//System.out.println("Corriendo la estrategia " + strategyName + " sobre " + unitToTestName);
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
						output.println("'" + unitToTestName + "' is not the name of " + "a selected operation.");
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
					output.println("'" + unitToTestName + "' is not the name of a " + "loaded operation nor a test class.");
					return;
				}
			}

			//We check if the argument is a known strategy
			if (parts[1].equalsIgnoreCase("Estrategia1")) {
				if (parts.length > 2)
					parts = "SPFull".split(" ", 0);
				else
					parts = "SP".split(" ", 0);
			} else if (parts[1].equalsIgnoreCase("Estrategia2")) {
				if (parts.length > 2)
					parts = "SPFull NRFull".split(" ", 0);
				else
					parts = "SP NR".split(" ", 0);
			} else if (parts[1].equalsIgnoreCase("Estrategia3")) {
				if (parts.length > 2)
					parts = "SPFull FTFull".split(" ", 0);
				else
					parts = "SP FT".split(" ", 0);
			} else if (parts[1].equalsIgnoreCase("Estrategia4")) {
				if (parts.length > 2)
					parts = "SPFull NRFull FTFull".split(" ", 0);
				else
					parts = "SP NR FT".split(" ", 0);
			} else if (parts[1].equalsIgnoreCase("Estrategia5")) {
				if (parts.length > 2)
					parts = "SPFull NRFull ISEFull".split(" ", 0);
				else
					parts = "SP NR ISE".split(" ", 0);
			}
			
			//We apply the strategy
			int i = 0;
			while (i < parts.length) { //Mientras haya estrategias por aplicar
				strategyName = parts[i].replace("Full", "");
				//Creamos las strategias y las aplicamos
				Class strategyClass = Class.forName("client.blogic.testing.ttree.strategies." + strategyName + "Strategy");
				Object object = strategyClass.newInstance();

				if (object instanceof SPStrategy) {
					String option = "";
					if (parts[i].contains("Full")){
						option = "Full";
					}
					((SPStrategy) object).applyStrategy(clientTextUI, unitToTestName, option);
				} else if (object instanceof NRStrategy) {
					String option = "";
					if (parts[i].contains("Full")){
						option = "Full";
					}
					((NRStrategy) object).applyStrategy(clientTextUI, unitToTestName, option);
				} else if (object instanceof FTStrategy) {
					String option = "";
					if (parts[i].contains("Full")){
						option = "Full";
					}
					((FTStrategy) object).applyStrategy(clientTextUI, unitToTestName, option);
				} else if (object instanceof ISEStrategy) {
					String option = "";
					if (parts[i].contains("Full")){
						option = "Full";
					}
					((ISEStrategy) object).applyStrategy(clientTextUI, unitToTestName, option);
				}
				i++;
			}

		} catch (ClassNotFoundException e) {
			output.println("'" + strategyName
					+ "' is not the name of a class which extends Strategy.");
		} catch (InstantiationException e) {
			output.println("Error: The class " + strategyName + " could not be"
					+ " instantiated.");
		} catch (IllegalAccessException e) {
			output.println("Error: " + e);
			e.printStackTrace(output);
		}
	}
}