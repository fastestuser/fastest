package compserver.tcasegen.strategies.setlog;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.tree.DefaultMutableTreeNode;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import common.z.SpecUtils;
import compserver.tcasegen.strategies.setlog.setlogtoz.ExprIterator;
import compserver.tcasegen.strategies.setlog.setlogtoz.ZVarsFiller;
import compserver.tcasegen.strategies.setlog.ztosetlog.ExprLexer;
import compserver.tcasegen.strategies.setlog.ztosetlog.ExprParser;

public final class SetLogGenerator {
	private static ExprParser parser;
	private static HashMap<String,String> tipos;
	private static HashMap<String, String> zNames;
	private static HashMap<String, String> zVars;
	private static int postfijo;
	private static String getNumber(){
		return String.valueOf(postfijo++);
	}

	//cambia los caracteres de setlog [] por langlerangle, etc...
	private static String setLogToLatexCharsReplacer(DefaultMutableTreeNode nodo,String exprS) throws Exception{
		ExprIterator expr = new ExprIterator(exprS);

		String ct = nodo.toString();


		if(exprS.startsWith("int(")){
			String aux[] = exprS.substring(4,exprS.length()-1).split(",");
			return aux[0] + " \\upto " + aux[1];
		}
		
		if (ct.equals("()")) 
			return "(" + setLogToLatexCharsReplacer((DefaultMutableTreeNode) nodo.getChildAt(0),exprS) + ")";
		
		if (ct.equals("\\pfun")||ct.equals("\\fun")||ct.equals("\\ffun")||ct.equals("\\rel")){
			String salida = "";
			String coma = ct.equals("\\rel")?",":"\\mapsto ";
			ExprIterator exprAux;
			while(expr.hasNext()){
				exprAux = new ExprIterator(expr.next());
				salida += "," + "(" + setLogToLatexCharsReplacer((DefaultMutableTreeNode) nodo.getChildAt(0),exprAux.next()) + coma + setLogToLatexCharsReplacer((DefaultMutableTreeNode) nodo.getChildAt(1),exprAux.next()) + ")";
			}
			if (!salida.isEmpty())
				return "\\{" + salida.substring(1) + "\\}";
			return "\\emptyset";
		}
		
		if (ct.equals("\\cross")){
			String salida = "";
			String coma = nodo.getChildCount()>2?",":" \\mapsto ";
			int i = 0;
			while(expr.hasNext()){
				salida += coma + setLogToLatexCharsReplacer((DefaultMutableTreeNode) nodo.getChildAt(i),expr.next());
				i++;
			}
			return "(" + salida.substring(1) + ")";
		}
		
		if (ct.equals("\\power")){
			String salida = "";
			while(expr.hasNext()){
				salida += "," + setLogToLatexCharsReplacer((DefaultMutableTreeNode) nodo.getChildAt(0),expr.next());
			}
			if (!salida.isEmpty())
				return "\\{" + salida.substring(1) + "\\}";
			return "\\emptyset";
		}
		
		if (ct.equals("\\seq")){
			String salida = "";
			while(expr.hasNext())
				salida += "," + setLogToLatexCharsReplacer((DefaultMutableTreeNode) nodo.getChildAt(0),expr.next());
			
			if (!salida.isEmpty())
				return "\\langle " + salida.substring(1) + "\\rangle";
			return "\\langle\\rangle";
		}
		
		String tipocompleto = tipos.get(ct);

		if (tipocompleto !=null){
			if (tipocompleto.startsWith("SchemaType")){
				ExprIterator tiposDecl = SetLogUtils.schemaToTypeExprIterator(ct, tipocompleto);
				ExprIterator varsDecl = SetLogUtils.schemaToVarExprIterator(ct, tipocompleto);
				String c,v,salida="";
				while(expr.hasNext()){
					c = expr.next();
					v = varsDecl.next();
					salida += "," + v + "==" + setLogToLatexCharsReplacer(SetLogUtils.toTreeNorm(tiposDecl.next()),c); 
				}
				if (!salida.isEmpty())
					return "\\lblot " + salida.substring(1) + " \\rblot";
				return "\\lblot\\rblot";
			}

			if (tipocompleto.startsWith("EnumerationType"))
				return zNames.get(exprS);

			if (tipocompleto.startsWith("BasicType")){
				String salida = zNames.get(exprS);
				salida = ct.toLowerCase() + (salida!=null?salida:getNumber());
				salida = salida.replace("?","");
				return salida;
			}
		}
		
		return exprS;
	}

	private static void setLogToLatexCharsReplacer() throws Exception{
		postfijo=0;
		Iterator<String> it = zVars.keySet().iterator();
		String var,tipo,expr;
		String varn;
		while (it.hasNext()) {  
			var = it.next().toString();
			tipo = tipos.get(var);
			expr = zVars.get(var);
			varn = setLogToLatexCharsReplacer(SetLogUtils.toTree(tipo),expr);
			varn = varn.replace("-", "\\negate ");
			zVars.put(var,varn);
		}
	}

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
			setLogToLatexCharsReplacer();
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
			
			String goal = "consult('./lib/SetLog/setlog4617.pl')."
					+ "\nset_prolog_flag(toplevel_print_options, [quoted(true), portray(true)])."
					+ "\nuse_module(library(dialect/sicstus/timeout))."
					+ "\nsetlog_consult('./lib/SetLog/setlogTTF.slog')."
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
					setlogOutput = s +"\n"+ setlogOutput;
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
		}
		return setlogOutput;
	}
}
