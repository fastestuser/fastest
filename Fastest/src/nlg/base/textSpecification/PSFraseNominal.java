package nlg.base.textSpecification;

/**
 * Modela sintagma nominal
 */
public class PSFraseNominal implements PhraseSpec {

	private String especificador;
	private String tagEspecificador;
	private String nucleo;
	private String tagNucleo;
	private PhraseSpec complemento;
	
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

	public PhraseSpec getComplemento() {
		return complemento;
	}

	public void setComplemento(PhraseSpec complemento) {
		this.complemento = complemento;
	}
	
	public String getTagEspecificador() {
		return tagEspecificador;
	}

	public void setTagEspecificador(String tagEspecificador) {
		this.tagEspecificador = tagEspecificador;
	}

	public String getTagNucleo() {
		return tagNucleo;
	}

	public void setTagNucleo(String tagNucleo) {
		this.tagNucleo = tagNucleo;
	}

	@Override
	public <X> X accept(PhraseSpecVisitor<X> visitor) {
		return visitor.visitPSFraseNominal(this);
	}

}
