package common.z;

import java.util.List;


/**
 * Interface that represents an abstract test case.
 * @author Pablo Rodriguez Monetti
 */
public interface AbstractTCase extends TClass{
	public void setInclsNotIntegrated(List<String> incls);
	public String getInclsNotIntegrated();
}


