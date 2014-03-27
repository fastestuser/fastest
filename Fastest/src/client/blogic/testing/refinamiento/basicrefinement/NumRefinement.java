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
		int i = javaExpr.exp.lastIndexOf(".");
		String table = "";
		if (i >= 0){
			table = javaExpr.exp.substring(0, i);
		}
		
		if (ftcrl.currentTable != null && ftcrl.currentTable.varName.equals(table)){//Puede ser una tabla
			ftcrl.currentTable.saveValues(value, javaExpr.exp.substring(i+1));
		//Si hay una variable en Java a utilizar, le asigno el valor refinado, y devuelvo la variable como salida 
		} else if ((value != "") && (javaExpr != null) && (javaExpr.exp != "")) {
			ftcrl.printAssignment(javaExpr.exp + " = " + value);
			ftcrl.references.put(javaExpr.exp, value);
			FTCRLUtils.saveReference(javaExpr.exp, value, ftcrl.references, ftcrl.isRef);
		}
		//Y sino devuelvo el valor refinado en vez de la variable Java
		return value;
	}

	public static String refineTo(SExpr zExpr, SExpr javaExpr){

		if (javaExpr.type.equals("int") || javaExpr.type.equals("short") ||
				javaExpr.type.equals("long") || javaExpr.type.equals("byte") ||
				javaExpr.type.equals("Integer") || javaExpr.type.equals("Short") ||
				javaExpr.type.equals("Long") || javaExpr.type.equals("Byte")) {
			return Integer.toString((int)Float.parseFloat(zExpr.exp));
		} else if (javaExpr.type.equals("float") || javaExpr.type.equals("double")
				|| javaExpr.type.equals("Float") || javaExpr.type.equals("Double")){
			return zExpr.exp;
		} else if (javaExpr.type.equals("char") || javaExpr.type.equals("Character")){
			//Convertimos a char el valor del entero
			return "'" + (char)(int)Float.parseFloat(zExpr.exp) + "'";
		} else if (javaExpr.type.equals("String")){
			return "\"" + zExpr.exp + "\"";
		} else if (FTCRLUtils.isEnumJava(javaExpr.type)){
			//Debemos obtener el n-esimo elemento de enum
			int n = (int)Float.parseFloat(zExpr.exp);
			return FTCRLUtils.getEnumJavaElem(javaExpr.type, n);
		}


		return "";

	}
}
