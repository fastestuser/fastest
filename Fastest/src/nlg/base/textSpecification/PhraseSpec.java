package nlg.base.textSpecification;

/**
 * Interface base para la especificacion de frases del texto.
 */
public abstract class PhraseSpec {
	public abstract <X> X accept(PhraseSpecVisitor<X> visitor);
}
