package client.blogic.management.ii.events;

import common.z.AbstractTCase;

/**
 * @author Hache
 */
public class TCaseRefineRequested extends Event_{
    private String opName;
    private AbstractTCase absTCase;
    private String targetLanguaje;
    private String pathUUT;

    public TCaseRefineRequested(String opName, AbstractTCase absTCase, String pathUUT, String targetLanguaje){
		this.opName = opName;
		this.absTCase = absTCase;
		this.targetLanguaje = targetLanguaje;
		this.pathUUT = pathUUT;
		super.setEventName("tCaseRefineRequested");
	}
    /**
     * Sets the name of the operation associated to this object.
     * @param opName
     */
	public void setOpName(String opName){
		this.opName = opName;
	}

    /**
     * Gets the name of the operation associated to this object.
     * @return
     */
	public String getOpName(){
		return opName;
	}


	public void setAbstractTCase(AbstractTCase absTCase){
		this.absTCase = absTCase;
	}

	public AbstractTCase getAbstractTCase(){
		return absTCase;
	}

	public String getTargetLanguaje(){
		return targetLanguaje;
	}
	
	public String getPathUUT(){
		return pathUUT;
	}
	
}
