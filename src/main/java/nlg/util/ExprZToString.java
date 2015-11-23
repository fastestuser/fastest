package nlg.util;

import java.util.Iterator;

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
 * Convierte a string una ExprZ
 */
public class ExprZToString implements ExprZVisitor<String> {

	@Override
	public String visitExprApply(ExprApply expr) {
		return expr.getFunction().accept(this) + " " + expr.getArgument().accept(this);
	}

	@Override
	public String visitExprDom(ExprDom expr) {
		return "\\dom " + expr.getFunction().accept(this);
	}

	@Override
	public String visitExprEq(ExprEq expr) {
		return expr.getLeftExpr().accept(this) + " = " + expr.getRightExpr().accept(this);
	}

	@Override
	public String visitExprIn(ExprIn expr) {
		return expr.getElement().accept(this) + " \\in " + expr.getSet().accept(this);
	}

	@Override
	public String visitExprIntersection(ExprIntersection expr) {
		return expr.getLeftSet().accept(this) + " \\cap " + expr.getRightSet().accept(this);
	}

	@Override
	public String visitExprMapsTo(ExprMapsTo expr) {
		return expr.getLeft().accept(this) + " \\mapsto " + expr.getRight().accept(this);
	}

	@Override
	public String visitExprRefExpr(ExprRef expr) {
		return expr.getName();
	}

	@Override
	public String visitExprNotEq(ExprNotEq expr) {
		return expr.getLeftExpr().accept(this) + " \\neq " + expr.getRightExpr().accept(this);
	}

	@Override
	public String visitExprNotIn(ExprNotIn expr) {
		return expr.getElement().accept(this) + " \\notin " + expr.getSet().accept(this);
	}

	@Override
	public String visitExprRan(ExprRan expr) {
		return "\\ran " + expr.getFunction().accept(this);
	}

	@Override
	public String visitExprSet(ExprSet expr) {
		String ret = "{";
		Iterator<ExprZ> it = expr.getElements().iterator();
		
		if (it.hasNext()) {
			ret += it.next().accept(this);
		}
		
		while (it.hasNext()) {
			ret += ", " + it.next().accept(this);
		}
		
		ret += "}"; 
		
		return ret;
	}

	@Override
	public String visitExprSubSetEq(ExprSubSetEq expr) {
		return expr.getLeftSet().accept(this) + " \\subseteq " + expr.getRightSet().accept(this);
	}

	@Override
	public String visitExprSubSet(ExprSubSet expr) {
		return expr.getLeftSet().accept(this) + " \\subset " + expr.getRightSet().accept(this);
	}

	@Override
	public String visitExprUnion(ExprUnion expr) {
		return expr.getLeftSet().accept(this) + " \\cup " + expr.getRightSet().accept(this);
	}

	@Override
	public String visitNot(ExprNot expr) {
		return "\\neg " + expr.getExpr().accept(this);
	}

}
