package client.blogic.testing.refinamiento;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;


public class ImportsResolver {

	private  static String path;
	private  static HashSet<String> importsExpandidos;
	private  static StringBuilder imports;

	private static class Programa{
		public HashSet<String> imports;
		public String codigo;
		public Programa(String programa){
			imports = new HashSet<String>();
			String aux[] = programa.split("import");
			int length = aux.length;
			int i = 1;
			for (i = 1;i<=length-2;i++){
				imports.add(aux[i].replace(" ", "").replace("\n",""));
			}
			String aux2[] = null;
			if (aux.length > 1){
				aux2 = (aux[i]).split(";");
				imports.add(aux2[0].replace(" ", "").replace("\n", "")+";");
				codigo = new String(aux[i].substring((aux2[0]+";").length()));
			}
			else{
				codigo = new String(programa);
			}

		}
	}

	private static String resolverImportPath(String importPath) {
		String p = path + importPath.replace(".", "/").replace(";","") + ".java";
		File file = new File(p.replace(" ", "").replace("\n", ""));
		FileInputStream fileStream;
		try {
			fileStream = new FileInputStream(file.getAbsolutePath());
			String fileString = new Scanner(fileStream,"UTF-8").useDelimiter("\\A").next();
			return fileString;
		} catch (FileNotFoundException e) {
			return "";
		}

	}
	private  static String getImportName(String importPath){
		String s[] = importPath.split("\\.");
		String ss = s.length==0?importPath:s[s.length-1];
		ss = ss.replace("\n","").replace(" ", "");
		return (ss.substring(0,ss.length()-1));
	}

	private static String resolverString(String filename, String programa){
		importsExpandidos.add(filename);
		Programa p = new Programa(programa);	
		if (p.imports==null) return programa;
		String codigo = p.codigo;
		String unimport,importPath,importName; // busca la dir y trae el archivo en string
		StringBuilder salida = new StringBuilder();	
		Iterator<String> it = p.imports.iterator();
		while (it.hasNext()){
			importPath = it.next();
			importName = getImportName(importPath);
			if (!importsExpandidos.contains(importName)){
				unimport = resolverImportPath(importPath);
				if (unimport.equals(""))
					imports.append("import " + importPath);
				else
					salida.append(resolverString(importName,unimport));
			}
		}
		salida.append(codigo);
		return salida.toString();
	}

	public static String resolver(String preamble,String uutPath){
		importsExpandidos = new HashSet<String>();
		imports = new StringBuilder();
		path = uutPath.charAt(uutPath.length()-1)=='/'?uutPath:uutPath+"/";
		//		File preamblePath = new File(path + "archivo7.java");
		//		FileInputStream preambleFile = null;
		//		try {
		//			preambleFile = new FileInputStream(preamblePath.getAbsolutePath());
		//		} catch (FileNotFoundException e) {
		//			// TODO Auto-generated catch block
		//			e.printStackTrace();
		//		}
		//String preambleString = new Scanner(preambleFile,"UTF-8").useDelimiter("\\A").next();
		String s = resolverString("preamble",preamble);
		return new String(imports.toString() +"\n" + s);
	}
}
