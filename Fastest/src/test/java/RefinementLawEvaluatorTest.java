import client.blogic.testing.atcal.*;
import client.blogic.testing.atcal.apl.*;
import client.blogic.testing.atcal.parser.AtcalLexer;
import client.blogic.testing.atcal.parser.AtcalParser;
import client.blogic.testing.atcal.z.ast.*;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * Created by cristian on 4/16/15.
 */
public class RefinementLawEvaluatorTest {

    // Z context
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

    private static final Map<String, ATCALType> DATATYPES = parseDatatypes();

    private static Map<String, ATCALType> parseDatatypes() {
        // preload the default data types (INT, FLOAT, STRING) in the type namespace.
        Map<String, ATCALType> datatypes = Maps.newHashMap();
        datatypes.put("INT", IntType.getInstance());
        datatypes.put("FLOAT", new FloatType());
        datatypes.put("STRING", new StringType());

        // test suit DATATYPES
        final String datatypesDef = "" +
                "@DATATYPES" +
                "DATATYPE myEnum = ENUM myEnum (E1, E2, E3);" +
                "DATATYPE List = CONSTRUCTOR newList() SETTER add(a, b) GETTER get();" +
                "DATATYPE myArr = ARRAY List (10);" +
                "DATATYPE myIntArr = ARRAY INT (10);" +
                "DATATYPE node = RECORD r (a:INT, b:myArr, c:STRING);";

        // parse the types definitions for the test cases
        ANTLRInputStream input = new ANTLRInputStream(datatypesDef);
        AtcalLexer lexer = new AtcalLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        AtcalParser parser = new AtcalParser(tokens);
        ParseTree tree = parser.datatypes();
        TypesEvaluator eval = new TypesEvaluator(datatypes);
        datatypes.putAll(eval.visit(tree));
        return datatypes;
    }

    private String evalLaw(String law, ZExprSchema scope) {
        ANTLRInputStream input = new ANTLRInputStream(law);
        AtcalLexer lexer = new AtcalLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        AtcalParser parser = new AtcalParser(tokens);
        ParseTree tree = parser.lawRefinement(); // begin parsing at lawRefinement
        RefinementLawEvaluator eval = new RefinementLawEvaluator(scope, new APLVar("", null), DATATYPES, new LValueFactory());
        return eval.visit(tree).toString();
    }

    private List<APLStmt> evalLaw2(String law, ZExprSchema scope) {
        ANTLRInputStream input = new ANTLRInputStream(law);
        AtcalLexer lexer = new AtcalLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        AtcalParser parser = new AtcalParser(tokens);
        ParseTree tree = parser.lawRefinement(); // begin parsing at lawRefinement
        RefinementLawEvaluator eval = new RefinementLawEvaluator(scope, new APLVar("", null), DATATYPES, new LValueFactory());
        return eval.visit(tree);
    }

    /**
     * Test integer refinement.
     */
    @Test
    public void test1() {
        String inputExpr = "5 ==> a AS INT";
        List<APLStmt> expectedStmts = Lists.newArrayList(new AssignStmt(new APLVar("a", DATATYPES.get("INT")), new LongExpr(5)));
        List<APLStmt> stmts = evalLaw2(inputExpr, atc1);
//        System.out.println(stmts);
//        System.out.println(expectedStmts);
        assert (stmts.equals(expectedStmts));
    }

    /**
     * Test integer to enumeration refinement.
     */
    @Test
    public void test2() {
        String inputExpr = "var3 ==> h AS myEnum";
        List<APLStmt> expectedStmts = Lists.newArrayList(new AssignStmt(new APLVar("h", DATATYPES.get("myEnum")), new ConsExpr("E3")));
        List<APLStmt> stmts = evalLaw2(inputExpr, atc1);
//        System.out.println(stmts);
//        System.out.println(expectedStmts);
        assert (stmts.equals(expectedStmts));
    }

    /**
     * Test propagation of Z scope evaluation.
     */
    @Test
    public void test3() {
        String inputExpr = "var3 ==> var3 + var4.@CARD ==> a AS INT";
        List<APLStmt> expectedStmts = Lists.newArrayList(new AssignStmt(new APLVar("a", DATATYPES.get("INT")), new LongExpr(4)));
        List<APLStmt> stmts = evalLaw2(inputExpr, atc1);
//        System.out.println(stmts);
//        System.out.println(expectedStmts);
        assert (stmts.equals(expectedStmts));
    }


    /**
     * Test nested contract type refinement.
     */
    @Test
    public void test4() {
        String inputExpr = "var4 ==> l AS List WITH [ var4.1 ==> a AS List WITH [var1 ==> a AS STRING, var4.1 ==> b AS INT], var4.2 ==> b AS INT]";
        List<APLStmt> expectedStmts = Lists.newArrayList(
                new AssignStmt(new APLVar("l_tmp", DATATYPES.get("List")), new CallExpr("newList", Lists.newArrayList())),
                new AssignStmt(new APLVar("a_tmp", DATATYPES.get("List")), new CallExpr("newList", Lists.newArrayList())),
                new AssignStmt(new APLVar("a", DATATYPES.get("STRING")), new StringExpr("Hello ")),
                new AssignStmt(new APLVar("b", DATATYPES.get("INT")), new LongExpr(1)),
                new SetterCallStmt(new APLVar("a_tmp", DATATYPES.get("List")), Lists.newArrayList("a", "b")),
                new AssignStmt(new APLVar("a", DATATYPES.get("List")), new APLVar("a_tmp", DATATYPES.get("List"))),
                new AssignStmt(new APLVar("b", DATATYPES.get("INT")), new LongExpr(2)),
                new SetterCallStmt(new APLVar("l_tmp", DATATYPES.get("List")), Lists.newArrayList("a", "b")),
                new AssignStmt(new APLVar("l", DATATYPES.get("List")), new APLVar("l_tmp", DATATYPES.get("List"))));
        List<APLStmt> stmts = evalLaw2(inputExpr, atc1);
//        System.out.println(stmts);
//        System.out.println(expectedStmts);
        assert (stmts.equals(expectedStmts));
    }

    /**
     * Test nested array and contract type refinement
     */
    @Test
    public void test5() {
        String inputExpr = "var4 ==> l AS myArr WITH [ var4.1 ==> [1] AS List WITH [var1 ==> a AS STRING, var4.1 ==> b AS INT]," +
                "var4.2 ==> [2] AS List WITH [\"hola\" ==> a AS STRING, var4.1 ==> b AS INT] ]";

        // Prepare expected statements list
        APLArray array = new APLArray("l", DATATYPES.get("myArr"));
        List<APLStmt> expectedStmts = Lists.newArrayList(
                new AssignStmt(array, new CallExpr("newArray", Lists.newArrayList("10"))),
                new AssignStmt(new APLVar("l1_tmp", DATATYPES.get("List")), new CallExpr("newList", Lists.newArrayList())),
                new AssignStmt(new APLVar("a", DATATYPES.get("STRING")), new StringExpr("Hello ")),
                new AssignStmt(new APLVar("b", DATATYPES.get("INT")), new LongExpr(1)),
                new SetterCallStmt(new APLVar("l1_tmp", DATATYPES.get("List")), Lists.newArrayList("a", "b")),
                new AssignStmt(array.getIndex(1), new APLVar("l1_tmp", DATATYPES.get("List"))),
                new AssignStmt(new APLVar("l2_tmp", DATATYPES.get("List")), new CallExpr("newList", Lists.newArrayList())),
                new AssignStmt(new APLVar("a", DATATYPES.get("STRING")), new StringExpr("hola")),
                new AssignStmt(new APLVar("b", DATATYPES.get("INT")), new LongExpr(1)),
                new SetterCallStmt(new APLVar("l2_tmp", DATATYPES.get("List")), Lists.newArrayList("a", "b")),
                new AssignStmt(array.getIndex(2), new APLVar("l2_tmp", DATATYPES.get("List"))));
        List<APLStmt> stmts = evalLaw2(inputExpr, atc1);
//        System.out.println(stmts);
//        System.out.println(expectedStmts);
        assert (stmts.equals(expectedStmts));
    }

    /**
     * Test constant to enumeration refinement.
     */
    @Test
    public void test6() {
        String inputExpr = "var1 ==> a AS myEnum";
        List<APLStmt> expectedStmts = Lists.newArrayList(new AssignStmt(new APLVar("a", DATATYPES.get("myEnum")), new ConsExpr("E1")));
        List<APLStmt> stmts = evalLaw2(inputExpr, atc3);
//        System.out.println(stmts);
//        System.out.println(expectedStmts);
        assert (stmts.equals(expectedStmts));
    }

    /**
     * Test constant to string refinement.
     */
    @Test
    public void test7() {
        String inputExpr = "var2 ==> a AS STRING";
        List<APLStmt> expectedStmts = Lists.newArrayList(new AssignStmt(new APLVar("a", DATATYPES.get("STRING")), new StringExpr("pepe")));
        List<APLStmt> stmts = evalLaw2(inputExpr, atc3);
//        System.out.println(stmts);
//        System.out.println(expectedStmts);
        assert (stmts.equals(expectedStmts));
    }

    /**
     * Test constant to integer refinement.
     */
    @Test
    public void test8() {
        String inputExpr = "var2 ==> a AS INT";
        List<APLStmt> expectedStmts = Lists.newArrayList(new AssignStmt(new APLVar("a", DATATYPES.get("INT")), new LongExpr(1)));
        List<APLStmt> stmts = evalLaw2(inputExpr, atc3);
//        System.out.println(stmts);
//        System.out.println(expectedStmts);
        assert (stmts.equals(expectedStmts));
    }

    /**
     * Test constant to enumeration with custom constant mapping.
     */
    @Test
    public void test9() {
        String inputExpr = "var2 ==> a AS myEnum MAP [ toto -> E1 , pepe -> E3 ]";
        List<APLStmt> expectedStmts = Lists.newArrayList(new AssignStmt(new APLVar("a", DATATYPES.get("myEnum")), new ConsExpr("E3")));
        List<APLStmt> stmts = evalLaw2(inputExpr, atc3);
//        System.out.println(stmts);
//        System.out.println(expectedStmts);
        assert (stmts.equals(expectedStmts));
    }

    /**
     * Test set to record refinement.
     */
    @Test
    public void test10() {
        String inputExpr = "var4 ==> record AS node WITH [ var4.1 ==> .a AS INT, var4.2 ==> .b AS INT ]";
        List<APLStmt> expectedStmts = Lists.newArrayList(new AssignStmt(new APLVar("record.a", DATATYPES.get("INT")), new LongExpr(1)),
                new AssignStmt(new APLVar("record.b", DATATYPES.get("INT")), new LongExpr(2)));
        List<APLStmt> stmts = evalLaw2(inputExpr, atc1);
//        System.out.println(stmts);
//        System.out.println(expectedStmts);
        assert (stmts.equals(expectedStmts));
    }

    /**
     * Test set to array refinement with wildcard references (@ELEM and [])
     */
    @Test
    public void lawEvalTest13() {
        String inputExpr = "var4 ==> r AS myIntArr WITH [ @ELEM ==> [] AS INT ]";
        APLArray array = new APLArray("r", DATATYPES.get("myIntArr"));
        List<APLStmt> expectedStmts = Lists.newArrayList(new AssignStmt(array,
                new CallExpr("newArray", Lists.newArrayList("10"))),
                new AssignStmt(array.getIndex(0), new LongExpr(1)),
                new AssignStmt(array.getIndex(1), new LongExpr(2)));
        List<APLStmt> stmts = evalLaw2(inputExpr, atc1);
//        System.out.println(stmts);
//        System.out.println(expectedStmts);
        assert (stmts.equals(expectedStmts));
    }
}
