package nlg.pipeline.documentPlanning;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import client.blogic.management.Controller;
import client.blogic.testing.ttree.TClassNode;
import client.blogic.testing.ttree.visitors.SchemeTTreeFinder;
import client.blogic.testing.ttree.visitors.TClassLeavesFinder;

import common.repository.AbstractIterator;
import common.repository.AbstractRepository;
import common.z.TClass;

/** 
 * Realiza tareas de "seleccion" parte de 
 * la etapa de "determinacion de contenido"
 */
public class SchFinder {

	public SchFinder(Controller controller) {
		this.controller = controller;
	}
	
	
	/**
	 * Recupera todas las clases de pruebas generadas
	 */
	public List<TClass> getAllTClasses() {
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
	 * Recupera por nombre una lista de clases de prueba generadas.
	 * @throws Exception Tira una exception si no encuentra
	 *  alguna de las clases indicadas
	 */
	public List<TClass> getTClasses(List<String> names) throws Exception {
		List<TClass> ret = new ArrayList<TClass>();
		
		for (String n : names) {
			ret.add(getTClass(n));
		}
		
		return ret;
	}
	
	/**
	 * Busca una clase de prueba, por nombre, en el arbol de prueba.
	 * (devuelve null en caso de no encontrarla)
	 * @throws Exception Tira una exception si no la encuentra
	 */
	private TClass getTClass(String schName) throws Exception {
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
        throw new Exception("TClass: " + schName + " not found.");
	}
	
	/**
	 * Recupera el nombre de la operacion a testear 
	 * con la clase de prueba indicada
	 * Revuelve null en el caso de no encontrarla
	 */
	public String getTestedOperation(String schName) {
		TClass tClass;
		
		// Recupero map operation names -> associated test trees
        Map<String, TClassNode> opTTreeMap = controller.getOpTTreeMap();
        
		// Busco la operacion recursivamente en el arbol de prueba
        for (String key : opTTreeMap.keySet()) {
            TClassNode opTTreeRoot = opTTreeMap.get(key);
            
            tClass = (TClass) opTTreeRoot.acceptVisitor(new SchemeTTreeFinder(schName, -1));
            
            if (null != tClass) {
            	return key;
            }
        }
        
        return null;
	}
	
	private Controller controller;
}
