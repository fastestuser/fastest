package org.fastest.atcal.apl;

/**
 * Created by Cristian on 4/20/15.
 */
public class DeclStmt implements APLStmt {

    private final String type;
    private final String name;
    private final String size;

    public DeclStmt(String type, String name, String size) {
        this.type = type;
        this.name = name;
        this.size = size;
    }

    @Override
    public String toString() {
        return type + " " + name + '[' + size + ']';
    }
}
