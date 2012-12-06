package client.blogic.testing.ttree.strategies;

import java.util.*;
import java.io.*;

import client.blogic.management.Controller;
import client.blogic.testing.ttree.TClassNode;
import client.blogic.testing.ttree.visitors.TClassNodeLeavesFinderHash;
import client.presentation.ClientTextUI;
import client.presentation.commands.AddTacticCommand;
import client.presentation.commands.Command;
import client.presentation.commands.GenAllTTCommand;
import client.presentation.commands.PruneTreeCommand;

import net.sourceforge.czt.base.ast.Term;
import net.sourceforge.czt.z.ast.AxPara;
import net.sourceforge.czt.z.ast.DeclList;
import net.sourceforge.czt.z.ast.ParaList;
import net.sourceforge.czt.z.ast.Sect;
import net.sourceforge.czt.z.ast.Spec;
import net.sourceforge.czt.z.ast.ZParaList;
import net.sourceforge.czt.z.ast.ZSect;
import net.sourceforge.czt.util.Visitor;

import common.z.SpecUtils;
import common.repository.AbstractRepository;
import common.z.czt.visitors.AtomicPredExtractor;
import common.z.czt.visitors.NumVarsExtractor;
import common.z.czt.visitors.SchemeUnfolder;


/**
 * Implementation of the strategy Numeric Ranges (NR).
 * @author Joaquin Cuenca
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
	}



	/**
	 * Applies this strategy to the specified test class and returns the list with
	 * the generated test classes.
	 * @param clientTextUI 
	 * @param unitToTestName 
	 * @param option 
	 * @param tClass
	 * @return 
	 * @return
	 */
	public void applyStrategy(ClientTextUI clientTextUI, String unitToTestName, String option){

		this.clientTextUI = clientTextUI;
		this.unitToTestName = unitToTestName;
		this.option = option;
		this.strategyName = "NR";

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
		HashMap<String, String> ranges = new HashMap(5);
		
		while (numVarsIt.hasNext()) {

			Term exp = numVarsIt.next();
			String expString = SpecUtils.termToLatex(exp);
			String type = "";
			String range = null;
			aplied = false;
			
			//Chequeamos el lenguaje en el que se implementa la especificacion
			while (language.equals("")) {
				output.println("Especifique el lenguaje de programacion:");
				try {
					language = input.readLine();
					if (language.equalsIgnoreCase("java")) {
						output.println("Lenguaje elegido: " + language);
						ranges.put("int", "\\langle -2147483648, 2147483647 \\rangle");
						ranges.put("short", "\\langle -32768, 32767 \\rangle");
						ranges.put("long", "\\langle -9223372036854775808, 9223372036854775807 \\rangle");
						ranges.put("float", "\\langle  \\rangle"); //Y estos??
						ranges.put("double", "\\langle  \\rangle");
					} else if (language.equalsIgnoreCase("C") || language.equalsIgnoreCase("C++")) {
							output.println("Lenguaje elegido: " + language);
							ranges.put("int", "\\langle -32768, 32767 \\rangle");
							ranges.put("short", "\\langle -32768, 32767 \\rangle");
							ranges.put("long", "\\langle -2147483648, 2147483647 \\rangle");
							ranges.put("unsigned int", "\\langle 0, 65535 \\rangle");
							ranges.put("unsigned short", "\\langle 0, 65535 \\rangle");
							ranges.put("unsigned long", "\\langle 0, 4294967295 \\rangle");
							ranges.put("double", "\\langle  \\rangle"); //Y estos??
							ranges.put("long double", "\\langle  \\rangle");
							
					} else {
						output.println("Lenguaje invalido, seleccione entre: java, C o C++");
						language = "";
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			//Chequeamos el tipo en el que se implemento
			while (range == null) {
				output.println("Especifique el tipo en el lenguaje " + language + " de la variable: " + expString);
				try {
					type = input.readLine();
					range = ranges.get(type);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			if (option.equals("Full")) { //Si se desea aplicar de forma completa, no se pregunta para cada expr
				output.println("Aplicamos: " + unitToTestName + " " + strategyName + " " + expString + " " + range);
				addtactic.run(clientTextUI, unitToTestName + " " + strategyName + " " + expString + " " + range);
				aplied = true;
			} else {
				output.println("Desea aplicar: " + unitToTestName + " " + strategyName + " " + expString + " " + range + " ?");
				try {
					option = input.readLine();
					if (option.equalsIgnoreCase("y") || option.equalsIgnoreCase("yes")){
						output.println("Aplicamos: " + unitToTestName + " " + strategyName + " " + expString + " " + range);
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



	/**
	 * Parses the parameters of this strategy.
	 * @param args
	 * @return
	 */
	public boolean parseArgs(String args) {
		return true;
	}

	/**
	 * Sets the instance of StrategyInfo associated to this object.
	 * @param strategyInfo
	 * @throws java.lang.IllegalArgumentException if strategyInfo is not an instance of
	 * StrategyInfo.
	 */
	//    public void setStrategyInfo(StrategyInfo strategyInfo)
	//            throws IllegalArgumentException {
	//
	//        if (strategyInfo instanceof SPStrategyInfo) {
	//            spStrategyInfo = (SPStrategyInfo) strategyInfo;
	//        } else {
	//            throw new IllegalArgumentException();
	//        }
	//
	//    }

	/**
	 * Gets the instance of StrategyInfo associated to this object.
	 * @return
	 */
	//    public StrategyInfo getStrategyInfo() {
	//        return spStrategyInfo;
	//    }

}
