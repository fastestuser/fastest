package nlg.base.designation;

import nlg.base.expr.ExprRef;
import nlg.base.expr.ExprZ;

/**
 * Designacion de un termino Z.
 *   schName -> nombre del esquema de NO tratarse de una desginacion global
 *   refExpr -> nombre del termino designado
 *   text -> texto designado
 */
public class TermDesignation {
	protected ExprRef expr;
	protected String schName;
	private String text;
	
	public TermDesignation(ExprRef expr, String schName, String text) {
		this.expr = expr;
		this.schName = schName;
		this.text = text;
	}
	
	public ExprRef getExpr() {
		return expr;
	}

	public String getSchName() {
		return schName;
	}

	public String getText() {
		return text;
	}
}
