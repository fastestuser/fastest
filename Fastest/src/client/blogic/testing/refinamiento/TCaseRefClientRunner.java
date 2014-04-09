package client.blogic.testing.refinamiento;

import common.z.AbstractTCase;
import common.z.SpecUtils;
import client.blogic.management.ii.EventAdmin;
import client.blogic.management.ii.events.TCaseRefined;
import client.blogic.testing.refinamiento.java.RefinerJava;

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
			Refiner refiner = null;
			if(targetLanguaje.equals("Java"))
				refiner = new RefinerJava();
		//  if(targetLanguaje.equals("C"))
		//		refiner = new RefinerC();
			refiner.refineCase(abstractTCase.getMyAxPara());
			String abstractName = SpecUtils.getAxParaName(abstractTCase);
			String concreteName = abstractName.substring(0,abstractName.indexOf("_TCASE")) + "_CTCASE";
			concreteTCase = new ConcreteTCase();
			concreteTCase.setOpName(opName);
			concreteTCase.setLanguaje(this.targetLanguaje);
			concreteTCase.setConcreteTCaseName(concreteName);
			concreteTCase.setAbstractTCase(abstractTCase);
			concreteTCase.setPreamble(FTCRLUtils.getPreamble());
			concreteTCase.setEpilogue(FTCRLUtils.getEpilogue());
			concreteTCase.setPlCode(FTCRLUtils.getPlCode());
			concreteTCase.setDeclaraciones(refiner.getDeclarations());
			concreteTCase.setAsignaciones(refiner.getAssignements());
			concreteTCase.setUutLine(refiner.getUutLine());
			
			TCaseRefined tCaseRefinedEvent = new TCaseRefined(opName,abstractTCase,concreteTCase);
			try {
				EventAdmin eventAdmin = EventAdmin.getInstance();
				eventAdmin.announceEvent(tCaseRefinedEvent);
			} catch (Exception e) {
				e.printStackTrace(System.out);
				System.exit(0);
			}
		} catch (Exception e) {
			e.printStackTrace(System.out);
			System.exit(0);
		}

	}

}
