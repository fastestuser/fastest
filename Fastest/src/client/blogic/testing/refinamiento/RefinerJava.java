package client.blogic.testing.refinamiento;

import java.util.List;

import org.antlr.v4.runtime.tree.ParseTree;

import common.z.SpecUtils;
import net.sourceforge.czt.base.ast.Term;
import client.blogic.testing.refinement.TCaseAssignment;

public class RefinerJava implements Refiner{

	@Override
	public List<TCaseAssignment> refineRule(RefinementRule rule, Term atc) {
		
		String casoString = SpecUtils.termToLatex(atc);
		casoString = casoString.replace("~", "");
		FTCRLJavaVisitor visitor = new FTCRLJavaVisitor();
		visitor.assignTCase(casoString);
		visitor.visit(rule.getTree());
		// TODO Auto-generated method stub
		return null;
	}




}
