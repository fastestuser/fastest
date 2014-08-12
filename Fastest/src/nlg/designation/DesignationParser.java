package nlg.designation;

import java.io.IOException;
import java.util.List;

import net.sourceforge.czt.session.CommandException;

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
	public List<TermDesignation> parse(String texContent) throws IOException, CommandException;
}
