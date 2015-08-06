package client.blogic.testing.atcal.z.ast;

import net.sourceforge.czt.z.ast.Expr;
import net.sourceforge.czt.z.ast.NumExpr;
import net.sourceforge.czt.z.ast.RefExpr;
import net.sourceforge.czt.z.ast.SetExpr;
import net.sourceforge.czt.z.impl.ZExprListImpl;
import net.sourceforge.czt.z.visitor.ExprVisitor;

import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by Cristian on 03/08/15.
 */

/**
 * This class implements a visitor that translates CZT expressions into ATCAL Z expressions.
 * ATCAL has its own AST to represent the abstract test cases that simplifies the refiner's implementation.
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
            if (((RefExpr) expr).getZName().getWord().equals("∅"))
                return ZExprSet.getEmptySet();

        }
        throw new RuntimeException("Unsupported CZT expr translation.");
    }
}
