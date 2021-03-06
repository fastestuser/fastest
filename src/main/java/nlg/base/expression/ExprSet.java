package nlg.base.expression;

import java.util.List;

/**
 * Conjunto de expresiones
 * ExprSet e1 e2 e3 -> {e1, e2, e3}
 */
public class ExprSet implements ExprZ {
	private List<ExprZ> elements;

	public ExprSet(List<ExprZ> elements) {
		super();
		this.elements = elements;
	}

	public List<ExprZ> getElements() {
		return elements;
	}

	public void setElements(List<ExprZ> elements) {
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
		ExprSet other = (ExprSet) obj;
		if (elements == null) {
			if (other.elements != null)
				return false;
		} else if (!elements.equals(other.elements))
			return false;
		return true;
	}
	
	@Override
	public <X> X accept(ExprZVisitor<X> visitor) {
		return visitor.visitExprSet(this);
	}
	
}
