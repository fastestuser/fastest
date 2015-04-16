package org.fastest.atcal.z.ast;

import com.google.common.collect.ImmutableList;

/**
 * Created by Cristian on 4/1/15.
 */
public class ZExprCrossProd implements ZExpr {

    private final ImmutableList<ZExpr> prod;

    public ZExprCrossProd(ZExpr[] prod) {
        this.prod = ImmutableList.copyOf(prod);
    }

    private ZExprCrossProd(ImmutableList<ZExpr> prod){
        this.prod = prod;
    }

    public static ZExprCrossProd of(ZExpr e1){
        return new ZExprCrossProd(ImmutableList.of(e1));
    }

    public static ZExprCrossProd of(ZExpr e1, ZExpr e2){
        return new ZExprCrossProd(ImmutableList.of(e1, e2));
    }

    public static ZExprCrossProd of(ZExpr e1, ZExpr e2, ZExpr e3){
        return new ZExprCrossProd(ImmutableList.of(e1, e2, e3));
    }

    public static ZExprCrossProd of(ZExpr e1, ZExpr e2, ZExpr e3, ZExpr e4){
        return new ZExprCrossProd(ImmutableList.of(e1, e2, e3, e4));
    }

    public static ZExprCrossProd of(ZExpr e1, ZExpr e2, ZExpr e3, ZExpr e4, ZExpr e5){
        return new ZExprCrossProd(ImmutableList.of(e1, e2, e3, e4, e5));
    }

    public ZExpr getValue(int pos) {
        return prod.get(pos);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ZExprCrossProd that = (ZExprCrossProd) o;

        if (!prod.equals(that.prod)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return prod.hashCode();
    }

    @Override
    public String toString() {
        return "ZExprCrossProd{" +
                "prod=" + prod +
                '}';
    }
}
