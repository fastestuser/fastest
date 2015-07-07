package client.presentation.commands;

import java.util.Map;

import nlg.base.designation.DesignationRepo;
import client.blogic.management.Controller;
import client.blogic.testing.ttree.TClassNode;
import client.presentation.ClientTextUI;

/**
 * Command para imprimir en pantalla las descripciones 
 * de todas las clases de prueba generadas.
 */
// TODO falta implementar
public class ShowDescAllCommand implements Command {

	@Override
	public void run(ClientTextUI clientTextUI, String args) {
		
		Controller controller = clientTextUI.getMyController();
        Map<String, TClassNode> opTTreeMap = controller.getOpTTreeMap();
        DesignationRepo desigRepo = clientTextUI.getMyController().getDesigRepo();
        printTTSchemes(clientTextUI, opTTreeMap, desigRepo);
		/*Controller controller = clientTextUI.getMyController();
		PrintWriter stdout = clientTextUI.getOutput();
		Map<String, TClassNode> opTTreeMap = controller.getOpTTreeMap();
		
		TCaseNodeFinder tcnf = new TCaseNodeFinder();
		
        for (TClassNode tcn : opTTreeMap.values()) {
        	AbstractIterator<AbstractTCase> it = tcn.acceptVisitor(tcnf).values().iterator();
        	
        	while (it.hasNext()) {
        		TClassNode tc = it.next().ge;
        		String desc = 
    					tc.getMyAxPara().accept(new SchemeDescriptor());
        		stdout.println(desc);
        	}
        }*/
		
	}
	
	private void printTTSchemes(ClientTextUI clientTextUI, Map<String, TClassNode> opTTreeMap, DesignationRepo desigRepo) {
        // Imprimos todos los casos de prueba o clases de prueba (de acuerdo al tTreeVisitor)
        // de todas las operaciones

        for (String opName : opTTreeMap.keySet()) {
            TClassNode opTTreeRoot = opTTreeMap.get(opName);
            //TClassNodeDescUIPrinter tTreeVisitor = new TClassNodeDescUIPrinter(clientTextUI.getOutput(), -1, opName, desigRepo);
            //opTTreeRoot.acceptVisitor(tTreeVisitor);
        }

    }

}