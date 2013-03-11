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
		T__48=1, T__47=2, T__46=3, T__45=4, T__44=5, T__43=6, T__42=7, T__41=8, 
		T__40=9, T__39=10, T__38=11, T__37=12, T__36=13, T__35=14, T__34=15, T__33=16, 
		T__32=17, T__31=18, T__30=19, T__29=20, T__28=21, T__27=22, T__26=23, 
		T__25=24, T__24=25, T__23=26, T__22=27, T__21=28, T__20=29, T__19=30, 
		T__18=31, T__17=32, T__16=33, T__15=34, T__14=35, T__13=36, T__12=37, 
		T__11=38, T__10=39, T__9=40, T__8=41, T__7=42, T__6=43, T__5=44, T__4=45, 
		T__3=46, T__2=47, T__1=48, T__0=49, NAME=50, NUM=51, IN_FUN_P3=52, IN_FUN_P4=53, 
		NL=54, WS=55, SETSTART=56, SETEND=57, SKIP=58;
	public static final String[] tokenNames = {
		"<INVALID>", "'\\lnot'", "']'", "'\\#'", "','", "'\\rel'", "'['", "':'", 
		"'('", "'<'", "'\\pfun'", "'false'", "'\\lor'", "'\\dom'", "'\\end{schema}'", 
		"'\\end{zed}'", "'\\ran'", "'\\upto'", "'\\in'", "'\\ffun'", "'}'", "'\\begin{schema}{'", 
		"'\\begin{axdef}'", "'true'", "'\\notin'", "'\\subset'", "'\\power'", 
		"')'", "'\\iff'", "'\\land'", "'\\end{axdef}'", "'@'", "'\\implies'", 
		"'\\fun'", "'\\seq'", "'='", "'\\leq'", "';'", "'\\neq'", "'\\nat'", "'>'", 
		"'\\geq'", "'\\where'", "'\\begin{zed}'", "'\\num'", "'=='", "'~'", "'::='", 
		"'|'", "'\\mapsto'", "NAME", "NUM", "IN_FUN_P3", "IN_FUN_P4", "NL", "WS", 
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

		public void print(String c) {
			if (modoSetExpression == 0) 
				/*System.out.println(c + " &");*/salida = salida.concat(c + " &");
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
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 21) | (1L << 22) | (1L << 43))) != 0) );
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
			setState(62);
			switch (_input.LA(1)) {
			case 21:
				enterOuterAlt(_localctx, 1);
				{
				setState(35); match(21);
				setState(36); match(NAME);
				setState(37); match(20);
				setState(38); schemaText();
				setState(39); match(14);
				}
				break;
			case 22:
				enterOuterAlt(_localctx, 2);
				{
				setState(41); match(22);
				setState(42); match(NL);
				setState(43); declPart();
				setState(44); match(NL);
				setState(45); match(30);
				}
				break;
			case 43:
				enterOuterAlt(_localctx, 3);
				{
				setState(47); match(43);
				setState(48); match(NL);
				setState(56); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(52);
					switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
					case 1:
						{
						setState(49); basic_type();
						}
						break;

					case 2:
						{
						setState(50); equivalent_type();
						}
						break;

					case 3:
						{
						setState(51); enumeration_type();
						}
						break;
					}
					setState(54); match(NL);
					}
					}
					setState(58); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==6 || _la==NAME );
				setState(60); match(15);
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
			setState(64); match(6);
			setState(65); ((Basic_typeContext)_localctx).a = declName();
			((Basic_typeContext)getInvokingContext(2)).typeList.add((((Basic_typeContext)_localctx).a!=null?_input.getText(((Basic_typeContext)_localctx).a.start,((Basic_typeContext)_localctx).a.stop):null));
			setState(73);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==4) {
				{
				{
				setState(67); match(4);
				setState(68); ((Basic_typeContext)_localctx).b = declName();
				((Basic_typeContext)getInvokingContext(2)).typeList.add((((Basic_typeContext)_localctx).b!=null?_input.getText(((Basic_typeContext)_localctx).b.start,((Basic_typeContext)_localctx).b.stop):null));
				}
				}
				setState(75);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(76); match(2);

					while( !((Basic_typeContext)getInvokingContext(2)).typeList.isEmpty() ) {
						String type = (String) ((Basic_typeContext)getInvokingContext(2)).typeList.remove(0);
						types.put(type, "BasicType");
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
			setState(79); declName();
			setState(80); match(45);
			setState(81); expression(0);
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
			setState(83); ((Enumeration_typeContext)_localctx).d = declName();
			setState(84); match(47);
			setState(85); ((Enumeration_typeContext)_localctx).a = declName();
			((Enumeration_typeContext)getInvokingContext(4)).cases.add((((Enumeration_typeContext)_localctx).a!=null?_input.getText(((Enumeration_typeContext)_localctx).a.start,((Enumeration_typeContext)_localctx).a.stop):null));
			setState(88);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 3) | (1L << 8) | (1L << 13) | (1L << 16) | (1L << 26) | (1L << 34) | (1L << 39) | (1L << 44) | (1L << NAME) | (1L << NUM) | (1L << SETSTART))) != 0)) {
				{
				setState(87); expression(0);
				}
			}

			setState(98);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==48) {
				{
				{
				setState(90); match(48);
				setState(91); ((Enumeration_typeContext)_localctx).b = declName();
				((Enumeration_typeContext)getInvokingContext(4)).cases.add((((Enumeration_typeContext)_localctx).b!=null?_input.getText(((Enumeration_typeContext)_localctx).b.start,((Enumeration_typeContext)_localctx).b.stop):null));
				setState(94);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 3) | (1L << 8) | (1L << 13) | (1L << 16) | (1L << 26) | (1L << 34) | (1L << 39) | (1L << 44) | (1L << NAME) | (1L << NUM) | (1L << SETSTART))) != 0)) {
					{
					setState(93); expression(0);
					}
				}

				}
				}
				setState(100);
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
			setState(103); match(NL);
			setState(107);
			_la = _input.LA(1);
			if (_la==NAME) {
				{
				setState(104); declPart();
				setState(105); match(NL);
				}
			}

			setState(109); match(42);
			setState(110); match(NL);
			setState(116);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 3) | (1L << 8) | (1L << 11) | (1L << 13) | (1L << 16) | (1L << 23) | (1L << 26) | (1L << 34) | (1L << 39) | (1L << 44) | (1L << NAME) | (1L << NUM) | (1L << SETSTART))) != 0)) {
				{
				{
				setState(111); predicate(0);
				setState(112); match(NL);
				}
				}
				setState(118);
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
			setState(119); declaration();
			setState(124);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(120);
					_la = _input.LA(1);
					if ( !(_la==37 || _la==NL) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					setState(121); declaration();
					}
					} 
				}
				setState(126);
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
			setState(127); ((DeclarationContext)_localctx).a = declName();
			((DeclarationContext)getInvokingContext(7)).vars.add((((DeclarationContext)_localctx).a!=null?_input.getText(((DeclarationContext)_localctx).a.start,((DeclarationContext)_localctx).a.stop):null));
			setState(135);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==4) {
				{
				{
				setState(129); match(4);
				setState(130); ((DeclarationContext)_localctx).b = declName();
				((DeclarationContext)getInvokingContext(7)).vars.add((((DeclarationContext)_localctx).b!=null?_input.getText(((DeclarationContext)_localctx).b.start,((DeclarationContext)_localctx).b.stop):null));
				}
				}
				setState(137);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(138); match(7);
			type = "";
			setState(140); ((DeclarationContext)_localctx).expression = expression(0);

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
						
						if (!type.equals(""))
							print(type + "(" + newVarName + ")");
						else if (((((DeclarationContext)_localctx).expression!=null?_input.getText(((DeclarationContext)_localctx).expression.start,((DeclarationContext)_localctx).expression.stop):null).equals("\\nat")) || ((((DeclarationContext)_localctx).expression!=null?_input.getText(((DeclarationContext)_localctx).expression.start,((DeclarationContext)_localctx).expression.stop):null).equals("\\num")))
							print(newVarName + " in " + ((String) memory.get((((DeclarationContext)_localctx).expression!=null?_input.getText(((DeclarationContext)_localctx).expression.start,((DeclarationContext)_localctx).expression.stop):null))));
						else if (((String) types.get((((DeclarationContext)_localctx).expression!=null?_input.getText(((DeclarationContext)_localctx).expression.start,((DeclarationContext)_localctx).expression.stop):null))).equals("BasicType")) {
							print("set(" + (((DeclarationContext)_localctx).expression!=null?_input.getText(((DeclarationContext)_localctx).expression.start,((DeclarationContext)_localctx).expression.stop):null) + ")"); //Falta poner mayusculas
							print(newVarName + " in " + (((DeclarationContext)_localctx).expression!=null?_input.getText(((DeclarationContext)_localctx).expression.start,((DeclarationContext)_localctx).expression.stop):null)); //Falta poner mayusculas
						}
						else if (((String) (types.get((((DeclarationContext)_localctx).expression!=null?_input.getText(((DeclarationContext)_localctx).expression.start,((DeclarationContext)_localctx).expression.stop):null)))).startsWith("EnumerationType:"))
							print(newVarName + " in " + ((String) types.get((((DeclarationContext)_localctx).expression!=null?_input.getText(((DeclarationContext)_localctx).expression.start,((DeclarationContext)_localctx).expression.stop):null))).substring(16));

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
			setState(143); match(NAME);
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
			setState(205);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				setState(146); match(1);
				setState(147); predicate(18);
				}
				break;

			case 2:
				{
				setState(148); ((PredicateContext)_localctx).e1 = expression(0);
				setState(149); match(18);
				setState(150); match(13);
				setState(151); ((PredicateContext)_localctx).e2 = expression(0);
					String a, b;
						a = (String)memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = (String)memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						print("in_dom(" + a + "," + b + ")");
					
				}
				break;

			case 3:
				{
				setState(154); ((PredicateContext)_localctx).e1 = expression(0);
				setState(155); match(18);
				setState(156); ((PredicateContext)_localctx).e2 = expression(0);

						String a, b;
						a = (String)memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = (String)memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						print(a + " in " + b);
					
				}
				break;

			case 4:
				{
				setState(159); ((PredicateContext)_localctx).e1 = expression(0);
				setState(160); match(24);
				setState(161); ((PredicateContext)_localctx).e2 = expression(0);

						String a, b;
						a = (String)memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = (String)memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						print(a + " nin " + b);
					
				}
				break;

			case 5:
				{
				setState(164); ((PredicateContext)_localctx).e1 = expression(0);
				setState(165); match(9);
				setState(166); ((PredicateContext)_localctx).e2 = expression(0);

						String a, b;
						a = (String)memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = (String)memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						print(a + " < " + b);
					
				}
				break;

			case 6:
				{
				setState(169); ((PredicateContext)_localctx).e1 = expression(0);
				setState(170); match(40);
				setState(171); ((PredicateContext)_localctx).e2 = expression(0);

						String a, b;
						a = (String)memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = (String)memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						print(a + " > " + b);
					
				}
				break;

			case 7:
				{
				setState(174); ((PredicateContext)_localctx).e1 = expression(0);
				setState(175); match(36);
				setState(176); ((PredicateContext)_localctx).e2 = expression(0);

						String a, b;
						a = (String)memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = (String)memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						print(a + " =< " + b);
					
				}
				break;

			case 8:
				{
				setState(179); ((PredicateContext)_localctx).e1 = expression(0);
				setState(180); match(41);
				setState(181); ((PredicateContext)_localctx).e2 = expression(0);

						String a, b;
						a = (String)memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = (String)memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						print(a + " =< " + b);
					
				}
				break;

			case 9:
				{
				setState(184); ((PredicateContext)_localctx).e1 = expression(0);
				setState(185); match(35);
				setState(186); ((PredicateContext)_localctx).e2 = expression(0);

						String a, b;
						a = (String)memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = (String)memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						print(a + " = " + b);
					
				}
				break;

			case 10:
				{
				setState(189); ((PredicateContext)_localctx).e1 = expression(0);
				setState(190); match(25);
				setState(191); ((PredicateContext)_localctx).e2 = expression(0);

						String a, b;
						a = (String)memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = (String)memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						print("dsubset(" + a + "," + b + ")");
					
				}
				break;

			case 11:
				{
				setState(194); ((PredicateContext)_localctx).e1 = expression(0);
				setState(195); match(38);
				setState(196); ((PredicateContext)_localctx).e2 = expression(0);

						String a, b;
						a = (String)memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = (String)memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						print(a + " neq " + b);
					
				}
				break;

			case 12:
				{
				setState(199); match(8);
				setState(200); predicate(0);
				setState(201); match(27);
				}
				break;

			case 13:
				{
				setState(203); match(23);
				}
				break;

			case 14:
				{
				setState(204); match(11);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(221);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(219);
					switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
					case 1:
						{
						_localctx = new PredicateContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_predicate);
						setState(207);
						if (!(4 >= _localctx._p)) throw new FailedPredicateException(this, "4 >= $_p");
						setState(208); match(28);
						setState(209); predicate(5);
						}
						break;

					case 2:
						{
						_localctx = new PredicateContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_predicate);
						setState(210);
						if (!(3 >= _localctx._p)) throw new FailedPredicateException(this, "3 >= $_p");
						setState(211); match(32);
						setState(212); predicate(4);
						}
						break;

					case 3:
						{
						_localctx = new PredicateContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_predicate);
						setState(213);
						if (!(2 >= _localctx._p)) throw new FailedPredicateException(this, "2 >= $_p");
						setState(214); match(12);
						setState(215); predicate(3);
						}
						break;

					case 4:
						{
						_localctx = new PredicateContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_predicate);
						setState(216);
						if (!(1 >= _localctx._p)) throw new FailedPredicateException(this, "1 >= $_p");
						setState(217); match(29);
						setState(218); predicate(2);
						}
						break;
					}
					} 
				}
				setState(223);
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
		public ExpressionContext e1;
		public Pre_genContext pre_gen;
		public ExpressionContext e;
		public Token NAME;
		public Token NUM;
		public Token SETSTART;
		public ExpressionContext a;
		public ExpressionContext b;
		public Token SETEND;
		public DeclPartContext declPart;
		public PredicateContext predicate;
		public ExpressionContext c;
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
			setState(283);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				setState(225); ((ExpressionContext)_localctx).pre_gen = pre_gen();
				setState(226); ((ExpressionContext)_localctx).e = expression(11);

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
				setState(229); match(26);
				setState(230); expression(8);
				}
				break;

			case 3:
				{
				setState(231); ((ExpressionContext)_localctx).NAME = match(NAME);

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
				setState(233); ((ExpressionContext)_localctx).NUM = match(NUM);

						if (memory.get((((ExpressionContext)_localctx).NUM!=null?((ExpressionContext)_localctx).NUM.getText():null)) == null)
							memory.put((((ExpressionContext)_localctx).NUM!=null?((ExpressionContext)_localctx).NUM.getText():null), (((ExpressionContext)_localctx).NUM!=null?((ExpressionContext)_localctx).NUM.getText():null));
					
				}
				break;

			case 5:
				{
				setState(235); ((ExpressionContext)_localctx).SETSTART = match(SETSTART);
				setState(239);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 3) | (1L << 8) | (1L << 13) | (1L << 16) | (1L << 26) | (1L << 34) | (1L << 39) | (1L << 44) | (1L << NAME) | (1L << NUM) | (1L << SETSTART))) != 0)) {
					{
					setState(236); ((ExpressionContext)_localctx).a = expression(0);
					_localctx.setVars.add((((ExpressionContext)_localctx).a!=null?_input.getText(((ExpressionContext)_localctx).a.start,((ExpressionContext)_localctx).a.stop):null));
					}
				}

				setState(247);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==4) {
					{
					{
					setState(241); match(4);
					setState(242); ((ExpressionContext)_localctx).b = expression(0);
					_localctx.setVars.add((((ExpressionContext)_localctx).b!=null?_input.getText(((ExpressionContext)_localctx).b.start,((ExpressionContext)_localctx).b.stop):null));
					}
					}
					setState(249);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(250); ((ExpressionContext)_localctx).SETEND = match(SETEND);
					
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
				setState(252); ((ExpressionContext)_localctx).SETSTART = match(SETSTART);
				modoSetExpression=1; setExpressionDecl = ""; setExpressionPred = ""; setExpressionExpr = ""; setExpressionVars = new ArrayList();
				setState(254); ((ExpressionContext)_localctx).declPart = declPart();
				((ExpressionContext)_localctx).externalName =  (((ExpressionContext)_localctx).SETSTART!=null?((ExpressionContext)_localctx).SETSTART.getText():null) + (((ExpressionContext)_localctx).declPart!=null?_input.getText(((ExpressionContext)_localctx).declPart.start,((ExpressionContext)_localctx).declPart.stop):null);
				setState(261);
				_la = _input.LA(1);
				if (_la==48) {
					{
					setState(256); match(48);
					modoSetExpression=2;
					setState(258); ((ExpressionContext)_localctx).predicate = predicate(0);
					((ExpressionContext)_localctx).externalName =  _localctx.externalName.concat("|" + (((ExpressionContext)_localctx).predicate!=null?_input.getText(((ExpressionContext)_localctx).predicate.start,((ExpressionContext)_localctx).predicate.stop):null));
					}
				}

				setState(268);
				_la = _input.LA(1);
				if (_la==31) {
					{
					setState(263); match(31);
					modoSetExpression=3;
					setState(265); ((ExpressionContext)_localctx).c = expression(0);
					((ExpressionContext)_localctx).externalName =  _localctx.externalName.concat("@" + (((ExpressionContext)_localctx).c!=null?_input.getText(((ExpressionContext)_localctx).c.start,((ExpressionContext)_localctx).c.stop):null));
					}
				}

				setState(270); ((ExpressionContext)_localctx).SETEND = match(SETEND);
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
				setState(274); match(8);
				setState(275); ((ExpressionContext)_localctx).e = expression(0);
				setState(276); match(27);

						//Guardo la expresion con los parentesis
						String a = (String) memory.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null));
						
						//Chequeo el nombre para ver si se trata de una sola variable, en ese caso no guardo en la memoria
						//los parentesis, en otro caso si
						
						Pattern p = Pattern.compile("[^a-zA-Z0-9_]");
						boolean hasSpecialChar = p.matcher(a).find();
						
						if (hasSpecialChar)
							memory.put("(" + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null) + ")", "(" + a + ")");
						else
							memory.put("(" + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null) + ")", a);
					
				}
				break;

			case 8:
				{
				setState(279); match(39);
					
						if (memory.get("\\nat") == null) {
							memory.put("\\nat", "NAT");
							print("NAT = int(0, 10000000000)");
						}	
					
				}
				break;

			case 9:
				{
				setState(281); match(44);
					
						if (memory.get("\\num") == null) {
							memory.put("\\num", "NUM");
							print("NUM = int(-10000000000, 10000000000)");
						}	
					
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(332);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(330);
					switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(285);
						if (!(18 >= _localctx._p)) throw new FailedPredicateException(this, "18 >= $_p");
						setState(286); match(5);
						setState(287); expression(19);
						type="is_rel";
						}
						break;

					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(290);
						if (!(17 >= _localctx._p)) throw new FailedPredicateException(this, "17 >= $_p");
						setState(291); match(10);
						setState(292); expression(18);
						type="is_pfun";
						}
						break;

					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(295);
						if (!(16 >= _localctx._p)) throw new FailedPredicateException(this, "16 >= $_p");
						setState(296); match(19);
						setState(297); expression(17);
						type="is_pfun";
						}
						break;

					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(300);
						if (!(15 >= _localctx._p)) throw new FailedPredicateException(this, "15 >= $_p");
						setState(301); match(33);
						setState(302); expression(16);
						type="is_fun";
						}
						break;

					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(305);
						if (!(14 >= _localctx._p)) throw new FailedPredicateException(this, "14 >= $_p");
						setState(306); match(46);
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

					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(310);
						if (!(13 >= _localctx._p)) throw new FailedPredicateException(this, "13 >= $_p");
						setState(311); match(49);
						setState(312); ((ExpressionContext)_localctx).e2 = expression(14);

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
						setState(315);
						if (!(12 >= _localctx._p)) throw new FailedPredicateException(this, "12 >= $_p");
						setState(316); match(17);
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

					case 8:
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

					case 9:
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
					}
					} 
				}
				setState(334);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
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
			setState(335);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 3) | (1L << 13) | (1L << 16) | (1L << 34))) != 0)) ) {
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

		case 7: return 15 >= _localctx._p;

		case 8: return 14 >= _localctx._p;

		case 9: return 13 >= _localctx._p;

		case 10: return 12 >= _localctx._p;

		case 11: return 10 >= _localctx._p;

		case 12: return 9 >= _localctx._p;
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
		"\2\3<\u0154\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4"+
		"\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\3\2\3\2\7\2\35\n\2\f\2\16\2 "+
		"\13\2\6\2\"\n\2\r\2\16\2#\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\5\3\67\n\3\3\3\3\3\6\3;\n\3\r\3\16\3<\3\3\3\3"+
		"\5\3A\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4J\n\4\f\4\16\4M\13\4\3\4\3\4"+
		"\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\5\6[\n\6\3\6\3\6\3\6\3\6\5\6"+
		"a\n\6\7\6c\n\6\f\6\16\6f\13\6\3\6\3\6\3\7\3\7\3\7\3\7\5\7n\n\7\3\7\3\7"+
		"\3\7\3\7\3\7\7\7u\n\7\f\7\16\7x\13\7\3\b\3\b\3\b\7\b}\n\b\f\b\16\b\u0080"+
		"\13\b\3\t\3\t\3\t\3\t\3\t\3\t\7\t\u0088\n\t\f\t\16\t\u008b\13\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u00d0\n\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\7\13\u00de\n\13\f\13"+
		"\16\13\u00e1\13\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\5\f\u00f2\n\f\3\f\3\f\3\f\3\f\7\f\u00f8\n\f\f\f\16\f\u00fb\13"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u0108\n\f\3\f\3\f\3"+
		"\f\3\f\3\f\5\f\u010f\n\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\5\f\u011e\n\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\7\f\u014d"+
		"\n\f\f\f\16\f\u0150\13\f\3\r\3\r\3\r\2\16\2\4\6\b\n\f\16\20\22\24\26\30"+
		"\2\4\4\'\'88\6\5\5\17\17\22\22$$\u017c\2!\3\2\2\2\4@\3\2\2\2\6B\3\2\2"+
		"\2\bQ\3\2\2\2\nU\3\2\2\2\fi\3\2\2\2\16y\3\2\2\2\20\u0081\3\2\2\2\22\u0091"+
		"\3\2\2\2\24\u00cf\3\2\2\2\26\u011d\3\2\2\2\30\u0151\3\2\2\2\32\36\5\4"+
		"\3\2\33\35\78\2\2\34\33\3\2\2\2\35 \3\2\2\2\36\34\3\2\2\2\36\37\3\2\2"+
		"\2\37\"\3\2\2\2 \36\3\2\2\2!\32\3\2\2\2\"#\3\2\2\2#!\3\2\2\2#$\3\2\2\2"+
		"$\3\3\2\2\2%&\7\27\2\2&\'\7\64\2\2\'(\7\26\2\2()\5\f\7\2)*\7\20\2\2*A"+
		"\3\2\2\2+,\7\30\2\2,-\78\2\2-.\5\16\b\2./\78\2\2/\60\7 \2\2\60A\3\2\2"+
		"\2\61\62\7-\2\2\62:\78\2\2\63\67\5\6\4\2\64\67\5\b\5\2\65\67\5\n\6\2\66"+
		"\63\3\2\2\2\66\64\3\2\2\2\66\65\3\2\2\2\678\3\2\2\289\78\2\29;\3\2\2\2"+
		":\66\3\2\2\2;<\3\2\2\2<:\3\2\2\2<=\3\2\2\2=>\3\2\2\2>?\7\21\2\2?A\3\2"+
		"\2\2@%\3\2\2\2@+\3\2\2\2@\61\3\2\2\2A\5\3\2\2\2BC\7\b\2\2CD\5\22\n\2D"+
		"K\b\4\1\2EF\7\6\2\2FG\5\22\n\2GH\b\4\1\2HJ\3\2\2\2IE\3\2\2\2JM\3\2\2\2"+
		"KI\3\2\2\2KL\3\2\2\2LN\3\2\2\2MK\3\2\2\2NO\7\4\2\2OP\b\4\1\2P\7\3\2\2"+
		"\2QR\5\22\n\2RS\7/\2\2ST\5\26\f\2T\t\3\2\2\2UV\5\22\n\2VW\7\61\2\2WX\5"+
		"\22\n\2XZ\b\6\1\2Y[\5\26\f\2ZY\3\2\2\2Z[\3\2\2\2[d\3\2\2\2\\]\7\62\2\2"+
		"]^\5\22\n\2^`\b\6\1\2_a\5\26\f\2`_\3\2\2\2`a\3\2\2\2ac\3\2\2\2b\\\3\2"+
		"\2\2cf\3\2\2\2db\3\2\2\2de\3\2\2\2eg\3\2\2\2fd\3\2\2\2gh\b\6\1\2h\13\3"+
		"\2\2\2im\78\2\2jk\5\16\b\2kl\78\2\2ln\3\2\2\2mj\3\2\2\2mn\3\2\2\2no\3"+
		"\2\2\2op\7,\2\2pv\78\2\2qr\5\24\13\2rs\78\2\2su\3\2\2\2tq\3\2\2\2ux\3"+
		"\2\2\2vt\3\2\2\2vw\3\2\2\2w\r\3\2\2\2xv\3\2\2\2y~\5\20\t\2z{\t\2\2\2{"+
		"}\5\20\t\2|z\3\2\2\2}\u0080\3\2\2\2~|\3\2\2\2~\177\3\2\2\2\177\17\3\2"+
		"\2\2\u0080~\3\2\2\2\u0081\u0082\5\22\n\2\u0082\u0089\b\t\1\2\u0083\u0084"+
		"\7\6\2\2\u0084\u0085\5\22\n\2\u0085\u0086\b\t\1\2\u0086\u0088\3\2\2\2"+
		"\u0087\u0083\3\2\2\2\u0088\u008b\3\2\2\2\u0089\u0087\3\2\2\2\u0089\u008a"+
		"\3\2\2\2\u008a\u008c\3\2\2\2\u008b\u0089\3\2\2\2\u008c\u008d\7\t\2\2\u008d"+
		"\u008e\b\t\1\2\u008e\u008f\5\26\f\2\u008f\u0090\b\t\1\2\u0090\21\3\2\2"+
		"\2\u0091\u0092\7\64\2\2\u0092\23\3\2\2\2\u0093\u0094\b\13\1\2\u0094\u0095"+
		"\7\3\2\2\u0095\u00d0\5\24\13\2\u0096\u0097\5\26\f\2\u0097\u0098\7\24\2"+
		"\2\u0098\u0099\7\17\2\2\u0099\u009a\5\26\f\2\u009a\u009b\b\13\1\2\u009b"+
		"\u00d0\3\2\2\2\u009c\u009d\5\26\f\2\u009d\u009e\7\24\2\2\u009e\u009f\5"+
		"\26\f\2\u009f\u00a0\b\13\1\2\u00a0\u00d0\3\2\2\2\u00a1\u00a2\5\26\f\2"+
		"\u00a2\u00a3\7\32\2\2\u00a3\u00a4\5\26\f\2\u00a4\u00a5\b\13\1\2\u00a5"+
		"\u00d0\3\2\2\2\u00a6\u00a7\5\26\f\2\u00a7\u00a8\7\13\2\2\u00a8\u00a9\5"+
		"\26\f\2\u00a9\u00aa\b\13\1\2\u00aa\u00d0\3\2\2\2\u00ab\u00ac\5\26\f\2"+
		"\u00ac\u00ad\7*\2\2\u00ad\u00ae\5\26\f\2\u00ae\u00af\b\13\1\2\u00af\u00d0"+
		"\3\2\2\2\u00b0\u00b1\5\26\f\2\u00b1\u00b2\7&\2\2\u00b2\u00b3\5\26\f\2"+
		"\u00b3\u00b4\b\13\1\2\u00b4\u00d0\3\2\2\2\u00b5\u00b6\5\26\f\2\u00b6\u00b7"+
		"\7+\2\2\u00b7\u00b8\5\26\f\2\u00b8\u00b9\b\13\1\2\u00b9\u00d0\3\2\2\2"+
		"\u00ba\u00bb\5\26\f\2\u00bb\u00bc\7%\2\2\u00bc\u00bd\5\26\f\2\u00bd\u00be"+
		"\b\13\1\2\u00be\u00d0\3\2\2\2\u00bf\u00c0\5\26\f\2\u00c0\u00c1\7\33\2"+
		"\2\u00c1\u00c2\5\26\f\2\u00c2\u00c3\b\13\1\2\u00c3\u00d0\3\2\2\2\u00c4"+
		"\u00c5\5\26\f\2\u00c5\u00c6\7(\2\2\u00c6\u00c7\5\26\f\2\u00c7\u00c8\b"+
		"\13\1\2\u00c8\u00d0\3\2\2\2\u00c9\u00ca\7\n\2\2\u00ca\u00cb\5\24\13\2"+
		"\u00cb\u00cc\7\35\2\2\u00cc\u00d0\3\2\2\2\u00cd\u00d0\7\31\2\2\u00ce\u00d0"+
		"\7\r\2\2\u00cf\u0093\3\2\2\2\u00cf\u0096\3\2\2\2\u00cf\u009c\3\2\2\2\u00cf"+
		"\u00a1\3\2\2\2\u00cf\u00a6\3\2\2\2\u00cf\u00ab\3\2\2\2\u00cf\u00b0\3\2"+
		"\2\2\u00cf\u00b5\3\2\2\2\u00cf\u00ba\3\2\2\2\u00cf\u00bf\3\2\2\2\u00cf"+
		"\u00c4\3\2\2\2\u00cf\u00c9\3\2\2\2\u00cf\u00cd\3\2\2\2\u00cf\u00ce\3\2"+
		"\2\2\u00d0\u00df\3\2\2\2\u00d1\u00d2\6\13\2\3\u00d2\u00d3\7\36\2\2\u00d3"+
		"\u00de\5\24\13\2\u00d4\u00d5\6\13\3\3\u00d5\u00d6\7\"\2\2\u00d6\u00de"+
		"\5\24\13\2\u00d7\u00d8\6\13\4\3\u00d8\u00d9\7\16\2\2\u00d9\u00de\5\24"+
		"\13\2\u00da\u00db\6\13\5\3\u00db\u00dc\7\37\2\2\u00dc\u00de\5\24\13\2"+
		"\u00dd\u00d1\3\2\2\2\u00dd\u00d4\3\2\2\2\u00dd\u00d7\3\2\2\2\u00dd\u00da"+
		"\3\2\2\2\u00de\u00e1\3\2\2\2\u00df\u00dd\3\2\2\2\u00df\u00e0\3\2\2\2\u00e0"+
		"\25\3\2\2\2\u00e1\u00df\3\2\2\2\u00e2\u00e3\b\f\1\2\u00e3\u00e4\5\30\r"+
		"\2\u00e4\u00e5\5\26\f\2\u00e5\u00e6\b\f\1\2\u00e6\u011e\3\2\2\2\u00e7"+
		"\u00e8\7\34\2\2\u00e8\u011e\5\26\f\2\u00e9\u00ea\7\64\2\2\u00ea\u011e"+
		"\b\f\1\2\u00eb\u00ec\7\65\2\2\u00ec\u011e\b\f\1\2\u00ed\u00f1\7:\2\2\u00ee"+
		"\u00ef\5\26\f\2\u00ef\u00f0\b\f\1\2\u00f0\u00f2\3\2\2\2\u00f1\u00ee\3"+
		"\2\2\2\u00f1\u00f2\3\2\2\2\u00f2\u00f9\3\2\2\2\u00f3\u00f4\7\6\2\2\u00f4"+
		"\u00f5\5\26\f\2\u00f5\u00f6\b\f\1\2\u00f6\u00f8\3\2\2\2\u00f7\u00f3\3"+
		"\2\2\2\u00f8\u00fb\3\2\2\2\u00f9\u00f7\3\2\2\2\u00f9\u00fa\3\2\2\2\u00fa"+
		"\u00fc\3\2\2\2\u00fb\u00f9\3\2\2\2\u00fc\u00fd\7;\2\2\u00fd\u011e\b\f"+
		"\1\2\u00fe\u00ff\7:\2\2\u00ff\u0100\b\f\1\2\u0100\u0101\5\16\b\2\u0101"+
		"\u0107\b\f\1\2\u0102\u0103\7\62\2\2\u0103\u0104\b\f\1\2\u0104\u0105\5"+
		"\24\13\2\u0105\u0106\b\f\1\2\u0106\u0108\3\2\2\2\u0107\u0102\3\2\2\2\u0107"+
		"\u0108\3\2\2\2\u0108\u010e\3\2\2\2\u0109\u010a\7!\2\2\u010a\u010b\b\f"+
		"\1\2\u010b\u010c\5\26\f\2\u010c\u010d\b\f\1\2\u010d\u010f\3\2\2\2\u010e"+
		"\u0109\3\2\2\2\u010e\u010f\3\2\2\2\u010f\u0110\3\2\2\2\u0110\u0111\7;"+
		"\2\2\u0111\u0112\b\f\1\2\u0112\u0113\b\f\1\2\u0113\u011e\3\2\2\2\u0114"+
		"\u0115\7\n\2\2\u0115\u0116\5\26\f\2\u0116\u0117\7\35\2\2\u0117\u0118\b"+
		"\f\1\2\u0118\u011e\3\2\2\2\u0119\u011a\7)\2\2\u011a\u011e\b\f\1\2\u011b"+
		"\u011c\7.\2\2\u011c\u011e\b\f\1\2\u011d\u00e2\3\2\2\2\u011d\u00e7\3\2"+
		"\2\2\u011d\u00e9\3\2\2\2\u011d\u00eb\3\2\2\2\u011d\u00ed\3\2\2\2\u011d"+
		"\u00fe\3\2\2\2\u011d\u0114\3\2\2\2\u011d\u0119\3\2\2\2\u011d\u011b\3\2"+
		"\2\2\u011e\u014e\3\2\2\2\u011f\u0120\6\f\6\3\u0120\u0121\7\7\2\2\u0121"+
		"\u0122\5\26\f\2\u0122\u0123\b\f\1\2\u0123\u014d\3\2\2\2\u0124\u0125\6"+
		"\f\7\3\u0125\u0126\7\f\2\2\u0126\u0127\5\26\f\2\u0127\u0128\b\f\1\2\u0128"+
		"\u014d\3\2\2\2\u0129\u012a\6\f\b\3\u012a\u012b\7\25\2\2\u012b\u012c\5"+
		"\26\f\2\u012c\u012d\b\f\1\2\u012d\u014d\3\2\2\2\u012e\u012f\6\f\t\3\u012f"+
		"\u0130\7#\2\2\u0130\u0131\5\26\f\2\u0131\u0132\b\f\1\2\u0132\u014d\3\2"+
		"\2\2\u0133\u0134\6\f\n\3\u0134\u0135\7\60\2\2\u0135\u0136\5\26\f\2\u0136"+
		"\u0137\b\f\1\2\u0137\u014d\3\2\2\2\u0138\u0139\6\f\13\3\u0139\u013a\7"+
		"\63\2\2\u013a\u013b\5\26\f\2\u013b\u013c\b\f\1\2\u013c\u014d\3\2\2\2\u013d"+
		"\u013e\6\f\f\3\u013e\u013f\7\23\2\2\u013f\u0140\5\26\f\2\u0140\u0141\b"+
		"\f\1\2\u0141\u014d\3\2\2\2\u0142\u0143\6\f\r\3\u0143\u0144\7\67\2\2\u0144"+
		"\u0145\5\26\f\2\u0145\u0146\b\f\1\2\u0146\u014d\3\2\2\2\u0147\u0148\6"+
		"\f\16\3\u0148\u0149\7\66\2\2\u0149\u014a\5\26\f\2\u014a\u014b\b\f\1\2"+
		"\u014b\u014d\3\2\2\2\u014c\u011f\3\2\2\2\u014c\u0124\3\2\2\2\u014c\u0129"+
		"\3\2\2\2\u014c\u012e\3\2\2\2\u014c\u0133\3\2\2\2\u014c\u0138\3\2\2\2\u014c"+
		"\u013d\3\2\2\2\u014c\u0142\3\2\2\2\u014c\u0147\3\2\2\2\u014d\u0150\3\2"+
		"\2\2\u014e\u014c\3\2\2\2\u014e\u014f\3\2\2\2\u014f\27\3\2\2\2\u0150\u014e"+
		"\3\2\2\2\u0151\u0152\t\3\2\2\u0152\31\3\2\2\2\31\36#\66<@KZ`dmv~\u0089"+
		"\u00cf\u00dd\u00df\u00f1\u00f9\u0107\u010e\u011d\u014c\u014e";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}