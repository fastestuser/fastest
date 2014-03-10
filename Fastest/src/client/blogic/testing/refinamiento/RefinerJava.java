package client.blogic.testing.refinamiento;

import java.util.List;

import common.z.SpecUtils;
import net.sourceforge.czt.base.ast.Term;
import client.blogic.testing.refinement.TCaseAssignment;

public class RefinerJava implements Refiner{

	@Override
	public String refineRuleInString(RefinementRule rule, Term atc) {
		
		String casoString = SpecUtils.termToLatex(atc);
		casoString = casoString.replace("~", "");
		FTCRLJavaVisitor visitor = new FTCRLJavaVisitor();
		visitor.assignTCase(casoString);
		visitor.visit(rule.getTree());

		return visitor.getDeclarationList() +"¬SEPARADOR¬"+ visitor.getAssignementList();
	}

	@Override
	public List<TCaseAssignment> refineRule(RefinementRule rule, Term atcPred) {
		// TODO Auto-generated method stub
		return null;
	}




}
