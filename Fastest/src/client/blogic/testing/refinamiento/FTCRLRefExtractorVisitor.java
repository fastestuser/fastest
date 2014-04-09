package client.blogic.testing.refinamiento;

import java.util.LinkedList;

import client.blogic.testing.refinamiento.FTCRLParser.Reference2Context;

public class FTCRLRefExtractorVisitor extends FTCRLBaseVisitor<Value> {

	
	//Variables que deben ser almacenadas, porque van a ser referenciadas
	private static LinkedList<String> referencedVars = new LinkedList<String>();
	
	public LinkedList<String> getReferencedVars(){
		return referencedVars;
	}
	
	@Override
	public Value visitReference2(Reference2Context ctx){

		String ref = FTCRLUtils.extractName(ctx.iName().getText());
		if (!referencedVars.contains(ref))
			referencedVars.add(ref);

		return null;
	}	

}