package pruebas.nlg;

import java.io.IOException;

import nlg.designation.DesignationUtils;
import nlg.designation.ParamDesignation;
import nlg.expr.base.ExprZ;
import nlg.expr.base.ExprDom;
import nlg.expr.base.ExprRef;
import nlg.expr.base.ExprRan;
import nlg.expr.base.ExprUnion;
import nlg.expr.visitors.ExprZToString;

public class BarTest {
	
	public static void main(String args[])throws IOException {
		
		
		ExprZ exprInst = new ExprUnion(
				new ExprDom(new ExprRef("procs")), 
				new ExprRan(new ExprRef("asd")));
		ExprZ exprDesg = new ExprUnion(
				new ExprDom(new ExprRef("procs")), 
				new ExprRef("x"));
		ParamDesignation paramDesig = new ParamDesignation(exprDesg, null, new ExprRef("x"), null);
		
		ExprZ ret = DesignationUtils.extractArgument(exprInst, paramDesig);
		
		System.out.println(ret.accept(new ExprZToString()));
	}
	
	
}
