package client.blogic.testing.refinamiento;

import common.z.AbstractTCase;
import common.z.SpecUtils;
import client.blogic.management.ii.EventAdmin;
import client.blogic.management.ii.events.TCaseRefined;

/**
 * @author Hache
 */
public class TCaseRefClientRunner implements Runnable {
	private String opName;
	private AbstractTCase abstractTCase;
	private ConcreteTCase concreteTCase;
	private String pathUUT;
	private String targetLanguaje;
	private String refRuleName;

	public TCaseRefClientRunner(String opName, AbstractTCase abstractTCase,
			String pathUUT, String targetLanguaje, String refRuleName) {
		this.opName = opName;
		this.abstractTCase = abstractTCase;
		this.pathUUT = pathUUT;
		this.targetLanguaje = targetLanguaje;
		this.refRuleName = refRuleName;
	}

	public ConcreteTCase getConcreteTCase() {
		return this.concreteTCase;
	}

	private ConcreteTCase refine(){
		RefinementRule rule = RefinementRules.getInstance().getRule(refRuleName);
		ConcreteTCase ctc = new ConcreteTCase();
		// We set some fields in the concrete case
		ctc.setPreamble(rule.getPreamble());
		ctc.setEpilogue("epilogo");
		ctc.setPathUUT("pathUUT");
		ctc.setLanguaje("Java");

		// We analyze the targetLanguaje and create the corresponding refiner
		Refiner refiner = null;
		if(targetLanguaje.equals("Java"))
			refiner = new RefinerJava();
		String s[] = refiner.refineRuleInString(rule, abstractTCase.getMyAxPara()).split("¬SEPARADOR¬");
		
		if(s.length>0)
			ctc.setDeclaraciones(s[0]);
		if (s.length>1)
			ctc.setAsignaciones(s[1]);
		return ctc;
	}

	@Override
	public void run() {
		try {
			concreteTCase = refine();
			// We set the operation related to this concrete case
			concreteTCase.setOpName(opName);
			// We set the name of this concrete test case
			String abstractName = SpecUtils.getAxParaName(abstractTCase);
			String concreteName = abstractName.substring(0,abstractName.indexOf("_TCASE"))
					+ "_CTCASE";
			concreteTCase.setConcreteTCaseName(concreteName);
			concreteTCase.setAbstractTCase(abstractTCase);
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
