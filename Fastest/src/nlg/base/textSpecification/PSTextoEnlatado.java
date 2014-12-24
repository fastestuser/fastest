package nlg.base.textSpecification;

/**
 * Modela frases "enlatadas" que no requieren procesamiento
 * alguno por parte del realizador de superficie.
 */
public class PSTextoEnlatado implements PhraseSpecification {

	private String text;
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public <X> X accept(PhraseSpecificationVisitor<X> visitor) {
		return visitor.visitPSTextoEnlatado(this);
	}

}
