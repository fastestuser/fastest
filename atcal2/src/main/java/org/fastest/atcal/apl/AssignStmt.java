package org.fastest.atcal.apl;

import com.google.common.base.Objects;

/**
 * Created by Cristian on 4/20/15.
 */
public class AssignStmt implements APLStmt {

    private final APLLValue lvalue;
    private final APLExpr expr;

    public AssignStmt(APLLValue lvalue, APLExpr expr) {
        this.lvalue = lvalue;
        this.expr = expr;
    }

    /**
     * Get the lvalue of the assignment
     * @return  the lvalue
     */
    public APLLValue getLvalue() {
        return lvalue;
    }

    /**
     * Get the expression of the assignment
     * @return  the expression
     */
    public APLExpr getExpr() {
        return expr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AssignStmt)) return false;
        AssignStmt that = (AssignStmt) o;
        return Objects.equal(lvalue, that.lvalue) &&
                Objects.equal(expr, that.expr);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(lvalue, expr);
    }

    @Override
    public String toString() {
        return lvalue.toString() + '=' + expr;
    }
}
