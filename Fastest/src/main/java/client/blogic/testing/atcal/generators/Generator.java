package client.blogic.testing.atcal.generators;

import client.blogic.testing.atcal.apl.APLStmt;

/**
 * Created by Cristian on 01/07/15.
 */
public interface Generator {
    String getTargetLanguage();
    String generate(APLStmt aplStmt);
}
