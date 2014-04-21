//Esta clase define las reglas de refinamiento para refinar desde el lenguaje Z
//una expresion de tipo conjunto. Cada método define el comportamiento basandose
//en el tipo en Java y FTCRL de la variable a la que se refina

package client.blogic.testing.refinement.java.basicrefinement;

import java.util.Iterator;

import client.blogic.testing.refinement.FTCRLUtils;
import client.blogic.testing.refinement.SExpr;
import client.blogic.testing.refinement.java.FTCRLtoJavaVisitor;

public class SetRefinement extends Refinement{

	public String refine(SExpr zExpr, String toType, SExpr javaExpr, FTCRLtoJavaVisitor ftcrl){
		//Primero vemos donde hay que almacenar lo que refinaremos
		String javaVar = "";
		if ((javaExpr != null) && (!javaExpr.exp.equals(""))){
			javaVar = javaExpr.exp;
		} else {
			javaVar = ftcrl.newVarName("set");
		}

		//Obtenemos los elementos del conjunto y determinamos el tipo de los elementos
		Iterator<String> itElements = new common.util.ExprIterator(zExpr.exp);
		String zElemType = FTCRLUtils.getChildType(zExpr.type, 0);

		if (toType.equals("LIST")){
			//Obtenemos el tipo de los nodos del conjunto
			String javaElemType = ftcrl.getInnerType(javaExpr.type);
			javaExpr.exp = "";
			javaExpr.type = javaElemType;
			int arrayPos = 0;
			while (itElements.hasNext()){
				SExpr zElemExpr = new SExpr(itElements.next(), zElemType);
				String refinedElem = ftcrl.refineFromZToJava(zElemExpr, "BASIC", javaExpr);
				ftcrl.printAssignment(javaVar + ".add(" + refinedElem + ")");
				FTCRLUtils.saveReference(javaVar + "[" + arrayPos + "]", zElemExpr.exp, zElemExpr.exp, ftcrl);
				arrayPos++;
			}
		} else if (toType.equals("ARRAY")){
			//Obtenemos el tipo de los nodos del conjunto
			String javaElemType = ftcrl.getInnerType(javaExpr.type);
			javaExpr.exp = "";
			javaExpr.type = javaElemType;
			int arrayPos = 0;
			while (itElements.hasNext()){
				SExpr zElemExpr = new SExpr(itElements.next(), zElemType);
				String refinedElem = ftcrl.refineFromZToJava(zElemExpr, "BASIC", javaExpr);
				ftcrl.printAssignment(javaVar + "[" + arrayPos + "] = " + refinedElem);
				FTCRLUtils.saveReference(javaVar + "[" + arrayPos + "]", zElemExpr.exp, zElemExpr.exp, ftcrl);
				arrayPos++;
			}
		} else if (toType.equals("FILE")){
			String file = ftcrl.openedFiles.get(javaExpr.exp);
			while (itElements.hasNext()){
				SExpr zElemExpr = new SExpr(itElements.next(), zElemType);
				String value = "";
				value = ftcrl.refineFromZToJava(zElemExpr, "BASIC", new SExpr("", "String"));
				ftcrl.printAssignment(file + ".println(str("+value+"))");
			}
		}
		return javaVar;

	}
}
