package client.blogic.testing.refinamiento;

public class Replacement {

	String exp = ""; //Expresion FTRCL
	String value = ""; //Valor de la expresion
	public String type = ""; //El tipo de la expresion

	Replacement(String exp, String value, String type){
		this.exp = exp; //clients
		this.value = value; //(1,2)
		this.type = type; //\cross(\num,\num)
	}

}
