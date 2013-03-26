// Generated from Expr.g4 by ANTLR 4.0

	import java.util.HashMap;
	import java.util.ArrayList;
	import java.util.regex.Matcher;
	import java.util.regex.Pattern;


import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.tree.ErrorNode;

public class ExprBaseListener implements ExprListener {
	@Override public void enterExpression(ExprParser.ExpressionContext ctx) { }
	@Override public void exitExpression(ExprParser.ExpressionContext ctx) { }

	@Override public void enterSchemaText(ExprParser.SchemaTextContext ctx) { }
	@Override public void exitSchemaText(ExprParser.SchemaTextContext ctx) { }

	@Override public void enterDeclaration(ExprParser.DeclarationContext ctx) { }
	@Override public void exitDeclaration(ExprParser.DeclarationContext ctx) { }

	@Override public void enterParagraph(ExprParser.ParagraphContext ctx) { }
	@Override public void exitParagraph(ExprParser.ParagraphContext ctx) { }

	@Override public void enterBasic_type(ExprParser.Basic_typeContext ctx) { }
	@Override public void exitBasic_type(ExprParser.Basic_typeContext ctx) { }

	@Override public void enterEnumeration_type(ExprParser.Enumeration_typeContext ctx) { }
	@Override public void exitEnumeration_type(ExprParser.Enumeration_typeContext ctx) { }

	@Override public void enterPredicate(ExprParser.PredicateContext ctx) { }
	@Override public void exitPredicate(ExprParser.PredicateContext ctx) { }

	@Override public void enterDeclName(ExprParser.DeclNameContext ctx) { }
	@Override public void exitDeclName(ExprParser.DeclNameContext ctx) { }

	@Override public void enterEquivalent_type(ExprParser.Equivalent_typeContext ctx) { }
	@Override public void exitEquivalent_type(ExprParser.Equivalent_typeContext ctx) { }

	@Override public void enterSpecification(ExprParser.SpecificationContext ctx) { }
	@Override public void exitSpecification(ExprParser.SpecificationContext ctx) { }

	@Override public void enterPre_gen(ExprParser.Pre_genContext ctx) { }
	@Override public void exitPre_gen(ExprParser.Pre_genContext ctx) { }

	@Override public void enterDeclPart(ExprParser.DeclPartContext ctx) { }
	@Override public void exitDeclPart(ExprParser.DeclPartContext ctx) { }

	@Override public void enterEveryRule(ParserRuleContext ctx) { }
	@Override public void exitEveryRule(ParserRuleContext ctx) { }
	@Override public void visitTerminal(TerminalNode node) { }
	@Override public void visitErrorNode(ErrorNode node) { }
}