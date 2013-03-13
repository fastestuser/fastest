package compserver.tcasegen.strategies;

import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;




import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import client.blogic.management.Controller;


import net.sourceforge.czt.z.ast.FreePara;
import net.sourceforge.czt.z.ast.Freetype;
import net.sourceforge.czt.z.ast.FreetypeList;
import net.sourceforge.czt.z.ast.Spec;
import net.sourceforge.czt.z.ast.ZFreetypeList;
import net.sourceforge.czt.z.impl.ZFreetypeListImpl;

import common.z.AbstractTCase;
import common.z.SpecUtils;
import common.z.TClass;
import common.z.czt.visitors.BasicTypeNamesExtractor;
import compserver.tcasegen.strategies.SetLogGrammar.*;

/* Estrategia que hace uso de SetLog para generar los casos. El parseo de Z a SetLog esta hecho basado en el codigo
 * que se utiliza en ANTLRv3 distinto al que se usa en TestRing (ANTLRv4) el cual tiene un procedimiento un poco difrente
 */
public class SetLogStrategy implements TCaseStrategy{

	private Map<String, List<String>> basicAxDefs;
	private List<FreePara> freeParas;
    private List<String> basicTypeNames;
	
	public SetLogStrategy(Map<String, List<String>> basicAxDefs,List<FreePara> freeParas,List<String> basicTypeNames) {
		this.basicAxDefs = basicAxDefs;
		this.freeParas = freeParas;
		this.basicTypeNames = basicTypeNames;
	}

	public AbstractTCase generateAbstractTCase(Spec spec, TClass tClass)  {
		
		String antlrInput = "";
		//Busco los tipos basicos en spec, que se utilizan en tClass

		/*Collection<List<String>> values = basicAxDefs.values();
		Iterator<List<String>> valuesIt = values.iterator();
		while (valuesIt.hasNext()) {
			System.out.println(valuesIt.next());
		}*/
		      
		String basicType;
		while (!basicTypeNames.isEmpty()) {
			basicType = basicTypeNames.remove(0);
			if (SpecUtils.termToLatex(tClass).contains(basicType)) {
				antlrInput = antlrInput.concat("\\begin{zed}\n" +
						          "[" + basicType + "]\n" + 
						          "\\end{zed}\n\n");
			}
		}
        
		//Busco los tipos libres en spec, que se utilizan en tClass
		Iterator<FreePara> freeParasIt = freeParas.iterator();
		 
		while (freeParasIt.hasNext()) {
			FreePara freePara = freeParasIt.next();
			FreetypeList freetypeList = freePara.getFreetypeList();
			if (freetypeList instanceof ZFreetypeListImpl) {
				ZFreetypeList zFreetypeList = (ZFreetypeListImpl) freetypeList;
				for (int i = 0; i < zFreetypeList.size(); i++) {
					Freetype freetype = zFreetypeList.get(i);
					if (SpecUtils.termToLatex(tClass).contains(freetype.getName().toString())) {
						antlrInput = antlrInput.concat("\\begin{zed}\n" +
						          SpecUtils.termToLatex(freetype) + "\n" + 
						          "\\end{zed}\n\n");
					}
				}	
			}
		}
		
		
		//parseo de Z a SetLog con ANTLR
		antlrInput = antlrInput.concat(SpecUtils.termToLatex(tClass.getMyAxPara()));
		ANTLRInputStream input = new ANTLRInputStream(antlrInput);
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
		
		catch (Exception e){ 
          e.printStackTrace(); 
		} 
		
        return null;
	}
}