// Generated from TypeManager.g4 by ANTLR 4.0

	package compserver.tcasegen.strategies.setlog;
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
		T__6=1, T__5=2, T__4=3, T__3=4, T__2=5, T__1=6, T__0=7, BINOP=8, UNOP=9, 
		NAME=10, NUM=11, WS=12;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'\\nat'", "'\\upto'", "')'", "'('", "'\\num'", "'\\cross'", "'\\nat_{1}'", 
		"BINOP", "UNOP", "NAME", "NUM", "WS"
	};
	public static final String[] ruleNames = {
		"T__6", "T__5", "T__4", "T__3", "T__2", "T__1", "T__0", "BINOP", "UNOP", 
		"NAME", "NUM", "WS"
	};


		DefaultMutableTreeNode root = new DefaultMutableTreeNode();
		
		public DefaultMutableTreeNode getRoot() {
			return root;
		}
		
		public static String printTree(DefaultMutableTreeNode tree){
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
		case 11: WS_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: skip(); break;
		}
	}

	public static final String _serializedATN =
		"\2\4\16\u0089\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b"+
		"\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\3\2\3\2\3\2\3\2\3\2\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\tR\n\t\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\5\nm\n\n\3\13\3\13\3\13\3\13\3\13\6\13t\n\13\r"+
		"\13\16\13u\3\13\7\13y\n\13\f\13\16\13|\13\13\3\f\6\f\177\n\f\r\f\16\f"+
		"\u0080\3\r\6\r\u0084\n\r\r\r\16\r\u0085\3\r\3\r\2\16\3\3\1\5\4\1\7\5\1"+
		"\t\6\1\13\7\1\r\b\1\17\t\1\21\n\1\23\13\1\25\f\1\27\r\1\31\16\2\3\2\4"+
		"\4C\\c|\5\13\f\17\17\"\"\u0094\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t"+
		"\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2"+
		"\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\3\33\3\2\2\2\5 \3\2\2\2\7&\3"+
		"\2\2\2\t(\3\2\2\2\13*\3\2\2\2\r/\3\2\2\2\17\66\3\2\2\2\21Q\3\2\2\2\23"+
		"l\3\2\2\2\25s\3\2\2\2\27~\3\2\2\2\31\u0083\3\2\2\2\33\34\7^\2\2\34\35"+
		"\7p\2\2\35\36\7c\2\2\36\37\7v\2\2\37\4\3\2\2\2 !\7^\2\2!\"\7w\2\2\"#\7"+
		"r\2\2#$\7v\2\2$%\7q\2\2%\6\3\2\2\2&\'\7+\2\2\'\b\3\2\2\2()\7*\2\2)\n\3"+
		"\2\2\2*+\7^\2\2+,\7p\2\2,-\7w\2\2-.\7o\2\2.\f\3\2\2\2/\60\7^\2\2\60\61"+
		"\7e\2\2\61\62\7t\2\2\62\63\7q\2\2\63\64\7u\2\2\64\65\7u\2\2\65\16\3\2"+
		"\2\2\66\67\7^\2\2\678\7p\2\289\7c\2\29:\7v\2\2:;\7a\2\2;<\7}\2\2<=\7\63"+
		"\2\2=>\7\177\2\2>\20\3\2\2\2?@\7^\2\2@A\7t\2\2AB\7g\2\2BR\7n\2\2CD\7^"+
		"\2\2DE\7r\2\2EF\7h\2\2FG\7w\2\2GR\7p\2\2HI\7^\2\2IJ\7h\2\2JK\7h\2\2KL"+
		"\7w\2\2LR\7p\2\2MN\7^\2\2NO\7h\2\2OP\7w\2\2PR\7p\2\2Q?\3\2\2\2QC\3\2\2"+
		"\2QH\3\2\2\2QM\3\2\2\2R\22\3\2\2\2ST\7^\2\2TU\7r\2\2UV\7q\2\2VW\7y\2\2"+
		"WX\7g\2\2Xm\7t\2\2YZ\7^\2\2Z[\7u\2\2[\\\7g\2\2\\]\7s\2\2]^\7a\2\2^_\7"+
		"}\2\2_`\7\63\2\2`m\7\177\2\2ab\7^\2\2bc\7u\2\2cd\7g\2\2dm\7s\2\2ef\7^"+
		"\2\2fg\7h\2\2gh\7k\2\2hi\7p\2\2ij\7u\2\2jk\7g\2\2km\7v\2\2lS\3\2\2\2l"+
		"Y\3\2\2\2la\3\2\2\2le\3\2\2\2m\24\3\2\2\2nt\t\2\2\2op\7^\2\2pq\7a\2\2"+
		"qt\7\"\2\2rt\7A\2\2sn\3\2\2\2so\3\2\2\2sr\3\2\2\2tu\3\2\2\2us\3\2\2\2"+
		"uv\3\2\2\2vz\3\2\2\2wy\4\62;\2xw\3\2\2\2y|\3\2\2\2zx\3\2\2\2z{\3\2\2\2"+
		"{\26\3\2\2\2|z\3\2\2\2}\177\4\62;\2~}\3\2\2\2\177\u0080\3\2\2\2\u0080"+
		"~\3\2\2\2\u0080\u0081\3\2\2\2\u0081\30\3\2\2\2\u0082\u0084\t\3\2\2\u0083"+
		"\u0082\3\2\2\2\u0084\u0085\3\2\2\2\u0085\u0083\3\2\2\2\u0085\u0086\3\2"+
		"\2\2\u0086\u0087\3\2\2\2\u0087\u0088\b\r\2\2\u0088\32\3\2\2\2\n\2Qlsu"+
		"z\u0080\u0085";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}