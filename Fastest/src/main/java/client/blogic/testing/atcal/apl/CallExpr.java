package client.blogic.testing.atcal.apl;

import com.google.common.base.Objects;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Cristian on 4/20/15.
 */
public class CallExpr implements APLExpr, APLStmt {

    private final String funName;
    private final List<APLLValue> args;

    public CallExpr(String funName, List<APLLValue> args) {
        this.funName = funName;
        this.args = args;
    }

    /**
     * Get function name
     *
     * @return the function name
     */
    public String getFunName() {
        return funName;
    }

    /**
     * Get function call arguments
     *
     * @return a list with the arguments
     */
    public List<APLLValue> getArgs() {
        return args;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CallExpr)) return false;
        CallExpr callExpr = (CallExpr) o;
        return Objects.equal(funName, callExpr.funName) &&
                Objects.equal(args, callExpr.args);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(funName, args);
    }

    @Override
    public String toString() {
        return funName + "(" + args.stream().map(Object::toString).collect(Collectors.joining(",")) + ")";
    }
}
