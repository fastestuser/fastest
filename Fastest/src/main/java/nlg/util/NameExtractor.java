package nlg.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import nlg.base.expression.ExprApply;
import nlg.base.expression.ExprDom;
import nlg.base.expression.ExprEq;
import nlg.base.expression.ExprIn;
import nlg.base.expression.ExprIntersection;
import nlg.base.expression.ExprMapsTo;
import nlg.base.expression.ExprNot;
import nlg.base.expression.ExprNotEq;
import nlg.base.expression.ExprNotIn;
import nlg.base.expression.ExprRan;
import nlg.base.expression.ExprRef;
import nlg.base.expression.ExprSet;
import nlg.base.expression.ExprSubSet;
import nlg.base.expression.ExprSubSetEq;
import nlg.base.expression.ExprUnion;
import nlg.base.expression.ExprZ;
import nlg.base.expression.ExprZVisitor;

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
	public List<String> visitExprRefExpr(ExprRef expr) {
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
