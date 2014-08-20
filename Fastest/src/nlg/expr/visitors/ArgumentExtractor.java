package nlg.expr.visitors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import nlg.expr.base.ExprApplyPlan;
import nlg.expr.base.ExprDescPlan;
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

public class ArgumentExtractor implements ExprDescPlanVisitor<List<ExprDescPlan>> {

	private ExprDescPlan exprInst; // Expresion ya instanciada
	private String paramName;
	
	public ArgumentExtractor(ExprDescPlan exprInst, String paramName) {
		this.exprInst = exprInst;
		this.paramName = paramName;
	}
	
	@Override
	public List<ExprDescPlan> visitExprApply(ExprApplyPlan expr) {
		List<ExprDescPlan> ret = null;
		
		if (exprInst instanceof ExprApplyPlan) {
			List<ExprDescPlan> ret1 =
				expr.getArgument().accept(new ArgumentExtractor(((ExprApplyPlan) exprInst).getArgument(), paramName));
			List<ExprDescPlan> ret2 =	
				expr.getFunction().accept(new ArgumentExtractor(((ExprApplyPlan) exprInst).getFunction(), paramName));
			
			if (null != ret1 && null != ret2) {
				ret = new ArrayList<ExprDescPlan>();
				ret.addAll(ret1);
				ret.addAll(ret2);
			}

		} 
		
		return ret;
	}
	
	@Override
	public List<ExprDescPlan> visitExprDom(ExprDomPlan expr) {
		List<ExprDescPlan> ret = null;
		
		if (exprInst instanceof ExprDomPlan) {
			List<ExprDescPlan> ret1 =
				expr.getFunction().accept(new ArgumentExtractor(((ExprDomPlan) exprInst).getFunction(), paramName));
			
			if (null != ret1) {
				ret = new ArrayList<ExprDescPlan>();
				ret.addAll(ret1);
			}

		} 
		
		return ret;
	}
	
	@Override
	public List<ExprDescPlan> visitExprEq(ExprEqPlan expr) {
		List<ExprDescPlan> ret = null;
		
		if (exprInst instanceof ExprEqPlan) {
			List<ExprDescPlan> ret1 =
				expr.getLeftExpr().accept(new ArgumentExtractor(((ExprEqPlan) exprInst).getLeftExpr(), paramName));
			List<ExprDescPlan> ret2 =	
				expr.getRightExpr().accept(new ArgumentExtractor(((ExprEqPlan) exprInst).getRightExpr(), paramName));
			
			if (null != ret1 && null != ret2) {
				ret = new ArrayList<ExprDescPlan>();
				ret.addAll(ret1);
				ret.addAll(ret2);
			}

		} 
		
		return ret;
	}
	
	@Override
	public List<ExprDescPlan> visitExprIn(ExprInPlan expr) {
		List<ExprDescPlan> ret = null;
		
		if (exprInst instanceof ExprInPlan) {
			List<ExprDescPlan> ret1 =
				expr.getElement().accept(new ArgumentExtractor(((ExprInPlan) exprInst).getElement(), paramName));
			List<ExprDescPlan> ret2 =	
				expr.getSet().accept(new ArgumentExtractor(((ExprInPlan) exprInst).getSet(), paramName));
			
			if (null != ret1 && null != ret2) {
				ret = new ArrayList<ExprDescPlan>();
				ret.addAll(ret1);
				ret.addAll(ret2);
			}

		} 
		
		return ret;
	}
	
	@Override
	public List<ExprDescPlan> visitExprIntersection(ExprIntersectionPlan expr) {
		List<ExprDescPlan> ret = null;
		
		if (exprInst instanceof ExprIntersectionPlan) {
			List<ExprDescPlan> ret1 =
				expr.getLeftSet().accept(new ArgumentExtractor(((ExprIntersectionPlan) exprInst).getLeftSet(), paramName));
			List<ExprDescPlan> ret2 =	
				expr.getRightSet().accept(new ArgumentExtractor(((ExprIntersectionPlan) exprInst).getRightSet(), paramName));
			
			if (null != ret1 && null != ret2) {
				ret = new ArrayList<ExprDescPlan>();
				ret.addAll(ret1);
				ret.addAll(ret2);
			}

		} 
		
		return ret;
	}
	
	@Override
	public List<ExprDescPlan> visitExprMapsTo(ExprMapsToPlan expr) {
		List<ExprDescPlan> ret = null;
		
		if (exprInst instanceof ExprMapsToPlan) {
			List<ExprDescPlan> ret1 =
				expr.getLeft().accept(new ArgumentExtractor(((ExprMapsToPlan) exprInst).getLeft(), paramName));
			List<ExprDescPlan> ret2 =	
				expr.getRight().accept(new ArgumentExtractor(((ExprMapsToPlan) exprInst).getRight(), paramName));
			
			if (null != ret1 && null != ret2) {
				ret = new ArrayList<ExprDescPlan>();
				ret.addAll(ret1);
				ret.addAll(ret2);
			}

		} 
		
		return ret;
	}
	
	@Override
	public List<ExprDescPlan> visitExprName(ExprNamePlan expr) {
		List<ExprDescPlan> ret = null;
		
		if (expr.getName().equals(paramName)) {
			ret = Arrays.asList(exprInst);
		} else if (expr.equals(exprInst)) {
			ret = new ArrayList<ExprDescPlan>();
		}
		
		return ret;
	}
	
	@Override
	public List<ExprDescPlan> visitExprNotEq(ExprNotEqPlan expr) {
		List<ExprDescPlan> ret = null;
		
		if (exprInst instanceof ExprNotEqPlan) {
			List<ExprDescPlan> ret1 =
				expr.getLeftExpr().accept(new ArgumentExtractor(((ExprNotEqPlan) exprInst).getLeftExpr(), paramName));
			List<ExprDescPlan> ret2 =	
				expr.getRightExpr().accept(new ArgumentExtractor(((ExprNotEqPlan) exprInst).getRightExpr(), paramName));
			
			if (null != ret1 && null != ret2) {
				ret = new ArrayList<ExprDescPlan>();
				ret.addAll(ret1);
				ret.addAll(ret2);
			}

		} 
		
		return ret;
	}
	
	@Override
	public List<ExprDescPlan> visitExprNotIn(ExprNotInPlan expr) {
		List<ExprDescPlan> ret = null;
		
		if (exprInst instanceof ExprNotInPlan) {
			List<ExprDescPlan> ret1 =
				expr.getElement().accept(new ArgumentExtractor(((ExprNotInPlan) exprInst).getElement(), paramName));
			List<ExprDescPlan> ret2 =	
				expr.getSet().accept(new ArgumentExtractor(((ExprNotInPlan) exprInst).getSet(), paramName));
			
			if (null != ret1 && null != ret2) {
				ret = new ArrayList<ExprDescPlan>();
				ret.addAll(ret1);
				ret.addAll(ret2);
			}

		} 
		
		return ret;
	}
	
	@Override
	public List<ExprDescPlan> visitExprRan(ExprRanPlan expr) {
		List<ExprDescPlan> ret = null;
		
		if (exprInst instanceof ExprRanPlan) {
			List<ExprDescPlan> ret1 =
				expr.getFunction().accept(new ArgumentExtractor(((ExprRanPlan) exprInst).getFunction(), paramName));
			
			if (null != ret1) {
				ret = new ArrayList<ExprDescPlan>();
				ret.addAll(ret1);
			}

		} 
		
		return ret;
	}
	
	@Override
	public List<ExprDescPlan> visitExprSet(ExprSetPlan expr) {
		List<ExprDescPlan> ret = new ArrayList<ExprDescPlan>();
		
		if (exprInst instanceof ExprSetPlan && 
				expr.getElements().size() == ((ExprSetPlan) exprInst).getElements().size()) {
			for (int i = 0; i < expr.getElements().size(); i++) {
				ExprDescPlan e1 = expr.getElements().get(i);
				ExprDescPlan e2 = ((ExprSetPlan) exprInst).getElements().get(i);
				List<ExprDescPlan> tmp = e1.accept(new ArgumentExtractor(e2, paramName));
				
				if (null == tmp) {
					ret = null;
					break;
				} else {
					ret.addAll(tmp);
				}
				
			}
		} else {
			ret = null;
		}
		
		return ret;
	}
	
	@Override
	public List<ExprDescPlan> visitExprSubSetEq(ExprSubSetEqPlan expr) {
		List<ExprDescPlan> ret = null;
		
		if (exprInst instanceof ExprSubSetEqPlan) {
			List<ExprDescPlan> ret1 =
				expr.getLeftSet().accept(new ArgumentExtractor(((ExprSubSetEqPlan) exprInst).getLeftSet(), paramName));
			List<ExprDescPlan> ret2 =	
				expr.getRightSet().accept(new ArgumentExtractor(((ExprSubSetEqPlan) exprInst).getRightSet(), paramName));
			
			if (null != ret1 && null != ret2) {
				ret = new ArrayList<ExprDescPlan>();
				ret.addAll(ret1);
				ret.addAll(ret2);
			}

		} 
		
		return ret;
	}
	
	@Override
	public List<ExprDescPlan> visitExprSubSet(ExprSubSetPlan expr) {
		List<ExprDescPlan> ret = null;
		
		if (exprInst instanceof ExprSubSetPlan) {
			List<ExprDescPlan> ret1 =
				expr.getLeftSet().accept(new ArgumentExtractor(((ExprSubSetPlan) exprInst).getLeftSet(), paramName));
			List<ExprDescPlan> ret2 =	
				expr.getRightSet().accept(new ArgumentExtractor(((ExprSubSetPlan) exprInst).getRightSet(), paramName));
			
			if (null != ret1 && null != ret2) {
				ret = new ArrayList<ExprDescPlan>();
				ret.addAll(ret1);
				ret.addAll(ret2);
			}

		} 
		
		return ret;
	}
	
	@Override
	public List<ExprDescPlan> visitExprUnion(ExprUnionPlan expr) {
		List<ExprDescPlan> ret = null;
		
		if (exprInst instanceof ExprUnionPlan) {
			List<ExprDescPlan> ret1 =
				expr.getLeftSet().accept(new ArgumentExtractor(((ExprUnionPlan) exprInst).getLeftSet(), paramName));
			List<ExprDescPlan> ret2 =	
				expr.getRightSet().accept(new ArgumentExtractor(((ExprUnionPlan) exprInst).getRightSet(), paramName));
			
			if (null != ret1 && null != ret2) {
				ret = new ArrayList<ExprDescPlan>();
				ret.addAll(ret1);
				ret.addAll(ret2);
			}

		} 
		
		return ret;
	}
	
	@Override
	public List<ExprDescPlan> visitNot(ExprNotPlan expr) {
		List<ExprDescPlan> ret = null;
		
		if (exprInst instanceof ExprNotPlan) {
			List<ExprDescPlan> ret1 =
				expr.getExpr().accept(new ArgumentExtractor(((ExprNotPlan) exprInst).getExpr(), paramName));
			
			if (null != ret1) {
				ret = new ArrayList<ExprDescPlan>();
				ret.addAll(ret1);
			}

		} 
		
		return ret;
	}
	
	
}
