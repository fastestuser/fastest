package nlg.designation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import nlg.expr.base.ExprDescPlan;


public class DesignationRepoImpl implements DesignationRepo {

	// Map:: nombre_esquema -> expr -> designacion
	public Map<String, Map<ExprDescPlan, TermDesignation>> designations = 
			new HashMap<String, Map<ExprDescPlan, TermDesignation>>();
	
	@Override
	public void addDesignation(TermDesignation desig) {
		if (!designations.containsKey(desig.getSchName())) {
			Map<ExprDescPlan, TermDesignation> temp = new HashMap<ExprDescPlan, TermDesignation>();
			temp.put(desig.getExpr(), desig);
			designations.put(desig.getSchName(), temp);
		} else if (!designations.get(desig.getSchName()).containsKey(desig.getExpr())) {
			designations.get(desig.getSchName()).put(desig.getExpr(), desig);
		}
	}
	
	@Override
	public void addAllDesignations(List<TermDesignation> desigs) {
		for (TermDesignation td : desigs) {
			addDesignation(td);
		}
	}

	@Override
	public TermDesignation getDesignation(ExprDescPlan exp, String schName) {
		if (designations.containsKey(schName) &&
				designations.get(schName).containsKey(exp)) {
			return designations.get(schName).get(exp);
		} else {
			return null;
		}
	}

}
