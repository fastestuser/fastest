// Generated from /home/cristian/workspace/fastest/Fastest/src/main/java/compserver/tcasegen/strategies/setlog/TypeManager.g4 by ANTLR 4.5.1
package compserver.tcasegen.strategies.setlog;

	import javax.swing.tree.DefaultMutableTreeNode;
	import javax.swing.tree.DefaultTreeModel;
	import javax.swing.tree.TreeNode;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TypeManagerParser}.
 */
public interface TypeManagerListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TypeManagerParser#typeManage}.
	 * @param ctx the parse tree
	 */
	void enterTypeManage(TypeManagerParser.TypeManageContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypeManagerParser#typeManage}.
	 * @param ctx the parse tree
	 */
	void exitTypeManage(TypeManagerParser.TypeManageContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypeManagerParser#typeManageNorm}.
	 * @param ctx the parse tree
	 */
	void enterTypeManageNorm(TypeManagerParser.TypeManageNormContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypeManagerParser#typeManageNorm}.
	 * @param ctx the parse tree
	 */
	void exitTypeManageNorm(TypeManagerParser.TypeManageNormContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypeManagerParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(TypeManagerParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypeManagerParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(TypeManagerParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypeManagerParser#typeCross}.
	 * @param ctx the parse tree
	 */
	void enterTypeCross(TypeManagerParser.TypeCrossContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypeManagerParser#typeCross}.
	 * @param ctx the parse tree
	 */
	void exitTypeCross(TypeManagerParser.TypeCrossContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypeManagerParser#typeNorm}.
	 * @param ctx the parse tree
	 */
	void enterTypeNorm(TypeManagerParser.TypeNormContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypeManagerParser#typeNorm}.
	 * @param ctx the parse tree
	 */
	void exitTypeNorm(TypeManagerParser.TypeNormContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypeManagerParser#typeNormCross}.
	 * @param ctx the parse tree
	 */
	void enterTypeNormCross(TypeManagerParser.TypeNormCrossContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypeManagerParser#typeNormCross}.
	 * @param ctx the parse tree
	 */
	void exitTypeNormCross(TypeManagerParser.TypeNormCrossContext ctx);
}