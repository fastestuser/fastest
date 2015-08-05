package client.presentation.commands;

import client.blogic.management.Controller;
import client.blogic.management.ii.EventAdmin;
import client.blogic.management.ii.events.RefineAbsTCasesRequested;
import client.blogic.testing.atcal.RefinementRule;
import client.blogic.testing.atcal.RuleManager;
import client.blogic.testing.ttree.TClassNode;
import client.blogic.testing.ttree.TTreeNode;
import client.blogic.testing.ttree.visitors.SchemeTTreeFinder;
import client.blogic.testing.ttree.visitors.TCaseNodeFinder;
import client.blogic.testing.ttree.visitors.TTreeNodeFinder;
import client.presentation.ClientTextUI;
import common.fastest.FastestUtils;
import common.z.AbstractTCase;
import common.z.Scheme;
import common.z.SpecUtils;
import net.sourceforge.czt.z.ast.AxPara;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/**
 * An instance of this class refine the abstract test case
 *
 * @author Joaquin Oscar Mesuro
 */
public class RefineCommand implements Command {

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

                // If the name is not an abstract test case, nor a test case, nor a class then fail.
                if (tcaMap == null) {
                    output.println("'" + opName + "' is neither the name of a loaded operation, nor an abstract Test Case nor a Test Class.");
                    return;
                }

                // Get the abstract test cases to be refined
                Collection<AbstractTCase> absTCasesColl = new ArrayList<AbstractTCase>();
                for (Map.Entry<String, AbstractTCase> opEntry : tcaMap.entrySet()) {
                    TTreeNode opCaseTTreeRoot = FastestUtils.getTTreeNode(controller, opEntry.getKey());
                    absTCasesColl.add(unfoldCase(opEntry.getValue(), opEntry.getKey(), opCaseTTreeRoot, controller));
                }

                // We check if the name of the abstraction law is contained in the
                // repository of loaded laws
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
                eventAdmin.announceEvent(new RefineAbsTCasesRequested(opName, absTCasesColl, targetLanguage, refinementRule));

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

    private static AbstractTCase unfoldCase(AbstractTCase abstractTCase, String opName, TTreeNode opTTreeRoot, Controller controller) {
        Scheme scheme = opTTreeRoot.acceptVisitor(new SchemeTTreeFinder(opName, -1));
        AxPara axPara = scheme.getMyAxPara();
        SpecUtils.setAxParaListOfDecl(abstractTCase.getMyAxPara(), SpecUtils.getAxParaListOfDecl(axPara));
        return abstractTCase;
    }
}
