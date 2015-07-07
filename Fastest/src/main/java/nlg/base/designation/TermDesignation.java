package nlg.base.designation;

import nlg.base.expression.ExprZ;

/**
 * Designacion de un termino Z.
 *   schName -> nombre del esquema de NO tratarse de una desginacion global
 *   expr -> termino designado
 *   text -> texto designado
 */
public class TermDesignation { 
	protected ExprZ expr;
	protected String schName;
	private String text;
	
	public TermDesignation(ExprZ expr, String schName, String text) {
		this.expr = expr;
		this.schName = schName;
		this.text = text;
	}
	
	public ExprZ getExpr() {
		return expr;
	}

	public String getSchName() {
		return schName;
	}

	public String getText() {
		return text;
	}
}
