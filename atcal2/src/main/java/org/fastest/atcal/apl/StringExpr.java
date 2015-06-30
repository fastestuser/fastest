package org.fastest.atcal.apl;

import com.google.common.base.Objects;

/**
 * Created by Cristian on 4/20/15.
 */
public class StringExpr implements APLExpr {

    private final String value;

    public StringExpr(String value) {
        this.value = value;
    }

    /**
     * Get the string value of the expression
     * @return  the string value
     */
    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StringExpr)) return false;
        StringExpr that = (StringExpr) o;
        return Objects.equal(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    @Override
    public String toString() {
        return "'" + value + "'";
    }
}
