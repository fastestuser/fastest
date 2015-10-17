package nlg.base.textSpecification;

import java.util.List;

/**
 * Especificacion para documento. 
 * Sera la raiz de nuestra especificacion del texto.
 */
public class TSDocument {
	
	private String title;
	private List<TSItemisedList> paragraphs;
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<TSItemisedList> getParagraphs() {
		return paragraphs;
	}

	public void setParagraphs(List<TSItemisedList> paragraphs) {
		this.paragraphs = paragraphs;
	}
}
