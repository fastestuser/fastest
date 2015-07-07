// Generated from Expr.g4 by ANTLR 4.0

	package compserver.tcasegen.strategies.setlog.ztosetlog;
	import org.antlr.v4.runtime.tree.*;

public interface ExprListener extends ParseTreeListener {
	void enterExpression(ExprParser.ExpressionContext ctx);
	void exitExpression(ExprParser.ExpressionContext ctx);

	void enterPost(ExprParser.PostContext ctx);
	void exitPost(ExprParser.PostContext ctx);

	void enterEndExpression(ExprParser.EndExpressionContext ctx);
	void exitEndExpression(ExprParser.EndExpressionContext ctx);

	void enterDeclaration(ExprParser.DeclarationContext ctx);
	void exitDeclaration(ExprParser.DeclarationContext ctx);

	void enterParagraph(ExprParser.ParagraphContext ctx);
	void exitParagraph(ExprParser.ParagraphContext ctx);

	void enterBasic_type(ExprParser.Basic_typeContext ctx);
	void exitBasic_type(ExprParser.Basic_typeContext ctx);

	void enterEnumeration_type(ExprParser.Enumeration_typeContext ctx);
	void exitEnumeration_type(ExprParser.Enumeration_typeContext ctx);

	void enterPredicate(ExprParser.PredicateContext ctx);
	void exitPredicate(ExprParser.PredicateContext ctx);

	void enterEquivalent_type(ExprParser.Equivalent_typeContext ctx);
	void exitEquivalent_type(ExprParser.Equivalent_typeContext ctx);

	void enterDeclPart(ExprParser.DeclPartContext ctx);
	void exitDeclPart(ExprParser.DeclPartContext ctx);

	void enterSchemaText(ExprParser.SchemaTextContext ctx);
	void exitSchemaText(ExprParser.SchemaTextContext ctx);

	void enterPre(ExprParser.PreContext ctx);
	void exitPre(ExprParser.PreContext ctx);

	void enterDeclName(ExprParser.DeclNameContext ctx);
	void exitDeclName(ExprParser.DeclNameContext ctx);

	void enterRefName(ExprParser.RefNameContext ctx);
	void exitRefName(ExprParser.RefNameContext ctx);

	void enterSpecification(ExprParser.SpecificationContext ctx);
	void exitSpecification(ExprParser.SpecificationContext ctx);

	void enterSchemaTypeText(ExprParser.SchemaTypeTextContext ctx);
	void exitSchemaTypeText(ExprParser.SchemaTypeTextContext ctx);
}