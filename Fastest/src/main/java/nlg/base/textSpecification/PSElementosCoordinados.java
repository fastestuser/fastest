package nlg.base.textSpecification;

import java.util.List;

/**
 * Modela conjunto de elementos que luego deberan
 * ser realizados como una conjuncion o disyuncion.
 */
public class PSElementosCoordinados extends PhraseSpec {

	private List<PhraseSpec> elementos;
	
	public PSElementosCoordinados(List<PhraseSpec> elementos) {
		this.elementos = elementos;
	}
	
	public List<PhraseSpec> getElementos() {
		return elementos;
	}

	public void setElementos(List<PhraseSpec> elementos) {
		this.elementos = elementos;
	}
	
	@Override
	public <X> X accept(PhraseSpecVisitor<X> visitor) {
		return visitor.visitPSElementosCoordinados(this);
	}

}
