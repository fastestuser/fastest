package org.fastest.atcal.z.ast;

/**
 * Created by Cristian on 4/7/15.
 */
public class ZExprNum implements ZExpr {
    private final long num;

    public ZExprNum(long num) {
        this.num = num;
    }

    public long getNum() {
        return num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ZExprNum zExprNum = (ZExprNum) o;

        if (num != zExprNum.num) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (int) (num ^ (num >>> 32));
    }

    @Override
    public String toString() {
        return "" + num;
    }
}
