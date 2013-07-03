package compserver.axdef;

import common.repository.AbstractRepository;
import common.repository.ConcreteRepository;
import common.repository.AbstractIterator;
import compserver.prunning.Theorem;


/**
 * The instance of this class (which is a singleton) contains a number of
 * instances of Theorem, representing synonyms of axiomatic definitions
 */
public class SynonymsControl implements AbstractRepository<Theorem>{
    
    private static SynonymsControl theoremsControl;
    private AbstractRepository<Theorem> repository;
    private int maxCard;
    
    
    
    /**
     * Creates intances of TheoremsControl.
     */
	private SynonymsControl(){
		repository = new ConcreteRepository<Theorem>();
	}

    /**
     * Gets the instance of this class, creating it if necessary.
     * @return
     */
	public static SynonymsControl getInstance(){	
		if(theoremsControl==null)
			theoremsControl = new SynonymsControl();
		return theoremsControl;
	}

    
    
    /**
     * Creates an iterator in order to be possible the traversal along this
     * structure.
     * @return
     */
	public AbstractIterator<Theorem> createIterator(){
		return repository.createIterator();
	}

    
    
    /**
     * Add a new instance of Theorem to this object.
     * @param theorem
     */
	public void addElement(Theorem theorem){
		repository.addElement(theorem);
	}

	public void setMaxCardinality(int maxCard){
		this.maxCard = maxCard;
	}

	public int getMaxCardinality(){
		return maxCard;
	}

}