package client.blogic.testing.atcal;

import client.blogic.testing.refinement.ConcreteTCase;
import common.z.AbstractTCase;

/**
 * Created by Cristian on 13/07/15.
 */
public class TCaseRefineClientRunner implements Runnable {

    private final String opName;
    private final AbstractTCase abstractTCase;
    private final String targetLanguage;

    public TCaseRefineClientRunner(String opName, AbstractTCase abstractTCase, String targetLanguage) {
        this.opName = opName;
        this.abstractTCase = abstractTCase;
        this.targetLanguage = targetLanguage;
    }

    @Override
    public void run() {
        System.out.println("I am refining operation " + opName);
    }
}
