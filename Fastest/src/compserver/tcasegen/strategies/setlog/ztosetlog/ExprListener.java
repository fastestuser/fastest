// Generated from Expr.g4 by ANTLR 4.0

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
	

import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.Token;

public interface ExprListener extends ParseTreeListener {
	void enterExpression(ExprParser.ExpressionContext ctx);
	void exitExpression(ExprParser.ExpressionContext ctx);

	void enterPost(ExprParser.PostContext ctx);
	void exitPost(ExprParser.PostContext ctx);

	void enterDeclaration(ExprParser.DeclarationContext ctx);
	void exitDeclaration(ExprParser.DeclarationContext ctx);

	void enterEndExpression(ExprParser.EndExpressionContext ctx);
	void exitEndExpression(ExprParser.EndExpressionContext ctx);

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

	void enterSpecification(ExprParser.SpecificationContext ctx);
	void exitSpecification(ExprParser.SpecificationContext ctx);

	void enterRefName(ExprParser.RefNameContext ctx);
	void exitRefName(ExprParser.RefNameContext ctx);
}