package nlg.util;

import nlg.base.expression.ExprApply;
import nlg.base.expression.ExprDom;
import nlg.base.expression.ExprEq;
import nlg.base.expression.ExprIn;
import nlg.base.expression.ExprIntersection;
import nlg.base.expression.ExprMapsTo;
import nlg.base.expression.ExprNot;
import nlg.base.expression.ExprNotEq;
import nlg.base.expression.ExprNotIn;
import nlg.base.expression.ExprRan;
import nlg.base.expression.ExprRef;
import nlg.base.expression.ExprSet;
import nlg.base.expression.ExprSubSet;
import nlg.base.expression.ExprSubSetEq;
import nlg.base.expression.ExprUnion;
import nlg.base.expression.ExprZ;
import nlg.base.expression.ExprZVisitor;

/**
 * Dadas dos expresiones (una de ellas parametrizadas) y el nombre del parametro
 * intentara extraer el parametro la expresion 
 *
 */
public class ParamExprMatcher implements ExprZVisitor<ExprZ> {

	private ExprZ exprInst; // Expresion ya instanciada
	private ExprRef paramName;
	
	public ParamExprMatcher(ExprZ exprInst, ExprRef paramName) {
		this.exprInst = exprInst;
		this.paramName = paramName;
	}
	
	@Override
	public ExprZ visitExprApply(ExprApply expr) {
		ExprZ ret = null;
		
		if (exprInst instanceof ExprApply) {
			ret = expr.getArgument().accept(new ParamExprMatcher(((ExprApply) exprInst).getArgument(), paramName));
			
			if (ret == null) {
				ret = expr.getFunction().accept(new ParamExprMatcher(((ExprApply) exprInst).getFunction(), paramName));
			}
		} 
		
		return ret;
	}
	
	@Override
	public ExprZ visitExprDom(ExprDom expr) {
		ExprZ ret = null;
		
		if (exprInst instanceof ExprDom) {
			ret = expr.getFunction().accept(new ParamExprMatcher(((ExprDom) exprInst).getFunction(), paramName));
		} 
		
		return ret;
	}
	
	@Override
	public ExprZ visitExprEq(ExprEq expr) {
		ExprZ ret = null;
		
		if (exprInst instanceof ExprEq) {
			ret = expr.getLeftExpr().accept(new ParamExprMatcher(((ExprEq) exprInst).getLeftExpr(), paramName));
			
			if (null == ret) {
				ret = expr.getRightExpr().accept(new ParamExprMatcher(((ExprEq) exprInst).getRightExpr(), paramName));
			}
		} 
		
		return ret;
	}
	
	@Override
	public ExprZ visitExprIn(ExprIn expr) {
		ExprZ ret = null;
		
		if (exprInst instanceof ExprIn) {
			ret = expr.getElement().accept(new ParamExprMatcher(((ExprIn) exprInst).getElement(), paramName));
			
			if (null == ret) {
				ret = expr.getSet().accept(new ParamExprMatcher(((ExprIn) exprInst).getSet(), paramName));
			}
		} 
		
		return ret;
	}
	
	@Override
	public ExprZ visitExprIntersection(ExprIntersection expr) {
		ExprZ ret = null;
		
		if (exprInst instanceof ExprIntersection) {
			ret = expr.getLeftSet().accept(new ParamExprMatcher(((ExprIntersection) exprInst).getLeftSet(), paramName));
			
			if (null == ret) {
				ret = expr.getRightSet().accept(new ParamExprMatcher(((ExprIntersection) exprInst).getRightSet(), paramName));
			}
		} 
		
		return ret;
	}
	
	@Override
	public ExprZ visitExprMapsTo(ExprMapsTo expr) {
		ExprZ ret = null;
		
		if (exprInst instanceof ExprMapsTo) {
			ret = expr.getLeft().accept(new ParamExprMatcher(((ExprMapsTo) exprInst).getLeft(), paramName));
			
			if (null == ret) {
				ret = expr.getRight().accept(new ParamExprMatcher(((ExprMapsTo) exprInst).getRight(), paramName));
			}
		} 
		
		return ret;
	}
	
	@Override
	public ExprZ visitExprRefExpr(ExprRef expr) {
		ExprZ ret = null;
		
		if (expr.equals(paramName)) {
			ret = exprInst;
		} 
		
		return ret;
	}
	
	@Override
	public ExprZ visitExprNotEq(ExprNotEq expr) {
		ExprZ ret = null;
		
		if (exprInst instanceof ExprNotEq) {
			ret = expr.getLeftExpr().accept(new ParamExprMatcher(((ExprNotEq) exprInst).getLeftExpr(), paramName));
			
			if (null == ret) {
				ret = expr.getRightExpr().accept(new ParamExprMatcher(((ExprNotEq) exprInst).getRightExpr(), paramName));
			}
		} 
		
		return ret;
	}
	
	@Override
	public ExprZ visitExprNotIn(ExprNotIn expr) {
		ExprZ ret = null;
		
		if (exprInst instanceof ExprNotIn) {
			ret = expr.getElement().accept(new ParamExprMatcher(((ExprNotIn) exprInst).getElement(), paramName));
			
			if (null == ret) {
				ret = expr.getSet().accept(new ParamExprMatcher(((ExprNotIn) exprInst).getSet(), paramName));
			}

		} 
		
		return ret;
	}
	
	@Override
	public ExprZ visitExprRan(ExprRan expr) {
		ExprZ ret = null;
		
		if (exprInst instanceof ExprRan) {
			ret = expr.getFunction().accept(new ParamExprMatcher(((ExprRan) exprInst).getFunction(), paramName));
		} 
		
		return ret;
	}
	
	@Override
	public ExprZ visitExprSet(ExprSet expr) {
		ExprZ ret = null;
		
		if (exprInst instanceof ExprSet && 
				expr.getElements().size() == ((ExprSet) exprInst).getElements().size()) {
			for (int i = 0; i < expr.getElements().size(); i++) {
				ExprZ e1 = expr.getElements().get(i);
				ExprZ e2 = ((ExprSet) exprInst).getElements().get(i);
				ExprZ tmp = e1.accept(new ParamExprMatcher(e2, paramName));
				
				if (null != tmp) {
					ret = tmp;
					break;
				}
				
			}
		} 
		
		return ret;
	}
	
	@Override
	public ExprZ visitExprSubSetEq(ExprSubSetEq expr) {
		ExprZ ret = null;
		
		if (exprInst instanceof ExprSubSetEq) {
			ret = expr.getLeftSet().accept(new ParamExprMatcher(((ExprSubSetEq) exprInst).getLeftSet(), paramName));
			
			if (null == ret) {
				ret = expr.getRightSet().accept(new ParamExprMatcher(((ExprSubSetEq) exprInst).getRightSet(), paramName));
			}
		} 
		
		return ret;
	}
	
	@Override
	public ExprZ visitExprSubSet(ExprSubSet expr) {
		ExprZ ret = null;
		
		if (exprInst instanceof ExprSubSet) {
			ret = expr.getLeftSet().accept(new ParamExprMatcher(((ExprSubSet) exprInst).getLeftSet(), paramName));
			
			if (null == ret) {
				ret = expr.getRightSet().accept(new ParamExprMatcher(((ExprSubSet) exprInst).getRightSet(), paramName));
			}
		} 
		
		return ret;
	}
	
	@Override
	public ExprZ visitExprUnion(ExprUnion expr) {
		ExprZ ret = null;
		
		if (exprInst instanceof ExprUnion) {
			ret = expr.getLeftSet().accept(new ParamExprMatcher(((ExprUnion) exprInst).getLeftSet(), paramName));
			
			if (null == ret) {
				ret = expr.getRightSet().accept(new ParamExprMatcher(((ExprUnion) exprInst).getRightSet(), paramName));
			}
		} 
		
		return ret;
	}
	
	@Override
	public ExprZ visitNot(ExprNot expr) {
		ExprZ ret = null;
		
		if (exprInst instanceof ExprNot) {
			ret = expr.getExpr().accept(new ParamExprMatcher(((ExprNot) exprInst).getExpr(), paramName));
		} 
		
		return ret;
	}
	
	
}
