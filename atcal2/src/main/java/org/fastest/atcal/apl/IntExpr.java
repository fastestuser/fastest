package org.fastest.atcal.apl;

/**
 * Created by Cristian on 4/20/15.
 */
public class IntExpr implements APLExpr {

    private final int value;

    public IntExpr(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "" + value;
    }
}
