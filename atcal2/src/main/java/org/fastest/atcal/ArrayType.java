package org.fastest.atcal;

/**
 * Created by Cristian on 29/04/15.
 */
public class ArrayType extends ATCALType {

    private final ATCALType type;
    private final int size;

    public ArrayType(ATCALType type, int size) {
        this.type = type;
        this.size = size;
    }

    public ATCALType getType() {
        return type;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "Array{" +
                "type='" + type + '\'' +
                ", size=" + size +
                '}';
    }
}
