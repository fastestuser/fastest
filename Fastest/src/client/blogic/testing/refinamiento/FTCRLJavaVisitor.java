package client.blogic.testing.refinamiento;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import client.blogic.testing.refinamiento.FTCRLParser.DataStructContext;
import client.blogic.testing.refinamiento.FTCRLParser.INameContext;
import client.blogic.testing.refinamiento.FTCRLParser.LawsContext;
import client.blogic.testing.refinamiento.FTCRLParser.PLCodeContext;
import client.blogic.testing.refinamiento.FTCRLParser.PreambleContext;
import client.blogic.testing.refinamiento.FTCRLParser.RefinementContext;
import client.blogic.testing.refinamiento.FTCRLParser.RefinementSentenceContext;
import client.blogic.testing.refinamiento.FTCRLParser.SNameContext;
import client.blogic.testing.refinamiento.FTCRLParser.UutContext;

public class FTCRLJavaVisitor extends FTCRLBaseVisitor<Value> {

	private String declarationList = "";
	private String assignmentList = "";
	private HashMap<String,String> zValuesMap = new HashMap<String,String>();

	@Override
	public Value visitRefinementRule(FTCRLParser.RefinementRuleContext ctx){

		//Analizamos el preambulo
		PreambleContext preamble = ctx.preamble();
		this.visit(preamble);
		//Despues del preambulo, imprimimos la definicion de la clase main
		System.out.println("public class main {\n" +
				"public static void main(String[]) {\n" +
				"Init init = new Init();" + 
				"{System.out.print(\"Initialization error\"); System.exit(0);}");

		//Analizamos las laws
		LawsContext laws = ctx.laws();
		this.visit(laws);
		System.out.print(declarationList);
		System.out.print(assignmentList);

		//Analizamos la uut
		UutContext uut = ctx.uut();
		this.visit(uut);

		//Cerramos la clase Java y el metodo Main
		System.out.println("}\n}");

		return null;
	}	

	@Override
	public Value visitPreamble(FTCRLParser.PreambleContext ctx){

		List<PLCodeContext> list = ctx.pLCode();
		for (PLCodeContext pl : list) {
			System.out.println(pl.anychar().getText());
		}

		return null;
	}

	@Override
	public Value visitUut(FTCRLParser.UutContext ctx){


		List<INameContext> list = ctx.iName();
		int size = list.size();

		//El ultimo iname, luego de "MODULE", es el nombre de la clase java
		String javaClass = list.get(size-1).getText();
		System.out.println(javaClass + " test = new " + javaClass + "();" );

		//Imprimimos la llamada al método de la clase
		System.out.print("test." + list.get(0).getText() + "(");

		if (size > 2) {
			int i = 1;
			System.out.print(list.get(i).getText());
			for (i = 2; i < size -1; i++) {
				System.out.print("," + list.get(i).getText());
			}
		}

		System.out.println(");");
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
	public Value visitAsRefinement(FTCRLParser.AsRefinementContext ctx, Replacement replaceValue, String record, String varName, String sValue, int position){
		
		DataStructContext dataStruct = ctx.dataStruct();
		
		//Si es una lista
		if (dataStruct.list() != null) {
			if (!ctx.refinement().isEmpty()) {
				//Si es una lista, no pasamos ningun record (por eso null), ya que no se utilizan "mas abajo" en el arbol
				String withVariable = refineWITH(ctx.refinement(), replaceValue, null);
				assignmentList = assignmentList.concat(varName + ".add( " + withVariable + ");\n");
			} else {
				refineFromZToJava(sValue, "LIST", varName);
			}
			
		//Si es un record
		} else if (FTCRLUtils.isRecord(dataStruct.getText())) {
			//Si es un record, pasamos "mas abajo" en el árbol el record creado
			refineWITH(ctx.refinement(), replaceValue, record);
		
			//Si es un array
		} else if (FTCRLUtils.isArray(dataStruct.getText())) {
			if (!ctx.refinement().isEmpty()) {
				//Si es una array, no pasamos ningun record (por eso null), ya que no se utilizan "mas abajo" en el arbol
				String withVariable = refineWITH(ctx.refinement(), replaceValue, null);
				assignmentList = assignmentList.concat(varName + "[" + position + "] = " + withVariable + ";\n");
			} else {
				refineFromZToJava(sValue, "ARRAY", varName);
			}
		}
		
		return null;
	}
	 
	
	//@Override
	public Value visitIExprRefinement(FTCRLParser.IExprRefinementContext ctx, Replacement replacement, String record, String varName, String sValue){

		if (ctx.asRefinement() != null) {
			//visito el asRefinement, pasando el nombre de la variable y el valor en Z a refinar
			visitAsRefinement(ctx.asRefinement(), replacement, record, varName, sValue, -1);
		} else {
			refineFromZToJava(sValue, "BASIC", varName);
		}

		return null;
	}
	 
	//@Override
	public String visitRefinement(FTCRLParser.RefinementContext ctx, List<String> zVars, String record, Replacement replaceValue){

		String varName = "";
		//Calculamos el valor del lado izquierdo
		String sValue = "";
		String replaceExp = "";
		if (ctx.sExprRefinement() != null) {
			//Si hay SExpr, calculamos su valor
			replaceExp = ctx.sExprRefinement().getText();
			sValue = FTCRLUtils.sValue(replaceExp, replaceValue, zValuesMap);
		} else {
			//Si no hay SExpr, debe obtener el valor de la variable Z
			replaceExp = zVars.get(0);
			sValue = FTCRLUtils.sValue(replaceExp, replaceValue, zValuesMap); 
		}

		//Observamos el lado derecho
		//Puede ser una variable o un tipo
		String refS = ctx.iExprRefinement().iName().getText();
		String recordType = FTCRLUtils.recordType(refS);
		String recordAtribute = FTCRLUtils.recordAtribute(refS);

		//Debo refinar element a refType
		if (Character.isLowerCase(refS.charAt(0))){ //Si es una variable, no debo crear un record
			varName = recordType;
		} else { //Si es un tipo, debo crear un elemento del mismo

			if (record == null) {
				//Elijo un nombre random
				varName = recordType.toLowerCase() + ((int) (Math.random()*100));
				declarationList = declarationList.concat(recordType + " " + varName + ";\n");
				record = varName;
			} else {
				//Uso un record ya creado
				varName = record; //Esto no deberia ser null
			}
			//assignmentList = assignmentList.concat(varName + recordAtribute + " = " + element + ";\n");
		}
		
		
		//Si es un conjunto y ademos tiene WITH
		if (FTCRLUtils.isSet(sValue) && (ctx.iExprRefinement().asRefinement() != null) 
				&& !ctx.iExprRefinement().asRefinement().refinement().isEmpty()) {
			Iterator<String> itElements = new common.util.ExprIterator(sValue);
			//Iteramos sobre los elementos del conjunto
			int position = 0;
			while (itElements.hasNext()){
				String elem = itElements.next();

				//Creamos el nuevo reemplazo
				replaceValue = new Replacement(replaceExp, elem);
				visitAsRefinement(ctx.iExprRefinement().asRefinement(), replaceValue, record, varName, sValue, position);
				
				//Incrementamos la posición del nodo
				//Esto se usa en los array, para saber en que posición va
				position++;
			}
			//Si no es un conjunto pero tiene WITH
		} else if (!FTCRLUtils.isSet(sValue) && (ctx.iExprRefinement().asRefinement() != null) 
				&& !ctx.iExprRefinement().asRefinement().refinement().isEmpty()) {

			//Creamos el nuevo reemplazo
			replaceValue = new Replacement(replaceExp, sValue);
			visitAsRefinement(ctx.iExprRefinement().asRefinement(), replaceValue, record, varName, sValue, 0);

		//No tiene WITH
		} else {
			
			visitIExprRefinement(ctx.iExprRefinement(), null, record, varName + recordAtribute, sValue);
			
		}

		return varName;
	}



	/*	
	//@Override
	public Value visitRefinement(FTCRLParser.RefinementContext ctx, List<String> zVars, List<String> records){

		boolean createRecords = false;
		Iterator<String> itRecords = records.iterator(); //Se usa cuando ya estan creados los records a usar
		if (records.isEmpty())
			createRecords = true;

		String value = "";

		//Si tiene sExprRefinement, hay que calcular su valor (lado izquierdo)
		if (ctx.sExprRefinement() != null) {
			//Calculamos su valor
			value = FTCRLUtils.sValue(ctx.sExprRefinement().getText(), zValuesMap);

		} else {//Y sino el valor es el de la variable Z que se encuentra en zVars
			value = FTCRLUtils.sValue(zVars.get(0), zValuesMap);
		}

		Iterator<String> itElements;
		//Vemos si es un conjunto
		boolean isSet = FTCRLUtils.isSet(value);
		if (isSet){ //si es un conjunto, debemos iterar sobre sus elementos
			//List<String> setElements = FTCRLUtils.setElements(value);
			value = value.substring(1, value.length()-2) + "}";
			itElements = new common.util.ExprIterator(value);
		} else { //si no es un conjunto, solo hay un valor
			List<String> elements = new ArrayList<String>();
			elements.add(value);
			itElements = elements.iterator();
		}

		while (itElements.hasNext()){//Luego iteramos sobre estos valores
			String element = itElements.next();

			//Determino primero a que refino (lado derecho)
			//Puede ser una variable o un tipo
			String refS = ctx.iExprRefinement().iName().getText();
			String recordType = FTCRLUtils.recordType(refS);
			String recordAtribute = FTCRLUtils.recordAtribute(refS);
			String varName = "";

			//Debo refinar element a refType
			if (Character.isLowerCase(refS.charAt(0))){ //Si es una variable, no debo crear un record
				varName = recordType;
			} else { //Si es un tipo, debo crear un elemento del mismo

				if (createRecords) {
					//Elijo un nombre random
					varName = recordType.toLowerCase() + ((int) (Math.random()*100));
					declarationList = declarationList.concat(recordType + " " + varName + ";\n");
					records.add(varName);
				} else {
					//Uso un record ya creado
					varName = itRecords.next(); //Esto no deberia ser null
					if (varName == null)
						System.out.println("ERROR: conjuntos en una misma regla WITH con distinta cardinalidad");
				}
				//assignmentList = assignmentList.concat(varName + recordAtribute + " = " + element + ";\n");
			}
			//Visito el IExprRefinement pasando el nombre y atributo de la variable y el valor a refinar de Z
			this.visitIExprRefinement(ctx.iExprRefinement(), varName + recordAtribute, element);
		} 

		return null;
	}
	 */
	private String refineWITH(List<RefinementContext> refinements, Replacement replace, String record) {

		//List<String> createdRecords = new LinkedList<String>();

		Iterator<RefinementContext> it = refinements.iterator();
		while (it.hasNext()){

			//Esta mal la parte dde ZValue
			//ArrayList<String> values = new ArrayList<String>();
			//values.add(zValue);
			record = this.visitRefinement(it.next(), null, record, replace);
		}

		return record;
	}

	//Refina el zValue a su valor correspondiente en Java
	//Debe refinar el valor de Z ZValue, al tipo toType. Y realizar lo que deba en typeVariable
	//Por ejemplo, si ZValue es una lista \langle 1, 2, 3 \rangle y toType es "LIST"
	//y typeVariable es l,
	//debera hacer las asignaciones: l.add(1); l.add(2); l.add(3) 
	private void refineFromZToJava(String ZValue, String toType, String typeVariable) {
		//Esta hardcodeada

		if (toType.equals("LIST")){
			assignmentList = assignmentList.concat(typeVariable + ".add(" + "refinamientoJoa1" + ");\n");
			assignmentList = assignmentList.concat(typeVariable + ".add(" + "refinamientoJoa2" + ");\n");
		} else {
			assignmentList = assignmentList.concat(typeVariable + " = " + "refinamientoJoa" + ";\n");
		}
	}

	//Este metodo se utiliza para determinar el caso de prueba que se 
	public void assignTCase(String tcase){

		this.zValuesMap = FTCRLUtils.createZValuesMap(tcase);
	}

}