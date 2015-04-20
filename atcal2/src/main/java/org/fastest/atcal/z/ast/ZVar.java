package org.fastest.atcal.z.ast;

/**
 * Created by Cristian on 3/31/15.
 */
public class ZVar implements ZExpr {

    private final String name;
    private final ZExpr value;

    public ZVar(String name, ZExpr value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public ZExpr getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ZVar zVar = (ZVar) o;

        if (!name.equals(zVar.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return  name + "=" + value;
    }
}
