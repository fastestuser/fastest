package org.fastest.atcal.apl;

/**
 * Created by Cristian on 05/05/15.
 */
public class APLArray implements APLExpr, APLLValue {

    private final String name;
    private final int index;

    public APLArray(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public String toString() {
        return name + '[' + index + ']';
    }
}
