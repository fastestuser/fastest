package client.blogic.testing.atcal;

import client.blogic.management.ii.EventAdmin;
import client.blogic.management.ii.events.TCaseRefined;
import client.blogic.testing.atcal.generators.BaseGen;
import client.blogic.testing.atcal.generators.Generator;
import client.blogic.testing.atcal.generators.PerlGen;
import client.blogic.testing.atcal.z.ast.CZTTranslator;
import client.blogic.testing.atcal.z.ast.ZExpr;
import client.blogic.testing.atcal.z.ast.ZExprSchema;
import client.blogic.testing.atcal.z.ast.ZVar;
import common.z.AbstractTCase;
import common.z.SpecUtils;
import net.sourceforge.czt.z.ast.Expr;
import net.sourceforge.czt.z.ast.RefExpr;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by Cristian on 13/07/15.
 */

/**
 * This class executes the refinement of an abstract test case using the ATCAL evaluator.
 */
public class TCaseRefineClientRunner implements Runnable {

    private final String opName;
    private final AbstractTCase abstractTCase;
    private final String targetLanguage;
    private final RefinementRule refinementRule;

    /**
     * Creates a TCaseRefineClientRunner instance.
     * @param opName            the name of the operation to refine
     * @param abstractTCase     the abstract test case to refine
     * @param targetLanguage    the target language of the refinement
     * @param refinementRule    the refinement rule to use for the refinement
     */
    public TCaseRefineClientRunner(String opName, AbstractTCase abstractTCase, String targetLanguage, RefinementRule refinementRule) {
        this.opName = opName;
        this.abstractTCase = abstractTCase;
        this.targetLanguage = targetLanguage;
        this.refinementRule = refinementRule;
    }

    @Override
    public void run() {

        // Instantiate the right code generator for the refinement.
        Generator codeGen = null;
        if(targetLanguage.equalsIgnoreCase("perl"))
            codeGen = new PerlGen();
        else if(targetLanguage.equalsIgnoreCase("debug"))
            codeGen = new BaseGen();
        else
            throw new RuntimeException("The " + targetLanguage + " language is not supported by the testing backend.");

        // Translate the abstract test case to ATCAL AST.
        ZExprSchema atc = Atcal.ATCToZExpr(abstractTCase);

        String concreteTCaseName = SpecUtils.getAxParaName(abstractTCase).replaceAll("_TCASE", "_CTCASE");

        // Get the ATCAL rule and evaluate it for the abstract test case.
        AtcalEvaluator atcalEvaluator = new AtcalEvaluator(atc, codeGen, concreteTCaseName);
        ConcreteTCase concreteTCase = atcalEvaluator.visitRefinementRule(refinementRule.getContext());

        // announce that the refinement process has finished.
        try {
            TCaseRefined tCaseRefinedEvent = new TCaseRefined(opName, abstractTCase, concreteTCase);
            EventAdmin eventAdmin = EventAdmin.getInstance();
            eventAdmin.announceEvent(tCaseRefinedEvent);
        } catch (IllegalAccessException e) {
            System.out.println(e);
        }
    }
}
