package client.blogic.testing.refinement;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.tree.DefaultMutableTreeNode;

import net.sourceforge.czt.z.ast.AxPara;
import net.sourceforge.czt.z.ast.BranchList;
import net.sourceforge.czt.z.ast.FreePara;
import net.sourceforge.czt.z.ast.Freetype;
import net.sourceforge.czt.z.ast.FreetypeList;
import net.sourceforge.czt.z.ast.ParaList;
import net.sourceforge.czt.z.ast.Sect;
import net.sourceforge.czt.z.ast.Spec;
import net.sourceforge.czt.z.ast.ZFreetypeList;
import net.sourceforge.czt.z.ast.ZParaList;
import net.sourceforge.czt.z.ast.ZSect;
import net.sourceforge.czt.z.impl.ZFreetypeListImpl;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import common.util.ExprIterator;
import common.z.SpecUtils;
import compserver.tcasegen.strategies.setlog.SetLogUtils;
import client.blogic.management.Controller;
import client.blogic.testing.refinement.FTCRLParser.RefinementRuleContext;
import client.blogic.testing.refinement.FTCRLParser.SExprRefinementContext;
import client.blogic.testing.refinement.java.FTCRLJavaVisitor;
import client.presentation.ClientTextUI;


public final class FTCRLUtils {

	static ClientTextUI clientTextUI;
	//Indica los tipos "enum" de java encontrados en preamble
	static HashMap<String, String> enumTypes = new HashMap<String,String>();
	//Indica las variables no publicas encontradas
	static LinkedList<String> privateVars = new LinkedList<String>();
	//es la regla actual, es decir la que elije el usuario en el comando refine
	static RefinementRule reglaActual;

	public static void setRule(RefinementRule rule){
		reglaActual = rule;
	}
	public static RefinementRuleContext getRule(){
		return reglaActual.getTree();
	}
	public static String getPreamble(){
		return reglaActual.getPreamble();
	}

	public static String getPlCode() {
		return reglaActual.getPlcode();
	}

	public static void setClientUI(ClientTextUI clientTextUI) {
		FTCRLUtils.clientTextUI = clientTextUI;

	}

	public static String getEpilogue(){
		return reglaActual.getEpilogue();
	}

	public static void setEnumTypes(HashMap<String,String> enumTypes) {
		FTCRLUtils.enumTypes = enumTypes;

	}

	public static void setPrivateVars(LinkedList<String> privateVars) {
		FTCRLUtils.privateVars = privateVars;

	}

	private static RefinementRuleContext preproc(String ruleString){
		ANTLRInputStream input = new ANTLRInputStream(ruleString); 
		FTCRLLexer lexer = new FTCRLLexer(input); 
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		FTCRLParser parser = new FTCRLParser(tokens);
		parser.setErrorHandler(new ExceptionErrorStrategy());
		RefinementRuleContext ruleContext = parser.refinementRule();
		ruleString = ruleContext.accept(new FTCRLPreprocVisitor(ruleContext));
		input = new ANTLRInputStream(ruleString);
		lexer = new FTCRLLexer(input);
		tokens = new CommonTokenStream(lexer);
		ruleContext = new FTCRLParser(tokens).refinementRule();
		return ruleContext;
	}

	private static String resolverPreamble(String preamble){
		RefinementRules rules = RefinementRules.getInstance();
		String REGEX = "^(\\w*)\\.@PREAMBLE$";
		Pattern p = Pattern.compile(REGEX,Pattern.MULTILINE);
		Matcher m = p.matcher(preamble);
		String unpreambulo = new String();
		while(m.find()) {
			unpreambulo = rules.getRule(m.group(1)).getPreamble();
			preamble = m.replaceFirst(resolverPreamble(unpreambulo));
			m = p.matcher(preamble);
		}
		return preamble;	
	}

	private static void preprocPreambles(){
		RefinementRules rules = RefinementRules.getInstance();
		Iterator<String> it = rules.getRefRuleNames().iterator();
		String key,preamble;
		RefinementRule rule;
		while (it.hasNext()) {
			key = it.next().toString();
			rule = rules.getRule(key);
			preamble = rule.getPreamble();
			preamble = resolverPreamble(preamble);
			rule.setPreamble(preamble);
		}
	}

	public static void parse(File refRuleFile) throws IOException{
		FileInputStream refRuleFileStream = new FileInputStream(refRuleFile.getAbsolutePath());
		String refRulesString = new Scanner(refRuleFileStream,"UTF-8").useDelimiter("\\A").next();
		refRuleFileStream.close();
		RefinementRuleContext ruleContext;
		RefinementRule rule;
		RefinementRules rules = RefinementRules.getInstance();
		String refRuleAux[],preamble, uut, epilogue,ruleString,rrule,plcode = "",laws;
		String refRulesAux[] = refRulesString.split("@RRULE");
		int cantHijos = refRulesAux.length;
		for (int i = 1; i<cantHijos;i++){

			refRuleAux = refRulesAux[i].split("@PREAMBLE",2);
			rrule = refRuleAux[0];

			refRuleAux = refRuleAux[1].split("@LAWS",2);
			preamble = refRuleAux[0];

			refRuleAux = refRuleAux[1].split("@PLCODE",2);
			if (refRuleAux.length == 2){ //tiene plcode
				laws = refRuleAux[0];
				refRuleAux = refRuleAux[1].split("@UUT");
				plcode = refRuleAux[0].substring(1);
			} else {
				refRuleAux = refRuleAux[0].split("@UUT");
				laws = refRuleAux[0];
				plcode = "";
			}

			refRuleAux = refRuleAux[1].split("@EPILOGUE",2);
			if (refRuleAux.length == 2){ //tiene epilogue
				epilogue = refRuleAux[1];
			} else {
				epilogue = "";
			}

			uut = refRuleAux[0];

			ruleString = "@RRULE"+rrule+"@PREAMBLE\n@LAWS"+laws+"@UUT"+uut;
			ruleContext = preproc(ruleString);	

			rule = new RefinementRule(ruleContext, preamble, epilogue, plcode);
			rules.addRule(ruleContext.name().getText(), rule);

		}
		preprocPreambles();
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

		HashMap<String,String> types = clientTextUI.getMyController().getUserDefinedTypes();
		HashMap<String, String> map = new HashMap<String, String>();

		//Limpiamos los espacios y doble barras
		//tcase = tcase.replaceAll(" ", "");
		tcase = tcase.replaceAll("\\\\\\\\", "");

		String lineas[] = tcase.split("\\where");

		lineas = lineas[0].split("\\n");

		//la primer linea siempre es "\\begin{schema}"
		for (int i = 1; i < lineas.length -1; i++){
			String[] reg = lineas[i].split(":");
			String type = reg[1];

			String vars[] = reg[0].split(","); //Lista de variables
			for (int j=0; j < vars.length; j++) {
				map.put(vars[j].replaceAll(" ", ""),unfoldTypes(types, type));
			}
		}

		return map;
	}

	//Funcion auxiliar para CreateZTypesMap.
	//Se utiliza para unfolder los typos de las variables
	private static String unfoldTypes(HashMap<String,String> types, String type) {
		Iterator<String> it = types.keySet().iterator();
		String t,aux = null;
		String ntipo = type;
		while (it.hasNext()){
			t = it.next();
			aux = types.get(t);
			aux = aux.replace("\\", "¬¬");
			aux = aux.replace('¬', '\\');
			ntipo = type.replaceAll("(^|\\W)" + t + "($|\\W)", "$1" + aux + "$2");
			if (!ntipo.equals(type)){
				ntipo = unfoldTypes(types,ntipo);
				type = ntipo;
			}
		}
		ntipo = ntipo.replaceAll(" ", "");
		return ntipo;
	}

	//Este método debe obtener el tipo de una expresion de código funete (java):
	//- una variable: "a"
	//- una variable de una clase: "A.name"
	//- el argumento de un metodo: "arg"
	public static String getCodeExpressionType(String javaExp, FTCRLJavaVisitor ftcrl){

		HashMap<String, String> types = ftcrl.javaTypesMap;
		String type = types.get(javaExp);
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
				type = getCodeExpressionType(javaExp.substring(0, lastPoint), ftcrl);
				type = types.get(type + atribute);
				return type;
			} else { //Es un tipo, como "String"
				return javaExp;
			}
		}

	}

	//Determina el SExpr correspondiente. Para eso utiliza el parser para crear el árbol y visitarlo
	public static SExpr sExpr(String exp, Replacement replacement, FTCRLJavaVisitor ftcrl) {
		if (replacement != null && replacement.exp != null && replacement.exp.equals(exp))
			return new SExpr(replacement.value, replacement.type);

		ANTLRInputStream in = new ANTLRInputStream(exp);
		FTCRLLexer lexer = new FTCRLLexer(in);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		FTCRLParser parser = new FTCRLParser(tokens);
		ParseTree tree = parser.sExprRefinement();

		//FTCRLJavaVisitor visitor = new FTCRLJavaVisitor();
		return ftcrl.visitSExprRefinement((SExprRefinementContext) tree,replacement);
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

	//Determina si es un tipo básico de Z
	public static boolean isBasicType(String type) {
		Controller controller = clientTextUI.getMyController();
		List<String> bs = controller.getBasicTypeNames();

		if (bs.contains(type))
			return true;
		return false;
	}

	public static boolean isCrossProduct(String type) {
		String nodeType = getType(type);
		if (nodeType.equals("\\cross"))
			return true;
		return false;
	}

	//Determina si es un tipo básico de Z
	public static String isFreeType(String type) {
		Controller controller = clientTextUI.getMyController();
		List<String> basicTypeNames = controller.getBasicTypeNames();
		Spec spec = controller.getOriginalSpec();
		Iterator<FreePara> freeParasIt = controller.getFreeParas().iterator();

		//Hay que buscar en la especificación para ver si es un tipo enumerado
		ZParaList zParaList = null;
		for (Sect sect : spec.getSect()) {
			if (sect instanceof ZSect) {
				ParaList paraList = ((ZSect) sect).getParaList();
				if (paraList instanceof ZParaList) {
					zParaList = (ZParaList) paraList;
				}
			}
		}

		AxPara schema = SpecUtils.axParaSearch(type, zParaList);
		String schemaString = SpecUtils.termToLatex(schema);
		if (schemaString.equals("null")){ //No es un tipo esquema
			if (!basicTypeNames.contains(type)){ //Es un tipo libre
				while (freeParasIt.hasNext() && schemaString.equals("null")) {
					FreePara freePara = freeParasIt.next();
					FreetypeList freetypeList = freePara.getFreetypeList();
					if (freetypeList instanceof ZFreetypeListImpl) {
						ZFreetypeList zFreetypeList = (ZFreetypeListImpl) freetypeList;
						for (int i = 0; i < zFreetypeList.size(); i++) {
							Freetype freetype = zFreetypeList.get(i);
							if (type.equals(freetype.getName().toString())) {
								BranchList fs = freetype.getBranchList();
								schemaString = SpecUtils.termToLatex(fs);
								schemaString = schemaString.replaceAll(" ", "");
								schemaString = schemaString.replaceAll("\\|", ",");
								return schemaString;
							}
						}
					}
				}
			}
		}
		return "";
	}

	//Determina la clase en Java que representa 'refS'
	//Por ejemplo, si la entrada es "A.name" donde A sería una clase
	//y name un atributo de la misma, retorna "A"
	public static String extractName(String refS) {
		return refS.split("[.]", 2)[0];
	}

	//Determina el atributo en Java que se utiliza en 'refS'
	//Por ejemplo, si la entrada es "A.name" donde A sería una clase
	//y name un atributo de la misma, retorna ".name"
	public static String extractAtribute(String refS) {
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
	public static String getType(String type) {
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

	//
	//  Metodo para obtener los tipos de los hijos.
	//  Se usa para unificar los tipos de funciones, conjuntos y secuencias
	//  Acepta solo: A \pfun B
	//               \power (A cross) B
	//               \seq A
	//               A \cross B 
	//
	static ArrayList<String> childsTypes(String type) {

		DefaultMutableTreeNode root = SetLogUtils.toTreeNorm(type);
		ArrayList<String> childsTypes = new ArrayList<String>();
		DefaultMutableTreeNode aux;
		String rootType = (String) root.getUserObject();

		while (rootType.equals("()")) {
			root = (DefaultMutableTreeNode) root.getChildAt(0);
			rootType = (String) root.getUserObject();
		}

		if (rootType.equals("\\power")) {
			DefaultMutableTreeNode child = (DefaultMutableTreeNode) root.getChildAt(0);
			String childType = (String) child.getUserObject();

			while (childType.equals("()")) {
				child = (DefaultMutableTreeNode) child.getChildAt(0);
				childType = (String) child.getUserObject();
			}

			if (childType.equals("\\cross")) { //Cambiar para multiples cross?
				int childsAmount = child.getChildCount();
				for (int i = 0; i < childsAmount; i++) {
					aux = (DefaultMutableTreeNode) child.getChildAt(i);
					while (((String) aux.getUserObject()).equals("()"))
						aux = (DefaultMutableTreeNode) aux.getChildAt(0);
					childsTypes.add(printTreeWithParenthesis(aux));
				}
			}

		}
		else if (isSeq(rootType)) { //Entonces empieza con pfun, rel etc

			childsTypes.add("\\nat");
			aux = (DefaultMutableTreeNode) root.getChildAt(0);
			while (((String) aux.getUserObject()).equals("()"))
				aux = (DefaultMutableTreeNode) aux.getChildAt(0);
			childsTypes.add(printTreeWithParenthesis(aux));

		}
		else if (rootType.equals("\\cross")) {

			int childsAmount = root.getChildCount();
			for (int i = 0; i < childsAmount; i++) {
				aux = (DefaultMutableTreeNode) root.getChildAt(i);
				while (((String) aux.getUserObject()).equals("()"))
					aux = (DefaultMutableTreeNode) aux.getChildAt(0);
				childsTypes.add(printTreeWithParenthesis(aux));
			}
		}

		else { //Entonces empieza con pfun, rel etc

			aux = (DefaultMutableTreeNode) root.getChildAt(0);
			while (((String) aux.getUserObject()).equals("()"))
				aux = (DefaultMutableTreeNode) aux.getChildAt(0);
			childsTypes.add(printTreeWithParenthesis(aux));

			aux = (DefaultMutableTreeNode) root.getChildAt(1);
			while (((String) aux.getUserObject()).equals("()"))
				aux = (DefaultMutableTreeNode) aux.getChildAt(0);

			childsTypes.add(printTreeWithParenthesis(aux));
		}

		return childsTypes;
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

	//Determina si un tipo del codigo fuente es "enum"
	public static boolean isEnumCodeType(String type){
		if (enumTypes.get(type) != null)
			return true;
		else
			return false;
	}

	//Retorna el n-esimo elemento de un tipo "enum" del codigo fuente
	public static String getEnumCodeTypeElem(String type, int n){

		String values = enumTypes.get(type);
		if (values != null){
			//Creamos un iterador sobre los elementos
			ExprIterator itElements = new common.util.ExprIterator(values);
			n = n % itElements.cardinalidad();
			return itElements.next(n);
		} else
			return "";
	}

	//Determina si una variable en el codigo es privada
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

	//Retorna el tipo de un elemento de un conjunto (o secuencia) de Z
	public static String elementType(String type) {

		String elemType = FTCRLUtils.getChildType(type, 0);
		//Si es una secuencia, debemos tomar sus elementos como una tupla
		if (FTCRLUtils.isSeq(type)){
			elemType = "\\num \\cross(" + elemType + ")";
		}
		return elemType;
	}

	//Metodo para determinar la referencia cuando se usa REF
	public static String findReference(String value, String iName, FTCRLJavaVisitor ftcrl) {

		//Primero busco por el nombre de la variable
		if (ftcrl.references.get(iName) != null)
			return ftcrl.references.get(iName).type;
		else { //Si no esta, busco por los elementos de la variable
			String varName = FTCRLUtils.extractName(iName);
			String atribute = FTCRLUtils.extractAtribute(iName);

			//Miro si la variable, es en realidad un atributo de la clase a testear
			//ya que en ese caso, debo agregar delante el nombre del elemento de la clase
			//Y luego debo iterar sobre los elementos de varName
			//Ej c[0], c[1]
			int it = 0;
			SExpr s = null;
			if (!ftcrl.uutArgs.contains(varName)) //Si es un atributo de la clase
				varName = ftcrl.testingVar + "." + varName;

			while ((s = ftcrl.references.get(varName + "[" + it + "]")) != null){
				SExpr t = ftcrl.references.get(s.type + atribute);
				if ((t != null) && (t.exp.equals(value)))
					return s.type + atribute;
				it++;
			}
		}

		return null;
	}

	//Determina si se debe almacenar el valor de una variable porque puede ser referenciado más tarde
	public static void saveReference(String var, String zValue, String javaValue, FTCRLJavaVisitor ftcrl) {
		if (ftcrl.isRef) {
			String varName = var;
			if (varName.startsWith(ftcrl.testingVar + "."))
				varName = var.substring(5);
			varName = FTCRLUtils.extractName(varName);

			ftcrl.references.put(var, new SExpr(zValue, javaValue));
		}
	}

	//En FTCRL se mezclan los conjuntos de Strings, para eso usar este método
	public static String concatFTCRLStringSets(SExpr sExprLeft, SExpr sExprRight) {

		String aux = "¬A¬" + "++" + "¬B¬";
		String newSet = "";
		if (isSet(sExprLeft.type)){
			ExprIterator it = new ExprIterator(sExprLeft.exp);
			while (it.hasNext()){
				String e = aux.replaceFirst("¬A¬", "\"" + it.next() + "\"");
				if (!newSet.equals(""))
					newSet += ",";
				newSet += e;
			}
		} else {
			newSet = aux.replaceFirst("¬A¬", "\"" + sExprLeft.exp + "\"");
		}

		aux = newSet;

		if (isSet(sExprRight.type)){
			newSet = "";
			ExprIterator it = new ExprIterator(sExprRight.exp);
			while (it.hasNext()){
				String e = aux.replaceAll("¬B¬", "\"" + it.next() + "\"");
				if (!newSet.equals(""))
					newSet += ",";
				newSet += e;
			}
		} else {
			newSet = aux.replaceAll("¬B¬", "\"" + sExprRight.exp + "\"");
		}

		return "\\{" + newSet + "\\}";
	}

	public static void closeTables(FTCRLJavaVisitor ftcrl) {

		Iterator<RefinementTable> it = ftcrl.openedTables.iterator();
		while (it.hasNext()){
			RefinementTable t = it.next();
			ftcrl.printDeclaration(t.stmt + ".close()");
		}

	}
	public static void closeFiles(FTCRLJavaVisitor ftcrl) {
		Iterator<String> it = ftcrl.openedFiles.keySet().iterator();
		while (it.hasNext()){
			String t = it.next();
			ftcrl.printAssignment("close(" + ftcrl.openedFiles.get(t) + ")");
		}

	}

	//Metodo auxiliar para DotSetOper cuando se trabaja sobre conjuntos
	public static String getDotSetElemFromSet(String setElem, String oper) {

		ExprIterator itElements = new common.util.ExprIterator(setElem);
		if(oper.contains("DOM")){ //Operador DOM
			String value = itElements.next();
			return value;
		}
		else if(oper.contains("RAN")){ //Operador RAN
			itElements.next();
			String value = itElements.next();
			return value;
		}
		else if(oper.contains("#")){ //Operador Cardinalidad
			String value = String.valueOf(itElements.cardinalidad());
			return value;
		}
		return "";
	}

	//Metodo auxiliar para DotSetOper cuando se trabaja sobre conjuntos
	public static String getDotSetTypeFromSet(String exp, String oper) {

		if(oper.contains("DOM")){ //Operador DOM
			ArrayList<String> childTypes = childsTypes(exp);
			return childTypes.get(0);
		}
		else if(oper.contains("RAN")){ //Operador RAN
			ArrayList<String> childTypes = childsTypes(exp);
			return childTypes.get(1);
		}
		else if(oper.contains("#")){ //Operador Cardinalidad
			return "\\num";
		}
		return null;
	}
}