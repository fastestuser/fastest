package nlg.base.expression;


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
