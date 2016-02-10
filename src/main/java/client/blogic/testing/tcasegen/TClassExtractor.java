package client.blogic.testing.tcasegen;

import client.blogic.management.ii.events.TCaseRequested;
import client.blogic.management.ii.events.AllTCasesRequested;
import client.blogic.management.ii.events.Event_;
import client.blogic.management.ii.EventAdmin;
import client.blogic.management.ii.IIComponent;
import client.blogic.testing.ttree.TClassNode;
import client.blogic.testing.ttree.visitors.TClassLeavesFinder;
import java.util.Collection;
import java.util.Iterator;
import common.z.TClass;

/**
 * Instances of this class (although we assume there is only one in the system)
 * have the responsibility of process events of type TTreeGenerated (those that
 * have as a parameter the test tree recently generated and the name of the 
 * associated operation), announcing an event of type TCaseRequested, for each 
 * test class the test tree has as a leaf.
 * @author Pablo Rodriguez Monetti
 */
public class TClassExtractor extends IIComponent {

    /**
     * Manages an implicit invocation event.
     * @param event_
     * @throws java.lang.IllegalArgumentException if event_ is not an instance
     * of AllTCasesRequested. 
     */
    public synchronized void manageEvent(Event_ event_)
            throws IllegalArgumentException {

        if (event_ instanceof AllTCasesRequested) {
            try {
                AllTCasesRequested allTCasesRequested = (AllTCasesRequested) event_;
                String opName = allTCasesRequested.getOpName();
                TClassNode tClassNode = allTCasesRequested.getTTree();
                int maxEval = allTCasesRequested.getMaxEval();

                // Extracts all the TCLassNodes that are leaves of the tClassNode test tree
                // except for those leaves that are descendants of pruned test classes.
                Collection<TClass> tClassLeaves = tClassNode.acceptVisitor(new TClassLeavesFinder());
                Iterator<TClass> tClassIt = tClassLeaves.iterator();
                EventAdmin eventAdmin = EventAdmin.getInstance();
                while (tClassIt.hasNext()) {
                    TClass tClass = tClassIt.next();
                    TCaseRequested tCaseRequested = new TCaseRequested(opName, tClass, maxEval);
                    eventAdmin.announceEvent(tCaseRequested);
                    System.out.println("se lanza tcase requested");
                }


            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            throw new IllegalArgumentException();
        }

    }
}
