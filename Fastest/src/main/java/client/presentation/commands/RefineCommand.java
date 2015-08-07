package client.presentation.commands;

import client.blogic.management.Controller;
import client.blogic.management.ii.EventAdmin;
import client.blogic.management.ii.IIComponent;
import client.blogic.management.ii.events.Event_;
import client.blogic.management.ii.events.TCaseRefineRequested;
import client.blogic.management.ii.events.TCaseRefined;
import client.blogic.testing.atcal.RefinementRule;
import client.blogic.testing.atcal.RuleManager;
import client.blogic.testing.ttree.TClassNode;
import client.blogic.testing.ttree.TTreeNode;
import client.blogic.testing.ttree.visitors.SchemeTTreeFinder;
import client.blogic.testing.ttree.visitors.TCaseNodeFinder;
import client.blogic.testing.ttree.visitors.TTreeNodeFinder;
import client.presentation.ClientTextUI;
import client.presentation.ClientUI;
import common.fastest.FastestUtils;
import common.z.AbstractTCase;
import common.z.Scheme;
import common.z.SpecUtils;
import net.sourceforge.czt.z.ast.AxPara;

import java.io.PrintWriter;
import java.util.*;

/**
 * An instance of this class represents an invocation of the refine command for an abstract test case collection.
 * The command announces one refine event for each abstract test case in the collection and returns once all the
 * refined events are received.
 *
 * @author Joaquin Oscar Mesuro
 * @author Cristian
 */
public class RefineCommand extends IIComponent implements Command {

    private static int pendingToRef = 0;    // number of pending refinement events to wait before completing

    @Override
    public void run(final ClientTextUI clientTextUI, final String args) {
        PrintWriter output = clientTextUI.getOutput();
        if (args == null || args.isEmpty() || args.split("\\s+").length < 9) {
            output.println("Invalid parameters.  Try 'help'.");
            return;
        } else {

            try {
                Controller controller = clientTextUI.getMyController();
                EventAdmin eventAdmin = EventAdmin.getInstance();

                // Parse arguments
                final String parts[] = args.split("\\s+");
                final String opName = parts[0];
                final String pathUUT = parts[3];
                final String targetLanguage = parts[6];
                final String refRuleName = parts[8];

                // Check if the name of the operation exists in the repository of loaded operations.
                // If not, check if the name is the name of an abstract test case or a name of a ttree node
                Map<String, AbstractTCase> tcaMap = null;
                Map<String, TClassNode> opTTreeMap = controller.getOpTTreeMap();

                if (FastestUtils.isLoadedOperation(controller, opName)) {
                    TClassNode opTTreeRoot = opTTreeMap.get(opName);
                    tcaMap = opTTreeRoot.acceptVisitor(new TCaseNodeFinder());
                    if ((tcaMap != null) && (tcaMap.isEmpty())) {
                        output.println("'" + opName + "' doesn't have Test Cases asociated.");
                        return;
                    }
                } else {
                    for (TClassNode tClassNode : opTTreeMap.values()) {
                        TTreeNode ttnode = tClassNode.acceptVisitor(new TTreeNodeFinder(opName));
                        if (ttnode != null) {
                            tcaMap = ttnode.acceptVisitor(new TCaseNodeFinder());
                            break;
                        }
                    }
                }

                // if the name is not an abstract test case, nor a test case, nor a class then fail.
                if (tcaMap == null) {
                    output.println("'" + opName + "' is neither the name of a loaded operation, nor an abstract Test Case nor a Test Class.");
                    return;
                }

                // get the abstract test cases to be refined
                Collection<AbstractTCase> absTCasesColl = new ArrayList<AbstractTCase>();
                for (Map.Entry<String, AbstractTCase> opEntry : tcaMap.entrySet()) {
                    TTreeNode opCaseTTreeRoot = FastestUtils.getTTreeNode(controller, opEntry.getKey());
                    absTCasesColl.add(unfoldCase(opEntry.getValue(), opEntry.getKey(), opCaseTTreeRoot, controller));
                }

                // check if the name of the abstraction law is contained in the repository of loaded laws
                RefinementRule refinementRule = RuleManager.getInstance().getRule(refRuleName);
                if (refinementRule == null) {
                    output.println("'" + refRuleName + "' is not the name of a loaded refinement law");
                    return;
                }

////				Extraemos las variables que serán referenciadas (REF)
//				RefinementRules.getInstance().generateReferencedVars(refRuleName);
//
////				se resuelven los import con el uutPath
//				String preamble = RefinementRules.getInstance().getRule(refRuleName).getPreamble();
//				String unfoldedPreamble = ImportResolver.getResolver(targetLanguage).resolver(preamble, pathUUT,output);
//				RefinementRules.getInstance().getRule(refRuleName).setUnfoldedPreamble(unfoldedPreamble);
//
//				FTCRLUtils.setRule(RefinementRules.getInstance().getRule(refRuleName));

                for(AbstractTCase atc: absTCasesColl){
                    TCaseRefineRequested tCaseRefineRequested = new TCaseRefineRequested(opName, atc, targetLanguage, refinementRule);
                    pendingToRef++;
                    eventAdmin.announceEvent(tCaseRefineRequested);
                }

                // Wait for the refinements to complete.
                synchronized (clientTextUI) {
                    clientTextUI.wait();
                }

            } catch (IllegalArgumentException e) {
                output.println(e.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Manages an implicit invocation event with the result of a refinement.
     * The method also notifies the client UI when all the results of the refinements are received.
     * @param event
     * @throws IllegalArgumentException
     */
    public synchronized void manageEvent(Event_ event) throws IllegalArgumentException {
        if (event instanceof TCaseRefined) {
            TCaseRefined tCaseRefined = (TCaseRefined) event;
            String tCaseName = tCaseRefined.getAbstractTCase().getSchName();
            Controller controller = myClientUI.getMyController();

            if (tCaseRefined.getConcreteTCase() != null) {
                controller.getOpTCaseRefinedMap().put(tCaseRefined.getConcreteTCase().getConcreteTCaseName(), tCaseRefined.getConcreteTCase());
                controller.getAbsTCaseConcrTCaseMap().put(tCaseName, tCaseRefined.getConcreteTCase());
                String warnings = tCaseRefined.getConcreteTCase().hasWarnings() ? " WARNING" : "";
                System.out.println(tCaseName + " test case refination -> SUCCESS." + warnings);
            } else {
                System.out.println(tCaseName + " test case refination -> FAILED.");
            }
            pendingToRef--;

            if (pendingToRef == 0) {
                try {
                    ClientUI clientUI = getMyClientUI();
                    if (clientUI instanceof ClientTextUI) {
                        synchronized (clientUI) {
                            clientUI.notify();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    private static AbstractTCase unfoldCase(AbstractTCase abstractTCase, String opName, TTreeNode opTTreeRoot, Controller controller) {
        Scheme scheme = opTTreeRoot.acceptVisitor(new SchemeTTreeFinder(opName, -1));
        AxPara axPara = scheme.getMyAxPara();
        SpecUtils.setAxParaListOfDecl(abstractTCase.getMyAxPara(), SpecUtils.getAxParaListOfDecl(axPara));
        return abstractTCase;
    }
}
