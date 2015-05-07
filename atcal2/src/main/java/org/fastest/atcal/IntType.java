package org.fastest.atcal;

import org.fastest.atcal.apl.IntExpr;
import org.fastest.atcal.z.ast.ZExpr;
import org.fastest.atcal.z.ast.ZExprNum;

/**
 * Created by Cristian on 06/05/15.
 */
public class IntType implements ATCALType {

    // Conversion to integer expression
    public IntExpr fromZExpr(ZExpr zExpr) throws Exception {
        if (zExpr instanceof ZExprNum)
            return new IntExpr(((ZExprNum) zExpr).getNum());
        throw new Exception();
    }

}
