package nlg.base;

import java.util.List;

import common.z.TClass;

/**
 * Descripcion de una clase de prueba.	
 */
public class TClassDesc {
	
	// Titulo o nombre de la clase de prueba
	private String title;
	// Descripcion de la operacion a testear
	private String description;
	// Lista de descripciones expresiones del esquema
	private List<String> textItems;
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public List<String> getTextItems() {
		return textItems;
	}
	
	public void setTextItems(List<String> textItems) {
		this.textItems = textItems;
	}

}
