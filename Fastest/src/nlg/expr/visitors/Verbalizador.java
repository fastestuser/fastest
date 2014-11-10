package nlg.expr.visitors;

import nlg.designation.DesignationRepo;
import nlg.designation.DesignationUtils;
import nlg.expr.base.ExprApply;
import nlg.expr.base.ExprDom;
import nlg.expr.base.ExprEq;
import nlg.expr.base.ExprIn;
import nlg.expr.base.ExprIntersection;
import nlg.expr.base.ExprMapsTo;
import nlg.expr.base.ExprName;
import nlg.expr.base.ExprNotEq;
import nlg.expr.base.ExprNotIn;
import nlg.expr.base.ExprNot;
import nlg.expr.base.ExprRan;
import nlg.expr.base.ExprSet;
import nlg.expr.base.ExprSubSetEq;
import nlg.expr.base.ExprSubSet;
import nlg.expr.base.ExprUnion;


public class Verbalizador implements ExprZVisitor<String> {

	private DesignationRepo desigRepo;
	
	public Verbalizador(DesignationRepo desigRepo) {
		this.desigRepo = desigRepo;
	}
	
	@Override
	public String visitExprApply(ExprApply expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitExprDom(ExprDom expr) {
		
		return null;
	}

	@Override
	public String visitExprEq(ExprEq expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitExprIn(ExprIn expr) {

		return null;
	}

	@Override
	public String visitExprIntersection(ExprIntersection expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitExprMapsTo(ExprMapsTo expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitExprName(ExprName expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitExprNotEq(ExprNotEq expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitExprNotIn(ExprNotIn expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitExprRan(ExprRan expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitExprSet(ExprSet expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitExprSubSetEq(ExprSubSetEq expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitExprSubSet(ExprSubSet expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitExprUnion(ExprUnion expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitNot(ExprNot expr) {
		// TODO Auto-generated method stub
		return null;
	}
}