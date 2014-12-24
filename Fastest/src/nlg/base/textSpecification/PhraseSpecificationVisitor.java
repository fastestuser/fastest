package nlg.base.textSpecification;

/**
 * Visitor para operar sobre la estructura 
 * de las especificaciones de frases
 */
public interface PhraseSpecificationVisitor<X> {
	public X visitPSConcatenacion(PSConcatenacion ps);
	public X visitPSElementosCoordinados(PSElementosCoordinados ps);
	public X visitPSFraseNominal(PSFraseNominal ps);
	public X visitPSFraseVerbal(PSFraseVerbal ps);
	public X visitPSOracion(PSOracion ps);
	public X visitPSTextoEnlatado(PSTextoEnlatado ps);
}
