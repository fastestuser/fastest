// Generated from TypeManager.g4 by ANTLR 4.0

	package compserver.tcasegen.strategies.setlog;
	import javax.swing.tree.DefaultMutableTreeNode;
	import javax.swing.tree.DefaultTreeModel;
	import javax.swing.tree.TreeNode;

import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.Token;

public interface TypeManagerListener extends ParseTreeListener {
	void enterTypeManage(TypeManagerParser.TypeManageContext ctx);
	void exitTypeManage(TypeManagerParser.TypeManageContext ctx);

	void enterTypeManageNorm(TypeManagerParser.TypeManageNormContext ctx);
	void exitTypeManageNorm(TypeManagerParser.TypeManageNormContext ctx);

	void enterTypeNorm(TypeManagerParser.TypeNormContext ctx);
	void exitTypeNorm(TypeManagerParser.TypeNormContext ctx);

	void enterType(TypeManagerParser.TypeContext ctx);
	void exitType(TypeManagerParser.TypeContext ctx);
}