package common.z.czt.visitors;

import net.sourceforge.czt.base.ast.*;
import net.sourceforge.czt.base.visitor.*;
import java.util.*;

import net.sourceforge.czt.z.ast.Expr;
import net.sourceforge.czt.z.visitor.MemPredVisitor;
import net.sourceforge.czt.z.ast.SetExpr;
import net.sourceforge.czt.z.ast.MemPred;
import common.z.SpecUtils;

/*
 * A visitor that obtains all the needed predicates to use in the ISE tactic when using an strategy
 */

public class ISEExpresionExtractor
implements TermVisitor<Map<Term,String>>, MemPredVisitor<Map<Term,String>>
{

	public ISEExpresionExtractor(){
	}

	public Map<Term,String> visitTerm(Term term)
	{
		Map<Term,String> mapList = new HashMap<Term,String>();
		try{
			if(term != null){
				Object[] array = term.getChildren();
				Term auxTerm = null;
				if(array!=null){
					for (int i = 0; i < array.length; i++) {
						final Object object = array[i];
						if (object instanceof Term && object != null){
							auxTerm = (Term) object;
							if(auxTerm!=null){
								Map<Term,String> auxMap = auxTerm.accept(this);
								if(auxMap!=null)
									mapList.putAll(auxMap);
							}
						}
					}
				}
			}
		}
		catch(Exception e){
			System.out.println("Exception: \n"+e.toString());
		}
		return mapList;
	}

	public Map<Term,String> visitMemPred(MemPred memPred){
		Map<Term,String> mapList = new HashMap<Term,String>();

		if (!memPred.getMixfix()) { //It is a \in predicate
			Expr rightExpr = memPred.getRightExpr();
			if (rightExpr instanceof SetExpr) {
				mapList.put(memPred, SpecUtils.termToLatex(memPred));
			}
			return mapList;
		} else {
			Expr rightExpr = memPred.getRightExpr();
			Expr leftExpr = memPred.getLeftExpr();
			mapList.putAll(leftExpr.accept(this));
			mapList.putAll(rightExpr.accept(this));
			return mapList;
		}
	}
}