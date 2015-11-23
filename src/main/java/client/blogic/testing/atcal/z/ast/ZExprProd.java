package client.blogic.testing.atcal.z.ast;

import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableList;

import java.util.List;

/**
 * Created by Cristian on 4/1/15.
 */
public class ZExprProd implements ZExpr {

    private final ImmutableList<ZExpr> prod;

    public ZExprProd(ZExpr[] prod) {
        this.prod = ImmutableList.copyOf(prod);
    }

    private ZExprProd(ImmutableList<ZExpr> prod) {
        this.prod = prod;
    }

    public static ZExprProd of(ZExpr e1) {
        return new ZExprProd(ImmutableList.of(e1));
    }

    public static ZExprProd of(ZExpr e1, ZExpr e2) {
        return new ZExprProd(ImmutableList.of(e1, e2));
    }

    public static ZExprProd of(ZExpr e1, ZExpr e2, ZExpr e3) {
        return new ZExprProd(ImmutableList.of(e1, e2, e3));
    }

    public static ZExprProd of(ZExpr e1, ZExpr e2, ZExpr e3, ZExpr e4) {
        return new ZExprProd(ImmutableList.of(e1, e2, e3, e4));
    }

    public static ZExprProd of(ZExpr e1, ZExpr e2, ZExpr e3, ZExpr e4, ZExpr e5) {
        return new ZExprProd(ImmutableList.of(e1, e2, e3, e4, e5));
    }

    public ImmutableList<ZExpr> getValues(){
        return prod;
    }

    public ZExpr getValue(int pos) {
        return prod.get(pos);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ZExprProd that = (ZExprProd) o;

        if (!prod.equals(that.prod)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return prod.hashCode();
    }

    @Override
    public String toString() {
        return "(" + Joiner.on(",").join(prod) + ')';
    }
}
