package client.blogic.testing.refinamiento;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import common.util.ExprIterator;
import client.blogic.testing.refinamiento.FTCRLParser.DataStructContext;
import client.blogic.testing.refinamiento.FTCRLParser.DotSetOperContext;
import client.blogic.testing.refinamiento.FTCRLParser.INameContext;
import client.blogic.testing.refinamiento.FTCRLParser.LawContext;
import client.blogic.testing.refinamiento.FTCRLParser.LawsContext;
import client.blogic.testing.refinamiento.FTCRLParser.RefinementContext;
import client.blogic.testing.refinamiento.FTCRLParser.RefinementSentenceContext;
import client.blogic.testing.refinamiento.FTCRLParser.SExprRefinementContext;
import client.blogic.testing.refinamiento.FTCRLParser.SNameContext;
import client.blogic.testing.refinamiento.FTCRLParser.UutContext;
import client.blogic.testing.refinamiento.FTCRLParser.ZExprSetContext;
import client.blogic.testing.refinamiento.FTCRLParser.ZExprStringContext;
import client.blogic.testing.refinamiento.basicrefinement.*;

public class FTCRLJavaVisitor extends FTCRLBaseVisitor<Value> {

	private String declarationList = ""; //String donde se acumulan las sentencias de declaracion
	private String assignmentList = "";  //String donde se acumulan las sentencias de asignacion
	//Map con los valores de las variables Z, obtenidos de la especificaciones
	private HashMap<String,String> zValuesMap = new HashMap<String,String>();
	//Map con los tipos de las variables Z, obtenidos de la especificaciones
	private HashMap<String,String> zTypesMap = new HashMap<String,String>();
	//Map con los tipos de las variables java, obtenidos del codigo enunciado en las reglas de refinamiento
	private HashMap<String,String> javaTypesMap = new HashMap<String,String>();
	//Module del UUT
	private String moduleName = "";
	//Argumentos del UUT
	public LinkedList<String> uutArgs= new LinkedList<String>();
	//Tabla acutla, para cuando refinamos a una tabla
	public RefinementTable currentTable;
	//Tablas abiertas, para cuando refinamos una tabla
	public HashSet<RefinementTable> openedTables = new HashSet<RefinementTable>();
	//Archivos abiertos, para cuando refinamos un file
	public HashSet<String> openedFiles = new HashSet<String>();
	//Variable para dar nombre a las variables que se crean
	private static int varNumber = 0;
	//Map con los valores almacenados por los REF
	public HashMap<String, String> references = new HashMap<String, String>();
	//Variables que deben ser almacenadas, porque van a ser referenciadas
	public static LinkedList<String> referencedVars = new LinkedList<String>();
	//Variables auxiliar para determinar si se debe guardar una referencia
	public boolean isRef;
	//Variable auxiliar para determinar el nombre de la variable de testing "test"
	public String testingVar;

	public String getDeclarationList(){
		return declarationList;
	}

	public String getAssignementList(){
		return assignmentList;
	}

	public void printDeclaration(String line){
		declarationList = declarationList.concat(line + ";\n");
	}

	public void printAssignment(String line){
		assignmentList = assignmentList.concat(line + ";\n");
	}

	@Override
	public Value visitRefinementRule(FTCRLParser.RefinementRuleContext ctx){

		//Inicializamos los nombres que les daremos a las variables
		varNumber = 0;
		//Inicializamos las ref vars
		referencedVars = RefinementRules.getInstance().getReferencedVars();

		//Cargamos el codigo java para obtener los tipos de las variables
		extractJavaTypes(FTCRLUtils.getPreamble());

		//Obtenemos en nombre del modulo del UUT
		UutContext uut = ctx.uut();
		moduleName = FTCRLUtils.extractModuleName(uut.getText());
		uutArgs = FTCRLUtils.extractUUTArgs(uut.getText());

		//Creamos la variable test, de la clase que vamos a testear
		testingVar = newVarName("test");
		printDeclaration(moduleName + " " + testingVar + " = new " + moduleName + "()" );

		//Analizamos las laws
		LawsContext laws = ctx.laws();
		this.visit(laws);
		
		//Cerramos tablas y archivos
		FTCRLUtils.closeTables(openedTables, this);
		FTCRLUtils.closeFiles(openedFiles, this);
		
		//Analizamos la uut
		this.visit(uut);

		System.out.println("-----------------------------------------");
		System.out.print(declarationList);
		System.out.print(assignmentList);
		System.out.println("-----------------------------------------");

		return null;
	}	

	@Override
	public Value visitLaws(FTCRLParser.LawsContext ctx){
		Iterator<LawContext> it = ctx.law().iterator();
		while (it.hasNext()){
			isRef = false; //Reseteamos la variable para determinar si es referenciada una variable
			this.visit(it.next());
		}

		return null;
	}

	@Override
	public Value visitLaw(FTCRLParser.LawContext ctx){
		if (ctx.refinementLaw() != null){
			this.visit(ctx.refinementLaw());
		}

		return null;
	}

	@Override
	public Value visitUut(FTCRLParser.UutContext ctx){

		//Imprimimos la llamada al método de la clase
		List<INameContext> list = ctx.iName();
		String line = testingVar + "." + list.get(0).getText() + "(";
		//Agregamos los argumentos
		Iterator<String> it = uutArgs.iterator();
		if (it.hasNext())
			line += it.next();
		while (it.hasNext()){
			line += "," + it.next();
		}
		line += ")";

		printAssignment(line);
		return null;
	}

	@Override
	public Value visitRefinementLaw(FTCRLParser.RefinementLawContext ctx){

		//Obtenemos los nombres de las variables Z que se van a utilizar
		//y se van a pasar como argumento a las RefinementSentence
		List<String> zVars = new ArrayList<String>();
		Iterator<SNameContext> itZVars = ctx.sName().iterator();
		while(itZVars.hasNext()){
			zVars.add(itZVars.next().getText());
		}

		//Iteramos sobre las RefinementSentence para pasar como argumento las variables Z
		Iterator<RefinementSentenceContext> itRefinementSentence = ctx.refinementSentence().iterator();
		while (itRefinementSentence.hasNext()){
			this.visitRefinementSentence(itRefinementSentence.next(), zVars);
		}

		return null;
	}

	public Value visitRefinementSentence(FTCRLParser.RefinementSentenceContext ctx, List<String> zVars){

		//Si se utilizan nuevas variables Z, pasamos esas, y sino utilizamos zVars que nos llegaron del padre
		if (ctx.refinement() != null){ //Si es un refinement
			this.visitRefinement(ctx.refinement(), zVars, null, null);

		} else { //Si hay nuevas sName
			zVars = new ArrayList<String>();
			Iterator<SNameContext> itZVars = ctx.sName().iterator();
			while(itZVars.hasNext()){
				zVars.add(itZVars.next().getText());
			}

			this.visitRefinementSentence(ctx.refinementSentence(), zVars);
		}

		return null;
	}

	//@Override
	public String visitRefinement(FTCRLParser.RefinementContext ctx, List<String> zVars, String record, Replacement replaceValue){

		String varName = ""; //java
		String varType = ""; //java
		boolean isPrivate = false; //si la variable es privada

		//Primero calculamos el valor del lado izquierdo
		String replaceExp = "";
		if (ctx.sExprRefinement() != null) {
			//Si hay SExpr, calculamos su valor
			replaceExp = ctx.sExprRefinement().getText();
		} else {
			//Si no hay SExpr, debe obtener el valor de la variable Z
			replaceExp = zVars.get(0);
		}
		SExpr zExpr = FTCRLUtils.sExpr(replaceExp, replaceValue, this);


		//Luego el lado derecho
		String refS = ctx.iExprRefinement().iName().getText();
		String var = FTCRLUtils.extractName(refS);
		String atribute = FTCRLUtils.extractAtribute(refS);
		varType = FTCRLUtils.getJavaType(refS, javaTypesMap);

		//Debo refinar zExpr a varType

		//Si es una variable que luego será referenciada, lo indico
		//para que se almacenen los valores cuando se refina.
		//Esta variable será consultada más tarde al refinar otras variables
		if (referencedVars.contains(var))
			isRef = true;

		//Veo si es privada. En ese caso hay que definirla usando reflection
		if (FTCRLUtils.isPrivate(refS))
			isPrivate = true;

		//Puede ser una variable o un tipo.
		//Primero vemos si debo crear una variable nueva (record)
		//Si refS es una variable, no debo crear un record 
		//ya que es un argumento del metodo de la clase a testear.
		if (FTCRLUtils.isVariable(refS)){ 
			varName = var;
			//Si es una variable que será parte del argumento de la función, debo crearla
			if (uutArgs.contains(varName)){
				printDeclaration(varType + " " + varName); //La declaro
			} else { //Sino, es un atributo de la clase a testear
				//Si es una variable privada la marco como privada
				if (FTCRLUtils.isPrivate(moduleName + "." + varName))
					isPrivate = true;
				//Obtengo su tipo
				varType = FTCRLUtils.getJavaType(moduleName + "." + varName, javaTypesMap);
				//Y cambio su nombre, ya que es en realidad un atributo de la clase principal
				varName = testingVar + "." + varName;
			}

			record = varName;

		} else { //Si no es una variable, debo crear un elemento con ese tipo

			if (record == null) {
				//Elijo un nombre y declaro la variable
				varName = newVarName(var.toLowerCase());
				printDeclaration(var + " " + varName);
				record = varName;
			} else				//Uso un record ya creado
				varName = record;
		}

		//Puede ser que la variable haga referencia a una tabla.
		//En ese caso, obtengo el tipo al que hay que refinar, a partir de los datos de sus columnas
		if (currentTable != null && currentTable.t.equals(var))
			varType = FTCRLUtils.getColumnType(atribute.replaceFirst(".", ""), currentTable);

		//Si es "private" en java, debo usar reflection
		String privateFieldVar = "";
		if (isPrivate){
			//Usamos una variable para el atributo de la clase
			privateFieldVar = newVarName(varName.toLowerCase());
			String field = atribute.substring(1);
			printDeclaration("Field " + privateFieldVar + " = " + record + ".getClass().getDeclaredField(\"" + field + "\")");
			printDeclaration(privateFieldVar + ".setAccessible(true)");
			//Como es private debo crear una nueva variable a usar
			varName = newVarName(varName.toLowerCase());
			printDeclaration(varType + " " + varName);
			atribute = "";
		}

		//Si es un conjunto (o secuencia) y hay que refinar con un WITH
		//hay que iterar sobre sus elementos
		boolean isSet = FTCRLUtils.isSet(zExpr.type) || FTCRLUtils.isSeq(zExpr.type);
		boolean hasWith = (ctx.iExprRefinement().asRefinement() != null) && !ctx.iExprRefinement().asRefinement().refinement().isEmpty();

		if (isSet &&  hasWith) {

			//Calculamos el tipo de cada elemento
			String elemType = FTCRLUtils.elementType(zExpr.type);

			//Iteramos sobre los elementos del conjunto
			Iterator<String> itElements = new common.util.ExprIterator(zExpr.exp);
			int position = 0;
			while (itElements.hasNext()){
				String elem = itElements.next();

				//Si es una lista, debo modificar el elemento transformandolo en una tupla
				if (FTCRLUtils.isSeq(zExpr.type)){
					elem = "(" + (position+1) + "," + elem + ")";
				}

				//Creamos el nuevo reemplazo
				replaceValue = new Replacement(replaceExp, elem, elemType);
				SExpr javaExpr = new SExpr(varName+atribute, varType);
				visitAsRefinement(ctx.iExprRefinement().asRefinement(), replaceValue, record, javaExpr, zExpr, position);

				//Incrementamos la posición del nodo
				//Esto se usa en los array, para saber en que posición va
				position++;
			}
		} else {
			visitIExprRefinement(ctx.iExprRefinement(), replaceValue, record, new SExpr(varName + atribute, varType), zExpr);
		}

		//Si la variable es privada debemos usar reflection
		if (isPrivate){
			printAssignment(privateFieldVar + ".set(" + record + ", " + varName + ")");
			FTCRLUtils.saveReference(record, varName, this);
			return record;
		}

		return varName;
	}

	//@Override
	public Value visitAsRefinement(FTCRLParser.AsRefinementContext ctx, Replacement replaceValue, String record, SExpr javaExpr, SExpr zExpr, int position){

		DataStructContext dataStruct = ctx.dataStruct();
		boolean hasWITH = !ctx.refinement().isEmpty();

		//Si es un LIST
		if (dataStruct.list() != null) {
			if (hasWITH) { //Si tiene WITH
				//Si es una lista, no pasamos ningun record (por eso null), ya que no se utilizan "mas abajo" en el arbol
				String withVariable = refineWITH(ctx.refinement(), replaceValue, null);
				printAssignment(javaExpr.exp + ".add(" + withVariable + ")");
				FTCRLUtils.saveReference(javaExpr.exp + "[" + position + "]", withVariable, this);
			} else {
				refineFromZToJava(zExpr, "LIST", javaExpr);
			}

			//Si es un RECORD
		} else if (dataStruct.getText().equals("RECORD")) {
			//Si es un record, pasamos "mas abajo" en el árbol el record creado
			refineWITH(ctx.refinement(), replaceValue, record);

			//Si es un ARRAY
		} else if (dataStruct.getText().equals("ARRAY")) {
			if (hasWITH) { //Si tiene WITH
				//Si es una array, no pasamos ningun record (por eso null), ya que no se utilizan "mas abajo" en el arbol
				String withVariable = refineWITH(ctx.refinement(), replaceValue, null);
				printAssignment(javaExpr.exp + "[" + position + "] = " + withVariable);
				FTCRLUtils.saveReference(javaExpr.exp + "[" + position + "]", withVariable, this);
			} else {
				refineFromZToJava(zExpr, "ARRAY", javaExpr);
			}

			//Si es un REF
		} else if (dataStruct.reference2() != null) {
			String reference = FTCRLUtils.findReference(zExpr.exp, dataStruct.reference2().iName().getText(), this);
			if (reference != null){
				printAssignment(javaExpr.exp + " = " + reference);
				FTCRLUtils.saveReference(javaExpr.exp, reference, this);
			}

			//Si es un ENUM
		} else if (dataStruct.enumeration() != null) {
			String values;
			if ((values = FTCRLUtils.isFreeType(zExpr.type)) != ""); //Si la expresion de Z es un tipo libre de Z
			FreeTypesRefinement.refine(zExpr, values, javaExpr, dataStruct.enumeration(),this);

			//Si es una TABLE
		} else if (dataStruct.table() != null) {

			RefinementTable table = this.currentTable;
			//'t' es el nombre de la tabla. Es basicamente el nombre del archivo
			String t = FTCRLUtils.extractName(dataStruct.table().fName().getText());
			//if (javaExpr.exp.startsWith("test."))
			//	tableName = "test." + tableName;
			if (table == null || !table.t.equals(t)){
				String c = dataStruct.table().iName().getText();
				String p = dataStruct.table().path().getText();
				String f = dataStruct.table().fName().getText();
				table = new RefinementTable(t, c, p, f, this);
				//Seteamos la nueva table actual (falta ver de almacenar la vieja, para cuando hay tablas dentro de tablas)
				this.currentTable = table;
			}

			if (hasWITH) { //Si tiene WITH

				//Simplemente visito los refinements
				refineWITH(ctx.refinement(), replaceValue, null);

			} else if (FTCRLUtils.getType(zExpr.type).equals("\\cross")){

				//Si no tiene WITH, debe ser una tupla. La cual se refina segun la pagina 46
				refineFromZToJava(zExpr, "TABLE", javaExpr);
			}

			//Imprimimos
			String values = currentTable.printValues();
			currentTable.resetValues();
			printDeclaration(table.stmt + ".executeUpdate(\"insert into " + currentTable.t + " values(" + values + ")\")");
			

		} else if (dataStruct.getText().equals("MAPPING")) { //Si es un MAPPING
			//Debo visitar los refinements,
			//pero separando la parte de la Key del Valor

			//El tipo en Java debe ser un HashMap<A,B>
			String types[] = FTCRLUtils.getInnerType(javaExpr.type).split(",", 2);
			String keyType = types[0];
			String valueType = types[1];

			//Debo dividir la lista de refinements, en sublistas.
			//Una para refinar la clave, y otra el valor.
			List<RefinementContext> rs = ctx.refinement();
			List<RefinementContext> ks = new ArrayList<FTCRLParser.RefinementContext>();
			List<RefinementContext> vs = new ArrayList<FTCRLParser.RefinementContext>();
			
			//Si la key y el valor son del mismo tipo
			//los refinamiento son mitad de cada uno
			int size = rs.size();
			if (keyType.equals(valueType)){
				int i = 0;
				for (; i < size/2; i++)
					ks.add(rs.get(i));
				for (; i < size; i++)
					vs.add(rs.get(i));
			} else { //Sino, veo cuales son de la key y cuales del valor
				for (int i = 0; i < size; i++)
					if (rs.get(i).getText().contains(keyType))
						ks.add(rs.get(i));
					else
						vs.add(rs.get(i));
			}
			
			String key = refineWITH(ks, replaceValue, null);
			String value = refineWITH(vs, replaceValue, null);
			
			printAssignment(javaExpr.exp + ".put(" + key + ", " + value + ")");
		
		} else if (dataStruct.file() != null) { //Si es un FILE
			
			if (!openedFiles.contains(javaExpr.exp)){
				printAssignment(javaExpr.exp + " = open(" + dataStruct.file().path().getText() + ")");
				openedFiles.add(javaExpr.exp);
			}
			
			if (!hasWITH){
				
				SExpr stringExpr = new SExpr("", "String");
				String value = refineFromZToJava(zExpr, "FILE", stringExpr);
				printAssignment("write(" + javaExpr.exp + ", " + value + ")");
				
			} else {
				
				Iterator<RefinementContext> it = ctx.refinement().iterator();
				while (it.hasNext()){
					String var = this.visitRefinement(it.next(), null, null, replaceValue);
					printAssignment("write(" + javaExpr.exp + ", str(" + var + "))");
				}
				
			}
		}

		return null;
	}

	//Este metodo permite visitar un SExprRefinement para obtener su valor y su tipo.
	public SExpr visitSExprRefinement(FTCRLParser.SExprRefinementContext ctx,Replacement replacement){

		//Si simplemente es un SName, debe estar en el replacement o en el Map de Z
		if (ctx.sName()!=null)
			return visitSName(ctx.sName(),replacement);
		//Si es un ZExpr, lo visito y devuelvo su SExpr
		else if(ctx.zExpr()!=null)
			return visitZExpr(ctx.zExpr(),replacement);
		else
			return null;
	}

	//@Override
	public Value visitIExprRefinement(FTCRLParser.IExprRefinementContext ctx, Replacement replacement, String record, SExpr javaExpr, SExpr zExpr){

		if (ctx.asRefinement() != null) {

			//visito el asRefinement, pasando el nombre de la variable y el valor en Z a refinar
			visitAsRefinement(ctx.asRefinement(), replacement, record, javaExpr, zExpr, 0);

		} else {
			refineFromZToJava(zExpr, "BASIC", javaExpr);
		}

		return null;
	}

	//Este metodo permite visitar un ZExpr para obtener su valor y su tipo.
	public SExpr visitZExpr(FTCRLParser.ZExprContext ctx,Replacement replacement){

		if(ctx.zExprSet() != null)
			return visitZExprSet(ctx.zExprSet(),replacement);
		else if (ctx.zExprNum() != null)
			return visitZExprNum(ctx.zExprNum(),replacement);
		else if (ctx.zExprString() != null)
			return visitZExprString(ctx.zExprString(),replacement);
		else
			return null;
	}

	//Este metodo permite visitar un ZExprSet para obtener su valor y su tipo.
	private SExpr visitZExprSet(FTCRLParser.ZExprSetContext ctx,Replacement replacement) {

		//En el primer caso, el ZExprSet se conforma de un SName, y quizas un dotSetOperator
		if (ctx.sName() != null){
			//Del sName debo obtener el SExpr correspondiente
			SExpr s = visitSName(ctx.sName(), replacement);
			//Y luego visito los DotSetOper, pero antes veo si debo hacer el replace
			String sName = ctx.sName().getText();
			List<DotSetOperContext> dot = ctx.dotSetOper();
			int replacePos = -1;
			if (replacement != null && !dot.isEmpty()) {

				//En la primer pasada intento hacer el replace
				for (replacePos++; replacePos < dot.size(); replacePos++){
					//Primero veo si debo hacer el replace
					sName = sName.concat("." + dot.get(replacePos).getText());
					if (sName.equals(replacement.exp)){
						s = new SExpr(replacement.value, replacement.type);
						break;
					}
				}
				//Si di la vuelta completa, "reseteo"
				if (replacePos == dot.size())
					replacePos = -1;
			}
			//Luego visito los DotSetOper que no fueron utilizados en el replace
			//donde se aplican los operadores a las expresiones
			for (replacePos++; replacePos < dot.size(); replacePos++){
				s = visitDotSetOper(dot.get(replacePos), s);
			}

			return s;

		} else if (ctx.setExtension() != null){ //Conjunto por extension
			return new SExpr(ctx.getText(), "\\power\\num");
		}
		return null;
	}

	//Este metodo permite visitar un ZExprNum para obtener su valor y su tipo.
	private SExpr visitZExprNum(FTCRLParser.ZExprNumContext ctx,Replacement replacement) {

		if (ctx.CARD() != null){ //Cardinal
			SExpr sExpr = visitSName(ctx.sName(), replacement);
			ExprIterator card = new ExprIterator(sExpr.exp);
			sExpr.exp = Integer.toString(card.cardinalidad());
			sExpr.type = "\\num";
			return sExpr;
		} else if (ctx.number() != null){ //Es un numero
			return new SExpr(ctx.number().getText(), "\\num");
		} else if (ctx.DIV() != null){ //Div
			SExpr sExprLeft = visitZExprNum(ctx.zExprNum(0), replacement);
			SExpr sExprRight = visitZExprNum(ctx.zExprNum(1), replacement);
			String div = Float.toString((int) (Float.parseFloat(sExprLeft.exp) / Float.parseFloat(sExprRight.exp)));
			return new SExpr(div, "\\num");
		} else if (ctx.SLASH() != null){ //Slash
			SExpr sExprLeft = visitZExprNum(ctx.zExprNum(0), replacement);
			SExpr sExprRight = visitZExprNum(ctx.zExprNum(1), replacement);
			String slash = Float.toString(Float.parseFloat(sExprLeft.exp) / Float.parseFloat(sExprRight.exp));
			return new SExpr(slash, "\\num");
		} else if (ctx.MOD() != null){ //Mod
			SExpr sExprLeft = visitZExprNum(ctx.zExprNum(0), replacement);
			SExpr sExprRight = visitZExprNum(ctx.zExprNum(1), replacement);
			String mod = Float.toString((int) (Float.parseFloat(sExprLeft.exp) % Float.parseFloat(sExprRight.exp)));
			return new SExpr(mod, "\\num");
		} else if (ctx.PLUS() != null){ //Plus
			SExpr sExprLeft = visitZExprNum(ctx.zExprNum(0), replacement);
			SExpr sExprRight = visitZExprNum(ctx.zExprNum(1), replacement);
			String plus = Float.toString(Float.parseFloat(sExprLeft.exp) + Float.parseFloat(sExprRight.exp));
			return new SExpr(plus, "\\num");
		} else if (ctx.MINUS() != null){ //Minus
			SExpr sExprLeft = visitZExprNum(ctx.zExprNum(0), replacement);
			SExpr sExprRight = visitZExprNum(ctx.zExprNum(1), replacement);
			String minus = Float.toString(Float.parseFloat(sExprLeft.exp) - Float.parseFloat(sExprRight.exp));
			return new SExpr(minus, "\\num");
		}

		return null;
	}

	//Este metodo permite visitar un SName para obtener su valor y su tipo.
	public SExpr visitSName(FTCRLParser.SNameContext ctx,Replacement replacement){

		String s = ctx.getText();
		//Si el replacement es el SName, devuelvo directamente su valor y tipo
		if (replacement != null && replacement.exp != null && replacement.exp.equals(s))
			return new SExpr(replacement.value, replacement.type);
		//Y sino lo busco en el Map de Z
		else if (zValuesMap != null && zValuesMap.get(s) != null )
			return new SExpr(zValuesMap.get(s), zTypesMap.get(s));
		//No deberia devolver null
		else
			return null;
	}

	//Este metodo permite visitar un ZExprString para obtener su valor y su tipo.
	private SExpr visitZExprString(FTCRLParser.ZExprStringContext ctx,Replacement replacement) {
		if (ctx.string() != null){ //String
			String string = ctx.string().getText();
			string = string.substring(1, string.length()-1);
			return new SExpr(string, "FTCRLString");
		} else if (ctx.number() != null){ //Number
			return new SExpr(ctx.number().getText(), "\\num");
		} else if (ctx.sName() != null){ //DOT
			SExpr sExpr = visitSName(ctx.sName(), replacement);

			//Y luego visito los DotSetOper, pero antes veo si debo hacer el replace
			String sName = ctx.sName().getText();
			List<DotSetOperContext> dot = ctx.dotSetOper();
			int replacePos = -1;
			if (replacement != null && !dot.isEmpty()) {

				//En la primer pasada intento hacer el replace
				for (replacePos++; replacePos < dot.size(); replacePos++){
					//Primero veo si debo hacer el replace
					sName = sName.concat("." + dot.get(replacePos).getText());
					if (sName.equals(replacement.exp)){
						sExpr = new SExpr(replacement.value, replacement.type);
						break;
					}
				}
				//Si di la vuelta completa, "reseteo"
				if (replacePos == dot.size())
					replacePos = -1;
			}
			//Luego visito los DotSetOper que no fueron utilizados en el replace
			//donde se aplican los operadores a las expresiones
			for (replacePos++; replacePos < dot.size(); replacePos++){
				sExpr = visitDotSetOper(dot.get(replacePos), sExpr);
			}

			//Luego veo si hay un CARD o STR
			if (ctx.CARD() != null){
				ExprIterator card = new ExprIterator(sExpr.exp);
				sExpr.exp = Integer.toString(card.cardinalidad());
				sExpr.type = "\\num";
			} else if (ctx.STR() != null){
				sExpr.exp = sExpr.exp;
				sExpr.type = "FTCRLString";
			}
			return sExpr;

		} else if (ctx.PLUSPLUS() != null){ //++
			//Cada hijo puede ser un FTCRLString o un conjunto
			ParseTree l = ctx.getChild(0);
			SExpr sExprL = new SExpr();
			if (l instanceof ZExprStringContext)
				sExprL = visitZExprString((ZExprStringContext)l, replacement);
			else
				sExprL = visitZExprSet((ZExprSetContext)l, replacement);
			ParseTree r = ctx.getChild(2);
			SExpr sExprR = new SExpr();
			if (r instanceof ZExprStringContext)
				sExprR = visitZExprString((ZExprStringContext)r, replacement);
			else
				sExprR = visitZExprSet((ZExprSetContext)r, replacement);

			//Si alguno es un conjunto, debo procesarlos de forma especial
			if (FTCRLUtils.isSet(sExprL.type) || FTCRLUtils.isSet(sExprR.type)){

				String merge = FTCRLUtils.concatFTCRLStringSets(sExprL, sExprR);
				ExprIterator it = new ExprIterator(merge);
				String set = "";
				SExpr elem = new SExpr();
				String elemType = "";
				while (it.hasNext()){
					String e = it.next();
					ANTLRInputStream in = new ANTLRInputStream(e);
					FTCRLLexer lexer = new FTCRLLexer(in);
					CommonTokenStream tokens = new CommonTokenStream(lexer);
					FTCRLParser parser = new FTCRLParser(tokens);
					SExprRefinementContext tree = parser.sExprRefinement();
					elem = visitSExprRefinement(tree, replacement);
					if (!set.equals(""))
						set += ",";
					else //Solo para el primer "elem"
						elemType = elem.type;
					set += elem.exp;
				}
				return new SExpr("\\{" + set + "\\}", "\\power(" + elemType + ")");

			} else {
				String concat = sExprL.exp + sExprR.exp;
				if (sExprL.type.equals("FTCRLString") || sExprR.type.equals("FTCRLString"))
					return new SExpr(concat, "FTCRLString");
				else
					return new SExpr(concat, "\\num");
			}
		}
		return null;
	}

	//Este metodo permite visitar un DotSetOper para obtener su valor y su tipo.
	//Se agrega el argumento SName, que se utilizará cuando haya más de un DotSetOper
	//para llevar la cuenta de cuando hay que hacer el replace.
	private SExpr visitDotSetOper(DotSetOperContext ctx, SExpr v) {

		//si es una tupla con (,), le pongo corchetes para que sea conjunto y asi poder usar su iterador
		v.exp = (v.exp.charAt(0)=='(')?"{"+v.exp.substring(1, v.exp.length()-1)+"}":v.exp;
		ExprIterator itElements = new common.util.ExprIterator(v.exp);

		String oper = ctx.getText();
		if(oper.contains("DOM")){ //Operador DOM
			String value = itElements.next();
			String type = FTCRLUtils.getChildType(v.type, 0); //A \cross B --> A
			return new SExpr(value, type);
		}
		else if(oper.contains("RAN")){ //Operador RAN
			itElements.next();
			String value = itElements.next();
			String type = FTCRLUtils.getChildType(v.type, 1); //A \cross B --> B
			return new SExpr(value, type);

		}
		else if(oper.contains("#")){ //Operador Cardinalidad
			String value = String.valueOf(itElements.cardinalidad());
			String type = "\\num";
			return new SExpr(value, type);
		}
		else if (ctx.digit() != null) { //Operador "."
			int atributeNumber = Integer.parseInt(ctx.digit().getText());
			for (int i = 1; i < atributeNumber; i++)
				itElements.next();
			String value = itElements.next();
			String type = FTCRLUtils.getChildType(v.type, atributeNumber-1);
			return new SExpr(value, type);
		}
		//si era un conjunto o una tupla devuelvo o un conjunto o un elemento
		return null;
	}

	private String refineWITH(List<RefinementContext> refinements, Replacement replace, String record) {

		//En casos donde se generen varias variables, se devuelven en la lista
		Iterator<RefinementContext> it = refinements.iterator();
		while (it.hasNext()){

			record = this.visitRefinement(it.next(), null, record, replace);
		}

		return record;
	}

	//Refina el zValue a su valor correspondiente en Java
	//Debe refinar el valor de Z ZValue, al tipo toType. Y realizar lo que deba en typeVariable
	//Por ejemplo, si ZValue es una lista \langle 1, 2, 3 \rangle y toType es "LIST"
	//y typeVariable es l,
	//debera hacer las asignaciones: l.add(1); l.add(2); l.add(3) 
	public String refineFromZToJava(SExpr zExpr, String toType, SExpr javaExpr) {

		//En base al tipo en Z de sValue debo utilizar una determinada clase para refinarla
		String values;
		if (zExpr.type.equals("\\num") || zExpr.type.equals("\\nat"))
			return NumRefinement.refine(zExpr, toType, javaExpr, this);
		else if (FTCRLUtils.isSet(zExpr.type))
			return SetRefinement.refine(zExpr, toType, javaExpr, this);
		else if (FTCRLUtils.isSeq(zExpr.type)){
			//Si es una lista refino como si fuese un conjunto
			zExpr.type = "\\power(" + FTCRLUtils.getChildType(zExpr.type,0) + ")";
			zExpr.exp = zExpr.exp.replaceFirst("^\\\\langle", "\\\\{");
			zExpr.exp = zExpr.exp.replaceFirst("\\\\rangle$", "\\\\}");
			return SetRefinement.refine(zExpr, toType, javaExpr, this);
		} else if (zExpr.type.equals("FTCRLString")){
			return FTCRLStringRefinement.refine(zExpr, toType, javaExpr, this);
		} else if(FTCRLUtils.isBasicType(zExpr.type)){
			//Es un tipo basico
			return GivenTypeRefinement.refine(zExpr, toType, javaExpr, this);
		} else if ((values = FTCRLUtils.isFreeType(zExpr.type)) != ""){
			return FreeTypesRefinement.refine(zExpr, values, javaExpr, null, this);
		} else if (FTCRLUtils.isCrossProduct(zExpr.type)){
			return CrossProductRefinement.refine(zExpr, toType, javaExpr, this);
		}
		return "";
	}

	//Este metodo se utiliza para determinar el caso de prueba que se utilizará
	//Almacena los valores de las variables Z en zValuesMap, y sus tipos en ZTypesMap
	public void assignTCase(String tcase){

		//this.zValuesMap = FTCRLUtils.createZValuesMap(tcase);
		this.zValuesMap = FTCRLUtils.createZValuesMap(tcase);
		this.zTypesMap = FTCRLUtils.createZTypesMap(tcase);
	}

	//Este metodo se utiliza para determinar los tipos de las variables java
	//Almacena los tipos de las variables Z en javaTypesMap
	public void extractJavaTypes(String javaCode){

		this.javaTypesMap = FTCRLUtils.createJavaTypesMap(javaCode);
	}

	public String newVarName(String name) {

		name += varNumber;
		varNumber++;
		return name;
	}

}