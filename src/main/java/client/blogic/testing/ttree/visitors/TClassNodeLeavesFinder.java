package client.blogic.testing.ttree.visitors;

import client.blogic.testing.ttree.*;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Iterator;


/**
 * Instances of this class make possible the traversal over a test tree to 
 * obtain those TClassNode that are leaves of the test tree (si la clase tiene un caso, entonces 
 * no es hoja).
 */
public class TClassNodeLeavesFinder implements TTreeVisitor<Collection<TClassNode>>{

    /**
     * Visit the specified instance of TClassNode and returns the TClassNodes of
     * this subtree that are leaves of the test tree.
     * @param tClassNode
     * @return the test classes of this subtree that are leaves of the test tree.
     */
	public Collection<TClassNode> visitTClassNode(TClassNode tClassNode){

		Collection<TClassNode> tClassRep = new ArrayList<TClassNode>();
	
	    if(tClassNode.isPruned())
	    	return null;
	
	    Collection<? extends TTreeNode> children = tClassNode.getChildren();
		Iterator<? extends TTreeNode> childrenIt = children.iterator();
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
			    Collection<TClassNode> tClassChildRep = tTreeNode.acceptVisitor(this);
			    if(tClassChildRep != null){
			    	Iterator<TClassNode> tClassIt = tClassChildRep.iterator();
			    	while(tClassIt.hasNext())
			    		tClassRep.add(tClassIt.next());
			    }
		
	        //}
		}
		
		if(isALeaf)
			tClassRep.add(tClassNode);
		return tClassRep;
		
	}

    
    /**
     * Since there is not any test class within the test tree under the
     * specified instance of TCaseNode, this method return null.
     * @param tCaseNode
     * @return null
     */
	public Collection<TClassNode> visitTCaseNode(TCaseNode tCaseNode){
		return null;
	}
}
