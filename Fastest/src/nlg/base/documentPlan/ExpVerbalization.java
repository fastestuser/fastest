package nlg.base.documentPlan;

import nlg.base.expr.ExprZ;

/**
 * Representan la informaciona a comunicar, en nuestro caso
 * la verbalizacion de expresiones.
 *
 */
public class ExpVerbalization {
	private ExprZ expr;
	
	public ExpVerbalization(ExprZ expr) {
		this.expr = expr;
	}

	public ExprZ getExpr() {
		return expr;
	}

	public void setExpr(ExprZ expr) {
		this.expr = expr;
	}
	
}
