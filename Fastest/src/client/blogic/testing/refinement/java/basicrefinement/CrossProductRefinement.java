//Esta clase define las reglas de refinamiento para refinar desde el lenguaje Z
//una expresion de tipo cross product. Cada método define el comportamiento basandose
//en el tipo en Java y FTCRL de la variable a la que se refina

package client.blogic.testing.refinement.java.basicrefinement;

import common.util.ExprIterator;
import client.blogic.testing.refinement.FTCRLUtils;
import client.blogic.testing.refinement.SExpr;
import client.blogic.testing.refinement.java.FTCRLtoJavaVisitor;

public class CrossProductRefinement extends Refinement {

	public String refine(SExpr zExpr, String toType, SExpr javaExpr, FTCRLtoJavaVisitor ftcrl) {

		if (toType.equals("TABLE") && ftcrl.currentTable != null){

			//Debemos refinar cada elemento de la tupla a una columna de la tabla
			String tuple = zExpr.exp;
			tuple = tuple.replaceFirst("\\(", "{");
			tuple = tuple.replaceFirst("\\)$", "}");
			ExprIterator itElements = new common.util.ExprIterator(zExpr.exp);

			//Asumimos que el tamaño de la tupla es el mismo que la cantidad de columnas de la tabla
			if (itElements.cardinalidad() == ftcrl.currentTable.size){
				int column = 0;
				while (itElements.hasNext()){
					//Debemos refinar cada elemento de la tupla a una columna de la tabla
					String elem = itElements.next();
					String elemType = FTCRLUtils.getChildType(zExpr.type, column);

					String columnVar = javaExpr.exp + "." + ftcrl.currentTable.columnName.get(column);
					String columnType = ftcrl.currentTable.columnType.get(column);
					ftcrl.refineFromZToJava(new SExpr(elem, elemType), "Basic", new SExpr(columnVar, columnType));

					column++;
				}
			}
		} else if (toType.equals("FILE")) {

			//Debemos refinar cada elemento de la tupla a una linea del archivo
			String tuple = zExpr.exp;
			tuple = tuple.replaceFirst("\\(", "{");
			tuple = tuple.replaceFirst("\\)", "}");
			ExprIterator itElements = new common.util.ExprIterator(zExpr.exp);

			//El archivo lo obtenemos de la expresión Java
			String fileName = javaExpr.exp;
			String writer = ftcrl.openedFiles.get(fileName);

			int pos = 0;
			while (itElements.hasNext()){
				//Debemos refinar cada elemento de la tupla a una columna de la tabla
				String elem = itElements.next();
				String elemType = FTCRLUtils.getChildType(zExpr.type, pos);
				String value = ftcrl.refineFromZToJava(new SExpr(elem, elemType), "BASIC", new SExpr("", "String"));
				if (!value.equals(""))
					ftcrl.printAssignment(writer+".println(str("+value+"))");

				pos++;
			}
		}
		ftcrl.addWarning(GenericJavaValue.getWarning(zExpr, javaExpr));
		return GenericJavaValue.getValue(javaExpr.type);
	}

	@Override
	String refineTo(SExpr zExpr, SExpr javaExpr) {
		return null;
	}
}
