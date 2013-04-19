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
		T__53=1, T__52=2, T__51=3, T__50=4, T__49=5, T__48=6, T__47=7, T__46=8, 
		T__45=9, T__44=10, T__43=11, T__42=12, T__41=13, T__40=14, T__39=15, T__38=16, 
		T__37=17, T__36=18, T__35=19, T__34=20, T__33=21, T__32=22, T__31=23, 
		T__30=24, T__29=25, T__28=26, T__27=27, T__26=28, T__25=29, T__24=30, 
		T__23=31, T__22=32, T__21=33, T__20=34, T__19=35, T__18=36, T__17=37, 
		T__16=38, T__15=39, T__14=40, T__13=41, T__12=42, T__11=43, T__10=44, 
		T__9=45, T__8=46, T__7=47, T__6=48, T__5=49, T__4=50, T__3=51, T__2=52, 
		T__1=53, T__0=54, NAME=55, NUM=56, IN_FUN_P3=57, IN_FUN_P4=58, IN_FUN_P5=59, 
		IN_FUN_P6=60, POST_FUN=61, PRE_GEN=62, DECORATION=63, NL=64, WS=65, SETSTART=66, 
		SETEND=67, LISTSTART=68, LISTEND=69, IMGSTART=70, IMGEND=71, SKIP=72;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'schema'", "'\\lnot'", "'rev'", "'['", "'\\pfun'", "'<'", "'false'", 
		"'\\emptyset'", "'\\upto'", "'tail'", "'\\ffun'", "'}'", "'\\notin'", 
		"'\\land'", "')'", "'@'", "'head'", "'='", "'\\leq'", "'\\nat'", "'\\neq'", 
		"'\\where'", "'\\geq'", "'::='", "'\\subseteq'", "'|'", "'\\end{'", "']'", 
		"'last'", "'\\rel'", "','", "'}{'", "'('", "':'", "'\\lor'", "'\\end{zed}'", 
		"'\\in'", "'\\cross'", "'true'", "'\\begin{'", "'\\subset'", "'\\power'", 
		"'.'", "'\\iff'", "'schemaType'", "'\\fun'", "'\\implies'", "';'", "'front'", 
		"'>'", "'\\begin{zed}'", "'\\num'", "'=='", "'\\mapsto'", "NAME", "NUM", 
		"IN_FUN_P3", "IN_FUN_P4", "IN_FUN_P5", "IN_FUN_P6", "'\\inv'", "PRE_GEN", 
		"'~'", "NL", "WS", "'\\{'", "'\\}'", "'\\langle'", "'\\rangle'", "'\\limg'", 
		"'\\rimg'", "SKIP"
	};
	public static final String[] ruleNames = {
		"T__53", "T__52", "T__51", "T__50", "T__49", "T__48", "T__47", "T__46", 
		"T__45", "T__44", "T__43", "T__42", "T__41", "T__40", "T__39", "T__38", 
		"T__37", "T__36", "T__35", "T__34", "T__33", "T__32", "T__31", "T__30", 
		"T__29", "T__28", "T__27", "T__26", "T__25", "T__24", "T__23", "T__22", 
		"T__21", "T__20", "T__19", "T__18", "T__17", "T__16", "T__15", "T__14", 
		"T__13", "T__12", "T__11", "T__10", "T__9", "T__8", "T__7", "T__6", "T__5", 
		"T__4", "T__3", "T__2", "T__1", "T__0", "NAME", "NUM", "IN_FUN_P3", "IN_FUN_P4", 
		"IN_FUN_P5", "IN_FUN_P6", "POST_FUN", "PRE_GEN", "DECORATION", "NL", "WS", 
		"SETSTART", "SETEND", "LISTSTART", "LISTEND", "IMGSTART", "IMGEND", "SKIP"
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
		
		//Metodo para realizar la inversion de un tipo en Z
		//Constraits: Debe ser una funcion o un \power de \cross
		String invertType(String type) {
			ANTLRInputStream input = new ANTLRInputStream(type);
	        TypeManagerLexer lexer = new TypeManagerLexer(input);
	        CommonTokenStream tokens = new CommonTokenStream(lexer);
	        TypeManagerParser parser = new TypeManagerParser(tokens);
	        parser.typeManage();
	        DefaultMutableTreeNode root = parser.getRoot();
	        
			String invertedType = new String();
			String rootType = (String) root.getUserObject();
			if (rootType.equals("\\power")) {
				invertedType = invertedType.concat("\\power(");
				DefaultMutableTreeNode child = (DefaultMutableTreeNode) root.getChildAt(0);
				String childType = (String) child.getUserObject();
				
				if (childType.equals("()")) {
					child = (DefaultMutableTreeNode) child.getChildAt(0);
					childType = (String) child.getUserObject();
				}
				
				if (childType.equals("\\cross")) {
					invertedType = invertedType.concat((String) ((DefaultMutableTreeNode) child.getChildAt(1)).getUserObject());
					invertedType = invertedType.concat("\\cross");
					invertedType = invertedType.concat((String) ((DefaultMutableTreeNode) child.getChildAt(0)).getUserObject());
				}
				invertedType = invertedType.concat(")");
			
			} else { //Entonces empieza con pfun, rel etc
			
				invertedType = invertedType.concat((String) ((DefaultMutableTreeNode) root.getChildAt(1)).getUserObject());
				invertedType = invertedType.concat(rootType);
				invertedType = invertedType.concat((String) ((DefaultMutableTreeNode) root.getChildAt(0)).getUserObject());
			
			}
			
			return invertedType;
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
		case 64: WS_action((RuleContext)_localctx, actionIndex); break;

		case 71: SKIP_action((RuleContext)_localctx, actionIndex); break;
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
		"\2\4J\u0266\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t"+
		"\b\4\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20"+
		"\t\20\4\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27"+
		"\t\27\4\30\t\30\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36"+
		"\t\36\4\37\t\37\4 \t \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4"+
		"(\t(\4)\t)\4*\t*\4+\t+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62"+
		"\t\62\4\63\t\63\4\64\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4"+
		":\t:\4;\t;\4<\t<\4=\t=\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\t"+
		"E\4F\tF\4G\tG\4H\tH\4I\tI\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\20"+
		"\3\20\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\24\3\24\3\24\3\24"+
		"\3\24\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\34\3\34\3\34"+
		"\3\34\3\34\3\34\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37"+
		"\3\37\3 \3 \3!\3!\3!\3\"\3\"\3#\3#\3$\3$\3$\3$\3$\3%\3%\3%\3%\3%\3%\3"+
		"%\3%\3%\3%\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3(\3)\3"+
		")\3)\3)\3)\3)\3)\3)\3*\3*\3*\3*\3*\3*\3*\3*\3+\3+\3+\3+\3+\3+\3+\3,\3"+
		",\3-\3-\3-\3-\3-\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3/\3/\3/\3/\3/\3\60"+
		"\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\61\3\61\3\62\3\62\3\62\3\62"+
		"\3\62\3\62\3\63\3\63\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64"+
		"\3\64\3\64\3\65\3\65\3\65\3\65\3\65\3\66\3\66\3\66\3\67\3\67\3\67\3\67"+
		"\3\67\3\67\3\67\3\67\38\38\38\38\38\68\u01b1\n8\r8\168\u01b2\38\38\38"+
		"\38\38\78\u01ba\n8\f8\168\u01bd\138\39\69\u01c0\n9\r9\169\u01c1\3:\3:"+
		"\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\5:\u01d6\n:\3;\3;\3;"+
		"\3;\3;\3;\3;\3;\3;\3;\3;\3;\3;\3;\3;\3;\3;\3;\3;\3;\3;\3;\3;\5;\u01ef"+
		"\n;\3<\3<\3<\3<\3<\3<\3<\3=\3=\3=\3=\3=\3=\3=\3=\3=\3=\3=\3=\3=\3=\3="+
		"\3=\3=\3=\3=\3=\3=\3=\5=\u020e\n=\3>\3>\3>\3>\3>\3?\3?\3?\3?\3?\3?\3?"+
		"\3?\3?\3?\3?\3?\3?\3?\3?\3?\3?\3?\3?\3?\3?\3?\3?\3?\3?\3?\3?\3?\5?\u0231"+
		"\n?\3@\3@\3A\5A\u0236\nA\3A\3A\3B\6B\u023b\nB\rB\16B\u023c\3B\3B\3C\3"+
		"C\3C\3D\3D\3D\3E\3E\3E\3E\3E\3E\3E\3E\3F\3F\3F\3F\3F\3F\3F\3F\3G\3G\3"+
		"G\3G\3G\3G\3H\3H\3H\3H\3H\3H\3I\3I\3I\3I\2J\3\3\1\5\4\1\7\5\1\t\6\1\13"+
		"\7\1\r\b\1\17\t\1\21\n\1\23\13\1\25\f\1\27\r\1\31\16\1\33\17\1\35\20\1"+
		"\37\21\1!\22\1#\23\1%\24\1\'\25\1)\26\1+\27\1-\30\1/\31\1\61\32\1\63\33"+
		"\1\65\34\1\67\35\19\36\1;\37\1= \1?!\1A\"\1C#\1E$\1G%\1I&\1K\'\1M(\1O"+
		")\1Q*\1S+\1U,\1W-\1Y.\1[/\1]\60\1_\61\1a\62\1c\63\1e\64\1g\65\1i\66\1"+
		"k\67\1m8\1o9\1q:\1s;\1u<\1w=\1y>\1{?\1}@\1\177A\1\u0081B\1\u0083C\2\u0085"+
		"D\1\u0087E\1\u0089F\1\u008bG\1\u008dH\1\u008fI\1\u0091J\3\3\2\7\4C\\c"+
		"|\4C\\c|\4\62;AA\4--//\5\13\13\17\17\"\"\u027e\2\3\3\2\2\2\2\5\3\2\2\2"+
		"\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3"+
		"\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2"+
		"\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2"+
		"\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2"+
		"\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2"+
		"\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2"+
		"\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y"+
		"\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2"+
		"\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2"+
		"\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\2\177"+
		"\3\2\2\2\2\u0081\3\2\2\2\2\u0083\3\2\2\2\2\u0085\3\2\2\2\2\u0087\3\2\2"+
		"\2\2\u0089\3\2\2\2\2\u008b\3\2\2\2\2\u008d\3\2\2\2\2\u008f\3\2\2\2\2\u0091"+
		"\3\2\2\2\3\u0093\3\2\2\2\5\u009a\3\2\2\2\7\u00a0\3\2\2\2\t\u00a4\3\2\2"+
		"\2\13\u00a6\3\2\2\2\r\u00ac\3\2\2\2\17\u00ae\3\2\2\2\21\u00b4\3\2\2\2"+
		"\23\u00be\3\2\2\2\25\u00c4\3\2\2\2\27\u00c9\3\2\2\2\31\u00cf\3\2\2\2\33"+
		"\u00d1\3\2\2\2\35\u00d8\3\2\2\2\37\u00de\3\2\2\2!\u00e0\3\2\2\2#\u00e2"+
		"\3\2\2\2%\u00e7\3\2\2\2\'\u00e9\3\2\2\2)\u00ee\3\2\2\2+\u00f3\3\2\2\2"+
		"-\u00f8\3\2\2\2/\u00ff\3\2\2\2\61\u0104\3\2\2\2\63\u0108\3\2\2\2\65\u0112"+
		"\3\2\2\2\67\u0114\3\2\2\29\u011a\3\2\2\2;\u011c\3\2\2\2=\u0121\3\2\2\2"+
		"?\u0126\3\2\2\2A\u0128\3\2\2\2C\u012b\3\2\2\2E\u012d\3\2\2\2G\u012f\3"+
		"\2\2\2I\u0134\3\2\2\2K\u013e\3\2\2\2M\u0142\3\2\2\2O\u0149\3\2\2\2Q\u014e"+
		"\3\2\2\2S\u0156\3\2\2\2U\u015e\3\2\2\2W\u0165\3\2\2\2Y\u0167\3\2\2\2["+
		"\u016c\3\2\2\2]\u0177\3\2\2\2_\u017c\3\2\2\2a\u0185\3\2\2\2c\u0187\3\2"+
		"\2\2e\u018d\3\2\2\2g\u018f\3\2\2\2i\u019b\3\2\2\2k\u01a0\3\2\2\2m\u01a3"+
		"\3\2\2\2o\u01b0\3\2\2\2q\u01bf\3\2\2\2s\u01d5\3\2\2\2u\u01ee\3\2\2\2w"+
		"\u01f0\3\2\2\2y\u020d\3\2\2\2{\u020f\3\2\2\2}\u0230\3\2\2\2\177\u0232"+
		"\3\2\2\2\u0081\u0235\3\2\2\2\u0083\u023a\3\2\2\2\u0085\u0240\3\2\2\2\u0087"+
		"\u0243\3\2\2\2\u0089\u0246\3\2\2\2\u008b\u024e\3\2\2\2\u008d\u0256\3\2"+
		"\2\2\u008f\u025c\3\2\2\2\u0091\u0262\3\2\2\2\u0093\u0094\7u\2\2\u0094"+
		"\u0095\7e\2\2\u0095\u0096\7j\2\2\u0096\u0097\7g\2\2\u0097\u0098\7o\2\2"+
		"\u0098\u0099\7c\2\2\u0099\4\3\2\2\2\u009a\u009b\7^\2\2\u009b\u009c\7n"+
		"\2\2\u009c\u009d\7p\2\2\u009d\u009e\7q\2\2\u009e\u009f\7v\2\2\u009f\6"+
		"\3\2\2\2\u00a0\u00a1\7t\2\2\u00a1\u00a2\7g\2\2\u00a2\u00a3\7x\2\2\u00a3"+
		"\b\3\2\2\2\u00a4\u00a5\7]\2\2\u00a5\n\3\2\2\2\u00a6\u00a7\7^\2\2\u00a7"+
		"\u00a8\7r\2\2\u00a8\u00a9\7h\2\2\u00a9\u00aa\7w\2\2\u00aa\u00ab\7p\2\2"+
		"\u00ab\f\3\2\2\2\u00ac\u00ad\7>\2\2\u00ad\16\3\2\2\2\u00ae\u00af\7h\2"+
		"\2\u00af\u00b0\7c\2\2\u00b0\u00b1\7n\2\2\u00b1\u00b2\7u\2\2\u00b2\u00b3"+
		"\7g\2\2\u00b3\20\3\2\2\2\u00b4\u00b5\7^\2\2\u00b5\u00b6\7g\2\2\u00b6\u00b7"+
		"\7o\2\2\u00b7\u00b8\7r\2\2\u00b8\u00b9\7v\2\2\u00b9\u00ba\7{\2\2\u00ba"+
		"\u00bb\7u\2\2\u00bb\u00bc\7g\2\2\u00bc\u00bd\7v\2\2\u00bd\22\3\2\2\2\u00be"+
		"\u00bf\7^\2\2\u00bf\u00c0\7w\2\2\u00c0\u00c1\7r\2\2\u00c1\u00c2\7v\2\2"+
		"\u00c2\u00c3\7q\2\2\u00c3\24\3\2\2\2\u00c4\u00c5\7v\2\2\u00c5\u00c6\7"+
		"c\2\2\u00c6\u00c7\7k\2\2\u00c7\u00c8\7n\2\2\u00c8\26\3\2\2\2\u00c9\u00ca"+
		"\7^\2\2\u00ca\u00cb\7h\2\2\u00cb\u00cc\7h\2\2\u00cc\u00cd\7w\2\2\u00cd"+
		"\u00ce\7p\2\2\u00ce\30\3\2\2\2\u00cf\u00d0\7\177\2\2\u00d0\32\3\2\2\2"+
		"\u00d1\u00d2\7^\2\2\u00d2\u00d3\7p\2\2\u00d3\u00d4\7q\2\2\u00d4\u00d5"+
		"\7v\2\2\u00d5\u00d6\7k\2\2\u00d6\u00d7\7p\2\2\u00d7\34\3\2\2\2\u00d8\u00d9"+
		"\7^\2\2\u00d9\u00da\7n\2\2\u00da\u00db\7c\2\2\u00db\u00dc\7p\2\2\u00dc"+
		"\u00dd\7f\2\2\u00dd\36\3\2\2\2\u00de\u00df\7+\2\2\u00df \3\2\2\2\u00e0"+
		"\u00e1\7B\2\2\u00e1\"\3\2\2\2\u00e2\u00e3\7j\2\2\u00e3\u00e4\7g\2\2\u00e4"+
		"\u00e5\7c\2\2\u00e5\u00e6\7f\2\2\u00e6$\3\2\2\2\u00e7\u00e8\7?\2\2\u00e8"+
		"&\3\2\2\2\u00e9\u00ea\7^\2\2\u00ea\u00eb\7n\2\2\u00eb\u00ec\7g\2\2\u00ec"+
		"\u00ed\7s\2\2\u00ed(\3\2\2\2\u00ee\u00ef\7^\2\2\u00ef\u00f0\7p\2\2\u00f0"+
		"\u00f1\7c\2\2\u00f1\u00f2\7v\2\2\u00f2*\3\2\2\2\u00f3\u00f4\7^\2\2\u00f4"+
		"\u00f5\7p\2\2\u00f5\u00f6\7g\2\2\u00f6\u00f7\7s\2\2\u00f7,\3\2\2\2\u00f8"+
		"\u00f9\7^\2\2\u00f9\u00fa\7y\2\2\u00fa\u00fb\7j\2\2\u00fb\u00fc\7g\2\2"+
		"\u00fc\u00fd\7t\2\2\u00fd\u00fe\7g\2\2\u00fe.\3\2\2\2\u00ff\u0100\7^\2"+
		"\2\u0100\u0101\7i\2\2\u0101\u0102\7g\2\2\u0102\u0103\7s\2\2\u0103\60\3"+
		"\2\2\2\u0104\u0105\7<\2\2\u0105\u0106\7<\2\2\u0106\u0107\7?\2\2\u0107"+
		"\62\3\2\2\2\u0108\u0109\7^\2\2\u0109\u010a\7u\2\2\u010a\u010b\7w\2\2\u010b"+
		"\u010c\7d\2\2\u010c\u010d\7u\2\2\u010d\u010e\7g\2\2\u010e\u010f\7v\2\2"+
		"\u010f\u0110\7g\2\2\u0110\u0111\7s\2\2\u0111\64\3\2\2\2\u0112\u0113\7"+
		"~\2\2\u0113\66\3\2\2\2\u0114\u0115\7^\2\2\u0115\u0116\7g\2\2\u0116\u0117"+
		"\7p\2\2\u0117\u0118\7f\2\2\u0118\u0119\7}\2\2\u01198\3\2\2\2\u011a\u011b"+
		"\7_\2\2\u011b:\3\2\2\2\u011c\u011d\7n\2\2\u011d\u011e\7c\2\2\u011e\u011f"+
		"\7u\2\2\u011f\u0120\7v\2\2\u0120<\3\2\2\2\u0121\u0122\7^\2\2\u0122\u0123"+
		"\7t\2\2\u0123\u0124\7g\2\2\u0124\u0125\7n\2\2\u0125>\3\2\2\2\u0126\u0127"+
		"\7.\2\2\u0127@\3\2\2\2\u0128\u0129\7\177\2\2\u0129\u012a\7}\2\2\u012a"+
		"B\3\2\2\2\u012b\u012c\7*\2\2\u012cD\3\2\2\2\u012d\u012e\7<\2\2\u012eF"+
		"\3\2\2\2\u012f\u0130\7^\2\2\u0130\u0131\7n\2\2\u0131\u0132\7q\2\2\u0132"+
		"\u0133\7t\2\2\u0133H\3\2\2\2\u0134\u0135\7^\2\2\u0135\u0136\7g\2\2\u0136"+
		"\u0137\7p\2\2\u0137\u0138\7f\2\2\u0138\u0139\7}\2\2\u0139\u013a\7|\2\2"+
		"\u013a\u013b\7g\2\2\u013b\u013c\7f\2\2\u013c\u013d\7\177\2\2\u013dJ\3"+
		"\2\2\2\u013e\u013f\7^\2\2\u013f\u0140\7k\2\2\u0140\u0141\7p\2\2\u0141"+
		"L\3\2\2\2\u0142\u0143\7^\2\2\u0143\u0144\7e\2\2\u0144\u0145\7t\2\2\u0145"+
		"\u0146\7q\2\2\u0146\u0147\7u\2\2\u0147\u0148\7u\2\2\u0148N\3\2\2\2\u0149"+
		"\u014a\7v\2\2\u014a\u014b\7t\2\2\u014b\u014c\7w\2\2\u014c\u014d\7g\2\2"+
		"\u014dP\3\2\2\2\u014e\u014f\7^\2\2\u014f\u0150\7d\2\2\u0150\u0151\7g\2"+
		"\2\u0151\u0152\7i\2\2\u0152\u0153\7k\2\2\u0153\u0154\7p\2\2\u0154\u0155"+
		"\7}\2\2\u0155R\3\2\2\2\u0156\u0157\7^\2\2\u0157\u0158\7u\2\2\u0158\u0159"+
		"\7w\2\2\u0159\u015a\7d\2\2\u015a\u015b\7u\2\2\u015b\u015c\7g\2\2\u015c"+
		"\u015d\7v\2\2\u015dT\3\2\2\2\u015e\u015f\7^\2\2\u015f\u0160\7r\2\2\u0160"+
		"\u0161\7q\2\2\u0161\u0162\7y\2\2\u0162\u0163\7g\2\2\u0163\u0164\7t\2\2"+
		"\u0164V\3\2\2\2\u0165\u0166\7\60\2\2\u0166X\3\2\2\2\u0167\u0168\7^\2\2"+
		"\u0168\u0169\7k\2\2\u0169\u016a\7h\2\2\u016a\u016b\7h\2\2\u016bZ\3\2\2"+
		"\2\u016c\u016d\7u\2\2\u016d\u016e\7e\2\2\u016e\u016f\7j\2\2\u016f\u0170"+
		"\7g\2\2\u0170\u0171\7o\2\2\u0171\u0172\7c\2\2\u0172\u0173\7V\2\2\u0173"+
		"\u0174\7{\2\2\u0174\u0175\7r\2\2\u0175\u0176\7g\2\2\u0176\\\3\2\2\2\u0177"+
		"\u0178\7^\2\2\u0178\u0179\7h\2\2\u0179\u017a\7w\2\2\u017a\u017b\7p\2\2"+
		"\u017b^\3\2\2\2\u017c\u017d\7^\2\2\u017d\u017e\7k\2\2\u017e\u017f\7o\2"+
		"\2\u017f\u0180\7r\2\2\u0180\u0181\7n\2\2\u0181\u0182\7k\2\2\u0182\u0183"+
		"\7g\2\2\u0183\u0184\7u\2\2\u0184`\3\2\2\2\u0185\u0186\7=\2\2\u0186b\3"+
		"\2\2\2\u0187\u0188\7h\2\2\u0188\u0189\7t\2\2\u0189\u018a\7q\2\2\u018a"+
		"\u018b\7p\2\2\u018b\u018c\7v\2\2\u018cd\3\2\2\2\u018d\u018e\7@\2\2\u018e"+
		"f\3\2\2\2\u018f\u0190\7^\2\2\u0190\u0191\7d\2\2\u0191\u0192\7g\2\2\u0192"+
		"\u0193\7i\2\2\u0193\u0194\7k\2\2\u0194\u0195\7p\2\2\u0195\u0196\7}\2\2"+
		"\u0196\u0197\7|\2\2\u0197\u0198\7g\2\2\u0198\u0199\7f\2\2\u0199\u019a"+
		"\7\177\2\2\u019ah\3\2\2\2\u019b\u019c\7^\2\2\u019c\u019d\7p\2\2\u019d"+
		"\u019e\7w\2\2\u019e\u019f\7o\2\2\u019fj\3\2\2\2\u01a0\u01a1\7?\2\2\u01a1"+
		"\u01a2\7?\2\2\u01a2l\3\2\2\2\u01a3\u01a4\7^\2\2\u01a4\u01a5\7o\2\2\u01a5"+
		"\u01a6\7c\2\2\u01a6\u01a7\7r\2\2\u01a7\u01a8\7u\2\2\u01a8\u01a9\7v\2\2"+
		"\u01a9\u01aa\7q\2\2\u01aan\3\2\2\2\u01ab\u01b1\t\2\2\2\u01ac\u01ad\7^"+
		"\2\2\u01ad\u01ae\7a\2\2\u01ae\u01b1\7\"\2\2\u01af\u01b1\7A\2\2\u01b0\u01ab"+
		"\3\2\2\2\u01b0\u01ac\3\2\2\2\u01b0\u01af\3\2\2\2\u01b1\u01b2\3\2\2\2\u01b2"+
		"\u01b0\3\2\2\2\u01b2\u01b3\3\2\2\2\u01b3\u01bb\3\2\2\2\u01b4\u01ba\t\3"+
		"\2\2\u01b5\u01b6\7^\2\2\u01b6\u01b7\7a\2\2\u01b7\u01ba\7\"\2\2\u01b8\u01ba"+
		"\t\4\2\2\u01b9\u01b4\3\2\2\2\u01b9\u01b5\3\2\2\2\u01b9\u01b8\3\2\2\2\u01ba"+
		"\u01bd\3\2\2\2\u01bb\u01b9\3\2\2\2\u01bb\u01bc\3\2\2\2\u01bcp\3\2\2\2"+
		"\u01bd\u01bb\3\2\2\2\u01be\u01c0\4\62;\2\u01bf\u01be\3\2\2\2\u01c0\u01c1"+
		"\3\2\2\2\u01c1\u01bf\3\2\2\2\u01c1\u01c2\3\2\2\2\u01c2r\3\2\2\2\u01c3"+
		"\u01d6\t\5\2\2\u01c4\u01c5\7^\2\2\u01c5\u01c6\7e\2\2\u01c6\u01c7\7w\2"+
		"\2\u01c7\u01d6\7r\2\2\u01c8\u01c9\7^\2\2\u01c9\u01ca\7u\2\2\u01ca\u01cb"+
		"\7g\2\2\u01cb\u01cc\7v\2\2\u01cc\u01cd\7o\2\2\u01cd\u01ce\7k\2\2\u01ce"+
		"\u01cf\7p\2\2\u01cf\u01d0\7w\2\2\u01d0\u01d6\7u\2\2\u01d1\u01d2\7^\2\2"+
		"\u01d2\u01d3\7e\2\2\u01d3\u01d4\7c\2\2\u01d4\u01d6\7v\2\2\u01d5\u01c3"+
		"\3\2\2\2\u01d5\u01c4\3\2\2\2\u01d5\u01c8\3\2\2\2\u01d5\u01d1\3\2\2\2\u01d6"+
		"t\3\2\2\2\u01d7\u01ef\7,\2\2\u01d8\u01d9\7^\2\2\u01d9\u01da\7f\2\2\u01da"+
		"\u01db\7k\2\2\u01db\u01ef\7x\2\2\u01dc\u01dd\7^\2\2\u01dd\u01de\7o\2\2"+
		"\u01de\u01df\7q\2\2\u01df\u01ef\7f\2\2\u01e0\u01e1\7^\2\2\u01e1\u01e2"+
		"\7e\2\2\u01e2\u01e3\7c\2\2\u01e3\u01ef\7r\2\2\u01e4\u01e5\7^\2\2\u01e5"+
		"\u01e6\7e\2\2\u01e6\u01e7\7q\2\2\u01e7\u01e8\7o\2\2\u01e8\u01ef\7r\2\2"+
		"\u01e9\u01ea\7^\2\2\u01ea\u01eb\7e\2\2\u01eb\u01ec\7k\2\2\u01ec\u01ed"+
		"\7t\2\2\u01ed\u01ef\7e\2\2\u01ee\u01d7\3\2\2\2\u01ee\u01d8\3\2\2\2\u01ee"+
		"\u01dc\3\2\2\2\u01ee\u01e0\3\2\2\2\u01ee\u01e4\3\2\2\2\u01ee\u01e9\3\2"+
		"\2\2\u01efv\3\2\2\2\u01f0\u01f1\7^\2\2\u01f1\u01f2\7q\2\2\u01f2\u01f3"+
		"\7r\2\2\u01f3\u01f4\7n\2\2\u01f4\u01f5\7w\2\2\u01f5\u01f6\7u\2\2\u01f6"+
		"x\3\2\2\2\u01f7\u01f8\7^\2\2\u01f8\u01f9\7f\2\2\u01f9\u01fa\7t\2\2\u01fa"+
		"\u01fb\7g\2\2\u01fb\u020e\7u\2\2\u01fc\u01fd\7^\2\2\u01fd\u01fe\7t\2\2"+
		"\u01fe\u01ff\7t\2\2\u01ff\u0200\7g\2\2\u0200\u020e\7u\2\2\u0201\u0202"+
		"\7^\2\2\u0202\u0203\7p\2\2\u0203\u0204\7f\2\2\u0204\u0205\7t\2\2\u0205"+
		"\u0206\7g\2\2\u0206\u020e\7u\2\2\u0207\u0208\7^\2\2\u0208\u0209\7p\2\2"+
		"\u0209\u020a\7t\2\2\u020a\u020b\7t\2\2\u020b\u020c\7g\2\2\u020c\u020e"+
		"\7u\2\2\u020d\u01f7\3\2\2\2\u020d\u01fc\3\2\2\2\u020d\u0201\3\2\2\2\u020d"+
		"\u0207\3\2\2\2\u020ez\3\2\2\2\u020f\u0210\7^\2\2\u0210\u0211\7k\2\2\u0211"+
		"\u0212\7p\2\2\u0212\u0213\7x\2\2\u0213|\3\2\2\2\u0214\u0215\7^\2\2\u0215"+
		"\u0216\7t\2\2\u0216\u0217\7c\2\2\u0217\u0231\7p\2\2\u0218\u0219\7^\2\2"+
		"\u0219\u021a\7f\2\2\u021a\u021b\7q\2\2\u021b\u0231\7o\2\2\u021c\u021d"+
		"\7^\2\2\u021d\u021e\7u\2\2\u021e\u021f\7g\2\2\u021f\u0231\7s\2\2\u0220"+
		"\u0221\7^\2\2\u0221\u0231\7%\2\2\u0222\u0223\7^\2\2\u0223\u0224\7d\2\2"+
		"\u0224\u0225\7k\2\2\u0225\u0226\7i\2\2\u0226\u0227\7e\2\2\u0227\u0228"+
		"\7w\2\2\u0228\u0231\7r\2\2\u0229\u022a\7^\2\2\u022a\u022b\7d\2\2\u022b"+
		"\u022c\7k\2\2\u022c\u022d\7i\2\2\u022d\u022e\7e\2\2\u022e\u022f\7w\2\2"+
		"\u022f\u0231\7r\2\2\u0230\u0214\3\2\2\2\u0230\u0218\3\2\2\2\u0230\u021c"+
		"\3\2\2\2\u0230\u0220\3\2\2\2\u0230\u0222\3\2\2\2\u0230\u0229\3\2\2\2\u0231"+
		"~\3\2\2\2\u0232\u0233\7\u0080\2\2\u0233\u0080\3\2\2\2\u0234\u0236\7\17"+
		"\2\2\u0235\u0234\3\2\2\2\u0235\u0236\3\2\2\2\u0236\u0237\3\2\2\2\u0237"+
		"\u0238\7\f\2\2\u0238\u0082\3\2\2\2\u0239\u023b\t\6\2\2\u023a\u0239\3\2"+
		"\2\2\u023b\u023c\3\2\2\2\u023c\u023a\3\2\2\2\u023c\u023d\3\2\2\2\u023d"+
		"\u023e\3\2\2\2\u023e\u023f\bB\2\2\u023f\u0084\3\2\2\2\u0240\u0241\7^\2"+
		"\2\u0241\u0242\7}\2\2\u0242\u0086\3\2\2\2\u0243\u0244\7^\2\2\u0244\u0245"+
		"\7\177\2\2\u0245\u0088\3\2\2\2\u0246\u0247\7^\2\2\u0247\u0248\7n\2\2\u0248"+
		"\u0249\7c\2\2\u0249\u024a\7p\2\2\u024a\u024b\7i\2\2\u024b\u024c\7n\2\2"+
		"\u024c\u024d\7g\2\2\u024d\u008a\3\2\2\2\u024e\u024f\7^\2\2\u024f\u0250"+
		"\7t\2\2\u0250\u0251\7c\2\2\u0251\u0252\7p\2\2\u0252\u0253\7i\2\2\u0253"+
		"\u0254\7n\2\2\u0254\u0255\7g\2\2\u0255\u008c\3\2\2\2\u0256\u0257\7^\2"+
		"\2\u0257\u0258\7n\2\2\u0258\u0259\7k\2\2\u0259\u025a\7o\2\2\u025a\u025b"+
		"\7i\2\2\u025b\u008e\3\2\2\2\u025c\u025d\7^\2\2\u025d\u025e\7t\2\2\u025e"+
		"\u025f\7k\2\2\u025f\u0260\7o\2\2\u0260\u0261\7i\2\2\u0261\u0090\3\2\2"+
		"\2\u0262\u0263\7^\2\2\u0263\u0264\7^\2\2\u0264\u0265\bI\3\2\u0265\u0092"+
		"\3\2\2\2\16\2\u01b0\u01b2\u01b9\u01bb\u01c1\u01d5\u01ee\u020d\u0230\u0235"+
		"\u023c";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}