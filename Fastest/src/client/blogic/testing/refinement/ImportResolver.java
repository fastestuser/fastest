package client.blogic.testing.refinement;

import java.io.PrintWriter;
import client.blogic.testing.refinement.java.ImportResolverJava;

public abstract class ImportResolver {
	public abstract String resolver(String preamble,String uutPath, PrintWriter out);
	
	public static ImportResolver getResolver(String lenguaje){
		if (lenguaje.equals("Java")){
			return new ImportResolverJava();
		}
		return null;
	}
}
