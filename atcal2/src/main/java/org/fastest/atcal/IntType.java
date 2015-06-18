package org.fastest.atcal;

import org.fastest.atcal.apl.LongExpr;
import org.fastest.atcal.z.ast.ZExpr;
import org.fastest.atcal.z.ast.ZExprConst;
import org.fastest.atcal.z.ast.ZExprNum;

/**
 * Created by Cristian on 06/05/15.
 */
public final class IntType extends ATCALType {

    private static final IntType INSTANCE = new IntType();

    private IntType() {
        if (INSTANCE != null) {
            throw new IllegalStateException("Already instantiated");
        }
    }

    public static IntType getInstance() {
        return INSTANCE;
    }

    // Conversion to integer expression
    @Override
    public LongExpr fromZExpr(ZExpr zExpr) {
        if (zExpr instanceof ZExprNum) {
            return new LongExpr(((ZExprNum) zExpr).getNum());
        } else if (zExpr instanceof ZExprConst) {
            return new LongExpr(((ZExprConst) zExpr).getConstId());
        }
        // Unsupported conversion
        throw new RuntimeException("Unsupported operation.");
    }

    @Override
    public String toString() {
        return "Int";
    }
}
