package nlg.expr.visitors;

import nlg.designation.DesignationRepo;
import nlg.designation.DesignationUtils;
import nlg.expr.base.ExprApplyPlan;
import nlg.expr.base.ExprDomPlan;
import nlg.expr.base.ExprEqPlan;
import nlg.expr.base.ExprInPlan;
import nlg.expr.base.ExprIntersectionPlan;
import nlg.expr.base.ExprMapsToPlan;
import nlg.expr.base.ExprNamePlan;
import nlg.expr.base.ExprNotEqPlan;
import nlg.expr.base.ExprNotInPlan;
import nlg.expr.base.ExprNotPlan;
import nlg.expr.base.ExprRanPlan;
import nlg.expr.base.ExprSetPlan;
import nlg.expr.base.ExprSubSetEqPlan;
import nlg.expr.base.ExprSubSetPlan;
import nlg.expr.base.ExprUnionPlan;


public class Verbalizador implements ExprDescPlanVisitor<String> {

	private DesignationRepo desigRepo;
	
	public Verbalizador(DesignationRepo desigRepo) {
		this.desigRepo = desigRepo;
	}
	
	@Override
	public String visitExprApply(ExprApplyPlan expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitExprDom(ExprDomPlan expr) {
		
		return null;
	}

	@Override
	public String visitExprEq(ExprEqPlan expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitExprIn(ExprInPlan expr) {

		return null;
	}

	@Override
	public String visitExprIntersection(ExprIntersectionPlan expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitExprMapsTo(ExprMapsToPlan expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitExprName(ExprNamePlan expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitExprNotEq(ExprNotEqPlan expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitExprNotIn(ExprNotInPlan expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitExprRan(ExprRanPlan expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitExprSet(ExprSetPlan expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitExprSubSetEq(ExprSubSetEqPlan expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitExprSubSet(ExprSubSetPlan expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitExprUnion(ExprUnionPlan expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitNot(ExprNotPlan expr) {
		// TODO Auto-generated method stub
		return null;
	}
}