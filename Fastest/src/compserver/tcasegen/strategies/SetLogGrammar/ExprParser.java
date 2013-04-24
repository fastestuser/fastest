// Generated from Expr.g4 by ANTLR 4.0

	package compserver.tcasegen.strategies.SetLogGrammar;
	import java.util.HashMap;
	import java.util.ArrayList;
	import java.util.regex.Matcher;
	import java.util.regex.Pattern;
	import javax.swing.tree.DefaultMutableTreeNode;

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
	public static final String[] tokenNames = {
		"<INVALID>", "'schema'", "'\\lnot'", "'rev'", "'['", "'\\pfun'", "'<'", 
		"'false'", "'\\emptyset'", "'\\upto'", "'tail'", "'\\ffun'", "'}'", "'\\notin'", 
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
	public static final int
		RULE_specification = 0, RULE_paragraph = 1, RULE_basic_type = 2, RULE_equivalent_type = 3, 
		RULE_enumeration_type = 4, RULE_schemaText = 5, RULE_declPart = 6, RULE_declaration = 7, 
		RULE_declName = 8, RULE_predicate = 9, RULE_expression = 10, RULE_seq_op = 11;
	public static final String[] ruleNames = {
		"specification", "paragraph", "basic_type", "equivalent_type", "enumeration_type", 
		"schemaText", "declPart", "declaration", "declName", "predicate", "expression", 
		"seq_op"
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
			setState(31); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(24); paragraph();
				setState(28);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(25); match(NL);
					}
					}
					setState(30);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(33); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==43 || _la==54 );
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
			setState(73);
			switch (_input.LA(1)) {
			case 43:
				enterOuterAlt(_localctx, 1);
				{
				setState(37); match(43);
				setState(41);
				switch (_input.LA(1)) {
				case 1:
					{
					setState(38); match(1);
					}
					break;
				case 48:
					{
					{
					setState(39); match(48);
					tipoSchema = 1; schemaTypeVars = "";
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(43); match(35);
				setState(44); ((ParagraphContext)_localctx).NAME = match(NAME);
				setState(45); match(12);
				setState(46); schemaText();

							if (tipoSchema == 1) {
								String newVarName = newVar((((ParagraphContext)_localctx).NAME!=null?((ParagraphContext)_localctx).NAME.getText():null));
								memory.put((((ParagraphContext)_localctx).NAME!=null?((ParagraphContext)_localctx).NAME.getText():null), newVarName);
								types.put((((ParagraphContext)_localctx).NAME!=null?((ParagraphContext)_localctx).NAME.getText():null), "SchemaType:" + newVarName + ":[" + schemaTypeVars + "]");
								schemaTypeVars = "";
							}
						
				setState(48); match(29);
				setState(52);
				switch (_input.LA(1)) {
				case 1:
					{
					setState(49); match(1);
					}
					break;
				case 48:
					{
					{
					setState(50); match(48);
					tipoSchema = 0;
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(54); match(12);
				}
				break;
			case 54:
				enterOuterAlt(_localctx, 2);
				{
				setState(56); match(54);
				setState(58);
				_la = _input.LA(1);
				if (_la==NL) {
					{
					setState(57); match(NL);
					}
				}

				setState(67); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(63);
					switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
					case 1:
						{
						setState(60); basic_type();
						}
						break;

					case 2:
						{
						setState(61); equivalent_type();
						}
						break;

					case 3:
						{
						setState(62); enumeration_type();
						}
						break;
					}
					setState(65); match(NL);
					}
					}
					setState(69); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==4 || _la==NAME );
				setState(71); match(39);
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
			setState(75); match(4);
			setState(76); ((Basic_typeContext)_localctx).a = ((Basic_typeContext)_localctx).declName = declName();
			((Basic_typeContext)getInvokingContext(2)).typeList.add((((Basic_typeContext)_localctx).a!=null?_input.getText(((Basic_typeContext)_localctx).a.start,((Basic_typeContext)_localctx).a.stop):null));
			setState(84);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==34) {
				{
				{
				setState(78); match(34);
				setState(79); ((Basic_typeContext)_localctx).b = ((Basic_typeContext)_localctx).declName = declName();
				((Basic_typeContext)getInvokingContext(2)).typeList.add((((Basic_typeContext)_localctx).b!=null?_input.getText(((Basic_typeContext)_localctx).b.start,((Basic_typeContext)_localctx).b.stop):null));
				}
				}
				setState(86);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(87); match(31);

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
			setState(90); ((Equivalent_typeContext)_localctx).declName = declName();
			setState(91); match(56);
			setState(92); ((Equivalent_typeContext)_localctx).expression = expression(0);
			 
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
			setState(95); ((Enumeration_typeContext)_localctx).d = declName();
			setState(96); match(26);
			setState(97); ((Enumeration_typeContext)_localctx).a = declName();
			((Enumeration_typeContext)getInvokingContext(4)).cases.add((((Enumeration_typeContext)_localctx).a!=null?_input.getText(((Enumeration_typeContext)_localctx).a.start,((Enumeration_typeContext)_localctx).a.stop):null));
			setState(100);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 3) | (1L << 8) | (1L << 10) | (1L << 17) | (1L << 21) | (1L << 23) | (1L << 32) | (1L << 36) | (1L << 45) | (1L << 52) | (1L << 55) | (1L << NAME) | (1L << NUM))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (PRE_GEN - 65)) | (1L << (DECORATION - 65)) | (1L << (SETSTART - 65)) | (1L << (LISTSTART - 65)))) != 0)) {
				{
				setState(99); expression(0);
				}
			}

			setState(110);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==28) {
				{
				{
				setState(102); match(28);
				setState(103); ((Enumeration_typeContext)_localctx).b = declName();
				((Enumeration_typeContext)getInvokingContext(4)).cases.add((((Enumeration_typeContext)_localctx).b!=null?_input.getText(((Enumeration_typeContext)_localctx).b.start,((Enumeration_typeContext)_localctx).b.stop):null));
				setState(106);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 3) | (1L << 8) | (1L << 10) | (1L << 17) | (1L << 21) | (1L << 23) | (1L << 32) | (1L << 36) | (1L << 45) | (1L << 52) | (1L << 55) | (1L << NAME) | (1L << NUM))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (PRE_GEN - 65)) | (1L << (DECORATION - 65)) | (1L << (SETSTART - 65)) | (1L << (LISTSTART - 65)))) != 0)) {
					{
					setState(105); expression(0);
					}
				}

				}
				}
				setState(112);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
				
					String elements = new String();
					while( !((Enumeration_typeContext)getInvokingContext(4)).cases.isEmpty() ){
						String e = ((Enumeration_typeContext)getInvokingContext(4)).cases.remove(0);
						elements = elements.concat(e);
						
						memory.put(e,e); //REVISAR!!!
						
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
			setState(115); match(NL);
			setState(119);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				setState(116); declPart();
				setState(117); match(NL);
				}
				break;
			}
			setState(123);
			_la = _input.LA(1);
			if (_la==24) {
				{
				setState(121); match(24);
				setState(122); match(NL);
				}
			}

			setState(130);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 2) | (1L << 3) | (1L << 7) | (1L << 8) | (1L << 10) | (1L << 17) | (1L << 21) | (1L << 23) | (1L << 32) | (1L << 36) | (1L << 42) | (1L << 45) | (1L << 52) | (1L << 55) | (1L << NAME) | (1L << NUM))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (PRE_GEN - 65)) | (1L << (DECORATION - 65)) | (1L << (SETSTART - 65)) | (1L << (LISTSTART - 65)))) != 0)) {
				{
				{
				setState(125); predicate(0);
				setState(126); match(NL);
				}
				}
				setState(132);
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
			setState(133); declaration();
			setState(138);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(134);
					_la = _input.LA(1);
					if ( !(_la==51 || _la==NL) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					setState(135); declaration();
					}
					} 
				}
				setState(140);
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
			setState(141); ((DeclarationContext)_localctx).a = declName();
			((DeclarationContext)getInvokingContext(7)).vars.add((((DeclarationContext)_localctx).a!=null?_input.getText(((DeclarationContext)_localctx).a.start,((DeclarationContext)_localctx).a.stop):null));
			setState(149);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==34) {
				{
				{
				setState(143); match(34);
				setState(144); ((DeclarationContext)_localctx).b = declName();
				((DeclarationContext)getInvokingContext(7)).vars.add((((DeclarationContext)_localctx).b!=null?_input.getText(((DeclarationContext)_localctx).b.start,((DeclarationContext)_localctx).b.stop):null));
				}
				}
				setState(151);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(152); match(37);
			setState(153); ((DeclarationContext)_localctx).expression = expression(0);

					//Para cada variable realizamos el procesamiento
					while( !((DeclarationContext)getInvokingContext(7)).vars.isEmpty() ) {

						String var = ((DeclarationContext)getInvokingContext(7)).vars.remove(0);

						if (tipoSchema == 0)
							zVars.put(var, null); //Marcamos la variable como variable Z, a la cual posiblemente se le deba asignarsele un valor

						String newVarName = newVar(var);
						if (tipoSchema == 0)
							memory.put(var, newVarName);
						if (modoSetExpression==1)
							setExpressionVars.put(var, newVarName); //Falta ver que hacemos para variables ligadas con el mismo nombre en distintas ligaduras
						
						String expType = types.get((((DeclarationContext)_localctx).expression!=null?_input.getText(((DeclarationContext)_localctx).expression.start,((DeclarationContext)_localctx).expression.stop):null));
						expType = typeInfo(newVarName, expType);
						
						if (tipoSchema == 0)
							types.put(var, expType);
						else { //La agregamos como variable del esquema
							if (!schemaTypeVars.equals(""))
								schemaTypeVars = schemaTypeVars.concat(",");
							schemaTypeVars = schemaTypeVars.concat(var + ":" + expType);
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
			setState(156); match(NAME);
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
			setState(245);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				{
				setState(159); ((PredicateContext)_localctx).e1 = expression(0);
				setState(160); match(40);
				setState(161); ((PredicateContext)_localctx).e2 = expression(0);

						String a, b;
						a = memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						
						print(a + " in " + b);
					/*	//Impresion de tipo
						String type = types.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						if (type != null)
							if (type.equals("\\power\\num") || type.equals("\\power\\nat"))
								print(a + " in " + memory.get(type.substring(6)));*/
					
				}
				break;

			case 2:
				{
				setState(173);
				switch (_input.LA(1)) {
				case 3:
				case 8:
				case 10:
				case 17:
				case 21:
				case 23:
				case 32:
				case 36:
				case 45:
				case 52:
				case 55:
				case NAME:
				case NUM:
				case PRE_GEN:
				case DECORATION:
				case SETSTART:
				case LISTSTART:
					{
					setState(164); ((PredicateContext)_localctx).e1 = expression(0);
					setState(165); match(13);
					setState(166); ((PredicateContext)_localctx).e2 = expression(0);
					}
					break;
				case 2:
					{
					setState(168); match(2);
					setState(169); ((PredicateContext)_localctx).e1 = expression(0);
					setState(170); match(40);
					setState(171); ((PredicateContext)_localctx).e2 = expression(0);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}

						String a, b;
						a = memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						print(a + " nin " + b);
						/*
						//Impresion de tipo
						String type = types.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						if (type != null)
							if (type.equals("\\power\\num") || type.equals("\\power\\nat"))
								print(a + " in " + memory.get(type.substring(6)));*/
					
				}
				break;

			case 3:
				{
				setState(177); ((PredicateContext)_localctx).e1 = expression(0);
				setState(178); match(6);
				setState(179); ((PredicateContext)_localctx).e2 = expression(0);

						String a, b;
						a = memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						print(a + " < " + b);
					
				}
				break;

			case 4:
				{
				setState(182); ((PredicateContext)_localctx).e1 = expression(0);
				setState(183); match(53);
				setState(184); ((PredicateContext)_localctx).e2 = expression(0);

						String a, b;
						a = memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						print(a + " > " + b);
					
				}
				break;

			case 5:
				{
				setState(187); ((PredicateContext)_localctx).e1 = expression(0);
				setState(188); match(19);
				setState(189); ((PredicateContext)_localctx).e2 = expression(0);

						String a, b;
						a = memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						print(a + " =< " + b);
					
				}
				break;

			case 6:
				{
				setState(192); ((PredicateContext)_localctx).e1 = expression(0);
				setState(193); match(25);
				setState(194); ((PredicateContext)_localctx).e2 = expression(0);

						String a, b;
						a = memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						print(a + " =< " + b);
					
				}
				break;

			case 7:
				{
				setState(197); ((PredicateContext)_localctx).e1 = expression(0);
				setState(198); match(18);
				setState(199); ((PredicateContext)_localctx).e2 = expression(0);

						String a, b;
						a = memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						print(a + " = " + b);
					
				}
				break;

			case 8:
				{
				setState(202); ((PredicateContext)_localctx).e1 = expression(0);
				setState(203); match(27);
				setState(204); ((PredicateContext)_localctx).e2 = expression(0);

						String a, b;
						a = memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						print("dsubset(" + a + "," + b + ")");
					
				}
				break;

			case 9:
				{
				setState(207); match(2);
				setState(208); ((PredicateContext)_localctx).e1 = expression(0);
				setState(209); match(27);
				setState(210); ((PredicateContext)_localctx).e2 = expression(0);

						String a, b;
						a = memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						print("dnsubset(" + a + "," + b + ")");
					
				}
				break;

			case 10:
				{
				setState(213); ((PredicateContext)_localctx).e1 = expression(0);
				setState(214); match(44);
				setState(215); ((PredicateContext)_localctx).e2 = expression(0);

						String a, b;
						a = memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						print("dssubset(" + a + "," + b + ")");
					
				}
				break;

			case 11:
				{
				setState(218); match(2);
				setState(219); ((PredicateContext)_localctx).e1 = expression(0);
				setState(220); match(44);
				setState(221); ((PredicateContext)_localctx).e2 = expression(0);

						String a, b;
						a = memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						String c = memory.get( (((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null) + "\\cap" + (((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						if (c == null) {
							c = newVar();
							memory.put( (((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null) + "\\cap" + (((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null), c);
							print("dinters(" + a + "," + b + "," + c + ")");
							String type = types.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
							types.put((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null) + "\\cap" + (((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null), type);
							typeInfo(c, type);
						}
						
						print(c + " neq " + a);
					
				}
				break;

			case 12:
				{
				setState(224); ((PredicateContext)_localctx).e1 = expression(0);
				setState(225); match(22);
				setState(226); ((PredicateContext)_localctx).e2 = expression(0);

						String a, b;
						a = memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						print(a + " neq " + b);
					
				}
				break;

			case 13:
				{
				setState(229); ((PredicateContext)_localctx).e1 = expression(0);
				setState(230); match(20);
				setState(231); ((PredicateContext)_localctx).e2 = expression(0);

						String a, b;
						a = memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						print("prolog_call(append(" + a + ",_," + b + "))");
					
				}
				break;

			case 14:
				{
				setState(234); ((PredicateContext)_localctx).e1 = expression(0);
				setState(235); match(30);
				setState(236); ((PredicateContext)_localctx).e2 = expression(0);

						String a, b;
						a = memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						print("prolog_call(append(_," + a + "," + b + "))");
					
				}
				break;

			case 15:
				{
				setState(239); match(36);
				setState(240); predicate(0);
				setState(241); match(15);
				}
				break;

			case 16:
				{
				setState(243); match(42);
				}
				break;

			case 17:
				{
				setState(244); match(7);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(261);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(259);
					switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
					case 1:
						{
						_localctx = new PredicateContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_predicate);
						setState(247);
						if (!(4 >= _localctx._p)) throw new FailedPredicateException(this, "4 >= $_p");
						setState(248); match(47);
						setState(249); predicate(5);
						}
						break;

					case 2:
						{
						_localctx = new PredicateContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_predicate);
						setState(250);
						if (!(3 >= _localctx._p)) throw new FailedPredicateException(this, "3 >= $_p");
						setState(251); match(50);
						setState(252); predicate(4);
						}
						break;

					case 3:
						{
						_localctx = new PredicateContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_predicate);
						setState(253);
						if (!(2 >= _localctx._p)) throw new FailedPredicateException(this, "2 >= $_p");
						setState(254); match(38);
						setState(255); predicate(3);
						}
						break;

					case 4:
						{
						_localctx = new PredicateContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_predicate);
						setState(256);
						if (!(1 >= _localctx._p)) throw new FailedPredicateException(this, "1 >= $_p");
						setState(257); match(14);
						setState(258); predicate(2);
						}
						break;
					}
					} 
				}
				setState(263);
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
		public ExpressionContext a;
		public ExpressionContext e1;
		public ExpressionContext e;
		public Token PRE_GEN;
		public Seq_opContext seq_op;
		public Token NAME;
		public Token NUM;
		public ExpressionContext b;
		public Token SETSTART;
		public Token SETEND;
		public DeclPartContext declPart;
		public PredicateContext predicate;
		public ExpressionContext c;
		public Token DECORATION;
		public Token LISTSTART;
		public Token LISTEND;
		public Token op;
		public ExpressionContext e2;
		public Token IN_FUN_P6;
		public Token IN_FUN_P5;
		public Token IN_FUN_P4;
		public Token IN_FUN_P3;
		public Token IMGSTART;
		public Token IMGEND;
		public Token POST_FUN;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public TerminalNode SETSTART() { return getToken(ExprParser.SETSTART, 0); }
		public TerminalNode IN_FUN_P6() { return getToken(ExprParser.IN_FUN_P6, 0); }
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode NAME() { return getToken(ExprParser.NAME, 0); }
		public PredicateContext predicate() {
			return getRuleContext(PredicateContext.class,0);
		}
		public DeclPartContext declPart() {
			return getRuleContext(DeclPartContext.class,0);
		}
		public TerminalNode POST_FUN() { return getToken(ExprParser.POST_FUN, 0); }
		public TerminalNode PRE_GEN() { return getToken(ExprParser.PRE_GEN, 0); }
		public TerminalNode SETEND() { return getToken(ExprParser.SETEND, 0); }
		public Seq_opContext seq_op() {
			return getRuleContext(Seq_opContext.class,0);
		}
		public TerminalNode DECORATION() { return getToken(ExprParser.DECORATION, 0); }
		public TerminalNode LISTSTART() { return getToken(ExprParser.LISTSTART, 0); }
		public TerminalNode IMGEND() { return getToken(ExprParser.IMGEND, 0); }
		public TerminalNode IMGSTART() { return getToken(ExprParser.IMGSTART, 0); }
		public TerminalNode LISTEND() { return getToken(ExprParser.LISTEND, 0); }
		public TerminalNode IN_FUN_P3() { return getToken(ExprParser.IN_FUN_P3, 0); }
		public TerminalNode NUM() { return getToken(ExprParser.NUM, 0); }
		public TerminalNode IN_FUN_P4() { return getToken(ExprParser.IN_FUN_P4, 0); }
		public TerminalNode IN_FUN_P5() { return getToken(ExprParser.IN_FUN_P5, 0); }
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
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(365);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				{
				setState(265); ((ExpressionContext)_localctx).PRE_GEN = match(PRE_GEN);
				setState(266); ((ExpressionContext)_localctx).e = expression(20);

						String a;
						a = memory.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null));
						
						if ((((ExpressionContext)_localctx).PRE_GEN!=null?((ExpressionContext)_localctx).PRE_GEN.getText():null).equals("\\#")){
							if (memory.get("\\#" + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null)) == null) {
								String newVarName = newVar();
								memory.put("\\#" + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), newVarName);
								types.put("\\#" + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), "\\nat");
								if (modoSetExpression != 0 )
									setExpressionVars.put("\\#" + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), newVarName);
									
								String type = getType(types.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null)));
								if (!type.equals("\\seq"))
									print("size(" + a + "," + newVarName + ")");
								else
									print("prolog_call(length(" + a + "," + newVarName + "))");
								
								if (memory.get("\\nat") == null) {
									memory.put("\\nat", "NAT");
									print("NAT = int(0, 10000000000)");
									types.put("\\nat", "\\nat");
								}
								print(newVarName + " in NAT");
							}
						}
						else if ((((ExpressionContext)_localctx).PRE_GEN!=null?((ExpressionContext)_localctx).PRE_GEN.getText():null).equals("\\dom")){
							if (memory.get("\\dom" + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null)) == null) {
								String newVarName = newVar();
								memory.put("\\dom" + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), newVarName);
								if (modoSetExpression != 0 )
									setExpressionVars.put("\\dom" + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), newVarName);
								types.put("\\dom" + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), "\\power(" + getChildType(types.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null)), 0) + ")");
								
								String e = memory.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null));
								
								//Chequeamos si e es una lista, estas son tratadas de forma diferente
								String type = getType(types.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null)));
								if (type.equals("\\seq"))
									print("ddom_list(" + e + "," + newVarName + ")");
								else
									print("dom(" + e + "," + newVarName + ")");
							}
						}
						else if ((((ExpressionContext)_localctx).PRE_GEN!=null?((ExpressionContext)_localctx).PRE_GEN.getText():null).equals("\\ran")){
							if (memory.get("\\ran" + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null)) == null) {
								String newVarName = newVar();
								memory.put("\\ran" + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), newVarName);
								if (modoSetExpression != 0 )
									setExpressionVars.put("\\ran" + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), newVarName);
								types.put("\\ran" + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), "\\power(" + getChildType(types.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null)), 1) + ")");
								
								String e = memory.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null));
								
								//Chequeamos si e es una lista, estas son tratadas de forma diferente
								String type = getType(types.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null)));
								if (type.equals("\\seq"))
									print("list_to_set(" + e + "," + newVarName + ")");
								else
									print("ran(" + e + "," + newVarName + ")");
							}
						}
						else if ((((ExpressionContext)_localctx).PRE_GEN!=null?((ExpressionContext)_localctx).PRE_GEN.getText():null).equals("\\seq")) {
							String eType = types.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null));
							if (isBasic(eType))
								eType = (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null);
						
							types.put("\\seq" + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), "\\seq" + eType);
						}
						else if ((((ExpressionContext)_localctx).PRE_GEN!=null?((ExpressionContext)_localctx).PRE_GEN.getText():null).equals("\\bigcup")){
							if (memory.get("\\bigcup" + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null)) == null) {
								String newVarName = newVar();
								memory.put("\\bigcup" + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), newVarName);
								if (modoSetExpression != 0 )
									setExpressionVars.put("\\bigcup" + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), newVarName);
								types.put("\\bigcup" + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), getChildType(types.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null)), 0));
								
								String e = memory.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null));
								print("bun(" + e + "," + newVarName + ")");
							}
						}
						else if ((((ExpressionContext)_localctx).PRE_GEN!=null?((ExpressionContext)_localctx).PRE_GEN.getText():null).equals("\\bigcap")){
							if (memory.get("\\bigcap" + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null)) == null) {
								String newVarName = newVar();
								memory.put("\\bigcap" + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), newVarName);
								if (modoSetExpression != 0 )
									setExpressionVars.put("\\bigcap" + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), newVarName);
								types.put("\\bigcap" + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), getChildType(types.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null)), 0));
								
								String e = memory.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null));
								print("bdinters(" + e + "," + newVarName + ")");
							}
						}
						
					
				}
				break;

			case 2:
				{
				setState(269); ((ExpressionContext)_localctx).seq_op = seq_op();
				setState(270); ((ExpressionContext)_localctx).e = expression(12);

						String a;
						a = memory.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null));
						
						if (memory.get( (((ExpressionContext)_localctx).seq_op!=null?_input.getText(((ExpressionContext)_localctx).seq_op.start,((ExpressionContext)_localctx).seq_op.stop):null) + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null)) == null) {
						
							String newVarName = newVar();
						
							if ((((ExpressionContext)_localctx).seq_op!=null?_input.getText(((ExpressionContext)_localctx).seq_op.start,((ExpressionContext)_localctx).seq_op.stop):null).startsWith("rev")){
								print("prolog_call(reverse(" + a + "," + newVarName + "))");
								memory.put((((ExpressionContext)_localctx).seq_op!=null?_input.getText(((ExpressionContext)_localctx).seq_op.start,((ExpressionContext)_localctx).seq_op.stop):null) + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), newVarName);
								String type = types.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null));
								types.put((((ExpressionContext)_localctx).seq_op!=null?_input.getText(((ExpressionContext)_localctx).seq_op.start,((ExpressionContext)_localctx).seq_op.stop):null) + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), type);
								typeInfo(newVarName, type);
								if (modoSetExpression != 0 )
									setExpressionVars.put((((ExpressionContext)_localctx).seq_op!=null?_input.getText(((ExpressionContext)_localctx).seq_op.start,((ExpressionContext)_localctx).seq_op.stop):null) + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), newVarName);
							}
							else if ((((ExpressionContext)_localctx).seq_op!=null?_input.getText(((ExpressionContext)_localctx).seq_op.start,((ExpressionContext)_localctx).seq_op.stop):null).startsWith("head")){
								print("nth1(1," + a + "," + newVarName + ")");
								memory.put((((ExpressionContext)_localctx).seq_op!=null?_input.getText(((ExpressionContext)_localctx).seq_op.start,((ExpressionContext)_localctx).seq_op.stop):null) + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), newVarName);
								String type = getChildType(types.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null)), 0);
								types.put((((ExpressionContext)_localctx).seq_op!=null?_input.getText(((ExpressionContext)_localctx).seq_op.start,((ExpressionContext)_localctx).seq_op.stop):null) + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), type);
								typeInfo(newVarName, type);
								if (modoSetExpression != 0 )
									setExpressionVars.put((((ExpressionContext)_localctx).seq_op!=null?_input.getText(((ExpressionContext)_localctx).seq_op.start,((ExpressionContext)_localctx).seq_op.stop):null) + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), newVarName);
							}
							else if ((((ExpressionContext)_localctx).seq_op!=null?_input.getText(((ExpressionContext)_localctx).seq_op.start,((ExpressionContext)_localctx).seq_op.stop):null).startsWith("last")){
								print("prolog_call(last(" + a + "," + newVarName + "))");
								memory.put((((ExpressionContext)_localctx).seq_op!=null?_input.getText(((ExpressionContext)_localctx).seq_op.start,((ExpressionContext)_localctx).seq_op.stop):null) + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), newVarName);
								String type = getChildType(types.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null)), 0);
								types.put((((ExpressionContext)_localctx).seq_op!=null?_input.getText(((ExpressionContext)_localctx).seq_op.start,((ExpressionContext)_localctx).seq_op.stop):null) + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), type);
								typeInfo(newVarName, type);
								if (modoSetExpression != 0 )
									setExpressionVars.put((((ExpressionContext)_localctx).seq_op!=null?_input.getText(((ExpressionContext)_localctx).seq_op.start,((ExpressionContext)_localctx).seq_op.stop):null) + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), newVarName);
							}
							else if ((((ExpressionContext)_localctx).seq_op!=null?_input.getText(((ExpressionContext)_localctx).seq_op.start,((ExpressionContext)_localctx).seq_op.stop):null).startsWith("tail")){
								print("prolog_call(drop(1," + a + "," + newVarName + "))");
								memory.put((((ExpressionContext)_localctx).seq_op!=null?_input.getText(((ExpressionContext)_localctx).seq_op.start,((ExpressionContext)_localctx).seq_op.stop):null) + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), newVarName);
								String type = types.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null));
								types.put((((ExpressionContext)_localctx).seq_op!=null?_input.getText(((ExpressionContext)_localctx).seq_op.start,((ExpressionContext)_localctx).seq_op.stop):null) + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), type);
								typeInfo(newVarName, type);
								if (modoSetExpression != 0 )
									setExpressionVars.put((((ExpressionContext)_localctx).seq_op!=null?_input.getText(((ExpressionContext)_localctx).seq_op.start,((ExpressionContext)_localctx).seq_op.stop):null) + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), newVarName);
							}
							else if ((((ExpressionContext)_localctx).seq_op!=null?_input.getText(((ExpressionContext)_localctx).seq_op.start,((ExpressionContext)_localctx).seq_op.stop):null).startsWith("front")){
								String n = newVar();
								print("prolog_call(length(" + a + "," + n + "))");
								if (memory.get("\\nat") == null) {
									memory.put("\\nat", "NAT");
									print("NAT = int(0, 10000000000)");
									types.put("\\nat", "\\nat");
								}
								print(n + " in NAT");
								print("prolog_call(take(" + n + "-1" + "," + a + "," + newVarName + "))");
								memory.put((((ExpressionContext)_localctx).seq_op!=null?_input.getText(((ExpressionContext)_localctx).seq_op.start,((ExpressionContext)_localctx).seq_op.stop):null) + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), newVarName);
								String type = types.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null));
								types.put((((ExpressionContext)_localctx).seq_op!=null?_input.getText(((ExpressionContext)_localctx).seq_op.start,((ExpressionContext)_localctx).seq_op.stop):null) + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), type);
								typeInfo(newVarName, type);
								if (modoSetExpression != 0 )
									setExpressionVars.put((((ExpressionContext)_localctx).seq_op!=null?_input.getText(((ExpressionContext)_localctx).seq_op.start,((ExpressionContext)_localctx).seq_op.stop):null) + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), newVarName);
							}
							else if ((((ExpressionContext)_localctx).seq_op!=null?_input.getText(((ExpressionContext)_localctx).seq_op.start,((ExpressionContext)_localctx).seq_op.stop):null).startsWith("squash")){
								print("squash(" + a + "," + newVarName + ")");
								memory.put((((ExpressionContext)_localctx).seq_op!=null?_input.getText(((ExpressionContext)_localctx).seq_op.start,((ExpressionContext)_localctx).seq_op.stop):null) + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), newVarName);
								String type = types.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null));
								ArrayList<String> leftAndRight = leftAndRightTypes(type);
								type = "\\seq(" + leftAndRight.get(1) + ")";
								types.put((((ExpressionContext)_localctx).seq_op!=null?_input.getText(((ExpressionContext)_localctx).seq_op.start,((ExpressionContext)_localctx).seq_op.stop):null) + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), type);
								typeInfo(newVarName, type);
								if (modoSetExpression != 0 )
									setExpressionVars.put((((ExpressionContext)_localctx).seq_op!=null?_input.getText(((ExpressionContext)_localctx).seq_op.start,((ExpressionContext)_localctx).seq_op.stop):null) + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), newVarName);
							}
						}
					
				}
				break;

			case 3:
				{
				setState(273); match(45);
				setState(274); ((ExpressionContext)_localctx).e = expression(11);

						String eType = types.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null));
						if (isBasic(eType))
							eType = (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null);
					
						types.put("\\power" + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), "\\power" + eType );
					
				}
				break;

			case 4:
				{
				setState(277); ((ExpressionContext)_localctx).NAME = match(NAME);

						if (memory.get((((ExpressionContext)_localctx).NAME!=null?((ExpressionContext)_localctx).NAME.getText():null)) == null)
						{
							String newVarName = newVar((((ExpressionContext)_localctx).NAME!=null?((ExpressionContext)_localctx).NAME.getText():null));
							
							memory.put((((ExpressionContext)_localctx).NAME!=null?((ExpressionContext)_localctx).NAME.getText():null), newVarName);
							if (modoSetExpression != 0 )
								setExpressionVars.put((((ExpressionContext)_localctx).NAME!=null?((ExpressionContext)_localctx).NAME.getText():null), newVarName);
						}
					
				}
				break;

			case 5:
				{
				setState(279); ((ExpressionContext)_localctx).NUM = match(NUM);

						if (memory.get((((ExpressionContext)_localctx).NUM!=null?((ExpressionContext)_localctx).NUM.getText():null)) == null) {
							memory.put((((ExpressionContext)_localctx).NUM!=null?((ExpressionContext)_localctx).NUM.getText():null), (((ExpressionContext)_localctx).NUM!=null?((ExpressionContext)_localctx).NUM.getText():null));
							types.put((((ExpressionContext)_localctx).NUM!=null?((ExpressionContext)_localctx).NUM.getText():null), "\\num");
						}
					
				}
				break;

			case 6:
				{
				setState(281); match(8);

						if (memory.get("\\emptyset") == null) {
							memory.put("\\emptyset", "{}");
							types.put("\\emptyset", "\\power(" + "generic" + ")");
						}
					
				}
				break;

			case 7:
				{
				setState(283); match(36);
				setState(284); ((ExpressionContext)_localctx).a = expression(0);
				_localctx.elements.add((((ExpressionContext)_localctx).a!=null?_input.getText(((ExpressionContext)_localctx).a.start,((ExpressionContext)_localctx).a.stop):null));
				setState(290); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(286); match(34);
					setState(287); ((ExpressionContext)_localctx).b = expression(0);
					_localctx.elements.add((((ExpressionContext)_localctx).b!=null?_input.getText(((ExpressionContext)_localctx).b.start,((ExpressionContext)_localctx).b.stop):null));
					}
					}
					setState(292); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==34 );
				setState(294); match(15);
					
						((ExpressionContext)_localctx).zName =  "(";
						String type = new String();
						//Llenamos elements y ponemos cada expression en la memory
						while( !_localctx.elements.isEmpty() ){
							String e = _localctx.elements.remove(0);
							if (type.equals(""))
								type = "(" + types.get(e) + ")";
							else
								type = type.concat("\\cross(" + types.get(e) + ")");
								 
							((ExpressionContext)_localctx).zName =  _localctx.zName.concat(e);
							//guardamos tambien las traducciones del conjunto
							((ExpressionContext)_localctx).setlogName =  _localctx.setlogName.concat(memory.get(e));
							
							if (!_localctx.elements.isEmpty()){
								((ExpressionContext)_localctx).zName =  _localctx.zName + ",";
								((ExpressionContext)_localctx).setlogName =  _localctx.setlogName + ",";
							}
						}
						((ExpressionContext)_localctx).zName =  _localctx.zName + ")";
						if (memory.get(_localctx.zName) == null) {
							memory.put(_localctx.zName, "[" + _localctx.setlogName + "]");
							types.put(_localctx.zName, type);
						}
					
				}
				break;

			case 8:
				{
				setState(297); ((ExpressionContext)_localctx).SETSTART = match(SETSTART);
				setState(301);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 3) | (1L << 8) | (1L << 10) | (1L << 17) | (1L << 21) | (1L << 23) | (1L << 32) | (1L << 36) | (1L << 45) | (1L << 52) | (1L << 55) | (1L << NAME) | (1L << NUM))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (PRE_GEN - 65)) | (1L << (DECORATION - 65)) | (1L << (SETSTART - 65)) | (1L << (LISTSTART - 65)))) != 0)) {
					{
					setState(298); ((ExpressionContext)_localctx).a = expression(0);
					_localctx.elements.add((((ExpressionContext)_localctx).a!=null?_input.getText(((ExpressionContext)_localctx).a.start,((ExpressionContext)_localctx).a.stop):null));
					}
				}

				setState(309);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==34) {
					{
					{
					setState(303); match(34);
					setState(304); ((ExpressionContext)_localctx).b = expression(0);
					_localctx.elements.add((((ExpressionContext)_localctx).b!=null?_input.getText(((ExpressionContext)_localctx).b.start,((ExpressionContext)_localctx).b.stop):null));
					}
					}
					setState(311);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(312); ((ExpressionContext)_localctx).SETEND = match(SETEND);
					
						((ExpressionContext)_localctx).zName =  (((ExpressionContext)_localctx).SETSTART!=null?((ExpressionContext)_localctx).SETSTART.getText():null);
						String type = new String();
						//Llenamos elements y ponemos cada expression en la memory
						while( !_localctx.elements.isEmpty() ){
							String e = _localctx.elements.remove(0);
							if (type.equals("")) {
								type = types.get(e);
							}
							((ExpressionContext)_localctx).zName =  _localctx.zName.concat(e);
							//guardamos tambien las traducciones del conjunto
							((ExpressionContext)_localctx).setlogName =  _localctx.setlogName.concat(memory.get(e));
							
							if (!_localctx.elements.isEmpty()){
								((ExpressionContext)_localctx).zName =  _localctx.zName + ",";
								((ExpressionContext)_localctx).setlogName =  _localctx.setlogName + ",";
							}
						}
						((ExpressionContext)_localctx).zName =  _localctx.zName + (((ExpressionContext)_localctx).SETEND!=null?((ExpressionContext)_localctx).SETEND.getText():null);
						if (memory.get(_localctx.zName) == null) {
							memory.put(_localctx.zName, "{" + _localctx.setlogName + "}");
							if (_localctx.setlogName.equals(""))
								types.put(_localctx.zName, "\\power(" + "generic" + ")");
							else
								types.put(_localctx.zName, "\\power(" + type + ")");
						}
					
				}
				break;

			case 9:
				{
				setState(314); ((ExpressionContext)_localctx).SETSTART = match(SETSTART);
				modoSetExpression=1; setExpressionDecl = ""; setExpressionPred = ""; setExpressionExpr = ""; setExpressionVars = new HashMap();
				setState(316); ((ExpressionContext)_localctx).declPart = declPart();
				((ExpressionContext)_localctx).zName =  (((ExpressionContext)_localctx).SETSTART!=null?((ExpressionContext)_localctx).SETSTART.getText():null) + (((ExpressionContext)_localctx).declPart!=null?_input.getText(((ExpressionContext)_localctx).declPart.start,((ExpressionContext)_localctx).declPart.stop):null);
				setState(323);
				_la = _input.LA(1);
				if (_la==28) {
					{
					setState(318); match(28);
					modoSetExpression=2;
					setState(320); ((ExpressionContext)_localctx).predicate = predicate(0);
					((ExpressionContext)_localctx).zName =  _localctx.zName.concat("|" + (((ExpressionContext)_localctx).predicate!=null?_input.getText(((ExpressionContext)_localctx).predicate.start,((ExpressionContext)_localctx).predicate.stop):null));
					}
				}

				setState(330);
				_la = _input.LA(1);
				if (_la==16) {
					{
					setState(325); match(16);
					modoSetExpression=3;
					setState(327); ((ExpressionContext)_localctx).c = expression(0);
					((ExpressionContext)_localctx).zName =  _localctx.zName.concat("@" + (((ExpressionContext)_localctx).c!=null?_input.getText(((ExpressionContext)_localctx).c.start,((ExpressionContext)_localctx).c.stop):null));
					}
				}

				setState(332); ((ExpressionContext)_localctx).SETEND = match(SETEND);
				modoSetExpression=0; ((ExpressionContext)_localctx).zName =  _localctx.zName.concat((((ExpressionContext)_localctx).SETEND!=null?((ExpressionContext)_localctx).SETEND.getText():null));

						if (memory.get(_localctx.zName)==null) {
						
							((ExpressionContext)_localctx).setlogName =  "";
							((ExpressionContext)_localctx).newVarName1 =  newVar();
							((ExpressionContext)_localctx).newVarName2 =  newVar();
							
							((ExpressionContext)_localctx).setlogName =  _localctx.setlogName.concat("{ " + _localctx.newVarName1 + ":exists([");
							
							Iterator<String> keysIt = setExpressionVars.keySet().iterator();
							while (keysIt.hasNext()){
								((ExpressionContext)_localctx).setlogName =  _localctx.setlogName.concat(setExpressionVars.get(keysIt.next()));
								if (keysIt.hasNext()) ((ExpressionContext)_localctx).setlogName =  _localctx.setlogName.concat(",");
							}
						
							((ExpressionContext)_localctx).setlogName =  _localctx.setlogName.concat("], " + setExpressionDecl.substring(setExpressionDecl.indexOf('&') + 1) +
							setExpressionPred + setExpressionExpr + " & " + _localctx.newVarName1 + " is " + memory.get((((ExpressionContext)_localctx).c!=null?_input.getText(((ExpressionContext)_localctx).c.start,((ExpressionContext)_localctx).c.stop):null)) + ")" + " }");
						
							memory.put(_localctx.zName, _localctx.newVarName2);
							types.put(_localctx.zName, "\\power(" + types.get((((ExpressionContext)_localctx).c!=null?_input.getText(((ExpressionContext)_localctx).c.start,((ExpressionContext)_localctx).c.stop):null)) + ")"); //REVISAR!!!
							print(_localctx.newVarName2 + " = " + _localctx.setlogName);
							
							keysIt = setExpressionVars.keySet().iterator();
							while (keysIt.hasNext()){
								String var = keysIt.next();
								memory.remove(var);
								keysIt.remove();
								//setExpressionVars.remove(var);
							}
						}
					
				}
				break;

			case 10:
				{
				setState(337);
				_la = _input.LA(1);
				if (_la==DECORATION) {
					{
					setState(336); ((ExpressionContext)_localctx).DECORATION = match(DECORATION);
					}
				}

				setState(339); ((ExpressionContext)_localctx).LISTSTART = match(LISTSTART);
				setState(343);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 3) | (1L << 8) | (1L << 10) | (1L << 17) | (1L << 21) | (1L << 23) | (1L << 32) | (1L << 36) | (1L << 45) | (1L << 52) | (1L << 55) | (1L << NAME) | (1L << NUM))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (PRE_GEN - 65)) | (1L << (DECORATION - 65)) | (1L << (SETSTART - 65)) | (1L << (LISTSTART - 65)))) != 0)) {
					{
					setState(340); ((ExpressionContext)_localctx).a = expression(0);
					_localctx.elements.add((((ExpressionContext)_localctx).a!=null?_input.getText(((ExpressionContext)_localctx).a.start,((ExpressionContext)_localctx).a.stop):null));
					}
				}

				setState(351);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==34) {
					{
					{
					setState(345); match(34);
					setState(346); ((ExpressionContext)_localctx).b = expression(0);
					_localctx.elements.add((((ExpressionContext)_localctx).b!=null?_input.getText(((ExpressionContext)_localctx).b.start,((ExpressionContext)_localctx).b.stop):null));
					}
					}
					setState(353);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(354); ((ExpressionContext)_localctx).LISTEND = match(LISTEND);
					
						if ((((ExpressionContext)_localctx).DECORATION!=null?((ExpressionContext)_localctx).DECORATION.getText():null) != null)
							((ExpressionContext)_localctx).zName =  (((ExpressionContext)_localctx).DECORATION!=null?((ExpressionContext)_localctx).DECORATION.getText():null);
						((ExpressionContext)_localctx).zName =  _localctx.zName.concat((((ExpressionContext)_localctx).LISTSTART!=null?((ExpressionContext)_localctx).LISTSTART.getText():null));
						String type = new String();
						//Llenamos elements y ponemos cada expression en la memory
						while( !_localctx.elements.isEmpty() ){
							String e = _localctx.elements.remove(0);
							if (type.equals("")) {
								type = types.get(e);
							}
							((ExpressionContext)_localctx).zName =  _localctx.zName.concat(e);
							//guardamos tambien las traducciones del conjunto
							((ExpressionContext)_localctx).setlogName =  _localctx.setlogName.concat(memory.get(e));
							
							if (!_localctx.elements.isEmpty()){
								((ExpressionContext)_localctx).zName =  _localctx.zName + ",";
								((ExpressionContext)_localctx).setlogName =  _localctx.setlogName + ",";
							}
						}
						((ExpressionContext)_localctx).zName =  _localctx.zName + (((ExpressionContext)_localctx).LISTEND!=null?((ExpressionContext)_localctx).LISTEND.getText():null);
						if (memory.get(_localctx.zName) == null) {
							memory.put(_localctx.zName, "[" + _localctx.setlogName + "]");
							if (_localctx.setlogName.equals(""))
								types.put(_localctx.zName, "\\seq(" + "generic" + ")");
							else
								types.put(_localctx.zName, "\\seq(" + type + ")");
						}
					
				}
				break;

			case 11:
				{
				setState(356); match(36);
				setState(357); ((ExpressionContext)_localctx).e = expression(0);
				setState(358); match(15);

						String a = memory.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null));
						
						//Chequeo el nombre para ver si se trata de una sola variable, en ese caso no guardo en la memoria
						//los parentesis, en otro caso si
						
						if (a != null) { //Si no estoy en la parte de declaracion
							Pattern p = Pattern.compile("[^a-zA-Z0-9_]");
							boolean hasSpecialChar = p.matcher(a).find();
							
							if (hasSpecialChar){
								memory.put("(" + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null) + ")", "(" + a + ")");
								if (types.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null)) != null) {
									types.put("(" + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null) + ")", types.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null)));
								}
							}
							else {
								memory.put("(" + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null) + ")", a);
								if (types.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null)) != null) {
									types.put("(" + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null) + ")", types.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null)));
								}
							}
						} else  //Si estoy en la parte de declaracion
							if (types.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null)) != null)
								types.put("(" + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null) + ")", "(" + types.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null)) + ")");
					
				}
				break;

			case 12:
				{
				setState(361); match(23);
					
						if (memory.get("\\nat") == null) {
							memory.put("\\nat", "NAT");
							print("NAT = int(0, 10000000000)");
							types.put("\\nat", "\\nat");
						}	
					
				}
				break;

			case 13:
				{
				setState(363); match(55);
					
						if (memory.get("\\num") == null) {
							memory.put("\\num", "NUM");
							print("NUM = int(-10000000000, 10000000000)");
							types.put("\\num", "\\num");
						}	
					
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(451);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(449);
					switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(367);
						if (!(27 >= _localctx._p)) throw new FailedPredicateException(this, "27 >= $_p");
						setState(368); match(33);
						setState(369); ((ExpressionContext)_localctx).b = expression(28);

						          		//Guardo el tipo
						          		String aType = types.get((((ExpressionContext)_localctx).a!=null?_input.getText(((ExpressionContext)_localctx).a.start,((ExpressionContext)_localctx).a.stop):null));
						          		if (isBasic(aType)) {
						          			aType = (((ExpressionContext)_localctx).a!=null?_input.getText(((ExpressionContext)_localctx).a.start,((ExpressionContext)_localctx).a.stop):null);
						          		}
						          		String bType = types.get((((ExpressionContext)_localctx).b!=null?_input.getText(((ExpressionContext)_localctx).b.start,((ExpressionContext)_localctx).b.stop):null));
						          		if (isBasic(bType))
						          			bType = (((ExpressionContext)_localctx).b!=null?_input.getText(((ExpressionContext)_localctx).b.start,((ExpressionContext)_localctx).b.stop):null);
						          			
						          		types.put((((ExpressionContext)_localctx).a!=null?_input.getText(((ExpressionContext)_localctx).a.start,((ExpressionContext)_localctx).a.stop):null) + "\\rel" + (((ExpressionContext)_localctx).b!=null?_input.getText(((ExpressionContext)_localctx).b.start,((ExpressionContext)_localctx).b.stop):null), aType + "\\rel" + bType );
						          	
						}
						break;

					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(372);
						if (!(26 >= _localctx._p)) throw new FailedPredicateException(this, "26 >= $_p");
						setState(373);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==5 || _la==11) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(374); ((ExpressionContext)_localctx).b = expression(27);

						          		//Guardo el tipo
						          		String aType = types.get((((ExpressionContext)_localctx).a!=null?_input.getText(((ExpressionContext)_localctx).a.start,((ExpressionContext)_localctx).a.stop):null));
						          		if (isBasic(aType)) {
						          			aType = (((ExpressionContext)_localctx).a!=null?_input.getText(((ExpressionContext)_localctx).a.start,((ExpressionContext)_localctx).a.stop):null);
						          		}
						          		String bType = types.get((((ExpressionContext)_localctx).b!=null?_input.getText(((ExpressionContext)_localctx).b.start,((ExpressionContext)_localctx).b.stop):null));
						          		if (isBasic(bType))
						          			bType = (((ExpressionContext)_localctx).b!=null?_input.getText(((ExpressionContext)_localctx).b.start,((ExpressionContext)_localctx).b.stop):null);
						          			
						          		types.put((((ExpressionContext)_localctx).a!=null?_input.getText(((ExpressionContext)_localctx).a.start,((ExpressionContext)_localctx).a.stop):null) + (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null) + (((ExpressionContext)_localctx).b!=null?_input.getText(((ExpressionContext)_localctx).b.start,((ExpressionContext)_localctx).b.stop):null), aType + "\\pfun" + bType );
						          	
						}
						break;

					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(377);
						if (!(25 >= _localctx._p)) throw new FailedPredicateException(this, "25 >= $_p");
						setState(378); match(49);
						setState(379); ((ExpressionContext)_localctx).b = expression(26);

						          		//Guardo el tipo
						          		String aType = types.get((((ExpressionContext)_localctx).a!=null?_input.getText(((ExpressionContext)_localctx).a.start,((ExpressionContext)_localctx).a.stop):null));
						          		if (isBasic(aType)) {
						          			aType = (((ExpressionContext)_localctx).a!=null?_input.getText(((ExpressionContext)_localctx).a.start,((ExpressionContext)_localctx).a.stop):null);
						          		}
						          		String bType = types.get((((ExpressionContext)_localctx).b!=null?_input.getText(((ExpressionContext)_localctx).b.start,((ExpressionContext)_localctx).b.stop):null));
						          		if (isBasic(bType))
						          			bType = (((ExpressionContext)_localctx).b!=null?_input.getText(((ExpressionContext)_localctx).b.start,((ExpressionContext)_localctx).b.stop):null);
						          			
						          		types.put((((ExpressionContext)_localctx).a!=null?_input.getText(((ExpressionContext)_localctx).a.start,((ExpressionContext)_localctx).a.stop):null) + "\\fun" + (((ExpressionContext)_localctx).b!=null?_input.getText(((ExpressionContext)_localctx).b.start,((ExpressionContext)_localctx).b.stop):null), aType + "\\fun" + bType );
						          	
						}
						break;

					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(382);
						if (!(23 >= _localctx._p)) throw new FailedPredicateException(this, "23 >= $_p");
						setState(383); ((ExpressionContext)_localctx).DECORATION = match(DECORATION);
						setState(384); ((ExpressionContext)_localctx).e2 = expression(24);

						          		String a, b;
						          		a = memory.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null));
						          		b = memory.get((((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null));
						          		
						          		if (memory.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "~" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null)) == null) {
						          			String newVarName = newVar();
						          			memory.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "~" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          			
						          			if (modoSetExpression != 0 )
						          				setExpressionVars.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "~" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);

						          			//Si es una lista debo transformarla
						          			String type1 = types.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null));
						          			if (getType(type1).equals("\\seq")) {
						          				String newVarName2 = newVar();
						          				print("list_to_rel(" + a + "," + newVarName2 +  ")");
						          				a = newVarName2;
						          			}

						          			String newVarType = leftAndRightTypes(type1).get(1);
						          			types.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "~" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarType);
						          			print("apply(" + a + "," + b + "," + newVarName + ")");
						          			
						          			//Imprimimos la informacion del tipo de la variable
						          			typeInfo(newVarName, newVarType);
						          		}
						          	
						}
						break;

					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(387);
						if (!(22 >= _localctx._p)) throw new FailedPredicateException(this, "22 >= $_p");
						setState(388); match(46);
						setState(389); ((ExpressionContext)_localctx).e2 = expression(23);

						          		if (memory.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "." + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null)) == null) {
						          		
						          			String e1Type = types.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null));
						          			if (!e1Type.startsWith("SchemaType:")) //Debo llegar a obtener la lista con las variables
						          				e1Type = types.get(e1Type);
						          			
						          			if (e1Type.startsWith("SchemaType:")) {
						          				String schemaVars = e1Type.split(":", 3)[2];
						          				//Obtengo el indice de la variable e2 dentro de la lista de variables del tipo schema
						          				//Primero obtenemos la lista de variables
						          				schemaVars = schemaVars.substring(1, schemaVars.length()-1);
						          				String[] vars = schemaVars.split(",");
						          				//Buscamos la posicion de la variable
						          				int position = 1;
						          				while (!vars[position-1].contains((((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null) + ":")) //Se resta 1 porque en setlog empiezan en 1, no en 0 como en java
						          					position++;
						          				//Creamos una nueva variable
						          				String newVarName = newVar();
						          				//Vemos su tipo
						          				String type = vars[position-1].substring((((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null).length()+1);
						          				memory.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "." + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          				if (modoSetExpression != 0 )
						          					setExpressionVars.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "." + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          				types.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "." + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), type);
						          				print("nth1(" + position + "," + memory.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null)) + "," + newVarName + ")");
						          				
						          				typeInfo(newVarName, type);
						          				
						          			}
						          		}
						          	
						}
						break;

					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(392);
						if (!(21 >= _localctx._p)) throw new FailedPredicateException(this, "21 >= $_p");
						setState(393); match(9);
						setState(394); ((ExpressionContext)_localctx).e2 = expression(22);

						          		String a, b;
						          		a = memory.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null));
						          		b = memory.get((((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null));
						          		if (memory.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\upto" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null)) == null) {
						          			String newVarName = newVar();
						          			memory.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\upto" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          			if (modoSetExpression != 0 )
						          				setExpressionVars.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\upto" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          			print(newVarName + " = int(" + a + "," + b + ")");
						          		}
						          	
						}
						break;

					case 7:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(397);
						if (!(18 >= _localctx._p)) throw new FailedPredicateException(this, "18 >= $_p");
						setState(398); ((ExpressionContext)_localctx).IN_FUN_P6 = match(IN_FUN_P6);
						setState(399); ((ExpressionContext)_localctx).e2 = expression(19);

						          		String a, b;
						          		a = memory.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null));
						          		b = memory.get((((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null));
						          		
						          		if (memory.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + (((ExpressionContext)_localctx).IN_FUN_P6!=null?((ExpressionContext)_localctx).IN_FUN_P6.getText():null) + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null)) == null) {
						          		
						          			String newVarName = newVar();
						          		
						          			if ((((ExpressionContext)_localctx).IN_FUN_P6!=null?((ExpressionContext)_localctx).IN_FUN_P6.getText():null).equals("\\dres")){
						          					print("dres(" + a + "," + b + "," + newVarName + ")");
						          					memory.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\dres" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          					String type2 = types.get((((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null));
						          					String type = "\\power(" + getChildType(type2, 0) + "\\cross" + getChildType(type2, 1) + ")";
						          					types.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\dres" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), type);
						          					typeInfo(newVarName, type);
						          					if (modoSetExpression != 0 )
						          						setExpressionVars.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\dres" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          			}
						          			else if ((((ExpressionContext)_localctx).IN_FUN_P6!=null?((ExpressionContext)_localctx).IN_FUN_P6.getText():null).equals("\\ndres")){
						          					print("ndres(" + a + "," + b + "," + newVarName + ")");
						          					memory.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\ndres" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          					String type2 = types.get((((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null));
						          					String type = "\\power(" + getChildType(type2, 0) + "\\cross" + getChildType(type2, 1) + ")";
						          					types.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\ndres" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), type);
						          					typeInfo(newVarName, type);
						          					if (modoSetExpression != 0 )
						          						setExpressionVars.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\ndres" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          			}
						          			else if ((((ExpressionContext)_localctx).IN_FUN_P6!=null?((ExpressionContext)_localctx).IN_FUN_P6.getText():null).equals("\\rres")){
						          					print("rres(" + b + "," + a + "," + newVarName + ")");
						          					memory.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\rres" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          					String type1 = types.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null));
						          					String type = "\\power(" + getChildType(type1, 0) + "\\cross" + getChildType(type1, 1) + ")";
						          					types.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\rres" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), type);
						          					typeInfo(newVarName, type);
						          					if (modoSetExpression != 0 )
						          						setExpressionVars.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\rres" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          			}
						          			else if ((((ExpressionContext)_localctx).IN_FUN_P6!=null?((ExpressionContext)_localctx).IN_FUN_P6.getText():null).equals("\\nrres")){
						          					print("nrres(" + b + "," + a + "," + newVarName + ")");
						          					memory.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\nrres" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          					String type1 = types.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null));
						          					String type = "\\power(" + getChildType(type1, 0) + "\\cross" + getChildType(type1, 1) + ")";
						          					types.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\nrres" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), type);
						          					typeInfo(newVarName, type);
						          					if (modoSetExpression != 0 )
						          						setExpressionVars.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\nrres" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          			}
						          		}
						          	
						}
						break;

					case 8:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(402);
						if (!(17 >= _localctx._p)) throw new FailedPredicateException(this, "17 >= $_p");
						setState(403); ((ExpressionContext)_localctx).IN_FUN_P5 = match(IN_FUN_P5);
						setState(404); ((ExpressionContext)_localctx).e2 = expression(18);

						          		String a, b;
						          		a = memory.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null));
						          		b = memory.get((((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null));
						          		
						          		if (memory.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + (((ExpressionContext)_localctx).IN_FUN_P5!=null?((ExpressionContext)_localctx).IN_FUN_P5.getText():null) + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null)) == null) {
						          		
						          			String newVarName = newVar();
						          		
						          			if ((((ExpressionContext)_localctx).IN_FUN_P5!=null?((ExpressionContext)_localctx).IN_FUN_P5.getText():null).equals("\\oplus")){
						          					print("oplus(" + a + "," + b + "," + newVarName + ")");
						          					memory.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\oplus" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          					String type1 = types.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null));
						          					String type = "\\power(" + getChildType(type1, 0) + "\\cross" + getChildType(type1, 1) + ")";
						          					types.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\oplus" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), type);
						          					typeInfo(newVarName, type);
						          					if (modoSetExpression != 0 )
						          						setExpressionVars.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\oplus" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          			}
						          		}
						          	
						}
						break;

					case 9:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(407);
						if (!(16 >= _localctx._p)) throw new FailedPredicateException(this, "16 >= $_p");
						setState(408); ((ExpressionContext)_localctx).IN_FUN_P4 = match(IN_FUN_P4);
						setState(409); ((ExpressionContext)_localctx).e2 = expression(17);

						          		String a, b;
						          		a = memory.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null));
						          		b = memory.get((((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null));
						          		
						          		if (memory.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + (((ExpressionContext)_localctx).IN_FUN_P4!=null?((ExpressionContext)_localctx).IN_FUN_P4.getText():null) + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null)) == null) {
						          		
						          			String newVarName = newVar();
						          			Boolean isNumeric = false; 
						          		
						          			if ((((ExpressionContext)_localctx).IN_FUN_P4!=null?((ExpressionContext)_localctx).IN_FUN_P4.getText():null).equals("*")){
						          				print( newVarName + " is " + a + "*" + b );
						          				memory.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "*" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          				if (modoSetExpression != 0 )
						          					setExpressionVars.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "*" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          				isNumeric = true;
						          			}
						          			else if ((((ExpressionContext)_localctx).IN_FUN_P4!=null?((ExpressionContext)_localctx).IN_FUN_P4.getText():null).equals("\\div")) {
						          				print( newVarName + " is div(" + a + "," + b + ")" );
						          				memory.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\div" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          				if (modoSetExpression != 0 )
						          					setExpressionVars.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\div" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          				isNumeric = true;
						          			}
						          			else if ((((ExpressionContext)_localctx).IN_FUN_P4!=null?((ExpressionContext)_localctx).IN_FUN_P4.getText():null).equals("\\mod")){
						          				print( newVarName + " is mod(" + a + "," + b + ")" );
						          				memory.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\mod" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          				if (modoSetExpression != 0 )
						          					setExpressionVars.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\mod" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          				isNumeric = true;
						          			}
						          			else if ((((ExpressionContext)_localctx).IN_FUN_P4!=null?((ExpressionContext)_localctx).IN_FUN_P4.getText():null).equals("\\cap")){
						          					print("dinters(" + a + "," + b + "," + newVarName + ")");
						          					memory.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\cap" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          					String type = types.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null));
						          					types.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\cap" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), type);
						          					typeInfo(newVarName, type);
						          					if (modoSetExpression != 0 )
						          						setExpressionVars.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\cap" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          			}
						          			else if ((((ExpressionContext)_localctx).IN_FUN_P4!=null?((ExpressionContext)_localctx).IN_FUN_P4.getText():null).equals("\\comp")){
						          					print("comp(" + a + "," + b + "," + newVarName + ")");
						          					memory.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\comp" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          					String type1 = types.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null));
						          					String type2 = types.get((((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null));
						          					String type = "\\power(" + getChildType(type1, 0) + "\\cross" + getChildType(type2, 1) + ")";
						          					types.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\comp" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), type);
						          					typeInfo(newVarName, type);
						          					if (modoSetExpression != 0 )
						          						setExpressionVars.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\comp" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          			}
						          			else if ((((ExpressionContext)_localctx).IN_FUN_P4!=null?((ExpressionContext)_localctx).IN_FUN_P4.getText():null).equals("\\circ")){
						          					print("circ(" + a + "," + b + "," + newVarName + ")");
						          					memory.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\circ" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          					String type1 = getChildType(types.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null)), 1);
						          					String type = "\\power(" + type1 + "\\cross" + type1 + ")";
						          					types.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\circ" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), type);
						          					typeInfo(newVarName, type);
						          					if (modoSetExpression != 0 )
						          						setExpressionVars.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\circ" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          			}
						          			else if ((((ExpressionContext)_localctx).IN_FUN_P4!=null?((ExpressionContext)_localctx).IN_FUN_P4.getText():null).equals("\\extract")){
						          					print("extract(" + a + "," + b + "," + newVarName + ")");
						          					memory.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\extract" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          					String type = types.get((((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null));
						          					types.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\extract" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), type);
						          					typeInfo(newVarName, type);
						          					if (modoSetExpression != 0 )
						          						setExpressionVars.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\extract" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          			}
						          			else if ((((ExpressionContext)_localctx).IN_FUN_P4!=null?((ExpressionContext)_localctx).IN_FUN_P4.getText():null).equals("\\filter")){
						          					print("filter(" + a + "," + b + "," + newVarName + ")");
						          					memory.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\filter" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          					String type = types.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null));
						          					types.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\filter" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), type);
						          					typeInfo(newVarName, type);
						          					if (modoSetExpression != 0 )
						          						setExpressionVars.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\filter" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          			}
						          			
						          			if (isNumeric) {
						          				if (memory.get("\\num") == null) {
						          					memory.put("\\num", "NUM");
						          					print("NUM = int(-10000000000, 10000000000)");
						          					types.put("\\num", "\\num");
						          				}
						          				print(newVarName + " in NUM");
						          				types.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + (((ExpressionContext)_localctx).IN_FUN_P4!=null?((ExpressionContext)_localctx).IN_FUN_P4.getText():null) + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), "\\num");
						          			}
						          		}
						          	
						}
						break;

					case 10:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(412);
						if (!(15 >= _localctx._p)) throw new FailedPredicateException(this, "15 >= $_p");
						setState(413); ((ExpressionContext)_localctx).IN_FUN_P3 = match(IN_FUN_P3);
						setState(414); ((ExpressionContext)_localctx).e2 = expression(16);

						          		String a, b;
						          		a = memory.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null));
						          		b = memory.get((((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null));
						          		
						          		if (memory.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + (((ExpressionContext)_localctx).IN_FUN_P3!=null?((ExpressionContext)_localctx).IN_FUN_P3.getText():null) + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null)) == null) {
						          		
						          			String newVarName = newVar();
						          			Boolean isNumeric = false; 
						          			
						          		
						          			if ((((ExpressionContext)_localctx).IN_FUN_P3!=null?((ExpressionContext)_localctx).IN_FUN_P3.getText():null).equals("+")){
						          				print( newVarName + " is " + a + "+" + b );
						          				memory.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "+" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          				if (modoSetExpression != 0 )
						          					setExpressionVars.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "+" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          				isNumeric = true;
						          			}
						          			else if ((((ExpressionContext)_localctx).IN_FUN_P3!=null?((ExpressionContext)_localctx).IN_FUN_P3.getText():null).equals("-")) {
						          				print( newVarName + " is " + a + "-" + b );
						          				memory.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "-" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          				if (modoSetExpression != 0 )
						          					setExpressionVars.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "-" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          				isNumeric = true;
						          			}
						          			else if ((((ExpressionContext)_localctx).IN_FUN_P3!=null?((ExpressionContext)_localctx).IN_FUN_P3.getText():null).equals("\\cup")){
						          					print("dun(" + a + "," + b + "," + newVarName + ")");
						          					memory.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\cup" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          					String type = types.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null));
						          					types.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\cup" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), type);
						          					typeInfo(newVarName, type);
						          					if (modoSetExpression != 0 )
						          						setExpressionVars.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\cup" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          			}
						          			else if ((((ExpressionContext)_localctx).IN_FUN_P3!=null?((ExpressionContext)_localctx).IN_FUN_P3.getText():null).equals("\\setminus")){
						          					print("diff(" + a + "," + b + "," + newVarName + ")");
						          					memory.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\setminus" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          					String type = types.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null));
						          					types.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\setminus" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), type);
						          					typeInfo(newVarName, type);
						          					if (modoSetExpression != 0 )
						          						setExpressionVars.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\setminus" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          			}
						          			else if ((((ExpressionContext)_localctx).IN_FUN_P3!=null?((ExpressionContext)_localctx).IN_FUN_P3.getText():null).equals("\\cat")){
						          					print("prolog_call(append(" + a + "," + b + "," + newVarName + "))");
						          					memory.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\cat" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          					String type = types.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null));
						          					types.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\cat" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), type);
						          					typeInfo(newVarName, type);
						          					if (modoSetExpression != 0 )
						          						setExpressionVars.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\cat" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          			}
						          			
						          			if (isNumeric) {
						          				if (memory.get("\\num") == null) {
						          					memory.put("\\num", "NUM");
						          					print("NUM = int(-10000000000, 10000000000)");
						          					types.put("\\num", "\\num");
						          				}
						          				print(newVarName + " in NUM");
						          				types.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + (((ExpressionContext)_localctx).IN_FUN_P3!=null?((ExpressionContext)_localctx).IN_FUN_P3.getText():null) + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), "\\num");
						          			}
						          		}
						          	
						}
						break;

					case 11:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(417);
						if (!(14 >= _localctx._p)) throw new FailedPredicateException(this, "14 >= $_p");
						setState(418); match(57);
						setState(419); ((ExpressionContext)_localctx).e2 = expression(15);

						          		String a, b;
						          		a = memory.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null));
						          		b = memory.get((((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null));
						          		memory.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\mapsto" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), "[" + a + "," + b + "]");
						          		types.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\mapsto" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), types.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null)) + "\\cross" + types.get((((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null)));
						          	
						}
						break;

					case 12:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(422);
						if (!(24 >= _localctx._p)) throw new FailedPredicateException(this, "24 >= $_p");
						((ExpressionContext)getInvokingContext(10)).elements.add((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null));
						setState(428); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(424); match(41);
								setState(425); ((ExpressionContext)_localctx).e2 = expression(0);
								((ExpressionContext)getInvokingContext(10)).elements.add((((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null));
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(430); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
						} while ( _alt!=2 && _alt!=-1 );

						          		String unfoldedType = "";
						          		
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
						          				((ExpressionContext)_localctx).zName =  _localctx.zName.concat("\\cross");
						          				unfoldedType = unfoldedType.concat("\\cross");
						          			}
						          		}
						          		
						          		types.put(_localctx.zName, unfoldedType);
						          	
						}
						break;

					case 13:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(434);
						if (!(19 >= _localctx._p)) throw new FailedPredicateException(this, "19 >= $_p");
						setState(435); ((ExpressionContext)_localctx).IMGSTART = match(IMGSTART);
						setState(436); ((ExpressionContext)_localctx).e2 = expression(0);
						setState(437); ((ExpressionContext)_localctx).IMGEND = match(IMGEND);
						setState(439);
						switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
						case 1:
							{
							setState(438); ((ExpressionContext)_localctx).DECORATION = match(DECORATION);
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

					case 14:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						_localctx.e = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(443);
						if (!(13 >= _localctx._p)) throw new FailedPredicateException(this, "13 >= $_p");
						setState(444); ((ExpressionContext)_localctx).POST_FUN = match(POST_FUN);
						setState(446);
						switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
						case 1:
							{
							setState(445); ((ExpressionContext)_localctx).DECORATION = match(DECORATION);
							}
							break;
						}

						          		String a;
						          		a = memory.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null));
						          		String op = (((ExpressionContext)_localctx).POST_FUN!=null?((ExpressionContext)_localctx).POST_FUN.getText():null) + (((ExpressionContext)_localctx).DECORATION!=null?((ExpressionContext)_localctx).DECORATION.getText():null);
						          		
						          		if (memory.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null) + op) == null) {
						          		
						          			String newVarName = newVar();
						          		
						          			if (op.startsWith("\\inv")){
						          				print("inv(" + newVarName + "," + a + ")");
						          				memory.put((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null) + op, newVarName);
						          				String type1 = types.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null));
						          				String type = invertType(type1); 
						          				types.put((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null) + op, type);
						          				typeInfo(newVarName, type);
						          				if (modoSetExpression != 0 )
						          					setExpressionVars.put((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null) + op, newVarName);
						          			}
						          		}
						          	
						}
						break;
					}
					} 
				}
				setState(453);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
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

	public static class Seq_opContext extends ParserRuleContext {
		public TerminalNode DECORATION() { return getToken(ExprParser.DECORATION, 0); }
		public Seq_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_seq_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterSeq_op(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitSeq_op(this);
		}
	}

	public final Seq_opContext seq_op() throws RecognitionException {
		Seq_opContext _localctx = new Seq_opContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_seq_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(454);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 3) | (1L << 10) | (1L << 17) | (1L << 21) | (1L << 32) | (1L << 52))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(455); match(DECORATION);
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
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 17: return 13 >= _localctx._p;

		case 16: return 19 >= _localctx._p;

		case 4: return 27 >= _localctx._p;

		case 5: return 26 >= _localctx._p;

		case 6: return 25 >= _localctx._p;

		case 7: return 23 >= _localctx._p;

		case 8: return 22 >= _localctx._p;

		case 9: return 21 >= _localctx._p;

		case 10: return 18 >= _localctx._p;

		case 11: return 17 >= _localctx._p;

		case 12: return 16 >= _localctx._p;

		case 13: return 15 >= _localctx._p;

		case 14: return 14 >= _localctx._p;

		case 15: return 24 >= _localctx._p;
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
		"\2\3M\u01cc\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4"+
		"\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\3\2\3\2\7\2\35\n\2\f\2\16\2 "+
		"\13\2\6\2\"\n\2\r\2\16\2#\3\2\3\2\3\3\3\3\3\3\3\3\5\3,\n\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\5\3\67\n\3\3\3\3\3\3\3\3\3\5\3=\n\3\3\3\3\3\3"+
		"\3\5\3B\n\3\3\3\3\3\6\3F\n\3\r\3\16\3G\3\3\3\3\5\3L\n\3\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\7\4U\n\4\f\4\16\4X\13\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5"+
		"\3\6\3\6\3\6\3\6\3\6\5\6g\n\6\3\6\3\6\3\6\3\6\5\6m\n\6\7\6o\n\6\f\6\16"+
		"\6r\13\6\3\6\3\6\3\7\3\7\3\7\3\7\5\7z\n\7\3\7\3\7\5\7~\n\7\3\7\3\7\3\7"+
		"\7\7\u0083\n\7\f\7\16\7\u0086\13\7\3\b\3\b\3\b\7\b\u008b\n\b\f\b\16\b"+
		"\u008e\13\b\3\t\3\t\3\t\3\t\3\t\3\t\7\t\u0096\n\t\f\t\16\t\u0099\13\t"+
		"\3\t\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u00b0\n\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u00f8\n\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\7\13\u0106\n\13\f\13"+
		"\16\13\u0109\13\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\6\f\u0125\n\f\r\f"+
		"\16\f\u0126\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u0130\n\f\3\f\3\f\3\f\3\f"+
		"\7\f\u0136\n\f\f\f\16\f\u0139\13\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\5\f\u0146\n\f\3\f\3\f\3\f\3\f\3\f\5\f\u014d\n\f\3\f\3\f\3\f\3"+
		"\f\3\f\5\f\u0154\n\f\3\f\3\f\3\f\3\f\5\f\u015a\n\f\3\f\3\f\3\f\3\f\7\f"+
		"\u0160\n\f\f\f\16\f\u0163\13\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\5\f\u0170\n\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\6\f\u01af\n\f\r\f"+
		"\16\f\u01b0\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u01ba\n\f\3\f\3\f\3\f\3\f"+
		"\3\f\5\f\u01c1\n\f\3\f\7\f\u01c4\n\f\f\f\16\f\u01c7\13\f\3\r\3\r\3\r\3"+
		"\r\2\16\2\4\6\b\n\f\16\20\22\24\26\30\2\5\4\65\65EE\4\7\7\r\r\b\5\5\f"+
		"\f\23\23\27\27\"\"\66\66\u020b\2!\3\2\2\2\4K\3\2\2\2\6M\3\2\2\2\b\\\3"+
		"\2\2\2\na\3\2\2\2\fu\3\2\2\2\16\u0087\3\2\2\2\20\u008f\3\2\2\2\22\u009e"+
		"\3\2\2\2\24\u00f7\3\2\2\2\26\u016f\3\2\2\2\30\u01c8\3\2\2\2\32\36\5\4"+
		"\3\2\33\35\7E\2\2\34\33\3\2\2\2\35 \3\2\2\2\36\34\3\2\2\2\36\37\3\2\2"+
		"\2\37\"\3\2\2\2 \36\3\2\2\2!\32\3\2\2\2\"#\3\2\2\2#!\3\2\2\2#$\3\2\2\2"+
		"$%\3\2\2\2%&\b\2\1\2&\3\3\2\2\2\'+\7-\2\2(,\7\3\2\2)*\7\62\2\2*,\b\3\1"+
		"\2+(\3\2\2\2+)\3\2\2\2,-\3\2\2\2-.\7%\2\2./\7<\2\2/\60\7\16\2\2\60\61"+
		"\5\f\7\2\61\62\b\3\1\2\62\66\7\37\2\2\63\67\7\3\2\2\64\65\7\62\2\2\65"+
		"\67\b\3\1\2\66\63\3\2\2\2\66\64\3\2\2\2\678\3\2\2\289\7\16\2\29L\3\2\2"+
		"\2:<\78\2\2;=\7E\2\2<;\3\2\2\2<=\3\2\2\2=E\3\2\2\2>B\5\6\4\2?B\5\b\5\2"+
		"@B\5\n\6\2A>\3\2\2\2A?\3\2\2\2A@\3\2\2\2BC\3\2\2\2CD\7E\2\2DF\3\2\2\2"+
		"EA\3\2\2\2FG\3\2\2\2GE\3\2\2\2GH\3\2\2\2HI\3\2\2\2IJ\7)\2\2JL\3\2\2\2"+
		"K\'\3\2\2\2K:\3\2\2\2L\5\3\2\2\2MN\7\6\2\2NO\5\22\n\2OV\b\4\1\2PQ\7$\2"+
		"\2QR\5\22\n\2RS\b\4\1\2SU\3\2\2\2TP\3\2\2\2UX\3\2\2\2VT\3\2\2\2VW\3\2"+
		"\2\2WY\3\2\2\2XV\3\2\2\2YZ\7!\2\2Z[\b\4\1\2[\7\3\2\2\2\\]\5\22\n\2]^\7"+
		":\2\2^_\5\26\f\2_`\b\5\1\2`\t\3\2\2\2ab\5\22\n\2bc\7\34\2\2cd\5\22\n\2"+
		"df\b\6\1\2eg\5\26\f\2fe\3\2\2\2fg\3\2\2\2gp\3\2\2\2hi\7\36\2\2ij\5\22"+
		"\n\2jl\b\6\1\2km\5\26\f\2lk\3\2\2\2lm\3\2\2\2mo\3\2\2\2nh\3\2\2\2or\3"+
		"\2\2\2pn\3\2\2\2pq\3\2\2\2qs\3\2\2\2rp\3\2\2\2st\b\6\1\2t\13\3\2\2\2u"+
		"y\7E\2\2vw\5\16\b\2wx\7E\2\2xz\3\2\2\2yv\3\2\2\2yz\3\2\2\2z}\3\2\2\2{"+
		"|\7\32\2\2|~\7E\2\2}{\3\2\2\2}~\3\2\2\2~\u0084\3\2\2\2\177\u0080\5\24"+
		"\13\2\u0080\u0081\7E\2\2\u0081\u0083\3\2\2\2\u0082\177\3\2\2\2\u0083\u0086"+
		"\3\2\2\2\u0084\u0082\3\2\2\2\u0084\u0085\3\2\2\2\u0085\r\3\2\2\2\u0086"+
		"\u0084\3\2\2\2\u0087\u008c\5\20\t\2\u0088\u0089\t\2\2\2\u0089\u008b\5"+
		"\20\t\2\u008a\u0088\3\2\2\2\u008b\u008e\3\2\2\2\u008c\u008a\3\2\2\2\u008c"+
		"\u008d\3\2\2\2\u008d\17\3\2\2\2\u008e\u008c\3\2\2\2\u008f\u0090\5\22\n"+
		"\2\u0090\u0097\b\t\1\2\u0091\u0092\7$\2\2\u0092\u0093\5\22\n\2\u0093\u0094"+
		"\b\t\1\2\u0094\u0096\3\2\2\2\u0095\u0091\3\2\2\2\u0096\u0099\3\2\2\2\u0097"+
		"\u0095\3\2\2\2\u0097\u0098\3\2\2\2\u0098\u009a\3\2\2\2\u0099\u0097\3\2"+
		"\2\2\u009a\u009b\7\'\2\2\u009b\u009c\5\26\f\2\u009c\u009d\b\t\1\2\u009d"+
		"\21\3\2\2\2\u009e\u009f\7<\2\2\u009f\23\3\2\2\2\u00a0\u00a1\b\13\1\2\u00a1"+
		"\u00a2\5\26\f\2\u00a2\u00a3\7*\2\2\u00a3\u00a4\5\26\f\2\u00a4\u00a5\b"+
		"\13\1\2\u00a5\u00f8\3\2\2\2\u00a6\u00a7\5\26\f\2\u00a7\u00a8\7\17\2\2"+
		"\u00a8\u00a9\5\26\f\2\u00a9\u00b0\3\2\2\2\u00aa\u00ab\7\4\2\2\u00ab\u00ac"+
		"\5\26\f\2\u00ac\u00ad\7*\2\2\u00ad\u00ae\5\26\f\2\u00ae\u00b0\3\2\2\2"+
		"\u00af\u00a6\3\2\2\2\u00af\u00aa\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00b2"+
		"\b\13\1\2\u00b2\u00f8\3\2\2\2\u00b3\u00b4\5\26\f\2\u00b4\u00b5\7\b\2\2"+
		"\u00b5\u00b6\5\26\f\2\u00b6\u00b7\b\13\1\2\u00b7\u00f8\3\2\2\2\u00b8\u00b9"+
		"\5\26\f\2\u00b9\u00ba\7\67\2\2\u00ba\u00bb\5\26\f\2\u00bb\u00bc\b\13\1"+
		"\2\u00bc\u00f8\3\2\2\2\u00bd\u00be\5\26\f\2\u00be\u00bf\7\25\2\2\u00bf"+
		"\u00c0\5\26\f\2\u00c0\u00c1\b\13\1\2\u00c1\u00f8\3\2\2\2\u00c2\u00c3\5"+
		"\26\f\2\u00c3\u00c4\7\33\2\2\u00c4\u00c5\5\26\f\2\u00c5\u00c6\b\13\1\2"+
		"\u00c6\u00f8\3\2\2\2\u00c7\u00c8\5\26\f\2\u00c8\u00c9\7\24\2\2\u00c9\u00ca"+
		"\5\26\f\2\u00ca\u00cb\b\13\1\2\u00cb\u00f8\3\2\2\2\u00cc\u00cd\5\26\f"+
		"\2\u00cd\u00ce\7\35\2\2\u00ce\u00cf\5\26\f\2\u00cf\u00d0\b\13\1\2\u00d0"+
		"\u00f8\3\2\2\2\u00d1\u00d2\7\4\2\2\u00d2\u00d3\5\26\f\2\u00d3\u00d4\7"+
		"\35\2\2\u00d4\u00d5\5\26\f\2\u00d5\u00d6\b\13\1\2\u00d6\u00f8\3\2\2\2"+
		"\u00d7\u00d8\5\26\f\2\u00d8\u00d9\7.\2\2\u00d9\u00da\5\26\f\2\u00da\u00db"+
		"\b\13\1\2\u00db\u00f8\3\2\2\2\u00dc\u00dd\7\4\2\2\u00dd\u00de\5\26\f\2"+
		"\u00de\u00df\7.\2\2\u00df\u00e0\5\26\f\2\u00e0\u00e1\b\13\1\2\u00e1\u00f8"+
		"\3\2\2\2\u00e2\u00e3\5\26\f\2\u00e3\u00e4\7\30\2\2\u00e4\u00e5\5\26\f"+
		"\2\u00e5\u00e6\b\13\1\2\u00e6\u00f8\3\2\2\2\u00e7\u00e8\5\26\f\2\u00e8"+
		"\u00e9\7\26\2\2\u00e9\u00ea\5\26\f\2\u00ea\u00eb\b\13\1\2\u00eb\u00f8"+
		"\3\2\2\2\u00ec\u00ed\5\26\f\2\u00ed\u00ee\7 \2\2\u00ee\u00ef\5\26\f\2"+
		"\u00ef\u00f0\b\13\1\2\u00f0\u00f8\3\2\2\2\u00f1\u00f2\7&\2\2\u00f2\u00f3"+
		"\5\24\13\2\u00f3\u00f4\7\21\2\2\u00f4\u00f8\3\2\2\2\u00f5\u00f8\7,\2\2"+
		"\u00f6\u00f8\7\t\2\2\u00f7\u00a0\3\2\2\2\u00f7\u00af\3\2\2\2\u00f7\u00b3"+
		"\3\2\2\2\u00f7\u00b8\3\2\2\2\u00f7\u00bd\3\2\2\2\u00f7\u00c2\3\2\2\2\u00f7"+
		"\u00c7\3\2\2\2\u00f7\u00cc\3\2\2\2\u00f7\u00d1\3\2\2\2\u00f7\u00d7\3\2"+
		"\2\2\u00f7\u00dc\3\2\2\2\u00f7\u00e2\3\2\2\2\u00f7\u00e7\3\2\2\2\u00f7"+
		"\u00ec\3\2\2\2\u00f7\u00f1\3\2\2\2\u00f7\u00f5\3\2\2\2\u00f7\u00f6\3\2"+
		"\2\2\u00f8\u0107\3\2\2\2\u00f9\u00fa\6\13\2\3\u00fa\u00fb\7\61\2\2\u00fb"+
		"\u0106\5\24\13\2\u00fc\u00fd\6\13\3\3\u00fd\u00fe\7\64\2\2\u00fe\u0106"+
		"\5\24\13\2\u00ff\u0100\6\13\4\3\u0100\u0101\7(\2\2\u0101\u0106\5\24\13"+
		"\2\u0102\u0103\6\13\5\3\u0103\u0104\7\20\2\2\u0104\u0106\5\24\13\2\u0105"+
		"\u00f9\3\2\2\2\u0105\u00fc\3\2\2\2\u0105\u00ff\3\2\2\2\u0105\u0102\3\2"+
		"\2\2\u0106\u0109\3\2\2\2\u0107\u0105\3\2\2\2\u0107\u0108\3\2\2\2\u0108"+
		"\25\3\2\2\2\u0109\u0107\3\2\2\2\u010a\u010b\b\f\1\2\u010b\u010c\7C\2\2"+
		"\u010c\u010d\5\26\f\2\u010d\u010e\b\f\1\2\u010e\u0170\3\2\2\2\u010f\u0110"+
		"\5\30\r\2\u0110\u0111\5\26\f\2\u0111\u0112\b\f\1\2\u0112\u0170\3\2\2\2"+
		"\u0113\u0114\7/\2\2\u0114\u0115\5\26\f\2\u0115\u0116\b\f\1\2\u0116\u0170"+
		"\3\2\2\2\u0117\u0118\7<\2\2\u0118\u0170\b\f\1\2\u0119\u011a\7=\2\2\u011a"+
		"\u0170\b\f\1\2\u011b\u011c\7\n\2\2\u011c\u0170\b\f\1\2\u011d\u011e\7&"+
		"\2\2\u011e\u011f\5\26\f\2\u011f\u0124\b\f\1\2\u0120\u0121\7$\2\2\u0121"+
		"\u0122\5\26\f\2\u0122\u0123\b\f\1\2\u0123\u0125\3\2\2\2\u0124\u0120\3"+
		"\2\2\2\u0125\u0126\3\2\2\2\u0126\u0124\3\2\2\2\u0126\u0127\3\2\2\2\u0127"+
		"\u0128\3\2\2\2\u0128\u0129\7\21\2\2\u0129\u012a\b\f\1\2\u012a\u0170\3"+
		"\2\2\2\u012b\u012f\7G\2\2\u012c\u012d\5\26\f\2\u012d\u012e\b\f\1\2\u012e"+
		"\u0130\3\2\2\2\u012f\u012c\3\2\2\2\u012f\u0130\3\2\2\2\u0130\u0137\3\2"+
		"\2\2\u0131\u0132\7$\2\2\u0132\u0133\5\26\f\2\u0133\u0134\b\f\1\2\u0134"+
		"\u0136\3\2\2\2\u0135\u0131\3\2\2\2\u0136\u0139\3\2\2\2\u0137\u0135\3\2"+
		"\2\2\u0137\u0138\3\2\2\2\u0138\u013a\3\2\2\2\u0139\u0137\3\2\2\2\u013a"+
		"\u013b\7H\2\2\u013b\u0170\b\f\1\2\u013c\u013d\7G\2\2\u013d\u013e\b\f\1"+
		"\2\u013e\u013f\5\16\b\2\u013f\u0145\b\f\1\2\u0140\u0141\7\36\2\2\u0141"+
		"\u0142\b\f\1\2\u0142\u0143\5\24\13\2\u0143\u0144\b\f\1\2\u0144\u0146\3"+
		"\2\2\2\u0145\u0140\3\2\2\2\u0145\u0146\3\2\2\2\u0146\u014c\3\2\2\2\u0147"+
		"\u0148\7\22\2\2\u0148\u0149\b\f\1\2\u0149\u014a\5\26\f\2\u014a\u014b\b"+
		"\f\1\2\u014b\u014d\3\2\2\2\u014c\u0147\3\2\2\2\u014c\u014d\3\2\2\2\u014d"+
		"\u014e\3\2\2\2\u014e\u014f\7H\2\2\u014f\u0150\b\f\1\2\u0150\u0151\b\f"+
		"\1\2\u0151\u0170\3\2\2\2\u0152\u0154\7D\2\2\u0153\u0152\3\2\2\2\u0153"+
		"\u0154\3\2\2\2\u0154\u0155\3\2\2\2\u0155\u0159\7I\2\2\u0156\u0157\5\26"+
		"\f\2\u0157\u0158\b\f\1\2\u0158\u015a\3\2\2\2\u0159\u0156\3\2\2\2\u0159"+
		"\u015a\3\2\2\2\u015a\u0161\3\2\2\2\u015b\u015c\7$\2\2\u015c\u015d\5\26"+
		"\f\2\u015d\u015e\b\f\1\2\u015e\u0160\3\2\2\2\u015f\u015b\3\2\2\2\u0160"+
		"\u0163\3\2\2\2\u0161\u015f\3\2\2\2\u0161\u0162\3\2\2\2\u0162\u0164\3\2"+
		"\2\2\u0163\u0161\3\2\2\2\u0164\u0165\7J\2\2\u0165\u0170\b\f\1\2\u0166"+
		"\u0167\7&\2\2\u0167\u0168\5\26\f\2\u0168\u0169\7\21\2\2\u0169\u016a\b"+
		"\f\1\2\u016a\u0170\3\2\2\2\u016b\u016c\7\31\2\2\u016c\u0170\b\f\1\2\u016d"+
		"\u016e\79\2\2\u016e\u0170\b\f\1\2\u016f\u010a\3\2\2\2\u016f\u010f\3\2"+
		"\2\2\u016f\u0113\3\2\2\2\u016f\u0117\3\2\2\2\u016f\u0119\3\2\2\2\u016f"+
		"\u011b\3\2\2\2\u016f\u011d\3\2\2\2\u016f\u012b\3\2\2\2\u016f\u013c\3\2"+
		"\2\2\u016f\u0153\3\2\2\2\u016f\u0166\3\2\2\2\u016f\u016b\3\2\2\2\u016f"+
		"\u016d\3\2\2\2\u0170\u01c5\3\2\2\2\u0171\u0172\6\f\6\3\u0172\u0173\7#"+
		"\2\2\u0173\u0174\5\26\f\2\u0174\u0175\b\f\1\2\u0175\u01c4\3\2\2\2\u0176"+
		"\u0177\6\f\7\3\u0177\u0178\t\3\2\2\u0178\u0179\5\26\f\2\u0179\u017a\b"+
		"\f\1\2\u017a\u01c4\3\2\2\2\u017b\u017c\6\f\b\3\u017c\u017d\7\63\2\2\u017d"+
		"\u017e\5\26\f\2\u017e\u017f\b\f\1\2\u017f\u01c4\3\2\2\2\u0180\u0181\6"+
		"\f\t\3\u0181\u0182\7D\2\2\u0182\u0183\5\26\f\2\u0183\u0184\b\f\1\2\u0184"+
		"\u01c4\3\2\2\2\u0185\u0186\6\f\n\3\u0186\u0187\7\60\2\2\u0187\u0188\5"+
		"\26\f\2\u0188\u0189\b\f\1\2\u0189\u01c4\3\2\2\2\u018a\u018b\6\f\13\3\u018b"+
		"\u018c\7\13\2\2\u018c\u018d\5\26\f\2\u018d\u018e\b\f\1\2\u018e\u01c4\3"+
		"\2\2\2\u018f\u0190\6\f\f\3\u0190\u0191\7A\2\2\u0191\u0192\5\26\f\2\u0192"+
		"\u0193\b\f\1\2\u0193\u01c4\3\2\2\2\u0194\u0195\6\f\r\3\u0195\u0196\7@"+
		"\2\2\u0196\u0197\5\26\f\2\u0197\u0198\b\f\1\2\u0198\u01c4\3\2\2\2\u0199"+
		"\u019a\6\f\16\3\u019a\u019b\7?\2\2\u019b\u019c\5\26\f\2\u019c\u019d\b"+
		"\f\1\2\u019d\u01c4\3\2\2\2\u019e\u019f\6\f\17\3\u019f\u01a0\7>\2\2\u01a0"+
		"\u01a1\5\26\f\2\u01a1\u01a2\b\f\1\2\u01a2\u01c4\3\2\2\2\u01a3\u01a4\6"+
		"\f\20\3\u01a4\u01a5\7;\2\2\u01a5\u01a6\5\26\f\2\u01a6\u01a7\b\f\1\2\u01a7"+
		"\u01c4\3\2\2\2\u01a8\u01a9\6\f\21\3\u01a9\u01ae\b\f\1\2\u01aa\u01ab\7"+
		"+\2\2\u01ab\u01ac\5\26\f\2\u01ac\u01ad\b\f\1\2\u01ad\u01af\3\2\2\2\u01ae"+
		"\u01aa\3\2\2\2\u01af\u01b0\3\2\2\2\u01b0\u01ae\3\2\2\2\u01b0\u01b1\3\2"+
		"\2\2\u01b1\u01b2\3\2\2\2\u01b2\u01b3\b\f\1\2\u01b3\u01c4\3\2\2\2\u01b4"+
		"\u01b5\6\f\22\3\u01b5\u01b6\7K\2\2\u01b6\u01b7\5\26\f\2\u01b7\u01b9\7"+
		"L\2\2\u01b8\u01ba\7D\2\2\u01b9\u01b8\3\2\2\2\u01b9\u01ba\3\2\2\2\u01ba"+
		"\u01bb\3\2\2\2\u01bb\u01bc\b\f\1\2\u01bc\u01c4\3\2\2\2\u01bd\u01be\6\f"+
		"\23\3\u01be\u01c0\7B\2\2\u01bf\u01c1\7D\2\2\u01c0\u01bf\3\2\2\2\u01c0"+
		"\u01c1\3\2\2\2\u01c1\u01c2\3\2\2\2\u01c2\u01c4\b\f\1\2\u01c3\u0171\3\2"+
		"\2\2\u01c3\u0176\3\2\2\2\u01c3\u017b\3\2\2\2\u01c3\u0180\3\2\2\2\u01c3"+
		"\u0185\3\2\2\2\u01c3\u018a\3\2\2\2\u01c3\u018f\3\2\2\2\u01c3\u0194\3\2"+
		"\2\2\u01c3\u0199\3\2\2\2\u01c3\u019e\3\2\2\2\u01c3\u01a3\3\2\2\2\u01c3"+
		"\u01a8\3\2\2\2\u01c3\u01b4\3\2\2\2\u01c3\u01bd\3\2\2\2\u01c4\u01c7\3\2"+
		"\2\2\u01c5\u01c3\3\2\2\2\u01c5\u01c6\3\2\2\2\u01c6\27\3\2\2\2\u01c7\u01c5"+
		"\3\2\2\2\u01c8\u01c9\t\4\2\2\u01c9\u01ca\7D\2\2\u01ca\31\3\2\2\2%\36#"+
		"+\66<AGKVflpy}\u0084\u008c\u0097\u00af\u00f7\u0105\u0107\u0126\u012f\u0137"+
		"\u0145\u014c\u0153\u0159\u0161\u016f\u01b0\u01b9\u01c0\u01c3\u01c5";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}