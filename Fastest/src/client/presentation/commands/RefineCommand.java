package client.presentation.commands;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import net.sourceforge.czt.z.ast.AxPara;
import common.fastest.FastestUtils;
import common.z.AbstractTCase;
import common.z.Scheme;
import common.z.SpecUtils;
import client.blogic.management.Controller;
import client.blogic.management.ii.EventAdmin;
import client.blogic.management.ii.events.RefineAbsTCasesRequested;
import client.blogic.testing.refinamiento.RefinementRules;
import client.blogic.testing.ttree.TClassNode;
import client.blogic.testing.ttree.TTreeNode;
import client.blogic.testing.ttree.visitors.SchemeTTreeFinder;
import client.blogic.testing.ttree.visitors.TCaseNodeFinder;
import client.presentation.ClientTextUI;

/**
 * An instance of this class refine the abstract test case
 * 
 * @author Joaquin Oscar Mesuro
 */
public class RefineCommand implements Command {

	@Override
	public void run(ClientTextUI clientTextUI, String args) {
		PrintWriter output = clientTextUI.getOutput();
		if (args == null || "".equals(args)){
			output.println("Invalid parameters.  Try 'help'.");
			return;
		} else {

			try{
				if (args == null || "".equals(args)){
					output.println("Invalid parameters.  Try 'help'.");
					return;
				}

				final String parts[] = args.split(" ");
				if (parts.length < 9){
					output.println("Invalid parameters.  Try 'help'.");
					return;
				}

				String opName = parts[0];
				String pathUUT = parts[3];
				String targetLanguaje = parts[6];
				String refRuleName = parts[8];

				Controller controller = clientTextUI.getMyController();
				EventAdmin eventAdmin = EventAdmin.getInstance();

				boolean isOp = false;
				AbstractTCase abstractTCase = null;

				//We check if the name of the operation is contained in the repository of loaded operations
				isOp = FastestUtils.isLoadedOperation(controller,opName);

				//If not, we check if name is the name of an abstract test case
				if(!isOp)
					abstractTCase = FastestUtils.getAbstractTCase(controller, opName);
				

				if(!isOp && abstractTCase == null){
					// We finish returning an error message
					output.println("'" + opName + "' is not the name of a loaded operation or a abstract Test case."); 
					return;
				}

				// We check if the name of the abstraction law is contained in the 
				// repository of loaded laws
				RefinementRules r = RefinementRules.getInstance();
				if (r.getRule(refRuleName)== null){
					output.println("'"+refRuleName+"' is not the name of a loaded refinement law");
					return;
				}
				
				//t.acceptVisitor(new TTreeTextUIPrinter(clientTextUI.getOutput()));
				// We obtain the abstract test cases to refine. If we try to refine
				// an operation then we send to refine all the leafs of this operation.
				// If we try to refine an abstract test case then we send a repository 
				// with only this element				
				Collection<AbstractTCase> absTCasesColl = new ArrayList<AbstractTCase>();
				if(isOp){
					Map<String, TClassNode> opTTreeMap = controller.getOpTTreeMap();
					TClassNode opTTreeRoot = opTTreeMap.get(opName);
					// We obtain all the leafs for this testing tree
					Map<String, AbstractTCase> tcaMap = opTTreeRoot.acceptVisitor(new TCaseNodeFinder());
					
					Set<String> set = tcaMap.keySet();
					Iterator<String> it = set.iterator();
					TTreeNode opCaseTTreeRoot; 
					String opCaseName;
					//unfoldeamos todos los casos antes de enviarlos a refinar
					while (it.hasNext()){
						opCaseName = it.next();
						abstractTCase = tcaMap.get(opCaseName);
						opCaseTTreeRoot = FastestUtils.getTTreeNode(controller,opCaseName);
						absTCasesColl.add(unfoldCase(abstractTCase,opCaseName,opCaseTTreeRoot,controller));
					}
				}
				else{
					TTreeNode opTTreeRoot = FastestUtils.getTTreeNode(controller,opName);
					abstractTCase = unfoldCase(abstractTCase,opName,opTTreeRoot,controller);
					absTCasesColl.add(abstractTCase);
				}

				//Extraemos las variables que serán referenciadas (REF)
				RefinementRules refRules = RefinementRules.getInstance();
				refRules.generateReferencedVars(refRuleName);
				eventAdmin.announceEvent(new RefineAbsTCasesRequested(opName, absTCasesColl, pathUUT,targetLanguaje,refRuleName));

				synchronized(clientTextUI){
					clientTextUI.wait();
				}

			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
	}

	private AbstractTCase unfoldCase(AbstractTCase abstractTCase, String opName, TTreeNode opTTreeRoot,Controller controller){
		Scheme scheme = opTTreeRoot.acceptVisitor(new SchemeTTreeFinder(opName, 5));		
		AxPara axPara = scheme.getMyAxPara();
		SpecUtils.setAxParaListOfDecl(abstractTCase.getMyAxPara(), SpecUtils.getAxParaListOfDecl(axPara));
		return abstractTCase;
	}

}
