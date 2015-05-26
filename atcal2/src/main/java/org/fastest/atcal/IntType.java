package org.fastest.atcal;

import org.fastest.atcal.apl.LongExpr;
import org.fastest.atcal.z.ast.ZExpr;
import org.fastest.atcal.z.ast.ZExprConst;
import org.fastest.atcal.z.ast.ZExprNum;

/**
 * Created by Cristian on 06/05/15.
 */
public class IntType implements ATCALType {

    // Conversion to integer expression
    public LongExpr fromZExpr(ZExpr zExpr) throws Exception {
        if (zExpr instanceof ZExprNum) {
            return new LongExpr(((ZExprNum) zExpr).getNum());
        } else if (zExpr instanceof ZExprConst){
            return new LongExpr(((ZExprConst) zExpr).getConstId());
        }

        throw new Exception();
    }

    @Override
    public String toString() {
        return "Int";
    }
}
