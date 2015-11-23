package client.blogic.testing.atcal.z.ast;

import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;

import java.util.Iterator;
import java.util.Set;

/**
 * Created by Cristian on 3/31/15.
 */
public class ZExprSet implements ZExpr, Iterable<ZExpr> {

    private final ImmutableSet<ZExpr> set;

    public ZExprSet(ZExpr[] set) {
        this.set = ImmutableSet.copyOf(set);
    }

    public ZExprSet(Set<ZExpr> set) {
        this.set = ImmutableSet.copyOf(set);
    }

    private ZExprSet(ImmutableSet<ZExpr> set) {
        this.set = set;
    }

    public static ZExprSet of(ZExpr e1) {
        return new ZExprSet(ImmutableSet.of(e1));
    }

    public static ZExprSet of(ZExpr e1, ZExpr e2) {
        return new ZExprSet(ImmutableSet.of(e1, e2));
    }

    public static ZExprSet of(ZExpr e1, ZExpr e2, ZExpr e3) {
        return new ZExprSet(ImmutableSet.of(e1, e2, e3));
    }

    public static ZExprSet of(ZExpr e1, ZExpr e2, ZExpr e3, ZExpr e4) {
        return new ZExprSet(ImmutableSet.of(e1, e2, e3, e4));
    }

    public static ZExprSet of(ZExpr e1, ZExpr e2, ZExpr e3, ZExpr e4, ZExpr e5) {
        return new ZExprSet(ImmutableSet.of(e1, e2, e3, e4, e5));
    }

    private static final class EmptySetHolder {
        static final ZExprSet emptySet = new ZExprSet(Sets.newHashSet());
    }

    public static ZExprSet getEmptySet() {
        return EmptySetHolder.emptySet;
    }

    public boolean contains(ZExpr expr) {
        if (expr == null)
            return false;
        else
            return set.contains(expr);
    }

    public int getCard() {
        return set.size();
    }

    public ZExpr get(int n) {
        return set.asList().get(n);
    }

    public ZExprSet intersection(ZExprSet s) {
        return new ZExprSet(Sets.intersection(this.set, s.set));
    }

    public ZExprSet difference(ZExprSet s) {
        return new ZExprSet(Sets.difference(this.set, s.set));
    }

    public ZExprSet union(ZExprSet s) {
        return new ZExprSet(Sets.union(this.set, s.set));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ZExprSet zExprSet = (ZExprSet) o;

        if (!set.equals(zExprSet.set)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return set.hashCode();
    }

    @Override
    public String toString() {
        return "{" + Joiner.on(",").join(set) + '}';
    }

    public Iterator<ZExpr> iterator() {
        return set.iterator();
    }
}
