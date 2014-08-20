package pruebas.nlg;

import java.io.IOException;

import nlg.designation.DesignationUtils;
import nlg.designation.ParamDesignation;
import nlg.expr.base.ExprDescPlan;
import nlg.expr.base.ExprDomPlan;
import nlg.expr.base.ExprNamePlan;
import nlg.expr.base.ExprRanPlan;
import nlg.expr.base.ExprUnionPlan;
import nlg.expr.visitors.ExprDescPlanToString;

public class BarTest {
	
	public static void main(String args[])throws IOException {
		
		
		ExprDescPlan exprInst = new ExprUnionPlan(
				new ExprDomPlan(new ExprNamePlan("procs")), 
				new ExprRanPlan(new ExprNamePlan("asd")));
		ExprDescPlan exprDesg = new ExprUnionPlan(
				new ExprDomPlan(new ExprNamePlan("procs")), 
				new ExprNamePlan("x"));
		ParamDesignation paramDesig = new ParamDesignation(exprDesg, null, "x", null);
		
		ExprDescPlan ret = DesignationUtils.extractArgument(exprInst, paramDesig);
		
		System.out.println(ret.accept(new ExprDescPlanToString()));
	}
	
	
}
