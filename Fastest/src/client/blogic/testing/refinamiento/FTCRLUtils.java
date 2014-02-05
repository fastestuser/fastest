package client.blogic.testing.refinamiento;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class FTCRLUtils {

	//Crea un map con los valores de las variables de Z, a partir del caso de prueba
	public static HashMap<String, String> createZValuesMap(String tcase){
		
		HashMap<String, String> map = new HashMap<String, String>();
		String lineas[] = tcase.split("\\where");
		//si no tiene where
		if (lineas.length == 1) return map;
		
		
		lineas = lineas[1].split("\\n");
		int i = 1;
		String[] reg = null;
		
		//la ultima linea siempre es "\\end{schema}"
		while (i < lineas.length -2){
			reg = lineas[i].split("=");
			map.put(reg[0],reg[1].substring(0, reg[1].length()-2));
			i++;
		}
		//la ultima linea no tiene "\\"
		reg = lineas[i].split("=");
		//si no tiene nada en el where
		if (reg.length == 2)
			map.put(reg[0],reg[1]);
		
		return map;
	}
	
	//Esta función debe calcular el valor de una expresión FTCRL como
	// xs ++ ys, o xs.@RAN, etc.
	//Para obtener el valor, debe utilizar el caso de prueba y asi obtener
	//los valores de xs e ys
	public static String sValue(String exp, HashMap<String,String> zValuesMap) {

		//Me fijo si es unicamente una variable de Z, si es así,
		//solo debo buscar su valor
		
		if (exp.equals("xs.@RAN"))
			return zValuesMap.get("xsRan");
		
		//Modificar
		
		return "\\{(\\langle 1 \\rangle \\mapsto str2), (joa)\\}";
	}

	//Determina si 'value' es un conjunto. Como entrada toma un valor, no una expresion FTCRL.
	public static boolean isSet(String value) {
		//Creo que con chequear el inicio y el final es suficiente, porque una expresión de la forma
		// { ...} ... {...} no debería llegar como argumenta, ya que pide un valor y no una expresion.
		if (value.startsWith("\\{") && value.endsWith("\\}"))
			return true;
		else
			return  false;
	}

	//Determina la clase en Java que representa 'refS'
	//Por ejemplo, si la entrada es "A.name" donde A sería una clase
	//y name un atributo de la misma, retorna "A"
	public static String recordType(String refS) {
		return refS.split("[.]", 2)[0];
	}

	//Determina el atributo en Java que se utiliza en 'refS'
	//Por ejemplo, si la entrada es "A.name" donde A sería una clase
	//y name un atributo de la misma, retorna ".name"
	public static String recordAtribute(String refS) {
		//Hay que controlarla.
		//Hay que devolver todos los atributos si tiene varios?
		//o solo el primero?
		String[] split = refS.split("[.]", 2);
		if (split.length > 1) //Tiene atributo
			return "." + split[1];
		else
			return "";
	}

	//Determina si es un ARRAY de FTCRL, se utiliza dentro de los AsRefinement
	public static boolean isArray(String text) {
		return text.equals("ARRAY");
	}

	//Determina si es un RECORD de FTCRL, se utiliza dentro de los AsRefinement
	public static boolean isRecord(String text) {
		return text.equals("RECORD");
	}

	//Refina el zValue a su valor correspondiente en Java
	public static List<String> refineFromZToJava(String ZValue) {
		// Esta hardcodeada, debería devolver una lista de nodos,
		//deberia tomar como argumento un valor en Z, y generar una lista con los valores refinados
		List<String> returnL = new ArrayList<String>();
		returnL.add("el refinamiento de: " + ZValue);
		return returnL;
	}

}
