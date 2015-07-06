package org.fastest.atcal.generators;

import org.fastest.atcal.apl.APLStmt;

/**
 * Created by cristian on 06/07/15.
 */
public class BaseGen implements Generator {

    public String generate(APLStmt aplStmt) {
        return aplStmt.toString();
    }

}
