package client.blogic.testing.refinamiento;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		FileInputStream fstream = new FileInputStream("/home/joaquin/workspace/Fastest/caso.tex");
		// Creamos el objeto de entrada
		DataInputStream entrada = new DataInputStream(fstream);
		// Creamos el Buffer de Lectura
		BufferedReader buffer = new BufferedReader(new InputStreamReader(
				entrada));

		String strLinea, aux;
		strLinea = "";
		// Leer el archivo linea por linea
		while ((aux = buffer.readLine()) != null) {
			strLinea = strLinea + "\n" + aux;
			// Imprimimos la línea por pantalla

		}
		entrada.close();
		
		FTCRLUtils.createZValuesMap(strLinea);

	}

}
