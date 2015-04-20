package org.fastest.atcal.apl;

/**
 * Created by Cristian on 4/20/15.
 */
public class IntExpr implements APLExpr {

    private final long value;

    public IntExpr(long value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "" + value;
    }
}
