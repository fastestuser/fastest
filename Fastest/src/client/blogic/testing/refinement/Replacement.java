package client.blogic.testing.refinement;

public class Replacement {

	public String exp = ""; //Expresion FTRCL
	public String value = ""; //Valor de la expresion
	public String type = ""; //El tipo de la expresion

	public Replacement(String exp, String value, String type){
		this.exp = exp; //clients
		this.value = value; //(1,2)
		this.type = type; //\cross(\num,\num)
	}

}
