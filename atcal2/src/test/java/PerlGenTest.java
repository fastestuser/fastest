import com.google.common.collect.Lists;
import org.fastest.atcal.ArrayType;
import org.fastest.atcal.IntType;
import org.fastest.atcal.apl.*;
import org.fastest.atcal.generators.PerlGen;
import org.junit.Test;

/**
 * Created by Cristian on 30/06/15.
 */
public class PerlGenTest {

    @Test
    public void test1() {

        PerlGen perlGen = new PerlGen();
        APLArray arr1 = new APLArray("myArray", new ArrayType(IntType.getInstance(), 10));
        APLVar var1 = new APLVar("myVar", IntType.getInstance());
        APLExpr longExpr = new LongExpr(6);
        APLExpr constExpr = new ConsExpr("HELLO");
        APLExpr stringExpr = new StringExpr("World");
        CallExpr callExpr = new CallExpr("function", Lists.newArrayList("a", "b", "c"));

        System.out.println(perlGen.generate(new AssignStmt(var1, longExpr)));
        System.out.println(perlGen.generate(new AssignStmt(var1, constExpr)));
        System.out.println(perlGen.generate(new AssignStmt(arr1.getIndex(0), stringExpr)));
        System.out.println(perlGen.generate(new AssignStmt(var1, callExpr)));
        System.out.println(perlGen.generate(callExpr));
    }

}
