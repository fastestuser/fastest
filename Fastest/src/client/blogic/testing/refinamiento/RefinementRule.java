package client.blogic.testing.refinamiento;

import client.blogic.testing.refinamiento.FTCRLParser.RefinementRuleContext;

public class RefinementRule {
	private RefinementRuleContext tree;
	private String preamble;
	private String epilogue;
	private String plcode;
	
	public RefinementRule(RefinementRuleContext tree, String preamble, String epilogue, String plcode){
		this.tree = tree;
		this.preamble = preamble;
		this.epilogue = epilogue;
		this.plcode = plcode;
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

	public String getPlcode() {
		return plcode;
	}

	public void setPlcode(String plcode) {
		this.plcode = plcode;
	}
	
	
}
