package nlg.util;

import java.util.List;

import net.sourceforge.czt.base.ast.Term;
import net.sourceforge.czt.base.visitor.TermVisitor;
import net.sourceforge.czt.base.visitor.VisitorUtils;
import net.sourceforge.czt.z.ast.NarrPara;
import net.sourceforge.czt.z.ast.NarrSect;
import net.sourceforge.czt.z.visitor.NarrParaVisitor;
import net.sourceforge.czt.z.visitor.NarrSectVisitor;
import nlg.base.designation.DesignationParser;
import nlg.base.designation.DesignationParserImpl;
import nlg.base.designation.DesignationRepo;
import nlg.base.designation.ParamDesignation;
import nlg.base.designation.TermDesignation;

/**
 * Parsea NarrPara en busca de designaciones y 
 * las agrega al repositorio de designaciones seteado.
 */
public class DesignationVisitor implements NarrParaVisitor<Void>,
		NarrSectVisitor<Void>, TermVisitor<Void> {

	public DesignationVisitor(DesignationRepo repo) {
		this.repo = repo;
	}

	@Override
	public Void visitNarrPara(NarrPara arg0) {
		List<? extends Object> content = arg0.getContent();
		visitContent(content);
		return null;
	}

	@Override
	public Void visitNarrSect(NarrSect arg0) {
		List<? extends Object> content = arg0.getContent();
		visitContent(content);
		return null;
	}

	private void visitContent(List<? extends Object> content) {
		for (Object o : content) {

			if (o instanceof String) {
				try {
					parser.parse((String) o);
					List<TermDesignation> listTd = parser.getAllTermDesignations();
					List<ParamDesignation> listPd = parser.getAllParamDesignations();
					
					for (TermDesignation td : listTd) {
						repo.addDesignation(td);
					}
					
					for (ParamDesignation pd : listPd) {
						repo.addDesignation(pd);
					}
				} catch (Exception e) {
					e.printStackTrace();
				} 
			}
		}
	}

	public Void visitTerm(Term term) {
		VisitorUtils.visitTerm(this, term, false);
		return null;
	}

	private DesignationParser parser = new DesignationParserImpl();
	private DesignationRepo repo;
}
