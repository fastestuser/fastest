package client.presentation.commands;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
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
import client.blogic.testing.refinamiento.FTCRLUtils;
import client.blogic.testing.refinamiento.ImportsResolver;
import client.blogic.testing.refinamiento.RefinementRules;
import client.blogic.testing.ttree.TClassNode;
import client.blogic.testing.ttree.TTreeNode;
import client.blogic.testing.ttree.visitors.SchemeTTreeFinder;
import client.blogic.testing.ttree.visitors.TCaseNodeFinder;
import client.blogic.testing.ttree.visitors.TTreeNodeFinder;
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
				Controller controller = clientTextUI.getMyController();

				String opName = parts[0];
				String pathUUT = parts[3];
				String targetLanguaje = parts[6];
				String refRuleName = parts[8];

				EventAdmin eventAdmin = EventAdmin.getInstance();

				boolean isOp = false;
				AbstractTCase abstractTCase = null;
				//We check if the name of the operation is contained in the repository of loaded operations
				isOp = FastestUtils.isLoadedOperation(controller,opName);
				Map<String, AbstractTCase> tcaMap = null;
				Map<String, TClassNode> opTTreeMap = controller.getOpTTreeMap();
				if (isOp){
					TClassNode opTTreeRoot = opTTreeMap.get(opName);
					tcaMap = opTTreeRoot.acceptVisitor(new TCaseNodeFinder());
				}
				//If not, we check if name is the name of an abstract test case or a name of a ttree node
				if(!isOp){
					Iterator<TClassNode> it = opTTreeMap.values().iterator();
					TTreeNode ttnode = null;
					while(it.hasNext()){
						ttnode = it.next().acceptVisitor(new TTreeNodeFinder(opName));
						if (ttnode !=null){
							tcaMap = ttnode.acceptVisitor(new TCaseNodeFinder());
							break;
						}
					}
				}
				if (tcaMap==null){
					output.println("'" + opName + "' is neither the name of a loaded operation, nor an abstract Test Case nor a Test Class."); 
					return;
				}
				
				Collection<AbstractTCase> absTCasesColl = new ArrayList<AbstractTCase>();
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
				
				// We check if the name of the abstraction law is contained in the 
				// repository of loaded laws
				RefinementRules refRules = RefinementRules.getInstance();
				if (refRules.getRule(refRuleName)== null){
					output.println("'"+refRuleName+"' is not the name of a loaded refinement law");
					return;
				}

				//Extraemos las variables que serán referenciadas (REF)
				refRules.generateReferencedVars(refRuleName);
				
				//se resuelven los import con el uutPath
				String preamble = refRules.getRule(refRuleName).getPreamble();
				preamble = ImportsResolver.resolver(preamble, pathUUT);
				refRules.getRule(refRuleName).setPreamble(preamble);
				
				FTCRLUtils.setRule(refRules.getRule(refRuleName));
				eventAdmin.announceEvent(new RefineAbsTCasesRequested(opName, absTCasesColl,targetLanguaje));

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
		Scheme scheme = opTTreeRoot.acceptVisitor(new SchemeTTreeFinder(opName, -1));
		AxPara axPara = scheme.getMyAxPara();
		SpecUtils.setAxParaListOfDecl(abstractTCase.getMyAxPara(), SpecUtils.getAxParaListOfDecl(axPara));
		return abstractTCase;
	}

}
