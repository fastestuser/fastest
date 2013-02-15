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
		T__40=1, T__39=2, T__38=3, T__37=4, T__36=5, T__35=6, T__34=7, T__33=8, 
		T__32=9, T__31=10, T__30=11, T__29=12, T__28=13, T__27=14, T__26=15, T__25=16, 
		T__24=17, T__23=18, T__22=19, T__21=20, T__20=21, T__19=22, T__18=23, 
		T__17=24, T__16=25, T__15=26, T__14=27, T__13=28, T__12=29, T__11=30, 
		T__10=31, T__9=32, T__8=33, T__7=34, T__6=35, T__5=36, T__4=37, T__3=38, 
		T__2=39, T__1=40, T__0=41, NAME=42, NUM=43, IN_FUN_P3=44, IN_FUN_P4=45, 
		PRE_GEN=46, NL=47, WS=48, SETSTART=49, SETEND=50, SKIP=51;
	public static final String[] tokenNames = {
		"<INVALID>", "'\\lnot'", "','", "'\\rel'", "'('", "':'", "'<'", "'\\pfun'", 
		"'false'", "'\\lor'", "'\\dom'", "'\\end{schema}'", "'\\end{zed}'", "'\\upto'", 
		"'\\in'", "'}'", "'\\begin{schema}{'", "'\\begin{axdef}'", "'true'", "'\\notin'", 
		"'\\subset'", "'\\power'", "')'", "'\\iff'", "'\\land'", "'\\end{axdef}'", 
		"'@'", "'\\implies'", "'\\fun'", "'='", "'\\leq'", "';'", "'\\neq'", "'\\nat'", 
		"'>'", "'\\geq'", "'\\where'", "'\\begin{zed}'", "'\\num'", "'~'", "'|'", 
		"'\\mapsto'", "NAME", "NUM", "IN_FUN_P3", "IN_FUN_P4", "PRE_GEN", "NL", 
		"WS", "'\\{'", "'\\}'", "SKIP"
	};
	public static final int
		RULE_specification = 0, RULE_paragraph = 1, RULE_schemaText = 2, RULE_declPart = 3, 
		RULE_declaration = 4, RULE_declName = 5, RULE_predicate = 6, RULE_expression = 7;
	public static final String[] ruleNames = {
		"specification", "paragraph", "schemaText", "declPart", "declaration", 
		"declName", "predicate", "expression"
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

		public void print(String c) {
			if (modoSetExpression == 0) 
				System.out.println(c + " & ");
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
			setState(23); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(16); paragraph();
				setState(20);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(17); match(NL);
					}
					}
					setState(22);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(25); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 16) | (1L << 17) | (1L << 37))) != 0) );
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
		public TerminalNode NAME() { return getToken(ExprParser.NAME, 0); }
		public List<TerminalNode> NL() { return getTokens(ExprParser.NL); }
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
		try {
			setState(43);
			switch (_input.LA(1)) {
			case 16:
				enterOuterAlt(_localctx, 1);
				{
				setState(27); match(16);
				setState(28); match(NAME);
				setState(29); match(15);
				setState(30); schemaText();
				setState(31); match(11);
				}
				break;
			case 37:
				enterOuterAlt(_localctx, 2);
				{
				setState(33); match(37);
				setState(34); schemaText();
				setState(35); match(12);
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 3);
				{
				setState(37); match(17);
				setState(38); match(NL);
				setState(39); declPart();
				setState(40); match(NL);
				setState(41); match(25);
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
		enterRule(_localctx, 4, RULE_schemaText);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(45); match(NL);
			setState(49);
			_la = _input.LA(1);
			if (_la==NAME) {
				{
				setState(46); declPart();
				setState(47); match(NL);
				}
			}

			setState(51); match(36);
			setState(52); match(NL);
			setState(58);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 4) | (1L << 8) | (1L << 18) | (1L << 21) | (1L << 33) | (1L << 38) | (1L << NAME) | (1L << NUM) | (1L << PRE_GEN) | (1L << SETSTART))) != 0)) {
				{
				{
				setState(53); predicate(0);
				setState(54); match(NL);
				}
				}
				setState(60);
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
		enterRule(_localctx, 6, RULE_declPart);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(61); declaration();
			setState(66);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(62);
					_la = _input.LA(1);
					if ( !(_la==31 || _la==NL) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					setState(63); declaration();
					}
					} 
				}
				setState(68);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
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
		enterRule(_localctx, 8, RULE_declaration);
		((DeclarationContext)getInvokingContext(4)).vars =  new ArrayList();
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69); ((DeclarationContext)_localctx).a = declName();
			((DeclarationContext)getInvokingContext(4)).vars.add((((DeclarationContext)_localctx).a!=null?_input.getText(((DeclarationContext)_localctx).a.start,((DeclarationContext)_localctx).a.stop):null));
			setState(77);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==2) {
				{
				{
				setState(71); match(2);
				setState(72); ((DeclarationContext)_localctx).b = declName();
				((DeclarationContext)getInvokingContext(4)).vars.add((((DeclarationContext)_localctx).b!=null?_input.getText(((DeclarationContext)_localctx).b.start,((DeclarationContext)_localctx).b.stop):null));
				}
				}
				setState(79);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(80); match(5);
			type = "";
			setState(82); expression(0);

					while( !((DeclarationContext)getInvokingContext(4)).vars.isEmpty() ) {
						String var = (String) ((DeclarationContext)getInvokingContext(4)).vars.remove(0);
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
		enterRule(_localctx, 10, RULE_declName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85); match(NAME);
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
		int _startState = 12;
		enterRecursionRule(_localctx, RULE_predicate);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				setState(88); match(1);
				setState(89); predicate(18);
				}
				break;

			case 2:
				{
				setState(90); ((PredicateContext)_localctx).e1 = expression(0);
				setState(91); match(14);
				setState(92); match(10);
				setState(93); ((PredicateContext)_localctx).e2 = expression(0);
					String a, b;
						a = (String)memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = (String)memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						print("in_dom(" + a + "," + b + ")");
					
				}
				break;

			case 3:
				{
				setState(96); ((PredicateContext)_localctx).e1 = expression(0);
				setState(97); match(14);
				setState(98); ((PredicateContext)_localctx).e2 = expression(0);

						String a, b;
						a = (String)memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = (String)memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						print(a + " in " + b);
					
				}
				break;

			case 4:
				{
				setState(101); ((PredicateContext)_localctx).e1 = expression(0);
				setState(102); match(19);
				setState(103); ((PredicateContext)_localctx).e2 = expression(0);

						String a, b;
						a = (String)memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = (String)memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						print(a + " nin " + b);
					
				}
				break;

			case 5:
				{
				setState(106); ((PredicateContext)_localctx).e1 = expression(0);
				setState(107); match(6);
				setState(108); ((PredicateContext)_localctx).e2 = expression(0);

						String a, b;
						a = (String)memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = (String)memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						print(a + " < " + b);
					
				}
				break;

			case 6:
				{
				setState(111); ((PredicateContext)_localctx).e1 = expression(0);
				setState(112); match(34);
				setState(113); ((PredicateContext)_localctx).e2 = expression(0);

						String a, b;
						a = (String)memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = (String)memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						print(a + " > " + b);
					
				}
				break;

			case 7:
				{
				setState(116); ((PredicateContext)_localctx).e1 = expression(0);
				setState(117); match(30);
				setState(118); ((PredicateContext)_localctx).e2 = expression(0);

						String a, b;
						a = (String)memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = (String)memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						print(a + " =< " + b);
					
				}
				break;

			case 8:
				{
				setState(121); ((PredicateContext)_localctx).e1 = expression(0);
				setState(122); match(35);
				setState(123); ((PredicateContext)_localctx).e2 = expression(0);

						String a, b;
						a = (String)memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = (String)memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						print(a + " =< " + b);
					
				}
				break;

			case 9:
				{
				setState(126); ((PredicateContext)_localctx).e1 = expression(0);
				setState(127); match(29);
				setState(128); ((PredicateContext)_localctx).e2 = expression(0);

						String a, b;
						a = (String)memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = (String)memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						print(a + " = " + b);
					
				}
				break;

			case 10:
				{
				setState(131); ((PredicateContext)_localctx).e1 = expression(0);
				setState(132); match(20);
				setState(133); ((PredicateContext)_localctx).e2 = expression(0);

						String a, b;
						a = (String)memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = (String)memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						print("dsubset(" + a + "," + b + ")");
					
				}
				break;

			case 11:
				{
				setState(136); ((PredicateContext)_localctx).e1 = expression(0);
				setState(137); match(32);
				setState(138); ((PredicateContext)_localctx).e2 = expression(0);

						String a, b;
						a = (String)memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = (String)memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						print(a + " neq " + b);
					
				}
				break;

			case 12:
				{
				setState(141); match(4);
				setState(142); predicate(0);
				setState(143); match(22);
				}
				break;

			case 13:
				{
				setState(145); match(18);
				}
				break;

			case 14:
				{
				setState(146); match(8);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(163);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(161);
					switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
					case 1:
						{
						_localctx = new PredicateContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_predicate);
						setState(149);
						if (!(4 >= _localctx._p)) throw new FailedPredicateException(this, "4 >= $_p");
						setState(150); match(23);
						setState(151); predicate(5);
						}
						break;

					case 2:
						{
						_localctx = new PredicateContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_predicate);
						setState(152);
						if (!(3 >= _localctx._p)) throw new FailedPredicateException(this, "3 >= $_p");
						setState(153); match(27);
						setState(154); predicate(4);
						}
						break;

					case 3:
						{
						_localctx = new PredicateContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_predicate);
						setState(155);
						if (!(2 >= _localctx._p)) throw new FailedPredicateException(this, "2 >= $_p");
						setState(156); match(9);
						setState(157); predicate(3);
						}
						break;

					case 4:
						{
						_localctx = new PredicateContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_predicate);
						setState(158);
						if (!(1 >= _localctx._p)) throw new FailedPredicateException(this, "1 >= $_p");
						setState(159); match(24);
						setState(160); predicate(2);
						}
						break;
					}
					} 
				}
				setState(165);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
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
		public Token PRE_GEN;
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
		public TerminalNode PRE_GEN() { return getToken(ExprParser.PRE_GEN, 0); }
		public TerminalNode NAME() { return getToken(ExprParser.NAME, 0); }
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public PredicateContext predicate() {
			return getRuleContext(PredicateContext.class,0);
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
		int _startState = 14;
		enterRecursionRule(_localctx, RULE_expression);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(224);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				setState(167); ((ExpressionContext)_localctx).PRE_GEN = match(PRE_GEN);
				setState(168); ((ExpressionContext)_localctx).e = expression(11);

						String a;
						a = (String)memory.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null));
						
						if ((((ExpressionContext)_localctx).PRE_GEN!=null?((ExpressionContext)_localctx).PRE_GEN.getText():null).equals("\\#")){
							if (memory.get("\\#" + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null)) == null) {
								String newVarName = "VAR" + varNumber;
								varNumber++;
								memory.put("\\#" + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), newVarName);
								print("prolog_call(length(" + a + "," + newVarName + "))");
							}
						}
						else if ((((ExpressionContext)_localctx).PRE_GEN!=null?((ExpressionContext)_localctx).PRE_GEN.getText():null).equals("\\dom")){
							if (memory.get("\\dom" + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null)) == null) {
								String newVarName = "VAR" + varNumber;
								varNumber++;
								memory.put("\\dom" + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), newVarName);
								String e = (String) memory.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null));
								print("dom(" + e + "," + newVarName + ")");
							}
						}
						else if ((((ExpressionContext)_localctx).PRE_GEN!=null?((ExpressionContext)_localctx).PRE_GEN.getText():null).equals("\\seq")) {
							type="list";
						}
					
				}
				break;

			case 2:
				{
				setState(171); match(21);
				setState(172); expression(8);
				}
				break;

			case 3:
				{
				setState(173); ((ExpressionContext)_localctx).NAME = match(NAME);

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
				setState(175); ((ExpressionContext)_localctx).NUM = match(NUM);

						if (memory.get((((ExpressionContext)_localctx).NUM!=null?((ExpressionContext)_localctx).NUM.getText():null)) == null)
							memory.put((((ExpressionContext)_localctx).NUM!=null?((ExpressionContext)_localctx).NUM.getText():null), (((ExpressionContext)_localctx).NUM!=null?((ExpressionContext)_localctx).NUM.getText():null));
					
				}
				break;

			case 5:
				{
				setState(177); ((ExpressionContext)_localctx).SETSTART = match(SETSTART);
				setState(181);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 4) | (1L << 21) | (1L << 33) | (1L << 38) | (1L << NAME) | (1L << NUM) | (1L << PRE_GEN) | (1L << SETSTART))) != 0)) {
					{
					setState(178); ((ExpressionContext)_localctx).a = expression(0);
					_localctx.setVars.add((((ExpressionContext)_localctx).a!=null?_input.getText(((ExpressionContext)_localctx).a.start,((ExpressionContext)_localctx).a.stop):null));
					}
				}

				setState(189);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==2) {
					{
					{
					setState(183); match(2);
					setState(184); ((ExpressionContext)_localctx).b = expression(0);
					_localctx.setVars.add((((ExpressionContext)_localctx).b!=null?_input.getText(((ExpressionContext)_localctx).b.start,((ExpressionContext)_localctx).b.stop):null));
					}
					}
					setState(191);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(192); ((ExpressionContext)_localctx).SETEND = match(SETEND);
					
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
				setState(194); ((ExpressionContext)_localctx).SETSTART = match(SETSTART);
				modoSetExpression=1; setExpressionDecl = ""; setExpressionPred = ""; setExpressionExpr = ""; setExpressionVars = new ArrayList();
				setState(196); ((ExpressionContext)_localctx).declPart = declPart();
				((ExpressionContext)_localctx).externalName =  (((ExpressionContext)_localctx).SETSTART!=null?((ExpressionContext)_localctx).SETSTART.getText():null) + (((ExpressionContext)_localctx).declPart!=null?_input.getText(((ExpressionContext)_localctx).declPart.start,((ExpressionContext)_localctx).declPart.stop):null);
				setState(203);
				_la = _input.LA(1);
				if (_la==40) {
					{
					setState(198); match(40);
					modoSetExpression=2;
					setState(200); ((ExpressionContext)_localctx).predicate = predicate(0);
					((ExpressionContext)_localctx).externalName =  _localctx.externalName.concat("|" + (((ExpressionContext)_localctx).predicate!=null?_input.getText(((ExpressionContext)_localctx).predicate.start,((ExpressionContext)_localctx).predicate.stop):null));
					}
				}

				setState(210);
				_la = _input.LA(1);
				if (_la==26) {
					{
					setState(205); match(26);
					modoSetExpression=3;
					setState(207); ((ExpressionContext)_localctx).c = expression(0);
					((ExpressionContext)_localctx).externalName =  _localctx.externalName.concat("@" + (((ExpressionContext)_localctx).c!=null?_input.getText(((ExpressionContext)_localctx).c.start,((ExpressionContext)_localctx).c.stop):null));
					}
				}

				setState(212); ((ExpressionContext)_localctx).SETEND = match(SETEND);
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
				setState(216); match(4);
				setState(217); ((ExpressionContext)_localctx).e = expression(0);
				setState(218); match(22);

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
				setState(221); match(33);
					
						if (memory.get("\\nat") == null) {
							memory.put("\\nat", "NAT");
							print("NAT = int(0, 10000000000)");
						}	
					
				}
				break;

			case 9:
				{
				setState(223); match(38);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(268);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(266);
					switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(226);
						if (!(17 >= _localctx._p)) throw new FailedPredicateException(this, "17 >= $_p");
						setState(227); match(3);
						setState(228); expression(18);
						type="is_rel";
						}
						break;

					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(231);
						if (!(16 >= _localctx._p)) throw new FailedPredicateException(this, "16 >= $_p");
						setState(232); match(7);
						setState(233); expression(17);
						type="is_pfun";
						}
						break;

					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(236);
						if (!(15 >= _localctx._p)) throw new FailedPredicateException(this, "15 >= $_p");
						setState(237); match(28);
						setState(238); expression(16);
						type="is_fun";
						}
						break;

					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(241);
						if (!(14 >= _localctx._p)) throw new FailedPredicateException(this, "14 >= $_p");
						setState(242); match(39);
						setState(243); ((ExpressionContext)_localctx).e2 = expression(15);

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
						setState(246);
						if (!(13 >= _localctx._p)) throw new FailedPredicateException(this, "13 >= $_p");
						setState(247); match(41);
						setState(248); ((ExpressionContext)_localctx).e2 = expression(14);

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
						setState(251);
						if (!(12 >= _localctx._p)) throw new FailedPredicateException(this, "12 >= $_p");
						setState(252); match(13);
						setState(253); ((ExpressionContext)_localctx).e2 = expression(13);

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
						setState(256);
						if (!(10 >= _localctx._p)) throw new FailedPredicateException(this, "10 >= $_p");
						setState(257); ((ExpressionContext)_localctx).IN_FUN_P4 = match(IN_FUN_P4);
						setState(258); ((ExpressionContext)_localctx).e2 = expression(11);

						          		String a, b;
						          		a = (String)memory.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null));
						          		b = (String)memory.get((((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null));
						          		
						          		if ((((ExpressionContext)_localctx).IN_FUN_P4!=null?((ExpressionContext)_localctx).IN_FUN_P4.getText():null).equals("*")){
						          			memory.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "*" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), a + "*" + b);
						          		}
						          		else if ((((ExpressionContext)_localctx).IN_FUN_P4!=null?((ExpressionContext)_localctx).IN_FUN_P4.getText():null).equals("\\div")) {
						          			memory.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\div" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), "div(" + a + "," + b + ")");
						          		}
						          		else if ((((ExpressionContext)_localctx).IN_FUN_P4!=null?((ExpressionContext)_localctx).IN_FUN_P4.getText():null).equals("\\mod")){
						          			memory.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\mod" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), "mod(" + a + "," + b + ")");
						          		}
						          		else if ((((ExpressionContext)_localctx).IN_FUN_P4!=null?((ExpressionContext)_localctx).IN_FUN_P4.getText():null).equals("\\cap")){
						          			if (memory.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\cap" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null)) == null) {
						          				String newVarName = "VAR" + varNumber;
						          				varNumber++;
						          				memory.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\cap" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          				print("dinters(" + a + "," + b + "," + newVarName + ")");
						          			}
						          		}
						          	
						}
						break;

					case 8:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(261);
						if (!(9 >= _localctx._p)) throw new FailedPredicateException(this, "9 >= $_p");
						setState(262); ((ExpressionContext)_localctx).IN_FUN_P3 = match(IN_FUN_P3);
						setState(263); ((ExpressionContext)_localctx).e2 = expression(10);

						          		String a, b;
						          		a = (String)memory.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null));
						          		b = (String)memory.get((((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null));
						          		
						          		if (((((ExpressionContext)_localctx).IN_FUN_P3!=null?((ExpressionContext)_localctx).IN_FUN_P3.getText():null).equals("+")) || ((((ExpressionContext)_localctx).IN_FUN_P3!=null?((ExpressionContext)_localctx).IN_FUN_P3.getText():null).equals("-")))
						          			memory.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + (((ExpressionContext)_localctx).IN_FUN_P3!=null?((ExpressionContext)_localctx).IN_FUN_P3.getText():null) + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), a + (((ExpressionContext)_localctx).IN_FUN_P3!=null?((ExpressionContext)_localctx).IN_FUN_P3.getText():null) + b);
						          		
						          		else if ((((ExpressionContext)_localctx).IN_FUN_P3!=null?((ExpressionContext)_localctx).IN_FUN_P3.getText():null).equals("\\cup"))
						          			if (memory.get( (((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\cup" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null)) == null) {
						          				String newVarName = "VAR" + varNumber;
						          				varNumber++;
						          				memory.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\cup" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          				print("dunion(" + a + "," + b + "," + newVarName + ")");
						          			}
						          	
						}
						break;
					}
					} 
				}
				setState(270);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 6: return predicate_sempred((PredicateContext)_localctx, predIndex);

		case 7: return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4: return 17 >= _localctx._p;

		case 5: return 16 >= _localctx._p;

		case 6: return 15 >= _localctx._p;

		case 7: return 14 >= _localctx._p;

		case 8: return 13 >= _localctx._p;

		case 9: return 12 >= _localctx._p;

		case 10: return 10 >= _localctx._p;

		case 11: return 9 >= _localctx._p;
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
		"\2\3\65\u0112\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b"+
		"\4\t\t\t\3\2\3\2\7\2\25\n\2\f\2\16\2\30\13\2\6\2\32\n\2\r\2\16\2\33\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3.\n"+
		"\3\3\4\3\4\3\4\3\4\5\4\64\n\4\3\4\3\4\3\4\3\4\3\4\7\4;\n\4\f\4\16\4>\13"+
		"\4\3\5\3\5\3\5\7\5C\n\5\f\5\16\5F\13\5\3\6\3\6\3\6\3\6\3\6\3\6\7\6N\n"+
		"\6\f\6\16\6Q\13\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\5\b\u0096\n\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\7"+
		"\b\u00a4\n\b\f\b\16\b\u00a7\13\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\5\t\u00b8\n\t\3\t\3\t\3\t\3\t\7\t\u00be\n\t\f\t"+
		"\16\t\u00c1\13\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u00ce"+
		"\n\t\3\t\3\t\3\t\3\t\3\t\5\t\u00d5\n\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\5\t\u00e3\n\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\7\t\u010d\n\t\f\t\16"+
		"\t\u0110\13\t\3\t\2\n\2\4\6\b\n\f\16\20\2\3\4!!\61\61\u0136\2\31\3\2\2"+
		"\2\4-\3\2\2\2\6/\3\2\2\2\b?\3\2\2\2\nG\3\2\2\2\fW\3\2\2\2\16\u0095\3\2"+
		"\2\2\20\u00e2\3\2\2\2\22\26\5\4\3\2\23\25\7\61\2\2\24\23\3\2\2\2\25\30"+
		"\3\2\2\2\26\24\3\2\2\2\26\27\3\2\2\2\27\32\3\2\2\2\30\26\3\2\2\2\31\22"+
		"\3\2\2\2\32\33\3\2\2\2\33\31\3\2\2\2\33\34\3\2\2\2\34\3\3\2\2\2\35\36"+
		"\7\22\2\2\36\37\7,\2\2\37 \7\21\2\2 !\5\6\4\2!\"\7\r\2\2\".\3\2\2\2#$"+
		"\7\'\2\2$%\5\6\4\2%&\7\16\2\2&.\3\2\2\2\'(\7\23\2\2()\7\61\2\2)*\5\b\5"+
		"\2*+\7\61\2\2+,\7\33\2\2,.\3\2\2\2-\35\3\2\2\2-#\3\2\2\2-\'\3\2\2\2.\5"+
		"\3\2\2\2/\63\7\61\2\2\60\61\5\b\5\2\61\62\7\61\2\2\62\64\3\2\2\2\63\60"+
		"\3\2\2\2\63\64\3\2\2\2\64\65\3\2\2\2\65\66\7&\2\2\66<\7\61\2\2\678\5\16"+
		"\b\289\7\61\2\29;\3\2\2\2:\67\3\2\2\2;>\3\2\2\2<:\3\2\2\2<=\3\2\2\2=\7"+
		"\3\2\2\2><\3\2\2\2?D\5\n\6\2@A\t\2\2\2AC\5\n\6\2B@\3\2\2\2CF\3\2\2\2D"+
		"B\3\2\2\2DE\3\2\2\2E\t\3\2\2\2FD\3\2\2\2GH\5\f\7\2HO\b\6\1\2IJ\7\4\2\2"+
		"JK\5\f\7\2KL\b\6\1\2LN\3\2\2\2MI\3\2\2\2NQ\3\2\2\2OM\3\2\2\2OP\3\2\2\2"+
		"PR\3\2\2\2QO\3\2\2\2RS\7\7\2\2ST\b\6\1\2TU\5\20\t\2UV\b\6\1\2V\13\3\2"+
		"\2\2WX\7,\2\2X\r\3\2\2\2YZ\b\b\1\2Z[\7\3\2\2[\u0096\5\16\b\2\\]\5\20\t"+
		"\2]^\7\20\2\2^_\7\f\2\2_`\5\20\t\2`a\b\b\1\2a\u0096\3\2\2\2bc\5\20\t\2"+
		"cd\7\20\2\2de\5\20\t\2ef\b\b\1\2f\u0096\3\2\2\2gh\5\20\t\2hi\7\25\2\2"+
		"ij\5\20\t\2jk\b\b\1\2k\u0096\3\2\2\2lm\5\20\t\2mn\7\b\2\2no\5\20\t\2o"+
		"p\b\b\1\2p\u0096\3\2\2\2qr\5\20\t\2rs\7$\2\2st\5\20\t\2tu\b\b\1\2u\u0096"+
		"\3\2\2\2vw\5\20\t\2wx\7 \2\2xy\5\20\t\2yz\b\b\1\2z\u0096\3\2\2\2{|\5\20"+
		"\t\2|}\7%\2\2}~\5\20\t\2~\177\b\b\1\2\177\u0096\3\2\2\2\u0080\u0081\5"+
		"\20\t\2\u0081\u0082\7\37\2\2\u0082\u0083\5\20\t\2\u0083\u0084\b\b\1\2"+
		"\u0084\u0096\3\2\2\2\u0085\u0086\5\20\t\2\u0086\u0087\7\26\2\2\u0087\u0088"+
		"\5\20\t\2\u0088\u0089\b\b\1\2\u0089\u0096\3\2\2\2\u008a\u008b\5\20\t\2"+
		"\u008b\u008c\7\"\2\2\u008c\u008d\5\20\t\2\u008d\u008e\b\b\1\2\u008e\u0096"+
		"\3\2\2\2\u008f\u0090\7\6\2\2\u0090\u0091\5\16\b\2\u0091\u0092\7\30\2\2"+
		"\u0092\u0096\3\2\2\2\u0093\u0096\7\24\2\2\u0094\u0096\7\n\2\2\u0095Y\3"+
		"\2\2\2\u0095\\\3\2\2\2\u0095b\3\2\2\2\u0095g\3\2\2\2\u0095l\3\2\2\2\u0095"+
		"q\3\2\2\2\u0095v\3\2\2\2\u0095{\3\2\2\2\u0095\u0080\3\2\2\2\u0095\u0085"+
		"\3\2\2\2\u0095\u008a\3\2\2\2\u0095\u008f\3\2\2\2\u0095\u0093\3\2\2\2\u0095"+
		"\u0094\3\2\2\2\u0096\u00a5\3\2\2\2\u0097\u0098\6\b\2\3\u0098\u0099\7\31"+
		"\2\2\u0099\u00a4\5\16\b\2\u009a\u009b\6\b\3\3\u009b\u009c\7\35\2\2\u009c"+
		"\u00a4\5\16\b\2\u009d\u009e\6\b\4\3\u009e\u009f\7\13\2\2\u009f\u00a4\5"+
		"\16\b\2\u00a0\u00a1\6\b\5\3\u00a1\u00a2\7\32\2\2\u00a2\u00a4\5\16\b\2"+
		"\u00a3\u0097\3\2\2\2\u00a3\u009a\3\2\2\2\u00a3\u009d\3\2\2\2\u00a3\u00a0"+
		"\3\2\2\2\u00a4\u00a7\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6"+
		"\17\3\2\2\2\u00a7\u00a5\3\2\2\2\u00a8\u00a9\b\t\1\2\u00a9\u00aa\7\60\2"+
		"\2\u00aa\u00ab\5\20\t\2\u00ab\u00ac\b\t\1\2\u00ac\u00e3\3\2\2\2\u00ad"+
		"\u00ae\7\27\2\2\u00ae\u00e3\5\20\t\2\u00af\u00b0\7,\2\2\u00b0\u00e3\b"+
		"\t\1\2\u00b1\u00b2\7-\2\2\u00b2\u00e3\b\t\1\2\u00b3\u00b7\7\63\2\2\u00b4"+
		"\u00b5\5\20\t\2\u00b5\u00b6\b\t\1\2\u00b6\u00b8\3\2\2\2\u00b7\u00b4\3"+
		"\2\2\2\u00b7\u00b8\3\2\2\2\u00b8\u00bf\3\2\2\2\u00b9\u00ba\7\4\2\2\u00ba"+
		"\u00bb\5\20\t\2\u00bb\u00bc\b\t\1\2\u00bc\u00be\3\2\2\2\u00bd\u00b9\3"+
		"\2\2\2\u00be\u00c1\3\2\2\2\u00bf\u00bd\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0"+
		"\u00c2\3\2\2\2\u00c1\u00bf\3\2\2\2\u00c2\u00c3\7\64\2\2\u00c3\u00e3\b"+
		"\t\1\2\u00c4\u00c5\7\63\2\2\u00c5\u00c6\b\t\1\2\u00c6\u00c7\5\b\5\2\u00c7"+
		"\u00cd\b\t\1\2\u00c8\u00c9\7*\2\2\u00c9\u00ca\b\t\1\2\u00ca\u00cb\5\16"+
		"\b\2\u00cb\u00cc\b\t\1\2\u00cc\u00ce\3\2\2\2\u00cd\u00c8\3\2\2\2\u00cd"+
		"\u00ce\3\2\2\2\u00ce\u00d4\3\2\2\2\u00cf\u00d0\7\34\2\2\u00d0\u00d1\b"+
		"\t\1\2\u00d1\u00d2\5\20\t\2\u00d2\u00d3\b\t\1\2\u00d3\u00d5\3\2\2\2\u00d4"+
		"\u00cf\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6\u00d7\7\64"+
		"\2\2\u00d7\u00d8\b\t\1\2\u00d8\u00d9\b\t\1\2\u00d9\u00e3\3\2\2\2\u00da"+
		"\u00db\7\6\2\2\u00db\u00dc\5\20\t\2\u00dc\u00dd\7\30\2\2\u00dd\u00de\b"+
		"\t\1\2\u00de\u00e3\3\2\2\2\u00df\u00e0\7#\2\2\u00e0\u00e3\b\t\1\2\u00e1"+
		"\u00e3\7(\2\2\u00e2\u00a8\3\2\2\2\u00e2\u00ad\3\2\2\2\u00e2\u00af\3\2"+
		"\2\2\u00e2\u00b1\3\2\2\2\u00e2\u00b3\3\2\2\2\u00e2\u00c4\3\2\2\2\u00e2"+
		"\u00da\3\2\2\2\u00e2\u00df\3\2\2\2\u00e2\u00e1\3\2\2\2\u00e3\u010e\3\2"+
		"\2\2\u00e4\u00e5\6\t\6\3\u00e5\u00e6\7\5\2\2\u00e6\u00e7\5\20\t\2\u00e7"+
		"\u00e8\b\t\1\2\u00e8\u010d\3\2\2\2\u00e9\u00ea\6\t\7\3\u00ea\u00eb\7\t"+
		"\2\2\u00eb\u00ec\5\20\t\2\u00ec\u00ed\b\t\1\2\u00ed\u010d\3\2\2\2\u00ee"+
		"\u00ef\6\t\b\3\u00ef\u00f0\7\36\2\2\u00f0\u00f1\5\20\t\2\u00f1\u00f2\b"+
		"\t\1\2\u00f2\u010d\3\2\2\2\u00f3\u00f4\6\t\t\3\u00f4\u00f5\7)\2\2\u00f5"+
		"\u00f6\5\20\t\2\u00f6\u00f7\b\t\1\2\u00f7\u010d\3\2\2\2\u00f8\u00f9\6"+
		"\t\n\3\u00f9\u00fa\7+\2\2\u00fa\u00fb\5\20\t\2\u00fb\u00fc\b\t\1\2\u00fc"+
		"\u010d\3\2\2\2\u00fd\u00fe\6\t\13\3\u00fe\u00ff\7\17\2\2\u00ff\u0100\5"+
		"\20\t\2\u0100\u0101\b\t\1\2\u0101\u010d\3\2\2\2\u0102\u0103\6\t\f\3\u0103"+
		"\u0104\7/\2\2\u0104\u0105\5\20\t\2\u0105\u0106\b\t\1\2\u0106\u010d\3\2"+
		"\2\2\u0107\u0108\6\t\r\3\u0108\u0109\7.\2\2\u0109\u010a\5\20\t\2\u010a"+
		"\u010b\b\t\1\2\u010b\u010d\3\2\2\2\u010c\u00e4\3\2\2\2\u010c\u00e9\3\2"+
		"\2\2\u010c\u00ee\3\2\2\2\u010c\u00f3\3\2\2\2\u010c\u00f8\3\2\2\2\u010c"+
		"\u00fd\3\2\2\2\u010c\u0102\3\2\2\2\u010c\u0107\3\2\2\2\u010d\u0110\3\2"+
		"\2\2\u010e\u010c\3\2\2\2\u010e\u010f\3\2\2\2\u010f\21\3\2\2\2\u0110\u010e"+
		"\3\2\2\2\23\26\33-\63<DO\u0095\u00a3\u00a5\u00b7\u00bf\u00cd\u00d4\u00e2"+
		"\u010c\u010e";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}