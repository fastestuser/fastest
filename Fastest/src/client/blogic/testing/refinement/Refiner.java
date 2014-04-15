package client.blogic.testing.refinement;

import client.blogic.testing.refinement.java.RefinerJava;
import net.sourceforge.czt.base.ast.Term;

public abstract class Refiner {
	public abstract void refineCase(Term atcPred);
	public abstract String getAssignements();
	public abstract String getDeclarations();
	public abstract String getUutLine();
	public static Refiner getRefiner(String lenguaje){
		if (lenguaje.equals(("Java")))
			return new RefinerJava();
		return null;
	}
}
