package compserver.tcasegen.strategies;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.tree.DefaultMutableTreeNode;




import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import net.sourceforge.czt.animation.eval.ZLive;
import net.sourceforge.czt.parser.z.ParseUtils;
import net.sourceforge.czt.session.CommandException;
import net.sourceforge.czt.session.StringSource;
import net.sourceforge.czt.z.ast.AxPara;
import net.sourceforge.czt.z.ast.Expr;
import client.blogic.management.Controller;
import client.presentation.ClientTextUI;


import net.sourceforge.czt.animation.eval.ZLive;
import net.sourceforge.czt.parser.z.ParseUtils;
import net.sourceforge.czt.session.CommandException;
import net.sourceforge.czt.session.StringSource;
import net.sourceforge.czt.z.ast.AxPara;
import net.sourceforge.czt.z.ast.Expr;
import net.sourceforge.czt.z.ast.FreePara;
import net.sourceforge.czt.z.ast.Freetype;
import net.sourceforge.czt.z.ast.FreetypeList;
import net.sourceforge.czt.z.ast.Pred;
import net.sourceforge.czt.z.ast.RefExpr;
import net.sourceforge.czt.z.ast.ParaList;
import net.sourceforge.czt.z.ast.Pred;
import net.sourceforge.czt.z.ast.RefExpr;
import net.sourceforge.czt.z.ast.Sect;
import net.sourceforge.czt.z.ast.Spec;
import net.sourceforge.czt.z.ast.ZFreetypeList;
import net.sourceforge.czt.z.ast.ZParaList;
import net.sourceforge.czt.z.ast.ZSect;
import net.sourceforge.czt.z.impl.ZFactoryImpl;
import net.sourceforge.czt.z.impl.ZFreetypeListImpl;

import common.z.AbstractTCase;
import common.z.AbstractTCaseImpl;
import common.z.SpecUtils;
import common.z.TClass;
import common.z.TClassImpl;

import common.z.czt.UniqueZLive;
import common.z.czt.visitors.BasicTypeNamesExtractor;

import common.z.czt.visitors.CZTCloner;
import common.z.czt.visitors.CZTReplacer;
import common.z.czt.visitors.BasicTypeNamesExtractor;
import common.z.czt.visitors.TypesExtractor;
import compserver.tcasegen.strategies.SetLogGrammar.*;

/* Estrategia que hace uso de SetLog para generar los casos. El parseo de Z a SetLog esta hecho basado en el codigo
 * que se utiliza en ANTLRv3 distinto al que se usa en TestRing (ANTLRv4) el cual tiene un procedimiento un poco difrente
 */
public class SetLogStrategy implements TCaseStrategy{

	private Map<RefExpr, Expr> axDefsValues;
	private Map<String, List<String>> basicAxDefs;
	private List<FreePara> freeParas;
	private List<String> basicTypeNames; 
    
    private void printHashMap(HashMap<String,String> map){
		Iterator<String> iterator = map.keySet().iterator();  
		String key,value;
		while (iterator.hasNext()) {  
		   key = iterator.next().toString();
		   if (map.get(key) == null)
			   value = "nullc";
		   else 
			   value = map.get(key).toString();
		   System.out.println(key + " = " + value);  
		} 
	}
    
    private HashMap<String,String> invertMap(HashMap<String,String> m){
		Iterator<String> iterator = m.keySet().iterator();  
   		HashMap<String,String> s = new HashMap<String,String>();
   		
		while (iterator.hasNext()) {  
		   String key = iterator.next().toString();  
		   String value = m.get(key).toString();  
		   s.put(value,key);
		} 	
		return s;
	}
    
    private HashMap<String,String> llenarZVars(ExprParser exprP, SLog2ZParser SL2ZP){
    	HashMap<String, String> zVars = SL2ZP.getZVars();
    	HashMap<String, String> sLogName = exprP.getMemory();
    	HashMap<String,String> zNames = invertMap(exprP.getMemory());
    	
        Iterator<String> iterator = zVars.keySet().iterator();  
		String key,valor;
		ConstantCreator cc; 
		HashMap<String,String> tipos = exprP.getTypes();
		while (iterator.hasNext()) {  
			key = iterator.next().toString();
			valor = zVars.get(key);
			if (valor == null){
				
				String tipo = tipos.get(key);
				ANTLRInputStream input = new ANTLRInputStream(tipo);
		        TypeManagerLexer lexer = new TypeManagerLexer(input);
		        CommonTokenStream tokens = new CommonTokenStream(lexer);
		        TypeManagerParser TMP = new TypeManagerParser(tokens);
		        TMP.typeManage();
		        DefaultMutableTreeNode root =  TMP.getRoot();
		        
		        cc = new ConstantCreator(sLogName.get(key),root,tipos,zNames,null);
		        valor =  cc.getCte();
				zVars.put(key, valor);
			}  
		}
		return (HashMap<String, String>) zVars;
    }
	
	public SetLogStrategy(Map<RefExpr, Expr> axDefsValues, Map<String, List<String>> basicAxDefs,List<FreePara> freeParas,List<String> basicTypeNames) {
		this.axDefsValues = axDefsValues;
		this.basicAxDefs = basicAxDefs;
		this.freeParas = freeParas;
		this.basicTypeNames = basicTypeNames;
	}

	public AbstractTCase generateAbstractTCase(Spec spec, TClass tClass)  {
		//Reemplazamos las definiciones axiomaticas por sus valores
		if (axDefsValues != null) {

			AxPara tClassAxPara = (AxPara) tClass.getMyAxPara().accept(new CZTCloner());
			String tClassName = tClass.getSchName();
			Pred pred = SpecUtils.getAxParaPred(tClassAxPara);
			Set<Map.Entry<RefExpr, Expr>> set = axDefsValues.entrySet();
			Iterator<Map.Entry<RefExpr, Expr>> iterator = set.iterator();
			CZTReplacer replaceVisitor = new CZTReplacer();

			while (iterator.hasNext()) {
				Map.Entry<RefExpr, Expr> mapEntry = iterator.next();
				RefExpr refExpr = mapEntry.getKey();
				Expr expr = mapEntry.getValue();
				replaceVisitor.setOrigTerm(refExpr);
				replaceVisitor.setNewTerm(expr);
				pred = (Pred) pred.accept(replaceVisitor);
			}

			SpecUtils.setAxParaPred(tClassAxPara, pred);
			tClass = new TClassImpl(tClassAxPara, tClassName);
		}

		//Buscamos los tipos que aparecen en tClass, para incluir
		//su informacion en la entrada del parser
		String schemas = "", antlrInput = "";

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

		//Busco los tipos que se utilizan en tClass
		TypesExtractor extractor = new TypesExtractor();
		HashSet<String> types = SpecUtils.getAxParaListOfDecl(tClass).accept(extractor);
		HashSet<String> typesPrinted = new HashSet<String>();
		Iterator<String> typesIt = types.iterator();

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
					//Reemplazo necesario en el parser de ANTLR
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
		antlrInput = antlrInput.concat(SpecUtils.termToLatex(tClass.getMyAxPara()));
		System.out.println("ANTLRINPUT\n" + antlrInput);

		//parseo de Z a SetLog con ANTLR
		ANTLRInputStream input = new ANTLRInputStream(antlrInput);
		ExprLexer lexer = new ExprLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		ExprParser parser = new ExprParser(tokens);
		//tambien imprime en pantalla
		parser.specification();

		String auxs = parser.getSalida().replaceAll("&", "\n");
		System.out.println("\n salida antlr:\n" + auxs );

		//Ejecucion de SetLog
		String setlogOutput = "";
		try{
			String[] cmd = {"prolog" , "-q"};
			final Process proc = Runtime.getRuntime().exec(cmd); 
			OutputStream out = proc.getOutputStream();

			String antlrOutput = parser.getSalida();
			System.out.println("ANTLROUTPUT\n" + antlrOutput);

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
		//traduccion de SLog a Z
		//setlogOutput = "Balances = {[N, 0]},\nVAR0 = 0,\nClients = Owners, Owners = {},";
		input = new ANTLRInputStream(setlogOutput);
        SLog2ZLexer lexer2 = new SLog2ZLexer(input);
        tokens = new CommonTokenStream(lexer2);
        SLog2ZParser parser2 = new SLog2ZParser(tokens);
        parser2.loadTablas(parser);
        
        //tambien imprime en pantalla
        parser2.lineas();
        Map<String, String> zVars = llenarZVars(parser,parser2);
        System.out.println("\nzVars llenas****************\n");
        printHashMap((HashMap) zVars);

		//Creamos el caso de prueba a partir de los valores de las variables obtenidas
		Map<RefExpr, Expr> map = new HashMap<RefExpr, Expr>();
		//Map<String, String> zVars = parser2.getZVars();
		Iterator<String> keys = zVars.keySet().iterator();
		ZLive zLive = UniqueZLive.getInstance();

		while (keys.hasNext()) {
			String varName = keys.next();
			String value = zVars.get(varName);
			System.out.println("------ " + varName + " = " + value);
			if (value != null) {
				RefExpr var;
				Expr val;
				try {
					var = (RefExpr) ParseUtils.parseExpr(new StringSource(varName), zLive.getCurrentSection(), zLive.getSectionManager());
					System.out.println("------ " + SpecUtils.termToLatex(var));
					val = ParseUtils.parseExpr(new StringSource(value), zLive.getCurrentSection(), zLive.getSectionManager());
					System.out.println("------ " + SpecUtils.termToLatex(var) + " = " + SpecUtils.termToLatex(val));
					map.put(var, val);

				} catch (IOException e) {
					e.printStackTrace();
				} catch (CommandException e) {
					e.printStackTrace();
				}
			}
		}

		AbstractTCaseImpl abstractTCase = new AbstractTCaseImpl(tClass.getMyAxPara(), tClass.getSchName(), map);

		return abstractTCase;

	}

	private TClass replaceAxDefValues(TClass tClass){

		AxPara tClassAxPara = (AxPara) tClass.getMyAxPara().accept(new CZTCloner());
		String tClassName = tClass.getSchName();

		// We replace in predicate the values for axiomatic definitions
		if (axDefsValues != null) {

			Pred pred = SpecUtils.getAxParaPred(tClassAxPara);
			Set<Map.Entry<RefExpr, Expr>> set = axDefsValues.entrySet();
			Iterator<Map.Entry<RefExpr, Expr>> iterator = set.iterator();
			CZTReplacer replaceVisitor = new CZTReplacer();

			while (iterator.hasNext()) {
				Map.Entry<RefExpr, Expr> mapEntry = iterator.next();
				RefExpr refExpr = mapEntry.getKey();
				Expr expr = mapEntry.getValue();
				replaceVisitor.setOrigTerm(refExpr);
				replaceVisitor.setNewTerm(expr);
				pred = (Pred) pred.accept(replaceVisitor);
			}

			SpecUtils.setAxParaPred(tClassAxPara, pred);
		}

		return tClass = new TClassImpl(tClassAxPara, tClassName);

	}
}