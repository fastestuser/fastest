package compserver.tcasegen.strategies;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import client.blogic.management.Controller;
import client.blogic.management.ii.EventAdmin;
import client.blogic.management.ii.events.TCaseRequested;
import client.blogic.testing.ttree.TClassNode;
import client.blogic.testing.ttree.TTreeNode;
import client.presentation.ClientUI;
import net.sourceforge.czt.animation.eval.ZLive;
import net.sourceforge.czt.parser.z.ParseUtils;
import net.sourceforge.czt.session.CommandException;
import net.sourceforge.czt.session.StringSource;
import net.sourceforge.czt.z.ast.AxPara;
import net.sourceforge.czt.z.ast.Expr;
import net.sourceforge.czt.z.ast.FreePara;
import net.sourceforge.czt.z.ast.Freetype;
import net.sourceforge.czt.z.ast.FreetypeList;
import net.sourceforge.czt.z.ast.RefExpr;
import net.sourceforge.czt.z.ast.ParaList;
import net.sourceforge.czt.z.ast.Sect;
import net.sourceforge.czt.z.ast.Spec;
import net.sourceforge.czt.z.ast.Type;
import net.sourceforge.czt.z.ast.ZFreetypeList;
import net.sourceforge.czt.z.ast.ZParaList;
import net.sourceforge.czt.z.ast.ZSect;
import net.sourceforge.czt.z.impl.ZFreetypeListImpl;
import common.fastest.FastestUtils;
import common.repository.AbstractIterator;
import common.repository.AbstractRepository;
import common.z.AbstractTCase;
import common.z.AbstractTCaseImpl;
import common.z.SpecUtils;
import common.z.TClass;
import common.z.czt.UniqueZLive;
import common.z.czt.visitors.ExpressionsExtractor;
import common.z.czt.visitors.TClassNodeUnfolder;
import common.z.czt.visitors.TypesExtractor;
import compserver.prunning.TreePruner;
import compserver.tcasegen.strategies.setlog.*;

/* Estrategia que hace uso de SetLog para generar los casos. El parseo de Z a SetLog esta hecho basado en el codigo
 * que se utiliza en ANTLRv3 distinto al que se usa en TestRing (ANTLRv4) el cual tiene un procedimiento un poco difrente
 */
public final class SetLogStrategy implements TCaseStrategy{

	private ClientUI clientUI; 

	public SetLogStrategy(ClientUI clientUI) {
		this.clientUI = clientUI;
	}

	public AbstractTCase generateAbstractTCase(Spec spec, TClass tClass)  {
		
		Controller controller = clientUI.getMyController();
		String tClassName = tClass.getSchName();
		
		
			
		System.out.println("Trying to generate a test case for the class: " + tClassName);
		
        List<FreePara> freeParas = controller.getFreeParas();
        List<String> basicTypeNames = controller.getBasicTypeNames();

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
										schemaString = "\\begin{zed}\n" + SpecUtils.termToLatex(freetype) + "\n" + "\\end{zed}\n\n";
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

		//Armamos la entrada para el parser
		antlrInput = antlrInput.concat(schemas);
		antlrInput = antlrInput.concat(SpecUtils.termToLatex(tClass.getMyAxPara()));
		
		
		//PROBANDO LOS TIPOS, despues borrar...
		//Map<Expr,Type> mapTypes = tClass.accept(new ExpressionsExtractor());
		//Iterator iteratorTypes = mapTypes.keySet().iterator();
		//while (iteratorTypes.hasNext()){
		//	Expr key = (Expr) iteratorTypes.next();
		//	System.out.println(SpecUtils.termToLatex(key) + " .... " + SpecUtils.termToLatex(mapTypes.get(key)));
		//}
		
		
		
		
		///////////////////////////////////////

		int setlogTimeout = controller.getSetlogTimeout();
		//Generamos el caso de prueba
		HashMap<String, String> zVars = SetLogGenerator.generate(antlrInput, setlogTimeout,clientUI);
		
		if (zVars == null) //No encontro caso
			return null;
		else if (zVars.isEmpty()) { //No hay caso de prueba, dio False {log}
			
			//Map<String, TClassNode> opTTreeMap = controller.getOpTTreeMap();
			TTreeNode tClassNode = FastestUtils.getTTreeNode(controller, tClassName);
            TClassNode dadNode = tClassNode.getDadNode();
            if (dadNode != null) { //Si el hijo no es el VIS
            	//Pruneamos el nodo
            	boolean result = (new TreePruner(controller)).pruneFrom(tClassName);
            	if (result) {
            		System.out.println("Node pruned: " + tClassName);
            	}
            	
    			//Debemos llamar genalltca en el padre, si es que todos sus hijos fueron pruneados
            	AbstractRepository<? extends TTreeNode> childsNodeRep = dadNode.getChildren();
            	AbstractIterator<? extends TTreeNode> childsNodeIt = childsNodeRep.createIterator();
            	Boolean allChildsPruned = new Boolean(true);
				while(childsNodeIt.hasNext() && allChildsPruned.booleanValue() == true) {
					TTreeNode child = childsNodeIt.next();
					if (child instanceof TClassNode) {
						allChildsPruned = ((TClassNode) child).isPruned();
					}
				}
				if (allChildsPruned) {
					EventAdmin eventAdmin = null;
					try {
						eventAdmin = EventAdmin.getInstance();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					}
                    TClassNodeUnfolder tClassNodeUnfolder = new TClassNodeUnfolder(dadNode, controller);
                    dadNode.acceptVisitor(tClassNodeUnfolder);
                    TClass dadClass = tClassNodeUnfolder.getTClassUnfolded();
                    TCaseRequested tCaseRequested = new TCaseRequested(dadClass.getSchName(), dadClass, controller.getMaxEval());
                    eventAdmin.announceEvent(tCaseRequested);
				}
            }
			return null;
		}
		
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