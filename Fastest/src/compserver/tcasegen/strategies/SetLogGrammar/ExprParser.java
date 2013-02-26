package compserver.tcasegen.strategies.SetLogGrammar;

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
		"<INVALID>", "'\\lnot'", "'\\#'", "'['", "'\\pfun'", "'<'", "'false'", 
		"'\\end{schema}'", "'\\dom'", "'\\upto'", "'\\ffun'", "'}'", "'\\notin'", 
		"'\\land'", "')'", "'@'", "'\\seq'", "'='", "'\\leq'", "'\\nat'", "'\\neq'", 
		"'\\where'", "'\\geq'", "'::='", "'|'", "']'", "'\\rel'", "','", "'('", 
		"':'", "'\\lor'", "'\\ran'", "'\\end{zed}'", "'\\in'", "'true'", "'\\begin{axdef}'", 
		"'\\begin{schema}{'", "'\\subset'", "'\\power'", "'\\iff'", "'\\end{axdef}'", 
		"'\\fun'", "'\\implies'", "';'", "'>'", "'\\begin{zed}'", "'\\num'", "'=='", 
		"'~'", "'\\mapsto'", "NAME", "NUM", "IN_FUN_P3", "IN_FUN_P4", "NL", "WS", 
		"'\\{'", "'\\}'", "SKIP"
	};
	public static final int
		RULE_specification = 0, RULE_paragraph = 1, RULE_basic_type = 2, RULE_equivalent_type = 3, 
		RULE_branch_type = 4, RULE_schemaText = 5, RULE_declPart = 6, RULE_declaration = 7, 
		RULE_declName = 8, RULE_predicate = 9, RULE_expression = 10, RULE_pre_gen = 11;
	public static final String[] ruleNames = {
		"specification", "paragraph", "basic_type", "equivalent_type", "branch_type", 
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
		HashMap memory = new HashMap();
		int modoSetExpression = 0; //0 = false, 1 = true
		String setExpressionDecl, setExpressionPred, setExpressionExpr;
		ArrayList setExpressionVars;

		String salida = new String();
		public String getSalida() {
			return salida;
		}

		public void print(String c) {
			if (modoSetExpression == 0) 
				salida = salida.concat(c + " & \n");
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
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 35) | (1L << 36) | (1L << 45))) != 0) );
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
		public Branch_typeContext branch_type(int i) {
			return getRuleContext(Branch_typeContext.class,i);
		}
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
		public List<TerminalNode> NL() { return getTokens(ExprParser.NL); }
		public List<Equivalent_typeContext> equivalent_type() {
			return getRuleContexts(Equivalent_typeContext.class);
		}
		public List<Branch_typeContext> branch_type() {
			return getRuleContexts(Branch_typeContext.class);
		}
		public Basic_typeContext basic_type(int i) {
			return getRuleContext(Basic_typeContext.class,i);
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
			case 36:
				enterOuterAlt(_localctx, 1);
				{
				setState(35); match(36);
				setState(36); match(NAME);
				setState(37); match(11);
				setState(38); schemaText();
				setState(39); match(7);
				}
				break;
			case 35:
				enterOuterAlt(_localctx, 2);
				{
				setState(41); match(35);
				setState(42); match(NL);
				setState(43); declPart();
				setState(44); match(NL);
				setState(45); match(40);
				}
				break;
			case 45:
				enterOuterAlt(_localctx, 3);
				{
				setState(47); match(45);
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
						setState(51); branch_type();
						}
						break;
					}
					setState(54); match(NL);
					}
					}
					setState(58); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==3 || _la==NAME );
				setState(60); match(32);
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64); match(3);
			setState(65); declName();
			setState(70);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==27) {
				{
				{
				setState(66); match(27);
				setState(67); declName();
				}
				}
				setState(72);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(73); match(25);
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
			setState(75); declName();
			setState(76); match(47);
			setState(77); expression(0);
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

	public static class Branch_typeContext extends ParserRuleContext {
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
		public Branch_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_branch_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterBranch_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitBranch_type(this);
		}
	}

	public final Branch_typeContext branch_type() throws RecognitionException {
		Branch_typeContext _localctx = new Branch_typeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_branch_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(79); declName();
			setState(80); match(23);
			setState(81); declName();
			setState(83);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 2) | (1L << 8) | (1L << 16) | (1L << 19) | (1L << 28) | (1L << 31) | (1L << 38) | (1L << 46) | (1L << NAME) | (1L << NUM) | (1L << SETSTART))) != 0)) {
				{
				setState(82); expression(0);
				}
			}

			setState(92);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==24) {
				{
				{
				setState(85); match(24);
				setState(86); declName();
				setState(88);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 2) | (1L << 8) | (1L << 16) | (1L << 19) | (1L << 28) | (1L << 31) | (1L << 38) | (1L << 46) | (1L << NAME) | (1L << NUM) | (1L << SETSTART))) != 0)) {
					{
					setState(87); expression(0);
					}
				}

				}
				}
				setState(94);
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
			setState(95); match(NL);
			setState(99);
			_la = _input.LA(1);
			if (_la==NAME) {
				{
				setState(96); declPart();
				setState(97); match(NL);
				}
			}

			setState(101); match(21);
			setState(102); match(NL);
			setState(108);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 2) | (1L << 6) | (1L << 8) | (1L << 16) | (1L << 19) | (1L << 28) | (1L << 31) | (1L << 34) | (1L << 38) | (1L << 46) | (1L << NAME) | (1L << NUM) | (1L << SETSTART))) != 0)) {
				{
				{
				setState(103); predicate(0);
				setState(104); match(NL);
				}
				}
				setState(110);
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
			setState(111); declaration();
			setState(116);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(112);
					_la = _input.LA(1);
					if ( !(_la==43 || _la==NL) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					setState(113); declaration();
					}
					} 
				}
				setState(118);
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
			setState(119); ((DeclarationContext)_localctx).a = declName();
			((DeclarationContext)getInvokingContext(7)).vars.add((((DeclarationContext)_localctx).a!=null?_input.getText(((DeclarationContext)_localctx).a.start,((DeclarationContext)_localctx).a.stop):null));
			setState(127);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==27) {
				{
				{
				setState(121); match(27);
				setState(122); ((DeclarationContext)_localctx).b = declName();
				((DeclarationContext)getInvokingContext(7)).vars.add((((DeclarationContext)_localctx).b!=null?_input.getText(((DeclarationContext)_localctx).b.start,((DeclarationContext)_localctx).b.stop):null));
				}
				}
				setState(129);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(130); match(29);
			type = "";
			setState(132); expression(0);

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
						
						if (!type.equals("")) print(type + "(" + newVarName + ")");
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
			setState(135); match(NAME);
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
			setState(197);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				setState(138); match(1);
				setState(139); predicate(18);
				}
				break;

			case 2:
				{
				setState(140); ((PredicateContext)_localctx).e1 = expression(0);
				setState(141); match(33);
				setState(142); match(8);
				setState(143); ((PredicateContext)_localctx).e2 = expression(0);
					String a, b;
						a = (String)memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = (String)memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						print("in_dom(" + a + "," + b + ")");
					
				}
				break;

			case 3:
				{
				setState(146); ((PredicateContext)_localctx).e1 = expression(0);
				setState(147); match(33);
				setState(148); ((PredicateContext)_localctx).e2 = expression(0);

						String a, b;
						a = (String)memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = (String)memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						print(a + " in " + b);
					
				}
				break;

			case 4:
				{
				setState(151); ((PredicateContext)_localctx).e1 = expression(0);
				setState(152); match(12);
				setState(153); ((PredicateContext)_localctx).e2 = expression(0);

						String a, b;
						a = (String)memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = (String)memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						print(a + " nin " + b);
					
				}
				break;

			case 5:
				{
				setState(156); ((PredicateContext)_localctx).e1 = expression(0);
				setState(157); match(5);
				setState(158); ((PredicateContext)_localctx).e2 = expression(0);

						String a, b;
						a = (String)memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = (String)memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						print(a + " < " + b);
					
				}
				break;

			case 6:
				{
				setState(161); ((PredicateContext)_localctx).e1 = expression(0);
				setState(162); match(44);
				setState(163); ((PredicateContext)_localctx).e2 = expression(0);

						String a, b;
						a = (String)memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = (String)memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						print(a + " > " + b);
					
				}
				break;

			case 7:
				{
				setState(166); ((PredicateContext)_localctx).e1 = expression(0);
				setState(167); match(18);
				setState(168); ((PredicateContext)_localctx).e2 = expression(0);

						String a, b;
						a = (String)memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = (String)memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						print(a + " =< " + b);
					
				}
				break;

			case 8:
				{
				setState(171); ((PredicateContext)_localctx).e1 = expression(0);
				setState(172); match(22);
				setState(173); ((PredicateContext)_localctx).e2 = expression(0);

						String a, b;
						a = (String)memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = (String)memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						print(a + " =< " + b);
					
				}
				break;

			case 9:
				{
				setState(176); ((PredicateContext)_localctx).e1 = expression(0);
				setState(177); match(17);
				setState(178); ((PredicateContext)_localctx).e2 = expression(0);

						String a, b;
						a = (String)memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = (String)memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						print(a + " = " + b);
					
				}
				break;

			case 10:
				{
				setState(181); ((PredicateContext)_localctx).e1 = expression(0);
				setState(182); match(37);
				setState(183); ((PredicateContext)_localctx).e2 = expression(0);

						String a, b;
						a = (String)memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = (String)memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						print("dsubset(" + a + "," + b + ")");
					
				}
				break;

			case 11:
				{
				setState(186); ((PredicateContext)_localctx).e1 = expression(0);
				setState(187); match(20);
				setState(188); ((PredicateContext)_localctx).e2 = expression(0);

						String a, b;
						a = (String)memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = (String)memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						print(a + " neq " + b);
					
				}
				break;

			case 12:
				{
				setState(191); match(28);
				setState(192); predicate(0);
				setState(193); match(14);
				}
				break;

			case 13:
				{
				setState(195); match(34);
				}
				break;

			case 14:
				{
				setState(196); match(6);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(213);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(211);
					switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
					case 1:
						{
						_localctx = new PredicateContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_predicate);
						setState(199);
						if (!(4 >= _localctx._p)) throw new FailedPredicateException(this, "4 >= $_p");
						setState(200); match(39);
						setState(201); predicate(5);
						}
						break;

					case 2:
						{
						_localctx = new PredicateContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_predicate);
						setState(202);
						if (!(3 >= _localctx._p)) throw new FailedPredicateException(this, "3 >= $_p");
						setState(203); match(42);
						setState(204); predicate(4);
						}
						break;

					case 3:
						{
						_localctx = new PredicateContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_predicate);
						setState(205);
						if (!(2 >= _localctx._p)) throw new FailedPredicateException(this, "2 >= $_p");
						setState(206); match(30);
						setState(207); predicate(3);
						}
						break;

					case 4:
						{
						_localctx = new PredicateContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_predicate);
						setState(208);
						if (!(1 >= _localctx._p)) throw new FailedPredicateException(this, "1 >= $_p");
						setState(209); match(13);
						setState(210); predicate(2);
						}
						break;
					}
					} 
				}
				setState(215);
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
			setState(274);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				setState(217); ((ExpressionContext)_localctx).pre_gen = pre_gen();
				setState(218); ((ExpressionContext)_localctx).e = expression(11);

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
				setState(221); match(38);
				setState(222); expression(8);
				}
				break;

			case 3:
				{
				setState(223); ((ExpressionContext)_localctx).NAME = match(NAME);

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
				setState(225); ((ExpressionContext)_localctx).NUM = match(NUM);

						if (memory.get((((ExpressionContext)_localctx).NUM!=null?((ExpressionContext)_localctx).NUM.getText():null)) == null)
							memory.put((((ExpressionContext)_localctx).NUM!=null?((ExpressionContext)_localctx).NUM.getText():null), (((ExpressionContext)_localctx).NUM!=null?((ExpressionContext)_localctx).NUM.getText():null));
					
				}
				break;

			case 5:
				{
				setState(227); ((ExpressionContext)_localctx).SETSTART = match(SETSTART);
				setState(231);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 2) | (1L << 8) | (1L << 16) | (1L << 19) | (1L << 28) | (1L << 31) | (1L << 38) | (1L << 46) | (1L << NAME) | (1L << NUM) | (1L << SETSTART))) != 0)) {
					{
					setState(228); ((ExpressionContext)_localctx).a = expression(0);
					_localctx.setVars.add((((ExpressionContext)_localctx).a!=null?_input.getText(((ExpressionContext)_localctx).a.start,((ExpressionContext)_localctx).a.stop):null));
					}
				}

				setState(239);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==27) {
					{
					{
					setState(233); match(27);
					setState(234); ((ExpressionContext)_localctx).b = expression(0);
					_localctx.setVars.add((((ExpressionContext)_localctx).b!=null?_input.getText(((ExpressionContext)_localctx).b.start,((ExpressionContext)_localctx).b.stop):null));
					}
					}
					setState(241);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(242); ((ExpressionContext)_localctx).SETEND = match(SETEND);
					
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
				setState(244); ((ExpressionContext)_localctx).SETSTART = match(SETSTART);
				modoSetExpression=1; setExpressionDecl = ""; setExpressionPred = ""; setExpressionExpr = ""; setExpressionVars = new ArrayList();
				setState(246); ((ExpressionContext)_localctx).declPart = declPart();
				((ExpressionContext)_localctx).externalName =  (((ExpressionContext)_localctx).SETSTART!=null?((ExpressionContext)_localctx).SETSTART.getText():null) + (((ExpressionContext)_localctx).declPart!=null?_input.getText(((ExpressionContext)_localctx).declPart.start,((ExpressionContext)_localctx).declPart.stop):null);
				setState(253);
				_la = _input.LA(1);
				if (_la==24) {
					{
					setState(248); match(24);
					modoSetExpression=2;
					setState(250); ((ExpressionContext)_localctx).predicate = predicate(0);
					((ExpressionContext)_localctx).externalName =  _localctx.externalName.concat("|" + (((ExpressionContext)_localctx).predicate!=null?_input.getText(((ExpressionContext)_localctx).predicate.start,((ExpressionContext)_localctx).predicate.stop):null));
					}
				}

				setState(260);
				_la = _input.LA(1);
				if (_la==15) {
					{
					setState(255); match(15);
					modoSetExpression=3;
					setState(257); ((ExpressionContext)_localctx).c = expression(0);
					((ExpressionContext)_localctx).externalName =  _localctx.externalName.concat("@" + (((ExpressionContext)_localctx).c!=null?_input.getText(((ExpressionContext)_localctx).c.start,((ExpressionContext)_localctx).c.stop):null));
					}
				}

				setState(262); ((ExpressionContext)_localctx).SETEND = match(SETEND);
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
				setState(266); match(28);
				setState(267); ((ExpressionContext)_localctx).e = expression(0);
				setState(268); match(14);

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
				setState(271); match(19);
					
						if (memory.get("\\nat") == null) {
							memory.put("\\nat", "NAT");
							print("NAT = int(0, 10000000000)");
						}	
					
				}
				break;

			case 9:
				{
				setState(273); match(46);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(323);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(321);
					switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(276);
						if (!(18 >= _localctx._p)) throw new FailedPredicateException(this, "18 >= $_p");
						setState(277); match(26);
						setState(278); expression(19);
						type="is_rel";
						}
						break;

					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(281);
						if (!(17 >= _localctx._p)) throw new FailedPredicateException(this, "17 >= $_p");
						setState(282); match(4);
						setState(283); expression(18);
						type="is_pfun";
						}
						break;

					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(286);
						if (!(16 >= _localctx._p)) throw new FailedPredicateException(this, "16 >= $_p");
						setState(287); match(10);
						setState(288); expression(17);
						type="is_pfun";
						}
						break;

					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(291);
						if (!(15 >= _localctx._p)) throw new FailedPredicateException(this, "15 >= $_p");
						setState(292); match(41);
						setState(293); expression(16);
						type="is_fun";
						}
						break;

					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(296);
						if (!(14 >= _localctx._p)) throw new FailedPredicateException(this, "14 >= $_p");
						setState(297); match(48);
						setState(298); ((ExpressionContext)_localctx).e2 = expression(15);

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
						setState(301);
						if (!(13 >= _localctx._p)) throw new FailedPredicateException(this, "13 >= $_p");
						setState(302); match(49);
						setState(303); ((ExpressionContext)_localctx).e2 = expression(14);

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
						setState(306);
						if (!(12 >= _localctx._p)) throw new FailedPredicateException(this, "12 >= $_p");
						setState(307); match(9);
						setState(308); ((ExpressionContext)_localctx).e2 = expression(13);

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
						setState(311);
						if (!(10 >= _localctx._p)) throw new FailedPredicateException(this, "10 >= $_p");
						setState(312); ((ExpressionContext)_localctx).IN_FUN_P4 = match(IN_FUN_P4);
						setState(313); ((ExpressionContext)_localctx).e2 = expression(11);

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
						setState(316);
						if (!(9 >= _localctx._p)) throw new FailedPredicateException(this, "9 >= $_p");
						setState(317); ((ExpressionContext)_localctx).IN_FUN_P3 = match(IN_FUN_P3);
						setState(318); ((ExpressionContext)_localctx).e2 = expression(10);

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
				setState(325);
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
			setState(326);
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
		"\2\3<\u014b\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4"+
		"\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\3\2\3\2\7\2\35\n\2\f\2\16\2 "+
		"\13\2\6\2\"\n\2\r\2\16\2#\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\5\3\67\n\3\3\3\3\3\6\3;\n\3\r\3\16\3<\3\3\3\3"+
		"\5\3A\n\3\3\4\3\4\3\4\3\4\7\4G\n\4\f\4\16\4J\13\4\3\4\3\4\3\5\3\5\3\5"+
		"\3\5\3\6\3\6\3\6\3\6\5\6V\n\6\3\6\3\6\3\6\5\6[\n\6\7\6]\n\6\f\6\16\6`"+
		"\13\6\3\7\3\7\3\7\3\7\5\7f\n\7\3\7\3\7\3\7\3\7\3\7\7\7m\n\7\f\7\16\7p"+
		"\13\7\3\b\3\b\3\b\7\bu\n\b\f\b\16\bx\13\b\3\t\3\t\3\t\3\t\3\t\3\t\7\t"+
		"\u0080\n\t\f\t\16\t\u0083\13\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\5\13\u00c8\n\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\7\13\u00d6\n\13\f\13\16\13\u00d9\13\13\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00ea\n\f\3\f\3\f\3\f"+
		"\3\f\7\f\u00f0\n\f\f\f\16\f\u00f3\13\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\5\f\u0100\n\f\3\f\3\f\3\f\3\f\3\f\5\f\u0107\n\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u0115\n\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\7\f\u0144\n\f\f\f\16\f\u0147\13\f\3\r\3\r\3\r\2"+
		"\16\2\4\6\b\n\f\16\20\22\24\26\30\2\4\4--88\6\4\4\n\n\22\22!!\u0173\2"+
		"!\3\2\2\2\4@\3\2\2\2\6B\3\2\2\2\bM\3\2\2\2\nQ\3\2\2\2\fa\3\2\2\2\16q\3"+
		"\2\2\2\20y\3\2\2\2\22\u0089\3\2\2\2\24\u00c7\3\2\2\2\26\u0114\3\2\2\2"+
		"\30\u0148\3\2\2\2\32\36\5\4\3\2\33\35\78\2\2\34\33\3\2\2\2\35 \3\2\2\2"+
		"\36\34\3\2\2\2\36\37\3\2\2\2\37\"\3\2\2\2 \36\3\2\2\2!\32\3\2\2\2\"#\3"+
		"\2\2\2#!\3\2\2\2#$\3\2\2\2$\3\3\2\2\2%&\7&\2\2&\'\7\64\2\2\'(\7\r\2\2"+
		"()\5\f\7\2)*\7\t\2\2*A\3\2\2\2+,\7%\2\2,-\78\2\2-.\5\16\b\2./\78\2\2/"+
		"\60\7*\2\2\60A\3\2\2\2\61\62\7/\2\2\62:\78\2\2\63\67\5\6\4\2\64\67\5\b"+
		"\5\2\65\67\5\n\6\2\66\63\3\2\2\2\66\64\3\2\2\2\66\65\3\2\2\2\678\3\2\2"+
		"\289\78\2\29;\3\2\2\2:\66\3\2\2\2;<\3\2\2\2<:\3\2\2\2<=\3\2\2\2=>\3\2"+
		"\2\2>?\7\"\2\2?A\3\2\2\2@%\3\2\2\2@+\3\2\2\2@\61\3\2\2\2A\5\3\2\2\2BC"+
		"\7\5\2\2CH\5\22\n\2DE\7\35\2\2EG\5\22\n\2FD\3\2\2\2GJ\3\2\2\2HF\3\2\2"+
		"\2HI\3\2\2\2IK\3\2\2\2JH\3\2\2\2KL\7\33\2\2L\7\3\2\2\2MN\5\22\n\2NO\7"+
		"\61\2\2OP\5\26\f\2P\t\3\2\2\2QR\5\22\n\2RS\7\31\2\2SU\5\22\n\2TV\5\26"+
		"\f\2UT\3\2\2\2UV\3\2\2\2V^\3\2\2\2WX\7\32\2\2XZ\5\22\n\2Y[\5\26\f\2ZY"+
		"\3\2\2\2Z[\3\2\2\2[]\3\2\2\2\\W\3\2\2\2]`\3\2\2\2^\\\3\2\2\2^_\3\2\2\2"+
		"_\13\3\2\2\2`^\3\2\2\2ae\78\2\2bc\5\16\b\2cd\78\2\2df\3\2\2\2eb\3\2\2"+
		"\2ef\3\2\2\2fg\3\2\2\2gh\7\27\2\2hn\78\2\2ij\5\24\13\2jk\78\2\2km\3\2"+
		"\2\2li\3\2\2\2mp\3\2\2\2nl\3\2\2\2no\3\2\2\2o\r\3\2\2\2pn\3\2\2\2qv\5"+
		"\20\t\2rs\t\2\2\2su\5\20\t\2tr\3\2\2\2ux\3\2\2\2vt\3\2\2\2vw\3\2\2\2w"+
		"\17\3\2\2\2xv\3\2\2\2yz\5\22\n\2z\u0081\b\t\1\2{|\7\35\2\2|}\5\22\n\2"+
		"}~\b\t\1\2~\u0080\3\2\2\2\177{\3\2\2\2\u0080\u0083\3\2\2\2\u0081\177\3"+
		"\2\2\2\u0081\u0082\3\2\2\2\u0082\u0084\3\2\2\2\u0083\u0081\3\2\2\2\u0084"+
		"\u0085\7\37\2\2\u0085\u0086\b\t\1\2\u0086\u0087\5\26\f\2\u0087\u0088\b"+
		"\t\1\2\u0088\21\3\2\2\2\u0089\u008a\7\64\2\2\u008a\23\3\2\2\2\u008b\u008c"+
		"\b\13\1\2\u008c\u008d\7\3\2\2\u008d\u00c8\5\24\13\2\u008e\u008f\5\26\f"+
		"\2\u008f\u0090\7#\2\2\u0090\u0091\7\n\2\2\u0091\u0092\5\26\f\2\u0092\u0093"+
		"\b\13\1\2\u0093\u00c8\3\2\2\2\u0094\u0095\5\26\f\2\u0095\u0096\7#\2\2"+
		"\u0096\u0097\5\26\f\2\u0097\u0098\b\13\1\2\u0098\u00c8\3\2\2\2\u0099\u009a"+
		"\5\26\f\2\u009a\u009b\7\16\2\2\u009b\u009c\5\26\f\2\u009c\u009d\b\13\1"+
		"\2\u009d\u00c8\3\2\2\2\u009e\u009f\5\26\f\2\u009f\u00a0\7\7\2\2\u00a0"+
		"\u00a1\5\26\f\2\u00a1\u00a2\b\13\1\2\u00a2\u00c8\3\2\2\2\u00a3\u00a4\5"+
		"\26\f\2\u00a4\u00a5\7.\2\2\u00a5\u00a6\5\26\f\2\u00a6\u00a7\b\13\1\2\u00a7"+
		"\u00c8\3\2\2\2\u00a8\u00a9\5\26\f\2\u00a9\u00aa\7\24\2\2\u00aa\u00ab\5"+
		"\26\f\2\u00ab\u00ac\b\13\1\2\u00ac\u00c8\3\2\2\2\u00ad\u00ae\5\26\f\2"+
		"\u00ae\u00af\7\30\2\2\u00af\u00b0\5\26\f\2\u00b0\u00b1\b\13\1\2\u00b1"+
		"\u00c8\3\2\2\2\u00b2\u00b3\5\26\f\2\u00b3\u00b4\7\23\2\2\u00b4\u00b5\5"+
		"\26\f\2\u00b5\u00b6\b\13\1\2\u00b6\u00c8\3\2\2\2\u00b7\u00b8\5\26\f\2"+
		"\u00b8\u00b9\7\'\2\2\u00b9\u00ba\5\26\f\2\u00ba\u00bb\b\13\1\2\u00bb\u00c8"+
		"\3\2\2\2\u00bc\u00bd\5\26\f\2\u00bd\u00be\7\26\2\2\u00be\u00bf\5\26\f"+
		"\2\u00bf\u00c0\b\13\1\2\u00c0\u00c8\3\2\2\2\u00c1\u00c2\7\36\2\2\u00c2"+
		"\u00c3\5\24\13\2\u00c3\u00c4\7\20\2\2\u00c4\u00c8\3\2\2\2\u00c5\u00c8"+
		"\7$\2\2\u00c6\u00c8\7\b\2\2\u00c7\u008b\3\2\2\2\u00c7\u008e\3\2\2\2\u00c7"+
		"\u0094\3\2\2\2\u00c7\u0099\3\2\2\2\u00c7\u009e\3\2\2\2\u00c7\u00a3\3\2"+
		"\2\2\u00c7\u00a8\3\2\2\2\u00c7\u00ad\3\2\2\2\u00c7\u00b2\3\2\2\2\u00c7"+
		"\u00b7\3\2\2\2\u00c7\u00bc\3\2\2\2\u00c7\u00c1\3\2\2\2\u00c7\u00c5\3\2"+
		"\2\2\u00c7\u00c6\3\2\2\2\u00c8\u00d7\3\2\2\2\u00c9\u00ca\6\13\2\3\u00ca"+
		"\u00cb\7)\2\2\u00cb\u00d6\5\24\13\2\u00cc\u00cd\6\13\3\3\u00cd\u00ce\7"+
		",\2\2\u00ce\u00d6\5\24\13\2\u00cf\u00d0\6\13\4\3\u00d0\u00d1\7 \2\2\u00d1"+
		"\u00d6\5\24\13\2\u00d2\u00d3\6\13\5\3\u00d3\u00d4\7\17\2\2\u00d4\u00d6"+
		"\5\24\13\2\u00d5\u00c9\3\2\2\2\u00d5\u00cc\3\2\2\2\u00d5\u00cf\3\2\2\2"+
		"\u00d5\u00d2\3\2\2\2\u00d6\u00d9\3\2\2\2\u00d7\u00d5\3\2\2\2\u00d7\u00d8"+
		"\3\2\2\2\u00d8\25\3\2\2\2\u00d9\u00d7\3\2\2\2\u00da\u00db\b\f\1\2\u00db"+
		"\u00dc\5\30\r\2\u00dc\u00dd\5\26\f\2\u00dd\u00de\b\f\1\2\u00de\u0115\3"+
		"\2\2\2\u00df\u00e0\7(\2\2\u00e0\u0115\5\26\f\2\u00e1\u00e2\7\64\2\2\u00e2"+
		"\u0115\b\f\1\2\u00e3\u00e4\7\65\2\2\u00e4\u0115\b\f\1\2\u00e5\u00e9\7"+
		":\2\2\u00e6\u00e7\5\26\f\2\u00e7\u00e8\b\f\1\2\u00e8\u00ea\3\2\2\2\u00e9"+
		"\u00e6\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea\u00f1\3\2\2\2\u00eb\u00ec\7\35"+
		"\2\2\u00ec\u00ed\5\26\f\2\u00ed\u00ee\b\f\1\2\u00ee\u00f0\3\2\2\2\u00ef"+
		"\u00eb\3\2\2\2\u00f0\u00f3\3\2\2\2\u00f1\u00ef\3\2\2\2\u00f1\u00f2\3\2"+
		"\2\2\u00f2\u00f4\3\2\2\2\u00f3\u00f1\3\2\2\2\u00f4\u00f5\7;\2\2\u00f5"+
		"\u0115\b\f\1\2\u00f6\u00f7\7:\2\2\u00f7\u00f8\b\f\1\2\u00f8\u00f9\5\16"+
		"\b\2\u00f9\u00ff\b\f\1\2\u00fa\u00fb\7\32\2\2\u00fb\u00fc\b\f\1\2\u00fc"+
		"\u00fd\5\24\13\2\u00fd\u00fe\b\f\1\2\u00fe\u0100\3\2\2\2\u00ff\u00fa\3"+
		"\2\2\2\u00ff\u0100\3\2\2\2\u0100\u0106\3\2\2\2\u0101\u0102\7\21\2\2\u0102"+
		"\u0103\b\f\1\2\u0103\u0104\5\26\f\2\u0104\u0105\b\f\1\2\u0105\u0107\3"+
		"\2\2\2\u0106\u0101\3\2\2\2\u0106\u0107\3\2\2\2\u0107\u0108\3\2\2\2\u0108"+
		"\u0109\7;\2\2\u0109\u010a\b\f\1\2\u010a\u010b\b\f\1\2\u010b\u0115\3\2"+
		"\2\2\u010c\u010d\7\36\2\2\u010d\u010e\5\26\f\2\u010e\u010f\7\20\2\2\u010f"+
		"\u0110\b\f\1\2\u0110\u0115\3\2\2\2\u0111\u0112\7\25\2\2\u0112\u0115\b"+
		"\f\1\2\u0113\u0115\7\60\2\2\u0114\u00da\3\2\2\2\u0114\u00df\3\2\2\2\u0114"+
		"\u00e1\3\2\2\2\u0114\u00e3\3\2\2\2\u0114\u00e5\3\2\2\2\u0114\u00f6\3\2"+
		"\2\2\u0114\u010c\3\2\2\2\u0114\u0111\3\2\2\2\u0114\u0113\3\2\2\2\u0115"+
		"\u0145\3\2\2\2\u0116\u0117\6\f\6\3\u0117\u0118\7\34\2\2\u0118\u0119\5"+
		"\26\f\2\u0119\u011a\b\f\1\2\u011a\u0144\3\2\2\2\u011b\u011c\6\f\7\3\u011c"+
		"\u011d\7\6\2\2\u011d\u011e\5\26\f\2\u011e\u011f\b\f\1\2\u011f\u0144\3"+
		"\2\2\2\u0120\u0121\6\f\b\3\u0121\u0122\7\f\2\2\u0122\u0123\5\26\f\2\u0123"+
		"\u0124\b\f\1\2\u0124\u0144\3\2\2\2\u0125\u0126\6\f\t\3\u0126\u0127\7+"+
		"\2\2\u0127\u0128\5\26\f\2\u0128\u0129\b\f\1\2\u0129\u0144\3\2\2\2\u012a"+
		"\u012b\6\f\n\3\u012b\u012c\7\62\2\2\u012c\u012d\5\26\f\2\u012d\u012e\b"+
		"\f\1\2\u012e\u0144\3\2\2\2\u012f\u0130\6\f\13\3\u0130\u0131\7\63\2\2\u0131"+
		"\u0132\5\26\f\2\u0132\u0133\b\f\1\2\u0133\u0144\3\2\2\2\u0134\u0135\6"+
		"\f\f\3\u0135\u0136\7\13\2\2\u0136\u0137\5\26\f\2\u0137\u0138\b\f\1\2\u0138"+
		"\u0144\3\2\2\2\u0139\u013a\6\f\r\3\u013a\u013b\7\67\2\2\u013b\u013c\5"+
		"\26\f\2\u013c\u013d\b\f\1\2\u013d\u0144\3\2\2\2\u013e\u013f\6\f\16\3\u013f"+
		"\u0140\7\66\2\2\u0140\u0141\5\26\f\2\u0141\u0142\b\f\1\2\u0142\u0144\3"+
		"\2\2\2\u0143\u0116\3\2\2\2\u0143\u011b\3\2\2\2\u0143\u0120\3\2\2\2\u0143"+
		"\u0125\3\2\2\2\u0143\u012a\3\2\2\2\u0143\u012f\3\2\2\2\u0143\u0134\3\2"+
		"\2\2\u0143\u0139\3\2\2\2\u0143\u013e\3\2\2\2\u0144\u0147\3\2\2\2\u0145"+
		"\u0143\3\2\2\2\u0145\u0146\3\2\2\2\u0146\27\3\2\2\2\u0147\u0145\3\2\2"+
		"\2\u0148\u0149\t\3\2\2\u0149\31\3\2\2\2\31\36#\66<@HUZ^env\u0081\u00c7"+
		"\u00d5\u00d7\u00e9\u00f1\u00ff\u0106\u0114\u0143\u0145";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}