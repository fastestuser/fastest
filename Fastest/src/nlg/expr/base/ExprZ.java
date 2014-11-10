package nlg.expr.base;

import nlg.expr.visitors.ExprZVisitor;

/**
 * Expresion Z.
 * Interface base para todas las expresiones Z soportadas
 * por el sistema de generacion de lenguaje natural.
 * Es bastante flexible en cuanto a tipos ya que se supone que
 * los mismos ya fueron chequeados anteriormente y las expresiones
 * con las que trabajamos estaran correctamente formadas.
 */
public interface ExprZ {
	public <X> X accept(ExprZVisitor<X> visitor);
}
