package org.fastest.atcal;

import org.fastest.atcal.apl.APLExpr;
import org.fastest.atcal.z.ast.ZExpr;

/**
 * Created by Cristian on 29/04/15.
 */
public class ArrayType implements ATCALType {

    private final String name;
    private final int size;

    public ArrayType(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public APLExpr fromZExpr(ZExpr expr) throws Exception {
        throw new Exception();
    }

    @Override
    public String toString() {
        return "Array{" +
                "name='" + name + '\'' +
                ", size=" + size +
                '}';
    }
}
