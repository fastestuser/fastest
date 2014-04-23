package client.blogic.testing.refinement.java.basicrefinement;

import client.blogic.testing.refinement.SExpr;

public class GenericJavaValue {
	public static String getValue(String type){
		if (type.equals("short")||type.equals("int")||
				type.equals("long")||type.equals("byte")||
				type.equals("double")||type.equals("float")||
				type.equals("char"))
			return "0";
		else 
			return "new " + type + "()";
	}
	public static String getWarning(SExpr zExpr, SExpr javaExpr){
		return "There is not valid translation for var " + javaExpr.exp + " of type " + javaExpr.type + " from value " + zExpr.exp + " of type " + zExpr.type ;
	}
}
