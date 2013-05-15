// Generated from TypeManager.g4 by ANTLR 4.0

	package compserver.tcasegen.strategies.SetLogGrammar;
	import javax.swing.tree.DefaultMutableTreeNode;
	import javax.swing.tree.DefaultTreeModel;
	import javax.swing.tree.TreeNode;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class TypeManagerLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__5=1, T__4=2, T__3=3, T__2=4, T__1=5, T__0=6, BINOP=7, UNOP=8, NAME=9, 
		NUM=10, WS=11;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'\\nat'", "'\\upto'", "')'", "'('", "'\\num'", "'\\nat_{1}'", "BINOP", 
		"UNOP", "NAME", "NUM", "WS"
	};
	public static final String[] ruleNames = {
		"T__5", "T__4", "T__3", "T__2", "T__1", "T__0", "BINOP", "UNOP", "NAME", 
		"NUM", "WS"
	};


		DefaultMutableTreeNode root = new DefaultMutableTreeNode();
		
		public DefaultMutableTreeNode getRoot() {
			return root;
		}
		
		public String printTree(DefaultMutableTreeNode tree){
			if (tree.isLeaf()) 
				return (String) tree.getUserObject();
			else if (tree.getChildCount() == 1)
				if ( ((String) tree.getUserObject()).equals("()")) //REVISAR
					return "(" + printTree((DefaultMutableTreeNode) tree.getChildAt(0)) + ")";
				else
					return (String) tree.getUserObject() + printTree((DefaultMutableTreeNode) tree.getChildAt(0));
			else //tiene dos hijos
				return printTree((DefaultMutableTreeNode) tree.getChildAt(0)) + ((String) tree.getUserObject()) + printTree((DefaultMutableTreeNode) tree.getChildAt(1));
		}


	public TypeManagerLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "TypeManager.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 10: WS_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: skip(); break;
		}
	}

	public static final String _serializedATN =
		"\2\4\r\u0086\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t"+
		"\b\4\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\bO\n\b\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\5\tj\n\t\3\n\3\n\3\n\3\n\3\n\6\nq\n\n\r\n\16\nr\3\n\7\nv\n\n"+
		"\f\n\16\ny\13\n\3\13\6\13|\n\13\r\13\16\13}\3\f\6\f\u0081\n\f\r\f\16\f"+
		"\u0082\3\f\3\f\2\r\3\3\1\5\4\1\7\5\1\t\6\1\13\7\1\r\b\1\17\t\1\21\n\1"+
		"\23\13\1\25\f\1\27\r\2\3\2\4\4C\\c|\5\13\f\17\17\"\"\u0092\2\3\3\2\2\2"+
		"\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2"+
		"\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\3\31\3\2\2\2"+
		"\5\36\3\2\2\2\7$\3\2\2\2\t&\3\2\2\2\13(\3\2\2\2\r-\3\2\2\2\17N\3\2\2\2"+
		"\21i\3\2\2\2\23p\3\2\2\2\25{\3\2\2\2\27\u0080\3\2\2\2\31\32\7^\2\2\32"+
		"\33\7p\2\2\33\34\7c\2\2\34\35\7v\2\2\35\4\3\2\2\2\36\37\7^\2\2\37 \7w"+
		"\2\2 !\7r\2\2!\"\7v\2\2\"#\7q\2\2#\6\3\2\2\2$%\7+\2\2%\b\3\2\2\2&\'\7"+
		"*\2\2\'\n\3\2\2\2()\7^\2\2)*\7p\2\2*+\7w\2\2+,\7o\2\2,\f\3\2\2\2-.\7^"+
		"\2\2./\7p\2\2/\60\7c\2\2\60\61\7v\2\2\61\62\7a\2\2\62\63\7}\2\2\63\64"+
		"\7\63\2\2\64\65\7\177\2\2\65\16\3\2\2\2\66\67\7^\2\2\678\7t\2\289\7g\2"+
		"\29O\7n\2\2:;\7^\2\2;<\7r\2\2<=\7h\2\2=>\7w\2\2>O\7p\2\2?@\7^\2\2@A\7"+
		"h\2\2AB\7h\2\2BC\7w\2\2CO\7p\2\2DE\7^\2\2EF\7h\2\2FG\7w\2\2GO\7p\2\2H"+
		"I\7^\2\2IJ\7e\2\2JK\7t\2\2KL\7q\2\2LM\7u\2\2MO\7u\2\2N\66\3\2\2\2N:\3"+
		"\2\2\2N?\3\2\2\2ND\3\2\2\2NH\3\2\2\2O\20\3\2\2\2PQ\7^\2\2QR\7r\2\2RS\7"+
		"q\2\2ST\7y\2\2TU\7g\2\2Uj\7t\2\2VW\7^\2\2WX\7u\2\2XY\7g\2\2YZ\7s\2\2Z"+
		"[\7a\2\2[\\\7}\2\2\\]\7\63\2\2]j\7\177\2\2^_\7^\2\2_`\7u\2\2`a\7g\2\2"+
		"aj\7s\2\2bc\7^\2\2cd\7h\2\2de\7k\2\2ef\7p\2\2fg\7u\2\2gh\7g\2\2hj\7v\2"+
		"\2iP\3\2\2\2iV\3\2\2\2i^\3\2\2\2ib\3\2\2\2j\22\3\2\2\2kq\t\2\2\2lm\7^"+
		"\2\2mn\7a\2\2nq\7\"\2\2oq\7A\2\2pk\3\2\2\2pl\3\2\2\2po\3\2\2\2qr\3\2\2"+
		"\2rp\3\2\2\2rs\3\2\2\2sw\3\2\2\2tv\4\62;\2ut\3\2\2\2vy\3\2\2\2wu\3\2\2"+
		"\2wx\3\2\2\2x\24\3\2\2\2yw\3\2\2\2z|\4\62;\2{z\3\2\2\2|}\3\2\2\2}{\3\2"+
		"\2\2}~\3\2\2\2~\26\3\2\2\2\177\u0081\t\3\2\2\u0080\177\3\2\2\2\u0081\u0082"+
		"\3\2\2\2\u0082\u0080\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u0084\3\2\2\2\u0084"+
		"\u0085\b\f\2\2\u0085\30\3\2\2\2\n\2Niprw}\u0082";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}