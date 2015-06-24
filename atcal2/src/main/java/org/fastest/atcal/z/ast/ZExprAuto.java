package org.fastest.atcal.z.ast;

import java.util.Iterator;

/**
 * Created by Cristian on 24/06/15.
 */
public class ZExprAuto implements ZExpr, Iterable<ZExpr> {

    private final ZExpr o;

    public ZExprAuto(){
        o = this;
    }

    @Override
    public Iterator<ZExpr> iterator() {
        return new Iterator<ZExpr>() {
            @Override
            public boolean hasNext() {
                return true;
            }

            @Override
            public ZExpr next() {
                return o;
            }
        };
    }
}
