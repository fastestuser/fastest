package client.presentation.commands;

import java.io.PrintWriter;
import common.repository.AbstractIterator;
import common.repository.AbstractRepository;
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
			AbstractRepository<String> loadedOpsRep = controller.getLoadedOpsRep();
			AbstractIterator<String> it = loadedOpsRep.createIterator();
			while (it.hasNext()) 
				selop.run(clientTextUI, it.next());
			
		}
		
	}

}
