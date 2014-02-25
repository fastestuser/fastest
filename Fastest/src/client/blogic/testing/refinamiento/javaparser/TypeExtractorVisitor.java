package client.blogic.testing.refinamiento.javaparser;

import java.util.HashMap;
import java.util.Iterator;

import client.blogic.testing.refinamiento.javaparser.Java7Parser.FieldDeclarationContext;
import client.blogic.testing.refinamiento.javaparser.Java7Parser.LocalVariableDeclarationContext;
import client.blogic.testing.refinamiento.javaparser.Java7Parser.NormalClassDeclarationContext;
import client.blogic.testing.refinamiento.javaparser.Java7Parser.NormalParameterDeclContext;
import client.blogic.testing.refinamiento.javaparser.Java7Parser.VariableDeclaratorContext;

public class TypeExtractorVisitor extends Java7ParserBaseVisitor{

	HashMap<String,String> map;
	
	public TypeExtractorVisitor(HashMap<String, String> map){
		this.map = map;
	}
	
	public HashMap<String,String> getMap(){
		return this.map;
	}
	
private String visitedClass = "";
	
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
	
}
