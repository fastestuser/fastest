package nlg.expr.visitors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import nlg.expr.base.ExprApply;
import nlg.expr.base.ExprZ;
import nlg.expr.base.ExprDom;
import nlg.expr.base.ExprEq;
import nlg.expr.base.ExprIn;
import nlg.expr.base.ExprIntersection;
import nlg.expr.base.ExprMapsTo;
import nlg.expr.base.ExprName;
import nlg.expr.base.ExprNotEq;
import nlg.expr.base.ExprNotIn;
import nlg.expr.base.ExprNot;
import nlg.expr.base.ExprRan;
import nlg.expr.base.ExprSet;
import nlg.expr.base.ExprSubSetEq;
import nlg.expr.base.ExprSubSet;
import nlg.expr.base.ExprUnion;

/**
 * Devuelve una lista con todos los "nombres" (ExprNamePlan) 
 * que aparecen dentro de de una expresion ExprDescPlan.
 */
public class NameExtractor implements ExprZVisitor<List<String>> {

	@Override
	public List<String> visitExprApply(ExprApply expr) {
		List<String> ret = new ArrayList<String>();
		ret.addAll(expr.getFunction().accept(this));
		ret.addAll(expr.getArgument().accept(this));
		return ret;
	}

	@Override
	public List<String> visitExprDom(ExprDom expr) {
		List<String> ret = new ArrayList<String>();
		ret.addAll(expr.getFunction().accept(this));
		return ret;
	}

	@Override
	public List<String> visitExprEq(ExprEq expr) {
		List<String> ret = new ArrayList<String>();
		ret.addAll(expr.getLeftExpr().accept(this));
		ret.addAll(expr.getRightExpr().accept(this));
		return ret;
	}

	@Override
	public List<String> visitExprIn(ExprIn expr) {
		List<String> ret = new ArrayList<String>();
		ret.addAll(expr.getElement().accept(this));
		ret.addAll(expr.getSet().accept(this));
		return ret;
	}

	@Override
	public List<String> visitExprIntersection(ExprIntersection expr) {
		List<String> ret = new ArrayList<String>();
		ret.addAll(expr.getLeftSet().accept(this));
		ret.addAll(expr.getRightSet().accept(this));
		return ret;
	}

	@Override
	public List<String> visitExprMapsTo(ExprMapsTo expr) {
		List<String> ret = new ArrayList<String>();
		ret.addAll(expr.getLeft().accept(this));
		ret.addAll(expr.getRight().accept(this));
		return ret;
	}

	@Override
	public List<String> visitExprName(ExprName expr) {
		return Arrays.asList(expr.getName());
	}

	@Override
	public List<String> visitExprNotEq(ExprNotEq expr) {
		List<String> ret = new ArrayList<String>();
		ret.addAll(expr.getLeftExpr().accept(this));
		ret.addAll(expr.getRightExpr().accept(this));
		return ret;
	}

	@Override
	public List<String> visitExprNotIn(ExprNotIn expr) {
		List<String> ret = new ArrayList<String>();
		ret.addAll(expr.getElement().accept(this));
		ret.addAll(expr.getSet().accept(this));
		return ret;
	}

	@Override
	public List<String> visitExprRan(ExprRan expr) {
		List<String> ret = new ArrayList<String>();
		ret.addAll(expr.getFunction().accept(this));
		return ret;
	}

	@Override
	public List<String> visitExprSet(ExprSet expr) {
		List<String> ret = new ArrayList<String>();
		for (ExprZ e : expr.getElements()) {
			ret.addAll(e.accept(this));
		}
		return ret;
	}

	@Override
	public List<String> visitExprSubSetEq(ExprSubSetEq expr) {
		List<String> ret = new ArrayList<String>();
		ret.addAll(expr.getLeftSet().accept(this));
		ret.addAll(expr.getRightSet().accept(this));
		return ret;
	}

	@Override
	public List<String> visitExprSubSet(ExprSubSet expr) {
		List<String> ret = new ArrayList<String>();
		ret.addAll(expr.getLeftSet().accept(this));
		ret.addAll(expr.getRightSet().accept(this));
		return ret;
	}

	@Override
	public List<String> visitExprUnion(ExprUnion expr) {
		List<String> ret = new ArrayList<String>();
		ret.addAll(expr.getLeftSet().accept(this));
		ret.addAll(expr.getRightSet().accept(this));
		return ret;
	}

	@Override
	public List<String> visitNot(ExprNot expr) {
		List<String> ret = new ArrayList<String>();
		ret.addAll(expr.getExpr().accept(this));
		return ret;
	}

}
