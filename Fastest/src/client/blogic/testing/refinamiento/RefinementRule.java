package client.blogic.testing.refinamiento;

import client.blogic.testing.refinamiento.FTCRLParser.RefinementRuleContext;

public class RefinementRule {
	private RefinementRuleContext tree;
	private String preamble;
	
	public RefinementRule(RefinementRuleContext tree, String preamble){
		this.tree = tree;
		this.preamble = preamble;
	}
	
	public RefinementRuleContext getTree() {
		return tree;
	}
	public void setTree(RefinementRuleContext tree) {
		this.tree = tree;
	}
	public String getPreamble() {
		return preamble;
	}
	public void setPreamble(String preamble) {
		this.preamble = preamble;
	}
	
	
}
