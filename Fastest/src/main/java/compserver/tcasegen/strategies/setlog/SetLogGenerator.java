package compserver.tcasegen.strategies.setlog;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import client.blogic.management.Controller;
import common.repository.AbstractIterator;
import compserver.tcasegen.strategies.setlog.setlogtoz.ZVarsFiller;
import compserver.tcasegen.strategies.setlog.ztosetlog.ExprLexer;
import compserver.tcasegen.strategies.setlog.ztosetlog.ExprParser;

public final class SetLogGenerator {
	private  ExprParser parser;
	private  HashMap<String,String> tipos;
	private  HashMap<String, String> zNames;
	private  HashMap<String, String> zVars;

	public  HashMap<String, String> generate(String antlrInput, Controller controller){

		int timeout = controller.getSetlogTimeout();
		String setlogFile = controller.getSetlogFile();
		boolean setlogPrint = controller.getSetlogPrint();
		
		String setLogInput;
		Map<String, List<String>> basicAxDef = controller.getBasicAxDefs();
		try {
			setLogInput = toSetLog(antlrInput,basicAxDef);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error when translating to {log}: " + e.toString());
			return null;
		}
		
		if (setlogPrint) {
			System.out.println("---");
			System.out.print("Translation to setlog:\n" + setLogInput.replace("&", "&\n"));
			System.out.println("---\n");
		}

		//setLogInput = "STATUS = {normal,failure} & REVENT = {liftOff,thrustDrop1E,thrustDrop2E,thrustDrop3E} & dom(Tli,VAR0) & VAR0 = REVENT & dom(Tls,VAR1) & VAR1 = REVENT & dom(X,VAR2) & VAR2 = REVENT & NAT = int(0, 2147483647) & Now ein NAT & dom(Ot,VAR3) & dsubset(VAR3,REVENT) & SysState in STATUS & Fa ein NAT & E in REVENT & SysState = normal & E nin VAR3 & apply(Tli,E,VAR4) & VAR4 ein NAT & apply(Tls,E,VAR5) & VAR5 ein NAT & VAR6 = int(VAR4,VAR5) & Now ein VAR6 & apply(X,E,VAR7) & VAR7 ein NAT & VAR7 >= Fa & E = thrustDrop3E & Ot neq {} & {[E,Now]} neq {} & dinters(Ot,{[E,Now]},VAR8) & VAR8 = {} & Now = 4 & is_pfun(Tli) & is_pfun(Tls) & is_pfun(X) & is_pfun(Ot) & STATUS = {normal,failure} & REVENT = {liftOff,thrustDrop1E,thrustDrop2E,thrustDrop3E} & Tli = {[liftOff,_G1098],[thrustDrop1E,_G1147],[thrustDrop2E,_G1196],[thrustDrop3E,0]} & VAR0 = {liftOff,thrustDrop1E,thrustDrop2E,thrustDrop3E} & Tls = {[liftOff,_G1371],[thrustDrop1E,_G1420],[thrustDrop2E,_G1469],[thrustDrop3E,4]} & VAR1 = {liftOff,thrustDrop1E,thrustDrop2E,thrustDrop3E} & X = {[liftOff,_G1644],[thrustDrop1E,_G1693],[thrustDrop2E,_G1742],[thrustDrop3E,0]} & VAR2 = {liftOff,thrustDrop1E,thrustDrop2E,thrustDrop3E} & NAT = int(0,2147483647) & Now = 4 & Ot = {[thrustDrop2E,_G2304]} & VAR3 = {thrustDrop2E} & SysState = normal & Fa = 0 & E = thrustDrop3E & VAR4 = 0 & VAR5 = 4 & VAR6 = int(0,4) & VAR7 = 0 & VAR8 = {} & STATUS = {normal,failure} & REVENT = {liftOff,thrustDrop1E,thrustDrop2E,thrustDrop3E} & Tli = {[liftOff,_G1098],[thrustDrop1E,_G1147],[thrustDrop2E,_G1196],[thrustDrop3E,0]} & "+
//"VAR0 = {liftOff,thrustDrop1E,thrustDrop2E,thrustDrop3E} & Tls = {[liftOff,_G1371],[thrustDrop1E,_G1420],[thrustDrop2E,_G1469],[thrustDrop3E,4]} & VAR1 = {liftOff,thrustDrop1E,thrustDrop2E,thrustDrop3E} & X = {[liftOff,_G1644],[thrustDrop1E,_G1693],[thrustDrop2E,_G1742],[thrustDrop3E,0]} & VAR2 = {liftOff,thrustDrop1E,thrustDrop2E,thrustDrop3E} & NAT = int(0,2147483647) & Now = 4 & Ot = {[thrustDrop2E,_G2304]} & VAR3 = {thrustDrop2E} & SysState = normal & Fa = 0 & E = thrustDrop3E & VAR4 = 0 & VAR5 = 4 & VAR6 = int(0,4) & VAR7 = 0 & VAR8 = {} &";
		
		String setlogOutput = runSetLog(setLogInput, setlogFile, timeout);
		
		AbstractIterator<String> it = controller.getClassToTestRep().createIterator();
		while(it.hasNext()){
			System.out.println("****" + it.next());
		}
		

		if (setlogOutput == null) //No se encontro caso
			return null;
		else if (setlogOutput.equals("FALSE"))
			return new HashMap<String, String>() ;

		zNames = SetLogUtils.invertHashMap(parser.getMemory());
		tipos = parser.getTypes();
		zVars = parser.getZVars();

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
	
	private  String toSetLog(String antlrInput,Map<String, List<String>> basicAxDef) throws Exception{
		ANTLRInputStream input = new ANTLRInputStream(antlrInput);
		ExprLexer lexer = new ExprLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		parser = new ExprParser(tokens);
		parser.setBasicAxDef((HashMap<String, List<String>>)basicAxDef);
		parser.specification();
		return parser.getSalida();
	}

	private  String runSetLog(String setLogInput, String setlogFile, int timeout){
		StringBuilder setlogOutput = new StringBuilder();
		try{
			String[] cmd = {"prolog" , "-q"};
			final Process proc = Runtime.getRuntime().exec(cmd); 
			OutputStream out = proc.getOutputStream();

			URL location = SetLogGenerator.class.getProtectionDomain().getCodeSource().getLocation();
			String path = location.getFile();
			if (path.endsWith("/")) //Al correrlo desde eclipse, el path termina en /bin/, con lo cual se elimina primero la ultima /
				path = path.substring(0, path.lastIndexOf("/"));
			//Luego, se elimina la ultima parte del path, ya sea /bin o /fastest.jar si se esta corriendo desde un jar
			//Por ultimo agregamos la direccion de setlog
			path = path.substring(0, path.lastIndexOf("/")) + "/lib/setlog/"; 
			path = URLDecoder.decode(path, "UTF-8");

			String goal = "consult('" + path + setlogFile + "')."//"setlog4617.pl')."
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
				else if (s.equals("_RET = time_out.") || s.startsWith("ERROR:") || s.startsWith("***WARNING***")) //No encontro solucion
					return null;
				else if ((!s.equals("")) && (!s.startsWith("true.")) && (!s.startsWith("_CONSTR"))) {
					setlogOutput.append(s + "\n");
				}else if(s.startsWith("_CONSTR")){
					setlogOutput.insert(0,s +"\n"+ setlogOutput);
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
		return setlogOutput.toString();
	}
}
