package nlg.base.designation;

import java.util.List;

import nlg.base.expr.ExprZ;
import nlg.util.ArgumentExtractor;

public class DesignationUtils {
	
	
	/**
	 * Si la expresion es una instancia de la designacion parametrizada
	 * dada devuelve su argumento, en caso contrario devuelve null.
	 */
	public static ExprZ extractArgument(ExprZ expr, ParamDesignation desig) {
		List<ExprZ> tmp = desig.getExpr().accept(new ArgumentExtractor(expr, desig.getRefExpr()));
		// TODO falta verificar que que todos los elementos de la lista sean la misma expresion
		if (null != tmp) {
			return tmp.get(0);
		} else {
			return null;
		}
	}
	
}
