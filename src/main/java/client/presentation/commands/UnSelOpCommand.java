package client.presentation.commands;

import java.io.*;
import java.util.*;

import client.presentation.ClientTextUI;
import java.util.Collection;
import java.util.Iterator;
import client.blogic.management.Controller;
import client.blogic.testing.ttree.tactics.Tactic;
import client.blogic.testing.ttree.strategies.TTreeStrategy;

/**
 * An instance of this class removes the selection of an operation to be tested.
 * @author Pablo Rodriguez Monetti
 */
public class UnSelOpCommand implements Command{ 

    /**
     * Runs this command.
     * @param clientTextUI
     * @param args
     */
    @Override
	public void run(ClientTextUI clientTextUI, String args){
		
			PrintWriter output = clientTextUI.getOutput();
			if (args == null || "".equals(args)){
	    		output.println("Invalid parameters.  Try 'help'.");
				return;	
			}
			
			final String parts[] = args.split(" ");
			if (parts.length !=1){
				output.println("Invalid parameters.  Try 'help'.");
				return;
			}
			
			String opName = parts[0];
	
			Controller controller = clientTextUI.getMyController();
			
			//We check if the name of the operation to be unselected is contained in the repository of loaded operations names
			Collection<String> loadedOpsRep = controller.getLoadedOpsRep();
			Iterator<String> it = loadedOpsRep.iterator();
			boolean hasFound = false; 
			while (it.hasNext() && !hasFound)
				if(it.next().equals(opName))
					hasFound = true;			
			if(!hasFound){
				output.println("'" + opName + "' is not the name of a loaded operation."); 
				return;
			}
	
			//We check if the operation to be unselected has been selected. If so, we remove it from the repository.
			Collection<String> opsToTestRep = controller.getOpsToTestRep();
			it = opsToTestRep.iterator();
			hasFound = false; 
			while (it.hasNext() && !hasFound)
				if(it.next().equals(opName)){
					hasFound = true;
					it.remove();
				}
			if(!hasFound)
				output.println("'"+ opName + "' is not the name of a testing list's operation.");
				Map<String,TTreeStrategy> opTTreeStrategyMap = controller.getOpTTreeStrategyMap();
			if(opTTreeStrategyMap.containsKey(opName))
				opTTreeStrategyMap.remove(opName);
			
			Map<String,List<Tactic>> opTacticMap = controller.getTacticMap();
			if(opTacticMap.containsKey(opName))
				opTacticMap.remove(opName);
	
	}
}
 
 
