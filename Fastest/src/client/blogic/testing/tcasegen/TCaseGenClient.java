package client.blogic.testing.tcasegen;

import java.util.*;

import net.sourceforge.czt.z.ast.Spec;
import client.blogic.management.ii.events.TCaseGenerated;
import client.blogic.management.ii.events.TCaseRequested;
import client.blogic.management.ii.events.UnfoldedSpecLoaded;
import client.blogic.management.ii.events.TCaseStrategySelected;
import client.blogic.management.ii.events.FastestResetted;
import client.blogic.management.ii.events.Event_;
import client.blogic.management.ii.EventAdmin;
import client.blogic.management.ii.IIComponent;
import common.fastest.FastestUtils;
import common.z.TClass;
import compserver.tcasegen.strategies.SetLogStrategy;
import compserver.tcasegen.strategies.TCaseStrategy;
import compserver.tcasegen.strategies.PreCalculatedFiniteModels;

/**
 * Intances of this class (although we assume there is only one in the system)
 * manages the requests for abstract test cases generation.  These requests are
 * done in each event of type TCaseRequested that is announced in the system and
 * each of them are processed in a different thread (to favour performance 
 * issues), running the method run() of TCaseGenClientRunner in each new thread.
 * @author Pablo Rodriguez Monetti
 */
public class TCaseGenClient extends IIComponent {

	private Spec spec;
	private Map<String, TCaseStrategy> tCaseStrategyMap = new HashMap<String, TCaseStrategy>();


	/**
	 * Manages an implicit invocation event.
	 * @param event_
	 * @throws java.lang.IllegalArgumentException if event_ is neither instance of
	 * SpecLoaded nor TCaseRequested. 
	 */
	public synchronized void manageEvent(Event_ event_)
			throws IllegalArgumentException{

		if(event_ instanceof UnfoldedSpecLoaded){
			spec = ((UnfoldedSpecLoaded)event_).getSpec();
		}
		else if(event_ instanceof TCaseRequested){
			TCaseRequested tCaseRequested = (TCaseRequested)event_;
			String opName = tCaseRequested.getOpName();
			TClass tClass = tCaseRequested.getTClass();


			if (!FastestUtils.allNonBasicAxDefReplaced(tClass.getMyAxPara(), myClientUI.getMyController())){
				TCaseGenerated tCaseGenerated = new TCaseGenerated(opName, tClass, null);
				try{
					EventAdmin eventAdmin = EventAdmin.getInstance();
					eventAdmin.announceEvent(tCaseGenerated);
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}else{

				//int maxEval = tCaseRequested.getMaxEval();


				//			Map<RefExpr, Expr> axDefsValues = controller.getAxDefsValues();
				//			Map<String, List<String>> basicAxDefs = controller.getBasicAxDefs();


				//			List<FreePara> freeParas = controller.getFreeParas();
				//			List<String> basicTypeNames = controller.getBasicTypeNames();

				//			int fmSize = controller.getFiniteModelSize();


				//			Map<String, TClassNode> mapTTree = controller.getOpTTreeMap();

				String tClassName = tClass.getSchName();

				TCaseStrategy tCaseStrategy = tCaseStrategyMap.get(tClassName);
				if(tCaseStrategy == null){
					//tCaseStrategy = new IterativeTCaseStrategy(3, maxEval, axDefsValues, basicAxDefs, new GivenIntFiniteModel(), new GivenNatFiniteModel());
					//tCaseStrategy = new AtomicPredTCaseStrategy(fmSize, maxEval, axDefsValues, basicAxDefs, new GivenIntFiniteModel(), new GivenNatFiniteModel(), mapTTree);
					tCaseStrategy = new SetLogStrategy(myClientUI);
					//tCaseStrategy = new AtomicPredTCaseStrategy(fmSize, maxEval, axDefsValues, basicAxDefs, new ZeroIntFiniteModel(12), new ZeroNatFiniteModel(12), mapTTree);
				}

				if(spec==null)
					return;
				(new Thread(new TCaseGenClientRunner(spec, opName, tClass, tCaseStrategy))).start();
			}
		}
		else if(event_ instanceof TCaseStrategySelected){
			TCaseStrategySelected tCaseStrategySelected = (TCaseStrategySelected)event_;
			String tClassName = tCaseStrategySelected.getTClassName();
			TCaseStrategy tCaseStrategy = tCaseStrategySelected.getTCaseStrategy();
			tCaseStrategyMap.put(tClassName, tCaseStrategy);
		}
		else if(event_ instanceof FastestResetted){
			tCaseStrategyMap = new HashMap<String, TCaseStrategy>();
			PreCalculatedFiniteModels pCFM = PreCalculatedFiniteModels.getInstance();
			pCFM.clear();
		}
		else
			throw new IllegalArgumentException();
	}
}

