package nlg.base.expression.matching;

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
import nlg.base.expression.ExprZVisitor;

/**
 * Verifica si se trata de un conjunto con mas de un elemento
 */
public class MatcherExprZSet implements ExprZVisitor<Boolean> {

	@Override
	public Boolean visitExprApply(ExprApply expr) {
		return false;
	}

	@Override
	public Boolean visitExprDom(ExprDom expr) {
		return false;
	}

	@Override
	public Boolean visitExprEq(ExprEq expr) {
		return false;
	}

	@Override
	public Boolean visitExprIn(ExprIn expr) {
		return false;
	}

	@Override
	public Boolean visitExprIntersection(ExprIntersection expr) {
		return false;
	}

	@Override
	public Boolean visitExprMapsTo(ExprMapsTo expr) {
		return false;
	}

	@Override
	public Boolean visitExprRefExpr(ExprRef expr) {
		return false;
	}

	@Override
	public Boolean visitExprNotEq(ExprNotEq expr) {
		return false;
	}

	@Override
	public Boolean visitExprNotIn(ExprNotIn expr) {
		return false;
	}

	@Override
	public Boolean visitExprRan(ExprRan expr) {
		return false;
	}

	@Override
	public Boolean visitExprSet(ExprSet expr) {
		if (expr.getElements().size() > 1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Boolean visitExprSubSetEq(ExprSubSetEq expr) {
		return false;
	}

	@Override
	public Boolean visitExprSubSet(ExprSubSet expr) {
		return false;
	}

	@Override
	public Boolean visitExprUnion(ExprUnion expr) {
		return false;
	}

	@Override
	public Boolean visitNot(ExprNot expr) {
		return false;
	}

}
