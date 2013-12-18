package client.presentation.commands;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import common.repository.AbstractIterator;
import common.repository.AbstractRepository;
import common.repository.ConcreteRepository;

import client.blogic.management.Controller;
import client.blogic.testing.ttree.strategies.TTreeStrategy;
import client.blogic.testing.ttree.tactics.Tactic;
import client.presentation.ClientTextUI;

/**
 * An instance of this class refine the abstract test case
 * 
 * @author Joaquin Oscar Mesuro
 */
public class Refine implements Command {

	@Override
	public void run(ClientTextUI clientTextUI, String args) {
		PrintWriter output = clientTextUI.getOutput();
		if (!args.equals("")) {
			output.println("Invalid parameters.  Try 'help'.");
		} else {

			System.out.println(leerCaso());
			System.out.println(leerRegla());
			

		}

	}

	private String leerCaso() {
		try {
			// Abrimos el archivo
			FileInputStream fstream = new FileInputStream(
					"/home/joaquin/workspace/caso.tex");
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
			return strLinea;
			
		} catch (Exception e) { // Catch de excepciones
			System.out.println("Ocurrio un error: " + e.getMessage());
		}
		return "null";
	}
	
	private String leerRegla() {
		try {
			// Abrimos el archivo
			FileInputStream fstream = new FileInputStream(
					"/home/joaquin/workspace/regla.tex");
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
			return strLinea;
			
		} catch (Exception e) { // Catch de excepciones
			System.out.println("Ocurrio un error: " + e.getMessage());
		}
		return "null";
	}
}
