// Generated from Expr.g4 by ANTLR 4.0

	package compserver.tcasegen.strategies.setlog.ztosetlog;
	import compserver.tcasegen.strategies.setlog.TypeManagerParser;
	import compserver.tcasegen.strategies.setlog.TypeManagerLexer;
	import java.util.HashMap;
	import java.util.ArrayList;
	import java.util.regex.Matcher;
	import java.util.regex.Pattern;
	import javax.swing.tree.DefaultMutableTreeNode;
	

import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.Token;

public interface ExprListener extends ParseTreeListener {
	void enterExpression(ExprParser.ExpressionContext ctx);
	void exitExpression(ExprParser.ExpressionContext ctx);

	void enterDeclaration(ExprParser.DeclarationContext ctx);
	void exitDeclaration(ExprParser.DeclarationContext ctx);

	void enterParagraph(ExprParser.ParagraphContext ctx);
	void exitParagraph(ExprParser.ParagraphContext ctx);

	void enterBasic_type(ExprParser.Basic_typeContext ctx);
	void exitBasic_type(ExprParser.Basic_typeContext ctx);

	void enterPost_fun(ExprParser.Post_funContext ctx);
	void exitPost_fun(ExprParser.Post_funContext ctx);

	void enterEnumeration_type(ExprParser.Enumeration_typeContext ctx);
	void exitEnumeration_type(ExprParser.Enumeration_typeContext ctx);

	void enterPredicate(ExprParser.PredicateContext ctx);
	void exitPredicate(ExprParser.PredicateContext ctx);

	void enterEquivalent_type(ExprParser.Equivalent_typeContext ctx);
	void exitEquivalent_type(ExprParser.Equivalent_typeContext ctx);

	void enterExpression0(ExprParser.Expression0Context ctx);
	void exitExpression0(ExprParser.Expression0Context ctx);

	void enterExpression1(ExprParser.Expression1Context ctx);
	void exitExpression1(ExprParser.Expression1Context ctx);

	void enterExpression2(ExprParser.Expression2Context ctx);
	void exitExpression2(ExprParser.Expression2Context ctx);

	void enterExpression3(ExprParser.Expression3Context ctx);
	void exitExpression3(ExprParser.Expression3Context ctx);

	void enterExpression4(ExprParser.Expression4Context ctx);
	void exitExpression4(ExprParser.Expression4Context ctx);

	void enterDeclPart(ExprParser.DeclPartContext ctx);
	void exitDeclPart(ExprParser.DeclPartContext ctx);

	void enterSchemaText(ExprParser.SchemaTextContext ctx);
	void exitSchemaText(ExprParser.SchemaTextContext ctx);

	void enterSeq_op(ExprParser.Seq_opContext ctx);
	void exitSeq_op(ExprParser.Seq_opContext ctx);

	void enterDeclName(ExprParser.DeclNameContext ctx);
	void exitDeclName(ExprParser.DeclNameContext ctx);

	void enterSpecification(ExprParser.SpecificationContext ctx);
	void exitSpecification(ExprParser.SpecificationContext ctx);

	void enterPre_gen(ExprParser.Pre_genContext ctx);
	void exitPre_gen(ExprParser.Pre_genContext ctx);
}