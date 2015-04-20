package org.fastest.atcal.apl;

/**
 * Created by Cristian on 4/20/15.
 */
public class AssignStmt implements APLStmt {

    private final String lvalue;
    private final APLExpr expr;

    public AssignStmt(String lvalue, APLExpr expr) {
        this.lvalue = lvalue;
        this.expr = expr;
    }

    @Override
    public String toString() {
        return lvalue + '=' + expr;
    }
}
