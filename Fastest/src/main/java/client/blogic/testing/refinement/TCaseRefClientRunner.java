package client.blogic.testing.refinement;

import common.z.AbstractTCase;
import common.z.SpecUtils;
import client.blogic.management.ii.EventAdmin;
import client.blogic.management.ii.events.TCaseRefined;
import client.blogic.testing.refinement.tcrlrules.RefinementRule;

/**
 * @author Hache
 */
public class TCaseRefClientRunner implements Runnable {
	private String opName;
	private AbstractTCase abstractTCase;
	private ConcreteTCase concreteTCase;
	private String targetLanguaje;

	public TCaseRefClientRunner(String opName, AbstractTCase abstractTCase, String targetLanguaje) {
		this.opName = opName;
		this.abstractTCase = abstractTCase;
		this.targetLanguaje = targetLanguaje;
	}

	public ConcreteTCase getConcreteTCase() {
		return this.concreteTCase;
	}

	@Override
	public void run() {
		try {
			// We analyze the targetLanguaje and create the corresponding refiner
			Refiner refiner = Refiner.getRefiner(targetLanguaje);
			refiner.refineCase(abstractTCase.getMyAxPara());
			String abstractName = SpecUtils.getAxParaName(abstractTCase);
			String concreteName = abstractName.substring(0,abstractName.indexOf("_TCASE")) + "_CTCASE";
			concreteTCase = new ConcreteTCase();
			concreteTCase.setOpName(opName);
			concreteTCase.setLanguaje(this.targetLanguaje);
			concreteTCase.setConcreteTCaseName(concreteName);
			concreteTCase.setAbstractTCase(abstractTCase);
			RefinementRule rule = FTCRLUtils.getRule();
			concreteTCase.setPreamble(rule.getPreamble());
			concreteTCase.setEpilogue(rule.getEpilogue());
			concreteTCase.setPlCode(rule.getPlCode());
			concreteTCase.setDeclaraciones(refiner.getDeclarations());
			concreteTCase.setAsignaciones(refiner.getAssignements());
			concreteTCase.setUutLine(refiner.getUutLine());
			concreteTCase.setWarnings(refiner.getWarnings());
		}catch(IllegalArgumentException e){
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println("Error when trying to refine " + opName + ":\n" + e.getMessage());
		} finally {
			try{
				TCaseRefined tCaseRefinedEvent = new TCaseRefined(opName,abstractTCase,concreteTCase);
				EventAdmin eventAdmin = EventAdmin.getInstance();
				eventAdmin.announceEvent(tCaseRefinedEvent);
			} catch (Exception e) {
			}
		}
	}

}
