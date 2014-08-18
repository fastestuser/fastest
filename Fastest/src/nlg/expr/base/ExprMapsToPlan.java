package nlg.expr.base;

import nlg.expr.visitors.VisitorExprDescPlan;

/**
 * Mapping
 * ExprMapsToPlan x y -> x ↦ y
 */
public class ExprMapsToPlan implements ExprDescPlan {
	private ExprDescPlan left;
	private ExprDescPlan right;
	
	public ExprMapsToPlan(){
		
	}
	
	public ExprMapsToPlan(ExprDescPlan left, ExprDescPlan right) {
		this.left = left;
		this.right = right;
	}
	
	public ExprDescPlan getLeft() {
		return left;
	}
	public void setLeft(ExprDescPlan left) {
		this.left = left;
	}
	public ExprDescPlan getRight() {
		return right;
	}
	public void setRight(ExprDescPlan right) {
		this.right = right;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((left == null) ? 0 : left.hashCode());
		result = prime * result + ((right == null) ? 0 : right.hashCode());
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
		ExprMapsToPlan other = (ExprMapsToPlan) obj;
		if (left == null) {
			if (other.left != null)
				return false;
		} else if (!left.equals(other.left))
			return false;
		if (right == null) {
			if (other.right != null)
				return false;
		} else if (!right.equals(other.right))
			return false;
		return true;
	}
	
	@Override
	public <X> X accept(VisitorExprDescPlan<X> visitor) {
		return visitor.visitExprMapsTo(this);
	}
}
