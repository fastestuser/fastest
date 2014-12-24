package nlg.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import nlg.base.expr.ExprApply;
import nlg.base.expr.ExprDom;
import nlg.base.expr.ExprEq;
import nlg.base.expr.ExprIn;
import nlg.base.expr.ExprIntersection;
import nlg.base.expr.ExprMapsTo;
import nlg.base.expr.ExprNot;
import nlg.base.expr.ExprNotEq;
import nlg.base.expr.ExprNotIn;
import nlg.base.expr.ExprRan;
import nlg.base.expr.ExprRef;
import nlg.base.expr.ExprSet;
import nlg.base.expr.ExprSubSet;
import nlg.base.expr.ExprSubSetEq;
import nlg.base.expr.ExprUnion;
import nlg.base.expr.ExprZ;
import nlg.base.expr.ExprZVisitor;

public class ArgumentExtractor implements ExprZVisitor<List<ExprZ>> {

	private ExprZ exprInst; // Expresion ya instanciada
	private ExprRef paramName;
	
	public ArgumentExtractor(ExprZ exprInst, ExprRef paramName) {
		this.exprInst = exprInst;
		this.paramName = paramName;
	}
	
	@Override
	public List<ExprZ> visitExprApply(ExprApply expr) {
		List<ExprZ> ret = null;
		
		if (exprInst instanceof ExprApply) {
			List<ExprZ> ret1 =
				expr.getArgument().accept(new ArgumentExtractor(((ExprApply) exprInst).getArgument(), paramName));
			List<ExprZ> ret2 =	
				expr.getFunction().accept(new ArgumentExtractor(((ExprApply) exprInst).getFunction(), paramName));
			
			if (null != ret1 && null != ret2) {
				ret = new ArrayList<ExprZ>();
				ret.addAll(ret1);
				ret.addAll(ret2);
			}

		} 
		
		return ret;
	}
	
	@Override
	public List<ExprZ> visitExprDom(ExprDom expr) {
		List<ExprZ> ret = null;
		
		if (exprInst instanceof ExprDom) {
			List<ExprZ> ret1 =
				expr.getFunction().accept(new ArgumentExtractor(((ExprDom) exprInst).getFunction(), paramName));
			
			if (null != ret1) {
				ret = new ArrayList<ExprZ>();
				ret.addAll(ret1);
			}

		} 
		
		return ret;
	}
	
	@Override
	public List<ExprZ> visitExprEq(ExprEq expr) {
		List<ExprZ> ret = null;
		
		if (exprInst instanceof ExprEq) {
			List<ExprZ> ret1 =
				expr.getLeftExpr().accept(new ArgumentExtractor(((ExprEq) exprInst).getLeftExpr(), paramName));
			List<ExprZ> ret2 =	
				expr.getRightExpr().accept(new ArgumentExtractor(((ExprEq) exprInst).getRightExpr(), paramName));
			
			if (null != ret1 && null != ret2) {
				ret = new ArrayList<ExprZ>();
				ret.addAll(ret1);
				ret.addAll(ret2);
			}

		} 
		
		return ret;
	}
	
	@Override
	public List<ExprZ> visitExprIn(ExprIn expr) {
		List<ExprZ> ret = null;
		
		if (exprInst instanceof ExprIn) {
			List<ExprZ> ret1 =
				expr.getElement().accept(new ArgumentExtractor(((ExprIn) exprInst).getElement(), paramName));
			List<ExprZ> ret2 =	
				expr.getSet().accept(new ArgumentExtractor(((ExprIn) exprInst).getSet(), paramName));
			
			if (null != ret1 && null != ret2) {
				ret = new ArrayList<ExprZ>();
				ret.addAll(ret1);
				ret.addAll(ret2);
			}

		} 
		
		return ret;
	}
	
	@Override
	public List<ExprZ> visitExprIntersection(ExprIntersection expr) {
		List<ExprZ> ret = null;
		
		if (exprInst instanceof ExprIntersection) {
			List<ExprZ> ret1 =
				expr.getLeftSet().accept(new ArgumentExtractor(((ExprIntersection) exprInst).getLeftSet(), paramName));
			List<ExprZ> ret2 =	
				expr.getRightSet().accept(new ArgumentExtractor(((ExprIntersection) exprInst).getRightSet(), paramName));
			
			if (null != ret1 && null != ret2) {
				ret = new ArrayList<ExprZ>();
				ret.addAll(ret1);
				ret.addAll(ret2);
			}

		} 
		
		return ret;
	}
	
	@Override
	public List<ExprZ> visitExprMapsTo(ExprMapsTo expr) {
		List<ExprZ> ret = null;
		
		if (exprInst instanceof ExprMapsTo) {
			List<ExprZ> ret1 =
				expr.getLeft().accept(new ArgumentExtractor(((ExprMapsTo) exprInst).getLeft(), paramName));
			List<ExprZ> ret2 =	
				expr.getRight().accept(new ArgumentExtractor(((ExprMapsTo) exprInst).getRight(), paramName));
			
			if (null != ret1 && null != ret2) {
				ret = new ArrayList<ExprZ>();
				ret.addAll(ret1);
				ret.addAll(ret2);
			}

		} 
		
		return ret;
	}
	
	@Override
	public List<ExprZ> visitExprRefExpr(ExprRef expr) {
		List<ExprZ> ret = null;
		
		if (expr.equals(paramName)) {
			ret = Arrays.asList(exprInst);
		} else if (expr.equals(exprInst)) {
			ret = new ArrayList<ExprZ>();
		}
		
		return ret;
	}
	
	@Override
	public List<ExprZ> visitExprNotEq(ExprNotEq expr) {
		List<ExprZ> ret = null;
		
		if (exprInst instanceof ExprNotEq) {
			List<ExprZ> ret1 =
				expr.getLeftExpr().accept(new ArgumentExtractor(((ExprNotEq) exprInst).getLeftExpr(), paramName));
			List<ExprZ> ret2 =	
				expr.getRightExpr().accept(new ArgumentExtractor(((ExprNotEq) exprInst).getRightExpr(), paramName));
			
			if (null != ret1 && null != ret2) {
				ret = new ArrayList<ExprZ>();
				ret.addAll(ret1);
				ret.addAll(ret2);
			}

		} 
		
		return ret;
	}
	
	@Override
	public List<ExprZ> visitExprNotIn(ExprNotIn expr) {
		List<ExprZ> ret = null;
		
		if (exprInst instanceof ExprNotIn) {
			List<ExprZ> ret1 =
				expr.getElement().accept(new ArgumentExtractor(((ExprNotIn) exprInst).getElement(), paramName));
			List<ExprZ> ret2 =	
				expr.getSet().accept(new ArgumentExtractor(((ExprNotIn) exprInst).getSet(), paramName));
			
			if (null != ret1 && null != ret2) {
				ret = new ArrayList<ExprZ>();
				ret.addAll(ret1);
				ret.addAll(ret2);
			}

		} 
		
		return ret;
	}
	
	@Override
	public List<ExprZ> visitExprRan(ExprRan expr) {
		List<ExprZ> ret = null;
		
		if (exprInst instanceof ExprRan) {
			List<ExprZ> ret1 =
				expr.getFunction().accept(new ArgumentExtractor(((ExprRan) exprInst).getFunction(), paramName));
			
			if (null != ret1) {
				ret = new ArrayList<ExprZ>();
				ret.addAll(ret1);
			}

		} 
		
		return ret;
	}
	
	@Override
	public List<ExprZ> visitExprSet(ExprSet expr) {
		List<ExprZ> ret = new ArrayList<ExprZ>();
		
		if (exprInst instanceof ExprSet && 
				expr.getElements().size() == ((ExprSet) exprInst).getElements().size()) {
			for (int i = 0; i < expr.getElements().size(); i++) {
				ExprZ e1 = expr.getElements().get(i);
				ExprZ e2 = ((ExprSet) exprInst).getElements().get(i);
				List<ExprZ> tmp = e1.accept(new ArgumentExtractor(e2, paramName));
				
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
	public List<ExprZ> visitExprSubSetEq(ExprSubSetEq expr) {
		List<ExprZ> ret = null;
		
		if (exprInst instanceof ExprSubSetEq) {
			List<ExprZ> ret1 =
				expr.getLeftSet().accept(new ArgumentExtractor(((ExprSubSetEq) exprInst).getLeftSet(), paramName));
			List<ExprZ> ret2 =	
				expr.getRightSet().accept(new ArgumentExtractor(((ExprSubSetEq) exprInst).getRightSet(), paramName));
			
			if (null != ret1 && null != ret2) {
				ret = new ArrayList<ExprZ>();
				ret.addAll(ret1);
				ret.addAll(ret2);
			}

		} 
		
		return ret;
	}
	
	@Override
	public List<ExprZ> visitExprSubSet(ExprSubSet expr) {
		List<ExprZ> ret = null;
		
		if (exprInst instanceof ExprSubSet) {
			List<ExprZ> ret1 =
				expr.getLeftSet().accept(new ArgumentExtractor(((ExprSubSet) exprInst).getLeftSet(), paramName));
			List<ExprZ> ret2 =	
				expr.getRightSet().accept(new ArgumentExtractor(((ExprSubSet) exprInst).getRightSet(), paramName));
			
			if (null != ret1 && null != ret2) {
				ret = new ArrayList<ExprZ>();
				ret.addAll(ret1);
				ret.addAll(ret2);
			}

		} 
		
		return ret;
	}
	
	@Override
	public List<ExprZ> visitExprUnion(ExprUnion expr) {
		List<ExprZ> ret = null;
		
		if (exprInst instanceof ExprUnion) {
			List<ExprZ> ret1 =
				expr.getLeftSet().accept(new ArgumentExtractor(((ExprUnion) exprInst).getLeftSet(), paramName));
			List<ExprZ> ret2 =	
				expr.getRightSet().accept(new ArgumentExtractor(((ExprUnion) exprInst).getRightSet(), paramName));
			
			if (null != ret1 && null != ret2) {
				ret = new ArrayList<ExprZ>();
				ret.addAll(ret1);
				ret.addAll(ret2);
			}

		} 
		
		return ret;
	}
	
	@Override
	public List<ExprZ> visitNot(ExprNot expr) {
		List<ExprZ> ret = null;
		
		if (exprInst instanceof ExprNot) {
			List<ExprZ> ret1 =
				expr.getExpr().accept(new ArgumentExtractor(((ExprNot) exprInst).getExpr(), paramName));
			
			if (null != ret1) {
				ret = new ArrayList<ExprZ>();
				ret.addAll(ret1);
			}

		} 
		
		return ret;
	}
	
	
}
