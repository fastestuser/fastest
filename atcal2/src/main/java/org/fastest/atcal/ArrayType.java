package org.fastest.atcal;

/**
 * Created by Cristian on 29/04/15.
 */
public class ArrayType implements ATCALType {

    private final String name;
    private final int size;

    public ArrayType(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "ArrayType{" +
                "name='" + name + '\'' +
                ", size=" + size +
                '}';
    }
}
