// Generated from Expr.g4 by ANTLR 4.0

	package compserver.tcasegen.strategies.SetLogGrammar;
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
		T__54=1, T__53=2, T__52=3, T__51=4, T__50=5, T__49=6, T__48=7, T__47=8, 
		T__46=9, T__45=10, T__44=11, T__43=12, T__42=13, T__41=14, T__40=15, T__39=16, 
		T__38=17, T__37=18, T__36=19, T__35=20, T__34=21, T__33=22, T__32=23, 
		T__31=24, T__30=25, T__29=26, T__28=27, T__27=28, T__26=29, T__25=30, 
		T__24=31, T__23=32, T__22=33, T__21=34, T__20=35, T__19=36, T__18=37, 
		T__17=38, T__16=39, T__15=40, T__14=41, T__13=42, T__12=43, T__11=44, 
		T__10=45, T__9=46, T__8=47, T__7=48, T__6=49, T__5=50, T__4=51, T__3=52, 
		T__2=53, T__1=54, T__0=55, NAME=56, NUM=57, IN_FUN_P3=58, IN_FUN_P4=59, 
		IN_FUN_P5=60, NL=61, WS=62, SETSTART=63, SETEND=64, LISTSTART=65, LISTEND=66, 
		SKIP=67;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'schema'", "'\\lnot'", "'\\#'", "'['", "'\\pfun'", "'<'", "'false'", 
		"'\\dom'", "'\\emptyset'", "'\\upto'", "'\\ffun'", "'}'", "'\\notin'", 
		"'\\land'", "')'", "'@'", "'\\seq'", "'='", "'\\leq'", "'\\neq'", "'\\nat'", 
		"'\\where'", "'\\geq'", "'\\bigcup'", "'::='", "'\\subseteq'", "'|'", 
		"'\\end{'", "']'", "'\\rel'", "','", "'}{'", "'('", "':'", "'\\lor'", 
		"'\\end{zed}'", "'\\ran'", "'\\in'", "'\\cross'", "'true'", "'\\begin{'", 
		"'\\subset'", "'\\power'", "'.'", "'\\iff'", "'schemaType'", "'\\fun'", 
		"'\\implies'", "';'", "'>'", "'\\begin{zed}'", "'\\num'", "'=='", "'~'", 
		"'\\mapsto'", "NAME", "NUM", "IN_FUN_P3", "IN_FUN_P4", "IN_FUN_P5", "NL", 
		"WS", "'\\{'", "'\\}'", "LISTSTART", "'\\rangle'", "SKIP"
	};
	public static final String[] ruleNames = {
		"T__54", "T__53", "T__52", "T__51", "T__50", "T__49", "T__48", "T__47", 
		"T__46", "T__45", "T__44", "T__43", "T__42", "T__41", "T__40", "T__39", 
		"T__38", "T__37", "T__36", "T__35", "T__34", "T__33", "T__32", "T__31", 
		"T__30", "T__29", "T__28", "T__27", "T__26", "T__25", "T__24", "T__23", 
		"T__22", "T__21", "T__20", "T__19", "T__18", "T__17", "T__16", "T__15", 
		"T__14", "T__13", "T__12", "T__11", "T__10", "T__9", "T__8", "T__7", "T__6", 
		"T__5", "T__4", "T__3", "T__2", "T__1", "T__0", "NAME", "NUM", "IN_FUN_P3", 
		"IN_FUN_P4", "IN_FUN_P5", "NL", "WS", "SETSTART", "SETEND", "LISTSTART", 
		"LISTEND", "SKIP"
	};


		
		String setExpressionDecl, setExpressionPred, setExpressionExpr;
		String schemaTypeVars = new String();
		
		int varNumber = 0;
		int modoSetExpression = 0; //0 = false, 1 = true
		int tipoSchema = 0;        //0 = false, 1 = true, esta variable se utiliza para no imprimir ciertas cosas,
						           //cuando trabajamos en tipos schema
		
		HashMap<String,String> setExpressionVars;
		
		HashMap<String,String> memory = new HashMap<String,String>(); //En memory se guardan las variables y expressiones leidas
		HashMap<String,String> types = new HashMap<String,String>();	//En types se guarda informacion sobre los tipos definidos
		HashMap<String,String> zVars = new HashMap<String,String>();  //En zVars se almacenan las variables Z, a las cuales luego (antes de generar
		                                //el caso de prueba) se les dara un valor.
		
		String out = new String();
		String functionsOut = new String();
		
		public String getSalida() {
			return out.concat(functionsOut);
		}
		
		public HashMap<String,String> getMemory() {
			return memory;
		}
		
		public HashMap<String,String> getTypes() {
			return types;
		}
		
		public HashMap<String,String> getZVars() {
			return zVars;
		}

		public void print(String c) {
			if (modoSetExpression == 0 && tipoSchema == 0) 
				//System.out.println(c + " &");
				out = out.concat(c + " &");
			else if (modoSetExpression == 1)
				setExpressionDecl = setExpressionDecl.concat(" & " + c);
			else if (modoSetExpression == 2)
				setExpressionPred = setExpressionPred.concat(" & " + c);
			else if (modoSetExpression == 3)
				setExpressionExpr = setExpressionExpr.concat(" & " + c);
		}
		
		//Este metodo se utiliza para imprimir informacion del tipo: is_pfun, is_rel, etc
		//ya que debe ir al final de todo
		public void printAtEnd(String c) {
			if (modoSetExpression == 0 && tipoSchema == 0) 
				functionsOut = functionsOut.concat(c + " &");
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
		
		private String typeInfo(String var, String type) {
			
			if (tipoSchema == 0 & type != null) {
				if (isBasic(type)) {
					type = type.split(":")[1];
					print(var + " in " + type);
					return type;
				}
			
				String nodeType = getType(type);
				if (nodeType.equals("\\seq"))
					printAtEnd("list(" + var + ")");
				else if (nodeType.equals("\\rel"))
					printAtEnd("is_rel(" + var + ")");
				else if (nodeType.equals("\\pfun"))
					printAtEnd("is_pfun(" + var + ")");
				else if (nodeType.equals("\\fun"))
					printAtEnd("is_fun(" + var + ")");
				else if (type.equals("\\nat") || type.equals("\\num"))
					print(var + " in " + memory.get(type));
				else { //double check
					type = types.get(type);
					if (type != null && isBasic(type)) {
						type = type.split(":")[1];
						print(var + " in " + type);
						return type;
					}
				}
			}
			return type;
		}
		
		private boolean isBasic(String type) {
			if (type.startsWith("BasicType") || type.startsWith("EnumerationType") || type.startsWith("SchemaType"))
				return true;
			return false;
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
		case 61: WS_action((RuleContext)_localctx, actionIndex); break;

		case 66: SKIP_action((RuleContext)_localctx, actionIndex); break;
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
		"\2\4E\u021b\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t"+
		"\b\4\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20"+
		"\t\20\4\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27"+
		"\t\27\4\30\t\30\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36"+
		"\t\36\4\37\t\37\4 \t \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4"+
		"(\t(\4)\t)\4*\t*\4+\t+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62"+
		"\t\62\4\63\t\63\4\64\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4"+
		":\t:\4;\t;\4<\t<\4=\t=\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3"+
		"\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\22\3\22"+
		"\3\22\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\26"+
		"\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30"+
		"\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32"+
		"\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\35\3\35"+
		"\3\35\3\35\3\35\3\35\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3 \3 \3!\3!\3"+
		"!\3\"\3\"\3#\3#\3$\3$\3$\3$\3$\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3&\3&\3&"+
		"\3&\3&\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3(\3(\3(\3)\3)\3)\3)\3)\3*\3*\3*\3"+
		"*\3*\3*\3*\3*\3+\3+\3+\3+\3+\3+\3+\3+\3,\3,\3,\3,\3,\3,\3,\3-\3-\3.\3"+
		".\3.\3.\3.\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3\60\3\60\3\60\3\60\3\60\3"+
		"\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\62\3\62\3\63\3\63\3\64\3"+
		"\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\65\3\65\3\65\3"+
		"\65\3\65\3\66\3\66\3\66\3\67\3\67\38\38\38\38\38\38\38\38\39\39\39\39"+
		"\39\69\u01aa\n9\r9\169\u01ab\39\39\39\39\39\79\u01b3\n9\f9\169\u01b6\13"+
		"9\3:\6:\u01b9\n:\r:\16:\u01ba\3;\3;\3;\3;\3;\3;\3;\3;\3;\3;\3;\3;\3;\3"+
		";\5;\u01cb\n;\3<\3<\3<\3<\3<\3<\3<\3<\3<\3<\3<\3<\3<\3<\3<\3<\3<\3<\3"+
		"<\3<\3<\3<\3<\5<\u01e4\n<\3=\3=\3=\3=\3=\3=\3=\3>\5>\u01ee\n>\3>\3>\3"+
		"?\6?\u01f3\n?\r?\16?\u01f4\3?\3?\3@\3@\3@\3A\3A\3A\3B\3B\3B\3B\3B\3B\3"+
		"B\3B\3B\3B\3B\3B\3B\3B\3B\5B\u020e\nB\3C\3C\3C\3C\3C\3C\3C\3C\3D\3D\3"+
		"D\3D\2E\3\3\1\5\4\1\7\5\1\t\6\1\13\7\1\r\b\1\17\t\1\21\n\1\23\13\1\25"+
		"\f\1\27\r\1\31\16\1\33\17\1\35\20\1\37\21\1!\22\1#\23\1%\24\1\'\25\1)"+
		"\26\1+\27\1-\30\1/\31\1\61\32\1\63\33\1\65\34\1\67\35\19\36\1;\37\1= "+
		"\1?!\1A\"\1C#\1E$\1G%\1I&\1K\'\1M(\1O)\1Q*\1S+\1U,\1W-\1Y.\1[/\1]\60\1"+
		"_\61\1a\62\1c\63\1e\64\1g\65\1i\66\1k\67\1m8\1o9\1q:\1s;\1u<\1w=\1y>\1"+
		"{?\1}@\2\177A\1\u0081B\1\u0083C\1\u0085D\1\u0087E\3\3\2\7\4C\\c|\4C\\"+
		"c|\4\62;AA\4--//\5\13\13\17\17\"\"\u022b\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3"+
		"\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2"+
		"\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35"+
		"\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)"+
		"\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2"+
		"\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2"+
		"A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3"+
		"\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2"+
		"\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2"+
		"g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3"+
		"\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\2\177\3"+
		"\2\2\2\2\u0081\3\2\2\2\2\u0083\3\2\2\2\2\u0085\3\2\2\2\2\u0087\3\2\2\2"+
		"\3\u0089\3\2\2\2\5\u0090\3\2\2\2\7\u0096\3\2\2\2\t\u0099\3\2\2\2\13\u009b"+
		"\3\2\2\2\r\u00a1\3\2\2\2\17\u00a3\3\2\2\2\21\u00a9\3\2\2\2\23\u00ae\3"+
		"\2\2\2\25\u00b8\3\2\2\2\27\u00be\3\2\2\2\31\u00c4\3\2\2\2\33\u00c6\3\2"+
		"\2\2\35\u00cd\3\2\2\2\37\u00d3\3\2\2\2!\u00d5\3\2\2\2#\u00d7\3\2\2\2%"+
		"\u00dc\3\2\2\2\'\u00de\3\2\2\2)\u00e3\3\2\2\2+\u00e8\3\2\2\2-\u00ed\3"+
		"\2\2\2/\u00f4\3\2\2\2\61\u00f9\3\2\2\2\63\u0101\3\2\2\2\65\u0105\3\2\2"+
		"\2\67\u010f\3\2\2\29\u0111\3\2\2\2;\u0117\3\2\2\2=\u0119\3\2\2\2?\u011e"+
		"\3\2\2\2A\u0120\3\2\2\2C\u0123\3\2\2\2E\u0125\3\2\2\2G\u0127\3\2\2\2I"+
		"\u012c\3\2\2\2K\u0136\3\2\2\2M\u013b\3\2\2\2O\u013f\3\2\2\2Q\u0146\3\2"+
		"\2\2S\u014b\3\2\2\2U\u0153\3\2\2\2W\u015b\3\2\2\2Y\u0162\3\2\2\2[\u0164"+
		"\3\2\2\2]\u0169\3\2\2\2_\u0174\3\2\2\2a\u0179\3\2\2\2c\u0182\3\2\2\2e"+
		"\u0184\3\2\2\2g\u0186\3\2\2\2i\u0192\3\2\2\2k\u0197\3\2\2\2m\u019a\3\2"+
		"\2\2o\u019c\3\2\2\2q\u01a9\3\2\2\2s\u01b8\3\2\2\2u\u01ca\3\2\2\2w\u01e3"+
		"\3\2\2\2y\u01e5\3\2\2\2{\u01ed\3\2\2\2}\u01f2\3\2\2\2\177\u01f8\3\2\2"+
		"\2\u0081\u01fb\3\2\2\2\u0083\u020d\3\2\2\2\u0085\u020f\3\2\2\2\u0087\u0217"+
		"\3\2\2\2\u0089\u008a\7u\2\2\u008a\u008b\7e\2\2\u008b\u008c\7j\2\2\u008c"+
		"\u008d\7g\2\2\u008d\u008e\7o\2\2\u008e\u008f\7c\2\2\u008f\4\3\2\2\2\u0090"+
		"\u0091\7^\2\2\u0091\u0092\7n\2\2\u0092\u0093\7p\2\2\u0093\u0094\7q\2\2"+
		"\u0094\u0095\7v\2\2\u0095\6\3\2\2\2\u0096\u0097\7^\2\2\u0097\u0098\7%"+
		"\2\2\u0098\b\3\2\2\2\u0099\u009a\7]\2\2\u009a\n\3\2\2\2\u009b\u009c\7"+
		"^\2\2\u009c\u009d\7r\2\2\u009d\u009e\7h\2\2\u009e\u009f\7w\2\2\u009f\u00a0"+
		"\7p\2\2\u00a0\f\3\2\2\2\u00a1\u00a2\7>\2\2\u00a2\16\3\2\2\2\u00a3\u00a4"+
		"\7h\2\2\u00a4\u00a5\7c\2\2\u00a5\u00a6\7n\2\2\u00a6\u00a7\7u\2\2\u00a7"+
		"\u00a8\7g\2\2\u00a8\20\3\2\2\2\u00a9\u00aa\7^\2\2\u00aa\u00ab\7f\2\2\u00ab"+
		"\u00ac\7q\2\2\u00ac\u00ad\7o\2\2\u00ad\22\3\2\2\2\u00ae\u00af\7^\2\2\u00af"+
		"\u00b0\7g\2\2\u00b0\u00b1\7o\2\2\u00b1\u00b2\7r\2\2\u00b2\u00b3\7v\2\2"+
		"\u00b3\u00b4\7{\2\2\u00b4\u00b5\7u\2\2\u00b5\u00b6\7g\2\2\u00b6\u00b7"+
		"\7v\2\2\u00b7\24\3\2\2\2\u00b8\u00b9\7^\2\2\u00b9\u00ba\7w\2\2\u00ba\u00bb"+
		"\7r\2\2\u00bb\u00bc\7v\2\2\u00bc\u00bd\7q\2\2\u00bd\26\3\2\2\2\u00be\u00bf"+
		"\7^\2\2\u00bf\u00c0\7h\2\2\u00c0\u00c1\7h\2\2\u00c1\u00c2\7w\2\2\u00c2"+
		"\u00c3\7p\2\2\u00c3\30\3\2\2\2\u00c4\u00c5\7\177\2\2\u00c5\32\3\2\2\2"+
		"\u00c6\u00c7\7^\2\2\u00c7\u00c8\7p\2\2\u00c8\u00c9\7q\2\2\u00c9\u00ca"+
		"\7v\2\2\u00ca\u00cb\7k\2\2\u00cb\u00cc\7p\2\2\u00cc\34\3\2\2\2\u00cd\u00ce"+
		"\7^\2\2\u00ce\u00cf\7n\2\2\u00cf\u00d0\7c\2\2\u00d0\u00d1\7p\2\2\u00d1"+
		"\u00d2\7f\2\2\u00d2\36\3\2\2\2\u00d3\u00d4\7+\2\2\u00d4 \3\2\2\2\u00d5"+
		"\u00d6\7B\2\2\u00d6\"\3\2\2\2\u00d7\u00d8\7^\2\2\u00d8\u00d9\7u\2\2\u00d9"+
		"\u00da\7g\2\2\u00da\u00db\7s\2\2\u00db$\3\2\2\2\u00dc\u00dd\7?\2\2\u00dd"+
		"&\3\2\2\2\u00de\u00df\7^\2\2\u00df\u00e0\7n\2\2\u00e0\u00e1\7g\2\2\u00e1"+
		"\u00e2\7s\2\2\u00e2(\3\2\2\2\u00e3\u00e4\7^\2\2\u00e4\u00e5\7p\2\2\u00e5"+
		"\u00e6\7g\2\2\u00e6\u00e7\7s\2\2\u00e7*\3\2\2\2\u00e8\u00e9\7^\2\2\u00e9"+
		"\u00ea\7p\2\2\u00ea\u00eb\7c\2\2\u00eb\u00ec\7v\2\2\u00ec,\3\2\2\2\u00ed"+
		"\u00ee\7^\2\2\u00ee\u00ef\7y\2\2\u00ef\u00f0\7j\2\2\u00f0\u00f1\7g\2\2"+
		"\u00f1\u00f2\7t\2\2\u00f2\u00f3\7g\2\2\u00f3.\3\2\2\2\u00f4\u00f5\7^\2"+
		"\2\u00f5\u00f6\7i\2\2\u00f6\u00f7\7g\2\2\u00f7\u00f8\7s\2\2\u00f8\60\3"+
		"\2\2\2\u00f9\u00fa\7^\2\2\u00fa\u00fb\7d\2\2\u00fb\u00fc\7k\2\2\u00fc"+
		"\u00fd\7i\2\2\u00fd\u00fe\7e\2\2\u00fe\u00ff\7w\2\2\u00ff\u0100\7r\2\2"+
		"\u0100\62\3\2\2\2\u0101\u0102\7<\2\2\u0102\u0103\7<\2\2\u0103\u0104\7"+
		"?\2\2\u0104\64\3\2\2\2\u0105\u0106\7^\2\2\u0106\u0107\7u\2\2\u0107\u0108"+
		"\7w\2\2\u0108\u0109\7d\2\2\u0109\u010a\7u\2\2\u010a\u010b\7g\2\2\u010b"+
		"\u010c\7v\2\2\u010c\u010d\7g\2\2\u010d\u010e\7s\2\2\u010e\66\3\2\2\2\u010f"+
		"\u0110\7~\2\2\u01108\3\2\2\2\u0111\u0112\7^\2\2\u0112\u0113\7g\2\2\u0113"+
		"\u0114\7p\2\2\u0114\u0115\7f\2\2\u0115\u0116\7}\2\2\u0116:\3\2\2\2\u0117"+
		"\u0118\7_\2\2\u0118<\3\2\2\2\u0119\u011a\7^\2\2\u011a\u011b\7t\2\2\u011b"+
		"\u011c\7g\2\2\u011c\u011d\7n\2\2\u011d>\3\2\2\2\u011e\u011f\7.\2\2\u011f"+
		"@\3\2\2\2\u0120\u0121\7\177\2\2\u0121\u0122\7}\2\2\u0122B\3\2\2\2\u0123"+
		"\u0124\7*\2\2\u0124D\3\2\2\2\u0125\u0126\7<\2\2\u0126F\3\2\2\2\u0127\u0128"+
		"\7^\2\2\u0128\u0129\7n\2\2\u0129\u012a\7q\2\2\u012a\u012b\7t\2\2\u012b"+
		"H\3\2\2\2\u012c\u012d\7^\2\2\u012d\u012e\7g\2\2\u012e\u012f\7p\2\2\u012f"+
		"\u0130\7f\2\2\u0130\u0131\7}\2\2\u0131\u0132\7|\2\2\u0132\u0133\7g\2\2"+
		"\u0133\u0134\7f\2\2\u0134\u0135\7\177\2\2\u0135J\3\2\2\2\u0136\u0137\7"+
		"^\2\2\u0137\u0138\7t\2\2\u0138\u0139\7c\2\2\u0139\u013a\7p\2\2\u013aL"+
		"\3\2\2\2\u013b\u013c\7^\2\2\u013c\u013d\7k\2\2\u013d\u013e\7p\2\2\u013e"+
		"N\3\2\2\2\u013f\u0140\7^\2\2\u0140\u0141\7e\2\2\u0141\u0142\7t\2\2\u0142"+
		"\u0143\7q\2\2\u0143\u0144\7u\2\2\u0144\u0145\7u\2\2\u0145P\3\2\2\2\u0146"+
		"\u0147\7v\2\2\u0147\u0148\7t\2\2\u0148\u0149\7w\2\2\u0149\u014a\7g\2\2"+
		"\u014aR\3\2\2\2\u014b\u014c\7^\2\2\u014c\u014d\7d\2\2\u014d\u014e\7g\2"+
		"\2\u014e\u014f\7i\2\2\u014f\u0150\7k\2\2\u0150\u0151\7p\2\2\u0151\u0152"+
		"\7}\2\2\u0152T\3\2\2\2\u0153\u0154\7^\2\2\u0154\u0155\7u\2\2\u0155\u0156"+
		"\7w\2\2\u0156\u0157\7d\2\2\u0157\u0158\7u\2\2\u0158\u0159\7g\2\2\u0159"+
		"\u015a\7v\2\2\u015aV\3\2\2\2\u015b\u015c\7^\2\2\u015c\u015d\7r\2\2\u015d"+
		"\u015e\7q\2\2\u015e\u015f\7y\2\2\u015f\u0160\7g\2\2\u0160\u0161\7t\2\2"+
		"\u0161X\3\2\2\2\u0162\u0163\7\60\2\2\u0163Z\3\2\2\2\u0164\u0165\7^\2\2"+
		"\u0165\u0166\7k\2\2\u0166\u0167\7h\2\2\u0167\u0168\7h\2\2\u0168\\\3\2"+
		"\2\2\u0169\u016a\7u\2\2\u016a\u016b\7e\2\2\u016b\u016c\7j\2\2\u016c\u016d"+
		"\7g\2\2\u016d\u016e\7o\2\2\u016e\u016f\7c\2\2\u016f\u0170\7V\2\2\u0170"+
		"\u0171\7{\2\2\u0171\u0172\7r\2\2\u0172\u0173\7g\2\2\u0173^\3\2\2\2\u0174"+
		"\u0175\7^\2\2\u0175\u0176\7h\2\2\u0176\u0177\7w\2\2\u0177\u0178\7p\2\2"+
		"\u0178`\3\2\2\2\u0179\u017a\7^\2\2\u017a\u017b\7k\2\2\u017b\u017c\7o\2"+
		"\2\u017c\u017d\7r\2\2\u017d\u017e\7n\2\2\u017e\u017f\7k\2\2\u017f\u0180"+
		"\7g\2\2\u0180\u0181\7u\2\2\u0181b\3\2\2\2\u0182\u0183\7=\2\2\u0183d\3"+
		"\2\2\2\u0184\u0185\7@\2\2\u0185f\3\2\2\2\u0186\u0187\7^\2\2\u0187\u0188"+
		"\7d\2\2\u0188\u0189\7g\2\2\u0189\u018a\7i\2\2\u018a\u018b\7k\2\2\u018b"+
		"\u018c\7p\2\2\u018c\u018d\7}\2\2\u018d\u018e\7|\2\2\u018e\u018f\7g\2\2"+
		"\u018f\u0190\7f\2\2\u0190\u0191\7\177\2\2\u0191h\3\2\2\2\u0192\u0193\7"+
		"^\2\2\u0193\u0194\7p\2\2\u0194\u0195\7w\2\2\u0195\u0196\7o\2\2\u0196j"+
		"\3\2\2\2\u0197\u0198\7?\2\2\u0198\u0199\7?\2\2\u0199l\3\2\2\2\u019a\u019b"+
		"\7\u0080\2\2\u019bn\3\2\2\2\u019c\u019d\7^\2\2\u019d\u019e\7o\2\2\u019e"+
		"\u019f\7c\2\2\u019f\u01a0\7r\2\2\u01a0\u01a1\7u\2\2\u01a1\u01a2\7v\2\2"+
		"\u01a2\u01a3\7q\2\2\u01a3p\3\2\2\2\u01a4\u01aa\t\2\2\2\u01a5\u01a6\7^"+
		"\2\2\u01a6\u01a7\7a\2\2\u01a7\u01aa\7\"\2\2\u01a8\u01aa\7A\2\2\u01a9\u01a4"+
		"\3\2\2\2\u01a9\u01a5\3\2\2\2\u01a9\u01a8\3\2\2\2\u01aa\u01ab\3\2\2\2\u01ab"+
		"\u01a9\3\2\2\2\u01ab\u01ac\3\2\2\2\u01ac\u01b4\3\2\2\2\u01ad\u01b3\t\3"+
		"\2\2\u01ae\u01af\7^\2\2\u01af\u01b0\7a\2\2\u01b0\u01b3\7\"\2\2\u01b1\u01b3"+
		"\t\4\2\2\u01b2\u01ad\3\2\2\2\u01b2\u01ae\3\2\2\2\u01b2\u01b1\3\2\2\2\u01b3"+
		"\u01b6\3\2\2\2\u01b4\u01b2\3\2\2\2\u01b4\u01b5\3\2\2\2\u01b5r\3\2\2\2"+
		"\u01b6\u01b4\3\2\2\2\u01b7\u01b9\4\62;\2\u01b8\u01b7\3\2\2\2\u01b9\u01ba"+
		"\3\2\2\2\u01ba\u01b8\3\2\2\2\u01ba\u01bb\3\2\2\2\u01bbt\3\2\2\2\u01bc"+
		"\u01cb\t\5\2\2\u01bd\u01be\7^\2\2\u01be\u01bf\7e\2\2\u01bf\u01c0\7w\2"+
		"\2\u01c0\u01cb\7r\2\2\u01c1\u01c2\7^\2\2\u01c2\u01c3\7u\2\2\u01c3\u01c4"+
		"\7g\2\2\u01c4\u01c5\7v\2\2\u01c5\u01c6\7o\2\2\u01c6\u01c7\7k\2\2\u01c7"+
		"\u01c8\7p\2\2\u01c8\u01c9\7w\2\2\u01c9\u01cb\7u\2\2\u01ca\u01bc\3\2\2"+
		"\2\u01ca\u01bd\3\2\2\2\u01ca\u01c1\3\2\2\2\u01cbv\3\2\2\2\u01cc\u01e4"+
		"\7,\2\2\u01cd\u01ce\7^\2\2\u01ce\u01cf\7f\2\2\u01cf\u01d0\7k\2\2\u01d0"+
		"\u01e4\7x\2\2\u01d1\u01d2\7^\2\2\u01d2\u01d3\7o\2\2\u01d3\u01d4\7q\2\2"+
		"\u01d4\u01e4\7f\2\2\u01d5\u01d6\7^\2\2\u01d6\u01d7\7e\2\2\u01d7\u01d8"+
		"\7c\2\2\u01d8\u01e4\7r\2\2\u01d9\u01da\7^\2\2\u01da\u01db\7e\2\2\u01db"+
		"\u01dc\7q\2\2\u01dc\u01dd\7o\2\2\u01dd\u01e4\7r\2\2\u01de\u01df\7^\2\2"+
		"\u01df\u01e0\7e\2\2\u01e0\u01e1\7k\2\2\u01e1\u01e2\7t\2\2\u01e2\u01e4"+
		"\7e\2\2\u01e3\u01cc\3\2\2\2\u01e3\u01cd\3\2\2\2\u01e3\u01d1\3\2\2\2\u01e3"+
		"\u01d5\3\2\2\2\u01e3\u01d9\3\2\2\2\u01e3\u01de\3\2\2\2\u01e4x\3\2\2\2"+
		"\u01e5\u01e6\7^\2\2\u01e6\u01e7\7q\2\2\u01e7\u01e8\7r\2\2\u01e8\u01e9"+
		"\7n\2\2\u01e9\u01ea\7w\2\2\u01ea\u01eb\7u\2\2\u01ebz\3\2\2\2\u01ec\u01ee"+
		"\7\17\2\2\u01ed\u01ec\3\2\2\2\u01ed\u01ee\3\2\2\2\u01ee\u01ef\3\2\2\2"+
		"\u01ef\u01f0\7\f\2\2\u01f0|\3\2\2\2\u01f1\u01f3\t\6\2\2\u01f2\u01f1\3"+
		"\2\2\2\u01f3\u01f4\3\2\2\2\u01f4\u01f2\3\2\2\2\u01f4\u01f5\3\2\2\2\u01f5"+
		"\u01f6\3\2\2\2\u01f6\u01f7\b?\2\2\u01f7~\3\2\2\2\u01f8\u01f9\7^\2\2\u01f9"+
		"\u01fa\7}\2\2\u01fa\u0080\3\2\2\2\u01fb\u01fc\7^\2\2\u01fc\u01fd\7\177"+
		"\2\2\u01fd\u0082\3\2\2\2\u01fe\u01ff\7^\2\2\u01ff\u0200\7n\2\2\u0200\u0201"+
		"\7c\2\2\u0201\u0202\7p\2\2\u0202\u0203\7i\2\2\u0203\u0204\7n\2\2\u0204"+
		"\u020e\7g\2\2\u0205\u0206\7\u0080\2\2\u0206\u0207\7^\2\2\u0207\u0208\7"+
		"n\2\2\u0208\u0209\7c\2\2\u0209\u020a\7p\2\2\u020a\u020b\7i\2\2\u020b\u020c"+
		"\7n\2\2\u020c\u020e\7g\2\2\u020d\u01fe\3\2\2\2\u020d\u0205\3\2\2\2\u020e"+
		"\u0084\3\2\2\2\u020f\u0210\7^\2\2\u0210\u0211\7t\2\2\u0211\u0212\7c\2"+
		"\2\u0212\u0213\7p\2\2\u0213\u0214\7i\2\2\u0214\u0215\7n\2\2\u0215\u0216"+
		"\7g\2\2\u0216\u0086\3\2\2\2\u0217\u0218\7^\2\2\u0218\u0219\7^\2\2\u0219"+
		"\u021a\bD\3\2\u021a\u0088\3\2\2\2\r\2\u01a9\u01ab\u01b2\u01b4\u01ba\u01ca"+
		"\u01e3\u01ed\u01f4\u020d";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}