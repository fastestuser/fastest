package nlg.util;

import java.util.ArrayList;
import java.util.List;

import net.sourceforge.czt.z.ast.Pred;
import nlg.base.expression.ExprZ;
import common.z.SpecUtils;
import common.z.TClass;
import common.z.czt.visitors.AndPredClausesExtractor2;

public class ExprZUtils {

	/**
	 * Divide el predicado del esquema dado 
	 * segun sus predicados "and"y  luego convierte 
	 * cada uno de estos predicados en ExprZ.
	 * @throws Exception Tira una exception en caso de intentar
	 *  parsear algun operador no soportado
	 */
	public static List<ExprZ> extractSchemaExpr(TClass tClass) throws Exception {
		List<ExprZ> ret = new ArrayList<ExprZ>();
				
		ASTToExprZVisitor visitor = new ASTToExprZVisitor();
		
		List<Pred> ps = 
				SpecUtils.getAxParaPred(
						tClass.getMyAxPara()).accept(
								new AndPredClausesExtractor2());
		
		for (Pred p : ps) {
			ExprZ edp = p.accept(visitor);
			
			if (null == edp) {
				throw new Exception("La expresion contiene algun operador no soportado: " + SpecUtils.termToLatex(p));
			} else {
				ret.add(edp);
			}
		}
		
		return ret;
	}
}
