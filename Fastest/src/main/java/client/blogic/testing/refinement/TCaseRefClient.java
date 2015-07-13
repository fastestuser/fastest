package client.blogic.testing.refinement;

import client.blogic.management.ii.IIComponent;
import client.blogic.management.ii.events.Event_;
import client.blogic.management.ii.events.TCaseRefineRequested;
import common.z.AbstractTCase;

public class TCaseRefClient extends IIComponent {

    public TCaseRefClient() {
    }

    public synchronized void manageEvent(Event_ event_)
            throws IllegalArgumentException {

        if (event_ instanceof TCaseRefineRequested) {
            TCaseRefineRequested tCaseRefineRequested = (TCaseRefineRequested) event_;
            String opName = tCaseRefineRequested.getOpName();
            AbstractTCase absTCase = tCaseRefineRequested.getAbstractTCase();
            String targetLanguaje = tCaseRefineRequested.getTargetLanguage();
            (new Thread(new TCaseRefClientRunner(opName, absTCase, targetLanguaje))).start();
        } else
            throw new IllegalArgumentException();
    }
}