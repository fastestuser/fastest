package client.blogic.testing.refinement;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.LinkedList;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RuleContext;

import client.blogic.testing.refinement.FTCRLParser.RefinementRuleContext;


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
	
	public void resolveLawsReferences(){
		Iterator<String> it = rules.keySet().iterator();
		RefinementRuleContext ruleContext;
		ANTLRInputStream input;
		String ruleString,ruleName;
		FTCRLLexer lexer;
		CommonTokenStream tokens;
		RefinementRule rule;
		while (it.hasNext()){
			ruleName = it.next();
			rule = rules.get(ruleName);
			ruleContext = rule.getTree();
			ruleString = ruleContext.accept(new FTCRLPreprocVisitor(ruleContext));
			input = new ANTLRInputStream(ruleString);
			lexer = new FTCRLLexer(input);
			tokens = new CommonTokenStream(lexer);
			ruleContext = new FTCRLParser(tokens).refinementRule();
			rule.setTree(ruleContext);
		}
	}
	
	public void addRule(String ruleName,RefinementRule rule){
		rules.put(ruleName, rule);
	}
	public RefinementRule getRule(String ruleName){
		return rules.get(ruleName);
	}
	
	public void clear(){
		rules.clear();
	}
	
	public int size(){
		return rules.size();
	}
	
	public Set<String> getRefRuleNames(){
        return rules.keySet();
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
