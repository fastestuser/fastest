package client.blogic.testing.atcal.generators;

import client.blogic.testing.atcal.apl.APLLValue;
import client.blogic.testing.atcal.apl.APLStmt;

import java.util.Collection;

/**
 * Created by Cristian on 01/07/15.
 */
public interface Generator {
    String getTargetLanguage();

    String generate(APLStmt aplStmt);

    String getDumpCode(Collection<APLLValue> lvaluesSet);
}
