import client.blogic.testing.atcal.Atcal;
import client.blogic.testing.atcal.AtcalEvaluator;
import client.blogic.testing.atcal.ConcreteTCase;
import client.blogic.testing.atcal.generators.PerlGen;
import client.blogic.testing.atcal.parser.AtcalLexer;
import client.blogic.testing.atcal.parser.AtcalParser;
import client.blogic.testing.atcal.z.ast.ZExprSchema;
import com.google.common.io.Resources;
import common.z.AbstractTCase;
import common.z.AbstractTCaseImpl;
import common.z.czt.UniqueZLive;
import net.sourceforge.czt.animation.eval.ZLive;
import net.sourceforge.czt.base.util.UnmarshalException;
import net.sourceforge.czt.parser.circus.ParseUtils;
import net.sourceforge.czt.parser.util.ParseException;
import net.sourceforge.czt.session.FileSource;
import net.sourceforge.czt.z.ast.AxPara;
import net.sourceforge.czt.z.ast.Spec;
import net.sourceforge.czt.z.ast.ZParaList;
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

    private AbstractTCase loadATCResource(URL fileURL) {
        try {
            ZLive zLive = UniqueZLive.getInstance();
            Spec spec = (Spec) ParseUtils.parse(new FileSource(fileURL.getFile()), zLive.getSectionManager());
            ZParaList o = (ZParaList) (spec.getSect().get(0).getChildren()[2]);
            AxPara axPara = (AxPara) (o.get(1));
            return new AbstractTCaseImpl(axPara, "test");
        } catch (ParseException | IOException | UnmarshalException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Test
    public void test1() {
        AbstractTCase atc = loadATCResource(Resources.getResource("perlGenTest/atc1.tex"));
        ParseTree parseTree = parseFile("perlGenTest/perlGenTest1.atcal");
        AtcalEvaluator evaluator = new AtcalEvaluator(atc, new PerlGen());
        ConcreteTCase output = evaluator.visitRefinementRule((AtcalParser.RefinementRuleContext) parseTree);
        System.out.println(output.getCode());
    }

    @Test
    public void test2() {
        AbstractTCase atc = loadATCResource(Resources.getResource("perlGenTest/atc2.tex"));
        ParseTree parseTree = parseFile("perlGenTest/perlGenTest2.atcal");
        AtcalEvaluator evaluator = new AtcalEvaluator(atc, new PerlGen());
        ConcreteTCase output = evaluator.visitRefinementRule((AtcalParser.RefinementRuleContext) parseTree);
        System.out.println(output.getCode());
    }
}
