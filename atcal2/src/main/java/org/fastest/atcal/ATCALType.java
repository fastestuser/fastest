package org.fastest.atcal;

import org.fastest.atcal.apl.APLExpr;
import org.fastest.atcal.z.ast.ZExpr;

/**
 * Created by cristian on 4/21/15.
 */
public interface ATCALType {
    public APLExpr fromZExpr(ZExpr expr) throws Exception;
}
