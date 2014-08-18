package nlg.base;

import java.util.List;

import nlg.expr.base.ExprDescPlan;

import common.z.TClass;

/**
 * "plan" de descripcion para una clase de prueba. 
 *
 */
public class TClassDescPlan {
	private TClass tClass;
	private List<ExprDescPlan> exprDescList;
	
	public TClassDescPlan(TClass tClass, List<ExprDescPlan> exprDescList) {
		this.tClass = tClass;
		this.exprDescList = exprDescList;
	}
	
	public TClass gettClass() {
		return tClass;
	}
	
	public void settClass(TClass tClass) {
		this.tClass = tClass;
	}
	
	public List<ExprDescPlan> getExprDescList() {
		return exprDescList;
	}
	
	public void setExprDescList(List<ExprDescPlan> exprDescList) {
		this.exprDescList = exprDescList;
	}
}
