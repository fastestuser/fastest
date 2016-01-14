package client.blogic.testing.atcal;

import client.blogic.management.ii.IIComponent;
import client.blogic.management.ii.events.Event_;
import client.blogic.management.ii.events.TCaseRefineRequested;
import common.z.AbstractTCase;

/**
 * Created by Cristian on 13/07/15.
 */
public class TCaseRefineClient extends IIComponent {

    public synchronized void manageEvent(Event_ event_) throws IllegalArgumentException {

        if (event_ instanceof TCaseRefineRequested) {
            TCaseRefineRequested tCaseRefineRequested = (TCaseRefineRequested) event_;
            String opName = tCaseRefineRequested.getOpName();
            AbstractTCase absTCase = tCaseRefineRequested.getAbstractTCase();
            String targetLanguage = tCaseRefineRequested.getTargetLanguage();
            RefinementRule refinementRule = tCaseRefineRequested.getRefinementRule();
            (new Thread(new TCaseRefineClientRunner(opName, absTCase, targetLanguage, refinementRule))).start();
        } else {
            throw new IllegalArgumentException();
        }
    }
}
