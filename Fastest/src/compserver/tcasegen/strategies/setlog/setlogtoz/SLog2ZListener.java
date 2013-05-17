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

import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.Token;

public interface SLog2ZListener extends ParseTreeListener {
	void enterSeqIgual(SLog2ZParser.SeqIgualContext ctx);
	void exitSeqIgual(SLog2ZParser.SeqIgualContext ctx);

	void enterLineas(SLog2ZParser.LineasContext ctx);
	void exitLineas(SLog2ZParser.LineasContext ctx);

	void enterRestr(SLog2ZParser.RestrContext ctx);
	void exitRestr(SLog2ZParser.RestrContext ctx);

	void enterConstr(SLog2ZParser.ConstrContext ctx);
	void exitConstr(SLog2ZParser.ConstrContext ctx);

	void enterExpr(SLog2ZParser.ExprContext ctx);
	void exitExpr(SLog2ZParser.ExprContext ctx);
}