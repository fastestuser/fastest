package nlg.base.textSpecification;

/**
 * Modela frases "enlatadas" que no requieren procesamiento
 * alguno por parte del realizador de superficie.
 */
public class PSTextoEnlatado implements PhraseSpec {

	private String text;
	
	public PSTextoEnlatado(String text) {
		this.text = text;
	}
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public <X> X accept(PhraseSpecVisitor<X> visitor) {
		return visitor.visitPSTextoEnlatado(this);
	}

}
