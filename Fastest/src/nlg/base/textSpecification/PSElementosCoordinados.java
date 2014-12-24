package nlg.base.textSpecification;

import java.util.List;

/**
 * Modela conjunto de elementos que luego deberan
 * ser realizados como una conjuncion o disyuncion.
 */
public class PSElementosCoordinados implements PhraseSpecification {

	private List<PhraseSpecification> elementos;
	
	public List<PhraseSpecification> getElementos() {
		return elementos;
	}

	public void setElementos(List<PhraseSpecification> elementos) {
		this.elementos = elementos;
	}
	
	@Override
	public <X> X accept(PhraseSpecificationVisitor<X> visitor) {
		return visitor.visitPSElementosCoordinados(this);
	}

}
