package pruebas.nlg;

import java.io.IOException;

import nlg.designation.DesignationUtils;
import nlg.designation.ParamDesignation;
import nlg.expr.base.ExprZ;
import nlg.expr.base.ExprDom;
import nlg.expr.base.ExprName;
import nlg.expr.base.ExprRan;
import nlg.expr.base.ExprUnion;
import nlg.expr.visitors.ExprDescPlanToString;

public class BarTest {
	
	public static void main(String args[])throws IOException {
		
		
		ExprZ exprInst = new ExprUnion(
				new ExprDom(new ExprName("procs")), 
				new ExprRan(new ExprName("asd")));
		ExprZ exprDesg = new ExprUnion(
				new ExprDom(new ExprName("procs")), 
				new ExprName("x"));
		ParamDesignation paramDesig = new ParamDesignation(exprDesg, null, "x", null);
		
		ExprZ ret = DesignationUtils.extractArgument(exprInst, paramDesig);
		
		System.out.println(ret.accept(new ExprDescPlanToString()));
	}
	
	
}
