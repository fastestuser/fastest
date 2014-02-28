package client.blogic.testing.refinamiento;

import java.util.HashMap;


public class RefinementRules {
	
	private HashMap<String,RefinementRule> rules;
	private static RefinementRules refinementRules;
	
	private RefinementRules(){
		rules = new HashMap<String,RefinementRule>();
	}
	public static RefinementRules getInstance(){
		if (refinementRules==null)
			refinementRules = new RefinementRules();
		return refinementRules;
	}
	
	public void addRule(String ruleName,RefinementRule rule){
		rules.put(ruleName, rule);
	}
	public RefinementRule getRule(String ruleName){
		return rules.get(ruleName);
	}
	
	
}
