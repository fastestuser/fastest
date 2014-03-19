//Esta clase define las reglas de refinamiento para refinar desde el lenguaje Z
//una expresion de tipo básico. Cada método define el comportamiento basandose
//en el tipo en Java y FTCRL de la variable a la que se refina

package client.blogic.testing.refinamiento.basicrefinement;

import java.util.List;

import client.blogic.testing.refinamiento.FTCRLJavaVisitor;
import client.blogic.testing.refinamiento.FTCRLParser.EnumerationContext;
import client.blogic.testing.refinamiento.FTCRLParser.SNameContext;
import client.blogic.testing.refinamiento.FTCRLUtils;
import client.blogic.testing.refinamiento.SExpr;

public class FreeTypesRefinement {

	private static String[] values;
	private static EnumerationContext context;


	public static String refine(SExpr zExpr, String values, SExpr javaExpr, EnumerationContext enumerationContext, FTCRLJavaVisitor ftcrl){

		//LLenamos una lista con los valores primero
		FreeTypesRefinement.values = values.split(",");

		//Guardamos el contenido del Enumeration Context
		FreeTypesRefinement.context = enumerationContext;

		String value = refineTo(zExpr, javaExpr);
		//Si hay una variable en Java a utilizar, le asigno el valor refinado, y devuelvo la variable como salida 
		if ((javaExpr != null) && (javaExpr.exp != "")) {
			ftcrl.printAssignment(javaExpr.exp + " = " + value);
			FTCRLUtils.saveReference(javaExpr.exp, zExpr.exp, ftcrl.references, ftcrl.isRef);
		}
		//Y sino devuelvo el valor refinado en vez de la variable Java
		return value;
	}

	private static String refineTo(SExpr zExpr, SExpr javaExpr){
		if (javaExpr.type.equals("String"))
			return "\"" + zExpr.exp + "\"";

		else if (FTCRLUtils.isEnumJava(javaExpr.type)){
			if (context != null){
				List<SNameContext> snames = context.sName();
				if (snames.isEmpty())
					return zExpr.exp;
				else {
					int pos = 0;
					for (; pos < snames.size(); pos++)
						if (snames.get(pos).getText().equals(zExpr.exp))
							break;
					if (pos >= context.iName().size())
						return ""; //Error!
					return context.iName(pos).getText();
				}
			}
		} else if (javaExpr.type.equals("int") || javaExpr.type.equals("short") ||
				javaExpr.type.equals("long") || javaExpr.type.equals("byte") ||
				javaExpr.type.equals("Integer") || javaExpr.type.equals("Short") ||
				javaExpr.type.equals("Long") || javaExpr.type.equals("Byte")){
			if (context != null){
				if (context.sName().isEmpty()){ //Estoy en el caso ENUM[m]
					int m = Integer.parseInt(context.number(0).getText());
					int k = 0;
					while (!values[k].equals(zExpr.exp))
						k++;
					return Integer.toString(k + m);
				} else { //Estoy en el caso ENUM[c1 > n1 ... cn > nn]
					List<SNameContext> snames = context.sName();
					int pos = 0;
					for (; pos < snames.size(); pos++)
						if (snames.get(pos).getText().equals(zExpr.exp))
							break;
					if (pos >= context.number().size())
						return ""; //Error!
					return context.number(pos).getText();
				}
				
			}
		} else if (javaExpr.type.equals("char") || javaExpr.type.equals("Character")){
			String value = "";
			if (context != null){
				if (context.sName().isEmpty()){ //Estoy en el caso ENUM[m]
					int m = Integer.parseInt(context.number(0).getText());
					int k = 0;
					while (!values[k].equals(zExpr.exp))
						k++;
					value = Integer.toString(k + m);
				} else { //Estoy en el caso ENUM[c1 > n1 ... cn > nn]
					List<SNameContext> snames = context.sName();
					int pos = 0;
					for (; pos < snames.size(); pos++)
						if (snames.get(pos).getText().equals(zExpr.exp))
							break;
					if (pos >= context.number().size())
						return ""; //Error!
					value = context.number(pos).getText();
				}
				
			}
			//Convertimos a char el valor del entero
			zExpr.exp = value;
			return NumRefinement.refineTo(zExpr, javaExpr);
		}

		return "";

	}
}
