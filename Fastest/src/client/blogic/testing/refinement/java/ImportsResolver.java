package client.blogic.testing.refinement.java;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


public final class ImportsResolver {

	private  static String path;
	private  static HashSet<String> importsExpandidos;
	private  static StringBuilder imports;
	private  static PrintWriter output;

	private static class Programa{
		public HashSet<String> imports;
		public String codigo;
		public Programa(String programa){
			imports = new HashSet<String>();
			String aux[] = programa.split("import");
			int length = aux.length;
			int i = 1;
			for (i = 1;i<=length-2;i++)
				imports.add(aux[i].replace(" ", "").replace("\n",""));
			String aux2[] = null;
			if (aux.length > 1){
				aux2 = (aux[i]).split(";");
				imports.add(aux2[0].replace(" ", "").replace("\n", "")+";");
				codigo = new String(aux[i].substring((aux2[0]+";").length()));
			}
			else
				codigo = new String(programa);
		}
	}

	//unfoldea un import devuelve el codigo correspondiente
	private static String unfoldImportPath(String importPath,String name) {
		String p = path + importPath.replace("*",name).replace(".", "/").replace(";","") + ".java";
		File file = new File(p.replace(" ", "").replace("\n", ""));
		try {
			FileInputStream fileStream = new FileInputStream(file.getAbsolutePath());
			String fileString = new Scanner(fileStream,"UTF-8").useDelimiter("\\A").next();
			return fileString;
		} catch (FileNotFoundException e) {
			output.println("Warning: Class " + importPath.substring(0, importPath.length()-1) + " not found in path " + 
					file.getAbsolutePath() + "\nmaybe you should change uutpath: " + path);
			return null;
		}
	}

	//devuelve el nombre del path, si termina en *; entonces devuelve todos los javas de la carpeta
	private  static Iterator<String> getImportNames(String importPath){
		List<String> l = new ArrayList<String>();
		if (importPath.endsWith("*;")){
			String camino = path + importPath.replace(".", "/").substring(0, importPath.length()-2);
			Process p;
			try {
				String nombreArchivo;
				p = Runtime.getRuntime().exec("ls " + camino);
				BufferedReader reader=new BufferedReader(new InputStreamReader(p.getInputStream()));
				while ((nombreArchivo = reader.readLine()) != null) 
					if (nombreArchivo.endsWith(".java"))
						l.add(nombreArchivo.replace(".java", "")+";");
			} catch (IOException e){ 
				e.printStackTrace();
			}
		}
		else {
			String s[] = importPath.split("\\.");
			String ss = s.length==0?importPath:s[s.length-1];
			ss = ss.replace("\n","").replace(" ", "");
			l.add(ss); //como guarda esto con ";" o sin??? 
		}
		return l.iterator();
	}

	//de un codigo, unfoldea los imports los va pegando y import infoldeables los deja en imports
	private static String resolverCodigo(String filename, String codigo){
		importsExpandidos.add(filename);
		Programa prog = new Programa(codigo);
		if (prog.imports==null) return codigo;
		String importPath; // busca la dir y trae el archivo en string
		Iterator<String> importedNames;
		String importedName;
		StringBuilder salida = new StringBuilder();	
		Iterator<String> it = prog.imports.iterator();
		String importUnFoldeado;
		while (it.hasNext()){ //resuelve una linea de import del programa import  java.io.* por ejemplo
			importPath = it.next();
			importedNames = getImportNames(importPath);
			while(importedNames.hasNext()){
				importedName = importedNames.next();
				if (!importsExpandidos.contains(importedName)){
					importUnFoldeado = unfoldImportPath(importPath,importedName);
					if (importUnFoldeado == null)
						imports.append("import " + importPath);
					else
						salida.append(resolverCodigo(importedName,importUnFoldeado));
				}
			}
		}
		salida.append(prog.codigo);
		return salida.toString();
	}

	public static String resolver(String preamble,String uutPath, PrintWriter out){
		importsExpandidos = new HashSet<String>();
		imports = new StringBuilder();
		path = uutPath.charAt(uutPath.length()-1)=='/'?uutPath:uutPath+"/";
		output = out;
		String s = resolverCodigo("preamble",preamble);
		return new String(imports.toString() +"\n" + s);
	}
}