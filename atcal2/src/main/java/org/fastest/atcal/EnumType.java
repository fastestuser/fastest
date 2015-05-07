package org.fastest.atcal;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import org.fastest.atcal.apl.APLExpr;
import org.fastest.atcal.apl.ConsExpr;
import org.fastest.atcal.z.ast.ZExpr;
import org.fastest.atcal.z.ast.ZExprNum;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Cristian on 05/05/15.
 */
public class EnumType implements ATCALType {

    private final String name;
    private final LinkedHashMap<String, ConsExpr> elements;

    public EnumType(String name, Collection<String> elements) {
        this.name = name;
        this.elements = Maps.newLinkedHashMap();
        for(String e: elements)
            this.elements.put(e, new ConsExpr(e));
    }

    public String getName() {
        return name;
    }

    public ConsExpr getElem(String e){
        return elements.get(e);
    }

    // Conversion to enum constants
    public ConsExpr fromZExpr(ZExpr zExpr) throws Exception {
        if (zExpr instanceof ZExprNum){
            return (ConsExpr)elements.values().toArray()[(int)((ZExprNum)zExpr).getNum()];
        }
        throw new Exception();
    }

    @Override
    public String toString() {
        return "Enum " + name +  "(" + elements.values() + ")";
    }
}
