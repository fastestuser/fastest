package client.blogic.testing.atcal.apl;

import client.blogic.testing.atcal.ContractType;
import com.google.common.base.Objects;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Created by Cristian on 05/10/15.
 */
public class SetterCallStmt implements APLStmt {

    private final APLLValue lvalue;
    private final Collection<String> exprs;

    public SetterCallStmt(APLLValue lvalue, Collection<String> exprs){
        this.lvalue = lvalue;
        this.exprs = exprs;
    }

    public APLLValue getLvalue() {
        return lvalue;
    }

    public Collection<String> getExprs() {
        return exprs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SetterCallStmt)) return false;
        SetterCallStmt that = (SetterCallStmt) o;
        return Objects.equal(lvalue, that.lvalue) &&
                Objects.equal(exprs, that.exprs);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(lvalue, exprs);
    }

    @Override
    public String toString() {
        String args = this.exprs.stream().map(Object::toString).collect(Collectors.joining(","));
        return lvalue.getName() + "." + ((ContractType)lvalue.getType()).getSetter() + "(" + args + ")";
    }
}
