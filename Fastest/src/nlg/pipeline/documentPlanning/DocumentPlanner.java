package nlg.pipeline.documentPlanning;

import java.util.ArrayList;
import java.util.List;

import nlg.base.documentPlan.DocumentPlan;
import nlg.base.documentPlan.TClassDescriptionPlan;
import nlg.expr.base.ExprZ;
import nlg.util.ExprDescUtils;
import client.blogic.management.Controller;

import common.z.TClass;

/**
 * TODO
 *
 */
public class DocumentPlanner {

	private Controller controller;
	
	public DocumentPlan plan(List<TClass> tClasses, Controller controller) {
		this.controller = controller;
		List<TClassDescriptionPlan> tClassDescPlanList = 
				new ArrayList<TClassDescriptionPlan>();
		
		// Genero un TClassDescription plan por cada clase
		for (TClass tClass : tClasses) {
			tClassDescPlanList.add(parseAndStructure(tClass));
		}
		
		DocumentPlan dp = new DocumentPlan("", tClassDescPlanList);
		
		return dp;
	}

	/**
	 * Convierte y re-estructura expresiones czt 
	 * soportadas por el sistema de NLG
	 */
	private TClassDescriptionPlan parseAndStructure(TClass tClass) {
		// TODO
		List<ExprZ> exprList = ExprDescUtils.extractSchemaExpr(tClass);
		//return new TClassDescriptionPlan(tClass, exprList);
		return null;
	}
}