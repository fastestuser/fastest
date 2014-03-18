package client.blogic.testing.refinamiento;

import client.blogic.testing.refinamiento.FTCRLParser.RefinementRuleContext;

public class RefinementRule {
	private RefinementRuleContext tree;
	private String preamble;
	private String epilogue;
	
	public RefinementRule(RefinementRuleContext tree, String preamble, String epilogue){
		this.tree = tree;
		this.preamble = preamble;
		this.epilogue = epilogue;
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

	public String getEpilogue() {
		return epilogue;
	}

	public void setEpilogue(String epilogue) {
		this.epilogue = epilogue;
	}
	
	
}
