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
		T__4=1, T__3=2, T__2=3, T__1=4, T__0=5, BINOP=6, UNOP=7, NAME=8, WS=9;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'\\nat'", "')'", "'('", "'\\num'", "'\\nat_{1}'", "BINOP", "UNOP", "NAME", 
		"WS"
	};
	public static final String[] ruleNames = {
		"T__4", "T__3", "T__2", "T__1", "T__0", "BINOP", "UNOP", "NAME", "WS"
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
		case 8: WS_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: skip(); break;
		}
	}

	public static final String _serializedATN =
		"\2\4\13k\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4"+
		"\t\t\t\4\n\t\n\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\5\3\5"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7@\n\7\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\bT\n\b\3\t\3"+
		"\t\3\t\3\t\3\t\6\t[\n\t\r\t\16\t\\\3\t\7\t`\n\t\f\t\16\tc\13\t\3\n\6\n"+
		"f\n\n\r\n\16\ng\3\n\3\n\2\13\3\3\1\5\4\1\7\5\1\t\6\1\13\7\1\r\b\1\17\t"+
		"\1\21\n\1\23\13\2\3\2\4\4C\\c|\5\13\f\17\17\"\"t\2\3\3\2\2\2\2\5\3\2\2"+
		"\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21"+
		"\3\2\2\2\2\23\3\2\2\2\3\25\3\2\2\2\5\32\3\2\2\2\7\34\3\2\2\2\t\36\3\2"+
		"\2\2\13#\3\2\2\2\r?\3\2\2\2\17S\3\2\2\2\21Z\3\2\2\2\23e\3\2\2\2\25\26"+
		"\7^\2\2\26\27\7p\2\2\27\30\7c\2\2\30\31\7v\2\2\31\4\3\2\2\2\32\33\7+\2"+
		"\2\33\6\3\2\2\2\34\35\7*\2\2\35\b\3\2\2\2\36\37\7^\2\2\37 \7p\2\2 !\7"+
		"w\2\2!\"\7o\2\2\"\n\3\2\2\2#$\7^\2\2$%\7p\2\2%&\7c\2\2&\'\7v\2\2\'(\7"+
		"a\2\2()\7}\2\2)*\7\63\2\2*+\7\177\2\2+\f\3\2\2\2,-\7^\2\2-.\7t\2\2./\7"+
		"g\2\2/@\7n\2\2\60\61\7^\2\2\61\62\7r\2\2\62\63\7h\2\2\63\64\7w\2\2\64"+
		"@\7p\2\2\65\66\7^\2\2\66\67\7h\2\2\678\7w\2\28@\7p\2\29:\7^\2\2:;\7e\2"+
		"\2;<\7t\2\2<=\7q\2\2=>\7u\2\2>@\7u\2\2?,\3\2\2\2?\60\3\2\2\2?\65\3\2\2"+
		"\2?9\3\2\2\2@\16\3\2\2\2AB\7^\2\2BC\7r\2\2CD\7q\2\2DE\7y\2\2EF\7g\2\2"+
		"FT\7t\2\2GH\7^\2\2HI\7u\2\2IJ\7g\2\2JK\7s\2\2KL\7a\2\2LM\7}\2\2MN\7\63"+
		"\2\2NT\7\177\2\2OP\7^\2\2PQ\7u\2\2QR\7g\2\2RT\7s\2\2SA\3\2\2\2SG\3\2\2"+
		"\2SO\3\2\2\2T\20\3\2\2\2U[\t\2\2\2VW\7^\2\2WX\7a\2\2X[\7\"\2\2Y[\7A\2"+
		"\2ZU\3\2\2\2ZV\3\2\2\2ZY\3\2\2\2[\\\3\2\2\2\\Z\3\2\2\2\\]\3\2\2\2]a\3"+
		"\2\2\2^`\4\62;\2_^\3\2\2\2`c\3\2\2\2a_\3\2\2\2ab\3\2\2\2b\22\3\2\2\2c"+
		"a\3\2\2\2df\t\3\2\2ed\3\2\2\2fg\3\2\2\2ge\3\2\2\2gh\3\2\2\2hi\3\2\2\2"+
		"ij\b\n\2\2j\24\3\2\2\2\t\2?SZ\\ag";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}