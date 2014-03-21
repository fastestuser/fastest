package client.presentation.commands;

import java.io.*;
import java.util.*;

import common.z.AbstractTCase;
import client.presentation.ClientTextUI;
import client.blogic.management.Controller;
import client.blogic.testing.refinamiento.ConcreteTCase;
import client.blogic.testing.ttree.TClassNode;
import client.blogic.testing.ttree.TTreeNode;
import client.blogic.testing.ttree.visitors.TCaseNodeFinder;
import client.blogic.testing.ttree.visitors.TTreeNodeFinder;

/**
 * An instance of this class allow the presentation of the concrete test cases which are
 * stored in Fastest. It is possible to print a particular concrete test case, all the
 * concrete test cases related to an operation or all the concrete test cases generated
 * in the refinement stage.
 * Printing can be done on screen or on a file or a set of files. In the case of the files,
 * the user must specify a folder in which Fastest will create the files. 
 */

public class ShowConcreteTCaseCommand implements Command{
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

		final String argv[] = args.split(" ");
		int argc = argv.length;
		String ctcFilter = argv[0];
		String folderPath = "";
		if(argc == 2 || (argc == 3 && !argv[1].equals("-o"))){
			output.println("Invalid parameters.  Try 'help'.");
			return;
		}
		Controller controller = clientTextUI.getMyController();
		Map<String, ConcreteTCase> opCtcMap = controller.getOpTCaseRefinedMap();
		Map<String,ConcreteTCase> absCtcMap = controller.getAbsTCaseConcrTCaseMap();
		if (opCtcMap==null){
			output.println("There aren't refined cases");
			return;
		}

		if(argc>2)
			folderPath = argv[2];

		List<ConcreteTCase> ctCases = new ArrayList<ConcreteTCase>();
		if (opCtcMap.get(ctcFilter)!=null){
			ctCases.add(opCtcMap.get(ctcFilter));
		}
		else if(ctcFilter.equals("-all"))
			ctCases.addAll(opCtcMap.values());
		else if (absCtcMap.get(ctcFilter)!=null){
			ctCases.add(absCtcMap.get(ctcFilter));
		}
		else{

			Map<String, TClassNode> opTTreeMap = controller.getOpTTreeMap();
			Iterator<TClassNode> it = opTTreeMap.values().iterator();
			Map<String, AbstractTCase> tcaMap = null;
			TTreeNode ttnode = null;
			while(it.hasNext()){
				ttnode = it.next().acceptVisitor(new TTreeNodeFinder(ctcFilter));
				if (ttnode !=null){
					tcaMap = ttnode.acceptVisitor(new TCaseNodeFinder());
					break;
				}
			}
			if (ttnode !=null){
				Iterator<String> it2 = tcaMap.keySet().iterator();
				ConcreteTCase ctc;
				while (it2.hasNext()){
					ctc = absCtcMap.get(it2.next());
					if (ctc !=null)	ctCases.add(ctc );
				}
			}
			else {
				output.println(ctcFilter+" is not the name of a concrete test case or the name of a refined operation");
				return;
			}
		}

		// Now we decide if we print the results in the screen or in files
		if(folderPath.equals("")){
			// We must print in the screen
			for(int i=0;i<ctCases.size();i++)
				output.println(ctCases.get(i).toString() + "\n\n");
		}
		else{
			try{
				// We must print in files
				for(int i=0;i<ctCases.size();i++){
					ConcreteTCase auxCTCase = ctCases.get(i);
					String auxCTCName = auxCTCase.getConcreteTCaseName();
					String targetLanguaje = auxCTCase.getLanguaje();
					String fileExtension = "";
					if(targetLanguaje.equals("Java"))
						fileExtension = ".java";
					else if (targetLanguaje.equals("C"))
						fileExtension = ".c";
					File auxFile = new File(folderPath + File.separator + auxCTCName + fileExtension);
					BufferedWriter auxBW = new BufferedWriter(new FileWriter(auxFile));
					auxBW.write(auxCTCase.toString());
					auxBW.close();
				}
			}
			catch(Exception e){
				e.printStackTrace(System.out);
			}
		}

	}
}
