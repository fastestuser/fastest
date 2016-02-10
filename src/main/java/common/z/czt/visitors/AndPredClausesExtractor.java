package common.z.czt.visitors;

import net.sourceforge.czt.z.ast.Pred;
import net.sourceforge.czt.z.ast.AndPred;
import net.sourceforge.czt.z.visitor.PredVisitor;
import net.sourceforge.czt.z.visitor.AndPredVisitor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import net.sourceforge.czt.z.ast.AndExpr;
import net.sourceforge.czt.z.ast.Expr;
import net.sourceforge.czt.z.ast.ExprPred;
import net.sourceforge.czt.z.impl.ZFactoryImpl;
import net.sourceforge.czt.z.visitor.AndExprVisitor;
import net.sourceforge.czt.z.visitor.ExprPredVisitor;
import net.sourceforge.czt.z.visitor.ExprVisitor;

/**
 * Instances of this class allow the extraction of the predicates that form a conjunction. The
 * class is based on the Visitor design pattern.
 * @author Pablo Rodriguez Monetti
 */
public class AndPredClausesExtractor
        implements AndPredVisitor<Collection<Pred>>,
        PredVisitor<Collection<Pred>>,
        ExprPredVisitor<Collection<Pred>>,
        AndExprVisitor<Collection<Pred>>,
        ExprVisitor<Collection<Pred>>{

    public Collection<Pred> visitAndPred(AndPred andPred) {
        Collection<Pred> predRep1 = andPred.getLeftPred().accept(this);
        Collection<Pred> predRep2 = andPred.getRightPred().accept(this);
        Iterator<Pred> predIt = predRep2.iterator();
        while (predIt.hasNext()) {
            Pred pred = predIt.next();
            predRep1.add(pred);
        }
        return predRep1;
    }

    public Collection<Pred> visitPred(Pred pred) {
        Collection<Pred> predRep = new ArrayList<Pred>();
        predRep.add(pred);
        return predRep;
    }

    public Collection<Pred> visitExprPred(ExprPred exprPred) {
        return (exprPred.getExpr()).accept(this);
    }

    public Collection<Pred> visitAndExpr(AndExpr andExpr) {
        Collection<Pred> predRep1 = andExpr.getLeftExpr().accept(this);
        Collection<Pred> predRep2 = andExpr.getRightExpr().accept(this);
        Iterator<Pred> predIt = predRep2.iterator();
        while (predIt.hasNext()) {
            predRep1.add(predIt.next());
        }
        return predRep1;
   }


    public Collection<Pred> visitExpr(Expr expr) {
        Collection<Pred> predRep = new ArrayList<Pred>();
        predRep.add((new ZFactoryImpl()).createExprPred(expr));
        return predRep;
    }


}
