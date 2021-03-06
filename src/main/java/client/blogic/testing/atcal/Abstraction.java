package client.blogic.testing.atcal;

import client.blogic.testing.atcal.apl.LongExpr;
import client.blogic.testing.atcal.apl.StringExpr;
import client.blogic.testing.atcal.z.ast.*;
import client.blogic.testing.atcal.z.ast.ZExprList;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import common.z.SpecUtils;
import common.z.czt.UniqueZLive;
import net.sourceforge.czt.animation.eval.ZLive;
import net.sourceforge.czt.z.ast.*;
import net.sourceforge.czt.z.util.Factory;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * This class implements the abstraction function from implementation to specification values.
 *
 * @author Cristian Rosa on 04/11/15.
 */
public class Abstraction {

    private static final ZLive zLive = UniqueZLive.getInstance();
    private static final Factory zFactory = zLive.getFactory();
    private final ConcreteTCase concreteTCase;

    /**
     * Helper function to transform an iterable into a stream
     *
     * @param iterable the iterable to transform
     * @return a stream
     */
    public static <T> Stream<T> stream(Iterable<T> iterable) {
        return StreamSupport.stream(
                Spliterators.spliteratorUnknownSize(
                        iterable.iterator(),
                        Spliterator.ORDERED
                ),
                false
        );
    }

    /**
     * Creates a new instance of the abstraction class
     *
     * @param concreteTCase the concrete test case whose execution should be abstracted
     */
    public Abstraction(ConcreteTCase concreteTCase) {
        this.concreteTCase = concreteTCase;
    }

    public Expr toZExpr(Object yamlObject, String zVarName, ZExpr targetType) {
        if (targetType instanceof ZExprNum) {
            if (yamlObject instanceof Integer)
                return zFactory.createNumExpr((Integer) yamlObject);
            else
                throw new RuntimeException("Cannot abstract object as number.");

        } else if (targetType instanceof ZExprConst) {
            if (yamlObject instanceof Integer) {
                ZExprConst zExprConst = concreteTCase.getZVarConstantMaps().get(zVarName).fromAPLExpr(new LongExpr((Integer) yamlObject));
                return zFactory.createRefExpr(zFactory.createZName(zExprConst.getValue()));
            } else if (yamlObject instanceof String) {
                ZExprConst zExprConst = concreteTCase.getZVarConstantMaps().get(zVarName).fromAPLExpr(new StringExpr((String) yamlObject));
                return zFactory.createRefExpr(zFactory.createZName(zExprConst.getValue()));
            } else {
                throw new RuntimeException("Cannot abstract object as constant.");
            }

        } else if (targetType instanceof ZExprProd) {
            ZExprProd zExprProd = (ZExprProd) targetType;
            if (yamlObject instanceof List) {
                List<Expr> exprList = Lists.newArrayList();
                for (int i = 0; i < zExprProd.getValues().size(); i++) {
                    exprList.add(toZExpr(((List) yamlObject).get(i), zVarName, zExprProd.getValue(i)));
                }
                return zFactory.createProdExpr(zFactory.createZExprList(exprList));
            } else {
                throw new RuntimeException("Cannot abstract object as cross product.");
            }

        } else if (targetType instanceof ZExprList) {
            if (yamlObject instanceof String) {
                return zFactory.createSequence(Arrays.asList(((String) yamlObject).split("")).stream().map(
                        s -> zFactory.createRefExpr(zFactory.createZName(s))
                ).collect(Collectors.toList()));
            } else if (yamlObject instanceof List) {
                List<Object> objectList = (List<Object>) yamlObject;
                List<Expr> exprList = objectList.stream().flatMap(
                        obj -> stream(((ZExprList) targetType)).map(t -> toZExpr(obj, zVarName, t))
                ).collect(Collectors.toList());
                return zFactory.createSequence(exprList);
            } else {
                throw new RuntimeException("Cannot abstract object into a sequence.");
            }

        } else if (targetType instanceof ZExprSet) {
            if (yamlObject instanceof List) {
                List<Object> objectSet = (List<Object>) yamlObject;
                ZExpr t = ((ZExprSet) targetType).get(0);
                List<Expr> exprList = objectSet.stream().map(obj -> toZExpr(obj, zVarName, t)).collect(Collectors.toList());
                return zFactory.createSetExpr(zFactory.createZExprList(exprList));
            } else if (yamlObject instanceof Map) {
                Map<Object, Object> objectMap = (Map<Object, Object>) yamlObject;
                ZExpr t = ((ZExprSet) targetType).get(0);
                if (t instanceof ZExprProd) {
                    List<Expr> exprList = objectMap.entrySet().stream().map(keyVal -> toZExpr(Lists.newArrayList(keyVal.getKey(), keyVal.getValue()), zVarName, t)).collect(Collectors.toList());
                    return zFactory.createSetExpr(zFactory.createZExprList(exprList));
                }
            }
            throw new RuntimeException("Cannot abstract object into a set.");

        } else if (targetType instanceof ZExprSchema) {
            if (yamlObject instanceof Map) {
                Map<String, Object> objectMap = (Map<String, Object>) yamlObject;
                ZExprSchema targetSchema = (ZExprSchema) targetType;
                Map<RefExpr, Expr> vars = Maps.newHashMap();
                for (ZVar zVar : targetSchema.getMap().values()) {
                    Object impVar = objectMap.get(zVar.getName());
                    vars.put(zFactory.createRefExpr(zFactory.createZName(zVar.getName())), toZExpr(impVar, zVarName, zVar.getValue()));
                }

                Pred pred = SpecUtils.createAndPred(vars);
                return zFactory.createSchExpr(zFactory.createZSchText(null, pred));
            } else {
                throw new RuntimeException("Cannot abstract object into a schema.");
            }
        } else {
            throw new RuntimeException("Unsupported targetType abstraction type");
        }
    }

    /**
     * Abstracts the result of the execution of a concrete test case into a CZT schema. The result of the execution is
     * given in YAML format.
     *
     * @param yamlData the yaml representation of the execution to abstract
     * @return a CZT schema with the abstracted values
     */
    public AxPara toAxPara(Map<String, Object> yamlData) {
        Map<RefExpr, Expr> vars = Maps.newHashMap();
        for (Map.Entry<String, Object> var : yamlData.entrySet()) {
            ZExpr targetType;
            String zVarName;
            if(concreteTCase.getzVarImpVarMap().inverse().containsKey(var.getKey())) {
                zVarName = concreteTCase.getzVarImpVarMap().inverse().get(var.getKey()).getName();
                targetType = concreteTCase.getZExprSchema().getVar(zVarName).get().getValue();
            } else {
                // If the type of the zVar being abstracted is unspecified choose one for it (for a limited subset).
                zVarName = var.getKey();
                targetType = new ZExprNum(0);
            }
            RefExpr zVar = zFactory.createRefExpr(zFactory.createZName(zVarName));
            Expr zVarValue = toZExpr(var.getValue(), zVarName, targetType);
            vars.put(zVar, zVarValue);
        }
        Pred pred2 = SpecUtils.createAndPred(vars);
        Name name = zFactory.createZName(concreteTCase.getName() + "_RUN");
        DeclList declList = SpecUtils.getAxParaListOfDecl(concreteTCase.getAbstractTCase().getMyAxPara());

        // Construct the Z schema with the parsed predicates
        SchText schText = zFactory.createZSchText(declList, pred2);
        return zFactory.createSchema(name, schText);
    }
}
