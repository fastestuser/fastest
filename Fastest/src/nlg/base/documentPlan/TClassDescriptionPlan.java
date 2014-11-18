package nlg.base.documentPlan;

import java.util.List;

/**
 * TODO documentar.
 * Nodo del documen plan que contiene expresiones a 
 * verbalizar por clase de prueba (y algunos datos adicionales).
 *
 */

public class TClassDescriptionPlan {

	private String name;
	private String introduction;
	private List<ExpVerbalization> expressions;
	
	public TClassDescriptionPlan(String name, String introduction,
			List<ExpVerbalization> expressions) {
		super();
		this.name = name;
		this.introduction = introduction;
		this.expressions = expressions;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getIntroduction() {
		return introduction;
	}
	
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	
	public List<ExpVerbalization> getExpressions() {
		return expressions;
	}
	
	public void setExpressions(List<ExpVerbalization> expressions) {
		this.expressions = expressions;
	}

}
