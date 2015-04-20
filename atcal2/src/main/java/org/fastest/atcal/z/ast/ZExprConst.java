package org.fastest.atcal.z.ast;

/**
 * Created by Cristian on 3/31/15.
 */
public class ZExprConst implements ZExpr {

    private final String value;

    public ZExprConst(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
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
}
