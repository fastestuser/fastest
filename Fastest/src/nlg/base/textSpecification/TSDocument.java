package nlg.base.textSpecification;

/**
 * Especificacion para documento. 
 * Sera la raiz de nuestra especificacion del texto.
 */
public class TSDocument implements TextSpecification {

	@Override
	public <X> X accept(TextSpecificationVisitor<X> visitor) {
		return visitor.visitTSDocument(this);
	}

}
