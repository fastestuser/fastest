import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.fastest.atcal.ZExprEvaluator;
import org.fastest.atcal.parser.AtcalLexer;
import org.fastest.atcal.parser.AtcalParser;
import org.fastest.atcal.z.ast.*;
import org.junit.Test;

/**
 * Created by Cristian on 3/31/15.
 */
public class ZExprEvaluatorTest {

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
    private ZVar zScope = new ZVar("zScope", ZExprSet.of(num1, num2));
    private ZExprSchema atc1 = ZExprSchema.of(var1, var2, var3, zScope);
    private ZExprSchema atc2 = ZExprSchema.of(var4, var5, var6, var7);

    private ZExpr evalExpr(String expr, ZExprSchema atc) {
        ANTLRInputStream input = new ANTLRInputStream(expr);
        AtcalLexer lexer = new AtcalLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        AtcalParser parser = new AtcalParser(tokens);
        ParseTree tree = parser.zExpr(); // begin parsing at zExpr
        ZExprEvaluator eval = new ZExprEvaluator(atc);
        return eval.visit(tree);
    }

    @Test
    public void stringTest() throws Exception {
        String inputExpr = "var1 ++ var2 ++ \" yay\"";
        ZExpr result = evalExpr(inputExpr, atc1);
        System.out.println(result.toString());
        assert (result.equals(new ZExprString("Hello world yay")));
    }

    @Test
    public void numTest() {
        String inputExpr = "5 + 4 * 2 + var3";
        ZExpr result = evalExpr(inputExpr, atc1);
        System.out.println(result.toString());
        assert (result.equals(new ZExprNum(15)));
    }

    @Test
    public void setTest1() {
        String inputExpr = "var4.@CARD";
        ZExpr result = evalExpr(inputExpr, atc2);
        System.out.println(result.toString());
        assert (result.equals(new ZExprNum(2)));
    }

    @Test
    public void setTest2() {
        String inputExpr = "var4 \\/ var5";
        ZExpr result = evalExpr(inputExpr, atc2);
        System.out.println(result.toString());
        assert (result.equals(ZExprSet.of(num1, num2, num3)));
    }

    @Test
    public void setTest3() {
        String inputExpr = "var4 /\\ var5";
        ZExpr result = evalExpr(inputExpr, atc2);
        System.out.println(result.toString());
        assert (result.equals(ZExprSet.of(num2)));
    }

    @Test
    public void setTest4() {
        String inputExpr = "var4 ~ var5";
        ZExpr result = evalExpr(inputExpr, atc2);
        System.out.println(result.toString());
        assert (result.equals(ZExprSet.of(num1)));
    }

    @Test
    public void setTest5() {
        String inputExpr = "var6.@DOM";
        ZExpr result = evalExpr(inputExpr, atc2);
        System.out.println(result.toString());
        assert (result.equals(ZExprSet.of(num1, num3)));
    }

    @Test
    public void setTest6() {
        String inputExpr = "var6.@RAN";
        ZExpr result = evalExpr(inputExpr, atc2);
        System.out.println(result.toString());
        assert (result.equals(ZExprSet.of(num2, num4)));
    }

    @Test
    public void setTest7() {
        String inputExpr = "var7.@3";
        ZExpr result = evalExpr(inputExpr, atc2);
        System.out.println(result.toString());
        assert (result.equals(ZExprSet.of(num3, num6)));
    }

    @Test
    public void setTest8() {
        String inputExpr = "var7.2";
        ZExpr result = evalExpr(inputExpr, atc2);
        System.out.println(result.toString());
        assert (result.equals(prod4));
    }

    @Test
    public void setTest9() {
        String inputExpr = "{5,6,7}";
        ZExpr result = evalExpr(inputExpr, atc2);
        System.out.println(result.toString());
        assert (result.equals(ZExprSet.of(new ZExprNum(5), new ZExprNum(6), new ZExprNum(7))));
    }

    @Test
    public void setTest10() {
        String inputExpr = "<5,6,7>";
        ZExpr result = evalExpr(inputExpr, atc2);
        System.out.println(result.toString());
        assert (result.equals(ZExprProd.of(new ZExprNum(5), new ZExprNum(6), new ZExprNum(7))));
    }

    @Test
    public void setTest11() {
        String inputExpr = "<a>";
        ZExpr result = evalExpr(inputExpr, atc2);
        System.out.println(result.toString());
        assert (result.equals(ZExprProd.of(new ZExprConst("a", 1, ZExprConst.ConstantType.BASIC))));
    }

    @Test
    public void setTest12() {
        String inputExpr = "{a,b}";
        ZExpr result = evalExpr(inputExpr, atc2);
        System.out.println(result.toString());
        assert (result.equals(ZExprSet.of(new ZExprConst("a", 1, ZExprConst.ConstantType.BASIC), new ZExprConst("b", 2, ZExprConst.ConstantType.BASIC))));
    }

    @Test
    public void setTest13() {
        String inputExpr = "{var4,b}";
        ZExpr result = evalExpr(inputExpr, atc2);
        System.out.println(result.toString());
        assert (result.equals(ZExprSet.of(ZExprSet.of(num1, num2), new ZExprConst("b", 1, ZExprConst.ConstantType.BASIC))));
    }

    @Test
    public void setTest14() {
        String inputExpr = "<var4,b>";
        ZExpr result = evalExpr(inputExpr, atc2);
        System.out.println(result.toString());
        assert (result.equals(ZExprProd.of(ZExprSet.of(num1, num2), new ZExprConst("b", 1, ZExprConst.ConstantType.BASIC))));
    }

    @Test
    public void setTest15() {
        String inputExpr = "var4.2 + var5.@CARD + (var4 \\/ var5).@CARD + var6.1.#2";
        ZExpr result = evalExpr(inputExpr, atc2);
        System.out.println(result.toString());
        assert (result.equals(new ZExprNum(9)));
    }

    @Test
    public void elemTest() {
        String inputExpr = "@ELEM";
        ZExpr result = evalExpr(inputExpr, atc1);
        System.out.println(result.toString());
    }
}
