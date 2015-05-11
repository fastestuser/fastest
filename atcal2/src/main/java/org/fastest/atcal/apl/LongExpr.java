package org.fastest.atcal.apl;

/**
 * Created by Cristian on 4/20/15.
 */
public class LongExpr implements APLExpr {

    private final long value;

    public LongExpr(long value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "" + value;
    }
}
