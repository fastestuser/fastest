//Esta clase define las reglas de refinamiento para refinar desde el lenguaje Z
//una expresion de tipo numérico. Cada método define el comportamiento basandose
//en el tipo en Java y FTCRL de la variable a la que se refina

package client.blogic.testing.refinamiento.basicrefinement;

import client.blogic.testing.refinamiento.FTCRLJavaVisitor;
import client.blogic.testing.refinamiento.FTCRLUtils;
import client.blogic.testing.refinamiento.SExpr;

public class FTCRLStringRefinement {

	public static String refine(SExpr zExpr, String toType, SExpr javaExpr, FTCRLJavaVisitor ftcrl){

		String value = refineTo(zExpr, javaExpr);
		//Si hay una variable en Java a utilizar, le asigno el valor refinado, y devuelvo la variable como salida 
		if ((javaExpr != null) && (javaExpr.exp != "")) {
			ftcrl.printAssignment(javaExpr.exp + " = " + value);
			ftcrl.references.put(javaExpr.exp, value);
			FTCRLUtils.saveReference(javaExpr.exp, value, ftcrl.references, ftcrl.isRef);
		}
		//Y sino devuelvo el valor refinado en vez de la variable Java
		return value;
	}

	public static String refineTo(SExpr zExpr, SExpr javaExpr){
		if (javaExpr.type.equals("String")){
			return "\"" + zExpr.exp + "\"";
		} 		

		return "";

	}
}
