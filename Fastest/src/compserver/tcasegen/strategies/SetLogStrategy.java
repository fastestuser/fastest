package compserver.tcasegen.strategies;

import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;




import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import client.blogic.management.Controller;
import client.presentation.ClientTextUI;


import net.sourceforge.czt.z.ast.AxPara;
import net.sourceforge.czt.z.ast.FreePara;
import net.sourceforge.czt.z.ast.Freetype;
import net.sourceforge.czt.z.ast.FreetypeList;
import net.sourceforge.czt.z.ast.ParaList;
import net.sourceforge.czt.z.ast.Sect;
import net.sourceforge.czt.z.ast.Spec;
import net.sourceforge.czt.z.ast.ZFreetypeList;
import net.sourceforge.czt.z.ast.ZParaList;
import net.sourceforge.czt.z.ast.ZSect;
import net.sourceforge.czt.z.impl.ZFreetypeListImpl;

import common.z.AbstractTCase;
import common.z.SpecUtils;
import common.z.TClass;
import common.z.czt.visitors.BasicTypeNamesExtractor;
import common.z.czt.visitors.TypesExtractor;
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
		
		String schemas = "", antlrInput = "";
		
		//Busco los tipos que se utilizan en tClass
		TypesExtractor extractor = new TypesExtractor();
		HashSet<String> types = tClass.accept(extractor);
		HashSet<String> typesPrinted = new HashSet<String>();
		Iterator<String> typesIt = types.iterator();
		
		ZParaList zParaList = null;
		for (Sect sect : spec.getSect()) {
            if (sect instanceof ZSect) {
                ParaList paraList = ((ZSect) sect).getParaList();
                if (paraList instanceof ZParaList) {
                    zParaList = (ZParaList) paraList;
                }
            }
        }
		Iterator<FreePara> freeParasIt = freeParas.iterator();
		
		
		while (typesIt.hasNext()){
			
			String schemaName = typesIt.next();
			if (!typesPrinted.contains(schemaName)) {
				AxPara schema = SpecUtils.axParaSearch(schemaName, zParaList);
				String schemaString = SpecUtils.termToLatex(schema);
				if (schemaString.equals("null")){ //No es un tipo esquema
					if (basicTypeNames.contains(schemaName)){ //Es un tipo basico
						schemaString = "\\begin{zed}\n" +
						          "[" + schemaName + "]\n" + 
						          "\\end{zed}\n\n";
						antlrInput = schemaString + antlrInput;
					} else { //Es un tipo libre
						while (freeParasIt.hasNext() && schemaString.equals("null")) {
							FreePara freePara = freeParasIt.next();
							FreetypeList freetypeList = freePara.getFreetypeList();
							if (freetypeList instanceof ZFreetypeListImpl) {
								ZFreetypeList zFreetypeList = (ZFreetypeListImpl) freetypeList;
								for (int i = 0; i < zFreetypeList.size(); i++) {
									Freetype freetype = zFreetypeList.get(i);
									if (schemaName.equals(freetype.getName().toString())) {
										schemaString = "\\begin{zed}\n" +
										          SpecUtils.termToLatex(freetype) + "\n" + 
										          "\\end{zed}\n\n";
										antlrInput = schemaString + antlrInput;
										break;
									}
								}	
							}
						}
					}
				} else { //Es un tipo esquema
					schemaString = schemaString.replace("begin{schema}", "begin{schemaType}");
					schemaString = schemaString.replace("end{schema}", "end{schemaType}");
					//Agrego los tipos que se utilizan en este esquema
					HashSet<String> auxTypes = schema.accept(extractor);
					types.addAll(auxTypes);
					typesIt = types.iterator();
					schemas = schemaString + schemas;
				}
				
				typesPrinted.add(schemaName);
			}
		}
		
		antlrInput = antlrInput.concat(schemas);
		
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
			
			String antlrOutput = parser.getSalida();
			System.out.println("ANTLROUTPUT\n" + antlrOutput);
			
			String setlogInput = "consult(setlog4617)."
			+ "\nuse_module(library(dialect/sicstus/timeout))."
			+ "\nsetlog_consult('./lib/SetLog/setlogTTF.slog')."
			+ "\nsetlog( \n"
			+ antlrOutput.substring(0,antlrOutput.lastIndexOf('&')) //quitamos el ultimo & el cual no corresponde
			+ "\n,_CONSTR).";
			
			out.write(setlogInput.getBytes());
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