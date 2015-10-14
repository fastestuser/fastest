import client.blogic.testing.atcal.Atcal;
import client.blogic.testing.atcal.z.ast.*;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by Cristian on 13/10/15.
 */
public class CZTTranslatorTest {

    @Test
    public void test() {
        ZExprSchema atc = Atcal.parseATCFile("CZTTranslatorTest/atc1.tex");

        ZVar a = new ZVar("a", new ZExprNum(1));
        ZVar b = new ZVar("b", ZExprSet.of(new ZExprNum(1), new ZExprNum(2), new ZExprNum(3), new ZExprNum(4)));
        ZVar d = new ZVar("d", ZExprSet.of(new ZExprConst("h", ZExprConst.ConstantType.BASIC),
                new ZExprConst("i", ZExprConst.ConstantType.BASIC), new ZExprConst("j", ZExprConst.ConstantType.BASIC)));
        ZVar e = new ZVar("e", ZExprProd.of(new ZExprNum(1), new ZExprNum(2)));
        ZVar f = new ZVar("f", ZExprSet.of(ZExprProd.of(new ZExprConst("x", ZExprConst.ConstantType.BASIC), new ZExprNum(1)),
                ZExprProd.of(new ZExprConst("y", ZExprConst.ConstantType.BASIC), new ZExprNum(2))));
        ZVar k = new ZVar("k", new ZExprList(Arrays.asList(new ZExprNum(1), new ZExprNum(2), new ZExprNum(3), new ZExprNum(4))));
//        System.out.println(atc);
//        System.out.println(ZExprSchema.add(ZExprSchema.of(a,b,d,e,f), k));
        assert(ZExprSchema.add(ZExprSchema.of(a,b,d,e,f), k).equals(atc));
    }

}
