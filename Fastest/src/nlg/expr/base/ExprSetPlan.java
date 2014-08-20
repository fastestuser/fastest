package nlg.expr.base;

import java.util.List;

import nlg.expr.visitors.ExprDescPlanVisitor;

/**
 * Conjunto de expresiones
 * ExprSetPlan e1 e2 e3 -> {e1, e2, e3}
 */
public class ExprSetPlan implements ExprDescPlan {
	private List<ExprDescPlan> elements;

	public ExprSetPlan(List<ExprDescPlan> elements) {
		super();
		this.elements = elements;
	}

	public List<ExprDescPlan> getElements() {
		return elements;
	}

	public void setElements(List<ExprDescPlan> elements) {
		this.elements = elements;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((elements == null) ? 0 : elements.hashCode());
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
		ExprSetPlan other = (ExprSetPlan) obj;
		if (elements == null) {
			if (other.elements != null)
				return false;
		} else if (!elements.equals(other.elements))
			return false;
		return true;
	}
	
	@Override
	public <X> X accept(ExprDescPlanVisitor<X> visitor) {
		return visitor.visitExprSet(this);
	}
	
}
