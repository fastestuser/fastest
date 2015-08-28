// Generated from FTSDL.g4 by ANTLR 4.5.1

package client.blogic.testing.ttree.strategies.ftsdl;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link FTSDLParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface FTSDLVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link FTSDLParser#strategies}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStrategies(FTSDLParser.StrategiesContext ctx);
	/**
	 * Visit a parse tree produced by {@link FTSDLParser#strategy}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStrategy(FTSDLParser.StrategyContext ctx);
	/**
	 * Visit a parse tree produced by {@link FTSDLParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(FTSDLParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link FTSDLParser#statementBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementBlock(FTSDLParser.StatementBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link FTSDLParser#variableAssignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableAssignment(FTSDLParser.VariableAssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link FTSDLParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(FTSDLParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link FTSDLParser#forStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStatement(FTSDLParser.ForStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link FTSDLParser#whileStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatement(FTSDLParser.WhileStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link FTSDLParser#foreachStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForeachStatement(FTSDLParser.ForeachStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link FTSDLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(FTSDLParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link FTSDLParser#logicalExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalExpression(FTSDLParser.LogicalExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link FTSDLParser#command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommand(FTSDLParser.CommandContext ctx);
	/**
	 * Visit a parse tree produced by {@link FTSDLParser#function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(FTSDLParser.FunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link FTSDLParser#treeManagement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTreeManagement(FTSDLParser.TreeManagementContext ctx);
	/**
	 * Visit a parse tree produced by {@link FTSDLParser#parametersManagement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParametersManagement(FTSDLParser.ParametersManagementContext ctx);
	/**
	 * Visit a parse tree produced by {@link FTSDLParser#tacticManagement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTacticManagement(FTSDLParser.TacticManagementContext ctx);
	/**
	 * Visit a parse tree produced by {@link FTSDLParser#expressionManagement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionManagement(FTSDLParser.ExpressionManagementContext ctx);
	/**
	 * Visit a parse tree produced by {@link FTSDLParser#stringManagement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringManagement(FTSDLParser.StringManagementContext ctx);
	/**
	 * Visit a parse tree produced by {@link FTSDLParser#enumerationManagement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumerationManagement(FTSDLParser.EnumerationManagementContext ctx);
	/**
	 * Visit a parse tree produced by {@link FTSDLParser#tactic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTactic(FTSDLParser.TacticContext ctx);
	/**
	 * Visit a parse tree produced by {@link FTSDLParser#zOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitZOperator(FTSDLParser.ZOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link FTSDLParser#arglist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArglist(FTSDLParser.ArglistContext ctx);
	/**
	 * Visit a parse tree produced by {@link FTSDLParser#literalExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteralExpression(FTSDLParser.LiteralExpressionContext ctx);
}