package nlg.base.designation;

import nlg.base.expr.ExprRef;

/**
 * Repositorio de designaciones.
 * Modela documento de designaciones de una especificacion.
 * Provee metodos para setear y recuperar las designaciones
 * de los distintos tipos de terminos.
 *
 */
public interface DesignationRepo {

	/**
	 * Agrega designacion no parametrizada al repositorio.
	 */
	public void addDesignation(TermDesignation desig);
	
	/**
	 * Agrega designacion parametrizada al repositorio.
	 */
	public void addDesignation(ParamDesignation desig);
	
	/**
	 * Recupera una designacion no parametrizada.
	 * De no encontrarse en el repositorio devuelve null.
	 */
	public TermDesignation getTermDesignation(ExprRef name, String schName);
}
