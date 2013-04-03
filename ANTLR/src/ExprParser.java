// Generated from Expr.g4 by ANTLR 4.0

	import java.util.HashMap;
	import java.util.ArrayList;
	import java.util.regex.Matcher;
	import java.util.regex.Pattern;

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
		T__51=1, T__50=2, T__49=3, T__48=4, T__47=5, T__46=6, T__45=7, T__44=8, 
		T__43=9, T__42=10, T__41=11, T__40=12, T__39=13, T__38=14, T__37=15, T__36=16, 
		T__35=17, T__34=18, T__33=19, T__32=20, T__31=21, T__30=22, T__29=23, 
		T__28=24, T__27=25, T__26=26, T__25=27, T__24=28, T__23=29, T__22=30, 
		T__21=31, T__20=32, T__19=33, T__18=34, T__17=35, T__16=36, T__15=37, 
		T__14=38, T__13=39, T__12=40, T__11=41, T__10=42, T__9=43, T__8=44, T__7=45, 
		T__6=46, T__5=47, T__4=48, T__3=49, T__2=50, T__1=51, T__0=52, NAME=53, 
		NUM=54, IN_FUN_P3=55, IN_FUN_P4=56, NL=57, WS=58, SETSTART=59, SETEND=60, 
		SKIP=61;
	public static final String[] tokenNames = {
		"<INVALID>", "'schema'", "'\\lnot'", "'\\#'", "'['", "'\\pfun'", "'<'", 
		"'false'", "'\\dom'", "'\\upto'", "'\\ffun'", "'}'", "'\\notin'", "'\\land'", 
		"')'", "'@'", "'\\seq'", "'='", "'\\leq'", "'\\nat'", "'\\neq'", "'\\geq'", 
		"'\\where'", "'::='", "'|'", "'\\end{'", "']'", "'\\rel'", "','", "'}{'", 
		"'('", "':'", "'\\lor'", "'\\end{zed}'", "'\\ran'", "'\\in'", "'\\cross'", 
		"'true'", "'\\begin{'", "'\\subset'", "'\\power'", "'.'", "'\\iff'", "'schemaType'", 
		"'\\fun'", "'\\implies'", "';'", "'>'", "'\\begin{zed}'", "'\\num'", "'=='", 
		"'~'", "'\\mapsto'", "NAME", "NUM", "IN_FUN_P3", "IN_FUN_P4", "NL", "WS", 
		"'\\{'", "'\\}'", "SKIP"
	};
	public static final int
		RULE_specification = 0, RULE_paragraph = 1, RULE_basic_type = 2, RULE_equivalent_type = 3, 
		RULE_enumeration_type = 4, RULE_schemaText = 5, RULE_declPart = 6, RULE_declaration = 7, 
		RULE_declName = 8, RULE_predicate = 9, RULE_expression = 10, RULE_pre_gen = 11;
	public static final String[] ruleNames = {
		"specification", "paragraph", "basic_type", "equivalent_type", "enumeration_type", 
		"schemaText", "declPart", "declaration", "declName", "predicate", "expression", 
		"pre_gen"
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
		
		ArrayList setExpressionVars;
		
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
	        return parser.getReturnRootType();
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
	        return parser.printChild(pos);
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
			} while ( _la==38 || _la==48 );

				   System.out.println("tablita de tippos");
				   System.out.println("-------------------");
				   String key, value;
				   Iterator iterator = types.keySet().iterator();
				   while (iterator.hasNext()) {
				           key = (String) iterator.next();
				           value = (String) types.get(key);
				           System.out.println(key + "\t\t| " + value);
				   }
				   System.out.println("\ntablita de memory");
				   System.out.println("-------------------");
				   iterator = memory.keySet().iterator();
				   while (iterator.hasNext()) {
				           key = (String) iterator.next();
				           value = (String) memory.get(key);
				           System.out.println(key + "\t\t| " + value);
				   }
				   System.out.println("\ntablita de zVars");
				   System.out.println("-------------------");
				   iterator = zVars.keySet().iterator();
				   while (iterator.hasNext()) {
				           key = (String) iterator.next();
				           value = (String) zVars.get(key);
				           System.out.println(key + "\t\t| " + value);
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
			setState(71);
			switch (_input.LA(1)) {
			case 38:
				enterOuterAlt(_localctx, 1);
				{
				setState(37); match(38);
				setState(41);
				switch (_input.LA(1)) {
				case 1:
					{
					setState(38); match(1);
					}
					break;
				case 43:
					{
					{
					setState(39); match(43);
					tipoSchema = 1; schemaTypeVars = "";
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(43); match(29);
				setState(44); ((ParagraphContext)_localctx).NAME = match(NAME);
				setState(45); match(11);
				setState(46); schemaText();

							if (tipoSchema == 1) {
								String newVarName = (((ParagraphContext)_localctx).NAME!=null?((ParagraphContext)_localctx).NAME.getText():null).substring(0,1).toUpperCase() + (((ParagraphContext)_localctx).NAME!=null?((ParagraphContext)_localctx).NAME.getText():null).substring(1).replace("?","");
								if (memory.containsValue(newVarName)) { 
									newVarName = "VAR" + varNumber;
									varNumber++;
								}
								memory.put((((ParagraphContext)_localctx).NAME!=null?((ParagraphContext)_localctx).NAME.getText():null), newVarName);
								types.put((((ParagraphContext)_localctx).NAME!=null?((ParagraphContext)_localctx).NAME.getText():null), "SchemaType:[" + schemaTypeVars + "]");
								schemaTypeVars = "";
							}
						
				setState(48); match(25);
				setState(52);
				switch (_input.LA(1)) {
				case 1:
					{
					setState(49); match(1);
					}
					break;
				case 43:
					{
					{
					setState(50); match(43);
					tipoSchema = 0;
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(54); match(11);
				}
				break;
			case 48:
				enterOuterAlt(_localctx, 2);
				{
				setState(56); match(48);
				setState(57); match(NL);
				setState(65); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(61);
					switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
					case 1:
						{
						setState(58); basic_type();
						}
						break;

					case 2:
						{
						setState(59); equivalent_type();
						}
						break;

					case 3:
						{
						setState(60); enumeration_type();
						}
						break;
					}
					setState(63); match(NL);
					}
					}
					setState(67); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==4 || _la==NAME );
				setState(69); match(33);
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
		public ArrayList typeList;;
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
		((Basic_typeContext)getInvokingContext(2)).typeList =  new ArrayList();
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73); match(4);
			setState(74); ((Basic_typeContext)_localctx).a = ((Basic_typeContext)_localctx).declName = declName();
			((Basic_typeContext)getInvokingContext(2)).typeList.add((((Basic_typeContext)_localctx).a!=null?_input.getText(((Basic_typeContext)_localctx).a.start,((Basic_typeContext)_localctx).a.stop):null));
			setState(82);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==28) {
				{
				{
				setState(76); match(28);
				setState(77); ((Basic_typeContext)_localctx).b = ((Basic_typeContext)_localctx).declName = declName();
				((Basic_typeContext)getInvokingContext(2)).typeList.add((((Basic_typeContext)_localctx).b!=null?_input.getText(((Basic_typeContext)_localctx).b.start,((Basic_typeContext)_localctx).b.stop):null));
				}
				}
				setState(84);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(85); match(26);

					while( !((Basic_typeContext)getInvokingContext(2)).typeList.isEmpty() ) {
						String type = (String) ((Basic_typeContext)getInvokingContext(2)).typeList.remove(0);
						
						String newVarName = (((Basic_typeContext)_localctx).declName!=null?_input.getText(((Basic_typeContext)_localctx).declName.start,((Basic_typeContext)_localctx).declName.stop):null).substring(0,1).toUpperCase() + (((Basic_typeContext)_localctx).declName!=null?_input.getText(((Basic_typeContext)_localctx).declName.start,((Basic_typeContext)_localctx).declName.stop):null).substring(1).replace("?","");
						if (memory.containsValue(newVarName)) { 
							newVarName = "VAR" + varNumber;
							varNumber++;
						}
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
			setState(88); ((Equivalent_typeContext)_localctx).declName = declName();
			setState(89); match(50);
			setState(90); ((Equivalent_typeContext)_localctx).expression = expression(0);
			 
					String type = (String) types.get((((Equivalent_typeContext)_localctx).expression!=null?_input.getText(((Equivalent_typeContext)_localctx).expression.start,((Equivalent_typeContext)_localctx).expression.stop):null));
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
		public ArrayList cases;;
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
		((Enumeration_typeContext)getInvokingContext(4)).cases =  new ArrayList();
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93); ((Enumeration_typeContext)_localctx).d = declName();
			setState(94); match(23);
			setState(95); ((Enumeration_typeContext)_localctx).a = declName();
			((Enumeration_typeContext)getInvokingContext(4)).cases.add((((Enumeration_typeContext)_localctx).a!=null?_input.getText(((Enumeration_typeContext)_localctx).a.start,((Enumeration_typeContext)_localctx).a.stop):null));
			setState(98);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 3) | (1L << 8) | (1L << 16) | (1L << 19) | (1L << 30) | (1L << 34) | (1L << 40) | (1L << 49) | (1L << NAME) | (1L << NUM) | (1L << SETSTART))) != 0)) {
				{
				setState(97); expression(0);
				}
			}

			setState(108);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==24) {
				{
				{
				setState(100); match(24);
				setState(101); ((Enumeration_typeContext)_localctx).b = declName();
				((Enumeration_typeContext)getInvokingContext(4)).cases.add((((Enumeration_typeContext)_localctx).b!=null?_input.getText(((Enumeration_typeContext)_localctx).b.start,((Enumeration_typeContext)_localctx).b.stop):null));
				setState(104);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 3) | (1L << 8) | (1L << 16) | (1L << 19) | (1L << 30) | (1L << 34) | (1L << 40) | (1L << 49) | (1L << NAME) | (1L << NUM) | (1L << SETSTART))) != 0)) {
					{
					setState(103); expression(0);
					}
				}

				}
				}
				setState(110);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
				
					String elements = new String();
					while( !((Enumeration_typeContext)getInvokingContext(4)).cases.isEmpty() ){
						String e = (String) ((Enumeration_typeContext)getInvokingContext(4)).cases.remove(0);
						elements = elements.concat(e);
						
						memory.put(e,e); //REVISAR!!!
						
						if (!((Enumeration_typeContext)getInvokingContext(4)).cases.isEmpty()){
							elements = elements.concat(",");
						}
					}
					if (types.get((((Enumeration_typeContext)_localctx).d!=null?_input.getText(((Enumeration_typeContext)_localctx).d.start,((Enumeration_typeContext)_localctx).d.stop):null)) == null) {
						//Le asigno un nombre al conjunto
						String newVarName = (((Enumeration_typeContext)_localctx).d!=null?_input.getText(((Enumeration_typeContext)_localctx).d.start,((Enumeration_typeContext)_localctx).d.stop):null).substring(0,1).toUpperCase() + (((Enumeration_typeContext)_localctx).d!=null?_input.getText(((Enumeration_typeContext)_localctx).d.start,((Enumeration_typeContext)_localctx).d.stop):null).substring(1).replace("?","");
						if (memory.containsValue(newVarName)) { 
							newVarName = "VAR" + varNumber;
							varNumber++;
						}
					
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
			setState(113); match(NL);
			setState(117);
			_la = _input.LA(1);
			if (_la==NAME) {
				{
				setState(114); declPart();
				setState(115); match(NL);
				}
			}

			setState(119); match(22);
			setState(120); match(NL);
			setState(126);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 2) | (1L << 3) | (1L << 7) | (1L << 8) | (1L << 16) | (1L << 19) | (1L << 30) | (1L << 34) | (1L << 37) | (1L << 40) | (1L << 49) | (1L << NAME) | (1L << NUM) | (1L << SETSTART))) != 0)) {
				{
				{
				setState(121); predicate(0);
				setState(122); match(NL);
				}
				}
				setState(128);
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
			setState(129); declaration();
			setState(134);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(130);
					_la = _input.LA(1);
					if ( !(_la==46 || _la==NL) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					setState(131); declaration();
					}
					} 
				}
				setState(136);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
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
		public ArrayList vars;;
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
		((DeclarationContext)getInvokingContext(7)).vars =  new ArrayList();
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137); ((DeclarationContext)_localctx).a = declName();
			((DeclarationContext)getInvokingContext(7)).vars.add((((DeclarationContext)_localctx).a!=null?_input.getText(((DeclarationContext)_localctx).a.start,((DeclarationContext)_localctx).a.stop):null));
			setState(145);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==28) {
				{
				{
				setState(139); match(28);
				setState(140); ((DeclarationContext)_localctx).b = declName();
				((DeclarationContext)getInvokingContext(7)).vars.add((((DeclarationContext)_localctx).b!=null?_input.getText(((DeclarationContext)_localctx).b.start,((DeclarationContext)_localctx).b.stop):null));
				}
				}
				setState(147);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(148); match(31);
			setState(149); ((DeclarationContext)_localctx).expression = expression(0);

					//Para cada variable realizamos el procesamiento
					while( !((DeclarationContext)getInvokingContext(7)).vars.isEmpty() ) {
						String var = (String) ((DeclarationContext)getInvokingContext(7)).vars.remove(0);
						if (tipoSchema == 0)
							zVars.put(var, null); //Marcamos la variable como variable Z, a la cual posiblemente se le deba asignarsele un valor
						String newVarName = var.substring(0,1).toUpperCase() + var.substring(1).replace("?","");
						if (memory.containsValue(newVarName)) { 
							newVarName = "VAR" + varNumber;
							varNumber++;
						}

						if (tipoSchema == 0)
							memory.put(var, newVarName);
						if (modoSetExpression==1)
							setExpressionVars.add(newVarName); //Falta ver que hacemos para variables ligadas con el mismo nombre en distintas ligaduras
						
						String expType = (String) types.get((((DeclarationContext)_localctx).expression!=null?_input.getText(((DeclarationContext)_localctx).expression.start,((DeclarationContext)_localctx).expression.stop):null));
						if (expType.startsWith("BasicType") || expType.startsWith("EnumerationType") || expType.startsWith("SchemaType"))
							expType = (((DeclarationContext)_localctx).expression!=null?_input.getText(((DeclarationContext)_localctx).expression.start,((DeclarationContext)_localctx).expression.stop):null);
						
						if (tipoSchema == 0)
							types.put(var, expType);
						else { //La agregamos como variable del esquema
							if (!schemaTypeVars.equals(""))
								schemaTypeVars = schemaTypeVars.concat(",");
							schemaTypeVars = schemaTypeVars.concat(var + ":" + expType);
						}
						
						//Imprimimos el tipo de la variable segun cual sea este	
						if (tipoSchema == 0 & expType != null) {
							String type = getType(expType);
							if (type.equals("\\seq"))
								print("list(" + newVarName + ")");
							else if (type.equals("\\rel"))
								print("is_rel(" + newVarName + ")");
							else if (type.equals("\\pfun"))
								print("is_pfun(" + newVarName + ")");
							else if (type.equals("\\fun"))
								print("is_fun(" + newVarName + ")");
							else if (expType.equals("\\nat") || expType.equals("\\num"))
								print(newVarName + " in " + memory.get(expType));
							else if (expType.startsWith("BasicType:"))
								print(newVarName + " in " + expType.substring(10));
							else if (expType.startsWith("EnumerationType:"))
								print(newVarName + " in " + expType.substring(16));
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
			setState(152); match(NAME);
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
			setState(214);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				setState(155); match(2);
				setState(156); predicate(18);
				}
				break;

			case 2:
				{
				setState(157); ((PredicateContext)_localctx).e1 = expression(0);
				setState(158); match(35);
				setState(159); match(8);
				setState(160); ((PredicateContext)_localctx).e2 = expression(0);
					String a, b;
						a = (String)memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = (String)memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						print("in_dom(" + a + "," + b + ")");
					
				}
				break;

			case 3:
				{
				setState(163); ((PredicateContext)_localctx).e1 = expression(0);
				setState(164); match(35);
				setState(165); ((PredicateContext)_localctx).e2 = expression(0);

						String a, b;
						a = (String)memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = (String)memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						print(a + " in " + b);
						
						//Impresion de tipo
						String type = (String) types.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						if (type != null)
							if (type.equals("\\power\\num") || type.equals("\\power\\nat"))
								print(a + " in " + memory.get(type.substring(6)));
					
				}
				break;

			case 4:
				{
				setState(168); ((PredicateContext)_localctx).e1 = expression(0);
				setState(169); match(12);
				setState(170); ((PredicateContext)_localctx).e2 = expression(0);

						String a, b;
						a = (String)memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = (String)memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						print(a + " nin " + b);
						
						//Impresion de tipo
						String type = (String) types.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						if (type != null)
							if (type.equals("\\power\\num") || type.equals("\\power\\nat"))
								print(a + " in " + memory.get(type.substring(6)));
					
				}
				break;

			case 5:
				{
				setState(173); ((PredicateContext)_localctx).e1 = expression(0);
				setState(174); match(6);
				setState(175); ((PredicateContext)_localctx).e2 = expression(0);

						String a, b;
						a = (String)memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = (String)memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						print(a + " < " + b);
					
				}
				break;

			case 6:
				{
				setState(178); ((PredicateContext)_localctx).e1 = expression(0);
				setState(179); match(47);
				setState(180); ((PredicateContext)_localctx).e2 = expression(0);

						String a, b;
						a = (String)memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = (String)memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						print(a + " > " + b);
					
				}
				break;

			case 7:
				{
				setState(183); ((PredicateContext)_localctx).e1 = expression(0);
				setState(184); match(18);
				setState(185); ((PredicateContext)_localctx).e2 = expression(0);

						String a, b;
						a = (String)memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = (String)memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						print(a + " =< " + b);
					
				}
				break;

			case 8:
				{
				setState(188); ((PredicateContext)_localctx).e1 = expression(0);
				setState(189); match(21);
				setState(190); ((PredicateContext)_localctx).e2 = expression(0);

						String a, b;
						a = (String)memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = (String)memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						print(a + " =< " + b);
					
				}
				break;

			case 9:
				{
				setState(193); ((PredicateContext)_localctx).e1 = expression(0);
				setState(194); match(17);
				setState(195); ((PredicateContext)_localctx).e2 = expression(0);

						String a, b;
						a = (String)memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = (String)memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						print(a + " = " + b);
					
				}
				break;

			case 10:
				{
				setState(198); ((PredicateContext)_localctx).e1 = expression(0);
				setState(199); match(39);
				setState(200); ((PredicateContext)_localctx).e2 = expression(0);

						String a, b;
						a = (String)memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = (String)memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						print("dsubset(" + a + "," + b + ")");
					
				}
				break;

			case 11:
				{
				setState(203); ((PredicateContext)_localctx).e1 = expression(0);
				setState(204); match(20);
				setState(205); ((PredicateContext)_localctx).e2 = expression(0);

						String a, b;
						a = (String)memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = (String)memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						print(a + " neq " + b);
					
				}
				break;

			case 12:
				{
				setState(208); match(30);
				setState(209); predicate(0);
				setState(210); match(14);
				}
				break;

			case 13:
				{
				setState(212); match(37);
				}
				break;

			case 14:
				{
				setState(213); match(7);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(230);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(228);
					switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
					case 1:
						{
						_localctx = new PredicateContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_predicate);
						setState(216);
						if (!(4 >= _localctx._p)) throw new FailedPredicateException(this, "4 >= $_p");
						setState(217); match(42);
						setState(218); predicate(5);
						}
						break;

					case 2:
						{
						_localctx = new PredicateContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_predicate);
						setState(219);
						if (!(3 >= _localctx._p)) throw new FailedPredicateException(this, "3 >= $_p");
						setState(220); match(45);
						setState(221); predicate(4);
						}
						break;

					case 3:
						{
						_localctx = new PredicateContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_predicate);
						setState(222);
						if (!(2 >= _localctx._p)) throw new FailedPredicateException(this, "2 >= $_p");
						setState(223); match(32);
						setState(224); predicate(3);
						}
						break;

					case 4:
						{
						_localctx = new PredicateContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_predicate);
						setState(225);
						if (!(1 >= _localctx._p)) throw new FailedPredicateException(this, "1 >= $_p");
						setState(226); match(13);
						setState(227); predicate(2);
						}
						break;
					}
					} 
				}
				setState(232);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
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
		public ArrayList elements = new ArrayList();
		public String setlogName = "";
		public String zName = "";
		public String operator = "";
		public String newVarName1 = "";
		public String newVarName2 = "";
		public ExpressionContext a;
		public ExpressionContext e1;
		public Pre_genContext pre_gen;
		public ExpressionContext e;
		public Token NAME;
		public Token NUM;
		public Token SETSTART;
		public ExpressionContext b;
		public Token SETEND;
		public DeclPartContext declPart;
		public PredicateContext predicate;
		public ExpressionContext c;
		public Token op;
		public ExpressionContext e2;
		public Token IN_FUN_P4;
		public Token IN_FUN_P3;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public TerminalNode SETEND() { return getToken(ExprParser.SETEND, 0); }
		public TerminalNode SETSTART() { return getToken(ExprParser.SETSTART, 0); }
		public TerminalNode NAME() { return getToken(ExprParser.NAME, 0); }
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public PredicateContext predicate() {
			return getRuleContext(PredicateContext.class,0);
		}
		public Pre_genContext pre_gen() {
			return getRuleContext(Pre_genContext.class,0);
		}
		public TerminalNode IN_FUN_P3() { return getToken(ExprParser.IN_FUN_P3, 0); }
		public TerminalNode NUM() { return getToken(ExprParser.NUM, 0); }
		public TerminalNode IN_FUN_P4() { return getToken(ExprParser.IN_FUN_P4, 0); }
		public DeclPartContext declPart() {
			return getRuleContext(DeclPartContext.class,0);
		}
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
			setState(294);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				{
				setState(234); ((ExpressionContext)_localctx).pre_gen = pre_gen();
				setState(235); ((ExpressionContext)_localctx).e = expression(11);

						String a;
						a = (String)memory.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null));
						
						if ((((ExpressionContext)_localctx).pre_gen!=null?_input.getText(((ExpressionContext)_localctx).pre_gen.start,((ExpressionContext)_localctx).pre_gen.stop):null).equals("\\#")){
							if (memory.get("\\#" + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null)) == null) {
								String newVarName = "VAR" + varNumber;
								varNumber++;
								memory.put("\\#" + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), newVarName);
								print("prolog_call(length(" + a + "," + newVarName + "))");
								
								if (memory.get("\\nat") == null) {
									memory.put("\\nat", "NAT");
									print("NAT = int(0, 10000000000)");
									types.put("\\nat", "\\nat");
								}
								print(newVarName + " in NAT");
							}
						}
						else if ((((ExpressionContext)_localctx).pre_gen!=null?_input.getText(((ExpressionContext)_localctx).pre_gen.start,((ExpressionContext)_localctx).pre_gen.stop):null).equals("\\dom")){
							if (memory.get("\\dom" + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null)) == null) {
								String newVarName = "VAR" + varNumber;
								varNumber++;
								memory.put("\\dom" + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), newVarName);
								types.put("\\dom" + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), getChildType((String) types.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null)), 0));
								
								String e = (String) memory.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null));
								
								//Chequeamos si e es una lista, estas son tratadas de forma diferente
								//System.out.println("ESTE ES EL TIPO: " + types.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null)) + " DE: " + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null));
								String type = getType((String) types.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null)));
								if (type.equals("\\seq"))
									print("ddom_list(" + e + "," + newVarName + ")");
								else
									print("dom(" + e + "," + newVarName + ")");
							}
						}
						else if ((((ExpressionContext)_localctx).pre_gen!=null?_input.getText(((ExpressionContext)_localctx).pre_gen.start,((ExpressionContext)_localctx).pre_gen.stop):null).equals("\\ran")){
							if (memory.get("\\ran" + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null)) == null) {
								String newVarName = "VAR" + varNumber;
								varNumber++;
								memory.put("\\ran" + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), newVarName);
								types.put("\\ran" + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), getChildType((String) types.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null)), 0));
								
								String e = (String) memory.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null));
								
								//Chequeamos si e es una lista, estas son tratadas de forma diferente
								String type = getType((String) types.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null)));
								if (type.equals("\\seq"))
									print("list_to_set(" + e + "," + newVarName + ")");
								else
									print("ran(" + e + "," + newVarName + ")");
							}
						}
						else if ((((ExpressionContext)_localctx).pre_gen!=null?_input.getText(((ExpressionContext)_localctx).pre_gen.start,((ExpressionContext)_localctx).pre_gen.stop):null).equals("\\seq")) {
							String eType = (String) types.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null));
							if (eType.startsWith("BasicType") || eType.startsWith("EnumerationType"))
								eType = (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null);
						
							types.put("\\seq" + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), "\\seq" + eType);
						}
					
				}
				break;

			case 2:
				{
				setState(238); match(40);
				setState(239); ((ExpressionContext)_localctx).e = expression(8);

						String eType = (String) types.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null));
						if (eType.startsWith("BasicType") || eType.startsWith("EnumerationType"))
							eType = (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null);
					
						types.put("\\power" + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), "\\power" + eType);
					
				}
				break;

			case 3:
				{
				setState(242); ((ExpressionContext)_localctx).NAME = match(NAME);

						if (memory.get((((ExpressionContext)_localctx).NAME!=null?((ExpressionContext)_localctx).NAME.getText():null)) == null)
						{
							String newVarName = (((ExpressionContext)_localctx).NAME!=null?((ExpressionContext)_localctx).NAME.getText():null).substring(0,1).toUpperCase() + (((ExpressionContext)_localctx).NAME!=null?((ExpressionContext)_localctx).NAME.getText():null).substring(1).replace("?","");
						
							if (memory.containsValue(newVarName)) { 
								newVarName = "VAR" + varNumber;
								varNumber++;
							}
							
							memory.put((((ExpressionContext)_localctx).NAME!=null?((ExpressionContext)_localctx).NAME.getText():null), newVarName);
						}
					
				}
				break;

			case 4:
				{
				setState(244); ((ExpressionContext)_localctx).NUM = match(NUM);

						if (memory.get((((ExpressionContext)_localctx).NUM!=null?((ExpressionContext)_localctx).NUM.getText():null)) == null)
							memory.put((((ExpressionContext)_localctx).NUM!=null?((ExpressionContext)_localctx).NUM.getText():null), (((ExpressionContext)_localctx).NUM!=null?((ExpressionContext)_localctx).NUM.getText():null));
					
				}
				break;

			case 5:
				{
				setState(246); ((ExpressionContext)_localctx).SETSTART = match(SETSTART);
				setState(250);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 3) | (1L << 8) | (1L << 16) | (1L << 19) | (1L << 30) | (1L << 34) | (1L << 40) | (1L << 49) | (1L << NAME) | (1L << NUM) | (1L << SETSTART))) != 0)) {
					{
					setState(247); ((ExpressionContext)_localctx).a = expression(0);
					_localctx.elements.add((((ExpressionContext)_localctx).a!=null?_input.getText(((ExpressionContext)_localctx).a.start,((ExpressionContext)_localctx).a.stop):null));
					}
				}

				setState(258);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==28) {
					{
					{
					setState(252); match(28);
					setState(253); ((ExpressionContext)_localctx).b = expression(0);
					_localctx.elements.add((((ExpressionContext)_localctx).b!=null?_input.getText(((ExpressionContext)_localctx).b.start,((ExpressionContext)_localctx).b.stop):null));
					}
					}
					setState(260);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(261); ((ExpressionContext)_localctx).SETEND = match(SETEND);
					
						((ExpressionContext)_localctx).zName =  (((ExpressionContext)_localctx).SETSTART!=null?((ExpressionContext)_localctx).SETSTART.getText():null);
						//Llenamos elements y ponemos cada expression en la memory
						while( !_localctx.elements.isEmpty() ){
							String e = (String) _localctx.elements.remove(0);
							((ExpressionContext)_localctx).zName =  _localctx.zName.concat(e);
							//guardamos tambien las traducciones del conjunto
							((ExpressionContext)_localctx).setlogName =  _localctx.setlogName.concat((String)memory.get(e));
							
							if (!_localctx.elements.isEmpty()){
								((ExpressionContext)_localctx).zName =  _localctx.zName + ",";
								((ExpressionContext)_localctx).setlogName =  _localctx.setlogName + ",";
							}
						}
						((ExpressionContext)_localctx).zName =  _localctx.zName + (((ExpressionContext)_localctx).SETEND!=null?((ExpressionContext)_localctx).SETEND.getText():null);
						if (memory.get(_localctx.zName) == null) {
							memory.put(_localctx.zName, "{" + _localctx.setlogName + "}");
						}
					
				}
				break;

			case 6:
				{
				setState(263); ((ExpressionContext)_localctx).SETSTART = match(SETSTART);
				modoSetExpression=1; setExpressionDecl = ""; setExpressionPred = ""; setExpressionExpr = ""; setExpressionVars = new ArrayList();
				setState(265); ((ExpressionContext)_localctx).declPart = declPart();
				((ExpressionContext)_localctx).zName =  (((ExpressionContext)_localctx).SETSTART!=null?((ExpressionContext)_localctx).SETSTART.getText():null) + (((ExpressionContext)_localctx).declPart!=null?_input.getText(((ExpressionContext)_localctx).declPart.start,((ExpressionContext)_localctx).declPart.stop):null);
				setState(272);
				_la = _input.LA(1);
				if (_la==24) {
					{
					setState(267); match(24);
					modoSetExpression=2;
					setState(269); ((ExpressionContext)_localctx).predicate = predicate(0);
					((ExpressionContext)_localctx).zName =  _localctx.zName.concat("|" + (((ExpressionContext)_localctx).predicate!=null?_input.getText(((ExpressionContext)_localctx).predicate.start,((ExpressionContext)_localctx).predicate.stop):null));
					}
				}

				setState(279);
				_la = _input.LA(1);
				if (_la==15) {
					{
					setState(274); match(15);
					modoSetExpression=3;
					setState(276); ((ExpressionContext)_localctx).c = expression(0);
					((ExpressionContext)_localctx).zName =  _localctx.zName.concat("@" + (((ExpressionContext)_localctx).c!=null?_input.getText(((ExpressionContext)_localctx).c.start,((ExpressionContext)_localctx).c.stop):null));
					}
				}

				setState(281); ((ExpressionContext)_localctx).SETEND = match(SETEND);
				modoSetExpression=0; ((ExpressionContext)_localctx).zName =  _localctx.zName.concat((((ExpressionContext)_localctx).SETEND!=null?((ExpressionContext)_localctx).SETEND.getText():null));

						if (memory.get(_localctx.zName)==null) {
							((ExpressionContext)_localctx).setlogName =  "";
							((ExpressionContext)_localctx).newVarName1 =  "VAR" + varNumber;
							varNumber++;
							((ExpressionContext)_localctx).newVarName2 =  "VAR" + varNumber;
							varNumber++;
							
							((ExpressionContext)_localctx).setlogName =  _localctx.setlogName.concat("{ " + _localctx.newVarName1 + ":exists([");
							
							while(!setExpressionVars.isEmpty()){
								((ExpressionContext)_localctx).setlogName =  _localctx.setlogName.concat((String) setExpressionVars.remove(0));
								if (!setExpressionVars.isEmpty()) ((ExpressionContext)_localctx).setlogName =  _localctx.setlogName.concat(",");
							}
						
							((ExpressionContext)_localctx).setlogName =  _localctx.setlogName.concat("], " + setExpressionDecl.substring(setExpressionDecl.indexOf('&') + 1) + ")" +
							setExpressionPred + " & " + _localctx.newVarName1 + " is " + memory.get((((ExpressionContext)_localctx).c!=null?_input.getText(((ExpressionContext)_localctx).c.start,((ExpressionContext)_localctx).c.stop):null)) + " }");
						
							memory.put(_localctx.zName, _localctx.newVarName2);
							print(_localctx.newVarName2 + " = " + _localctx.setlogName);
						}
					
				}
				break;

			case 7:
				{
				setState(285); match(30);
				setState(286); ((ExpressionContext)_localctx).e = expression(0);
				setState(287); match(14);

						String a = (String) memory.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null));
						
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

			case 8:
				{
				setState(290); match(19);
					
						if (memory.get("\\nat") == null) {
							memory.put("\\nat", "NAT");
							print("NAT = int(0, 10000000000)");
							types.put("\\nat", "\\nat");
						}	
					
				}
				break;

			case 9:
				{
				setState(292); match(49);
					
						if (memory.get("\\num") == null) {
							memory.put("\\num", "NUM");
							print("NUM = int(-10000000000, 10000000000)");
							types.put("\\num", "\\num");
						}	
					
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(355);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(353);
					switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(296);
						if (!(19 >= _localctx._p)) throw new FailedPredicateException(this, "19 >= $_p");
						setState(297); match(27);
						setState(298); ((ExpressionContext)_localctx).b = expression(20);

						          		//Guardo el tipo
						          		String aType = (String) types.get((((ExpressionContext)_localctx).a!=null?_input.getText(((ExpressionContext)_localctx).a.start,((ExpressionContext)_localctx).a.stop):null));
						          		if (aType.startsWith("BasicType") || aType.startsWith("EnumerationType")) {
						          			aType = (((ExpressionContext)_localctx).a!=null?_input.getText(((ExpressionContext)_localctx).a.start,((ExpressionContext)_localctx).a.stop):null);
						          		}
						          		String bType = (String) types.get((((ExpressionContext)_localctx).b!=null?_input.getText(((ExpressionContext)_localctx).b.start,((ExpressionContext)_localctx).b.stop):null));
						          		if (bType.startsWith("BasicType") || bType.startsWith("EnumerationType"))
						          			bType = (((ExpressionContext)_localctx).b!=null?_input.getText(((ExpressionContext)_localctx).b.start,((ExpressionContext)_localctx).b.stop):null);
						          			
						          		types.put((((ExpressionContext)_localctx).a!=null?_input.getText(((ExpressionContext)_localctx).a.start,((ExpressionContext)_localctx).a.stop):null) + "\\rel" + (((ExpressionContext)_localctx).b!=null?_input.getText(((ExpressionContext)_localctx).b.start,((ExpressionContext)_localctx).b.stop):null), aType + "\\rel" + bType );
						          	
						}
						break;

					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(301);
						if (!(18 >= _localctx._p)) throw new FailedPredicateException(this, "18 >= $_p");
						setState(302);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==5 || _la==10) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(303); ((ExpressionContext)_localctx).b = expression(19);

						          		//Guardo el tipo
						          		String aType = (String) types.get((((ExpressionContext)_localctx).a!=null?_input.getText(((ExpressionContext)_localctx).a.start,((ExpressionContext)_localctx).a.stop):null));
						          		if (aType.startsWith("BasicType") || aType.startsWith("EnumerationType")) {
						          			aType = (((ExpressionContext)_localctx).a!=null?_input.getText(((ExpressionContext)_localctx).a.start,((ExpressionContext)_localctx).a.stop):null);
						          		}
						          		String bType = (String) types.get((((ExpressionContext)_localctx).b!=null?_input.getText(((ExpressionContext)_localctx).b.start,((ExpressionContext)_localctx).b.stop):null));
						          		if (bType.startsWith("BasicType") || bType.startsWith("EnumerationType"))
						          			bType = (((ExpressionContext)_localctx).b!=null?_input.getText(((ExpressionContext)_localctx).b.start,((ExpressionContext)_localctx).b.stop):null);
						          			
						          		types.put((((ExpressionContext)_localctx).a!=null?_input.getText(((ExpressionContext)_localctx).a.start,((ExpressionContext)_localctx).a.stop):null) + (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null) + (((ExpressionContext)_localctx).b!=null?_input.getText(((ExpressionContext)_localctx).b.start,((ExpressionContext)_localctx).b.stop):null), aType + "\\pfun" + bType );
						          	
						}
						break;

					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(306);
						if (!(17 >= _localctx._p)) throw new FailedPredicateException(this, "17 >= $_p");
						setState(307); match(44);
						setState(308); ((ExpressionContext)_localctx).b = expression(18);

						          		//Guardo el tipo
						          		String aType = (String) types.get((((ExpressionContext)_localctx).a!=null?_input.getText(((ExpressionContext)_localctx).a.start,((ExpressionContext)_localctx).a.stop):null));
						          		if (aType.startsWith("BasicType") || aType.startsWith("EnumerationType")) {
						          			aType = (((ExpressionContext)_localctx).a!=null?_input.getText(((ExpressionContext)_localctx).a.start,((ExpressionContext)_localctx).a.stop):null);
						          		}
						          		String bType = (String) types.get((((ExpressionContext)_localctx).b!=null?_input.getText(((ExpressionContext)_localctx).b.start,((ExpressionContext)_localctx).b.stop):null));
						          		if (bType.startsWith("BasicType") || bType.startsWith("EnumerationType"))
						          			bType = (((ExpressionContext)_localctx).b!=null?_input.getText(((ExpressionContext)_localctx).b.start,((ExpressionContext)_localctx).b.stop):null);
						          			
						          		types.put((((ExpressionContext)_localctx).a!=null?_input.getText(((ExpressionContext)_localctx).a.start,((ExpressionContext)_localctx).a.stop):null) + "\\fun" + (((ExpressionContext)_localctx).b!=null?_input.getText(((ExpressionContext)_localctx).b.start,((ExpressionContext)_localctx).b.stop):null), aType + "\\fun" + bType );
						          	
						}
						break;

					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(311);
						if (!(15 >= _localctx._p)) throw new FailedPredicateException(this, "15 >= $_p");
						setState(312); match(51);
						setState(313); ((ExpressionContext)_localctx).e2 = expression(16);

						          		String a, b;
						          		a = (String)memory.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null));
						          		b = (String)memory.get((((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null));
						          		
						          		if (memory.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "~" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null)) == null) {
						          			String newVarName = "VAR" + varNumber;
						          			varNumber++;
						          			memory.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "~" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          			types.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "~" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), getChildType((String) types.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null)), 1));
						          			print("apply(" + a + "," + b + "," + newVarName + ")");
						          			
						          			//Consulto el tipo para ver si es numerico
						          			String newVarType = getChildType((String) types.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null)), 1);
						          			
						          			if (newVarType.equals("\\num"))
						          				print(newVarName + " in NUM");
						          			else if (newVarType.equals("\\nat"))
						          				print(newVarName + " in NAT");
						          		}
						          	
						}
						break;

					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(316);
						if (!(14 >= _localctx._p)) throw new FailedPredicateException(this, "14 >= $_p");
						setState(317); match(41);
						setState(318); ((ExpressionContext)_localctx).e2 = expression(15);

						          		if (memory.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "." + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null)) == null) {
						          		
						          			String e1Type = (String) types.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null));
						          			if (!e1Type.startsWith("SchemaType:")) //Debo llegar a obtener la lista con las variables
						          				e1Type = (String) types.get(e1Type);
						          			
						          			if (e1Type.startsWith("SchemaType:")) {
						          				String schemaVars = e1Type.substring("SchemaType:".length());
						          				
						          				//Obtengo el indice de la variable e2 dentro de la lista de variables del tipo schema
						          				//Primero obtenemos la lista de variables
						          				schemaVars = schemaVars.substring(1, schemaVars.length()-1);
						          				String[] vars = schemaVars.split(",");
						          				//Buscamos la posicion de la variable
						          				int position = 1;
						          				while (!vars[position-1].contains((((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null) + ":")) //Se resta 1 porque en setlog empiezan en 1, no en 0 como en java
						          					position++;
						          				//Creamos una nueva variable
						          				String newVarName = "VAR" + varNumber;
						          				varNumber++;
						          				//Vemos su tipo
						          				String type = vars[position-1].substring((((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null).length()+1);
						          				memory.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "." + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          				types.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "." + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), type);
						          				print("nth1(" + position + "," + memory.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null)) + "," + newVarName + ")");
						          				
						          			}
						          		}
						          	
						}
						break;

					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(321);
						if (!(13 >= _localctx._p)) throw new FailedPredicateException(this, "13 >= $_p");
						setState(322); match(52);
						setState(323); ((ExpressionContext)_localctx).e2 = expression(14);

						          		String a, b;
						          		a = (String)memory.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null));
						          		b = (String)memory.get((((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null));
						          		memory.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\mapsto" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), "[" + a + "," + b + "]");
						          	
						}
						break;

					case 7:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(326);
						if (!(12 >= _localctx._p)) throw new FailedPredicateException(this, "12 >= $_p");
						setState(327); match(9);
						setState(328); ((ExpressionContext)_localctx).e2 = expression(13);

						          		String a, b;
						          		a = (String)memory.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null));
						          		b = (String)memory.get((((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null));
						          		if (memory.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\upto" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null)) == null) {
						          			String newVarName = "VAR" + varNumber;
						          			varNumber++;
						          			memory.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\upto" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          			print(newVarName + " = int(" + a + "," + b + ")");
						          		}
						          	
						}
						break;

					case 8:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(331);
						if (!(10 >= _localctx._p)) throw new FailedPredicateException(this, "10 >= $_p");
						setState(332); ((ExpressionContext)_localctx).IN_FUN_P4 = match(IN_FUN_P4);
						setState(333); ((ExpressionContext)_localctx).e2 = expression(11);

						          		String a, b;
						          		a = (String)memory.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null));
						          		b = (String)memory.get((((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null));
						          		
						          		if (memory.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + (((ExpressionContext)_localctx).IN_FUN_P4!=null?((ExpressionContext)_localctx).IN_FUN_P4.getText():null) + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null)) == null) {
						          		
						          			String newVarName = "VAR" + varNumber;
						          			varNumber++;
						          			Boolean isNumeric = false; 
						          		
						          			if ((((ExpressionContext)_localctx).IN_FUN_P4!=null?((ExpressionContext)_localctx).IN_FUN_P4.getText():null).equals("*")){
						          				print( newVarName + " is " + a + "*" + b );
						          				memory.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "*" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          				isNumeric = true;
						          			}
						          			else if ((((ExpressionContext)_localctx).IN_FUN_P4!=null?((ExpressionContext)_localctx).IN_FUN_P4.getText():null).equals("\\div")) {
						          				print( newVarName + " is div(" + a + "," + b + ")" );
						          				memory.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\div" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          				isNumeric = true;
						          			}
						          			else if ((((ExpressionContext)_localctx).IN_FUN_P4!=null?((ExpressionContext)_localctx).IN_FUN_P4.getText():null).equals("\\mod")){
						          				print( newVarName + " is mod(" + a + "," + b + ")" );
						          				memory.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\mod" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          				isNumeric = true;
						          			}
						          			else if ((((ExpressionContext)_localctx).IN_FUN_P4!=null?((ExpressionContext)_localctx).IN_FUN_P4.getText():null).equals("\\cap")){
						          					print("dinters(" + a + "," + b + "," + newVarName + ")");
						          					memory.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\cap" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          			}
						          			
						          			if (isNumeric) {
						          				if (memory.get("\\num") == null) {
						          					memory.put("\\num", "NUM");
						          					print("NUM = int(-10000000000, 10000000000)");
						          					types.put("\\num", "\\num");
						          				}
						          				print(newVarName + " in NUM");
						          			}
						          		}
						          	
						}
						break;

					case 9:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(336);
						if (!(9 >= _localctx._p)) throw new FailedPredicateException(this, "9 >= $_p");
						setState(337); ((ExpressionContext)_localctx).IN_FUN_P3 = match(IN_FUN_P3);
						setState(338); ((ExpressionContext)_localctx).e2 = expression(10);

						          		String a, b;
						          		a = (String)memory.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null));
						          		b = (String)memory.get((((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null));
						          		
						          		if (memory.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + (((ExpressionContext)_localctx).IN_FUN_P3!=null?((ExpressionContext)_localctx).IN_FUN_P3.getText():null) + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null)) == null) {
						          		
						          			String newVarName = "VAR" + varNumber;
						          			varNumber++;
						          			Boolean isNumeric = false; 
						          			
						          		
						          			if ((((ExpressionContext)_localctx).IN_FUN_P3!=null?((ExpressionContext)_localctx).IN_FUN_P3.getText():null).equals("+")){
						          				print( newVarName + " is " + a + "+" + b );
						          				memory.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "+" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          				isNumeric = true;
						          			}
						          			else if ((((ExpressionContext)_localctx).IN_FUN_P3!=null?((ExpressionContext)_localctx).IN_FUN_P3.getText():null).equals("-")) {
						          				print( newVarName + " is " + a + "-" + b );
						          				memory.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "-" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          				isNumeric = true;
						          			}
						          			else if ((((ExpressionContext)_localctx).IN_FUN_P3!=null?((ExpressionContext)_localctx).IN_FUN_P3.getText():null).equals("\\cup")){
						          					print("dunion(" + a + "," + b + "," + newVarName + ")");
						          					memory.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\cup" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          			}
						          			
						          			if (isNumeric) {
						          				if (memory.get("\\num") == null) {
						          					memory.put("\\num", "NUM");
						          					print("NUM = int(-10000000000, 10000000000)");
						          					types.put("\\num", "\\num");
						          				}
						          				print(newVarName + " in NUM");
						          			}
						          		}
						          	
						}
						break;

					case 10:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(341);
						if (!(16 >= _localctx._p)) throw new FailedPredicateException(this, "16 >= $_p");
						((ExpressionContext)getInvokingContext(10)).elements.add((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null));
						setState(347); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(343); match(36);
								setState(344); ((ExpressionContext)_localctx).e2 = expression(0);
								((ExpressionContext)getInvokingContext(10)).elements.add((((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null));
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(349); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
						} while ( _alt!=2 && _alt!=-1 );

						          		String unfoldedType = "";
						          		
						          		//Para cada exp realizamos el procesamiento
						          		while( !((ExpressionContext)getInvokingContext(10)).elements.isEmpty() ) {
						          			String exp = (String) ((ExpressionContext)getInvokingContext(10)).elements.remove(0);
						          			
						          			((ExpressionContext)_localctx).zName =  _localctx.zName.concat(exp);
						          			
						          			String expType = (String) types.get(exp);
						          			if (expType.startsWith("BasicType") || expType.startsWith("EnumerationType"))
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
					}
					} 
				}
				setState(357);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
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

	public static class Pre_genContext extends ParserRuleContext {
		public Pre_genContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pre_gen; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterPre_gen(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitPre_gen(this);
		}
	}

	public final Pre_genContext pre_gen() throws RecognitionException {
		Pre_genContext _localctx = new Pre_genContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_pre_gen);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(358);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 3) | (1L << 8) | (1L << 16) | (1L << 34))) != 0)) ) {
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
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4: return 19 >= _localctx._p;

		case 5: return 18 >= _localctx._p;

		case 6: return 17 >= _localctx._p;

		case 7: return 15 >= _localctx._p;

		case 8: return 14 >= _localctx._p;

		case 9: return 13 >= _localctx._p;

		case 10: return 12 >= _localctx._p;

		case 11: return 10 >= _localctx._p;

		case 12: return 9 >= _localctx._p;

		case 13: return 16 >= _localctx._p;
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
		"\2\3?\u016b\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4"+
		"\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\3\2\3\2\7\2\35\n\2\f\2\16\2 "+
		"\13\2\6\2\"\n\2\r\2\16\2#\3\2\3\2\3\3\3\3\3\3\3\3\5\3,\n\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\5\3\67\n\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3@\n"+
		"\3\3\3\3\3\6\3D\n\3\r\3\16\3E\3\3\3\3\5\3J\n\3\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\7\4S\n\4\f\4\16\4V\13\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3"+
		"\6\3\6\3\6\5\6e\n\6\3\6\3\6\3\6\3\6\5\6k\n\6\7\6m\n\6\f\6\16\6p\13\6\3"+
		"\6\3\6\3\7\3\7\3\7\3\7\5\7x\n\7\3\7\3\7\3\7\3\7\3\7\7\7\177\n\7\f\7\16"+
		"\7\u0082\13\7\3\b\3\b\3\b\7\b\u0087\n\b\f\b\16\b\u008a\13\b\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\7\t\u0092\n\t\f\t\16\t\u0095\13\t\3\t\3\t\3\t\3\t\3\n\3"+
		"\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\5\13\u00d9\n\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\7\13\u00e7\n\13\f\13\16\13\u00ea\13\13"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5"+
		"\f\u00fd\n\f\3\f\3\f\3\f\3\f\7\f\u0103\n\f\f\f\16\f\u0106\13\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u0113\n\f\3\f\3\f\3\f\3\f\3\f"+
		"\5\f\u011a\n\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f"+
		"\u0129\n\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\6\f\u015e\n\f\r\f\16\f\u015f\3\f\3\f\7\f\u0164\n\f\f\f\16\f\u0167"+
		"\13\f\3\r\3\r\3\r\2\16\2\4\6\b\n\f\16\20\22\24\26\30\2\5\4\60\60;;\4\7"+
		"\7\f\f\6\5\5\n\n\22\22$$\u0196\2!\3\2\2\2\4I\3\2\2\2\6K\3\2\2\2\bZ\3\2"+
		"\2\2\n_\3\2\2\2\fs\3\2\2\2\16\u0083\3\2\2\2\20\u008b\3\2\2\2\22\u009a"+
		"\3\2\2\2\24\u00d8\3\2\2\2\26\u0128\3\2\2\2\30\u0168\3\2\2\2\32\36\5\4"+
		"\3\2\33\35\7;\2\2\34\33\3\2\2\2\35 \3\2\2\2\36\34\3\2\2\2\36\37\3\2\2"+
		"\2\37\"\3\2\2\2 \36\3\2\2\2!\32\3\2\2\2\"#\3\2\2\2#!\3\2\2\2#$\3\2\2\2"+
		"$%\3\2\2\2%&\b\2\1\2&\3\3\2\2\2\'+\7(\2\2(,\7\3\2\2)*\7-\2\2*,\b\3\1\2"+
		"+(\3\2\2\2+)\3\2\2\2,-\3\2\2\2-.\7\37\2\2./\7\67\2\2/\60\7\r\2\2\60\61"+
		"\5\f\7\2\61\62\b\3\1\2\62\66\7\33\2\2\63\67\7\3\2\2\64\65\7-\2\2\65\67"+
		"\b\3\1\2\66\63\3\2\2\2\66\64\3\2\2\2\678\3\2\2\289\7\r\2\29J\3\2\2\2:"+
		";\7\62\2\2;C\7;\2\2<@\5\6\4\2=@\5\b\5\2>@\5\n\6\2?<\3\2\2\2?=\3\2\2\2"+
		"?>\3\2\2\2@A\3\2\2\2AB\7;\2\2BD\3\2\2\2C?\3\2\2\2DE\3\2\2\2EC\3\2\2\2"+
		"EF\3\2\2\2FG\3\2\2\2GH\7#\2\2HJ\3\2\2\2I\'\3\2\2\2I:\3\2\2\2J\5\3\2\2"+
		"\2KL\7\6\2\2LM\5\22\n\2MT\b\4\1\2NO\7\36\2\2OP\5\22\n\2PQ\b\4\1\2QS\3"+
		"\2\2\2RN\3\2\2\2SV\3\2\2\2TR\3\2\2\2TU\3\2\2\2UW\3\2\2\2VT\3\2\2\2WX\7"+
		"\34\2\2XY\b\4\1\2Y\7\3\2\2\2Z[\5\22\n\2[\\\7\64\2\2\\]\5\26\f\2]^\b\5"+
		"\1\2^\t\3\2\2\2_`\5\22\n\2`a\7\31\2\2ab\5\22\n\2bd\b\6\1\2ce\5\26\f\2"+
		"dc\3\2\2\2de\3\2\2\2en\3\2\2\2fg\7\32\2\2gh\5\22\n\2hj\b\6\1\2ik\5\26"+
		"\f\2ji\3\2\2\2jk\3\2\2\2km\3\2\2\2lf\3\2\2\2mp\3\2\2\2nl\3\2\2\2no\3\2"+
		"\2\2oq\3\2\2\2pn\3\2\2\2qr\b\6\1\2r\13\3\2\2\2sw\7;\2\2tu\5\16\b\2uv\7"+
		";\2\2vx\3\2\2\2wt\3\2\2\2wx\3\2\2\2xy\3\2\2\2yz\7\30\2\2z\u0080\7;\2\2"+
		"{|\5\24\13\2|}\7;\2\2}\177\3\2\2\2~{\3\2\2\2\177\u0082\3\2\2\2\u0080~"+
		"\3\2\2\2\u0080\u0081\3\2\2\2\u0081\r\3\2\2\2\u0082\u0080\3\2\2\2\u0083"+
		"\u0088\5\20\t\2\u0084\u0085\t\2\2\2\u0085\u0087\5\20\t\2\u0086\u0084\3"+
		"\2\2\2\u0087\u008a\3\2\2\2\u0088\u0086\3\2\2\2\u0088\u0089\3\2\2\2\u0089"+
		"\17\3\2\2\2\u008a\u0088\3\2\2\2\u008b\u008c\5\22\n\2\u008c\u0093\b\t\1"+
		"\2\u008d\u008e\7\36\2\2\u008e\u008f\5\22\n\2\u008f\u0090\b\t\1\2\u0090"+
		"\u0092\3\2\2\2\u0091\u008d\3\2\2\2\u0092\u0095\3\2\2\2\u0093\u0091\3\2"+
		"\2\2\u0093\u0094\3\2\2\2\u0094\u0096\3\2\2\2\u0095\u0093\3\2\2\2\u0096"+
		"\u0097\7!\2\2\u0097\u0098\5\26\f\2\u0098\u0099\b\t\1\2\u0099\21\3\2\2"+
		"\2\u009a\u009b\7\67\2\2\u009b\23\3\2\2\2\u009c\u009d\b\13\1\2\u009d\u009e"+
		"\7\4\2\2\u009e\u00d9\5\24\13\2\u009f\u00a0\5\26\f\2\u00a0\u00a1\7%\2\2"+
		"\u00a1\u00a2\7\n\2\2\u00a2\u00a3\5\26\f\2\u00a3\u00a4\b\13\1\2\u00a4\u00d9"+
		"\3\2\2\2\u00a5\u00a6\5\26\f\2\u00a6\u00a7\7%\2\2\u00a7\u00a8\5\26\f\2"+
		"\u00a8\u00a9\b\13\1\2\u00a9\u00d9\3\2\2\2\u00aa\u00ab\5\26\f\2\u00ab\u00ac"+
		"\7\16\2\2\u00ac\u00ad\5\26\f\2\u00ad\u00ae\b\13\1\2\u00ae\u00d9\3\2\2"+
		"\2\u00af\u00b0\5\26\f\2\u00b0\u00b1\7\b\2\2\u00b1\u00b2\5\26\f\2\u00b2"+
		"\u00b3\b\13\1\2\u00b3\u00d9\3\2\2\2\u00b4\u00b5\5\26\f\2\u00b5\u00b6\7"+
		"\61\2\2\u00b6\u00b7\5\26\f\2\u00b7\u00b8\b\13\1\2\u00b8\u00d9\3\2\2\2"+
		"\u00b9\u00ba\5\26\f\2\u00ba\u00bb\7\24\2\2\u00bb\u00bc\5\26\f\2\u00bc"+
		"\u00bd\b\13\1\2\u00bd\u00d9\3\2\2\2\u00be\u00bf\5\26\f\2\u00bf\u00c0\7"+
		"\27\2\2\u00c0\u00c1\5\26\f\2\u00c1\u00c2\b\13\1\2\u00c2\u00d9\3\2\2\2"+
		"\u00c3\u00c4\5\26\f\2\u00c4\u00c5\7\23\2\2\u00c5\u00c6\5\26\f\2\u00c6"+
		"\u00c7\b\13\1\2\u00c7\u00d9\3\2\2\2\u00c8\u00c9\5\26\f\2\u00c9\u00ca\7"+
		")\2\2\u00ca\u00cb\5\26\f\2\u00cb\u00cc\b\13\1\2\u00cc\u00d9\3\2\2\2\u00cd"+
		"\u00ce\5\26\f\2\u00ce\u00cf\7\26\2\2\u00cf\u00d0\5\26\f\2\u00d0\u00d1"+
		"\b\13\1\2\u00d1\u00d9\3\2\2\2\u00d2\u00d3\7 \2\2\u00d3\u00d4\5\24\13\2"+
		"\u00d4\u00d5\7\20\2\2\u00d5\u00d9\3\2\2\2\u00d6\u00d9\7\'\2\2\u00d7\u00d9"+
		"\7\t\2\2\u00d8\u009c\3\2\2\2\u00d8\u009f\3\2\2\2\u00d8\u00a5\3\2\2\2\u00d8"+
		"\u00aa\3\2\2\2\u00d8\u00af\3\2\2\2\u00d8\u00b4\3\2\2\2\u00d8\u00b9\3\2"+
		"\2\2\u00d8\u00be\3\2\2\2\u00d8\u00c3\3\2\2\2\u00d8\u00c8\3\2\2\2\u00d8"+
		"\u00cd\3\2\2\2\u00d8\u00d2\3\2\2\2\u00d8\u00d6\3\2\2\2\u00d8\u00d7\3\2"+
		"\2\2\u00d9\u00e8\3\2\2\2\u00da\u00db\6\13\2\3\u00db\u00dc\7,\2\2\u00dc"+
		"\u00e7\5\24\13\2\u00dd\u00de\6\13\3\3\u00de\u00df\7/\2\2\u00df\u00e7\5"+
		"\24\13\2\u00e0\u00e1\6\13\4\3\u00e1\u00e2\7\"\2\2\u00e2\u00e7\5\24\13"+
		"\2\u00e3\u00e4\6\13\5\3\u00e4\u00e5\7\17\2\2\u00e5\u00e7\5\24\13\2\u00e6"+
		"\u00da\3\2\2\2\u00e6\u00dd\3\2\2\2\u00e6\u00e0\3\2\2\2\u00e6\u00e3\3\2"+
		"\2\2\u00e7\u00ea\3\2\2\2\u00e8\u00e6\3\2\2\2\u00e8\u00e9\3\2\2\2\u00e9"+
		"\25\3\2\2\2\u00ea\u00e8\3\2\2\2\u00eb\u00ec\b\f\1\2\u00ec\u00ed\5\30\r"+
		"\2\u00ed\u00ee\5\26\f\2\u00ee\u00ef\b\f\1\2\u00ef\u0129\3\2\2\2\u00f0"+
		"\u00f1\7*\2\2\u00f1\u00f2\5\26\f\2\u00f2\u00f3\b\f\1\2\u00f3\u0129\3\2"+
		"\2\2\u00f4\u00f5\7\67\2\2\u00f5\u0129\b\f\1\2\u00f6\u00f7\78\2\2\u00f7"+
		"\u0129\b\f\1\2\u00f8\u00fc\7=\2\2\u00f9\u00fa\5\26\f\2\u00fa\u00fb\b\f"+
		"\1\2\u00fb\u00fd\3\2\2\2\u00fc\u00f9\3\2\2\2\u00fc\u00fd\3\2\2\2\u00fd"+
		"\u0104\3\2\2\2\u00fe\u00ff\7\36\2\2\u00ff\u0100\5\26\f\2\u0100\u0101\b"+
		"\f\1\2\u0101\u0103\3\2\2\2\u0102\u00fe\3\2\2\2\u0103\u0106\3\2\2\2\u0104"+
		"\u0102\3\2\2\2\u0104\u0105\3\2\2\2\u0105\u0107\3\2\2\2\u0106\u0104\3\2"+
		"\2\2\u0107\u0108\7>\2\2\u0108\u0129\b\f\1\2\u0109\u010a\7=\2\2\u010a\u010b"+
		"\b\f\1\2\u010b\u010c\5\16\b\2\u010c\u0112\b\f\1\2\u010d\u010e\7\32\2\2"+
		"\u010e\u010f\b\f\1\2\u010f\u0110\5\24\13\2\u0110\u0111\b\f\1\2\u0111\u0113"+
		"\3\2\2\2\u0112\u010d\3\2\2\2\u0112\u0113\3\2\2\2\u0113\u0119\3\2\2\2\u0114"+
		"\u0115\7\21\2\2\u0115\u0116\b\f\1\2\u0116\u0117\5\26\f\2\u0117\u0118\b"+
		"\f\1\2\u0118\u011a\3\2\2\2\u0119\u0114\3\2\2\2\u0119\u011a\3\2\2\2\u011a"+
		"\u011b\3\2\2\2\u011b\u011c\7>\2\2\u011c\u011d\b\f\1\2\u011d\u011e\b\f"+
		"\1\2\u011e\u0129\3\2\2\2\u011f\u0120\7 \2\2\u0120\u0121\5\26\f\2\u0121"+
		"\u0122\7\20\2\2\u0122\u0123\b\f\1\2\u0123\u0129\3\2\2\2\u0124\u0125\7"+
		"\25\2\2\u0125\u0129\b\f\1\2\u0126\u0127\7\63\2\2\u0127\u0129\b\f\1\2\u0128"+
		"\u00eb\3\2\2\2\u0128\u00f0\3\2\2\2\u0128\u00f4\3\2\2\2\u0128\u00f6\3\2"+
		"\2\2\u0128\u00f8\3\2\2\2\u0128\u0109\3\2\2\2\u0128\u011f\3\2\2\2\u0128"+
		"\u0124\3\2\2\2\u0128\u0126\3\2\2\2\u0129\u0165\3\2\2\2\u012a\u012b\6\f"+
		"\6\3\u012b\u012c\7\35\2\2\u012c\u012d\5\26\f\2\u012d\u012e\b\f\1\2\u012e"+
		"\u0164\3\2\2\2\u012f\u0130\6\f\7\3\u0130\u0131\t\3\2\2\u0131\u0132\5\26"+
		"\f\2\u0132\u0133\b\f\1\2\u0133\u0164\3\2\2\2\u0134\u0135\6\f\b\3\u0135"+
		"\u0136\7.\2\2\u0136\u0137\5\26\f\2\u0137\u0138\b\f\1\2\u0138\u0164\3\2"+
		"\2\2\u0139\u013a\6\f\t\3\u013a\u013b\7\65\2\2\u013b\u013c\5\26\f\2\u013c"+
		"\u013d\b\f\1\2\u013d\u0164\3\2\2\2\u013e\u013f\6\f\n\3\u013f\u0140\7+"+
		"\2\2\u0140\u0141\5\26\f\2\u0141\u0142\b\f\1\2\u0142\u0164\3\2\2\2\u0143"+
		"\u0144\6\f\13\3\u0144\u0145\7\66\2\2\u0145\u0146\5\26\f\2\u0146\u0147"+
		"\b\f\1\2\u0147\u0164\3\2\2\2\u0148\u0149\6\f\f\3\u0149\u014a\7\13\2\2"+
		"\u014a\u014b\5\26\f\2\u014b\u014c\b\f\1\2\u014c\u0164\3\2\2\2\u014d\u014e"+
		"\6\f\r\3\u014e\u014f\7:\2\2\u014f\u0150\5\26\f\2\u0150\u0151\b\f\1\2\u0151"+
		"\u0164\3\2\2\2\u0152\u0153\6\f\16\3\u0153\u0154\79\2\2\u0154\u0155\5\26"+
		"\f\2\u0155\u0156\b\f\1\2\u0156\u0164\3\2\2\2\u0157\u0158\6\f\17\3\u0158"+
		"\u015d\b\f\1\2\u0159\u015a\7&\2\2\u015a\u015b\5\26\f\2\u015b\u015c\b\f"+
		"\1\2\u015c\u015e\3\2\2\2\u015d\u0159\3\2\2\2\u015e\u015f\3\2\2\2\u015f"+
		"\u015d\3\2\2\2\u015f\u0160\3\2\2\2\u0160\u0161\3\2\2\2\u0161\u0162\b\f"+
		"\1\2\u0162\u0164\3\2\2\2\u0163\u012a\3\2\2\2\u0163\u012f\3\2\2\2\u0163"+
		"\u0134\3\2\2\2\u0163\u0139\3\2\2\2\u0163\u013e\3\2\2\2\u0163\u0143\3\2"+
		"\2\2\u0163\u0148\3\2\2\2\u0163\u014d\3\2\2\2\u0163\u0152\3\2\2\2\u0163"+
		"\u0157\3\2\2\2\u0164\u0167\3\2\2\2\u0165\u0163\3\2\2\2\u0165\u0166\3\2"+
		"\2\2\u0166\27\3\2\2\2\u0167\u0165\3\2\2\2\u0168\u0169\t\4\2\2\u0169\31"+
		"\3\2\2\2\34\36#+\66?EITdjnw\u0080\u0088\u0093\u00d8\u00e6\u00e8\u00fc"+
		"\u0104\u0112\u0119\u0128\u015f\u0163\u0165";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}