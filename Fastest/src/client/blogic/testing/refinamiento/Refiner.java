package client.blogic.testing.refinamiento;

import java.util.List;

import net.sourceforge.czt.base.ast.Term;
import client.blogic.testing.refinement.TCaseAssignment;

public interface Refiner {

	public List<TCaseAssignment> refineRule(RefinementRule rule, Term atcPred);

	
}
