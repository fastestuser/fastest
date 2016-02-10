/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package client.blogic.testing.ttree.tactics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Collection;

/**
 * The instance of this class (which is a singleton) contains a number of
 * instances of StdPartition.
 * @author Pablo Rodriguez Monetti
 */
public class StdPartitionsControl {

    private static StdPartitionsControl stdPartitionsControl;
    private final Collection<StdPartition> repository;

    /**
     * Creates intances of StdPartitionsControl.
     */
    private StdPartitionsControl() {
        repository = new ArrayList<StdPartition>();
    }

    /**
     * Gets the instance of this class, creating it if necessary.
     * @return
     */
    public static StdPartitionsControl getInstance() {
        if (stdPartitionsControl == null) {
            stdPartitionsControl = new StdPartitionsControl();
        }
        return stdPartitionsControl;
    }

    /**
     * Creates an iterator in order to be possible the traversal along this
     * structure.
     * @return
     */
    public Iterator<StdPartition> iterator() {
        return repository.iterator();
    }

    /**
     * Add a new instance of StdPartition to this object.
     * @param stdPartition
     */
    public boolean add(StdPartition stdPartition) {
        return repository.add(stdPartition);
    }
}
