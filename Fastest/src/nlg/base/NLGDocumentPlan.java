package nlg.base;

import java.util.List;

/**
 * Estructura del documento a generar
 *
 */
public class NLGDocumentPlan {
	private List<TClassDescPlan> tClassDescPlanList;

	public NLGDocumentPlan(List<TClassDescPlan> tClassDescPlanList) {
		this.tClassDescPlanList = tClassDescPlanList;
	}

	public List<TClassDescPlan> gettClassDescPlanList() {
		return tClassDescPlanList;
	}

	public void settClassDescPlanList(List<TClassDescPlan> tClassDescPlanList) {
		this.tClassDescPlanList = tClassDescPlanList;
	}
}
