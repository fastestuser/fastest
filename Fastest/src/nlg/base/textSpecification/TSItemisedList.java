package nlg.base.textSpecification;

/**
 * Especificacion para lista de frases.
 * Usada para modelar las descripciones de clases
 * de prueba, donde las restricciones se deben
 * mostrar en forma de lista.
 */
public class TSItemisedList implements TextSpecification {

	@Override
	public <X> X accept(TextSpecificationVisitor<X> visitor) {
		return visitor.visitTSItemisedList(this);
	}

}
