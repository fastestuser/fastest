package compserver.management;

import net.sourceforge.czt.z.ast.Spec;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * The instance of this class (which is a singleton) contains all the specifications that were
 * sent to the server
 */
public class SpecsReceived {

    private static SpecsReceived specsReceived;
    private final Collection<Spec> repository;

    /**
     * Creates intances of SpecsReceived.
     */
    private SpecsReceived() {
        repository = new ArrayList<>();
    }

    /**
     * Gets the instance of this class, creating it if necessary.
     *
     * @return
     */
    public static SpecsReceived getInstance() {
        if (specsReceived == null)
            specsReceived = new SpecsReceived();
        return specsReceived;
    }

    /**
     * Creates an iterator in order to be possible the traversal along this
     * structure.
     *
     * @return
     */
    public Iterator<Spec> iterator() {
        return repository.iterator();
    }

    /**
     * Add a new instance of Spec to this object.
     *
     * @param spec
     */
    public boolean add(Spec spec) {
        return repository.add(spec);
    }
}