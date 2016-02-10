package client.blogic.testing.ttree.visitors;

import client.blogic.testing.ttree.*;
import common.z.TClass;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;


/**
 * Instances of this class make possible the traversal over a test tree to 
 * obtain those test classes whose nodes are leaves of the test tree. Those test
 * classes are of interest because they are the source for generation of test
 * cases.
 * @author Pablo Rodriguez Monetti
 */
public class TClassLeavesFinder implements TTreeVisitor<Collection<TClass>>{
	    
    /**
     * Visit the specified instance of TClassNode and returns the test classes of
     * this subtree that are leaves of the test tree.
     * @param tClassNode
     * @return the test classes of this subtree that are leaves of the test tree.
     */
	public Collection<TClass> visitTClassNode(TClassNode tClassNode){

		Collection<TClass> tClassRep = new ArrayList<TClass>();
		
        if(tClassNode.isPruned())
            return tClassRep;
        
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
            
			Collection<TClass> tClassChildRep = tTreeNode.acceptVisitor(this);
			if(tClassChildRep != null){
				Iterator<TClass> tClassIt = tClassChildRep.iterator();
				while(tClassIt.hasNext())
					tClassRep.add(tClassIt.next());
			}
		}
		if(isALeaf)
			tClassRep.add((TClass) tClassNode.getUnfoldedValue());
		return tClassRep;
	}

    
    /**
     * Since there is not any test class within the test tree under the
     * specified instance of TCaseNode, this method return null.
     * @param tCaseNode
     * @return null
     */
	public Collection<TClass> visitTCaseNode(TCaseNode tCaseNode){
		return null;
	}
}
