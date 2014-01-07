package client.blogic.testing.refinamiento;

import java.util.LinkedList;
import java.util.List;

public class FTCRLUtils {

	public static String sValue(String text) {
		//Hay que modificarla, esta hardcodeada
		return "\\{ 1,2,3,4\\}";
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
		elements.add("1");
		elements.add("2");
		elements.add("3");
		elements.add("4");
		
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

}
