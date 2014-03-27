//Esta clase define las reglas de refinamiento para refinar desde el lenguaje Z
//una expresion de tipo conjunto. Cada método define el comportamiento basandose
//en el tipo en Java y FTCRL de la variable a la que se refina

package client.blogic.testing.refinamiento.basicrefinement;

import common.util.ExprIterator;
import client.blogic.testing.refinamiento.FTCRLJavaVisitor;
import client.blogic.testing.refinamiento.FTCRLUtils;
import client.blogic.testing.refinamiento.SExpr;

public class CrossProductRefinement {

	public static String refine(SExpr zExpr, String toType, SExpr javaExpr, FTCRLJavaVisitor ftcrl){

		if (toType.equals("TABLE") && ftcrl.currentTable != null){
			
			//Debemos refinar cada elemento de la tupla a una columna de la tabla
			String tuple = zExpr.exp;
			tuple = tuple.replaceFirst("\\(", "{");
			tuple = tuple.replaceFirst("\\)", "}");
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
		}
		return "";
	}
}
