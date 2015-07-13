package client.blogic.testing.atcal.apl;

/**
 * Created by Cristian on 4/20/15.
 */
public class ConsExpr implements APLExpr {

    private final String value;

    public ConsExpr(String value) {
        this.value = value;
    }

    /**
     * Get the value of the expression
     * @return  a string representing the constant value
     */
    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ConsExpr consExpr = (ConsExpr) o;

        return value.equals(consExpr.value);

    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
