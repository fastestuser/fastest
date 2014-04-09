package client.blogic.testing.refinement;

import net.sourceforge.czt.base.ast.Term;

public interface Refiner {
	public void refineCase(Term atcPred);
	public String getAssignements();
	public String getDeclarations();
	public String getUutLine();
}
