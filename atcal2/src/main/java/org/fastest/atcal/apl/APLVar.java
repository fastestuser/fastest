package org.fastest.atcal.apl;

import org.fastest.atcal.ATCALType;

/**
 * Created by cristian on 27/04/15.
 */
public class APLVar implements APLExpr, APLLValue {

    private final String name;
    private final ATCALType type;

    public APLVar(String name, ATCALType type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public ATCALType getType() {
        return type;
    }

    @Override
    public String toString() {
        return name;
    }
}
