// Generated from /home/cristian/workspace/fastest/Fastest/src/main/java/compserver/tcasegen/strategies/setlog/TypeManager.g4 by ANTLR 4.5.1
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
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, BINOP=8, NAME=9, 
		UNOP=10, NUM=11, WS=12;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "BINOP", "NAME", 
		"UNOP", "NUM", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'\\cross'", "'('", "')'", "'\\num'", "'\\nat_{1}'", "'\\nat'", 
		"'\\upto'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, "BINOP", "NAME", "UNOP", 
		"NUM", "WS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


		DefaultMutableTreeNode root = new DefaultMutableTreeNode();
		
		public DefaultMutableTreeNode getRoot() {
			return root;
		}
		
		public static String printTree(DefaultMutableTreeNode tree){
			if (tree.isLeaf()) 
				return (String) tree.getUserObject();
			else if (tree.getChildCount() == 1)
				if ( ((String) tree.getUserObject()).equals("()"))
					return "(" + printTree((DefaultMutableTreeNode) tree.getChildAt(0)) + ")";
				else
					return (String) tree.getUserObject() + printTree((DefaultMutableTreeNode) tree.getChildAt(0));
			else if (tree.getChildCount() == 2)
				return printTree((DefaultMutableTreeNode) tree.getChildAt(0)) + ((String) tree.getUserObject()) + printTree((DefaultMutableTreeNode) tree.getChildAt(1));
			else {//tiene varios hijos, es un CROSS!
				String returnString = printTree((DefaultMutableTreeNode) tree.getChildAt(0));
				int i = 1;
				while (i < tree.getChildCount()) {
					returnString = returnString.concat("\\cross");
					returnString = returnString.concat(printTree((DefaultMutableTreeNode) tree.getChildAt(i)));
					i++;
				}
				return returnString;
			}
		}


	public TypeManagerLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "TypeManager.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 11:
			WS_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:
			skip();
			break;
		}
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\16\u0090\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3"+
		"\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7"+
		"\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\tR\n\t\3\n\3\n\3\n\3\n\3\n\6\nY\n\n\r"+
		"\n\16\nZ\3\n\7\n^\n\n\f\n\16\na\13\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u0083\n\13"+
		"\3\f\6\f\u0086\n\f\r\f\16\f\u0087\3\r\6\r\u008b\n\r\r\r\16\r\u008c\3\r"+
		"\3\r\2\2\16\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\3"+
		"\2\4\4\2C\\c|\5\2\13\f\17\17\"\"\u009c\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2"+
		"\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2"+
		"\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\3\33\3\2\2\2\5\"\3"+
		"\2\2\2\7$\3\2\2\2\t&\3\2\2\2\13+\3\2\2\2\r\64\3\2\2\2\179\3\2\2\2\21Q"+
		"\3\2\2\2\23X\3\2\2\2\25\u0082\3\2\2\2\27\u0085\3\2\2\2\31\u008a\3\2\2"+
		"\2\33\34\7^\2\2\34\35\7e\2\2\35\36\7t\2\2\36\37\7q\2\2\37 \7u\2\2 !\7"+
		"u\2\2!\4\3\2\2\2\"#\7*\2\2#\6\3\2\2\2$%\7+\2\2%\b\3\2\2\2&\'\7^\2\2\'"+
		"(\7p\2\2()\7w\2\2)*\7o\2\2*\n\3\2\2\2+,\7^\2\2,-\7p\2\2-.\7c\2\2./\7v"+
		"\2\2/\60\7a\2\2\60\61\7}\2\2\61\62\7\63\2\2\62\63\7\177\2\2\63\f\3\2\2"+
		"\2\64\65\7^\2\2\65\66\7p\2\2\66\67\7c\2\2\678\7v\2\28\16\3\2\2\29:\7^"+
		"\2\2:;\7w\2\2;<\7r\2\2<=\7v\2\2=>\7q\2\2>\20\3\2\2\2?@\7^\2\2@A\7t\2\2"+
		"AB\7g\2\2BR\7n\2\2CD\7^\2\2DE\7r\2\2EF\7h\2\2FG\7w\2\2GR\7p\2\2HI\7^\2"+
		"\2IJ\7h\2\2JK\7h\2\2KL\7w\2\2LR\7p\2\2MN\7^\2\2NO\7h\2\2OP\7w\2\2PR\7"+
		"p\2\2Q?\3\2\2\2QC\3\2\2\2QH\3\2\2\2QM\3\2\2\2R\22\3\2\2\2SY\t\2\2\2TU"+
		"\7^\2\2UV\7a\2\2VY\7\"\2\2WY\7A\2\2XS\3\2\2\2XT\3\2\2\2XW\3\2\2\2YZ\3"+
		"\2\2\2ZX\3\2\2\2Z[\3\2\2\2[_\3\2\2\2\\^\4\62;\2]\\\3\2\2\2^a\3\2\2\2_"+
		"]\3\2\2\2_`\3\2\2\2`\24\3\2\2\2a_\3\2\2\2bc\7^\2\2cd\7r\2\2de\7q\2\2e"+
		"f\7y\2\2fg\7g\2\2g\u0083\7t\2\2hi\7u\2\2ij\7g\2\2jk\7s\2\2kl\7a\2\2lm"+
		"\7}\2\2mn\7\63\2\2n\u0083\7\177\2\2op\7u\2\2pq\7g\2\2qr\7s\2\2rs\7a\2"+
		"\2st\7}\2\2tu\7\63\2\2uv\7\177\2\2v\u0083\7\u0080\2\2wx\7^\2\2xy\7u\2"+
		"\2yz\7g\2\2z\u0083\7s\2\2{|\7^\2\2|}\7h\2\2}~\7k\2\2~\177\7p\2\2\177\u0080"+
		"\7u\2\2\u0080\u0081\7g\2\2\u0081\u0083\7v\2\2\u0082b\3\2\2\2\u0082h\3"+
		"\2\2\2\u0082o\3\2\2\2\u0082w\3\2\2\2\u0082{\3\2\2\2\u0083\26\3\2\2\2\u0084"+
		"\u0086\4\62;\2\u0085\u0084\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u0085\3\2"+
		"\2\2\u0087\u0088\3\2\2\2\u0088\30\3\2\2\2\u0089\u008b\t\3\2\2\u008a\u0089"+
		"\3\2\2\2\u008b\u008c\3\2\2\2\u008c\u008a\3\2\2\2\u008c\u008d\3\2\2\2\u008d"+
		"\u008e\3\2\2\2\u008e\u008f\b\r\2\2\u008f\32\3\2\2\2\n\2QXZ_\u0082\u0087"+
		"\u008c\3\3\r\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}