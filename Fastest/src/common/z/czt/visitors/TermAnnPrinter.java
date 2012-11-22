package common.z.czt.visitors;

import net.sourceforge.czt.base.ast.*;
import net.sourceforge.czt.base.visitor.*;
import java.util.*;

import net.sourceforge.czt.z.ast.Expr;
import net.sourceforge.czt.z.visitor.ApplExprVisitor;
import net.sourceforge.czt.z.visitor.MemPredVisitor;
import net.sourceforge.czt.z.ast.Ann;
import net.sourceforge.czt.z.ast.ApplExpr;
import net.sourceforge.czt.z.ast.SetExpr;
import net.sourceforge.czt.z.ast.MemPred;
import net.sourceforge.czt.z.ast.TypeAnn;
import net.sourceforge.czt.z.ast.ZExprList;
import common.z.SpecUtils;

/**
 * A visitor that obtains all the needed predicates to use in the SP tactic when using an strategy
 */

public class TermAnnPrinter
implements TermVisitor<Term>
{

	public TermAnnPrinter(){
	}

	

	public Term visitTerm(Term term){
		Iterator<Object> it = term.getAnns().iterator();
		while(it.hasNext()){
			TypeAnn ann = (TypeAnn) it.next();
			System.out.println( "--------Ann: " + SpecUtils.termToLatex(ann)
					+ "\nTerm: " + SpecUtils.termToLatex(term));
		}
		
		Object[] args = term.getChildren();
		for (int i = 0; i < args.length; i++) {
			if (args[i] instanceof Term) {
				args[i] = ((Term) args[i]).accept(this);
			}
		}
		return term;
	}

	

}