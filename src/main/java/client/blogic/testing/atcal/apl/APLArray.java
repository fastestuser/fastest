package client.blogic.testing.atcal.apl;

import client.blogic.testing.atcal.ATCALType;
import client.blogic.testing.atcal.ArrayType;
import com.google.common.base.Objects;


/**
 * Created by Cristian on 05/05/15.
 */
public class APLArray implements APLExpr, APLLValue {

    private final String name;      // todo: arrays do not have names, variables do.
    private final ATCALType type;
    private int currentIndex = 0;   // scary side effect variable!

    public APLArray(String name, ATCALType type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof APLArray)) return false;
        APLArray aplArray = (APLArray) o;
        return Objects.equal(name, aplArray.name) &&
                Objects.equal(type, aplArray.type);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name, type);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public ATCALType getType() {
        return type;
    }

    public APLLValue getIndex(int index) {
        return new APLArrayIndex(this, index, ((ArrayType) type).getType());
    }

    public APLLValue getNextIndex() {
        // note the post increment in current index
        return new APLArrayIndex(this, currentIndex++, ((ArrayType) type).getType());
    }

    @Override
    public String toString() {
        return name;
    }

    public class APLArrayIndex implements APLExpr, APLLValue {

        private final APLArray parent;
        private final ATCALType type;
        private final int index;

        private APLArrayIndex(APLArray parent, int index, ATCALType type) {
            this.parent = parent;
            this.index = index;
            this.type = type;
        }

        @Override
        public String getName() {
            return parent.getName() + index;
        }

        public APLArray getParent() {
            return parent;
        }

        public int getIndex() {
            return index;
        }

        @Override
        public ATCALType getType() {
            return type;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof APLArrayIndex)) return false;
            APLArrayIndex that = (APLArrayIndex) o;
            return Objects.equal(index, that.index) &&
                    Objects.equal(parent, that.parent) &&
                    Objects.equal(type, that.type);
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(parent, type, index);
        }

        @Override
        public String toString(){
            return parent.getName() + "[" + index + "]";
        }
    }
}
