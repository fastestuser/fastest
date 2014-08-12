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
import nlg.expr.base.ExprApply;
import nlg.expr.base.ExprEq;
import nlg.expr.base.ExprIn;
import nlg.expr.base.ExprIntersection;
import nlg.expr.base.ExprMapsTo;
import nlg.expr.base.ExprName;
import nlg.expr.base.ExprNot;
import nlg.expr.base.ExprNotEq;
import nlg.expr.base.ExprNotIn;
import nlg.expr.base.ExprSet;
import nlg.expr.base.ExprSubSet;
import nlg.expr.base.ExprSubSetEq;
import nlg.expr.base.ExprUnion;
import nlg.expr.base.ExprZ;
import common.z.SpecUtils;
import common.z.UtilSymbols;

/**
 * Construye expresion ExprZ a partir de arbol AST (czt)
 */
public class ASTToExprZVisitor implements  
MemPredVisitor<ExprZ>,
RefExprVisitor<ExprZ>, 
ApplExprVisitor<ExprZ>,
SetExprVisitor<ExprZ>,
NegPredVisitor<ExprZ>,
ExprPredVisitor<ExprZ>,
TermVisitor<ExprZ> {


	// Default: expresion no soportada!
	@Override
	public ExprZ visitTerm(Term arg0) {
		System.out.println("expresion no soportada: " + SpecUtils.termToLatex(arg0));
		return null;
	}

	@Override
	public ExprZ visitMemPred(MemPred arg0) {
		ExprZ ret = null;

		Expr leftExpr = arg0.getLeftExpr();
		Expr rightExpr = arg0.getRightExpr();
		boolean mixfix = arg0.getMixfix();

		if (!mixfix) {	// se trata de un pertenece

			ExprZ lexp = leftExpr.accept(this);
			ExprZ rexp = rightExpr.accept(this);

			if (null != lexp || null != rexp) {
				ret = new ExprIn(lexp, rexp);
			}

		} else { 		

			if(rightExpr instanceof SetExpr){	// se trata de una igualdad ?

				SetExpr auxSet = (SetExpr) rightExpr;
				ZExprList zList = auxSet.getZExprList();
				if(zList.size()==1) {

					ExprZ lexp = leftExpr.accept(this);
					ExprZ rexp = zList.get(0).accept(this);


					if (null != lexp || null != rexp) {
						ret = new ExprEq(lexp, rexp);
					}

				}

			} else if (rightExpr instanceof RefExpr) {

				RefExpr refExpr = (RefExpr) rightExpr;
				String opName = refExpr.getName().toString();

				TupleExpr tuple = (TupleExpr) leftExpr;
				Object[] opArguments = tuple.getZExprList().getChildren();

				// Describo recursivamente los hijos
				ExprZ lexp = ((Expr) opArguments[0]).accept(this);
				ExprZ rexp = ((Expr) opArguments[1]).accept(this);

				if (opName.equals(UtilSymbols.notInSymbol())) {					// ∉ - Non-membership symbol
					if (null != lexp || null != rexp) {
						ret = new ExprNotIn(lexp, rexp);
					}
				} else if (opName.equals(UtilSymbols.neqSymbol())) {			// ≠ - Unequality  symbol
					if (null != lexp || null != rexp) {
						ret = new ExprNotEq(lexp, rexp);
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
						ret = new ExprSubSet(lexp, rexp);
					}
				} else if (opName.equals(UtilSymbols.subseteqSymbol())) {		// ⊆ - Subseteq symbol
					if (null != lexp || null != rexp) {
						ret = new ExprSubSetEq(lexp, rexp);
					}
				} else {
					System.out.println("unhandled RefExpr");
				}
			}
		}

		return ret;
	}

	@Override
	public ExprZ visitApplExpr(ApplExpr arg0) {
		boolean mixfix = arg0.getMixfix();
		Expr leftExpr = arg0.getLeftExpr();
		Expr rightExpr = arg0.getRightExpr();

		ExprZ ret = null;

		if (mixfix) {

			if (leftExpr instanceof RefExpr) {
				String name = ((RefExpr) arg0.getLeftExpr()).getName().toString();

				Expr rExpr = arg0.getRightExpr();

				// Por ahora solo contemplo \mapsto, \cap y \cup
				if (rExpr instanceof TupleExpr && ((TupleExpr) rExpr).getZExprList().size() == 2) {
					Expr left = ((TupleExpr) rExpr).getZExprList().get(0);
					Expr right = ((TupleExpr) rExpr).getZExprList().get(1);

					// proceso recursivamente los hijos
					ExprZ lexp = left.accept(this);
					ExprZ rexp = right.accept(this);

					if (null != lexp || null != rexp) {
						if (name.equals(UtilSymbols.mapletSymbol())) {				// ↦ - MapsTo symbol
							ret = new ExprMapsTo(lexp, rexp);
						} else if (name.equals(UtilSymbols.intersectionSymbol())) {	// ⋂ - Intersection symbol
							ret = new ExprIntersection(lexp, rexp);
						} else if (name.equals(UtilSymbols.unionSymbol())) {		// ⋃ - Union symbol
							ret = new ExprUnion(lexp, rexp);
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
			ExprZ lexp = leftExpr.accept(this);
			ExprZ rexp = rightExpr.accept(this);

			if (null != lexp || null != rexp) {
				ret = new ExprApply(lexp, rexp);
			}
		}


		return ret;
	}

	@Override
	public ExprZ visitRefExpr(RefExpr arg0) {
		return new ExprName(arg0.getZName().toString());
	}

	@Override
	public ExprZ visitSetExpr(SetExpr arg0) {
		List<ExprZ> list = new ArrayList<ExprZ>();
		for (Expr exp : arg0.getZExprList()) {
			list.add(exp.accept(this));
		}

		return new ExprSet(list);
	}

	@Override
	public ExprZ visitNegPred(NegPred arg0) {
		return new ExprNot(arg0.getPred().accept(this));
	}

	@Override
	public ExprZ visitExprPred(ExprPred arg0) {
		return arg0.getExpr().accept(this);
	}

}
