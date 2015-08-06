package common.z;

import net.sourceforge.czt.z.ast.Expr;
import net.sourceforge.czt.z.ast.RefExpr;

import java.util.List;
import java.util.Map;


/**
 * Interface that represents an abstract test case.
 * @author Pablo Rodriguez Monetti
 */
public interface AbstractTCase extends TClass{
	public void setInclsNotIntegrated(List<String> incls);
	public String getInclsNotIntegrated();
	public Map<RefExpr, Expr> getVarExpMap();
}


