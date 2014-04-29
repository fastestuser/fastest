package client.presentation.commands;

import java.io.*;
import java.util.*;

import net.sourceforge.czt.z.ast.ZDeclList;

import client.presentation.ClientTextUI;
import common.repository.ConcreteRepository;
import client.blogic.management.Controller;
import client.blogic.testing.ttree.tactics.Tactic;
import client.blogic.testing.ttree.TClassNode;
import client.blogic.testing.ttree.strategies.TTreeStrategy;
import client.blogic.management.ii.EventAdmin;
import client.blogic.management.ii.events.TCaseRequested;
import client.blogic.testing.ttree.visitors.TClassNodeLeavesFinder;
import common.repository.AbstractIterator;
import common.repository.AbstractRepository;
import common.z.SpecUtils;
import common.z.TClass;
import common.z.czt.visitors.TClassNodeUnfolder;

/**
 * Instances of this class allow the generation of test cases for the operations for which 
 * there is a test tree generated.
 * @author Pablo Rodriguez Monetti
 */
public class GenAllTCasesCommand implements Command {

	/**
	 * Runs this command.
	 * @param clientTextUI
	 * @param args
	 */
	@Override
	public void run(ClientTextUI clientTextUI, String args) {
		PrintWriter output = clientTextUI.getOutput();
		try {

			if (!args.equals("")) {
				output.println("Invalid parameters. Try 'help'.");
				return;
			}

			Controller controller = clientTextUI.getMyController();

			EventAdmin eventAdmin = EventAdmin.getInstance();
			Map<String, TClassNode> opTTreeMap = controller.getOpTTreeMap();
			Set<Map.Entry<String, TClassNode>> set = opTTreeMap.entrySet();
			Iterator<Map.Entry<String, TClassNode>> iterator = set.iterator();
			int maxEval = controller.getMaxEval();


			Iterator<ZDeclList> it = controller.getAuxiliarDecls().values().iterator();
			while (it.hasNext())
				System.out.println(SpecUtils.termToLatex(it.next()));	

			boolean someEventAnnounced = false;
			while (iterator.hasNext()) {
				Map.Entry<String, TClassNode> mapEntry = iterator.next();
				String opName = mapEntry.getKey();
				TClassNode opTTreeRoot = mapEntry.getValue();


				// Extracts all the TCLassNodes that are leaves of the tClassNode test tree
				// except for those leaves that are descendants of pruned test classes.
				AbstractRepository<TClassNode> tClassNodeLeaves = opTTreeRoot.acceptVisitor(new TClassNodeLeavesFinder());
				AbstractIterator<TClassNode> tClassNodeIt = tClassNodeLeaves.createIterator();
				while (tClassNodeIt.hasNext()) {
					TClassNode tClassNode = tClassNodeIt.next();
					TClassNodeUnfolder tClassNodeUnfolder = new TClassNodeUnfolder(tClassNode, controller);
					tClassNode.acceptVisitor(tClassNodeUnfolder);
					TClass tClass = tClassNodeUnfolder.getTClassUnfolded();

					if (someEventAnnounced == false) {
						Calendar cal = Calendar.getInstance();
						controller.setInicio(cal.getTimeInMillis());
					}
					someEventAnnounced = true;
					TCaseRequested tCaseRequested = new TCaseRequested(opName, tClass, maxEval);
					eventAdmin.announceEvent(tCaseRequested);
				}


			}


			if (someEventAnnounced) {
				synchronized (clientTextUI) {
					clientTextUI.wait();
				}
			}

			// Quitamos las seleccion de las operaciones elegidas
			controller.setOpsToTestRep(new ConcreteRepository<String>());
			controller.setOpTTreeStrategyMap(new HashMap<String, TTreeStrategy>());
			controller.setTacticMap(new HashMap<String, List<Tactic>>());


		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
