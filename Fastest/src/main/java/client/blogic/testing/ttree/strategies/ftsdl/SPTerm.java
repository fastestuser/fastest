package client.blogic.testing.ttree.strategies.ftsdl;

public class SPTerm
{
	private String op = ""; // Operator to use in SP.
	private String exp = ""; // Expression to use in SP.
	
	public SPTerm(String operator, String expression)
	{
		this.op = operator;
		this.exp = expression;
	}
	
	public String getOp()
	{
		return op;
	}
	
	public String getExp()
	{
		return exp;
	}

}
