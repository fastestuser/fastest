package compserver.tcasegen.strategies.setlog;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import compserver.tcasegen.strategies.setlog.setlogtoz.ExprIterator;
import compserver.tcasegen.strategies.setlog.setlogtoz.ZVarsFiller;
import compserver.tcasegen.strategies.setlog.ztosetlog.ExprLexer;
import compserver.tcasegen.strategies.setlog.ztosetlog.ExprParser;

public final class SetLogGenerator {
	private static ExprParser parser;
	private static HashMap<String,String> tipos;

	//cambia los caracteres de setlog [] por langlerangle, etc...
	private static String crossReplacer(DefaultMutableTreeNode nodo,String exprS){
		ExprIterator expr = new ExprIterator(exprS);

		if (nodo.toString().equals("\\cross"))
			return "(" + crossReplacer((DefaultMutableTreeNode) nodo.getChildAt(0),expr.next()) + "," + crossReplacer((DefaultMutableTreeNode) nodo.getChildAt(1),expr.next()) + ")"; 

		return exprS;
	}


	private static void setLogToLatexCharsReplacer(HashMap<String,String> zVars,HashMap<String,String> tipos){
		Iterator<String> it = zVars.keySet().iterator();
		String var,tipo,expr;
		String varn;
		while (it.hasNext()) {  
			var = it.next().toString();
			tipo = tipos.get(var);
			expr = zVars.get(var);
			varn = crossReplacer(SetLogUtils.toTreeNorm(tipo),expr);

			varn = varn.replace('[', '$');
			varn = varn.replace(']', '#');
			varn = varn.replace("$", "\\langle");
			varn = varn.replace("#", "\\rangle");

			varn = varn.replace('{', '$');
			varn = varn.replace('}', '#');
			varn = varn.replace("$", "\\{");
			varn = varn.replace("#", "\\}");

			zVars.put(var,varn);
		}
	}

	public static HashMap<String, String> generate(String antlrInput){

		String setLogInput = toSetLog(antlrInput);
		System.out.println("**********************************************************************************************");
		System.out.println("ANTLROUTPUT\n" + setLogInput);
		System.out.println("**********************************************************************************************\n");
		String setlogOutput = runSetLog(setLogInput);

		if (setlogOutput == null) //No se encontro caso
			return null;

		HashMap<String,String> memory = parser.getMemory();
		tipos = parser.getTypes();
		HashMap<String,String> zVars = parser.getZVars();


		ZVarsFiller zvf = new ZVarsFiller(zVars,tipos,memory,setlogOutput);
		zvf.generar();

		setLogToLatexCharsReplacer(zVars,tipos);

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
					+ "\nset_prolog_flag(toplevel_print_options, [quoted(true), portray(true)])."
					+ "\nuse_module(library(dialect/sicstus/timeout))."
					+ "\nsetlog_consult('./lib/SetLog/setlogTTF.slog')."
					+ "\ntime_out(setlog( \n"
					+ antlrOutput.substring(0,antlrOutput.lastIndexOf('&')) //quitamos el ultimo '&' el cual no corresponde
					+ "\n,_CONSTR),1000,_RET).";

			out.write(setlogInput.getBytes());
			out.close();

			BufferedReader stdError = new BufferedReader(new InputStreamReader(proc.getErrorStream()));
			String s;
			System.out.println("**********************************************************************************************");
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
			//System.out.println("SETLOG OUT:\n" + setlogOutput);
			System.out.println("**********************************************************************************************\n");

		}
		catch (Exception e){ 
			e.printStackTrace(); 
		}
		return setlogOutput;
	}
}
