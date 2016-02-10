package client.presentation.commands;

import java.io.PrintWriter;
import java.util.Collection;
import java.util.Iterator;

import client.blogic.management.Controller;
import client.presentation.ClientTextUI;


/**
 * An instance of this class allow the selection of all operations selected to be tested.
 * @author Joaquin Oscar Mesuro
 */
public class SelOpAllCommand implements Command{

	@Override
	public void run(ClientTextUI clientTextUI, String args) {
		PrintWriter output = clientTextUI.getOutput();
		if (!args.equals("")){
    		output.println("Invalid parameters.  Try 'help'.");
		}
		else{
			SelOpCommand selop = new SelOpCommand();
			Controller controller = clientTextUI.getMyController();
			Collection<String> loadedOpsRep = controller.getLoadedOpsRep();
			Iterator<String> it = loadedOpsRep.iterator();
			while (it.hasNext()) 
				selop.run(clientTextUI, it.next());
			
		}
		
	}

}
