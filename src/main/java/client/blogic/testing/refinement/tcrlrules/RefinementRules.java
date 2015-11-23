package client.blogic.testing.refinement.tcrlrules;

import client.blogic.testing.refinement.FTCRLRefExtractorVisitor;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;


public class RefinementRules {

    private final HashMap<String, RefinementRule> rules;
    private final LinkedList<String> referencedVars;

    public static RefinementRules getInstance() {
        return RefinementRulesHolder.instance;
    }

    private RefinementRules() {
        rules = Maps.newHashMap();
        referencedVars = Lists.newLinkedList();
    }

    private static final class RefinementRulesHolder {
        static final RefinementRules instance = new RefinementRules();
    }

    public void addRule(String ruleName, RefinementRule rule) {
        rules.put(ruleName, rule);
    }

    public RefinementRule getRule(String ruleName) {
        return rules.get(ruleName);
    }

    public Iterator<String> getRefRuleNames() {
        return rules.keySet().iterator();
    }

    public void clear() {
        rules.clear();
    }

    public int size() {
        return rules.size();
    }

    public boolean isEmpty() {
        return rules.isEmpty();
    }

    public LinkedList<String> getReferencedVars() {
        return referencedVars;
    }

    public void generateReferencedVars(String ruleName) {
        RefinementRule rule = rules.get(ruleName);
        if (rule != null) {
            FTCRLRefExtractorVisitor visitor = new FTCRLRefExtractorVisitor();
            visitor.visit(rule.getTree());
            referencedVars.addAll(visitor.getReferencedVars());
        }
    }

    public void deleteRule(String ruleName) {
        rules.remove(ruleName);
    }
}
