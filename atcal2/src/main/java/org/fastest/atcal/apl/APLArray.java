package org.fastest.atcal.apl;

import org.fastest.atcal.ATCALType;
import org.fastest.atcal.ArrayType;

/**
 * Created by Cristian on 05/05/15.
 */
public class APLArray implements APLExpr, APLLValue {

    private final String name;
    private final ATCALType type;
    private int currentIndex = 0;   // scary side effect variable!

    public APLArray(String name, ATCALType type) {
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

    public APLVar getIndex(int index) {
        return new APLVar(name + "[" + index + "]", ((ArrayType) type).getType());
    }

    public APLVar getNextIndex() {
        return new APLVar(name + "[" + currentIndex++ + "]", ((ArrayType) type).getType());     // note the post increment in current index
    }

    @Override
    public String toString() {
        return name;
    }
}
