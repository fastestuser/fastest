package nlg.pipeline.microplanner;

import nlg.base.documentPlan.DocumentPlan;
import nlg.base.textSpecification.TextSpecification;
import client.blogic.management.Controller;

public class MicroPlanner {

	private Controller controller;
	
	public MicroPlanner(Controller controller) {
		this.controller = controller;
	}
	
	public TextSpecification createTS(DocumentPlan dp) {
		return null;
	}
	
}
