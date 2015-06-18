import com.google.common.collect.Maps;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.fastest.atcal.*;
import org.fastest.atcal.apl.APLVar;
import org.fastest.atcal.parser.AtcalLexer;
import org.fastest.atcal.parser.AtcalParser;
import org.fastest.atcal.z.ast.*;
import org.junit.Test;

import java.util.Map;

/**
 * Created by cristian on 4/16/15.
 */
public class RefinementLawEvaluatorTest {

    private static final String datatypes = "" +
            "@DATATYPES" +
            "DATATYPE myEnum = ENUM myEnum (E1, E2, E3);" +
            "DATATYPE List = CONSTRUCTOR newList() SETTER add(list, a, b) GETTER get();" +
            "DATATYPE myArr = ARRAY List (10);" +
            "DATATYPE myIntArr = ARRAY INT (10);" +
            "DATATYPE node = RECORD r (a:INT, b:myArr, c:STRING);";
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
    private ZExprSchema atc3 = ZExprSchema.of(new ZVar("var1", new ZExprConst("toto", 0, ZExprConst.ConstantType.BASIC)),
            new ZVar("var2", new ZExprConst("pepe", 1, ZExprConst.ConstantType.BASIC)));

    private String evalLaw(String law, ZExprSchema scope) {
        ANTLRInputStream input = new ANTLRInputStream(law);
        AtcalLexer lexer = new AtcalLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        AtcalParser parser = new AtcalParser(tokens);
        ParseTree tree = parser.lawRefinement(); // begin parsing at lawRefinement

        // Parse datatypes declarations used for testing.
        final Map<String, ATCALType> types = parseDatatypes(datatypes);

        RefinementLawEvaluator eval = new RefinementLawEvaluator(scope, new APLVar("", null), types);
        return eval.visit(tree).toString();
    }

    private Map<String, ATCALType> parseDatatypes(String typeDec) {
        // preload the default data types (INT, FLOAT, STRING) in the type namespace.
        Map<String, ATCALType> datatypes = Maps.newHashMap();
        datatypes.put("INT", new IntType());
        datatypes.put("FLOAT", new FloatType());
        datatypes.put("STRING", new StringType());

        // parse the types definitions for the test cases
        ANTLRInputStream input = new ANTLRInputStream(typeDec);
        AtcalLexer lexer = new AtcalLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        AtcalParser parser = new AtcalParser(tokens);
        ParseTree tree = parser.datatypes();
        TypesEvaluator eval = new TypesEvaluator(datatypes);
        datatypes.putAll(eval.visit(tree));
        return datatypes;
    }

    @Test
    public void lawEvalTest1() {
        String inputExpr = "5 ==> a AS INT";
        String result = evalLaw(inputExpr, atc1);
        System.out.println(result);
    }

    @Test
    public void lawEvalTest3() {
        String inputExpr = "var3 ==> h AS myEnum";
        String result = evalLaw(inputExpr, atc1);
        System.out.println(result);
    }

    @Test
    public void lawEvalTest4() {
        String inputExpr = "var3 ==> var3 + var4.@CARD ==> a AS INT";
        String result = evalLaw(inputExpr, atc1);
        System.out.println(result);
    }

    @Test
    public void lawEvalTest5() {
        String inputExpr = "var4 ==> l AS List WITH [ var4.1 ==> a AS List WITH [var1 ==> a AS STRING, var4.1 ==> b AS INT], var4.2 ==> b AS INT]";
        String result = evalLaw(inputExpr, atc1);
        System.out.println(result);
    }

    @Test
    public void lawEvalTest6() {
        String inputExpr = "var4 ==> l AS myArr WITH [ var4.1 ==> [1] AS List WITH [var1 ==> a AS STRING], var4.2 ==> [2] AS List WITH [\"hola\" ==> b AS STRING] ]";
        String result = evalLaw(inputExpr, atc1);
        System.out.println(result);
    }

    @Test
    public void lawEvalTest7() {
        String inputExpr = "var1 ==> a AS myEnum";
        String result = evalLaw(inputExpr, atc3);
        System.out.println(result);
        assert (result.equals("[a=E1]"));
    }

    @Test
    public void lawEvalTest8() {
        String inputExpr = "var2 ==> a AS STRING";
        String result = evalLaw(inputExpr, atc3);
        System.out.println(result);
        assert (result.equals("[a='pepe']"));
    }

    @Test
    public void lawEvalTest9() {
        String inputExpr = "var2 ==> a AS INT";
        String result = evalLaw(inputExpr, atc3);
        System.out.println(result);
        assert (result.equals("[a=1]"));
    }

    @Test
    public void lawEvalTest10() {
        String inputExpr = "var2 ==> a AS myEnum MAP [ toto -> E1 , pepe -> E3 ]";
        String result = evalLaw(inputExpr, atc3);
        System.out.println(result);
        assert (result.equals("[a=E3]"));
    }

    @Test
    public void lawEvalTest11() {
        String inputExpr = "var4 ==> record AS node WITH [ var4.1 ==> .a AS INT, var2 ==> .b AS STRING ]";
        String result = evalLaw(inputExpr, atc1);
        System.out.println(result);
    }

    @Test
    public void lawEvalTest12() {
        String inputExpr = "var4 ==> r AS RECORD rec (a:INT, b:myArr, c:STRING) WITH [ var4.1 ==> .a AS INT, var2 ==> .b AS STRING ]";
        String result = evalLaw(inputExpr, atc1);
        System.out.println(result);
    }

    @Test
    public void lawEvalTest13() {
        String inputExpr = "var4 ==> r AS myIntArr WITH [ @ELEM ==> [] AS INT ]";
        String result = evalLaw(inputExpr, atc1);
        System.out.println(result);
    }
}
