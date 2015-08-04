package client.blogic.testing.atcal.z.ast;

import net.sourceforge.czt.base.ast.Term;
import net.sourceforge.czt.base.visitor.TermVisitor;
import net.sourceforge.czt.z.ast.*;
import net.sourceforge.czt.z.impl.ZExprListImpl;

import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by Cristian on 03/08/15.
 */
public final class CZTTranslator implements TermVisitor<ZExpr> {

    @Override
    public ZExpr visitTerm(Term term) {
        if (term instanceof ZSchText) {
            ZSchText zSchText = (ZSchText)term;
            ZVar zVar = (ZVar)(zSchText.getPred().accept(CZTTranslator.this));
            return ZExprSchema.of(zVar);

        } else if (term instanceof MemPred) {
            MemPred memPred = (MemPred) term;
            if (memPred.getMixfix() == true) {
                RefExpr leftExpr = (RefExpr) (memPred.getLeftExpr());
                SetExpr rightExpr = (SetExpr)memPred.getRightExpr();
                return new ZVar(leftExpr.getName().toString(), rightExpr.getZExprList().get(0).accept(CZTTranslator.this));
            } else {
                throw new RuntimeException("Unsupported term: " + term);
            }
        } else if (term instanceof SetExpr) {
            ZExprListImpl zExprList = (ZExprListImpl)((SetExpr) term).getExprList();
            Set<ZExpr> zExprSet = zExprList.stream().map(new Function<Expr, ZExpr>() {
                @Override
                public ZExpr apply(Expr expr) {
                    return expr.accept(CZTTranslator.this);
                }
            }).collect(Collectors.toSet());
            return new ZExprSet(zExprSet);
        } else if (term instanceof NumExpr) {
            //Todo: What if the number is bigger than a long?
            return new ZExprNum(((NumExpr)term).getValue().longValue());
        }

        return null;
    }
}
