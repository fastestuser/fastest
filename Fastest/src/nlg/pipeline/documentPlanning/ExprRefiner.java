package nlg.pipeline.documentPlanning;

import nlg.expr.base.ExprZ;

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
		return expr;
	}
	
	
}
