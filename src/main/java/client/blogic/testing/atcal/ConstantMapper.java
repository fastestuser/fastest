package client.blogic.testing.atcal;

import client.blogic.testing.atcal.apl.APLExpr;
import client.blogic.testing.atcal.apl.ConsExpr;
import client.blogic.testing.atcal.apl.LongExpr;
import client.blogic.testing.atcal.apl.StringExpr;
import client.blogic.testing.atcal.z.ast.ZExprConst;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.Range;

import java.util.Map;

/**
 * An instance of this class represents a mapper object responsible for the bijections of Z constants to APL expressions.
 * All mappings are reversible.
 * Created by Cristian on 02/12/15.
 */
public class ConstantMapper {

    private final BiMap<ZExprConst, APLExpr> biMap; // constants bijection map

    public ConstantMapper() {
        this.biMap = HashBiMap.create();
    }

    /**
     * Gets the mapping of the Z constant or adds a new mapping if it does not exists.
     *
     * @param zExprConst the Z constant
     * @param newAplExpr the new mapping value to add if it does not exists
     * @return the mapped APL expression for the Z constant
     */
    private APLExpr getOrPut(ZExprConst zExprConst, APLExpr newAplExpr) {
        APLExpr aplExpr = biMap.get(zExprConst);
        if (aplExpr == null) {
            biMap.put(zExprConst, newAplExpr);
            return newAplExpr;
        }
        return aplExpr;
    }

    /**
     * Converts a Z constant to APL numeric expression.
     *
     * @param zExprConst the Z constant
     * @return an APL numeric expression
     */
    public APLExpr toInt(ZExprConst zExprConst) {
        return getOrPut(zExprConst, new LongExpr(biMap.size()));
    }

    /**
     * Converts a Z constant to APL string expression.
     *
     * @param zExprConst the Z constant
     * @return an APL string expression
     */
    public APLExpr toString(ZExprConst zExprConst) {
        return getOrPut(zExprConst, new StringExpr(zExprConst.getValue()));
    }

    /**
     * Converts a Z constant to APL enum constant expression.
     *
     * @param zExprConst the Z constant
     * @param enumType   the APL enumeration type
     * @return an APL enum constant expression
     */
    public APLExpr toEnum(ZExprConst zExprConst, EnumType enumType) {

        APLExpr aplExpr = biMap.get(zExprConst);

        if (aplExpr == null) {
            switch (zExprConst.getType()) {
                // If the Z constant is a basic (or given) type we use positional enumeration refinement
                case BASIC:
                    // Use the constant ID as the index in the enumeration to convert
                    // TODO: what happens if the constantInt is beyond the int range?
                    int constantInt = biMap.size();

                    if (!Range.closed(0, enumType.getElemCount()).contains(constantInt))
                        throw new RuntimeException(
                                String.format("Cannot map Z constant %s to enum %s: Outside enumeration range.",
                                        zExprConst.getValue(), enumType.toString()));

                    aplExpr = enumType.getElemByIndex(constantInt);
                    break;

                // If the Z type of the constant is an enumeration type look up the matching APL constant by name
                case ENUM:
                    aplExpr = enumType.getElemByName(zExprConst.getValue());
                    if (aplExpr == null)
                        throw new RuntimeException(
                                String.format("Cannot map Z constant %s to enum %s: enumeration constant does not exist.",
                                        zExprConst.getValue(), enumType.toString()));

                    break;
            }
            biMap.put(zExprConst, aplExpr);
        }

        return aplExpr;
    }

    /**
     * Converts a Z constant to APL enum constant expression usgin a custom mapping.
     *
     * @param zExprConst the Z constant
     * @param customMap  the custom mapping
     * @return an APL enum constant expression
     */
    public APLExpr toEnum(ZExprConst zExprConst, Map<ZExprConst, ConsExpr> customMap) {

        if (this.biMap.containsKey(zExprConst))
            throw new RuntimeException(String.format("Cannot map Z constant %s to enum using custom map %s: constant is already mapped as %s.", zExprConst.getValue(), customMap.toString(), biMap.get(zExprConst).toString()));

        APLExpr aplExpr = customMap.get(zExprConst);
        this.biMap.put(zExprConst, aplExpr);
        return aplExpr;
    }

    /**
     * Converts a refined APL expression back to its Z constant value
     *
     * @param aplExpr the refined APL expression
     * @return a Z constant
     */
    public ZExprConst fromAPLExpr(APLExpr aplExpr) {
        return this.biMap.inverse().get(aplExpr);
    }
}
