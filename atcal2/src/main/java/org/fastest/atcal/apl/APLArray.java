package org.fastest.atcal.apl;

import com.google.common.base.Objects;
import org.fastest.atcal.ATCALType;
import org.fastest.atcal.ArrayType;

/**
 * Created by Cristian on 05/05/15.
 */
public class APLArray implements APLExpr, APLLValue {

    private final String name;      // todo: arrays do not have names, variables do.
    private final ATCALType type;
    private int currentIndex = 0;   // scary side effect variable!

    public APLArray(String name, ATCALType type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof APLArray)) return false;
        APLArray aplArray = (APLArray) o;
        return Objects.equal(name, aplArray.name) &&
                Objects.equal(type, aplArray.type);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name, type);
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
