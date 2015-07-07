package client.blogic.testing.refinement.java;

import client.blogic.testing.refinement.FTCRLUtils;
import client.blogic.testing.refinement.Refiner;
import common.z.SpecUtils;
import net.sourceforge.czt.base.ast.Term;

public final class RefinerJava extends Refiner{
	private String declarationList;
	private String assignementList;
	private String uutLine;
	private String warnings;
	
	public void refineCase(Term atc) throws Exception {
		
		String casoString = SpecUtils.termToLatex(atc);
		casoString = casoString.replace("~", "");
		casoString = casoString.replace("\\emptyset", "\\{\\}");
		FTCRLtoJavaVisitor visitor = new FTCRLtoJavaVisitor();
		visitor.assignTCase(casoString);
		visitor.visit(FTCRLUtils.getRule().getTree());

		warnings = visitor.getWarnings();
		declarationList =  visitor.getDeclarationList();
		assignementList =  visitor.getAssignementList();
		uutLine = visitor.uutLine;
	}

	public String getWarnings(){
		return warnings;
	}
	
	public String getAssignements() {
		return assignementList;
	}

	public String getDeclarations() {
		return declarationList;
	}
	
	public String getUutLine(){
		return uutLine;
	}
}
