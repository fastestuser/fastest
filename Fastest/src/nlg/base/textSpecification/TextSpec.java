package nlg.base.textSpecification;

/**
 * Interface base para la especificacion de estructuras del texto.
 */
public interface TextSpec {
	public <X> X accept(TextSpecVisitor<X> visitor);
}

