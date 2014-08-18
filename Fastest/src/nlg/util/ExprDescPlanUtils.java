package nlg.util;

import java.util.ArrayList;
import java.util.List;

import net.sourceforge.czt.z.ast.Pred;
import nlg.czt.visitors.ASTToExprDescPlanVisitor;
import nlg.expr.base.ExprDescPlan;

import common.z.SpecUtils;
import common.z.TClass;
import common.z.czt.visitors.AndPredClausesExtractor2;

public class ExprDescPlanUtils {

	/**
	 * Divide el predicado del esquema dado 
	 * segun sus predicados "and"y  luego convierte 
	 * cada uno de estos predicados en ExprDescPlan.
	 */
	public static List<ExprDescPlan> extractSchemaExpr(TClass tClass) {
		List<ExprDescPlan> ret = new ArrayList<ExprDescPlan>();
				
		ASTToExprDescPlanVisitor visitor = new ASTToExprDescPlanVisitor();
		
		List<Pred> ps = 
				SpecUtils.getAxParaPred(
						tClass.getMyAxPara()).accept(
								new AndPredClausesExtractor2());
		
		for (Pred p : ps) {
			ret.add(p.accept(visitor));
		}
		
		return ret;
	}
}
