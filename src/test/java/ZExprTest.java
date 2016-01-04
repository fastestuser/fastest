import client.blogic.testing.atcal.z.ast.*;
import org.junit.Test;

/**
 * Created by Cristian on 4/1/15.
 */
public class ZExprTest {

    private ZVar var1 = new ZVar("var1", new ZExprConst("val1", "var1", ZExprConst.ConstantType.BASIC));
    private ZVar var2 = new ZVar("var2", new ZExprConst("val2", "var2", ZExprConst.ConstantType.BASIC));
    private ZExprNum num1 = new ZExprNum(1);
    private ZExprNum num2 = new ZExprNum(2);
    private ZExprNum num3 = new ZExprNum(3);
    private ZExprNum num4 = new ZExprNum(4);
    private ZExprProd crossProd1 = ZExprProd.of(num1, num3);
    private ZExprProd crossProd2 = ZExprProd.of(num1, num4);
    private ZExprSet set1 = ZExprSet.of(num1, num2);
    private ZExprSet set2 = ZExprSet.of(num3);
    private ZExprSet set3 = ZExprSet.of(num1, num3);
    private ZVar var3 = new ZVar("var3", new ZExprNum(5));
    private ZVar var4 = new ZVar("var4", crossProd1);
    private ZExpr atc1 = ZExprSchema.of(var1, var2, var3, var4);
    private ZExpr atc2 = ZExprSchema.of(var4, var3, var2, var1);

    @Test
    public void equalityTest1() {
        assert (!num1.equals(num2));
    }

    @Test
    public void equalityTest2() {
        assert (!num3.equals(num4));
    }

    @Test
    public void equalityTest3() {
        assert (!var1.equals(var2));
    }

    @Test
    public void equalityTest4() {
        assert (!crossProd1.equals(crossProd2));
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
        assert (set1.intersection(set3).equals(new ZExprSet(new ZExpr[]{num1})));
    }

    @Test
    public void unionTest() {
        assert (set1.union(set2).equals(new ZExprSet(new ZExpr[]{num1, num2, num3})));
    }

    @Test
    public void differenceTest() {
        assert (set3.difference(set2).equals(new ZExprSet(new ZExpr[]{num1})));
    }
}