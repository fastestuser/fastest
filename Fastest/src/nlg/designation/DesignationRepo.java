package nlg.designation;

import java.util.List;

import nlg.expr.base.ExprZ;

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
	 * Agrega una lista de designaciones al repositorio
	 */
	public void addAllDesignations(List<TermDesignation> desigs);
	
	/**
	 * Recupera una designacion de esquema.
	 * De no encontrarse en el repositorio devuelve null.
	 */
	public TermDesignation getDesignation(ExprZ exp, String schName);
}
