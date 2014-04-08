//Esta clase define las reglas de refinamiento para refinar desde el lenguaje Z
//una expresion de tipo numérico. Cada método define el comportamiento basandose
//en el tipo en Java y FTCRL de la variable a la que se refina

package client.blogic.testing.refinamiento.basicrefinement;

import client.blogic.testing.refinamiento.SExpr;

public class FTCRLStringRefinement extends Refinement{

	public String refineTo(SExpr zExpr, SExpr javaExpr){
		if (javaExpr.type.equals("String")){
			return "new String(\"" + zExpr.exp + "\")";
		} 		

		return "";

	}
}
