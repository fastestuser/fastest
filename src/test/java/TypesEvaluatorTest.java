import client.blogic.testing.atcal.*;
import client.blogic.testing.atcal.parser.AtcalLexer;
import client.blogic.testing.atcal.parser.AtcalParser;
import com.google.common.collect.Maps;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;

import java.util.Map;

/**
 * Created by Cristian on 15/05/15.
 */
public class TypesEvaluatorTest {

    private Map<String, ATCALType> parseDatatypes(String typeDec) {
        // preload the default data types (INT, FLOAT, STRING) in the type namespace.
        Map<String, ATCALType> datatypes = Maps.newHashMap();
        datatypes.put("INT", IntType.getInstance());
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
    public void test1() {
        String testA = "@DATATYPES" +
                "DATATYPE myInt = INT;" +
                "DATATYPE myFloat = FLOAT;" +
                "DATATYPE myString = STRING;" +
                "DATATYPE myArray = ARRAY myInt (10);" +
                "DATATYPE contract = CONSTRUCTOR c(a,b,c) SETTER s(d,e,f) GETTER g(h,i,j);" +
                "DATATYPE toto = myInt;" +
                "DATATYPE myRecord = RECORD r (a:INT, b:ARRAY INT (4), c:CONSTRUCTOR c(a,b,c) " +
                "SETTER s(d,e,f) GETTER g(h,i,j), d:RECORD r2 (x:STRING));";
        System.out.println(parseDatatypes(testA));
    }
}
