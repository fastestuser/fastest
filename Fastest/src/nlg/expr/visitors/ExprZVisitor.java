package nlg.expr.visitors;

import nlg.expr.base.ExprApply;
import nlg.expr.base.ExprDom;
import nlg.expr.base.ExprEq;
import nlg.expr.base.ExprIn;
import nlg.expr.base.ExprIntersection;
import nlg.expr.base.ExprMapsTo;
import nlg.expr.base.ExprRef;
import nlg.expr.base.ExprNotEq;
import nlg.expr.base.ExprNotIn;
import nlg.expr.base.ExprNot;
import nlg.expr.base.ExprRan;
import nlg.expr.base.ExprSet;
import nlg.expr.base.ExprSubSetEq;
import nlg.expr.base.ExprSubSet;
import nlg.expr.base.ExprUnion;

/**
 * Visitor para operar sobre la estructura de las expresiones ExprZ
 */
public interface ExprZVisitor<X> {
	public X visitExprApply(ExprApply expr);
	public X visitExprDom(ExprDom expr);
	public X visitExprEq(ExprEq expr);
	public X visitExprIn(ExprIn expr);
	public X visitExprIntersection(ExprIntersection expr);
	public X visitExprMapsTo(ExprMapsTo expr);
	public X visitExprRefExpr(ExprRef expr);
	public X visitExprNotEq(ExprNotEq expr);
	public X visitExprNotIn(ExprNotIn expr);
	public X visitExprRan(ExprRan expr);
	public X visitExprSet(ExprSet expr);
	public X visitExprSubSetEq(ExprSubSetEq expr);
	public X visitExprSubSet(ExprSubSet expr);
	public X visitExprUnion(ExprUnion expr);
	public X visitNot(ExprNot expr);
}
