package nlg.base.textSpecification;

/**
 * Modela sintagma verbal
 */
public class PSFraseVerbal implements PhraseSpecification {

	private String verbo;
	private String atributo;
	private PhraseSpecification complemento;
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

	public PhraseSpecification getComplemento() {
		return complemento;
	}

	public void setComplemento(PhraseSpecification complemento) {
		this.complemento = complemento;
	}

	public boolean isNegado() {
		return negado;
	}

	public void setNegado(boolean negado) {
		this.negado = negado;
	}

	@Override
	public <X> X accept(PhraseSpecificationVisitor<X> visitor) {
		return visitor.visitPSFraseVerbal(this);
	}

}
