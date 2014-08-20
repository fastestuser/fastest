package nlg.expr.base;

import nlg.expr.visitors.ExprDescPlanVisitor;

/**
 * Parametro en designacion parametrizada
 */
public class DesigParamPlan implements ExprDescPlan {

	private String varName;
	
	public DesigParamPlan(String varName) {
		this.varName = varName;
	}

	public String getVarName() {
		return varName;
	}

	public void setVarName(String varName) {
		this.varName = varName;
	}
	
	@Override
	public <X> X accept(ExprDescPlanVisitor<X> visitor) {
		return visitor.visitDesigParameter(this);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result;
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
		return true;
	}

}
