package nlg.base.textSpecification;

import nlg.base.linguistic.InfoMorfologica;

/**
 * Modela sintagma nominal
 */
public class PSFraseNominal extends PhraseSpec {

	private String especificador;
	private String nucleo;
	private InfoMorfologica infoNucleo;
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

	public InfoMorfologica getInfoNucleo() {
		return infoNucleo;
	}

	public void setInfoNucleo(InfoMorfologica infoNucleo) {
		this.infoNucleo = infoNucleo;
	}
	
	@Override
	public <X> X accept(PhraseSpecVisitor<X> visitor) {
		return visitor.visitPSFraseNominal(this);
	}
}
