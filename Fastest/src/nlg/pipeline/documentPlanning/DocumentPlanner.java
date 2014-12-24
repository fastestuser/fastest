package nlg.pipeline.documentPlanning;

import java.util.ArrayList;
import java.util.List;

import nlg.base.designation.TermDesignation;
import nlg.base.documentPlan.DocumentPlan;
import nlg.base.documentPlan.ExpVerbalization;
import nlg.base.documentPlan.TClassDescriptionPlan;
import nlg.base.expr.ExprRef;
import nlg.base.expr.ExprZ;
import nlg.util.ExprZUtils;
import client.blogic.management.Controller;
import common.z.TClass;


/**
 * Modulo encarcagado de la etapa de "Document Planning"
 */
public class DocumentPlanner {

	private Controller controller;
	
	public DocumentPlanner(Controller controller) {
		this.controller = controller;
	}
	
	public DocumentPlan createDP(List<String> names) throws Exception {
		List<TClassDescriptionPlan> dpList = new ArrayList<TClassDescriptionPlan>();
		
		// Intento recuperar las clases de prueba indicadas
		SchFinder schFinder = new SchFinder(controller);
		List<TClass> tClasses = schFinder.getTClasses(names);
		
		// Proceso expresiones antes de generar los mensajes
		ExprRefiner expRefiner = new ExprRefiner();
		for (TClass tClass : tClasses) {
			
			// Intento convertir las expresiones a ExprZ
			List<ExprZ> exprList = parse(tClass);
			
			// Proceso las expresiones
			List<ExpVerbalization> expVerbList = new ArrayList<ExpVerbalization>();
			for (ExprZ expr : exprList) {
				ExprZ newExpr = expRefiner.refine(expr);
				
				if (null != newExpr) {
					expVerbList.add(new ExpVerbalization(newExpr));
				}
			}
			
			String name = tClass.getSchName();
			// Recupero nombre de la operacion a testear
			String testedSch = schFinder.getTestedOperation(name);
			// Intento recuperar designacion de la operacion
			TermDesignation td = 
					controller.getDesigRepo().getTermDesignation(new ExprRef(testedSch), null);
			String intro = null;
			if (null != td) {
				intro = td.getText();
			}
			
			// 
			dpList.add(new TClassDescriptionPlan(name, intro, expVerbList));
			
		}
		
		return new DocumentPlan("titulo", dpList);
	}

	/**
	 * Convierte y re-estructura expresiones czt 
	 * soportadas por el sistema de NLG
	 * @throws Exception Tira una exception si no se pudo parsear alguna expresion
	 */
	private List<ExprZ> parse(TClass tClass) throws Exception {
		return ExprZUtils.extractSchemaExpr(tClass);
	}
}