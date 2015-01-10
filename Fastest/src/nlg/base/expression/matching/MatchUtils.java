package nlg.base.expression.matching;

import nlg.base.expression.ExprIntersection;
import nlg.base.expression.ExprZ;

public class MatchUtils {

	/**
	 * exp = {}
	 */
	public static Boolean matchEmptySet(ExprZ exp) {
		MatcherEmptySet visitor = new MatcherEmptySet();
		return exp.accept(visitor);
	}
	
	/**
	 * exp = {x}
	 */
	public static Boolean matchSingleton(ExprZ exp) {
		MatcherSingleton visitor = new MatcherSingleton();
		return exp.accept(visitor);
	}
	
	/**
	 * exp = exp1 ∩ exp2
	 */
	public static Boolean matchIntersection(ExprZ exp) {
		MatcherExprZIntersection visitor = new MatcherExprZIntersection();
		return exp.accept(visitor);
	}
	
	/**
	 * exp = {x} ∩ exp2
	 */
	public static Boolean matchIntersectionSingleton1(ExprZ exp) {
		MatcherExprZIntersection visitor = new MatcherExprZIntersection();
		if (exp.accept(visitor)) {
			return matchSingleton(((ExprIntersection) exp).getLeftSet());
		} else {
			return false;
		}
	}
	
	/**
	 * exp = exp2 ∩ {x}
	 */
	public static Boolean matchIntersectionSingleton2(ExprZ exp) {
		MatcherExprZIntersection visitor = new MatcherExprZIntersection();
		if (exp.accept(visitor)) {
			return matchSingleton(((ExprIntersection) exp).getRightSet());
		} else {
			return false;
		}
	}
	
	/**
	 * exp = {x, y , ..., z}
	 */
	public static Boolean matchSet(ExprZ exp) {
		MatcherExprZSet visitor = new MatcherExprZSet();
		return exp.accept(visitor);
	}
	
	/**
	 * exp = A ⊆ B
	 */
	public static Boolean matchSubSetEq(ExprZ exp) {
		MatcherExprZSubSetEq visitor = new MatcherExprZSubSetEq();
		return exp.accept(visitor);
	}
	
	/**
	 * exp = A ⊂ B
	 */
	public static Boolean matchSubSet(ExprZ exp) {
		MatcherExprZSubSet visitor = new MatcherExprZSubSet();
		return exp.accept(visitor);
	}
}
