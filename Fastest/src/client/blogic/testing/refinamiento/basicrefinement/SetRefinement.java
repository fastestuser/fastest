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
		//Obtenemos los elementos del conjunto y determinamos el tipo de los elementos
		Iterator<String> itElements = new common.util.ExprIterator(zExpr.exp);
		String elemType = "\\num";
		while (itElements.hasNext()){
			SExpr zElemExpr = new SExpr(itElements.next(), elemType);
			ftcrl.printAssignment(javaExpr.exp + ".add(" + ftcrl.refineFromZToJava(zElemExpr, "BASIC", null) + ")");
		}
		return javaExpr.exp;
		
	}

}
