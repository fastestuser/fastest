package nlg.base.expression;


/**
 * Aplicacion de funcion.
 * ExprApply f x -> f~x
 */
public class ExprApply implements ExprZ {
	private ExprZ function;
	private ExprZ argument;
	
	public ExprApply() {
		
	}
	
	public ExprApply(ExprZ function, ExprZ argument) {
		this.function = function;
		this.argument = argument;
	}
	
	public ExprZ getFunction() {
		return function;
	}
	public void setFunction(ExprZ function) {
		this.function = function;
	}
	public ExprZ getArgument() {
		return argument;
	}
	public void setArgument(ExprZ argument) {
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
		ExprApply other = (ExprApply) obj;
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
	public <X> X accept(ExprZVisitor<X> visitor) {
		return visitor.visitExprApply(this);
	}
}
