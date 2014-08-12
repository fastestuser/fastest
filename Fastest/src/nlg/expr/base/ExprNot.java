package nlg.expr.base;

import nlg.expr.visitors.VisitorExprZ;

/**
 * Negacion
 * ExprNot x -> ¬ x
 */
public class ExprNot implements ExprZ {
	private ExprZ expr;

	public ExprNot(ExprZ expr) {
		this.expr = expr;
	}

	public ExprZ getExpr() {
		return expr;
	}

	public void setExpr(ExprZ expr) {
		this.expr = expr;
	}

	@Override
	public <X> X accept(VisitorExprZ<X> visitor) {
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
		ExprNot other = (ExprNot) obj;
		if (expr == null) {
			if (other.expr != null)
				return false;
		} else if (!expr.equals(other.expr))
			return false;
		return true;
	}
}
