package org.fastest.atcal;

import org.fastest.atcal.apl.APLExpr;
import org.fastest.atcal.z.ast.ZExpr;

/**
 * Created by Cristian on 4/21/15.
 */
public abstract class ATCALType {
    public APLExpr fromZExpr(ZExpr expr) {
        throw new RuntimeException("Unsupported operation.");
    }
}
