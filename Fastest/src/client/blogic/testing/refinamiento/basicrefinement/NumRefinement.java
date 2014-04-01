//Esta clase define las reglas de refinamiento para refinar desde el lenguaje Z
//una expresion de tipo numérico. Cada método define el comportamiento basandose
//en el tipo en Java y FTCRL de la variable a la que se refina

package client.blogic.testing.refinamiento.basicrefinement;

import client.blogic.testing.refinamiento.FTCRLJavaVisitor;
import client.blogic.testing.refinamiento.FTCRLUtils;
import client.blogic.testing.refinamiento.SExpr;

public class NumRefinement {

	public static String refine(SExpr zExpr, String toType, SExpr javaExpr, FTCRLJavaVisitor ftcrl){

		String value = refineTo(zExpr, javaExpr);

		//Si es una tabla, debo guardar el valor en la tabla
		String parts[] = javaExpr.exp.split("\\.");
		String table = "";
		String column = "";
		if (parts[0].equals(ftcrl.testingVar)){
			table = parts[1];
			column = parts[2];
		} else {
			table = parts[0];
			column = parts[1];
		}

		if (ftcrl.currentTable != null && ftcrl.currentTable.t.equals(table)){//Puede ser una tabla
			ftcrl.currentTable.saveValues(value, column);
		
		} else if ((value != "") && (javaExpr != null) && (javaExpr.exp != "")) {
			//Si hay una variable en Java a utilizar, le asigno el valor refinado, y devuelvo la variable como salida
			ftcrl.printAssignment(javaExpr.exp + " = " + value);
			ftcrl.references.put(javaExpr.exp, value);
			FTCRLUtils.saveReference(javaExpr.exp, value, ftcrl);
		}
		
		//Y sino devuelvo el valor refinado en vez de la variable Java
		return value;
	}

	public static String refineTo(SExpr zExpr, SExpr javaExpr){

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
			return "'" + (char)(int)Float.parseFloat(zExpr.exp) + "'";

		} else if  (javaExpr.type.equals("Character")){

			//Convertimos a char el valor del entero
			return "new Character('" + (char)(int)Float.parseFloat(zExpr.exp) + "')";

		} else if (javaExpr.type.equals("String")){

			return "new String(\"" + zExpr.exp + "\")";

		} else if (FTCRLUtils.isEnumJava(javaExpr.type)){

			//Debemos obtener el n-esimo elemento de enum
			int n = (int)Float.parseFloat(zExpr.exp);
			return javaExpr.type + "." + FTCRLUtils.getEnumJavaElem(javaExpr.type, n);
		}


		return "";

	}
}
