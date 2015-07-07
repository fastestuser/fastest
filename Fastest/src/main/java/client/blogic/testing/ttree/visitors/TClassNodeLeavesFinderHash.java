package client.blogic.testing.ttree.visitors;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import client.blogic.testing.ttree.*;
import common.repository.AbstractRepository;
import common.repository.AbstractIterator;


/**
 * Instances of this class make possible the traversal over a test tree to 
 * obtain those TClassNode that are leaves of the test tree.
 */
public class TClassNodeLeavesFinderHash implements TTreeVisitor<Map<String,TClassNode>>{

    /**
     * Visit the specified instance of TClassNode and returns the TClassNodes of
     * this subtree that are leaves of the test tree.
     * @param tClassNode
     * @return the test classes of this subtree that are leaves of the test tree.
     */
	public Map<String,TClassNode> visitTClassNode(TClassNode tClassNode){

		Map<String,TClassNode> tClassRep = new HashMap<String,TClassNode>();
	
	    if(tClassNode.isPruned())
	    	return null;
	
	    AbstractRepository<? extends TTreeNode> children = tClassNode.getChildren();
		AbstractIterator<? extends TTreeNode> childrenIt = children.createIterator();
		// This test class node will be consider a leaf if it has not any child 
	    // or every child is a pruned test class node
	    boolean isALeaf = true;
		while(childrenIt.hasNext()){
	        TTreeNode tTreeNode = childrenIt.next();
	        if(tTreeNode instanceof TClassNode && !((TClassNode) tTreeNode).isPruned()){
	                isALeaf = false;
	        }
	        else if(tTreeNode instanceof TCaseNode){
	            isALeaf = false;
	        }
	        
	        //if (!isALeaf){
			    Map<String,TClassNode> tClassChildRep = tTreeNode.acceptVisitor(this);
			    if(tClassChildRep != null){
			    	Iterator<TClassNode> tClassIt = tClassChildRep.values().iterator();
			    	while(tClassIt.hasNext()){
			    		TClassNode nodo = tClassIt.next();
			    		tClassRep.put(nodo.getValue().getSchName(),nodo);
			    	}
			    }
		
	        //}
		}
		
		if(isALeaf)
			tClassRep.put(tClassNode.getValue().getSchName(),tClassNode);
		return tClassRep;
		
	}

    
    /**
     * Since there is not any test class within the test tree under the
     * specified instance of TCaseNode, this method return null.
     * @param tCaseNode
     * @return null
     */
	public Map<String,TClassNode> visitTCaseNode(TCaseNode tCaseNode){
		return null;
	}
}
