//Esta clase define las reglas de refinamiento para refinar desde el lenguaje Z
//una expresion de tipo numérico. Cada método define el comportamiento basandose
//en el tipo en Java y FTCRL de la variable a la que se refina

package client.blogic.testing.refinamiento.basicrefinement;

import client.blogic.testing.refinamiento.FTCRLJavaVisitor;
import client.blogic.testing.refinamiento.SExpr;

public class NumRefinement {
	
	public static String refine(SExpr zExpr, String toType, SExpr javaExpr, FTCRLJavaVisitor ftcrlJavaVisitor){
		if (javaExpr != null) {
			ftcrlJavaVisitor.printAssignment(javaExpr.exp + " = " + zExpr.exp);
			return javaExpr.exp;
		} else {
			return zExpr.exp;
		}
		
	}

}
