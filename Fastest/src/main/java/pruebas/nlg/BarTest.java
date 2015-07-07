package pruebas.nlg;

import java.io.IOException;

import nlg.base.designation.DesignationUtils;
import nlg.base.designation.ParamDesignation;
import nlg.base.expression.ExprDom;
import nlg.base.expression.ExprRan;
import nlg.base.expression.ExprRef;
import nlg.base.expression.ExprUnion;
import nlg.base.expression.ExprZ;
import nlg.util.ExprZTreeToString;

public class BarTest {
	
	public static void main(String args[])throws IOException {
		
		
		ExprZ exprInst = new ExprUnion(
				new ExprDom(new ExprRef("procs")), 
				new ExprRan(new ExprRef("asd")));
		ExprZ exprDesg = new ExprUnion(
				new ExprDom(new ExprRef("procs")), 
				new ExprRef("x"));
		ParamDesignation paramDesig = new ParamDesignation(exprDesg, null, new ExprRef("x"), null);
		
		//ExprZ ret = DesignationUtils.extractArgument(exprInst, paramDesig);
		
		//System.out.println(ret.accept(new ExprZToString()));
	}
	
	
}
