package compserver.abstraction.capture;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;


/**
 * The instance of this class (which is a singleton) contains a number of
 * instances of CapturedVar.
 */
public class CapturedVarsControl {
    
    private static CapturedVarsControl capturedVarsControl;
    private final Collection<CapturedVar> repository;
    

    /**
     * Creates intances of CapturedVarsControl.
     */
	private CapturedVarsControl(){
		repository = new ArrayList<CapturedVar>();
	}

    /**
     * Gets the instance of this class, creating it if necessary.
     * @return
     */
	public static CapturedVarsControl getInstance(){	
		if(capturedVarsControl==null)
			capturedVarsControl = new CapturedVarsControl();
		return capturedVarsControl;
	}


    /**
     * Creates an iterator in order to be possible the traversal along this
     * structure.
     * @return
     */
	public Iterator<CapturedVar> iterator(){
		return repository.iterator();
	}

    
    
    /**
     * Add a new instance of CapturedVar to this object.
	 * @param theorem
	 */
	public boolean add(CapturedVar capturedVar){
		return repository.add(capturedVar);
	}

}