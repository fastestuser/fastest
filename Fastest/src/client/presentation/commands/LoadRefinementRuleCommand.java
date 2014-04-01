package client.presentation.commands;

import java.io.*;

import org.antlr.v4.runtime.RecognitionException;

import client.presentation.ClientTextUI;
import client.blogic.testing.refinamiento.FTCRLUtils;


public class LoadRefinementRuleCommand implements Command{

    /**
     * Runs this command.
     * @param clientTextUI
     * @param args
     */
    @Override
	public void run(ClientTextUI clientTextUI, String args){

		PrintWriter output = clientTextUI.getOutput();

		try{
			if (args == null || "".equals(args)){
			    output.println("Invalid parameters.  Try 'help'.");
			    return;
			}

			final String parts[] = args.split(" ");

			if (parts.length != 1){
			    output.println("Invalid parameters.  Try 'help'.");
			    return;
			}

			// We obtain the file from the path
			
			File refLawFile = new File(parts[0]);
			if (!refLawFile.exists()){
			    output.println("File " + parts[0] + " not found");
			}
			else{
				// We parse the refinement law
				FTCRLUtils.setClientUI(clientTextUI);
				FTCRLUtils.parse(refLawFile);
			}
		}
		catch(RecognitionException e){
			output.println("The FTCRL file have syntax errors.");
			output.println(e.getMessage());
		}
		catch(Exception e){
			output.println("The FTCRL file have syntax errors.");
			e.printStackTrace(output);
		}
	}
}

