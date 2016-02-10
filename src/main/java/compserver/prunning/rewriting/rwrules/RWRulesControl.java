package compserver.prunning.rewriting.rwrules;

import java.util.Collection;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * The instance of this class (which is a singleton) contains a number of
 * instances of objetcs that implements the interface RWRule.
 */
public class RWRulesControl {
    
    private static RWRulesControl rwRulesControl;
    private final Collection<RWRule> repository;
    
    /**
     * Creates intances of RWRulesControl and load the rules
     */
	private RWRulesControl(){
		repository = new ArrayList<RWRule>();
		RWRule rwEquality = new RWEquality();
		RWRule rwGreaterThanEqual = new RWGreaterThanEqual();
		RWRule rwGreaterThan = new RWGreaterThan();
		RWRule rwIntersection = new RWIntersection();
		RWRule rwLessThanEqual = new RWLessThanEqual();
		RWRule rwLessThan = new	RWLessThan();
		RWRule rwNotEqual = new RWNotEqual();
		RWRule rwUnion = new RWUnion();
		repository.add(rwEquality);
		repository.add(rwGreaterThanEqual);
		repository.add(rwGreaterThan);
		repository.add(rwIntersection);
		repository.add(rwLessThanEqual);
		repository.add(rwLessThan);
		repository.add(rwNotEqual);
		repository.add(rwUnion);
	}

    /**
     * Gets the instance of this class, creating it if necessary.
     * @return
     */
	public static RWRulesControl getInstance(){	
		if(rwRulesControl==null)
			rwRulesControl = new RWRulesControl();

		return rwRulesControl;
	}

    /**
     * Creates an iterator in order to be possible the traversal along this
     * structure.
     * @return
     */
	public Iterator<RWRule> iterator(){
		return repository.iterator();
	}

    /**
     * Add a new instance of a rewrite rule.
	 * @param rwRule
	 */
	public boolean add(RWRule rwRule){
		return repository.add(rwRule);
	}
}