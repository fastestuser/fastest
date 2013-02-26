package compserver.tcasegen.strategies;

import jpl.Query;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import net.sourceforge.czt.z.ast.Spec;

import common.z.AbstractTCase;
import common.z.SpecUtils;
import common.z.TClass;
import compserver.tcasegen.strategies.SetLogGrammar.*;

/* Estrategia que hace uso de SetLog para generar los casos. El parseo de Z a SetLog esta hecho basado en el codigo
 * que se utiliza en ANTLRv3 distinto al que se usa en TestRing (ANTLRv4) el cual tiene un procedimiento un poco difrente
 */
public class SetLogStrategy implements TCaseStrategy{

	public AbstractTCase generateAbstractTCase(Spec spec, TClass tClass) {
		String tClassString = SpecUtils.termToLatex(tClass.getMyAxPara());
		ANTLRInputStream input = new ANTLRInputStream(tClassString);
        ExprLexer lexer = new ExprLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ExprParser parser = new ExprParser(tokens);
        parser.specification();
        //System.out.println(parser.getSalida());
        
        String t1 = "consult('test.pl')";
		Query q1 = new Query(t1);
		System.out.println( t1 + " " + (q1.hasSolution() ? "succeesssded" : "failed") );
        return null;
	}
}