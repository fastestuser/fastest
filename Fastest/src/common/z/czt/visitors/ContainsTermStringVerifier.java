
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package common.z.czt.visitors;

import net.sourceforge.czt.base.ast.Term;
import net.sourceforge.czt.base.visitor.TermVisitor;
import common.z.SpecUtils;

/**
 * An instance of this class allows the verification of term containing another 
 * term chequeando string a string, en vez de term a term.
 * 
 * The verification is performed recursively and is based on the Visitor design 
 * pattern.
 * 
 * @author JM
 */
	
public class ContainsTermStringVerifier
        implements TermVisitor<Boolean> {

    // The term to find
    private String theTerm;
    private Boolean contains;
    
    public ContainsTermStringVerifier() {
    	contains = false;
    }

    public ContainsTermStringVerifier(String theTerm) {
        this.theTerm = theTerm;
        contains = false;
    }

    private Boolean areEqualTermsString(String term1, String term2){
    		term1 = term1.replaceAll("\\s+","");
    		term2 = term2.replaceAll("\\s+","");
//    		System.out.println("term1 " + term1 + term1.length());
//    		System.out.println("term2 " + term2 + term2.length());
    		 
    		return term1.equals(term2);
    }
    
    public Boolean visitTerm(Term term) {
//    	if (contains){ 
//    		return true;
//    	}
        Object[] array = term.getChildren();
        
        //MODIFICADO
        /*if (SpecUtils.areEqualTerms(term, theTerm)) {
            return true;
        }*/
        
        String termStr = SpecUtils.termToLatex(term);
//        System.out.println("theTerm " + theTerm);
//        System.out.println("term " + termStr);
        
        if (areEqualTermsString(theTerm,termStr)){ 
        	return true;
        }
        String auxTermStr;
        //MODIFICADO
        //System.out.println("theTerm " + SpecUtils.termToLatex(theTerm) );
        for (int i = 0; i < array.length; i++) {
            final Object object = array[i];
            if (object instanceof Term) {
                Term auxTerm = (Term) object;
                //MODIFICADO
                //System.out.println("auxTerm " + SpecUtils.termToLatex(auxTerm) );
                auxTermStr = SpecUtils.termToLatex(auxTerm);
//                System.out.println("theTerm " + theTerm);
//                System.out.println("auxTermStr " + auxTermStr);
                boolean equals = areEqualTermsString(theTerm,auxTermStr);
                contains = auxTerm.accept(this);
                if(equals || contains)
                    return true;
            }
        }
        return false;
    }

    public void setTerm(String term) {
        this.theTerm = term;
    }
    
}
