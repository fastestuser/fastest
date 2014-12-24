package nlg.base.textSpecification;

/**
 * Modela oraciones bimembres.
 */
public class PSOracion implements PhraseSpecification {

	private PSFraseNominal fraseNominal;
	private PSFraseVerbal fraseVerbal;
	
	public PSFraseNominal getFraseNominal() {
		return fraseNominal;
	}

	public void setFraseNominal(PSFraseNominal fraseNominal) {
		this.fraseNominal = fraseNominal;
	}

	public PSFraseVerbal getFraseVerbal() {
		return fraseVerbal;
	}

	public void setFraseVerbal(PSFraseVerbal fraseVerbal) {
		this.fraseVerbal = fraseVerbal;
	}

	@Override
	public <X> X accept(PhraseSpecificationVisitor<X> visitor) {
		return visitor.visitPSOracion(this);
	}

}
