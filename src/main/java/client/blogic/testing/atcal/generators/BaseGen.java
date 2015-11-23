package client.blogic.testing.atcal.generators;

import client.blogic.testing.atcal.apl.APLLValue;
import client.blogic.testing.atcal.apl.APLStmt;

import java.util.Collection;

/**
 * Created by cristian on 06/07/15.
 */
public class BaseGen implements Generator {
    @Override
    public String getTargetLanguage() {
        return "debug";
    }

    public String generate(APLStmt aplStmt) {
        return aplStmt.toString();
    }

    @Override
    public String getDumpCode(Collection<APLLValue> lvaluesSet) {
        return "";
    }
}
