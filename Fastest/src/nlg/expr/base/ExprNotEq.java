package nlg.expr.base;

import nlg.expr.visitors.ExprZVisitor;

/**
 * Desigualdad
 * ExprNotEq x y -> x ≠ y
 *
 */
public class ExprNotEq implements ExprZ {
	private ExprZ leftExpr;
	private ExprZ rightExpr;
	
	public ExprNotEq() {
		
	}
	
	public ExprNotEq(ExprZ leftExpr, ExprZ rightExpr) {
		this.leftExpr = leftExpr;
		this.rightExpr = rightExpr;
	}
	
	public ExprZ getLeftExpr() {
		return leftExpr;
	}
	public void setLeftExpr(ExprZ leftExpr) {
		this.leftExpr = leftExpr;
	}
	public ExprZ getRightExpr() {
		return rightExpr;
	}
	public void setRightExpr(ExprZ rightExpr) {
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
		ExprNotEq other = (ExprNotEq) obj;
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
	public <X> X accept(ExprZVisitor<X> visitor) {
		return visitor.visitExprNotEq(this);
	}
}
