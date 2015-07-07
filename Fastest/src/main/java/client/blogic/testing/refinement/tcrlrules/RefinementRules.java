package client.blogic.testing.refinement.tcrlrules;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

import client.blogic.testing.refinement.FTCRLRefExtractorVisitor;


public final class RefinementRules {
	
	private static HashMap<String,RefinementRule> rules;
	private static LinkedList<String> referencedVars;
	
	public static void instance(){
		if (rules == null)
			rules = new HashMap<String,RefinementRule>();
	}
	
	public static void addRule(String ruleName,RefinementRule rule){
		rules.put(ruleName, rule);
	}
	public static RefinementRule getRule(String ruleName){
		return rules.get(ruleName);
	}
	
	public static Iterator<RefinementRule> getRefRuleIterator(){
		return rules.values().iterator();
	}
	
	public static Iterator<String> getRefRuleNames(){
		return rules.keySet().iterator();
	}
	
	public static void clear(){
		rules.clear();
	}
	
	public static int size(){
		return rules.size();
	}
	
	public static boolean isEmpty(){
		return rules.isEmpty();
	}
	
	public static LinkedList<String> getReferencedVars(){
		return referencedVars;
	}
	public static void generateReferencedVars(String ruleName){
		RefinementRule rule = rules.get(ruleName);
		if (rule != null){
			FTCRLRefExtractorVisitor visitor = new FTCRLRefExtractorVisitor();
			visitor.visit(rule.getTree());
			referencedVars = visitor.getReferencedVars();
		}
	}
	public static void deleteRule(String ruleName) {
		rules.remove(ruleName);
		
	}
	
	
}
