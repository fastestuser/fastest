package nlg.pipeline.microplanner;

import nlg.base.designation.DesignationRepo;
import nlg.base.designation.DesignationUtils;
import nlg.base.expression.ExprZ;
import nlg.base.textSpecification.PhraseSpecification;

public class Verbalizator {

	private DesignationRepo desigRepo;
	
	public Verbalizator(DesignationRepo desigRepo) {
		this.desigRepo = desigRepo;
	}
	
	public PhraseSpecification verbalize(ExprZ expr) {
		return null;
	}
	
	// verbaliza expresion designada
	// supongo que ya se verifico que la misma se encuentra designada
	public PhraseSpecification applyDesignation(ExprZ expr, String schName) {
		System.out.println(DesignationUtils.applyDesignation(expr, schName, desigRepo));
		
		return null;
	}
}
