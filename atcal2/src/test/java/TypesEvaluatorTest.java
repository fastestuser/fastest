import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.fastest.atcal.ATCALType;
import org.fastest.atcal.TypesEvaluator;
import org.fastest.atcal.parser.AtcalLexer;
import org.fastest.atcal.parser.AtcalParser;
import org.junit.Test;

import java.util.Map;

/**
 * Created by Cristian on 15/05/15.
 */
public class TypesEvaluatorTest {

    Map<String, ATCALType> parseTypeDec(String typeDec) {
        ANTLRInputStream input = new ANTLRInputStream(typeDec);
        AtcalLexer lexer = new AtcalLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        AtcalParser parser = new AtcalParser(tokens);
        ParseTree tree = parser.typeDec();
        TypesEvaluator eval = new TypesEvaluator();
        return eval.visit(tree);
    }

    @Test
    public void test1() {
        String intType = "DATATYPE myInt = INT;";
        System.out.println(parseTypeDec(intType));

        String floatType = "DATATYPE myFloat = FLOAT;";
        System.out.println(parseTypeDec(floatType));

        String StringType = "DATATYPE myString = STRING;";
        System.out.println(parseTypeDec(StringType));

        String arrayType = "DATATYPE myArray = ARRAY toto (10);";
        System.out.println(parseTypeDec(arrayType));

        String contractType = "DATATYPE contract = CONSTRUCTOR c(a,b,c) SETTER s(d,e,f) GETTER g(h,i,j);";
        System.out.println(parseTypeDec(contractType));

        String recordType = "DATATYPE myRecord = RECORD r (a:INT, b:ARRAY toto (4), c:CONSTRUCTOR c(a,b,c) SETTER s(d,e,f) GETTER g(h,i,j), d:RECORD r2 (x:STRING));";
        System.out.println(parseTypeDec(recordType));
    }
}
