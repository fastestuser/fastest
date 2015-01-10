package nlg.base.textSpecification;

/**
 * Modela sintagma verbal
 */
public class PSFraseVerbal implements PhraseSpec {

	private String verbo;
	private String atributo; // para cuando se tiene un verbo copulativo (ser, estar, etc.)
	private PhraseSpec complemento;
	private boolean negado;
	
	public String getVerbo() {
		return verbo;
	}

	public void setVerbo(String verbo) {
		this.verbo = verbo;
	}

	public String getAtributo() {
		return atributo;
	}

	public void setAtributo(String atributo) {
		this.atributo = atributo;
	}

	public PhraseSpec getComplemento() {
		return complemento;
	}

	public void setComplemento(PhraseSpec complemento) {
		this.complemento = complemento;
	}

	public boolean isNegado() {
		return negado;
	}

	public void setNegado(boolean negado) {
		this.negado = negado;
	}

	@Override
	public <X> X accept(PhraseSpecVisitor<X> visitor) {
		return visitor.visitPSFraseVerbal(this);
	}

}
