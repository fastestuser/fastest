// Generated from SLog2Z.g4 by ANTLR 4.0

package compserver.tcasegen.strategies.setlog.setlogtoz;
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


import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.tree.ErrorNode;

public class SLog2ZBaseListener implements SLog2ZListener {
	@Override public void enterSeqIgual(SLog2ZParser.SeqIgualContext ctx) { }
	@Override public void exitSeqIgual(SLog2ZParser.SeqIgualContext ctx) { }

	@Override public void enterLineas(SLog2ZParser.LineasContext ctx) { }
	@Override public void exitLineas(SLog2ZParser.LineasContext ctx) { }

	@Override public void enterRestr(SLog2ZParser.RestrContext ctx) { }
	@Override public void exitRestr(SLog2ZParser.RestrContext ctx) { }

	@Override public void enterConstr(SLog2ZParser.ConstrContext ctx) { }
	@Override public void exitConstr(SLog2ZParser.ConstrContext ctx) { }

	@Override public void enterExpr(SLog2ZParser.ExprContext ctx) { }
	@Override public void exitExpr(SLog2ZParser.ExprContext ctx) { }

	@Override public void enterEveryRule(ParserRuleContext ctx) { }
	@Override public void exitEveryRule(ParserRuleContext ctx) { }
	@Override public void visitTerminal(TerminalNode node) { }
	@Override public void visitErrorNode(ErrorNode node) { }
}