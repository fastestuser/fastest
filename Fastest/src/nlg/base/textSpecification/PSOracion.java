package nlg.base.textSpecification;

/**
 * Modela oraciones bimembres.
 */
public class PSOracion implements PhraseSpec {

	private PhraseSpec sujeto;
	private PSFraseVerbal predicado;
	
	public PSOracion (PhraseSpec sujeto, PSFraseVerbal predicado) {
		this.sujeto = sujeto;
		this.predicado = predicado;
	}
	
	public PhraseSpec getSujeto() {
		return sujeto;
	}

	public void setSujeto(PhraseSpec fraseNominal) {
		this.sujeto = fraseNominal;
	}

	public PSFraseVerbal getPredicado() {
		return predicado;
	}

	public void setPredicado(PSFraseVerbal fraseVerbal) {
		this.predicado = fraseVerbal;
	}

	@Override
	public <X> X accept(PhraseSpecVisitor<X> visitor) {
		return visitor.visitPSOracion(this);
	}

}
