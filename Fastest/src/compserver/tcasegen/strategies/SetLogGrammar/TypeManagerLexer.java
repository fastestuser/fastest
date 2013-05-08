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
		"\2\4\rz\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4"+
		"\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\5\bJ\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t^\n\t\3\n\3\n\3\n\3\n\3\n\6\ne\n\n\r\n\16"+
		"\nf\3\n\7\nj\n\n\f\n\16\nm\13\n\3\13\6\13p\n\13\r\13\16\13q\3\f\6\fu\n"+
		"\f\r\f\16\fv\3\f\3\f\2\r\3\3\1\5\4\1\7\5\1\t\6\1\13\7\1\r\b\1\17\t\1\21"+
		"\n\1\23\13\1\25\f\1\27\r\2\3\2\4\4C\\c|\5\13\f\17\17\"\"\u0084\2\3\3\2"+
		"\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17"+
		"\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\3\31\3\2"+
		"\2\2\5\36\3\2\2\2\7$\3\2\2\2\t&\3\2\2\2\13(\3\2\2\2\r-\3\2\2\2\17I\3\2"+
		"\2\2\21]\3\2\2\2\23d\3\2\2\2\25o\3\2\2\2\27t\3\2\2\2\31\32\7^\2\2\32\33"+
		"\7p\2\2\33\34\7c\2\2\34\35\7v\2\2\35\4\3\2\2\2\36\37\7^\2\2\37 \7w\2\2"+
		" !\7r\2\2!\"\7v\2\2\"#\7q\2\2#\6\3\2\2\2$%\7+\2\2%\b\3\2\2\2&\'\7*\2\2"+
		"\'\n\3\2\2\2()\7^\2\2)*\7p\2\2*+\7w\2\2+,\7o\2\2,\f\3\2\2\2-.\7^\2\2."+
		"/\7p\2\2/\60\7c\2\2\60\61\7v\2\2\61\62\7a\2\2\62\63\7}\2\2\63\64\7\63"+
		"\2\2\64\65\7\177\2\2\65\16\3\2\2\2\66\67\7^\2\2\678\7t\2\289\7g\2\29J"+
		"\7n\2\2:;\7^\2\2;<\7r\2\2<=\7h\2\2=>\7w\2\2>J\7p\2\2?@\7^\2\2@A\7h\2\2"+
		"AB\7w\2\2BJ\7p\2\2CD\7^\2\2DE\7e\2\2EF\7t\2\2FG\7q\2\2GH\7u\2\2HJ\7u\2"+
		"\2I\66\3\2\2\2I:\3\2\2\2I?\3\2\2\2IC\3\2\2\2J\20\3\2\2\2KL\7^\2\2LM\7"+
		"r\2\2MN\7q\2\2NO\7y\2\2OP\7g\2\2P^\7t\2\2QR\7^\2\2RS\7u\2\2ST\7g\2\2T"+
		"U\7s\2\2UV\7a\2\2VW\7}\2\2WX\7\63\2\2X^\7\177\2\2YZ\7^\2\2Z[\7u\2\2[\\"+
		"\7g\2\2\\^\7s\2\2]K\3\2\2\2]Q\3\2\2\2]Y\3\2\2\2^\22\3\2\2\2_e\t\2\2\2"+
		"`a\7^\2\2ab\7a\2\2be\7\"\2\2ce\7A\2\2d_\3\2\2\2d`\3\2\2\2dc\3\2\2\2ef"+
		"\3\2\2\2fd\3\2\2\2fg\3\2\2\2gk\3\2\2\2hj\4\62;\2ih\3\2\2\2jm\3\2\2\2k"+
		"i\3\2\2\2kl\3\2\2\2l\24\3\2\2\2mk\3\2\2\2np\4\62;\2on\3\2\2\2pq\3\2\2"+
		"\2qo\3\2\2\2qr\3\2\2\2r\26\3\2\2\2su\t\3\2\2ts\3\2\2\2uv\3\2\2\2vt\3\2"+
		"\2\2vw\3\2\2\2wx\3\2\2\2xy\b\f\2\2y\30\3\2\2\2\n\2I]dfkqv";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}