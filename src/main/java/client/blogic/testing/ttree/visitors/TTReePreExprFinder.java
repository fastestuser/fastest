package client.blogic.testing.ttree.visitors;

import java.util.Collection;
import java.util.List;

import net.sourceforge.czt.z.ast.PreExpr;
import net.sourceforge.czt.z.ast.Pred;
import client.blogic.testing.ttree.*;

import java.util.Iterator;
import common.z.SpecUtils;
import common.z.czt.visitors.PreExprExtractor;


/**
 * Instances of this class make possible the traversal over a test tree to 
 * obtain those DNF TClassNode that has PreExpr and fill all clases with it. 
 */
public class TTReePreExprFinder implements TTreeVisitor<TTreeNode>{

	public TClassNode visitTClassNode(TClassNode tClassNode){

		if(tClassNode.isPruned())
			return null;

		List<PreExpr> preds,predsPadre;
		if(tClassNode.getDadNode()!=null) { //obtengo los \pre ? del nodo actual si no soy el vis
			Pred pred = SpecUtils.getAxParaPred(tClassNode.getValue().getMyAxPara());
			PreExprExtractor preExtractor = new PreExprExtractor();
			pred.accept(preExtractor);
			preds = preExtractor.getPreds();
			predsPadre = tClassNode.getDadNode().getValue().getInclPreds();
			if (predsPadre!=null)
				preds.addAll(predsPadre);
			tClassNode.getValue().setInclPreds(preds);
		} 
		
		Collection<? extends TTreeNode> children = tClassNode.getChildren();
		Iterator<? extends TTreeNode> childrenIt = children.iterator();
		while(childrenIt.hasNext()){
			TTreeNode tTreeNode = childrenIt.next();
			if(tTreeNode instanceof TClassNode && !((TClassNode) tTreeNode).isPruned())
				tTreeNode.acceptVisitor(this);
		}
		return tClassNode;
	}
	public TCaseNode visitTCaseNode(TCaseNode tCaseNode){
		return tCaseNode;
	}
}
