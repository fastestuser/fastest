package org.fastest.atcal;

import java.util.List;

/**
 * Created by cristian on 4/21/15.
 */
public class ContractType implements ATCALType {
    private final String name;
    private final String constructor;
    private final List<String> constArgs;
    private final String setter;
    private final List<String> setterArgs;
    private final String getter;
    private final List<String> getterArgs;

    public ContractType(String name, String constructor, List<String> constArgs, String setter, List<String> setterArgs,
                        String getter, List<String> getterArgs) {
        this.name = name;
        this.constructor = constructor;
        this.constArgs = constArgs;
        this.setter = setter;
        this.setterArgs = setterArgs;
        this.getter = getter;
        this.getterArgs = getterArgs;
    }

    public String getName() {
        return name;
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
}
