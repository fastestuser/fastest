// Generated from /home/cristian/workspace/fastest/Fastest/src/main/java/compserver/tcasegen/strategies/setlog/ztosetlog/Expr.g4 by ANTLR 4.5.1
package compserver.tcasegen.strategies.setlog.ztosetlog;

	import compserver.tcasegen.strategies.setlog.TypeManagerParser;
	import compserver.tcasegen.strategies.setlog.TypeManagerLexer;
	import java.util.HashMap;
	import java.util.ArrayList;
	import java.util.regex.Matcher;
	import java.util.regex.Pattern;
	import java.util.Collection;
	import java.util.Iterator;
	import java.util.Set;
	import java.lang.String;
	import javax.swing.tree.DefaultMutableTreeNode;
	import javax.rmi.CORBA.Util;
	import java.util.List;
	

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ExprParser}.
 */
public interface ExprListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ExprParser#specification}.
	 * @param ctx the parse tree
	 */
	void enterSpecification(ExprParser.SpecificationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#specification}.
	 * @param ctx the parse tree
	 */
	void exitSpecification(ExprParser.SpecificationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#paragraph}.
	 * @param ctx the parse tree
	 */
	void enterParagraph(ExprParser.ParagraphContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#paragraph}.
	 * @param ctx the parse tree
	 */
	void exitParagraph(ExprParser.ParagraphContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#basic_type}.
	 * @param ctx the parse tree
	 */
	void enterBasic_type(ExprParser.Basic_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#basic_type}.
	 * @param ctx the parse tree
	 */
	void exitBasic_type(ExprParser.Basic_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#equivalent_type}.
	 * @param ctx the parse tree
	 */
	void enterEquivalent_type(ExprParser.Equivalent_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#equivalent_type}.
	 * @param ctx the parse tree
	 */
	void exitEquivalent_type(ExprParser.Equivalent_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#enumeration_type}.
	 * @param ctx the parse tree
	 */
	void enterEnumeration_type(ExprParser.Enumeration_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#enumeration_type}.
	 * @param ctx the parse tree
	 */
	void exitEnumeration_type(ExprParser.Enumeration_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#schemaText}.
	 * @param ctx the parse tree
	 */
	void enterSchemaText(ExprParser.SchemaTextContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#schemaText}.
	 * @param ctx the parse tree
	 */
	void exitSchemaText(ExprParser.SchemaTextContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#schemaTypeText}.
	 * @param ctx the parse tree
	 */
	void enterSchemaTypeText(ExprParser.SchemaTypeTextContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#schemaTypeText}.
	 * @param ctx the parse tree
	 */
	void exitSchemaTypeText(ExprParser.SchemaTypeTextContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#declPart}.
	 * @param ctx the parse tree
	 */
	void enterDeclPart(ExprParser.DeclPartContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#declPart}.
	 * @param ctx the parse tree
	 */
	void exitDeclPart(ExprParser.DeclPartContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(ExprParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(ExprParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#declName}.
	 * @param ctx the parse tree
	 */
	void enterDeclName(ExprParser.DeclNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#declName}.
	 * @param ctx the parse tree
	 */
	void exitDeclName(ExprParser.DeclNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#predicate}.
	 * @param ctx the parse tree
	 */
	void enterPredicate(ExprParser.PredicateContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#predicate}.
	 * @param ctx the parse tree
	 */
	void exitPredicate(ExprParser.PredicateContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(ExprParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(ExprParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#endExpression}.
	 * @param ctx the parse tree
	 */
	void enterEndExpression(ExprParser.EndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#endExpression}.
	 * @param ctx the parse tree
	 */
	void exitEndExpression(ExprParser.EndExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#refName}.
	 * @param ctx the parse tree
	 */
	void enterRefName(ExprParser.RefNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#refName}.
	 * @param ctx the parse tree
	 */
	void exitRefName(ExprParser.RefNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#post}.
	 * @param ctx the parse tree
	 */
	void enterPost(ExprParser.PostContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#post}.
	 * @param ctx the parse tree
	 */
	void exitPost(ExprParser.PostContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#pre}.
	 * @param ctx the parse tree
	 */
	void enterPre(ExprParser.PreContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#pre}.
	 * @param ctx the parse tree
	 */
	void exitPre(ExprParser.PreContext ctx);
}