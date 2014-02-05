package client.blogic.testing.refinamiento;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
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
			this.visitRefinement(ctx.refinement(), zVars, new ArrayList<String>());

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
	public Value visitAsRefinement(FTCRLParser.AsRefinementContext ctx, String varName, String ZValue){
		DataStructContext dataStruct = ctx.dataStruct();
		//Si es una lista..
		if (dataStruct.list() != null) {
			List<String> createdNodes = new ArrayList<String>();
			if (ctx.refinement().isEmpty()) { //No tiene WITH
				createdNodes = FTCRLUtils.refineFromZToJava(ZValue);
			} else {
				//Si tiene WITH Hay que llenar la LinkedList, con los nodos creados en el WITH
				List<RefinementContext> refinement = ctx.refinement();
				createdNodes = this.refineWITH(refinement, ZValue);
			}
			Iterator<String> it = createdNodes.iterator();
			while (it.hasNext()) {
				assignmentList = assignmentList.concat(varName + ".add(" + it.next() + ");\n");
			}
		} else if (FTCRLUtils.isArray(dataStruct.getText())) { //Si es un ARRAY
			//Hay que llenar el Array, con los nodos creados en el WITH
			List<String> createdNodes = this.refineWITH(ctx.refinement(), ZValue);
			Iterator<String> it = createdNodes.iterator();
			int position = 0;
			while (it.hasNext()) {
				assignmentList = assignmentList.concat(varName + "[" + position + "] = " + it.next() + ";\n");
				position++;
			}
		} else if (FTCRLUtils.isRecord(dataStruct.getText())) { //Si es un RECORD
			//Hay que llenar el Record, con los nodos creados en el WITH (esta bien este comentario??)
			List<String> createdNodes = this.refineWITH(ctx.refinement(), ZValue);
			Iterator<String> it = createdNodes.iterator();
			//Podemos asumir que como es un RECORD, solo habrá un nodo en el iterador
			if (it.hasNext()) {
				assignmentList = assignmentList.concat(varName + " = " + it.next() + ";\n");
			}
		}

		return null;
	}

	//@Override
	public Value visitIExprRefinement(FTCRLParser.IExprRefinementContext ctx, String recordName, String ZValue){

		if (ctx.asRefinement() != null) {
			//visito el asRefinement, pasando el nombre de la variable y el valor en Z a refinar
			visitAsRefinement(ctx.asRefinement(), recordName, ZValue);
		} else {
			assignmentList = assignmentList.concat(recordName + " = " + FTCRLUtils.refineFromZToJava(ZValue) + ";\n");
		}

		return new Value(recordName);
	}

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
					declarationList = declarationList.concat(recordType + " " + varName + /*" = new " + recordType + ()*/";\n");
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

	private List<String> refineWITH(List<RefinementContext> refinements, String zValue) {

		List<String> createdRecords = new LinkedList<String>();

		Iterator<RefinementContext> it = refinements.iterator();
		while (it.hasNext()){

			//Esta mal la parte dde ZValue
			ArrayList<String> values = new ArrayList<String>();
			values.add(zValue);
			this.visitRefinement(it.next(), values, createdRecords);
		}

		return createdRecords;
	}
	
	//Este metodo se utiliza para determinar el caso de prueba que se 
	public void assignTCase(String tcase){
		
		this.zValuesMap = FTCRLUtils.createZValuesMap(tcase);
	}

}