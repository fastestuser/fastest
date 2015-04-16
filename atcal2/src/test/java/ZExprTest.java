import org.fastest.atcal.z.ast.*;
import org.junit.Test;

/**
 * Created by Cristian on 4/1/15.
 */
public class ZExprTest {

    private ZVar var1 = new ZVar("var1", new ZExprConst("val1"));
    private ZVar var2 = new ZVar("var2", new ZExprConst("val2"));
    private ZExprConst const1 = new ZExprConst("val3");
    private ZExprConst const2 = new ZExprConst("val4");
    private ZExprConst const3 = new ZExprConst("val5");
    private ZExprConst const4 = new ZExprConst("val5");
    private ZExprProd crossProd1 = ZExprProd.of(const1, const3);
    private ZExprProd crossProd2 = ZExprProd.of(const1, const4);
    private ZExprSet set1 = ZExprSet.of(const1, const2);
    private ZExprSet set2 = ZExprSet.of(const3);
    private ZExprSet set3 = ZExprSet.of(const1, const3);
    private ZVar var3 = new ZVar("var3", new ZExprNum(5));
    private ZVar var4 = new ZVar("var4", crossProd1);
    private ZVar var5 = new ZVar("var4", crossProd2);
    private ZExpr atc1 = ZExprSchema.of(var1, var2, var3, var4);
    private ZExpr atc2 = ZExprSchema.of(var4, var3, var2, var1);

    @Test
    public void equalityTest1() {
        assert (!const1.equals(const2));
    }

    @Test
    public void equalityTest2() {
        assert (const3.equals(const4));
    }

    @Test
    public void equalityTest3() {
        assert (!var1.equals(var2));
    }

    @Test
    public void equalityTest4() {
        assert (crossProd1.equals(crossProd2));
    }

    @Test
    public void equalityTest5() {
        assert (!set1.equals(set2));
    }

    @Test
    public void equalityTest7() {
        assert (atc1.equals(atc2));
    }

    @Test
    public void intersectionTest() {
        System.out.println(set1.intersection(set3).toString());
        assert (set1.intersection(set3).equals(new ZExprSet(new ZExpr[]{const1})));
    }

    @Test
    public void unionTest() {
        assert (set1.union(set2).equals(new ZExprSet(new ZExpr[]{const1, const2, const3})));
    }

    @Test
    public void differenceTest() {
        assert (set3.difference(set2).equals(new ZExprSet(new ZExpr[]{const1})));
    }
}