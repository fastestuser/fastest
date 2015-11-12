import client.blogic.testing.atcal.AtcalEvaluator;
import client.blogic.testing.atcal.ConcreteTCase;
import client.blogic.testing.atcal.generators.BaseGen;
import client.blogic.testing.atcal.generators.Generator;
import client.blogic.testing.atcal.parser.AtcalLexer;
import client.blogic.testing.atcal.parser.AtcalParser;
import common.z.AbstractTCase;
import common.z.AbstractTCaseImpl;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

/**
 * Created by Cristian on 11/06/15.
 */
public class AtcalEvaluatorTest {

    private static final Generator BASE_GEN = new BaseGen();

    private ParseTree parseFile(String atcalSrc) {
        try {
            assertNotNull("Atcal test file missing", getClass().getResource(atcalSrc));
            ANTLRInputStream input = new ANTLRInputStream(getClass().getResourceAsStream(atcalSrc));
            AtcalLexer lexer = new AtcalLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            AtcalParser parser = new AtcalParser(tokens);
            return parser.refinementRule();
        } catch (IOException e) {
            fail(e.toString());
            return null;
        }
    }

    /**
     * Basic file refinement.
     */
    @Test
    public void test1() {
        ParseTree atcalTree = parseFile("example1.atcal");
        AbstractTCase atc = AbstractTCaseImpl.fromFile(this.getClass().getClassLoader().getResource("AtcalEvaluatorTest/atc1.tex"));
        AtcalEvaluator evaluator = new AtcalEvaluator(atc, BASE_GEN);
        ConcreteTCase output = evaluator.visitRefinementRule((AtcalParser.RefinementRuleContext) atcalTree);
        System.out.println(output.getCode());
        assert (output.getCode().equals("a=2\nb='Hello world'\nf(b)"));
    }

    /**
     * Nested array of lists with contract types.
     */
    @Test
    public void test2() {
        ParseTree atcalTree = parseFile("example2.atcal");
        AbstractTCase atc = AbstractTCaseImpl.fromFile(getClass().getResource("/AtcalEvaluatorTest/atc1.tex"));
        AtcalEvaluator evaluator = new AtcalEvaluator(atc, BASE_GEN);
        ConcreteTCase output = evaluator.visitRefinementRule((AtcalParser.RefinementRuleContext) atcalTree);
        System.out.println(output.getCode());
        assert (output.getCode().equals("Array{type='ContractType{constructor='newList', constArgs=[], setter='add', " +
                "setterArgs=[a], getter='get', getterArgs=[]}', size=10} l[10]\n" +
                "l1_tmp=newList()\n" +
                "a='Hello'\n" +
                "l1_tmp.add(a)\n" +
                "l[1]=l1_tmp\n" +
                "l2_tmp=newList()\n" +
                "b='hola'\n" +
                "l2_tmp.add(a)\n" +
                "l[2]=l2_tmp\n" +
                "f(l)"));
    }

    /**
     * ATC extracted from paper:
     * "Test Adaptation for Model-Based Testing Methods Using Set-Based Specification Languages"
     * It contains autofill, contract types, and multiple refinement laws.
     */
    @Test
    public void test3() {
        ParseTree atcalTree = parseFile("example3.atcal");
        AbstractTCase atc = AbstractTCaseImpl.fromFile(getClass().getClassLoader().getResource("AtcalEvaluatorTest/atc2.tex"));
        AtcalEvaluator evaluator = new AtcalEvaluator(atc, BASE_GEN);
        ConcreteTCase output = evaluator.visitRefinementRule((AtcalParser.RefinementRuleContext) atcalTree);
        System.out.println(output.getCode());
        assert (output.getCode().equals("roll_tmp=newDBTable()\n" +
                "vid=2\n" +
                "name='Peter'\n" +
                "addr='AUTOFILL'\n" +
                "roll_tmp.insert(vid,name,addr)\n" +
                "vid=1\n" +
                "name='Paul'\n" +
                "addr='AUTOFILL'\n" +
                "roll_tmp.insert(vid,name,addr)\n" +
                "vid=3\n" +
                "name='Joe'\n" +
                "addr='AUTOFILL'\n" +
                "roll_tmp.insert(vid,name,addr)\n" +
                "roll=roll_tmp\n" +
                "voter.id=1\n" +
                "isVoter(voter)"));
    }
}
