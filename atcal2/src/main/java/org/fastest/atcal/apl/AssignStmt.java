package org.fastest.atcal.apl;

/**
 * Created by Cristian on 4/20/15.
 */
public class AssignStmt implements APLStmt {

    private final APLVar lvalue;
    private final APLExpr expr;

    public AssignStmt(APLVar lvalue, APLExpr expr) {
        this.lvalue = lvalue;
        this.expr = expr;
    }

    @Override
    public String toString() {
        return lvalue.toString() + '=' + expr;
    }
}
