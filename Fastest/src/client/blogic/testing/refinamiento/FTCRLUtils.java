package client.blogic.testing.refinamiento;

import java.io.IOException;
import java.util.HashMap;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import client.blogic.testing.refinamiento.FTCRLParser.SExprRefinementContext;


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
			map.put(reg[0].replaceAll(" ", ""),reg[1].substring(0, reg[1].length()-2).replaceAll(" ", ""));
			i++;
		}
		//la ultima linea no tiene "\\"
		reg = lineas[i].split("=");
		//si no tiene nada en el where
		if (reg.length == 2)
			map.put(reg[0].replaceAll(" ", ""),reg[1].replaceAll(" ", ""));
		
		return map;
	}
	
	
	//Esta función debe calcular el valor de una expresión FTCRL como
	// xs ++ ys, o xs.@RAN, etc.
	//Para obtener el valor, debe utilizar el caso de prueba y asi obtener
	//los valores de xs e ys
	private static String resolverSExp(String e,Replacement replacement, HashMap<String,String> zValuesMap) throws IOException{
		
		ANTLRInputStream in = new ANTLRInputStream(e);
		FTCRLLexer lexer = new FTCRLLexer(in);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		FTCRLParser parser = new FTCRLParser(tokens);

		ParseTree tree = parser.sExprRefinement();
		
		FTCRLJavaVisitor visitor = new FTCRLJavaVisitor();
		return visitor.visitSExprRefinement((SExprRefinementContext) tree,replacement,zValuesMap);
	}
//	private static String remplazo(String expr, String var, String value){
//		//remplaza en expr, cada vez que aparece var por value
//		//tiene en cuenta ej: expr = xsxs++xs; var = xs; value = (1,2)
//		//salida es = xsxs++(1,2)
//		Pattern pattern = Pattern.compile("(\\W|^)"+var+"(\\W|$)");
//		Matcher matcher = pattern.matcher(expr);
//		return matcher.replaceAll("$1" + value + "$2");
//	}
	public static String sValue(String exp, Replacement replacement, HashMap<String,String> zValuesMap) {
		try {
			return resolverSExp(exp,replacement,zValuesMap);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		String salida ="";
//		salida = remplazo(exp,replacement.exp,replacement.value);
//		
//		Iterator<String> iterator = zValuesMap.keySet().iterator();
//
//		String key,value;
//		while (iterator.hasNext()) {  
//			key = iterator.next().toString();
//			if (zValuesMap.get(key) == null)
//				value = "nullc";
//			else 
//				value = zValuesMap.get(key).toString();
//			salida = remplazo(salida,key,value);  
//		} 
//		
//		salida = resolverSExp(salida);
//		
//		return zValuesMap.get(exp);
		return exp;
		
		//Modificar
		
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
}
