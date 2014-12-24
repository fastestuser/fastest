package nlg.util;

import nlg.base.expr.ExprApply;
import nlg.base.expr.ExprDom;
import nlg.base.expr.ExprEq;
import nlg.base.expr.ExprIn;
import nlg.base.expr.ExprIntersection;
import nlg.base.expr.ExprMapsTo;
import nlg.base.expr.ExprNot;
import nlg.base.expr.ExprNotEq;
import nlg.base.expr.ExprNotIn;
import nlg.base.expr.ExprRan;
import nlg.base.expr.ExprRef;
import nlg.base.expr.ExprSet;
import nlg.base.expr.ExprSubSet;
import nlg.base.expr.ExprSubSetEq;
import nlg.base.expr.ExprUnion;
import nlg.base.expr.ExprZ;
import nlg.base.expr.ExprZVisitor;

/**
 * Visitor para imprimir una ExprZ
 * formateada en forma de arbol.
 */
public class ExprZToString implements ExprZVisitor<String> {

	@Override
	public String visitExprApply(ExprApply expr) {
		return "ExprApply \n"
				+ "  |_ " + insetTabs(expr.getFunction().accept(this)) + "\n"
				+ "  |_ " + insetTabs(expr.getArgument().accept(this));
	}

	@Override
	public String visitExprDom(ExprDom expr) {
		return "ExprDom \n"
				+ "  |_ " + insetTabs(expr.getFunction().accept(this));
	}

	@Override
	public String visitExprEq(ExprEq expr) {
		return "ExprEq \n"
				+ "  |_ " + insetTabs(expr.getLeftExpr().accept(this)) + "\n"
				+ "  |_ " + insetTabs(expr.getRightExpr().accept(this));
	}

	@Override
	public String visitExprIn(ExprIn expr) {
		return "ExprIn \n"
				+ "  |_ " + insetTabs(expr.getElement().accept(this)) + "\n"
				+ "  |_ " + insetTabs(expr.getSet().accept(this));
	}

	@Override
	public String visitExprIntersection(ExprIntersection expr) {
		return "ExprIntersection \n"
				+ "  |_ " + insetTabs(expr.getLeftSet().accept(this)) + "\n"
				+ "  |_ " + insetTabs(expr.getRightSet().accept(this));
	}

	@Override
	public String visitExprMapsTo(ExprMapsTo expr) {
		return "ExprMapsTo \n"
				+ "  |_ " + insetTabs(expr.getLeft().accept(this)) + "\n"
				+ "  |_ " + insetTabs(expr.getRight().accept(this));
	}

	@Override
	public String visitExprRefExpr(ExprRef expr) {
		return "ExprName " + expr.getName();
	}

	@Override
	public String visitExprNotEq(ExprNotEq expr) {
		return "ExprNotEq \n"
				+ "  |_ " + insetTabs(expr.getLeftExpr().accept(this)) + "\n"
				+ "  |_ " + insetTabs(expr.getRightExpr().accept(this));
	}

	@Override
	public String visitExprNotIn(ExprNotIn expr) {
		return "ExprNotIn \n"
				+ "  |_ " + insetTabs(expr.getElement().accept(this)) + "\n"
				+ "  |_ " + insetTabs(expr.getSet().accept(this));
	}

	@Override
	public String visitExprRan(ExprRan expr) {
		return "ExprRan \n"
				+ "  |_ " + insetTabs(expr.getFunction().accept(this));
	}

	@Override
	public String visitExprSet(ExprSet expr) {
		String ret = "ExprSet ";
		if (expr.getElements().isEmpty()) {
			ret += "{ }";
		} else {
			for (ExprZ exp : expr.getElements()) {
				ret += "\n  |_ " + insetTabs(exp.accept(this));
			}
		}
				
		return ret;		
	}

	@Override
	public String visitExprSubSetEq(ExprSubSetEq expr) {
		return "ExprSubSetEq \n"
				+ "  |_ " + insetTabs(expr.getLeftSet().accept(this)) + "\n"
				+ "  |_ " + insetTabs(expr.getRightSet().accept(this));
	}

	@Override
	public String visitExprSubSet(ExprSubSet expr) {
		return "ExprSubSet \n"
				+ "  |_ " + insetTabs(expr.getLeftSet().accept(this)) + "\n"
				+ "  |_ " + insetTabs(expr.getRightSet().accept(this));
	}

	@Override
	public String visitExprUnion(ExprUnion expr) {
		return "ExprUnion \n"
				+ "  |_ " + insetTabs(expr.getLeftSet().accept(this)) + "\n"
				+ "  |_ " + insetTabs(expr.getRightSet().accept(this));
	}

	@Override
	public String visitNot(ExprNot expr) {
		return "ExprNot \n"
				+ "  |_ " + insetTabs(expr.getExpr().accept(this));
	}
	
	private String insetTabs(String string) {
		return string.replaceAll("\\|", "  |");
	}
}
