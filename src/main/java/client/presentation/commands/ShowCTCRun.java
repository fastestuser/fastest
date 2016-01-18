package client.presentation.commands;

import client.blogic.management.Controller;
import client.blogic.testing.atcal.ConcreteTCaseRun;
import client.presentation.ClientTextUI;
import common.z.SpecUtils;

import java.io.PrintWriter;

/**
 * An instance of this class allows the presentation of the executions of the concrete test cases.
 *
 * @author Cristian Rosa
 */
public class ShowCTCRun implements Command {

    @Override
    public void run(ClientTextUI clientTextUI, String args) {
        PrintWriter output = clientTextUI.getOutput();

        // Parse command arguments
        if (args == null || args.trim().isEmpty()){
            output.println("Invalid parameters.  Try 'help'.");
            return;
        }

        String[] argv = args.split("\\s+");
        String ctcName = argv[0];

        // Fetch concrete test case execution result schema and print it.
        Controller controller = clientTextUI.getMyController();
        if(ctcName.equalsIgnoreCase("-all")){
            for(ConcreteTCaseRun concreteTCaseRun: controller.getConcreteTCaseRunMap().values()){
                output.println(SpecUtils.termToLatex(concreteTCaseRun.getResultsSchema()));
            }
        } else {
            ConcreteTCaseRun concreteTCaseRun = controller.getConcreteTCaseRunMap().get(ctcName);
            if(concreteTCaseRun != null){
                output.println(SpecUtils.termToLatex(concreteTCaseRun.getResultsSchema()));
            } else {
                output.println(ctcName + " is not the name of a concrete test case.");
            }
        }
    }
}
