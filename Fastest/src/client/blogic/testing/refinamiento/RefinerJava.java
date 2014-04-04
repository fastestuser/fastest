package client.blogic.testing.refinamiento;

import common.z.SpecUtils;
import net.sourceforge.czt.base.ast.Term;

public final class RefinerJava implements Refiner{
	private String declarationList;
	private String assignementList;
	private String uutLine;
	
	public void refineCase(Term atc) {
		
		String casoString = SpecUtils.termToLatex(atc);
		casoString = casoString.replace("~", "");
		casoString = casoString.replace("\\emptyset", "\\{\\}");
		FTCRLJavaVisitor visitor = new FTCRLJavaVisitor();
		visitor.assignTCase(casoString);
		visitor.visit(FTCRLUtils.getRule());

		declarationList =  visitor.getDeclarationList();
		assignementList =  visitor.getAssignementList();
		uutLine = visitor.uutLine;
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
