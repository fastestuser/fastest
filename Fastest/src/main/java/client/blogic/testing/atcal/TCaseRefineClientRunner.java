package client.blogic.testing.atcal;

import client.blogic.management.ii.EventAdmin;
import client.blogic.management.ii.events.TCaseRefined;
import client.blogic.testing.atcal.generators.BaseGen;
import client.blogic.testing.atcal.z.ast.CZTTranslator;
import client.blogic.testing.atcal.z.ast.ZExprSchema;
import common.z.AbstractTCase;
import net.sourceforge.czt.z.ast.ConstDecl;
import net.sourceforge.czt.z.ast.SchExpr;
import net.sourceforge.czt.z.ast.ZSchText;

/**
 * Created by Cristian on 13/07/15.
 */
public class TCaseRefineClientRunner implements Runnable {

    private final String opName;
    private final AbstractTCase abstractTCase;
    private final String targetLanguage;
    private final RefinementRule refinementRule;

    public TCaseRefineClientRunner(String opName, AbstractTCase abstractTCase, String targetLanguage, RefinementRule refinementRule) {
        this.opName = opName;
        this.abstractTCase = abstractTCase;
        this.targetLanguage = targetLanguage;
        this.refinementRule = refinementRule;
    }

    @Override
    public void run() {

        // Translate ATC to ATCAL AST.
        CZTTranslator cztTranslator = new CZTTranslator();
        ZExprSchema atc = (ZExprSchema) ((SchExpr) ((ConstDecl) ((ZSchText) abstractTCase.getMyAxPara().getSchText()).getZDeclList().get(0)).getExpr()).getZSchText().accept(cztTranslator);

        // Parse ATCAL rule and invoke the evaluator.
        AtcalEvaluator atcalEvaluator = new AtcalEvaluator(atc, new BaseGen());
        String output = atcalEvaluator.visitRefinementRule(refinementRule.getContext());

        // Show the input and output.
        System.out.println(atc);
        System.out.println(output);

        // announce that the refinement process has finished.
        try {
            TCaseRefined tCaseRefinedEvent = new TCaseRefined(opName, abstractTCase, null);
            EventAdmin eventAdmin = EventAdmin.getInstance();
            eventAdmin.announceEvent(tCaseRefinedEvent);
        } catch (IllegalAccessException e) {
            System.out.println(e);
        }
    }
}
