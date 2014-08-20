package nlg.expr.visitors;

import nlg.expr.base.ExprApplyPlan;
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
 * Visitor para operar sobre la estructura de las expresiones ExprDescPlan
 */
public interface ExprDescPlanVisitor<X> {
	public X visitExprApply(ExprApplyPlan expr);
	public X visitExprDom(ExprDomPlan expr);
	public X visitExprEq(ExprEqPlan expr);
	public X visitExprIn(ExprInPlan expr);
	public X visitExprIntersection(ExprIntersectionPlan expr);
	public X visitExprMapsTo(ExprMapsToPlan expr);
	public X visitExprName(ExprNamePlan expr);
	public X visitExprNotEq(ExprNotEqPlan expr);
	public X visitExprNotIn(ExprNotInPlan expr);
	public X visitExprRan(ExprRanPlan expr);
	public X visitExprSet(ExprSetPlan expr);
	public X visitExprSubSetEq(ExprSubSetEqPlan expr);
	public X visitExprSubSet(ExprSubSetPlan expr);
	public X visitExprUnion(ExprUnionPlan expr);
	public X visitNot(ExprNotPlan expr);
}
