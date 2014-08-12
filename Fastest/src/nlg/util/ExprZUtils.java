package nlg.util;

import java.util.ArrayList;
import java.util.List;

import net.sourceforge.czt.z.ast.Pred;
import nlg.czt.visitors.ASTToExprZVisitor;
import nlg.expr.base.ExprZ;
import common.z.SpecUtils;
import common.z.TClass;
import common.z.czt.visitors.AndPredClausesExtractor2;

public class ExprZUtils {

	/**
	 * Divide el predicado del esquema dado 
	 * segun sus predicados "and"y  luego convierte 
	 * cada uno de estos predicados en ExprZ.
	 */
	public static List<ExprZ> extractSchemaExpr(TClass tClass) {
		List<ExprZ> ret = new ArrayList<ExprZ>();
				
		ASTToExprZVisitor visitor = new ASTToExprZVisitor();
		
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
