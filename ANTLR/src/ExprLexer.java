// Generated from Expr.g4 by ANTLR 4.0

	import java.util.HashMap;
	import java.util.ArrayList;
	import java.util.regex.Matcher;
	import java.util.regex.Pattern;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ExprLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__49=1, T__48=2, T__47=3, T__46=4, T__45=5, T__44=6, T__43=7, T__42=8, 
		T__41=9, T__40=10, T__39=11, T__38=12, T__37=13, T__36=14, T__35=15, T__34=16, 
		T__33=17, T__32=18, T__31=19, T__30=20, T__29=21, T__28=22, T__27=23, 
		T__26=24, T__25=25, T__24=26, T__23=27, T__22=28, T__21=29, T__20=30, 
		T__19=31, T__18=32, T__17=33, T__16=34, T__15=35, T__14=36, T__13=37, 
		T__12=38, T__11=39, T__10=40, T__9=41, T__8=42, T__7=43, T__6=44, T__5=45, 
		T__4=46, T__3=47, T__2=48, T__1=49, T__0=50, NAME=51, NUM=52, IN_FUN_P3=53, 
		IN_FUN_P4=54, NL=55, WS=56, SETSTART=57, SETEND=58, SKIP=59;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'\\lnot'", "'\\#'", "'['", "'\\pfun'", "'<'", "'false'", "'\\end{schema}'", 
		"'\\dom'", "'\\upto'", "'\\ffun'", "'}'", "'\\notin'", "'\\land'", "')'", 
		"'@'", "'\\seq'", "'='", "'\\leq'", "'\\nat'", "'\\neq'", "'\\where'", 
		"'\\geq'", "'::='", "'|'", "']'", "'\\rel'", "','", "'('", "':'", "'\\lor'", 
		"'\\ran'", "'\\end{zed}'", "'\\in'", "'\\cross'", "'true'", "'\\begin{axdef}'", 
		"'\\begin{schema}{'", "'\\subset'", "'\\power'", "'\\iff'", "'\\end{axdef}'", 
		"'\\fun'", "'\\implies'", "';'", "'>'", "'\\begin{zed}'", "'\\num'", "'=='", 
		"'~'", "'\\mapsto'", "NAME", "NUM", "IN_FUN_P3", "IN_FUN_P4", "NL", "WS", 
		"'\\{'", "'\\}'", "SKIP"
	};
	public static final String[] ruleNames = {
		"T__49", "T__48", "T__47", "T__46", "T__45", "T__44", "T__43", "T__42", 
		"T__41", "T__40", "T__39", "T__38", "T__37", "T__36", "T__35", "T__34", 
		"T__33", "T__32", "T__31", "T__30", "T__29", "T__28", "T__27", "T__26", 
		"T__25", "T__24", "T__23", "T__22", "T__21", "T__20", "T__19", "T__18", 
		"T__17", "T__16", "T__15", "T__14", "T__13", "T__12", "T__11", "T__10", 
		"T__9", "T__8", "T__7", "T__6", "T__5", "T__4", "T__3", "T__2", "T__1", 
		"T__0", "NAME", "NUM", "IN_FUN_P3", "IN_FUN_P4", "NL", "WS", "SETSTART", 
		"SETEND", "SKIP"
	};


		
		String setExpressionDecl, setExpressionPred, setExpressionExpr;
		
		int varNumber = 0;
		int modoSetExpression = 0; //0 = false, 1 = true
		
		ArrayList setExpressionVars;
		
		HashMap memory = new HashMap(); //En memory se guardan las variables y expressiones leidas
		HashMap types = new HashMap();	//En types se guarda informacion sobre los tipos definidos
		HashMap zVars = new HashMap();  //En zVars se almacenan las variables Z, a las cuales luego (antes de generar
		                                //el caso de prueba) se les dara un valor.
		
		String salida = new String();
		public String getSalida() {
			return salida;
		}
		
		public HashMap getMemory() {
			return memory;
		}
		
		public HashMap getTypes() {
			return types;
		}

		public void print(String c) {
			if (modoSetExpression == 0) 
				System.out.println(c + " &");
				//salida = salida.concat(c + " &");
			else if (modoSetExpression == 1)
				setExpressionDecl = setExpressionDecl.concat(" & " + c);
			else if (modoSetExpression == 2)
				setExpressionPred = setExpressionPred.concat(" & " + c);
			else if (modoSetExpression == 3)
				setExpressionExpr = setExpressionExpr.concat(" & " + c);
		}
		
		//Metodo para la determinacion del tipo.
		//Constraits: El arbol debio ser previamente generado
		//Input: String representando el tipo.
		//Output: String, con el valor del root.
		String getType(String type) {
			//El calculo se realiza mediante la construccion del arbol de tipos con la gramatica TypeManager
			ANTLRInputStream input = new ANTLRInputStream(type);
	        TypeManagerLexer lexer = new TypeManagerLexer(input);
	        CommonTokenStream tokens = new CommonTokenStream(lexer);
	        TypeManagerParser parser = new TypeManagerParser(tokens);
	        parser.typeManage();
	        return parser.getReturnRootType();
		}
		
		//Metodo para la determinacion del tipo de salida de una funcion.
		//Constraits: El arbol debio ser previamente generado, para un tipo "funcion"
		//Input: String representando el tipo y Int con la posicion del hijo deseado (empieza en 0).
		//Output: String, con el valor del nodo.
		String getChildType(String type, int pos) {
			//El calculo se realiza mediante la construccion del arbol de tipos con la gramatica TypeManager
			ANTLRInputStream input = new ANTLRInputStream(type);
	        TypeManagerLexer lexer = new TypeManagerLexer(input);
	        CommonTokenStream tokens = new CommonTokenStream(lexer);
	        TypeManagerParser parser = new TypeManagerParser(tokens);
	        parser.typeManage();
	        return parser.printChild(pos);
		}


	public ExprLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Expr.g4"; }

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
		case 55: WS_action((RuleContext)_localctx, actionIndex); break;

		case 58: SKIP_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: skip(); break;
		}
	}
	private void SKIP_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1: skip(); break;
		}
	}

	public static final String _serializedATN =
		"\2\4=\u01ca\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t"+
		"\b\4\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20"+
		"\t\20\4\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27"+
		"\t\27\4\30\t\30\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36"+
		"\t\36\4\37\t\37\4 \t \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4"+
		"(\t(\4)\t)\4*\t*\4+\t+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62"+
		"\t\62\4\63\t\63\4\64\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4"+
		":\t:\4;\t;\4<\t<\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\21\3\21\3"+
		"\21\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\25\3"+
		"\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3"+
		"\27\3\27\3\30\3\30\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\33\3\33\3"+
		"\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3"+
		" \3 \3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3#\3#\3"+
		"#\3$\3$\3$\3$\3$\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3&\3&\3&\3"+
		"&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'"+
		"\3(\3(\3(\3(\3(\3(\3(\3)\3)\3)\3)\3)\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*"+
		"\3*\3+\3+\3+\3+\3+\3,\3,\3,\3,\3,\3,\3,\3,\3,\3-\3-\3.\3.\3/\3/\3/\3/"+
		"\3/\3/\3/\3/\3/\3/\3/\3/\3\60\3\60\3\60\3\60\3\60\3\61\3\61\3\61\3\62"+
		"\3\62\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\64\3\64\3\64\3\64\3\64"+
		"\6\64\u0190\n\64\r\64\16\64\u0191\3\64\7\64\u0195\n\64\f\64\16\64\u0198"+
		"\13\64\3\65\6\65\u019b\n\65\r\65\16\65\u019c\3\66\3\66\3\66\3\66\3\66"+
		"\5\66\u01a4\n\66\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67"+
		"\3\67\3\67\5\67\u01b3\n\67\38\58\u01b6\n8\38\38\39\69\u01bb\n9\r9\169"+
		"\u01bc\39\39\3:\3:\3:\3;\3;\3;\3<\3<\3<\3<\2=\3\3\1\5\4\1\7\5\1\t\6\1"+
		"\13\7\1\r\b\1\17\t\1\21\n\1\23\13\1\25\f\1\27\r\1\31\16\1\33\17\1\35\20"+
		"\1\37\21\1!\22\1#\23\1%\24\1\'\25\1)\26\1+\27\1-\30\1/\31\1\61\32\1\63"+
		"\33\1\65\34\1\67\35\19\36\1;\37\1= \1?!\1A\"\1C#\1E$\1G%\1I&\1K\'\1M("+
		"\1O)\1Q*\1S+\1U,\1W-\1Y.\1[/\1]\60\1_\61\1a\62\1c\63\1e\64\1g\65\1i\66"+
		"\1k\67\1m8\1o9\1q:\2s;\1u<\1w=\3\3\2\5\4C\\c|\4--//\5\13\13\17\17\"\""+
		"\u01d4\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2"+
		"\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3"+
		"\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2"+
		"\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2"+
		"/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2"+
		"\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2"+
		"G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3"+
		"\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2"+
		"\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2"+
		"m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\3y\3"+
		"\2\2\2\5\177\3\2\2\2\7\u0082\3\2\2\2\t\u0084\3\2\2\2\13\u008a\3\2\2\2"+
		"\r\u008c\3\2\2\2\17\u0092\3\2\2\2\21\u009f\3\2\2\2\23\u00a4\3\2\2\2\25"+
		"\u00aa\3\2\2\2\27\u00b0\3\2\2\2\31\u00b2\3\2\2\2\33\u00b9\3\2\2\2\35\u00bf"+
		"\3\2\2\2\37\u00c1\3\2\2\2!\u00c3\3\2\2\2#\u00c8\3\2\2\2%\u00ca\3\2\2\2"+
		"\'\u00cf\3\2\2\2)\u00d4\3\2\2\2+\u00d9\3\2\2\2-\u00e0\3\2\2\2/\u00e5\3"+
		"\2\2\2\61\u00e9\3\2\2\2\63\u00eb\3\2\2\2\65\u00ed\3\2\2\2\67\u00f2\3\2"+
		"\2\29\u00f4\3\2\2\2;\u00f6\3\2\2\2=\u00f8\3\2\2\2?\u00fd\3\2\2\2A\u0102"+
		"\3\2\2\2C\u010c\3\2\2\2E\u0110\3\2\2\2G\u0117\3\2\2\2I\u011c\3\2\2\2K"+
		"\u012a\3\2\2\2M\u013a\3\2\2\2O\u0142\3\2\2\2Q\u0149\3\2\2\2S\u014e\3\2"+
		"\2\2U\u015a\3\2\2\2W\u015f\3\2\2\2Y\u0168\3\2\2\2[\u016a\3\2\2\2]\u016c"+
		"\3\2\2\2_\u0178\3\2\2\2a\u017d\3\2\2\2c\u0180\3\2\2\2e\u0182\3\2\2\2g"+
		"\u018f\3\2\2\2i\u019a\3\2\2\2k\u01a3\3\2\2\2m\u01b2\3\2\2\2o\u01b5\3\2"+
		"\2\2q\u01ba\3\2\2\2s\u01c0\3\2\2\2u\u01c3\3\2\2\2w\u01c6\3\2\2\2yz\7^"+
		"\2\2z{\7n\2\2{|\7p\2\2|}\7q\2\2}~\7v\2\2~\4\3\2\2\2\177\u0080\7^\2\2\u0080"+
		"\u0081\7%\2\2\u0081\6\3\2\2\2\u0082\u0083\7]\2\2\u0083\b\3\2\2\2\u0084"+
		"\u0085\7^\2\2\u0085\u0086\7r\2\2\u0086\u0087\7h\2\2\u0087\u0088\7w\2\2"+
		"\u0088\u0089\7p\2\2\u0089\n\3\2\2\2\u008a\u008b\7>\2\2\u008b\f\3\2\2\2"+
		"\u008c\u008d\7h\2\2\u008d\u008e\7c\2\2\u008e\u008f\7n\2\2\u008f\u0090"+
		"\7u\2\2\u0090\u0091\7g\2\2\u0091\16\3\2\2\2\u0092\u0093\7^\2\2\u0093\u0094"+
		"\7g\2\2\u0094\u0095\7p\2\2\u0095\u0096\7f\2\2\u0096\u0097\7}\2\2\u0097"+
		"\u0098\7u\2\2\u0098\u0099\7e\2\2\u0099\u009a\7j\2\2\u009a\u009b\7g\2\2"+
		"\u009b\u009c\7o\2\2\u009c\u009d\7c\2\2\u009d\u009e\7\177\2\2\u009e\20"+
		"\3\2\2\2\u009f\u00a0\7^\2\2\u00a0\u00a1\7f\2\2\u00a1\u00a2\7q\2\2\u00a2"+
		"\u00a3\7o\2\2\u00a3\22\3\2\2\2\u00a4\u00a5\7^\2\2\u00a5\u00a6\7w\2\2\u00a6"+
		"\u00a7\7r\2\2\u00a7\u00a8\7v\2\2\u00a8\u00a9\7q\2\2\u00a9\24\3\2\2\2\u00aa"+
		"\u00ab\7^\2\2\u00ab\u00ac\7h\2\2\u00ac\u00ad\7h\2\2\u00ad\u00ae\7w\2\2"+
		"\u00ae\u00af\7p\2\2\u00af\26\3\2\2\2\u00b0\u00b1\7\177\2\2\u00b1\30\3"+
		"\2\2\2\u00b2\u00b3\7^\2\2\u00b3\u00b4\7p\2\2\u00b4\u00b5\7q\2\2\u00b5"+
		"\u00b6\7v\2\2\u00b6\u00b7\7k\2\2\u00b7\u00b8\7p\2\2\u00b8\32\3\2\2\2\u00b9"+
		"\u00ba\7^\2\2\u00ba\u00bb\7n\2\2\u00bb\u00bc\7c\2\2\u00bc\u00bd\7p\2\2"+
		"\u00bd\u00be\7f\2\2\u00be\34\3\2\2\2\u00bf\u00c0\7+\2\2\u00c0\36\3\2\2"+
		"\2\u00c1\u00c2\7B\2\2\u00c2 \3\2\2\2\u00c3\u00c4\7^\2\2\u00c4\u00c5\7"+
		"u\2\2\u00c5\u00c6\7g\2\2\u00c6\u00c7\7s\2\2\u00c7\"\3\2\2\2\u00c8\u00c9"+
		"\7?\2\2\u00c9$\3\2\2\2\u00ca\u00cb\7^\2\2\u00cb\u00cc\7n\2\2\u00cc\u00cd"+
		"\7g\2\2\u00cd\u00ce\7s\2\2\u00ce&\3\2\2\2\u00cf\u00d0\7^\2\2\u00d0\u00d1"+
		"\7p\2\2\u00d1\u00d2\7c\2\2\u00d2\u00d3\7v\2\2\u00d3(\3\2\2\2\u00d4\u00d5"+
		"\7^\2\2\u00d5\u00d6\7p\2\2\u00d6\u00d7\7g\2\2\u00d7\u00d8\7s\2\2\u00d8"+
		"*\3\2\2\2\u00d9\u00da\7^\2\2\u00da\u00db\7y\2\2\u00db\u00dc\7j\2\2\u00dc"+
		"\u00dd\7g\2\2\u00dd\u00de\7t\2\2\u00de\u00df\7g\2\2\u00df,\3\2\2\2\u00e0"+
		"\u00e1\7^\2\2\u00e1\u00e2\7i\2\2\u00e2\u00e3\7g\2\2\u00e3\u00e4\7s\2\2"+
		"\u00e4.\3\2\2\2\u00e5\u00e6\7<\2\2\u00e6\u00e7\7<\2\2\u00e7\u00e8\7?\2"+
		"\2\u00e8\60\3\2\2\2\u00e9\u00ea\7~\2\2\u00ea\62\3\2\2\2\u00eb\u00ec\7"+
		"_\2\2\u00ec\64\3\2\2\2\u00ed\u00ee\7^\2\2\u00ee\u00ef\7t\2\2\u00ef\u00f0"+
		"\7g\2\2\u00f0\u00f1\7n\2\2\u00f1\66\3\2\2\2\u00f2\u00f3\7.\2\2\u00f38"+
		"\3\2\2\2\u00f4\u00f5\7*\2\2\u00f5:\3\2\2\2\u00f6\u00f7\7<\2\2\u00f7<\3"+
		"\2\2\2\u00f8\u00f9\7^\2\2\u00f9\u00fa\7n\2\2\u00fa\u00fb\7q\2\2\u00fb"+
		"\u00fc\7t\2\2\u00fc>\3\2\2\2\u00fd\u00fe\7^\2\2\u00fe\u00ff\7t\2\2\u00ff"+
		"\u0100\7c\2\2\u0100\u0101\7p\2\2\u0101@\3\2\2\2\u0102\u0103\7^\2\2\u0103"+
		"\u0104\7g\2\2\u0104\u0105\7p\2\2\u0105\u0106\7f\2\2\u0106\u0107\7}\2\2"+
		"\u0107\u0108\7|\2\2\u0108\u0109\7g\2\2\u0109\u010a\7f\2\2\u010a\u010b"+
		"\7\177\2\2\u010bB\3\2\2\2\u010c\u010d\7^\2\2\u010d\u010e\7k\2\2\u010e"+
		"\u010f\7p\2\2\u010fD\3\2\2\2\u0110\u0111\7^\2\2\u0111\u0112\7e\2\2\u0112"+
		"\u0113\7t\2\2\u0113\u0114\7q\2\2\u0114\u0115\7u\2\2\u0115\u0116\7u\2\2"+
		"\u0116F\3\2\2\2\u0117\u0118\7v\2\2\u0118\u0119\7t\2\2\u0119\u011a\7w\2"+
		"\2\u011a\u011b\7g\2\2\u011bH\3\2\2\2\u011c\u011d\7^\2\2\u011d\u011e\7"+
		"d\2\2\u011e\u011f\7g\2\2\u011f\u0120\7i\2\2\u0120\u0121\7k\2\2\u0121\u0122"+
		"\7p\2\2\u0122\u0123\7}\2\2\u0123\u0124\7c\2\2\u0124\u0125\7z\2\2\u0125"+
		"\u0126\7f\2\2\u0126\u0127\7g\2\2\u0127\u0128\7h\2\2\u0128\u0129\7\177"+
		"\2\2\u0129J\3\2\2\2\u012a\u012b\7^\2\2\u012b\u012c\7d\2\2\u012c\u012d"+
		"\7g\2\2\u012d\u012e\7i\2\2\u012e\u012f\7k\2\2\u012f\u0130\7p\2\2\u0130"+
		"\u0131\7}\2\2\u0131\u0132\7u\2\2\u0132\u0133\7e\2\2\u0133\u0134\7j\2\2"+
		"\u0134\u0135\7g\2\2\u0135\u0136\7o\2\2\u0136\u0137\7c\2\2\u0137\u0138"+
		"\7\177\2\2\u0138\u0139\7}\2\2\u0139L\3\2\2\2\u013a\u013b\7^\2\2\u013b"+
		"\u013c\7u\2\2\u013c\u013d\7w\2\2\u013d\u013e\7d\2\2\u013e\u013f\7u\2\2"+
		"\u013f\u0140\7g\2\2\u0140\u0141\7v\2\2\u0141N\3\2\2\2\u0142\u0143\7^\2"+
		"\2\u0143\u0144\7r\2\2\u0144\u0145\7q\2\2\u0145\u0146\7y\2\2\u0146\u0147"+
		"\7g\2\2\u0147\u0148\7t\2\2\u0148P\3\2\2\2\u0149\u014a\7^\2\2\u014a\u014b"+
		"\7k\2\2\u014b\u014c\7h\2\2\u014c\u014d\7h\2\2\u014dR\3\2\2\2\u014e\u014f"+
		"\7^\2\2\u014f\u0150\7g\2\2\u0150\u0151\7p\2\2\u0151\u0152\7f\2\2\u0152"+
		"\u0153\7}\2\2\u0153\u0154\7c\2\2\u0154\u0155\7z\2\2\u0155\u0156\7f\2\2"+
		"\u0156\u0157\7g\2\2\u0157\u0158\7h\2\2\u0158\u0159\7\177\2\2\u0159T\3"+
		"\2\2\2\u015a\u015b\7^\2\2\u015b\u015c\7h\2\2\u015c\u015d\7w\2\2\u015d"+
		"\u015e\7p\2\2\u015eV\3\2\2\2\u015f\u0160\7^\2\2\u0160\u0161\7k\2\2\u0161"+
		"\u0162\7o\2\2\u0162\u0163\7r\2\2\u0163\u0164\7n\2\2\u0164\u0165\7k\2\2"+
		"\u0165\u0166\7g\2\2\u0166\u0167\7u\2\2\u0167X\3\2\2\2\u0168\u0169\7=\2"+
		"\2\u0169Z\3\2\2\2\u016a\u016b\7@\2\2\u016b\\\3\2\2\2\u016c\u016d\7^\2"+
		"\2\u016d\u016e\7d\2\2\u016e\u016f\7g\2\2\u016f\u0170\7i\2\2\u0170\u0171"+
		"\7k\2\2\u0171\u0172\7p\2\2\u0172\u0173\7}\2\2\u0173\u0174\7|\2\2\u0174"+
		"\u0175\7g\2\2\u0175\u0176\7f\2\2\u0176\u0177\7\177\2\2\u0177^\3\2\2\2"+
		"\u0178\u0179\7^\2\2\u0179\u017a\7p\2\2\u017a\u017b\7w\2\2\u017b\u017c"+
		"\7o\2\2\u017c`\3\2\2\2\u017d\u017e\7?\2\2\u017e\u017f\7?\2\2\u017fb\3"+
		"\2\2\2\u0180\u0181\7\u0080\2\2\u0181d\3\2\2\2\u0182\u0183\7^\2\2\u0183"+
		"\u0184\7o\2\2\u0184\u0185\7c\2\2\u0185\u0186\7r\2\2\u0186\u0187\7u\2\2"+
		"\u0187\u0188\7v\2\2\u0188\u0189\7q\2\2\u0189f\3\2\2\2\u018a\u0190\t\2"+
		"\2\2\u018b\u018c\7^\2\2\u018c\u018d\7a\2\2\u018d\u0190\7\"\2\2\u018e\u0190"+
		"\7A\2\2\u018f\u018a\3\2\2\2\u018f\u018b\3\2\2\2\u018f\u018e\3\2\2\2\u0190"+
		"\u0191\3\2\2\2\u0191\u018f\3\2\2\2\u0191\u0192\3\2\2\2\u0192\u0196\3\2"+
		"\2\2\u0193\u0195\4\62;\2\u0194\u0193\3\2\2\2\u0195\u0198\3\2\2\2\u0196"+
		"\u0194\3\2\2\2\u0196\u0197\3\2\2\2\u0197h\3\2\2\2\u0198\u0196\3\2\2\2"+
		"\u0199\u019b\4\62;\2\u019a\u0199\3\2\2\2\u019b\u019c\3\2\2\2\u019c\u019a"+
		"\3\2\2\2\u019c\u019d\3\2\2\2\u019dj\3\2\2\2\u019e\u01a4\t\3\2\2\u019f"+
		"\u01a0\7^\2\2\u01a0\u01a1\7e\2\2\u01a1\u01a2\7w\2\2\u01a2\u01a4\7r\2\2"+
		"\u01a3\u019e\3\2\2\2\u01a3\u019f\3\2\2\2\u01a4l\3\2\2\2\u01a5\u01b3\7"+
		",\2\2\u01a6\u01a7\7^\2\2\u01a7\u01a8\7f\2\2\u01a8\u01a9\7k\2\2\u01a9\u01b3"+
		"\7x\2\2\u01aa\u01ab\7^\2\2\u01ab\u01ac\7o\2\2\u01ac\u01ad\7q\2\2\u01ad"+
		"\u01b3\7f\2\2\u01ae\u01af\7^\2\2\u01af\u01b0\7e\2\2\u01b0\u01b1\7c\2\2"+
		"\u01b1\u01b3\7r\2\2\u01b2\u01a5\3\2\2\2\u01b2\u01a6\3\2\2\2\u01b2\u01aa"+
		"\3\2\2\2\u01b2\u01ae\3\2\2\2\u01b3n\3\2\2\2\u01b4\u01b6\7\17\2\2\u01b5"+
		"\u01b4\3\2\2\2\u01b5\u01b6\3\2\2\2\u01b6\u01b7\3\2\2\2\u01b7\u01b8\7\f"+
		"\2\2\u01b8p\3\2\2\2\u01b9\u01bb\t\4\2\2\u01ba\u01b9\3\2\2\2\u01bb\u01bc"+
		"\3\2\2\2\u01bc\u01ba\3\2\2\2\u01bc\u01bd\3\2\2\2\u01bd\u01be\3\2\2\2\u01be"+
		"\u01bf\b9\2\2\u01bfr\3\2\2\2\u01c0\u01c1\7^\2\2\u01c1\u01c2\7}\2\2\u01c2"+
		"t\3\2\2\2\u01c3\u01c4\7^\2\2\u01c4\u01c5\7\177\2\2\u01c5v\3\2\2\2\u01c6"+
		"\u01c7\7^\2\2\u01c7\u01c8\7^\2\2\u01c8\u01c9\b<\3\2\u01c9x\3\2\2\2\13"+
		"\2\u018f\u0191\u0196\u019c\u01a3\u01b2\u01b5\u01bc";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}