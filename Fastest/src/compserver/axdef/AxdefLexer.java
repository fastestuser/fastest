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
	

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class AxdefLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__4=1, T__3=2, T__2=3, T__1=4, T__0=5, OP=6, WORD=7, NUM=8, WS=9;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'\\emptyset'", "')'", "','", "'('", "'~'", "OP", "WORD", "NUM", "WS"
	};
	public static final String[] ruleNames = {
		"T__4", "T__3", "T__2", "T__1", "T__0", "OP", "WORD", "NUM", "WS"
	};


		ArrayList<String> arguments = new ArrayList<String>();
		String functionName;
		int argAmmount;

		DefaultMutableTreeNode root = new DefaultMutableTreeNode();
		public DefaultMutableTreeNode getRoot() {
			return root;
		}


	public AxdefLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Axdef.g4"; }

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
		"\2\4\13<\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4"+
		"\t\t\t\4\n\t\n\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4"+
		"\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\7\b,\n\b\f\b\16\b/\13\b\3\t\6\t\62\n"+
		"\t\r\t\16\t\63\3\n\6\n\67\n\n\r\n\16\n8\3\n\3\n\2\13\3\3\1\5\4\1\7\5\1"+
		"\t\6\1\13\7\1\r\b\1\17\t\1\21\n\1\23\13\2\3\2\6\4--@@\4C\\c|\6AAC\\aa"+
		"c|\5\f\f\17\17\"\">\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2"+
		"\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\3\25\3"+
		"\2\2\2\5\37\3\2\2\2\7!\3\2\2\2\t#\3\2\2\2\13%\3\2\2\2\r\'\3\2\2\2\17)"+
		"\3\2\2\2\21\61\3\2\2\2\23\66\3\2\2\2\25\26\7^\2\2\26\27\7g\2\2\27\30\7"+
		"o\2\2\30\31\7r\2\2\31\32\7v\2\2\32\33\7{\2\2\33\34\7u\2\2\34\35\7g\2\2"+
		"\35\36\7v\2\2\36\4\3\2\2\2\37 \7+\2\2 \6\3\2\2\2!\"\7.\2\2\"\b\3\2\2\2"+
		"#$\7*\2\2$\n\3\2\2\2%&\7\u0080\2\2&\f\3\2\2\2\'(\t\2\2\2(\16\3\2\2\2)"+
		"-\t\3\2\2*,\t\4\2\2+*\3\2\2\2,/\3\2\2\2-+\3\2\2\2-.\3\2\2\2.\20\3\2\2"+
		"\2/-\3\2\2\2\60\62\4\62;\2\61\60\3\2\2\2\62\63\3\2\2\2\63\61\3\2\2\2\63"+
		"\64\3\2\2\2\64\22\3\2\2\2\65\67\t\5\2\2\66\65\3\2\2\2\678\3\2\2\28\66"+
		"\3\2\2\289\3\2\2\29:\3\2\2\2:;\b\n\2\2;\24\3\2\2\2\6\2-\638";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}