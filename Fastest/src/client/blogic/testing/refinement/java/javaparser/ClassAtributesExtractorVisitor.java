package client.blogic.testing.refinement.java.javaparser;

import java.util.Iterator;
import java.util.LinkedList;

import client.blogic.testing.refinement.SExpr;
import client.blogic.testing.refinement.java.javaparser.Java7Parser.FieldDeclarationContext;
import client.blogic.testing.refinement.java.javaparser.Java7Parser.NormalClassDeclarationContext;
import client.blogic.testing.refinement.java.javaparser.Java7Parser.VariableDeclaratorContext;

public class ClassAtributesExtractorVisitor extends Java7ParserBaseVisitor{

	LinkedList<SExpr> atributes;
	String className = "";
	
	public ClassAtributesExtractorVisitor(String className){
		this.atributes = new LinkedList<SExpr>();
		this.className = className;
	}
	
	public LinkedList<SExpr> getAtributes(){
		return this.atributes;
	}
	
	@Override
	public Object visitNormalClassDeclaration(NormalClassDeclarationContext ctx){
		if (className.equals(ctx.Identifier().getText()));
			return visitChildren(ctx);
	}
	
	@Override
	public Object visitFieldDeclaration(FieldDeclarationContext ctx){
		String type = ctx.type().getText(); //El tipo de la variable
		
		Iterator<VariableDeclaratorContext> it = ctx.variableDeclarator().iterator();
		while (it.hasNext()) {
			VariableDeclaratorContext elem = it.next();
			//Cargamos el tipo como Array si tiene "[]"
			int i = elem.LBRACKET().size();
			for (int j = 0; j < i; j++)
				type = type.concat("[]");
			String var = elem.Identifier().getText();
			atributes.add(new SExpr(var,type));
		}
		return null;
	}
}
