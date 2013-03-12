package compserver.tcasegen.strategies;

import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.io.OutputStream;




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

	public AbstractTCase generateAbstractTCase(Spec spec, TClass tClass)  {
		//parseo de Z a SetLog con ANTLR
		String tClassString = SpecUtils.termToLatex(tClass.getMyAxPara());
		ANTLRInputStream input = new ANTLRInputStream(tClassString);
        ExprLexer lexer = new ExprLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ExprParser parser = new ExprParser(tokens);
        parser.specification();
        
        
        
        //Ejecucion de SetLog
		try{
			String[] cmd = {"prolog" , "-q"};
			final Process proc = Runtime.getRuntime().exec(cmd); 
			OutputStream out = proc.getOutputStream();
			
			String goal,setLogOutput;
			setLogOutput = parser.getSalida();
			
			goal = "consult(setlog4617)."
			+ "\nuse_module(library(dialect/sicstus/timeout))."
			+ "\nsetlog_consult('./lib/SetLog/setlogTTF.slog')."
			+ "\nsetlog( \n"
			+ setLogOutput.substring(0,setLogOutput.lastIndexOf('&')) //quitamos el ultimo & el cual no corresponde
			+ "\n,_CONSTR).";
			
			out.write(goal.getBytes());
			out.close();
			
		    BufferedReader stdError = new BufferedReader(new InputStreamReader(proc.getErrorStream()));
		    String s;
		    while ((s = stdError.readLine()) != null) {
		       System.out.println(s);
		    }
		}
		catch (Exception e) 
		{ 
          e.printStackTrace(); 
		} 
		
		
				
        return null;
	}
}