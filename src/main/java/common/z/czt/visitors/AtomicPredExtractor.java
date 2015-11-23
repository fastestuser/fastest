package common.z.czt.visitors;

import net.sourceforge.czt.base.ast.*;
import net.sourceforge.czt.base.visitor.*;
import java.util.*;

import net.sourceforge.czt.z.ast.Expr;
import net.sourceforge.czt.z.visitor.ApplExprVisitor;
import net.sourceforge.czt.z.visitor.MemPredVisitor;
import net.sourceforge.czt.z.ast.ApplExpr;
import net.sourceforge.czt.z.ast.NumExpr;
import net.sourceforge.czt.z.ast.RefExpr;
import net.sourceforge.czt.z.ast.SetExpr;
import net.sourceforge.czt.z.ast.MemPred;
import net.sourceforge.czt.z.ast.TypeAnn;
import net.sourceforge.czt.z.ast.ZExprList;
import common.z.SpecUtils;
import common.z.UtilSymbols;

/*
 * A visitor that obtains all the needed predicates to use in the SP tactic when using an strategy
 */

public class AtomicPredExtractor
implements TermVisitor<Map<Term,String>>, ApplExprVisitor<Map<Term,String>>, MemPredVisitor<Map<Term,String>>
{

	public AtomicPredExtractor(){
	}

	public Map<Term,String> visitTerm(Term term)
	{
		Map<Term,String> mapList = new HashMap<Term,String>();
		try{
			if(term != null){
				Object[] array = term.getChildren();
				Term auxTerm = null;
				if(array!=null){
					for (int i = 0; i < array.length; i++) {
						final Object object = array[i];
						if (object instanceof Term && object != null){
							auxTerm = (Term) object;
							if(auxTerm!=null){
								Map<Term,String> auxMap = auxTerm.accept(this);
								if(auxMap!=null)
									mapList.putAll(auxMap);
							}
						}
					}
				}
			}
		}
		catch(Exception e){
			System.out.println("Exception: \n"+e.toString());
		}
		return mapList;
	}

	public Map<Term,String> visitApplExpr(ApplExpr applExpr)
	{
		Map<Term,String> mapList = new HashMap<Term,String>();

		Expr leftExpr = applExpr.getLeftExpr();
		Expr rightExpr = applExpr.getRightExpr();

		if (applExpr.getMixfix()) { //Function Operator Application
			String operator = SpecUtils.termToLatex(leftExpr);
			if (operator.contentEquals("( \\_ \\oplus \\_ )")) {
				mapList.put(applExpr, "\\oplus");
			} else if (operator.contentEquals("( \\_ \\cup \\_ )")) {
				mapList.put(applExpr, "\\cup");
			} else if (operator.contentEquals("( \\_ \\cap \\_ )")) {
				mapList.put(applExpr, "\\cap");
			} else if (operator.contentEquals("( \\_ \\setminus \\_ )")) {
				mapList.put(applExpr, "\\setminus");
			} else if (operator.contentEquals("( \\_ + \\_ )")) {
				mapList.put(applExpr, "+");
			} else if (operator.contentEquals("( \\_ \\ndres \\_ )")) {
				mapList.put(applExpr, "\\ndres");
			} else if (operator.contentEquals("( \\_ \\dres \\_ )")) {
				mapList.put(applExpr, "\\dres");
			} else if (operator.contentEquals("( \\_ \\rres \\_ )")) {
				mapList.put(applExpr, "\\rres");
			} else if (operator.contentEquals("( \\_ \\extract \\_ )")) {
				mapList.put(applExpr, "\\extract");
			} else if (operator.contentEquals("( \\# \\_ )")) {
				mapList.put(applExpr, "\\#");
			}
		}
		mapList.putAll(leftExpr.accept(this));
		mapList.putAll(rightExpr.accept(this));
		return mapList;
	}

	public Map<Term,String> visitMemPred(MemPred memPred){
		Map<Term,String> mapList = new HashMap<Term,String>();

		if (!memPred.getMixfix()) { //It is a \in predicate
			Expr rightExpr = memPred.getRightExpr();
			if (! (rightExpr instanceof SetExpr)) {
				mapList.put(memPred, "\\in");
			}
			return mapList;
		} else {
			Expr rightExpr = memPred.getRightExpr();
			Expr leftExpr = memPred.getLeftExpr();
			if(rightExpr instanceof SetExpr){ //It is a predicate like: "n = m" has left="n" and right="{m}".

				String typeName = "";
				if (leftExpr instanceof ApplExpr) { //We need to check if it a numeric type expr
					ApplExpr applExpr = (ApplExpr) leftExpr;

					List<Object> anns = applExpr.getAnns();
					for (int i = 0; i < anns.size(); i++) {
						Object ann = anns.get(i);
						if (ann instanceof TypeAnn) {
							TypeAnn typeAnn = (TypeAnn) ann;
							typeName = typeAnn.getType().toString();
						}
					}
					//System.out.println("El tipo es: " + typeName);
					String arithmosTypeName = "GIVEN " + UtilSymbols.arithmosSymbol();
					if (typeName.equals(arithmosTypeName)) {
						mapList.put(memPred, "=");
					}
				} else if (leftExpr instanceof RefExpr) {
					RefExpr refExpr = (RefExpr) leftExpr;

					List<Object> anns = refExpr.getAnns();
					for (int i = 0; i < anns.size(); i++) {
						Object ann = anns.get(i);
						if (ann instanceof TypeAnn) {
							TypeAnn typeAnn = (TypeAnn) ann;
							typeName = typeAnn.getType().toString();
						}
					}
					String arithmosTypeName = "GIVEN " + UtilSymbols.arithmosSymbol();
					if (typeName.equals(arithmosTypeName)) {
						mapList.put(memPred, "=");
					}
				} else if (leftExpr instanceof NumExpr) {
					mapList.put(memPred, "=");
				}

				mapList.putAll(leftExpr.accept(this));
				SetExpr auxSetExpr = (SetExpr) rightExpr;
				ZExprList zExprList = auxSetExpr.getZExprList();
				for(int i=0;i<zExprList.size();i++){
					Expr auxExpr = zExprList.get(i);
					mapList.putAll(auxExpr.accept(this));
				}
			}
			else{ //It is a predicate like: "n < m" has left="(n,m)" and right=" _ < _ "
				String operator = SpecUtils.termToLatex(rightExpr);
				if (operator.contentEquals("( \\_~<~\\_ )")) {
					mapList.put(memPred, "<");
				} else if (operator.contentEquals("( \\_~>~\\_ )")) {
					mapList.put(memPred, ">");
				} else if (operator.contentEquals("( \\_ \\leq \\_ )")) {
					mapList.put(memPred, "\\leq");
				} else if (operator.contentEquals("( \\_ \\geq \\_ )")) {
					mapList.put(memPred, "\\geq");
				} else if (operator.contentEquals("( \\_ \\notin \\_ )")) {
					mapList.put(memPred, "\\notin");
				}
				mapList.putAll(leftExpr.accept(this));
				mapList.putAll(rightExpr.accept(this));
			}
			return mapList;
		}
	}
}