package client.presentation.commands;

import client.presentation.ClientTextUI;

/**
 * Command para imprimir en pantalla la descripcion
 * de una clase de prueba indicada.
 */
// TODO falta implementar
public class ShowDescCommand implements Command {

	@Override
	public void run(ClientTextUI clientTextUI, String args) {
		/*
		// Valido parametros
		// Sintaxis: showdesc nombre_clase_prueba
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
        
        
        // Obtengo clase de prueba y intento describirla
        String schName = firstArg;
        TClass tClass = null;
        
        // Busco la operacion recursivamente en el arbol de prueba
        boolean fail = true;
        for (String key : opTTreeMap.keySet()) {
            TClassNode opTTreeRoot = opTTreeMap.get(key);
            
            tClass = (TClass) opTTreeRoot.acceptVisitor(new SchemeTTreeFinder(schName, -1));
            
            if (null != tClass) {
            	TClassDescription desc = 
            			DescriptionUtils.describeTClass(
	            			tClass, 
	            			key, 
	            			clientTextUI.getMyController().getDesigRepo());
            	DescriptionUtils.printDescription(desc);
            	
            	fail = false;
            	break;
            }
        }
        
        if (fail) {
        	stdout.println("'" + schName + "' is not the name of any schema.");
        }
        */
	}
	


}
