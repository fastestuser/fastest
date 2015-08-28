package client.blogic.testing.ttree.strategies.ftsdl;

public class FTTerm
{
	private String exp = "";   // Expression to use in FT tactic.
	
	public FTTerm(String expression)
	{
		this.exp = expression;
	}
	
	public String getExp()
	{
		return exp;
	}
}
