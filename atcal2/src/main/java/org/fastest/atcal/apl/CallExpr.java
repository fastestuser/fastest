package org.fastest.atcal.apl;

import com.sun.deploy.util.StringUtils;

import java.util.List;

/**
 * Created by Cristian on 4/20/15.
 */
public class CallExpr implements APLExpr, APLStmt {

    private final String funName;
    private final List<String> args;

    public CallExpr(String funName, List<String> args) {
        this.funName = funName;
        this.args = args;
    }

    @Override
    public String toString() {
        return funName + "(" + StringUtils.join(args, ",") + ")";
    }
}
