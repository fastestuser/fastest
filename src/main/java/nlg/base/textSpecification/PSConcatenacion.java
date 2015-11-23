package nlg.base.textSpecification;

import java.util.Arrays;
import java.util.List;

/**
 * Modela yuxtaposicion de frases
 */
public class PSConcatenacion extends PhraseSpec {

	private List<PhraseSpec> elementos;
	
	public PSConcatenacion() {
	}
	
	public PSConcatenacion(PhraseSpec ... specs) {
		this.elementos = Arrays.asList(specs);
	}
	
	public List<PhraseSpec> getElementos() {
		return elementos;
	}

	public void setElementos(List<PhraseSpec> elementos) {
		this.elementos = elementos;
	}

	@Override
	public <X> X accept(PhraseSpecVisitor<X> visitor) {
		return visitor.visitPSConcatenacion(this);
	}

}
