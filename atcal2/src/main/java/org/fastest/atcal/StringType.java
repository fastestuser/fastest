package org.fastest.atcal;

import org.fastest.atcal.apl.StringExpr;
import org.fastest.atcal.z.ast.*;

/**
 * Created by Cristian on 06/05/15.
 */
public class StringType extends ATCALType {

    // Conversion to string expression
    public StringExpr fromZExpr(ZExpr zExpr) {
        if (zExpr instanceof ZExprNum) {
            return new StringExpr(String.valueOf(((ZExprNum) zExpr).getNum()));
        } else if (zExpr instanceof ZExprString) {
            return new StringExpr(((ZExprString) zExpr).getStr());
        } else if (zExpr instanceof ZExprConst) {
            return new StringExpr(((ZExprConst) zExpr).getValue());
        } else if (zExpr instanceof ZExprAuto) {
            return new StringExpr("AUTOFILL");
        }
        // Unsupported conversion
        throw new RuntimeException("Unsupported operation.");
    }

    @Override
    public String toString() {
        return "String";
    }
}
