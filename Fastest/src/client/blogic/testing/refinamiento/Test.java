package client.blogic.testing.refinamiento;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Test {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
//		FileInputStream fstream = new FileInputStream("/home/joaquin/workspace/Fastest/caso.tex");
//		// Creamos el objeto de entrada
//		DataInputStream entrada = new DataInputStream(fstream);
//		// Creamos el Buffer de Lectura
//		BufferedReader buffer = new BufferedReader(new InputStreamReader(
//				entrada));
//
//		String strLinea, aux;
//		strLinea = "";
//		// Leer el archivo linea por linea
//		while ((aux = buffer.readLine()) != null) {
//			strLinea = strLinea + "\n" + aux;
//			// Imprimimos la línea por pantalla
//
//		}
//		entrada.close();
//		
//		FTCRLUtils.createZValuesMap(strLinea);

		String expr = new String("xs.@#");
		Replacement r = new Replacement("xs", "{(1,2),(2,3)}");
		HashMap<String,String> zValuesMap = new HashMap<String, String>();
		zValuesMap.put("ys", "{(1,a),(2,b)}");
		String e = FTCRLUtils.sValue(expr, r, zValuesMap);
		System.out.println(e);
		
	}

}
