package nlg.expr.base;

import nlg.expr.visitors.VisitorExprDescPlan;

/**
 * Expresion Z.
 * Interface base para todas las expresiones Z soportadas
 * por el sistema de generacion de lenguaje natural.
 * Es bastante flexible en cuanto a tipos ya que se supone que
 * los mismos ya fueron chequeados anteriormente y las expresiones
 * con las que trabajamos estaran correctamente formadas.
 */
public interface ExprDescPlan {
	public <X> X accept(VisitorExprDescPlan<X> visitor);
}
