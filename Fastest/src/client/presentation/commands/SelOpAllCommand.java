package client.presentation.commands;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import common.repository.AbstractIterator;
import common.repository.AbstractRepository;
import common.repository.ConcreteRepository;

import client.blogic.management.Controller;
import client.blogic.testing.ttree.strategies.TTreeStrategy;
import client.blogic.testing.ttree.tactics.Tactic;
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
