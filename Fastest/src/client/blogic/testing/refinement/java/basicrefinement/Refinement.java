package client.blogic.testing.refinement.java.basicrefinement;

import client.blogic.testing.refinement.FTCRLUtils;
import client.blogic.testing.refinement.SExpr;
import client.blogic.testing.refinement.java.FTCRLtoJavaVisitor;

public abstract class Refinement {

	public String refine(SExpr zExpr, String toType, SExpr javaExpr, FTCRLtoJavaVisitor ftcrl) {
		//Si es un file, modificamos el javaExpr para que sea un String
		if (toType.equals("FILE")){
			return  refineTo(zExpr, new SExpr("", "String"));
		}
		
		String value = refineTo(zExpr, javaExpr);
		if (value.equals("")){
			ftcrl.addWarning(GenericJavaValue.getWarning(zExpr, javaExpr));
			value = GenericJavaValue.getValue(javaExpr.type);
		}
		
		//Si es una tabla, debo guardar el valor en la tabla
		String parts[] = javaExpr.exp.split("\\.");
		String table = "";
		String column = "";
		if (parts.length == 3 && parts[0].equals(ftcrl.testingVar)){
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
	
	public String refineTo(SExpr zExpr, SExpr javaExpr) {return "";}
	
}