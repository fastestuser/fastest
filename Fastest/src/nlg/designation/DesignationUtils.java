package nlg.designation;

import java.util.List;

import nlg.expr.base.ExprDescPlan;
import nlg.expr.visitors.ArgumentExtractor;

public class DesignationUtils {
	
	
	/**
	 * Si la expresion es una instancia de la designacion parametrizada
	 * dada devuelve su argumento, en caso contrario devuelve null.
	 */
	public static ExprDescPlan extractArgument(ExprDescPlan expr, ParamDesignation desig) {
		List<ExprDescPlan> tmp = desig.getExpr().accept(new ArgumentExtractor(expr, desig.getParam()));
		// TODO falta verificar que que todos los elementos de la lista sean la misma expresion
		if (null != tmp) {
			return tmp.get(0);
		} else {
			return null;
		}
	}
	
}
