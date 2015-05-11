package org.fastest.atcal;

import com.google.common.collect.Maps;
import org.fastest.atcal.apl.ConsExpr;
import org.fastest.atcal.z.ast.ZExpr;
import org.fastest.atcal.z.ast.ZExprConst;
import org.fastest.atcal.z.ast.ZExprNum;

import java.util.Collection;
import java.util.LinkedHashMap;

/**
 * Created by Cristian on 05/05/15.
 */
public class EnumType implements ATCALType {

    private final String name;
    private final LinkedHashMap<String, ConsExpr> elements;

    public EnumType(String name, Collection<String> elements) {
        this.name = name;
        this.elements = Maps.newLinkedHashMap();
        for (String e : elements)
            this.elements.put(e, new ConsExpr(e));
    }

    public String getName() {
        return name;
    }

    public ConsExpr getElem(String e) {
        return elements.get(e);
    }

    // Conversion to enum constants
    public ConsExpr fromZExpr(ZExpr zExpr) throws Exception {

        // Convert from Z numeric expression
        if (zExpr instanceof ZExprNum) {
            ZExprNum zExprNum = (ZExprNum) zExpr;

            // Check if the numeric expression value is between the bounds of the array.
            int value = (int) zExprNum.getNum();     // TODO: what happens if the value is beyond the int range?
            if (value < 0 && value > elements.values().size())
                throw new Exception();

            return (ConsExpr) elements.values().toArray()[value];

        // Convert from Z constant value
        } else if (zExpr instanceof ZExprConst) {
            ZExprConst zExprConst = (ZExprConst)zExpr;

            // We use the constant ID as the default bijection between the Z constant type and the integers.
            int value = (int) zExprConst.getConstId();// TODO: what happens if the value is beyond the int range?
            if (value < 0 && value > elements.values().size())
                throw new Exception();

            return (ConsExpr) elements.values().toArray()[value];
        }

        // Unsupported conversion
        throw new Exception();
    }

    @Override
    public String toString() {
        return "Enum " + name + "(" + elements.values() + ")";
    }
}
