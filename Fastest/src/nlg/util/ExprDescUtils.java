package nlg.util;

import java.util.ArrayList;
import java.util.List;

import net.sourceforge.czt.z.ast.Pred;
import nlg.czt.visitors.ASTToExprDescPlanVisitor;
import nlg.expr.base.ExprZ;

import common.z.SpecUtils;
import common.z.TClass;
import common.z.czt.visitors.AndPredClausesExtractor2;

public class ExprDescUtils {

	/**
	 * Divide el predicado del esquema dado 
	 * segun sus predicados "and"y  luego convierte 
	 * cada uno de estos predicados en ExprDescPlan.
	 */
	public static List<ExprZ> extractSchemaExpr(TClass tClass) {
		List<ExprZ> ret = new ArrayList<ExprZ>();
				
		ASTToExprDescPlanVisitor visitor = new ASTToExprDescPlanVisitor();
		
		List<Pred> ps = 
				SpecUtils.getAxParaPred(
						tClass.getMyAxPara()).accept(
								new AndPredClausesExtractor2());
		
		for (Pred p : ps) {
			ExprZ edp = p.accept(visitor);
			// TODO ignoro expresiones no soportadas (esto no deberia permitirse)
			if (null != edp) {
				ret.add(edp);
			}
		}
		
		return ret;
	}
}
