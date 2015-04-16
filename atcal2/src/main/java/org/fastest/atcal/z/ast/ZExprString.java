package org.fastest.atcal.z.ast;

/**
 * Created by cristian on 4/7/15.
 */
public class ZExprString implements ZExpr {
    private final String str;

    public ZExprString(String str) {
        this.str = str;
    }

    public String getStr() {
        return str;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ZExprString that = (ZExprString) o;

        if (!str.equals(that.str)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return str.hashCode();
    }

    @Override
    public String toString() {
        return "ZExprString{" +
                "str='" + str + '\'' +
                '}';
    }
}
