package nlg.expr.visitors;

import nlg.expr.base.DesigParamPlan;
import nlg.expr.base.ExprApplyPlan;
import nlg.expr.base.ExprDomPlan;
import nlg.expr.base.ExprEqPlan;
import nlg.expr.base.ExprInPlan;
import nlg.expr.base.ExprIntersectionPlan;
import nlg.expr.base.ExprMapsToPlan;
import nlg.expr.base.ExprNamePlan;
import nlg.expr.base.ExprNotPlan;
import nlg.expr.base.ExprNotEqPlan;
import nlg.expr.base.ExprNotInPlan;
import nlg.expr.base.ExprRanPlan;
import nlg.expr.base.ExprSetPlan;
import nlg.expr.base.ExprSubSetPlan;
import nlg.expr.base.ExprSubSetEqPlan;
import nlg.expr.base.ExprUnionPlan;
import nlg.expr.base.ExprDescPlan;

/**
 * Modifica una expresion ExprDescPlan cambiando el nombre indicado
 * por un objeto DesigParameterPlan (sin modificar el resto de la expresion).
 * Se realiza esta accion una vez parseadas las designaciones, ya
 * que los parametros son parseados como variables por el parser
 * de czt, por lo tanto sera necesario realizar esta modificacion
 * luego de identificar los parametros para poder trabajar con estos.
 */
public class NameToParamVisitor implements VisitorExprDescPlan<ExprDescPlan> {

	private String paramName;
	
	public String getParamName() {
		return paramName;
	}

	public void setParamName(String paramName) {
		this.paramName = paramName;
	}

	@Override
	public ExprDescPlan visitExprApply(ExprApplyPlan expr) {
		return expr;
	}

	@Override
	public ExprDescPlan visitExprDom(ExprDomPlan expr) {
		return expr;
	}

	@Override
	public ExprDescPlan visitExprEq(ExprEqPlan expr) {
		return expr;
	}

	@Override
	public ExprDescPlan visitExprIn(ExprInPlan expr) {
		return expr;
	}

	@Override
	public ExprDescPlan visitExprIntersection(ExprIntersectionPlan expr) {
		return expr;
	}

	@Override
	public ExprDescPlan visitExprMapsTo(ExprMapsToPlan expr) {
		return expr;
	}

	@Override
	public ExprDescPlan visitExprName(ExprNamePlan expr) {
		if (expr.getName().equals(paramName)) {
			return new DesigParamPlan(expr.getName());
		} else {
			return expr;
		}
	}

	@Override
	public ExprDescPlan visitExprNotEq(ExprNotEqPlan expr) {
		return expr;
	}

	@Override
	public ExprDescPlan visitExprNotIn(ExprNotInPlan expr) {
		return expr;
	}

	@Override
	public ExprDescPlan visitExprRan(ExprRanPlan expr) {
		return expr;
	}

	@Override
	public ExprDescPlan visitExprSet(ExprSetPlan expr) {
		return expr;
	}

	@Override
	public ExprDescPlan visitExprSubSetEq(ExprSubSetEqPlan expr) {
		return expr;
	}

	@Override
	public ExprDescPlan visitExprSubSet(ExprSubSetPlan expr) {
		return expr;
	}

	@Override
	public ExprDescPlan visitExprUnion(ExprUnionPlan expr) {
		return expr;
	}

	@Override
	public ExprDescPlan visitNot(ExprNotPlan expr) {
		return expr;
	}

	@Override
	public ExprDescPlan visitDesigParameter(DesigParamPlan param) {
		return param;
	}

	
	
}
