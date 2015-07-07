package nlg.base.designation;

import java.util.List;

import nlg.base.expression.ExprZ;
import nlg.util.ExprZToString;
import nlg.util.ParamExprMatcher;

public class DesignationUtils {
	
	/**
	 * Verifica si una expresion se encuentra designada.
	 * Primero busca en las designaciones asociadas al nombre de esquema dado,
	 * de fallar intetara buscar una designacion global para la expresion
	 */
	public static boolean isDesignated(ExprZ expr, String schName, DesignationRepo repo) {
		boolean ret = false;
		
		// me fijo si hay una designacion comun
		TermDesignation td = repo.getTermDesignation(expr, schName);
		
		if (null != td) {
			ret = true;
			
		} else {
			List<ParamDesignation> desigs = repo.getAllParamDesignation(schName);
			
			for (ParamDesignation pd : desigs) {
				// Intento recuperar la designacion del argumento
				TermDesignation argDesig = repo.getTermDesignation(expr, schName);
				
				if (null == argDesig) {
					ret = true;
					break;
				}
			}
			
		}
		
		if (!ret && null == schName) {
			// Puede que sea una designacion global, intento nuevamente
			ret = isDesignated(expr, null, repo);
		}
		
		return ret;
	}
	
	/**
	 * Busca la designacion de un termino.
	 * De no existir designacion local asociada al esquema dado, 
	 * intentara buscar una designacion "global" para el mismo.
	 * De ser un termino parametrizado supongo que el parametro del mismos
	 * se encuentra designado.
	 * De no encontrar la designacion devuelve texto latex correspondiente a la expresion.
	 */
	public static String applyDesignation(ExprZ expr, String schName, DesignationRepo repo) {
		String ret = null;
		
		// Intento recuperar designacion 
		TermDesignation td = repo.getTermDesignation(expr, schName);
		
		
		if (null != td) {
			ret = td.getText();
			
		} else { 						// Veo si se trata de una designacion parametrizada
			List<ParamDesignation> desigs = repo.getAllParamDesignation(schName);
			
			for (ParamDesignation pd : desigs) {
				ExprZ arg = extractArgument(expr, pd);
				
				if (null != arg) {
					// Intento recuperar la designacion del argumento
					TermDesignation argDesig = repo.getTermDesignation(arg, schName);
					
					if (null == argDesig) {
						// No se encuentra designado 
						// convierto a texto el argumento
						ret = pd.getDesigFun().apply(arg.accept(new ExprZToString()));
						
					} else {
						ret = pd.getDesigFun().apply(argDesig.getText());
					}
					
					break;
				}
			}
		}
		
		if (null == ret) { 		// No se encuentra designado 
			if (null == schName) {
				// Puede que sea una designacion global, intento nuevamente
				ret = applyDesignation(expr, null, repo);
				
			} else {
				ret = expr.accept(new ExprZToString());
			}
		}
		
		return ret;
	}
	
	/**
	 * Si la expresion es una instancia de la designacion parametrizada
	 * dada devuelve su argumento, en caso contrario devuelve null.
	 */
	private static ExprZ extractArgument(ExprZ expr, ParamDesignation desig) {
		return desig.getExpr().accept(new ParamExprMatcher(expr, desig.getRefExpr()));
	}
	
}
