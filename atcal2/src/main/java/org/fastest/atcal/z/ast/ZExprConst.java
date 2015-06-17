package org.fastest.atcal.z.ast;

/**
 * Created by Cristian on 3/31/15.
 */
public class ZExprConst implements ZExpr {

    private final String value;
    private final long constId;
    private final ConstantType type;
    public ZExprConst(String value, long constId, ConstantType type) {
        this.value = value;
        this.constId = constId;
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public long getConstId() {
        return constId;
    }

    public ConstantType getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ZExprConst that = (ZExprConst) o;

        if (!value.equals(that.value)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public String toString() {
        return value;
    }

    public enum ConstantType {BASIC, ENUM}
}
