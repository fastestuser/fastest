package common.z.czt.visitors;

import compserver.axdef.SynonymsLoader;
import java.util.ArrayList;
import java.util.List;
import net.sourceforge.czt.base.ast.Term;
import net.sourceforge.czt.base.visitor.TermVisitor;
import net.sourceforge.czt.base.visitor.VisitorUtils;
import net.sourceforge.czt.z.ast.AxPara;
import net.sourceforge.czt.z.ast.Box;
import net.sourceforge.czt.z.ast.Pred;
import net.sourceforge.czt.z.ast.RefExpr;
import net.sourceforge.czt.z.ast.ZSchText;
import net.sourceforge.czt.z.visitor.AxParaVisitor;

public class AxDefsSynonymsClassifier implements AxParaVisitor<Void>,
TermVisitor<Void> {

	private List<RefExpr> noBasicAxDefVars;

	public AxDefsSynonymsClassifier(List<RefExpr> noBasicAxDefVars) {
		this.noBasicAxDefVars = noBasicAxDefVars;
	}

	public Void visitAxPara(AxPara axPara) {
		if (axPara.getBox() == Box.AxBox) {
			ZSchText zSchText = axPara.getZSchText();
			Pred axDefPred = zSchText.getPred();
			ArrayList<String> axDefVars = new ArrayList<String>();
			for (int i = 0; i < noBasicAxDefVars.size(); i++) { //Las definiciones axiomaticas complejas deben tener una constante dentro
				axDefVars.add(noBasicAxDefVars.get(i).getZName().getWord());
			}	
			SynonymsLoader.loadSynonyms(axDefPred, axDefVars); //For thoose axiomatic definitions that use \forall
		}
		return null;
	}

	public Void visitTerm(Term term) {
		VisitorUtils.visitTerm(this, term, false);
		return null;
	}
}
