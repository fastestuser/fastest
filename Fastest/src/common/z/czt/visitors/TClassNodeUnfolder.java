package common.z.czt.visitors;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import net.sourceforge.czt.z.ast.AndPred;
import net.sourceforge.czt.z.ast.AxPara;
import net.sourceforge.czt.z.ast.ConstDecl;
import net.sourceforge.czt.z.ast.Pred;
import net.sourceforge.czt.z.ast.RefExpr;
import net.sourceforge.czt.z.ast.SchExpr;
import net.sourceforge.czt.z.ast.ZDeclList;
import net.sourceforge.czt.z.ast.ZFactory;
import net.sourceforge.czt.z.ast.ZName;
import net.sourceforge.czt.z.ast.ZSchText;
import net.sourceforge.czt.z.impl.ZFactoryImpl;
import client.blogic.management.Controller;
import client.blogic.testing.ttree.*;
import client.blogic.testing.ttree.tactics.DNFIterator;
import client.blogic.testing.ttree.visitors.TTreeVisitor;
import common.repository.AbstractIterator;
import common.z.SpecUtils;
import common.z.TClass;
import common.z.TClassImpl;


public class TClassNodeUnfolder implements TTreeVisitor<TClassNode>{
	private Pred predUnfolded; //predUnfolded es el que se envia a genalltca,
	private ZDeclList zDeclListRoot;; // zDeclListRoot es el que se envia a genalltca, 
	private String schName;
	private String opName;
	private Controller controller;
	private TClassNode root;
	
	public TClassNodeUnfolder(TClassNode tClassNode, String opName, Controller controller){
		 root = tClassNode;
		 predUnfolded = null;
		 zDeclListRoot = (new ZFactoryImpl()).createZDeclList();
		 this.controller = controller;
		 this.opName = opName;
	}
	
	public TClass getTClassUnfolded(){
		  
		 if (predUnfolded != null){
			 AxPara axPara  = SpecUtils.createAxPara(zDeclListRoot, predUnfolded);
		 	return new TClassImpl(axPara,schName);
		 }
		//se pide TCase para el Vis, entonces no se inicializo pred y zDeclListRoot esta vacia entonces se devuelve el root
		 return root.getValue();
	}


    /**
     * Visit the specified instance of TClassNode and returns the TClassNodes of
     * this subtree that are leaves of the test tree.
     * @param tClassNode
     * @return the test classes of this subtree that are leaves of the test tree.
     */
	public TClassNode visitTClassNode(TClassNode tClassNode){


		TClassNode tClassNodePadre = tClassNode.getDadNode();
		//habria que pasarle schemeUnfolder al squema del padre????
		if (tClassNodePadre==null){
			return tClassNode;
		}
		
		tClassNodePadre.acceptVisitor(this);
		
		//info del PADRE del nodo actual
		AxPara axPara = tClassNodePadre.getValue().getMyAxPara();
		ZSchText zSchText = axPara.getZSchText();
		ZDeclList zDeclList = zSchText.getZDeclList();
		ConstDecl decl = (ConstDecl) zDeclList.get(0);
		SchExpr schExpr = (SchExpr) decl.getExpr();
		Pred predPadre = schExpr.getZSchText().getPred();
		ZDeclList zDeclListPadre = schExpr.getZSchText().getZDeclList();	
		
		//info del nodo actual
		
		axPara = tClassNode.getValue().getMyAxPara();
		zSchText = axPara.getZSchText();
		zDeclList = zSchText.getZDeclList();
		decl = (ConstDecl) zDeclList.get(0);
		schExpr = (SchExpr) decl.getExpr();
		Pred pred = schExpr.getZSchText().getPred();
		
		//soy la Hoja si no tengo hijos, o mis hijos es un TCase o son TClass pero estan pruneados
		AbstractIterator<? extends TTreeNode> childrenIt = tClassNode.getChildren().createIterator();
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
		if (esHoja)
			schName = tClassNode.getValue().getSchName();//nombre para el foldeado
		
		//si padre no es el root saco el pred, SpecUils.andPreds CREA un nuevo predicado
		if (tClassNodePadre.getDadNode() != null){
			Pred predUnfoldedClone = (Pred) predUnfolded.accept(new CZTCloner());
			predUnfolded = SpecUtils.andPreds(predUnfoldedClone, pred);
		}
		// si el padre es el root saco el decl e incializo Pred.
		else {
//			List<TClass> tClassList = new ArrayList<TClass>();
//
//			AxPara visAxPara = tClassNodePadre.getValue().getMyAxPara();
//
//	        Pred visPred = SpecUtils.getAxParaPred(visAxPara);
//
//	        if (visPred == null) {
//	            return tClassNode;
//	        }
//
//	        List<Pred> conjunctsList = controller.getSchemaDNFPredList(opName);
//	        String s = SpecUtils.termToLatex(conjunctsList.get(0));
//	        System.out.println( "conjunctsListtttttt" +  s);
//	        conjunctsList.add(pred);
//	        
//	        if (conjunctsList == null) {
//	            return tClassNode;
//	        }
//
//	        DNFIterator dnfIterator = new DNFIterator(conjunctsList);
//	        int maxNumberOfPredsToAnalize = controller.getMaxPredsToAnalize();
//
//	        List<Pred> disjunctsList = new ArrayList<Pred>();
//
//	        int k = 0;
//	        while (dnfIterator.hasNext() && k < maxNumberOfPredsToAnalize) {
//
//	            Pred disjunct = dnfIterator.next();
//
//	            disjunct = SpecUtils.simplifyAndPred(disjunct);
//	            System.out.println("disjunctssssssssssssss " + SpecUtils.termToLatex(disjunct));
//	            boolean isPredRepeated = false;
//	            for (int j = 0; j < disjunctsList.size() && !isPredRepeated; j++) {
//	                Pred jPred = disjunctsList.get(j);
//	                if (SpecUtils.areEqualTerms(jPred, disjunct)) {
//	                    isPredRepeated = true;
//	                }
//	            }
//	            if (!isPredRepeated) {
//	                disjunctsList.add(disjunct);
//	            }
//
//	        }
//
//	        System.out.println();
//	        
//	        predUnfolded = SpecUtils.createAndPred(disjunctsList);
			
			predUnfolded = pred; //inicializo el pred TEMP hasta que ande lo anterior.
			SpecUtils.insertZDeclList(zDeclListRoot, zDeclListPadre, 0);
			
		}
		return tClassNode;
		
	}

    

	public TClassNode visitTCaseNode(TCaseNode tCaseNode){
		return null;
	}
	
}
