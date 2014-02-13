//Esta clase define las reglas de refinamiento para refinar desde el lenguaje Z
//una expresion de tipo numérico. Cada método define el comportamiento basandose
//en el tipo en Java y FTCRL de la variable a la que se refina

package client.blogic.testing.refinamiento.basicrefinement;

import client.blogic.testing.refinamiento.FTCRLJavaVisitor;
import client.blogic.testing.refinamiento.SExpr;

public class NumRefinement {
	
	public static String refine(SExpr zExpr, String toType, SExpr javaExpr, FTCRLJavaVisitor ftcrl){
		//Si hay una variable en Java a utilizar, le asigno el valor refinado, y devuelvo la variable como salida 
		if (javaExpr != null) {
			ftcrl.printAssignment(javaExpr.exp + " = " + zExpr.exp);
			return javaExpr.exp;
		//Y sino devuelvo el valor refinado en vez de la variable Java
		} else {
			return zExpr.exp;
		}
		
	}

}
