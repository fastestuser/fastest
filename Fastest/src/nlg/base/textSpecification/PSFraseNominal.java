package nlg.base.textSpecification;

/**
 * Modela sintagma nominal
 */
public class PSFraseNominal implements PhraseSpecification {

	private String especificador;
	private String nucleo;
	private PhraseSpecification complemento;
	
	public String getEspecificador() {
		return especificador;
	}

	public void setEspecificador(String especificador) {
		this.especificador = especificador;
	}

	public String getNucleo() {
		return nucleo;
	}

	public void setNucleo(String nucleo) {
		this.nucleo = nucleo;
	}

	public PhraseSpecification getComplemento() {
		return complemento;
	}

	public void setComplemento(PhraseSpecification complemento) {
		this.complemento = complemento;
	}

	@Override
	public <X> X accept(PhraseSpecificationVisitor<X> visitor) {
		return visitor.visitPSFraseNominal(this);
	}

}
