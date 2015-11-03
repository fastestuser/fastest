import client.blogic.testing.atcal.Atcal;
import client.blogic.testing.atcal.AtcalEvaluator;
import client.blogic.testing.atcal.ConcreteTCase;
import client.blogic.testing.atcal.generators.PerlGen;
import client.blogic.testing.atcal.parser.AtcalLexer;
import client.blogic.testing.atcal.parser.AtcalParser;
import client.blogic.testing.atcal.z.ast.ZExprSchema;
import com.google.common.io.Resources;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;

import java.io.IOException;
import java.net.URL;

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

    @Test
    public void test1() {
        URL fileURL = Resources.getResource("perlGenTest/atc1.tex");
        ZExprSchema atc = Atcal.parseATCFile(fileURL);
        ParseTree parseTree = parseFile("perlGenTest/perlGenTest1.atcal");
        AtcalEvaluator evaluator = new AtcalEvaluator(atc, new PerlGen(), "Basic refinement");
        ConcreteTCase output = evaluator.visitRefinementRule((AtcalParser.RefinementRuleContext) parseTree);
        System.out.println(output.getCode());
    }

    @Test
    public void test2() {
        URL fileURL = Resources.getResource("perlGenTest/atc2.tex");
        ZExprSchema atc = Atcal.parseATCFile(fileURL);
        ParseTree parseTree = parseFile("perlGenTest/perlGenTest2.atcal");
        AtcalEvaluator evaluator = new AtcalEvaluator(atc, new PerlGen(), "Basic refinement");
        ConcreteTCase output = evaluator.visitRefinementRule((AtcalParser.RefinementRuleContext) parseTree);
        System.out.println(output.getCode());
    }
}
