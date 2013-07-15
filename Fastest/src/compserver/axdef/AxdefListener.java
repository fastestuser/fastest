// Generated from Axdef.g4 by ANTLR 4.0

	package compserver.axdef;
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

public interface AxdefListener extends ParseTreeListener {
	void enterExpression(AxdefParser.ExpressionContext ctx);
	void exitExpression(AxdefParser.ExpressionContext ctx);

	void enterSimpleArgument(AxdefParser.SimpleArgumentContext ctx);
	void exitSimpleArgument(AxdefParser.SimpleArgumentContext ctx);

	void enterStrategy(AxdefParser.StrategyContext ctx);
	void exitStrategy(AxdefParser.StrategyContext ctx);

	void enterComplexArgument(AxdefParser.ComplexArgumentContext ctx);
	void exitComplexArgument(AxdefParser.ComplexArgumentContext ctx);
}