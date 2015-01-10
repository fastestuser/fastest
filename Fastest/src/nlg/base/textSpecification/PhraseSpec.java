package nlg.base.textSpecification;

/**
 * Interface base para la especificacion de frases del texto.
 */
public interface PhraseSpec {
	public <X> X accept(PhraseSpecVisitor<X> visitor);
}
