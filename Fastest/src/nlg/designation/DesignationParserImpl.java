package nlg.designation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import net.sourceforge.czt.parser.z.ParseUtils;
import net.sourceforge.czt.session.CommandException;
import net.sourceforge.czt.session.SectionManager;
import net.sourceforge.czt.session.StringSource;
import net.sourceforge.czt.z.ast.Pred;
import nlg.czt.visitors.ASTToExprDescPlanVisitor;
import nlg.expr.base.ExprZ;
import nlg.expr.visitors.NameExtractor;

public class DesignationParserImpl implements DesignationParser {

	@Override
	public List<TermDesignation> parse(String texContent) throws IOException, CommandException {
		String[] lineas = texContent.split("\\\n");
		Iterator<String> it = Arrays.asList(lineas).iterator();

		List<TermDesignation> ret = new ArrayList<TermDesignation>();

		while (it.hasNext()) {
			String line = it.next();

			// Comienza bloque de designaciones
			if (line.contains("begin{designations}")) {

				String schName = null;
				// Verifico si se trata de una designacion global o de esquema
				if (line.trim().length() > 22) {
					// Obtengo el nombre de esquema
					schName = line.trim().substring(21, line.length() - 1);
				}
				
				// Parseo bloque de designaciones
				while (it.hasNext()) {
					line = it.next();

					if (line.contains("end{designations}")) // Fin bloque designaciones
						break;

					if (line.contains("desig{")) {
						
						TermDesignation td = parseDesigLine(line, schName);
						
						if (null != td) {
							ret.add(td);
						}
					}
				}
			}
		}

		return ret;
	}
	
	
	

	private TermDesignation parseDesigLine(String line, String schName) throws IOException, CommandException {
		TermDesignation ret;
		line = line.trim();
		Integer index = line.indexOf("}");

		String designation = line.substring(7, index);
		String termString = line.substring(index + 2, line.length() - 1);
		
		// Remuevo signos indeseados de designaciones
		designation = designation.replaceAll("\\$", "");
		
		// Intento parsear el termino y convertiro a ExprDescPlan
		Pred term = ParseUtils.parsePred(new StringSource(termString), null, new SectionManager());
		ExprZ exprTerm = term.accept(new ASTToExprDescPlanVisitor());
		
		// Extraigo parametros de la designacion
		List<String> parametros = getParameters(designation, exprTerm);
		
		// Verifico si se trata de una designacion parametrizada
		if (!parametros.isEmpty()) {
			if (parametros.size() == 1) {
				ret = new ParamDesignation(exprTerm, schName, parametros.get(0), createDesignationFuncion(designation, parametros.get(0)));
			} else {
				ret = null;
				System.out.println("Error: No se encuentran soportadas las designaciones con mas de un parametro.");
			}
		} else {
			ret = new SimpleDesignation(exprTerm, schName, designation);
		}
		
		return ret;
	}
	
	// Construye una DesignationFunction a partir de una designacion parseada
	private DesignationFunction createDesignationFuncion(final String text, final String varName) {
		
		DesignationFunction ret =
			new DesignationFunction() {
				@Override
				public String apply(String exprDesc) {
					// Reemplazo apariciones del parametro en el medio del texto
					String tmp = text.replaceAll(" " + varName + " ", " " + exprDesc + " ");
					
					// Reemplazo apariciones del parametro al comienzo del texto
					if (tmp.startsWith(varName + " ")) {
						tmp = exprDesc + " " + tmp.substring(varName.length() + 1, tmp.length());
					}
					
					// Reemplazo apariciones del parametro al final del texto
					if (tmp.endsWith(" " + varName)) {
						tmp = tmp.substring(0, tmp.length() - varName.length() - 1) + " " + exprDesc;
					}
					
					return tmp;
				}
			};
		
			return ret;
	}
	
	// Extrae los nombres de los parametros de una designacion
	private List<String> getParameters (String designation, ExprZ expr) {
		List<String> ret = new ArrayList<String>();
		
		// Extraigo nombres de variables, funciones, etc de expr
		NameExtractor ne = new NameExtractor();
		List<String> names = expr.accept(ne);
		
		// Separo palabas en designacion
		List<String> desigNames = Arrays.asList(designation.split(" "));
		
		// Verifico si alguna palabra de la designacion fue 
		// usada como parametro del lado derecho
		for (String n : desigNames) {
			if (names.contains(n.trim())) {
				ret.add(n);
			}
		}
		
		return ret;
	}
}