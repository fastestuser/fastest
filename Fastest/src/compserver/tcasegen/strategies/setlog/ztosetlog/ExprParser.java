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
	

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ExprParser extends Parser {
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
		T__1=60, T__0=61, CROSS=62, POWER=63, IN_FUN_65=64, IN_FUN_60=65, IN_FUN_50=66, 
		IN_FUN_45=67, IN_FUN_40=68, IN_FUN_30=69, IN_FUN_20=70, IN_FUN_10=71, 
		IN_FUN_5=72, SELECTION=73, NAME=74, NUM=75, DECORATION=76, NL=77, WS=78, 
		SETSTART=79, SETEND=80, LISTSTART=81, LISTEND=82, IMGSTART=83, IMGEND=84, 
		SKIP=85;
	public static final String[] tokenNames = {
		"<INVALID>", "'schema'", "'\\lnot'", "'\\#'", "'rev'", "'min'", "'['", 
		"'<'", "'false'", "'_{1}'", "'\\dom'", "'\\emptyset'", "'\\bigcap'", "'tail'", 
		"'}'", "'\\notin'", "'max'", "'\\land'", "')'", "'@'", "'\\seq'", "'head'", 
		"'='", "'\\leq'", "'\\prefix'", "'squash'", "'\\nat'", "'\\neq'", "'\\where'", 
		"'\\geq'", "'\\bigcup'", "'::='", "'\\subseteq'", "'|'", "'\\end{'", "'\\suffix'", 
		"']'", "'last'", "','", "'}{'", "'('", "':'", "'\\lor'", "'\\ran'", "'\\end{zed}'", 
		"'seq_{1}'", "'\\in'", "'\\rblot'", "'\\inv'", "'true'", "'\\begin{'", 
		"'\\lblot'", "'\\subset'", "'\\iff'", "'schemaType'", "'\\implies'", "';'", 
		"'front'", "'>'", "'\\begin{zed}'", "'\\num'", "'=='", "'\\cross'", "POWER", 
		"IN_FUN_65", "IN_FUN_60", "IN_FUN_50", "IN_FUN_45", "IN_FUN_40", "IN_FUN_30", 
		"IN_FUN_20", "IN_FUN_10", "IN_FUN_5", "'.'", "NAME", "NUM", "'~'", "NL", 
		"WS", "'\\{'", "'\\}'", "'\\langle'", "'\\rangle'", "'\\limg'", "'\\rimg'", 
		"SKIP"
	};
	public static final int
		RULE_specification = 0, RULE_paragraph = 1, RULE_basic_type = 2, RULE_equivalent_type = 3, 
		RULE_enumeration_type = 4, RULE_schemaText = 5, RULE_declPart = 6, RULE_declaration = 7, 
		RULE_declName = 8, RULE_predicate = 9, RULE_expression = 10, RULE_endExpression = 11, 
		RULE_refName = 12, RULE_post = 13, RULE_pre = 14;
	public static final String[] ruleNames = {
		"specification", "paragraph", "basic_type", "equivalent_type", "enumeration_type", 
		"schemaText", "declPart", "declaration", "declName", "predicate", "expression", 
		"endExpression", "refName", "post", "pre"
	};

	@Override
	public String getGrammarFileName() { return "Expr.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public ATN getATN() { return _ATN; }


		
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
					print(translation + " = int(-10000000000, 10000000000)");
				else if (type.equals("\\nat"))
					print(translation + " = int(0, 10000000000)");
				else if (type.equals("\\nat_{1}"))
					print(translation + " = int(1, 10000000000)");
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

	public ExprParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class SpecificationContext extends ParserRuleContext {
		public ParagraphContext paragraph(int i) {
			return getRuleContext(ParagraphContext.class,i);
		}
		public List<ParagraphContext> paragraph() {
			return getRuleContexts(ParagraphContext.class);
		}
		public List<TerminalNode> NL() { return getTokens(ExprParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(ExprParser.NL, i);
		}
		public SpecificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_specification; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterSpecification(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitSpecification(this);
		}
	}

	public final SpecificationContext specification() throws RecognitionException {
		SpecificationContext _localctx = new SpecificationContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_specification);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(37); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(30); paragraph();
				setState(34);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(31); match(NL);
					}
					}
					setState(36);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(39); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==50 || _la==59 );
			/*
				   System.out.println("tablita de tippos");
				   System.out.println("-------------------");
				   String key, value;
				   Iterator<String> iterator = types.keySet().iterator();
				   while (iterator.hasNext()) {
				           key = iterator.next();
				           value = types.get(key);
				           System.out.println(key + "\t\t| " + value);
				   }
				   System.out.println("\ntablita de memory");
				   System.out.println("-------------------");
				   iterator = memory.keySet().iterator();
				   while (iterator.hasNext()) {
				           key = iterator.next();
				           value = memory.get(key);
				           System.out.println(key + "\t\t| " + value);
				   }
				   System.out.println("\ntablita de zVars");
				   System.out.println("-------------------");
				   iterator = zVars.keySet().iterator();
				   while (iterator.hasNext()) {
			           key = iterator.next();
			           value = zVars.get(key);
			           System.out.println(key + "\t\t| " + value);
			  	   }
			     
				*/
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParagraphContext extends ParserRuleContext {
		public Token NAME;
		public SchemaTextContext schemaText() {
			return getRuleContext(SchemaTextContext.class,0);
		}
		public Equivalent_typeContext equivalent_type(int i) {
			return getRuleContext(Equivalent_typeContext.class,i);
		}
		public TerminalNode NAME() { return getToken(ExprParser.NAME, 0); }
		public List<Basic_typeContext> basic_type() {
			return getRuleContexts(Basic_typeContext.class);
		}
		public List<Enumeration_typeContext> enumeration_type() {
			return getRuleContexts(Enumeration_typeContext.class);
		}
		public List<TerminalNode> NL() { return getTokens(ExprParser.NL); }
		public List<Equivalent_typeContext> equivalent_type() {
			return getRuleContexts(Equivalent_typeContext.class);
		}
		public Basic_typeContext basic_type(int i) {
			return getRuleContext(Basic_typeContext.class,i);
		}
		public Enumeration_typeContext enumeration_type(int i) {
			return getRuleContext(Enumeration_typeContext.class,i);
		}
		public TerminalNode NL(int i) {
			return getToken(ExprParser.NL, i);
		}
		public ParagraphContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paragraph; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterParagraph(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitParagraph(this);
		}
	}

	public final ParagraphContext paragraph() throws RecognitionException {
		ParagraphContext _localctx = new ParagraphContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_paragraph);
		int _la;
		try {
			setState(79);
			switch (_input.LA(1)) {
			case 50:
				enterOuterAlt(_localctx, 1);
				{
				setState(43); match(50);
				setState(47);
				switch (_input.LA(1)) {
				case 1:
					{
					setState(44); match(1);
					}
					break;
				case 54:
					{
					{
					setState(45); match(54);
					tipoSchema = 1; schemaTypeVars = new HashMap<String,String>();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(49); match(39);
				setState(50); ((ParagraphContext)_localctx).NAME = match(NAME);
				setState(51); match(14);
				setState(52); schemaText();

							if (tipoSchema == 1) {
								String newVarName = newVar((((ParagraphContext)_localctx).NAME!=null?((ParagraphContext)_localctx).NAME.getText():null));
								memory.put((((ParagraphContext)_localctx).NAME!=null?((ParagraphContext)_localctx).NAME.getText():null), newVarName);
								String vars = "";
								
								List<String> sortedVars = new ArrayList<String>(schemaTypeVars.keySet());
								java.util.Collections.sort(sortedVars);
								
								int i = 0;
								while( i < sortedVars.size() ){
								
									String type = schemaTypeVars.get(sortedVars.get(i));
								
									vars = vars.concat(sortedVars.get(i) + ":" + type);
						
									if (i+1 < sortedVars.size()){
										vars = vars.concat(",");
									}
									i++;
								}
								
								types.put((((ParagraphContext)_localctx).NAME!=null?((ParagraphContext)_localctx).NAME.getText():null), "SchemaType:" + newVarName + ":[" + vars + "]");
								vars = "";
							}
						
				setState(54); match(34);
				setState(58);
				switch (_input.LA(1)) {
				case 1:
					{
					setState(55); match(1);
					}
					break;
				case 54:
					{
					{
					setState(56); match(54);
					tipoSchema = 0;
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(60); match(14);
				}
				break;
			case 59:
				enterOuterAlt(_localctx, 2);
				{
				setState(62); match(59);
				setState(64);
				_la = _input.LA(1);
				if (_la==NL) {
					{
					setState(63); match(NL);
					}
				}

				setState(73); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(69);
					switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
					case 1:
						{
						setState(66); basic_type();
						}
						break;

					case 2:
						{
						setState(67); equivalent_type();
						}
						break;

					case 3:
						{
						setState(68); enumeration_type();
						}
						break;
					}
					setState(71); match(NL);
					}
					}
					setState(75); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==6 || _la==NAME );
				setState(77); match(44);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Basic_typeContext extends ParserRuleContext {
		public ArrayList<String> typeList;;
		public DeclNameContext a;
		public DeclNameContext declName;
		public DeclNameContext b;
		public List<DeclNameContext> declName() {
			return getRuleContexts(DeclNameContext.class);
		}
		public DeclNameContext declName(int i) {
			return getRuleContext(DeclNameContext.class,i);
		}
		public Basic_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_basic_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterBasic_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitBasic_type(this);
		}
	}

	public final Basic_typeContext basic_type() throws RecognitionException {
		Basic_typeContext _localctx = new Basic_typeContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_basic_type);
		((Basic_typeContext)getInvokingContext(2)).typeList =  new ArrayList<String>();
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81); match(6);
			setState(82); ((Basic_typeContext)_localctx).a = ((Basic_typeContext)_localctx).declName = declName();
			((Basic_typeContext)getInvokingContext(2)).typeList.add((((Basic_typeContext)_localctx).a!=null?_input.getText(((Basic_typeContext)_localctx).a.start,((Basic_typeContext)_localctx).a.stop):null));
			setState(90);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==38) {
				{
				{
				setState(84); match(38);
				setState(85); ((Basic_typeContext)_localctx).b = ((Basic_typeContext)_localctx).declName = declName();
				((Basic_typeContext)getInvokingContext(2)).typeList.add((((Basic_typeContext)_localctx).b!=null?_input.getText(((Basic_typeContext)_localctx).b.start,((Basic_typeContext)_localctx).b.stop):null));
				}
				}
				setState(92);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(93); match(36);

					while( !((Basic_typeContext)getInvokingContext(2)).typeList.isEmpty() ) {
						String type = ((Basic_typeContext)getInvokingContext(2)).typeList.remove(0);
						
						String newVarName = newVar((((Basic_typeContext)_localctx).declName!=null?_input.getText(((Basic_typeContext)_localctx).declName.start,((Basic_typeContext)_localctx).declName.stop):null));
						memory.put(type, newVarName);
						print("set(" + newVarName + ")");
						types.put(type, "BasicType:" + newVarName);
					}
				
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Equivalent_typeContext extends ParserRuleContext {
		public DeclNameContext declName;
		public ExpressionContext expression;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public DeclNameContext declName() {
			return getRuleContext(DeclNameContext.class,0);
		}
		public Equivalent_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equivalent_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterEquivalent_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitEquivalent_type(this);
		}
	}

	public final Equivalent_typeContext equivalent_type() throws RecognitionException {
		Equivalent_typeContext _localctx = new Equivalent_typeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_equivalent_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96); ((Equivalent_typeContext)_localctx).declName = declName();
			setState(97); match(61);
			setState(98); ((Equivalent_typeContext)_localctx).expression = expression(0);
			 
					String type = types.get((((Equivalent_typeContext)_localctx).expression!=null?_input.getText(((Equivalent_typeContext)_localctx).expression.start,((Equivalent_typeContext)_localctx).expression.stop):null));
					if (type != null) {
						types.put((((Equivalent_typeContext)_localctx).declName!=null?_input.getText(((Equivalent_typeContext)_localctx).declName.start,((Equivalent_typeContext)_localctx).declName.stop):null), type);
					}
				
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Enumeration_typeContext extends ParserRuleContext {
		public ArrayList<String> cases;;
		public DeclNameContext d;
		public DeclNameContext a;
		public DeclNameContext b;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<DeclNameContext> declName() {
			return getRuleContexts(DeclNameContext.class);
		}
		public DeclNameContext declName(int i) {
			return getRuleContext(DeclNameContext.class,i);
		}
		public Enumeration_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumeration_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterEnumeration_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitEnumeration_type(this);
		}
	}

	public final Enumeration_typeContext enumeration_type() throws RecognitionException {
		Enumeration_typeContext _localctx = new Enumeration_typeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_enumeration_type);
		((Enumeration_typeContext)getInvokingContext(4)).cases =  new ArrayList<String>();
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(101); ((Enumeration_typeContext)_localctx).d = declName();
			setState(102); match(31);
			setState(103); ((Enumeration_typeContext)_localctx).a = declName();
			((Enumeration_typeContext)getInvokingContext(4)).cases.add((((Enumeration_typeContext)_localctx).a!=null?_input.getText(((Enumeration_typeContext)_localctx).a.start,((Enumeration_typeContext)_localctx).a.stop):null));
			setState(106);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 3) | (1L << 4) | (1L << 5) | (1L << 10) | (1L << 11) | (1L << 12) | (1L << 13) | (1L << 16) | (1L << 20) | (1L << 21) | (1L << 25) | (1L << 26) | (1L << 30) | (1L << 37) | (1L << 40) | (1L << 43) | (1L << 45) | (1L << 51) | (1L << 57) | (1L << 60) | (1L << POWER))) != 0) || ((((_la - 74)) & ~0x3f) == 0 && ((1L << (_la - 74)) & ((1L << (NAME - 74)) | (1L << (NUM - 74)) | (1L << (SETSTART - 74)) | (1L << (LISTSTART - 74)))) != 0)) {
				{
				setState(105); expression(0);
				}
			}

			setState(116);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==33) {
				{
				{
				setState(108); match(33);
				setState(109); ((Enumeration_typeContext)_localctx).b = declName();
				((Enumeration_typeContext)getInvokingContext(4)).cases.add((((Enumeration_typeContext)_localctx).b!=null?_input.getText(((Enumeration_typeContext)_localctx).b.start,((Enumeration_typeContext)_localctx).b.stop):null));
				setState(112);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 3) | (1L << 4) | (1L << 5) | (1L << 10) | (1L << 11) | (1L << 12) | (1L << 13) | (1L << 16) | (1L << 20) | (1L << 21) | (1L << 25) | (1L << 26) | (1L << 30) | (1L << 37) | (1L << 40) | (1L << 43) | (1L << 45) | (1L << 51) | (1L << 57) | (1L << 60) | (1L << POWER))) != 0) || ((((_la - 74)) & ~0x3f) == 0 && ((1L << (_la - 74)) & ((1L << (NAME - 74)) | (1L << (NUM - 74)) | (1L << (SETSTART - 74)) | (1L << (LISTSTART - 74)))) != 0)) {
					{
					setState(111); expression(0);
					}
				}

				}
				}
				setState(118);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
				
					String elements = new String();
					while( !((Enumeration_typeContext)getInvokingContext(4)).cases.isEmpty() ){
						String e = ((Enumeration_typeContext)getInvokingContext(4)).cases.remove(0);
						String eMinus = e.substring(0,1).toLowerCase() + e.substring(1); //Pasamos la primer mayuscula a minuscula ya que setlog asi lo precisa
						elements = elements.concat(eMinus);
						
						memory.put(e, eMinus);
						types.put(e, (((Enumeration_typeContext)_localctx).d!=null?_input.getText(((Enumeration_typeContext)_localctx).d.start,((Enumeration_typeContext)_localctx).d.stop):null));
						
						if (!((Enumeration_typeContext)getInvokingContext(4)).cases.isEmpty()){
							elements = elements.concat(",");
						}
					}
					if (types.get((((Enumeration_typeContext)_localctx).d!=null?_input.getText(((Enumeration_typeContext)_localctx).d.start,((Enumeration_typeContext)_localctx).d.stop):null)) == null) {
						//Le asigno un nombre al conjunto
						String newVarName = newVar((((Enumeration_typeContext)_localctx).d!=null?_input.getText(((Enumeration_typeContext)_localctx).d.start,((Enumeration_typeContext)_localctx).d.stop):null));
						memory.put((((Enumeration_typeContext)_localctx).d!=null?_input.getText(((Enumeration_typeContext)_localctx).d.start,((Enumeration_typeContext)_localctx).d.stop):null), newVarName);
						types.put((((Enumeration_typeContext)_localctx).d!=null?_input.getText(((Enumeration_typeContext)_localctx).d.start,((Enumeration_typeContext)_localctx).d.stop):null), "EnumerationType:" + newVarName + ":{" + elements + "}");
						print(newVarName + " = {" + elements + "}");
					}
				
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SchemaTextContext extends ParserRuleContext {
		public PredicateContext predicate(int i) {
			return getRuleContext(PredicateContext.class,i);
		}
		public List<TerminalNode> NL() { return getTokens(ExprParser.NL); }
		public List<PredicateContext> predicate() {
			return getRuleContexts(PredicateContext.class);
		}
		public DeclPartContext declPart() {
			return getRuleContext(DeclPartContext.class,0);
		}
		public TerminalNode NL(int i) {
			return getToken(ExprParser.NL, i);
		}
		public SchemaTextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_schemaText; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterSchemaText(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitSchemaText(this);
		}
	}

	public final SchemaTextContext schemaText() throws RecognitionException {
		SchemaTextContext _localctx = new SchemaTextContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_schemaText);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121); match(NL);
			setState(125);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				setState(122); declPart();
				setState(123); match(NL);
				}
				break;
			}
			setState(129);
			_la = _input.LA(1);
			if (_la==28) {
				{
				setState(127); match(28);
				setState(128); match(NL);
				}
			}

			setState(136);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 2) | (1L << 3) | (1L << 4) | (1L << 5) | (1L << 8) | (1L << 10) | (1L << 11) | (1L << 12) | (1L << 13) | (1L << 16) | (1L << 20) | (1L << 21) | (1L << 25) | (1L << 26) | (1L << 30) | (1L << 37) | (1L << 40) | (1L << 43) | (1L << 45) | (1L << 49) | (1L << 51) | (1L << 57) | (1L << 60) | (1L << POWER))) != 0) || ((((_la - 74)) & ~0x3f) == 0 && ((1L << (_la - 74)) & ((1L << (NAME - 74)) | (1L << (NUM - 74)) | (1L << (SETSTART - 74)) | (1L << (LISTSTART - 74)))) != 0)) {
				{
				{
				setState(131); predicate(0);
				setState(132); match(NL);
				}
				}
				setState(138);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclPartContext extends ParserRuleContext {
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public List<TerminalNode> NL() { return getTokens(ExprParser.NL); }
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public TerminalNode NL(int i) {
			return getToken(ExprParser.NL, i);
		}
		public DeclPartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declPart; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterDeclPart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitDeclPart(this);
		}
	}

	public final DeclPartContext declPart() throws RecognitionException {
		DeclPartContext _localctx = new DeclPartContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_declPart);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(139); declaration();
			setState(144);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(140);
					_la = _input.LA(1);
					if ( !(_la==56 || _la==NL) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					setState(141); declaration();
					}
					} 
				}
				setState(146);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclarationContext extends ParserRuleContext {
		public ArrayList<String> vars;;
		public DeclNameContext a;
		public DeclNameContext b;
		public ExpressionContext expression;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<DeclNameContext> declName() {
			return getRuleContexts(DeclNameContext.class);
		}
		public DeclNameContext declName(int i) {
			return getRuleContext(DeclNameContext.class,i);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitDeclaration(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_declaration);
		((DeclarationContext)getInvokingContext(7)).vars =  new ArrayList<String>();
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147); ((DeclarationContext)_localctx).a = declName();
			((DeclarationContext)getInvokingContext(7)).vars.add((((DeclarationContext)_localctx).a!=null?_input.getText(((DeclarationContext)_localctx).a.start,((DeclarationContext)_localctx).a.stop):null));
			setState(155);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==38) {
				{
				{
				setState(149); match(38);
				setState(150); ((DeclarationContext)_localctx).b = declName();
				((DeclarationContext)getInvokingContext(7)).vars.add((((DeclarationContext)_localctx).b!=null?_input.getText(((DeclarationContext)_localctx).b.start,((DeclarationContext)_localctx).b.stop):null));
				}
				}
				setState(157);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(158); match(41);
			setState(159); ((DeclarationContext)_localctx).expression = expression(0);

					//Para cada variable realizamos el procesamiento
					while( !((DeclarationContext)getInvokingContext(7)).vars.isEmpty() ) {

						String var = ((DeclarationContext)getInvokingContext(7)).vars.remove(0);

						if (tipoSchema == 0)
							zVars.put(var, null); //Marcamos la variable como variable Z, a la cual posiblemente se le deba asignarsele un valor

						String newVarName = newVar(var);
						if (tipoSchema == 0)
							memory.put(var, newVarName);
						if (modoSetExpression==1)
							setExpressionVars.put(var, newVarName);
						
						String expType = types.get((((DeclarationContext)_localctx).expression!=null?_input.getText(((DeclarationContext)_localctx).expression.start,((DeclarationContext)_localctx).expression.stop):null));
						expType = typeInfo(newVarName, expType);
						
						/*
						//Chequeo si es un tipo basico, ej [ACCNUM], ya que estos no se imprimen en typeInfo
						String t = types.get(expType);
						if (t != null && t.startsWith("BasicType"))
							print(newVarName + " in " + expType);
						*/
						
						if (tipoSchema == 0)
							types.put(var, expType);
						else { //La agregamos como variable del esquema
							schemaTypeVars.put(var,expType);
						}
					}
				
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclNameContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(ExprParser.NAME, 0); }
		public DeclNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterDeclName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitDeclName(this);
		}
	}

	public final DeclNameContext declName() throws RecognitionException {
		DeclNameContext _localctx = new DeclNameContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_declName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162); match(NAME);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PredicateContext extends ParserRuleContext {
		public int _p;
		public ExpressionContext e1;
		public ExpressionContext e2;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public PredicateContext predicate(int i) {
			return getRuleContext(PredicateContext.class,i);
		}
		public List<PredicateContext> predicate() {
			return getRuleContexts(PredicateContext.class);
		}
		public PredicateContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public PredicateContext(ParserRuleContext parent, int invokingState, int _p) {
			super(parent, invokingState);
			this._p = _p;
		}
		@Override public int getRuleIndex() { return RULE_predicate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterPredicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitPredicate(this);
		}
	}

	public final PredicateContext predicate(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		PredicateContext _localctx = new PredicateContext(_ctx, _parentState, _p);
		PredicateContext _prevctx = _localctx;
		int _startState = 18;
		enterRecursionRule(_localctx, RULE_predicate);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(251);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				{
				setState(165); ((PredicateContext)_localctx).e1 = expression(0);
				setState(166); match(46);
				setState(167); ((PredicateContext)_localctx).e2 = expression(0);

						String a, b;
						a = memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						
						//Si b es una lista, debo convertirla
						b = convertToSet((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null), b);
						
						print(a + " in " + b);
					
				}
				break;

			case 2:
				{
				setState(179);
				switch (_input.LA(1)) {
				case 3:
				case 4:
				case 5:
				case 10:
				case 11:
				case 12:
				case 13:
				case 16:
				case 20:
				case 21:
				case 25:
				case 26:
				case 30:
				case 37:
				case 40:
				case 43:
				case 45:
				case 51:
				case 57:
				case 60:
				case POWER:
				case NAME:
				case NUM:
				case SETSTART:
				case LISTSTART:
					{
					setState(170); ((PredicateContext)_localctx).e1 = expression(0);
					setState(171); match(15);
					setState(172); ((PredicateContext)_localctx).e2 = expression(0);
					}
					break;
				case 2:
					{
					setState(174); match(2);
					setState(175); ((PredicateContext)_localctx).e1 = expression(0);
					setState(176); match(46);
					setState(177); ((PredicateContext)_localctx).e2 = expression(0);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}

						String a, b;
						a = memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						
						//Si b es una lista, debo convertirla
						b = convertToSet((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null), b);
						
						print(a + " nin " + b);
					
				}
				break;

			case 3:
				{
				setState(183); ((PredicateContext)_localctx).e1 = expression(0);
				setState(184); match(7);
				setState(185); ((PredicateContext)_localctx).e2 = expression(0);

						String a, b;
						a = memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						print(a + " < " + b);
					
				}
				break;

			case 4:
				{
				setState(188); ((PredicateContext)_localctx).e1 = expression(0);
				setState(189); match(58);
				setState(190); ((PredicateContext)_localctx).e2 = expression(0);

						String a, b;
						a = memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						print(a + " > " + b);
					
				}
				break;

			case 5:
				{
				setState(193); ((PredicateContext)_localctx).e1 = expression(0);
				setState(194); match(23);
				setState(195); ((PredicateContext)_localctx).e2 = expression(0);

						String a, b;
						a = memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						
						print(a + " =< " + b);
					
				}
				break;

			case 6:
				{
				setState(198); ((PredicateContext)_localctx).e1 = expression(0);
				setState(199); match(29);
				setState(200); ((PredicateContext)_localctx).e2 = expression(0);

						String a, b;
						a = memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						print(a + " =< " + b);
					
				}
				break;

			case 7:
				{
				setState(203); ((PredicateContext)_localctx).e1 = expression(0);
				setState(204); match(22);
				setState(205); ((PredicateContext)_localctx).e2 = expression(0);

						String a, b;
						a = memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						print(a + " = " + b);
					
				}
				break;

			case 8:
				{
				setState(208); ((PredicateContext)_localctx).e1 = expression(0);
				setState(209); match(32);
				setState(210); ((PredicateContext)_localctx).e2 = expression(0);

						String a, b;
						a = memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						
						//Si a es una lista, debo convertirla
						a = convertToSet((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null), a);
						//Si b es una lista, debo convertirla
						b = convertToSet((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null), b);
						
						print("dsubset(" + a + "," + b + ")");
					
				}
				break;

			case 9:
				{
				setState(213); match(2);
				setState(214); ((PredicateContext)_localctx).e1 = expression(0);
				setState(215); match(32);
				setState(216); ((PredicateContext)_localctx).e2 = expression(0);

						String a, b;
						a = memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						
						//Si a es una lista, debo convertirla
						a = convertToSet((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null), a);
						//Si b es una lista, debo convertirla
						b = convertToSet((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null), b);
						
						print("dnsubset(" + a + "," + b + ")");
					
				}
				break;

			case 10:
				{
				setState(219); ((PredicateContext)_localctx).e1 = expression(0);
				setState(220); match(52);
				setState(221); ((PredicateContext)_localctx).e2 = expression(0);

						String a, b;
						a = memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						
						//Si a es una lista, debo convertirla
						a = convertToSet((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null), a);
						//Si b es una lista, debo convertirla
						b = convertToSet((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null), b);
						
						print("dssubset(" + a + "," + b + ")");
					
				}
				break;

			case 11:
				{
				setState(224); match(2);
				setState(225); ((PredicateContext)_localctx).e1 = expression(0);
				setState(226); match(52);
				setState(227); ((PredicateContext)_localctx).e2 = expression(0);

						String a, b;
						a = memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						
						//Si a es una lista, debo convertirla
						a = convertToSet((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null), a);
						//Si b es una lista, debo convertirla
						b = convertToSet((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null), b);
						
						String c = memory.get( (((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null) + "\\cap" + (((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						if (c == null) {
							c = newVar();
							memory.put( (((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null) + "\\cap" + (((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null), c);
							print("dinters(" + a + "," + b + "," + c + ")");
							String type = types.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
							if (isSequence(getType(type)))
								type = "\\power(\\nat\\cross(" + leftAndRightTypes(type).get(1) + "))";
							types.put((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null) + "\\cap" + (((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null), type);
							//typeInfo(c, type);
						}
						
						print(c + " neq " + a);
					
				}
				break;

			case 12:
				{
				setState(230); ((PredicateContext)_localctx).e1 = expression(0);
				setState(231); match(27);
				setState(232); ((PredicateContext)_localctx).e2 = expression(0);

						String a, b;
						a = memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						
						if (!getType(types.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null))).equals(getType(types.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null))))) {
							//Si a es una lista, debo convertirla
							a = convertToSet((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null), a);
							//Si b es una lista, debo convertirla
							b = convertToSet((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null), b);
						}
							
						
						print(a + " neq " + b);
					
				}
				break;

			case 13:
				{
				setState(235); ((PredicateContext)_localctx).e1 = expression(0);
				setState(236); match(24);
				setState(237); ((PredicateContext)_localctx).e2 = expression(0);

						String a, b;
						a = memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						print("prolog_call(append(" + a + ",_," + b + "))");
					
				}
				break;

			case 14:
				{
				setState(240); ((PredicateContext)_localctx).e1 = expression(0);
				setState(241); match(35);
				setState(242); ((PredicateContext)_localctx).e2 = expression(0);

						String a, b;
						a = memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						print("prolog_call(append(_," + a + "," + b + "))");
					
				}
				break;

			case 15:
				{
				setState(245); match(40);
				setState(246); predicate(0);
				setState(247); match(18);
				}
				break;

			case 16:
				{
				setState(249); match(49);
				}
				break;

			case 17:
				{
				setState(250); match(8);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(267);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(265);
					switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
					case 1:
						{
						_localctx = new PredicateContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_predicate);
						setState(253);
						if (!(4 >= _localctx._p)) throw new FailedPredicateException(this, "4 >= $_p");
						setState(254); match(53);
						setState(255); predicate(5);
						}
						break;

					case 2:
						{
						_localctx = new PredicateContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_predicate);
						setState(256);
						if (!(3 >= _localctx._p)) throw new FailedPredicateException(this, "3 >= $_p");
						setState(257); match(55);
						setState(258); predicate(4);
						}
						break;

					case 3:
						{
						_localctx = new PredicateContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_predicate);
						setState(259);
						if (!(2 >= _localctx._p)) throw new FailedPredicateException(this, "2 >= $_p");
						setState(260); match(42);
						setState(261); predicate(3);
						}
						break;

					case 4:
						{
						_localctx = new PredicateContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_predicate);
						setState(262);
						if (!(1 >= _localctx._p)) throw new FailedPredicateException(this, "1 >= $_p");
						setState(263); match(17);
						setState(264); predicate(2);
						}
						break;
					}
					} 
				}
				setState(269);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public int _p;
		public ArrayList<String> elements = new ArrayList<String>();
		public String setlogName = "";
		public String zName = "";
		public String operator = "";
		public String newVarName1 = "";
		public String newVarName2 = "";
		public ExpressionContext e1;
		public ExpressionContext a;
		public PreContext pre;
		public ExpressionContext e;
		public ExpressionContext expression;
		public Token CROSS;
		public ExpressionContext e2;
		public Token IN_FUN_65;
		public Token IN_FUN_60;
		public Token IN_FUN_40;
		public Token IN_FUN_30;
		public Token IN_FUN_20;
		public Token IN_FUN_10;
		public Token IN_FUN_5;
		public ExpressionContext b;
		public EndExpressionContext end;
		public Token DECORATION;
		public Token IMGSTART;
		public Token IMGEND;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public EndExpressionContext endExpression() {
			return getRuleContext(EndExpressionContext.class,0);
		}
		public TerminalNode IN_FUN_50() { return getToken(ExprParser.IN_FUN_50, 0); }
		public TerminalNode IN_FUN_5() { return getToken(ExprParser.IN_FUN_5, 0); }
		public TerminalNode POWER() { return getToken(ExprParser.POWER, 0); }
		public TerminalNode IN_FUN_60() { return getToken(ExprParser.IN_FUN_60, 0); }
		public TerminalNode DECORATION() { return getToken(ExprParser.DECORATION, 0); }
		public TerminalNode IN_FUN_10() { return getToken(ExprParser.IN_FUN_10, 0); }
		public TerminalNode IN_FUN_40() { return getToken(ExprParser.IN_FUN_40, 0); }
		public PreContext pre() {
			return getRuleContext(PreContext.class,0);
		}
		public TerminalNode IN_FUN_30() { return getToken(ExprParser.IN_FUN_30, 0); }
		public TerminalNode IN_FUN_20() { return getToken(ExprParser.IN_FUN_20, 0); }
		public TerminalNode IN_FUN_45() { return getToken(ExprParser.IN_FUN_45, 0); }
		public TerminalNode CROSS() { return getToken(ExprParser.CROSS, 0); }
		public TerminalNode IMGEND() { return getToken(ExprParser.IMGEND, 0); }
		public TerminalNode IMGSTART() { return getToken(ExprParser.IMGSTART, 0); }
		public TerminalNode IN_FUN_65() { return getToken(ExprParser.IN_FUN_65, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public ExpressionContext(ParserRuleContext parent, int invokingState, int _p) {
			super(parent, invokingState);
			this._p = _p;
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitExpression(this);
		}
	}

	public final ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState, _p);
		ExpressionContext _prevctx = _localctx;
		int _startState = 20;
		enterRecursionRule(_localctx, RULE_expression);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(280);
			switch (_input.LA(1)) {
			case 3:
			case 4:
			case 5:
			case 10:
			case 12:
			case 13:
			case 16:
			case 20:
			case 21:
			case 25:
			case 30:
			case 37:
			case 43:
			case 45:
			case 57:
				{
				setState(271); ((ExpressionContext)_localctx).pre = pre();
				setState(272); ((ExpressionContext)_localctx).e = ((ExpressionContext)_localctx).expression = expression(16);

						if (memory.get((((ExpressionContext)_localctx).pre!=null?_input.getText(((ExpressionContext)_localctx).pre.start,((ExpressionContext)_localctx).pre.stop):null) + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null)) == null) {
						
							String a;
							a = memory.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null));
							String newVarName = newVar();
						
							if ((((ExpressionContext)_localctx).pre!=null?_input.getText(((ExpressionContext)_localctx).pre.start,((ExpressionContext)_localctx).pre.stop):null).equals("\\#")){
								memory.put("\\#" + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), newVarName);
								types.put("\\#" + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), "\\nat");
								if (modoSetExpression != 0 )
									setExpressionVars.put("\\#" + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), newVarName);
								
								String type = getType(types.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null)));
								if (isSequence(type))
									print("prolog_call(length(" + a + "," + newVarName + "))");
								else
									print("size(" + a + "," + newVarName + ")");					
							
								print(newVarName + " in " + printInfo("\\nat", true));
							}
							else if ((((ExpressionContext)_localctx).pre!=null?_input.getText(((ExpressionContext)_localctx).pre.start,((ExpressionContext)_localctx).pre.stop):null).equals("\\dom")){
								memory.put("\\dom" + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), newVarName);
								if (modoSetExpression != 0 )
									setExpressionVars.put("\\dom" + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), newVarName);
								types.put("\\dom" + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), "\\power(" + getChildType(types.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null)), 0) + ")");
							
								String e = memory.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null));
							
								//Chequeamos si e es una lista, estas son tratadas de forma diferente
								String type = getType(types.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null)));
								if (isSequence(type))
									print("ddom_list(" + e + "," + newVarName + ")");
								else
									print("dom(" + e + "," + newVarName + ")");
							}
							else if ((((ExpressionContext)_localctx).pre!=null?_input.getText(((ExpressionContext)_localctx).pre.start,((ExpressionContext)_localctx).pre.stop):null).equals("\\ran")){
								memory.put("\\ran" + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), newVarName);
								if (modoSetExpression != 0 )
									setExpressionVars.put("\\ran" + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), newVarName);
								types.put("\\ran" + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), "\\power(" + getChildType(types.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null)), 1) + ")");
							
								String e = memory.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null));
							
								//Chequeamos si e es una lista, estas son tratadas de forma diferente
								String type = getType(types.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null)));
								if (isSequence(type))
									print("list_to_set(" + e + "," + newVarName + ")");
								else
									print("ran(" + e + "," + newVarName + ")");
							}
							else if ((((ExpressionContext)_localctx).pre!=null?_input.getText(((ExpressionContext)_localctx).pre.start,((ExpressionContext)_localctx).pre.stop):null).startsWith("seq_{1}")) {
								String eType = types.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null));
								if (isBasic(eType))
									eType = (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null);
						
								types.put((((ExpressionContext)_localctx).pre!=null?_input.getText(((ExpressionContext)_localctx).pre.start,((ExpressionContext)_localctx).pre.stop):null) + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), (((ExpressionContext)_localctx).pre!=null?_input.getText(((ExpressionContext)_localctx).pre.start,((ExpressionContext)_localctx).pre.stop):null) + eType);
							}
							else if ((((ExpressionContext)_localctx).pre!=null?_input.getText(((ExpressionContext)_localctx).pre.start,((ExpressionContext)_localctx).pre.stop):null).equals("\\seq")) {
								String eType = types.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null));
								if (isBasic(eType))
									eType = (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null);
						
								types.put("\\seq" + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), "\\seq" + eType);
							}
							else if ((((ExpressionContext)_localctx).pre!=null?_input.getText(((ExpressionContext)_localctx).pre.start,((ExpressionContext)_localctx).pre.stop):null).equals("\\bigcup")){
								memory.put("\\bigcup" + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), newVarName);
								if (modoSetExpression != 0 )
									setExpressionVars.put("\\bigcup" + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), newVarName);
								types.put("\\bigcup" + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), getChildType(types.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null)), 0));
							
								String e = memory.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null));
								print("bun(" + e + "," + newVarName + ")");
							}
							else if ((((ExpressionContext)_localctx).pre!=null?_input.getText(((ExpressionContext)_localctx).pre.start,((ExpressionContext)_localctx).pre.stop):null).equals("\\bigcap")){
								memory.put("\\bigcap" + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), newVarName);
								if (modoSetExpression != 0 )
									setExpressionVars.put("\\bigcap" + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), newVarName);
								types.put("\\bigcap" + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), getChildType(types.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null)), 0));
							
								String e = memory.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null));
								print("bdinters(" + e + "," + newVarName + ")");
							}
							else if ((((ExpressionContext)_localctx).pre!=null?_input.getText(((ExpressionContext)_localctx).pre.start,((ExpressionContext)_localctx).pre.stop):null).startsWith("min")){
								memory.put((((ExpressionContext)_localctx).pre!=null?_input.getText(((ExpressionContext)_localctx).pre.start,((ExpressionContext)_localctx).pre.stop):null) + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), newVarName);
								if (modoSetExpression != 0 )
									setExpressionVars.put((((ExpressionContext)_localctx).pre!=null?_input.getText(((ExpressionContext)_localctx).pre.start,((ExpressionContext)_localctx).pre.stop):null) + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), newVarName);
								types.put((((ExpressionContext)_localctx).pre!=null?_input.getText(((ExpressionContext)_localctx).pre.start,((ExpressionContext)_localctx).pre.stop):null) + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), getChildType(types.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null)), 0));
							
								String e = memory.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null));
								print("prolog_call(min(" + e + "," + newVarName + "))");
							}
							else if ((((ExpressionContext)_localctx).pre!=null?_input.getText(((ExpressionContext)_localctx).pre.start,((ExpressionContext)_localctx).pre.stop):null).startsWith("max")){
								memory.put((((ExpressionContext)_localctx).pre!=null?_input.getText(((ExpressionContext)_localctx).pre.start,((ExpressionContext)_localctx).pre.stop):null) + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), newVarName);
								if (modoSetExpression != 0 )
									setExpressionVars.put((((ExpressionContext)_localctx).pre!=null?_input.getText(((ExpressionContext)_localctx).pre.start,((ExpressionContext)_localctx).pre.stop):null) + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), newVarName);
								types.put((((ExpressionContext)_localctx).pre!=null?_input.getText(((ExpressionContext)_localctx).pre.start,((ExpressionContext)_localctx).pre.stop):null) + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), getChildType(types.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null)), 0));
							
								String e = memory.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null));
								print("max(" + e + "," + newVarName + ")");
							}
							else if ((((ExpressionContext)_localctx).pre!=null?_input.getText(((ExpressionContext)_localctx).pre.start,((ExpressionContext)_localctx).pre.stop):null).startsWith("rev")){
								print("prolog_call(reverse(" + a + "," + newVarName + "))");
								memory.put((((ExpressionContext)_localctx).pre!=null?_input.getText(((ExpressionContext)_localctx).pre.start,((ExpressionContext)_localctx).pre.stop):null) + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), newVarName);
								String type = types.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null));
								types.put((((ExpressionContext)_localctx).pre!=null?_input.getText(((ExpressionContext)_localctx).pre.start,((ExpressionContext)_localctx).pre.stop):null) + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), type);
								typeInfo(newVarName, type);
								if (modoSetExpression != 0 )
									setExpressionVars.put((((ExpressionContext)_localctx).pre!=null?_input.getText(((ExpressionContext)_localctx).pre.start,((ExpressionContext)_localctx).pre.stop):null) + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), newVarName);
							}
							else if ((((ExpressionContext)_localctx).pre!=null?_input.getText(((ExpressionContext)_localctx).pre.start,((ExpressionContext)_localctx).pre.stop):null).startsWith("head")){
								print("nth1(1," + a + "," + newVarName + ")");
								memory.put((((ExpressionContext)_localctx).pre!=null?_input.getText(((ExpressionContext)_localctx).pre.start,((ExpressionContext)_localctx).pre.stop):null) + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), newVarName);
								String type = getChildType(types.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null)), 0);
								types.put((((ExpressionContext)_localctx).pre!=null?_input.getText(((ExpressionContext)_localctx).pre.start,((ExpressionContext)_localctx).pre.stop):null) + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), type);
								typeInfo(newVarName, type);
								if (modoSetExpression != 0 )
									setExpressionVars.put((((ExpressionContext)_localctx).pre!=null?_input.getText(((ExpressionContext)_localctx).pre.start,((ExpressionContext)_localctx).pre.stop):null) + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), newVarName);
							}
							else if ((((ExpressionContext)_localctx).pre!=null?_input.getText(((ExpressionContext)_localctx).pre.start,((ExpressionContext)_localctx).pre.stop):null).startsWith("last")){
								print("prolog_call(last(" + a + "," + newVarName + "))");
								memory.put((((ExpressionContext)_localctx).pre!=null?_input.getText(((ExpressionContext)_localctx).pre.start,((ExpressionContext)_localctx).pre.stop):null) + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), newVarName);
								String type = getChildType(types.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null)), 0);
								types.put((((ExpressionContext)_localctx).pre!=null?_input.getText(((ExpressionContext)_localctx).pre.start,((ExpressionContext)_localctx).pre.stop):null) + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), type);
								typeInfo(newVarName, type);
								if (modoSetExpression != 0 )
									setExpressionVars.put((((ExpressionContext)_localctx).pre!=null?_input.getText(((ExpressionContext)_localctx).pre.start,((ExpressionContext)_localctx).pre.stop):null) + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), newVarName);
							}
							else if ((((ExpressionContext)_localctx).pre!=null?_input.getText(((ExpressionContext)_localctx).pre.start,((ExpressionContext)_localctx).pre.stop):null).startsWith("tail")){
								print("prolog_call(drop(1," + a + "," + newVarName + "))");
								memory.put((((ExpressionContext)_localctx).pre!=null?_input.getText(((ExpressionContext)_localctx).pre.start,((ExpressionContext)_localctx).pre.stop):null) + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), newVarName);
								String type = types.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null));
								types.put((((ExpressionContext)_localctx).pre!=null?_input.getText(((ExpressionContext)_localctx).pre.start,((ExpressionContext)_localctx).pre.stop):null) + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), type);
								typeInfo(newVarName, type);
								if (modoSetExpression != 0 )
									setExpressionVars.put((((ExpressionContext)_localctx).pre!=null?_input.getText(((ExpressionContext)_localctx).pre.start,((ExpressionContext)_localctx).pre.stop):null) + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), newVarName);
							}
							else if ((((ExpressionContext)_localctx).pre!=null?_input.getText(((ExpressionContext)_localctx).pre.start,((ExpressionContext)_localctx).pre.stop):null).startsWith("front")){
								String n = newVar();
								print("prolog_call(length(" + a + "," + n + "))");
								print(n + " in " + printInfo("\\nat", true));
								print("prolog_call(take(" + n + "-1" + "," + a + "," + newVarName + "))");
								memory.put((((ExpressionContext)_localctx).pre!=null?_input.getText(((ExpressionContext)_localctx).pre.start,((ExpressionContext)_localctx).pre.stop):null) + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), newVarName);
								String type = types.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null));
								types.put((((ExpressionContext)_localctx).pre!=null?_input.getText(((ExpressionContext)_localctx).pre.start,((ExpressionContext)_localctx).pre.stop):null) + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), type);
								typeInfo(newVarName, type);
								if (modoSetExpression != 0 )
									setExpressionVars.put((((ExpressionContext)_localctx).pre!=null?_input.getText(((ExpressionContext)_localctx).pre.start,((ExpressionContext)_localctx).pre.stop):null) + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), newVarName);
							}
							else if ((((ExpressionContext)_localctx).pre!=null?_input.getText(((ExpressionContext)_localctx).pre.start,((ExpressionContext)_localctx).pre.stop):null).startsWith("squash")){
								print("squash(" + a + "," + newVarName + ")");
								memory.put((((ExpressionContext)_localctx).pre!=null?_input.getText(((ExpressionContext)_localctx).pre.start,((ExpressionContext)_localctx).pre.stop):null) + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), newVarName);
								String type = types.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null));
								ArrayList<String> leftAndRight = leftAndRightTypes(type);
								type = "\\seq(" + leftAndRight.get(1) + ")";
								types.put((((ExpressionContext)_localctx).pre!=null?_input.getText(((ExpressionContext)_localctx).pre.start,((ExpressionContext)_localctx).pre.stop):null) + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), type);
								typeInfo(newVarName, type);
								if (modoSetExpression != 0 )
									setExpressionVars.put((((ExpressionContext)_localctx).pre!=null?_input.getText(((ExpressionContext)_localctx).pre.start,((ExpressionContext)_localctx).pre.stop):null) + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), newVarName);
							}
						}
					
				}
				break;
			case POWER:
				{
				setState(275); match(POWER);
				setState(276); ((ExpressionContext)_localctx).e = ((ExpressionContext)_localctx).expression = expression(13);

						String eType = types.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null));
						if (isBasic(eType))
							eType = (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null);
					
						types.put(_input.getText(_localctx.start, _input.LT(-1)), "\\power" + eType );
					
				}
				break;
			case 11:
			case 26:
			case 40:
			case 51:
			case 60:
			case NAME:
			case NUM:
			case SETSTART:
			case LISTSTART:
				{
				setState(279); endExpression(0);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(350);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(348);
					switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(282);
						if (!(12 >= _localctx._p)) throw new FailedPredicateException(this, "12 >= $_p");
						setState(283); ((ExpressionContext)_localctx).CROSS = match(CROSS);
						setState(284); ((ExpressionContext)_localctx).e2 = ((ExpressionContext)_localctx).expression = expression(13);

						          		String unfoldedType = "";

						          		String exp = (((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null);
						          		
						          		((ExpressionContext)_localctx).zName =  _localctx.zName.concat(exp);
						          		String expType = types.get(exp);
						          		if (isBasic(expType))
						          			unfoldedType = unfoldedType.concat(exp);
						          		else
						          			unfoldedType = unfoldedType.concat(expType);
						          				
						          		((ExpressionContext)_localctx).zName =  _localctx.zName.concat((((ExpressionContext)_localctx).CROSS!=null?((ExpressionContext)_localctx).CROSS.getText():null));
						          		unfoldedType = unfoldedType.concat((((ExpressionContext)_localctx).CROSS!=null?((ExpressionContext)_localctx).CROSS.getText():null));
						          			
						          		exp = (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null);
						          		((ExpressionContext)_localctx).zName =  _localctx.zName.concat(exp);
						          		expType = types.get(exp);
						          		if (isBasic(expType))
						          			unfoldedType = unfoldedType.concat(exp);
						          		else
						          			unfoldedType = unfoldedType.concat(expType);
						          			
						          		/*
						          		//Para cada exp realizamos el procesamiento
						          		while( !((ExpressionContext)getInvokingContext(10)).elements.isEmpty() ) {
						          			String exp = ((ExpressionContext)getInvokingContext(10)).elements.remove(0);
						          			
						          			((ExpressionContext)_localctx).zName =  _localctx.zName.concat(exp);
						          			
						          			String expType = types.get(exp);
						          			if (isBasic(expType))
						          				unfoldedType = unfoldedType.concat(exp);
						          			else
						          				unfoldedType = unfoldedType.concat(expType);
						          				
						          			if (!((ExpressionContext)getInvokingContext(10)).elements.isEmpty()) {
						          				((ExpressionContext)_localctx).zName =  _localctx.zName.concat((((ExpressionContext)_localctx).CROSS!=null?((ExpressionContext)_localctx).CROSS.getText():null));
						          				unfoldedType = unfoldedType.concat((((ExpressionContext)_localctx).CROSS!=null?((ExpressionContext)_localctx).CROSS.getText():null));
						          			}
						          		}*/
						          		
						          		types.put(_localctx.zName, unfoldedType);
						          	
						}
						break;

					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(287);
						if (!(11 >= _localctx._p)) throw new FailedPredicateException(this, "11 >= $_p");
						setState(288); ((ExpressionContext)_localctx).IN_FUN_65 = match(IN_FUN_65);
						setState(289); ((ExpressionContext)_localctx).e2 = ((ExpressionContext)_localctx).expression = expression(12);

						          		String a, b;
						          		a = memory.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null));
						          		b = memory.get((((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null));
						          		
						          		//Si a es una lista, debo convertirla
						          		a = convertToSet((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null), a);
						          		//Si b es una lista, debo convertirla
						          		b = convertToSet((((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), b);
						          		
						          		if (memory.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + (((ExpressionContext)_localctx).IN_FUN_65!=null?((ExpressionContext)_localctx).IN_FUN_65.getText():null) + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null)) == null) {
						          		
						          			String newVarName = newVar();
						          		
						          			if ((((ExpressionContext)_localctx).IN_FUN_65!=null?((ExpressionContext)_localctx).IN_FUN_65.getText():null).equals("\\dres")){
						          				print("dres(" + a + "," + b + "," + newVarName + ")");
						          				memory.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\dres" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          				String type2 = types.get((((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null));
						          				ArrayList<String> leftAndRight = leftAndRightTypes(type2);
						          				String type = "\\power((" + leftAndRight.get(0) + ")\\cross(" + leftAndRight.get(1) + "))";
						          				types.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\dres" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), type);
						          				typeInfo(newVarName, type);
						          				if (modoSetExpression != 0 )
						          					setExpressionVars.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\dres" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          			}
						          			else if ((((ExpressionContext)_localctx).IN_FUN_65!=null?((ExpressionContext)_localctx).IN_FUN_65.getText():null).equals("\\ndres")){
						          				print("ndres(" + a + "," + b + "," + newVarName + ")");
						          				memory.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\ndres" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          				String type2 = types.get((((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null));
						          				ArrayList<String> leftAndRight = leftAndRightTypes(type2);
						          				String type = "\\power((" + leftAndRight.get(0) + ")\\cross(" + leftAndRight.get(1) + "))";
						          				types.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\ndres" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), type);
						          				typeInfo(newVarName, type);
						          				if (modoSetExpression != 0 )
						          					setExpressionVars.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\ndres" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          			}
						          		}
						          	
						}
						break;

					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(292);
						if (!(10 >= _localctx._p)) throw new FailedPredicateException(this, "10 >= $_p");
						setState(293); ((ExpressionContext)_localctx).IN_FUN_60 = match(IN_FUN_60);
						setState(294); ((ExpressionContext)_localctx).e2 = ((ExpressionContext)_localctx).expression = expression(11);

						          		String a, b;
						          		a = memory.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null));
						          		b = memory.get((((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null));
						          		
						          		//Si a es una lista, debo convertirla
						          		a = convertToSet((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null), a);
						          		//Si b es una lista, debo convertirla
						          		b = convertToSet((((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), b);
						          		
						          		if (memory.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + (((ExpressionContext)_localctx).IN_FUN_60!=null?((ExpressionContext)_localctx).IN_FUN_60.getText():null) + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null)) == null) {
						          		
						          			String newVarName = newVar();
						          		
						          			if ((((ExpressionContext)_localctx).IN_FUN_60!=null?((ExpressionContext)_localctx).IN_FUN_60.getText():null).equals("\\rres")){
						          				print("rres(" + b + "," + a + "," + newVarName + ")");
						          				memory.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\rres" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          				String type1 = types.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null));
						          				ArrayList<String> leftAndRight = leftAndRightTypes(type1);
						          				String type = "\\power((" + leftAndRight.get(0) + ")\\cross(" + leftAndRight.get(1) + "))";
						          				types.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\rres" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), type);
						          				typeInfo(newVarName, type);
						          				if (modoSetExpression != 0 )
						          					setExpressionVars.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\rres" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          			}
						          			else if ((((ExpressionContext)_localctx).IN_FUN_60!=null?((ExpressionContext)_localctx).IN_FUN_60.getText():null).equals("\\nrres")){
						          				print("nrres(" + b + "," + a + "," + newVarName + ")");
						          				memory.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\nrres" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          				String type1 = types.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null));
						          				ArrayList<String> leftAndRight = leftAndRightTypes(type1);
						          				String type = "\\power((" + leftAndRight.get(0) + ")\\cross(" + leftAndRight.get(1) + "))";
						          				types.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\nrres" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), type);
						          				typeInfo(newVarName, type);
						          				if (modoSetExpression != 0 )
						          					setExpressionVars.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\nrres" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          			}
						          		}
						          	
						}
						break;

					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(297);
						if (!(9 >= _localctx._p)) throw new FailedPredicateException(this, "9 >= $_p");
						setState(298); match(IN_FUN_50);
						setState(299); ((ExpressionContext)_localctx).e2 = ((ExpressionContext)_localctx).expression = expression(10);

						          		String a, b;
						          		a = memory.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null));
						          		b = memory.get((((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null));
						          		
						          		//Si a es una lista, debo convertirla
						          		a = convertToSet((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null), a);
						          		//Si b es una lista, debo convertirla
						          		b = convertToSet((((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), b);
						          		
						          		if (memory.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\oplus" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null)) == null) {
						          		
						          			String newVarName = newVar();
						          		
						          			print("oplus(" + a + "," + b + "," + newVarName + ")");
						          			memory.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\oplus" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          			String type1 = types.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null));
						          			ArrayList<String> leftAndRight = leftAndRightTypes(type1);
						          			String type = "\\power((" + leftAndRight.get(0) + ")\\cross(" + leftAndRight.get(1) + "))";
						          			types.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\oplus" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), type);
						          			typeInfo(newVarName, type);
						          			if (modoSetExpression != 0 )
						          				setExpressionVars.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\oplus" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          		}
						          	
						}
						break;

					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(302);
						if (!(8 >= _localctx._p)) throw new FailedPredicateException(this, "8 >= $_p");
						setState(303); match(IN_FUN_45);
						setState(304); ((ExpressionContext)_localctx).e2 = ((ExpressionContext)_localctx).expression = expression(9);

						          		String a, b;
						          		
						          		a = memory.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null));
						          		b = memory.get((((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null));

						          		if (memory.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\extract" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null)) == null) {
						          		
						          			String newVarName = newVar();

						          			print("extract(" + a + "," + b + "," + newVarName + ")");
						          			memory.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\extract" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          			String type = types.get((((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null));
						          			types.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\extract" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), type);
						          			typeInfo(newVarName, type);
						          			if (modoSetExpression != 0 )
						          				setExpressionVars.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\extract" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          		}
						          	
						}
						break;

					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(307);
						if (!(7 >= _localctx._p)) throw new FailedPredicateException(this, "7 >= $_p");
						setState(308); ((ExpressionContext)_localctx).IN_FUN_40 = match(IN_FUN_40);
						setState(309); ((ExpressionContext)_localctx).e2 = ((ExpressionContext)_localctx).expression = expression(8);

						          		String a, b;
						          		
						          		a = memory.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null));
						          		b = memory.get((((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null));

						          		if (memory.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + (((ExpressionContext)_localctx).IN_FUN_40!=null?((ExpressionContext)_localctx).IN_FUN_40.getText():null) + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null)) == null) {
						          		
						          			String newVarName = newVar();
						          			Boolean isNumeric = false; 
						          		
						          			if ((((ExpressionContext)_localctx).IN_FUN_40!=null?((ExpressionContext)_localctx).IN_FUN_40.getText():null).equals("*")){
						          				print( newVarName + " is " + a + "*" + b );
						          				memory.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "*" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          				if (modoSetExpression != 0 )
						          					setExpressionVars.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "*" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          				isNumeric = true;
						          			}
						          			else if ((((ExpressionContext)_localctx).IN_FUN_40!=null?((ExpressionContext)_localctx).IN_FUN_40.getText():null).equals("\\div")) {
						          				print( newVarName + " is div(" + a + "," + b + ")" );
						          				memory.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\div" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          				if (modoSetExpression != 0 )
						          					setExpressionVars.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\div" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          				isNumeric = true;
						          			}
						          			else if ((((ExpressionContext)_localctx).IN_FUN_40!=null?((ExpressionContext)_localctx).IN_FUN_40.getText():null).equals("\\mod")){
						          				print( newVarName + " is mod(" + a + "," + b + ")" );
						          				memory.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\mod" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          				if (modoSetExpression != 0 )
						          					setExpressionVars.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\mod" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          				isNumeric = true;
						          			}
						          			else if ((((ExpressionContext)_localctx).IN_FUN_40!=null?((ExpressionContext)_localctx).IN_FUN_40.getText():null).equals("\\cap")){
						          				//Si a es una lista, debo convertirla
						          				a = convertToSet((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null), a);
						          				//Si b es una lista, debo convertirla
						          				b = convertToSet((((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), b);
						          								
						          				print("dinters(" + a + "," + b + "," + newVarName + ")");
						          				memory.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\cap" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          				String type = types.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null));
						          				if (isSequence(getType(type)))
						          					type = "\\power(\\nat\\cross(" + leftAndRightTypes(type).get(1) + "))";
						          				types.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\cap" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), type);
						          				//typeInfo(newVarName, type);
						          				if (modoSetExpression != 0 )
						          					setExpressionVars.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\cap" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          			}
						          			else if ((((ExpressionContext)_localctx).IN_FUN_40!=null?((ExpressionContext)_localctx).IN_FUN_40.getText():null).equals("\\comp")){
						          				//Si a es una lista, debo convertirla
						          				a = convertToSet((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null), a);
						          				//Si b es una lista, debo convertirla
						          				b = convertToSet((((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), b);
						          						
						          				print("comp(" + a + "," + b + "," + newVarName + ")");
						          				memory.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\comp" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          				String type1 = types.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null));
						          				String type2 = types.get((((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null));
						          				String type = "\\power((" + leftAndRightTypes(type1).get(0) + ")\\cross(" + leftAndRightTypes(type2).get(1) + "))";
						          				types.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\comp" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), type);
						          				typeInfo(newVarName, type);
						          				if (modoSetExpression != 0 )
						          					setExpressionVars.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\comp" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          			}
						          			else if ((((ExpressionContext)_localctx).IN_FUN_40!=null?((ExpressionContext)_localctx).IN_FUN_40.getText():null).equals("\\circ")){
						          				//Si a es una lista, debo convertirla
						          				a = convertToSet((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null), a);
						          				//Si b es una lista, debo convertirla
						          				b = convertToSet((((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), b);
						          				
						          				print("circ(" + a + "," + b + "," + newVarName + ")");
						          				memory.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\circ" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          				String type1 = types.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null));
						          				type1 = leftAndRightTypes(type1).get(1);
						          				String type = "\\power((" + type1 + ")\\cross(" + type1 + "))";
						          				types.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\circ" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), type);
						          				typeInfo(newVarName, type);
						          				if (modoSetExpression != 0 )
						          					setExpressionVars.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\circ" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          			}
						          			else if ((((ExpressionContext)_localctx).IN_FUN_40!=null?((ExpressionContext)_localctx).IN_FUN_40.getText():null).equals("\\filter")){
						          				print("filter(" + a + "," + b + "," + newVarName + ")");
						          				memory.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\filter" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          				String type = types.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null));
						          				types.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\filter" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), type);
						          				typeInfo(newVarName, type);
						          				if (modoSetExpression != 0 )
						          					setExpressionVars.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\filter" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          			}
						          			
						          			if (isNumeric) {
						          				print(newVarName + " in " + printInfo("\\num", true));
						          				types.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + (((ExpressionContext)_localctx).IN_FUN_40!=null?((ExpressionContext)_localctx).IN_FUN_40.getText():null) + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), "\\num");
						          			}
						          		}
						          	
						}
						break;

					case 7:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(312);
						if (!(6 >= _localctx._p)) throw new FailedPredicateException(this, "6 >= $_p");
						setState(313); ((ExpressionContext)_localctx).IN_FUN_30 = match(IN_FUN_30);
						setState(314); ((ExpressionContext)_localctx).e2 = ((ExpressionContext)_localctx).expression = expression(7);

						          		String a, b;
						          		a = memory.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null));
						          		b = memory.get((((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null));
						          		
						          		if (memory.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + (((ExpressionContext)_localctx).IN_FUN_30!=null?((ExpressionContext)_localctx).IN_FUN_30.getText():null) + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null)) == null) {
						          		
						          			String newVarName = newVar();
						          			Boolean isNumeric = false; 
						          			
						          		
						          			if ((((ExpressionContext)_localctx).IN_FUN_30!=null?((ExpressionContext)_localctx).IN_FUN_30.getText():null).equals("+")){
						          				print( newVarName + " is " + a + "+" + b );
						          				memory.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "+" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          				if (modoSetExpression != 0 )
						          					setExpressionVars.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "+" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          				isNumeric = true;
						          			}
						          			else if ((((ExpressionContext)_localctx).IN_FUN_30!=null?((ExpressionContext)_localctx).IN_FUN_30.getText():null).equals("-")) {
						          				print( newVarName + " is " + a + "-" + b );
						          				memory.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "-" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          				if (modoSetExpression != 0 )
						          					setExpressionVars.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "-" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          				isNumeric = true;
						          			}
						          			else if ((((ExpressionContext)_localctx).IN_FUN_30!=null?((ExpressionContext)_localctx).IN_FUN_30.getText():null).equals("\\cup")){
						          			
						          				//Si a es una lista, debo convertirla
						          				a = convertToSet((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null), a);
						          				//Si b es una lista, debo convertirla
						          				b = convertToSet((((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), b);
						          				
						          				print("dun(" + a + "," + b + "," + newVarName + ")");
						          				memory.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\cup" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          				String type = types.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null));
						          				if (isSequence(getType(type)))
						          					type = "\\power(\\nat\\cross(" + leftAndRightTypes(type).get(1) + "))";
						          				types.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\cup" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), type);
						          				typeInfo(newVarName, type);
						          				if (modoSetExpression != 0 )
						          					setExpressionVars.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\cup" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          			}
						          			else if ((((ExpressionContext)_localctx).IN_FUN_30!=null?((ExpressionContext)_localctx).IN_FUN_30.getText():null).equals("\\setminus")){
						          				//Si a es una lista, debo convertirla
						          				a = convertToSet((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null), a);
						          				//Si b es una lista, debo convertirla
						          				b = convertToSet((((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), b);
						          		
						          				print("diff(" + a + "," + b + "," + newVarName + ")");
						          				memory.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\setminus" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          				String type = types.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null));
						          				if (isSequence(getType(type)))
						          					type = "\\power(\\nat\\cross(" + leftAndRightTypes(type).get(1) + "))";
						          				types.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\setminus" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), type);
						          				typeInfo(newVarName, type);
						          				if (modoSetExpression != 0 )
						          					setExpressionVars.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\setminus" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          			}
						          			else if ((((ExpressionContext)_localctx).IN_FUN_30!=null?((ExpressionContext)_localctx).IN_FUN_30.getText():null).equals("\\cat")){
						          				print("prolog_call(append(" + a + "," + b + "," + newVarName + "))");
						          				memory.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\cat" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          				String type = types.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null));
						          				types.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\cat" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), type);
						          				typeInfo(newVarName, type);
						          				if (modoSetExpression != 0 )
						          					setExpressionVars.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\cat" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          			}
						          			
						          			if (isNumeric) {
						          				print(newVarName + " in " + printInfo("\\num", true));
						          				types.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + (((ExpressionContext)_localctx).IN_FUN_30!=null?((ExpressionContext)_localctx).IN_FUN_30.getText():null) + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), "\\num");
						          			}
						          		}
						          	
						}
						break;

					case 8:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(317);
						if (!(5 >= _localctx._p)) throw new FailedPredicateException(this, "5 >= $_p");
						setState(318); ((ExpressionContext)_localctx).IN_FUN_20 = match(IN_FUN_20);
						setState(319); ((ExpressionContext)_localctx).e2 = ((ExpressionContext)_localctx).expression = expression(6);

						          		String a, b;
						          		a = memory.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null));
						          		b = memory.get((((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null));
						          		if (memory.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + (((ExpressionContext)_localctx).IN_FUN_20!=null?((ExpressionContext)_localctx).IN_FUN_20.getText():null) + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null)) == null) {
						          			String newVarName = newVar();
						          			memory.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + (((ExpressionContext)_localctx).IN_FUN_20!=null?((ExpressionContext)_localctx).IN_FUN_20.getText():null) + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          			types.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + (((ExpressionContext)_localctx).IN_FUN_20!=null?((ExpressionContext)_localctx).IN_FUN_20.getText():null) + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), memory.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null)) + (((ExpressionContext)_localctx).IN_FUN_20!=null?((ExpressionContext)_localctx).IN_FUN_20.getText():null) + memory.get((((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null)));
						          			if (modoSetExpression != 0 )
						          				setExpressionVars.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + (((ExpressionContext)_localctx).IN_FUN_20!=null?((ExpressionContext)_localctx).IN_FUN_20.getText():null) + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          			print(newVarName + " = int(" + a + "," + b + ")");
						          		}
						          	
						}
						break;

					case 9:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(322);
						if (!(4 >= _localctx._p)) throw new FailedPredicateException(this, "4 >= $_p");
						setState(323); ((ExpressionContext)_localctx).IN_FUN_10 = match(IN_FUN_10);
						setState(324); ((ExpressionContext)_localctx).e2 = ((ExpressionContext)_localctx).expression = expression(5);

						          		String a, b;
						          		a = memory.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null));
						          		b = memory.get((((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null));
						          		memory.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + (((ExpressionContext)_localctx).IN_FUN_10!=null?((ExpressionContext)_localctx).IN_FUN_10.getText():null) + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), "[" + a + "," + b + "]");
						          		types.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + (((ExpressionContext)_localctx).IN_FUN_10!=null?((ExpressionContext)_localctx).IN_FUN_10.getText():null) + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), types.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null)) + "\\cross" + types.get((((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null)));
						          	
						}
						break;

					case 10:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(327);
						if (!(3 >= _localctx._p)) throw new FailedPredicateException(this, "3 >= $_p");
						setState(328); ((ExpressionContext)_localctx).IN_FUN_5 = match(IN_FUN_5);
						setState(329); ((ExpressionContext)_localctx).b = ((ExpressionContext)_localctx).expression = expression(4);

						          		//Guardo el tipo
						          		String aType = types.get((((ExpressionContext)_localctx).a!=null?_input.getText(((ExpressionContext)_localctx).a.start,((ExpressionContext)_localctx).a.stop):null));
						          		if (isBasic(aType)) {
						          			aType = (((ExpressionContext)_localctx).a!=null?_input.getText(((ExpressionContext)_localctx).a.start,((ExpressionContext)_localctx).a.stop):null);
						          		}
						          		String bType = types.get((((ExpressionContext)_localctx).b!=null?_input.getText(((ExpressionContext)_localctx).b.start,((ExpressionContext)_localctx).b.stop):null));
						          		if (isBasic(bType))
						          			bType = (((ExpressionContext)_localctx).b!=null?_input.getText(((ExpressionContext)_localctx).b.start,((ExpressionContext)_localctx).b.stop):null);
						          		
						          		types.put((((ExpressionContext)_localctx).a!=null?_input.getText(((ExpressionContext)_localctx).a.start,((ExpressionContext)_localctx).a.stop):null) + (((ExpressionContext)_localctx).IN_FUN_5!=null?((ExpressionContext)_localctx).IN_FUN_5.getText():null) + (((ExpressionContext)_localctx).b!=null?_input.getText(((ExpressionContext)_localctx).b.start,((ExpressionContext)_localctx).b.stop):null), aType + (((ExpressionContext)_localctx).IN_FUN_5!=null?((ExpressionContext)_localctx).IN_FUN_5.getText():null) + bType );
						          	
						}
						break;

					case 11:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(332);
						if (!(15 >= _localctx._p)) throw new FailedPredicateException(this, "15 >= $_p");
						setState(333); ((ExpressionContext)_localctx).end = endExpression(0);

						          		String a, b;
						          		a = memory.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null));
						          		b = memory.get((((ExpressionContext)_localctx).end!=null?_input.getText(((ExpressionContext)_localctx).end.start,((ExpressionContext)_localctx).end.stop):null));
						          		String op = "";
						          		//if ((((ExpressionContext)_localctx).DECORATION!=null?((ExpressionContext)_localctx).DECORATION.getText():null) != null) op = "~";
						          		
						          		//Si a es una lista, debo convertirla
						          		a = convertToSet((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null), a);
						          		
						          		if (memory.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + op + (((ExpressionContext)_localctx).end!=null?_input.getText(((ExpressionContext)_localctx).end.start,((ExpressionContext)_localctx).end.stop):null)) == null) {
						          			String newVarName = newVar();
						          			memory.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + op + (((ExpressionContext)_localctx).end!=null?_input.getText(((ExpressionContext)_localctx).end.start,((ExpressionContext)_localctx).end.stop):null), newVarName);
						          			
						          			if (modoSetExpression != 0 )
						          				setExpressionVars.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + op + (((ExpressionContext)_localctx).end!=null?_input.getText(((ExpressionContext)_localctx).end.start,((ExpressionContext)_localctx).end.stop):null), newVarName);

						          			String type1 = types.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null));
						          			//getType(type1);
						          			String newVarType = leftAndRightTypes(type1).get(1);
						          			types.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + op + (((ExpressionContext)_localctx).end!=null?_input.getText(((ExpressionContext)_localctx).end.start,((ExpressionContext)_localctx).end.stop):null), newVarType);
						          			print("apply(" + a + "," + b + "," + newVarName + ")");
						          			
						          			//Imprimimos la informacion del tipo de la variable
						          			typeInfo(newVarName, newVarType);
						          		}
						          	
						}
						break;

					case 12:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(336);
						if (!(14 >= _localctx._p)) throw new FailedPredicateException(this, "14 >= $_p");
						setState(337); ((ExpressionContext)_localctx).DECORATION = match(DECORATION);

						          		if (memory.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + (((ExpressionContext)_localctx).DECORATION!=null?((ExpressionContext)_localctx).DECORATION.getText():null)) == null) {
						          			String a = memory.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null));
						          			memory.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + (((ExpressionContext)_localctx).DECORATION!=null?((ExpressionContext)_localctx).DECORATION.getText():null), a);
						          			types.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + (((ExpressionContext)_localctx).DECORATION!=null?((ExpressionContext)_localctx).DECORATION.getText():null), types.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null)));
						          		}
						          	
						}
						break;

					case 13:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(339);
						if (!(2 >= _localctx._p)) throw new FailedPredicateException(this, "2 >= $_p");
						setState(340); ((ExpressionContext)_localctx).IMGSTART = match(IMGSTART);
						setState(341); ((ExpressionContext)_localctx).e2 = ((ExpressionContext)_localctx).expression = expression(0);
						setState(342); ((ExpressionContext)_localctx).IMGEND = match(IMGEND);
						setState(344);
						switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
						case 1:
							{
							setState(343); ((ExpressionContext)_localctx).DECORATION = match(DECORATION);
							}
							break;
						}

						          		String a, b;
						          		a = memory.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null));
						          		b = memory.get((((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null));
						          		
						          		if (memory.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + (((ExpressionContext)_localctx).IMGSTART!=null?((ExpressionContext)_localctx).IMGSTART.getText():null) + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null) + (((ExpressionContext)_localctx).IMGEND!=null?((ExpressionContext)_localctx).IMGEND.getText():null) + (((ExpressionContext)_localctx).DECORATION!=null?((ExpressionContext)_localctx).DECORATION.getText():null)) == null) {
						          			String newVarName = newVar();
						          			print("rimg(" + a + "," + b + "," + newVarName + ")");
						          			memory.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + (((ExpressionContext)_localctx).IMGSTART!=null?((ExpressionContext)_localctx).IMGSTART.getText():null) + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null) + (((ExpressionContext)_localctx).IMGEND!=null?((ExpressionContext)_localctx).IMGEND.getText():null) + (((ExpressionContext)_localctx).DECORATION!=null?((ExpressionContext)_localctx).DECORATION.getText():null), newVarName);
						          			String type1 = types.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null));
						          			String type = "\\power(" + getChildType(type1, 1) + ")";
						          			types.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + (((ExpressionContext)_localctx).IMGSTART!=null?((ExpressionContext)_localctx).IMGSTART.getText():null) + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null) + (((ExpressionContext)_localctx).IMGEND!=null?((ExpressionContext)_localctx).IMGEND.getText():null) + (((ExpressionContext)_localctx).DECORATION!=null?((ExpressionContext)_localctx).DECORATION.getText():null), type);
						          			typeInfo(newVarName, type);
						          			if (modoSetExpression != 0 )
						          				setExpressionVars.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + (((ExpressionContext)_localctx).IMGSTART!=null?((ExpressionContext)_localctx).IMGSTART.getText():null) + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null) + (((ExpressionContext)_localctx).IMGEND!=null?((ExpressionContext)_localctx).IMGEND.getText():null) + (((ExpressionContext)_localctx).DECORATION!=null?((ExpressionContext)_localctx).DECORATION.getText():null), newVarName);
						          		}
						          	
						}
						break;
					}
					} 
				}
				setState(352);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class EndExpressionContext extends ParserRuleContext {
		public int _p;
		public ArrayList<String> elements = new ArrayList<String>();
		public String setlogName = "";
		public String zName = "";
		public String operator = "";
		public String newVarName1 = "";
		public String newVarName2 = "";
		public EndExpressionContext end;
		public RefNameContext refName;
		public Token NUM;
		public Token SETSTART;
		public ExpressionContext a;
		public ExpressionContext expression;
		public ExpressionContext b;
		public Token SETEND;
		public DeclPartContext declPart;
		public PredicateContext predicate;
		public ExpressionContext c;
		public Token n;
		public ExpressionContext e;
		public Token LISTSTART;
		public Token LISTEND;
		public PostContext post;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public TerminalNode SETSTART() { return getToken(ExprParser.SETSTART, 0); }
		public PostContext post() {
			return getRuleContext(PostContext.class,0);
		}
		public EndExpressionContext endExpression() {
			return getRuleContext(EndExpressionContext.class,0);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> NAME() { return getTokens(ExprParser.NAME); }
		public PredicateContext predicate() {
			return getRuleContext(PredicateContext.class,0);
		}
		public TerminalNode NAME(int i) {
			return getToken(ExprParser.NAME, i);
		}
		public DeclPartContext declPart() {
			return getRuleContext(DeclPartContext.class,0);
		}
		public TerminalNode SETEND() { return getToken(ExprParser.SETEND, 0); }
		public RefNameContext refName() {
			return getRuleContext(RefNameContext.class,0);
		}
		public TerminalNode LISTSTART() { return getToken(ExprParser.LISTSTART, 0); }
		public TerminalNode LISTEND() { return getToken(ExprParser.LISTEND, 0); }
		public TerminalNode NUM() { return getToken(ExprParser.NUM, 0); }
		public TerminalNode SELECTION() { return getToken(ExprParser.SELECTION, 0); }
		public EndExpressionContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public EndExpressionContext(ParserRuleContext parent, int invokingState, int _p) {
			super(parent, invokingState);
			this._p = _p;
		}
		@Override public int getRuleIndex() { return RULE_endExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterEndExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitEndExpression(this);
		}
	}

	public final EndExpressionContext endExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		EndExpressionContext _localctx = new EndExpressionContext(_ctx, _parentState, _p);
		EndExpressionContext _prevctx = _localctx;
		int _startState = 22;
		enterRecursionRule(_localctx, RULE_endExpression);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(457);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				{
				setState(354); ((EndExpressionContext)_localctx).refName = refName();
				}
				break;

			case 2:
				{
				setState(355); ((EndExpressionContext)_localctx).NUM = match(NUM);

						if (memory.get((((EndExpressionContext)_localctx).NUM!=null?((EndExpressionContext)_localctx).NUM.getText():null)) == null) {
							memory.put((((EndExpressionContext)_localctx).NUM!=null?((EndExpressionContext)_localctx).NUM.getText():null), (((EndExpressionContext)_localctx).NUM!=null?((EndExpressionContext)_localctx).NUM.getText():null));
							types.put((((EndExpressionContext)_localctx).NUM!=null?((EndExpressionContext)_localctx).NUM.getText():null), "\\num");
						}
					
				}
				break;

			case 3:
				{
				setState(357); match(11);

						if (memory.get("\\emptyset") == null) {
							memory.put("\\emptyset", "{}");
							types.put("\\emptyset", "\\power(" + "generic" + ")");
						}
					
				}
				break;

			case 4:
				{
				setState(359); ((EndExpressionContext)_localctx).SETSTART = match(SETSTART);
				setState(363);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 3) | (1L << 4) | (1L << 5) | (1L << 10) | (1L << 11) | (1L << 12) | (1L << 13) | (1L << 16) | (1L << 20) | (1L << 21) | (1L << 25) | (1L << 26) | (1L << 30) | (1L << 37) | (1L << 40) | (1L << 43) | (1L << 45) | (1L << 51) | (1L << 57) | (1L << 60) | (1L << POWER))) != 0) || ((((_la - 74)) & ~0x3f) == 0 && ((1L << (_la - 74)) & ((1L << (NAME - 74)) | (1L << (NUM - 74)) | (1L << (SETSTART - 74)) | (1L << (LISTSTART - 74)))) != 0)) {
					{
					setState(360); ((EndExpressionContext)_localctx).a = ((EndExpressionContext)_localctx).expression = expression(0);
					_localctx.elements.add((((EndExpressionContext)_localctx).a!=null?_input.getText(((EndExpressionContext)_localctx).a.start,((EndExpressionContext)_localctx).a.stop):null));
					}
				}

				setState(371);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==38) {
					{
					{
					setState(365); match(38);
					setState(366); ((EndExpressionContext)_localctx).b = ((EndExpressionContext)_localctx).expression = expression(0);
					_localctx.elements.add((((EndExpressionContext)_localctx).b!=null?_input.getText(((EndExpressionContext)_localctx).b.start,((EndExpressionContext)_localctx).b.stop):null));
					}
					}
					setState(373);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(374); ((EndExpressionContext)_localctx).SETEND = match(SETEND);
					
						((EndExpressionContext)_localctx).zName =  (((EndExpressionContext)_localctx).SETSTART!=null?((EndExpressionContext)_localctx).SETSTART.getText():null);
						String type = new String();
						//Llenamos elements y ponemos cada expression en la memory
						while( !_localctx.elements.isEmpty() ){
							String e = _localctx.elements.remove(0);
							if (type.equals("")) {
								type = types.get(e);
							}
							((EndExpressionContext)_localctx).zName =  _localctx.zName.concat(e);
							//guardamos tambien las traducciones del conjunto
							((EndExpressionContext)_localctx).setlogName =  _localctx.setlogName.concat(memory.get(e));
							
							if (!_localctx.elements.isEmpty()){
								((EndExpressionContext)_localctx).zName =  _localctx.zName + ",";
								((EndExpressionContext)_localctx).setlogName =  _localctx.setlogName + ",";
							}
						}
						((EndExpressionContext)_localctx).zName =  _localctx.zName + (((EndExpressionContext)_localctx).SETEND!=null?((EndExpressionContext)_localctx).SETEND.getText():null);
						if (memory.get(_localctx.zName) == null) {
							memory.put(_localctx.zName, "{" + _localctx.setlogName + "}");
							if (_localctx.setlogName.equals(""))
								types.put(_localctx.zName, "\\power(" + "generic" + ")");
							else
								types.put(_localctx.zName, "\\power(" + type + ")");
						}
					
				}
				break;

			case 5:
				{
				setState(376); ((EndExpressionContext)_localctx).SETSTART = match(SETSTART);
				modoSetExpression=1; setExpressionDecl = ""; setExpressionPred = ""; setExpressionExpr = ""; setExpressionVars = new HashMap();
				setState(378); ((EndExpressionContext)_localctx).declPart = declPart();
				((EndExpressionContext)_localctx).zName =  (((EndExpressionContext)_localctx).SETSTART!=null?((EndExpressionContext)_localctx).SETSTART.getText():null) + (((EndExpressionContext)_localctx).declPart!=null?_input.getText(((EndExpressionContext)_localctx).declPart.start,((EndExpressionContext)_localctx).declPart.stop):null);
				setState(385);
				_la = _input.LA(1);
				if (_la==33) {
					{
					setState(380); match(33);
					modoSetExpression=2;
					setState(382); ((EndExpressionContext)_localctx).predicate = predicate(0);
					((EndExpressionContext)_localctx).zName =  _localctx.zName.concat("|" + (((EndExpressionContext)_localctx).predicate!=null?_input.getText(((EndExpressionContext)_localctx).predicate.start,((EndExpressionContext)_localctx).predicate.stop):null));
					}
				}

				setState(392);
				_la = _input.LA(1);
				if (_la==19) {
					{
					setState(387); match(19);
					modoSetExpression=3;
					setState(389); ((EndExpressionContext)_localctx).c = ((EndExpressionContext)_localctx).expression = expression(0);
					((EndExpressionContext)_localctx).zName =  _localctx.zName.concat("@" + (((EndExpressionContext)_localctx).c!=null?_input.getText(((EndExpressionContext)_localctx).c.start,((EndExpressionContext)_localctx).c.stop):null));
					}
				}

				setState(394); ((EndExpressionContext)_localctx).SETEND = match(SETEND);
				modoSetExpression=0; ((EndExpressionContext)_localctx).zName =  _localctx.zName.concat((((EndExpressionContext)_localctx).SETEND!=null?((EndExpressionContext)_localctx).SETEND.getText():null));

						if (memory.get(_localctx.zName)==null) {
						
							// Probando eliminar la variable extra y usar '=' en vez de 'is' cuando corresponde
							String varName = memory.get((((EndExpressionContext)_localctx).c!=null?_input.getText(((EndExpressionContext)_localctx).c.start,((EndExpressionContext)_localctx).c.stop):null));
							String op = getType(types.get((((EndExpressionContext)_localctx).c!=null?_input.getText(((EndExpressionContext)_localctx).c.start,((EndExpressionContext)_localctx).c.stop):null)));
							if (isNumeric(op))
								op = " is ";
							else
								op = " = ";
							
							boolean needsNewName = false;
							if ((varName == null) || (varName.matches("^.*[^a-zA-Z0-9 ].*"))) { //Si es nulo o tiene caracteres que no son letras o numeros
								varName = newVar();
								needsNewName = true;
							}
						
							((EndExpressionContext)_localctx).setlogName =  "";
							((EndExpressionContext)_localctx).newVarName2 =  newVar();
							
							((EndExpressionContext)_localctx).setlogName =  _localctx.setlogName.concat("{ " + varName + " :exists([");
							
							Collection<String> values = setExpressionVars.values();
							if (!needsNewName)
								values.remove(varName);
							
							Iterator<String> valuesIt = values.iterator();
							while (valuesIt.hasNext()){
								((EndExpressionContext)_localctx).setlogName =   _localctx.setlogName.concat(valuesIt.next());
								if (valuesIt.hasNext()) ((EndExpressionContext)_localctx).setlogName =   _localctx.setlogName.concat(",");
							}
						
							String content = setExpressionDecl + setExpressionPred + setExpressionExpr;
							content = content.substring(content.indexOf('&') + 1);
							if (!content.equals("") && needsNewName)
								content = content.concat(" & ");
							
							((EndExpressionContext)_localctx).setlogName =  _localctx.setlogName.concat("], " + content);
							if (needsNewName)
								((EndExpressionContext)_localctx).setlogName =  _localctx.setlogName.concat(varName + op + memory.get((((EndExpressionContext)_localctx).c!=null?_input.getText(((EndExpressionContext)_localctx).c.start,((EndExpressionContext)_localctx).c.stop):null)));
							((EndExpressionContext)_localctx).setlogName =  _localctx.setlogName.concat(")" + " }");
						
							memory.put(_localctx.zName, _localctx.newVarName2);
							types.put(_localctx.zName, "\\power(" + types.get((((EndExpressionContext)_localctx).c!=null?_input.getText(((EndExpressionContext)_localctx).c.start,((EndExpressionContext)_localctx).c.stop):null)) + ")"); //REVISAR!!!
							print(_localctx.newVarName2 + " = " + _localctx.setlogName);
							
							Iterator<String> keysIt = setExpressionVars.keySet().iterator();
							while (keysIt.hasNext()){
								String var = keysIt.next();
								memory.remove(var);
								keysIt.remove();
								//setExpressionVars.remove(var);
							}
						}
					
				}
				break;

			case 6:
				{
				setState(398); match(51);
				setExpressionVars = new HashMap();
				setState(407); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(400); ((EndExpressionContext)_localctx).n = match(NAME);
					setState(401); match(61);
					setState(402); ((EndExpressionContext)_localctx).e = ((EndExpressionContext)_localctx).expression = expression(0);
					setExpressionVars.put((((EndExpressionContext)_localctx).n!=null?((EndExpressionContext)_localctx).n.getText():null), (((EndExpressionContext)_localctx).e!=null?_input.getText(((EndExpressionContext)_localctx).e.start,((EndExpressionContext)_localctx).e.stop):null));
					setState(405);
					_la = _input.LA(1);
					if (_la==38) {
						{
						setState(404); match(38);
						}
					}

					}
					}
					setState(409); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NAME );
				setState(411); match(47);

						((EndExpressionContext)_localctx).setlogName =  "[";
						List<String> sortedVars = new ArrayList<String>(setExpressionVars.keySet());
						java.util.Collections.sort(sortedVars);
						
						int i = 0;
						while( i < sortedVars.size() ){
							String value = setExpressionVars.get(sortedVars.get(i));

							((EndExpressionContext)_localctx).setlogName =  _localctx.setlogName.concat(value);
							
							if (i+1 < sortedVars.size()){
								((EndExpressionContext)_localctx).setlogName =  _localctx.setlogName.concat(",");
							}
							i++;
						}
						
						((EndExpressionContext)_localctx).setlogName =  _localctx.setlogName.concat("]");
						
						if (memory.get((((EndExpressionContext)_localctx).expression!=null?_input.getText(((EndExpressionContext)_localctx).expression.start,((EndExpressionContext)_localctx).expression.stop):null)) == null) {
							memory.put((((EndExpressionContext)_localctx).expression!=null?_input.getText(((EndExpressionContext)_localctx).expression.start,((EndExpressionContext)_localctx).expression.stop):null), _localctx.setlogName);
							types.put((((EndExpressionContext)_localctx).expression!=null?_input.getText(((EndExpressionContext)_localctx).expression.start,((EndExpressionContext)_localctx).expression.stop):null), "\\seq(" + "generic" + ")");
						}
					
				}
				break;

			case 7:
				{
				setState(414); ((EndExpressionContext)_localctx).LISTSTART = match(LISTSTART);
				setState(418);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 3) | (1L << 4) | (1L << 5) | (1L << 10) | (1L << 11) | (1L << 12) | (1L << 13) | (1L << 16) | (1L << 20) | (1L << 21) | (1L << 25) | (1L << 26) | (1L << 30) | (1L << 37) | (1L << 40) | (1L << 43) | (1L << 45) | (1L << 51) | (1L << 57) | (1L << 60) | (1L << POWER))) != 0) || ((((_la - 74)) & ~0x3f) == 0 && ((1L << (_la - 74)) & ((1L << (NAME - 74)) | (1L << (NUM - 74)) | (1L << (SETSTART - 74)) | (1L << (LISTSTART - 74)))) != 0)) {
					{
					setState(415); ((EndExpressionContext)_localctx).a = ((EndExpressionContext)_localctx).expression = expression(0);
					_localctx.elements.add((((EndExpressionContext)_localctx).a!=null?_input.getText(((EndExpressionContext)_localctx).a.start,((EndExpressionContext)_localctx).a.stop):null));
					}
				}

				setState(426);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==38) {
					{
					{
					setState(420); match(38);
					setState(421); ((EndExpressionContext)_localctx).b = ((EndExpressionContext)_localctx).expression = expression(0);
					_localctx.elements.add((((EndExpressionContext)_localctx).b!=null?_input.getText(((EndExpressionContext)_localctx).b.start,((EndExpressionContext)_localctx).b.stop):null));
					}
					}
					setState(428);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(429); ((EndExpressionContext)_localctx).LISTEND = match(LISTEND);
					
						((EndExpressionContext)_localctx).zName =  _localctx.zName.concat((((EndExpressionContext)_localctx).LISTSTART!=null?((EndExpressionContext)_localctx).LISTSTART.getText():null));
						String type = new String();
						//Llenamos elements y ponemos cada expression en la memory
						while( !_localctx.elements.isEmpty() ){
							String e = _localctx.elements.remove(0);
							if (type.equals("")) {
								type = types.get(e);
							}
							((EndExpressionContext)_localctx).zName =  _localctx.zName.concat(e);
							//guardamos tambien las traducciones del conjunto
							((EndExpressionContext)_localctx).setlogName =  _localctx.setlogName.concat(memory.get(e));
							
							if (!_localctx.elements.isEmpty()){
								((EndExpressionContext)_localctx).zName =  _localctx.zName + ",";
								((EndExpressionContext)_localctx).setlogName =  _localctx.setlogName + ",";
							}
						}
						((EndExpressionContext)_localctx).zName =  _localctx.zName + (((EndExpressionContext)_localctx).LISTEND!=null?((EndExpressionContext)_localctx).LISTEND.getText():null);
						if (memory.get(_localctx.zName) == null) {
							memory.put(_localctx.zName, "[" + _localctx.setlogName + "]");
							if (_localctx.setlogName.equals(""))
								types.put(_localctx.zName, "\\seq(" + "generic" + ")");
							else
								types.put(_localctx.zName, "\\seq(" + type + ")");
						}
					
				}
				break;

			case 8:
				{
				setState(431); match(40);
				setState(432); ((EndExpressionContext)_localctx).a = ((EndExpressionContext)_localctx).expression = expression(0);
				_localctx.elements.add((((EndExpressionContext)_localctx).a!=null?_input.getText(((EndExpressionContext)_localctx).a.start,((EndExpressionContext)_localctx).a.stop):null));
				setState(438); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(434); match(38);
					setState(435); ((EndExpressionContext)_localctx).b = ((EndExpressionContext)_localctx).expression = expression(0);
					_localctx.elements.add((((EndExpressionContext)_localctx).b!=null?_input.getText(((EndExpressionContext)_localctx).b.start,((EndExpressionContext)_localctx).b.stop):null));
					}
					}
					setState(440); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==38 );
				setState(442); match(18);
					
						((EndExpressionContext)_localctx).zName =  "(";
						String type = new String();
						//Llenamos elements y ponemos cada expression en la memory
						while( !_localctx.elements.isEmpty() ){
							String e = _localctx.elements.remove(0);
							if (type.equals(""))
								type = "(" + types.get(e) + ")";
							else
								type = type.concat("\\cross(" + types.get(e) + ")");
								 
							((EndExpressionContext)_localctx).zName =  _localctx.zName.concat(e);
							//guardamos tambien las traducciones del conjunto
							((EndExpressionContext)_localctx).setlogName =  _localctx.setlogName.concat(memory.get(e));
							
							if (!_localctx.elements.isEmpty()){
								((EndExpressionContext)_localctx).zName =  _localctx.zName + ",";
								((EndExpressionContext)_localctx).setlogName =  _localctx.setlogName + ",";
							}
						}
						((EndExpressionContext)_localctx).zName =  _localctx.zName + ")";
						if (memory.get(_localctx.zName) == null) {
							memory.put(_localctx.zName, "[" + _localctx.setlogName + "]");
							types.put(_localctx.zName, type);
						}
					
				}
				break;

			case 9:
				{
				setState(445); match(40);
				setState(446); ((EndExpressionContext)_localctx).e = ((EndExpressionContext)_localctx).expression = expression(0);
				setState(447); match(18);

						String a = memory.get((((EndExpressionContext)_localctx).e!=null?_input.getText(((EndExpressionContext)_localctx).e.start,((EndExpressionContext)_localctx).e.stop):null));
						
						//Chequeo el nombre para ver si se trata de una sola variable, en ese caso no guardo en la memoria
						//los parentesis, en otro caso si
						
						if (a != null) { //Si no estoy en la parte de declaracion
							Pattern p = Pattern.compile("[^a-zA-Z0-9_]");
							boolean hasSpecialChar = p.matcher(a).find();
							
							if (hasSpecialChar){
								memory.put("(" + (((EndExpressionContext)_localctx).e!=null?_input.getText(((EndExpressionContext)_localctx).e.start,((EndExpressionContext)_localctx).e.stop):null) + ")", "(" + a + ")");
								if (types.get((((EndExpressionContext)_localctx).e!=null?_input.getText(((EndExpressionContext)_localctx).e.start,((EndExpressionContext)_localctx).e.stop):null)) != null) {
									types.put("(" + (((EndExpressionContext)_localctx).e!=null?_input.getText(((EndExpressionContext)_localctx).e.start,((EndExpressionContext)_localctx).e.stop):null) + ")", "(" + types.get((((EndExpressionContext)_localctx).e!=null?_input.getText(((EndExpressionContext)_localctx).e.start,((EndExpressionContext)_localctx).e.stop):null)) + ")");
								}
							}
							else {
								memory.put("(" + (((EndExpressionContext)_localctx).e!=null?_input.getText(((EndExpressionContext)_localctx).e.start,((EndExpressionContext)_localctx).e.stop):null) + ")", a);
								if (types.get((((EndExpressionContext)_localctx).e!=null?_input.getText(((EndExpressionContext)_localctx).e.start,((EndExpressionContext)_localctx).e.stop):null)) != null) {
									types.put("(" + (((EndExpressionContext)_localctx).e!=null?_input.getText(((EndExpressionContext)_localctx).e.start,((EndExpressionContext)_localctx).e.stop):null) + ")", "(" + types.get((((EndExpressionContext)_localctx).e!=null?_input.getText(((EndExpressionContext)_localctx).e.start,((EndExpressionContext)_localctx).e.stop):null)) + ")");
								}
							}
						} else  //Si estoy en la parte de declaracion
							if (types.get((((EndExpressionContext)_localctx).e!=null?_input.getText(((EndExpressionContext)_localctx).e.start,((EndExpressionContext)_localctx).e.stop):null)) != null)
								types.put("(" + (((EndExpressionContext)_localctx).e!=null?_input.getText(((EndExpressionContext)_localctx).e.start,((EndExpressionContext)_localctx).e.stop):null) + ")", "(" + types.get((((EndExpressionContext)_localctx).e!=null?_input.getText(((EndExpressionContext)_localctx).e.start,((EndExpressionContext)_localctx).e.stop):null)) + ")");
					
				}
				break;

			case 10:
				{
				setState(450); match(26);
				setState(451); match(9);
					
						printInfo(_input.getText(_localctx.start, _input.LT(-1)), false);	
					
				}
				break;

			case 11:
				{
				setState(453); match(26);
					
						printInfo(_input.getText(_localctx.start, _input.LT(-1)), false);	
					
				}
				break;

			case 12:
				{
				setState(455); match(60);
					
						printInfo(_input.getText(_localctx.start, _input.LT(-1)), false);	
					
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(472);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(470);
					switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
					case 1:
						{
						_localctx = new EndExpressionContext(_parentctx, _parentState, _p);
						_localctx.end = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_endExpression);
						setState(459);
						if (!(6 >= _localctx._p)) throw new FailedPredicateException(this, "6 >= $_p");
						setState(460); match(SELECTION);
						setState(463);
						switch (_input.LA(1)) {
						case NAME:
							{
							setState(461); ((EndExpressionContext)_localctx).refName = refName();
							}
							break;
						case NUM:
							{
							setState(462); ((EndExpressionContext)_localctx).NUM = match(NUM);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}

						          		String n;
						          		if ((((EndExpressionContext)_localctx).refName!=null?_input.getText(((EndExpressionContext)_localctx).refName.start,((EndExpressionContext)_localctx).refName.stop):null) == null)
						          			n = (((EndExpressionContext)_localctx).NUM!=null?((EndExpressionContext)_localctx).NUM.getText():null);
						          		else
						          			n = (((EndExpressionContext)_localctx).refName!=null?_input.getText(((EndExpressionContext)_localctx).refName.start,((EndExpressionContext)_localctx).refName.stop):null);
						          			
						          		if (memory.get((((EndExpressionContext)_localctx).end!=null?_input.getText(((EndExpressionContext)_localctx).end.start,((EndExpressionContext)_localctx).end.stop):null) + "." + n) == null) {
						          		
						          			String eType = types.get((((EndExpressionContext)_localctx).end!=null?_input.getText(((EndExpressionContext)_localctx).end.start,((EndExpressionContext)_localctx).end.stop):null));
						          			if (!eType.startsWith("SchemaType:")) //Debo llegar a obtener la lista con las variables
						          				eType = types.get(eType);
						          			
						          			if (eType.startsWith("SchemaType:")) {
						          				String schemaVars = eType.split(":", 3)[2];
						          				//Obtengo el indice de la variable e2 dentro de la lista de variables del tipo schema
						          				//Primero obtenemos la lista de variables
						          				schemaVars = schemaVars.substring(1, schemaVars.length()-1);
						          				String[] vars = schemaVars.split(",");
						          				//Buscamos la posicion de la variable
						          				int position = 1;
						          				while (!vars[position-1].contains(n + ":")) //Se resta 1 porque en setlog empiezan en 1, no en 0 como en java
						          					position++;
						          				//Creamos una nueva variable
						          				String newVarName = newVar();
						          				//Vemos su tipo
						          				String type = vars[position-1].substring(n.length()+1);
						          				memory.put((((EndExpressionContext)_localctx).end!=null?_input.getText(((EndExpressionContext)_localctx).end.start,((EndExpressionContext)_localctx).end.stop):null) + "." + n, newVarName);
						          				if (modoSetExpression != 0 )
						          					setExpressionVars.put((((EndExpressionContext)_localctx).end!=null?_input.getText(((EndExpressionContext)_localctx).end.start,((EndExpressionContext)_localctx).end.stop):null) + "." + n, newVarName);
						          				types.put((((EndExpressionContext)_localctx).end!=null?_input.getText(((EndExpressionContext)_localctx).end.start,((EndExpressionContext)_localctx).end.stop):null) + "." + n, type);
						          				print("nth1(" + position + "," + memory.get((((EndExpressionContext)_localctx).end!=null?_input.getText(((EndExpressionContext)_localctx).end.start,((EndExpressionContext)_localctx).end.stop):null)) + "," + newVarName + ")");
						          				
						          				typeInfo(newVarName, type);
						          				
						          			}
						          			else { //Se pide el elemento de una tupla
						          				String newVarName = newVar();
						          				memory.put((((EndExpressionContext)_localctx).end!=null?_input.getText(((EndExpressionContext)_localctx).end.start,((EndExpressionContext)_localctx).end.stop):null) + "." + n, newVarName);
						          				eType = leftAndRightTypes(eType).get(Integer.parseInt(n)-1);
						          				types.put((((EndExpressionContext)_localctx).end!=null?_input.getText(((EndExpressionContext)_localctx).end.start,((EndExpressionContext)_localctx).end.stop):null) + "." + n, eType); //Arreglar
						          				print("nth1(" + n + "," + memory.get((((EndExpressionContext)_localctx).end!=null?_input.getText(((EndExpressionContext)_localctx).end.start,((EndExpressionContext)_localctx).end.stop):null)) + "," + newVarName + ")");
						          			}
						          		}
						          	
						}
						break;

					case 2:
						{
						_localctx = new EndExpressionContext(_parentctx, _parentState, _p);
						_localctx.end = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_endExpression);
						setState(466);
						if (!(5 >= _localctx._p)) throw new FailedPredicateException(this, "5 >= $_p");
						setState(467); ((EndExpressionContext)_localctx).post = post();

						          		String a;
						          		a = memory.get((((EndExpressionContext)_localctx).end!=null?_input.getText(((EndExpressionContext)_localctx).end.start,((EndExpressionContext)_localctx).end.stop):null));
						          		String op = (((EndExpressionContext)_localctx).post!=null?_input.getText(((EndExpressionContext)_localctx).post.start,((EndExpressionContext)_localctx).post.stop):null);
						          		
						          		if (memory.get((((EndExpressionContext)_localctx).end!=null?_input.getText(((EndExpressionContext)_localctx).end.start,((EndExpressionContext)_localctx).end.stop):null) + op) == null) {
						          		
						          			String newVarName = newVar();
						          		
						          			if (op.startsWith("\\inv")){
						          				//Si a es una lista, debo convertirla
						          				a = convertToSet((((EndExpressionContext)_localctx).end!=null?_input.getText(((EndExpressionContext)_localctx).end.start,((EndExpressionContext)_localctx).end.stop):null), a);
						          			
						          				print("inv(" + newVarName + "," + a + ")");
						          				memory.put((((EndExpressionContext)_localctx).end!=null?_input.getText(((EndExpressionContext)_localctx).end.start,((EndExpressionContext)_localctx).end.stop):null) + op, newVarName);
						          				String type = types.get((((EndExpressionContext)_localctx).end!=null?_input.getText(((EndExpressionContext)_localctx).end.start,((EndExpressionContext)_localctx).end.stop):null));
						          				if (isSequence(getType(type)))
						          					type = "\\power(\\nat\\cross(" + leftAndRightTypes(type).get(1) + "))";
						          				type = invertType(type); 
						          				types.put((((EndExpressionContext)_localctx).end!=null?_input.getText(((EndExpressionContext)_localctx).end.start,((EndExpressionContext)_localctx).end.stop):null) + op, type);
						          				typeInfo(newVarName, type);
						          				if (modoSetExpression != 0 )
						          					setExpressionVars.put((((EndExpressionContext)_localctx).end!=null?_input.getText(((EndExpressionContext)_localctx).end.start,((EndExpressionContext)_localctx).end.stop):null) + op, newVarName);
						          			}
						          		}
						          	
						}
						break;
					}
					} 
				}
				setState(474);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class RefNameContext extends ParserRuleContext {
		public Token NAME;
		public TerminalNode NAME() { return getToken(ExprParser.NAME, 0); }
		public RefNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_refName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterRefName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitRefName(this);
		}
	}

	public final RefNameContext refName() throws RecognitionException {
		RefNameContext _localctx = new RefNameContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_refName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(475); ((RefNameContext)_localctx).NAME = match(NAME);

					if (memory.get((((RefNameContext)_localctx).NAME!=null?((RefNameContext)_localctx).NAME.getText():null)) == null)
					{
						String newVarName = newVar((((RefNameContext)_localctx).NAME!=null?((RefNameContext)_localctx).NAME.getText():null));
						
						memory.put((((RefNameContext)_localctx).NAME!=null?((RefNameContext)_localctx).NAME.getText():null), newVarName);
						if (modoSetExpression != 0 )
							setExpressionVars.put((((RefNameContext)_localctx).NAME!=null?((RefNameContext)_localctx).NAME.getText():null), newVarName);
					}
				
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PostContext extends ParserRuleContext {
		public PostContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_post; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterPost(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitPost(this);
		}
	}

	public final PostContext post() throws RecognitionException {
		PostContext _localctx = new PostContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_post);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(478); match(48);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PreContext extends ParserRuleContext {
		public PreContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pre; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterPre(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitPre(this);
		}
	}

	public final PreContext pre() throws RecognitionException {
		PreContext _localctx = new PreContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_pre);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(480);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 3) | (1L << 4) | (1L << 5) | (1L << 10) | (1L << 12) | (1L << 13) | (1L << 16) | (1L << 20) | (1L << 21) | (1L << 25) | (1L << 30) | (1L << 37) | (1L << 43) | (1L << 45) | (1L << 57))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 9: return predicate_sempred((PredicateContext)_localctx, predIndex);

		case 10: return expression_sempred((ExpressionContext)_localctx, predIndex);

		case 11: return endExpression_sempred((EndExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4: return 12 >= _localctx._p;

		case 5: return 11 >= _localctx._p;

		case 6: return 10 >= _localctx._p;

		case 7: return 9 >= _localctx._p;

		case 8: return 8 >= _localctx._p;

		case 9: return 7 >= _localctx._p;

		case 10: return 6 >= _localctx._p;

		case 11: return 5 >= _localctx._p;

		case 12: return 4 >= _localctx._p;

		case 13: return 3 >= _localctx._p;

		case 14: return 15 >= _localctx._p;

		case 15: return 14 >= _localctx._p;

		case 16: return 2 >= _localctx._p;
		}
		return true;
	}
	private boolean endExpression_sempred(EndExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 17: return 6 >= _localctx._p;

		case 18: return 5 >= _localctx._p;
		}
		return true;
	}
	private boolean predicate_sempred(PredicateContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return 4 >= _localctx._p;

		case 1: return 3 >= _localctx._p;

		case 2: return 2 >= _localctx._p;

		case 3: return 1 >= _localctx._p;
		}
		return true;
	}

	public static final String _serializedATN =
		"\2\3W\u01e5\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4"+
		"\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20"+
		"\3\2\3\2\7\2#\n\2\f\2\16\2&\13\2\6\2(\n\2\r\2\16\2)\3\2\3\2\3\3\3\3\3"+
		"\3\3\3\5\3\62\n\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3=\n\3\3\3\3\3"+
		"\3\3\3\3\5\3C\n\3\3\3\3\3\3\3\5\3H\n\3\3\3\3\3\6\3L\n\3\r\3\16\3M\3\3"+
		"\3\3\5\3R\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4[\n\4\f\4\16\4^\13\4\3\4"+
		"\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\5\6m\n\6\3\6\3\6\3\6"+
		"\3\6\5\6s\n\6\7\6u\n\6\f\6\16\6x\13\6\3\6\3\6\3\7\3\7\3\7\3\7\5\7\u0080"+
		"\n\7\3\7\3\7\5\7\u0084\n\7\3\7\3\7\3\7\7\7\u0089\n\7\f\7\16\7\u008c\13"+
		"\7\3\b\3\b\3\b\7\b\u0091\n\b\f\b\16\b\u0094\13\b\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\7\t\u009c\n\t\f\t\16\t\u009f\13\t\3\t\3\t\3\t\3\t\3\n\3\n\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13"+
		"\u00b6\n\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\5\13\u00fe\n\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\7\13\u010c\n\13\f\13\16\13\u010f\13\13\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u011b\n\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\5\f\u015b\n\f\3\f\3\f\7\f\u015f\n\f\f\f\16\f\u0162\13\f\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u016e\n\r\3\r\3\r\3\r\3\r\7\r\u0174"+
		"\n\r\f\r\16\r\u0177\13\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5"+
		"\r\u0184\n\r\3\r\3\r\3\r\3\r\3\r\5\r\u018b\n\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\5\r\u0198\n\r\6\r\u019a\n\r\r\r\16\r\u019b\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\5\r\u01a5\n\r\3\r\3\r\3\r\3\r\7\r\u01ab\n\r\f\r"+
		"\16\r\u01ae\13\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\6\r\u01b9\n\r\r\r"+
		"\16\r\u01ba\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\5\r\u01cc\n\r\3\r\3\r\3\r\3\r\5\r\u01d2\n\r\3\r\3\r\3\r\3\r\3\r\7\r"+
		"\u01d9\n\r\f\r\16\r\u01dc\13\r\3\16\3\16\3\16\3\17\3\17\3\20\3\20\3\20"+
		"\2\21\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36\2\4\4::OO\r\5\7\f\f\16\17"+
		"\22\22\26\27\33\33  \'\'--//;;\u0223\2\'\3\2\2\2\4Q\3\2\2\2\6S\3\2\2\2"+
		"\bb\3\2\2\2\ng\3\2\2\2\f{\3\2\2\2\16\u008d\3\2\2\2\20\u0095\3\2\2\2\22"+
		"\u00a4\3\2\2\2\24\u00fd\3\2\2\2\26\u011a\3\2\2\2\30\u01cb\3\2\2\2\32\u01dd"+
		"\3\2\2\2\34\u01e0\3\2\2\2\36\u01e2\3\2\2\2 $\5\4\3\2!#\7O\2\2\"!\3\2\2"+
		"\2#&\3\2\2\2$\"\3\2\2\2$%\3\2\2\2%(\3\2\2\2&$\3\2\2\2\' \3\2\2\2()\3\2"+
		"\2\2)\'\3\2\2\2)*\3\2\2\2*+\3\2\2\2+,\b\2\1\2,\3\3\2\2\2-\61\7\64\2\2"+
		".\62\7\3\2\2/\60\78\2\2\60\62\b\3\1\2\61.\3\2\2\2\61/\3\2\2\2\62\63\3"+
		"\2\2\2\63\64\7)\2\2\64\65\7L\2\2\65\66\7\20\2\2\66\67\5\f\7\2\678\b\3"+
		"\1\28<\7$\2\29=\7\3\2\2:;\78\2\2;=\b\3\1\2<9\3\2\2\2<:\3\2\2\2=>\3\2\2"+
		"\2>?\7\20\2\2?R\3\2\2\2@B\7=\2\2AC\7O\2\2BA\3\2\2\2BC\3\2\2\2CK\3\2\2"+
		"\2DH\5\6\4\2EH\5\b\5\2FH\5\n\6\2GD\3\2\2\2GE\3\2\2\2GF\3\2\2\2HI\3\2\2"+
		"\2IJ\7O\2\2JL\3\2\2\2KG\3\2\2\2LM\3\2\2\2MK\3\2\2\2MN\3\2\2\2NO\3\2\2"+
		"\2OP\7.\2\2PR\3\2\2\2Q-\3\2\2\2Q@\3\2\2\2R\5\3\2\2\2ST\7\b\2\2TU\5\22"+
		"\n\2U\\\b\4\1\2VW\7(\2\2WX\5\22\n\2XY\b\4\1\2Y[\3\2\2\2ZV\3\2\2\2[^\3"+
		"\2\2\2\\Z\3\2\2\2\\]\3\2\2\2]_\3\2\2\2^\\\3\2\2\2_`\7&\2\2`a\b\4\1\2a"+
		"\7\3\2\2\2bc\5\22\n\2cd\7?\2\2de\5\26\f\2ef\b\5\1\2f\t\3\2\2\2gh\5\22"+
		"\n\2hi\7!\2\2ij\5\22\n\2jl\b\6\1\2km\5\26\f\2lk\3\2\2\2lm\3\2\2\2mv\3"+
		"\2\2\2no\7#\2\2op\5\22\n\2pr\b\6\1\2qs\5\26\f\2rq\3\2\2\2rs\3\2\2\2su"+
		"\3\2\2\2tn\3\2\2\2ux\3\2\2\2vt\3\2\2\2vw\3\2\2\2wy\3\2\2\2xv\3\2\2\2y"+
		"z\b\6\1\2z\13\3\2\2\2{\177\7O\2\2|}\5\16\b\2}~\7O\2\2~\u0080\3\2\2\2\177"+
		"|\3\2\2\2\177\u0080\3\2\2\2\u0080\u0083\3\2\2\2\u0081\u0082\7\36\2\2\u0082"+
		"\u0084\7O\2\2\u0083\u0081\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u008a\3\2"+
		"\2\2\u0085\u0086\5\24\13\2\u0086\u0087\7O\2\2\u0087\u0089\3\2\2\2\u0088"+
		"\u0085\3\2\2\2\u0089\u008c\3\2\2\2\u008a\u0088\3\2\2\2\u008a\u008b\3\2"+
		"\2\2\u008b\r\3\2\2\2\u008c\u008a\3\2\2\2\u008d\u0092\5\20\t\2\u008e\u008f"+
		"\t\2\2\2\u008f\u0091\5\20\t\2\u0090\u008e\3\2\2\2\u0091\u0094\3\2\2\2"+
		"\u0092\u0090\3\2\2\2\u0092\u0093\3\2\2\2\u0093\17\3\2\2\2\u0094\u0092"+
		"\3\2\2\2\u0095\u0096\5\22\n\2\u0096\u009d\b\t\1\2\u0097\u0098\7(\2\2\u0098"+
		"\u0099\5\22\n\2\u0099\u009a\b\t\1\2\u009a\u009c\3\2\2\2\u009b\u0097\3"+
		"\2\2\2\u009c\u009f\3\2\2\2\u009d\u009b\3\2\2\2\u009d\u009e\3\2\2\2\u009e"+
		"\u00a0\3\2\2\2\u009f\u009d\3\2\2\2\u00a0\u00a1\7+\2\2\u00a1\u00a2\5\26"+
		"\f\2\u00a2\u00a3\b\t\1\2\u00a3\21\3\2\2\2\u00a4\u00a5\7L\2\2\u00a5\23"+
		"\3\2\2\2\u00a6\u00a7\b\13\1\2\u00a7\u00a8\5\26\f\2\u00a8\u00a9\7\60\2"+
		"\2\u00a9\u00aa\5\26\f\2\u00aa\u00ab\b\13\1\2\u00ab\u00fe\3\2\2\2\u00ac"+
		"\u00ad\5\26\f\2\u00ad\u00ae\7\21\2\2\u00ae\u00af\5\26\f\2\u00af\u00b6"+
		"\3\2\2\2\u00b0\u00b1\7\4\2\2\u00b1\u00b2\5\26\f\2\u00b2\u00b3\7\60\2\2"+
		"\u00b3\u00b4\5\26\f\2\u00b4\u00b6\3\2\2\2\u00b5\u00ac\3\2\2\2\u00b5\u00b0"+
		"\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00b8\b\13\1\2\u00b8\u00fe\3\2\2\2"+
		"\u00b9\u00ba\5\26\f\2\u00ba\u00bb\7\t\2\2\u00bb\u00bc\5\26\f\2\u00bc\u00bd"+
		"\b\13\1\2\u00bd\u00fe\3\2\2\2\u00be\u00bf\5\26\f\2\u00bf\u00c0\7<\2\2"+
		"\u00c0\u00c1\5\26\f\2\u00c1\u00c2\b\13\1\2\u00c2\u00fe\3\2\2\2\u00c3\u00c4"+
		"\5\26\f\2\u00c4\u00c5\7\31\2\2\u00c5\u00c6\5\26\f\2\u00c6\u00c7\b\13\1"+
		"\2\u00c7\u00fe\3\2\2\2\u00c8\u00c9\5\26\f\2\u00c9\u00ca\7\37\2\2\u00ca"+
		"\u00cb\5\26\f\2\u00cb\u00cc\b\13\1\2\u00cc\u00fe\3\2\2\2\u00cd\u00ce\5"+
		"\26\f\2\u00ce\u00cf\7\30\2\2\u00cf\u00d0\5\26\f\2\u00d0\u00d1\b\13\1\2"+
		"\u00d1\u00fe\3\2\2\2\u00d2\u00d3\5\26\f\2\u00d3\u00d4\7\"\2\2\u00d4\u00d5"+
		"\5\26\f\2\u00d5\u00d6\b\13\1\2\u00d6\u00fe\3\2\2\2\u00d7\u00d8\7\4\2\2"+
		"\u00d8\u00d9\5\26\f\2\u00d9\u00da\7\"\2\2\u00da\u00db\5\26\f\2\u00db\u00dc"+
		"\b\13\1\2\u00dc\u00fe\3\2\2\2\u00dd\u00de\5\26\f\2\u00de\u00df\7\66\2"+
		"\2\u00df\u00e0\5\26\f\2\u00e0\u00e1\b\13\1\2\u00e1\u00fe\3\2\2\2\u00e2"+
		"\u00e3\7\4\2\2\u00e3\u00e4\5\26\f\2\u00e4\u00e5\7\66\2\2\u00e5\u00e6\5"+
		"\26\f\2\u00e6\u00e7\b\13\1\2\u00e7\u00fe\3\2\2\2\u00e8\u00e9\5\26\f\2"+
		"\u00e9\u00ea\7\35\2\2\u00ea\u00eb\5\26\f\2\u00eb\u00ec\b\13\1\2\u00ec"+
		"\u00fe\3\2\2\2\u00ed\u00ee\5\26\f\2\u00ee\u00ef\7\32\2\2\u00ef\u00f0\5"+
		"\26\f\2\u00f0\u00f1\b\13\1\2\u00f1\u00fe\3\2\2\2\u00f2\u00f3\5\26\f\2"+
		"\u00f3\u00f4\7%\2\2\u00f4\u00f5\5\26\f\2\u00f5\u00f6\b\13\1\2\u00f6\u00fe"+
		"\3\2\2\2\u00f7\u00f8\7*\2\2\u00f8\u00f9\5\24\13\2\u00f9\u00fa\7\24\2\2"+
		"\u00fa\u00fe\3\2\2\2\u00fb\u00fe\7\63\2\2\u00fc\u00fe\7\n\2\2\u00fd\u00a6"+
		"\3\2\2\2\u00fd\u00b5\3\2\2\2\u00fd\u00b9\3\2\2\2\u00fd\u00be\3\2\2\2\u00fd"+
		"\u00c3\3\2\2\2\u00fd\u00c8\3\2\2\2\u00fd\u00cd\3\2\2\2\u00fd\u00d2\3\2"+
		"\2\2\u00fd\u00d7\3\2\2\2\u00fd\u00dd\3\2\2\2\u00fd\u00e2\3\2\2\2\u00fd"+
		"\u00e8\3\2\2\2\u00fd\u00ed\3\2\2\2\u00fd\u00f2\3\2\2\2\u00fd\u00f7\3\2"+
		"\2\2\u00fd\u00fb\3\2\2\2\u00fd\u00fc\3\2\2\2\u00fe\u010d\3\2\2\2\u00ff"+
		"\u0100\6\13\2\3\u0100\u0101\7\67\2\2\u0101\u010c\5\24\13\2\u0102\u0103"+
		"\6\13\3\3\u0103\u0104\79\2\2\u0104\u010c\5\24\13\2\u0105\u0106\6\13\4"+
		"\3\u0106\u0107\7,\2\2\u0107\u010c\5\24\13\2\u0108\u0109\6\13\5\3\u0109"+
		"\u010a\7\23\2\2\u010a\u010c\5\24\13\2\u010b\u00ff\3\2\2\2\u010b\u0102"+
		"\3\2\2\2\u010b\u0105\3\2\2\2\u010b\u0108\3\2\2\2\u010c\u010f\3\2\2\2\u010d"+
		"\u010b\3\2\2\2\u010d\u010e\3\2\2\2\u010e\25\3\2\2\2\u010f\u010d\3\2\2"+
		"\2\u0110\u0111\b\f\1\2\u0111\u0112\5\36\20\2\u0112\u0113\5\26\f\2\u0113"+
		"\u0114\b\f\1\2\u0114\u011b\3\2\2\2\u0115\u0116\7A\2\2\u0116\u0117\5\26"+
		"\f\2\u0117\u0118\b\f\1\2\u0118\u011b\3\2\2\2\u0119\u011b\5\30\r\2\u011a"+
		"\u0110\3\2\2\2\u011a\u0115\3\2\2\2\u011a\u0119\3\2\2\2\u011b\u0160\3\2"+
		"\2\2\u011c\u011d\6\f\6\3\u011d\u011e\7@\2\2\u011e\u011f\5\26\f\2\u011f"+
		"\u0120\b\f\1\2\u0120\u015f\3\2\2\2\u0121\u0122\6\f\7\3\u0122\u0123\7B"+
		"\2\2\u0123\u0124\5\26\f\2\u0124\u0125\b\f\1\2\u0125\u015f\3\2\2\2\u0126"+
		"\u0127\6\f\b\3\u0127\u0128\7C\2\2\u0128\u0129\5\26\f\2\u0129\u012a\b\f"+
		"\1\2\u012a\u015f\3\2\2\2\u012b\u012c\6\f\t\3\u012c\u012d\7D\2\2\u012d"+
		"\u012e\5\26\f\2\u012e\u012f\b\f\1\2\u012f\u015f\3\2\2\2\u0130\u0131\6"+
		"\f\n\3\u0131\u0132\7E\2\2\u0132\u0133\5\26\f\2\u0133\u0134\b\f\1\2\u0134"+
		"\u015f\3\2\2\2\u0135\u0136\6\f\13\3\u0136\u0137\7F\2\2\u0137\u0138\5\26"+
		"\f\2\u0138\u0139\b\f\1\2\u0139\u015f\3\2\2\2\u013a\u013b\6\f\f\3\u013b"+
		"\u013c\7G\2\2\u013c\u013d\5\26\f\2\u013d\u013e\b\f\1\2\u013e\u015f\3\2"+
		"\2\2\u013f\u0140\6\f\r\3\u0140\u0141\7H\2\2\u0141\u0142\5\26\f\2\u0142"+
		"\u0143\b\f\1\2\u0143\u015f\3\2\2\2\u0144\u0145\6\f\16\3\u0145\u0146\7"+
		"I\2\2\u0146\u0147\5\26\f\2\u0147\u0148\b\f\1\2\u0148\u015f\3\2\2\2\u0149"+
		"\u014a\6\f\17\3\u014a\u014b\7J\2\2\u014b\u014c\5\26\f\2\u014c\u014d\b"+
		"\f\1\2\u014d\u015f\3\2\2\2\u014e\u014f\6\f\20\3\u014f\u0150\5\30\r\2\u0150"+
		"\u0151\b\f\1\2\u0151\u015f\3\2\2\2\u0152\u0153\6\f\21\3\u0153\u0154\7"+
		"N\2\2\u0154\u015f\b\f\1\2\u0155\u0156\6\f\22\3\u0156\u0157\7U\2\2\u0157"+
		"\u0158\5\26\f\2\u0158\u015a\7V\2\2\u0159\u015b\7N\2\2\u015a\u0159\3\2"+
		"\2\2\u015a\u015b\3\2\2\2\u015b\u015c\3\2\2\2\u015c\u015d\b\f\1\2\u015d"+
		"\u015f\3\2\2\2\u015e\u011c\3\2\2\2\u015e\u0121\3\2\2\2\u015e\u0126\3\2"+
		"\2\2\u015e\u012b\3\2\2\2\u015e\u0130\3\2\2\2\u015e\u0135\3\2\2\2\u015e"+
		"\u013a\3\2\2\2\u015e\u013f\3\2\2\2\u015e\u0144\3\2\2\2\u015e\u0149\3\2"+
		"\2\2\u015e\u014e\3\2\2\2\u015e\u0152\3\2\2\2\u015e\u0155\3\2\2\2\u015f"+
		"\u0162\3\2\2\2\u0160\u015e\3\2\2\2\u0160\u0161\3\2\2\2\u0161\27\3\2\2"+
		"\2\u0162\u0160\3\2\2\2\u0163\u0164\b\r\1\2\u0164\u01cc\5\32\16\2\u0165"+
		"\u0166\7M\2\2\u0166\u01cc\b\r\1\2\u0167\u0168\7\r\2\2\u0168\u01cc\b\r"+
		"\1\2\u0169\u016d\7Q\2\2\u016a\u016b\5\26\f\2\u016b\u016c\b\r\1\2\u016c"+
		"\u016e\3\2\2\2\u016d\u016a\3\2\2\2\u016d\u016e\3\2\2\2\u016e\u0175\3\2"+
		"\2\2\u016f\u0170\7(\2\2\u0170\u0171\5\26\f\2\u0171\u0172\b\r\1\2\u0172"+
		"\u0174\3\2\2\2\u0173\u016f\3\2\2\2\u0174\u0177\3\2\2\2\u0175\u0173\3\2"+
		"\2\2\u0175\u0176\3\2\2\2\u0176\u0178\3\2\2\2\u0177\u0175\3\2\2\2\u0178"+
		"\u0179\7R\2\2\u0179\u01cc\b\r\1\2\u017a\u017b\7Q\2\2\u017b\u017c\b\r\1"+
		"\2\u017c\u017d\5\16\b\2\u017d\u0183\b\r\1\2\u017e\u017f\7#\2\2\u017f\u0180"+
		"\b\r\1\2\u0180\u0181\5\24\13\2\u0181\u0182\b\r\1\2\u0182\u0184\3\2\2\2"+
		"\u0183\u017e\3\2\2\2\u0183\u0184\3\2\2\2\u0184\u018a\3\2\2\2\u0185\u0186"+
		"\7\25\2\2\u0186\u0187\b\r\1\2\u0187\u0188\5\26\f\2\u0188\u0189\b\r\1\2"+
		"\u0189\u018b\3\2\2\2\u018a\u0185\3\2\2\2\u018a\u018b\3\2\2\2\u018b\u018c"+
		"\3\2\2\2\u018c\u018d\7R\2\2\u018d\u018e\b\r\1\2\u018e\u018f\b\r\1\2\u018f"+
		"\u01cc\3\2\2\2\u0190\u0191\7\65\2\2\u0191\u0199\b\r\1\2\u0192\u0193\7"+
		"L\2\2\u0193\u0194\7?\2\2\u0194\u0195\5\26\f\2\u0195\u0197\b\r\1\2\u0196"+
		"\u0198\7(\2\2\u0197\u0196\3\2\2\2\u0197\u0198\3\2\2\2\u0198\u019a\3\2"+
		"\2\2\u0199\u0192\3\2\2\2\u019a\u019b\3\2\2\2\u019b\u0199\3\2\2\2\u019b"+
		"\u019c\3\2\2\2\u019c\u019d\3\2\2\2\u019d\u019e\7\61\2\2\u019e\u019f\b"+
		"\r\1\2\u019f\u01cc\3\2\2\2\u01a0\u01a4\7S\2\2\u01a1\u01a2\5\26\f\2\u01a2"+
		"\u01a3\b\r\1\2\u01a3\u01a5\3\2\2\2\u01a4\u01a1\3\2\2\2\u01a4\u01a5\3\2"+
		"\2\2\u01a5\u01ac\3\2\2\2\u01a6\u01a7\7(\2\2\u01a7\u01a8\5\26\f\2\u01a8"+
		"\u01a9\b\r\1\2\u01a9\u01ab\3\2\2\2\u01aa\u01a6\3\2\2\2\u01ab\u01ae\3\2"+
		"\2\2\u01ac\u01aa\3\2\2\2\u01ac\u01ad\3\2\2\2\u01ad\u01af\3\2\2\2\u01ae"+
		"\u01ac\3\2\2\2\u01af\u01b0\7T\2\2\u01b0\u01cc\b\r\1\2\u01b1\u01b2\7*\2"+
		"\2\u01b2\u01b3\5\26\f\2\u01b3\u01b8\b\r\1\2\u01b4\u01b5\7(\2\2\u01b5\u01b6"+
		"\5\26\f\2\u01b6\u01b7\b\r\1\2\u01b7\u01b9\3\2\2\2\u01b8\u01b4\3\2\2\2"+
		"\u01b9\u01ba\3\2\2\2\u01ba\u01b8\3\2\2\2\u01ba\u01bb\3\2\2\2\u01bb\u01bc"+
		"\3\2\2\2\u01bc\u01bd\7\24\2\2\u01bd\u01be\b\r\1\2\u01be\u01cc\3\2\2\2"+
		"\u01bf\u01c0\7*\2\2\u01c0\u01c1\5\26\f\2\u01c1\u01c2\7\24\2\2\u01c2\u01c3"+
		"\b\r\1\2\u01c3\u01cc\3\2\2\2\u01c4\u01c5\7\34\2\2\u01c5\u01c6\7\13\2\2"+
		"\u01c6\u01cc\b\r\1\2\u01c7\u01c8\7\34\2\2\u01c8\u01cc\b\r\1\2\u01c9\u01ca"+
		"\7>\2\2\u01ca\u01cc\b\r\1\2\u01cb\u0163\3\2\2\2\u01cb\u0165\3\2\2\2\u01cb"+
		"\u0167\3\2\2\2\u01cb\u0169\3\2\2\2\u01cb\u017a\3\2\2\2\u01cb\u0190\3\2"+
		"\2\2\u01cb\u01a0\3\2\2\2\u01cb\u01b1\3\2\2\2\u01cb\u01bf\3\2\2\2\u01cb"+
		"\u01c4\3\2\2\2\u01cb\u01c7\3\2\2\2\u01cb\u01c9\3\2\2\2\u01cc\u01da\3\2"+
		"\2\2\u01cd\u01ce\6\r\23\3\u01ce\u01d1\7K\2\2\u01cf\u01d2\5\32\16\2\u01d0"+
		"\u01d2\7M\2\2\u01d1\u01cf\3\2\2\2\u01d1\u01d0\3\2\2\2\u01d2\u01d3\3\2"+
		"\2\2\u01d3\u01d9\b\r\1\2\u01d4\u01d5\6\r\24\3\u01d5\u01d6\5\34\17\2\u01d6"+
		"\u01d7\b\r\1\2\u01d7\u01d9\3\2\2\2\u01d8\u01cd\3\2\2\2\u01d8\u01d4\3\2"+
		"\2\2\u01d9\u01dc\3\2\2\2\u01da\u01d8\3\2\2\2\u01da\u01db\3\2\2\2\u01db"+
		"\31\3\2\2\2\u01dc\u01da\3\2\2\2\u01dd\u01de\7L\2\2\u01de\u01df\b\16\1"+
		"\2\u01df\33\3\2\2\2\u01e0\u01e1\7\62\2\2\u01e1\35\3\2\2\2\u01e2\u01e3"+
		"\t\3\2\2\u01e3\37\3\2\2\2($)\61<BGMQ\\lrv\177\u0083\u008a\u0092\u009d"+
		"\u00b5\u00fd\u010b\u010d\u011a\u015a\u015e\u0160\u016d\u0175\u0183\u018a"+
		"\u0197\u019b\u01a4\u01ac\u01ba\u01cb\u01d1\u01d8\u01da";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}