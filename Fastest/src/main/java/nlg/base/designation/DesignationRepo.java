package nlg.base.designation;

import java.util.List;

import nlg.base.expression.ExprZ;


/**
 * Repositorio de designaciones.
 * Modela documento de designaciones de una especificacion.
 * Provee metodos para setear y recuperar las designaciones
 * de los distintos tipos de terminos.
 *
 */
public interface DesignationRepo {

	/**
	 * Agrega designacion al repositorio.
	 */
	public void addDesignation(TermDesignation desig);
	
	/**
	 * Agrega designacion parametrizada al repositorio.
	 */
	public void addDesignation(ParamDesignation desig);
	
	/**
	 * Recupera una designacion del repositorio.
	 * De no encontrarse devuelve null.
	 */
	public TermDesignation getTermDesignation(ExprZ expr, String schName);
	
	/**
	 * Recupera todas las designaciones parametrizadas
	 */
	public List<ParamDesignation> getAllParamDesignation(String schName);
}
