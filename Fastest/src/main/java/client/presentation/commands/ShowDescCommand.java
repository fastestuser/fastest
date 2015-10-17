package client.presentation.commands;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Map;

import client.blogic.management.Controller;
import client.blogic.testing.ttree.TClassNode;
import client.blogic.testing.ttree.visitors.SchemeTTreeFinder;
import client.presentation.ClientTextUI;
import common.z.TClass;
import nlg.pipeline.controller.NLGPipeline;
import nlg.pipeline.realizer.TextSurfaceRealizer;

/**
 * Command para imprimir en pantalla la descripcion
 * de una clase de prueba indicada.
 */
public class ShowDescCommand implements Command {

	@Override
	public void run(ClientTextUI clientTextUI, String args) {
		// Valido parametros
		// Sintaxis: showdesc [nombre_clase_prueba|nombre_operacion]
		final String argv[] = args.split(" ");
        int argc = argv.length;
        
		PrintWriter stdout = clientTextUI.getOutput();
		
        String firstArg = "";
        if (argc > 0 && !argv[0].equals("")) {
            firstArg = argv[0];
        } else {
        	stdout.println("Invalid parameters.  Try 'help'.");
            return;
        }
        
        // Recupero map operation names -> associated test trees
        Controller controller = clientTextUI.getMyController();
        Map<String, TClassNode> opTTreeMap = controller.getOpTTreeMap();
        
        NLGPipeline pipeline = new NLGPipeline(controller);
        pipeline.setSurfaceRealizer(new TextSurfaceRealizer());
        
        // Obtengo clase de prueba y intento describirla
        String schName = firstArg;
        TClass tClass = null;
        
        // Busco la operacion recursivamente en el arbol de prueba
        boolean fail = true;
        for (String key : opTTreeMap.keySet()) {
            TClassNode opTTreeRoot = opTTreeMap.get(key);
            
            tClass = (TClass) opTTreeRoot.acceptVisitor(new SchemeTTreeFinder(schName, -1));
            
            if (null != tClass) {
            	try {
					clientTextUI.getOutput().print(pipeline.run(Arrays.asList(tClass.getSchName())));
				} catch (Exception e) {
					clientTextUI.getOutput().print("Error: " + e.getMessage());
				}
            	fail = false;
            	break;
            }
        }
        
        if (fail) {
        	stdout.println("'" + schName + "' is not the name of any schema.");
        }
	}

}
