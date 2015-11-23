package client.blogic.testing.ttree.strategies.ftsdl;

public class NRTerm
{
	private String exp = "";   // Expression to use in NR.
	private String zType = ""; // Type of the expression in the specification.
	
	public NRTerm(String expression, String zType)
	{
		this.exp = expression;
		this.zType = zType;
	}
	
	public String getExp()
	{
		return exp;
	}
	
	public String getRan()
	{
		//TODO: des-harcodear esto. Pero hay que definir como hacerlo.
		if (zType.equals("\\nat"))
		{
			return "\\langle 0, 4294967295\\rangle";
		}
		else
		{
			return "\\langle -2147483648, 2147483647\\rangle";
		}
	}
}
