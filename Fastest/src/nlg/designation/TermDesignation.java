package nlg.designation;

import nlg.expr.base.ExprZ;

/**
 * Designacion de un termino Z.
 */
public class TermDesignation {
	private ExprZ expr;
	private String schName;
	
	public TermDesignation(ExprZ expr, String schName) {
		this.expr = expr;
		this.schName = schName;
	}

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
