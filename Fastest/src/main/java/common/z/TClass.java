package common.z;

import java.util.List;

import net.sourceforge.czt.z.ast.AxPara;
import net.sourceforge.czt.z.ast.PreExpr;

/**
 * Interface that represents a test class.
 * @author Pablo Rodriguez Monetti
 */
public interface TClass extends Scheme{

	public void setSchName(String name);
	public String getSchName();
	public AxPara clone();
	public List<PreExpr> getInclPreds();
	public void setInclPreds(List<PreExpr> preds);
}


