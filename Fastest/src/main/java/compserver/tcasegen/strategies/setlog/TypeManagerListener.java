// Generated from TypeManager.g4 by ANTLR 4.0

	package compserver.tcasegen.strategies.setlog;
	import org.antlr.v4.runtime.tree.*;

public interface TypeManagerListener extends ParseTreeListener {
	void enterTypeManage(TypeManagerParser.TypeManageContext ctx);
	void exitTypeManage(TypeManagerParser.TypeManageContext ctx);

	void enterTypeCross(TypeManagerParser.TypeCrossContext ctx);
	void exitTypeCross(TypeManagerParser.TypeCrossContext ctx);

	void enterTypeManageNorm(TypeManagerParser.TypeManageNormContext ctx);
	void exitTypeManageNorm(TypeManagerParser.TypeManageNormContext ctx);

	void enterTypeNormCross(TypeManagerParser.TypeNormCrossContext ctx);
	void exitTypeNormCross(TypeManagerParser.TypeNormCrossContext ctx);

	void enterTypeNorm(TypeManagerParser.TypeNormContext ctx);
	void exitTypeNorm(TypeManagerParser.TypeNormContext ctx);

	void enterType(TypeManagerParser.TypeContext ctx);
	void exitType(TypeManagerParser.TypeContext ctx);
}