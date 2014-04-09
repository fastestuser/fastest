//Esta clase define las reglas de refinamiento para refinar desde el lenguaje Z
//una expresion de tipo básico. Cada método define el comportamiento basandose
//en el tipo en Java y FTCRL de la variable a la que se refina

package client.blogic.testing.refinement.java.basicrefinement;

import java.util.List;

import client.blogic.testing.refinement.FTCRLUtils;
import client.blogic.testing.refinement.SExpr;
import client.blogic.testing.refinement.FTCRLParser.EnumerationContext;
import client.blogic.testing.refinement.FTCRLParser.SNameContext;
import client.blogic.testing.refinement.java.FTCRLJavaVisitor;

public class FreeTypesRefinement extends Refinement{

	private static String[] values;
	private static EnumerationContext context;


	public FreeTypesRefinement(EnumerationContext enumerationContext, String values) {
		this.context = enumerationContext;
		this.values = values.split(",");;
		
	}

	public String refineTo(SExpr zExpr, SExpr javaExpr){
		if (javaExpr.type.equals("String"))
			return "\"" + zExpr.exp + "\"";

		else if (FTCRLUtils.isEnumCodeType(javaExpr.type)){
			if (context != null){
				List<SNameContext> snames = context.sName();
				if (snames.isEmpty())
					return javaExpr.type + "." + zExpr.exp;
				else {
					int pos = 0;
					for (; pos < snames.size(); pos++)
						if (snames.get(pos).getText().equals(zExpr.exp))
							break;
					if (pos >= context.iName().size())
						return ""; //Error!
					return javaExpr.type + "." + context.iName(pos).getText();
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
					if (Character.isLowerCase(javaExpr.type.charAt(0)))
						return Integer.toString(k + m);
					else
						return "new " + javaExpr.type + "(" + Integer.toString(k + m) + ")";

				} else { //Estoy en el caso ENUM[c1 > n1 ... cn > nn]
					List<SNameContext> snames = context.sName();
					int pos = 0;
					for (; pos < snames.size(); pos++)
						if (snames.get(pos).getText().equals(zExpr.exp))
							break;
					if (pos >= context.number().size())
						return ""; //Error!
					if (Character.isLowerCase(javaExpr.type.charAt(0)))
						return context.number(pos).getText();
					else
						return "new " + javaExpr.type + "(" + context.number(pos).getText() + ")";
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
			Refinement refinement = new NumRefinement();
			if (Character.isLowerCase(javaExpr.type.charAt(0)))
				return refinement.refineTo(zExpr, javaExpr);
			else
				return "new " + javaExpr.type + "(" + refinement.refineTo(zExpr, javaExpr) + ")";
		}

		return "";

	}
}
