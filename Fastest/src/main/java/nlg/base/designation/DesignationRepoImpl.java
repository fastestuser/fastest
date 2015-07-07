package nlg.base.designation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import nlg.base.expression.ExprZ;


public class DesignationRepoImpl implements DesignationRepo {

	// map: nombre esquema -> termino -> TermDesignation
	private Map<String, Map<ExprZ, TermDesignation>> termDesigMap = new HashMap<String, Map<ExprZ,TermDesignation>>();
	// map: nombre esquema -> ParamDesignation
	private Map<String, List<ParamDesignation>> paramDesigMap = new HashMap<String, List<ParamDesignation>>();
		
	@Override
	public void addDesignation(TermDesignation desig) {
		if (!termDesigMap.containsKey(desig.getSchName())) {
			termDesigMap.put(desig.getSchName(), new HashMap<ExprZ, TermDesignation>());
		}
		
		termDesigMap.get(desig.getSchName()).put(desig.getExpr(), desig);
	}

	@Override
	public void addDesignation(ParamDesignation desig) {
		if (!paramDesigMap.containsKey(desig.getSchName())) {
			paramDesigMap.put(desig.getSchName(), new ArrayList<ParamDesignation>());
		}
		
		paramDesigMap.get(desig.getSchName()).add(desig);
	}
	
	@Override
	public TermDesignation getTermDesignation(ExprZ expr, String schName) {
		if (termDesigMap.containsKey(schName)) {
			return termDesigMap.get(schName).get(expr);
		} else {
			return null;
		}
	}

	@Override
	public List<ParamDesignation> getAllParamDesignation(String schName) {
		if (paramDesigMap.containsKey(schName)) {
			return paramDesigMap.get(schName);
		} else {
			return new ArrayList<ParamDesignation>();
		}
	}
	
	/*
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
	}*/

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
