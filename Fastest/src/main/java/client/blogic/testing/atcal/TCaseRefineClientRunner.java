package client.blogic.testing.atcal;

import client.blogic.management.ii.EventAdmin;
import client.blogic.management.ii.events.TCaseRefined;
import client.blogic.testing.atcal.generators.BaseGen;
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

    /**
     * Helper function to translate the abstract test case from CZT to ATCAL representation.
     * @param atc   a CZT abstract test case
     * @return      an ATCAL abstract test case
     */
    private static ZExprSchema ATCToZExpr(AbstractTCase atc) {
        final CZTTranslator cztTranslator = new CZTTranslator();
        ArrayList<ZVar> translatedVars = new ArrayList<ZVar>();
        for (Map.Entry<RefExpr, Expr> varExpr : atc.getVarExpMap().entrySet()) {
            ZExpr expr = varExpr.getValue().accept(cztTranslator);
            translatedVars.add(new ZVar(varExpr.getKey().getName().toString(), expr));
        }
        return new ZExprSchema(translatedVars.toArray(new ZVar[translatedVars.size()]));
    }

    @Override
    public void run() {
        // Translate the abstract test case to ATCAL AST.
        ZExprSchema atc = ATCToZExpr(abstractTCase);

        // Get the ATCAL rule and evaluate it for the abstract test case.
        AtcalEvaluator atcalEvaluator = new AtcalEvaluator(atc, new BaseGen());
        String code = atcalEvaluator.visitRefinementRule(refinementRule.getContext());

        String concreteName = SpecUtils.getAxParaName(abstractTCase).replaceAll("_TCASE", "_CTCASE");
//        String concreteName = abstractName.substring(0,abstractName.indexOf("_TCASE")) + "_CTCASE";
        ConcreteTCase concreteTCase = new ConcreteTCase(concreteName, targetLanguage, code);

        // Show the input and code.
        System.out.println(atc);
        System.out.println(code);

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
