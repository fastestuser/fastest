package client.blogic.testing.ttree.strategies.ftsdl;

import java.util.HashMap;

import client.blogic.testing.ttree.strategies.ftsdl.Values.NodeValue;


public class EstrategyLoaderVisitor extends FTSDLBaseVisitor<NodeValue>
{	
	private HashMap<String,FTSDLParser.StrategyContext> strategies = new HashMap<String, FTSDLParser.StrategyContext>();

	public HashMap<String, FTSDLParser.StrategyContext> getStrategies()
	{
		return strategies;
	}

	@Override
	public NodeValue visitStrategy(FTSDLParser.StrategyContext ctx)
	{
		strategies.put(ctx.IDENTIFIER().getText(), ctx);
		
		return null;
	}
}