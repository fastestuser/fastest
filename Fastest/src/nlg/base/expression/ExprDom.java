package nlg.base.expression;


/**
 * Dominio de una funcion
 * ExprDom f -> dom(f)
 */
public class ExprDom implements ExprZ {
	private ExprZ function;

	public ExprDom() {
		
	}
	
	public ExprDom(ExprZ function) {
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
		ExprDom other = (ExprDom) obj;
		if (function == null) {
			if (other.function != null)
				return false;
		} else if (!function.equals(other.function))
			return false;
		return true;
	}
	
	@Override
	public <X> X accept(ExprZVisitor<X> visitor) {
		return visitor.visitExprDom(this);
	}
}
