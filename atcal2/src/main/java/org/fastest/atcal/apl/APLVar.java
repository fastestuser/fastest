package org.fastest.atcal.apl;

/**
 * Created by cristian on 27/04/15.
 */
public class APLVar implements APLExpr {

    private final String name;

    public APLVar(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
