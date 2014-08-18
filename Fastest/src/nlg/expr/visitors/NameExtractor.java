package nlg.expr.visitors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
 * Devuelve una lista con todos los "nombres" (ExprNamePlan) 
 * que aparecen dentro de de una expresion ExprDescPlan.
 */
public class NameExtractor implements VisitorExprDescPlan<List<String>> {

	@Override
	public List<String> visitExprApply(ExprApplyPlan expr) {
		List<String> ret = new ArrayList<String>();
		ret.addAll(expr.getFunction().accept(this));
		ret.addAll(expr.getArgument().accept(this));
		return ret;
	}

	@Override
	public List<String> visitExprDom(ExprDomPlan expr) {
		List<String> ret = new ArrayList<String>();
		ret.addAll(expr.getFunction().accept(this));
		return ret;
	}

	@Override
	public List<String> visitExprEq(ExprEqPlan expr) {
		List<String> ret = new ArrayList<String>();
		ret.addAll(expr.getLeftExpr().accept(this));
		ret.addAll(expr.getRightExpr().accept(this));
		return ret;
	}

	@Override
	public List<String> visitExprIn(ExprInPlan expr) {
		List<String> ret = new ArrayList<String>();
		ret.addAll(expr.getElement().accept(this));
		ret.addAll(expr.getSet().accept(this));
		return ret;
	}

	@Override
	public List<String> visitExprIntersection(ExprIntersectionPlan expr) {
		List<String> ret = new ArrayList<String>();
		ret.addAll(expr.getLeftSet().accept(this));
		ret.addAll(expr.getRightSet().accept(this));
		return ret;
	}

	@Override
	public List<String> visitExprMapsTo(ExprMapsToPlan expr) {
		List<String> ret = new ArrayList<String>();
		ret.addAll(expr.getLeft().accept(this));
		ret.addAll(expr.getRight().accept(this));
		return ret;
	}

	@Override
	public List<String> visitExprName(ExprNamePlan expr) {
		return Arrays.asList(expr.getName());
	}

	@Override
	public List<String> visitExprNotEq(ExprNotEqPlan expr) {
		List<String> ret = new ArrayList<String>();
		ret.addAll(expr.getLeftExpr().accept(this));
		ret.addAll(expr.getRightExpr().accept(this));
		return ret;
	}

	@Override
	public List<String> visitExprNotIn(ExprNotInPlan expr) {
		List<String> ret = new ArrayList<String>();
		ret.addAll(expr.getElement().accept(this));
		ret.addAll(expr.getSet().accept(this));
		return ret;
	}

	@Override
	public List<String> visitExprRan(ExprRanPlan expr) {
		List<String> ret = new ArrayList<String>();
		ret.addAll(expr.getFunction().accept(this));
		return ret;
	}

	@Override
	public List<String> visitExprSet(ExprSetPlan expr) {
		List<String> ret = new ArrayList<String>();
		for (ExprDescPlan e : expr.getElements()) {
			ret.addAll(e.accept(this));
		}
		return ret;
	}

	@Override
	public List<String> visitExprSubSetEq(ExprSubSetEqPlan expr) {
		List<String> ret = new ArrayList<String>();
		ret.addAll(expr.getLeftSet().accept(this));
		ret.addAll(expr.getRightSet().accept(this));
		return ret;
	}

	@Override
	public List<String> visitExprSubSet(ExprSubSetPlan expr) {
		List<String> ret = new ArrayList<String>();
		ret.addAll(expr.getLeftSet().accept(this));
		ret.addAll(expr.getRightSet().accept(this));
		return ret;
	}

	@Override
	public List<String> visitExprUnion(ExprUnionPlan expr) {
		List<String> ret = new ArrayList<String>();
		ret.addAll(expr.getLeftSet().accept(this));
		ret.addAll(expr.getRightSet().accept(this));
		return ret;
	}

	@Override
	public List<String> visitNot(ExprNotPlan expr) {
		List<String> ret = new ArrayList<String>();
		ret.addAll(expr.getExpr().accept(this));
		return ret;
	}

	@Override
	public List<String> visitDesigParameter(DesigParamPlan param) {
		return Arrays.asList(param.getVarName());
	}

}
