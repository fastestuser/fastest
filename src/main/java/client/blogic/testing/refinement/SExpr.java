//Esta clase es utilizada para pasar informacion de una expresion FTCRL
//donde se indica la expresión, es decir su valor, y el tipo en Z de la misma

package client.blogic.testing.refinement;

public class SExpr {

	public String exp = ""; //Expresion FTRCL
	public String type = ""; //Tipo de la expresion

	public SExpr(String exp, String value){
		this.exp = exp;
		this.type = value;
	}
	public SExpr(){
	}
	
}
