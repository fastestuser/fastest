// Generated from /home/cristian/workspace/fastest/Fastest/src/main/java/compserver/tcasegen/strategies/setlog/setlogtoz/SLog2Z.g4 by ANTLR 4.5.1
package compserver.tcasegen.strategies.setlog.setlogtoz;

//package compserver.tcasegen.strategies.setlog.setlogtoz;
	import java.util.LinkedList;
	import java.util.List;
	import java.util.HashMap;
	import java.util.ArrayList;
	import java.util.regex.Matcher;
	import java.util.regex.Pattern;
	import java.util.Iterator;
	import javax.swing.tree.DefaultMutableTreeNode;
	import javax.swing.tree.DefaultTreeModel;
	import javax.swing.tree.TreeNode;
	import compserver.tcasegen.strategies.setlog.ztosetlog.ExprParser;
	import compserver.tcasegen.strategies.setlog.TypeManagerLexer;
	import compserver.tcasegen.strategies.setlog.TypeManagerParser;
	import compserver.tcasegen.strategies.setlog.SetLogUtils;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SLog2ZParser}.
 */
public interface SLog2ZListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SLog2ZParser#lineas}.
	 * @param ctx the parse tree
	 */
	void enterLineas(SLog2ZParser.LineasContext ctx);
	/**
	 * Exit a parse tree produced by {@link SLog2ZParser#lineas}.
	 * @param ctx the parse tree
	 */
	void exitLineas(SLog2ZParser.LineasContext ctx);
	/**
	 * Enter a parse tree produced by {@link SLog2ZParser#constr}.
	 * @param ctx the parse tree
	 */
	void enterConstr(SLog2ZParser.ConstrContext ctx);
	/**
	 * Exit a parse tree produced by {@link SLog2ZParser#constr}.
	 * @param ctx the parse tree
	 */
	void exitConstr(SLog2ZParser.ConstrContext ctx);
	/**
	 * Enter a parse tree produced by {@link SLog2ZParser#restr}.
	 * @param ctx the parse tree
	 */
	void enterRestr(SLog2ZParser.RestrContext ctx);
	/**
	 * Exit a parse tree produced by {@link SLog2ZParser#restr}.
	 * @param ctx the parse tree
	 */
	void exitRestr(SLog2ZParser.RestrContext ctx);
	/**
	 * Enter a parse tree produced by {@link SLog2ZParser#seqIgual}.
	 * @param ctx the parse tree
	 */
	void enterSeqIgual(SLog2ZParser.SeqIgualContext ctx);
	/**
	 * Exit a parse tree produced by {@link SLog2ZParser#seqIgual}.
	 * @param ctx the parse tree
	 */
	void exitSeqIgual(SLog2ZParser.SeqIgualContext ctx);
	/**
	 * Enter a parse tree produced by {@link SLog2ZParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(SLog2ZParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link SLog2ZParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(SLog2ZParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link SLog2ZParser#exprCte}.
	 * @param ctx the parse tree
	 */
	void enterExprCte(SLog2ZParser.ExprCteContext ctx);
	/**
	 * Exit a parse tree produced by {@link SLog2ZParser#exprCte}.
	 * @param ctx the parse tree
	 */
	void exitExprCte(SLog2ZParser.ExprCteContext ctx);
}