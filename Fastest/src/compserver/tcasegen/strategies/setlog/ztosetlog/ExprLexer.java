// Generated from Expr.g4 by ANTLR 4.0

	package compserver.tcasegen.strategies.setlog.ztosetlog;
	import compserver.tcasegen.strategies.setlog.TypeManagerParser;
	import compserver.tcasegen.strategies.setlog.TypeManagerLexer;
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
		T__63=1, T__62=2, T__61=3, T__60=4, T__59=5, T__58=6, T__57=7, T__56=8, 
		T__55=9, T__54=10, T__53=11, T__52=12, T__51=13, T__50=14, T__49=15, T__48=16, 
		T__47=17, T__46=18, T__45=19, T__44=20, T__43=21, T__42=22, T__41=23, 
		T__40=24, T__39=25, T__38=26, T__37=27, T__36=28, T__35=29, T__34=30, 
		T__33=31, T__32=32, T__31=33, T__30=34, T__29=35, T__28=36, T__27=37, 
		T__26=38, T__25=39, T__24=40, T__23=41, T__22=42, T__21=43, T__20=44, 
		T__19=45, T__18=46, T__17=47, T__16=48, T__15=49, T__14=50, T__13=51, 
		T__12=52, T__11=53, T__10=54, T__9=55, T__8=56, T__7=57, T__6=58, T__5=59, 
		T__4=60, T__3=61, T__2=62, T__1=63, T__0=64, NAME=65, NUM=66, IN_FUN_P3=67, 
		IN_FUN_P4=68, IN_FUN_P5=69, IN_FUN_P6=70, IN_GEN=71, DECORATION=72, NL=73, 
		WS=74, SETSTART=75, SETEND=76, LISTSTART=77, LISTEND=78, IMGSTART=79, 
		IMGEND=80, SKIP=81;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'schema'", "'\\lnot'", "'\\#'", "'rev'", "'min'", "'['", "'<'", "'false'", 
		"'_{1}'", "'\\dom'", "'\\emptyset'", "'\\upto'", "'tail'", "'\\finset'", 
		"'}'", "'\\notin'", "'max'", "'\\land'", "')'", "'@'", "'\\seq'", "'head'", 
		"'='", "'\\leq'", "'\\prefix'", "'squash'", "'\\nat'", "'\\neq'", "'\\where'", 
		"'\\geq'", "'\\bigcup'", "'::='", "'\\subseteq'", "'|'", "'\\end{'", "'\\suffix'", 
		"']'", "'last'", "','", "'}{'", "'('", "':'", "'\\lor'", "'\\end{zed}'", 
		"'\\ran'", "'\\in'", "'seq_{1}'", "'\\inv'", "'\\cross'", "'true'", "'\\begin{'", 
		"'\\subset'", "'\\power'", "'.'", "'\\iff'", "'schemaType'", "'\\implies'", 
		"';'", "'front'", "'>'", "'\\begin{zed}'", "'\\num'", "'=='", "'\\mapsto'", 
		"NAME", "NUM", "IN_FUN_P3", "IN_FUN_P4", "IN_FUN_P5", "IN_FUN_P6", "IN_GEN", 
		"'~'", "NL", "WS", "'\\{'", "'\\}'", "'\\langle'", "'\\rangle'", "'\\limg'", 
		"'\\rimg'", "SKIP"
	};
	public static final String[] ruleNames = {
		"T__63", "T__62", "T__61", "T__60", "T__59", "T__58", "T__57", "T__56", 
		"T__55", "T__54", "T__53", "T__52", "T__51", "T__50", "T__49", "T__48", 
		"T__47", "T__46", "T__45", "T__44", "T__43", "T__42", "T__41", "T__40", 
		"T__39", "T__38", "T__37", "T__36", "T__35", "T__34", "T__33", "T__32", 
		"T__31", "T__30", "T__29", "T__28", "T__27", "T__26", "T__25", "T__24", 
		"T__23", "T__22", "T__21", "T__20", "T__19", "T__18", "T__17", "T__16", 
		"T__15", "T__14", "T__13", "T__12", "T__11", "T__10", "T__9", "T__8", 
		"T__7", "T__6", "T__5", "T__4", "T__3", "T__2", "T__1", "T__0", "NAME", 
		"NUM", "IN_FUN_P3", "IN_FUN_P4", "IN_FUN_P5", "IN_FUN_P6", "IN_GEN", "DECORATION", 
		"NL", "WS", "SETSTART", "SETEND", "LISTSTART", "LISTEND", "IMGSTART", 
		"IMGEND", "SKIP"
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
			if (modoSetExpression == 0 && tipoSchema == 0) { 
				System.out.println(c + " &");
				out = out.concat(c + " &");
			}
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
					invertedType = invertedType.concat(parser.printTree((DefaultMutableTreeNode) child.getChildAt(1)));
					invertedType = invertedType.concat("\\cross");
					invertedType = invertedType.concat(parser.printTree((DefaultMutableTreeNode) child.getChildAt(0)));
				}
				invertedType = invertedType.concat(")");
			
			} else { //Entonces empieza con pfun, rel etc
			
				invertedType = invertedType.concat(parser.printTree((DefaultMutableTreeNode) root.getChildAt(1)));
				invertedType = invertedType.concat(rootType);
				invertedType = invertedType.concat(parser.printTree((DefaultMutableTreeNode) root.getChildAt(0)));
			
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
					
					leftAndRight.add(parser.printTree(left));
					leftAndRight.add(parser.printTree(right));
				}
			
			}
			else if (isSequence(rootType)) { //Entonces empieza con pfun, rel etc

				leftAndRight.add("\\nat");
				right = (DefaultMutableTreeNode) root.getChildAt(0);
				while (((String) right.getUserObject()).equals("()"))
					right = (DefaultMutableTreeNode) right.getChildAt(0);
				leftAndRight.add(parser.printTree(right));

			}
			else { //Entonces empieza con pfun, rel etc

			left = (DefaultMutableTreeNode) root.getChildAt(0);
			while (((String) left.getUserObject()).equals("()"))
				left = (DefaultMutableTreeNode) left.getChildAt(0);
			right = (DefaultMutableTreeNode) root.getChildAt(1);
			while (((String) right.getUserObject()).equals("()"))
				right = (DefaultMutableTreeNode) right.getChildAt(0);
				
			leftAndRight.add(parser.printTree(left));
			leftAndRight.add(parser.printTree(right));
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
				
			if (type != null) {
				if (isBasic(type)) {
					if(type.startsWith("EnumerationType")) {
						type = type.split(":")[1];
						if (tipoSchema == 0) print(var + " in " + type);
					} else
						type = type.split(":")[1];
					return type;
				}
			
				String nodeType = getType(type);
				
				if (isSequence(nodeType)){
					if (tipoSchema == 0) {
						if (nodeType.equals("\\seq_{1}"))
							print(var + " neq []");
						printAtEnd("list(" + var + ")");
					}
				}
				else if (nodeType.equals("\\rel")) {
					if (tipoSchema == 0) printAtEnd("is_rel(" + var + ")");
				}
				else if (nodeType.equals("\\pfun")) {
					if (tipoSchema == 0) printAtEnd("is_pfun(" + var + ")");
				}
				else if (nodeType.equals("\\fun")) {
					if (tipoSchema == 0) printAtEnd("is_fun(" + var + ")");
				}
				else if (type.equals("\\nat") || type.equals("\\num") || type.equals("\\nat_{1}")) {
					if (tipoSchema == 0) {
						print(var + " in " + printInfo(type, true));
					}
				}
				else if (nodeType.equals("\\power")) {
					//Veo si lo que sigue es un tipo enumerado
					String childType = getChildType(type,0);
					childType = types.get(childType);
					if (childType != null && childType.startsWith("EnumerationType")) {
						if (tipoSchema == 0) print("subset(" + var + "," + childType.split(":")[1] + ")");
					}
				}
				else if (nodeType.contains("\\upto")) {
					String nodeName = memory.get(nodeType);
					if (nodeName != null) {
						if (tipoSchema == 0) print(var + " in " + nodeName);
					}
				}
				else { //double check
					type = types.get(type);
					if (type.startsWith("EnumerationType")) {
						if(!type.startsWith("BasicType")) {
							type = type.split(":")[1];
							if (tipoSchema == 0) print(var + " in " + type);
						} else
							type = type.split(":")[1];
						return type;
					}
				}
			}
			return type;
		}
		
		private String printInfo(String type, boolean wantToPrint) {
			String translation = memory.get(type);
			
			if (translation == null) {
				if (type.equals("\\num"))
					translation = newVar("INT");
				else if (type.equals("\\nat"))
					translation = newVar("NAT");
				else if (type.equals("\\nat_{1}"))
					translation = newVar("NAT1");
				else
					translation = newVar();
			
				memory.put(type, translation);
				types.put(type, type);
			}
			
			if (wantToPrint && (!out.contains( translation + " = int("))){ //Chequeo si ya se imprimio informacion del tipo
				if (type.equals("\\num"))
					print(translation + " = int(-10000000000, 10000000000)");
				else if (type.equals("\\nat"))
					print(translation + " = int(0, 10000000000)");
				else if (type.equals("\\nat_{1}"))
					print(translation + " = int(1, 10000000000)");
			}
			
			return translation;
		}
		
		private boolean isBasic(String type) {
			if (type.startsWith("BasicType") || type.startsWith("EnumerationType") || type.startsWith("SchemaType"))
				return true;
			return false;
		}
		
		private boolean isSequence(String type) {
			if (type.startsWith("\\seq"))
				return true;
			return false;
		}
		
		String convertToSet(String zVar, String setlogVar) { //si es una lista, debemos aplicar list_to_rel
			
			String type = types.get(zVar);
			if (isSequence(getType(type))) 
				if (memory.get("list_to_rel(" + zVar + ")") == null) {
					String newVarName = newVar();
					print("list_to_rel(" + setlogVar + "," + newVarName + ")");
					//Hace falta ver el tipo?
					String seqType = leftAndRightTypes(type).get(1);
					//typeInfo(newVarName, "\\power(\\nat\\cross(" + seqType + "))");
					types.put("list_to_rel(" + zVar + ")", "\\power(\\nat\\cross(" + seqType + "))");
					memory.put("list_to_rel(" + zVar + ")", newVarName);
					return newVarName;
				} else {
					return memory.get("list_to_rel(" + zVar + ")");
				}
			else
				return setlogVar;
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
		case 73: WS_action((RuleContext)_localctx, actionIndex); break;

		case 80: SKIP_action((RuleContext)_localctx, actionIndex); break;
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
		"\2\4S\u02b5\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t"+
		"\b\4\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20"+
		"\t\20\4\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27"+
		"\t\27\4\30\t\30\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36"+
		"\t\36\4\37\t\37\4 \t \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4"+
		"(\t(\4)\t)\4*\t*\4+\t+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62"+
		"\t\62\4\63\t\63\4\64\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4"+
		":\t:\4;\t;\4<\t<\4=\t=\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\t"+
		"E\4F\tF\4G\tG\4H\tH\4I\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4"+
		"Q\tQ\4R\tR\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4"+
		"\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\24"+
		"\3\24\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\30"+
		"\3\30\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\35\3\35"+
		"\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37"+
		"\3\37\3 \3 \3 \3 \3 \3 \3 \3 \3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\3\""+
		"\3\"\3\"\3\"\3#\3#\3$\3$\3$\3$\3$\3$\3%\3%\3%\3%\3%\3%\3%\3%\3&\3&\3\'"+
		"\3\'\3\'\3\'\3\'\3(\3(\3)\3)\3)\3*\3*\3+\3+\3,\3,\3,\3,\3,\3-\3-\3-\3"+
		"-\3-\3-\3-\3-\3-\3-\3.\3.\3.\3.\3.\3/\3/\3/\3/\3\60\3\60\3\60\3\60\3\60"+
		"\3\60\3\60\3\60\3\61\3\61\3\61\3\61\3\61\3\62\3\62\3\62\3\62\3\62\3\62"+
		"\3\62\3\63\3\63\3\63\3\63\3\63\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64"+
		"\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\66\3\66\3\66\3\66\3\66\3\66"+
		"\3\66\3\67\3\67\38\38\38\38\38\39\39\39\39\39\39\39\39\39\39\39\3:\3:"+
		"\3:\3:\3:\3:\3:\3:\3:\3;\3;\3<\3<\3<\3<\3<\3<\3=\3=\3>\3>\3>\3>\3>\3>"+
		"\3>\3>\3>\3>\3>\3>\3?\3?\3?\3?\3?\3@\3@\3@\3A\3A\3A\3A\3A\3A\3A\3A\3B"+
		"\3B\3B\3B\3B\6B\u0200\nB\rB\16B\u0201\3B\3B\3B\3B\3B\7B\u0209\nB\fB\16"+
		"B\u020c\13B\3C\6C\u020f\nC\rC\16C\u0210\3D\3D\3D\3D\3D\3D\3D\3D\3D\3D"+
		"\3D\3D\3D\3D\3D\3D\3D\3D\5D\u0225\nD\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E"+
		"\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E"+
		"\3E\3E\3E\3E\5E\u024d\nE\3F\3F\3F\3F\3F\3F\3F\3G\3G\3G\3G\3G\3G\3G\3G"+
		"\3G\3G\3G\3G\3G\3G\3G\3G\3G\3G\3G\3G\3G\3G\5G\u026c\nG\3H\3H\3H\3H\3H"+
		"\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\5H\u0280\nH\3I\3I\3J\5J\u0285"+
		"\nJ\3J\3J\3K\6K\u028a\nK\rK\16K\u028b\3K\3K\3L\3L\3L\3M\3M\3M\3N\3N\3"+
		"N\3N\3N\3N\3N\3N\3O\3O\3O\3O\3O\3O\3O\3O\3P\3P\3P\3P\3P\3P\3Q\3Q\3Q\3"+
		"Q\3Q\3Q\3R\3R\3R\3R\2S\3\3\1\5\4\1\7\5\1\t\6\1\13\7\1\r\b\1\17\t\1\21"+
		"\n\1\23\13\1\25\f\1\27\r\1\31\16\1\33\17\1\35\20\1\37\21\1!\22\1#\23\1"+
		"%\24\1\'\25\1)\26\1+\27\1-\30\1/\31\1\61\32\1\63\33\1\65\34\1\67\35\1"+
		"9\36\1;\37\1= \1?!\1A\"\1C#\1E$\1G%\1I&\1K\'\1M(\1O)\1Q*\1S+\1U,\1W-\1"+
		"Y.\1[/\1]\60\1_\61\1a\62\1c\63\1e\64\1g\65\1i\66\1k\67\1m8\1o9\1q:\1s"+
		";\1u<\1w=\1y>\1{?\1}@\1\177A\1\u0081B\1\u0083C\1\u0085D\1\u0087E\1\u0089"+
		"F\1\u008bG\1\u008dH\1\u008fI\1\u0091J\1\u0093K\1\u0095L\2\u0097M\1\u0099"+
		"N\1\u009bO\1\u009dP\1\u009fQ\1\u00a1R\1\u00a3S\3\3\2\7\4C\\c|\4C\\c|\4"+
		"\62;AA\4--//\5\13\13\17\17\"\"\u02cd\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2"+
		"\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23"+
		"\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2"+
		"\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2"+
		"\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3"+
		"\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2"+
		"\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2"+
		"\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2["+
		"\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2"+
		"\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2"+
		"\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\2\177\3\2\2\2"+
		"\2\u0081\3\2\2\2\2\u0083\3\2\2\2\2\u0085\3\2\2\2\2\u0087\3\2\2\2\2\u0089"+
		"\3\2\2\2\2\u008b\3\2\2\2\2\u008d\3\2\2\2\2\u008f\3\2\2\2\2\u0091\3\2\2"+
		"\2\2\u0093\3\2\2\2\2\u0095\3\2\2\2\2\u0097\3\2\2\2\2\u0099\3\2\2\2\2\u009b"+
		"\3\2\2\2\2\u009d\3\2\2\2\2\u009f\3\2\2\2\2\u00a1\3\2\2\2\2\u00a3\3\2\2"+
		"\2\3\u00a5\3\2\2\2\5\u00ac\3\2\2\2\7\u00b2\3\2\2\2\t\u00b5\3\2\2\2\13"+
		"\u00b9\3\2\2\2\r\u00bd\3\2\2\2\17\u00bf\3\2\2\2\21\u00c1\3\2\2\2\23\u00c7"+
		"\3\2\2\2\25\u00cc\3\2\2\2\27\u00d1\3\2\2\2\31\u00db\3\2\2\2\33\u00e1\3"+
		"\2\2\2\35\u00e6\3\2\2\2\37\u00ee\3\2\2\2!\u00f0\3\2\2\2#\u00f7\3\2\2\2"+
		"%\u00fb\3\2\2\2\'\u0101\3\2\2\2)\u0103\3\2\2\2+\u0105\3\2\2\2-\u010a\3"+
		"\2\2\2/\u010f\3\2\2\2\61\u0111\3\2\2\2\63\u0116\3\2\2\2\65\u011e\3\2\2"+
		"\2\67\u0125\3\2\2\29\u012a\3\2\2\2;\u012f\3\2\2\2=\u0136\3\2\2\2?\u013b"+
		"\3\2\2\2A\u0143\3\2\2\2C\u0147\3\2\2\2E\u0151\3\2\2\2G\u0153\3\2\2\2I"+
		"\u0159\3\2\2\2K\u0161\3\2\2\2M\u0163\3\2\2\2O\u0168\3\2\2\2Q\u016a\3\2"+
		"\2\2S\u016d\3\2\2\2U\u016f\3\2\2\2W\u0171\3\2\2\2Y\u0176\3\2\2\2[\u0180"+
		"\3\2\2\2]\u0185\3\2\2\2_\u0189\3\2\2\2a\u0191\3\2\2\2c\u0196\3\2\2\2e"+
		"\u019d\3\2\2\2g\u01a2\3\2\2\2i\u01aa\3\2\2\2k\u01b2\3\2\2\2m\u01b9\3\2"+
		"\2\2o\u01bb\3\2\2\2q\u01c0\3\2\2\2s\u01cb\3\2\2\2u\u01d4\3\2\2\2w\u01d6"+
		"\3\2\2\2y\u01dc\3\2\2\2{\u01de\3\2\2\2}\u01ea\3\2\2\2\177\u01ef\3\2\2"+
		"\2\u0081\u01f2\3\2\2\2\u0083\u01ff\3\2\2\2\u0085\u020e\3\2\2\2\u0087\u0224"+
		"\3\2\2\2\u0089\u024c\3\2\2\2\u008b\u024e\3\2\2\2\u008d\u026b\3\2\2\2\u008f"+
		"\u027f\3\2\2\2\u0091\u0281\3\2\2\2\u0093\u0284\3\2\2\2\u0095\u0289\3\2"+
		"\2\2\u0097\u028f\3\2\2\2\u0099\u0292\3\2\2\2\u009b\u0295\3\2\2\2\u009d"+
		"\u029d\3\2\2\2\u009f\u02a5\3\2\2\2\u00a1\u02ab\3\2\2\2\u00a3\u02b1\3\2"+
		"\2\2\u00a5\u00a6\7u\2\2\u00a6\u00a7\7e\2\2\u00a7\u00a8\7j\2\2\u00a8\u00a9"+
		"\7g\2\2\u00a9\u00aa\7o\2\2\u00aa\u00ab\7c\2\2\u00ab\4\3\2\2\2\u00ac\u00ad"+
		"\7^\2\2\u00ad\u00ae\7n\2\2\u00ae\u00af\7p\2\2\u00af\u00b0\7q\2\2\u00b0"+
		"\u00b1\7v\2\2\u00b1\6\3\2\2\2\u00b2\u00b3\7^\2\2\u00b3\u00b4\7%\2\2\u00b4"+
		"\b\3\2\2\2\u00b5\u00b6\7t\2\2\u00b6\u00b7\7g\2\2\u00b7\u00b8\7x\2\2\u00b8"+
		"\n\3\2\2\2\u00b9\u00ba\7o\2\2\u00ba\u00bb\7k\2\2\u00bb\u00bc\7p\2\2\u00bc"+
		"\f\3\2\2\2\u00bd\u00be\7]\2\2\u00be\16\3\2\2\2\u00bf\u00c0\7>\2\2\u00c0"+
		"\20\3\2\2\2\u00c1\u00c2\7h\2\2\u00c2\u00c3\7c\2\2\u00c3\u00c4\7n\2\2\u00c4"+
		"\u00c5\7u\2\2\u00c5\u00c6\7g\2\2\u00c6\22\3\2\2\2\u00c7\u00c8\7a\2\2\u00c8"+
		"\u00c9\7}\2\2\u00c9\u00ca\7\63\2\2\u00ca\u00cb\7\177\2\2\u00cb\24\3\2"+
		"\2\2\u00cc\u00cd\7^\2\2\u00cd\u00ce\7f\2\2\u00ce\u00cf\7q\2\2\u00cf\u00d0"+
		"\7o\2\2\u00d0\26\3\2\2\2\u00d1\u00d2\7^\2\2\u00d2\u00d3\7g\2\2\u00d3\u00d4"+
		"\7o\2\2\u00d4\u00d5\7r\2\2\u00d5\u00d6\7v\2\2\u00d6\u00d7\7{\2\2\u00d7"+
		"\u00d8\7u\2\2\u00d8\u00d9\7g\2\2\u00d9\u00da\7v\2\2\u00da\30\3\2\2\2\u00db"+
		"\u00dc\7^\2\2\u00dc\u00dd\7w\2\2\u00dd\u00de\7r\2\2\u00de\u00df\7v\2\2"+
		"\u00df\u00e0\7q\2\2\u00e0\32\3\2\2\2\u00e1\u00e2\7v\2\2\u00e2\u00e3\7"+
		"c\2\2\u00e3\u00e4\7k\2\2\u00e4\u00e5\7n\2\2\u00e5\34\3\2\2\2\u00e6\u00e7"+
		"\7^\2\2\u00e7\u00e8\7h\2\2\u00e8\u00e9\7k\2\2\u00e9\u00ea\7p\2\2\u00ea"+
		"\u00eb\7u\2\2\u00eb\u00ec\7g\2\2\u00ec\u00ed\7v\2\2\u00ed\36\3\2\2\2\u00ee"+
		"\u00ef\7\177\2\2\u00ef \3\2\2\2\u00f0\u00f1\7^\2\2\u00f1\u00f2\7p\2\2"+
		"\u00f2\u00f3\7q\2\2\u00f3\u00f4\7v\2\2\u00f4\u00f5\7k\2\2\u00f5\u00f6"+
		"\7p\2\2\u00f6\"\3\2\2\2\u00f7\u00f8\7o\2\2\u00f8\u00f9\7c\2\2\u00f9\u00fa"+
		"\7z\2\2\u00fa$\3\2\2\2\u00fb\u00fc\7^\2\2\u00fc\u00fd\7n\2\2\u00fd\u00fe"+
		"\7c\2\2\u00fe\u00ff\7p\2\2\u00ff\u0100\7f\2\2\u0100&\3\2\2\2\u0101\u0102"+
		"\7+\2\2\u0102(\3\2\2\2\u0103\u0104\7B\2\2\u0104*\3\2\2\2\u0105\u0106\7"+
		"^\2\2\u0106\u0107\7u\2\2\u0107\u0108\7g\2\2\u0108\u0109\7s\2\2\u0109,"+
		"\3\2\2\2\u010a\u010b\7j\2\2\u010b\u010c\7g\2\2\u010c\u010d\7c\2\2\u010d"+
		"\u010e\7f\2\2\u010e.\3\2\2\2\u010f\u0110\7?\2\2\u0110\60\3\2\2\2\u0111"+
		"\u0112\7^\2\2\u0112\u0113\7n\2\2\u0113\u0114\7g\2\2\u0114\u0115\7s\2\2"+
		"\u0115\62\3\2\2\2\u0116\u0117\7^\2\2\u0117\u0118\7r\2\2\u0118\u0119\7"+
		"t\2\2\u0119\u011a\7g\2\2\u011a\u011b\7h\2\2\u011b\u011c\7k\2\2\u011c\u011d"+
		"\7z\2\2\u011d\64\3\2\2\2\u011e\u011f\7u\2\2\u011f\u0120\7s\2\2\u0120\u0121"+
		"\7w\2\2\u0121\u0122\7c\2\2\u0122\u0123\7u\2\2\u0123\u0124\7j\2\2\u0124"+
		"\66\3\2\2\2\u0125\u0126\7^\2\2\u0126\u0127\7p\2\2\u0127\u0128\7c\2\2\u0128"+
		"\u0129\7v\2\2\u01298\3\2\2\2\u012a\u012b\7^\2\2\u012b\u012c\7p\2\2\u012c"+
		"\u012d\7g\2\2\u012d\u012e\7s\2\2\u012e:\3\2\2\2\u012f\u0130\7^\2\2\u0130"+
		"\u0131\7y\2\2\u0131\u0132\7j\2\2\u0132\u0133\7g\2\2\u0133\u0134\7t\2\2"+
		"\u0134\u0135\7g\2\2\u0135<\3\2\2\2\u0136\u0137\7^\2\2\u0137\u0138\7i\2"+
		"\2\u0138\u0139\7g\2\2\u0139\u013a\7s\2\2\u013a>\3\2\2\2\u013b\u013c\7"+
		"^\2\2\u013c\u013d\7d\2\2\u013d\u013e\7k\2\2\u013e\u013f\7i\2\2\u013f\u0140"+
		"\7e\2\2\u0140\u0141\7w\2\2\u0141\u0142\7r\2\2\u0142@\3\2\2\2\u0143\u0144"+
		"\7<\2\2\u0144\u0145\7<\2\2\u0145\u0146\7?\2\2\u0146B\3\2\2\2\u0147\u0148"+
		"\7^\2\2\u0148\u0149\7u\2\2\u0149\u014a\7w\2\2\u014a\u014b\7d\2\2\u014b"+
		"\u014c\7u\2\2\u014c\u014d\7g\2\2\u014d\u014e\7v\2\2\u014e\u014f\7g\2\2"+
		"\u014f\u0150\7s\2\2\u0150D\3\2\2\2\u0151\u0152\7~\2\2\u0152F\3\2\2\2\u0153"+
		"\u0154\7^\2\2\u0154\u0155\7g\2\2\u0155\u0156\7p\2\2\u0156\u0157\7f\2\2"+
		"\u0157\u0158\7}\2\2\u0158H\3\2\2\2\u0159\u015a\7^\2\2\u015a\u015b\7u\2"+
		"\2\u015b\u015c\7w\2\2\u015c\u015d\7h\2\2\u015d\u015e\7h\2\2\u015e\u015f"+
		"\7k\2\2\u015f\u0160\7z\2\2\u0160J\3\2\2\2\u0161\u0162\7_\2\2\u0162L\3"+
		"\2\2\2\u0163\u0164\7n\2\2\u0164\u0165\7c\2\2\u0165\u0166\7u\2\2\u0166"+
		"\u0167\7v\2\2\u0167N\3\2\2\2\u0168\u0169\7.\2\2\u0169P\3\2\2\2\u016a\u016b"+
		"\7\177\2\2\u016b\u016c\7}\2\2\u016cR\3\2\2\2\u016d\u016e\7*\2\2\u016e"+
		"T\3\2\2\2\u016f\u0170\7<\2\2\u0170V\3\2\2\2\u0171\u0172\7^\2\2\u0172\u0173"+
		"\7n\2\2\u0173\u0174\7q\2\2\u0174\u0175\7t\2\2\u0175X\3\2\2\2\u0176\u0177"+
		"\7^\2\2\u0177\u0178\7g\2\2\u0178\u0179\7p\2\2\u0179\u017a\7f\2\2\u017a"+
		"\u017b\7}\2\2\u017b\u017c\7|\2\2\u017c\u017d\7g\2\2\u017d\u017e\7f\2\2"+
		"\u017e\u017f\7\177\2\2\u017fZ\3\2\2\2\u0180\u0181\7^\2\2\u0181\u0182\7"+
		"t\2\2\u0182\u0183\7c\2\2\u0183\u0184\7p\2\2\u0184\\\3\2\2\2\u0185\u0186"+
		"\7^\2\2\u0186\u0187\7k\2\2\u0187\u0188\7p\2\2\u0188^\3\2\2\2\u0189\u018a"+
		"\7u\2\2\u018a\u018b\7g\2\2\u018b\u018c\7s\2\2\u018c\u018d\7a\2\2\u018d"+
		"\u018e\7}\2\2\u018e\u018f\7\63\2\2\u018f\u0190\7\177\2\2\u0190`\3\2\2"+
		"\2\u0191\u0192\7^\2\2\u0192\u0193\7k\2\2\u0193\u0194\7p\2\2\u0194\u0195"+
		"\7x\2\2\u0195b\3\2\2\2\u0196\u0197\7^\2\2\u0197\u0198\7e\2\2\u0198\u0199"+
		"\7t\2\2\u0199\u019a\7q\2\2\u019a\u019b\7u\2\2\u019b\u019c\7u\2\2\u019c"+
		"d\3\2\2\2\u019d\u019e\7v\2\2\u019e\u019f\7t\2\2\u019f\u01a0\7w\2\2\u01a0"+
		"\u01a1\7g\2\2\u01a1f\3\2\2\2\u01a2\u01a3\7^\2\2\u01a3\u01a4\7d\2\2\u01a4"+
		"\u01a5\7g\2\2\u01a5\u01a6\7i\2\2\u01a6\u01a7\7k\2\2\u01a7\u01a8\7p\2\2"+
		"\u01a8\u01a9\7}\2\2\u01a9h\3\2\2\2\u01aa\u01ab\7^\2\2\u01ab\u01ac\7u\2"+
		"\2\u01ac\u01ad\7w\2\2\u01ad\u01ae\7d\2\2\u01ae\u01af\7u\2\2\u01af\u01b0"+
		"\7g\2\2\u01b0\u01b1\7v\2\2\u01b1j\3\2\2\2\u01b2\u01b3\7^\2\2\u01b3\u01b4"+
		"\7r\2\2\u01b4\u01b5\7q\2\2\u01b5\u01b6\7y\2\2\u01b6\u01b7\7g\2\2\u01b7"+
		"\u01b8\7t\2\2\u01b8l\3\2\2\2\u01b9\u01ba\7\60\2\2\u01ban\3\2\2\2\u01bb"+
		"\u01bc\7^\2\2\u01bc\u01bd\7k\2\2\u01bd\u01be\7h\2\2\u01be\u01bf\7h\2\2"+
		"\u01bfp\3\2\2\2\u01c0\u01c1\7u\2\2\u01c1\u01c2\7e\2\2\u01c2\u01c3\7j\2"+
		"\2\u01c3\u01c4\7g\2\2\u01c4\u01c5\7o\2\2\u01c5\u01c6\7c\2\2\u01c6\u01c7"+
		"\7V\2\2\u01c7\u01c8\7{\2\2\u01c8\u01c9\7r\2\2\u01c9\u01ca\7g\2\2\u01ca"+
		"r\3\2\2\2\u01cb\u01cc\7^\2\2\u01cc\u01cd\7k\2\2\u01cd\u01ce\7o\2\2\u01ce"+
		"\u01cf\7r\2\2\u01cf\u01d0\7n\2\2\u01d0\u01d1\7k\2\2\u01d1\u01d2\7g\2\2"+
		"\u01d2\u01d3\7u\2\2\u01d3t\3\2\2\2\u01d4\u01d5\7=\2\2\u01d5v\3\2\2\2\u01d6"+
		"\u01d7\7h\2\2\u01d7\u01d8\7t\2\2\u01d8\u01d9\7q\2\2\u01d9\u01da\7p\2\2"+
		"\u01da\u01db\7v\2\2\u01dbx\3\2\2\2\u01dc\u01dd\7@\2\2\u01ddz\3\2\2\2\u01de"+
		"\u01df\7^\2\2\u01df\u01e0\7d\2\2\u01e0\u01e1\7g\2\2\u01e1\u01e2\7i\2\2"+
		"\u01e2\u01e3\7k\2\2\u01e3\u01e4\7p\2\2\u01e4\u01e5\7}\2\2\u01e5\u01e6"+
		"\7|\2\2\u01e6\u01e7\7g\2\2\u01e7\u01e8\7f\2\2\u01e8\u01e9\7\177\2\2\u01e9"+
		"|\3\2\2\2\u01ea\u01eb\7^\2\2\u01eb\u01ec\7p\2\2\u01ec\u01ed\7w\2\2\u01ed"+
		"\u01ee\7o\2\2\u01ee~\3\2\2\2\u01ef\u01f0\7?\2\2\u01f0\u01f1\7?\2\2\u01f1"+
		"\u0080\3\2\2\2\u01f2\u01f3\7^\2\2\u01f3\u01f4\7o\2\2\u01f4\u01f5\7c\2"+
		"\2\u01f5\u01f6\7r\2\2\u01f6\u01f7\7u\2\2\u01f7\u01f8\7v\2\2\u01f8\u01f9"+
		"\7q\2\2\u01f9\u0082\3\2\2\2\u01fa\u0200\t\2\2\2\u01fb\u01fc\7^\2\2\u01fc"+
		"\u01fd\7a\2\2\u01fd\u0200\7\"\2\2\u01fe\u0200\7A\2\2\u01ff\u01fa\3\2\2"+
		"\2\u01ff\u01fb\3\2\2\2\u01ff\u01fe\3\2\2\2\u0200\u0201\3\2\2\2\u0201\u01ff"+
		"\3\2\2\2\u0201\u0202\3\2\2\2\u0202\u020a\3\2\2\2\u0203\u0209\t\3\2\2\u0204"+
		"\u0205\7^\2\2\u0205\u0206\7a\2\2\u0206\u0209\7\"\2\2\u0207\u0209\t\4\2"+
		"\2\u0208\u0203\3\2\2\2\u0208\u0204\3\2\2\2\u0208\u0207\3\2\2\2\u0209\u020c"+
		"\3\2\2\2\u020a\u0208\3\2\2\2\u020a\u020b\3\2\2\2\u020b\u0084\3\2\2\2\u020c"+
		"\u020a\3\2\2\2\u020d\u020f\4\62;\2\u020e\u020d\3\2\2\2\u020f\u0210\3\2"+
		"\2\2\u0210\u020e\3\2\2\2\u0210\u0211\3\2\2\2\u0211\u0086\3\2\2\2\u0212"+
		"\u0225\t\5\2\2\u0213\u0214\7^\2\2\u0214\u0215\7e\2\2\u0215\u0216\7w\2"+
		"\2\u0216\u0225\7r\2\2\u0217\u0218\7^\2\2\u0218\u0219\7u\2\2\u0219\u021a"+
		"\7g\2\2\u021a\u021b\7v\2\2\u021b\u021c\7o\2\2\u021c\u021d\7k\2\2\u021d"+
		"\u021e\7p\2\2\u021e\u021f\7w\2\2\u021f\u0225\7u\2\2\u0220\u0221\7^\2\2"+
		"\u0221\u0222\7e\2\2\u0222\u0223\7c\2\2\u0223\u0225\7v\2\2\u0224\u0212"+
		"\3\2\2\2\u0224\u0213\3\2\2\2\u0224\u0217\3\2\2\2\u0224\u0220\3\2\2\2\u0225"+
		"\u0088\3\2\2\2\u0226\u024d\7,\2\2\u0227\u0228\7^\2\2\u0228\u0229\7f\2"+
		"\2\u0229\u022a\7k\2\2\u022a\u024d\7x\2\2\u022b\u022c\7^\2\2\u022c\u022d"+
		"\7o\2\2\u022d\u022e\7q\2\2\u022e\u024d\7f\2\2\u022f\u0230\7^\2\2\u0230"+
		"\u0231\7e\2\2\u0231\u0232\7c\2\2\u0232\u024d\7r\2\2\u0233\u0234\7^\2\2"+
		"\u0234\u0235\7e\2\2\u0235\u0236\7q\2\2\u0236\u0237\7o\2\2\u0237\u024d"+
		"\7r\2\2\u0238\u0239\7^\2\2\u0239\u023a\7e\2\2\u023a\u023b\7k\2\2\u023b"+
		"\u023c\7t\2\2\u023c\u024d\7e\2\2\u023d\u023e\7^\2\2\u023e\u023f\7g\2\2"+
		"\u023f\u0240\7z\2\2\u0240\u0241\7v\2\2\u0241\u0242\7t\2\2\u0242\u0243"+
		"\7c\2\2\u0243\u0244\7e\2\2\u0244\u024d\7v\2\2\u0245\u0246\7^\2\2\u0246"+
		"\u0247\7h\2\2\u0247\u0248\7k\2\2\u0248\u0249\7n\2\2\u0249\u024a\7v\2\2"+
		"\u024a\u024b\7g\2\2\u024b\u024d\7t\2\2\u024c\u0226\3\2\2\2\u024c\u0227"+
		"\3\2\2\2\u024c\u022b\3\2\2\2\u024c\u022f\3\2\2\2\u024c\u0233\3\2\2\2\u024c"+
		"\u0238\3\2\2\2\u024c\u023d\3\2\2\2\u024c\u0245\3\2\2\2\u024d\u008a\3\2"+
		"\2\2\u024e\u024f\7^\2\2\u024f\u0250\7q\2\2\u0250\u0251\7r\2\2\u0251\u0252"+
		"\7n\2\2\u0252\u0253\7w\2\2\u0253\u0254\7u\2\2\u0254\u008c\3\2\2\2\u0255"+
		"\u0256\7^\2\2\u0256\u0257\7f\2\2\u0257\u0258\7t\2\2\u0258\u0259\7g\2\2"+
		"\u0259\u026c\7u\2\2\u025a\u025b\7^\2\2\u025b\u025c\7t\2\2\u025c\u025d"+
		"\7t\2\2\u025d\u025e\7g\2\2\u025e\u026c\7u\2\2\u025f\u0260\7^\2\2\u0260"+
		"\u0261\7p\2\2\u0261\u0262\7f\2\2\u0262\u0263\7t\2\2\u0263\u0264\7g\2\2"+
		"\u0264\u026c\7u\2\2\u0265\u0266\7^\2\2\u0266\u0267\7p\2\2\u0267\u0268"+
		"\7t\2\2\u0268\u0269\7t\2\2\u0269\u026a\7g\2\2\u026a\u026c\7u\2\2\u026b"+
		"\u0255\3\2\2\2\u026b\u025a\3\2\2\2\u026b\u025f\3\2\2\2\u026b\u0265\3\2"+
		"\2\2\u026c\u008e\3\2\2\2\u026d\u026e\7^\2\2\u026e\u026f\7t\2\2\u026f\u0270"+
		"\7g\2\2\u0270\u0280\7n\2\2\u0271\u0272\7^\2\2\u0272\u0273\7r\2\2\u0273"+
		"\u0274\7h\2\2\u0274\u0275\7w\2\2\u0275\u0280\7p\2\2\u0276\u0277\7^\2\2"+
		"\u0277\u0278\7h\2\2\u0278\u0279\7w\2\2\u0279\u0280\7p\2\2\u027a\u027b"+
		"\7^\2\2\u027b\u027c\7h\2\2\u027c\u027d\7h\2\2\u027d\u027e\7w\2\2\u027e"+
		"\u0280\7p\2\2\u027f\u026d\3\2\2\2\u027f\u0271\3\2\2\2\u027f\u0276\3\2"+
		"\2\2\u027f\u027a\3\2\2\2\u0280\u0090\3\2\2\2\u0281\u0282\7\u0080\2\2\u0282"+
		"\u0092\3\2\2\2\u0283\u0285\7\17\2\2\u0284\u0283\3\2\2\2\u0284\u0285\3"+
		"\2\2\2\u0285\u0286\3\2\2\2\u0286\u0287\7\f\2\2\u0287\u0094\3\2\2\2\u0288"+
		"\u028a\t\6\2\2\u0289\u0288\3\2\2\2\u028a\u028b\3\2\2\2\u028b\u0289\3\2"+
		"\2\2\u028b\u028c\3\2\2\2\u028c\u028d\3\2\2\2\u028d\u028e\bK\2\2\u028e"+
		"\u0096\3\2\2\2\u028f\u0290\7^\2\2\u0290\u0291\7}\2\2\u0291\u0098\3\2\2"+
		"\2\u0292\u0293\7^\2\2\u0293\u0294\7\177\2\2\u0294\u009a\3\2\2\2\u0295"+
		"\u0296\7^\2\2\u0296\u0297\7n\2\2\u0297\u0298\7c\2\2\u0298\u0299\7p\2\2"+
		"\u0299\u029a\7i\2\2\u029a\u029b\7n\2\2\u029b\u029c\7g\2\2\u029c\u009c"+
		"\3\2\2\2\u029d\u029e\7^\2\2\u029e\u029f\7t\2\2\u029f\u02a0\7c\2\2\u02a0"+
		"\u02a1\7p\2\2\u02a1\u02a2\7i\2\2\u02a2\u02a3\7n\2\2\u02a3\u02a4\7g\2\2"+
		"\u02a4\u009e\3\2\2\2\u02a5\u02a6\7^\2\2\u02a6\u02a7\7n\2\2\u02a7\u02a8"+
		"\7k\2\2\u02a8\u02a9\7o\2\2\u02a9\u02aa\7i\2\2\u02aa\u00a0\3\2\2\2\u02ab"+
		"\u02ac\7^\2\2\u02ac\u02ad\7t\2\2\u02ad\u02ae\7k\2\2\u02ae\u02af\7o\2\2"+
		"\u02af\u02b0\7i\2\2\u02b0\u00a2\3\2\2\2\u02b1\u02b2\7^\2\2\u02b2\u02b3"+
		"\7^\2\2\u02b3\u02b4\bR\3\2\u02b4\u00a4\3\2\2\2\16\2\u01ff\u0201\u0208"+
		"\u020a\u0210\u0224\u024c\u026b\u027f\u0284\u028b";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}