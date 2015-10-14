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

        ZExprSchema atcTest = new ZExprSchema.Builder().
                addNumVar("a", 1).
                addVar("b", ZExprSet.of(new ZExprNum(1), new ZExprNum(2), new ZExprNum(3), new ZExprNum(4))).
                addVar("d", ZExprSet.of(ZExprConst.basic("h"), ZExprConst.basic("i"), ZExprConst.basic("j"))).
                addVar("e", ZExprProd.of(new ZExprNum(1), new ZExprNum(2))).
                addVar("f", ZExprSet.of(ZExprProd.of(ZExprConst.basic("x"), new ZExprNum(1)), ZExprProd.of(ZExprConst.basic("y"), new ZExprNum(2)))).
                addVar("k", new ZExprList(Arrays.asList(new ZExprNum(1), new ZExprNum(2), new ZExprNum(3), new ZExprNum(4)))).build();

//        System.out.println(atc);
//        System.out.println(ZExprSchema.add(ZExprSchema.of(a,b,d,e,f), k));
        assert (atcTest.equals(atc));
    }

}
