package client.presentation.commands;

import antlr.StringUtils;
import client.blogic.testing.atcal.RefinementRule;
import client.blogic.testing.atcal.RuleManager;
import client.blogic.testing.atcal.parser.AtcalLexer;
import client.blogic.testing.atcal.parser.AtcalParser;
import client.blogic.testing.refinement.FTCRLUtils;
import client.blogic.testing.refinement.tcrlrules.TCRLFileParser;
import client.presentation.ClientTextUI;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.*;

/**
 * An instance of this class represents a command to load a refinement rule written in ATCALv2.0
 */
public class LoadRefinementRuleCommand implements Command {

    /**
     * Runs this command.
     *
     * @param clientTextUI  a reference to the text user interface issuing the command
     * @param args
     */
    @Override
    public void run(ClientTextUI clientTextUI, String args) {

        PrintWriter output = clientTextUI.getOutput();

        if (args == null || args.isEmpty() || args.split("\\s+").length != 1) {
            output.println("Invalid parameters.  Try 'help'.");
            return;
        }
        try {
            // Tokenize ATCAL refinement rule.
            ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(args.trim()));
            AtcalLexer lexer = new AtcalLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            AtcalParser parser = new AtcalParser(tokens);
            AtcalParser.RefinementRuleContext r = parser.refinementRule();
            RuleManager.getInstance().addRule(r.ID().getText(), new RefinementRule(r));
        } catch (IOException e) {
            output.println("File '" + args + "' not found.");
        }
    }
}

