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
import nlg.expr.base.ExprDescPlan;
import nlg.expr.visitors.NameExtractor;
import nlg.expr.visitors.NameToParamVisitor;

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

				if (line.trim().length() <= 22) { 	// Asumo que se trata de un 
													// bloque de designaciones globales

					while (it.hasNext()) {
						line = it.next();

						if (line.contains("end{designations}")) // Fin bloque designaciones
							break;

						if (line.contains("desig{")) {
							
							// Parseo y agrego designacion al resultado
							ret.add(new TermDesignation(parseDesigLine(line), null));
							
						}
					}

				} else {						// Asumo que se tratan de 
												// designaciones de esquema

					// Parseo el nombre de esquema
					String schName = line.trim().substring(21, line.length() - 1);

					// A continuacion leo las designaciones
					while (it.hasNext()) {
						line = it.next();

						if (line.contains("end{designations}")) // Fin bloque designaciones
							break;

						if (line.contains("desig{")) {
							
							// Parseo y agrego designacion al resultado
							ret.add(new TermDesignation(parseDesigLine(line), schName));
							
						}
					}
				}
			}
		}

		return ret;
	}
	
	private ExprDescPlan parseDesigLine(String line) throws IOException, CommandException {
		line = line.trim();
		Integer index = line.indexOf("}");

		String designation = line.substring(7, index);
		String termString = line.substring(index + 2, line.length() - 1);
		
		// Remuevo signos indeseados de designaciones
		designation = designation.replaceAll("\\$", "");
		
		// Intento parsear el termino y convertiro a ExprDescPlan
		Pred term = ParseUtils.parsePred(new StringSource(termString), null, new SectionManager());
		ExprDescPlan exprTerm = term.accept(new ASTToExprDescPlanVisitor());
		
		// Extraigo parametros de la designacion
		List<String> parametros = getParameters(designation, exprTerm);
		
		// Verifico si se trata de una designacion parametrizada
		if (!parametros.isEmpty()) {
			// Transformo la expresion marcando modificando 
			// las variables que correspondan a parametros
			exprTerm = exprTerm.accept(nameToParamVisitor);
		}
		
		return exprTerm;

	}
	
	// Extrae los nombres de los parametros de una designacion
	private List<String> getParameters (String designation, ExprDescPlan expr) {
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
	
	private NameToParamVisitor nameToParamVisitor = new NameToParamVisitor();
}