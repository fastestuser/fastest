package nlg.description;

import java.util.List;

import common.z.TClass;

/**
 * Descripcion de una clase de prueba.
 */
public class TClassDescription {
	
	private TClass tClass;
	private String opDescription;
	private List<String> predtDescriptions;
	
	public TClass getTClass() {
		return tClass;
	}
	public void setTClass(TClass tClass) {
		this.tClass = tClass;
	}
	public String getOpDescription() {
		return opDescription;
	}
	public void setOpDescription(String opDescription) {
		this.opDescription = opDescription;
	}
	public List<String> getPredtDescriptions() {
		return predtDescriptions;
	}
	public void setPredtDescriptions(List<String> predtDescriptions) {
		this.predtDescriptions = predtDescriptions;
	}
	
	
}
