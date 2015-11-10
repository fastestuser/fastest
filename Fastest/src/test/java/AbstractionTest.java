import client.blogic.testing.atcal.Abstraction;
import client.blogic.testing.atcal.z.ast.*;
import com.google.common.collect.Maps;
import common.z.SpecUtils;
import org.junit.Test;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Map;

/**
 * Created by Cristian on 05/11/15.
 */
public class AbstractionTest {

    private static final Map<Long, ZExprConst> bijectionMap = Maps.newHashMap();

    private Map<String, Object> loadYaml(String resourceName) {
        // Parse the YAML output and abstract it back to a Z schema
        InputStream inputStream = this.getClass().getResourceAsStream(resourceName);
        Yaml yaml = new Yaml();
        return (Map<String, Object>) yaml.load(inputStream);
    }

    @Test
    public void numTest() {
        Abstraction abstraction = new Abstraction(bijectionMap);
        Map<String, Object> yamlData = loadYaml("AbstractionTest/abstractionTest.yml");
        ZExprNum zExprNum = new ZExprNum(1);
        System.out.println(abstraction.toZExpr(yamlData.get("myA"), zExprNum));
    }

    @Test
    public void seqTest() {
        Abstraction abstraction = new Abstraction(bijectionMap);
        Map<String, Object> yamlData = loadYaml("AbstractionTest/abstractionTest.yml");
        ZExprList zExprList = new ZExprList(Arrays.asList(new ZExprNum(1)));
        System.out.println(SpecUtils.termToLatex(abstraction.toZExpr(yamlData.get("myArr"), zExprList)));
    }

    @Test
    public void schemaTest() {
        Abstraction abstraction = new Abstraction(bijectionMap);
        Map<String, Object> yamlData = loadYaml("AbstractionTest/abstractionTest.yml");
        ZExprSchema zExprSchema = ZExprSchema.of(new ZVar("1", ZExprConst.basic("a")),
                new ZVar("2", ZExprConst.basic("b")), new ZVar("3", ZExprConst.basic("c")));
        System.out.println(SpecUtils.termToLatex(abstraction.toZExpr(yamlData.get("myHash"), zExprSchema)));
    }

    @Test
    public void setTest() {
        Abstraction abstraction = new Abstraction(bijectionMap);
        Map<String, Object> yamlData = loadYaml("AbstractionTest/abstractionTest.yml");
        ZExprSet zExprSet = ZExprSet.of(new ZExprNum(1));
        System.out.println(SpecUtils.termToLatex(abstraction.toZExpr(yamlData.get("myArr"), zExprSet)));
    }
}
