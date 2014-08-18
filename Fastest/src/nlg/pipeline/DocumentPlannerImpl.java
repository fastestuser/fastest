package nlg.pipeline;

import java.util.ArrayList;
import java.util.List;

import nlg.base.NLGDocumentPlan;
import nlg.base.TClassDescPlan;
import nlg.expr.base.ExprDescPlan;
import nlg.util.ExprDescPlanUtils;
import client.blogic.management.Controller;
import common.z.TClass;

public class DocumentPlannerImpl implements DocumentPlanner {

	private Controller controller;
	
	@Override
	public NLGDocumentPlan plan(List<TClass> tClasses, Controller controller) {
		this.controller = controller;
		List<TClassDescPlan> tClassDescPlanList = 
				new ArrayList<TClassDescPlan>();
		
		// Genero un TClassDescription plan por cada clase
		for (TClass tClass : tClasses) {
			tClassDescPlanList.add(parseAndStructure(tClass));
		}
		
		NLGDocumentPlan dp = new NLGDocumentPlan(tClassDescPlanList);
		
		return dp;
	}

	/**
	 * Convierte y re-estructura expresiones czt 
	 * soportadas por el sistema de NLG
	 */
	private TClassDescPlan parseAndStructure(TClass tClass) {
		List<ExprDescPlan> exprList = ExprDescPlanUtils.extractSchemaExpr(tClass);
		return new TClassDescPlan(tClass, exprList);
	}
}
