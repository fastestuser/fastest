package nlg.designation;

import nlg.expr.base.ExprDescPlan;

/**
 * Designacion de un termino Z.
 */
public class TermDesignation {
	protected ExprDescPlan expr;
	protected String schName;

	public ExprDescPlan getExpr() {
		return expr;
	}

	public void setExpr(ExprDescPlan expr) {
		this.expr = expr;
	}

	public String getSchName() {
		return schName;
	}

	public void setSchName(String schName) {
		this.schName = schName;
	}	
}
