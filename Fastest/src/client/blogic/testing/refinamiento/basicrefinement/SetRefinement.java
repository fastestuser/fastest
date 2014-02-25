//Esta clase define las reglas de refinamiento para refinar desde el lenguaje Z
//una expresion de tipo conjunto. Cada método define el comportamiento basandose
//en el tipo en Java y FTCRL de la variable a la que se refina

package client.blogic.testing.refinamiento.basicrefinement;

import java.util.Iterator;

import client.blogic.testing.refinamiento.FTCRLJavaVisitor;
import client.blogic.testing.refinamiento.FTCRLUtils;
import client.blogic.testing.refinamiento.SExpr;

public class SetRefinement {
	
	public static String refine(SExpr zExpr, String toType, SExpr javaExpr, FTCRLJavaVisitor ftcrl){
		//Primero vemos donde hay que almacenar lo que refinaremos
		String javaVar = "";
		if ((javaExpr != null) && (javaExpr.exp != "")){
			javaVar = javaExpr.exp;
		} else {
			javaVar = "newSetVar"; //Cambiar
		}
		
		//Obtenemos los elementos del conjunto y determinamos el tipo de los elementos
		Iterator<String> itElements = new common.util.ExprIterator(zExpr.exp);
		String zElemType = FTCRLUtils.getChildType(zExpr.type, 0);

		//Obtenemos el tipo de los nodos del conjunto
		String javaElemType = FTCRLUtils.getInnerType(javaExpr.type);
		javaExpr.exp = "";
		javaExpr.type = javaElemType;
		
		while (itElements.hasNext()){
			SExpr zElemExpr = new SExpr(itElements.next(), zElemType);
			ftcrl.printAssignment(javaVar + ".add(" + ftcrl.refineFromZToJava(zElemExpr, "BASIC", javaExpr) + ")");
		}
		return javaVar;
		
	}

}
