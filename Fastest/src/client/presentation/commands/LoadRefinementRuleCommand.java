package client.presentation.commands;

import java.io.*;

import client.presentation.ClientTextUI;
import client.blogic.testing.refinement.FTCRLUtils;
import client.blogic.testing.refinement.tcrlrules.TCRLFileParser;


public class LoadRefinementRuleCommand implements Command{

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
		if (parts.length != 1){
			output.println("Invalid parameters.  Try 'help'.");
			return;
		}
		// We obtain the file from the path
		File refLawFile = new File(parts[0]);
		if (!refLawFile.exists())
			output.println("File " + parts[0] + " not found");
		try{
			// We parse the refinement law
			FTCRLUtils.setClientUI(clientTextUI);
			TCRLFileParser.parse(refLawFile);
		}

		catch(IOException e){
		}
		catch(Exception e){
			output.println("The " + parts[0] + " file have syntax errors.");
		}
	}
}

