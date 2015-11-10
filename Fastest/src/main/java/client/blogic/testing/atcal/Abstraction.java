package client.blogic.testing.atcal;

import client.blogic.testing.atcal.z.ast.*;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import common.z.SpecUtils;
import common.z.czt.UniqueZLive;
import net.sourceforge.czt.animation.eval.ZLive;
import net.sourceforge.czt.z.ast.Expr;
import net.sourceforge.czt.z.ast.Pred;
import net.sourceforge.czt.z.ast.RefExpr;
import net.sourceforge.czt.z.util.Factory;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
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
    private final Map<Long, ZExprConst> bijectionMap;

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
     * Creates a new abstraction instance.
     *
     * @param bijectionMap a map from values to constant names
     */
    public Abstraction(Map<Long, ZExprConst> bijectionMap) {
        this.bijectionMap = bijectionMap;
    }

    public Expr toZExpr(Object o, ZExpr target) {
        if (target instanceof ZExprNum) {
            if (o instanceof Integer)
                return zFactory.createNumExpr((Integer) o);
            else
                throw new RuntimeException("Cannot abstract object as number.");

        } else if (target instanceof ZExprConst) {
            // TODO: this conversion should consider bijection mappings
            if (o instanceof Integer) {
                String constantName = bijectionMap.get(o).getValue();
                return null; //FIXME: return a constant expression zFactory.createZName(constantName);
            } else if (o instanceof String) {
                return zFactory.createRefExpr(zFactory.createZName((String)o));
            } else {
                throw new RuntimeException("Cannot abstract object as constant.");
            }

        } else if (target instanceof ZExprProd) {
            ZExprProd zExprProd = (ZExprProd) target;
            if (o instanceof List) {
                List<Expr> exprList = Lists.newArrayList();
                for (int i = 0; i < zExprProd.getValues().size(); i++) {
                    exprList.add(toZExpr(((List) o).get(i), zExprProd.getValue(i)));
                }
                return null; //FIXME: zFactory.createProdExpr(exprList);
            } else {
                throw new RuntimeException("Cannot abstract object as cross product.");
            }

        } else if (target instanceof ZExprList) {
            if (o instanceof String) {
                return zFactory.createSequence(Arrays.asList(((String) o).split("")).stream().map(
                        s -> zFactory.createRefExpr(zFactory.createZName(s))
                ).collect(Collectors.toList()));
            } else if (o instanceof List) {
                List<Object> objectList = (List<Object>) o;
                List<Expr> exprList = objectList.stream().flatMap(
                        obj -> stream(((ZExprList) target)).map(t -> toZExpr(obj, t))
                ).collect(Collectors.toList());
                return zFactory.createSequence(exprList);
            } else {
                throw new RuntimeException("Cannot abstract object into a sequence.");
            }

        } else if (target instanceof ZExprSet) {
            if (o instanceof List) {
                List<Object> objectSet = (List<Object>) o;
                List<Expr> exprList = objectSet.stream().flatMap(
                        obj -> stream(((ZExprSet) target)).map(t -> toZExpr(obj, t))
                ).collect(Collectors.toList());
                return zFactory.createSetExpr(zFactory.createZExprList(exprList));
            } else {
                throw new RuntimeException("Cannot abstract object into a set.");
            }

        } else if (target instanceof ZExprSchema) {
            if (o instanceof Map) {
                Map<String, Object> objectMap = (Map<String, Object>) o;
                ZExprSchema targetSchema = (ZExprSchema) target;
                Map<RefExpr, Expr> vars = Maps.newHashMap();
                for(ZVar zVar: targetSchema.getMap().values()){
                    Object impVar = objectMap.get(zVar.getName());
                    vars.put(zFactory.createRefExpr(zFactory.createZName(zVar.getName())), toZExpr(impVar, zVar.getValue()));
                }

                Pred pred = SpecUtils.createAndPred(vars);
                return zFactory.createSchExpr(zFactory.createZSchText(null, pred));
            } else {
                throw new RuntimeException("Cannot abstract object into a schema.");
            }
        } else {
            throw new RuntimeException("Unsupported target abstraction type");
        }
    }
}
