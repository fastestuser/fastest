package org.fastest.atcal;

import org.fastest.atcal.apl.APLExpr;
import org.fastest.atcal.z.ast.ZExpr;

import java.util.List;

/**
 * Created by cristian on 4/21/15.
 */
public class ContractType implements ATCALType {
    private final String constructor;
    private final List<String> constArgs;
    private final String setter;
    private final List<String> setterArgs;
    private final String getter;
    private final List<String> getterArgs;

    public ContractType(String constructor, List<String> constArgs, String setter, List<String> setterArgs,
                        String getter, List<String> getterArgs) {
        this.constructor = constructor;
        this.constArgs = constArgs;
        this.setter = setter;
        this.setterArgs = setterArgs;
        this.getter = getter;
        this.getterArgs = getterArgs;
    }

    public String getConstructor() {
        return constructor;
    }

    public List<String> getConstArgs() {
        return constArgs;
    }

    public String getSetter() {
        return setter;
    }

    public List<String> getSetterArgs() {
        return setterArgs;
    }

    public String getGetter() {
        return getter;
    }

    public List<String> getGetterArgs() {
        return getterArgs;
    }

    public APLExpr fromZExpr(ZExpr expr) throws Exception {
        throw new Exception();
    }
}
