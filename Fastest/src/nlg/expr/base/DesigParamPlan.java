package nlg.expr.base;

import nlg.expr.visitors.VisitorExprDescPlan;

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
	public <X> X accept(VisitorExprDescPlan<X> visitor) {
		return visitor.visitDesigParameter(this);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((varName == null) ? 0 : varName.hashCode());
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
		DesigParamPlan other = (DesigParamPlan) obj;
		if (varName == null) {
			if (other.varName != null)
				return false;
		} else if (!varName.equals(other.varName))
			return false;
		return true;
	}
}
