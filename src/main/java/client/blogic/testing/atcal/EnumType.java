package client.blogic.testing.atcal;

import client.blogic.testing.atcal.apl.ConsExpr;
import client.blogic.testing.atcal.z.ast.ZExpr;
import client.blogic.testing.atcal.z.ast.ZExprAuto;
import client.blogic.testing.atcal.z.ast.ZExprConst;
import client.blogic.testing.atcal.z.ast.ZExprNum;
import com.google.common.collect.Maps;
import com.google.common.collect.Range;

import java.util.Collection;
import java.util.LinkedHashMap;

/**
 * Created by Cristian on 05/05/15.
 */
public class EnumType extends ATCALType {

    private final String name;
    private final LinkedHashMap<String, ConsExpr> elements;

    public EnumType(String name, Collection<String> elements) {
        this.name = name;
        this.elements = Maps.newLinkedHashMap();
        for (String e : elements)
            this.elements.put(e, new ConsExpr(e));
    }

    public ConsExpr getElemByName(String e) {
        return elements.get(e);
    }

    public ConsExpr getElemByIndex(int index) {
        return elements.values().toArray(new ConsExpr[elements.values().size()])[index];
    }

    public int getElemCount(){
        return elements.size();
    }

    // Conversion to enum constants from Z types without bijection maps.
    @Override
    public ConsExpr fromZExpr(ZExpr zExpr) {

        // Convert from Z numeric expression
        if (zExpr instanceof ZExprNum) {
            ZExprNum zExprNum = (ZExprNum) zExpr;

            // Check if the numeric expression value is between the bounds of the array.
            int value = (int) zExprNum.getNum();     // TODO: what happens if the value is beyond the int range?
            if (!Range.closed(0, getElemCount()).contains(value))
                throw new RuntimeException("Z integer value is outside ATCAL enumeration range.");

            return getElemByIndex(value);

            // Convert from Z constant value
        } else if (zExpr instanceof ZExprAuto) {
            // AUTOFILL expressions get the first value in the enumeration
            return elements.values().iterator().next();
        }

        // Unsupported conversion
        throw new RuntimeException("Unsupported operation.");
    }

    @Override
    public String toString() {
        return "Enum " + name + "(" + elements.values() + ")";
    }
}
