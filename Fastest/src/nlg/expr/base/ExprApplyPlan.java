package nlg.expr.base;

import nlg.expr.visitors.ExprDescPlanVisitor;

/**
 * Aplicacion de funcion.
 * ExprApplyPlan f x -> f~x
 */
public class ExprApplyPlan implements ExprDescPlan {
	private ExprDescPlan function;
	private ExprDescPlan argument;
	
	public ExprApplyPlan() {
		
	}
	
	public ExprApplyPlan(ExprDescPlan function, ExprDescPlan argument) {
		this.function = function;
		this.argument = argument;
	}
	
	public ExprDescPlan getFunction() {
		return function;
	}
	public void setFunction(ExprDescPlan function) {
		this.function = function;
	}
	public ExprDescPlan getArgument() {
		return argument;
	}
	public void setArgument(ExprDescPlan argument) {
		this.argument = argument;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((argument == null) ? 0 : argument.hashCode());
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
		ExprApplyPlan other = (ExprApplyPlan) obj;
		if (argument == null) {
			if (other.argument != null)
				return false;
		} else if (!argument.equals(other.argument))
			return false;
		if (function == null) {
			if (other.function != null)
				return false;
		} else if (!function.equals(other.function))
			return false;
		return true;
	}
	
	@Override
	public <X> X accept(ExprDescPlanVisitor<X> visitor) {
		return visitor.visitExprApply(this);
	}
}
