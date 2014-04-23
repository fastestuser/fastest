//Esta clase define las reglas de refinamiento para refinar desde el lenguaje Z
//una expresion de tipo cross product. Cada método define el comportamiento basandose
//en el tipo en Java y FTCRL de la variable a la que se refina

package client.blogic.testing.refinement.java.basicrefinement;

import java.util.Iterator;
import java.util.LinkedList;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import common.util.ExprIterator;
import client.blogic.testing.refinement.FTCRLUtils;
import client.blogic.testing.refinement.SExpr;
import client.blogic.testing.refinement.java.FTCRLtoJavaVisitor;
import client.blogic.testing.refinement.java.javaparser.ClassAtributesExtractorVisitor;
import client.blogic.testing.refinement.java.javaparser.Java7Lexer;
import client.blogic.testing.refinement.java.javaparser.Java7Parser;

public class CrossProductRefinement extends Refinement {

	public String refine(SExpr zExpr, String toType, SExpr javaExpr, FTCRLtoJavaVisitor ftcrl) {

		if (toType.equals("TABLE") && ftcrl.currentTable != null){

			//Debemos refinar cada elemento de la tupla a una columna de la tabla
			String tuple = zExpr.exp;
			tuple = tuple.replaceFirst("\\(", "{");
			tuple = tuple.replaceFirst("\\)$", "}");
			ExprIterator itElements = new common.util.ExprIterator(zExpr.exp);

			//Asumimos que el tamaño de la tupla es el mismo que la cantidad de columnas de la tabla
			if (itElements.cardinalidad() == ftcrl.currentTable.size){
				int column = 0;
				while (itElements.hasNext()){
					//Debemos refinar cada elemento de la tupla a una columna de la tabla
					String elem = itElements.next();
					String elemType = FTCRLUtils.getChildType(zExpr.type, column);

					String columnVar = javaExpr.exp + "." + ftcrl.currentTable.columnName.get(column);
					String columnType = ftcrl.currentTable.columnType.get(column);
					ftcrl.refineFromZToJava(new SExpr(elem, elemType), "Basic", new SExpr(columnVar, columnType));

					column++;
				}
			}
		} else if (toType.equals("FILE")) {

			//Debemos refinar cada elemento de la tupla a una linea del archivo
			String tuple = zExpr.exp;
			tuple = tuple.replaceFirst("\\(", "{");
			tuple = tuple.replaceFirst("\\)", "}");
			ExprIterator itElements = new common.util.ExprIterator(zExpr.exp);

			//El archivo lo obtenemos de la expresión Java
			String fileName = javaExpr.exp;
			String writer = ftcrl.openedFiles.get(fileName);

			int pos = 0;
			while (itElements.hasNext()){
				//Debemos refinar cada elemento de la tupla a una columna de la tabla
				String elem = itElements.next();
				String elemType = FTCRLUtils.getChildType(zExpr.type, pos);
				String value = ftcrl.refineFromZToJava(new SExpr(elem, elemType), "BASIC", new SExpr("", "String"));
				if (!value.equals(""))
					ftcrl.printAssignment(writer+".println(str("+value+"))");

				pos++;
			}
		} else if (toType.equals("RECORD")) {
			//Debemos refinar cada elemento de la tupla a un atributo de la clase
			String tuple = zExpr.exp;
			tuple = tuple.replaceFirst("\\(", "{");
			tuple = tuple.replaceFirst("\\)", "}");
			ExprIterator itElements = new common.util.ExprIterator(zExpr.exp);
			
			ClassAtributesExtractorVisitor visitor = new ClassAtributesExtractorVisitor(javaExpr.type);
			//Utilizamos el parser de Java
			ANTLRInputStream input = new ANTLRInputStream(FTCRLUtils.getRule().getPreamble());
			Java7Lexer lexer = new Java7Lexer(input);
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			Java7Parser parser = new Java7Parser(tokens);
			ParseTree tree = parser.compilationUnit();
			visitor.visit(tree);
			
			//Debemos obterner los atributos de la clase
			Iterator<SExpr> atributes = visitor.getAtributes().iterator();

			int pos = 0;
			while (itElements.hasNext()){
				//Debemos refinar cada elemento de la tupla a una columna de la tabla
				String elem = itElements.next();
				String elemType = FTCRLUtils.getChildType(zExpr.type, pos);
				SExpr atribute = atributes.next();
				atribute.exp = javaExpr.exp + "." + atribute.exp;
				String value = ftcrl.refineFromZToJava(new SExpr(elem, elemType), "BASIC", atribute);

				pos++;
			}
		}
		ftcrl.addWarning(GenericJavaValue.getWarning(zExpr, javaExpr));
		return GenericJavaValue.getValue(javaExpr.type);
	}

	@Override
	String refineTo(SExpr zExpr, SExpr javaExpr) {
		return null;
	}
}
