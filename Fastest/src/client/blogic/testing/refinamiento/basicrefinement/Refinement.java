package client.blogic.testing.refinamiento.basicrefinement;

import client.blogic.testing.refinamiento.FTCRLJavaVisitor;
import client.blogic.testing.refinamiento.FTCRLUtils;
import client.blogic.testing.refinamiento.SExpr;

public abstract class Refinement {

	public String refine(SExpr zExpr, String toType, SExpr javaExpr, FTCRLJavaVisitor ftcrl){

		//Si es un file, modificamos el javaExpr para que sea un String
		if (toType.equals("FILE"))
			return  refineTo(zExpr, new SExpr("", "String"));
		
		String value = refineTo(zExpr, javaExpr);

		//Si es una tabla, debo guardar el valor en la tabla
		String parts[] = javaExpr.exp.split("\\.");
		String table = "";
		String column = "";
		if (parts[0].equals(ftcrl.testingVar) && parts.length == 3){
			table = parts[1];
			column = parts[2];
		} else if (parts.length == 2){
			table = parts[0];
			column = parts[1];
		}

		if (ftcrl.currentTable != null && ftcrl.currentTable.t.equals(table)){//Puede ser una tabla
			ftcrl.currentTable.saveValues(value, column);

		} else if ((value != "") && (javaExpr != null) && (javaExpr.exp != "")) {
			//Si hay una variable en Java a utilizar, le asigno el valor refinado, y devuelvo la variable como salida
			ftcrl.printAssignment(javaExpr.exp + " = " + value);
			//ftcrl.references.put(javaExpr.exp, value);
			FTCRLUtils.saveReference(javaExpr.exp, zExpr.exp, value, ftcrl);
		}

		//Y sino devuelvo el valor refinado en vez de la variable Java
		return value;
	}
	
	public String refineTo(SExpr zExpr, SExpr javaExpr){return "";}
	
}