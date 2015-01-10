package nlg.base.textSpecification;

import java.util.List;

/**
 * Especificacion para lista de frases.
 * Usada para modelar las descripciones de clases
 * de prueba, donde las restricciones se deben
 * mostrar en forma de lista.
 */
public class TSItemisedList implements TextSpec {
	
	private PhraseSpec introduction;
	private List<PhraseSpec> elements;
	
	public PhraseSpec getIntroduction() {
		return introduction;
	}

	public void setIntroduction(PhraseSpec introduction) {
		this.introduction = introduction;
	}

	public List<PhraseSpec> getElements() {
		return elements;
	}

	public void setElements(List<PhraseSpec> elements) {
		this.elements = elements;
	}

	@Override
	public <X> X accept(TextSpecVisitor<X> visitor) {
		return visitor.visitTSItemisedList(this);
	}

}
