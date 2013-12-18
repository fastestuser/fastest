package client.blogic.testing.refinamiento;

public class FTCRLJavaVisitor extends FTCRLBaseVisitor<Value> {
    
	@Override
	public Value visitRefinementLaw(FTCRLParser.RefinementLawContext ctx){
		System.out.println(ctx.getText());
		return null;
	}
	
	@Override
	public Value visitName(FTCRLParser.NameContext ctx){
		System.out.println(ctx.getText());
		return null;
	}
	
	@Override
	public Value visitSName(FTCRLParser.SNameContext ctx){
		System.out.println(ctx.getText());
		return null;
	}
}