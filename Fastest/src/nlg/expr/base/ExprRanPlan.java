package nlg.expr.base;

import nlg.expr.visitors.ExprDescPlanVisitor;

/**
 * Rango de una funcion
 * ExprRanPlan f -> ran(f)
 */
public class ExprRanPlan implements ExprDescPlan {
	private ExprDescPlan function;

	public ExprRanPlan() {
		
	}
	
	public ExprRanPlan(ExprDescPlan function) {
		this.function = function;
	}

	public ExprDescPlan getFunction() {
		return function;
	}

	public void setFunction(ExprDescPlan function) {
		this.function = function;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((function == null) ? 0 : function.hashCode());
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
		ExprRanPlan other = (ExprRanPlan) obj;
		if (function == null) {
			if (other.function != null)
				return false;
		} else if (!function.equals(other.function))
			return false;
		return true;
	}
	
	@Override
	public <X> X accept(ExprDescPlanVisitor<X> visitor) {
		return visitor.visitExprRan(this);
	}
}
