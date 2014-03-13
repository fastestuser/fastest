package client.blogic.testing.refinamiento;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import javax.swing.tree.DefaultMutableTreeNode;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import java.util.Scanner;
import common.util.ExprIterator;
import compserver.tcasegen.strategies.setlog.SetLogUtils;
import client.blogic.testing.refinamiento.FTCRLParser.RefinementRuleContext;
import client.blogic.testing.refinamiento.FTCRLParser.SExprRefinementContext;
import client.blogic.testing.refinamiento.javaparser.Java7Lexer;
import client.blogic.testing.refinamiento.javaparser.Java7Parser;
import client.blogic.testing.refinamiento.javaparser.TypeExtractorVisitor;


public final class FTCRLUtils {
	static RefinementRuleContext tree;
	static String preamble; //codigo java de la refrule
	static HashMap<String, String> enumTypes = new HashMap<String,String>(); //Indica los tipos "enum" de java encontrados en preamble
	static LinkedList<String> privateVars = new LinkedList<String>(); //Indica las variables privadas (no publicas en verdad) de java

	public static RefinementRuleContext getTree(){
		return tree;
	}

	public static String getPreamble(){
		return preamble;
	}

	public static String preprosesar(File refRuleFile) throws IOException{
		FileInputStream refRuleFileStream = new FileInputStream(refRuleFile.getAbsolutePath());
		String refRules = new Scanner(refRuleFileStream,"UTF-8").useDelimiter("\\A").next();
		String refRulesAux[] = refRules.split("@PREAMBLE|@LAWS");
		preamble = refRulesAux[1];
		String inPre = refRulesAux[0] +"@PREAMBLE\n@LAWS"+ refRulesAux[2];
		
		ANTLRInputStream input = new ANTLRInputStream(inPre);
		FTCRLLexer lexer = new FTCRLLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		tree = new FTCRLParser(tokens).refinementRule();
		String s = tree.accept(new FTCRLPreprocVisitor(tree));
		//System.out.println("+++++++++\n" + s +"\n +++++++");
		
		return s;
	}


	public static void parse(String refRules) throws IOException{
		ANTLRInputStream input = new ANTLRInputStream(refRules);
		FTCRLLexer lexer = new FTCRLLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		tree = new FTCRLParser(tokens).refinementRule();
		RefinementRule newRule = new RefinementRule(tree,preamble);
		RefinementRules.getInstance().addRule(tree.name().getText(), newRule);
	} 

	//Crea un map con los valores de las variables de Z, a partir del caso de prueba
	public static HashMap<String, String> createZValuesMap(String tcase){

		HashMap<String, String> map = new HashMap<String, String>();

		//Limpiamos los espacios y doble barras
		tcase = tcase.replaceAll(" ", "");
		tcase = tcase.replaceAll("\\\\\\\\", "");

		String lineas[] = tcase.split("\\where");

		//si no tiene where
		if (lineas.length == 1) return map;

		lineas = lineas[1].split("\\n");

		//la ultima linea siempre es "\\end{schema}"
		for (int i = 1; i < lineas.length -1; i++){
			String[] reg = lineas[i].split("=");
			map.put(reg[0], reg[1]);
		}

		return map;
	}

	//Crea un map con los tyipos de las variables de Z, a partir del caso de prueba
	public static HashMap<String, String> createZTypesMap(String tcase){

		HashMap<String, String> map = new HashMap<String, String>();

		//Limpiamos los espacios y doble barras
		tcase = tcase.replaceAll(" ", "");
		tcase = tcase.replaceAll("\\\\\\\\", "");

		String lineas[] = tcase.split("\\where");

		lineas = lineas[0].split("\\n");

		//la primer linea siempre es "\\begin{schema}"
		for (int i = 1; i < lineas.length -1; i++){
			String[] reg = lineas[i].split(":");
			String type = reg[1];

			String vars[] = reg[0].split(","); //Lista de variables
			for (int j=0; j < vars.length; j++) {
				map.put(vars[j].replaceAll(" ", ""),type);
			}
		}

		return map;
	}

	//Crea un map con los tipos de las variables de java, a partir del codigo fuente
	public static HashMap<String, String> createJavaTypesMap(String javaCode){

		//Utilizamos el parser de Java
		ANTLRInputStream input = new ANTLRInputStream(javaCode);
		Java7Lexer lexer = new Java7Lexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		Java7Parser parser = new Java7Parser(tokens);
		ParseTree tree = parser.compilationUnit();

		//Lo visitamos
		TypeExtractorVisitor visitor = new TypeExtractorVisitor();

		visitor.visit(tree);

		enumTypes = visitor.getEnumTypes(); //Almacenamos los tipos "enum"
		privateVars = visitor.getPrivateVars(); //Almacenamos las variables privadas
		return visitor.getMap(); //retornamos el map con los tipos de las variables
	}

	//Este método debe obtener el tipo de una expresion java como:
	//- una variable: "a"
	//- una variable de una clase: "A.name"
	//- el argumento de un metodo: "arg"
	public static String getJavaType(String javaExp, HashMap<String, String> javaTypes){

		String type = javaTypes.get(javaExp);
		if (type != null)
			return type;
		else {
			//tiene que ser un atributo de una clase
			//ej: A.b.name, donde A.b es un B
			//obtenemos el ultimo argumento,
			//y buscamos el tipo de la primer parte
			int lastPoint = javaExp.lastIndexOf(".");
			if (lastPoint != -1){
				String atribute = javaExp.substring(lastPoint);
				type = getJavaType(javaExp.substring(0, lastPoint), javaTypes);
				type = javaTypes.get(type + atribute);
				return type;
			}
		}
		return "";

	}

	//Determina el SExpr correspondiente. Para eso utiliza el parser para crear el árbol y visitarlo
	public static SExpr sExpr(String exp, Replacement replacement, HashMap<String,String> zValuesMap, HashMap<String,String> zTypesMap) {
		ANTLRInputStream in = new ANTLRInputStream(exp);
		FTCRLLexer lexer = new FTCRLLexer(in);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		FTCRLParser parser = new FTCRLParser(tokens);
		ParseTree tree = parser.sExprRefinement();

		FTCRLJavaVisitor visitor = new FTCRLJavaVisitor();
		return visitor.visitSExprRefinement((SExprRefinementContext) tree,replacement,zValuesMap, zTypesMap);
	}

	//Determina si 'value' es un conjunto. Como entrada toma un valor, no una expresion FTCRL.
	public static boolean isSet(String value) {

		if (getType(value).equals("\\power"))
			return true;
		else
			return  false;
	}

	//Determina si 'value' es una seq. Como entrada toma un valor, no una expresion FTCRL.
	public static boolean isSeq(String value) {
		if (getType(value).equals("\\seq") || getType(value).equals("\\seq_{1}"))
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

	//
	//  Metodo para la determinacion del tipo de nodo mas externo de un tipo.
	//  Ej:  type = A \cross B ----> return \cross
	//
	static String getType(String type) {
		//El calculo se realiza mediante la construccion del arbol de tipos con la gramatica TypeManager
		DefaultMutableTreeNode root = SetLogUtils.toTreeNorm(type);;

		//root es la raiz del arbol, como puede contener parentesis, los elimino
		while (((String) root.getUserObject()).equals("()")) {
			root = (DefaultMutableTreeNode) root.getChildAt(0);
		}

		//se retorna la informacion de la raiz
		return (String) root.getUserObject();
	}

	//  Metodo para la determinacion del tipo de un hijo de una expresion Z.
	public static String getChildType(String type, int pos) {
		//El calculo se realiza mediante la construccion del arbol de tipos con la gramatica TypeManager utilizada en Setlog
		DefaultMutableTreeNode root = SetLogUtils.toTreeNorm(type);

		DefaultMutableTreeNode child = (DefaultMutableTreeNode) root.getChildAt(pos);

		while (((String) child.getUserObject()).equals("()")) {
			child = (DefaultMutableTreeNode) child.getChildAt(0);
		}

		//se retorna la impresion del hijo correspondiente
		return printTreeWithParenthesis(child);
	}

	//Necesito esta funcion para imprimir el árbol en getChildType(...), la cual agrega parentesis, ya que TreeNorm los elimina
	private static String printTreeWithParenthesis(DefaultMutableTreeNode tree){
		if (tree.isLeaf()) 
			return (String) tree.getUserObject();
		else if (tree.getChildCount() == 1)
			return (String) tree.getUserObject()+ "(" + printTreeWithParenthesis((DefaultMutableTreeNode) tree.getChildAt(0)) + ")";
		else if (tree.getChildCount() == 2)
			return "(" + printTreeWithParenthesis((DefaultMutableTreeNode) tree.getChildAt(0)) + ")" + ((String) tree.getUserObject()) + "(" + printTreeWithParenthesis((DefaultMutableTreeNode) tree.getChildAt(1)) + ")";
		else {//tiene varios hijos, es un CROSS!
			String returnString = "(" + printTreeWithParenthesis((DefaultMutableTreeNode) tree.getChildAt(0)) + ")";
			int i = 1;
			while (i < tree.getChildCount()) {
				returnString = returnString.concat("\\cross");
				returnString = returnString.concat("(" + printTreeWithParenthesis((DefaultMutableTreeNode) tree.getChildAt(i)) + ")");
				i++;
			}
			return returnString;
		}
	}

	//Devuelve el tipo del "hijo" de un tipo de java
	//Ej: entrada: "LinkedList<String>" -> salida: String
	public static String getInnerType(String type) {
		//Hay que controlarla
		int start = type.indexOf("<");
		int end = type.lastIndexOf(">");
		if ((start != -1) && (end != -1)){
			return type.substring(start+1, end);
		}

		return null;
	}

	//Determina si un tipo en java es "enum"
	public static boolean isEnumJava(String type){
		if (enumTypes.get(type) != null)
			return true;
		else
			return false;
	}

	//Retorna el n-esimo elemento de un "enum" de Java
	public static String getEnumJavaElem(String type, int n){

		String values = enumTypes.get(type);
		if (values != null){
			//Creamos un iterador sobre los elementos
			ExprIterator itElements = new common.util.ExprIterator(values);
			n = n % itElements.cardinalidad();
			return itElements.next(n);
		} else
			return "";
	}

	//Determina si una variable en java es "private"
	public static boolean isPrivate(String var){

		if (privateVars.contains(var))
			return true;
		else
			return false;
	}

	//Obtiene el nombre del MODULE de la uut
	public static String extractModuleName(String uut){
		String[] s = uut.split("MODULE", 2);
		return s[1].replaceAll("\n", "");
	}

	//Obtiene el nombre de las variables del uut
	public static LinkedList<String> extractUUTArgs(String uut){
		LinkedList<String> l = new LinkedList<String>();
		uut = uut.substring(uut.indexOf("(")+1, uut.indexOf(")"));
		String[] args = uut.split(",");
		for (int i = 0; i < args.length; i++)
			l.add(args[i]);
		return l;
	}

	public static String convertToSeq(String exp, String elemType) {
		//Si es una secuencia, debemos tomar sus elementos como una tupla
		if (FTCRLUtils.isSeq(exp)){
			elemType = "\\num \\cross(" + elemType + ")";
		}
		return elemType;
	}

	//Metodo para determinar la referencia cuando se usa REF
	public static String findReference(String value, String iName, HashMap<String, String> references, LinkedList<String> uutArgs) {

		//Primero busco por el nombre de la variable
		if (references.get(iName) != null)
			return references.get(iName);
		else { //Si no esta, busco por los elementos de la variable
			String varName = FTCRLUtils.recordType(iName);
			String atribute = FTCRLUtils.recordAtribute(iName);

			//Miro si la variable, es en realidad un atributo de la clase a testear
			//ya que en ese caso, debo agregar delante el nombre del elemento de la clase
			//Y luego debo iterar sobre los elementos de varName
			//Ej c[0], c[1]
			int it = 0;
			String s = "";
			if (!uutArgs.contains(varName)) //Si es un atributo de la clase
				varName = "test." + varName;

			while ((s = references.get(varName + "[" + it + "]")) != null){
				String t = references.get(s + atribute);
				if ((t != null) && (t.equals(value)))
					return s + atribute;
				it++;
			}
		}

		return null;
	}

	//Determina si se debe almacenar el valor de una variable porque puede ser referenciado más tarde
	public static void saveReference(String var, String value,	HashMap<String, String> references, boolean isRef) {
		if (isRef) {
			String varName = var;
			if (varName.startsWith("test."))
				varName = var.substring(5);
			varName = FTCRLUtils.recordType(varName);

			references.put(var, value);
		}
	}
}
