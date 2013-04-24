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
		T__56=1, T__55=2, T__54=3, T__53=4, T__52=5, T__51=6, T__50=7, T__49=8, 
		T__48=9, T__47=10, T__46=11, T__45=12, T__44=13, T__43=14, T__42=15, T__41=16, 
		T__40=17, T__39=18, T__38=19, T__37=20, T__36=21, T__35=22, T__34=23, 
		T__33=24, T__32=25, T__31=26, T__30=27, T__29=28, T__28=29, T__27=30, 
		T__26=31, T__25=32, T__24=33, T__23=34, T__22=35, T__21=36, T__20=37, 
		T__19=38, T__18=39, T__17=40, T__16=41, T__15=42, T__14=43, T__13=44, 
		T__12=45, T__11=46, T__10=47, T__9=48, T__8=49, T__7=50, T__6=51, T__5=52, 
		T__4=53, T__3=54, T__2=55, T__1=56, T__0=57, NAME=58, NUM=59, IN_FUN_P3=60, 
		IN_FUN_P4=61, IN_FUN_P5=62, IN_FUN_P6=63, POST_FUN=64, PRE_GEN=65, DECORATION=66, 
		NL=67, WS=68, SETSTART=69, SETEND=70, LISTSTART=71, LISTEND=72, IMGSTART=73, 
		IMGEND=74, SKIP=75;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'schema'", "'\\lnot'", "'rev'", "'['", "'\\pfun'", "'<'", "'false'", 
		"'\\emptyset'", "'\\upto'", "'tail'", "'\\ffun'", "'}'", "'\\notin'", 
		"'\\land'", "')'", "'@'", "'head'", "'='", "'\\leq'", "'\\prefix'", "'squash'", 
		"'\\neq'", "'\\nat'", "'\\where'", "'\\geq'", "'::='", "'\\subseteq'", 
		"'|'", "'\\end{'", "'\\suffix'", "']'", "'last'", "'\\rel'", "','", "'}{'", 
		"'('", "':'", "'\\lor'", "'\\end{zed}'", "'\\in'", "'\\cross'", "'true'", 
		"'\\begin{'", "'\\subset'", "'\\power'", "'.'", "'\\iff'", "'schemaType'", 
		"'\\fun'", "'\\implies'", "';'", "'front'", "'>'", "'\\begin{zed}'", "'\\num'", 
		"'=='", "'\\mapsto'", "NAME", "NUM", "IN_FUN_P3", "IN_FUN_P4", "IN_FUN_P5", 
		"IN_FUN_P6", "'\\inv'", "PRE_GEN", "'~'", "NL", "WS", "'\\{'", "'\\}'", 
		"'\\langle'", "'\\rangle'", "'\\limg'", "'\\rimg'", "SKIP"
	};
	public static final String[] ruleNames = {
		"T__56", "T__55", "T__54", "T__53", "T__52", "T__51", "T__50", "T__49", 
		"T__48", "T__47", "T__46", "T__45", "T__44", "T__43", "T__42", "T__41", 
		"T__40", "T__39", "T__38", "T__37", "T__36", "T__35", "T__34", "T__33", 
		"T__32", "T__31", "T__30", "T__29", "T__28", "T__27", "T__26", "T__25", 
		"T__24", "T__23", "T__22", "T__21", "T__20", "T__19", "T__18", "T__17", 
		"T__16", "T__15", "T__14", "T__13", "T__12", "T__11", "T__10", "T__9", 
		"T__8", "T__7", "T__6", "T__5", "T__4", "T__3", "T__2", "T__1", "T__0", 
		"NAME", "NUM", "IN_FUN_P3", "IN_FUN_P4", "IN_FUN_P5", "IN_FUN_P6", "POST_FUN", 
		"PRE_GEN", "DECORATION", "NL", "WS", "SETSTART", "SETEND", "LISTSTART", 
		"LISTEND", "IMGSTART", "IMGEND", "SKIP"
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
	        
	        while (((String) root.getUserObject()).equals("()")) {
	        	root = (DefaultMutableTreeNode) root.getChildAt(0);
	        }
	        
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
	        
	        while (((String) root.getUserObject()).equals("()")) {
	        	root = (DefaultMutableTreeNode) root.getChildAt(0);
	        }
	        
	        DefaultMutableTreeNode child = (DefaultMutableTreeNode) root.getChildAt(pos);
	        
	        while (((String) child.getUserObject()).equals("()")) {
	        	child = (DefaultMutableTreeNode) child.getChildAt(0);
	        }
	        
	        return parser.printTree(child);
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
		
		//Metodo para obtener los tipos izquierdo y derecho
		//Constraits: Debe ser una funcion o un \power de \cross
		//EJ: A \pfun B devuelve A y B
		ArrayList<String> leftAndRightTypes(String type) {
			ANTLRInputStream input = new ANTLRInputStream(type);
	        TypeManagerLexer lexer = new TypeManagerLexer(input);
	        CommonTokenStream tokens = new CommonTokenStream(lexer);
	        TypeManagerParser parser = new TypeManagerParser(tokens);
	        parser.typeManage();
	        DefaultMutableTreeNode root = parser.getRoot();
	        
			ArrayList<String> leftAndRight = new ArrayList<String>();
			DefaultMutableTreeNode left, right;
			String rootType = (String) root.getUserObject();
			if (rootType.equals("\\power")) {
				DefaultMutableTreeNode child = (DefaultMutableTreeNode) root.getChildAt(0);
				String childType = (String) child.getUserObject();
				
				while (childType.equals("()")) {
					child = (DefaultMutableTreeNode) child.getChildAt(0);
					childType = (String) child.getUserObject();
				}
				
				if (childType.equals("\\cross")) {
					left = (DefaultMutableTreeNode) child.getChildAt(0);
					while (((String) left.getUserObject()).equals("()"))
						left = (DefaultMutableTreeNode) left.getChildAt(0);
					right = (DefaultMutableTreeNode) child.getChildAt(1);
					while (((String) right.getUserObject()).equals("()"))
						right = (DefaultMutableTreeNode) right.getChildAt(0);
					
					leftAndRight.add((String) left.getUserObject());
					leftAndRight.add((String) right.getUserObject());
				}
			
			}
			else if (rootType.equals("\\seq")) { //Entonces empieza con pfun, rel etc

				leftAndRight.add("\\nat");
				right = (DefaultMutableTreeNode) root.getChildAt(0);
				while (((String) right.getUserObject()).equals("()"))
					right = (DefaultMutableTreeNode) right.getChildAt(0);
				leftAndRight.add((String) right.getUserObject());

			}
			else { //Entonces empieza con pfun, rel etc

			left = (DefaultMutableTreeNode) root.getChildAt(0);
			while (((String) left.getUserObject()).equals("()"))
				left = (DefaultMutableTreeNode) left.getChildAt(0);
			right = (DefaultMutableTreeNode) root.getChildAt(1);
			while (((String) right.getUserObject()).equals("()"))
				right = (DefaultMutableTreeNode) right.getChildAt(0);
				
			leftAndRight.add((String) left.getUserObject());
			leftAndRight.add((String) right.getUserObject());
			}
			
			return leftAndRight;
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
				else if (nodeType.equals("\\power")) {
					//Veo si lo que sigue es un tipo enumerado
					String childType = getChildType(type,0);
					childType = types.get(childType);
					if (childType != null && childType.startsWith("EnumerationType"))
						print("subset(" + var + "," + childType.split(":")[1] + ")");
				}
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
		case 67: WS_action((RuleContext)_localctx, actionIndex); break;

		case 74: SKIP_action((RuleContext)_localctx, actionIndex); break;
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
		"\2\4M\u0292\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t"+
		"\b\4\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20"+
		"\t\20\4\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27"+
		"\t\27\4\30\t\30\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36"+
		"\t\36\4\37\t\37\4 \t \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4"+
		"(\t(\4)\t)\4*\t*\4+\t+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62"+
		"\t\62\4\63\t\63\4\64\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4"+
		":\t:\4;\t;\4<\t<\4=\t=\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\t"+
		"E\4F\tF\4G\tG\4H\tH\4I\tI\4J\tJ\4K\tK\4L\tL\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3"+
		"\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3"+
		"\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3"+
		"\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3"+
		"\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3"+
		"\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37\3"+
		"\37\3\37\3 \3 \3!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3#\3#\3$\3$\3$\3%\3"+
		"%\3&\3&\3\'\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3)\3)\3)\3)"+
		"\3*\3*\3*\3*\3*\3*\3*\3+\3+\3+\3+\3+\3,\3,\3,\3,\3,\3,\3,\3,\3-\3-\3-"+
		"\3-\3-\3-\3-\3-\3.\3.\3.\3.\3.\3.\3.\3/\3/\3\60\3\60\3\60\3\60\3\60\3"+
		"\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\62\3\62\3\62\3"+
		"\62\3\62\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\64\3\64\3\65\3"+
		"\65\3\65\3\65\3\65\3\65\3\66\3\66\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3"+
		"\67\3\67\3\67\3\67\3\67\38\38\38\38\38\39\39\39\3:\3:\3:\3:\3:\3:\3:\3"+
		":\3;\3;\3;\3;\3;\6;\u01ce\n;\r;\16;\u01cf\3;\3;\3;\3;\3;\7;\u01d7\n;\f"+
		";\16;\u01da\13;\3<\6<\u01dd\n<\r<\16<\u01de\3=\3=\3=\3=\3=\3=\3=\3=\3"+
		"=\3=\3=\3=\3=\3=\3=\3=\3=\3=\5=\u01f3\n=\3>\3>\3>\3>\3>\3>\3>\3>\3>\3"+
		">\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3"+
		">\3>\3>\3>\3>\3>\5>\u021b\n>\3?\3?\3?\3?\3?\3?\3?\3@\3@\3@\3@\3@\3@\3"+
		"@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\5@\u023a\n@\3A\3A\3A\3"+
		"A\3A\3B\3B\3B\3B\3B\3B\3B\3B\3B\3B\3B\3B\3B\3B\3B\3B\3B\3B\3B\3B\3B\3"+
		"B\3B\3B\3B\3B\3B\3B\5B\u025d\nB\3C\3C\3D\5D\u0262\nD\3D\3D\3E\6E\u0267"+
		"\nE\rE\16E\u0268\3E\3E\3F\3F\3F\3G\3G\3G\3H\3H\3H\3H\3H\3H\3H\3H\3I\3"+
		"I\3I\3I\3I\3I\3I\3I\3J\3J\3J\3J\3J\3J\3K\3K\3K\3K\3K\3K\3L\3L\3L\3L\2"+
		"M\3\3\1\5\4\1\7\5\1\t\6\1\13\7\1\r\b\1\17\t\1\21\n\1\23\13\1\25\f\1\27"+
		"\r\1\31\16\1\33\17\1\35\20\1\37\21\1!\22\1#\23\1%\24\1\'\25\1)\26\1+\27"+
		"\1-\30\1/\31\1\61\32\1\63\33\1\65\34\1\67\35\19\36\1;\37\1= \1?!\1A\""+
		"\1C#\1E$\1G%\1I&\1K\'\1M(\1O)\1Q*\1S+\1U,\1W-\1Y.\1[/\1]\60\1_\61\1a\62"+
		"\1c\63\1e\64\1g\65\1i\66\1k\67\1m8\1o9\1q:\1s;\1u<\1w=\1y>\1{?\1}@\1\177"+
		"A\1\u0081B\1\u0083C\1\u0085D\1\u0087E\1\u0089F\2\u008bG\1\u008dH\1\u008f"+
		"I\1\u0091J\1\u0093K\1\u0095L\1\u0097M\3\3\2\7\4C\\c|\4C\\c|\4\62;AA\4"+
		"--//\5\13\13\17\17\"\"\u02ac\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3"+
		"\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2"+
		"\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37"+
		"\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3"+
		"\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2"+
		"\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C"+
		"\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2"+
		"\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2"+
		"\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i"+
		"\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2"+
		"\2\2\2w\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\2\177\3\2\2\2\2\u0081"+
		"\3\2\2\2\2\u0083\3\2\2\2\2\u0085\3\2\2\2\2\u0087\3\2\2\2\2\u0089\3\2\2"+
		"\2\2\u008b\3\2\2\2\2\u008d\3\2\2\2\2\u008f\3\2\2\2\2\u0091\3\2\2\2\2\u0093"+
		"\3\2\2\2\2\u0095\3\2\2\2\2\u0097\3\2\2\2\3\u0099\3\2\2\2\5\u00a0\3\2\2"+
		"\2\7\u00a6\3\2\2\2\t\u00aa\3\2\2\2\13\u00ac\3\2\2\2\r\u00b2\3\2\2\2\17"+
		"\u00b4\3\2\2\2\21\u00ba\3\2\2\2\23\u00c4\3\2\2\2\25\u00ca\3\2\2\2\27\u00cf"+
		"\3\2\2\2\31\u00d5\3\2\2\2\33\u00d7\3\2\2\2\35\u00de\3\2\2\2\37\u00e4\3"+
		"\2\2\2!\u00e6\3\2\2\2#\u00e8\3\2\2\2%\u00ed\3\2\2\2\'\u00ef\3\2\2\2)\u00f4"+
		"\3\2\2\2+\u00fc\3\2\2\2-\u0103\3\2\2\2/\u0108\3\2\2\2\61\u010d\3\2\2\2"+
		"\63\u0114\3\2\2\2\65\u0119\3\2\2\2\67\u011d\3\2\2\29\u0127\3\2\2\2;\u0129"+
		"\3\2\2\2=\u012f\3\2\2\2?\u0137\3\2\2\2A\u0139\3\2\2\2C\u013e\3\2\2\2E"+
		"\u0143\3\2\2\2G\u0145\3\2\2\2I\u0148\3\2\2\2K\u014a\3\2\2\2M\u014c\3\2"+
		"\2\2O\u0151\3\2\2\2Q\u015b\3\2\2\2S\u015f\3\2\2\2U\u0166\3\2\2\2W\u016b"+
		"\3\2\2\2Y\u0173\3\2\2\2[\u017b\3\2\2\2]\u0182\3\2\2\2_\u0184\3\2\2\2a"+
		"\u0189\3\2\2\2c\u0194\3\2\2\2e\u0199\3\2\2\2g\u01a2\3\2\2\2i\u01a4\3\2"+
		"\2\2k\u01aa\3\2\2\2m\u01ac\3\2\2\2o\u01b8\3\2\2\2q\u01bd\3\2\2\2s\u01c0"+
		"\3\2\2\2u\u01cd\3\2\2\2w\u01dc\3\2\2\2y\u01f2\3\2\2\2{\u021a\3\2\2\2}"+
		"\u021c\3\2\2\2\177\u0239\3\2\2\2\u0081\u023b\3\2\2\2\u0083\u025c\3\2\2"+
		"\2\u0085\u025e\3\2\2\2\u0087\u0261\3\2\2\2\u0089\u0266\3\2\2\2\u008b\u026c"+
		"\3\2\2\2\u008d\u026f\3\2\2\2\u008f\u0272\3\2\2\2\u0091\u027a\3\2\2\2\u0093"+
		"\u0282\3\2\2\2\u0095\u0288\3\2\2\2\u0097\u028e\3\2\2\2\u0099\u009a\7u"+
		"\2\2\u009a\u009b\7e\2\2\u009b\u009c\7j\2\2\u009c\u009d\7g\2\2\u009d\u009e"+
		"\7o\2\2\u009e\u009f\7c\2\2\u009f\4\3\2\2\2\u00a0\u00a1\7^\2\2\u00a1\u00a2"+
		"\7n\2\2\u00a2\u00a3\7p\2\2\u00a3\u00a4\7q\2\2\u00a4\u00a5\7v\2\2\u00a5"+
		"\6\3\2\2\2\u00a6\u00a7\7t\2\2\u00a7\u00a8\7g\2\2\u00a8\u00a9\7x\2\2\u00a9"+
		"\b\3\2\2\2\u00aa\u00ab\7]\2\2\u00ab\n\3\2\2\2\u00ac\u00ad\7^\2\2\u00ad"+
		"\u00ae\7r\2\2\u00ae\u00af\7h\2\2\u00af\u00b0\7w\2\2\u00b0\u00b1\7p\2\2"+
		"\u00b1\f\3\2\2\2\u00b2\u00b3\7>\2\2\u00b3\16\3\2\2\2\u00b4\u00b5\7h\2"+
		"\2\u00b5\u00b6\7c\2\2\u00b6\u00b7\7n\2\2\u00b7\u00b8\7u\2\2\u00b8\u00b9"+
		"\7g\2\2\u00b9\20\3\2\2\2\u00ba\u00bb\7^\2\2\u00bb\u00bc\7g\2\2\u00bc\u00bd"+
		"\7o\2\2\u00bd\u00be\7r\2\2\u00be\u00bf\7v\2\2\u00bf\u00c0\7{\2\2\u00c0"+
		"\u00c1\7u\2\2\u00c1\u00c2\7g\2\2\u00c2\u00c3\7v\2\2\u00c3\22\3\2\2\2\u00c4"+
		"\u00c5\7^\2\2\u00c5\u00c6\7w\2\2\u00c6\u00c7\7r\2\2\u00c7\u00c8\7v\2\2"+
		"\u00c8\u00c9\7q\2\2\u00c9\24\3\2\2\2\u00ca\u00cb\7v\2\2\u00cb\u00cc\7"+
		"c\2\2\u00cc\u00cd\7k\2\2\u00cd\u00ce\7n\2\2\u00ce\26\3\2\2\2\u00cf\u00d0"+
		"\7^\2\2\u00d0\u00d1\7h\2\2\u00d1\u00d2\7h\2\2\u00d2\u00d3\7w\2\2\u00d3"+
		"\u00d4\7p\2\2\u00d4\30\3\2\2\2\u00d5\u00d6\7\177\2\2\u00d6\32\3\2\2\2"+
		"\u00d7\u00d8\7^\2\2\u00d8\u00d9\7p\2\2\u00d9\u00da\7q\2\2\u00da\u00db"+
		"\7v\2\2\u00db\u00dc\7k\2\2\u00dc\u00dd\7p\2\2\u00dd\34\3\2\2\2\u00de\u00df"+
		"\7^\2\2\u00df\u00e0\7n\2\2\u00e0\u00e1\7c\2\2\u00e1\u00e2\7p\2\2\u00e2"+
		"\u00e3\7f\2\2\u00e3\36\3\2\2\2\u00e4\u00e5\7+\2\2\u00e5 \3\2\2\2\u00e6"+
		"\u00e7\7B\2\2\u00e7\"\3\2\2\2\u00e8\u00e9\7j\2\2\u00e9\u00ea\7g\2\2\u00ea"+
		"\u00eb\7c\2\2\u00eb\u00ec\7f\2\2\u00ec$\3\2\2\2\u00ed\u00ee\7?\2\2\u00ee"+
		"&\3\2\2\2\u00ef\u00f0\7^\2\2\u00f0\u00f1\7n\2\2\u00f1\u00f2\7g\2\2\u00f2"+
		"\u00f3\7s\2\2\u00f3(\3\2\2\2\u00f4\u00f5\7^\2\2\u00f5\u00f6\7r\2\2\u00f6"+
		"\u00f7\7t\2\2\u00f7\u00f8\7g\2\2\u00f8\u00f9\7h\2\2\u00f9\u00fa\7k\2\2"+
		"\u00fa\u00fb\7z\2\2\u00fb*\3\2\2\2\u00fc\u00fd\7u\2\2\u00fd\u00fe\7s\2"+
		"\2\u00fe\u00ff\7w\2\2\u00ff\u0100\7c\2\2\u0100\u0101\7u\2\2\u0101\u0102"+
		"\7j\2\2\u0102,\3\2\2\2\u0103\u0104\7^\2\2\u0104\u0105\7p\2\2\u0105\u0106"+
		"\7g\2\2\u0106\u0107\7s\2\2\u0107.\3\2\2\2\u0108\u0109\7^\2\2\u0109\u010a"+
		"\7p\2\2\u010a\u010b\7c\2\2\u010b\u010c\7v\2\2\u010c\60\3\2\2\2\u010d\u010e"+
		"\7^\2\2\u010e\u010f\7y\2\2\u010f\u0110\7j\2\2\u0110\u0111\7g\2\2\u0111"+
		"\u0112\7t\2\2\u0112\u0113\7g\2\2\u0113\62\3\2\2\2\u0114\u0115\7^\2\2\u0115"+
		"\u0116\7i\2\2\u0116\u0117\7g\2\2\u0117\u0118\7s\2\2\u0118\64\3\2\2\2\u0119"+
		"\u011a\7<\2\2\u011a\u011b\7<\2\2\u011b\u011c\7?\2\2\u011c\66\3\2\2\2\u011d"+
		"\u011e\7^\2\2\u011e\u011f\7u\2\2\u011f\u0120\7w\2\2\u0120\u0121\7d\2\2"+
		"\u0121\u0122\7u\2\2\u0122\u0123\7g\2\2\u0123\u0124\7v\2\2\u0124\u0125"+
		"\7g\2\2\u0125\u0126\7s\2\2\u01268\3\2\2\2\u0127\u0128\7~\2\2\u0128:\3"+
		"\2\2\2\u0129\u012a\7^\2\2\u012a\u012b\7g\2\2\u012b\u012c\7p\2\2\u012c"+
		"\u012d\7f\2\2\u012d\u012e\7}\2\2\u012e<\3\2\2\2\u012f\u0130\7^\2\2\u0130"+
		"\u0131\7u\2\2\u0131\u0132\7w\2\2\u0132\u0133\7h\2\2\u0133\u0134\7h\2\2"+
		"\u0134\u0135\7k\2\2\u0135\u0136\7z\2\2\u0136>\3\2\2\2\u0137\u0138\7_\2"+
		"\2\u0138@\3\2\2\2\u0139\u013a\7n\2\2\u013a\u013b\7c\2\2\u013b\u013c\7"+
		"u\2\2\u013c\u013d\7v\2\2\u013dB\3\2\2\2\u013e\u013f\7^\2\2\u013f\u0140"+
		"\7t\2\2\u0140\u0141\7g\2\2\u0141\u0142\7n\2\2\u0142D\3\2\2\2\u0143\u0144"+
		"\7.\2\2\u0144F\3\2\2\2\u0145\u0146\7\177\2\2\u0146\u0147\7}\2\2\u0147"+
		"H\3\2\2\2\u0148\u0149\7*\2\2\u0149J\3\2\2\2\u014a\u014b\7<\2\2\u014bL"+
		"\3\2\2\2\u014c\u014d\7^\2\2\u014d\u014e\7n\2\2\u014e\u014f\7q\2\2\u014f"+
		"\u0150\7t\2\2\u0150N\3\2\2\2\u0151\u0152\7^\2\2\u0152\u0153\7g\2\2\u0153"+
		"\u0154\7p\2\2\u0154\u0155\7f\2\2\u0155\u0156\7}\2\2\u0156\u0157\7|\2\2"+
		"\u0157\u0158\7g\2\2\u0158\u0159\7f\2\2\u0159\u015a\7\177\2\2\u015aP\3"+
		"\2\2\2\u015b\u015c\7^\2\2\u015c\u015d\7k\2\2\u015d\u015e\7p\2\2\u015e"+
		"R\3\2\2\2\u015f\u0160\7^\2\2\u0160\u0161\7e\2\2\u0161\u0162\7t\2\2\u0162"+
		"\u0163\7q\2\2\u0163\u0164\7u\2\2\u0164\u0165\7u\2\2\u0165T\3\2\2\2\u0166"+
		"\u0167\7v\2\2\u0167\u0168\7t\2\2\u0168\u0169\7w\2\2\u0169\u016a\7g\2\2"+
		"\u016aV\3\2\2\2\u016b\u016c\7^\2\2\u016c\u016d\7d\2\2\u016d\u016e\7g\2"+
		"\2\u016e\u016f\7i\2\2\u016f\u0170\7k\2\2\u0170\u0171\7p\2\2\u0171\u0172"+
		"\7}\2\2\u0172X\3\2\2\2\u0173\u0174\7^\2\2\u0174\u0175\7u\2\2\u0175\u0176"+
		"\7w\2\2\u0176\u0177\7d\2\2\u0177\u0178\7u\2\2\u0178\u0179\7g\2\2\u0179"+
		"\u017a\7v\2\2\u017aZ\3\2\2\2\u017b\u017c\7^\2\2\u017c\u017d\7r\2\2\u017d"+
		"\u017e\7q\2\2\u017e\u017f\7y\2\2\u017f\u0180\7g\2\2\u0180\u0181\7t\2\2"+
		"\u0181\\\3\2\2\2\u0182\u0183\7\60\2\2\u0183^\3\2\2\2\u0184\u0185\7^\2"+
		"\2\u0185\u0186\7k\2\2\u0186\u0187\7h\2\2\u0187\u0188\7h\2\2\u0188`\3\2"+
		"\2\2\u0189\u018a\7u\2\2\u018a\u018b\7e\2\2\u018b\u018c\7j\2\2\u018c\u018d"+
		"\7g\2\2\u018d\u018e\7o\2\2\u018e\u018f\7c\2\2\u018f\u0190\7V\2\2\u0190"+
		"\u0191\7{\2\2\u0191\u0192\7r\2\2\u0192\u0193\7g\2\2\u0193b\3\2\2\2\u0194"+
		"\u0195\7^\2\2\u0195\u0196\7h\2\2\u0196\u0197\7w\2\2\u0197\u0198\7p\2\2"+
		"\u0198d\3\2\2\2\u0199\u019a\7^\2\2\u019a\u019b\7k\2\2\u019b\u019c\7o\2"+
		"\2\u019c\u019d\7r\2\2\u019d\u019e\7n\2\2\u019e\u019f\7k\2\2\u019f\u01a0"+
		"\7g\2\2\u01a0\u01a1\7u\2\2\u01a1f\3\2\2\2\u01a2\u01a3\7=\2\2\u01a3h\3"+
		"\2\2\2\u01a4\u01a5\7h\2\2\u01a5\u01a6\7t\2\2\u01a6\u01a7\7q\2\2\u01a7"+
		"\u01a8\7p\2\2\u01a8\u01a9\7v\2\2\u01a9j\3\2\2\2\u01aa\u01ab\7@\2\2\u01ab"+
		"l\3\2\2\2\u01ac\u01ad\7^\2\2\u01ad\u01ae\7d\2\2\u01ae\u01af\7g\2\2\u01af"+
		"\u01b0\7i\2\2\u01b0\u01b1\7k\2\2\u01b1\u01b2\7p\2\2\u01b2\u01b3\7}\2\2"+
		"\u01b3\u01b4\7|\2\2\u01b4\u01b5\7g\2\2\u01b5\u01b6\7f\2\2\u01b6\u01b7"+
		"\7\177\2\2\u01b7n\3\2\2\2\u01b8\u01b9\7^\2\2\u01b9\u01ba\7p\2\2\u01ba"+
		"\u01bb\7w\2\2\u01bb\u01bc\7o\2\2\u01bcp\3\2\2\2\u01bd\u01be\7?\2\2\u01be"+
		"\u01bf\7?\2\2\u01bfr\3\2\2\2\u01c0\u01c1\7^\2\2\u01c1\u01c2\7o\2\2\u01c2"+
		"\u01c3\7c\2\2\u01c3\u01c4\7r\2\2\u01c4\u01c5\7u\2\2\u01c5\u01c6\7v\2\2"+
		"\u01c6\u01c7\7q\2\2\u01c7t\3\2\2\2\u01c8\u01ce\t\2\2\2\u01c9\u01ca\7^"+
		"\2\2\u01ca\u01cb\7a\2\2\u01cb\u01ce\7\"\2\2\u01cc\u01ce\7A\2\2\u01cd\u01c8"+
		"\3\2\2\2\u01cd\u01c9\3\2\2\2\u01cd\u01cc\3\2\2\2\u01ce\u01cf\3\2\2\2\u01cf"+
		"\u01cd\3\2\2\2\u01cf\u01d0\3\2\2\2\u01d0\u01d8\3\2\2\2\u01d1\u01d7\t\3"+
		"\2\2\u01d2\u01d3\7^\2\2\u01d3\u01d4\7a\2\2\u01d4\u01d7\7\"\2\2\u01d5\u01d7"+
		"\t\4\2\2\u01d6\u01d1\3\2\2\2\u01d6\u01d2\3\2\2\2\u01d6\u01d5\3\2\2\2\u01d7"+
		"\u01da\3\2\2\2\u01d8\u01d6\3\2\2\2\u01d8\u01d9\3\2\2\2\u01d9v\3\2\2\2"+
		"\u01da\u01d8\3\2\2\2\u01db\u01dd\4\62;\2\u01dc\u01db\3\2\2\2\u01dd\u01de"+
		"\3\2\2\2\u01de\u01dc\3\2\2\2\u01de\u01df\3\2\2\2\u01dfx\3\2\2\2\u01e0"+
		"\u01f3\t\5\2\2\u01e1\u01e2\7^\2\2\u01e2\u01e3\7e\2\2\u01e3\u01e4\7w\2"+
		"\2\u01e4\u01f3\7r\2\2\u01e5\u01e6\7^\2\2\u01e6\u01e7\7u\2\2\u01e7\u01e8"+
		"\7g\2\2\u01e8\u01e9\7v\2\2\u01e9\u01ea\7o\2\2\u01ea\u01eb\7k\2\2\u01eb"+
		"\u01ec\7p\2\2\u01ec\u01ed\7w\2\2\u01ed\u01f3\7u\2\2\u01ee\u01ef\7^\2\2"+
		"\u01ef\u01f0\7e\2\2\u01f0\u01f1\7c\2\2\u01f1\u01f3\7v\2\2\u01f2\u01e0"+
		"\3\2\2\2\u01f2\u01e1\3\2\2\2\u01f2\u01e5\3\2\2\2\u01f2\u01ee\3\2\2\2\u01f3"+
		"z\3\2\2\2\u01f4\u021b\7,\2\2\u01f5\u01f6\7^\2\2\u01f6\u01f7\7f\2\2\u01f7"+
		"\u01f8\7k\2\2\u01f8\u021b\7x\2\2\u01f9\u01fa\7^\2\2\u01fa\u01fb\7o\2\2"+
		"\u01fb\u01fc\7q\2\2\u01fc\u021b\7f\2\2\u01fd\u01fe\7^\2\2\u01fe\u01ff"+
		"\7e\2\2\u01ff\u0200\7c\2\2\u0200\u021b\7r\2\2\u0201\u0202\7^\2\2\u0202"+
		"\u0203\7e\2\2\u0203\u0204\7q\2\2\u0204\u0205\7o\2\2\u0205\u021b\7r\2\2"+
		"\u0206\u0207\7^\2\2\u0207\u0208\7e\2\2\u0208\u0209\7k\2\2\u0209\u020a"+
		"\7t\2\2\u020a\u021b\7e\2\2\u020b\u020c\7^\2\2\u020c\u020d\7g\2\2\u020d"+
		"\u020e\7z\2\2\u020e\u020f\7v\2\2\u020f\u0210\7t\2\2\u0210\u0211\7c\2\2"+
		"\u0211\u0212\7e\2\2\u0212\u021b\7v\2\2\u0213\u0214\7^\2\2\u0214\u0215"+
		"\7h\2\2\u0215\u0216\7k\2\2\u0216\u0217\7n\2\2\u0217\u0218\7v\2\2\u0218"+
		"\u0219\7g\2\2\u0219\u021b\7t\2\2\u021a\u01f4\3\2\2\2\u021a\u01f5\3\2\2"+
		"\2\u021a\u01f9\3\2\2\2\u021a\u01fd\3\2\2\2\u021a\u0201\3\2\2\2\u021a\u0206"+
		"\3\2\2\2\u021a\u020b\3\2\2\2\u021a\u0213\3\2\2\2\u021b|\3\2\2\2\u021c"+
		"\u021d\7^\2\2\u021d\u021e\7q\2\2\u021e\u021f\7r\2\2\u021f\u0220\7n\2\2"+
		"\u0220\u0221\7w\2\2\u0221\u0222\7u\2\2\u0222~\3\2\2\2\u0223\u0224\7^\2"+
		"\2\u0224\u0225\7f\2\2\u0225\u0226\7t\2\2\u0226\u0227\7g\2\2\u0227\u023a"+
		"\7u\2\2\u0228\u0229\7^\2\2\u0229\u022a\7t\2\2\u022a\u022b\7t\2\2\u022b"+
		"\u022c\7g\2\2\u022c\u023a\7u\2\2\u022d\u022e\7^\2\2\u022e\u022f\7p\2\2"+
		"\u022f\u0230\7f\2\2\u0230\u0231\7t\2\2\u0231\u0232\7g\2\2\u0232\u023a"+
		"\7u\2\2\u0233\u0234\7^\2\2\u0234\u0235\7p\2\2\u0235\u0236\7t\2\2\u0236"+
		"\u0237\7t\2\2\u0237\u0238\7g\2\2\u0238\u023a\7u\2\2\u0239\u0223\3\2\2"+
		"\2\u0239\u0228\3\2\2\2\u0239\u022d\3\2\2\2\u0239\u0233\3\2\2\2\u023a\u0080"+
		"\3\2\2\2\u023b\u023c\7^\2\2\u023c\u023d\7k\2\2\u023d\u023e\7p\2\2\u023e"+
		"\u023f\7x\2\2\u023f\u0082\3\2\2\2\u0240\u0241\7^\2\2\u0241\u0242\7t\2"+
		"\2\u0242\u0243\7c\2\2\u0243\u025d\7p\2\2\u0244\u0245\7^\2\2\u0245\u0246"+
		"\7f\2\2\u0246\u0247\7q\2\2\u0247\u025d\7o\2\2\u0248\u0249\7^\2\2\u0249"+
		"\u024a\7u\2\2\u024a\u024b\7g\2\2\u024b\u025d\7s\2\2\u024c\u024d\7^\2\2"+
		"\u024d\u025d\7%\2\2\u024e\u024f\7^\2\2\u024f\u0250\7d\2\2\u0250\u0251"+
		"\7k\2\2\u0251\u0252\7i\2\2\u0252\u0253\7e\2\2\u0253\u0254\7w\2\2\u0254"+
		"\u025d\7r\2\2\u0255\u0256\7^\2\2\u0256\u0257\7d\2\2\u0257\u0258\7k\2\2"+
		"\u0258\u0259\7i\2\2\u0259\u025a\7e\2\2\u025a\u025b\7w\2\2\u025b\u025d"+
		"\7r\2\2\u025c\u0240\3\2\2\2\u025c\u0244\3\2\2\2\u025c\u0248\3\2\2\2\u025c"+
		"\u024c\3\2\2\2\u025c\u024e\3\2\2\2\u025c\u0255\3\2\2\2\u025d\u0084\3\2"+
		"\2\2\u025e\u025f\7\u0080\2\2\u025f\u0086\3\2\2\2\u0260\u0262\7\17\2\2"+
		"\u0261\u0260\3\2\2\2\u0261\u0262\3\2\2\2\u0262\u0263\3\2\2\2\u0263\u0264"+
		"\7\f\2\2\u0264\u0088\3\2\2\2\u0265\u0267\t\6\2\2\u0266\u0265\3\2\2\2\u0267"+
		"\u0268\3\2\2\2\u0268\u0266\3\2\2\2\u0268\u0269\3\2\2\2\u0269\u026a\3\2"+
		"\2\2\u026a\u026b\bE\2\2\u026b\u008a\3\2\2\2\u026c\u026d\7^\2\2\u026d\u026e"+
		"\7}\2\2\u026e\u008c\3\2\2\2\u026f\u0270\7^\2\2\u0270\u0271\7\177\2\2\u0271"+
		"\u008e\3\2\2\2\u0272\u0273\7^\2\2\u0273\u0274\7n\2\2\u0274\u0275\7c\2"+
		"\2\u0275\u0276\7p\2\2\u0276\u0277\7i\2\2\u0277\u0278\7n\2\2\u0278\u0279"+
		"\7g\2\2\u0279\u0090\3\2\2\2\u027a\u027b\7^\2\2\u027b\u027c\7t\2\2\u027c"+
		"\u027d\7c\2\2\u027d\u027e\7p\2\2\u027e\u027f\7i\2\2\u027f\u0280\7n\2\2"+
		"\u0280\u0281\7g\2\2\u0281\u0092\3\2\2\2\u0282\u0283\7^\2\2\u0283\u0284"+
		"\7n\2\2\u0284\u0285\7k\2\2\u0285\u0286\7o\2\2\u0286\u0287\7i\2\2\u0287"+
		"\u0094\3\2\2\2\u0288\u0289\7^\2\2\u0289\u028a\7t\2\2\u028a\u028b\7k\2"+
		"\2\u028b\u028c\7o\2\2\u028c\u028d\7i\2\2\u028d\u0096\3\2\2\2\u028e\u028f"+
		"\7^\2\2\u028f\u0290\7^\2\2\u0290\u0291\bL\3\2\u0291\u0098\3\2\2\2\16\2"+
		"\u01cd\u01cf\u01d6\u01d8\u01de\u01f2\u021a\u0239\u025c\u0261\u0268";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}