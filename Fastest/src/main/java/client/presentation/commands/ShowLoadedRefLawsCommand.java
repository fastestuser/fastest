package client.presentation.commands;

import java.io.*;

import client.presentation.ClientTextUI;

import java.util.Iterator;

import client.blogic.management.Controller;
import client.blogic.testing.refinement.tcrlrules.RefinementRules;

/**
 *
 * @author Hache
 */
public class ShowLoadedRefLawsCommand implements Command{
    /**
    * Runs this command.
    * @param clientTextUI
    * @param args
    */
    @Override
    public void run(ClientTextUI clientTextUI, String args){
        PrintWriter output = clientTextUI.getOutput();

        if (!args.equals("")){
            output.println("Invalid parameters.  Try 'help'.");
        }
        else{
            //Controller controller = clientTextUI.getMyController();

            RefinementRules.instance();

            if (RefinementRules.size() == 0){
                output.println("There is not any refinement law in the repository.");
            }
            else{
                Iterator<String> it = RefinementRules.getRefRuleNames();
                while(it.hasNext())
                    output.println("* "+ it.next());
            }
        }
    }
}
