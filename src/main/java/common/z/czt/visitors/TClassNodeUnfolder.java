package common.z.czt.visitors;

import java.util.ArrayList;
import java.util.List;

import net.sourceforge.czt.z.ast.AxPara;
import net.sourceforge.czt.z.ast.Decl;
import net.sourceforge.czt.z.ast.Expr;
import net.sourceforge.czt.z.ast.InclDecl;
import net.sourceforge.czt.z.ast.ParaList;
import net.sourceforge.czt.z.ast.PreExpr;
import net.sourceforge.czt.z.ast.Pred;
import net.sourceforge.czt.z.ast.RefExpr;
import net.sourceforge.czt.z.ast.Sect;
import net.sourceforge.czt.z.ast.Spec;
import net.sourceforge.czt.z.ast.ZDeclList;
import net.sourceforge.czt.z.ast.ZParaList;
import net.sourceforge.czt.z.ast.ZSect;
import net.sourceforge.czt.z.impl.ZFactoryImpl;
import client.blogic.management.Controller;
import client.blogic.testing.ttree.*;
import client.blogic.testing.ttree.visitors.TTreeVisitor;
import java.util.Iterator;
import common.z.SpecUtils;
import common.z.TClass;
import common.z.TClassImpl;


public class TClassNodeUnfolder implements TTreeVisitor<TClassNode>{
	private Pred predUnfolded; //predUnfolded es el que se envia a genalltca,
	private ZDeclList zDeclListRoot; // zDeclListRoot es el que se envia a genalltca, 
	private String schName;
	private Controller controller;
	private TClassNode root;
	private int MAXINCLDECL = 20;
	private List<PreExpr> preds;
		
	public TClassNodeUnfolder(TClassNode tClassNode, Controller controller){
		 predUnfolded = null;
		 zDeclListRoot = (new ZFactoryImpl()).createZDeclList();
		 this.controller = controller;
		 this.preds = tClassNode.getValue().getInclPreds();
		 
	}
	
	public TClass getTClassUnfolded(){
		  
		if (schName.endsWith("VIS")){
			return root.getValue();
		} else {
			AxPara axPara  = SpecUtils.createAxPara(zDeclListRoot, predUnfolded);
			TClass tClase =  new TClassImpl(axPara,schName);
			tClase.setInclPreds(preds);
			return tClase;
		}
	}


    /**
     * Visit the specified instance of TClassNode and returns the TClassNodes of
     * this subtree that are leaves of the test tree.
     * @param tClassNode
     * @return the test classes of this subtree that are leaves of the test tree.
     */
	public TClassNode visitTClassNode(TClassNode tClassNode){

		TClassNode tClassNodePadre = tClassNode.getDadNode();
		//Consideramos que las incluciones *_Decls solo estan en el root
		if (tClassNodePadre==null){
			schName = tClassNode.getValue().getSchName();
			root = tClassNode;
			AxPara axPara = tClassNode.getValue().getMyAxPara();
			ZDeclList zDeclList = (ZDeclList) SpecUtils.getAxParaListOfDecl(axPara); 
			ZDeclList zDeclListAux = (new ZFactoryImpl()).createZDeclList();
	        int declListSize = zDeclList.size();
	        List<Integer> js = new ArrayList<Integer>();//indices de decls que deberan ser borrados
	        int i = 0;
	        for (int j = 0; j < declListSize; j++) {
	            Decl decl = zDeclList.get(j);
	            
	            if (decl instanceof InclDecl) {
	                Expr expr = ((InclDecl) decl).getExpr();

	                if (expr instanceof RefExpr) {
	                	String includedSchemeName  = ((RefExpr) expr).getName().toString();
	                	if (includedSchemeName.endsWith("_Decls")){
	                		//Obtenemos el AxPara incluido de la especificacion
	                		String includedSchemeNameAux = includedSchemeName.substring(0, includedSchemeName.length()-6);
	                		TTreeNode includedRoot = controller.getOpTTreeMap().get(includedSchemeNameAux);
	                		
	                		//Obtenemos el ZParaList para poder unfolderalo

	                        Spec spec = controller.getOriginalSpec(); 
	                        for (Sect sect : spec.getSect()) {
	                            if (sect instanceof ZSect) {
	                                ParaList paraList = ((ZSect) sect).getParaList();
	                                if (paraList instanceof ZParaList) {
	                                    DeclsExtractorFull declsExtractor = new DeclsExtractorFull((ZParaList) paraList, controller);
	                                    //zDeclList.remove(j); //Borramos el Decl que expandido
	                                    js.add(j-i);i++; //le resto i por que a medida que haces remove en zDeclList se corren
	                                    //declListSize = zDeclList.size();
	                                    SpecUtils.insertZDeclList(zDeclListAux, includedRoot.getValue().getMyAxPara().accept(declsExtractor), 0);
	                                }
	                            }
	                        }
	                	}
	                }
	            }
	        }
	        
	        
	        
	        for(int j:js)
	            zDeclList.remove(j);
	        SpecUtils.insertZDeclList(zDeclList,zDeclListAux,0);
            return tClassNode;
		}
		
		tClassNodePadre.acceptVisitor(this);
		
		//info del PADRE del nodo actual
		AxPara axPara = tClassNodePadre.getValue().getMyAxPara();
		ZDeclList zDeclListPadre = (ZDeclList) SpecUtils.getAxParaListOfDecl(axPara);
		
		//info del nodo actual
		axPara = tClassNode.getValue().getMyAxPara();
		Pred pred = SpecUtils.getAxParaPred(axPara);
        pred = pred.accept(new PreExprCleaner());
        /*if (pred == null){
        	ZFactory zFactory = new ZFactoryImpl();
        	ZExprList memPredExprList = zFactory.createZExprList();
			pred = zFactory.createMemPred(memPredExprList, true);
        }*/
		
		//soy la Hoja si no tengo hijos, o mis hijos es un TCase o son TClass pero estan pruneados
		Iterator<? extends TTreeNode> childrenIt = tClassNode.getChildren().iterator();
		boolean esHoja = true;
		while (  childrenIt.hasNext() ){
			esHoja = false;
			TTreeNode tTreeNode = childrenIt.next();
			if ( (tTreeNode instanceof TCaseNode)){
				esHoja = true;
				break;
			}
			if ( (tTreeNode instanceof TClassNode) && ((TClassNode)tTreeNode).isPruned() ){
				esHoja = true;
			}
			else break;
		}
		// si soy la hoja, obtengo el nombre del scheme
		if (esHoja){
			schName = tClassNode.getValue().getSchName();//nombre para el foldeado
		}
		
		//si padre no es el root saco el pred, SpecUils.andPreds CREA un nuevo predicado
		if (tClassNodePadre.getDadNode() != null){
			Pred predUnfoldedClone = null;
			if (predUnfolded != null)
				predUnfoldedClone = (Pred) predUnfolded.accept(new CZTCloner());
			
			predUnfoldedClone = SpecUtils.simplifyAndPred(predUnfoldedClone);
			pred = SpecUtils.simplifyAndPred(pred);
			predUnfolded = SpecUtils.andPreds(predUnfoldedClone, pred);
		}
		// si el padre es el root saco el decl e incializo Pred.
		else {
			pred = SpecUtils.simplifyAndPred(pred);
			predUnfolded = pred; //inicializo el pred TEMP hasta que ande lo anterior.
			SpecUtils.insertZDeclList(zDeclListRoot, zDeclListPadre, 0);
			
		}
		return tClassNode;
	}

	public TClassNode visitTCaseNode(TCaseNode tCaseNode){
		return null;
	}
	
}
