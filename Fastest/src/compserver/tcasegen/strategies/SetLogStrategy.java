package compserver.tcasegen.strategies;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import client.blogic.testing.ttree.TClassNode;
import client.blogic.testing.ttree.visitors.TClassNodeFinder;
import client.presentation.ClientUI;
import client.presentation.ClientTextUI;
import net.sourceforge.czt.animation.eval.ZLive;
import net.sourceforge.czt.parser.z.ParseUtils;
import net.sourceforge.czt.session.CommandException;
import net.sourceforge.czt.session.StringSource;
import net.sourceforge.czt.z.ast.AxPara;
import net.sourceforge.czt.z.ast.DeclList;
import net.sourceforge.czt.z.ast.Expr;
import net.sourceforge.czt.z.ast.FreePara;
import net.sourceforge.czt.z.ast.Freetype;
import net.sourceforge.czt.z.ast.FreetypeList;
import net.sourceforge.czt.z.ast.ParaList;
import net.sourceforge.czt.z.ast.PreExpr;
import net.sourceforge.czt.z.ast.Pred;
import net.sourceforge.czt.z.ast.RefExpr;
import net.sourceforge.czt.z.ast.Sect;
import net.sourceforge.czt.z.ast.Spec;
import net.sourceforge.czt.z.ast.ZFreetypeList;
import net.sourceforge.czt.z.ast.ZParaList;
import net.sourceforge.czt.z.ast.ZSect;
import net.sourceforge.czt.z.impl.ZFreetypeListImpl;
import common.repository.AbstractIterator;
import common.repository.AbstractRepository;
import common.z.AbstractTCase;
import common.z.AbstractTCaseImpl;
import common.z.SpecUtils;
import common.z.TClass;
import common.z.TClassImpl;
import common.z.czt.UniqueZLive;
import common.z.czt.visitors.TypesExtractor;
import compserver.tcasegen.strategies.setlog.*;

/* Estrategia que hace uso de SetLog para generar los casos. El parseo de Z a SetLog esta hecho basado en el codigo
 * que se utiliza en ANTLRv3 distinto al que se usa en TestRing (ANTLRv4) el cual tiene un procedimiento un poco difrente
 */
public final class SetLogStrategy implements TCaseStrategy{

	private ClientUI clientUI;
	private Spec spec;

	public SetLogStrategy(ClientUI clientUI) {
		this.clientUI = clientUI;
		this.spec = clientUI.getMyController().getOriginalSpec();
	}

	public AbstractTCase generateAbstractTCase(Spec spec, TClass tClass)  {
		((ClientTextUI)clientUI).getOutput().println("Trying to generate a test case for the class: " + tClass.getSchName());
		return generarCaso(tClass);
	}
	private AbstractTCase generarCaso(TClass tClass){
		String antlrInput = buildCompleteInput(tClass);
		HashMap<String, String> zVars = (new SetLogGenerator()).generate(antlrInput,clientUI.getMyController());
		AbstractTCase abstractTCase;
		if (zVars == null) //No encontro caso
			return null;
		else if (zVars.isEmpty()) { //No existe caso de prueba, dio False {log}
			abstractTCase = new AbstractTCaseImpl(null, tClass.getSchName());
			return abstractTCase;
		}
		abstractTCase = buildTCase(zVars,tClass);//crea caso con las zvars generadas
		integrate(tClass,abstractTCase);//integra el caso si tiene incls
		return abstractTCase;
	}
	
	
	//supongamos A == B \land C entonces una clase de prueba de A es
	// A==[decl|\pre B \land \pre C]
	private void integrate(TClass tClass, AbstractTCase abstractTCase){
		if (abstractTCase==null || abstractTCase.getMyAxPara() == null)
			return;
		List<PreExpr> inclPreds = tClass.getInclPreds();
		if (inclPreds == null || inclPreds.isEmpty())
			return;
		List<String> inclsNotIntegrated = new LinkedList<String>();
		Iterator<PreExpr> it = inclPreds.iterator();
		PreExpr pre;
		String opName; //nombre de la operacion incluida como \pre B
		Map<String, TClassNode> opTTreeMap = clientUI.getMyController().getOpTTreeMap();
		TClassNode vis,tClassNode;
		AbstractRepository<TClassNode> tClassNodeLeaves;
		AbstractIterator<TClassNode> tClassNodeIt;
		DeclList declList = SpecUtils.getAxParaListOfDecl(tClass.getMyAxPara()); //declaracion de A
		Pred classPred,casePred; //predicado B
		AxPara axPara;
		casePred = SpecUtils.getAxParaPred(abstractTCase.getMyAxPara()); //predicado del caso de A
		AbstractTCase newAbstractTCase;
		while (it.hasNext()){ //iteramos sobre los esuqemas incluidos (B y C)
			pre = it.next();
			opName = SpecUtils.termToLatex(pre.getExpr());
			inclsNotIntegrated.add(opName); //por defecto no integra
			vis = opTTreeMap.get(opName);
			tClassNodeLeaves = vis.acceptVisitor(new TClassNodeFinder());
			tClassNodeIt = tClassNodeLeaves.createIterator();
			while (tClassNodeIt.hasNext()) { //iteramos sobre cada clase de B o C
				tClassNode = tClassNodeIt.next(); //obtenemos una clase de preuba de B
				//obtenemos las preciondiciones de B
				classPred = SpecUtils.getAxParaPred(tClassNode.getValue().getMyAxPara());
				//creamos la clase de prueba nueva a testear
				axPara = SpecUtils.createAxPara(declList,SpecUtils.andPreds(casePred, classPred));
				//System.out.println("clase+caso:" + SpecUtils.termToLatex(axPara));
				//testeamos si el caso de A anda con el predicado de B
				newAbstractTCase = generarCaso(new TClassImpl(axPara,tClass.getSchName()));
				if (newAbstractTCase!=null && newAbstractTCase.getMyAxPara() != null 
						&& newAbstractTCase.getInclsNotIntegrated().isEmpty()){
					inclsNotIntegrated.remove(opName); //sacamos de las ops con la que no puede integrar el caso
					break; //para esta operacion(B o C) ya integró
				}
			}
		}
		abstractTCase.setInclsNotIntegrated(inclsNotIntegrated);
		return; 
	}

	private AbstractTCase buildTCase(HashMap<String, String> zVars, TClass tClass){
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
	
	//se agregan las decl incluidas, y decl necesarias de toda la especificacion para que el 
	//caso se genere.
	private String buildCompleteInput(TClass tClass){
		List<FreePara> freeParas = clientUI.getMyController().getFreeParas();
		List<String> basicTypeNames = clientUI.getMyController().getBasicTypeNames();
		Spec spec = clientUI.getMyController().getOriginalSpec();
		//Buscamos los tipos que aparecen en tClass, para incluir
		//su informacion en la entrada del parser
		StringBuilder schemas = new StringBuilder();
		StringBuilder antlrInput = new StringBuilder();

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

		//Buscamos los tipos que se utilizan en tClass
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
						schemaString = "\\begin{zed}\n" + "[" + schemaName + "]\n" + "\\end{zed}\n\n";
						antlrInput.insert(0,schemaString);
						//antlrInput = schemaString + antlrInput;
					} else { //Es un tipo libre
						while (freeParasIt.hasNext() && schemaString.equals("null")) {
							FreePara freePara = freeParasIt.next();
							FreetypeList freetypeList = freePara.getFreetypeList();
							if (freetypeList instanceof ZFreetypeListImpl) {
								ZFreetypeList zFreetypeList = (ZFreetypeListImpl) freetypeList;
								for (int i = 0; i < zFreetypeList.size(); i++) {
									Freetype freetype = zFreetypeList.get(i);
									if (schemaName.equals(freetype.getName().toString())) {
										schemaString = "\\begin{zed}\n" + SpecUtils.termToLatex(freetype) + "\n" + "\\end{zed}\n\n";
										antlrInput.insert(0,schemaString);
										//antlrInput = schemaString + antlrInput;
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
					schemas.insert(0, schemaString);
					//schemas = schemaString + schemas;
				}
				typesPrinted.add(schemaName);
			}
		}

		//Armamos la entrada para el parser
		antlrInput.append(schemas + SpecUtils.termToLatex(tClass.getMyAxPara()));
		return antlrInput.toString();
	} 
}