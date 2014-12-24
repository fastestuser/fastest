package nlg.base.textSpecification;

/**
 * Interface base para la especificacion de frases del texto.
 */
public interface PhraseSpecification {
	public <X> X accept(PhraseSpecificationVisitor<X> visitor);
}
