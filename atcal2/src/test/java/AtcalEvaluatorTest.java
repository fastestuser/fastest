import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.fastest.atcal.AtcalEvaluator;
import org.fastest.atcal.generators.BaseGen;
import org.fastest.atcal.generators.Generator;
import org.fastest.atcal.generators.PerlGen;
import org.fastest.atcal.parser.AtcalLexer;
import org.fastest.atcal.parser.AtcalParser;
import org.fastest.atcal.z.ast.*;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

/**
 * Created by Cristian on 11/06/15.
 */
public class AtcalEvaluatorTest {

    private ZExprNum num1 = new ZExprNum(1);
    private ZExprNum num2 = new ZExprNum(2);
    private ZVar var1 = new ZVar("var1", new ZExprString("Hello "));
    private ZVar var2 = new ZVar("var2", new ZExprString("world"));
    private ZVar var3 = new ZVar("var3", new ZExprNum(2));
    private ZVar var4 = new ZVar("var4", ZExprSet.of(num1, num2));
    private ZExprSchema atc1 = ZExprSchema.of(var1, var2, var3, var4);
    private Generator baseGen = new BaseGen();

    // ATC extracted from paper:
    // "Test Adaptation for Model-Based Testing Methods Using Set-Based Specification Languages"
    private ZVar v = new ZVar("v", new ZExprConst("id_1", 0, ZExprConst.ConstantType.BASIC));
    private ZVar elecRoll = new ZVar("elecRoll", ZExprSet.of(ZExprProd.of(new ZExprConst("id_1", 0,
                    ZExprConst.ConstantType.BASIC), new ZExprConst("data_1", 0, ZExprConst.ConstantType.BASIC)),
            ZExprProd.of(new ZExprConst("id_2", 1,
                    ZExprConst.ConstantType.BASIC), new ZExprConst("data_2", 1, ZExprConst.ConstantType.BASIC))));
    private ZExprSchema atc4 = ZExprSchema.of(elecRoll, v);

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
        AtcalEvaluator evaluator = new AtcalEvaluator(atc1, baseGen);
        String output = evaluator.visitRefinementRule((AtcalParser.RefinementRuleContext) atcalTree);
        //System.out.println(output);
        assert(output.equals("Int a\nString b\na=2\nb='Hello world'\nf(b)"));
    }

    /**
     * Nested array of lists with contract types.
     */
    @Test
    public void test2() {
        ParseTree atcalTree = parseFile("example2.atcal");
        AtcalEvaluator evaluator = new AtcalEvaluator(atc1, baseGen);
        String output = evaluator.visitRefinementRule((AtcalParser.RefinementRuleContext) atcalTree);
//        System.out.println(output);
        assert(output.equals("String a\nString b\nArray{type='ContractType{constructor='newList', constArgs=[]," +
                " setter='add', setterArgs=[list, a], getter='get', getterArgs=[]}', size=10} l\nl=newArray(10)\n" +
                "l1_list=newList()\na='Hello '\nadd(l1_list,a)\nl[1]=l1_list\nl2_list=newList()\n" +
                "b='hola'\nadd(l2_list,a)\nl[2]=l2_list\nf(l)"));
    }

    /**
     * Extracted from paper example.
     * It contains autofill, contract types, and multiple refinement laws.
     */
    @Test
    public void test3() {
        ParseTree atcalTree = parseFile("example3.atcal");
        AtcalEvaluator evaluator = new AtcalEvaluator(atc4, baseGen);
        String output = evaluator.visitRefinementRule((AtcalParser.RefinementRuleContext) atcalTree);
//        System.out.println(output);
        assert(output.equals("Int vid\nContractType{constructor='newDBTable', constArgs=[], setter='insert', " +
                "setterArgs=[table, vid, name, addr], getter='select', getterArgs=[]} roll\nString name\n" +
                "RecordType{fields={id=Int}} voter\nString addr\nroll_table=newDBTable()\nvid=0\nname='AUTOFILL'\n" +
                "addr='AUTOFILL'\ninsert(roll_table,vid,name,addr)\nvid=1\nname='AUTOFILL'\naddr='AUTOFILL'\n" +
                "insert(roll_table,vid,name,addr)\nroll=roll_table\nvoter.id=0\nisVoter(voter)"));
    }
}
