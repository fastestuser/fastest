package nlg.pipeline.documentPlanning;

import nlg.base.expr.ExprNotEq;
import nlg.base.expr.ExprSet;
import nlg.base.expr.ExprZ;
import nlg.util.DomMapsToVisitor;

/** 
 * Realiza tareas de "razonamiento con los datos"
 * parte de la etapa de "determinacion de contenido"
 */
public class ExprRefiner {
	
	/**
	 * 1) Devuelve null si se trata de alguna tautologia 
	 *  comun en Fastest, para no incluirla en la descripcion. 
	 *  (solo considera algunos casos, no evalua la expresion)
	 * 2) Realiza algunas reducciones triviales
	 */
	public ExprZ refine(ExprZ expr) {
		// Evaluo algunas tautologias
		if (exprSetNotEmpty(expr)) {
			return null;
		}
		
		ExprZ ret = reduceDomMapsTo(expr);
		
		return ret;
	}
	
	
	public ExprZ reduceDomMapsTo(ExprZ expr) {
		DomMapsToVisitor visitor = new DomMapsToVisitor();
		return expr.accept(visitor);
	}
	
	// Devuelve true en el caso de que la expresion
	// sea del tipo { ... } != {}
	public boolean exprSetNotEmpty(ExprZ expr) {
		if (expr instanceof ExprNotEq) {
			ExprNotEq eq = (ExprNotEq) expr;
			
			if (eq.getLeftExpr() instanceof ExprSet &&
					eq.getRightExpr() instanceof ExprSet) {
				ExprSet leftSet = (ExprSet) eq.getLeftExpr();
				ExprSet rightSet = (ExprSet) eq.getRightExpr();
				
				if (leftSet.getElements().isEmpty() ^ rightSet.getElements().isEmpty()) {
					return true;
				}
			}
		}
		return false;
	}
	
	
}
