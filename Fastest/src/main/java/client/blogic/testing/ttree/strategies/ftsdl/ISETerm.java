package client.blogic.testing.ttree.strategies.ftsdl;

public class ISETerm
{
	private String exp = "";   // Expression to use in FT tactic.
	
	public ISETerm(String expression)
	{
		this.exp = expression;
	}
	
	public String getExp()
	{
		return exp;
	}
}
