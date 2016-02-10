package client.presentation.commands;

import java.io.*;
import java.util.Collection;


import net.sourceforge.czt.z.ast.Spec;

import client.presentation.ClientTextUI;

import java.util.Iterator;

import client.blogic.management.Controller;



/**
 * An instance of this class allow the presentation of the list of operations loaded with
 * the specification of the system to be tested. Those operations are the ones that can be 
 * tested.
 * @author Pablo Rodriguez Monetti
 */
public final class ShowLoadedOpsCommand implements Command{ 

    /**
     * Runs this command.
     * @param clientTextUI
     * @param args
     */
	public void run(ClientTextUI clientTextUI, String args){
		PrintWriter output = clientTextUI.getOutput();

		if (!args.equals("")){
    		output.println("Invalid parameters.  Try 'help'.");
		}
		else{
			Controller controller = clientTextUI.getMyController();
			Spec spec = null;
			// CAMBIAR ESTO!! que no unfoldee para fijarce esto
			if (controller.getOriginalSpec() != null)
				spec = controller.getOriginalSpec();
			
			if (spec == null)
				output.println("There is not any specification loaded.");
			else{
				Collection<String> opNamesRep = controller.getLoadedOpsRep();
				Iterator<String> it = opNamesRep.iterator();
				while(it.hasNext())
					output.println("* "+ it.next());
			}
		}	
	}

}
