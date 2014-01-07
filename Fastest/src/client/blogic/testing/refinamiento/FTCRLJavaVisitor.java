package client.blogic.testing.refinamiento;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import client.blogic.testing.refinamiento.FTCRLParser.DataStructContext;
import client.blogic.testing.refinamiento.FTCRLParser.INameContext;
import client.blogic.testing.refinamiento.FTCRLParser.LawsContext;
import client.blogic.testing.refinamiento.FTCRLParser.PLCodeContext;
import client.blogic.testing.refinamiento.FTCRLParser.PreambleContext;
import client.blogic.testing.refinamiento.FTCRLParser.RefinementContext;
import client.blogic.testing.refinamiento.FTCRLParser.UutContext;

public class FTCRLJavaVisitor extends FTCRLBaseVisitor<Value> {

	private String declarationList = "";
	private String asignementList = "";

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
		System.out.print(asignementList);

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

	//@Override
	public Value visitAsRefinement(FTCRLParser.AsRefinementContext ctx, String varName){

		DataStructContext dataStruct = ctx.dataStruct();
		//Si es una lista..
		if (dataStruct.list() != null) {
			//Hay que llenar la LinkedList, con los nodos creados en el WITH
			List<String> createdNodes = this.refineWITH(ctx.refinement());
			Iterator<String> it = createdNodes.iterator();
			while (it.hasNext()) {
				asignementList = asignementList.concat(varName + ".add(" + it.next() + ");\n");
			}
		} else if (FTCRLUtils.isArray(dataStruct.getText())) { //Si es un ARRAY
			//Hay que llenar el Array, con los nodos creados en el WITH
			List<String> createdNodes = this.refineWITH(ctx.refinement());
			Iterator<String> it = createdNodes.iterator();
			int position = 0;
			while (it.hasNext()) {
				asignementList = asignementList.concat(varName + "[" + position + "] = " + it.next() + ";\n");
				position++;
			}
		}

		return null;
	}

	@Override
	public Value visitIExprRefinement(FTCRLParser.IExprRefinementContext ctx){

		if (ctx.asRefinement() != null) {
			//visito el asRefinement, pasando el nombre de la variable
			visitAsRefinement(ctx.asRefinement(), ctx.iName().getText());
		}

		return new Value(ctx.iName().getText());
	}
	
	//@Override
	public Value visitIExprRefinement(FTCRLParser.IExprRefinementContext ctx, String recordName){

		if (ctx.asRefinement() != null) {
			//visito el asRefinement, pasando el nombre de la variable
			visitAsRefinement(ctx.asRefinement(), recordName);
		}

		return new Value(recordName);
	}

	//@Override
	public Value visitRefinement(FTCRLParser.RefinementContext ctx, List<String> records){

		boolean createRecords = false;
		Iterator<String> itRecords = records.iterator(); //Se usa cuando ya estan creados los records a usar
		if (records.isEmpty())
			createRecords = true;

		//Determino primero a que refino (lado derecho)
		//Value ref = this.visit(ctx.iExprRefinement());
		//String refS = ref.asString(); //cdata.uid
		//String refType = FTCRLUtils.getType(refS); //String

		//Si tiene sExprRefinement, hay que calcular su valor (lado izquierdo)
		if (ctx.sExprRefinement() != null) {
			//Calculamos su valor
			String value = FTCRLUtils.sValue(ctx.sExprRefinement().getText());
			//Vemos si es un conjunto
			boolean isSet = FTCRLUtils.isSet(value);
			if (isSet){ //si es un conjunto, debemos iterar sobre sus elementos
				List<String> setElements = FTCRLUtils.setElements(value);
				Iterator<String> it = setElements.iterator();
				while (it.hasNext()){
					String element = it.next();
					
					//Determino primero a que refino (lado derecho)
					String refS = ctx.iExprRefinement().iName().getText();
					//String refS = ref.asString(); //cdata.uid
					//String refType = FTCRLUtils.getType(refS); //String
					
					//Debo refinar element a refType, y almacenarlo en un record refS
					//Entonces primero creo un record, el tipo del record lo obtengo de refS
					if (createRecords) {
						String recordType = FTCRLUtils.recordType(refS);
						String recordAtribute = FTCRLUtils.recordAtribute(refS);
						//Elijo un nombre random
						String recordName = recordType + ((int) (Math.random()*100));
						
						this.visitIExprRefinement(ctx.iExprRefinement(), recordName + recordAtribute);
						
						declarationList = declarationList.concat(recordType + " " + recordName + " = new " + recordType + "();\n");
						asignementList = asignementList.concat(recordName + recordAtribute + " = " + element + ";\n");
						records.add(recordName);
					} else {
						//Uso un record ya creado
						String nodeName = itRecords.next(); //Esto no deberia ser null
						if (nodeName == null)
							System.out.println("ERROR: conjuntos en una misma regla WITH con distinta cardinalidad");
						String recordAtribute = FTCRLUtils.recordAtribute(refS);
						asignementList = asignementList.concat(nodeName + recordAtribute + " = " + element + ";\n");
					}
				}
			} else { //si no es un conjunto, no hay que iterar

			}

		}

		return null;
	}

	@Override
	public Value visitRefinement(FTCRLParser.RefinementContext ctx){
		//Determino primero a que refino (lado derecho)
		Value ref = this.visit(ctx.iExprRefinement());
		String refS = ref.asString(); //l
		String refType = FTCRLUtils.getType(refS); //int

		//Si tiene sExprRefinement, hay que calcular su valor (lado izquierdo)
		if (ctx.sExprRefinement() != null) {
			//Calculamos su valor
			String value = FTCRLUtils.sValue(ctx.sExprRefinement().getText());
			//Debo refinar element a refType, y almacenarlo en la variable
			asignementList = asignementList.concat(refS + " = " + value + ";\n");
		}
		return null;
	}

		private List<String> refineWITH(List<RefinementContext> refinements) {

			List<String> createdRecords = new LinkedList<String>();

			Iterator<RefinementContext> it = refinements.iterator();
			while (it.hasNext()){
				this.visitRefinement(it.next(), createdRecords);
			}

			return createdRecords;
		}

	}