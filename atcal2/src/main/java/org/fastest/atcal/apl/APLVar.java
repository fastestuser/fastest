package org.fastest.atcal.apl;

import com.google.common.base.Objects;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof APLVar)) return false;
        APLVar aplVar = (APLVar) o;
        return Objects.equal(name, aplVar.name) &&
                Objects.equal(type, aplVar.type);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name, type);
    }

    @Override
    public String toString() {
        return name;
    }
}
