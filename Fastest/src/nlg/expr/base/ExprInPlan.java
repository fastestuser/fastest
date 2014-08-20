package nlg.expr.base;

import nlg.expr.visitors.ExprDescPlanVisitor;

/**
 * Pertenencia
 * ExprInPlan x A -> x ∈ A
 */
public class ExprInPlan implements ExprDescPlan {
	private ExprDescPlan element;
	private ExprDescPlan set;
	
	public ExprInPlan() {
		
	}
	
	public ExprInPlan (ExprDescPlan element, ExprDescPlan set) {
		this.element = element;
		this.set = set;
	}
	
	public ExprDescPlan getElement() {
		return element;
	}
	public void setElement(ExprDescPlan element) {
		this.element = element;
	}
	public ExprDescPlan getSet() {
		return set;
	}
	public void setSet(ExprDescPlan set) {
		this.set = set;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((element == null) ? 0 : element.hashCode());
		result = prime * result + ((set == null) ? 0 : set.hashCode());
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
		ExprInPlan other = (ExprInPlan) obj;
		if (element == null) {
			if (other.element != null)
				return false;
		} else if (!element.equals(other.element))
			return false;
		if (set == null) {
			if (other.set != null)
				return false;
		} else if (!set.equals(other.set))
			return false;
		return true;
	}
	
	@Override
	public <X> X accept(ExprDescPlanVisitor<X> visitor) {
		return visitor.visitExprIn(this);
	}
}
