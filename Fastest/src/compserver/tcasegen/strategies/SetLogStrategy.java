package compserver.tcasegen.strategies;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;


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
import net.sourceforge.czt.z.ast.Sect;
import net.sourceforge.czt.z.ast.Spec;
import net.sourceforge.czt.z.ast.ZFreetypeList;
import net.sourceforge.czt.z.ast.ZParaList;
import net.sourceforge.czt.z.ast.ZSect;
import net.sourceforge.czt.z.impl.ZFreetypeListImpl;

import common.z.AbstractTCase;
import common.z.AbstractTCaseImpl;
import common.z.SpecUtils;
import common.z.TClass;
import common.z.TClassImpl;

import common.z.czt.UniqueZLive;

import common.z.czt.visitors.CZTCloner;
import common.z.czt.visitors.CZTReplacer;
import common.z.czt.visitors.TypesExtractor;
import compserver.tcasegen.strategies.setlog.*;

/* Estrategia que hace uso de SetLog para generar los casos. El parseo de Z a SetLog esta hecho basado en el codigo
 * que se utiliza en ANTLRv3 distinto al que se usa en TestRing (ANTLRv4) el cual tiene un procedimiento un poco difrente
 */
public final class SetLogStrategy implements TCaseStrategy{

	private Map<RefExpr, Expr> axDefsValues;
	private Map<String, List<String>> basicAxDefs;
	private List<FreePara> freeParas;
	private List<String> basicTypeNames; 


	

	public SetLogStrategy(Map<RefExpr, Expr> axDefsValues, Map<String, List<String>> basicAxDefs,List<FreePara> freeParas,List<String> basicTypeNames) {
		this.axDefsValues = axDefsValues;
		this.basicAxDefs = basicAxDefs;
		this.freeParas = freeParas;
		this.basicTypeNames = basicTypeNames;
	}

	public AbstractTCase generateAbstractTCase(Spec spec, TClass tClass)  {
		
		String tClassName = tClass.getSchName();
		System.out.println("Trying to generate a test case for the class: " + tClassName);
		
		//Reemplazamos las definiciones axiomaticas por sus valores
		if (axDefsValues != null) {

			AxPara tClassAxPara = (AxPara) tClass.getMyAxPara().accept(new CZTCloner());
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
						freeParasIt = freeParas.iterator();
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
		//antlrInput = "\\begin{schema}{K\\_ DNF\\_ 1}\\\\\nprocs : \\num \\ffun \\nat \\\\\nmaxProcs : \\nat\n\\where\n\\# (\\dom procs) = maxProcs\n\\end{schema}";
		//System.out.println("**********************************************************************************************");
		//System.out.println("ANTLRINPUT\n" + antlrInput);
		//System.out.println("**********************************************************************************************\n");

		HashMap<String, String> zVars = SetLogGenerator.generate(antlrInput);
		
		if (zVars == null) //No encontro caso
			return null;

		//Creamos el caso de prueba a partir de los valores de las variables obtenidas
		Map<RefExpr, Expr> map = new HashMap<RefExpr, Expr>();
		//Map<String, String> zVars = parser2.getZVars();
		Iterator<String> keys = zVars.keySet().iterator();
		ZLive zLive = UniqueZLive.getInstance();

		while (keys.hasNext()) {
			String varName = keys.next();
			String value = zVars.get(varName);
			//System.out.println("------ " + varName + " = " + value);
			if (value != null) {
				RefExpr var;
				Expr val;
				try {
					var = (RefExpr) ParseUtils.parseExpr(new StringSource(varName), zLive.getCurrentSection(), zLive.getSectionManager());
					//System.out.println("------ " + SpecUtils.termToLatex(var));
					val = ParseUtils.parseExpr(new StringSource(value), zLive.getCurrentSection(), zLive.getSectionManager());
					//System.out.println("------ " + SpecUtils.termToLatex(var) + " = " + SpecUtils.termToLatex(val));
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
}