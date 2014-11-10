package nlg.expr.base;

import nlg.expr.visitors.ExprZVisitor;

/**
 * Inclusion estricta
 * ExprSubSetPlan A B -> A ⊂ B
 */
public class ExprSubSet implements ExprZ {
	private ExprZ leftSet;
	private ExprZ rightSet;
	
	public ExprSubSet() {
		
	}
	
	public ExprSubSet(ExprZ leftSet, ExprZ rightSet) {
		this.leftSet = leftSet;
		this.rightSet = rightSet;
	}
	
	public ExprZ getLeftSet() {
		return leftSet;
	}
	public void setLeftSet(ExprZ leftSet) {
		this.leftSet = leftSet;
	}
	public ExprZ getRightSet() {
		return rightSet;
	}
	public void setRightSet(ExprZ rightSet) {
		this.rightSet = rightSet;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((leftSet == null) ? 0 : leftSet.hashCode());
		result = prime * result
				+ ((rightSet == null) ? 0 : rightSet.hashCode());
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
		ExprSubSet other = (ExprSubSet) obj;
		if (leftSet == null) {
			if (other.leftSet != null)
				return false;
		} else if (!leftSet.equals(other.leftSet))
			return false;
		if (rightSet == null) {
			if (other.rightSet != null)
				return false;
		} else if (!rightSet.equals(other.rightSet))
			return false;
		return true;
	}

	@Override
	public <X> X accept(ExprZVisitor<X> visitor) {
		return visitor.visitExprSubSet(this);
	}
}
