package common.z.czt.visitors;

import java.util.*;

import net.sourceforge.czt.base.ast.Term;
import net.sourceforge.czt.base.visitor.VisitorUtils;
import net.sourceforge.czt.base.visitor.TermVisitor;
import net.sourceforge.czt.z.visitor.ZNameVisitor;
import net.sourceforge.czt.z.ast.ZName;

import java.util.Iterator;
import java.util.Collection;
import net.sourceforge.czt.z.ast.ZFactory;
import net.sourceforge.czt.z.ast.ZStrokeList;
import net.sourceforge.czt.z.impl.ZFactoryImpl;

/**
 * An instance of this class allow the adding of an apostrophe to each variable that appear in
 * an expression (in order toi make it a primed variable) provides that variable is contained
 * in the repository passed as argument to the constructor of this class. PrimeVarsMaker is
 * based on the Visitor design pattern.
 * @author Pablo Rodriguez Monetti
 */
public class PrimeVarsMaker
        implements TermVisitor<Term>,
        ZNameVisitor<Term> {

    private Collection<String> varNameRep;

    public PrimeVarsMaker(Collection<String> varNameRep) {
        this.varNameRep = varNameRep;
    }

    public void setVarNameRep(Collection<String> varNameRep) {
        this.varNameRep = varNameRep;
    }

    public Collection<String> getVarNameRep() {
        return varNameRep;
    }

    private void visitAnns(Term term, Term result) {
        List<Object> anns = result.getAnns();
        for (Object o : term.getAnns()) {
            if (o instanceof Term) {
                anns.add(((Term) o).accept(this));
            } else {
                anns.add(o);
            }
        }
    }

    public Term visitTerm(Term term) {
        Term result = VisitorUtils.visitTerm(this, term, false);
        visitAnns(term, result);
        return result;
    }

    public ZName visitZName(ZName zName) {
        CZTCloner cloneVisitor = new CZTCloner();
        ZName zNameClone = (ZName) zName.accept(cloneVisitor);
        String zNameWord = zName.getWord();

        boolean found = false;
        Iterator<String> it = varNameRep.iterator();
        while (it.hasNext() && !found) {
            if (it.next().equals(zNameWord)) {
                found = true;
            }
        }

        if (found) {
            ZFactory zFactory = new ZFactoryImpl();
            ZStrokeList zStrokeList = zFactory.createZStrokeList();
            zStrokeList.add(zFactory.createNextStroke());
            zNameClone.setWord(zNameWord);
            zNameClone.setStrokeList(zStrokeList);
        }
        return zNameClone;
    }
}
