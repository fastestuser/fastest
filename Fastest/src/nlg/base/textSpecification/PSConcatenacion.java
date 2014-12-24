package nlg.base.textSpecification;

import java.util.List;

/**
 * Modela yuxtaposicion de frases
 */
public class PSConcatenacion implements PhraseSpecification {

	private List<PhraseSpecification> elementos;
	
	public List<PhraseSpecification> getElementos() {
		return elementos;
	}

	public void setElementos(List<PhraseSpecification> elementos) {
		this.elementos = elementos;
	}

	@Override
	public <X> X accept(PhraseSpecificationVisitor<X> visitor) {
		return visitor.visitPSConcatenacion(this);
	}

}
