package client.blogic.testing.refinamiento.javaparser;

import java.util.HashMap;
import java.util.Iterator;

import client.blogic.testing.refinamiento.javaparser.Java7Parser.EnumBodyContext;
import client.blogic.testing.refinamiento.javaparser.Java7Parser.EnumConstantContext;
import client.blogic.testing.refinamiento.javaparser.Java7Parser.EnumDeclarationContext;
import client.blogic.testing.refinamiento.javaparser.Java7Parser.FieldDeclarationContext;
import client.blogic.testing.refinamiento.javaparser.Java7Parser.LocalVariableDeclarationContext;
import client.blogic.testing.refinamiento.javaparser.Java7Parser.NormalClassDeclarationContext;
import client.blogic.testing.refinamiento.javaparser.Java7Parser.NormalParameterDeclContext;
import client.blogic.testing.refinamiento.javaparser.Java7Parser.VariableDeclaratorContext;

public class TypeExtractorVisitor extends Java7ParserBaseVisitor{

	HashMap<String,String> map; //Tipos de las variables
	HashMap<String,String> enumTypes; //Tipos "enum"
	
	public TypeExtractorVisitor(){
		this.map = new HashMap<String,String>();
		this.enumTypes = new HashMap<String,String>();
		//this.enumTypes.put("Day", "{Lunes,Martes,Miercoles,Jueves}");
	}
	
	public HashMap<String,String> getMap(){
		return this.map;
	}
	
	public HashMap<String,String> getEnumTypes(){
		return this.enumTypes;
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
		String type = ctx.type().getText();
		Iterator<VariableDeclaratorContext> it = ctx.variableDeclarator().iterator();
		while (it.hasNext()) {
			String var = it.next().Identifier().getText();
			map.put(visitedClass + "." + var,type);
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
			String var = it.next().Identifier().getText();
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
