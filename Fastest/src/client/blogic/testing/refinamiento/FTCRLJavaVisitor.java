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

		//Veamos si es una lista
		DataStructContext dataStruct = ctx.dataStruct();
		//Si es una lista..
		if (dataStruct.list() != null) {
			//Hay que llenar la LinkedList, con los nodos creados en el WITH
			List<String> createdNodes = this.refineWITH(ctx.refinement());
			Iterator<String> it = createdNodes.iterator();
			while (it.hasNext()) {
				System.out.println(varName + ".add(" + it.next() + ");");
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
	public Value visitRefinement(FTCRLParser.RefinementContext ctx, List<String> records){
		
		//Determino primero, a que refino
		Value ref = this.visit(ctx.iExprRefinement());
		String refS = ref.asString(); //cdata.uid
		
		
		//Si tiene sExprRefinement, hay que calcular su valor
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
				}
			} else { //si no es un conjunto, no hay que iterar
				
			}
			
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