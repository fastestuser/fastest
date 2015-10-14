package client.blogic.testing.atcal.z.ast;

import com.google.common.base.Joiner;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import java.util.Map;
import java.util.Set;

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
        return "[" + Joiner.on(",").join(schema.values()) + ']';
    }

    /**
     * Z expression schema builder class
     */
    public static class Builder {

        private Set<ZVar> vars;

        public Builder() {
            this.vars = Sets.newHashSet();
        }

        public Builder addNumVar(String name, long num){
            this.vars.add(new ZVar(name, new ZExprNum(num)));
            return this;
        }

        public Builder addConstVar(String name, String cons){
            this.vars.add(new ZVar(name, new ZExprConst(cons, ZExprConst.ConstantType.BASIC)));
            return this;
        }

        public Builder addVar(String name, ZExpr expr){
            this.vars.add(new ZVar(name, expr));
            return this;
        }

        public ZExprSchema build(){
            ZVar[] a = {};
            return new ZExprSchema(vars.toArray(a));
        }
    }
}
