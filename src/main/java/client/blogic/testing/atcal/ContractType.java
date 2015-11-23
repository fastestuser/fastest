package client.blogic.testing.atcal;

import java.util.List;

/**
 * Created by cristian on 4/21/15.
 */
public class ContractType extends ATCALType {
    private final String module;
    private final String constructor;
    private final List<String> constArgs;
    private final String setter;
    private final List<String> setterArgs;
    private final String getter;
    private final List<String> getterArgs;

    public ContractType(String constructor, List<String> constArgs, String setter, List<String> setterArgs,
                        String getter, List<String> getterArgs) {
        this.module = null;
        this.constructor = constructor;
        this.constArgs = constArgs;
        this.setter = setter;
        this.setterArgs = setterArgs;
        this.getter = getter;
        this.getterArgs = getterArgs;
    }

    public ContractType(String module, String constructor, List<String> constArgs, String setter, List<String> setterArgs,
                        String getter, List<String> getterArgs) {
        this.module = module.replaceAll("\"", "");  // remove string characters
        this.constructor = constructor;
        this.constArgs = constArgs;
        this.setter = setter;
        this.setterArgs = setterArgs;
        this.getter = getter;
        this.getterArgs = getterArgs;
    }

    public String getModule() {
        return module;
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

    @Override
    public String toString() {
        return "ContractType{" +
                "constructor='" + constructor + '\'' +
                ", constArgs=" + constArgs +
                ", setter='" + setter + '\'' +
                ", setterArgs=" + setterArgs +
                ", getter='" + getter + '\'' +
                ", getterArgs=" + getterArgs +
                '}';
    }
}
