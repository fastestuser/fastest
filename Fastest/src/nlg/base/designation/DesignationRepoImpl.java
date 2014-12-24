package nlg.base.designation;

import java.util.HashMap;
import java.util.Map;

import nlg.base.expr.ExprRef;


public class DesignationRepoImpl implements DesignationRepo {

	// Map: nombre esquema -> termino -> TermDesignation
	private Map<String, Map<ExprRef, TermDesignation>> mapTermDesignations = 
			new HashMap<String, Map<ExprRef,TermDesignation>>();
	
	@Override
	public void addDesignation(TermDesignation desig) {
		if (!mapTermDesignations.containsKey(desig.getSchName())) {
			mapTermDesignations.put(desig.getSchName(), new HashMap<ExprRef, TermDesignation>());
		}
		
		mapTermDesignations.get(desig.getSchName()).put(desig.getExpr(), desig);
	}

	@Override
	public void addDesignation(ParamDesignation desig) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TermDesignation getTermDesignation(ExprRef name, String schName) {
		if (mapTermDesignations.containsKey(schName)) {
			return mapTermDesignations.get(schName).get(name);
		} else {
			return null;
		}
	}

	/*
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

	@Override
	public SimpleDesignation getSimpleDesignation(ExprZ exp, String schName) {
		if (designations.containsKey(schName) &&
				designations.get(schName).containsKey(exp)) {
			TermDesignation td = designations.get(schName).get(exp);
			
			if (td instanceof SimpleDesignation) {
				return (SimpleDesignation) td;
			} else {
				return null;
			}
		} else {
			return null;
		}
	}
 */
}
