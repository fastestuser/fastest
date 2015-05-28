package org.fastest.atcal.z.ast;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * Created by Cristian on 28/05/15.
 */
public class ZExprList implements ZExpr, Iterable<ZExpr> {

    private final Iterable<ZExpr> zExprs;

    public ZExprList(Iterable<ZExpr> zExprs) {
        this.zExprs = zExprs;
    }

    @Override
    public void forEach(Consumer<? super ZExpr> action) {
        zExprs.forEach(action);
    }

    @Override
    public Spliterator<ZExpr> spliterator() {
        return zExprs.spliterator();
    }

    @Override
    public Iterator<ZExpr> iterator() {
        return zExprs.iterator();
    }

    @Override
    public String toString() {
        return "ZExprList" + zExprs;
    }
}
