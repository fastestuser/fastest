import client.blogic.testing.atcal.Abstraction;
import client.blogic.testing.atcal.Atcal;
import client.blogic.testing.atcal.ConcreteTCase;
import client.blogic.testing.atcal.ConstantMapper;
import client.blogic.testing.atcal.z.ast.*;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.Maps;
import com.google.common.io.Resources;
import common.z.AbstractTCase;
import common.z.AbstractTCaseImpl;
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

    private static final ConcreteTCase concreteTCase = new ConcreteTCase("test", "test", "test", null, null, null, null);

    private Map<String, Object> loadYaml(String resourceName) {
        // Parse the YAML output and abstract it back to a Z schema
        InputStream inputStream = this.getClass().getResourceAsStream(resourceName);
        Yaml yaml = new Yaml();
        return (Map<String, Object>) yaml.load(inputStream);
    }

    @Test
    public void numTest() {
        Abstraction abstraction = new Abstraction(concreteTCase);
        Map<String, Object> yamlData = loadYaml("AbstractionTest/abstractionTest.yml");
        ZExprNum zExprNum = new ZExprNum(1);
        System.out.println(abstraction.toZExpr(yamlData.get("myA"), "myA", zExprNum));
    }

    @Test
    public void seqTest() {
        Abstraction abstraction = new Abstraction(concreteTCase);
        Map<String, Object> yamlData = loadYaml("AbstractionTest/abstractionTest.yml");
        ZExprList zExprList = new ZExprList(Arrays.asList(new ZExprNum(1)));
        System.out.println(SpecUtils.termToLatex(abstraction.toZExpr(yamlData.get("myArr"), "myArr", zExprList)));
    }

    @Test
    public void schemaTest() {

        // The test uses a schema with a Z variable of type schema
        ZExprSchema myHash = ZExprSchema.of(new ZVar("1", ZExprConst.basic("a", "1")),
                new ZVar("2", ZExprConst.basic("b", "2")), new ZVar("3", ZExprConst.basic("c", "3")));
        ZExprSchema zExprSchema = ZExprSchema.of(new ZVar("myHash", myHash));

        // We are not running the refinement law evaluator, thus create the maps of constants for the Z vars manually.
        Map<String, ConstantMapper> zVarConstantMaps = Maps.newHashMap();
        BiMap<ZVar, String> zVarImpVarMap = HashBiMap.create();
        ConstantMapper constantMapper = new ConstantMapper();
        for (ZVar zVar : myHash.getMap().values()) {
            constantMapper.toString((ZExprConst) zVar.getValue());
        }
        zVarConstantMaps.put("myHash", constantMapper);

        // Create a concrete test case that includes the maps of constants
        ConcreteTCase concreteTCase = new ConcreteTCase("test", "test", "test", zExprSchema, null, zVarConstantMaps, zVarImpVarMap);
        Abstraction abstraction = new Abstraction(concreteTCase);
        Map<String, Object> yamlData = loadYaml("AbstractionTest/abstractionTest.yml");
        System.out.println(SpecUtils.termToLatex(abstraction.toZExpr(yamlData, "myHash", zExprSchema)));
    }

    @Test
    public void setTest() {
        Abstraction abstraction = new Abstraction(concreteTCase);
        Map<String, Object> yamlData = loadYaml("AbstractionTest/abstractionTest.yml");
        ZExprSet zExprSet = ZExprSet.of(new ZExprNum(1), new ZExprNum(2));
        System.out.println(SpecUtils.termToLatex(abstraction.toZExpr(yamlData.get("myArr"), "myArr", zExprSet)));
    }

    @Test
    public void toAxParaTest() {
        AbstractTCase atc = AbstractTCaseImpl.fromFile(Resources.getResource("AbstractionTest/toAxPara_test.tex"));
        ZExprSchema atcalAtc = Atcal.ATCToZExpr(atc);
        Map<String, ConstantMapper> zVarConstantMaps = Maps.newHashMap();
        BiMap<ZVar, String> zVarImpVarMap = HashBiMap.create();
        zVarImpVarMap.put(atcalAtc.getVar("myA").get(), "myA");
        zVarImpVarMap.put(atcalAtc.getVar("myArr").get(), "myArr");
        zVarImpVarMap.put(atcalAtc.getVar("myHash").get(), "myHash");
        ConstantMapper constantMapper = new ConstantMapper();
        constantMapper.toString(ZExprConst.basic("1", "myHash"));
        constantMapper.toString(ZExprConst.basic("a", "myHash"));
        constantMapper.toString(ZExprConst.basic("2", "myHash"));
        constantMapper.toString(ZExprConst.basic("b", "myHash"));
        constantMapper.toString(ZExprConst.basic("3", "myHash"));
        constantMapper.toString(ZExprConst.basic("c", "myHash"));
        zVarConstantMaps.put("myHash", constantMapper);
        ConcreteTCase concreteTCase = new ConcreteTCase("test", "test", "test", atcalAtc, atc, zVarConstantMaps, zVarImpVarMap);
        Abstraction abstraction = new Abstraction(concreteTCase);
        Map<String, Object> yamlData = loadYaml("AbstractionTest/toAxPara_test.yml");
        System.out.println(SpecUtils.termToLatex(abstraction.toAxPara(yamlData)));
    }
}
