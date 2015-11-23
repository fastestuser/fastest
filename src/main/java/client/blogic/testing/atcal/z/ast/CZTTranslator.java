package client.blogic.testing.atcal.z.ast;

import net.sourceforge.czt.base.ast.Term;
import net.sourceforge.czt.util.Visitor;
import net.sourceforge.czt.z.ast.*;
import net.sourceforge.czt.z.ast.ZExprList;
import net.sourceforge.czt.z.impl.ApplExprImpl;
import net.sourceforge.czt.z.impl.ZExprListImpl;
import net.sourceforge.czt.z.visitor.ExprVisitor;

import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by Cristian on 03/08/15.
 */

/**
 * This class implements a visitor that translates CZT expressions into ATCAL Z expressions.
 * ATCAL has its own AST to represent the abstract test cases that simplifies the refiner implementation.
 */
public final class CZTTranslator implements ExprVisitor<ZExpr> {

    @Override
    public ZExpr visitExpr(Expr expr) {

        if (expr instanceof SetExpr) {
            ZExprListImpl zExprList = (ZExprListImpl) ((SetExpr) expr).getExprList();
            Set<ZExpr> zExprSet = zExprList.stream().map(new Function<Expr, ZExpr>() {
                @Override
                public ZExpr apply(Expr expr) {
                    return expr.accept(CZTTranslator.this);
                }
            }).collect(Collectors.toSet());
            return new ZExprSet(zExprSet);

        } else if (expr instanceof NumExpr) {
            //Todo: What if the number is bigger than a long?
            return new ZExprNum(((NumExpr) expr).getValue().longValue());

        } else if (expr instanceof RefExpr) {
            // The empty set expression has an instance of a different class than the rest of the sets.
            RefExpr refExpr = (RefExpr)expr;
            if (refExpr.getZName().getWord().equals("∅"))
                return ZExprSet.getEmptySet();
            else
                return new ZExprConst(refExpr.getZName().getWord(), ZExprConst.ConstantType.BASIC);

        } else if (expr instanceof TupleExpr) {
            ZExpr[] array = {};
            TupleExpr tupleExpr = (TupleExpr)expr;
            List<ZExpr> exprList = tupleExpr.getZExprList().stream().map(zExpr -> zExpr.accept(this)).collect(Collectors.toList());
            return new ZExprProd(exprList.toArray(array));

        } else if (expr instanceof ApplExpr) {
            ApplExpr applExpr = (ApplExpr)expr;
            if(applExpr.getMixfix() && ((RefExpr)applExpr.getLeftExpr()).getZName().getWord().equals("⟨ ,, ⟩")){
                ZExprList zExprList = ((SetExpr)applExpr.getRightExpr()).getZExprList();
                return new client.blogic.testing.atcal.z.ast.ZExprList((zExprList.stream().
                        map( t -> ((TupleExpr)t).getZExprList().get(1).accept(this)).collect(Collectors.toList())));
            }
        }
        throw new RuntimeException("Unsupported CZT expr translation.");
    }
}
