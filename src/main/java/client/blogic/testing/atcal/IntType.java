package client.blogic.testing.atcal;


import client.blogic.testing.atcal.apl.LongExpr;
import client.blogic.testing.atcal.z.ast.ZExpr;
import client.blogic.testing.atcal.z.ast.ZExprAuto;
import client.blogic.testing.atcal.z.ast.ZExprConst;
import client.blogic.testing.atcal.z.ast.ZExprNum;

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
        } else if (zExpr instanceof ZExprAuto) {
            return new LongExpr(0xDEADBEEF);
        }
        // Unsupported conversion
        throw new RuntimeException("Unsupported operation.");
    }

    @Override
    public String toString() {
        return "Int";
    }
}
