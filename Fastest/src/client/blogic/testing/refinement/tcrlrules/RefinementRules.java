package client.blogic.testing.refinement.tcrlrules;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

import client.blogic.testing.refinement.FTCRLRefExtractorVisitor;


public final class RefinementRules {
	
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
	
	public Iterator<RefinementRule> getRefRuleIterator(){
		return rules.values().iterator();
	}
	
	public Iterator<String> getRefRuleNames(){
		return rules.keySet().iterator();
	}
	
	public void clear(){
		rules.clear();
	}
	
	public int size(){
		return rules.size();
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
	public void deleteRule(String ruleName) {
		rules.remove(ruleName);
		
	}
	
	
}
