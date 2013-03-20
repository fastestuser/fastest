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
		T__3=1, T__2=2, T__1=3, T__0=4, BINOP=5, UNOP=6, NAME=7, NUM=8, WS=9;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'\\nat'", "')'", "'('", "'\\num'", "BINOP", "'\\power'", "NAME", "NUM", 
		"WS"
	};
	public static final String[] ruleNames = {
		"T__3", "T__2", "T__1", "T__0", "BINOP", "UNOP", "NAME", "NUM", "WS"
	};


		DefaultMutableTreeNode root = new DefaultMutableTreeNode();


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
		"\2\4\13Z\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4"+
		"\t\t\t\4\n\t\n\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\5\3\5"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\5\6\67\n\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\6\b"+
		"E\n\b\r\b\16\bF\3\b\7\bJ\n\b\f\b\16\bM\13\b\3\t\6\tP\n\t\r\t\16\tQ\3\n"+
		"\6\nU\n\n\r\n\16\nV\3\n\3\n\2\13\3\3\1\5\4\1\7\5\1\t\6\1\13\7\1\r\b\1"+
		"\17\t\1\21\n\1\23\13\2\3\2\4\4C\\c|\5\13\f\17\17\"\"b\2\3\3\2\2\2\2\5"+
		"\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2"+
		"\2\21\3\2\2\2\2\23\3\2\2\2\3\25\3\2\2\2\5\32\3\2\2\2\7\34\3\2\2\2\t\36"+
		"\3\2\2\2\13\66\3\2\2\2\r8\3\2\2\2\17D\3\2\2\2\21O\3\2\2\2\23T\3\2\2\2"+
		"\25\26\7^\2\2\26\27\7p\2\2\27\30\7c\2\2\30\31\7v\2\2\31\4\3\2\2\2\32\33"+
		"\7+\2\2\33\6\3\2\2\2\34\35\7*\2\2\35\b\3\2\2\2\36\37\7^\2\2\37 \7p\2\2"+
		" !\7w\2\2!\"\7o\2\2\"\n\3\2\2\2#$\7^\2\2$%\7t\2\2%&\7g\2\2&\67\7n\2\2"+
		"\'(\7^\2\2()\7r\2\2)*\7h\2\2*+\7w\2\2+\67\7p\2\2,-\7^\2\2-.\7h\2\2./\7"+
		"w\2\2/\67\7p\2\2\60\61\7^\2\2\61\62\7e\2\2\62\63\7t\2\2\63\64\7q\2\2\64"+
		"\65\7u\2\2\65\67\7u\2\2\66#\3\2\2\2\66\'\3\2\2\2\66,\3\2\2\2\66\60\3\2"+
		"\2\2\67\f\3\2\2\289\7^\2\29:\7r\2\2:;\7q\2\2;<\7y\2\2<=\7g\2\2=>\7t\2"+
		"\2>\16\3\2\2\2?E\t\2\2\2@A\7^\2\2AB\7a\2\2BE\7\"\2\2CE\7A\2\2D?\3\2\2"+
		"\2D@\3\2\2\2DC\3\2\2\2EF\3\2\2\2FD\3\2\2\2FG\3\2\2\2GK\3\2\2\2HJ\4\62"+
		";\2IH\3\2\2\2JM\3\2\2\2KI\3\2\2\2KL\3\2\2\2L\20\3\2\2\2MK\3\2\2\2NP\4"+
		"\62;\2ON\3\2\2\2PQ\3\2\2\2QO\3\2\2\2QR\3\2\2\2R\22\3\2\2\2SU\t\3\2\2T"+
		"S\3\2\2\2UV\3\2\2\2VT\3\2\2\2VW\3\2\2\2WX\3\2\2\2XY\b\n\2\2Y\24\3\2\2"+
		"\2\t\2\66DFKQV";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}