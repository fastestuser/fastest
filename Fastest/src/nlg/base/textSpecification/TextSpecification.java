package nlg.base.textSpecification;

/**
 * Interface base para la especificacion de estructuras del texto.
 */
public interface TextSpecification {
	public <X> X accept(TextSpecificationVisitor<X> visitor);
}

