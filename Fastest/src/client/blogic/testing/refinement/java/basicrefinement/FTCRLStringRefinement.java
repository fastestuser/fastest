//Esta clase define las reglas de refinamiento para refinar desde el lenguaje Z
//una expresion de tipo numérico. Cada método define el comportamiento basandose
//en el tipo en Java y FTCRL de la variable a la que se refina

package client.blogic.testing.refinement.java.basicrefinement;

import client.blogic.testing.refinement.SExpr;

public class FTCRLStringRefinement extends Refinement{

	public String refineTo(SExpr zExpr, SExpr javaExpr){
		if (javaExpr.type.equals("String")){
			return "\"" + zExpr.exp + "\"";
		} 		

		return "";
	}
}
