package org.fastest.atcal.apl;

import com.google.common.base.Objects;

/**
 * Created by Cristian on 4/20/15.
 */
public class LongExpr implements APLExpr {

    private final long value;

    public LongExpr(long value) {
        this.value = value;
    }

    /**
     * Get the value of the expression
     * @return  the long value
     */
    public long getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LongExpr)) return false;
        LongExpr longExpr = (LongExpr) o;
        return Objects.equal(value, longExpr.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    @Override
    public String toString() {
        return "" + value;
    }
}
