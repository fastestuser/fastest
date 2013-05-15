package compserver.tcasegen.strategies.setlog;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.HashMap;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import compserver.tcasegen.strategies.setlog.setlogtoz.ZVarsFiller;
import compserver.tcasegen.strategies.setlog.ztosetlog.ExprLexer;
import compserver.tcasegen.strategies.setlog.ztosetlog.ExprParser;

public class SetLogGenerator {
	private static ExprParser parser;
	
	public static HashMap<String, String> generate(String antlrInput){
		
		String setLogInput = toSetLog(antlrInput);
		String setlogOutput = runSetLog(setLogInput);
		
		
		HashMap<String,String> memory = parser.getMemory();
		HashMap<String,String> tipos = parser.getTypes();
		HashMap<String,String> zVars = parser.getZVars();
		
		ZVarsFiller zvf = new ZVarsFiller(zVars,tipos,memory,setlogOutput);
		zvf.generar();
		return zVars;
	}
	
	private static String toSetLog(String antlrInput){
		ANTLRInputStream input = new ANTLRInputStream(antlrInput);
		ExprLexer lexer = new ExprLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		parser = new ExprParser(tokens);
		parser.specification();
		return parser.getSalida();
	}
	
	private static String runSetLog(String setLogInput){
		String setlogOutput = "";
		try{
			String[] cmd = {"prolog" , "-q"};
			final Process proc = Runtime.getRuntime().exec(cmd); 
			OutputStream out = proc.getOutputStream();

			String antlrOutput = setLogInput;

			String setlogInput = "consult(setlog4617)."
					+ "\nuse_module(library(dialect/sicstus/timeout))."
					+ "\nsetlog_consult('./lib/SetLog/setlogTTF.slog')."
					+ "\ntime_out(setlog( \n"
					+ antlrOutput.substring(0,antlrOutput.lastIndexOf('&')) //quitamos el ultimo '&' el cual no corresponde
					+ "\n,_CONSTR),1000,_RET).";

			out.write(setlogInput.getBytes());
			out.close();

			BufferedReader stdError = new BufferedReader(new InputStreamReader(proc.getErrorStream()));
			String s;
			System.out.println("SETLOG OUT:\n");
			while ((s = stdError.readLine()) != null) {
				System.out.println(s);
				if (s.equals("false.") || s.equals("_RET = time_out.")) //No encontro solucion
					return null;
				if ((!s.equals("")) && (!s.startsWith("true.")) && (!s.startsWith("_CONSTR"))) {
					setlogOutput = setlogOutput.concat(s + "\n");
				}else if(s.startsWith("_CONSTR")){
					setlogOutput = s +"\n"+ setlogOutput;
					break;
				}
			}
			System.out.println("SETLOG OUT:\n" + setlogOutput);

		}
		catch (Exception e){ 
			e.printStackTrace(); 
		}
		return setlogOutput;
	}
}
