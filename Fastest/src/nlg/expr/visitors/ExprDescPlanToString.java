package nlg.expr.visitors;

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
 * Visitor para imprimir una ExprDescPlan
 * formateada en forma de arbol.
 */
public class ExprDescPlanToString implements VisitorExprDescPlan<String> {

	@Override
	public String visitExprApply(ExprApplyPlan expr) {
		return "ExprApply \n"
				+ "  |_ " + insetTabs(expr.getFunction().accept(this)) + "\n"
				+ "  |_ " + insetTabs(expr.getArgument().accept(this));
	}

	@Override
	public String visitExprDom(ExprDomPlan expr) {
		return "ExprDom \n"
				+ "  |_ " + insetTabs(expr.getFunction().accept(this)) + "\n"
				+ "  |_ " + insetTabs(expr.getFunction().accept(this));
	}

	@Override
	public String visitExprEq(ExprEqPlan expr) {
		return "ExprEq \n"
				+ "  |_ " + insetTabs(expr.getLeftExpr().accept(this)) + "\n"
				+ "  |_ " + insetTabs(expr.getRightExpr().accept(this));
	}

	@Override
	public String visitExprIn(ExprInPlan expr) {
		return "ExprIn \n"
				+ "  |_ " + insetTabs(expr.getElement().accept(this)) + "\n"
				+ "  |_ " + insetTabs(expr.getSet().accept(this));
	}

	@Override
	public String visitExprIntersection(ExprIntersectionPlan expr) {
		return "ExprIntersection \n"
				+ "  |_ " + insetTabs(expr.getLeftSet().accept(this)) + "\n"
				+ "  |_ " + insetTabs(expr.getRightSet().accept(this));
	}

	@Override
	public String visitExprMapsTo(ExprMapsToPlan expr) {
		return "ExprMapsTo \n"
				+ "  |_ " + insetTabs(expr.getLeft().accept(this)) + "\n"
				+ "  |_ " + insetTabs(expr.getRight().accept(this));
	}

	@Override
	public String visitExprName(ExprNamePlan expr) {
		return "ExprName " + expr.getName();
	}

	@Override
	public String visitExprNotEq(ExprNotEqPlan expr) {
		return "ExprNotEq \n"
				+ "  |_ " + insetTabs(expr.getLeftExpr().accept(this)) + "\n"
				+ "  |_ " + insetTabs(expr.getRightExpr().accept(this));
	}

	@Override
	public String visitExprNotIn(ExprNotInPlan expr) {
		return "ExprNotIn \n"
				+ "  |_ " + insetTabs(expr.getElement().accept(this)) + "\n"
				+ "  |_ " + insetTabs(expr.getSet().accept(this));
	}

	@Override
	public String visitExprRan(ExprRanPlan expr) {
		return "ExprRan \n"
				+ "  |_ " + insetTabs(expr.getFunction().accept(this));
	}

	@Override
	public String visitExprSet(ExprSetPlan expr) {
		String ret = "ExprSet ";
		if (expr.getElements().isEmpty()) {
			ret += "{ }";
		} else {
			for (ExprDescPlan exp : expr.getElements()) {
				ret += "\n  |_ " + insetTabs(exp.accept(this));
			}
		}
				
		return ret;		
	}

	@Override
	public String visitExprSubSetEq(ExprSubSetEqPlan expr) {
		return "ExprSubSetEq \n"
				+ "  |_ " + insetTabs(expr.getLeftSet().accept(this)) + "\n"
				+ "  |_ " + insetTabs(expr.getRightSet().accept(this));
	}

	@Override
	public String visitExprSubSet(ExprSubSetPlan expr) {
		return "ExprSubSet \n"
				+ "  |_ " + insetTabs(expr.getLeftSet().accept(this)) + "\n"
				+ "  |_ " + insetTabs(expr.getRightSet().accept(this));
	}

	@Override
	public String visitExprUnion(ExprUnionPlan expr) {
		return "ExprUnion \n"
				+ "  |_ " + insetTabs(expr.getLeftSet().accept(this)) + "\n"
				+ "  |_ " + insetTabs(expr.getRightSet().accept(this));
	}

	@Override
	public String visitNot(ExprNotPlan expr) {
		return "ExprNot \n"
				+ "  |_ " + insetTabs(expr.getExpr().accept(this));
	}
	
	@Override
	public String visitDesigParameter(DesigParamPlan param) {
		return "DesigParameter " + param.getVarName();
	}
	
	private String insetTabs(String string) {
		return string.replaceAll("\\|", "  |");
	}
}
