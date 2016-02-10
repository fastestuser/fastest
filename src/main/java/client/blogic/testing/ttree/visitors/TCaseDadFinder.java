package client.blogic.testing.ttree.visitors;

import client.blogic.testing.ttree.*;
import common.z.TClass;
import common.z.AbstractTCase;
import java.util.Collection;
import java.util.Iterator;


/**
 * Instances of this class look for the TClassNode father of a leaf that is passed as
 * argument to the visitor and return the name of the father in the sucess case or the
 * empty string otherwise.
 */
public class TCaseDadFinder implements TTreeVisitor<String>{
	
	private String abstractTCaseName;

    /**
     * Creates instances of TCaseDadFinder.
     * @param abstractTCaseName
     */
	public TCaseDadFinder(String abstractTCaseName){
		this.abstractTCaseName = abstractTCaseName;
	}

	public String visitTClassNode(TClassNode tClassNode){
		String dadName = "";
		TClass tClass = (TClass) tClassNode.getUnfoldedValue().clone();
		String tClassNodeName = tClass.getSchName();
		Collection<? extends TTreeNode> children = tClassNode.getChildren();
		Iterator<? extends TTreeNode> childrenIt = children.iterator();
		while(childrenIt.hasNext() && "".equals(dadName)){
		TTreeNode tTreeNode = childrenIt.next();
		if(tTreeNode instanceof TCaseNode){
			TCaseNode tCaseNode = (TCaseNode) tTreeNode;
			AbstractTCase abstractTCase = (AbstractTCase) tCaseNode.getValue().clone();
			String auxName = abstractTCase.getSchName();
			if(auxName.equals(abstractTCaseName))
				dadName = tClassNodeName;
		}
		else if(tTreeNode instanceof TClassNode){
			TClassNode childTClassNode = (TClassNode) tTreeNode;
			dadName = childTClassNode.acceptVisitor(this);
		}
		}
		return dadName;
	}

    public String visitTCaseNode(TCaseNode tCaseNode){
        return "";
    }
}
