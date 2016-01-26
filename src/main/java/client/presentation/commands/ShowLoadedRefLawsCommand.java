package client.presentation.commands;

import client.blogic.testing.atcal.RefinementRule;
import client.blogic.testing.atcal.RuleManager;
import client.presentation.ClientTextUI;
import java.io.PrintWriter;

/**
 * @author Hache
 */
public class ShowLoadedRefLawsCommand implements Command {
    /**
     * Runs this command.
     *
     * @param clientTextUI
     * @param args
     */
    @Override
    public void run(ClientTextUI clientTextUI, String args) {
        PrintWriter output = clientTextUI.getOutput();
        if (!args.isEmpty()) {
            output.println("Invalid parameters.  Try 'help'.");
        } else if (RuleManager.getInstance().isEmpty()) {
            output.println("There is not any refinement law in the repository.");
        } else {
            for (RefinementRule rule : RuleManager.getInstance()) {
                output.println("* " + rule);
            }
        }
    }

}
