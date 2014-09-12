package client.blogic.testing.ttree.visitors;

import java.io.*;
import java.util.*;

import client.blogic.testing.refinement.ConcreteTCase;
import client.blogic.testing.ttree.TTreeNode;
import client.blogic.testing.ttree.TClassNode;
import client.blogic.testing.ttree.TCaseNode;
import client.presentation.ClientTextUI;
import common.repository.AbstractRepository;
import common.repository.AbstractIterator;



/**
 * Instances of this class make possible the printing of test trees, displaying
 * only the names of test class and test cases. The content of each one is not
 * displayed. The test classes which are pruned are presented with an X appended to their
 * end.
 * @author Pablo Rodriguez Monetti
 */
 public class TTreeTextUIPrunePrinter implements TTreeVisitor<Void>{

	private int nroTab = 0;
    private List<Boolean> auxList = new ArrayList<Boolean>();
	private PrintWriter out;
	private ClientTextUI clientTextUI;

    
    /**
     * Creates instances of TTreeTextUIPrunePrinter.
     * @param out
     */
	public TTreeTextUIPrunePrinter(PrintWriter out, ClientTextUI ctui){
        this.out = out;
		nroTab = 0;
		this.clientTextUI = ctui;
	}

    
    
    /**
     * Visit the specified instance of TClassNode, printing the associated test 
     * class's name and ordering the recursive application of this visitor to 
     * the children of the specified node, only if the TClassNode is not pruned.
     * @param tClassNode
     * @return
     */
	public Void visitTClassNode(TClassNode tClassNode){
		String tClassStr = tClassNode.getValue().getSchName();
        if(tClassNode.isPruned()){     
            out.println(getStrTab(nroTab, true) + tClassStr + " X");
            out.flush();
        }
        else{
            out.println(getStrTab(nroTab, true) + tClassStr);
            out.flush();
            AbstractRepository<? extends TTreeNode> children = tClassNode.getChildren();	
            AbstractIterator<? extends TTreeNode> childrenIt = children.createIterator();
            boolean hasChildren = false;
    		while(childrenIt.hasNext()){
    			TTreeNode child = childrenIt.next();
                if(childrenIt.hasNext())
                   auxList.add(new Boolean(true));
                else
                   auxList.add(new Boolean(false));
                   
                nroTab++;
                child.acceptVisitor(this);
                nroTab--;
                auxList.remove(auxList.size()-1);
                
                hasChildren = true;
            }
            if(hasChildren){
                String strTab2 = getStrTab(nroTab, false);
                if(strTab2.contains("|"))
                    out.println(strTab2);
            }
        }
        return null;        
        
	}

    
    
    /**
     * Visit the specified instance of TClassNode, printing the associated test 
     * class's name.
     * @param tCaseNode
     * @return
     */
	public Void visitTCaseNode(TCaseNode tCaseNode){
		String tCaseStr = tCaseNode.getValue().getSchName();
		
		Map<String, ConcreteTCase> m = clientTextUI.getMyController().getAbsTCaseConcrTCaseMap();
		String s1 = "",s2 = "";
		if (m.get(tCaseStr)!=null){
			 String warning = m.get(tCaseStr).hasWarnings()?" (with warnings)":"";
			 s1 = " > " + m.get(tCaseStr).getConcreteTCaseName() + warning;
		}
		if (!tCaseNode.getValue().getInclsNotIntegrated().isEmpty()){
			s2 = " not integrated with " + tCaseNode.getValue().getInclsNotIntegrated();
		}
		String strTab = getStrTab(nroTab, true);
		out.println(strTab + tCaseStr + s1 + s2);
        out.flush();
        return null;
	}


	private String getStrTab(int nroTab, boolean withName){
		//String strTab = "";
		StringBuilder strTab = new StringBuilder();
		for(int i=0; i<nroTab-1; i++){
            if(auxList.get(i).booleanValue())
                strTab.append("  |\t");
            else
                strTab.append("  \t");
        }
			
		if(nroTab>0 && withName)
			strTab.append("  !______");                  
        else if(nroTab>0 && auxList.get(nroTab-1).booleanValue())
            strTab.append("  |");
		return strTab.toString();
	}


}