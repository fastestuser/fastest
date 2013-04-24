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
		T__60=1, T__59=2, T__58=3, T__57=4, T__56=5, T__55=6, T__54=7, T__53=8, 
		T__52=9, T__51=10, T__50=11, T__49=12, T__48=13, T__47=14, T__46=15, T__45=16, 
		T__44=17, T__43=18, T__42=19, T__41=20, T__40=21, T__39=22, T__38=23, 
		T__37=24, T__36=25, T__35=26, T__34=27, T__33=28, T__32=29, T__31=30, 
		T__30=31, T__29=32, T__28=33, T__27=34, T__26=35, T__25=36, T__24=37, 
		T__23=38, T__22=39, T__21=40, T__20=41, T__19=42, T__18=43, T__17=44, 
		T__16=45, T__15=46, T__14=47, T__13=48, T__12=49, T__11=50, T__10=51, 
		T__9=52, T__8=53, T__7=54, T__6=55, T__5=56, T__4=57, T__3=58, T__2=59, 
		T__1=60, T__0=61, NAME=62, NUM=63, IN_FUN_P3=64, IN_FUN_P4=65, IN_FUN_P5=66, 
		IN_FUN_P6=67, POST_FUN=68, IN_GEN=69, DECORATION=70, NL=71, WS=72, SETSTART=73, 
		SETEND=74, LISTSTART=75, LISTEND=76, IMGSTART=77, IMGEND=78, SKIP=79;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'schema'", "'\\lnot'", "'\\#'", "'rev'", "'min'", "'['", "'<'", "'false'", 
		"'_{1}'", "'\\dom'", "'\\emptyset'", "'\\upto'", "'tail'", "'}'", "'\\notin'", 
		"'max'", "'\\land'", "')'", "'@'", "'\\seq'", "'head'", "'='", "'\\leq'", 
		"'\\prefix'", "'squash'", "'\\nat'", "'\\neq'", "'\\where'", "'\\geq'", 
		"'\\bigcup'", "'::='", "'\\subseteq'", "'|'", "'\\end{'", "'\\suffix'", 
		"']'", "'last'", "','", "'}{'", "'('", "':'", "'\\lor'", "'\\end{zed}'", 
		"'\\ran'", "'\\in'", "'\\cross'", "'true'", "'\\begin{'", "'\\subset'", 
		"'\\power'", "'.'", "'\\iff'", "'schemaType'", "'\\implies'", "';'", "'front'", 
		"'>'", "'\\begin{zed}'", "'\\num'", "'=='", "'\\mapsto'", "NAME", "NUM", 
		"IN_FUN_P3", "IN_FUN_P4", "IN_FUN_P5", "IN_FUN_P6", "'\\inv'", "IN_GEN", 
		"'~'", "NL", "WS", "'\\{'", "'\\}'", "'\\langle'", "'\\rangle'", "'\\limg'", 
		"'\\rimg'", "SKIP"
	};
	public static final String[] ruleNames = {
		"T__60", "T__59", "T__58", "T__57", "T__56", "T__55", "T__54", "T__53", 
		"T__52", "T__51", "T__50", "T__49", "T__48", "T__47", "T__46", "T__45", 
		"T__44", "T__43", "T__42", "T__41", "T__40", "T__39", "T__38", "T__37", 
		"T__36", "T__35", "T__34", "T__33", "T__32", "T__31", "T__30", "T__29", 
		"T__28", "T__27", "T__26", "T__25", "T__24", "T__23", "T__22", "T__21", 
		"T__20", "T__19", "T__18", "T__17", "T__16", "T__15", "T__14", "T__13", 
		"T__12", "T__11", "T__10", "T__9", "T__8", "T__7", "T__6", "T__5", "T__4", 
		"T__3", "T__2", "T__1", "T__0", "NAME", "NUM", "IN_FUN_P3", "IN_FUN_P4", 
		"IN_FUN_P5", "IN_FUN_P6", "POST_FUN", "IN_GEN", "DECORATION", "NL", "WS", 
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
		HashMap<String,String> types = new HashMap<String,String>();  //En types se guarda informacion sobre los tipos definidos
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
		
		//Metodo para la determinacion del tipo mas externo.
		String getType(String type) {
			//El calculo se realiza mediante la construccion del arbol de tipos con la gramatica TypeManager
			ANTLRInputStream input = new ANTLRInputStream(type);
	        TypeManagerLexer lexer = new TypeManagerLexer(input);
	        CommonTokenStream tokens = new CommonTokenStream(lexer);
	        TypeManagerParser parser = new TypeManagerParser(tokens);
	        parser.typeManage();
	        DefaultMutableTreeNode root = parser.getRoot();
	        
	        //Elimino parentesis externos
	        while (((String) root.getUserObject()).equals("()")) {
	        	root = (DefaultMutableTreeNode) root.getChildAt(0);
	        }
	        
	        return (String) root.getUserObject();
		}
		
		//Metodo para la determinacion del tipo de salida o entrada de una funcion.
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
		
		//Metodo para realizar la inversion de un tipo en Z, debe ser una funcion o un \power de \cross.
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
		
		//Metodo para obtener los tipos izquierdo y derecho.
		//Debe ser una funcion, un \power de \cross o una \seq
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
				else if (type.equals("\\nat") || type.equals("\\num") || type.equals("\\nat_{1}"))
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
		case 71: WS_action((RuleContext)_localctx, actionIndex); break;

		case 78: SKIP_action((RuleContext)_localctx, actionIndex); break;
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
		"\2\4Q\u02a1\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t"+
		"\b\4\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20"+
		"\t\20\4\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27"+
		"\t\27\4\30\t\30\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36"+
		"\t\36\4\37\t\37\4 \t \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4"+
		"(\t(\4)\t)\4*\t*\4+\t+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62"+
		"\t\62\4\63\t\63\4\64\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4"+
		":\t:\4;\t;\4<\t<\4=\t=\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\t"+
		"E\4F\tF\4G\tG\4H\tH\4I\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\5\3\5"+
		"\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3"+
		"\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\17\3\17"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\26\3\26"+
		"\3\26\3\26\3\26\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33"+
		"\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35"+
		"\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3 \3"+
		" \3 \3 \3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3\"\3\"\3#\3#\3#\3#\3#\3#\3$\3$"+
		"\3$\3$\3$\3$\3$\3$\3%\3%\3&\3&\3&\3&\3&\3\'\3\'\3(\3(\3(\3)\3)\3*\3*\3"+
		"+\3+\3+\3+\3+\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3-\3-\3-\3-\3-\3.\3.\3.\3"+
		".\3/\3/\3/\3/\3/\3/\3/\3\60\3\60\3\60\3\60\3\60\3\61\3\61\3\61\3\61\3"+
		"\61\3\61\3\61\3\61\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\63\3\63\3"+
		"\63\3\63\3\63\3\63\3\63\3\64\3\64\3\65\3\65\3\65\3\65\3\65\3\66\3\66\3"+
		"\66\3\66\3\66\3\66\3\66\3\66\3\66\3\66\3\66\3\67\3\67\3\67\3\67\3\67\3"+
		"\67\3\67\3\67\3\67\38\38\39\39\39\39\39\39\3:\3:\3;\3;\3;\3;\3;\3;\3;"+
		"\3;\3;\3;\3;\3;\3<\3<\3<\3<\3<\3=\3=\3=\3>\3>\3>\3>\3>\3>\3>\3>\3?\3?"+
		"\3?\3?\3?\6?\u01e7\n?\r?\16?\u01e8\3?\3?\3?\3?\3?\7?\u01f0\n?\f?\16?\u01f3"+
		"\13?\3@\6@\u01f6\n@\r@\16@\u01f7\3A\3A\3A\3A\3A\3A\3A\3A\3A\3A\3A\3A\3"+
		"A\3A\3A\3A\3A\3A\5A\u020c\nA\3B\3B\3B\3B\3B\3B\3B\3B\3B\3B\3B\3B\3B\3"+
		"B\3B\3B\3B\3B\3B\3B\3B\3B\3B\3B\3B\3B\3B\3B\3B\3B\3B\3B\3B\3B\3B\3B\3"+
		"B\3B\5B\u0234\nB\3C\3C\3C\3C\3C\3C\3C\3D\3D\3D\3D\3D\3D\3D\3D\3D\3D\3"+
		"D\3D\3D\3D\3D\3D\3D\3D\3D\3D\3D\3D\5D\u0253\nD\3E\3E\3E\3E\3E\3F\3F\3"+
		"F\3F\3F\3F\3F\3F\3F\3F\3F\3F\3F\3F\3F\3F\3F\3F\5F\u026c\nF\3G\3G\3H\5"+
		"H\u0271\nH\3H\3H\3I\6I\u0276\nI\rI\16I\u0277\3I\3I\3J\3J\3J\3K\3K\3K\3"+
		"L\3L\3L\3L\3L\3L\3L\3L\3M\3M\3M\3M\3M\3M\3M\3M\3N\3N\3N\3N\3N\3N\3O\3"+
		"O\3O\3O\3O\3O\3P\3P\3P\3P\2Q\3\3\1\5\4\1\7\5\1\t\6\1\13\7\1\r\b\1\17\t"+
		"\1\21\n\1\23\13\1\25\f\1\27\r\1\31\16\1\33\17\1\35\20\1\37\21\1!\22\1"+
		"#\23\1%\24\1\'\25\1)\26\1+\27\1-\30\1/\31\1\61\32\1\63\33\1\65\34\1\67"+
		"\35\19\36\1;\37\1= \1?!\1A\"\1C#\1E$\1G%\1I&\1K\'\1M(\1O)\1Q*\1S+\1U,"+
		"\1W-\1Y.\1[/\1]\60\1_\61\1a\62\1c\63\1e\64\1g\65\1i\66\1k\67\1m8\1o9\1"+
		"q:\1s;\1u<\1w=\1y>\1{?\1}@\1\177A\1\u0081B\1\u0083C\1\u0085D\1\u0087E"+
		"\1\u0089F\1\u008bG\1\u008dH\1\u008fI\1\u0091J\2\u0093K\1\u0095L\1\u0097"+
		"M\1\u0099N\1\u009bO\1\u009dP\1\u009fQ\3\3\2\7\4C\\c|\4C\\c|\4\62;AA\4"+
		"--//\5\13\13\17\17\"\"\u02b9\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3"+
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
		"\3\2\2\2\2\u0095\3\2\2\2\2\u0097\3\2\2\2\2\u0099\3\2\2\2\2\u009b\3\2\2"+
		"\2\2\u009d\3\2\2\2\2\u009f\3\2\2\2\3\u00a1\3\2\2\2\5\u00a8\3\2\2\2\7\u00ae"+
		"\3\2\2\2\t\u00b1\3\2\2\2\13\u00b5\3\2\2\2\r\u00b9\3\2\2\2\17\u00bb\3\2"+
		"\2\2\21\u00bd\3\2\2\2\23\u00c3\3\2\2\2\25\u00c8\3\2\2\2\27\u00cd\3\2\2"+
		"\2\31\u00d7\3\2\2\2\33\u00dd\3\2\2\2\35\u00e2\3\2\2\2\37\u00e4\3\2\2\2"+
		"!\u00eb\3\2\2\2#\u00ef\3\2\2\2%\u00f5\3\2\2\2\'\u00f7\3\2\2\2)\u00f9\3"+
		"\2\2\2+\u00fe\3\2\2\2-\u0103\3\2\2\2/\u0105\3\2\2\2\61\u010a\3\2\2\2\63"+
		"\u0112\3\2\2\2\65\u0119\3\2\2\2\67\u011e\3\2\2\29\u0123\3\2\2\2;\u012a"+
		"\3\2\2\2=\u012f\3\2\2\2?\u0137\3\2\2\2A\u013b\3\2\2\2C\u0145\3\2\2\2E"+
		"\u0147\3\2\2\2G\u014d\3\2\2\2I\u0155\3\2\2\2K\u0157\3\2\2\2M\u015c\3\2"+
		"\2\2O\u015e\3\2\2\2Q\u0161\3\2\2\2S\u0163\3\2\2\2U\u0165\3\2\2\2W\u016a"+
		"\3\2\2\2Y\u0174\3\2\2\2[\u0179\3\2\2\2]\u017d\3\2\2\2_\u0184\3\2\2\2a"+
		"\u0189\3\2\2\2c\u0191\3\2\2\2e\u0199\3\2\2\2g\u01a0\3\2\2\2i\u01a2\3\2"+
		"\2\2k\u01a7\3\2\2\2m\u01b2\3\2\2\2o\u01bb\3\2\2\2q\u01bd\3\2\2\2s\u01c3"+
		"\3\2\2\2u\u01c5\3\2\2\2w\u01d1\3\2\2\2y\u01d6\3\2\2\2{\u01d9\3\2\2\2}"+
		"\u01e6\3\2\2\2\177\u01f5\3\2\2\2\u0081\u020b\3\2\2\2\u0083\u0233\3\2\2"+
		"\2\u0085\u0235\3\2\2\2\u0087\u0252\3\2\2\2\u0089\u0254\3\2\2\2\u008b\u026b"+
		"\3\2\2\2\u008d\u026d\3\2\2\2\u008f\u0270\3\2\2\2\u0091\u0275\3\2\2\2\u0093"+
		"\u027b\3\2\2\2\u0095\u027e\3\2\2\2\u0097\u0281\3\2\2\2\u0099\u0289\3\2"+
		"\2\2\u009b\u0291\3\2\2\2\u009d\u0297\3\2\2\2\u009f\u029d\3\2\2\2\u00a1"+
		"\u00a2\7u\2\2\u00a2\u00a3\7e\2\2\u00a3\u00a4\7j\2\2\u00a4\u00a5\7g\2\2"+
		"\u00a5\u00a6\7o\2\2\u00a6\u00a7\7c\2\2\u00a7\4\3\2\2\2\u00a8\u00a9\7^"+
		"\2\2\u00a9\u00aa\7n\2\2\u00aa\u00ab\7p\2\2\u00ab\u00ac\7q\2\2\u00ac\u00ad"+
		"\7v\2\2\u00ad\6\3\2\2\2\u00ae\u00af\7^\2\2\u00af\u00b0\7%\2\2\u00b0\b"+
		"\3\2\2\2\u00b1\u00b2\7t\2\2\u00b2\u00b3\7g\2\2\u00b3\u00b4\7x\2\2\u00b4"+
		"\n\3\2\2\2\u00b5\u00b6\7o\2\2\u00b6\u00b7\7k\2\2\u00b7\u00b8\7p\2\2\u00b8"+
		"\f\3\2\2\2\u00b9\u00ba\7]\2\2\u00ba\16\3\2\2\2\u00bb\u00bc\7>\2\2\u00bc"+
		"\20\3\2\2\2\u00bd\u00be\7h\2\2\u00be\u00bf\7c\2\2\u00bf\u00c0\7n\2\2\u00c0"+
		"\u00c1\7u\2\2\u00c1\u00c2\7g\2\2\u00c2\22\3\2\2\2\u00c3\u00c4\7a\2\2\u00c4"+
		"\u00c5\7}\2\2\u00c5\u00c6\7\63\2\2\u00c6\u00c7\7\177\2\2\u00c7\24\3\2"+
		"\2\2\u00c8\u00c9\7^\2\2\u00c9\u00ca\7f\2\2\u00ca\u00cb\7q\2\2\u00cb\u00cc"+
		"\7o\2\2\u00cc\26\3\2\2\2\u00cd\u00ce\7^\2\2\u00ce\u00cf\7g\2\2\u00cf\u00d0"+
		"\7o\2\2\u00d0\u00d1\7r\2\2\u00d1\u00d2\7v\2\2\u00d2\u00d3\7{\2\2\u00d3"+
		"\u00d4\7u\2\2\u00d4\u00d5\7g\2\2\u00d5\u00d6\7v\2\2\u00d6\30\3\2\2\2\u00d7"+
		"\u00d8\7^\2\2\u00d8\u00d9\7w\2\2\u00d9\u00da\7r\2\2\u00da\u00db\7v\2\2"+
		"\u00db\u00dc\7q\2\2\u00dc\32\3\2\2\2\u00dd\u00de\7v\2\2\u00de\u00df\7"+
		"c\2\2\u00df\u00e0\7k\2\2\u00e0\u00e1\7n\2\2\u00e1\34\3\2\2\2\u00e2\u00e3"+
		"\7\177\2\2\u00e3\36\3\2\2\2\u00e4\u00e5\7^\2\2\u00e5\u00e6\7p\2\2\u00e6"+
		"\u00e7\7q\2\2\u00e7\u00e8\7v\2\2\u00e8\u00e9\7k\2\2\u00e9\u00ea\7p\2\2"+
		"\u00ea \3\2\2\2\u00eb\u00ec\7o\2\2\u00ec\u00ed\7c\2\2\u00ed\u00ee\7z\2"+
		"\2\u00ee\"\3\2\2\2\u00ef\u00f0\7^\2\2\u00f0\u00f1\7n\2\2\u00f1\u00f2\7"+
		"c\2\2\u00f2\u00f3\7p\2\2\u00f3\u00f4\7f\2\2\u00f4$\3\2\2\2\u00f5\u00f6"+
		"\7+\2\2\u00f6&\3\2\2\2\u00f7\u00f8\7B\2\2\u00f8(\3\2\2\2\u00f9\u00fa\7"+
		"^\2\2\u00fa\u00fb\7u\2\2\u00fb\u00fc\7g\2\2\u00fc\u00fd\7s\2\2\u00fd*"+
		"\3\2\2\2\u00fe\u00ff\7j\2\2\u00ff\u0100\7g\2\2\u0100\u0101\7c\2\2\u0101"+
		"\u0102\7f\2\2\u0102,\3\2\2\2\u0103\u0104\7?\2\2\u0104.\3\2\2\2\u0105\u0106"+
		"\7^\2\2\u0106\u0107\7n\2\2\u0107\u0108\7g\2\2\u0108\u0109\7s\2\2\u0109"+
		"\60\3\2\2\2\u010a\u010b\7^\2\2\u010b\u010c\7r\2\2\u010c\u010d\7t\2\2\u010d"+
		"\u010e\7g\2\2\u010e\u010f\7h\2\2\u010f\u0110\7k\2\2\u0110\u0111\7z\2\2"+
		"\u0111\62\3\2\2\2\u0112\u0113\7u\2\2\u0113\u0114\7s\2\2\u0114\u0115\7"+
		"w\2\2\u0115\u0116\7c\2\2\u0116\u0117\7u\2\2\u0117\u0118\7j\2\2\u0118\64"+
		"\3\2\2\2\u0119\u011a\7^\2\2\u011a\u011b\7p\2\2\u011b\u011c\7c\2\2\u011c"+
		"\u011d\7v\2\2\u011d\66\3\2\2\2\u011e\u011f\7^\2\2\u011f\u0120\7p\2\2\u0120"+
		"\u0121\7g\2\2\u0121\u0122\7s\2\2\u01228\3\2\2\2\u0123\u0124\7^\2\2\u0124"+
		"\u0125\7y\2\2\u0125\u0126\7j\2\2\u0126\u0127\7g\2\2\u0127\u0128\7t\2\2"+
		"\u0128\u0129\7g\2\2\u0129:\3\2\2\2\u012a\u012b\7^\2\2\u012b\u012c\7i\2"+
		"\2\u012c\u012d\7g\2\2\u012d\u012e\7s\2\2\u012e<\3\2\2\2\u012f\u0130\7"+
		"^\2\2\u0130\u0131\7d\2\2\u0131\u0132\7k\2\2\u0132\u0133\7i\2\2\u0133\u0134"+
		"\7e\2\2\u0134\u0135\7w\2\2\u0135\u0136\7r\2\2\u0136>\3\2\2\2\u0137\u0138"+
		"\7<\2\2\u0138\u0139\7<\2\2\u0139\u013a\7?\2\2\u013a@\3\2\2\2\u013b\u013c"+
		"\7^\2\2\u013c\u013d\7u\2\2\u013d\u013e\7w\2\2\u013e\u013f\7d\2\2\u013f"+
		"\u0140\7u\2\2\u0140\u0141\7g\2\2\u0141\u0142\7v\2\2\u0142\u0143\7g\2\2"+
		"\u0143\u0144\7s\2\2\u0144B\3\2\2\2\u0145\u0146\7~\2\2\u0146D\3\2\2\2\u0147"+
		"\u0148\7^\2\2\u0148\u0149\7g\2\2\u0149\u014a\7p\2\2\u014a\u014b\7f\2\2"+
		"\u014b\u014c\7}\2\2\u014cF\3\2\2\2\u014d\u014e\7^\2\2\u014e\u014f\7u\2"+
		"\2\u014f\u0150\7w\2\2\u0150\u0151\7h\2\2\u0151\u0152\7h\2\2\u0152\u0153"+
		"\7k\2\2\u0153\u0154\7z\2\2\u0154H\3\2\2\2\u0155\u0156\7_\2\2\u0156J\3"+
		"\2\2\2\u0157\u0158\7n\2\2\u0158\u0159\7c\2\2\u0159\u015a\7u\2\2\u015a"+
		"\u015b\7v\2\2\u015bL\3\2\2\2\u015c\u015d\7.\2\2\u015dN\3\2\2\2\u015e\u015f"+
		"\7\177\2\2\u015f\u0160\7}\2\2\u0160P\3\2\2\2\u0161\u0162\7*\2\2\u0162"+
		"R\3\2\2\2\u0163\u0164\7<\2\2\u0164T\3\2\2\2\u0165\u0166\7^\2\2\u0166\u0167"+
		"\7n\2\2\u0167\u0168\7q\2\2\u0168\u0169\7t\2\2\u0169V\3\2\2\2\u016a\u016b"+
		"\7^\2\2\u016b\u016c\7g\2\2\u016c\u016d\7p\2\2\u016d\u016e\7f\2\2\u016e"+
		"\u016f\7}\2\2\u016f\u0170\7|\2\2\u0170\u0171\7g\2\2\u0171\u0172\7f\2\2"+
		"\u0172\u0173\7\177\2\2\u0173X\3\2\2\2\u0174\u0175\7^\2\2\u0175\u0176\7"+
		"t\2\2\u0176\u0177\7c\2\2\u0177\u0178\7p\2\2\u0178Z\3\2\2\2\u0179\u017a"+
		"\7^\2\2\u017a\u017b\7k\2\2\u017b\u017c\7p\2\2\u017c\\\3\2\2\2\u017d\u017e"+
		"\7^\2\2\u017e\u017f\7e\2\2\u017f\u0180\7t\2\2\u0180\u0181\7q\2\2\u0181"+
		"\u0182\7u\2\2\u0182\u0183\7u\2\2\u0183^\3\2\2\2\u0184\u0185\7v\2\2\u0185"+
		"\u0186\7t\2\2\u0186\u0187\7w\2\2\u0187\u0188\7g\2\2\u0188`\3\2\2\2\u0189"+
		"\u018a\7^\2\2\u018a\u018b\7d\2\2\u018b\u018c\7g\2\2\u018c\u018d\7i\2\2"+
		"\u018d\u018e\7k\2\2\u018e\u018f\7p\2\2\u018f\u0190\7}\2\2\u0190b\3\2\2"+
		"\2\u0191\u0192\7^\2\2\u0192\u0193\7u\2\2\u0193\u0194\7w\2\2\u0194\u0195"+
		"\7d\2\2\u0195\u0196\7u\2\2\u0196\u0197\7g\2\2\u0197\u0198\7v\2\2\u0198"+
		"d\3\2\2\2\u0199\u019a\7^\2\2\u019a\u019b\7r\2\2\u019b\u019c\7q\2\2\u019c"+
		"\u019d\7y\2\2\u019d\u019e\7g\2\2\u019e\u019f\7t\2\2\u019ff\3\2\2\2\u01a0"+
		"\u01a1\7\60\2\2\u01a1h\3\2\2\2\u01a2\u01a3\7^\2\2\u01a3\u01a4\7k\2\2\u01a4"+
		"\u01a5\7h\2\2\u01a5\u01a6\7h\2\2\u01a6j\3\2\2\2\u01a7\u01a8\7u\2\2\u01a8"+
		"\u01a9\7e\2\2\u01a9\u01aa\7j\2\2\u01aa\u01ab\7g\2\2\u01ab\u01ac\7o\2\2"+
		"\u01ac\u01ad\7c\2\2\u01ad\u01ae\7V\2\2\u01ae\u01af\7{\2\2\u01af\u01b0"+
		"\7r\2\2\u01b0\u01b1\7g\2\2\u01b1l\3\2\2\2\u01b2\u01b3\7^\2\2\u01b3\u01b4"+
		"\7k\2\2\u01b4\u01b5\7o\2\2\u01b5\u01b6\7r\2\2\u01b6\u01b7\7n\2\2\u01b7"+
		"\u01b8\7k\2\2\u01b8\u01b9\7g\2\2\u01b9\u01ba\7u\2\2\u01ban\3\2\2\2\u01bb"+
		"\u01bc\7=\2\2\u01bcp\3\2\2\2\u01bd\u01be\7h\2\2\u01be\u01bf\7t\2\2\u01bf"+
		"\u01c0\7q\2\2\u01c0\u01c1\7p\2\2\u01c1\u01c2\7v\2\2\u01c2r\3\2\2\2\u01c3"+
		"\u01c4\7@\2\2\u01c4t\3\2\2\2\u01c5\u01c6\7^\2\2\u01c6\u01c7\7d\2\2\u01c7"+
		"\u01c8\7g\2\2\u01c8\u01c9\7i\2\2\u01c9\u01ca\7k\2\2\u01ca\u01cb\7p\2\2"+
		"\u01cb\u01cc\7}\2\2\u01cc\u01cd\7|\2\2\u01cd\u01ce\7g\2\2\u01ce\u01cf"+
		"\7f\2\2\u01cf\u01d0\7\177\2\2\u01d0v\3\2\2\2\u01d1\u01d2\7^\2\2\u01d2"+
		"\u01d3\7p\2\2\u01d3\u01d4\7w\2\2\u01d4\u01d5\7o\2\2\u01d5x\3\2\2\2\u01d6"+
		"\u01d7\7?\2\2\u01d7\u01d8\7?\2\2\u01d8z\3\2\2\2\u01d9\u01da\7^\2\2\u01da"+
		"\u01db\7o\2\2\u01db\u01dc\7c\2\2\u01dc\u01dd\7r\2\2\u01dd\u01de\7u\2\2"+
		"\u01de\u01df\7v\2\2\u01df\u01e0\7q\2\2\u01e0|\3\2\2\2\u01e1\u01e7\t\2"+
		"\2\2\u01e2\u01e3\7^\2\2\u01e3\u01e4\7a\2\2\u01e4\u01e7\7\"\2\2\u01e5\u01e7"+
		"\7A\2\2\u01e6\u01e1\3\2\2\2\u01e6\u01e2\3\2\2\2\u01e6\u01e5\3\2\2\2\u01e7"+
		"\u01e8\3\2\2\2\u01e8\u01e6\3\2\2\2\u01e8\u01e9\3\2\2\2\u01e9\u01f1\3\2"+
		"\2\2\u01ea\u01f0\t\3\2\2\u01eb\u01ec\7^\2\2\u01ec\u01ed\7a\2\2\u01ed\u01f0"+
		"\7\"\2\2\u01ee\u01f0\t\4\2\2\u01ef\u01ea\3\2\2\2\u01ef\u01eb\3\2\2\2\u01ef"+
		"\u01ee\3\2\2\2\u01f0\u01f3\3\2\2\2\u01f1\u01ef\3\2\2\2\u01f1\u01f2\3\2"+
		"\2\2\u01f2~\3\2\2\2\u01f3\u01f1\3\2\2\2\u01f4\u01f6\4\62;\2\u01f5\u01f4"+
		"\3\2\2\2\u01f6\u01f7\3\2\2\2\u01f7\u01f5\3\2\2\2\u01f7\u01f8\3\2\2\2\u01f8"+
		"\u0080\3\2\2\2\u01f9\u020c\t\5\2\2\u01fa\u01fb\7^\2\2\u01fb\u01fc\7e\2"+
		"\2\u01fc\u01fd\7w\2\2\u01fd\u020c\7r\2\2\u01fe\u01ff\7^\2\2\u01ff\u0200"+
		"\7u\2\2\u0200\u0201\7g\2\2\u0201\u0202\7v\2\2\u0202\u0203\7o\2\2\u0203"+
		"\u0204\7k\2\2\u0204\u0205\7p\2\2\u0205\u0206\7w\2\2\u0206\u020c\7u\2\2"+
		"\u0207\u0208\7^\2\2\u0208\u0209\7e\2\2\u0209\u020a\7c\2\2\u020a\u020c"+
		"\7v\2\2\u020b\u01f9\3\2\2\2\u020b\u01fa\3\2\2\2\u020b\u01fe\3\2\2\2\u020b"+
		"\u0207\3\2\2\2\u020c\u0082\3\2\2\2\u020d\u0234\7,\2\2\u020e\u020f\7^\2"+
		"\2\u020f\u0210\7f\2\2\u0210\u0211\7k\2\2\u0211\u0234\7x\2\2\u0212\u0213"+
		"\7^\2\2\u0213\u0214\7o\2\2\u0214\u0215\7q\2\2\u0215\u0234\7f\2\2\u0216"+
		"\u0217\7^\2\2\u0217\u0218\7e\2\2\u0218\u0219\7c\2\2\u0219\u0234\7r\2\2"+
		"\u021a\u021b\7^\2\2\u021b\u021c\7e\2\2\u021c\u021d\7q\2\2\u021d\u021e"+
		"\7o\2\2\u021e\u0234\7r\2\2\u021f\u0220\7^\2\2\u0220\u0221\7e\2\2\u0221"+
		"\u0222\7k\2\2\u0222\u0223\7t\2\2\u0223\u0234\7e\2\2\u0224\u0225\7^\2\2"+
		"\u0225\u0226\7g\2\2\u0226\u0227\7z\2\2\u0227\u0228\7v\2\2\u0228\u0229"+
		"\7t\2\2\u0229\u022a\7c\2\2\u022a\u022b\7e\2\2\u022b\u0234\7v\2\2\u022c"+
		"\u022d\7^\2\2\u022d\u022e\7h\2\2\u022e\u022f\7k\2\2\u022f\u0230\7n\2\2"+
		"\u0230\u0231\7v\2\2\u0231\u0232\7g\2\2\u0232\u0234\7t\2\2\u0233\u020d"+
		"\3\2\2\2\u0233\u020e\3\2\2\2\u0233\u0212\3\2\2\2\u0233\u0216\3\2\2\2\u0233"+
		"\u021a\3\2\2\2\u0233\u021f\3\2\2\2\u0233\u0224\3\2\2\2\u0233\u022c\3\2"+
		"\2\2\u0234\u0084\3\2\2\2\u0235\u0236\7^\2\2\u0236\u0237\7q\2\2\u0237\u0238"+
		"\7r\2\2\u0238\u0239\7n\2\2\u0239\u023a\7w\2\2\u023a\u023b\7u\2\2\u023b"+
		"\u0086\3\2\2\2\u023c\u023d\7^\2\2\u023d\u023e\7f\2\2\u023e\u023f\7t\2"+
		"\2\u023f\u0240\7g\2\2\u0240\u0253\7u\2\2\u0241\u0242\7^\2\2\u0242\u0243"+
		"\7t\2\2\u0243\u0244\7t\2\2\u0244\u0245\7g\2\2\u0245\u0253\7u\2\2\u0246"+
		"\u0247\7^\2\2\u0247\u0248\7p\2\2\u0248\u0249\7f\2\2\u0249\u024a\7t\2\2"+
		"\u024a\u024b\7g\2\2\u024b\u0253\7u\2\2\u024c\u024d\7^\2\2\u024d\u024e"+
		"\7p\2\2\u024e\u024f\7t\2\2\u024f\u0250\7t\2\2\u0250\u0251\7g\2\2\u0251"+
		"\u0253\7u\2\2\u0252\u023c\3\2\2\2\u0252\u0241\3\2\2\2\u0252\u0246\3\2"+
		"\2\2\u0252\u024c\3\2\2\2\u0253\u0088\3\2\2\2\u0254\u0255\7^\2\2\u0255"+
		"\u0256\7k\2\2\u0256\u0257\7p\2\2\u0257\u0258\7x\2\2\u0258\u008a\3\2\2"+
		"\2\u0259\u025a\7^\2\2\u025a\u025b\7t\2\2\u025b\u025c\7g\2\2\u025c\u026c"+
		"\7n\2\2\u025d\u025e\7^\2\2\u025e\u025f\7r\2\2\u025f\u0260\7h\2\2\u0260"+
		"\u0261\7w\2\2\u0261\u026c\7p\2\2\u0262\u0263\7^\2\2\u0263\u0264\7h\2\2"+
		"\u0264\u0265\7w\2\2\u0265\u026c\7p\2\2\u0266\u0267\7^\2\2\u0267\u0268"+
		"\7h\2\2\u0268\u0269\7h\2\2\u0269\u026a\7w\2\2\u026a\u026c\7p\2\2\u026b"+
		"\u0259\3\2\2\2\u026b\u025d\3\2\2\2\u026b\u0262\3\2\2\2\u026b\u0266\3\2"+
		"\2\2\u026c\u008c\3\2\2\2\u026d\u026e\7\u0080\2\2\u026e\u008e\3\2\2\2\u026f"+
		"\u0271\7\17\2\2\u0270\u026f\3\2\2\2\u0270\u0271\3\2\2\2\u0271\u0272\3"+
		"\2\2\2\u0272\u0273\7\f\2\2\u0273\u0090\3\2\2\2\u0274\u0276\t\6\2\2\u0275"+
		"\u0274\3\2\2\2\u0276\u0277\3\2\2\2\u0277\u0275\3\2\2\2\u0277\u0278\3\2"+
		"\2\2\u0278\u0279\3\2\2\2\u0279\u027a\bI\2\2\u027a\u0092\3\2\2\2\u027b"+
		"\u027c\7^\2\2\u027c\u027d\7}\2\2\u027d\u0094\3\2\2\2\u027e\u027f\7^\2"+
		"\2\u027f\u0280\7\177\2\2\u0280\u0096\3\2\2\2\u0281\u0282\7^\2\2\u0282"+
		"\u0283\7n\2\2\u0283\u0284\7c\2\2\u0284\u0285\7p\2\2\u0285\u0286\7i\2\2"+
		"\u0286\u0287\7n\2\2\u0287\u0288\7g\2\2\u0288\u0098\3\2\2\2\u0289\u028a"+
		"\7^\2\2\u028a\u028b\7t\2\2\u028b\u028c\7c\2\2\u028c\u028d\7p\2\2\u028d"+
		"\u028e\7i\2\2\u028e\u028f\7n\2\2\u028f\u0290\7g\2\2\u0290\u009a\3\2\2"+
		"\2\u0291\u0292\7^\2\2\u0292\u0293\7n\2\2\u0293\u0294\7k\2\2\u0294\u0295"+
		"\7o\2\2\u0295\u0296\7i\2\2\u0296\u009c\3\2\2\2\u0297\u0298\7^\2\2\u0298"+
		"\u0299\7t\2\2\u0299\u029a\7k\2\2\u029a\u029b\7o\2\2\u029b\u029c\7i\2\2"+
		"\u029c\u009e\3\2\2\2\u029d\u029e\7^\2\2\u029e\u029f\7^\2\2\u029f\u02a0"+
		"\bP\3\2\u02a0\u00a0\3\2\2\2\16\2\u01e6\u01e8\u01ef\u01f1\u01f7\u020b\u0233"+
		"\u0252\u026b\u0270\u0277";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}