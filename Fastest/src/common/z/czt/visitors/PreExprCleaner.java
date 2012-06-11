package common.z.czt.visitors;

import net.sourceforge.czt.base.ast.Term;
import net.sourceforge.czt.base.visitor.TermVisitor;
import net.sourceforge.czt.z.ast.Expr;
import net.sourceforge.czt.z.ast.ExprPred;
import net.sourceforge.czt.z.ast.PreExpr;
import net.sourceforge.czt.z.ast.Pred;
import net.sourceforge.czt.z.ast.Pred2;
import net.sourceforge.czt.z.visitor.ExprPredVisitor;
import net.sourceforge.czt.z.visitor.Pred2Visitor;
import net.sourceforge.czt.z.visitor.PredVisitor;


public class PreExprCleaner implements TermVisitor,
									   Pred2Visitor,
									   ExprPredVisitor{
		
	public PreExprCleaner(){
	}
	
    /**
     * Visit the specified instance of Pred and returns the same
     * but deleting the \pred (PredExpr) instances.
     * If it is necesary, it converts from AndPred to a simple one.
     * @param tClassNode
     * @return the test classes of this subtree that are leaves of the test tree.
     */
	
	public Pred visitExprPred(ExprPred pred){
		Expr expr = pred.getExpr();
		if (expr instanceof PreExpr) {
			return null;
		} else {
			return pred;
		}
	}
	
	public Pred visitPred2(Pred2 pred){

		Pred predLeft = pred.getLeftPred();
		Pred predRight = pred.getRightPred();
		Pred predLeft2 = predLeft.accept(this);
		Pred predRight2 = predRight.accept(this);
		if ( predLeft2 == null) {
			return predRight2;
		} else if (predRight2 == null){
			return predLeft2;
		} else {
			return pred;
		}

	}    

	public Term visitTerm(Term term)
	{
		Object[] args = term.getChildren();
		for (int i = 0; i < args.length; i++) {
			if (args[i] instanceof Term) {
					args[i] = ((Term) args[i]).accept(this);
					if (args[i] == null) {
//						for (int j = i; j < args.length; j++) {
//							args[j] = args[j+1];
//						}
//						i--;
						int nums = args.length - ( i + 1 ) ;
						System.arraycopy( args, i + 1, args, i, nums ) ;
					}
			}
		}
		return term.create(args);
	}

	
//	public Pred visitPred(Pred pred) {
//		return pred;
//	}

}
