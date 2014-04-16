//Esta clase se utiliza cuando se refina el lado izquierdo y resulta
//ser la aplicación de una funcion
package client.blogic.testing.refinement;

public final class FunAppSExpr extends SExpr{

	public FunAppSExpr(String exp, String type) {
		this.exp = exp;
		this.type = type;
	}

}
