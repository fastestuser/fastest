package client.blogic.testing.atcal;

import client.blogic.testing.atcal.parser.AtcalLexer;
import client.blogic.testing.atcal.parser.AtcalParser;
import client.blogic.testing.atcal.z.ast.CZTTranslator;
import client.blogic.testing.atcal.z.ast.ZExpr;
import client.blogic.testing.atcal.z.ast.ZExprSchema;
import client.blogic.testing.atcal.z.ast.ZVar;
import common.z.AbstractTCase;
import net.sourceforge.czt.z.ast.Expr;
import net.sourceforge.czt.z.ast.RefExpr;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by cristian on 3/31/15.
 */
public class Atcal {

    /**
     * Helper function to translate the abstract test case from CZT to ATCAL representation.
     * @param atc   a CZT abstract test case
     * @return      an ATCAL abstract test case
     */
    public static ZExprSchema ATCToZExpr(AbstractTCase atc) {
        final CZTTranslator cztTranslator = new CZTTranslator();
        ArrayList<ZVar> translatedVars = new ArrayList<ZVar>();
        for (Map.Entry<RefExpr, Expr> varExpr : atc.getVarExpMap().entrySet()) {
            ZExpr expr = varExpr.getValue().accept(cztTranslator);
            translatedVars.add(new ZVar(varExpr.getKey().getName().toString(), expr));
        }
        return new ZExprSchema(translatedVars.toArray(new ZVar[translatedVars.size()]));
    }
}
