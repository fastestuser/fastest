package client.blogic.testing.atcal;

import client.blogic.testing.atcal.apl.APLExpr;
import client.blogic.testing.atcal.z.ast.ZExpr;

/**
 * Created by Cristian on 4/21/15.
 */
public abstract class ATCALType {
    /**
     * Convert a Z expression into an APL
     *
     * @param expr The Z expression
     * @return An APL expression or a runtime exception if conversion is not supported.
     */
    public APLExpr fromZExpr(ZExpr expr) {
        throw new RuntimeException("Unsupported operation.");
    }
}
