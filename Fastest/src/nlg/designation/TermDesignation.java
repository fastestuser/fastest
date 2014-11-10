package nlg.designation;

import nlg.expr.base.ExprZ;

/**
 * Designacion de un termino Z.
 */
public class TermDesignation {
	protected ExprZ expr;
	protected String schName;

	public ExprZ getExpr() {
		return expr;
	}

	public void setExpr(ExprZ expr) {
		this.expr = expr;
	}

	public String getSchName() {
		return schName;
	}

	public void setSchName(String schName) {
		this.schName = schName;
	}	
}
