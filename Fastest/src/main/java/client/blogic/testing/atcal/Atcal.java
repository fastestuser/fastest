package client.blogic.testing.atcal;

import client.blogic.testing.atcal.parser.AtcalLexer;
import client.blogic.testing.atcal.parser.AtcalParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

/**
 * Created by cristian on 3/31/15.
 */
public class Atcal {

    public static void main(String[] args) throws Exception {
        // Create a CharStream that reads from standard input
        ANTLRInputStream input = new ANTLRInputStream(System.in);
        // Create a lexer that feeds off of input CharStream
        AtcalLexer lexer = new AtcalLexer(input);
        // Create a buffer of tokens pulled from the lexer
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        // Create a parser that feeds off the tokens buffer
        AtcalParser parser = new AtcalParser(tokens);
        ParseTree tree = parser.refinementRule(); // begin parsing at init rule
        System.out.println(tree.toStringTree(parser)); // print LISP-style tree
    }
}
