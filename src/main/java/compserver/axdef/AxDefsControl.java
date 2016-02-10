package compserver.axdef;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import compserver.prunning.Theorem;

/**
 * The instance of this class (which is a singleton) contains a number of
 * instances of Theorem, representing axiomatic definitions that uses forall
 */
public final class AxDefsControl {
    
    private static AxDefsControl axDefsControl;
    private final Collection<Theorem> repository;
    private int maxCard;
    
    /**
     * Creates intances of AxDefsControl.
     */
	private AxDefsControl(){
		repository = new ArrayList<Theorem>();
	}

    /**
     * Gets the instance of this class, creating it if necessary.
     * @return
     */
	public static AxDefsControl getInstance(){	
		if(axDefsControl==null)
			axDefsControl = new AxDefsControl();
		return axDefsControl;
	}
    
    /**
     * Creates an iterator in order to be possible the traversal along this
     * structure.
     * @return
     */
	public Iterator<Theorem> iterator(){
		return repository.iterator();
	}
    
    /**
     * Add a new instance of Theorem to this object.
	 * @param theorem
	 */
	public boolean add(Theorem theorem){
		return repository.add(theorem);
	}

	public void setMaxCardinality(int maxCard){
		this.maxCard = maxCard;
	}

	public int getMaxCardinality(){
		return maxCard;
	}

}