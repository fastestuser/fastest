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
	
	//cambia los caracteres de setlog [] por langlerangle, etc...
	private static String setLogToLatexCharsReplacer(DefaultMutableTreeNode nodo,String exprS){
		ExprIterator expr = new ExprIterator(exprS);
		char c = exprS.charAt(0);
		String ct = nodo.toString();
		String salida = null;
		
		if(ct.equals("\\cross")){
			return "(" + setLogToLatexCharsReplacer((DefaultMutableTreeNode) nodo.getChildAt(0),expr.next()) + "," + setLogToLatexCharsReplacer((DefaultMutableTreeNode) nodo.getChildAt(1),expr.next()) + ")"; 
		}
		else if(ct.equals("\\power")){
			if(c == '['){
				DefaultMutableTreeNode naux = new DefaultMutableTreeNode("\\seq");
				// powe->()->x->A        (der)
				//			  ->NUM|NAT  (izq)
				DefaultMutableTreeNode nauxHijo = (DefaultMutableTreeNode) ((nodo.getChildAt(0)).getChildAt(0)).getChildAt(1);
				naux.add(nauxHijo);
				return setLogToLatexCharsReplacer(naux,exprS);
			}
			else{
					//pinta {X,X,X}
					if(	exprS.charAt(1)=='}')
						return "\\{\\}";
					String elem;
					salida = "\\{";
					while(expr.hasNext()){
						elem = expr.next();
						salida = salida + setLogToLatexCharsReplacer((DefaultMutableTreeNode) nodo.getChildAt(0),elem) + ","; 
					}
					//le quito la coma final
					if (salida.charAt(salida.length()-1) == ',')
						salida = salida.substring(0, salida.length()-1);
					return salida + "\\}";
				}
		}
		else if(ct.equals("\\seq")){
			//pinta [X,X,X]
			if(	exprS.charAt(1)==']')
				return "\\langle\\rangle";
			
			String elem;
			salida = "\\langle";
			while(expr.hasNext()){
				elem = expr.next();
				salida = salida + setLogToLatexCharsReplacer((DefaultMutableTreeNode) nodo.getChildAt(0),elem) + ","; 
			}
			//le quito la coma final
			if (salida.charAt(salida.length()-1) == ',')
				salida = salida.substring(0, salida.length()-1);
			return salida + "\\rangle";
		}
		salida = exprS;
		return salida;
	}
	
	
	private static void setLogToLatexCharsReplacer(HashMap<String,String> zVars,HashMap<String,String> tipos){
		Iterator<String> it = zVars.keySet().iterator();
		String var,tipo,expr;
		while (it.hasNext()) {  
			var = it.next().toString();
			tipo = tipos.get(var);
			expr = zVars.get(var);
			zVars.put(var, setLogToLatexCharsReplacer(SetLogUtils.toTreeNorm(tipo),expr));
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
		HashMap<String,String> tipos = parser.getTypes();
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
