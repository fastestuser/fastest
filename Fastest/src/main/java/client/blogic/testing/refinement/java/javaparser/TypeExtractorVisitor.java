package client.blogic.testing.refinement.java.javaparser;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

import client.blogic.testing.refinement.java.javaparser.Java7Parser.EnumConstantContext;
import client.blogic.testing.refinement.java.javaparser.Java7Parser.EnumDeclarationContext;
import client.blogic.testing.refinement.java.javaparser.Java7Parser.FieldDeclarationContext;
import client.blogic.testing.refinement.java.javaparser.Java7Parser.LocalVariableDeclarationContext;
import client.blogic.testing.refinement.java.javaparser.Java7Parser.NormalClassDeclarationContext;
import client.blogic.testing.refinement.java.javaparser.Java7Parser.NormalParameterDeclContext;
import client.blogic.testing.refinement.java.javaparser.Java7Parser.VariableDeclaratorContext;

public class TypeExtractorVisitor extends Java7ParserBaseVisitor{

	HashMap<String,String> map; //Tipos de las variables
	HashMap<String,String> enumTypes; //Tipos "enum"
	LinkedList<String> privateVars; //Variables "private"
	
	public TypeExtractorVisitor(){
		this.map = new HashMap<String,String>();
		this.enumTypes = new HashMap<String,String>();
		this.privateVars = new LinkedList<String>();
	}
	
	public HashMap<String,String> getMap(){
		return this.map;
	}
	
	public HashMap<String,String> getEnumTypes(){
		return this.enumTypes;
	}
	
	public LinkedList<String> getPrivateVars(){
		return this.privateVars;
	}
	
	private String visitedClass = "";
	private String visitedEnumType = "";
	
	@Override
	public Object visitNormalClassDeclaration(NormalClassDeclarationContext ctx){
		//System.out.println("Visitando: " + ctx.Identifier().getText());
		visitedClass = ctx.Identifier().getText();
		
		return visitChildren(ctx);
	}
	
	@Override
	public Object visitFieldDeclaration(FieldDeclarationContext ctx){
		String type = ctx.type().getText(); //El tipo de la variable
		boolean isPublic = false; //Para saber si la variable es privada o publica
		String modifiers = ctx.modifiers().getText();//Los modificadores
		if (modifiers.contains("public"))
			isPublic = true;
		
		Iterator<VariableDeclaratorContext> it = ctx.variableDeclarator().iterator();
		while (it.hasNext()) {
			VariableDeclaratorContext elem = it.next();
			//Cargamos el tipo como Array si tiene "[]"
			int i = elem.LBRACKET().size();
			for (int j = 0; j < i; j++)
				type = type.concat("[]");
			String var = elem.Identifier().getText();
			map.put(visitedClass + "." + var,type);
			if (!isPublic) //Si no es publica, debo agregarla a la lista de variables privadas
				privateVars.add(visitedClass + "." + var);
		}
		return null;
	}
	
	@Override
	public Object visitNormalParameterDecl(NormalParameterDeclContext ctx){
		String type = ctx.type().getText();
		String var = ctx.Identifier().getText();
		map.put(var, type);
		
		return null;
	}
	
	@Override
	public Object visitLocalVariableDeclaration(LocalVariableDeclarationContext ctx){
		String type = ctx.type().getText();
		Iterator<VariableDeclaratorContext> it = ctx.variableDeclarator().iterator();
		while (it.hasNext()) {
			VariableDeclaratorContext elem = it.next();
			//Cargamos el tipo como Array si tiene "[]"
			int i = elem.LBRACKET().size();
			for (int j = 0; j < i; j++)
				type = type.concat("[]");
			String var = elem.Identifier().getText();
			map.put(var, type);
		}
		
		return null;
	}
	
	@Override
	public Object visitEnumDeclaration(EnumDeclarationContext ctx){
		String typeName = ctx.Identifier().getText();
		visitedEnumType = typeName;
		enumTypes.put(typeName, "{}");
		return visitChildren(ctx);
	}
	
	@Override
	public Object visitEnumConstant(EnumConstantContext ctx){
		String enumConstant = ctx.Identifier().getText();
		String constants = enumTypes.get(visitedEnumType);
		if (constants.length() > 2) //Tengo que poner la comma (",")
			constants = constants.substring(0, constants.length()-1) + "," + enumConstant + "}";
		else
			constants = constants.substring(0, constants.length()-1) + enumConstant + "}";
		
		enumTypes.put(visitedEnumType, constants);
		//System.out.println("ENUM: " + visitedEnumType + " - " + constants);
		return null;
	}
	
}
