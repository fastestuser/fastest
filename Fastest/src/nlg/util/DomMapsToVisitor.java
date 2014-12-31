package nlg.util;

import java.util.ArrayList;
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
 * Busca y reduce expresiones del tipo dom { x -> y }
 *
 */
public class DomMapsToVisitor implements ExprZVisitor<ExprZ> {

	@Override
	public ExprZ visitExprApply(ExprApply expr) {
		return new ExprApply(expr.getFunction().accept(this), expr.getArgument().accept(this));
	}

	@Override
	public ExprZ visitExprDom(ExprDom expr) {
		if (expr.getFunction() instanceof ExprSet) {
			List<ExprZ> elements = ((ExprSet) expr.getFunction()).getElements();
			if (null != elements && !elements.isEmpty() &&
					elements.get(0) instanceof ExprMapsTo) {
				return ((ExprMapsTo) elements.get(0)).getLeft();
			}
		}
			
		return new ExprDom(expr.getFunction().accept(this));
	}

	@Override
	public ExprZ visitExprEq(ExprEq expr) {
		return new ExprEq(expr.getLeftExpr().accept(this), expr.getRightExpr().accept(this));
	}

	@Override
	public ExprZ visitExprIn(ExprIn expr) {
		return new ExprIn(expr.getElement().accept(this), expr.getSet().accept(this));
	}

	@Override
	public ExprZ visitExprIntersection(ExprIntersection expr) {
		return new ExprIntersection(expr.getLeftSet().accept(this), expr.getRightSet().accept(this));
	}

	@Override
	public ExprZ visitExprMapsTo(ExprMapsTo expr) {
		return new ExprMapsTo(expr.getLeft().accept(this), expr.getRight().accept(this));
	}

	@Override
	public ExprZ visitExprRefExpr(ExprRef expr) {
		return expr;
	}

	@Override
	public ExprZ visitExprNotEq(ExprNotEq expr) {
		return new ExprNotEq(expr.getLeftExpr().accept(this), expr.getRightExpr().accept(this));
	}

	@Override
	public ExprZ visitExprNotIn(ExprNotIn expr) {
		return new ExprNotIn(expr.getElement().accept(this), expr.getSet().accept(this));
	}

	@Override
	public ExprZ visitExprRan(ExprRan expr) {
		return new ExprRan(expr.getFunction().accept(this));
	}

	@Override
	public ExprZ visitExprSet(ExprSet expr) {
		List<ExprZ> elements = new ArrayList<ExprZ>();
		for (ExprZ e : expr.getElements()) {
			elements.add(e.accept(this));
		}
		return new ExprSet(elements);
	}

	@Override
	public ExprZ visitExprSubSetEq(ExprSubSetEq expr) {
		return new ExprSubSetEq(expr.getLeftSet().accept(this), expr.getRightSet().accept(this));
	}

	@Override
	public ExprZ visitExprSubSet(ExprSubSet expr) {
		return new ExprSubSetEq(expr.getLeftSet().accept(this), expr.getRightSet().accept(this));
	}

	@Override
	public ExprZ visitExprUnion(ExprUnion expr) {
		return new ExprSubSetEq(expr.getLeftSet().accept(this), expr.getRightSet().accept(this));
	}

	@Override
	public ExprZ visitNot(ExprNot expr) {
		return new ExprNot(expr.getExpr().accept(this));
	}

}
