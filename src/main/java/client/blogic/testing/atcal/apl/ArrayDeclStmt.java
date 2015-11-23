package client.blogic.testing.atcal.apl;

import client.blogic.testing.atcal.ArrayType;
import com.google.common.base.Objects;

/**
 * Created by Cristian on 4/20/15.
 */
public class ArrayDeclStmt implements APLStmt {

    private final ArrayType type;
    private final String name;
    private final long size;

    public ArrayDeclStmt(ArrayType type, String name, long size) {
        this.type = type;
        this.name = name;
        this.size = size;
    }

    public ArrayType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public long getSize() {
        return size;
    }

    @Override
    public String toString() {
        return type + " " + name + '[' + size + ']';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ArrayDeclStmt)) return false;
        ArrayDeclStmt that = (ArrayDeclStmt) o;
        return Objects.equal(size, that.size) &&
                Objects.equal(type, that.type) &&
                Objects.equal(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(type, name, size);
    }
}
