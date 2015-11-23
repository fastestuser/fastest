//Esta clase define las reglas de refinamiento para refinar desde el lenguaje Z
//una expresion de tipo numérico. Cada método define el comportamiento basandose
//en el tipo en Java y FTCRL de la variable a la que se refina

package client.blogic.testing.refinement.java.basicrefinement;

import client.blogic.testing.refinement.FTCRLUtils;
import client.blogic.testing.refinement.SExpr;

public class NumRefinement extends Refinement{

	String refineTo(SExpr zExpr, SExpr javaExpr){

		if (javaExpr.type.equals("int") || javaExpr.type.equals("short") ||
				javaExpr.type.equals("long") || javaExpr.type.equals("byte")) {

			return Integer.toString((int)Float.parseFloat(zExpr.exp));

		} else if (javaExpr.type.equals("Integer") || javaExpr.type.equals("Short") ||
				javaExpr.type.equals("Long") || javaExpr.type.equals("Byte")){

			return "new " + javaExpr.type + "(" + Integer.toString((int)Float.parseFloat(zExpr.exp)) + ")";

		} else if (javaExpr.type.equals("float") || javaExpr.type.equals("double")){

			return zExpr.exp;

		} else if (javaExpr.type.equals("Float") || javaExpr.type.equals("Double")) {

			return "new " + javaExpr.type + "(" + zExpr.exp + ")";

		} else if (javaExpr.type.equals("char")){

			//Convertimos a char el valor del entero
			return "'" + (char) (32 + (Integer.parseInt(zExpr.exp) % 95)) + "'";

		} else if  (javaExpr.type.equals("Character")){

			//Convertimos a char el valor del entero
			return "new Character('" + (char)(int)Float.parseFloat(zExpr.exp) + "')";

		} else if (javaExpr.type.equals("String")){

			return "\"" + zExpr.exp + "\"";

		} else if (FTCRLUtils.isEnumCodeType(javaExpr.type)){

			//Debemos obtener el n-esimo elemento de enum
			int n = (int)Float.parseFloat(zExpr.exp);
			return javaExpr.type + "." + FTCRLUtils.getEnumCodeTypeElem(javaExpr.type, n);
		}
		return "";

	}
}
