package org.fastest.atcal.apl;

/**
 * Created by Cristian on 4/20/15.
 */
public class ConsExpr implements APLExpr {

    private final String value;

    public ConsExpr(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
