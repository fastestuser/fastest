package nlg.designation;

import java.util.List;

/**
 * Parser para designaciones en la especificacion.
 */
public interface DesignationParser {
	/**
	 * Parsea bloques de designaciones del tipo:
	 * <pre>
	 * {@code
	 * \begin{designations}
	 *   \desig{texto}{termino}
	 *   ...
	 * \end{designations}
	 * }
	 * </pre>
	 * 
	 * @return Lista de designaciones parseadas
	 */
	public void parse(String texContent) throws Exception;
	
	/**
	 * Devuelve todas las designaciones no parametrizadas parseadas
	 */
	public List<TermDesignation> getAllTermDesignations();
	
	/**
	 * Devuelve todas las designaciones parametrizadas parseadas
	 */
	public List<ParamDesignation> getAllParamDesignations();
}
