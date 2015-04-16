import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.fastest.atcal.parser.AtcalLexer;
import org.fastest.atcal.parser.AtcalParser;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Cristian on 3/31/15.
 */
public class AtcalParserTest {

    @Test
    public void testParser() throws Exception {
        assertNotNull("Test file missing", getClass().getResource("/test1.tcrl"));

        ANTLRInputStream input = new ANTLRInputStream(getClass().getResourceAsStream("/test1.tcrl"));
        AtcalLexer lexer = new AtcalLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        AtcalParser parser = new AtcalParser(tokens);
        ParseTree tree = parser.refinementRule(); // begin parsing at init rule
        System.out.println(tree.toStringTree(parser)); // print LISP-style tree
    }
}
