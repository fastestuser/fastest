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
		IN_FUN_P5=60, IN_FUN_P6=61, NL=62, WS=63, SETSTART=64, SETEND=65, LISTSTART=66, 
		LISTEND=67, IMGSTART=68, IMGEND=69, SKIP=70;
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
		"'\\mapsto'", "NAME", "NUM", "IN_FUN_P3", "IN_FUN_P4", "IN_FUN_P5", "IN_FUN_P6", 
		"NL", "WS", "'\\{'", "'\\}'", "LISTSTART", "'\\rangle'", "'\\limg'", "IMGEND", 
		"SKIP"
	};
	public static final String[] ruleNames = {
		"T__54", "T__53", "T__52", "T__51", "T__50", "T__49", "T__48", "T__47", 
		"T__46", "T__45", "T__44", "T__43", "T__42", "T__41", "T__40", "T__39", 
		"T__38", "T__37", "T__36", "T__35", "T__34", "T__33", "T__32", "T__31", 
		"T__30", "T__29", "T__28", "T__27", "T__26", "T__25", "T__24", "T__23", 
		"T__22", "T__21", "T__20", "T__19", "T__18", "T__17", "T__16", "T__15", 
		"T__14", "T__13", "T__12", "T__11", "T__10", "T__9", "T__8", "T__7", "T__6", 
		"T__5", "T__4", "T__3", "T__2", "T__1", "T__0", "NAME", "NUM", "IN_FUN_P3", 
		"IN_FUN_P4", "IN_FUN_P5", "IN_FUN_P6", "NL", "WS", "SETSTART", "SETEND", 
		"LISTSTART", "LISTEND", "IMGSTART", "IMGEND", "SKIP"
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
		case 62: WS_action((RuleContext)_localctx, actionIndex); break;

		case 69: SKIP_action((RuleContext)_localctx, actionIndex); break;
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
		"\2\4H\u024c\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t"+
		"\b\4\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20"+
		"\t\20\4\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27"+
		"\t\27\4\30\t\30\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36"+
		"\t\36\4\37\t\37\4 \t \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4"+
		"(\t(\4)\t)\4*\t*\4+\t+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62"+
		"\t\62\4\63\t\63\4\64\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4"+
		":\t:\4;\t;\4<\t<\4=\t=\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\t"+
		"E\4F\tF\4G\tG\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\4"+
		"\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\21\3\21"+
		"\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\25\3\25"+
		"\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\37\3\37\3\37\3\37"+
		"\3\37\3 \3 \3!\3!\3!\3\"\3\"\3#\3#\3$\3$\3$\3$\3$\3%\3%\3%\3%\3%\3%\3"+
		"%\3%\3%\3%\3&\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3(\3(\3(\3)\3)\3"+
		")\3)\3)\3*\3*\3*\3*\3*\3*\3*\3*\3+\3+\3+\3+\3+\3+\3+\3+\3,\3,\3,\3,\3"+
		",\3,\3,\3-\3-\3.\3.\3.\3.\3.\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3\60\3\60"+
		"\3\60\3\60\3\60\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\62\3\62"+
		"\3\63\3\63\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64"+
		"\3\65\3\65\3\65\3\65\3\65\3\66\3\66\3\66\3\67\3\67\38\38\38\38\38\38\3"+
		"8\38\39\39\39\39\39\69\u01b0\n9\r9\169\u01b1\39\39\39\39\39\79\u01b9\n"+
		"9\f9\169\u01bc\139\3:\6:\u01bf\n:\r:\16:\u01c0\3;\3;\3;\3;\3;\3;\3;\3"+
		";\3;\3;\3;\3;\3;\3;\5;\u01d1\n;\3<\3<\3<\3<\3<\3<\3<\3<\3<\3<\3<\3<\3"+
		"<\3<\3<\3<\3<\3<\3<\3<\3<\3<\3<\5<\u01ea\n<\3=\3=\3=\3=\3=\3=\3=\3>\3"+
		">\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\5>\u0209"+
		"\n>\3?\5?\u020c\n?\3?\3?\3@\6@\u0211\n@\r@\16@\u0212\3@\3@\3A\3A\3A\3"+
		"B\3B\3B\3C\3C\3C\3C\3C\3C\3C\3C\3C\3C\3C\3C\3C\3C\3C\5C\u022c\nC\3D\3"+
		"D\3D\3D\3D\3D\3D\3D\3E\3E\3E\3E\3E\3E\3F\3F\3F\3F\3F\3F\3F\3F\3F\3F\3"+
		"F\5F\u0247\nF\3G\3G\3G\3G\2H\3\3\1\5\4\1\7\5\1\t\6\1\13\7\1\r\b\1\17\t"+
		"\1\21\n\1\23\13\1\25\f\1\27\r\1\31\16\1\33\17\1\35\20\1\37\21\1!\22\1"+
		"#\23\1%\24\1\'\25\1)\26\1+\27\1-\30\1/\31\1\61\32\1\63\33\1\65\34\1\67"+
		"\35\19\36\1;\37\1= \1?!\1A\"\1C#\1E$\1G%\1I&\1K\'\1M(\1O)\1Q*\1S+\1U,"+
		"\1W-\1Y.\1[/\1]\60\1_\61\1a\62\1c\63\1e\64\1g\65\1i\66\1k\67\1m8\1o9\1"+
		"q:\1s;\1u<\1w=\1y>\1{?\1}@\1\177A\2\u0081B\1\u0083C\1\u0085D\1\u0087E"+
		"\1\u0089F\1\u008bG\1\u008dH\3\3\2\7\4C\\c|\4C\\c|\4\62;AA\4--//\5\13\13"+
		"\17\17\"\"\u0260\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13"+
		"\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2"+
		"\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2"+
		"!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3"+
		"\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2"+
		"\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E"+
		"\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2"+
		"\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2"+
		"\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k"+
		"\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2"+
		"\2\2\2y\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\2\177\3\2\2\2\2\u0081\3\2\2\2\2"+
		"\u0083\3\2\2\2\2\u0085\3\2\2\2\2\u0087\3\2\2\2\2\u0089\3\2\2\2\2\u008b"+
		"\3\2\2\2\2\u008d\3\2\2\2\3\u008f\3\2\2\2\5\u0096\3\2\2\2\7\u009c\3\2\2"+
		"\2\t\u009f\3\2\2\2\13\u00a1\3\2\2\2\r\u00a7\3\2\2\2\17\u00a9\3\2\2\2\21"+
		"\u00af\3\2\2\2\23\u00b4\3\2\2\2\25\u00be\3\2\2\2\27\u00c4\3\2\2\2\31\u00ca"+
		"\3\2\2\2\33\u00cc\3\2\2\2\35\u00d3\3\2\2\2\37\u00d9\3\2\2\2!\u00db\3\2"+
		"\2\2#\u00dd\3\2\2\2%\u00e2\3\2\2\2\'\u00e4\3\2\2\2)\u00e9\3\2\2\2+\u00ee"+
		"\3\2\2\2-\u00f3\3\2\2\2/\u00fa\3\2\2\2\61\u00ff\3\2\2\2\63\u0107\3\2\2"+
		"\2\65\u010b\3\2\2\2\67\u0115\3\2\2\29\u0117\3\2\2\2;\u011d\3\2\2\2=\u011f"+
		"\3\2\2\2?\u0124\3\2\2\2A\u0126\3\2\2\2C\u0129\3\2\2\2E\u012b\3\2\2\2G"+
		"\u012d\3\2\2\2I\u0132\3\2\2\2K\u013c\3\2\2\2M\u0141\3\2\2\2O\u0145\3\2"+
		"\2\2Q\u014c\3\2\2\2S\u0151\3\2\2\2U\u0159\3\2\2\2W\u0161\3\2\2\2Y\u0168"+
		"\3\2\2\2[\u016a\3\2\2\2]\u016f\3\2\2\2_\u017a\3\2\2\2a\u017f\3\2\2\2c"+
		"\u0188\3\2\2\2e\u018a\3\2\2\2g\u018c\3\2\2\2i\u0198\3\2\2\2k\u019d\3\2"+
		"\2\2m\u01a0\3\2\2\2o\u01a2\3\2\2\2q\u01af\3\2\2\2s\u01be\3\2\2\2u\u01d0"+
		"\3\2\2\2w\u01e9\3\2\2\2y\u01eb\3\2\2\2{\u0208\3\2\2\2}\u020b\3\2\2\2\177"+
		"\u0210\3\2\2\2\u0081\u0216\3\2\2\2\u0083\u0219\3\2\2\2\u0085\u022b\3\2"+
		"\2\2\u0087\u022d\3\2\2\2\u0089\u0235\3\2\2\2\u008b\u0246\3\2\2\2\u008d"+
		"\u0248\3\2\2\2\u008f\u0090\7u\2\2\u0090\u0091\7e\2\2\u0091\u0092\7j\2"+
		"\2\u0092\u0093\7g\2\2\u0093\u0094\7o\2\2\u0094\u0095\7c\2\2\u0095\4\3"+
		"\2\2\2\u0096\u0097\7^\2\2\u0097\u0098\7n\2\2\u0098\u0099\7p\2\2\u0099"+
		"\u009a\7q\2\2\u009a\u009b\7v\2\2\u009b\6\3\2\2\2\u009c\u009d\7^\2\2\u009d"+
		"\u009e\7%\2\2\u009e\b\3\2\2\2\u009f\u00a0\7]\2\2\u00a0\n\3\2\2\2\u00a1"+
		"\u00a2\7^\2\2\u00a2\u00a3\7r\2\2\u00a3\u00a4\7h\2\2\u00a4\u00a5\7w\2\2"+
		"\u00a5\u00a6\7p\2\2\u00a6\f\3\2\2\2\u00a7\u00a8\7>\2\2\u00a8\16\3\2\2"+
		"\2\u00a9\u00aa\7h\2\2\u00aa\u00ab\7c\2\2\u00ab\u00ac\7n\2\2\u00ac\u00ad"+
		"\7u\2\2\u00ad\u00ae\7g\2\2\u00ae\20\3\2\2\2\u00af\u00b0\7^\2\2\u00b0\u00b1"+
		"\7f\2\2\u00b1\u00b2\7q\2\2\u00b2\u00b3\7o\2\2\u00b3\22\3\2\2\2\u00b4\u00b5"+
		"\7^\2\2\u00b5\u00b6\7g\2\2\u00b6\u00b7\7o\2\2\u00b7\u00b8\7r\2\2\u00b8"+
		"\u00b9\7v\2\2\u00b9\u00ba\7{\2\2\u00ba\u00bb\7u\2\2\u00bb\u00bc\7g\2\2"+
		"\u00bc\u00bd\7v\2\2\u00bd\24\3\2\2\2\u00be\u00bf\7^\2\2\u00bf\u00c0\7"+
		"w\2\2\u00c0\u00c1\7r\2\2\u00c1\u00c2\7v\2\2\u00c2\u00c3\7q\2\2\u00c3\26"+
		"\3\2\2\2\u00c4\u00c5\7^\2\2\u00c5\u00c6\7h\2\2\u00c6\u00c7\7h\2\2\u00c7"+
		"\u00c8\7w\2\2\u00c8\u00c9\7p\2\2\u00c9\30\3\2\2\2\u00ca\u00cb\7\177\2"+
		"\2\u00cb\32\3\2\2\2\u00cc\u00cd\7^\2\2\u00cd\u00ce\7p\2\2\u00ce\u00cf"+
		"\7q\2\2\u00cf\u00d0\7v\2\2\u00d0\u00d1\7k\2\2\u00d1\u00d2\7p\2\2\u00d2"+
		"\34\3\2\2\2\u00d3\u00d4\7^\2\2\u00d4\u00d5\7n\2\2\u00d5\u00d6\7c\2\2\u00d6"+
		"\u00d7\7p\2\2\u00d7\u00d8\7f\2\2\u00d8\36\3\2\2\2\u00d9\u00da\7+\2\2\u00da"+
		" \3\2\2\2\u00db\u00dc\7B\2\2\u00dc\"\3\2\2\2\u00dd\u00de\7^\2\2\u00de"+
		"\u00df\7u\2\2\u00df\u00e0\7g\2\2\u00e0\u00e1\7s\2\2\u00e1$\3\2\2\2\u00e2"+
		"\u00e3\7?\2\2\u00e3&\3\2\2\2\u00e4\u00e5\7^\2\2\u00e5\u00e6\7n\2\2\u00e6"+
		"\u00e7\7g\2\2\u00e7\u00e8\7s\2\2\u00e8(\3\2\2\2\u00e9\u00ea\7^\2\2\u00ea"+
		"\u00eb\7p\2\2\u00eb\u00ec\7g\2\2\u00ec\u00ed\7s\2\2\u00ed*\3\2\2\2\u00ee"+
		"\u00ef\7^\2\2\u00ef\u00f0\7p\2\2\u00f0\u00f1\7c\2\2\u00f1\u00f2\7v\2\2"+
		"\u00f2,\3\2\2\2\u00f3\u00f4\7^\2\2\u00f4\u00f5\7y\2\2\u00f5\u00f6\7j\2"+
		"\2\u00f6\u00f7\7g\2\2\u00f7\u00f8\7t\2\2\u00f8\u00f9\7g\2\2\u00f9.\3\2"+
		"\2\2\u00fa\u00fb\7^\2\2\u00fb\u00fc\7i\2\2\u00fc\u00fd\7g\2\2\u00fd\u00fe"+
		"\7s\2\2\u00fe\60\3\2\2\2\u00ff\u0100\7^\2\2\u0100\u0101\7d\2\2\u0101\u0102"+
		"\7k\2\2\u0102\u0103\7i\2\2\u0103\u0104\7e\2\2\u0104\u0105\7w\2\2\u0105"+
		"\u0106\7r\2\2\u0106\62\3\2\2\2\u0107\u0108\7<\2\2\u0108\u0109\7<\2\2\u0109"+
		"\u010a\7?\2\2\u010a\64\3\2\2\2\u010b\u010c\7^\2\2\u010c\u010d\7u\2\2\u010d"+
		"\u010e\7w\2\2\u010e\u010f\7d\2\2\u010f\u0110\7u\2\2\u0110\u0111\7g\2\2"+
		"\u0111\u0112\7v\2\2\u0112\u0113\7g\2\2\u0113\u0114\7s\2\2\u0114\66\3\2"+
		"\2\2\u0115\u0116\7~\2\2\u01168\3\2\2\2\u0117\u0118\7^\2\2\u0118\u0119"+
		"\7g\2\2\u0119\u011a\7p\2\2\u011a\u011b\7f\2\2\u011b\u011c\7}\2\2\u011c"+
		":\3\2\2\2\u011d\u011e\7_\2\2\u011e<\3\2\2\2\u011f\u0120\7^\2\2\u0120\u0121"+
		"\7t\2\2\u0121\u0122\7g\2\2\u0122\u0123\7n\2\2\u0123>\3\2\2\2\u0124\u0125"+
		"\7.\2\2\u0125@\3\2\2\2\u0126\u0127\7\177\2\2\u0127\u0128\7}\2\2\u0128"+
		"B\3\2\2\2\u0129\u012a\7*\2\2\u012aD\3\2\2\2\u012b\u012c\7<\2\2\u012cF"+
		"\3\2\2\2\u012d\u012e\7^\2\2\u012e\u012f\7n\2\2\u012f\u0130\7q\2\2\u0130"+
		"\u0131\7t\2\2\u0131H\3\2\2\2\u0132\u0133\7^\2\2\u0133\u0134\7g\2\2\u0134"+
		"\u0135\7p\2\2\u0135\u0136\7f\2\2\u0136\u0137\7}\2\2\u0137\u0138\7|\2\2"+
		"\u0138\u0139\7g\2\2\u0139\u013a\7f\2\2\u013a\u013b\7\177\2\2\u013bJ\3"+
		"\2\2\2\u013c\u013d\7^\2\2\u013d\u013e\7t\2\2\u013e\u013f\7c\2\2\u013f"+
		"\u0140\7p\2\2\u0140L\3\2\2\2\u0141\u0142\7^\2\2\u0142\u0143\7k\2\2\u0143"+
		"\u0144\7p\2\2\u0144N\3\2\2\2\u0145\u0146\7^\2\2\u0146\u0147\7e\2\2\u0147"+
		"\u0148\7t\2\2\u0148\u0149\7q\2\2\u0149\u014a\7u\2\2\u014a\u014b\7u\2\2"+
		"\u014bP\3\2\2\2\u014c\u014d\7v\2\2\u014d\u014e\7t\2\2\u014e\u014f\7w\2"+
		"\2\u014f\u0150\7g\2\2\u0150R\3\2\2\2\u0151\u0152\7^\2\2\u0152\u0153\7"+
		"d\2\2\u0153\u0154\7g\2\2\u0154\u0155\7i\2\2\u0155\u0156\7k\2\2\u0156\u0157"+
		"\7p\2\2\u0157\u0158\7}\2\2\u0158T\3\2\2\2\u0159\u015a\7^\2\2\u015a\u015b"+
		"\7u\2\2\u015b\u015c\7w\2\2\u015c\u015d\7d\2\2\u015d\u015e\7u\2\2\u015e"+
		"\u015f\7g\2\2\u015f\u0160\7v\2\2\u0160V\3\2\2\2\u0161\u0162\7^\2\2\u0162"+
		"\u0163\7r\2\2\u0163\u0164\7q\2\2\u0164\u0165\7y\2\2\u0165\u0166\7g\2\2"+
		"\u0166\u0167\7t\2\2\u0167X\3\2\2\2\u0168\u0169\7\60\2\2\u0169Z\3\2\2\2"+
		"\u016a\u016b\7^\2\2\u016b\u016c\7k\2\2\u016c\u016d\7h\2\2\u016d\u016e"+
		"\7h\2\2\u016e\\\3\2\2\2\u016f\u0170\7u\2\2\u0170\u0171\7e\2\2\u0171\u0172"+
		"\7j\2\2\u0172\u0173\7g\2\2\u0173\u0174\7o\2\2\u0174\u0175\7c\2\2\u0175"+
		"\u0176\7V\2\2\u0176\u0177\7{\2\2\u0177\u0178\7r\2\2\u0178\u0179\7g\2\2"+
		"\u0179^\3\2\2\2\u017a\u017b\7^\2\2\u017b\u017c\7h\2\2\u017c\u017d\7w\2"+
		"\2\u017d\u017e\7p\2\2\u017e`\3\2\2\2\u017f\u0180\7^\2\2\u0180\u0181\7"+
		"k\2\2\u0181\u0182\7o\2\2\u0182\u0183\7r\2\2\u0183\u0184\7n\2\2\u0184\u0185"+
		"\7k\2\2\u0185\u0186\7g\2\2\u0186\u0187\7u\2\2\u0187b\3\2\2\2\u0188\u0189"+
		"\7=\2\2\u0189d\3\2\2\2\u018a\u018b\7@\2\2\u018bf\3\2\2\2\u018c\u018d\7"+
		"^\2\2\u018d\u018e\7d\2\2\u018e\u018f\7g\2\2\u018f\u0190\7i\2\2\u0190\u0191"+
		"\7k\2\2\u0191\u0192\7p\2\2\u0192\u0193\7}\2\2\u0193\u0194\7|\2\2\u0194"+
		"\u0195\7g\2\2\u0195\u0196\7f\2\2\u0196\u0197\7\177\2\2\u0197h\3\2\2\2"+
		"\u0198\u0199\7^\2\2\u0199\u019a\7p\2\2\u019a\u019b\7w\2\2\u019b\u019c"+
		"\7o\2\2\u019cj\3\2\2\2\u019d\u019e\7?\2\2\u019e\u019f\7?\2\2\u019fl\3"+
		"\2\2\2\u01a0\u01a1\7\u0080\2\2\u01a1n\3\2\2\2\u01a2\u01a3\7^\2\2\u01a3"+
		"\u01a4\7o\2\2\u01a4\u01a5\7c\2\2\u01a5\u01a6\7r\2\2\u01a6\u01a7\7u\2\2"+
		"\u01a7\u01a8\7v\2\2\u01a8\u01a9\7q\2\2\u01a9p\3\2\2\2\u01aa\u01b0\t\2"+
		"\2\2\u01ab\u01ac\7^\2\2\u01ac\u01ad\7a\2\2\u01ad\u01b0\7\"\2\2\u01ae\u01b0"+
		"\7A\2\2\u01af\u01aa\3\2\2\2\u01af\u01ab\3\2\2\2\u01af\u01ae\3\2\2\2\u01b0"+
		"\u01b1\3\2\2\2\u01b1\u01af\3\2\2\2\u01b1\u01b2\3\2\2\2\u01b2\u01ba\3\2"+
		"\2\2\u01b3\u01b9\t\3\2\2\u01b4\u01b5\7^\2\2\u01b5\u01b6\7a\2\2\u01b6\u01b9"+
		"\7\"\2\2\u01b7\u01b9\t\4\2\2\u01b8\u01b3\3\2\2\2\u01b8\u01b4\3\2\2\2\u01b8"+
		"\u01b7\3\2\2\2\u01b9\u01bc\3\2\2\2\u01ba\u01b8\3\2\2\2\u01ba\u01bb\3\2"+
		"\2\2\u01bbr\3\2\2\2\u01bc\u01ba\3\2\2\2\u01bd\u01bf\4\62;\2\u01be\u01bd"+
		"\3\2\2\2\u01bf\u01c0\3\2\2\2\u01c0\u01be\3\2\2\2\u01c0\u01c1\3\2\2\2\u01c1"+
		"t\3\2\2\2\u01c2\u01d1\t\5\2\2\u01c3\u01c4\7^\2\2\u01c4\u01c5\7e\2\2\u01c5"+
		"\u01c6\7w\2\2\u01c6\u01d1\7r\2\2\u01c7\u01c8\7^\2\2\u01c8\u01c9\7u\2\2"+
		"\u01c9\u01ca\7g\2\2\u01ca\u01cb\7v\2\2\u01cb\u01cc\7o\2\2\u01cc\u01cd"+
		"\7k\2\2\u01cd\u01ce\7p\2\2\u01ce\u01cf\7w\2\2\u01cf\u01d1\7u\2\2\u01d0"+
		"\u01c2\3\2\2\2\u01d0\u01c3\3\2\2\2\u01d0\u01c7\3\2\2\2\u01d1v\3\2\2\2"+
		"\u01d2\u01ea\7,\2\2\u01d3\u01d4\7^\2\2\u01d4\u01d5\7f\2\2\u01d5\u01d6"+
		"\7k\2\2\u01d6\u01ea\7x\2\2\u01d7\u01d8\7^\2\2\u01d8\u01d9\7o\2\2\u01d9"+
		"\u01da\7q\2\2\u01da\u01ea\7f\2\2\u01db\u01dc\7^\2\2\u01dc\u01dd\7e\2\2"+
		"\u01dd\u01de\7c\2\2\u01de\u01ea\7r\2\2\u01df\u01e0\7^\2\2\u01e0\u01e1"+
		"\7e\2\2\u01e1\u01e2\7q\2\2\u01e2\u01e3\7o\2\2\u01e3\u01ea\7r\2\2\u01e4"+
		"\u01e5\7^\2\2\u01e5\u01e6\7e\2\2\u01e6\u01e7\7k\2\2\u01e7\u01e8\7t\2\2"+
		"\u01e8\u01ea\7e\2\2\u01e9\u01d2\3\2\2\2\u01e9\u01d3\3\2\2\2\u01e9\u01d7"+
		"\3\2\2\2\u01e9\u01db\3\2\2\2\u01e9\u01df\3\2\2\2\u01e9\u01e4\3\2\2\2\u01ea"+
		"x\3\2\2\2\u01eb\u01ec\7^\2\2\u01ec\u01ed\7q\2\2\u01ed\u01ee\7r\2\2\u01ee"+
		"\u01ef\7n\2\2\u01ef\u01f0\7w\2\2\u01f0\u01f1\7u\2\2\u01f1z\3\2\2\2\u01f2"+
		"\u01f3\7^\2\2\u01f3\u01f4\7f\2\2\u01f4\u01f5\7t\2\2\u01f5\u01f6\7g\2\2"+
		"\u01f6\u0209\7u\2\2\u01f7\u01f8\7^\2\2\u01f8\u01f9\7t\2\2\u01f9\u01fa"+
		"\7t\2\2\u01fa\u01fb\7g\2\2\u01fb\u0209\7u\2\2\u01fc\u01fd\7^\2\2\u01fd"+
		"\u01fe\7p\2\2\u01fe\u01ff\7f\2\2\u01ff\u0200\7t\2\2\u0200\u0201\7g\2\2"+
		"\u0201\u0209\7u\2\2\u0202\u0203\7^\2\2\u0203\u0204\7p\2\2\u0204\u0205"+
		"\7t\2\2\u0205\u0206\7t\2\2\u0206\u0207\7g\2\2\u0207\u0209\7u\2\2\u0208"+
		"\u01f2\3\2\2\2\u0208\u01f7\3\2\2\2\u0208\u01fc\3\2\2\2\u0208\u0202\3\2"+
		"\2\2\u0209|\3\2\2\2\u020a\u020c\7\17\2\2\u020b\u020a\3\2\2\2\u020b\u020c"+
		"\3\2\2\2\u020c\u020d\3\2\2\2\u020d\u020e\7\f\2\2\u020e~\3\2\2\2\u020f"+
		"\u0211\t\6\2\2\u0210\u020f\3\2\2\2\u0211\u0212\3\2\2\2\u0212\u0210\3\2"+
		"\2\2\u0212\u0213\3\2\2\2\u0213\u0214\3\2\2\2\u0214\u0215\b@\2\2\u0215"+
		"\u0080\3\2\2\2\u0216\u0217\7^\2\2\u0217\u0218\7}\2\2\u0218\u0082\3\2\2"+
		"\2\u0219\u021a\7^\2\2\u021a\u021b\7\177\2\2\u021b\u0084\3\2\2\2\u021c"+
		"\u021d\7^\2\2\u021d\u021e\7n\2\2\u021e\u021f\7c\2\2\u021f\u0220\7p\2\2"+
		"\u0220\u0221\7i\2\2\u0221\u0222\7n\2\2\u0222\u022c\7g\2\2\u0223\u0224"+
		"\7\u0080\2\2\u0224\u0225\7^\2\2\u0225\u0226\7n\2\2\u0226\u0227\7c\2\2"+
		"\u0227\u0228\7p\2\2\u0228\u0229\7i\2\2\u0229\u022a\7n\2\2\u022a\u022c"+
		"\7g\2\2\u022b\u021c\3\2\2\2\u022b\u0223\3\2\2\2\u022c\u0086\3\2\2\2\u022d"+
		"\u022e\7^\2\2\u022e\u022f\7t\2\2\u022f\u0230\7c\2\2\u0230\u0231\7p\2\2"+
		"\u0231\u0232\7i\2\2\u0232\u0233\7n\2\2\u0233\u0234\7g\2\2\u0234\u0088"+
		"\3\2\2\2\u0235\u0236\7^\2\2\u0236\u0237\7n\2\2\u0237\u0238\7k\2\2\u0238"+
		"\u0239\7o\2\2\u0239\u023a\7i\2\2\u023a\u008a\3\2\2\2\u023b\u023c\7^\2"+
		"\2\u023c\u023d\7t\2\2\u023d\u023e\7k\2\2\u023e\u023f\7o\2\2\u023f\u0247"+
		"\7i\2\2\u0240\u0241\7^\2\2\u0241\u0242\7t\2\2\u0242\u0243\7k\2\2\u0243"+
		"\u0244\7o\2\2\u0244\u0245\7i\2\2\u0245\u0247\7\u0080\2\2\u0246\u023b\3"+
		"\2\2\2\u0246\u0240\3\2\2\2\u0247\u008c\3\2\2\2\u0248\u0249\7^\2\2\u0249"+
		"\u024a\7^\2\2\u024a\u024b\bG\3\2\u024b\u008e\3\2\2\2\17\2\u01af\u01b1"+
		"\u01b8\u01ba\u01c0\u01d0\u01e9\u0208\u020b\u0212\u022b\u0246";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}