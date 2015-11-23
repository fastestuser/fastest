package nlg.base.textSpecification;

/**
 * Visitor para operar sobre la estructura 
 * de las especificaciones de texto
 */
public interface TextSpecVisitor<X> {
	public X visitTSDocument(TSDocument ts);
	public X visitTSItemisedList(TSItemisedList ts);
}
