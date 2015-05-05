import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.fastest.atcal.ATCALType;
import org.fastest.atcal.ArrayType;
import org.fastest.atcal.ContractType;
import org.fastest.atcal.RefinementLawEvaluator;
import org.fastest.atcal.apl.APLVar;
import org.fastest.atcal.parser.AtcalLexer;
import org.fastest.atcal.parser.AtcalParser;
import org.fastest.atcal.z.ast.*;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cristian on 4/16/15.
 */
public class RefinementLawEvaluatorTest {

    private ZExprNum num1 = new ZExprNum(1);
    private ZExprNum num2 = new ZExprNum(2);
    private ZExprNum num3 = new ZExprNum(3);
    private ZExprNum num4 = new ZExprNum(4);
    private ZExprNum num5 = new ZExprNum(5);
    private ZExprNum num6 = new ZExprNum(6);
    private ZExprProd prod1 = ZExprProd.of(num1, num2);
    private ZExprProd prod2 = ZExprProd.of(num3, num4);
    private ZExprProd prod3 = ZExprProd.of(num1, num2, num3);
    private ZExprProd prod4 = ZExprProd.of(num4, num5, num6);
    private ZVar var1 = new ZVar("var1", new ZExprString("Hello "));
    private ZVar var2 = new ZVar("var2", new ZExprString("world"));
    private ZVar var3 = new ZVar("var3", new ZExprNum(2));
    private ZVar var4 = new ZVar("var4", ZExprSet.of(num1, num2));
    private ZVar var5 = new ZVar("var5", ZExprSet.of(num2, num3));
    private ZVar var6 = new ZVar("var6", ZExprSet.of(prod1, prod2));
    private ZVar var7 = new ZVar("var7", ZExprSet.of(prod3, prod4));
    private ZExprSchema atc1 = ZExprSchema.of(var1, var2, var3, var4);
    private ZExprSchema atc2 = ZExprSchema.of(var4, var5, var6, var7);


    private String evalLaw(String law, ZExprSchema scope) {
        ANTLRInputStream input = new ANTLRInputStream(law);
        AtcalLexer lexer = new AtcalLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        AtcalParser parser = new AtcalParser(tokens);
        ParseTree tree = parser.lawRefinement(); // begin parsing at lawRefinement

        final Map<String, ATCALType> types = Maps.newHashMap();
        List<String> constArgs = Lists.newArrayList();
        List<String> setterArgs = Lists.newArrayList("list", "a", "b");
        List<String> getterArgs = Lists.newArrayList();
        types.put("List", new ContractType("List", "newList", constArgs, "add", setterArgs, "get", getterArgs));
        types.put("myArr", new ArrayType("myArr", 10));

        RefinementLawEvaluator eval = new RefinementLawEvaluator(scope, new APLVar(""), types);
        return eval.visit(tree).toString();
    }

    @Test
    public void lawEvalTest1() {
        String inputExpr = "5 ==> a";
        String result = evalLaw(inputExpr, atc1);
        System.out.println(result);
    }

    @Test
    public void lawEvalTest2() {
        String inputExpr = "pepe ==> []";
        String result = evalLaw(inputExpr, atc1);
        System.out.println(result);
    }

    @Test
    public void lawEvalTest3() {
        String inputExpr = "var3 ==> [5]";
        String result = evalLaw(inputExpr, atc1);
        System.out.println(result);
    }

    @Test
    public void lawEvalTest4() {
        String inputExpr = "var3 ==> var3 + var4.@CARD ==> a";
        String result = evalLaw(inputExpr, atc1);
        System.out.println(result);
    }

    @Test
    public void lawEvalTest5() {
        String inputExpr = "var4 ==> l AS List WITH [ var4.1 ==> a AS List WITH [var1 ==> a, var4.1 ==> b], var4.2 ==> b]";
        String result = evalLaw(inputExpr, atc1);
        System.out.println(result);
    }

    @Test
    public void lawEvalTest6() {
        String inputExpr = "var4 ==> l AS myArr WITH [ var4.1 ==> [1] AS List WITH [var1 ==> a], var4.2 ==> [2] AS List WITH [\"hola\" ==> b] ]";
        String result = evalLaw(inputExpr, atc1);
        System.out.println(result);
    }
}
