//Clase base para visitar un árbol FTCRL y refinarlo
package client.blogic.testing.refinement;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class FTCRLtoCodeVisitor  extends FTCRLBaseVisitor<Value> {

	protected StringBuilder warnings;
	protected String declarationList = ""; //String donde se acumulan las sentencias de declaracion
	protected String assignmentList = "";  //String donde se acumulan las sentencias de asignacion
	//Map con los valores de las variables Z, obtenidos de la especificaciones
	protected HashMap<String,String> zValuesMap = new HashMap<String,String>();
	//Map con los tipos de las variables Z, obtenidos de la especificaciones
	protected HashMap<String,String> zTypesMap = new HashMap<String,String>();
	//Map con los tipos de las variables java, obtenidos del codigo enunciado en las reglas de refinamiento
	public HashMap<String,String> codeTypesMap = new HashMap<String,String>();
	//Module del UUT
	protected String moduleName = "";
	//Argumentos del UUT
	public LinkedList<String> uutArgs= new LinkedList<String>();
	//Linea de impresion del UUT
	public String uutLine = "";
	//Tabla acutla, para cuando refinamos a una tabla
	public RefinementTable currentTable;
	//Tablas abiertas, para cuando refinamos una tabla
	public HashSet<RefinementTable> openedTables = new HashSet<RefinementTable>();
	//Archivos abiertos, para cuando refinamos un file
	public HashMap<String, String> openedFiles = new HashMap<String, String>();
	//Variable para dar nombre a las variables que se crean
	protected static int varNumber = 0;
	//Map con los valores almacenados por los REF
	public HashMap<String, SExpr> references = new HashMap<String, SExpr>();
	//Variables que deben ser almacenadas, porque van a ser referenciadas
	public static LinkedList<String> referencedVars = new LinkedList<String>();
	//Variables auxiliar para determinar si se debe guardar una referencia
	public boolean isRef;
	//Variable auxiliar para determinar el nombre de la variable de testing "test"
	public String testingVar;
	
	public String getWarnings(){
		return warnings.toString();
	}
	
	public void addWarning(String warning){
		warnings.append("// " + warning + "\n");
	}
	
	public String getDeclarationList(){
		return declarationList;
	}

	public String getAssignementList(){
		return assignmentList;
	}

	public void printDeclaration(String line){
		declarationList = declarationList.concat(line + "\n");
	}

	public void printAssignment(String line){
		assignmentList = assignmentList.concat(line + "\n");
	}
	
	public String newVarName(String name) {
		name = name.replaceAll("\\W", "");
		name += varNumber;
		varNumber++;
		return name;
	}
	
}
