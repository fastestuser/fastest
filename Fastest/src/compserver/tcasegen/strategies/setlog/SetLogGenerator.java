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
import compserver.tcasegen.strategies.setlog.setlogtoz.StringPointer;
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
	private static String setLogToLatexCharsReplacer(DefaultMutableTreeNode nodo,String exprS){
		ExprIterator expr = new ExprIterator(exprS);

		String ct = nodo.toString();

		if (ct.equals("\\cross"))
			return "(" + setLogToLatexCharsReplacer((DefaultMutableTreeNode) nodo.getChildAt(0),expr.next()) + "\\mapsto" + setLogToLatexCharsReplacer((DefaultMutableTreeNode) nodo.getChildAt(1),expr.next()) + ")"; 

		if (ct.equals("\\power")){
			String salida = "";
			while(expr.hasNext()){
				salida = "," + setLogToLatexCharsReplacer((DefaultMutableTreeNode) nodo.getChildAt(0),expr.next());
			}
			if (!salida.isEmpty())
				return "\\{" + salida.substring(1) + "\\}";
			return "\\{\\}";
		}
		
		if (ct.equals("\\seq")){
			String salida = "";
			while(expr.hasNext())
				salida = "," + setLogToLatexCharsReplacer((DefaultMutableTreeNode) nodo.getChildAt(0),expr.next());
			
			if (!salida.isEmpty())
				return "\\langle" + salida.substring(1) + "\\rangle";
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



	private static DefaultMutableTreeNode aglutinarCorss(DefaultMutableTreeNode nodo){
		String ct = nodo.toString();
		
		DefaultMutableTreeNode n = new DefaultMutableTreeNode(ct);
		if(ct.equals("\\cross")){
			DefaultMutableTreeNode izq = (DefaultMutableTreeNode) nodo.getChildAt(0);
			DefaultMutableTreeNode der = (DefaultMutableTreeNode) nodo.getChildAt(1);
			if (izq.toString().equals("\\cross")){
				n.add(aglutinarCorss((DefaultMutableTreeNode) izq.getChildAt(0)));
				n.add(aglutinarCorss((DefaultMutableTreeNode) izq.getChildAt(0)));
			}
			else
				n.add(aglutinarCorss((DefaultMutableTreeNode) izq));
			if (der.toString().equals("\\cross")){
				n.add(aglutinarCorss((DefaultMutableTreeNode) der.getChildAt(0)));
				n.add(aglutinarCorss((DefaultMutableTreeNode) der.getChildAt(0)));
			}
			else
				n.add(aglutinarCorss((DefaultMutableTreeNode) der));
			return n;
		}
		if(!nodo.isLeaf()){
			n.add(aglutinarCorss((DefaultMutableTreeNode) nodo.getChildAt(0)));
			return n;
		}
		
		return n;
	}

	private static void setLogToLatexCharsReplacer(){
		postfijo=0;
		Iterator<String> it = zVars.keySet().iterator();
		String var,tipo,expr;
		String varn;DefaultMutableTreeNode aux;
		while (it.hasNext()) {  
			var = it.next().toString();
			tipo = tipos.get(var);
			expr = zVars.get(var);
			
			varn = setLogToLatexCharsReplacer(SetLogUtils.toTreeNorm(tipo),expr);
			varn = varn.replace("-", "\\neg");

			zVars.put(var,varn);
		}
	}

	public static HashMap<String, String> generate(String antlrInput){

		String setLogInput = toSetLog(antlrInput);
		System.out.println("**********************************************************************************************");
		System.out.println("Entrada setlog:\n" + setLogInput);
		System.out.println("**********************************************************************************************\n");
		String setlogOutput = runSetLog(setLogInput);

		if (setlogOutput == null) //No se encontro caso
			return null;

		zNames = SetLogUtils.invertHashMap(parser.getMemory());
		tipos = parser.getTypes();
		zVars = parser.getZVars();


		ZVarsFiller zvf = new ZVarsFiller(zVars,tipos,zNames,setlogOutput);
		zvf.generar();

		setLogToLatexCharsReplacer();

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
