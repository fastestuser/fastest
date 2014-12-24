package pruebas.nlg;

import java.io.IOException;

import nlg.base.designation.DesignationUtils;
import nlg.base.designation.ParamDesignation;
import nlg.base.expr.ExprDom;
import nlg.base.expr.ExprRan;
import nlg.base.expr.ExprRef;
import nlg.base.expr.ExprUnion;
import nlg.base.expr.ExprZ;
import nlg.util.ExprZToString;

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
