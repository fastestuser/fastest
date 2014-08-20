package nlg.expr.visitors;

import java.util.ArrayList;
import java.util.List;

import nlg.expr.base.DesigParamPlan;
import nlg.expr.base.ExprApplyPlan;
import nlg.expr.base.ExprDescPlan;
import nlg.expr.base.ExprDomPlan;
import nlg.expr.base.ExprEqPlan;
import nlg.expr.base.ExprInPlan;
import nlg.expr.base.ExprIntersectionPlan;
import nlg.expr.base.ExprMapsToPlan;
import nlg.expr.base.ExprNamePlan;
import nlg.expr.base.ExprNotEqPlan;
import nlg.expr.base.ExprNotInPlan;
import nlg.expr.base.ExprNotPlan;
import nlg.expr.base.ExprRanPlan;
import nlg.expr.base.ExprSetPlan;
import nlg.expr.base.ExprSubSetEqPlan;
import nlg.expr.base.ExprSubSetPlan;
import nlg.expr.base.ExprUnionPlan;

/**
 * Modifica una expresion ExprDescPlan cambiando el nombre indicado
 * por un objeto DesigParameterPlan (sin modificar el resto de la expresion).
 * Se realiza esta accion una vez parseadas las designaciones, ya
 * que los parametros son parseados como variables por el parser
 * de czt, por lo tanto sera necesario realizar esta modificacion
 * luego de identificar los parametros para poder trabajar con estos.
 */
public class NameToParamVisitor implements ExprDescPlanVisitor<ExprDescPlan> {

	private String paramName;
	
	public String getParamName() {
		return paramName;
	}

	public void setParamName(String paramName) {
		this.paramName = paramName;
	}

	@Override
	public ExprDescPlan visitExprApply(ExprApplyPlan expr) {
		return new ExprApplyPlan(expr.getFunction().accept(this), expr.getArgument().accept(this));
	}

	@Override
	public ExprDescPlan visitExprDom(ExprDomPlan expr) {
		return new ExprDomPlan(expr.getFunction().accept(this));
	}

	@Override
	public ExprDescPlan visitExprEq(ExprEqPlan expr) {
		return new ExprEqPlan(expr.getLeftExpr().accept(this), expr.getRightExpr().accept(this));
	}

	@Override
	public ExprDescPlan visitExprIn(ExprInPlan expr) {
		return new ExprInPlan(expr.getElement().accept(this), expr.getSet().accept(this));
	}

	@Override
	public ExprDescPlan visitExprIntersection(ExprIntersectionPlan expr) {
		return new ExprIntersectionPlan(expr.getLeftSet().accept(this), expr.getRightSet().accept(this));
	}

	@Override
	public ExprDescPlan visitExprMapsTo(ExprMapsToPlan expr) {
		return new ExprMapsToPlan(expr.getLeft().accept(this), expr.getRight().accept(this));
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
		return new ExprNotEqPlan(expr.getLeftExpr().accept(this), expr.getRightExpr().accept(this));
	}

	@Override
	public ExprDescPlan visitExprNotIn(ExprNotInPlan expr) {
		return new ExprNotInPlan(expr.getElement().accept(this), expr.getSet().accept(this));
	}

	@Override
	public ExprDescPlan visitExprRan(ExprRanPlan expr) {
		return new ExprRanPlan(expr.getFunction().accept(this));
	}

	@Override
	public ExprDescPlan visitExprSet(ExprSetPlan expr) {
		List<ExprDescPlan> tmp = new ArrayList<ExprDescPlan>();
		for (ExprDescPlan edp : expr.getElements()) {
			tmp.add(edp.accept(this));
		}
		return new ExprSetPlan(tmp);
	}

	@Override
	public ExprDescPlan visitExprSubSetEq(ExprSubSetEqPlan expr) {
		return new ExprSubSetEqPlan(expr.getLeftSet().accept(this), expr.getRightSet().accept(this));
	}

	@Override
	public ExprDescPlan visitExprSubSet(ExprSubSetPlan expr) {
		return new ExprSubSetPlan(expr.getLeftSet().accept(this), expr.getRightSet().accept(this));
	}

	@Override
	public ExprDescPlan visitExprUnion(ExprUnionPlan expr) {
		return new ExprUnionPlan(expr.getLeftSet().accept(this), expr.getRightSet().accept(this));
	}

	@Override
	public ExprDescPlan visitNot(ExprNotPlan expr) {
		return new ExprNotPlan(expr.getExpr().accept(this));
	}

	@Override
	public ExprDescPlan visitDesigParameter(DesigParamPlan param) {
		return param;
	}
}
