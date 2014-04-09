//Esta clase define las reglas de refinamiento para refinar desde el lenguaje Z
//una expresion de tipo básico. Cada método define el comportamiento basandose
//en el tipo en Java y FTCRL de la variable a la que se refina

package client.blogic.testing.refinamiento.java.basicrefinement;

import java.util.HashMap;

import client.blogic.testing.refinamiento.FTCRLUtils;
import client.blogic.testing.refinamiento.SExpr;

public class GivenTypeRefinement extends Refinement{

	private static HashMap<String, String> bijection = new HashMap<String,String>();
	private static int lastElem = 0;

	public String refineTo(SExpr zExpr, SExpr javaExpr){

		if (javaExpr.type.equals("int") || javaExpr.type.equals("short") ||
				javaExpr.type.equals("long") || javaExpr.type.equals("byte")) {

			return getValue(zExpr.exp);

		} else if (javaExpr.type.equals("Integer") || javaExpr.type.equals("Short") ||
				javaExpr.type.equals("Long") || javaExpr.type.equals("Byte")) {

			return "new " + javaExpr.exp + "(" + getValue(zExpr.exp) + ")";

		} else if (javaExpr.type.equals("float") || javaExpr.type.equals("double")){

			return getValue(zExpr.exp);

		} else if (javaExpr.type.equals("Float") || javaExpr.type.equals("Double")){

			return "new " + javaExpr.exp + "(" + getValue(zExpr.exp) + ")";

		} else if (javaExpr.type.equals("char")){

			//Convertimos a char el valor del entero
			//Pero solo podemos usar algunos enteros, ya que sino no nos da chars validos
			return "'" + (char) (32 + (Integer.parseInt(getValue(zExpr.exp)) % 95)) + "'";

		} else if (javaExpr.type.equals("Character")){

			//Convertimos a char el valor del entero
			//Pero solo podemos usar algunos enteros, ya que sino no nos da chars validos
			return "new Character('" + (char) (32 + (Integer.parseInt(getValue(zExpr.exp)) % 95)) + "')";

		} else if (javaExpr.type.equals("String")){

			return "new String(\"" + zExpr.exp + "\")";

		} else if (FTCRLUtils.isEnumCodeType(javaExpr.type)){

			//Debemos obtener el n-esimo elemento de enum
			int n = Integer.parseInt(getValue(zExpr.exp));
			return javaExpr.type + "." + FTCRLUtils.getEnumCodeTypeElem(javaExpr.type, n);
		}

		return "";

	}

	//Bijection para Tipo basico -> int
	private static String getValue(String s){
		String v = "";
		v = bijection.get(s);
		if (v == null){
			v = Integer.toString(lastElem);
			bijection.put(s, v);
			lastElem++;
		}
		return v;
	}
}
