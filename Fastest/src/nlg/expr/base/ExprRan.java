package nlg.expr.base;

import nlg.expr.visitors.ExprZVisitor;

/**
 * Rango de una funcion
 * ExprRanPlan f -> ran(f)
 */
public class ExprRan implements ExprZ {
	private ExprZ function;

	public ExprRan() {
		
	}
	
	public ExprRan(ExprZ function) {
		this.function = function;
	}

	public ExprZ getFunction() {
		return function;
	}

	public void setFunction(ExprZ function) {
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
		ExprRan other = (ExprRan) obj;
		if (function == null) {
			if (other.function != null)
				return false;
		} else if (!function.equals(other.function))
			return false;
		return true;
	}
	
	@Override
	public <X> X accept(ExprZVisitor<X> visitor) {
		return visitor.visitExprRan(this);
	}
}
