package nlg.base;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import nlg.base.documentPlan.DocumentPlan;
import nlg.expr.base.ExprZ;
import nlg.expr.visitors.ExprDescPlanToString;
import client.blogic.management.Controller;
import client.blogic.testing.ttree.TClassNode;
import client.blogic.testing.ttree.visitors.SchemeTTreeFinder;
import client.blogic.testing.ttree.visitors.TClassLeavesFinder;
import common.repository.AbstractIterator;
import common.repository.AbstractRepository;
import common.z.TClass;

public class NLGUtils {
	
	/**
	 * Formatea un DocumentPlan (usado para debug)
	 */
	public static String nlgDocumentPlanToString(DocumentPlan nlgDP) {
		String ret = "";
		
		/* TODO
		ExprDescPlanToString visitor = new ExprDescPlanToString();
		List<TClassDescPlan> descs = nlgDP.gettClassDescPlanList();
		
		for (TClassDescPlan descPlan : descs) {
			TClass tClass = descPlan.gettClass();
			List<ExprZ> exprList = descPlan.getExprDescList();
			
			ret += tClass.getSchName() + "\n";
			
			for (ExprZ edp : exprList) {
				ret += "* " + insetTabs(edp.accept(visitor)) + "\n";
			}
			
			ret += "\n";
		}
		*/
		
		return ret;
	}
	
	/**
	 * Recupera todas las clases de pruebas generadas
	 */
	public static List<TClass> getAllTClassLeaves(Controller controller) {
		List<TClass> ret = new ArrayList<TClass>();
		// Recupero map operation names -> associated test trees
        Map<String, TClassNode> opTTreeMap = controller.getOpTTreeMap();
        
		// Recupero todas las clasese de prueba generadas
        for (String key : opTTreeMap.keySet()) {
            TClassNode opTTreeRoot = opTTreeMap.get(key);
            
            AbstractRepository<TClass> classes = opTTreeRoot.acceptVisitor(new TClassLeavesFinder());
            
            AbstractIterator<TClass> it = classes.createIterator();
            
            while (it.hasNext()) {
            	ret.add(it.next());
            }
        }
        
        return ret;
	}
	
	/**
	 * Busca una clase de prueba, por nombre, en el arbol de pruebas.
	 * (devuelve null en caso de no encontrarla)
	 * @param schName Nombre de la clase de prueba a buscar
	 */
	public static TClass getTClass(String schName, Controller controller) {
		TClass tClass;
		
		// Recupero map operation names -> associated test trees
        Map<String, TClassNode> opTTreeMap = controller.getOpTTreeMap();
        
		// Busco la operacion recursivamente en el arbol de prueba
        for (String key : opTTreeMap.keySet()) {
            TClassNode opTTreeRoot = opTTreeMap.get(key);
            
            tClass = (TClass) opTTreeRoot.acceptVisitor(new SchemeTTreeFinder(schName, -1));
            
            if (null != tClass) {
            	return tClass;
            }
        }
        
        // No se encontro la clase de prueba buscada
        return null;
	}
	
	private static String insetTabs(String string) {
		return string.replaceAll("\\|", "  |");
	}
}
