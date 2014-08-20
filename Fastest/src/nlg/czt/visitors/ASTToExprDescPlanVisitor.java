package nlg.czt.visitors;

import java.util.ArrayList;
import java.util.List;

import net.sourceforge.czt.base.ast.Term;
import net.sourceforge.czt.base.visitor.TermVisitor;
import net.sourceforge.czt.z.ast.ApplExpr;
import net.sourceforge.czt.z.ast.Expr;
import net.sourceforge.czt.z.ast.ExprPred;
import net.sourceforge.czt.z.ast.MemPred;
import net.sourceforge.czt.z.ast.NegPred;
import net.sourceforge.czt.z.ast.RefExpr;
import net.sourceforge.czt.z.ast.SetExpr;
import net.sourceforge.czt.z.ast.TupleExpr;
import net.sourceforge.czt.z.ast.ZExprList;
import net.sourceforge.czt.z.visitor.ApplExprVisitor;
import net.sourceforge.czt.z.visitor.ExprPredVisitor;
import net.sourceforge.czt.z.visitor.MemPredVisitor;
import net.sourceforge.czt.z.visitor.NegPredVisitor;
import net.sourceforge.czt.z.visitor.RefExprVisitor;
import net.sourceforge.czt.z.visitor.SetExprVisitor;
import nlg.expr.base.ExprApplyPlan;
import nlg.expr.base.ExprEqPlan;
import nlg.expr.base.ExprInPlan;
import nlg.expr.base.ExprIntersectionPlan;
import nlg.expr.base.ExprMapsToPlan;
import nlg.expr.base.ExprNamePlan;
import nlg.expr.base.ExprNotPlan;
import nlg.expr.base.ExprNotEqPlan;
import nlg.expr.base.ExprNotInPlan;
import nlg.expr.base.ExprSetPlan;
import nlg.expr.base.ExprSubSetPlan;
import nlg.expr.base.ExprSubSetEqPlan;
import nlg.expr.base.ExprUnionPlan;
import nlg.expr.base.ExprDescPlan;
import common.z.SpecUtils;
import common.z.UtilSymbols;

/**
 * Construye expresion ExprDescPlan a partir de arbol AST (czt)
 */
public class ASTToExprDescPlanVisitor implements  
MemPredVisitor<ExprDescPlan>,
RefExprVisitor<ExprDescPlan>, 
ApplExprVisitor<ExprDescPlan>,
SetExprVisitor<ExprDescPlan>,
NegPredVisitor<ExprDescPlan>,
ExprPredVisitor<ExprDescPlan>,
TermVisitor<ExprDescPlan> {


	// Default: expresion no soportada!
	@Override
	public ExprDescPlan visitTerm(Term arg0) {
		System.out.println("expresion no soportada: " + SpecUtils.termToLatex(arg0) + "\n");
		return null;
	}

	@Override
	public ExprDescPlan visitMemPred(MemPred arg0) {
		ExprDescPlan ret = null;

		Expr leftExpr = arg0.getLeftExpr();
		Expr rightExpr = arg0.getRightExpr();
		boolean mixfix = arg0.getMixfix();

		if (!mixfix) {	// se trata de un pertenece

			ExprDescPlan lexp = leftExpr.accept(this);
			ExprDescPlan rexp = rightExpr.accept(this);

			if (null != lexp || null != rexp) {
				ret = new ExprInPlan(lexp, rexp);
			}

		} else { 		

			if(rightExpr instanceof SetExpr){	// se trata de una igualdad ?

				SetExpr auxSet = (SetExpr) rightExpr;
				ZExprList zList = auxSet.getZExprList();
				if(zList.size()==1) {

					ExprDescPlan lexp = leftExpr.accept(this);
					ExprDescPlan rexp = zList.get(0).accept(this);


					if (null != lexp || null != rexp) {
						ret = new ExprEqPlan(lexp, rexp);
					}

				}

			} else if (rightExpr instanceof RefExpr) {

				RefExpr refExpr = (RefExpr) rightExpr;
				String opName = refExpr.getName().toString();

				TupleExpr tuple = (TupleExpr) leftExpr;
				Object[] opArguments = tuple.getZExprList().getChildren();

				// Describo recursivamente los hijos
				ExprDescPlan lexp = ((Expr) opArguments[0]).accept(this);
				ExprDescPlan rexp = ((Expr) opArguments[1]).accept(this);

				if (opName.equals(UtilSymbols.notInSymbol())) {					// ∉ - Non-membership symbol
					if (null != lexp || null != rexp) {
						ret = new ExprNotInPlan(lexp, rexp);
					}
				} else if (opName.equals(UtilSymbols.neqSymbol())) {			// ≠ - Unequality  symbol
					if (null != lexp || null != rexp) {
						ret = new ExprNotEqPlan(lexp, rexp);
					}
				} else if (opName.equals(UtilSymbols.lessThanSymbol())) {		// < - Less symbol
					System.out.println("expresion no soportada: " + SpecUtils.termToLatex(arg0));
				} else if (opName.equals(UtilSymbols.leqSymbol())) {			// ≤ - Less or equal symbol
					System.out.println("expresion no soportada: " + SpecUtils.termToLatex(arg0));
				} else if (opName.equals(UtilSymbols.gecSymbol())) {			// ≥ - Greater or equal symbol
					System.out.println("expresion no soportada: " + SpecUtils.termToLatex(arg0));
				} else if (opName.equals(UtilSymbols.greaterThanSymbol())) {	// > - Greater symbol
					System.out.println("expresion no soportada: " + SpecUtils.termToLatex(arg0));
				} else if (opName.equals(UtilSymbols.subsetSymbol())) {			// ⊂ - Subset symbol
					if (null != lexp || null != rexp) {
						ret = new ExprSubSetPlan(lexp, rexp);
					}
				} else if (opName.equals(UtilSymbols.subseteqSymbol())) {		// ⊆ - Subseteq symbol
					if (null != lexp || null != rexp) {
						ret = new ExprSubSetEqPlan(lexp, rexp);
					}
				} else {
					System.out.println("unhandled RefExpr");
				}
			}
		}

		return ret;
	}

	@Override
	public ExprDescPlan visitApplExpr(ApplExpr arg0) {
		boolean mixfix = arg0.getMixfix();
		Expr leftExpr = arg0.getLeftExpr();
		Expr rightExpr = arg0.getRightExpr();

		ExprDescPlan ret = null;

		if (mixfix) {

			if (leftExpr instanceof RefExpr) {
				String name = ((RefExpr) arg0.getLeftExpr()).getName().toString();

				Expr rExpr = arg0.getRightExpr();

				// Por ahora solo contemplo \mapsto, \cap y \cup
				if (rExpr instanceof TupleExpr && ((TupleExpr) rExpr).getZExprList().size() == 2) {
					Expr left = ((TupleExpr) rExpr).getZExprList().get(0);
					Expr right = ((TupleExpr) rExpr).getZExprList().get(1);

					// proceso recursivamente los hijos
					ExprDescPlan lexp = left.accept(this);
					ExprDescPlan rexp = right.accept(this);

					if (null != lexp || null != rexp) {
						if (name.equals(UtilSymbols.mapletSymbol())) {				// ↦ - MapsTo symbol
							ret = new ExprMapsToPlan(lexp, rexp);
						} else if (name.equals(UtilSymbols.intersectionSymbol())) {	// ⋂ - Intersection symbol
							ret = new ExprIntersectionPlan(lexp, rexp);
						} else if (name.equals(UtilSymbols.unionSymbol())) {		// ⋃ - Union symbol
							ret = new ExprUnionPlan(lexp, rexp);
						}
					}
				} else {
					System.out.println("expresion no soportada: " + SpecUtils.termToLatex(arg0));
				}
			} else {
				System.out.println("expresion no soportada: " + SpecUtils.termToLatex(arg0));
			}
		} else {		
			// Describo recursivamente los hijos
			ExprDescPlan lexp = leftExpr.accept(this);
			ExprDescPlan rexp = rightExpr.accept(this);

			if (null != lexp || null != rexp) {
				ret = new ExprApplyPlan(lexp, rexp);
			}
		}


		return ret;
	}

	@Override
	public ExprDescPlan visitRefExpr(RefExpr arg0) {
		return new ExprNamePlan(arg0.getZName().toString());
	}

	@Override
	public ExprDescPlan visitSetExpr(SetExpr arg0) {
		List<ExprDescPlan> list = new ArrayList<ExprDescPlan>();
		for (Expr exp : arg0.getZExprList()) {
			list.add(exp.accept(this));
		}

		return new ExprSetPlan(list);
	}

	@Override
	public ExprDescPlan visitNegPred(NegPred arg0) {
		return new ExprNotPlan(arg0.getPred().accept(this));
	}

	@Override
	public ExprDescPlan visitExprPred(ExprPred arg0) {
		return arg0.getExpr().accept(this);
	}

}
