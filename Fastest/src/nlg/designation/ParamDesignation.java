package nlg.designation;

import nlg.expr.base.ExprRef;
import nlg.expr.base.ExprZ;

/**
 * Designacion parametrizada
 *  Ej: x es una designacion ~ desig(x)
 *   expr -> expresion designada [ej: desig(x)]
 *   schName -> nombre del esquema de NO tratarse de una desginacion global [ej: null]
 *   refExpr -> nombre del parametro [ej: x]
 *   desigFun -> funcion que verbaliza la designacion [ej: \s:String -> s + "es una designacion"]
 *
 */
public class ParamDesignation {
	private ExprZ expr;
	private ExprRef refExpr;
	private String schName;
	private DesignationFunction desigFun;
	
	public ParamDesignation(ExprZ expr, String schName, ExprRef refExpr, DesignationFunction desigFun) {
		this.refExpr = refExpr;
		this.desigFun = desigFun;
		this.expr = expr;
		this.schName = schName;
	}

	public ExprZ getExpr() {
		return expr;
	}

	// devuelve nombre del parametro
	public ExprRef getRefExpr() {
		return refExpr;
	}

	public String getSchName() {
		return schName;
	}

	public DesignationFunction getDesigFun() {
		return desigFun;
	}
	
}
