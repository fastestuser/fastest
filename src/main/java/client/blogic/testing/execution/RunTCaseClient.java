package client.blogic.testing.execution;

import client.blogic.management.ii.IIComponent;
import client.blogic.management.ii.events.Event_;
import client.blogic.management.ii.events.RunCTCRequested;
import client.blogic.testing.atcal.ConcreteTCase;


/**
 * Instances of this class (although we assume there is only one in the system)
 * manages the requests for execute concrete test cases . These requests are
 * done in each event of type RunCTCRequested that is announced in the system and
 * each of them are processed in a different thread (to favour performance
 * issues), running the method run() of RunTCaseClientRunner in each new thread.
 */
public class RunTCaseClient extends IIComponent {

    /**
     * Manages an implicit invocation event.
     *
     * @param event_ the event to manage
     * @throws java.lang.IllegalArgumentException if event_ is not instance of RunCTCRequested
     */
    public synchronized void manageEvent(Event_ event_) throws IllegalArgumentException {
        if (event_ instanceof RunCTCRequested) {
            RunCTCRequested runRequest = (RunCTCRequested) event_;
            ConcreteTCase concreteTCase = runRequest.getConcreteTCase();
            String workingDirectory = runRequest.getWorkingDirectory();
            (new Thread(new RunTCaseClientRunner(concreteTCase, workingDirectory))).start();
        } else
            throw new IllegalArgumentException();
    }
}

