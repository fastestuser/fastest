package nlg.designation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import nlg.expr.base.ExprZ;


public class DesignationRepoImpl implements DesignationRepo {

	// Map:: nombre_esquema -> expr -> designacion
	public Map<String, Map<ExprZ, TermDesignation>> designations = 
			new HashMap<String, Map<ExprZ, TermDesignation>>();
	
	@Override
	public void addDesignation(TermDesignation desig) {
		if (!designations.containsKey(desig.getSchName())) {
			Map<ExprZ, TermDesignation> temp = new HashMap<ExprZ, TermDesignation>();
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
	public TermDesignation getDesignation(ExprZ exp, String schName) {
		if (designations.containsKey(schName) &&
				designations.get(schName).containsKey(exp)) {
			return designations.get(schName).get(exp);
		} else {
			return null;
		}
	}

}
