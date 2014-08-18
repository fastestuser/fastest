package nlg.expr.base;

import nlg.expr.visitors.VisitorExprDescPlan;

/**
 * Igualdad
 * ExprEqPlan x y -> x = y
 *
 */
public class ExprEqPlan implements ExprDescPlan {
	private ExprDescPlan leftExpr;
	private ExprDescPlan rightExpr;
	
	public ExprEqPlan(){
		
	}
	
	public ExprEqPlan(ExprDescPlan leftExpr, ExprDescPlan rightExpr) {
		this.leftExpr = leftExpr;
		this.rightExpr = rightExpr;
	}
	
	public ExprDescPlan getLeftExpr() {
		return leftExpr;
	}
	public void setLeftExpr(ExprDescPlan leftExpr) {
		this.leftExpr = leftExpr;
	}
	public ExprDescPlan getRightExpr() {
		return rightExpr;
	}
	public void setRightExpr(ExprDescPlan rightExpr) {
		this.rightExpr = rightExpr;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((leftExpr == null) ? 0 : leftExpr.hashCode());
		result = prime * result
				+ ((rightExpr == null) ? 0 : rightExpr.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ExprEqPlan other = (ExprEqPlan) obj;
		if (leftExpr == null) {
			if (other.leftExpr != null)
				return false;
		} else if (!leftExpr.equals(other.leftExpr))
			return false;
		if (rightExpr == null) {
			if (other.rightExpr != null)
				return false;
		} else if (!rightExpr.equals(other.rightExpr))
			return false;
		return true;
	}
	
	@Override
	public <X> X accept(VisitorExprDescPlan<X> visitor) {
		return visitor.visitExprEq(this);
	}
}
