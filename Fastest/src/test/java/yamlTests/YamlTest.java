package yamlTests;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import common.z.SpecUtils;
import common.z.czt.UniqueZLive;
import net.sourceforge.czt.animation.eval.ZLive;
import net.sourceforge.czt.base.ast.Term;
import net.sourceforge.czt.base.util.UnmarshalException;
import net.sourceforge.czt.parser.circus.ParseUtils;
import net.sourceforge.czt.session.CommandException;
import net.sourceforge.czt.session.StringSource;
import net.sourceforge.czt.z.ast.*;
import net.sourceforge.czt.z.util.Factory;
import org.junit.Test;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by cristian on 21/09/15.
 */
public class YamlTest {

    @Test
    public void yamlTest() throws IOException, CommandException, UnmarshalException {
        InputStream input = getClass().getResourceAsStream("/test.yml");
        Yaml yaml = new Yaml();
        Map<String, Object> data = (Map<String, Object>) yaml.load(input);
        System.out.println("Input yaml" + data.toString());

        ZLive zLive = UniqueZLive.getInstance();
        Factory zFactory = zLive.getFactory();

        NameList nameList = zFactory.createZNameList(Lists.newArrayList(zFactory.createZName("toto")));
        List<Decl> decls = Lists.newArrayList(zFactory.createConstDecl(zFactory.createZName("pepe"), zFactory.createNumExpr(5)),
                zFactory.createVarDecl(zFactory.createZNameList(Lists.newArrayList(zFactory.createZName("titi"))), zFactory.createNumExpr(9)));
        DeclList declList = zFactory.createZDeclList(decls);
        Pred pred = zFactory.createTruePred();

        // Convert parsed variables into a Z predicate
        Map<RefExpr, Expr> vars = Maps.newHashMap();
        for (Map.Entry<String, Object> var : data.entrySet())
            vars.put(zFactory.createRefExpr(zFactory.createZName(var.getKey())), parseValue(var.getValue()));
        Pred pred2 = SpecUtils.createAndPred(vars);

        // Construct the Z schema with the parsed predicates
        SchText schText = zFactory.createZSchText(declList, pred2);
        AxPara myAxPara = zFactory.createAxPara(nameList, schText, Box.AxBox);

        // Print the Z schema
        zLive.printTerm(System.out, myAxPara);
    }

    private Expr parseValue(Object o) {

        ZLive zLive = UniqueZLive.getInstance();
        Factory zFactory = zLive.getFactory();

        if (o instanceof List) {
            List<Expr> exprList = ((List<Object>) o).stream().map(v -> parseValue(v)).collect(Collectors.toList());
            return zFactory.createSequence(exprList);
        } else if (o instanceof Set) {
            List<Expr> exprList = ((Set<Object>) o).stream().map(v -> parseValue(v)).collect(Collectors.toList());
            return zFactory.createSetExpr(zFactory.createZExprList(exprList));
        } else if (o instanceof Map) {
            Map<RefExpr, Expr> vars = Maps.newHashMap();
            for (Map.Entry<String, Object> var : ((Map<String, Object>)o).entrySet())
                vars.put(zFactory.createRefExpr(zFactory.createZName(var.getKey())), parseValue(var.getValue()));
            Pred pred = SpecUtils.createAndPred(vars);
            return zFactory.createSchExpr(zFactory.createZSchText(null, pred));
        } else if (o instanceof String) {
            return zFactory.createSequence(Arrays.asList(((String) o).split("")).stream().map(s -> zFactory.createRefExpr(zFactory.createZName(s))).collect(Collectors.toList()));
        } else if (o instanceof Integer) {
            return zFactory.createNumExpr((Integer)o);
        } else {
            return null;
        }
    }


}
