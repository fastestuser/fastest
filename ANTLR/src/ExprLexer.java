// Generated from Expr.g4 by ANTLR 4.0

	import java.util.HashMap;
	import java.util.ArrayList;
	import java.util.regex.Matcher;
	import java.util.regex.Pattern;
	import javax.swing.tree.DefaultMutableTreeNode;

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
		T__51=1, T__50=2, T__49=3, T__48=4, T__47=5, T__46=6, T__45=7, T__44=8, 
		T__43=9, T__42=10, T__41=11, T__40=12, T__39=13, T__38=14, T__37=15, T__36=16, 
		T__35=17, T__34=18, T__33=19, T__32=20, T__31=21, T__30=22, T__29=23, 
		T__28=24, T__27=25, T__26=26, T__25=27, T__24=28, T__23=29, T__22=30, 
		T__21=31, T__20=32, T__19=33, T__18=34, T__17=35, T__16=36, T__15=37, 
		T__14=38, T__13=39, T__12=40, T__11=41, T__10=42, T__9=43, T__8=44, T__7=45, 
		T__6=46, T__5=47, T__4=48, T__3=49, T__2=50, T__1=51, T__0=52, NAME=53, 
		NUM=54, IN_FUN_P3=55, IN_FUN_P4=56, NL=57, WS=58, SETSTART=59, SETEND=60, 
		SKIP=61;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'schema'", "'\\lnot'", "'\\#'", "'['", "'\\pfun'", "'<'", "'false'", 
		"'\\dom'", "'\\upto'", "'\\ffun'", "'}'", "'\\notin'", "'\\land'", "')'", 
		"'@'", "'\\seq'", "'='", "'\\leq'", "'\\nat'", "'\\neq'", "'\\geq'", "'\\where'", 
		"'::='", "'|'", "'\\end{'", "']'", "'\\rel'", "','", "'}{'", "'('", "':'", 
		"'\\lor'", "'\\end{zed}'", "'\\ran'", "'\\in'", "'\\cross'", "'true'", 
		"'\\begin{'", "'\\subset'", "'\\power'", "'.'", "'\\iff'", "'schemaType'", 
		"'\\fun'", "'\\implies'", "';'", "'>'", "'\\begin{zed}'", "'\\num'", "'=='", 
		"'~'", "'\\mapsto'", "NAME", "NUM", "IN_FUN_P3", "IN_FUN_P4", "NL", "WS", 
		"'\\{'", "'\\}'", "SKIP"
	};
	public static final String[] ruleNames = {
		"T__51", "T__50", "T__49", "T__48", "T__47", "T__46", "T__45", "T__44", 
		"T__43", "T__42", "T__41", "T__40", "T__39", "T__38", "T__37", "T__36", 
		"T__35", "T__34", "T__33", "T__32", "T__31", "T__30", "T__29", "T__28", 
		"T__27", "T__26", "T__25", "T__24", "T__23", "T__22", "T__21", "T__20", 
		"T__19", "T__18", "T__17", "T__16", "T__15", "T__14", "T__13", "T__12", 
		"T__11", "T__10", "T__9", "T__8", "T__7", "T__6", "T__5", "T__4", "T__3", 
		"T__2", "T__1", "T__0", "NAME", "NUM", "IN_FUN_P3", "IN_FUN_P4", "NL", 
		"WS", "SETSTART", "SETEND", "SKIP"
	};


		
		String setExpressionDecl, setExpressionPred, setExpressionExpr;
		String schemaTypeVars = new String();
		
		int varNumber = 0;
		int modoSetExpression = 0; //0 = false, 1 = true
		int tipoSchema = 0;        //0 = false, 1 = true, esta variable se utiliza para no imprimir ciertas cosas,
						           //cuando trabajamos en tipos schema
		
		HashMap<String,String> setExpressionVars;
		
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
		
		public HashMap getZVars() {
			return zVars;
		}

		public void print(String c) {
			if (modoSetExpression == 0 & tipoSchema == 0) 
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
	        DefaultMutableTreeNode root = parser.getRoot();
	        return (String) root.getUserObject();
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
	        DefaultMutableTreeNode root = parser.getRoot();
	        return parser.printTree((DefaultMutableTreeNode) root.getChildAt(pos));
		}
		
		private String newVar() {
			String newVarName = "VAR" + varNumber;
			varNumber++;
			return newVarName;
		}
		
		private String newVar(String zName) {
			String newVarName = zName.substring(0,1).toUpperCase() + zName.substring(1).replace("?","");
			if (memory.containsValue(newVarName) || modoSetExpression==1) { 
				newVarName = "VAR" + varNumber;
				varNumber++;
			}
			return newVarName;
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
		case 57: WS_action((RuleContext)_localctx, actionIndex); break;

		case 60: SKIP_action((RuleContext)_localctx, actionIndex); break;
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
		"\2\4?\u01bc\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t"+
		"\b\4\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20"+
		"\t\20\4\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27"+
		"\t\27\4\30\t\30\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36"+
		"\t\36\4\37\t\37\4 \t \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4"+
		"(\t(\4)\t)\4*\t*\4+\t+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62"+
		"\t\62\4\63\t\63\4\64\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4"+
		":\t:\4;\t;\4<\t<\4=\t=\4>\t>\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\22\3\22"+
		"\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25"+
		"\3\25\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\30"+
		"\3\30\3\30\3\30\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\34"+
		"\3\34\3\34\3\34\3\34\3\35\3\35\3\36\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3"+
		"!\3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3#\3$\3$\3"+
		"$\3$\3%\3%\3%\3%\3%\3%\3%\3&\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3"+
		"\'\3(\3(\3(\3(\3(\3(\3(\3(\3)\3)\3)\3)\3)\3)\3)\3*\3*\3+\3+\3+\3+\3+\3"+
		",\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3-\3-\3-\3-\3-\3.\3.\3.\3.\3.\3.\3.\3"+
		".\3.\3/\3/\3\60\3\60\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61"+
		"\3\61\3\61\3\62\3\62\3\62\3\62\3\62\3\63\3\63\3\63\3\64\3\64\3\65\3\65"+
		"\3\65\3\65\3\65\3\65\3\65\3\65\3\66\3\66\3\66\3\66\3\66\6\66\u0182\n\66"+
		"\r\66\16\66\u0183\3\66\7\66\u0187\n\66\f\66\16\66\u018a\13\66\3\67\6\67"+
		"\u018d\n\67\r\67\16\67\u018e\38\38\38\38\38\58\u0196\n8\39\39\39\39\3"+
		"9\39\39\39\39\39\39\39\39\59\u01a5\n9\3:\5:\u01a8\n:\3:\3:\3;\6;\u01ad"+
		"\n;\r;\16;\u01ae\3;\3;\3<\3<\3<\3=\3=\3=\3>\3>\3>\3>\2?\3\3\1\5\4\1\7"+
		"\5\1\t\6\1\13\7\1\r\b\1\17\t\1\21\n\1\23\13\1\25\f\1\27\r\1\31\16\1\33"+
		"\17\1\35\20\1\37\21\1!\22\1#\23\1%\24\1\'\25\1)\26\1+\27\1-\30\1/\31\1"+
		"\61\32\1\63\33\1\65\34\1\67\35\19\36\1;\37\1= \1?!\1A\"\1C#\1E$\1G%\1"+
		"I&\1K\'\1M(\1O)\1Q*\1S+\1U,\1W-\1Y.\1[/\1]\60\1_\61\1a\62\1c\63\1e\64"+
		"\1g\65\1i\66\1k\67\1m8\1o9\1q:\1s;\1u<\2w=\1y>\1{?\3\3\2\5\4C\\c|\4--"+
		"//\5\13\13\17\17\"\"\u01c6\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2"+
		"\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2"+
		"\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3"+
		"\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2"+
		"\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67"+
		"\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2"+
		"\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2"+
		"\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]"+
		"\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2"+
		"\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2"+
		"\2w\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\3}\3\2\2\2\5\u0084\3\2\2\2\7\u008a\3"+
		"\2\2\2\t\u008d\3\2\2\2\13\u008f\3\2\2\2\r\u0095\3\2\2\2\17\u0097\3\2\2"+
		"\2\21\u009d\3\2\2\2\23\u00a2\3\2\2\2\25\u00a8\3\2\2\2\27\u00ae\3\2\2\2"+
		"\31\u00b0\3\2\2\2\33\u00b7\3\2\2\2\35\u00bd\3\2\2\2\37\u00bf\3\2\2\2!"+
		"\u00c1\3\2\2\2#\u00c6\3\2\2\2%\u00c8\3\2\2\2\'\u00cd\3\2\2\2)\u00d2\3"+
		"\2\2\2+\u00d7\3\2\2\2-\u00dc\3\2\2\2/\u00e3\3\2\2\2\61\u00e7\3\2\2\2\63"+
		"\u00e9\3\2\2\2\65\u00ef\3\2\2\2\67\u00f1\3\2\2\29\u00f6\3\2\2\2;\u00f8"+
		"\3\2\2\2=\u00fb\3\2\2\2?\u00fd\3\2\2\2A\u00ff\3\2\2\2C\u0104\3\2\2\2E"+
		"\u010e\3\2\2\2G\u0113\3\2\2\2I\u0117\3\2\2\2K\u011e\3\2\2\2M\u0123\3\2"+
		"\2\2O\u012b\3\2\2\2Q\u0133\3\2\2\2S\u013a\3\2\2\2U\u013c\3\2\2\2W\u0141"+
		"\3\2\2\2Y\u014c\3\2\2\2[\u0151\3\2\2\2]\u015a\3\2\2\2_\u015c\3\2\2\2a"+
		"\u015e\3\2\2\2c\u016a\3\2\2\2e\u016f\3\2\2\2g\u0172\3\2\2\2i\u0174\3\2"+
		"\2\2k\u0181\3\2\2\2m\u018c\3\2\2\2o\u0195\3\2\2\2q\u01a4\3\2\2\2s\u01a7"+
		"\3\2\2\2u\u01ac\3\2\2\2w\u01b2\3\2\2\2y\u01b5\3\2\2\2{\u01b8\3\2\2\2}"+
		"~\7u\2\2~\177\7e\2\2\177\u0080\7j\2\2\u0080\u0081\7g\2\2\u0081\u0082\7"+
		"o\2\2\u0082\u0083\7c\2\2\u0083\4\3\2\2\2\u0084\u0085\7^\2\2\u0085\u0086"+
		"\7n\2\2\u0086\u0087\7p\2\2\u0087\u0088\7q\2\2\u0088\u0089\7v\2\2\u0089"+
		"\6\3\2\2\2\u008a\u008b\7^\2\2\u008b\u008c\7%\2\2\u008c\b\3\2\2\2\u008d"+
		"\u008e\7]\2\2\u008e\n\3\2\2\2\u008f\u0090\7^\2\2\u0090\u0091\7r\2\2\u0091"+
		"\u0092\7h\2\2\u0092\u0093\7w\2\2\u0093\u0094\7p\2\2\u0094\f\3\2\2\2\u0095"+
		"\u0096\7>\2\2\u0096\16\3\2\2\2\u0097\u0098\7h\2\2\u0098\u0099\7c\2\2\u0099"+
		"\u009a\7n\2\2\u009a\u009b\7u\2\2\u009b\u009c\7g\2\2\u009c\20\3\2\2\2\u009d"+
		"\u009e\7^\2\2\u009e\u009f\7f\2\2\u009f\u00a0\7q\2\2\u00a0\u00a1\7o\2\2"+
		"\u00a1\22\3\2\2\2\u00a2\u00a3\7^\2\2\u00a3\u00a4\7w\2\2\u00a4\u00a5\7"+
		"r\2\2\u00a5\u00a6\7v\2\2\u00a6\u00a7\7q\2\2\u00a7\24\3\2\2\2\u00a8\u00a9"+
		"\7^\2\2\u00a9\u00aa\7h\2\2\u00aa\u00ab\7h\2\2\u00ab\u00ac\7w\2\2\u00ac"+
		"\u00ad\7p\2\2\u00ad\26\3\2\2\2\u00ae\u00af\7\177\2\2\u00af\30\3\2\2\2"+
		"\u00b0\u00b1\7^\2\2\u00b1\u00b2\7p\2\2\u00b2\u00b3\7q\2\2\u00b3\u00b4"+
		"\7v\2\2\u00b4\u00b5\7k\2\2\u00b5\u00b6\7p\2\2\u00b6\32\3\2\2\2\u00b7\u00b8"+
		"\7^\2\2\u00b8\u00b9\7n\2\2\u00b9\u00ba\7c\2\2\u00ba\u00bb\7p\2\2\u00bb"+
		"\u00bc\7f\2\2\u00bc\34\3\2\2\2\u00bd\u00be\7+\2\2\u00be\36\3\2\2\2\u00bf"+
		"\u00c0\7B\2\2\u00c0 \3\2\2\2\u00c1\u00c2\7^\2\2\u00c2\u00c3\7u\2\2\u00c3"+
		"\u00c4\7g\2\2\u00c4\u00c5\7s\2\2\u00c5\"\3\2\2\2\u00c6\u00c7\7?\2\2\u00c7"+
		"$\3\2\2\2\u00c8\u00c9\7^\2\2\u00c9\u00ca\7n\2\2\u00ca\u00cb\7g\2\2\u00cb"+
		"\u00cc\7s\2\2\u00cc&\3\2\2\2\u00cd\u00ce\7^\2\2\u00ce\u00cf\7p\2\2\u00cf"+
		"\u00d0\7c\2\2\u00d0\u00d1\7v\2\2\u00d1(\3\2\2\2\u00d2\u00d3\7^\2\2\u00d3"+
		"\u00d4\7p\2\2\u00d4\u00d5\7g\2\2\u00d5\u00d6\7s\2\2\u00d6*\3\2\2\2\u00d7"+
		"\u00d8\7^\2\2\u00d8\u00d9\7i\2\2\u00d9\u00da\7g\2\2\u00da\u00db\7s\2\2"+
		"\u00db,\3\2\2\2\u00dc\u00dd\7^\2\2\u00dd\u00de\7y\2\2\u00de\u00df\7j\2"+
		"\2\u00df\u00e0\7g\2\2\u00e0\u00e1\7t\2\2\u00e1\u00e2\7g\2\2\u00e2.\3\2"+
		"\2\2\u00e3\u00e4\7<\2\2\u00e4\u00e5\7<\2\2\u00e5\u00e6\7?\2\2\u00e6\60"+
		"\3\2\2\2\u00e7\u00e8\7~\2\2\u00e8\62\3\2\2\2\u00e9\u00ea\7^\2\2\u00ea"+
		"\u00eb\7g\2\2\u00eb\u00ec\7p\2\2\u00ec\u00ed\7f\2\2\u00ed\u00ee\7}\2\2"+
		"\u00ee\64\3\2\2\2\u00ef\u00f0\7_\2\2\u00f0\66\3\2\2\2\u00f1\u00f2\7^\2"+
		"\2\u00f2\u00f3\7t\2\2\u00f3\u00f4\7g\2\2\u00f4\u00f5\7n\2\2\u00f58\3\2"+
		"\2\2\u00f6\u00f7\7.\2\2\u00f7:\3\2\2\2\u00f8\u00f9\7\177\2\2\u00f9\u00fa"+
		"\7}\2\2\u00fa<\3\2\2\2\u00fb\u00fc\7*\2\2\u00fc>\3\2\2\2\u00fd\u00fe\7"+
		"<\2\2\u00fe@\3\2\2\2\u00ff\u0100\7^\2\2\u0100\u0101\7n\2\2\u0101\u0102"+
		"\7q\2\2\u0102\u0103\7t\2\2\u0103B\3\2\2\2\u0104\u0105\7^\2\2\u0105\u0106"+
		"\7g\2\2\u0106\u0107\7p\2\2\u0107\u0108\7f\2\2\u0108\u0109\7}\2\2\u0109"+
		"\u010a\7|\2\2\u010a\u010b\7g\2\2\u010b\u010c\7f\2\2\u010c\u010d\7\177"+
		"\2\2\u010dD\3\2\2\2\u010e\u010f\7^\2\2\u010f\u0110\7t\2\2\u0110\u0111"+
		"\7c\2\2\u0111\u0112\7p\2\2\u0112F\3\2\2\2\u0113\u0114\7^\2\2\u0114\u0115"+
		"\7k\2\2\u0115\u0116\7p\2\2\u0116H\3\2\2\2\u0117\u0118\7^\2\2\u0118\u0119"+
		"\7e\2\2\u0119\u011a\7t\2\2\u011a\u011b\7q\2\2\u011b\u011c\7u\2\2\u011c"+
		"\u011d\7u\2\2\u011dJ\3\2\2\2\u011e\u011f\7v\2\2\u011f\u0120\7t\2\2\u0120"+
		"\u0121\7w\2\2\u0121\u0122\7g\2\2\u0122L\3\2\2\2\u0123\u0124\7^\2\2\u0124"+
		"\u0125\7d\2\2\u0125\u0126\7g\2\2\u0126\u0127\7i\2\2\u0127\u0128\7k\2\2"+
		"\u0128\u0129\7p\2\2\u0129\u012a\7}\2\2\u012aN\3\2\2\2\u012b\u012c\7^\2"+
		"\2\u012c\u012d\7u\2\2\u012d\u012e\7w\2\2\u012e\u012f\7d\2\2\u012f\u0130"+
		"\7u\2\2\u0130\u0131\7g\2\2\u0131\u0132\7v\2\2\u0132P\3\2\2\2\u0133\u0134"+
		"\7^\2\2\u0134\u0135\7r\2\2\u0135\u0136\7q\2\2\u0136\u0137\7y\2\2\u0137"+
		"\u0138\7g\2\2\u0138\u0139\7t\2\2\u0139R\3\2\2\2\u013a\u013b\7\60\2\2\u013b"+
		"T\3\2\2\2\u013c\u013d\7^\2\2\u013d\u013e\7k\2\2\u013e\u013f\7h\2\2\u013f"+
		"\u0140\7h\2\2\u0140V\3\2\2\2\u0141\u0142\7u\2\2\u0142\u0143\7e\2\2\u0143"+
		"\u0144\7j\2\2\u0144\u0145\7g\2\2\u0145\u0146\7o\2\2\u0146\u0147\7c\2\2"+
		"\u0147\u0148\7V\2\2\u0148\u0149\7{\2\2\u0149\u014a\7r\2\2\u014a\u014b"+
		"\7g\2\2\u014bX\3\2\2\2\u014c\u014d\7^\2\2\u014d\u014e\7h\2\2\u014e\u014f"+
		"\7w\2\2\u014f\u0150\7p\2\2\u0150Z\3\2\2\2\u0151\u0152\7^\2\2\u0152\u0153"+
		"\7k\2\2\u0153\u0154\7o\2\2\u0154\u0155\7r\2\2\u0155\u0156\7n\2\2\u0156"+
		"\u0157\7k\2\2\u0157\u0158\7g\2\2\u0158\u0159\7u\2\2\u0159\\\3\2\2\2\u015a"+
		"\u015b\7=\2\2\u015b^\3\2\2\2\u015c\u015d\7@\2\2\u015d`\3\2\2\2\u015e\u015f"+
		"\7^\2\2\u015f\u0160\7d\2\2\u0160\u0161\7g\2\2\u0161\u0162\7i\2\2\u0162"+
		"\u0163\7k\2\2\u0163\u0164\7p\2\2\u0164\u0165\7}\2\2\u0165\u0166\7|\2\2"+
		"\u0166\u0167\7g\2\2\u0167\u0168\7f\2\2\u0168\u0169\7\177\2\2\u0169b\3"+
		"\2\2\2\u016a\u016b\7^\2\2\u016b\u016c\7p\2\2\u016c\u016d\7w\2\2\u016d"+
		"\u016e\7o\2\2\u016ed\3\2\2\2\u016f\u0170\7?\2\2\u0170\u0171\7?\2\2\u0171"+
		"f\3\2\2\2\u0172\u0173\7\u0080\2\2\u0173h\3\2\2\2\u0174\u0175\7^\2\2\u0175"+
		"\u0176\7o\2\2\u0176\u0177\7c\2\2\u0177\u0178\7r\2\2\u0178\u0179\7u\2\2"+
		"\u0179\u017a\7v\2\2\u017a\u017b\7q\2\2\u017bj\3\2\2\2\u017c\u0182\t\2"+
		"\2\2\u017d\u017e\7^\2\2\u017e\u017f\7a\2\2\u017f\u0182\7\"\2\2\u0180\u0182"+
		"\7A\2\2\u0181\u017c\3\2\2\2\u0181\u017d\3\2\2\2\u0181\u0180\3\2\2\2\u0182"+
		"\u0183\3\2\2\2\u0183\u0181\3\2\2\2\u0183\u0184\3\2\2\2\u0184\u0188\3\2"+
		"\2\2\u0185\u0187\4\62;\2\u0186\u0185\3\2\2\2\u0187\u018a\3\2\2\2\u0188"+
		"\u0186\3\2\2\2\u0188\u0189\3\2\2\2\u0189l\3\2\2\2\u018a\u0188\3\2\2\2"+
		"\u018b\u018d\4\62;\2\u018c\u018b\3\2\2\2\u018d\u018e\3\2\2\2\u018e\u018c"+
		"\3\2\2\2\u018e\u018f\3\2\2\2\u018fn\3\2\2\2\u0190\u0196\t\3\2\2\u0191"+
		"\u0192\7^\2\2\u0192\u0193\7e\2\2\u0193\u0194\7w\2\2\u0194\u0196\7r\2\2"+
		"\u0195\u0190\3\2\2\2\u0195\u0191\3\2\2\2\u0196p\3\2\2\2\u0197\u01a5\7"+
		",\2\2\u0198\u0199\7^\2\2\u0199\u019a\7f\2\2\u019a\u019b\7k\2\2\u019b\u01a5"+
		"\7x\2\2\u019c\u019d\7^\2\2\u019d\u019e\7o\2\2\u019e\u019f\7q\2\2\u019f"+
		"\u01a5\7f\2\2\u01a0\u01a1\7^\2\2\u01a1\u01a2\7e\2\2\u01a2\u01a3\7c\2\2"+
		"\u01a3\u01a5\7r\2\2\u01a4\u0197\3\2\2\2\u01a4\u0198\3\2\2\2\u01a4\u019c"+
		"\3\2\2\2\u01a4\u01a0\3\2\2\2\u01a5r\3\2\2\2\u01a6\u01a8\7\17\2\2\u01a7"+
		"\u01a6\3\2\2\2\u01a7\u01a8\3\2\2\2\u01a8\u01a9\3\2\2\2\u01a9\u01aa\7\f"+
		"\2\2\u01aat\3\2\2\2\u01ab\u01ad\t\4\2\2\u01ac\u01ab\3\2\2\2\u01ad\u01ae"+
		"\3\2\2\2\u01ae\u01ac\3\2\2\2\u01ae\u01af\3\2\2\2\u01af\u01b0\3\2\2\2\u01b0"+
		"\u01b1\b;\2\2\u01b1v\3\2\2\2\u01b2\u01b3\7^\2\2\u01b3\u01b4\7}\2\2\u01b4"+
		"x\3\2\2\2\u01b5\u01b6\7^\2\2\u01b6\u01b7\7\177\2\2\u01b7z\3\2\2\2\u01b8"+
		"\u01b9\7^\2\2\u01b9\u01ba\7^\2\2\u01ba\u01bb\b>\3\2\u01bb|\3\2\2\2\13"+
		"\2\u0181\u0183\u0188\u018e\u0195\u01a4\u01a7\u01ae";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}