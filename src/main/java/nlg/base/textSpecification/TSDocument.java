package nlg.base.textSpecification;

import java.util.List;

/**
 * Especificacion para documento. 
 * Sera la raiz de nuestra especificacion del texto.
 */
public class TSDocument implements TextSpec {
	
	private String title;
	private List<TextSpec> paragraphs;
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<TextSpec> getParagraphs() {
		return paragraphs;
	}

	public void setParagraphs(List<TextSpec> paragraphs) {
		this.paragraphs = paragraphs;
	}

	@Override
	public <X> X accept(TextSpecVisitor<X> visitor) {
		return visitor.visitTSDocument(this);
	}

}
