package nlg.base.documentPlan;

import java.util.List;

/**
 * Raiz del document plan
 * Sirve para modelar la estructura final del documento
 * de textos a generar.
 *
 */
public class DocumentPlan {
	private String title;
	private List<TClassDescriptionPlan> tClassDescPlanList;

	public DocumentPlan(String title, List<TClassDescriptionPlan> tClassDescPlanList) {
		this.title = title;
		this.tClassDescPlanList = tClassDescPlanList;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public List<TClassDescriptionPlan> gettClassDescPlanList() {
		return tClassDescPlanList;
	}

	public void settClassDescPlanList(List<TClassDescriptionPlan> tClassDescPlanList) {
		this.tClassDescPlanList = tClassDescPlanList;
	}
}
