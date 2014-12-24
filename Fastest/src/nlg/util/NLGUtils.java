package nlg.util;

import java.util.List;

import nlg.base.documentPlan.DocumentPlan;
import nlg.base.documentPlan.ExpVerbalization;
import nlg.base.documentPlan.TClassDescriptionPlan;

public class NLGUtils {
	
	/**
	 * Formatea un DocumentPlan (usado para debug)
	 */
	public static String documentPlanToString(DocumentPlan nlgDP) {
		String ret = "DocumentPlan";
		
		ExprZToString visitor = new ExprZToString();
		List<TClassDescriptionPlan> desc = nlgDP.gettClassDescPlanList();
		
		ret += "\n  + titulo: " + nlgDP.getTitle() + "\n";
		
		for (TClassDescriptionPlan descPlan : desc) {
			ret += "  |_ TClassDescriptionPlan\n";
			ret += "       + nombre: " + descPlan.getName() + "\n";
			ret += "       + intro: " + descPlan.getIntroduction() + "\n";
			
			ret += "       + ExpVerbalization:\n";
			
			List<ExpVerbalization> exprList = descPlan.getExpressions();
			
			for (ExpVerbalization edp : exprList) {
				ret += "           *" + insetTabs(edp.getExpr().accept(visitor)) + "\n";
			}
			
			ret += "\n";
		}
		
		return ret;
	}
	
	private static String insetTabs(String string) {
		return string.replaceAll("\\|", "           |");
	}
}
