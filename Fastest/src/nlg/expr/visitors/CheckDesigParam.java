package nlg.expr.visitors;

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
 * Verifica si una expresion se encuentra parametrizada
 *
 */
public class CheckDesigParam implements ExprDescPlanVisitor<Boolean> {

	@Override
	public Boolean visitExprApply(ExprApplyPlan expr) {
		return expr.getFunction().accept(this) || expr.getArgument().accept(this);
	}

	@Override
	public Boolean visitExprDom(ExprDomPlan expr) {
		return expr.getFunction().accept(this);
	}

	@Override
	public Boolean visitExprEq(ExprEqPlan expr) {
		return expr.accept(this);
	}

	@Override
	public Boolean visitExprIn(ExprInPlan expr) {
		return expr.accept(this);
	}

	@Override
	public Boolean visitExprIntersection(ExprIntersectionPlan expr) {
		return expr.getLeftSet().accept(this) || expr.getRightSet().accept(this);
	}

	@Override
	public Boolean visitExprMapsTo(ExprMapsToPlan expr) {
		return expr.getLeft().accept(this) || expr.getRight().accept(this);
	}

	@Override
	public Boolean visitExprName(ExprNamePlan expr) {
		return false;
	}

	@Override
	public Boolean visitExprNotEq(ExprNotEqPlan expr) {
		return expr.getLeftExpr().accept(this) || expr.getRightExpr().accept(this);
	}

	@Override
	public Boolean visitExprNotIn(ExprNotInPlan expr) {
		return expr.getElement().accept(this) || expr.getSet().accept(this);
	}

	@Override
	public Boolean visitExprRan(ExprRanPlan expr) {
		return expr.getFunction().accept(this);
	}

	@Override
	public Boolean visitExprSet(ExprSetPlan expr) {
		Boolean ret = false;
		for (ExprDescPlan edp : expr.getElements()) {
			ret = ret || edp.accept(this);
		}
		return ret;
	}

	@Override
	public Boolean visitExprSubSetEq(ExprSubSetEqPlan expr) {
		return expr.getLeftSet().accept(this) || expr.getRightSet().accept(this);
	}

	@Override
	public Boolean visitExprSubSet(ExprSubSetPlan expr) {
		return expr.getLeftSet().accept(this) || expr.getRightSet().accept(this);
	}

	@Override
	public Boolean visitExprUnion(ExprUnionPlan expr) {
		return expr.getLeftSet().accept(this) || expr.getRightSet().accept(this);
	}

	@Override
	public Boolean visitNot(ExprNotPlan expr) {
		return expr.getExpr().accept(this);
	}

	@Override
	public Boolean visitDesigParameter(DesigParamPlan param) {
		return true;
	}
}
