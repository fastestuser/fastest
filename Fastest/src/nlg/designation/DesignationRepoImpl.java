package nlg.designation;

import java.util.ArrayList;
import java.util.List;

import nlg.expr.base.ExprZ;


public class DesignationRepoImpl implements DesignationRepo {

	// TODO CAMBIAR ESTO!!!!
	public List<TermDesignation> designations = new ArrayList<TermDesignation>();
	
	@Override
	public void addDesignation(TermDesignation desig) {
		designations.add(desig);
	}
	
	@Override
	public void addAllDesignations(List<TermDesignation> desigs) {
		designations.addAll(desigs);
	}

	@Override
	public TermDesignation getDesignation(ExprZ exp, String schName) {
		// TODO Auto-generated method stub
		return null;
	}

}
