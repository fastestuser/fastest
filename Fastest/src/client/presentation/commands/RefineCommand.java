package client.presentation.commands;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import common.repository.AbstractIterator;
import common.repository.AbstractRepository;
import common.repository.ConcreteRepository;
import compserver.tcasegen.strategies.setlog.SetLogGenerator;
import client.blogic.management.Controller;
import client.blogic.testing.refinamiento.FTCRLJavaVisitor;
import client.blogic.testing.refinamiento.FTCRLLexer;
import client.blogic.testing.refinamiento.FTCRLParser;
import client.blogic.testing.ttree.strategies.TTreeStrategy;
import client.blogic.testing.ttree.tactics.Tactic;
import client.presentation.ClientTextUI;

/**
 * An instance of this class refine the abstract test case
 * 
 * @author Joaquin Oscar Mesuro
 */
public class RefineCommand implements Command {

	@Override
	public void run(ClientTextUI clientTextUI, String args) {
		PrintWriter output = clientTextUI.getOutput();
		if (!args.equals("")) {
			output.println("Invalid parameters.  Try 'help'.");
		} else {

			String caso = leerCaso();
			System.out.println(leerRegla(caso));
		}
	}

	private String leerCaso() {
		try {
			// Abrimos el archivo
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
			return strLinea;
			
		} catch (Exception e) { // Catch de excepciones
			System.out.println("Ocurrio un error: " + e.getMessage());
		}
		return "null";
	}
	
	private String leerRegla(String tcase) {
		try {
			//Llamamos a ANTLR
			
			URL location = SetLogGenerator.class.getProtectionDomain().getCodeSource().getLocation();
			String path = location.getFile();
			if (path.endsWith("/")) //Al correrlo desde eclipse, el path termina en /bin/, con lo cual se elimina primero la ultima /
				path = path.substring(0, path.lastIndexOf("/"));
			path = path.substring(0, path.lastIndexOf("/")); //Luego, se elimina la ultima parte del path, ya sea /bin o /fastest.jar si se esta corriendo desde un jar
			path = URLDecoder.decode(path, "UTF-8");
			
			InputStream in = new FileInputStream(path + "/RefinementLaws");
			ANTLRInputStream input = new ANTLRInputStream(in );
			FTCRLLexer lexer = new FTCRLLexer(input);
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			FTCRLParser parser = new FTCRLParser(tokens);

			ParseTree tree = parser.refinementRule();
			
			FTCRLJavaVisitor visitor = new FTCRLJavaVisitor();
			visitor.assignTCase(tcase);
			visitor.visit(tree);
			
			
			return "";
			
		} catch (Exception e) { // Catch de excepciones
			System.out.println("Ocurrio un error: " + e.getMessage());
		}
		return "null";
	}
}
