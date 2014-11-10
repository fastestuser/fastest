package nlg.designation;

import nlg.expr.base.ExprZ;

public class ParamDesignation extends TermDesignation {
	private String param;
	private DesignationFunction desigFun;
	
	public ParamDesignation(ExprZ expr, String schName, String param, DesignationFunction desigFun) {
		this.param = param;
		this.desigFun = desigFun;
		this.expr = expr;
		this.schName = schName;
	}
	
	public String getParam() {
		return param;
	}
	public void setParam(String param) {
		this.param = param;
	}
	public DesignationFunction getDesigFun() {
		return desigFun;
	}
	public void setDesigFun(DesignationFunction desigFun) {
		this.desigFun = desigFun;
	}
}
