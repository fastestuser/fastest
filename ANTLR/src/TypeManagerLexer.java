// Generated from TypeManager.g4 by ANTLR 4.0

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
		T__3=1, T__2=2, T__1=3, T__0=4, BINOP=5, UNOP=6, NAME=7, WS=8;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'\\nat'", "')'", "'('", "'\\num'", "BINOP", "UNOP", "NAME", "WS"
	};
	public static final String[] ruleNames = {
		"T__3", "T__2", "T__1", "T__0", "BINOP", "UNOP", "NAME", "WS"
	};


		DefaultMutableTreeNode root = new DefaultMutableTreeNode();
		
		public DefaultMutableTreeNode getRoot() {
			return root;
		}
		
		String printTree(DefaultMutableTreeNode tree){
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
		case 7: WS_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: skip(); break;
		}
	}

	public static final String _serializedATN =
		"\2\4\nX\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4"+
		"\t\t\t\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5"+
		"\6\65\n\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7A\n\7\3\b\3\b\3\b"+
		"\3\b\3\b\6\bH\n\b\r\b\16\bI\3\b\7\bM\n\b\f\b\16\bP\13\b\3\t\6\tS\n\t\r"+
		"\t\16\tT\3\t\3\t\2\n\3\3\1\5\4\1\7\5\1\t\6\1\13\7\1\r\b\1\17\t\1\21\n"+
		"\2\3\2\4\4C\\c|\5\13\f\17\17\"\"`\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2"+
		"\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\3\23\3"+
		"\2\2\2\5\30\3\2\2\2\7\32\3\2\2\2\t\34\3\2\2\2\13\64\3\2\2\2\r@\3\2\2\2"+
		"\17G\3\2\2\2\21R\3\2\2\2\23\24\7^\2\2\24\25\7p\2\2\25\26\7c\2\2\26\27"+
		"\7v\2\2\27\4\3\2\2\2\30\31\7+\2\2\31\6\3\2\2\2\32\33\7*\2\2\33\b\3\2\2"+
		"\2\34\35\7^\2\2\35\36\7p\2\2\36\37\7w\2\2\37 \7o\2\2 \n\3\2\2\2!\"\7^"+
		"\2\2\"#\7t\2\2#$\7g\2\2$\65\7n\2\2%&\7^\2\2&\'\7r\2\2\'(\7h\2\2()\7w\2"+
		"\2)\65\7p\2\2*+\7^\2\2+,\7h\2\2,-\7w\2\2-\65\7p\2\2./\7^\2\2/\60\7e\2"+
		"\2\60\61\7t\2\2\61\62\7q\2\2\62\63\7u\2\2\63\65\7u\2\2\64!\3\2\2\2\64"+
		"%\3\2\2\2\64*\3\2\2\2\64.\3\2\2\2\65\f\3\2\2\2\66\67\7^\2\2\678\7r\2\2"+
		"89\7q\2\29:\7y\2\2:;\7g\2\2;A\7t\2\2<=\7^\2\2=>\7u\2\2>?\7g\2\2?A\7s\2"+
		"\2@\66\3\2\2\2@<\3\2\2\2A\16\3\2\2\2BH\t\2\2\2CD\7^\2\2DE\7a\2\2EH\7\""+
		"\2\2FH\7A\2\2GB\3\2\2\2GC\3\2\2\2GF\3\2\2\2HI\3\2\2\2IG\3\2\2\2IJ\3\2"+
		"\2\2JN\3\2\2\2KM\4\62;\2LK\3\2\2\2MP\3\2\2\2NL\3\2\2\2NO\3\2\2\2O\20\3"+
		"\2\2\2PN\3\2\2\2QS\t\3\2\2RQ\3\2\2\2ST\3\2\2\2TR\3\2\2\2TU\3\2\2\2UV\3"+
		"\2\2\2VW\b\t\2\2W\22\3\2\2\2\t\2\64@GINT";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}