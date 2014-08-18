package nlg.pipeline;

import java.util.List;

import nlg.base.NLGDocumentPlan;
import client.blogic.management.Controller;
import common.z.TClass;

/**
 * Interfaz abstracta para etapa de document planning
 * Primera etapa del sistema, debera convertir la informacion
 * de czt a una representacion interna, realizando la seleccion
 * y estructuracion de los datos.
 *
 */
public interface DocumentPlanner {
	public NLGDocumentPlan plan(List<TClass> tClasses, Controller controller);
}
