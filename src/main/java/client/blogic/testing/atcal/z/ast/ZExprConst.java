package client.blogic.testing.atcal.z.ast;

/**
 * Created by Cristian on 3/31/15.
 */
public class ZExprConst implements ZExpr {

    private final String value;
    private final ConstantType type;
    private final String zVarName;

    public ZExprConst(String value, String zVarName, ConstantType type) {
        this.value = value;
        this.type = type;
        this.zVarName = zVarName;
    }

    public static ZExprConst basic(String value, String zVarName) {
        return new ZExprConst(value, zVarName, ConstantType.BASIC);
    }

    public String getValue() {
        return value;
    }

    public ConstantType getType() {
        return type;
    }

    public String getZVarName() {
        return zVarName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ZExprConst that = (ZExprConst) o;

        if (!value.equals(that.value)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public String toString() {
        return value;
    }

    public enum ConstantType {
        BASIC,
        ENUM
    }
}
