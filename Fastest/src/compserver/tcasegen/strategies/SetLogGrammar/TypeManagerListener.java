package compserver.tcasegen.strategies.SetLogGrammar;
// Generated from TypeManager.g4 by ANTLR 4.0

	import javax.swing.tree.DefaultMutableTreeNode;
	import javax.swing.tree.DefaultTreeModel;
	import javax.swing.tree.TreeNode;

import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.Token;

public interface TypeManagerListener extends ParseTreeListener {
	void enterTypeManage(TypeManagerParser.TypeManageContext ctx);
	void exitTypeManage(TypeManagerParser.TypeManageContext ctx);

	void enterType(TypeManagerParser.TypeContext ctx);
	void exitType(TypeManagerParser.TypeContext ctx);
}