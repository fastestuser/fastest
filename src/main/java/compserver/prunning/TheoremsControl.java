package compserver.prunning;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;


/**
 * The instance of this class (which is a singleton) contains a number of
 * instances of Theorem.
 */
public class TheoremsControl {

    private static TheoremsControl theoremsControl;
    private final Collection<Theorem> repository;
    private int maxCard;

    /**
     * Creates intances of TheoremsControl.
     */
    private TheoremsControl() {
        repository = new ArrayList<Theorem>();
    }

    /**
     * Gets the instance of this class, creating it if necessary.
     *
     * @return
     */
    public static TheoremsControl getInstance() {
        if (theoremsControl == null)
            theoremsControl = new TheoremsControl();
        return theoremsControl;
    }


    /**
     * Creates an iterator in order to be possible the traversal along this
     * structure.
     *
     * @return
     */
    public Iterator<Theorem> iterator() {
        return repository.iterator();
    }


    /**
     * Add a new instance of Theorem to this object.
     *
     * @param theorem
     */
    public boolean add(Theorem theorem) {
        return repository.add(theorem);
    }

    public void setMaxCardinality(int maxCard) {
        this.maxCard = maxCard;
    }

    public int getMaxCardinality() {
        return maxCard;
    }

}