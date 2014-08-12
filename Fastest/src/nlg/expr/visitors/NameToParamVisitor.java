package nlg.expr.visitors;

import nlg.expr.base.DesigParameter;
import nlg.expr.base.ExprApply;
import nlg.expr.base.ExprDom;
import nlg.expr.base.ExprEq;
import nlg.expr.base.ExprIn;
import nlg.expr.base.ExprIntersection;
import nlg.expr.base.ExprMapsTo;
import nlg.expr.base.ExprName;
import nlg.expr.base.ExprNot;
import nlg.expr.base.ExprNotEq;
import nlg.expr.base.ExprNotIn;
import nlg.expr.base.ExprRan;
import nlg.expr.base.ExprSet;
import nlg.expr.base.ExprSubSet;
import nlg.expr.base.ExprSubSetEq;
import nlg.expr.base.ExprUnion;
import nlg.expr.base.ExprZ;

/**
 * Modifica una expresion ExprZ cambiando el nombre indicado
 * por un objeto DesigParameter (sin modificar el resto de la expresion).
 * Se realiza esta accion una vez parseadas las designaciones, ya
 * que los parametros son parseados como variables por el parser
 * de czt, por lo tanto sera necesario realizar esta modificacion
 * luego de identificar los parametros para poder trabajar con estos.
 */
public class NameToParamVisitor implements VisitorExprZ<ExprZ> {

	private String paramName;
	
	public String getParamName() {
		return paramName;
	}

	public void setParamName(String paramName) {
		this.paramName = paramName;
	}

	@Override
	public ExprZ visitExprApply(ExprApply expr) {
		return expr;
	}

	@Override
	public ExprZ visitExprDom(ExprDom expr) {
		return expr;
	}

	@Override
	public ExprZ visitExprEq(ExprEq expr) {
		return expr;
	}

	@Override
	public ExprZ visitExprIn(ExprIn expr) {
		return expr;
	}

	@Override
	public ExprZ visitExprIntersection(ExprIntersection expr) {
		return expr;
	}

	@Override
	public ExprZ visitExprMapsTo(ExprMapsTo expr) {
		return expr;
	}

	@Override
	public ExprZ visitExprName(ExprName expr) {
		if (expr.getName().equals(paramName)) {
			return new DesigParameter(expr.getName());
		} else {
			return expr;
		}
	}

	@Override
	public ExprZ visitExprNotEq(ExprNotEq expr) {
		return expr;
	}

	@Override
	public ExprZ visitExprNotIn(ExprNotIn expr) {
		return expr;
	}

	@Override
	public ExprZ visitExprRan(ExprRan expr) {
		return expr;
	}

	@Override
	public ExprZ visitExprSet(ExprSet expr) {
		return expr;
	}

	@Override
	public ExprZ visitExprSubSetEq(ExprSubSetEq expr) {
		return expr;
	}

	@Override
	public ExprZ visitExprSubSet(ExprSubSet expr) {
		return expr;
	}

	@Override
	public ExprZ visitExprUnion(ExprUnion expr) {
		return expr;
	}

	@Override
	public ExprZ visitNot(ExprNot expr) {
		return expr;
	}

	@Override
	public ExprZ visitDesigParameter(DesigParameter param) {
		return param;
	}

	
	
}
