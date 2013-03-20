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
		T__49=1, T__48=2, T__47=3, T__46=4, T__45=5, T__44=6, T__43=7, T__42=8, 
		T__41=9, T__40=10, T__39=11, T__38=12, T__37=13, T__36=14, T__35=15, T__34=16, 
		T__33=17, T__32=18, T__31=19, T__30=20, T__29=21, T__28=22, T__27=23, 
		T__26=24, T__25=25, T__24=26, T__23=27, T__22=28, T__21=29, T__20=30, 
		T__19=31, T__18=32, T__17=33, T__16=34, T__15=35, T__14=36, T__13=37, 
		T__12=38, T__11=39, T__10=40, T__9=41, T__8=42, T__7=43, T__6=44, T__5=45, 
		T__4=46, T__3=47, T__2=48, T__1=49, T__0=50, NAME=51, NUM=52, IN_FUN_P3=53, 
		IN_FUN_P4=54, NL=55, WS=56, SETSTART=57, SETEND=58, SKIP=59;
	public static final String[] tokenNames = {
		"<INVALID>", "'\\lnot'", "'\\#'", "'['", "'\\pfun'", "'<'", "'false'", 
		"'\\end{schema}'", "'\\dom'", "'\\upto'", "'\\ffun'", "'}'", "'\\notin'", 
		"'\\land'", "')'", "'@'", "'\\seq'", "'='", "'\\leq'", "'\\nat'", "'\\neq'", 
		"'\\where'", "'\\geq'", "'::='", "'|'", "']'", "'\\rel'", "','", "'('", 
		"':'", "'\\lor'", "'\\ran'", "'\\end{zed}'", "'\\in'", "'\\cross'", "'true'", 
		"'\\begin{axdef}'", "'\\begin{schema}{'", "'\\subset'", "'\\power'", "'\\iff'", 
		"'\\end{axdef}'", "'\\fun'", "'\\implies'", "';'", "'>'", "'\\begin{zed}'", 
		"'\\num'", "'=='", "'~'", "'\\mapsto'", "NAME", "NUM", "IN_FUN_P3", "IN_FUN_P4", 
		"NL", "WS", "'\\{'", "'\\}'", "SKIP"
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


		String type;
		int varNumber = 0;
		HashMap memory = new HashMap(); //En memory se guardan las variables y expressiones leidas
		HashMap types = new HashMap();	//En types se guarda informacion sobre los tipos definidos
		int modoSetExpression = 0; //0 = false, 1 = true
		String setExpressionDecl, setExpressionPred, setExpressionExpr;
		ArrayList setExpressionVars;

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
			if (modoSetExpression == 0) 
				System.out.println(c + " &");
				//salida = salida.concat(c + " &");
			else if (modoSetExpression == 1)
				setExpressionDecl = setExpressionDecl.concat(" & " + c);
			else if (modoSetExpression == 2)
				setExpressionPred = setExpressionPred.concat(" & " + c);
			else if (modoSetExpression == 3)
				setExpressionExpr = setExpressionExpr.concat(" & " + c);
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
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 36) | (1L << 37) | (1L << 46))) != 0) );

				
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
		public DeclPartContext declPart() {
			return getRuleContext(DeclPartContext.class,0);
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
			setState(64);
			switch (_input.LA(1)) {
			case 37:
				enterOuterAlt(_localctx, 1);
				{
				setState(37); match(37);
				setState(38); match(NAME);
				setState(39); match(11);
				setState(40); schemaText();
				setState(41); match(7);
				}
				break;
			case 36:
				enterOuterAlt(_localctx, 2);
				{
				setState(43); match(36);
				setState(44); match(NL);
				setState(45); declPart();
				setState(46); match(NL);
				setState(47); match(41);
				}
				break;
			case 46:
				enterOuterAlt(_localctx, 3);
				{
				setState(49); match(46);
				setState(50); match(NL);
				setState(58); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(54);
					switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
					case 1:
						{
						setState(51); basic_type();
						}
						break;

					case 2:
						{
						setState(52); equivalent_type();
						}
						break;

					case 3:
						{
						setState(53); enumeration_type();
						}
						break;
					}
					setState(56); match(NL);
					}
					}
					setState(60); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==3 || _la==NAME );
				setState(62); match(32);
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
			setState(66); match(3);
			setState(67); ((Basic_typeContext)_localctx).a = ((Basic_typeContext)_localctx).declName = declName();
			((Basic_typeContext)getInvokingContext(2)).typeList.add((((Basic_typeContext)_localctx).a!=null?_input.getText(((Basic_typeContext)_localctx).a.start,((Basic_typeContext)_localctx).a.stop):null));
			setState(75);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==27) {
				{
				{
				setState(69); match(27);
				setState(70); ((Basic_typeContext)_localctx).b = ((Basic_typeContext)_localctx).declName = declName();
				((Basic_typeContext)getInvokingContext(2)).typeList.add((((Basic_typeContext)_localctx).b!=null?_input.getText(((Basic_typeContext)_localctx).b.start,((Basic_typeContext)_localctx).b.stop):null));
				}
				}
				setState(77);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(78); match(25);

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
			setState(81); ((Equivalent_typeContext)_localctx).declName = declName();
			setState(82); match(48);
			setState(83); ((Equivalent_typeContext)_localctx).expression = expression(0);
			 
					/* esto ya no se hace, porque simplemente declName es una etiqueta de tipos
					String newVarName = (((Equivalent_typeContext)_localctx).declName!=null?_input.getText(((Equivalent_typeContext)_localctx).declName.start,((Equivalent_typeContext)_localctx).declName.stop):null).substring(0,1).toUpperCase() + (((Equivalent_typeContext)_localctx).declName!=null?_input.getText(((Equivalent_typeContext)_localctx).declName.start,((Equivalent_typeContext)_localctx).declName.stop):null).substring(1).replace("?","");
					if (memory.containsValue(newVarName)) { 
						newVarName = "VAR" + varNumber;
						varNumber++;
					}
				
					memory.put((((Equivalent_typeContext)_localctx).declName!=null?_input.getText(((Equivalent_typeContext)_localctx).declName.start,((Equivalent_typeContext)_localctx).declName.stop):null), newVarName);
					*/
					
					String type = (String) types.get((((Equivalent_typeContext)_localctx).expression!=null?_input.getText(((Equivalent_typeContext)_localctx).expression.start,((Equivalent_typeContext)_localctx).expression.stop):null));
					if (type != null) {
						types.put((((Equivalent_typeContext)_localctx).declName!=null?_input.getText(((Equivalent_typeContext)_localctx).declName.start,((Equivalent_typeContext)_localctx).declName.stop):null), type);
					}
					//print(newVarName + " = " + memory.get((((Equivalent_typeContext)_localctx).expression!=null?_input.getText(((Equivalent_typeContext)_localctx).expression.start,((Equivalent_typeContext)_localctx).expression.stop):null))); esto ya no se hace, porque simplemente declName es una etiqueta de tipos
				
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
			setState(86); ((Enumeration_typeContext)_localctx).d = declName();
			setState(87); match(23);
			setState(88); ((Enumeration_typeContext)_localctx).a = declName();
			((Enumeration_typeContext)getInvokingContext(4)).cases.add((((Enumeration_typeContext)_localctx).a!=null?_input.getText(((Enumeration_typeContext)_localctx).a.start,((Enumeration_typeContext)_localctx).a.stop):null));
			setState(91);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 2) | (1L << 8) | (1L << 16) | (1L << 19) | (1L << 28) | (1L << 31) | (1L << 39) | (1L << 47) | (1L << NAME) | (1L << NUM) | (1L << SETSTART))) != 0)) {
				{
				setState(90); expression(0);
				}
			}

			setState(101);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==24) {
				{
				{
				setState(93); match(24);
				setState(94); ((Enumeration_typeContext)_localctx).b = declName();
				((Enumeration_typeContext)getInvokingContext(4)).cases.add((((Enumeration_typeContext)_localctx).b!=null?_input.getText(((Enumeration_typeContext)_localctx).b.start,((Enumeration_typeContext)_localctx).b.stop):null));
				setState(97);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 2) | (1L << 8) | (1L << 16) | (1L << 19) | (1L << 28) | (1L << 31) | (1L << 39) | (1L << 47) | (1L << NAME) | (1L << NUM) | (1L << SETSTART))) != 0)) {
					{
					setState(96); expression(0);
					}
				}

				}
				}
				setState(103);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
				
					String internalName = new String();
					while( !((Enumeration_typeContext)getInvokingContext(4)).cases.isEmpty() ){
						String e = (String) ((Enumeration_typeContext)getInvokingContext(4)).cases.remove(0);
						internalName = internalName.concat(e);
						
						memory.put(e,e); //REVISAR!!!
						
						if (!((Enumeration_typeContext)getInvokingContext(4)).cases.isEmpty()){
							internalName = internalName.concat(",");
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
						types.put((((Enumeration_typeContext)_localctx).d!=null?_input.getText(((Enumeration_typeContext)_localctx).d.start,((Enumeration_typeContext)_localctx).d.stop):null), "EnumerationType:" + newVarName);
						print(newVarName + " = {" + internalName + "}");
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
			setState(106); match(NL);
			setState(110);
			_la = _input.LA(1);
			if (_la==NAME) {
				{
				setState(107); declPart();
				setState(108); match(NL);
				}
			}

			setState(112); match(21);
			setState(113); match(NL);
			setState(119);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 2) | (1L << 6) | (1L << 8) | (1L << 16) | (1L << 19) | (1L << 28) | (1L << 31) | (1L << 35) | (1L << 39) | (1L << 47) | (1L << NAME) | (1L << NUM) | (1L << SETSTART))) != 0)) {
				{
				{
				setState(114); predicate(0);
				setState(115); match(NL);
				}
				}
				setState(121);
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
			setState(122); declaration();
			setState(127);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(123);
					_la = _input.LA(1);
					if ( !(_la==44 || _la==NL) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					setState(124); declaration();
					}
					} 
				}
				setState(129);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
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
			setState(130); ((DeclarationContext)_localctx).a = declName();
			((DeclarationContext)getInvokingContext(7)).vars.add((((DeclarationContext)_localctx).a!=null?_input.getText(((DeclarationContext)_localctx).a.start,((DeclarationContext)_localctx).a.stop):null));
			setState(138);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==27) {
				{
				{
				setState(132); match(27);
				setState(133); ((DeclarationContext)_localctx).b = declName();
				((DeclarationContext)getInvokingContext(7)).vars.add((((DeclarationContext)_localctx).b!=null?_input.getText(((DeclarationContext)_localctx).b.start,((DeclarationContext)_localctx).b.stop):null));
				}
				}
				setState(140);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(141); match(29);
			type = "";
			setState(143); ((DeclarationContext)_localctx).expression = expression(0);

					//Para cada variable realizamos el procesamiento
					while( !((DeclarationContext)getInvokingContext(7)).vars.isEmpty() ) {
						String var = (String) ((DeclarationContext)getInvokingContext(7)).vars.remove(0);
						String newVarName = var.substring(0,1).toUpperCase() + var.substring(1).replace("?","");
						if (memory.containsValue(newVarName)) { 
							newVarName = "VAR" + varNumber;
							varNumber++;
						}
						
						memory.put(var, newVarName);
						if (modoSetExpression==1)
							setExpressionVars.add(newVarName); //Falta ver que hacemos para variables ligadas con el mismo nombre en distintas ligaduras
						
						String expType = (String) types.get((((DeclarationContext)_localctx).expression!=null?_input.getText(((DeclarationContext)_localctx).expression.start,((DeclarationContext)_localctx).expression.stop):null));
						types.put(var, expType);
						
						if (!type.equals(""))
							print(type + "(" + newVarName + ")");
						else if (expType != null) {	
							if (expType.equals("\\nat") || expType.equals("\\num"))
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
			setState(146); match(NAME);
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
			setState(208);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				setState(149); match(1);
				setState(150); predicate(18);
				}
				break;

			case 2:
				{
				setState(151); ((PredicateContext)_localctx).e1 = expression(0);
				setState(152); match(33);
				setState(153); match(8);
				setState(154); ((PredicateContext)_localctx).e2 = expression(0);
					String a, b;
						a = (String)memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = (String)memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						print("in_dom(" + a + "," + b + ")");
					
				}
				break;

			case 3:
				{
				setState(157); ((PredicateContext)_localctx).e1 = expression(0);
				setState(158); match(33);
				setState(159); ((PredicateContext)_localctx).e2 = expression(0);

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
				setState(162); ((PredicateContext)_localctx).e1 = expression(0);
				setState(163); match(12);
				setState(164); ((PredicateContext)_localctx).e2 = expression(0);

						String a, b;
						a = (String)memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = (String)memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						print(a + " nin " + b);
					
				}
				break;

			case 5:
				{
				setState(167); ((PredicateContext)_localctx).e1 = expression(0);
				setState(168); match(5);
				setState(169); ((PredicateContext)_localctx).e2 = expression(0);

						String a, b;
						a = (String)memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = (String)memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						print(a + " < " + b);
					
				}
				break;

			case 6:
				{
				setState(172); ((PredicateContext)_localctx).e1 = expression(0);
				setState(173); match(45);
				setState(174); ((PredicateContext)_localctx).e2 = expression(0);

						String a, b;
						a = (String)memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = (String)memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						print(a + " > " + b);
					
				}
				break;

			case 7:
				{
				setState(177); ((PredicateContext)_localctx).e1 = expression(0);
				setState(178); match(18);
				setState(179); ((PredicateContext)_localctx).e2 = expression(0);

						String a, b;
						a = (String)memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = (String)memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						print(a + " =< " + b);
					
				}
				break;

			case 8:
				{
				setState(182); ((PredicateContext)_localctx).e1 = expression(0);
				setState(183); match(22);
				setState(184); ((PredicateContext)_localctx).e2 = expression(0);

						String a, b;
						a = (String)memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = (String)memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						print(a + " =< " + b);
					
				}
				break;

			case 9:
				{
				setState(187); ((PredicateContext)_localctx).e1 = expression(0);
				setState(188); match(17);
				setState(189); ((PredicateContext)_localctx).e2 = expression(0);

						String a, b;
						a = (String)memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = (String)memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						print(a + " = " + b);
					
				}
				break;

			case 10:
				{
				setState(192); ((PredicateContext)_localctx).e1 = expression(0);
				setState(193); match(38);
				setState(194); ((PredicateContext)_localctx).e2 = expression(0);

						String a, b;
						a = (String)memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = (String)memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						print("dsubset(" + a + "," + b + ")");
					
				}
				break;

			case 11:
				{
				setState(197); ((PredicateContext)_localctx).e1 = expression(0);
				setState(198); match(20);
				setState(199); ((PredicateContext)_localctx).e2 = expression(0);

						String a, b;
						a = (String)memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = (String)memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						print(a + " neq " + b);
					
				}
				break;

			case 12:
				{
				setState(202); match(28);
				setState(203); predicate(0);
				setState(204); match(14);
				}
				break;

			case 13:
				{
				setState(206); match(35);
				}
				break;

			case 14:
				{
				setState(207); match(6);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(224);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(222);
					switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
					case 1:
						{
						_localctx = new PredicateContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_predicate);
						setState(210);
						if (!(4 >= _localctx._p)) throw new FailedPredicateException(this, "4 >= $_p");
						setState(211); match(40);
						setState(212); predicate(5);
						}
						break;

					case 2:
						{
						_localctx = new PredicateContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_predicate);
						setState(213);
						if (!(3 >= _localctx._p)) throw new FailedPredicateException(this, "3 >= $_p");
						setState(214); match(43);
						setState(215); predicate(4);
						}
						break;

					case 3:
						{
						_localctx = new PredicateContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_predicate);
						setState(216);
						if (!(2 >= _localctx._p)) throw new FailedPredicateException(this, "2 >= $_p");
						setState(217); match(30);
						setState(218); predicate(3);
						}
						break;

					case 4:
						{
						_localctx = new PredicateContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_predicate);
						setState(219);
						if (!(1 >= _localctx._p)) throw new FailedPredicateException(this, "1 >= $_p");
						setState(220); match(13);
						setState(221); predicate(2);
						}
						break;
					}
					} 
				}
				setState(226);
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
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public int _p;
		public ArrayList setVars = new ArrayList();
		public String internalName = "";
		public String externalName = "";
		public String translatedSet = "";
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
			setState(288);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				setState(228); ((ExpressionContext)_localctx).pre_gen = pre_gen();
				setState(229); ((ExpressionContext)_localctx).e = expression(11);

						String a;
						a = (String)memory.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null));
						
						if ((((ExpressionContext)_localctx).pre_gen!=null?_input.getText(((ExpressionContext)_localctx).pre_gen.start,((ExpressionContext)_localctx).pre_gen.stop):null).equals("\\#")){
							if (memory.get("\\#" + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null)) == null) {
								String newVarName = "VAR" + varNumber;
								varNumber++;
								memory.put("\\#" + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), newVarName);
								print("prolog_call(length(" + a + "," + newVarName + "))");
							}
						}
						else if ((((ExpressionContext)_localctx).pre_gen!=null?_input.getText(((ExpressionContext)_localctx).pre_gen.start,((ExpressionContext)_localctx).pre_gen.stop):null).equals("\\dom")){
							if (memory.get("\\dom" + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null)) == null) {
								String newVarName = "VAR" + varNumber;
								varNumber++;
								memory.put("\\dom" + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), newVarName);
								String e = (String) memory.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null));
								print("dom(" + e + "," + newVarName + ")");
							}
						}
						else if ((((ExpressionContext)_localctx).pre_gen!=null?_input.getText(((ExpressionContext)_localctx).pre_gen.start,((ExpressionContext)_localctx).pre_gen.stop):null).equals("\\ran")){
							if (memory.get("\\ran" + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null)) == null) {
								String newVarName = "VAR" + varNumber;
								varNumber++;
								memory.put("\\ran" + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), newVarName);
								String e = (String) memory.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null));
								print("ran(" + e + "," + newVarName + ")");
							}
						}
						else if ((((ExpressionContext)_localctx).pre_gen!=null?_input.getText(((ExpressionContext)_localctx).pre_gen.start,((ExpressionContext)_localctx).pre_gen.stop):null).equals("\\seq")) {
							type="list";
						}
					
				}
				break;

			case 2:
				{
				setState(232); match(39);
				setState(233); ((ExpressionContext)_localctx).e = expression(8);

						types.put("\\power" + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), "\\power" + types.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null)));
					
				}
				break;

			case 3:
				{
				setState(236); ((ExpressionContext)_localctx).NAME = match(NAME);

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
				setState(238); ((ExpressionContext)_localctx).NUM = match(NUM);

						if (memory.get((((ExpressionContext)_localctx).NUM!=null?((ExpressionContext)_localctx).NUM.getText():null)) == null)
							memory.put((((ExpressionContext)_localctx).NUM!=null?((ExpressionContext)_localctx).NUM.getText():null), (((ExpressionContext)_localctx).NUM!=null?((ExpressionContext)_localctx).NUM.getText():null));
					
				}
				break;

			case 5:
				{
				setState(240); ((ExpressionContext)_localctx).SETSTART = match(SETSTART);
				setState(244);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 2) | (1L << 8) | (1L << 16) | (1L << 19) | (1L << 28) | (1L << 31) | (1L << 39) | (1L << 47) | (1L << NAME) | (1L << NUM) | (1L << SETSTART))) != 0)) {
					{
					setState(241); ((ExpressionContext)_localctx).a = expression(0);
					_localctx.setVars.add((((ExpressionContext)_localctx).a!=null?_input.getText(((ExpressionContext)_localctx).a.start,((ExpressionContext)_localctx).a.stop):null));
					}
				}

				setState(252);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==27) {
					{
					{
					setState(246); match(27);
					setState(247); ((ExpressionContext)_localctx).b = expression(0);
					_localctx.setVars.add((((ExpressionContext)_localctx).b!=null?_input.getText(((ExpressionContext)_localctx).b.start,((ExpressionContext)_localctx).b.stop):null));
					}
					}
					setState(254);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(255); ((ExpressionContext)_localctx).SETEND = match(SETEND);
					
						((ExpressionContext)_localctx).externalName =  (((ExpressionContext)_localctx).SETSTART!=null?((ExpressionContext)_localctx).SETSTART.getText():null);
						//Llenamos _localctx.externalName y ponemos cada expression en la memory
						while( !_localctx.setVars.isEmpty() ){
							String e = (String) _localctx.setVars.remove(0);
							((ExpressionContext)_localctx).externalName =  _localctx.externalName + e;
							//guardamos tambien las traducciones interiores del conjunto
							((ExpressionContext)_localctx).internalName =  _localctx.internalName + (String)memory.get(e);
							
							if (!_localctx.setVars.isEmpty()){
								((ExpressionContext)_localctx).externalName =  _localctx.externalName + ",";
								((ExpressionContext)_localctx).internalName =  _localctx.internalName + ",";
							}
						}
						((ExpressionContext)_localctx).externalName =  _localctx.externalName + (((ExpressionContext)_localctx).SETEND!=null?((ExpressionContext)_localctx).SETEND.getText():null);
						if (memory.get(_localctx.externalName) == null) {
							memory.put(_localctx.externalName, "{" + _localctx.internalName + "}");
						}
					
				}
				break;

			case 6:
				{
				setState(257); ((ExpressionContext)_localctx).SETSTART = match(SETSTART);
				modoSetExpression=1; setExpressionDecl = ""; setExpressionPred = ""; setExpressionExpr = ""; setExpressionVars = new ArrayList();
				setState(259); ((ExpressionContext)_localctx).declPart = declPart();
				((ExpressionContext)_localctx).externalName =  (((ExpressionContext)_localctx).SETSTART!=null?((ExpressionContext)_localctx).SETSTART.getText():null) + (((ExpressionContext)_localctx).declPart!=null?_input.getText(((ExpressionContext)_localctx).declPart.start,((ExpressionContext)_localctx).declPart.stop):null);
				setState(266);
				_la = _input.LA(1);
				if (_la==24) {
					{
					setState(261); match(24);
					modoSetExpression=2;
					setState(263); ((ExpressionContext)_localctx).predicate = predicate(0);
					((ExpressionContext)_localctx).externalName =  _localctx.externalName.concat("|" + (((ExpressionContext)_localctx).predicate!=null?_input.getText(((ExpressionContext)_localctx).predicate.start,((ExpressionContext)_localctx).predicate.stop):null));
					}
				}

				setState(273);
				_la = _input.LA(1);
				if (_la==15) {
					{
					setState(268); match(15);
					modoSetExpression=3;
					setState(270); ((ExpressionContext)_localctx).c = expression(0);
					((ExpressionContext)_localctx).externalName =  _localctx.externalName.concat("@" + (((ExpressionContext)_localctx).c!=null?_input.getText(((ExpressionContext)_localctx).c.start,((ExpressionContext)_localctx).c.stop):null));
					}
				}

				setState(275); ((ExpressionContext)_localctx).SETEND = match(SETEND);
				modoSetExpression=0; ((ExpressionContext)_localctx).externalName =  _localctx.externalName.concat((((ExpressionContext)_localctx).SETEND!=null?((ExpressionContext)_localctx).SETEND.getText():null));

						if (memory.get(_localctx.externalName)==null) {
							((ExpressionContext)_localctx).translatedSet =  "";
							((ExpressionContext)_localctx).newVarName1 =  "VAR" + varNumber;
							varNumber++;
							((ExpressionContext)_localctx).newVarName2 =  "VAR" + varNumber;
							varNumber++;
							
							((ExpressionContext)_localctx).translatedSet =  _localctx.translatedSet.concat("{ " + _localctx.newVarName1 + ":exists([");
							
							while(!setExpressionVars.isEmpty()){
								((ExpressionContext)_localctx).translatedSet =  _localctx.translatedSet.concat((String) setExpressionVars.remove(0));
								if (!setExpressionVars.isEmpty()) ((ExpressionContext)_localctx).translatedSet =  _localctx.translatedSet.concat(",");
							}
						
							((ExpressionContext)_localctx).translatedSet =  _localctx.translatedSet.concat("], " + setExpressionDecl.substring(setExpressionDecl.indexOf('&') + 1) + ")" + setExpressionPred +
						" & " + _localctx.newVarName1 + " is " + memory.get((((ExpressionContext)_localctx).c!=null?_input.getText(((ExpressionContext)_localctx).c.start,((ExpressionContext)_localctx).c.stop):null)) + " }");
						
							memory.put(_localctx.externalName, _localctx.newVarName2);
							print(_localctx.newVarName2 + " = " + _localctx.translatedSet);
						}
					
				}
				break;

			case 7:
				{
				setState(279); match(28);
				setState(280); ((ExpressionContext)_localctx).e = expression(0);
				setState(281); match(14);

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
				setState(284); match(19);
					
						if (memory.get("\\nat") == null) {
							memory.put("\\nat", "NAT");
							print("NAT = int(0, 10000000000)");
							types.put("\\nat", "\\nat");
						}	
					
				}
				break;

			case 9:
				{
				setState(286); match(47);
					
						if (memory.get("\\num") == null) {
							memory.put("\\num", "NUM");
							print("NUM = int(-10000000000, 10000000000)");
							types.put("\\num", "\\num");
						}	
					
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(344);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(342);
					switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(290);
						if (!(18 >= _localctx._p)) throw new FailedPredicateException(this, "18 >= $_p");
						setState(291); match(26);
						setState(292); ((ExpressionContext)_localctx).b = expression(19);

						          		type="is_rel";
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
						setState(295);
						if (!(17 >= _localctx._p)) throw new FailedPredicateException(this, "17 >= $_p");
						setState(296);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==4 || _la==10) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(297); ((ExpressionContext)_localctx).b = expression(18);

						          		type="is_pfun";

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
						setState(300);
						if (!(16 >= _localctx._p)) throw new FailedPredicateException(this, "16 >= $_p");
						setState(301); match(42);
						setState(302); ((ExpressionContext)_localctx).b = expression(17);

						          		type="is_fun";
						          		
						          		//Guardo el tipo
						          		String aType = (String) types.get((((ExpressionContext)_localctx).a!=null?_input.getText(((ExpressionContext)_localctx).a.start,((ExpressionContext)_localctx).a.stop):null));
						          		if (aType.startsWith("BasicType") || aType.startsWith("EnumerationType")) {
						          			System.out.println("jojo");
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
						setState(305);
						if (!(14 >= _localctx._p)) throw new FailedPredicateException(this, "14 >= $_p");
						setState(306); match(49);
						setState(307); ((ExpressionContext)_localctx).e2 = expression(15);

						          		String a, b;
						          		a = (String)memory.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null));
						          		b = (String)memory.get((((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null));
						          		
						          		if (memory.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "~" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null)) == null) {
						          			String newVarName = "VAR" + varNumber;
						          			varNumber++;
						          			memory.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "~" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          			print("apply(" + a + "," + b + "," + newVarName + ")");
						          		}
						          	
						}
						break;

					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(310);
						if (!(13 >= _localctx._p)) throw new FailedPredicateException(this, "13 >= $_p");
						setState(311); match(50);
						setState(312); ((ExpressionContext)_localctx).e2 = expression(14);

						          		String a, b;
						          		a = (String)memory.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null));
						          		b = (String)memory.get((((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null));
						          		memory.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\mapsto" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), "[" + a + "," + b + "]");
						          	
						}
						break;

					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(315);
						if (!(12 >= _localctx._p)) throw new FailedPredicateException(this, "12 >= $_p");
						setState(316); match(9);
						setState(317); ((ExpressionContext)_localctx).e2 = expression(13);

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

					case 7:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(320);
						if (!(10 >= _localctx._p)) throw new FailedPredicateException(this, "10 >= $_p");
						setState(321); ((ExpressionContext)_localctx).IN_FUN_P4 = match(IN_FUN_P4);
						setState(322); ((ExpressionContext)_localctx).e2 = expression(11);

						          		String a, b;
						          		a = (String)memory.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null));
						          		b = (String)memory.get((((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null));
						          		
						          		if (memory.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + (((ExpressionContext)_localctx).IN_FUN_P4!=null?((ExpressionContext)_localctx).IN_FUN_P4.getText():null) + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null)) == null) {
						          		
						          			String newVarName = "VAR" + varNumber;
						          			varNumber++;
						          		
						          			if ((((ExpressionContext)_localctx).IN_FUN_P4!=null?((ExpressionContext)_localctx).IN_FUN_P4.getText():null).equals("*")){
						          				print( newVarName + " is " + a + "*" + b );
						          				memory.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "*" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          			}
						          			else if ((((ExpressionContext)_localctx).IN_FUN_P4!=null?((ExpressionContext)_localctx).IN_FUN_P4.getText():null).equals("\\div")) {
						          				print( newVarName + " is div(" + a + "," + b + ")" );
						          				memory.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\div" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          			}
						          			else if ((((ExpressionContext)_localctx).IN_FUN_P4!=null?((ExpressionContext)_localctx).IN_FUN_P4.getText():null).equals("\\mod")){
						          				print( newVarName + " is mod(" + a + "," + b + ")" );
						          				memory.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\mod" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          			}
						          			else if ((((ExpressionContext)_localctx).IN_FUN_P4!=null?((ExpressionContext)_localctx).IN_FUN_P4.getText():null).equals("\\cap")){
						          					print("dinters(" + a + "," + b + "," + newVarName + ")");
						          					memory.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\cap" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          			}
						          		}
						          	
						}
						break;

					case 8:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(325);
						if (!(9 >= _localctx._p)) throw new FailedPredicateException(this, "9 >= $_p");
						setState(326); ((ExpressionContext)_localctx).IN_FUN_P3 = match(IN_FUN_P3);
						setState(327); ((ExpressionContext)_localctx).e2 = expression(10);

						          		String a, b;
						          		a = (String)memory.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null));
						          		b = (String)memory.get((((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null));
						          		
						          		if (memory.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + (((ExpressionContext)_localctx).IN_FUN_P3!=null?((ExpressionContext)_localctx).IN_FUN_P3.getText():null) + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null)) == null) {
						          		
						          			String newVarName = "VAR" + varNumber;
						          			varNumber++;
						          		
						          			if ((((ExpressionContext)_localctx).IN_FUN_P3!=null?((ExpressionContext)_localctx).IN_FUN_P3.getText():null).equals("+")){
						          				print( newVarName + " is " + a + "+" + b );
						          				memory.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "+" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          			}
						          			else if ((((ExpressionContext)_localctx).IN_FUN_P3!=null?((ExpressionContext)_localctx).IN_FUN_P3.getText():null).equals("-")) {
						          				print( newVarName + " is " + a + "-" + b );
						          				memory.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "-" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          			}
						          			else if ((((ExpressionContext)_localctx).IN_FUN_P3!=null?((ExpressionContext)_localctx).IN_FUN_P3.getText():null).equals("\\cup")){
						          					print("dunion(" + a + "," + b + "," + newVarName + ")");
						          					memory.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\cup" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          			}
						          		}
						          	
						}
						break;

					case 9:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(330);
						if (!(15 >= _localctx._p)) throw new FailedPredicateException(this, "15 >= $_p");
						((ExpressionContext)getInvokingContext(10)).setVars.add((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null));
						setState(336); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(332); match(34);
								setState(333); ((ExpressionContext)_localctx).e2 = expression(0);
								((ExpressionContext)getInvokingContext(10)).setVars.add((((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null));
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(338); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
						} while ( _alt!=2 && _alt!=-1 );

						          		//Para cada exp realizamos el procesamiento
						          		while( !((ExpressionContext)getInvokingContext(10)).setVars.isEmpty() ) {
						          			String exp = (String) ((ExpressionContext)getInvokingContext(10)).setVars.remove(0);
						          			
						          			((ExpressionContext)_localctx).internalName =  _localctx.internalName.concat(exp);
						          			
						          			String type = (String) types.get(exp);
						          			if (type.startsWith("BasicType") || type.startsWith("EnumerationType"))
						          				((ExpressionContext)_localctx).externalName =  _localctx.externalName.concat(exp);
						          			else
						          				((ExpressionContext)_localctx).externalName =  _localctx.externalName.concat(type);
						          				
						          			if (!((ExpressionContext)getInvokingContext(10)).setVars.isEmpty()) {
						          				((ExpressionContext)_localctx).internalName =  _localctx.internalName.concat("\\cross");
						          				((ExpressionContext)_localctx).externalName =  _localctx.externalName.concat("\\cross");
						          			}
						          		}
						          		
						          		types.put(_localctx.internalName, _localctx.externalName);
						          	
						}
						break;
					}
					} 
				}
				setState(346);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
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
			setState(347);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 2) | (1L << 8) | (1L << 16) | (1L << 31))) != 0)) ) {
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
		case 4: return 18 >= _localctx._p;

		case 5: return 17 >= _localctx._p;

		case 6: return 16 >= _localctx._p;

		case 7: return 14 >= _localctx._p;

		case 8: return 13 >= _localctx._p;

		case 9: return 12 >= _localctx._p;

		case 10: return 10 >= _localctx._p;

		case 11: return 9 >= _localctx._p;

		case 12: return 15 >= _localctx._p;
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
		"\2\3=\u0160\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4"+
		"\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\3\2\3\2\7\2\35\n\2\f\2\16\2 "+
		"\13\2\6\2\"\n\2\r\2\16\2#\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\39\n\3\3\3\3\3\6\3=\n\3\r\3\16\3>\3"+
		"\3\3\3\5\3C\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4L\n\4\f\4\16\4O\13\4\3"+
		"\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\5\6^\n\6\3\6\3\6\3"+
		"\6\3\6\5\6d\n\6\7\6f\n\6\f\6\16\6i\13\6\3\6\3\6\3\7\3\7\3\7\3\7\5\7q\n"+
		"\7\3\7\3\7\3\7\3\7\3\7\7\7x\n\7\f\7\16\7{\13\7\3\b\3\b\3\b\7\b\u0080\n"+
		"\b\f\b\16\b\u0083\13\b\3\t\3\t\3\t\3\t\3\t\3\t\7\t\u008b\n\t\f\t\16\t"+
		"\u008e\13\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u00d3"+
		"\n\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\7\13"+
		"\u00e1\n\13\f\13\16\13\u00e4\13\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00f7\n\f\3\f\3\f\3\f\3\f\7\f\u00fd"+
		"\n\f\f\f\16\f\u0100\13\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5"+
		"\f\u010d\n\f\3\f\3\f\3\f\3\f\3\f\5\f\u0114\n\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u0123\n\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\6\f\u0153\n\f\r\f\16\f\u0154\3\f\3\f\7\f\u0159\n\f\f"+
		"\f\16\f\u015c\13\f\3\r\3\r\3\r\2\16\2\4\6\b\n\f\16\20\22\24\26\30\2\5"+
		"\4..99\4\6\6\f\f\6\4\4\n\n\22\22!!\u0189\2!\3\2\2\2\4B\3\2\2\2\6D\3\2"+
		"\2\2\bS\3\2\2\2\nX\3\2\2\2\fl\3\2\2\2\16|\3\2\2\2\20\u0084\3\2\2\2\22"+
		"\u0094\3\2\2\2\24\u00d2\3\2\2\2\26\u0122\3\2\2\2\30\u015d\3\2\2\2\32\36"+
		"\5\4\3\2\33\35\79\2\2\34\33\3\2\2\2\35 \3\2\2\2\36\34\3\2\2\2\36\37\3"+
		"\2\2\2\37\"\3\2\2\2 \36\3\2\2\2!\32\3\2\2\2\"#\3\2\2\2#!\3\2\2\2#$\3\2"+
		"\2\2$%\3\2\2\2%&\b\2\1\2&\3\3\2\2\2\'(\7\'\2\2()\7\65\2\2)*\7\r\2\2*+"+
		"\5\f\7\2+,\7\t\2\2,C\3\2\2\2-.\7&\2\2./\79\2\2/\60\5\16\b\2\60\61\79\2"+
		"\2\61\62\7+\2\2\62C\3\2\2\2\63\64\7\60\2\2\64<\79\2\2\659\5\6\4\2\669"+
		"\5\b\5\2\679\5\n\6\28\65\3\2\2\28\66\3\2\2\28\67\3\2\2\29:\3\2\2\2:;\7"+
		"9\2\2;=\3\2\2\2<8\3\2\2\2=>\3\2\2\2><\3\2\2\2>?\3\2\2\2?@\3\2\2\2@A\7"+
		"\"\2\2AC\3\2\2\2B\'\3\2\2\2B-\3\2\2\2B\63\3\2\2\2C\5\3\2\2\2DE\7\5\2\2"+
		"EF\5\22\n\2FM\b\4\1\2GH\7\35\2\2HI\5\22\n\2IJ\b\4\1\2JL\3\2\2\2KG\3\2"+
		"\2\2LO\3\2\2\2MK\3\2\2\2MN\3\2\2\2NP\3\2\2\2OM\3\2\2\2PQ\7\33\2\2QR\b"+
		"\4\1\2R\7\3\2\2\2ST\5\22\n\2TU\7\62\2\2UV\5\26\f\2VW\b\5\1\2W\t\3\2\2"+
		"\2XY\5\22\n\2YZ\7\31\2\2Z[\5\22\n\2[]\b\6\1\2\\^\5\26\f\2]\\\3\2\2\2]"+
		"^\3\2\2\2^g\3\2\2\2_`\7\32\2\2`a\5\22\n\2ac\b\6\1\2bd\5\26\f\2cb\3\2\2"+
		"\2cd\3\2\2\2df\3\2\2\2e_\3\2\2\2fi\3\2\2\2ge\3\2\2\2gh\3\2\2\2hj\3\2\2"+
		"\2ig\3\2\2\2jk\b\6\1\2k\13\3\2\2\2lp\79\2\2mn\5\16\b\2no\79\2\2oq\3\2"+
		"\2\2pm\3\2\2\2pq\3\2\2\2qr\3\2\2\2rs\7\27\2\2sy\79\2\2tu\5\24\13\2uv\7"+
		"9\2\2vx\3\2\2\2wt\3\2\2\2x{\3\2\2\2yw\3\2\2\2yz\3\2\2\2z\r\3\2\2\2{y\3"+
		"\2\2\2|\u0081\5\20\t\2}~\t\2\2\2~\u0080\5\20\t\2\177}\3\2\2\2\u0080\u0083"+
		"\3\2\2\2\u0081\177\3\2\2\2\u0081\u0082\3\2\2\2\u0082\17\3\2\2\2\u0083"+
		"\u0081\3\2\2\2\u0084\u0085\5\22\n\2\u0085\u008c\b\t\1\2\u0086\u0087\7"+
		"\35\2\2\u0087\u0088\5\22\n\2\u0088\u0089\b\t\1\2\u0089\u008b\3\2\2\2\u008a"+
		"\u0086\3\2\2\2\u008b\u008e\3\2\2\2\u008c\u008a\3\2\2\2\u008c\u008d\3\2"+
		"\2\2\u008d\u008f\3\2\2\2\u008e\u008c\3\2\2\2\u008f\u0090\7\37\2\2\u0090"+
		"\u0091\b\t\1\2\u0091\u0092\5\26\f\2\u0092\u0093\b\t\1\2\u0093\21\3\2\2"+
		"\2\u0094\u0095\7\65\2\2\u0095\23\3\2\2\2\u0096\u0097\b\13\1\2\u0097\u0098"+
		"\7\3\2\2\u0098\u00d3\5\24\13\2\u0099\u009a\5\26\f\2\u009a\u009b\7#\2\2"+
		"\u009b\u009c\7\n\2\2\u009c\u009d\5\26\f\2\u009d\u009e\b\13\1\2\u009e\u00d3"+
		"\3\2\2\2\u009f\u00a0\5\26\f\2\u00a0\u00a1\7#\2\2\u00a1\u00a2\5\26\f\2"+
		"\u00a2\u00a3\b\13\1\2\u00a3\u00d3\3\2\2\2\u00a4\u00a5\5\26\f\2\u00a5\u00a6"+
		"\7\16\2\2\u00a6\u00a7\5\26\f\2\u00a7\u00a8\b\13\1\2\u00a8\u00d3\3\2\2"+
		"\2\u00a9\u00aa\5\26\f\2\u00aa\u00ab\7\7\2\2\u00ab\u00ac\5\26\f\2\u00ac"+
		"\u00ad\b\13\1\2\u00ad\u00d3\3\2\2\2\u00ae\u00af\5\26\f\2\u00af\u00b0\7"+
		"/\2\2\u00b0\u00b1\5\26\f\2\u00b1\u00b2\b\13\1\2\u00b2\u00d3\3\2\2\2\u00b3"+
		"\u00b4\5\26\f\2\u00b4\u00b5\7\24\2\2\u00b5\u00b6\5\26\f\2\u00b6\u00b7"+
		"\b\13\1\2\u00b7\u00d3\3\2\2\2\u00b8\u00b9\5\26\f\2\u00b9\u00ba\7\30\2"+
		"\2\u00ba\u00bb\5\26\f\2\u00bb\u00bc\b\13\1\2\u00bc\u00d3\3\2\2\2\u00bd"+
		"\u00be\5\26\f\2\u00be\u00bf\7\23\2\2\u00bf\u00c0\5\26\f\2\u00c0\u00c1"+
		"\b\13\1\2\u00c1\u00d3\3\2\2\2\u00c2\u00c3\5\26\f\2\u00c3\u00c4\7(\2\2"+
		"\u00c4\u00c5\5\26\f\2\u00c5\u00c6\b\13\1\2\u00c6\u00d3\3\2\2\2\u00c7\u00c8"+
		"\5\26\f\2\u00c8\u00c9\7\26\2\2\u00c9\u00ca\5\26\f\2\u00ca\u00cb\b\13\1"+
		"\2\u00cb\u00d3\3\2\2\2\u00cc\u00cd\7\36\2\2\u00cd\u00ce\5\24\13\2\u00ce"+
		"\u00cf\7\20\2\2\u00cf\u00d3\3\2\2\2\u00d0\u00d3\7%\2\2\u00d1\u00d3\7\b"+
		"\2\2\u00d2\u0096\3\2\2\2\u00d2\u0099\3\2\2\2\u00d2\u009f\3\2\2\2\u00d2"+
		"\u00a4\3\2\2\2\u00d2\u00a9\3\2\2\2\u00d2\u00ae\3\2\2\2\u00d2\u00b3\3\2"+
		"\2\2\u00d2\u00b8\3\2\2\2\u00d2\u00bd\3\2\2\2\u00d2\u00c2\3\2\2\2\u00d2"+
		"\u00c7\3\2\2\2\u00d2\u00cc\3\2\2\2\u00d2\u00d0\3\2\2\2\u00d2\u00d1\3\2"+
		"\2\2\u00d3\u00e2\3\2\2\2\u00d4\u00d5\6\13\2\3\u00d5\u00d6\7*\2\2\u00d6"+
		"\u00e1\5\24\13\2\u00d7\u00d8\6\13\3\3\u00d8\u00d9\7-\2\2\u00d9\u00e1\5"+
		"\24\13\2\u00da\u00db\6\13\4\3\u00db\u00dc\7 \2\2\u00dc\u00e1\5\24\13\2"+
		"\u00dd\u00de\6\13\5\3\u00de\u00df\7\17\2\2\u00df\u00e1\5\24\13\2\u00e0"+
		"\u00d4\3\2\2\2\u00e0\u00d7\3\2\2\2\u00e0\u00da\3\2\2\2\u00e0\u00dd\3\2"+
		"\2\2\u00e1\u00e4\3\2\2\2\u00e2\u00e0\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3"+
		"\25\3\2\2\2\u00e4\u00e2\3\2\2\2\u00e5\u00e6\b\f\1\2\u00e6\u00e7\5\30\r"+
		"\2\u00e7\u00e8\5\26\f\2\u00e8\u00e9\b\f\1\2\u00e9\u0123\3\2\2\2\u00ea"+
		"\u00eb\7)\2\2\u00eb\u00ec\5\26\f\2\u00ec\u00ed\b\f\1\2\u00ed\u0123\3\2"+
		"\2\2\u00ee\u00ef\7\65\2\2\u00ef\u0123\b\f\1\2\u00f0\u00f1\7\66\2\2\u00f1"+
		"\u0123\b\f\1\2\u00f2\u00f6\7;\2\2\u00f3\u00f4\5\26\f\2\u00f4\u00f5\b\f"+
		"\1\2\u00f5\u00f7\3\2\2\2\u00f6\u00f3\3\2\2\2\u00f6\u00f7\3\2\2\2\u00f7"+
		"\u00fe\3\2\2\2\u00f8\u00f9\7\35\2\2\u00f9\u00fa\5\26\f\2\u00fa\u00fb\b"+
		"\f\1\2\u00fb\u00fd\3\2\2\2\u00fc\u00f8\3\2\2\2\u00fd\u0100\3\2\2\2\u00fe"+
		"\u00fc\3\2\2\2\u00fe\u00ff\3\2\2\2\u00ff\u0101\3\2\2\2\u0100\u00fe\3\2"+
		"\2\2\u0101\u0102\7<\2\2\u0102\u0123\b\f\1\2\u0103\u0104\7;\2\2\u0104\u0105"+
		"\b\f\1\2\u0105\u0106\5\16\b\2\u0106\u010c\b\f\1\2\u0107\u0108\7\32\2\2"+
		"\u0108\u0109\b\f\1\2\u0109\u010a\5\24\13\2\u010a\u010b\b\f\1\2\u010b\u010d"+
		"\3\2\2\2\u010c\u0107\3\2\2\2\u010c\u010d\3\2\2\2\u010d\u0113\3\2\2\2\u010e"+
		"\u010f\7\21\2\2\u010f\u0110\b\f\1\2\u0110\u0111\5\26\f\2\u0111\u0112\b"+
		"\f\1\2\u0112\u0114\3\2\2\2\u0113\u010e\3\2\2\2\u0113\u0114\3\2\2\2\u0114"+
		"\u0115\3\2\2\2\u0115\u0116\7<\2\2\u0116\u0117\b\f\1\2\u0117\u0118\b\f"+
		"\1\2\u0118\u0123\3\2\2\2\u0119\u011a\7\36\2\2\u011a\u011b\5\26\f\2\u011b"+
		"\u011c\7\20\2\2\u011c\u011d\b\f\1\2\u011d\u0123\3\2\2\2\u011e\u011f\7"+
		"\25\2\2\u011f\u0123\b\f\1\2\u0120\u0121\7\61\2\2\u0121\u0123\b\f\1\2\u0122"+
		"\u00e5\3\2\2\2\u0122\u00ea\3\2\2\2\u0122\u00ee\3\2\2\2\u0122\u00f0\3\2"+
		"\2\2\u0122\u00f2\3\2\2\2\u0122\u0103\3\2\2\2\u0122\u0119\3\2\2\2\u0122"+
		"\u011e\3\2\2\2\u0122\u0120\3\2\2\2\u0123\u015a\3\2\2\2\u0124\u0125\6\f"+
		"\6\3\u0125\u0126\7\34\2\2\u0126\u0127\5\26\f\2\u0127\u0128\b\f\1\2\u0128"+
		"\u0159\3\2\2\2\u0129\u012a\6\f\7\3\u012a\u012b\t\3\2\2\u012b\u012c\5\26"+
		"\f\2\u012c\u012d\b\f\1\2\u012d\u0159\3\2\2\2\u012e\u012f\6\f\b\3\u012f"+
		"\u0130\7,\2\2\u0130\u0131\5\26\f\2\u0131\u0132\b\f\1\2\u0132\u0159\3\2"+
		"\2\2\u0133\u0134\6\f\t\3\u0134\u0135\7\63\2\2\u0135\u0136\5\26\f\2\u0136"+
		"\u0137\b\f\1\2\u0137\u0159\3\2\2\2\u0138\u0139\6\f\n\3\u0139\u013a\7\64"+
		"\2\2\u013a\u013b\5\26\f\2\u013b\u013c\b\f\1\2\u013c\u0159\3\2\2\2\u013d"+
		"\u013e\6\f\13\3\u013e\u013f\7\13\2\2\u013f\u0140\5\26\f\2\u0140\u0141"+
		"\b\f\1\2\u0141\u0159\3\2\2\2\u0142\u0143\6\f\f\3\u0143\u0144\78\2\2\u0144"+
		"\u0145\5\26\f\2\u0145\u0146\b\f\1\2\u0146\u0159\3\2\2\2\u0147\u0148\6"+
		"\f\r\3\u0148\u0149\7\67\2\2\u0149\u014a\5\26\f\2\u014a\u014b\b\f\1\2\u014b"+
		"\u0159\3\2\2\2\u014c\u014d\6\f\16\3\u014d\u0152\b\f\1\2\u014e\u014f\7"+
		"$\2\2\u014f\u0150\5\26\f\2\u0150\u0151\b\f\1\2\u0151\u0153\3\2\2\2\u0152"+
		"\u014e\3\2\2\2\u0153\u0154\3\2\2\2\u0154\u0152\3\2\2\2\u0154\u0155\3\2"+
		"\2\2\u0155\u0156\3\2\2\2\u0156\u0157\b\f\1\2\u0157\u0159\3\2\2\2\u0158"+
		"\u0124\3\2\2\2\u0158\u0129\3\2\2\2\u0158\u012e\3\2\2\2\u0158\u0133\3\2"+
		"\2\2\u0158\u0138\3\2\2\2\u0158\u013d\3\2\2\2\u0158\u0142\3\2\2\2\u0158"+
		"\u0147\3\2\2\2\u0158\u014c\3\2\2\2\u0159\u015c\3\2\2\2\u015a\u0158\3\2"+
		"\2\2\u015a\u015b\3\2\2\2\u015b\27\3\2\2\2\u015c\u015a\3\2\2\2\u015d\u015e"+
		"\t\4\2\2\u015e\31\3\2\2\2\32\36#8>BM]cgpy\u0081\u008c\u00d2\u00e0\u00e2"+
		"\u00f6\u00fe\u010c\u0113\u0122\u0154\u0158\u015a";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}