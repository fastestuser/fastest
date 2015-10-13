import client.blogic.testing.atcal.AtcalEvaluator;
import client.blogic.testing.atcal.ConcreteTCase;
import client.blogic.testing.atcal.generators.PerlGen;
import client.blogic.testing.atcal.parser.AtcalLexer;
import client.blogic.testing.atcal.parser.AtcalParser;
import client.blogic.testing.atcal.z.ast.CZTTranslator;
import client.blogic.testing.atcal.z.ast.ZExprSchema;
import client.blogic.testing.atcal.z.ast.ZVar;
import com.google.common.base.Charsets;
import com.google.common.collect.Lists;
import com.google.common.io.Resources;
import common.z.czt.UniqueZLive;
import net.sourceforge.czt.animation.eval.ZLive;
import net.sourceforge.czt.parser.circus.ParseUtils;
import net.sourceforge.czt.session.CommandException;
import net.sourceforge.czt.session.StringSource;
import net.sourceforge.czt.z.ast.Expr;
import net.sourceforge.czt.z.ast.RefExpr;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

/**
 * Created by Cristian on 30/06/15.
 */
public class PerlGenTest {

    private ParseTree parseFile(String filename) {
        try {
            assertNotNull("Atcal test file missing", getClass().getResource(filename));
            ANTLRInputStream input = new ANTLRInputStream(getClass().getResourceAsStream(filename));
            AtcalLexer lexer = new AtcalLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            AtcalParser parser = new AtcalParser(tokens);
            return parser.refinementRule();
        } catch (IOException e) {
            fail(e.toString());
            return null;
        }
    }

    private ZExprSchema abstractTCaseFromFile(String filename) {
        ZLive zLive = UniqueZLive.getInstance();
        URL specFile = Resources.getResource(filename);
        ArrayList<ZVar> translatedVars = Lists.newArrayList();
        final CZTTranslator cztTranslator = new CZTTranslator();
        try {
            List<String> fileLines = Resources.readLines(specFile, Charsets.UTF_8);
            for(String line: fileLines){
                String[] varVal = line.split("=");
                RefExpr var = (RefExpr) ParseUtils.parseExpr(new StringSource(varVal[0]), zLive.getCurrentSection(), zLive.getSectionManager());
                Expr expr = ParseUtils.parseExpr(new StringSource(varVal[1]), zLive.getCurrentSection(), zLive.getSectionManager());
                translatedVars.add(new ZVar(var.getName().toString(), expr.accept(cztTranslator)));
            }
            return new ZExprSchema(translatedVars.toArray(new ZVar[translatedVars.size()]));
        } catch (IOException | CommandException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Test
    public void test1() {
        ZExprSchema atc = abstractTCaseFromFile("atc1.tex");
        System.out.println(atc);
        ParseTree parseTree = parseFile("perlGenTest1.atcal");
        AtcalEvaluator evaluator = new AtcalEvaluator(atc, new PerlGen(), "Basic refinement");
        ConcreteTCase output = evaluator.visitRefinementRule((AtcalParser.RefinementRuleContext) parseTree);
        System.out.println(output.getCode());
    }

}
