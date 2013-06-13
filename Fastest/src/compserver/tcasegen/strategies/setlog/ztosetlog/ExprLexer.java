// Generated from Expr.g4 by ANTLR 4.0

	package compserver.tcasegen.strategies.setlog.ztosetlog;
	import compserver.tcasegen.strategies.setlog.TypeManagerParser;
	import compserver.tcasegen.strategies.setlog.TypeManagerLexer;
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
public class ExprLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__61=1, T__60=2, T__59=3, T__58=4, T__57=5, T__56=6, T__55=7, T__54=8, 
		T__53=9, T__52=10, T__51=11, T__50=12, T__49=13, T__48=14, T__47=15, T__46=16, 
		T__45=17, T__44=18, T__43=19, T__42=20, T__41=21, T__40=22, T__39=23, 
		T__38=24, T__37=25, T__36=26, T__35=27, T__34=28, T__33=29, T__32=30, 
		T__31=31, T__30=32, T__29=33, T__28=34, T__27=35, T__26=36, T__25=37, 
		T__24=38, T__23=39, T__22=40, T__21=41, T__20=42, T__19=43, T__18=44, 
		T__17=45, T__16=46, T__15=47, T__14=48, T__13=49, T__12=50, T__11=51, 
		T__10=52, T__9=53, T__8=54, T__7=55, T__6=56, T__5=57, T__4=58, T__3=59, 
		T__2=60, T__1=61, T__0=62, CROSS=63, POWER=64, IN_FUN_65=65, IN_FUN_60=66, 
		IN_FUN_50=67, IN_FUN_45=68, IN_FUN_40=69, IN_FUN_30=70, IN_FUN_20=71, 
		IN_FUN_10=72, IN_FUN_5=73, SELECTION=74, NAME=75, NUM=76, NL=77, WS=78, 
		SETSTART=79, SETEND=80, LISTSTART=81, LISTEND=82, IMGSTART=83, IMGEND=84, 
		SKIP=85;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'schema'", "'\\lnot'", "'\\#'", "'rev'", "'min'", "'['", "'<'", "'false'", 
		"'_{1}'", "'\\dom'", "'\\emptyset'", "'\\bigcap'", "'tail'", "'}'", "'\\notin'", 
		"'max'", "'\\land'", "')'", "'@'", "'\\seq'", "'head'", "'='", "'\\leq'", 
		"'\\prefix'", "'squash'", "'\\nat'", "'\\neq'", "'\\where'", "'\\geq'", 
		"'\\bigcup'", "'::='", "'\\subseteq'", "'|'", "'\\end{'", "'\\suffix'", 
		"']'", "'last'", "','", "'}{'", "'('", "':'", "'\\lor'", "'\\ran'", "'\\end{zed}'", 
		"'\\in'", "'seq_{1}'", "'\\rblot'", "'\\inv'", "'true'", "'\\begin{'", 
		"'\\lblot'", "'\\subset'", "'\\iff'", "'schemaType'", "'\\implies'", "';'", 
		"'front'", "'>'", "'\\negate'", "'\\begin{zed}'", "'\\num'", "'=='", "'\\cross'", 
		"POWER", "IN_FUN_65", "IN_FUN_60", "IN_FUN_50", "IN_FUN_45", "IN_FUN_40", 
		"IN_FUN_30", "IN_FUN_20", "IN_FUN_10", "IN_FUN_5", "'.'", "NAME", "NUM", 
		"NL", "WS", "'\\{'", "'\\}'", "'\\langle'", "'\\rangle'", "'\\limg'", 
		"'\\rimg'", "SKIP"
	};
	public static final String[] ruleNames = {
		"T__61", "T__60", "T__59", "T__58", "T__57", "T__56", "T__55", "T__54", 
		"T__53", "T__52", "T__51", "T__50", "T__49", "T__48", "T__47", "T__46", 
		"T__45", "T__44", "T__43", "T__42", "T__41", "T__40", "T__39", "T__38", 
		"T__37", "T__36", "T__35", "T__34", "T__33", "T__32", "T__31", "T__30", 
		"T__29", "T__28", "T__27", "T__26", "T__25", "T__24", "T__23", "T__22", 
		"T__21", "T__20", "T__19", "T__18", "T__17", "T__16", "T__15", "T__14", 
		"T__13", "T__12", "T__11", "T__10", "T__9", "T__8", "T__7", "T__6", "T__5", 
		"T__4", "T__3", "T__2", "T__1", "T__0", "CROSS", "POWER", "IN_FUN_65", 
		"IN_FUN_60", "IN_FUN_50", "IN_FUN_45", "IN_FUN_40", "IN_FUN_30", "IN_FUN_20", 
		"IN_FUN_10", "IN_FUN_5", "SELECTION", "NAME", "NUM", "NL", "WS", "SETSTART", 
		"SETEND", "LISTSTART", "LISTEND", "IMGSTART", "IMGEND", "SKIP"
	};


		
		String setExpressionDecl, setExpressionPred, setExpressionExpr;
		
		int varNumber = 0;
		int modoSetExpression = 0; //0 = false, 1 = true
		int tipoSchema = 0;        //0 = false, 1 = true, esta variable se utiliza para no imprimir ciertas cosas,
						           //cuando trabajamos en tipos schema
		
		HashMap<String,String> schemaTypeVars;

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
		
		//Metodo para quitar los parentesis exteriores
		String removeParenthesis(String type) {
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
	        
	        return parser.printTree(root);
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
			if (memory.containsValue(newVarName) /*|| modoSetExpression==1*/) { 
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
						if (nodeType.startsWith("seq_{1}"))
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
					if (tipoSchema == 0) printAtEnd("is_pfun(" + var + ")");
				}
				else if (type.equals("\\nat") || type.equals("\\num") || type.equals("\\nat_{1}")) {
					if (tipoSchema == 0) {
						print(var + " ein " + printInfo(type, true));
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
				else if (nodeType.contains("\\upto")) { //En este caso, los hijos pueden ser variables Setlog. (Se podra mejorar?)
					String[] childs = nodeType.split("\\\\upto");
					String childa = childs[0];
					String childb = childs[1];
					
					//Como pueden ser variables de setlog, debo buscar su equivalente Z
					childa = getKey(childa, memory);
					childb = getKey(childb, memory);
					
					//Obtengo la variable de setlg que representa el upto
					String nodeName = memory.get(childa + "\\upto" + childb); 
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
		
		private String getKey(String value, HashMap<String,String> hashmap) {
			Iterator<String> keysIt= hashmap.keySet().iterator();
			while (keysIt.hasNext()) {
				String key = keysIt.next();
				if (hashmap.get(key).equals(value))
					return key;
			}
			return null;
		}
		
		private String printInfo(String type, boolean wantToPrint) {
			String translation = memory.get(type);
			int modoSetExpressionBk = modoSetExpression;
			
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
				//if (modoSetExpression > 0)
				//	setExpressionVars.put(type, translation);
			}
			
			if (wantToPrint && (!out.contains(translation + " = int(")) && ((modoSetExpression == 0) || !((setExpressionDecl+setExpressionExpr+setExpressionPred).contains(translation + " = int(")))){ //Chequeo si ya se imprimio informacion del tipo
				modoSetExpression = 0;
				if (type.equals("\\num"))
					print(translation + " = int(-2147483648, 2147483647)");
				else if (type.equals("\\nat"))
					print(translation + " = int(0, 2147483647)");
				else if (type.equals("\\nat_{1}"))
					print(translation + " = int(1, 2147483647)");
				modoSetExpression = modoSetExpressionBk;
			}
			
			return translation;
		}
		
		private boolean isBasic(String type) {
			if (type.startsWith("BasicType") || type.startsWith("EnumerationType") || type.startsWith("SchemaType"))
				return true;
			return false;
		}
		
		private boolean isNumeric(String type) {
			if (type.equals("\\num") || type.equals("\\nat") || type.equals("\\nat_{1}"))
				return true;
			return false;
		}
		
		private boolean isSequence(String type) {
			if (type.equals("\\seq") || type.startsWith("seq_{1}"))
				return true;
			return false;
		}
		
		String convertToSet(String zVar, String setlogVar) { //si es una lista, debemos aplicar list_to_rel
			
			String type = types.get(zVar);
			if (isSequence(getType(type))) 
				if (memory.get("list_to_rel(" + zVar + ")") == null) {
					String newVarName = newVar();
					print("list_to_rel(" + setlogVar + "," + newVarName + ")");
					if (modoSetExpression != 0 ) //Si estoy dentro de un conjunto
						setExpressionVars.put(zVar, newVarName);				
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
		case 77: WS_action((RuleContext)_localctx, actionIndex); break;

		case 84: SKIP_action((RuleContext)_localctx, actionIndex); break;
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
		"\2\4W\u02dc\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t"+
		"\b\4\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20"+
		"\t\20\4\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27"+
		"\t\27\4\30\t\30\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36"+
		"\t\36\4\37\t\37\4 \t \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4"+
		"(\t(\4)\t)\4*\t*\4+\t+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62"+
		"\t\62\4\63\t\63\4\64\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4"+
		":\t:\4;\t;\4<\t<\4=\t=\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\t"+
		"E\4F\tF\4G\tG\4H\tH\4I\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4"+
		"Q\tQ\4R\tR\4S\tS\4T\tT\4U\tU\4V\tV\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3"+
		"\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13"+
		"\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3"+
		"\20\3\20\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3"+
		"\24\3\24\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3"+
		"\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3"+
		"\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3"+
		"\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3"+
		"\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3!\3!\3!\3!\3!\3!\3"+
		"!\3!\3!\3!\3\"\3\"\3#\3#\3#\3#\3#\3#\3$\3$\3$\3$\3$\3$\3$\3$\3%\3%\3&"+
		"\3&\3&\3&\3&\3\'\3\'\3(\3(\3(\3)\3)\3*\3*\3+\3+\3+\3+\3+\3,\3,\3,\3,\3"+
		",\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3.\3.\3.\3.\3/\3/\3/\3/\3/\3/\3/\3/\3"+
		"\60\3\60\3\60\3\60\3\60\3\60\3\60\3\61\3\61\3\61\3\61\3\61\3\62\3\62\3"+
		"\62\3\62\3\62\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\64\3\64\3\64\3"+
		"\64\3\64\3\64\3\64\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\66\3\66\3"+
		"\66\3\66\3\66\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3"+
		"8\38\38\38\38\38\38\38\38\39\39\3:\3:\3:\3:\3:\3:\3;\3;\3<\3<\3<\3<\3"+
		"<\3<\3<\3<\3=\3=\3=\3=\3=\3=\3=\3=\3=\3=\3=\3=\3>\3>\3>\3>\3>\3?\3?\3"+
		"?\3@\3@\3@\3@\3@\3@\3@\3A\3A\3A\3A\3A\3A\3A\3A\3A\3A\3A\3A\3A\5A\u020f"+
		"\nA\3B\3B\3B\3B\3B\3B\3B\3B\3B\3B\3B\5B\u021c\nB\3C\3C\3C\3C\3C\3C\3C"+
		"\3C\3C\3C\3C\5C\u0229\nC\3D\3D\3D\3D\3D\3D\3D\3E\3E\3E\3E\3E\3E\3E\3E"+
		"\3E\3F\3F\3F\3F\3F\3F\3F\3F\3F\3F\3F\3F\3F\3F\3F\3F\3F\3F\3F\3F\3F\3F"+
		"\3F\3F\3F\3F\3F\3F\3F\3F\5F\u0259\nF\3G\3G\3G\3G\3G\3G\3G\3G\3G\3G\3G"+
		"\3G\3G\3G\3G\3G\3G\3G\5G\u026d\nG\3H\3H\3H\3H\3H\3H\3I\3I\3I\3I\3I\3I"+
		"\3I\3I\3J\3J\3J\3J\3J\3J\3J\3J\3J\3J\3J\3J\3J\3J\3J\3J\3J\3J\5J\u028f"+
		"\nJ\3K\3K\3L\3L\3L\3L\3L\6L\u0298\nL\rL\16L\u0299\3L\3L\3L\3L\3L\7L\u02a1"+
		"\nL\fL\16L\u02a4\13L\3M\6M\u02a7\nM\rM\16M\u02a8\3N\5N\u02ac\nN\3N\3N"+
		"\3O\6O\u02b1\nO\rO\16O\u02b2\3O\3O\3P\3P\3P\3Q\3Q\3Q\3R\3R\3R\3R\3R\3"+
		"R\3R\3R\3S\3S\3S\3S\3S\3S\3S\3S\3T\3T\3T\3T\3T\3T\3U\3U\3U\3U\3U\3U\3"+
		"V\3V\3V\3V\2W\3\3\1\5\4\1\7\5\1\t\6\1\13\7\1\r\b\1\17\t\1\21\n\1\23\13"+
		"\1\25\f\1\27\r\1\31\16\1\33\17\1\35\20\1\37\21\1!\22\1#\23\1%\24\1\'\25"+
		"\1)\26\1+\27\1-\30\1/\31\1\61\32\1\63\33\1\65\34\1\67\35\19\36\1;\37\1"+
		"= \1?!\1A\"\1C#\1E$\1G%\1I&\1K\'\1M(\1O)\1Q*\1S+\1U,\1W-\1Y.\1[/\1]\60"+
		"\1_\61\1a\62\1c\63\1e\64\1g\65\1i\66\1k\67\1m8\1o9\1q:\1s;\1u<\1w=\1y"+
		">\1{?\1}@\1\177A\1\u0081B\1\u0083C\1\u0085D\1\u0087E\1\u0089F\1\u008b"+
		"G\1\u008dH\1\u008fI\1\u0091J\1\u0093K\1\u0095L\1\u0097M\1\u0099N\1\u009b"+
		"O\1\u009dP\2\u009fQ\1\u00a1R\1\u00a3S\1\u00a5T\1\u00a7U\1\u00a9V\1\u00ab"+
		"W\3\3\2\7\4--//\4C\\c|\4C\\c|\4\62;AA\6\13\13\17\17\"\"\u0080\u0080\u02f3"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2"+
		"\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3"+
		"\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2"+
		"\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2"+
		"U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3"+
		"\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2"+
		"\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2"+
		"{\3\2\2\2\2}\3\2\2\2\2\177\3\2\2\2\2\u0081\3\2\2\2\2\u0083\3\2\2\2\2\u0085"+
		"\3\2\2\2\2\u0087\3\2\2\2\2\u0089\3\2\2\2\2\u008b\3\2\2\2\2\u008d\3\2\2"+
		"\2\2\u008f\3\2\2\2\2\u0091\3\2\2\2\2\u0093\3\2\2\2\2\u0095\3\2\2\2\2\u0097"+
		"\3\2\2\2\2\u0099\3\2\2\2\2\u009b\3\2\2\2\2\u009d\3\2\2\2\2\u009f\3\2\2"+
		"\2\2\u00a1\3\2\2\2\2\u00a3\3\2\2\2\2\u00a5\3\2\2\2\2\u00a7\3\2\2\2\2\u00a9"+
		"\3\2\2\2\2\u00ab\3\2\2\2\3\u00ad\3\2\2\2\5\u00b4\3\2\2\2\7\u00ba\3\2\2"+
		"\2\t\u00bd\3\2\2\2\13\u00c1\3\2\2\2\r\u00c5\3\2\2\2\17\u00c7\3\2\2\2\21"+
		"\u00c9\3\2\2\2\23\u00cf\3\2\2\2\25\u00d4\3\2\2\2\27\u00d9\3\2\2\2\31\u00e3"+
		"\3\2\2\2\33\u00eb\3\2\2\2\35\u00f0\3\2\2\2\37\u00f2\3\2\2\2!\u00f9\3\2"+
		"\2\2#\u00fd\3\2\2\2%\u0103\3\2\2\2\'\u0105\3\2\2\2)\u0107\3\2\2\2+\u010c"+
		"\3\2\2\2-\u0111\3\2\2\2/\u0113\3\2\2\2\61\u0118\3\2\2\2\63\u0120\3\2\2"+
		"\2\65\u0127\3\2\2\2\67\u012c\3\2\2\29\u0131\3\2\2\2;\u0138\3\2\2\2=\u013d"+
		"\3\2\2\2?\u0145\3\2\2\2A\u0149\3\2\2\2C\u0153\3\2\2\2E\u0155\3\2\2\2G"+
		"\u015b\3\2\2\2I\u0163\3\2\2\2K\u0165\3\2\2\2M\u016a\3\2\2\2O\u016c\3\2"+
		"\2\2Q\u016f\3\2\2\2S\u0171\3\2\2\2U\u0173\3\2\2\2W\u0178\3\2\2\2Y\u017d"+
		"\3\2\2\2[\u0187\3\2\2\2]\u018b\3\2\2\2_\u0193\3\2\2\2a\u019a\3\2\2\2c"+
		"\u019f\3\2\2\2e\u01a4\3\2\2\2g\u01ac\3\2\2\2i\u01b3\3\2\2\2k\u01bb\3\2"+
		"\2\2m\u01c0\3\2\2\2o\u01cb\3\2\2\2q\u01d4\3\2\2\2s\u01d6\3\2\2\2u\u01dc"+
		"\3\2\2\2w\u01de\3\2\2\2y\u01e6\3\2\2\2{\u01f2\3\2\2\2}\u01f7\3\2\2\2\177"+
		"\u01fa\3\2\2\2\u0081\u020e\3\2\2\2\u0083\u021b\3\2\2\2\u0085\u0228\3\2"+
		"\2\2\u0087\u022a\3\2\2\2\u0089\u0231\3\2\2\2\u008b\u0258\3\2\2\2\u008d"+
		"\u026c\3\2\2\2\u008f\u026e\3\2\2\2\u0091\u0274\3\2\2\2\u0093\u028e\3\2"+
		"\2\2\u0095\u0290\3\2\2\2\u0097\u0297\3\2\2\2\u0099\u02a6\3\2\2\2\u009b"+
		"\u02ab\3\2\2\2\u009d\u02b0\3\2\2\2\u009f\u02b6\3\2\2\2\u00a1\u02b9\3\2"+
		"\2\2\u00a3\u02bc\3\2\2\2\u00a5\u02c4\3\2\2\2\u00a7\u02cc\3\2\2\2\u00a9"+
		"\u02d2\3\2\2\2\u00ab\u02d8\3\2\2\2\u00ad\u00ae\7u\2\2\u00ae\u00af\7e\2"+
		"\2\u00af\u00b0\7j\2\2\u00b0\u00b1\7g\2\2\u00b1\u00b2\7o\2\2\u00b2\u00b3"+
		"\7c\2\2\u00b3\4\3\2\2\2\u00b4\u00b5\7^\2\2\u00b5\u00b6\7n\2\2\u00b6\u00b7"+
		"\7p\2\2\u00b7\u00b8\7q\2\2\u00b8\u00b9\7v\2\2\u00b9\6\3\2\2\2\u00ba\u00bb"+
		"\7^\2\2\u00bb\u00bc\7%\2\2\u00bc\b\3\2\2\2\u00bd\u00be\7t\2\2\u00be\u00bf"+
		"\7g\2\2\u00bf\u00c0\7x\2\2\u00c0\n\3\2\2\2\u00c1\u00c2\7o\2\2\u00c2\u00c3"+
		"\7k\2\2\u00c3\u00c4\7p\2\2\u00c4\f\3\2\2\2\u00c5\u00c6\7]\2\2\u00c6\16"+
		"\3\2\2\2\u00c7\u00c8\7>\2\2\u00c8\20\3\2\2\2\u00c9\u00ca\7h\2\2\u00ca"+
		"\u00cb\7c\2\2\u00cb\u00cc\7n\2\2\u00cc\u00cd\7u\2\2\u00cd\u00ce\7g\2\2"+
		"\u00ce\22\3\2\2\2\u00cf\u00d0\7a\2\2\u00d0\u00d1\7}\2\2\u00d1\u00d2\7"+
		"\63\2\2\u00d2\u00d3\7\177\2\2\u00d3\24\3\2\2\2\u00d4\u00d5\7^\2\2\u00d5"+
		"\u00d6\7f\2\2\u00d6\u00d7\7q\2\2\u00d7\u00d8\7o\2\2\u00d8\26\3\2\2\2\u00d9"+
		"\u00da\7^\2\2\u00da\u00db\7g\2\2\u00db\u00dc\7o\2\2\u00dc\u00dd\7r\2\2"+
		"\u00dd\u00de\7v\2\2\u00de\u00df\7{\2\2\u00df\u00e0\7u\2\2\u00e0\u00e1"+
		"\7g\2\2\u00e1\u00e2\7v\2\2\u00e2\30\3\2\2\2\u00e3\u00e4\7^\2\2\u00e4\u00e5"+
		"\7d\2\2\u00e5\u00e6\7k\2\2\u00e6\u00e7\7i\2\2\u00e7\u00e8\7e\2\2\u00e8"+
		"\u00e9\7c\2\2\u00e9\u00ea\7r\2\2\u00ea\32\3\2\2\2\u00eb\u00ec\7v\2\2\u00ec"+
		"\u00ed\7c\2\2\u00ed\u00ee\7k\2\2\u00ee\u00ef\7n\2\2\u00ef\34\3\2\2\2\u00f0"+
		"\u00f1\7\177\2\2\u00f1\36\3\2\2\2\u00f2\u00f3\7^\2\2\u00f3\u00f4\7p\2"+
		"\2\u00f4\u00f5\7q\2\2\u00f5\u00f6\7v\2\2\u00f6\u00f7\7k\2\2\u00f7\u00f8"+
		"\7p\2\2\u00f8 \3\2\2\2\u00f9\u00fa\7o\2\2\u00fa\u00fb\7c\2\2\u00fb\u00fc"+
		"\7z\2\2\u00fc\"\3\2\2\2\u00fd\u00fe\7^\2\2\u00fe\u00ff\7n\2\2\u00ff\u0100"+
		"\7c\2\2\u0100\u0101\7p\2\2\u0101\u0102\7f\2\2\u0102$\3\2\2\2\u0103\u0104"+
		"\7+\2\2\u0104&\3\2\2\2\u0105\u0106\7B\2\2\u0106(\3\2\2\2\u0107\u0108\7"+
		"^\2\2\u0108\u0109\7u\2\2\u0109\u010a\7g\2\2\u010a\u010b\7s\2\2\u010b*"+
		"\3\2\2\2\u010c\u010d\7j\2\2\u010d\u010e\7g\2\2\u010e\u010f\7c\2\2\u010f"+
		"\u0110\7f\2\2\u0110,\3\2\2\2\u0111\u0112\7?\2\2\u0112.\3\2\2\2\u0113\u0114"+
		"\7^\2\2\u0114\u0115\7n\2\2\u0115\u0116\7g\2\2\u0116\u0117\7s\2\2\u0117"+
		"\60\3\2\2\2\u0118\u0119\7^\2\2\u0119\u011a\7r\2\2\u011a\u011b\7t\2\2\u011b"+
		"\u011c\7g\2\2\u011c\u011d\7h\2\2\u011d\u011e\7k\2\2\u011e\u011f\7z\2\2"+
		"\u011f\62\3\2\2\2\u0120\u0121\7u\2\2\u0121\u0122\7s\2\2\u0122\u0123\7"+
		"w\2\2\u0123\u0124\7c\2\2\u0124\u0125\7u\2\2\u0125\u0126\7j\2\2\u0126\64"+
		"\3\2\2\2\u0127\u0128\7^\2\2\u0128\u0129\7p\2\2\u0129\u012a\7c\2\2\u012a"+
		"\u012b\7v\2\2\u012b\66\3\2\2\2\u012c\u012d\7^\2\2\u012d\u012e\7p\2\2\u012e"+
		"\u012f\7g\2\2\u012f\u0130\7s\2\2\u01308\3\2\2\2\u0131\u0132\7^\2\2\u0132"+
		"\u0133\7y\2\2\u0133\u0134\7j\2\2\u0134\u0135\7g\2\2\u0135\u0136\7t\2\2"+
		"\u0136\u0137\7g\2\2\u0137:\3\2\2\2\u0138\u0139\7^\2\2\u0139\u013a\7i\2"+
		"\2\u013a\u013b\7g\2\2\u013b\u013c\7s\2\2\u013c<\3\2\2\2\u013d\u013e\7"+
		"^\2\2\u013e\u013f\7d\2\2\u013f\u0140\7k\2\2\u0140\u0141\7i\2\2\u0141\u0142"+
		"\7e\2\2\u0142\u0143\7w\2\2\u0143\u0144\7r\2\2\u0144>\3\2\2\2\u0145\u0146"+
		"\7<\2\2\u0146\u0147\7<\2\2\u0147\u0148\7?\2\2\u0148@\3\2\2\2\u0149\u014a"+
		"\7^\2\2\u014a\u014b\7u\2\2\u014b\u014c\7w\2\2\u014c\u014d\7d\2\2\u014d"+
		"\u014e\7u\2\2\u014e\u014f\7g\2\2\u014f\u0150\7v\2\2\u0150\u0151\7g\2\2"+
		"\u0151\u0152\7s\2\2\u0152B\3\2\2\2\u0153\u0154\7~\2\2\u0154D\3\2\2\2\u0155"+
		"\u0156\7^\2\2\u0156\u0157\7g\2\2\u0157\u0158\7p\2\2\u0158\u0159\7f\2\2"+
		"\u0159\u015a\7}\2\2\u015aF\3\2\2\2\u015b\u015c\7^\2\2\u015c\u015d\7u\2"+
		"\2\u015d\u015e\7w\2\2\u015e\u015f\7h\2\2\u015f\u0160\7h\2\2\u0160\u0161"+
		"\7k\2\2\u0161\u0162\7z\2\2\u0162H\3\2\2\2\u0163\u0164\7_\2\2\u0164J\3"+
		"\2\2\2\u0165\u0166\7n\2\2\u0166\u0167\7c\2\2\u0167\u0168\7u\2\2\u0168"+
		"\u0169\7v\2\2\u0169L\3\2\2\2\u016a\u016b\7.\2\2\u016bN\3\2\2\2\u016c\u016d"+
		"\7\177\2\2\u016d\u016e\7}\2\2\u016eP\3\2\2\2\u016f\u0170\7*\2\2\u0170"+
		"R\3\2\2\2\u0171\u0172\7<\2\2\u0172T\3\2\2\2\u0173\u0174\7^\2\2\u0174\u0175"+
		"\7n\2\2\u0175\u0176\7q\2\2\u0176\u0177\7t\2\2\u0177V\3\2\2\2\u0178\u0179"+
		"\7^\2\2\u0179\u017a\7t\2\2\u017a\u017b\7c\2\2\u017b\u017c\7p\2\2\u017c"+
		"X\3\2\2\2\u017d\u017e\7^\2\2\u017e\u017f\7g\2\2\u017f\u0180\7p\2\2\u0180"+
		"\u0181\7f\2\2\u0181\u0182\7}\2\2\u0182\u0183\7|\2\2\u0183\u0184\7g\2\2"+
		"\u0184\u0185\7f\2\2\u0185\u0186\7\177\2\2\u0186Z\3\2\2\2\u0187\u0188\7"+
		"^\2\2\u0188\u0189\7k\2\2\u0189\u018a\7p\2\2\u018a\\\3\2\2\2\u018b\u018c"+
		"\7u\2\2\u018c\u018d\7g\2\2\u018d\u018e\7s\2\2\u018e\u018f\7a\2\2\u018f"+
		"\u0190\7}\2\2\u0190\u0191\7\63\2\2\u0191\u0192\7\177\2\2\u0192^\3\2\2"+
		"\2\u0193\u0194\7^\2\2\u0194\u0195\7t\2\2\u0195\u0196\7d\2\2\u0196\u0197"+
		"\7n\2\2\u0197\u0198\7q\2\2\u0198\u0199\7v\2\2\u0199`\3\2\2\2\u019a\u019b"+
		"\7^\2\2\u019b\u019c\7k\2\2\u019c\u019d\7p\2\2\u019d\u019e\7x\2\2\u019e"+
		"b\3\2\2\2\u019f\u01a0\7v\2\2\u01a0\u01a1\7t\2\2\u01a1\u01a2\7w\2\2\u01a2"+
		"\u01a3\7g\2\2\u01a3d\3\2\2\2\u01a4\u01a5\7^\2\2\u01a5\u01a6\7d\2\2\u01a6"+
		"\u01a7\7g\2\2\u01a7\u01a8\7i\2\2\u01a8\u01a9\7k\2\2\u01a9\u01aa\7p\2\2"+
		"\u01aa\u01ab\7}\2\2\u01abf\3\2\2\2\u01ac\u01ad\7^\2\2\u01ad\u01ae\7n\2"+
		"\2\u01ae\u01af\7d\2\2\u01af\u01b0\7n\2\2\u01b0\u01b1\7q\2\2\u01b1\u01b2"+
		"\7v\2\2\u01b2h\3\2\2\2\u01b3\u01b4\7^\2\2\u01b4\u01b5\7u\2\2\u01b5\u01b6"+
		"\7w\2\2\u01b6\u01b7\7d\2\2\u01b7\u01b8\7u\2\2\u01b8\u01b9\7g\2\2\u01b9"+
		"\u01ba\7v\2\2\u01baj\3\2\2\2\u01bb\u01bc\7^\2\2\u01bc\u01bd\7k\2\2\u01bd"+
		"\u01be\7h\2\2\u01be\u01bf\7h\2\2\u01bfl\3\2\2\2\u01c0\u01c1\7u\2\2\u01c1"+
		"\u01c2\7e\2\2\u01c2\u01c3\7j\2\2\u01c3\u01c4\7g\2\2\u01c4\u01c5\7o\2\2"+
		"\u01c5\u01c6\7c\2\2\u01c6\u01c7\7V\2\2\u01c7\u01c8\7{\2\2\u01c8\u01c9"+
		"\7r\2\2\u01c9\u01ca\7g\2\2\u01can\3\2\2\2\u01cb\u01cc\7^\2\2\u01cc\u01cd"+
		"\7k\2\2\u01cd\u01ce\7o\2\2\u01ce\u01cf\7r\2\2\u01cf\u01d0\7n\2\2\u01d0"+
		"\u01d1\7k\2\2\u01d1\u01d2\7g\2\2\u01d2\u01d3\7u\2\2\u01d3p\3\2\2\2\u01d4"+
		"\u01d5\7=\2\2\u01d5r\3\2\2\2\u01d6\u01d7\7h\2\2\u01d7\u01d8\7t\2\2\u01d8"+
		"\u01d9\7q\2\2\u01d9\u01da\7p\2\2\u01da\u01db\7v\2\2\u01dbt\3\2\2\2\u01dc"+
		"\u01dd\7@\2\2\u01ddv\3\2\2\2\u01de\u01df\7^\2\2\u01df\u01e0\7p\2\2\u01e0"+
		"\u01e1\7g\2\2\u01e1\u01e2\7i\2\2\u01e2\u01e3\7c\2\2\u01e3\u01e4\7v\2\2"+
		"\u01e4\u01e5\7g\2\2\u01e5x\3\2\2\2\u01e6\u01e7\7^\2\2\u01e7\u01e8\7d\2"+
		"\2\u01e8\u01e9\7g\2\2\u01e9\u01ea\7i\2\2\u01ea\u01eb\7k\2\2\u01eb\u01ec"+
		"\7p\2\2\u01ec\u01ed\7}\2\2\u01ed\u01ee\7|\2\2\u01ee\u01ef\7g\2\2\u01ef"+
		"\u01f0\7f\2\2\u01f0\u01f1\7\177\2\2\u01f1z\3\2\2\2\u01f2\u01f3\7^\2\2"+
		"\u01f3\u01f4\7p\2\2\u01f4\u01f5\7w\2\2\u01f5\u01f6\7o\2\2\u01f6|\3\2\2"+
		"\2\u01f7\u01f8\7?\2\2\u01f8\u01f9\7?\2\2\u01f9~\3\2\2\2\u01fa\u01fb\7"+
		"^\2\2\u01fb\u01fc\7e\2\2\u01fc\u01fd\7t\2\2\u01fd\u01fe\7q\2\2\u01fe\u01ff"+
		"\7u\2\2\u01ff\u0200\7u\2\2\u0200\u0080\3\2\2\2\u0201\u0202\7^\2\2\u0202"+
		"\u0203\7r\2\2\u0203\u0204\7q\2\2\u0204\u0205\7y\2\2\u0205\u0206\7g\2\2"+
		"\u0206\u020f\7t\2\2\u0207\u0208\7^\2\2\u0208\u0209\7h\2\2\u0209\u020a"+
		"\7k\2\2\u020a\u020b\7p\2\2\u020b\u020c\7u\2\2\u020c\u020d\7g\2\2\u020d"+
		"\u020f\7v\2\2\u020e\u0201\3\2\2\2\u020e\u0207\3\2\2\2\u020f\u0082\3\2"+
		"\2\2\u0210\u0211\7^\2\2\u0211\u0212\7f\2\2\u0212\u0213\7t\2\2\u0213\u0214"+
		"\7g\2\2\u0214\u021c\7u\2\2\u0215\u0216\7^\2\2\u0216\u0217\7p\2\2\u0217"+
		"\u0218\7f\2\2\u0218\u0219\7t\2\2\u0219\u021a\7g\2\2\u021a\u021c\7u\2\2"+
		"\u021b\u0210\3\2\2\2\u021b\u0215\3\2\2\2\u021c\u0084\3\2\2\2\u021d\u021e"+
		"\7^\2\2\u021e\u021f\7t\2\2\u021f\u0220\7t\2\2\u0220\u0221\7g\2\2\u0221"+
		"\u0229\7u\2\2\u0222\u0223\7^\2\2\u0223\u0224\7p\2\2\u0224\u0225\7t\2\2"+
		"\u0225\u0226\7t\2\2\u0226\u0227\7g\2\2\u0227\u0229\7u\2\2\u0228\u021d"+
		"\3\2\2\2\u0228\u0222\3\2\2\2\u0229\u0086\3\2\2\2\u022a\u022b\7^\2\2\u022b"+
		"\u022c\7q\2\2\u022c\u022d\7r\2\2\u022d\u022e\7n\2\2\u022e\u022f\7w\2\2"+
		"\u022f\u0230\7u\2\2\u0230\u0088\3\2\2\2\u0231\u0232\7^\2\2\u0232\u0233"+
		"\7g\2\2\u0233\u0234\7z\2\2\u0234\u0235\7v\2\2\u0235\u0236\7t\2\2\u0236"+
		"\u0237\7c\2\2\u0237\u0238\7e\2\2\u0238\u0239\7v\2\2\u0239\u008a\3\2\2"+
		"\2\u023a\u0259\7,\2\2\u023b\u023c\7^\2\2\u023c\u023d\7f\2\2\u023d\u023e"+
		"\7k\2\2\u023e\u0259\7x\2\2\u023f\u0240\7^\2\2\u0240\u0241\7o\2\2\u0241"+
		"\u0242\7q\2\2\u0242\u0259\7f\2\2\u0243\u0244\7^\2\2\u0244\u0245\7e\2\2"+
		"\u0245\u0246\7c\2\2\u0246\u0259\7r\2\2\u0247\u0248\7^\2\2\u0248\u0249"+
		"\7h\2\2\u0249\u024a\7k\2\2\u024a\u024b\7n\2\2\u024b\u024c\7v\2\2\u024c"+
		"\u024d\7g\2\2\u024d\u0259\7t\2\2\u024e\u024f\7^\2\2\u024f\u0250\7e\2\2"+
		"\u0250\u0251\7q\2\2\u0251\u0252\7o\2\2\u0252\u0259\7r\2\2\u0253\u0254"+
		"\7^\2\2\u0254\u0255\7e\2\2\u0255\u0256\7k\2\2\u0256\u0257\7t\2\2\u0257"+
		"\u0259\7e\2\2\u0258\u023a\3\2\2\2\u0258\u023b\3\2\2\2\u0258\u023f\3\2"+
		"\2\2\u0258\u0243\3\2\2\2\u0258\u0247\3\2\2\2\u0258\u024e\3\2\2\2\u0258"+
		"\u0253\3\2\2\2\u0259\u008c\3\2\2\2\u025a\u026d\t\2\2\2\u025b\u025c\7^"+
		"\2\2\u025c\u025d\7e\2\2\u025d\u025e\7w\2\2\u025e\u026d\7r\2\2\u025f\u0260"+
		"\7^\2\2\u0260\u0261\7u\2\2\u0261\u0262\7g\2\2\u0262\u0263\7v\2\2\u0263"+
		"\u0264\7o\2\2\u0264\u0265\7k\2\2\u0265\u0266\7p\2\2\u0266\u0267\7w\2\2"+
		"\u0267\u026d\7u\2\2\u0268\u0269\7^\2\2\u0269\u026a\7e\2\2\u026a\u026b"+
		"\7c\2\2\u026b\u026d\7v\2\2\u026c\u025a\3\2\2\2\u026c\u025b\3\2\2\2\u026c"+
		"\u025f\3\2\2\2\u026c\u0268\3\2\2\2\u026d\u008e\3\2\2\2\u026e\u026f\7^"+
		"\2\2\u026f\u0270\7w\2\2\u0270\u0271\7r\2\2\u0271\u0272\7v\2\2\u0272\u0273"+
		"\7q\2\2\u0273\u0090\3\2\2\2\u0274\u0275\7^\2\2\u0275\u0276\7o\2\2\u0276"+
		"\u0277\7c\2\2\u0277\u0278\7r\2\2\u0278\u0279\7u\2\2\u0279\u027a\7v\2\2"+
		"\u027a\u027b\7q\2\2\u027b\u0092\3\2\2\2\u027c\u027d\7^\2\2\u027d\u027e"+
		"\7t\2\2\u027e\u027f\7g\2\2\u027f\u028f\7n\2\2\u0280\u0281\7^\2\2\u0281"+
		"\u0282\7r\2\2\u0282\u0283\7h\2\2\u0283\u0284\7w\2\2\u0284\u028f\7p\2\2"+
		"\u0285\u0286\7^\2\2\u0286\u0287\7h\2\2\u0287\u0288\7w\2\2\u0288\u028f"+
		"\7p\2\2\u0289\u028a\7^\2\2\u028a\u028b\7h\2\2\u028b\u028c\7h\2\2\u028c"+
		"\u028d\7w\2\2\u028d\u028f\7p\2\2\u028e\u027c\3\2\2\2\u028e\u0280\3\2\2"+
		"\2\u028e\u0285\3\2\2\2\u028e\u0289\3\2\2\2\u028f\u0094\3\2\2\2\u0290\u0291"+
		"\7\60\2\2\u0291\u0096\3\2\2\2\u0292\u0298\t\3\2\2\u0293\u0294\7^\2\2\u0294"+
		"\u0295\7a\2\2\u0295\u0298\7\"\2\2\u0296\u0298\7A\2\2\u0297\u0292\3\2\2"+
		"\2\u0297\u0293\3\2\2\2\u0297\u0296\3\2\2\2\u0298\u0299\3\2\2\2\u0299\u0297"+
		"\3\2\2\2\u0299\u029a\3\2\2\2\u029a\u02a2\3\2\2\2\u029b\u02a1\t\4\2\2\u029c"+
		"\u029d\7^\2\2\u029d\u029e\7a\2\2\u029e\u02a1\7\"\2\2\u029f\u02a1\t\5\2"+
		"\2\u02a0\u029b\3\2\2\2\u02a0\u029c\3\2\2\2\u02a0\u029f\3\2\2\2\u02a1\u02a4"+
		"\3\2\2\2\u02a2\u02a0\3\2\2\2\u02a2\u02a3\3\2\2\2\u02a3\u0098\3\2\2\2\u02a4"+
		"\u02a2\3\2\2\2\u02a5\u02a7\4\62;\2\u02a6\u02a5\3\2\2\2\u02a7\u02a8\3\2"+
		"\2\2\u02a8\u02a6\3\2\2\2\u02a8\u02a9\3\2\2\2\u02a9\u009a\3\2\2\2\u02aa"+
		"\u02ac\7\17\2\2\u02ab\u02aa\3\2\2\2\u02ab\u02ac\3\2\2\2\u02ac\u02ad\3"+
		"\2\2\2\u02ad\u02ae\7\f\2\2\u02ae\u009c\3\2\2\2\u02af\u02b1\t\6\2\2\u02b0"+
		"\u02af\3\2\2\2\u02b1\u02b2\3\2\2\2\u02b2\u02b0\3\2\2\2\u02b2\u02b3\3\2"+
		"\2\2\u02b3\u02b4\3\2\2\2\u02b4\u02b5\bO\2\2\u02b5\u009e\3\2\2\2\u02b6"+
		"\u02b7\7^\2\2\u02b7\u02b8\7}\2\2\u02b8\u00a0\3\2\2\2\u02b9\u02ba\7^\2"+
		"\2\u02ba\u02bb\7\177\2\2\u02bb\u00a2\3\2\2\2\u02bc\u02bd\7^\2\2\u02bd"+
		"\u02be\7n\2\2\u02be\u02bf\7c\2\2\u02bf\u02c0\7p\2\2\u02c0\u02c1\7i\2\2"+
		"\u02c1\u02c2\7n\2\2\u02c2\u02c3\7g\2\2\u02c3\u00a4\3\2\2\2\u02c4\u02c5"+
		"\7^\2\2\u02c5\u02c6\7t\2\2\u02c6\u02c7\7c\2\2\u02c7\u02c8\7p\2\2\u02c8"+
		"\u02c9\7i\2\2\u02c9\u02ca\7n\2\2\u02ca\u02cb\7g\2\2\u02cb\u00a6\3\2\2"+
		"\2\u02cc\u02cd\7^\2\2\u02cd\u02ce\7n\2\2\u02ce\u02cf\7k\2\2\u02cf\u02d0"+
		"\7o\2\2\u02d0\u02d1\7i\2\2\u02d1\u00a8\3\2\2\2\u02d2\u02d3\7^\2\2\u02d3"+
		"\u02d4\7t\2\2\u02d4\u02d5\7k\2\2\u02d5\u02d6\7o\2\2\u02d6\u02d7\7i\2\2"+
		"\u02d7\u00aa\3\2\2\2\u02d8\u02d9\7^\2\2\u02d9\u02da\7^\2\2\u02da\u02db"+
		"\bV\3\2\u02db\u00ac\3\2\2\2\20\2\u020e\u021b\u0228\u0258\u026c\u028e\u0297"+
		"\u0299\u02a0\u02a2\u02a8\u02ab\u02b2";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}