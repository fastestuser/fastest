package org.fastest.atcal;

import org.fastest.atcal.apl.StringExpr;
import org.fastest.atcal.z.ast.ZExpr;
import org.fastest.atcal.z.ast.ZExprNum;
import org.fastest.atcal.z.ast.ZExprString;

/**
 * Created by Cristian on 06/05/15.
 */
public class StringType implements ATCALType {

    // Conversion to string expression
    public StringExpr fromZExpr(ZExpr zExpr) throws Exception {
        if (zExpr instanceof ZExprNum)
            return new StringExpr(String.valueOf(((ZExprNum) zExpr).getNum()));
        else if (zExpr instanceof ZExprString)
            return new StringExpr(((ZExprString)zExpr).getStr());

        throw new Exception();
    }
}
