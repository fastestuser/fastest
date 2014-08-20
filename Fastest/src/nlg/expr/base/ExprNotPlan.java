package nlg.expr.base;

import nlg.expr.visitors.ExprDescPlanVisitor;

/**
 * Negacion
 * ExprNotPlan x -> ¬ x
 */
public class ExprNotPlan implements ExprDescPlan {
	private ExprDescPlan expr;

	public ExprNotPlan(ExprDescPlan expr) {
		this.expr = expr;
	}

	public ExprDescPlan getExpr() {
		return expr;
	}

	public void setExpr(ExprDescPlan expr) {
		this.expr = expr;
	}

	@Override
	public <X> X accept(ExprDescPlanVisitor<X> visitor) {
		return visitor.visitNot(this);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((expr == null) ? 0 : expr.hashCode());
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
		ExprNotPlan other = (ExprNotPlan) obj;
		if (expr == null) {
			if (other.expr != null)
				return false;
		} else if (!expr.equals(other.expr))
			return false;
		return true;
	}
}
