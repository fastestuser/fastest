package org.fastest.atcal.apl;

/**
 * Created by Cristian on 4/20/15.
 */
public class AssignStmt implements APLStmt, APLExpr {

    private final APLLValue lvalue;
    private final APLExpr expr;

    public AssignStmt(APLLValue lvalue, APLExpr expr) {
        this.lvalue = lvalue;
        this.expr = expr;
    }

    @Override
    public String toString() {
        return lvalue.toString() + '=' + expr;
    }
}
