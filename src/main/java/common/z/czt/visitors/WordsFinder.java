package common.z.czt.visitors;

import net.sourceforge.czt.base.ast.Term;
import net.sourceforge.czt.base.visitor.TermVisitor;
import net.sourceforge.czt.z.visitor.ZNameVisitor;

import net.sourceforge.czt.z.ast.ZName;

import java.util.Collection;
import java.util.Iterator;

/**
 * An instance of this class allow the search for alphanumeric constants in a expression.
 * Those constants are specified through the repository that is passed as argument to the 
 * constructor of this class. WordsFinder is based on the Visitor desing pattern.
 * @author Pablo Rodriguez Monetti
 */
public class WordsFinder
        implements TermVisitor<Boolean>,
        ZNameVisitor<Boolean> {

    private Collection<String> varNamesRep;

    public WordsFinder(Collection<String> varNamesRep) {
        this.varNamesRep = varNamesRep;
    }

    public Boolean visitTerm(Term term) {
        Object[] array = term.getChildren();
        Boolean result = new Boolean(false);
        for (int i = 0; i < array.length && !result.booleanValue(); i++) {
            final Object object = array[i];
            if (object instanceof Term) {
                result = ((Term) object).accept(this);
            }
        }
        return result;
    }

    public Boolean visitZName(ZName zName) {
        String zNameWord = zName.toString();
        Iterator<String> it = varNamesRep.iterator();
        boolean hasFound = false;
        while (it.hasNext() && !hasFound) {
            String varName = it.next();
            if (zNameWord.equals(varName)) {
                hasFound = true;
            }
        }
        return new Boolean(hasFound);
    }
}
