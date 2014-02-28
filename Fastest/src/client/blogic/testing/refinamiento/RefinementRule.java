package client.blogic.testing.refinamiento;

import org.antlr.v4.runtime.tree.ParseTree;

public class RefinementRule {
	private FTCRLParser parser;
	private String preamble;
	
	public RefinementRule(FTCRLParser parser, String preamble){
		this.parser = parser;
		this.preamble = preamble;
	}
	
	public FTCRLParser getParser() {
		return parser;
	}
	public void setParser(FTCRLParser parser) {
		this.parser = parser;
	}
	public String getPreamble() {
		return preamble;
	}
	public void setPreamble(String preamble) {
		this.preamble = preamble;
	}
	
	
}
