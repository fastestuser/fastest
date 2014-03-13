package client.blogic.testing.refinamiento;

import java.util.HashMap;
import java.util.LinkedList;


public class RefinementRules {
	
	private HashMap<String,RefinementRule> rules;
	private static RefinementRules refinementRules;
	private static LinkedList<String> referencedVars;
	
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
	
	public LinkedList<String> getReferencedVars(){
		return referencedVars;
	}
	public void generateReferencedVars(String ruleName){
		RefinementRule rule = rules.get(ruleName);
		if (rule != null){
			FTCRLRefExtractorVisitor visitor = new FTCRLRefExtractorVisitor();
			visitor.visit(rule.getTree());
			referencedVars = visitor.getReferencedVars();
		}
	}
	
	
}
