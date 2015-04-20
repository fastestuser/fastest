package org.fastest.atcal.z.ast;

import com.google.common.base.Optional;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

import java.util.Map;

/**
 * Created by Cristian on 4/1/15.
 */
public class ZExprSchema implements ZExpr {

    private final ImmutableMap<String, ZVar> schema;

    public ZExprSchema(ZVar[] zVars) {
        Map<String, ZVar> schema = Maps.newHashMap();
        for (ZVar var : zVars)
            schema.put(var.getName(), var);
        this.schema = ImmutableMap.copyOf(schema);
    }

    private ZExprSchema(ImmutableMap<String, ZVar> schema) {
        this.schema = schema;
    }

    public static ZExprSchema of(ZVar v1) {
        return new ZExprSchema(ImmutableMap.of(v1.getName(), v1));
    }

    public static ZExprSchema of(ZVar v1, ZVar v2) {
        return new ZExprSchema(ImmutableMap.of(v1.getName(), v1, v2.getName(), v2));
    }

    public static ZExprSchema of(ZVar v1, ZVar v2, ZVar v3) {
        return new ZExprSchema(ImmutableMap.of(v1.getName(), v1, v2.getName(), v2, v3.getName(), v3));
    }

    public static ZExprSchema of(ZVar v1, ZVar v2, ZVar v3, ZVar v4) {
        return new ZExprSchema(ImmutableMap.of(v1.getName(), v1, v2.getName(), v2, v3.getName(), v3, v4.getName(), v4));
    }

    public static ZExprSchema of(ZVar v1, ZVar v2, ZVar v3, ZVar v4, ZVar v5) {
        return new ZExprSchema(ImmutableMap.of(v1.getName(), v1, v2.getName(), v2, v3.getName(), v3, v4.getName(), v4, v5.getName(), v5));
    }

    public static ZExprSchema add(ZExprSchema schema, ZVar var) {
        Map<String, ZVar> newMap = Maps.newHashMap(schema.schema);
        newMap.put(var.getName(), var);
        return new ZExprSchema(ImmutableMap.copyOf(newMap));
    }

    public Optional<ZVar> getVar(String varName) {
        return Optional.fromNullable(schema.get(varName));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ZExprSchema that = (ZExprSchema) o;

        if (!schema.equals(that.schema)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return schema.hashCode();
    }

    @Override
    public String toString() {
        return "[" + schema + ']';
    }
}
