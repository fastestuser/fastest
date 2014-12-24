package nlg.base.expr;


/**
 * RefExpr.
 * Representa nombres de variables, funciones, etc.
 */
public class ExprRef implements ExprZ {
	private String name;

	public ExprRef(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		ExprRef other = (ExprRef) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	@Override
	public <X> X accept(ExprZVisitor<X> visitor) {
		return visitor.visitExprRefExpr(this);
	}
}
