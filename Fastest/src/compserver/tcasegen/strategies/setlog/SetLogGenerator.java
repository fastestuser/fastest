package compserver.tcasegen.strategies.setlog;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLDecoder;
import java.util.HashMap;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import compserver.tcasegen.strategies.SetLogStrategy;
import compserver.tcasegen.strategies.setlog.setlogtoz.ZVarsFiller;
import compserver.tcasegen.strategies.setlog.ztosetlog.ExprLexer;
import compserver.tcasegen.strategies.setlog.ztosetlog.ExprParser;

public final class SetLogGenerator {
	private static ExprParser parser;
	private static HashMap<String,String> tipos;
	private static HashMap<String, String> zNames;
	private static HashMap<String, String> zVars;

	
	public static HashMap<String, String> generate(String antlrInput, int timeout){

		String setLogInput;
		try {
			setLogInput = toSetLog(antlrInput);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error when translating to {log}: " + e.toString());
			return null;
		}
		//System.out.println("**********************************************************************************************");
		//System.out.println("Entrada setlog:\n" + setLogInput.replace("&", "&\n"));
		//System.out.println("**********************************************************************************************\n");

		String setlogOutput = runSetLog(setLogInput, timeout);

		if (setlogOutput == null) //No se encontro caso
			return null;
		else if (setlogOutput.equals("FALSE"))
			return new HashMap<String, String>() ;

		zNames = SetLogUtils.invertHashMap(parser.getMemory());
		tipos = parser.getTypes();
		zVars = parser.getZVars();
		//SetLogUtils.printHashMap(zVars);

		ZVarsFiller zvf = new ZVarsFiller(zVars,tipos,zNames,setlogOutput);
		
		try{
			zvf.generar();
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error when translating from {log}: " + e.toString());
			return null;
		}
		
		return zVars;
	}

	private static String toSetLog(String antlrInput) throws Exception{
	
		ANTLRInputStream input = new ANTLRInputStream(antlrInput);
		ExprLexer lexer = new ExprLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		parser = new ExprParser(tokens);
		parser.specification();
		return parser.getSalida();
	}

	private static String runSetLog(String setLogInput, int timeout){
		String setlogOutput = "";
		try{
			String[] cmd = {"prolog" , "-q"};
			final Process proc = Runtime.getRuntime().exec(cmd); 
			OutputStream out = proc.getOutputStream();
			
			URL location = SetLogGenerator.class.getProtectionDomain().getCodeSource().getLocation();
			String path = location.getFile();
			if (path.endsWith("/")) //Al correrlo desde eclipse, el path termina en /bin/, con lo cual se elimina primero la ultima /
				path = path.substring(0, path.lastIndexOf("/"));
			path = path.substring(0, path.lastIndexOf("/")); //Luego, se elimina la ultima parte del path, ya sea /bin o /fastest.jar si se esta corriendo desde un jar
			path = path + "/lib/setlog/"; //Por ultimo agregamos la direccion de setlog
			path = URLDecoder.decode(path, "UTF-8");
			//System.out.println("DIRECTORIO: " + path + "setlog4617.pl");
			
			String goal = "consult('" + path + "setlog4617.pl')."
					+ "\nset_prolog_flag(toplevel_print_options, [quoted(true), portray(true)])."
					+ "\nuse_module(library(dialect/sicstus/timeout))."
					+ "\nsetlog_consult('" + path + "setlogTTF.slog')."
					+ "\ntime_out(setlog( \n"
					+ setLogInput.substring(0,setLogInput.lastIndexOf('&')) //quitamos el ultimo '&' el cual no corresponde
					+ "\n,_CONSTR)," + timeout + ",_RET).\n";

			
			out.write(goal.getBytes());
			out.close();

			boolean pruneClass = false;
			BufferedReader stdError = new BufferedReader(new InputStreamReader(proc.getErrorStream()));
			String s;
			//System.out.println("**********************************************************************************************");
			//System.out.println("SETLOG OUT:\n");
			while ((s = stdError.readLine()) != null) {
				//System.out.println(s);
				if (s.equals("false.")) {
					pruneClass = true;
					break;
				}
				else if (s.equals("_RET = time_out.") || s.startsWith("ERROR:")) //No encontro solucion
					return null;
				else if ((!s.equals("")) && (!s.startsWith("true.")) && (!s.startsWith("_CONSTR"))) {
					setlogOutput = setlogOutput.concat(s + "\n");
				}else if(s.startsWith("_CONSTR")){
					//setlogOutput = s +"\n"+ setlogOutput;
					setlogOutput = setlogOutput  + "\n" + s;
					break;
				}
			}
			//System.out.println("SETLOG OUT:\n" + setlogOutput.replace("&", "&\n"));
			//System.out.println("**********************************************************************************************\n");
			
			if (pruneClass) {
				return "FALSE";
			}

		}
		catch (Exception e){ 
			e.printStackTrace();
			return null;
		}
		return setlogOutput;
	}
}
