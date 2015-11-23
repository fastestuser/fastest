package common.z.czt.visitors;

import java.util.ArrayList;
import java.util.List;

import net.sourceforge.czt.z.ast.Expr;
import net.sourceforge.czt.z.ast.ExprPred;
import net.sourceforge.czt.z.ast.IffPred;
import net.sourceforge.czt.z.ast.OrPred;
import net.sourceforge.czt.z.ast.PreExpr;
import net.sourceforge.czt.z.ast.Pred;
import net.sourceforge.czt.z.ast.Pred2;
import net.sourceforge.czt.z.visitor.ExprPredVisitor;
import net.sourceforge.czt.z.visitor.IffPredVisitor;
import net.sourceforge.czt.z.visitor.OrPredVisitor;
import net.sourceforge.czt.z.visitor.Pred2Visitor;
import net.sourceforge.czt.z.visitor.PredVisitor;


public class PreExprExtractor implements PredVisitor<Object>,
Pred2Visitor<Object>,
ExprPredVisitor<Object>,
IffPredVisitor<Object>,
OrPredVisitor<Object>{
	private List<PreExpr> preds;

	public PreExprExtractor(){
		preds = new ArrayList<PreExpr>();
	}
	public List<PreExpr> getPreds(){
		return preds;
	}

	/**
	 * Visit the specified instance of Pred and returns the same
	 * but deleting the \pred (PredExpr) instances.
	 * If it is necesary, it converts from AndPred to a simple one.
	 * @param tClassNode
	 */

	public Object visitExprPred(ExprPred pred){
		Expr expr = pred.getExpr();
		if (expr instanceof PreExpr) 
			preds.add((PreExpr) expr);
		return null;
	}

	public Object visitIffPred(IffPred pred) {
		Pred predLeft = pred.getLeftPred();
		Pred predRight = pred.getRightPred();
		predLeft.accept(this);
		predRight.accept(this);
		return null;
	}

	public Object visitOrPred(OrPred pred) {
		Pred predLeft = pred.getLeftPred();
		Pred predRight = pred.getRightPred();
		predLeft.accept(this);
		predRight.accept(this);
		return null;
	}

	public Object visitPred2(Pred2 pred){

		Pred predLeft = pred.getLeftPred();
		Pred predRight = pred.getRightPred();
		predLeft.accept(this);
		predRight.accept(this);
		return null;
	}    

	public Object visitPred(Pred pred)
	{
		Object[] args = pred.getChildren();
		for (int i = 0; i < args.length; i++) {
			if (args[i] instanceof Pred) {
				args[i] = ((Pred) args[i]).accept(this);
				if (args[i] == null) {
					int nums = args.length - ( i + 1 ) ;
					System.arraycopy( args, i + 1, args, i, nums ) ;
				}
			}
		}
		return null;
	}

}
