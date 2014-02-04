package client.blogic.testing.refinamiento;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FTCRLUtils {

	public static String sValue(String text) {
		//Hay que modificarla, esta hardcodeada
		return "(\\langle 1 \\rangle \\mapsto str2)";
	}

	public static boolean isSet(String value) {
		//Hay que modificarla, no esta bien esto, hay que parsear la entrada o algo asi
		if (value.startsWith("\\{") && value.endsWith("\\}"))
			return true;
		else
			return  false;
	}

	public static List<String> setElements(String value) {
		//value debe ser un conjunto
		//Hay que modificarla, esta hardcodeada
		
		LinkedList<String> elements = new LinkedList<String>();
		elements.add("(\\langle 1 \\rangle \\mapsto str2)");
		
		return elements;
	}

	public static String getType(String refS) {
		//Hay que modificarla, esta hardcodeada
		
		return "String";
	}

	public static String recordType(String refS) {
		//Hay que controlarla
		return refS.split("[.]", 2)[0];
	}

	public static String recordAtribute(String refS) {
		//Hay que controlarla
		String[] split = refS.split("[.]", 2);
		if (split.length > 1) //Tiene atributo
			return "." + split[1];
		else
			return "";
	}

	public static boolean isArray(String text) {
		return text.equals("ARRAY");
	}
	
	public static boolean isRecord(String text) {
		return text.equals("RECORD");
	}

	public static List<String> refineFromZToJava(String ZValue) {
		// Esta hardcodeada, debería devolver una lista de nodos,
		//deberia tomar como argumento un valor en Z, y generar una lista con los valores refinados
		List<String> returnL = new ArrayList<String>();
		returnL.add("el refinamiento de: " + ZValue);
		return returnL;
	}

}
