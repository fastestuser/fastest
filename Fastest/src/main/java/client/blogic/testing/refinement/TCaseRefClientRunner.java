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
	private String targetLanguage;

	public TCaseRefClientRunner(String opName, AbstractTCase abstractTCase, String targetLanguage) {
		this.opName = opName;
		this.abstractTCase = abstractTCase;
		this.targetLanguage = targetLanguage;
	}

	public ConcreteTCase getConcreteTCase() {
		return this.concreteTCase;
	}

	@Override
	public void run() {
		try {
			// We analyze the targetLanguage and create the corresponding refiner
			Refiner refiner = Refiner.getRefiner(targetLanguage);
			refiner.refineCase(abstractTCase.getMyAxPara());
			String abstractName = SpecUtils.getAxParaName(abstractTCase);
			String concreteName = abstractName.substring(0,abstractName.indexOf("_TCASE")) + "_CTCASE";
			concreteTCase = new ConcreteTCase();
			concreteTCase.setOpName(opName);
			concreteTCase.setLanguage(this.targetLanguage);
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
				TCaseRefined tCaseRefinedEvent = new TCaseRefined(opName,abstractTCase,null);
				EventAdmin eventAdmin = EventAdmin.getInstance();
				eventAdmin.announceEvent(tCaseRefinedEvent);
			} catch (Exception e) {
			}
		}
	}

}
