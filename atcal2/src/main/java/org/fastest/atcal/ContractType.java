package org.fastest.atcal;

/**
 * Created by cristian on 4/21/15.
 */
public class ContractType implements ATCALType {
    private final String name;
    private final String constructor;
    private final String setter;
    private final String getter;

    public ContractType(String name, String constructor, String setter, String getter) {
        this.name = name;
        this.constructor = constructor;
        this.setter = setter;
        this.getter = getter;
    }

    public String getName() {
        return name;
    }

    public String getConstructor() {
        return constructor;
    }

    public String getSetter() {
        return setter;
    }

    public String getGetter() {
        return getter;
    }

}
