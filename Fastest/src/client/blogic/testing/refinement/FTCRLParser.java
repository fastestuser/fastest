// Generated from FTCRL.g4 by ANTLR 4.0

package client.blogic.testing.refinement;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class FTCRLParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, Q=2, EQUALQAUAL=3, PLUSPLUS=4, UNDERSCORE=5, DOTA=6, L=7, R=8, 
		LB=9, RB=10, SLASH=11, LSB=12, RSB=13, LCB=14, RCB=15, ARROBA=16, CARD=17, 
		STRING=18, ZERO=19, PLUS=20, MINUS=21, DIV=22, MOD=23, SEMICOLON=24, COMMA=25, 
		STR=26, CUP=27, DOT=28, FILE=29, TABLE=30, ENUM=31, REF=32, SLL=33, DLL=34, 
		CLL=35, DCLL=36, LIST=37, DOM=38, RAN=39, ELEM=40, RECORD=41, MAPPING=42, 
		ARRAY=43, WITH=44, AS=45, AUTOFILL=46, EPILOGUE=47, AEPILOGUE=48, MODULE=49, 
		UUT=50, PLCODE=51, LAWS=52, PREAMBLE=53, APREAMBLE=54, RRULE=55, DIGIT=56, 
		LETTER=57, COLON=58, NL=59, WS=60;
	public static final String[] tokenNames = {
		"<INVALID>", "'==>'", "'?'", "'=='", "'++'", "'_'", "'.*'", "'<'", "'>'", 
		"'('", "')'", "'/'", "'['", "']'", "'{'", "'}'", "'@'", "'#'", "STRING", 
		"'0'", "'+'", "'-'", "'div'", "'mod'", "';'", "','", "'STR'", "'@CUP@'", 
		"'.'", "'FILE'", "'TABLE'", "'ENUM'", "'REF'", "'SLL'", "'DLL'", "'CLL'", 
		"'DCLL'", "'LIST'", "'DOM'", "'RAN'", "'ELEM'", "'RECORD'", "'MAPPING'", 
		"'ARRAY'", "'WITH'", "'AS'", "'@AUTOFILL'", "'@EPILOGUE'", "'.@EPILOGUE'", 
		"'MODULE'", "'@UUT'", "'@PLCODE'", "'@LAWS'", "'@PREAMBLE'", "'.@PREAMBLE'", 
		"'@RRULE'", "DIGIT", "LETTER", "':'", "'\n'", "WS"
	};
	public static final int
		RULE_refinementRule = 0, RULE_preamble = 1, RULE_laws = 2, RULE_law = 3, 
		RULE_reference = 4, RULE_plcode = 5, RULE_uut = 6, RULE_epilogue = 7, 
		RULE_synonymLaw = 8, RULE_asSynonym = 9, RULE_withSynonym = 10, RULE_refinementLaw = 11, 
		RULE_refinementSentence = 12, RULE_refinement = 13, RULE_iExprRefinement = 14, 
		RULE_asRefinement = 15, RULE_withRefinement = 16, RULE_exprRefinement = 17, 
		RULE_dataStruct = 18, RULE_sExprRefinement = 19, RULE_zExpr = 20, RULE_zExprSet = 21, 
		RULE_zExprNum = 22, RULE_zExprString = 23, RULE_zExprSeq = 24, RULE_funAppExpr = 25, 
		RULE_dotSetOper = 26, RULE_list = 27, RULE_listType = 28, RULE_reference2 = 29, 
		RULE_number = 30, RULE_enumeration = 31, RULE_table = 32, RULE_file = 33, 
		RULE_name = 34, RULE_lawName = 35, RULE_sName = 36, RULE_iName = 37, RULE_iIdent = 38, 
		RULE_fName = 39, RULE_path = 40, RULE_digit = 41, RULE_string = 42, RULE_setExtension = 43;
	public static final String[] ruleNames = {
		"refinementRule", "preamble", "laws", "law", "reference", "plcode", "uut", 
		"epilogue", "synonymLaw", "asSynonym", "withSynonym", "refinementLaw", 
		"refinementSentence", "refinement", "iExprRefinement", "asRefinement", 
		"withRefinement", "exprRefinement", "dataStruct", "sExprRefinement", "zExpr", 
		"zExprSet", "zExprNum", "zExprString", "zExprSeq", "funAppExpr", "dotSetOper", 
		"list", "listType", "reference2", "number", "enumeration", "table", "file", 
		"name", "lawName", "sName", "iName", "iIdent", "fName", "path", "digit", 
		"string", "setExtension"
	};

	@Override
	public String getGrammarFileName() { return "FTCRL.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public ATN getATN() { return _ATN; }



	public FTCRLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class RefinementRuleContext extends ParserRuleContext {
		public EpilogueContext epilogue() {
			return getRuleContext(EpilogueContext.class,0);
		}
		public List<TerminalNode> NL() { return getTokens(FTCRLParser.NL); }
		public TerminalNode RRULE() { return getToken(FTCRLParser.RRULE, 0); }
		public PreambleContext preamble() {
			return getRuleContext(PreambleContext.class,0);
		}
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public LawsContext laws() {
			return getRuleContext(LawsContext.class,0);
		}
		public PlcodeContext plcode() {
			return getRuleContext(PlcodeContext.class,0);
		}
		public UutContext uut() {
			return getRuleContext(UutContext.class,0);
		}
		public TerminalNode NL(int i) {
			return getToken(FTCRLParser.NL, i);
		}
		public RefinementRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_refinementRule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FTCRLListener ) ((FTCRLListener)listener).enterRefinementRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FTCRLListener ) ((FTCRLListener)listener).exitRefinementRule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FTCRLVisitor ) return ((FTCRLVisitor<? extends T>)visitor).visitRefinementRule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RefinementRuleContext refinementRule() throws RecognitionException {
		RefinementRuleContext _localctx = new RefinementRuleContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_refinementRule);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88); match(RRULE);
			setState(89); name();
			setState(90); match(NL);
			setState(91); preamble();
			setState(92); laws();
			setState(96);
			_la = _input.LA(1);
			if (_la==PLCODE) {
				{
				setState(93); plcode();
				setState(94); match(NL);
				}
			}

			setState(98); uut();
			setState(102);
			_la = _input.LA(1);
			if (_la==EPILOGUE) {
				{
				setState(99); epilogue();
				setState(100); match(NL);
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

	public static class PreambleContext extends ParserRuleContext {
		public TerminalNode APREAMBLE(int i) {
			return getToken(FTCRLParser.APREAMBLE, i);
		}
		public List<TerminalNode> NL() { return getTokens(FTCRLParser.NL); }
		public List<NameContext> name() {
			return getRuleContexts(NameContext.class);
		}
		public NameContext name(int i) {
			return getRuleContext(NameContext.class,i);
		}
		public List<TerminalNode> APREAMBLE() { return getTokens(FTCRLParser.APREAMBLE); }
		public TerminalNode PREAMBLE() { return getToken(FTCRLParser.PREAMBLE, 0); }
		public TerminalNode NL(int i) {
			return getToken(FTCRLParser.NL, i);
		}
		public PreambleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_preamble; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FTCRLListener ) ((FTCRLListener)listener).enterPreamble(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FTCRLListener ) ((FTCRLListener)listener).exitPreamble(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FTCRLVisitor ) return ((FTCRLVisitor<? extends T>)visitor).visitPreamble(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PreambleContext preamble() throws RecognitionException {
		PreambleContext _localctx = new PreambleContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_preamble);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104); match(PREAMBLE);
			setState(105); match(NL);
			setState(112);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LETTER) {
				{
				{
				setState(106); name();
				setState(107); match(APREAMBLE);
				setState(108); match(NL);
				}
				}
				setState(114);
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

	public static class LawsContext extends ParserRuleContext {
		public List<LawContext> law() {
			return getRuleContexts(LawContext.class);
		}
		public ReferenceContext reference(int i) {
			return getRuleContext(ReferenceContext.class,i);
		}
		public TerminalNode DOT(int i) {
			return getToken(FTCRLParser.DOT, i);
		}
		public List<TerminalNode> NL() { return getTokens(FTCRLParser.NL); }
		public List<NameContext> name() {
			return getRuleContexts(NameContext.class);
		}
		public TerminalNode LAWS(int i) {
			return getToken(FTCRLParser.LAWS, i);
		}
		public List<TerminalNode> DOT() { return getTokens(FTCRLParser.DOT); }
		public NameContext name(int i) {
			return getRuleContext(NameContext.class,i);
		}
		public LawContext law(int i) {
			return getRuleContext(LawContext.class,i);
		}
		public List<TerminalNode> LAWS() { return getTokens(FTCRLParser.LAWS); }
		public List<ReferenceContext> reference() {
			return getRuleContexts(ReferenceContext.class);
		}
		public TerminalNode NL(int i) {
			return getToken(FTCRLParser.NL, i);
		}
		public LawsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_laws; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FTCRLListener ) ((FTCRLListener)listener).enterLaws(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FTCRLListener ) ((FTCRLListener)listener).exitLaws(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FTCRLVisitor ) return ((FTCRLVisitor<? extends T>)visitor).visitLaws(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LawsContext laws() throws RecognitionException {
		LawsContext _localctx = new LawsContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_laws);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115); match(LAWS);
			setState(116); match(NL);
			setState(128); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(128);
				switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
				case 1:
					{
					setState(117); law();
					setState(118); match(NL);
					}
					break;

				case 2:
					{
					setState(120); reference();
					setState(121); match(NL);
					}
					break;

				case 3:
					{
					setState(123); name();
					setState(124); match(DOT);
					setState(125); match(LAWS);
					setState(126); match(NL);
					}
					break;
				}
				}
				setState(130); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==LETTER );
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

	public static class LawContext extends ParserRuleContext {
		public TerminalNode COLON() { return getToken(FTCRLParser.COLON, 0); }
		public SynonymLawContext synonymLaw() {
			return getRuleContext(SynonymLawContext.class,0);
		}
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public RefinementLawContext refinementLaw() {
			return getRuleContext(RefinementLawContext.class,0);
		}
		public LawContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_law; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FTCRLListener ) ((FTCRLListener)listener).enterLaw(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FTCRLListener ) ((FTCRLListener)listener).exitLaw(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FTCRLVisitor ) return ((FTCRLVisitor<? extends T>)visitor).visitLaw(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LawContext law() throws RecognitionException {
		LawContext _localctx = new LawContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_law);
		try {
			setState(144);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(135);
				switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
				case 1:
					{
					setState(132); name();
					setState(133); match(COLON);
					}
					break;
				}
				setState(137); synonymLaw();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(141);
				switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
				case 1:
					{
					setState(138); name();
					setState(139); match(COLON);
					}
					break;
				}
				setState(143); refinementLaw();
				}
				break;
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

	public static class ReferenceContext extends ParserRuleContext {
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TerminalNode DOT() { return getToken(FTCRLParser.DOT, 0); }
		public LawNameContext lawName() {
			return getRuleContext(LawNameContext.class,0);
		}
		public ReferenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_reference; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FTCRLListener ) ((FTCRLListener)listener).enterReference(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FTCRLListener ) ((FTCRLListener)listener).exitReference(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FTCRLVisitor ) return ((FTCRLVisitor<? extends T>)visitor).visitReference(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReferenceContext reference() throws RecognitionException {
		ReferenceContext _localctx = new ReferenceContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_reference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146); name();
			setState(147); match(DOT);
			setState(148); lawName();
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

	public static class PlcodeContext extends ParserRuleContext {
		public TerminalNode NL() { return getToken(FTCRLParser.NL, 0); }
		public TerminalNode PLCODE() { return getToken(FTCRLParser.PLCODE, 0); }
		public PlcodeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_plcode; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FTCRLListener ) ((FTCRLListener)listener).enterPlcode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FTCRLListener ) ((FTCRLListener)listener).exitPlcode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FTCRLVisitor ) return ((FTCRLVisitor<? extends T>)visitor).visitPlcode(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PlcodeContext plcode() throws RecognitionException {
		PlcodeContext _localctx = new PlcodeContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_plcode);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(150); match(PLCODE);
			setState(151); match(NL);
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

	public static class UutContext extends ParserRuleContext {
		public TerminalNode LB() { return getToken(FTCRLParser.LB, 0); }
		public TerminalNode COMMA(int i) {
			return getToken(FTCRLParser.COMMA, i);
		}
		public INameContext iName(int i) {
			return getRuleContext(INameContext.class,i);
		}
		public TerminalNode NL() { return getToken(FTCRLParser.NL, 0); }
		public TerminalNode RB() { return getToken(FTCRLParser.RB, 0); }
		public TerminalNode MODULE() { return getToken(FTCRLParser.MODULE, 0); }
		public List<TerminalNode> COMMA() { return getTokens(FTCRLParser.COMMA); }
		public TerminalNode UUT() { return getToken(FTCRLParser.UUT, 0); }
		public List<INameContext> iName() {
			return getRuleContexts(INameContext.class);
		}
		public UutContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_uut; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FTCRLListener ) ((FTCRLListener)listener).enterUut(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FTCRLListener ) ((FTCRLListener)listener).exitUut(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FTCRLVisitor ) return ((FTCRLVisitor<? extends T>)visitor).visitUut(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UutContext uut() throws RecognitionException {
		UutContext _localctx = new UutContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_uut);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(153); match(UUT);
			setState(154); iName();
			setState(155); match(LB);
			setState(157);
			_la = _input.LA(1);
			if (_la==LETTER) {
				{
				setState(156); iName();
				}
			}

			setState(163);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(159); match(COMMA);
				setState(160); iName();
				}
				}
				setState(165);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(166); match(RB);
			setState(169);
			_la = _input.LA(1);
			if (_la==MODULE) {
				{
				setState(167); match(MODULE);
				setState(168); iName();
				}
			}

			setState(172);
			_la = _input.LA(1);
			if (_la==NL) {
				{
				setState(171); match(NL);
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

	public static class EpilogueContext extends ParserRuleContext {
		public List<TerminalNode> AEPILOGUE() { return getTokens(FTCRLParser.AEPILOGUE); }
		public List<TerminalNode> NL() { return getTokens(FTCRLParser.NL); }
		public List<NameContext> name() {
			return getRuleContexts(NameContext.class);
		}
		public NameContext name(int i) {
			return getRuleContext(NameContext.class,i);
		}
		public TerminalNode EPILOGUE() { return getToken(FTCRLParser.EPILOGUE, 0); }
		public TerminalNode AEPILOGUE(int i) {
			return getToken(FTCRLParser.AEPILOGUE, i);
		}
		public TerminalNode NL(int i) {
			return getToken(FTCRLParser.NL, i);
		}
		public EpilogueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_epilogue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FTCRLListener ) ((FTCRLListener)listener).enterEpilogue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FTCRLListener ) ((FTCRLListener)listener).exitEpilogue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FTCRLVisitor ) return ((FTCRLVisitor<? extends T>)visitor).visitEpilogue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EpilogueContext epilogue() throws RecognitionException {
		EpilogueContext _localctx = new EpilogueContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_epilogue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174); match(EPILOGUE);
			setState(175); match(NL);
			setState(180); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(176); name();
				setState(177); match(AEPILOGUE);
				setState(178); match(NL);
				}
				}
				setState(182); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==LETTER );
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

	public static class SynonymLawContext extends ParserRuleContext {
		public WithSynonymContext withSynonym() {
			return getRuleContext(WithSynonymContext.class,0);
		}
		public TerminalNode EQUALQAUAL() { return getToken(FTCRLParser.EQUALQAUAL, 0); }
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public AsSynonymContext asSynonym() {
			return getRuleContext(AsSynonymContext.class,0);
		}
		public SynonymLawContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_synonymLaw; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FTCRLListener ) ((FTCRLListener)listener).enterSynonymLaw(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FTCRLListener ) ((FTCRLListener)listener).exitSynonymLaw(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FTCRLVisitor ) return ((FTCRLVisitor<? extends T>)visitor).visitSynonymLaw(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SynonymLawContext synonymLaw() throws RecognitionException {
		SynonymLawContext _localctx = new SynonymLawContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_synonymLaw);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(184); name();
			setState(185); match(EQUALQAUAL);
			setState(188);
			switch (_input.LA(1)) {
			case FILE:
			case TABLE:
			case ENUM:
			case REF:
			case LIST:
			case RECORD:
			case MAPPING:
			case ARRAY:
				{
				setState(186); asSynonym();
				}
				break;
			case L:
			case LCB:
			case STRING:
			case AUTOFILL:
			case DIGIT:
			case LETTER:
				{
				setState(187); withSynonym();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class AsSynonymContext extends ParserRuleContext {
		public AsRefinementContext asRefinement() {
			return getRuleContext(AsRefinementContext.class,0);
		}
		public AsSynonymContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_asSynonym; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FTCRLListener ) ((FTCRLListener)listener).enterAsSynonym(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FTCRLListener ) ((FTCRLListener)listener).exitAsSynonym(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FTCRLVisitor ) return ((FTCRLVisitor<? extends T>)visitor).visitAsSynonym(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AsSynonymContext asSynonym() throws RecognitionException {
		AsSynonymContext _localctx = new AsSynonymContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_asSynonym);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(190); asRefinement();
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

	public static class WithSynonymContext extends ParserRuleContext {
		public WithRefinementContext withRefinement() {
			return getRuleContext(WithRefinementContext.class,0);
		}
		public WithSynonymContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_withSynonym; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FTCRLListener ) ((FTCRLListener)listener).enterWithSynonym(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FTCRLListener ) ((FTCRLListener)listener).exitWithSynonym(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FTCRLVisitor ) return ((FTCRLVisitor<? extends T>)visitor).visitWithSynonym(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WithSynonymContext withSynonym() throws RecognitionException {
		WithSynonymContext _localctx = new WithSynonymContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_withSynonym);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(192); withRefinement();
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

	public static class RefinementLawContext extends ParserRuleContext {
		public RefinementSentenceContext refinementSentence(int i) {
			return getRuleContext(RefinementSentenceContext.class,i);
		}
		public TerminalNode SEMICOLON(int i) {
			return getToken(FTCRLParser.SEMICOLON, i);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(FTCRLParser.SEMICOLON); }
		public TerminalNode COMMA(int i) {
			return getToken(FTCRLParser.COMMA, i);
		}
		public List<TerminalNode> NL() { return getTokens(FTCRLParser.NL); }
		public List<TerminalNode> COMMA() { return getTokens(FTCRLParser.COMMA); }
		public List<RefinementSentenceContext> refinementSentence() {
			return getRuleContexts(RefinementSentenceContext.class);
		}
		public SNameContext sName(int i) {
			return getRuleContext(SNameContext.class,i);
		}
		public List<SNameContext> sName() {
			return getRuleContexts(SNameContext.class);
		}
		public TerminalNode NL(int i) {
			return getToken(FTCRLParser.NL, i);
		}
		public RefinementLawContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_refinementLaw; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FTCRLListener ) ((FTCRLListener)listener).enterRefinementLaw(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FTCRLListener ) ((FTCRLListener)listener).exitRefinementLaw(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FTCRLVisitor ) return ((FTCRLVisitor<? extends T>)visitor).visitRefinementLaw(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RefinementLawContext refinementLaw() throws RecognitionException {
		RefinementLawContext _localctx = new RefinementLawContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_refinementLaw);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(194); sName();
			setState(199);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(195); match(COMMA);
				setState(196); sName();
				}
				}
				setState(201);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(202); match(1);
			setState(204);
			_la = _input.LA(1);
			if (_la==NL) {
				{
				setState(203); match(NL);
				}
			}

			setState(206); refinementSentence();
			setState(214);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEMICOLON) {
				{
				{
				setState(207); match(SEMICOLON);
				setState(209);
				_la = _input.LA(1);
				if (_la==NL) {
					{
					setState(208); match(NL);
					}
				}

				setState(211); refinementSentence();
				}
				}
				setState(216);
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

	public static class RefinementSentenceContext extends ParserRuleContext {
		public RefinementContext refinement() {
			return getRuleContext(RefinementContext.class,0);
		}
		public TerminalNode COMMA(int i) {
			return getToken(FTCRLParser.COMMA, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(FTCRLParser.COMMA); }
		public RefinementSentenceContext refinementSentence() {
			return getRuleContext(RefinementSentenceContext.class,0);
		}
		public SNameContext sName(int i) {
			return getRuleContext(SNameContext.class,i);
		}
		public List<SNameContext> sName() {
			return getRuleContexts(SNameContext.class);
		}
		public RefinementSentenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_refinementSentence; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FTCRLListener ) ((FTCRLListener)listener).enterRefinementSentence(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FTCRLListener ) ((FTCRLListener)listener).exitRefinementSentence(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FTCRLVisitor ) return ((FTCRLVisitor<? extends T>)visitor).visitRefinementSentence(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RefinementSentenceContext refinementSentence() throws RecognitionException {
		RefinementSentenceContext _localctx = new RefinementSentenceContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_refinementSentence);
		int _la;
		try {
			setState(229);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(217); sName();
				setState(222);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(218); match(COMMA);
					setState(219); sName();
					}
					}
					setState(224);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(225); match(1);
				setState(226); refinementSentence();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(228); refinement();
				}
				break;
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

	public static class RefinementContext extends ParserRuleContext {
		public SExprRefinementContext sExprRefinement() {
			return getRuleContext(SExprRefinementContext.class,0);
		}
		public IExprRefinementContext iExprRefinement() {
			return getRuleContext(IExprRefinementContext.class,0);
		}
		public RefinementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_refinement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FTCRLListener ) ((FTCRLListener)listener).enterRefinement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FTCRLListener ) ((FTCRLListener)listener).exitRefinement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FTCRLVisitor ) return ((FTCRLVisitor<? extends T>)visitor).visitRefinement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RefinementContext refinement() throws RecognitionException {
		RefinementContext _localctx = new RefinementContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_refinement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(234);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				setState(231); sExprRefinement();
				setState(232); match(1);
				}
				break;
			}
			setState(236); iExprRefinement();
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

	public static class IExprRefinementContext extends ParserRuleContext {
		public TerminalNode AS() { return getToken(FTCRLParser.AS, 0); }
		public AsRefinementContext asRefinement() {
			return getRuleContext(AsRefinementContext.class,0);
		}
		public INameContext iName() {
			return getRuleContext(INameContext.class,0);
		}
		public AsSynonymContext asSynonym() {
			return getRuleContext(AsSynonymContext.class,0);
		}
		public IExprRefinementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_iExprRefinement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FTCRLListener ) ((FTCRLListener)listener).enterIExprRefinement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FTCRLListener ) ((FTCRLListener)listener).exitIExprRefinement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FTCRLVisitor ) return ((FTCRLVisitor<? extends T>)visitor).visitIExprRefinement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IExprRefinementContext iExprRefinement() throws RecognitionException {
		IExprRefinementContext _localctx = new IExprRefinementContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_iExprRefinement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(238); iName();
			setState(242);
			switch (_input.LA(1)) {
			case AS:
				{
				setState(239); match(AS);
				setState(240); asRefinement();
				}
				break;
			case FILE:
			case TABLE:
			case ENUM:
			case REF:
			case LIST:
			case RECORD:
			case MAPPING:
			case ARRAY:
				{
				setState(241); asSynonym();
				}
				break;
			case RB:
			case RSB:
			case SEMICOLON:
			case COMMA:
			case NL:
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class AsRefinementContext extends ParserRuleContext {
		public TerminalNode SEMICOLON(int i) {
			return getToken(FTCRLParser.SEMICOLON, i);
		}
		public List<RefinementContext> refinement() {
			return getRuleContexts(RefinementContext.class);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(FTCRLParser.SEMICOLON); }
		public List<TerminalNode> NL() { return getTokens(FTCRLParser.NL); }
		public DataStructContext dataStruct() {
			return getRuleContext(DataStructContext.class,0);
		}
		public TerminalNode RSB() { return getToken(FTCRLParser.RSB, 0); }
		public RefinementContext refinement(int i) {
			return getRuleContext(RefinementContext.class,i);
		}
		public TerminalNode LSB() { return getToken(FTCRLParser.LSB, 0); }
		public TerminalNode WITH() { return getToken(FTCRLParser.WITH, 0); }
		public TerminalNode NL(int i) {
			return getToken(FTCRLParser.NL, i);
		}
		public AsRefinementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_asRefinement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FTCRLListener ) ((FTCRLListener)listener).enterAsRefinement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FTCRLListener ) ((FTCRLListener)listener).exitAsRefinement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FTCRLVisitor ) return ((FTCRLVisitor<? extends T>)visitor).visitAsRefinement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AsRefinementContext asRefinement() throws RecognitionException {
		AsRefinementContext _localctx = new AsRefinementContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_asRefinement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(244); dataStruct();
			setState(263);
			_la = _input.LA(1);
			if (_la==WITH) {
				{
				setState(245); match(WITH);
				setState(246); match(LSB);
				setState(248);
				_la = _input.LA(1);
				if (_la==NL) {
					{
					setState(247); match(NL);
					}
				}

				setState(250); refinement();
				setState(258);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==SEMICOLON) {
					{
					{
					setState(251); match(SEMICOLON);
					setState(253);
					_la = _input.LA(1);
					if (_la==NL) {
						{
						setState(252); match(NL);
						}
					}

					setState(255); refinement();
					}
					}
					setState(260);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(261); match(RSB);
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

	public static class WithRefinementContext extends ParserRuleContext {
		public ExprRefinementContext exprRefinement(int i) {
			return getRuleContext(ExprRefinementContext.class,i);
		}
		public TerminalNode COMMA(int i) {
			return getToken(FTCRLParser.COMMA, i);
		}
		public List<TerminalNode> NL() { return getTokens(FTCRLParser.NL); }
		public List<ExprRefinementContext> exprRefinement() {
			return getRuleContexts(ExprRefinementContext.class);
		}
		public List<TerminalNode> COMMA() { return getTokens(FTCRLParser.COMMA); }
		public TerminalNode NL(int i) {
			return getToken(FTCRLParser.NL, i);
		}
		public WithRefinementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_withRefinement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FTCRLListener ) ((FTCRLListener)listener).enterWithRefinement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FTCRLListener ) ((FTCRLListener)listener).exitWithRefinement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FTCRLVisitor ) return ((FTCRLVisitor<? extends T>)visitor).visitWithRefinement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WithRefinementContext withRefinement() throws RecognitionException {
		WithRefinementContext _localctx = new WithRefinementContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_withRefinement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(265); exprRefinement();
			setState(273);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(266); match(COMMA);
				setState(268);
				_la = _input.LA(1);
				if (_la==NL) {
					{
					setState(267); match(NL);
					}
				}

				setState(270); exprRefinement();
				}
				}
				setState(275);
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

	public static class ExprRefinementContext extends ParserRuleContext {
		public RefinementContext refinement() {
			return getRuleContext(RefinementContext.class,0);
		}
		public ZExprContext zExpr() {
			return getRuleContext(ZExprContext.class,0);
		}
		public ExprRefinementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprRefinement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FTCRLListener ) ((FTCRLListener)listener).enterExprRefinement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FTCRLListener ) ((FTCRLListener)listener).exitExprRefinement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FTCRLVisitor ) return ((FTCRLVisitor<? extends T>)visitor).visitExprRefinement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprRefinementContext exprRefinement() throws RecognitionException {
		ExprRefinementContext _localctx = new ExprRefinementContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_exprRefinement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(276); zExpr();
			setState(277); match(1);
			setState(278); refinement();
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

	public static class DataStructContext extends ParserRuleContext {
		public Reference2Context reference2() {
			return getRuleContext(Reference2Context.class,0);
		}
		public TerminalNode RECORD() { return getToken(FTCRLParser.RECORD, 0); }
		public FileContext file() {
			return getRuleContext(FileContext.class,0);
		}
		public ListContext list() {
			return getRuleContext(ListContext.class,0);
		}
		public TerminalNode MAPPING() { return getToken(FTCRLParser.MAPPING, 0); }
		public TableContext table() {
			return getRuleContext(TableContext.class,0);
		}
		public EnumerationContext enumeration() {
			return getRuleContext(EnumerationContext.class,0);
		}
		public TerminalNode ARRAY() { return getToken(FTCRLParser.ARRAY, 0); }
		public DataStructContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataStruct; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FTCRLListener ) ((FTCRLListener)listener).enterDataStruct(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FTCRLListener ) ((FTCRLListener)listener).exitDataStruct(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FTCRLVisitor ) return ((FTCRLVisitor<? extends T>)visitor).visitDataStruct(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DataStructContext dataStruct() throws RecognitionException {
		DataStructContext _localctx = new DataStructContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_dataStruct);
		try {
			setState(288);
			switch (_input.LA(1)) {
			case ARRAY:
				enterOuterAlt(_localctx, 1);
				{
				setState(280); match(ARRAY);
				}
				break;
			case RECORD:
				enterOuterAlt(_localctx, 2);
				{
				setState(281); match(RECORD);
				}
				break;
			case MAPPING:
				enterOuterAlt(_localctx, 3);
				{
				setState(282); match(MAPPING);
				}
				break;
			case LIST:
				enterOuterAlt(_localctx, 4);
				{
				setState(283); list();
				}
				break;
			case REF:
				enterOuterAlt(_localctx, 5);
				{
				setState(284); reference2();
				}
				break;
			case ENUM:
				enterOuterAlt(_localctx, 6);
				{
				setState(285); enumeration();
				}
				break;
			case TABLE:
				enterOuterAlt(_localctx, 7);
				{
				setState(286); table();
				}
				break;
			case FILE:
				enterOuterAlt(_localctx, 8);
				{
				setState(287); file();
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

	public static class SExprRefinementContext extends ParserRuleContext {
		public FunAppExprContext funAppExpr() {
			return getRuleContext(FunAppExprContext.class,0);
		}
		public ZExprContext zExpr() {
			return getRuleContext(ZExprContext.class,0);
		}
		public SNameContext sName() {
			return getRuleContext(SNameContext.class,0);
		}
		public SExprRefinementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sExprRefinement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FTCRLListener ) ((FTCRLListener)listener).enterSExprRefinement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FTCRLListener ) ((FTCRLListener)listener).exitSExprRefinement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FTCRLVisitor ) return ((FTCRLVisitor<? extends T>)visitor).visitSExprRefinement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SExprRefinementContext sExprRefinement() throws RecognitionException {
		SExprRefinementContext _localctx = new SExprRefinementContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_sExprRefinement);
		try {
			setState(293);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(290); sName();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(291); zExpr();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(292); funAppExpr();
				}
				break;
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

	public static class ZExprContext extends ParserRuleContext {
		public ZExprSetContext zExprSet() {
			return getRuleContext(ZExprSetContext.class,0);
		}
		public ZExprSeqContext zExprSeq() {
			return getRuleContext(ZExprSeqContext.class,0);
		}
		public ZExprNumContext zExprNum() {
			return getRuleContext(ZExprNumContext.class,0);
		}
		public ZExprStringContext zExprString() {
			return getRuleContext(ZExprStringContext.class,0);
		}
		public ZExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_zExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FTCRLListener ) ((FTCRLListener)listener).enterZExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FTCRLListener ) ((FTCRLListener)listener).exitZExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FTCRLVisitor ) return ((FTCRLVisitor<? extends T>)visitor).visitZExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ZExprContext zExpr() throws RecognitionException {
		ZExprContext _localctx = new ZExprContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_zExpr);
		try {
			setState(299);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(295); zExprSet(0);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(296); zExprNum(0);
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(297); zExprString(0);
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(298); zExprSeq();
				}
				break;
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

	public static class ZExprSetContext extends ParserRuleContext {
		public int _p;
		public TerminalNode CUP() { return getToken(FTCRLParser.CUP, 0); }
		public TerminalNode DOT(int i) {
			return getToken(FTCRLParser.DOT, i);
		}
		public List<ZExprSetContext> zExprSet() {
			return getRuleContexts(ZExprSetContext.class);
		}
		public DotSetOperContext dotSetOper(int i) {
			return getRuleContext(DotSetOperContext.class,i);
		}
		public SetExtensionContext setExtension() {
			return getRuleContext(SetExtensionContext.class,0);
		}
		public List<TerminalNode> DOT() { return getTokens(FTCRLParser.DOT); }
		public ZExprSetContext zExprSet(int i) {
			return getRuleContext(ZExprSetContext.class,i);
		}
		public SNameContext sName() {
			return getRuleContext(SNameContext.class,0);
		}
		public List<DotSetOperContext> dotSetOper() {
			return getRuleContexts(DotSetOperContext.class);
		}
		public ZExprSetContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public ZExprSetContext(ParserRuleContext parent, int invokingState, int _p) {
			super(parent, invokingState);
			this._p = _p;
		}
		@Override public int getRuleIndex() { return RULE_zExprSet; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FTCRLListener ) ((FTCRLListener)listener).enterZExprSet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FTCRLListener ) ((FTCRLListener)listener).exitZExprSet(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FTCRLVisitor ) return ((FTCRLVisitor<? extends T>)visitor).visitZExprSet(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ZExprSetContext zExprSet(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ZExprSetContext _localctx = new ZExprSetContext(_ctx, _parentState, _p);
		ZExprSetContext _prevctx = _localctx;
		int _startState = 42;
		enterRecursionRule(_localctx, RULE_zExprSet);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(311);
			switch (_input.LA(1)) {
			case LETTER:
				{
				setState(302); sName();
				setState(307);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
				while ( _alt!=2 && _alt!=-1 ) {
					if ( _alt==1 ) {
						{
						{
						setState(303); match(DOT);
						setState(304); dotSetOper();
						}
						} 
					}
					setState(309);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
				}
				}
				break;
			case LCB:
				{
				setState(310); setExtension();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(318);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ZExprSetContext(_parentctx, _parentState, _p);
					pushNewRecursionContext(_localctx, _startState, RULE_zExprSet);
					setState(313);
					if (!(1 >= _localctx._p)) throw new FailedPredicateException(this, "1 >= $_p");
					setState(314); match(CUP);
					setState(315); zExprSet(2);
					}
					} 
				}
				setState(320);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
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

	public static class ZExprNumContext extends ParserRuleContext {
		public int _p;
		public TerminalNode PLUS() { return getToken(FTCRLParser.PLUS, 0); }
		public TerminalNode SLASH() { return getToken(FTCRLParser.SLASH, 0); }
		public ZExprNumContext zExprNum(int i) {
			return getRuleContext(ZExprNumContext.class,i);
		}
		public TerminalNode MINUS() { return getToken(FTCRLParser.MINUS, 0); }
		public TerminalNode DIV() { return getToken(FTCRLParser.DIV, 0); }
		public TerminalNode DOT() { return getToken(FTCRLParser.DOT, 0); }
		public TerminalNode MOD() { return getToken(FTCRLParser.MOD, 0); }
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public List<ZExprNumContext> zExprNum() {
			return getRuleContexts(ZExprNumContext.class);
		}
		public TerminalNode AUTOFILL() { return getToken(FTCRLParser.AUTOFILL, 0); }
		public SNameContext sName() {
			return getRuleContext(SNameContext.class,0);
		}
		public TerminalNode CARD() { return getToken(FTCRLParser.CARD, 0); }
		public ZExprNumContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public ZExprNumContext(ParserRuleContext parent, int invokingState, int _p) {
			super(parent, invokingState);
			this._p = _p;
		}
		@Override public int getRuleIndex() { return RULE_zExprNum; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FTCRLListener ) ((FTCRLListener)listener).enterZExprNum(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FTCRLListener ) ((FTCRLListener)listener).exitZExprNum(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FTCRLVisitor ) return ((FTCRLVisitor<? extends T>)visitor).visitZExprNum(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ZExprNumContext zExprNum(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ZExprNumContext _localctx = new ZExprNumContext(_ctx, _parentState, _p);
		ZExprNumContext _prevctx = _localctx;
		int _startState = 44;
		enterRecursionRule(_localctx, RULE_zExprNum);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(328);
			switch (_input.LA(1)) {
			case LETTER:
				{
				setState(322); sName();
				setState(323); match(DOT);
				setState(324); match(CARD);
				}
				break;
			case DIGIT:
				{
				setState(326); number();
				}
				break;
			case AUTOFILL:
				{
				setState(327); match(AUTOFILL);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(347);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(345);
					switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
					case 1:
						{
						_localctx = new ZExprNumContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_zExprNum);
						setState(330);
						if (!(5 >= _localctx._p)) throw new FailedPredicateException(this, "5 >= $_p");
						setState(331); match(DIV);
						setState(332); zExprNum(6);
						}
						break;

					case 2:
						{
						_localctx = new ZExprNumContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_zExprNum);
						setState(333);
						if (!(4 >= _localctx._p)) throw new FailedPredicateException(this, "4 >= $_p");
						setState(334); match(SLASH);
						setState(335); zExprNum(5);
						}
						break;

					case 3:
						{
						_localctx = new ZExprNumContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_zExprNum);
						setState(336);
						if (!(3 >= _localctx._p)) throw new FailedPredicateException(this, "3 >= $_p");
						setState(337); match(MOD);
						setState(338); zExprNum(4);
						}
						break;

					case 4:
						{
						_localctx = new ZExprNumContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_zExprNum);
						setState(339);
						if (!(2 >= _localctx._p)) throw new FailedPredicateException(this, "2 >= $_p");
						setState(340); match(PLUS);
						setState(341); zExprNum(3);
						}
						break;

					case 5:
						{
						_localctx = new ZExprNumContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_zExprNum);
						setState(342);
						if (!(1 >= _localctx._p)) throw new FailedPredicateException(this, "1 >= $_p");
						setState(343); match(MINUS);
						setState(344); zExprNum(2);
						}
						break;
					}
					} 
				}
				setState(349);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
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

	public static class ZExprStringContext extends ParserRuleContext {
		public int _p;
		public TerminalNode STR() { return getToken(FTCRLParser.STR, 0); }
		public TerminalNode DOT(int i) {
			return getToken(FTCRLParser.DOT, i);
		}
		public DotSetOperContext dotSetOper(int i) {
			return getRuleContext(DotSetOperContext.class,i);
		}
		public List<ZExprSetContext> zExprSet() {
			return getRuleContexts(ZExprSetContext.class);
		}
		public ZExprStringContext zExprString(int i) {
			return getRuleContext(ZExprStringContext.class,i);
		}
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public TerminalNode PLUSPLUS() { return getToken(FTCRLParser.PLUSPLUS, 0); }
		public TerminalNode AUTOFILL() { return getToken(FTCRLParser.AUTOFILL, 0); }
		public List<ZExprStringContext> zExprString() {
			return getRuleContexts(ZExprStringContext.class);
		}
		public TerminalNode CARD() { return getToken(FTCRLParser.CARD, 0); }
		public List<DotSetOperContext> dotSetOper() {
			return getRuleContexts(DotSetOperContext.class);
		}
		public TerminalNode ARROBA() { return getToken(FTCRLParser.ARROBA, 0); }
		public StringContext string() {
			return getRuleContext(StringContext.class,0);
		}
		public List<TerminalNode> DOT() { return getTokens(FTCRLParser.DOT); }
		public ZExprSetContext zExprSet(int i) {
			return getRuleContext(ZExprSetContext.class,i);
		}
		public SNameContext sName() {
			return getRuleContext(SNameContext.class,0);
		}
		public ZExprStringContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public ZExprStringContext(ParserRuleContext parent, int invokingState, int _p) {
			super(parent, invokingState);
			this._p = _p;
		}
		@Override public int getRuleIndex() { return RULE_zExprString; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FTCRLListener ) ((FTCRLListener)listener).enterZExprString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FTCRLListener ) ((FTCRLListener)listener).exitZExprString(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FTCRLVisitor ) return ((FTCRLVisitor<? extends T>)visitor).visitZExprString(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ZExprStringContext zExprString(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ZExprStringContext _localctx = new ZExprStringContext(_ctx, _parentState, _p);
		ZExprStringContext _prevctx = _localctx;
		int _startState = 46;
		enterRecursionRule(_localctx, RULE_zExprString);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(376);
			switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
			case 1:
				{
				setState(351); string();
				}
				break;

			case 2:
				{
				setState(352); number();
				}
				break;

			case 3:
				{
				setState(353); match(AUTOFILL);
				}
				break;

			case 4:
				{
				setState(354); sName();
				setState(359);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
				while ( _alt!=2 && _alt!=-1 ) {
					if ( _alt==1 ) {
						{
						{
						setState(355); match(DOT);
						setState(356); dotSetOper();
						}
						} 
					}
					setState(361);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
				}
				setState(368);
				switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
				case 1:
					{
					setState(362); match(DOT);
					setState(366);
					switch (_input.LA(1)) {
					case CARD:
						{
						setState(363); match(CARD);
						}
						break;
					case ARROBA:
						{
						setState(364); match(ARROBA);
						setState(365); match(STR);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					break;
				}
				}
				break;

			case 5:
				{
				setState(370); zExprSet(0);
				setState(371); match(PLUSPLUS);
				setState(374);
				switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
				case 1:
					{
					setState(372); zExprString(0);
					}
					break;

				case 2:
					{
					setState(373); zExprSet(0);
					}
					break;
				}
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(386);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,43,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ZExprStringContext(_parentctx, _parentState, _p);
					pushNewRecursionContext(_localctx, _startState, RULE_zExprString);
					setState(378);
					if (!(1 >= _localctx._p)) throw new FailedPredicateException(this, "1 >= $_p");
					setState(379); match(PLUSPLUS);
					setState(382);
					switch ( getInterpreter().adaptivePredict(_input,42,_ctx) ) {
					case 1:
						{
						setState(380); zExprString(0);
						}
						break;

					case 2:
						{
						setState(381); zExprSet(0);
						}
						break;
					}
					}
					} 
				}
				setState(388);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,43,_ctx);
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

	public static class ZExprSeqContext extends ParserRuleContext {
		public TerminalNode R() { return getToken(FTCRLParser.R, 0); }
		public TerminalNode L() { return getToken(FTCRLParser.L, 0); }
		public ZExprSeqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_zExprSeq; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FTCRLListener ) ((FTCRLListener)listener).enterZExprSeq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FTCRLListener ) ((FTCRLListener)listener).exitZExprSeq(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FTCRLVisitor ) return ((FTCRLVisitor<? extends T>)visitor).visitZExprSeq(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ZExprSeqContext zExprSeq() throws RecognitionException {
		ZExprSeqContext _localctx = new ZExprSeqContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_zExprSeq);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(389); match(L);
			setState(390); match(R);
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

	public static class FunAppExprContext extends ParserRuleContext {
		public IIdentContext iIdent() {
			return getRuleContext(IIdentContext.class,0);
		}
		public List<RefinementContext> refinement() {
			return getRuleContexts(RefinementContext.class);
		}
		public TerminalNode LB() { return getToken(FTCRLParser.LB, 0); }
		public TerminalNode COMMA(int i) {
			return getToken(FTCRLParser.COMMA, i);
		}
		public TerminalNode RB() { return getToken(FTCRLParser.RB, 0); }
		public List<TerminalNode> COMMA() { return getTokens(FTCRLParser.COMMA); }
		public RefinementContext refinement(int i) {
			return getRuleContext(RefinementContext.class,i);
		}
		public FunAppExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funAppExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FTCRLListener ) ((FTCRLListener)listener).enterFunAppExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FTCRLListener ) ((FTCRLListener)listener).exitFunAppExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FTCRLVisitor ) return ((FTCRLVisitor<? extends T>)visitor).visitFunAppExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunAppExprContext funAppExpr() throws RecognitionException {
		FunAppExprContext _localctx = new FunAppExprContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_funAppExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(392); iIdent();
			setState(393); match(LB);
			setState(402);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << L) | (1L << LCB) | (1L << STRING) | (1L << AUTOFILL) | (1L << DIGIT) | (1L << LETTER))) != 0)) {
				{
				setState(394); refinement();
				setState(399);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(395); match(COMMA);
					setState(396); refinement();
					}
					}
					setState(401);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(404); match(RB);
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

	public static class DotSetOperContext extends ParserRuleContext {
		public DigitContext digit() {
			return getRuleContext(DigitContext.class,0);
		}
		public TerminalNode DOM() { return getToken(FTCRLParser.DOM, 0); }
		public TerminalNode ARROBA() { return getToken(FTCRLParser.ARROBA, 0); }
		public TerminalNode RAN() { return getToken(FTCRLParser.RAN, 0); }
		public SNameContext sName() {
			return getRuleContext(SNameContext.class,0);
		}
		public TerminalNode CARD() { return getToken(FTCRLParser.CARD, 0); }
		public TerminalNode ELEM() { return getToken(FTCRLParser.ELEM, 0); }
		public DotSetOperContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dotSetOper; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FTCRLListener ) ((FTCRLListener)listener).enterDotSetOper(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FTCRLListener ) ((FTCRLListener)listener).exitDotSetOper(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FTCRLVisitor ) return ((FTCRLVisitor<? extends T>)visitor).visitDotSetOper(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DotSetOperContext dotSetOper() throws RecognitionException {
		DotSetOperContext _localctx = new DotSetOperContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_dotSetOper);
		int _la;
		try {
			setState(410);
			switch (_input.LA(1)) {
			case ARROBA:
				enterOuterAlt(_localctx, 1);
				{
				setState(406); match(ARROBA);
				setState(407);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CARD) | (1L << DOM) | (1L << RAN) | (1L << ELEM))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				break;
			case ZERO:
			case DIGIT:
				enterOuterAlt(_localctx, 2);
				{
				setState(408); digit();
				}
				break;
			case LETTER:
				enterOuterAlt(_localctx, 3);
				{
				setState(409); sName();
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

	public static class ListContext extends ParserRuleContext {
		public INameContext iName(int i) {
			return getRuleContext(INameContext.class,i);
		}
		public TerminalNode COMMA(int i) {
			return getToken(FTCRLParser.COMMA, i);
		}
		public ListTypeContext listType() {
			return getRuleContext(ListTypeContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(FTCRLParser.COMMA); }
		public TerminalNode LIST() { return getToken(FTCRLParser.LIST, 0); }
		public List<INameContext> iName() {
			return getRuleContexts(INameContext.class);
		}
		public TerminalNode RSB() { return getToken(FTCRLParser.RSB, 0); }
		public TerminalNode LSB() { return getToken(FTCRLParser.LSB, 0); }
		public ListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FTCRLListener ) ((FTCRLListener)listener).enterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FTCRLListener ) ((FTCRLListener)listener).exitList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FTCRLVisitor ) return ((FTCRLVisitor<? extends T>)visitor).visitList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListContext list() throws RecognitionException {
		ListContext _localctx = new ListContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(412); match(LIST);
			setState(425);
			_la = _input.LA(1);
			if (_la==LSB) {
				{
				setState(413); match(LSB);
				setState(414); listType();
				setState(417);
				switch ( getInterpreter().adaptivePredict(_input,47,_ctx) ) {
				case 1:
					{
					setState(415); match(COMMA);
					setState(416); iName();
					}
					break;
				}
				setState(421);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(419); match(COMMA);
					setState(420); iName();
					}
				}

				setState(423); match(RSB);
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

	public static class ListTypeContext extends ParserRuleContext {
		public TerminalNode DCLL() { return getToken(FTCRLParser.DCLL, 0); }
		public TerminalNode SLL() { return getToken(FTCRLParser.SLL, 0); }
		public TerminalNode CLL() { return getToken(FTCRLParser.CLL, 0); }
		public TerminalNode DLL() { return getToken(FTCRLParser.DLL, 0); }
		public ListTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FTCRLListener ) ((FTCRLListener)listener).enterListType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FTCRLListener ) ((FTCRLListener)listener).exitListType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FTCRLVisitor ) return ((FTCRLVisitor<? extends T>)visitor).visitListType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListTypeContext listType() throws RecognitionException {
		ListTypeContext _localctx = new ListTypeContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_listType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(427);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SLL) | (1L << DLL) | (1L << CLL) | (1L << DCLL))) != 0)) ) {
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

	public static class Reference2Context extends ParserRuleContext {
		public INameContext iName() {
			return getRuleContext(INameContext.class,0);
		}
		public TerminalNode RSB() { return getToken(FTCRLParser.RSB, 0); }
		public TerminalNode LSB() { return getToken(FTCRLParser.LSB, 0); }
		public TerminalNode REF() { return getToken(FTCRLParser.REF, 0); }
		public Reference2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_reference2; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FTCRLListener ) ((FTCRLListener)listener).enterReference2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FTCRLListener ) ((FTCRLListener)listener).exitReference2(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FTCRLVisitor ) return ((FTCRLVisitor<? extends T>)visitor).visitReference2(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Reference2Context reference2() throws RecognitionException {
		Reference2Context _localctx = new Reference2Context(_ctx, getState());
		enterRule(_localctx, 58, RULE_reference2);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(429); match(REF);
			setState(430); match(LSB);
			setState(431); iName();
			setState(432); match(RSB);
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

	public static class NumberContext extends ParserRuleContext {
		public List<DigitContext> digit() {
			return getRuleContexts(DigitContext.class);
		}
		public DigitContext digit(int i) {
			return getRuleContext(DigitContext.class,i);
		}
		public TerminalNode DIGIT() { return getToken(FTCRLParser.DIGIT, 0); }
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FTCRLListener ) ((FTCRLListener)listener).enterNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FTCRLListener ) ((FTCRLListener)listener).exitNumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FTCRLVisitor ) return ((FTCRLVisitor<? extends T>)visitor).visitNumber(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_number);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(434); match(DIGIT);
			setState(438);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,50,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(435); digit();
					}
					} 
				}
				setState(440);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,50,_ctx);
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

	public static class EnumerationContext extends ParserRuleContext {
		public NumberContext number(int i) {
			return getRuleContext(NumberContext.class,i);
		}
		public TerminalNode ENUM() { return getToken(FTCRLParser.ENUM, 0); }
		public List<TerminalNode> COMMA() { return getTokens(FTCRLParser.COMMA); }
		public List<NumberContext> number() {
			return getRuleContexts(NumberContext.class);
		}
		public TerminalNode R(int i) {
			return getToken(FTCRLParser.R, i);
		}
		public TerminalNode RSB() { return getToken(FTCRLParser.RSB, 0); }
		public TerminalNode COMMA(int i) {
			return getToken(FTCRLParser.COMMA, i);
		}
		public INameContext iName(int i) {
			return getRuleContext(INameContext.class,i);
		}
		public List<TerminalNode> R() { return getTokens(FTCRLParser.R); }
		public SNameContext sName(int i) {
			return getRuleContext(SNameContext.class,i);
		}
		public List<INameContext> iName() {
			return getRuleContexts(INameContext.class);
		}
		public List<SNameContext> sName() {
			return getRuleContexts(SNameContext.class);
		}
		public TerminalNode LSB() { return getToken(FTCRLParser.LSB, 0); }
		public EnumerationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumeration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FTCRLListener ) ((FTCRLListener)listener).enterEnumeration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FTCRLListener ) ((FTCRLListener)listener).exitEnumeration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FTCRLVisitor ) return ((FTCRLVisitor<? extends T>)visitor).visitEnumeration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnumerationContext enumeration() throws RecognitionException {
		EnumerationContext _localctx = new EnumerationContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_enumeration);
		int _la;
		try {
			setState(472);
			switch ( getInterpreter().adaptivePredict(_input,56,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(441); match(ENUM);
				setState(463);
				_la = _input.LA(1);
				if (_la==LSB) {
					{
					setState(442); match(LSB);
					setState(443); sName();
					setState(444); match(R);
					setState(447);
					switch (_input.LA(1)) {
					case LETTER:
						{
						setState(445); iName();
						}
						break;
					case DIGIT:
						{
						setState(446); number();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(458);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(449); match(COMMA);
						setState(450); sName();
						setState(451); match(R);
						setState(454);
						switch (_input.LA(1)) {
						case LETTER:
							{
							setState(452); iName();
							}
							break;
						case DIGIT:
							{
							setState(453); number();
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						}
						}
						setState(460);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(461); match(RSB);
					}
				}

				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(465); match(ENUM);
				setState(470);
				_la = _input.LA(1);
				if (_la==LSB) {
					{
					setState(466); match(LSB);
					setState(467); number();
					setState(468); match(RSB);
					}
				}

				}
				break;
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

	public static class TableContext extends ParserRuleContext {
		public TerminalNode TABLE() { return getToken(FTCRLParser.TABLE, 0); }
		public TerminalNode COMMA(int i) {
			return getToken(FTCRLParser.COMMA, i);
		}
		public PathContext path() {
			return getRuleContext(PathContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(FTCRLParser.COMMA); }
		public INameContext iName() {
			return getRuleContext(INameContext.class,0);
		}
		public TerminalNode RSB() { return getToken(FTCRLParser.RSB, 0); }
		public TerminalNode LSB() { return getToken(FTCRLParser.LSB, 0); }
		public FNameContext fName() {
			return getRuleContext(FNameContext.class,0);
		}
		public TableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FTCRLListener ) ((FTCRLListener)listener).enterTable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FTCRLListener ) ((FTCRLListener)listener).exitTable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FTCRLVisitor ) return ((FTCRLVisitor<? extends T>)visitor).visitTable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TableContext table() throws RecognitionException {
		TableContext _localctx = new TableContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_table);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(474); match(TABLE);
			setState(475); match(LSB);
			setState(476); iName();
			setState(477); match(COMMA);
			setState(478); path();
			setState(479); match(COMMA);
			setState(480); fName();
			setState(481); match(RSB);
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

	public static class FileContext extends ParserRuleContext {
		public PathContext path() {
			return getRuleContext(PathContext.class,0);
		}
		public TerminalNode FILE() { return getToken(FTCRLParser.FILE, 0); }
		public TerminalNode RSB() { return getToken(FTCRLParser.RSB, 0); }
		public TerminalNode LSB() { return getToken(FTCRLParser.LSB, 0); }
		public FileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_file; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FTCRLListener ) ((FTCRLListener)listener).enterFile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FTCRLListener ) ((FTCRLListener)listener).exitFile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FTCRLVisitor ) return ((FTCRLVisitor<? extends T>)visitor).visitFile(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FileContext file() throws RecognitionException {
		FileContext _localctx = new FileContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_file);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(483); match(FILE);
			setState(484); match(LSB);
			setState(485); path();
			setState(486); match(RSB);
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

	public static class NameContext extends ParserRuleContext {
		public List<DigitContext> digit() {
			return getRuleContexts(DigitContext.class);
		}
		public TerminalNode LETTER(int i) {
			return getToken(FTCRLParser.LETTER, i);
		}
		public DigitContext digit(int i) {
			return getRuleContext(DigitContext.class,i);
		}
		public List<TerminalNode> UNDERSCORE() { return getTokens(FTCRLParser.UNDERSCORE); }
		public TerminalNode UNDERSCORE(int i) {
			return getToken(FTCRLParser.UNDERSCORE, i);
		}
		public List<TerminalNode> LETTER() { return getTokens(FTCRLParser.LETTER); }
		public NameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FTCRLListener ) ((FTCRLListener)listener).enterName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FTCRLListener ) ((FTCRLListener)listener).exitName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FTCRLVisitor ) return ((FTCRLVisitor<? extends T>)visitor).visitName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NameContext name() throws RecognitionException {
		NameContext _localctx = new NameContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_name);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(488); match(LETTER);
			setState(494);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,58,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					setState(492);
					switch (_input.LA(1)) {
					case UNDERSCORE:
						{
						setState(489); match(UNDERSCORE);
						}
						break;
					case ZERO:
					case DIGIT:
						{
						setState(490); digit();
						}
						break;
					case LETTER:
						{
						setState(491); match(LETTER);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(496);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,58,_ctx);
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

	public static class LawNameContext extends ParserRuleContext {
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public LawNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lawName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FTCRLListener ) ((FTCRLListener)listener).enterLawName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FTCRLListener ) ((FTCRLListener)listener).exitLawName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FTCRLVisitor ) return ((FTCRLVisitor<? extends T>)visitor).visitLawName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LawNameContext lawName() throws RecognitionException {
		LawNameContext _localctx = new LawNameContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_lawName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(497); name();
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

	public static class SNameContext extends ParserRuleContext {
		public TerminalNode Q() { return getToken(FTCRLParser.Q, 0); }
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public SNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FTCRLListener ) ((FTCRLListener)listener).enterSName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FTCRLListener ) ((FTCRLListener)listener).exitSName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FTCRLVisitor ) return ((FTCRLVisitor<? extends T>)visitor).visitSName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SNameContext sName() throws RecognitionException {
		SNameContext _localctx = new SNameContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_sName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(499); name();
			setState(501);
			switch ( getInterpreter().adaptivePredict(_input,59,_ctx) ) {
			case 1:
				{
				setState(500); match(Q);
				}
				break;
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

	public static class INameContext extends ParserRuleContext {
		public List<IIdentContext> iIdent() {
			return getRuleContexts(IIdentContext.class);
		}
		public TerminalNode DOTA() { return getToken(FTCRLParser.DOTA, 0); }
		public IIdentContext iIdent(int i) {
			return getRuleContext(IIdentContext.class,i);
		}
		public TerminalNode DOT() { return getToken(FTCRLParser.DOT, 0); }
		public TerminalNode RSB() { return getToken(FTCRLParser.RSB, 0); }
		public TerminalNode LSB() { return getToken(FTCRLParser.LSB, 0); }
		public INameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_iName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FTCRLListener ) ((FTCRLListener)listener).enterIName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FTCRLListener ) ((FTCRLListener)listener).exitIName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FTCRLVisitor ) return ((FTCRLVisitor<? extends T>)visitor).visitIName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final INameContext iName() throws RecognitionException {
		INameContext _localctx = new INameContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_iName);
		try {
			setState(515);
			switch ( getInterpreter().adaptivePredict(_input,60,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(503); iIdent();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(504); iIdent();
				setState(505); match(LSB);
				setState(506); match(RSB);
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(508); iIdent();
				setState(509); match(DOT);
				setState(510); iIdent();
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(512); iIdent();
				setState(513); match(DOTA);
				}
				break;
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

	public static class IIdentContext extends ParserRuleContext {
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public IIdentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_iIdent; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FTCRLListener ) ((FTCRLListener)listener).enterIIdent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FTCRLListener ) ((FTCRLListener)listener).exitIIdent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FTCRLVisitor ) return ((FTCRLVisitor<? extends T>)visitor).visitIIdent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IIdentContext iIdent() throws RecognitionException {
		IIdentContext _localctx = new IIdentContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_iIdent);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(517); name();
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

	public static class FNameContext extends ParserRuleContext {
		public TerminalNode DOT(int i) {
			return getToken(FTCRLParser.DOT, i);
		}
		public List<NameContext> name() {
			return getRuleContexts(NameContext.class);
		}
		public List<TerminalNode> DOT() { return getTokens(FTCRLParser.DOT); }
		public NameContext name(int i) {
			return getRuleContext(NameContext.class,i);
		}
		public FNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FTCRLListener ) ((FTCRLListener)listener).enterFName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FTCRLListener ) ((FTCRLListener)listener).exitFName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FTCRLVisitor ) return ((FTCRLVisitor<? extends T>)visitor).visitFName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FNameContext fName() throws RecognitionException {
		FNameContext _localctx = new FNameContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_fName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(519); name();
			setState(526);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT || _la==LETTER) {
				{
				{
				setState(521);
				_la = _input.LA(1);
				if (_la==DOT) {
					{
					setState(520); match(DOT);
					}
				}

				setState(523); name();
				}
				}
				setState(528);
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

	public static class PathContext extends ParserRuleContext {
		public List<TerminalNode> SLASH() { return getTokens(FTCRLParser.SLASH); }
		public FNameContext fName(int i) {
			return getRuleContext(FNameContext.class,i);
		}
		public TerminalNode DOT() { return getToken(FTCRLParser.DOT, 0); }
		public TerminalNode SLASH(int i) {
			return getToken(FTCRLParser.SLASH, i);
		}
		public List<FNameContext> fName() {
			return getRuleContexts(FNameContext.class);
		}
		public PathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_path; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FTCRLListener ) ((FTCRLListener)listener).enterPath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FTCRLListener ) ((FTCRLListener)listener).exitPath(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FTCRLVisitor ) return ((FTCRLVisitor<? extends T>)visitor).visitPath(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PathContext path() throws RecognitionException {
		PathContext _localctx = new PathContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_path);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(530);
			_la = _input.LA(1);
			if (_la==DOT) {
				{
				setState(529); match(DOT);
				}
			}

			setState(533);
			_la = _input.LA(1);
			if (_la==SLASH) {
				{
				setState(532); match(SLASH);
				}
			}

			setState(535); fName();
			setState(540);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SLASH) {
				{
				{
				setState(536); match(SLASH);
				setState(537); fName();
				}
				}
				setState(542);
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

	public static class DigitContext extends ParserRuleContext {
		public TerminalNode DIGIT() { return getToken(FTCRLParser.DIGIT, 0); }
		public TerminalNode ZERO() { return getToken(FTCRLParser.ZERO, 0); }
		public DigitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_digit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FTCRLListener ) ((FTCRLListener)listener).enterDigit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FTCRLListener ) ((FTCRLListener)listener).exitDigit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FTCRLVisitor ) return ((FTCRLVisitor<? extends T>)visitor).visitDigit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DigitContext digit() throws RecognitionException {
		DigitContext _localctx = new DigitContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_digit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(543);
			_la = _input.LA(1);
			if ( !(_la==ZERO || _la==DIGIT) ) {
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

	public static class StringContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(FTCRLParser.STRING, 0); }
		public StringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_string; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FTCRLListener ) ((FTCRLListener)listener).enterString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FTCRLListener ) ((FTCRLListener)listener).exitString(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FTCRLVisitor ) return ((FTCRLVisitor<? extends T>)visitor).visitString(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringContext string() throws RecognitionException {
		StringContext _localctx = new StringContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_string);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(545); match(STRING);
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

	public static class SetExtensionContext extends ParserRuleContext {
		public TerminalNode COMMA(int i) {
			return getToken(FTCRLParser.COMMA, i);
		}
		public NumberContext number(int i) {
			return getRuleContext(NumberContext.class,i);
		}
		public List<StringContext> string() {
			return getRuleContexts(StringContext.class);
		}
		public TerminalNode RCB() { return getToken(FTCRLParser.RCB, 0); }
		public List<TerminalNode> COMMA() { return getTokens(FTCRLParser.COMMA); }
		public TerminalNode LCB() { return getToken(FTCRLParser.LCB, 0); }
		public List<NumberContext> number() {
			return getRuleContexts(NumberContext.class);
		}
		public StringContext string(int i) {
			return getRuleContext(StringContext.class,i);
		}
		public SetExtensionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_setExtension; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FTCRLListener ) ((FTCRLListener)listener).enterSetExtension(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FTCRLListener ) ((FTCRLListener)listener).exitSetExtension(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FTCRLVisitor ) return ((FTCRLVisitor<? extends T>)visitor).visitSetExtension(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SetExtensionContext setExtension() throws RecognitionException {
		SetExtensionContext _localctx = new SetExtensionContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_setExtension);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(547); match(LCB);
			setState(550);
			switch (_input.LA(1)) {
			case DIGIT:
				{
				setState(548); number();
				}
				break;
			case STRING:
				{
				setState(549); string();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(559);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(552); match(COMMA);
				setState(555);
				switch (_input.LA(1)) {
				case DIGIT:
					{
					setState(553); number();
					}
					break;
				case STRING:
					{
					setState(554); string();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				}
				setState(561);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(562); match(RCB);
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
		case 21: return zExprSet_sempred((ZExprSetContext)_localctx, predIndex);

		case 22: return zExprNum_sempred((ZExprNumContext)_localctx, predIndex);

		case 23: return zExprString_sempred((ZExprStringContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean zExprSet_sempred(ZExprSetContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return 1 >= _localctx._p;
		}
		return true;
	}
	private boolean zExprNum_sempred(ZExprNumContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1: return 5 >= _localctx._p;

		case 2: return 4 >= _localctx._p;

		case 3: return 3 >= _localctx._p;

		case 4: return 2 >= _localctx._p;

		case 5: return 1 >= _localctx._p;
		}
		return true;
	}
	private boolean zExprString_sempred(ZExprStringContext _localctx, int predIndex) {
		switch (predIndex) {
		case 6: return 1 >= _localctx._p;
		}
		return true;
	}

	public static final String _serializedATN =
		"\2\3>\u0237\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4"+
		"\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20"+
		"\4\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27"+
		"\4\30\t\30\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36"+
		"\4\37\t\37\4 \t \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4"+
		")\t)\4*\t*\4+\t+\4,\t,\4-\t-\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2c\n\2"+
		"\3\2\3\2\3\2\3\2\5\2i\n\2\3\3\3\3\3\3\3\3\3\3\3\3\7\3q\n\3\f\3\16\3t\13"+
		"\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\6\4\u0083\n\4\r"+
		"\4\16\4\u0084\3\5\3\5\3\5\5\5\u008a\n\5\3\5\3\5\3\5\3\5\5\5\u0090\n\5"+
		"\3\5\5\5\u0093\n\5\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\b\3\b\5\b\u00a0"+
		"\n\b\3\b\3\b\7\b\u00a4\n\b\f\b\16\b\u00a7\13\b\3\b\3\b\3\b\5\b\u00ac\n"+
		"\b\3\b\5\b\u00af\n\b\3\t\3\t\3\t\3\t\3\t\3\t\6\t\u00b7\n\t\r\t\16\t\u00b8"+
		"\3\n\3\n\3\n\3\n\5\n\u00bf\n\n\3\13\3\13\3\f\3\f\3\r\3\r\3\r\7\r\u00c8"+
		"\n\r\f\r\16\r\u00cb\13\r\3\r\3\r\5\r\u00cf\n\r\3\r\3\r\3\r\5\r\u00d4\n"+
		"\r\3\r\7\r\u00d7\n\r\f\r\16\r\u00da\13\r\3\16\3\16\3\16\7\16\u00df\n\16"+
		"\f\16\16\16\u00e2\13\16\3\16\3\16\3\16\3\16\5\16\u00e8\n\16\3\17\3\17"+
		"\3\17\5\17\u00ed\n\17\3\17\3\17\3\20\3\20\3\20\3\20\5\20\u00f5\n\20\3"+
		"\21\3\21\3\21\3\21\5\21\u00fb\n\21\3\21\3\21\3\21\5\21\u0100\n\21\3\21"+
		"\7\21\u0103\n\21\f\21\16\21\u0106\13\21\3\21\3\21\5\21\u010a\n\21\3\22"+
		"\3\22\3\22\5\22\u010f\n\22\3\22\7\22\u0112\n\22\f\22\16\22\u0115\13\22"+
		"\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u0123"+
		"\n\24\3\25\3\25\3\25\5\25\u0128\n\25\3\26\3\26\3\26\3\26\5\26\u012e\n"+
		"\26\3\27\3\27\3\27\3\27\7\27\u0134\n\27\f\27\16\27\u0137\13\27\3\27\5"+
		"\27\u013a\n\27\3\27\3\27\3\27\7\27\u013f\n\27\f\27\16\27\u0142\13\27\3"+
		"\30\3\30\3\30\3\30\3\30\3\30\3\30\5\30\u014b\n\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\7\30\u015c\n\30"+
		"\f\30\16\30\u015f\13\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\7\31\u0168"+
		"\n\31\f\31\16\31\u016b\13\31\3\31\3\31\3\31\3\31\5\31\u0171\n\31\5\31"+
		"\u0173\n\31\3\31\3\31\3\31\3\31\5\31\u0179\n\31\5\31\u017b\n\31\3\31\3"+
		"\31\3\31\3\31\5\31\u0181\n\31\7\31\u0183\n\31\f\31\16\31\u0186\13\31\3"+
		"\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\7\33\u0190\n\33\f\33\16\33\u0193"+
		"\13\33\5\33\u0195\n\33\3\33\3\33\3\34\3\34\3\34\3\34\5\34\u019d\n\34\3"+
		"\35\3\35\3\35\3\35\3\35\5\35\u01a4\n\35\3\35\3\35\5\35\u01a8\n\35\3\35"+
		"\3\35\5\35\u01ac\n\35\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3 \3 \7 \u01b7"+
		"\n \f \16 \u01ba\13 \3!\3!\3!\3!\3!\3!\5!\u01c2\n!\3!\3!\3!\3!\3!\5!\u01c9"+
		"\n!\7!\u01cb\n!\f!\16!\u01ce\13!\3!\3!\5!\u01d2\n!\3!\3!\3!\3!\3!\5!\u01d9"+
		"\n!\5!\u01db\n!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3#\3$"+
		"\3$\3$\3$\7$\u01ef\n$\f$\16$\u01f2\13$\3%\3%\3&\3&\5&\u01f8\n&\3\'\3\'"+
		"\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\5\'\u0206\n\'\3(\3(\3)\3)\5)"+
		"\u020c\n)\3)\7)\u020f\n)\f)\16)\u0212\13)\3*\5*\u0215\n*\3*\5*\u0218\n"+
		"*\3*\3*\3*\7*\u021d\n*\f*\16*\u0220\13*\3+\3+\3,\3,\3-\3-\3-\5-\u0229"+
		"\n-\3-\3-\3-\5-\u022e\n-\7-\u0230\n-\f-\16-\u0233\13-\3-\3-\3-\2.\2\4"+
		"\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNP"+
		"RTVX\2\5\4\23\23(*\3#&\4\25\25::\u0265\2Z\3\2\2\2\4j\3\2\2\2\6u\3\2\2"+
		"\2\b\u0092\3\2\2\2\n\u0094\3\2\2\2\f\u0098\3\2\2\2\16\u009b\3\2\2\2\20"+
		"\u00b0\3\2\2\2\22\u00ba\3\2\2\2\24\u00c0\3\2\2\2\26\u00c2\3\2\2\2\30\u00c4"+
		"\3\2\2\2\32\u00e7\3\2\2\2\34\u00ec\3\2\2\2\36\u00f0\3\2\2\2 \u00f6\3\2"+
		"\2\2\"\u010b\3\2\2\2$\u0116\3\2\2\2&\u0122\3\2\2\2(\u0127\3\2\2\2*\u012d"+
		"\3\2\2\2,\u0139\3\2\2\2.\u014a\3\2\2\2\60\u017a\3\2\2\2\62\u0187\3\2\2"+
		"\2\64\u018a\3\2\2\2\66\u019c\3\2\2\28\u019e\3\2\2\2:\u01ad\3\2\2\2<\u01af"+
		"\3\2\2\2>\u01b4\3\2\2\2@\u01da\3\2\2\2B\u01dc\3\2\2\2D\u01e5\3\2\2\2F"+
		"\u01ea\3\2\2\2H\u01f3\3\2\2\2J\u01f5\3\2\2\2L\u0205\3\2\2\2N\u0207\3\2"+
		"\2\2P\u0209\3\2\2\2R\u0214\3\2\2\2T\u0221\3\2\2\2V\u0223\3\2\2\2X\u0225"+
		"\3\2\2\2Z[\79\2\2[\\\5F$\2\\]\7=\2\2]^\5\4\3\2^b\5\6\4\2_`\5\f\7\2`a\7"+
		"=\2\2ac\3\2\2\2b_\3\2\2\2bc\3\2\2\2cd\3\2\2\2dh\5\16\b\2ef\5\20\t\2fg"+
		"\7=\2\2gi\3\2\2\2he\3\2\2\2hi\3\2\2\2i\3\3\2\2\2jk\7\67\2\2kr\7=\2\2l"+
		"m\5F$\2mn\78\2\2no\7=\2\2oq\3\2\2\2pl\3\2\2\2qt\3\2\2\2rp\3\2\2\2rs\3"+
		"\2\2\2s\5\3\2\2\2tr\3\2\2\2uv\7\66\2\2v\u0082\7=\2\2wx\5\b\5\2xy\7=\2"+
		"\2y\u0083\3\2\2\2z{\5\n\6\2{|\7=\2\2|\u0083\3\2\2\2}~\5F$\2~\177\7\36"+
		"\2\2\177\u0080\7\66\2\2\u0080\u0081\7=\2\2\u0081\u0083\3\2\2\2\u0082w"+
		"\3\2\2\2\u0082z\3\2\2\2\u0082}\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0082"+
		"\3\2\2\2\u0084\u0085\3\2\2\2\u0085\7\3\2\2\2\u0086\u0087\5F$\2\u0087\u0088"+
		"\7<\2\2\u0088\u008a\3\2\2\2\u0089\u0086\3\2\2\2\u0089\u008a\3\2\2\2\u008a"+
		"\u008b\3\2\2\2\u008b\u0093\5\22\n\2\u008c\u008d\5F$\2\u008d\u008e\7<\2"+
		"\2\u008e\u0090\3\2\2\2\u008f\u008c\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u0091"+
		"\3\2\2\2\u0091\u0093\5\30\r\2\u0092\u0089\3\2\2\2\u0092\u008f\3\2\2\2"+
		"\u0093\t\3\2\2\2\u0094\u0095\5F$\2\u0095\u0096\7\36\2\2\u0096\u0097\5"+
		"H%\2\u0097\13\3\2\2\2\u0098\u0099\7\65\2\2\u0099\u009a\7=\2\2\u009a\r"+
		"\3\2\2\2\u009b\u009c\7\64\2\2\u009c\u009d\5L\'\2\u009d\u009f\7\13\2\2"+
		"\u009e\u00a0\5L\'\2\u009f\u009e\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u00a5"+
		"\3\2\2\2\u00a1\u00a2\7\33\2\2\u00a2\u00a4\5L\'\2\u00a3\u00a1\3\2\2\2\u00a4"+
		"\u00a7\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00a8\3\2"+
		"\2\2\u00a7\u00a5\3\2\2\2\u00a8\u00ab\7\f\2\2\u00a9\u00aa\7\63\2\2\u00aa"+
		"\u00ac\5L\'\2\u00ab\u00a9\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00ae\3\2"+
		"\2\2\u00ad\u00af\7=\2\2\u00ae\u00ad\3\2\2\2\u00ae\u00af\3\2\2\2\u00af"+
		"\17\3\2\2\2\u00b0\u00b1\7\61\2\2\u00b1\u00b6\7=\2\2\u00b2\u00b3\5F$\2"+
		"\u00b3\u00b4\7\62\2\2\u00b4\u00b5\7=\2\2\u00b5\u00b7\3\2\2\2\u00b6\u00b2"+
		"\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8\u00b6\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9"+
		"\21\3\2\2\2\u00ba\u00bb\5F$\2\u00bb\u00be\7\5\2\2\u00bc\u00bf\5\24\13"+
		"\2\u00bd\u00bf\5\26\f\2\u00be\u00bc\3\2\2\2\u00be\u00bd\3\2\2\2\u00bf"+
		"\23\3\2\2\2\u00c0\u00c1\5 \21\2\u00c1\25\3\2\2\2\u00c2\u00c3\5\"\22\2"+
		"\u00c3\27\3\2\2\2\u00c4\u00c9\5J&\2\u00c5\u00c6\7\33\2\2\u00c6\u00c8\5"+
		"J&\2\u00c7\u00c5\3\2\2\2\u00c8\u00cb\3\2\2\2\u00c9\u00c7\3\2\2\2\u00c9"+
		"\u00ca\3\2\2\2\u00ca\u00cc\3\2\2\2\u00cb\u00c9\3\2\2\2\u00cc\u00ce\7\3"+
		"\2\2\u00cd\u00cf\7=\2\2\u00ce\u00cd\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf"+
		"\u00d0\3\2\2\2\u00d0\u00d8\5\32\16\2\u00d1\u00d3\7\32\2\2\u00d2\u00d4"+
		"\7=\2\2\u00d3\u00d2\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5"+
		"\u00d7\5\32\16\2\u00d6\u00d1\3\2\2\2\u00d7\u00da\3\2\2\2\u00d8\u00d6\3"+
		"\2\2\2\u00d8\u00d9\3\2\2\2\u00d9\31\3\2\2\2\u00da\u00d8\3\2\2\2\u00db"+
		"\u00e0\5J&\2\u00dc\u00dd\7\33\2\2\u00dd\u00df\5J&\2\u00de\u00dc\3\2\2"+
		"\2\u00df\u00e2\3\2\2\2\u00e0\u00de\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1\u00e3"+
		"\3\2\2\2\u00e2\u00e0\3\2\2\2\u00e3\u00e4\7\3\2\2\u00e4\u00e5\5\32\16\2"+
		"\u00e5\u00e8\3\2\2\2\u00e6\u00e8\5\34\17\2\u00e7\u00db\3\2\2\2\u00e7\u00e6"+
		"\3\2\2\2\u00e8\33\3\2\2\2\u00e9\u00ea\5(\25\2\u00ea\u00eb\7\3\2\2\u00eb"+
		"\u00ed\3\2\2\2\u00ec\u00e9\3\2\2\2\u00ec\u00ed\3\2\2\2\u00ed\u00ee\3\2"+
		"\2\2\u00ee\u00ef\5\36\20\2\u00ef\35\3\2\2\2\u00f0\u00f4\5L\'\2\u00f1\u00f2"+
		"\7/\2\2\u00f2\u00f5\5 \21\2\u00f3\u00f5\5\24\13\2\u00f4\u00f1\3\2\2\2"+
		"\u00f4\u00f3\3\2\2\2\u00f4\u00f5\3\2\2\2\u00f5\37\3\2\2\2\u00f6\u0109"+
		"\5&\24\2\u00f7\u00f8\7.\2\2\u00f8\u00fa\7\16\2\2\u00f9\u00fb\7=\2\2\u00fa"+
		"\u00f9\3\2\2\2\u00fa\u00fb\3\2\2\2\u00fb\u00fc\3\2\2\2\u00fc\u0104\5\34"+
		"\17\2\u00fd\u00ff\7\32\2\2\u00fe\u0100\7=\2\2\u00ff\u00fe\3\2\2\2\u00ff"+
		"\u0100\3\2\2\2\u0100\u0101\3\2\2\2\u0101\u0103\5\34\17\2\u0102\u00fd\3"+
		"\2\2\2\u0103\u0106\3\2\2\2\u0104\u0102\3\2\2\2\u0104\u0105\3\2\2\2\u0105"+
		"\u0107\3\2\2\2\u0106\u0104\3\2\2\2\u0107\u0108\7\17\2\2\u0108\u010a\3"+
		"\2\2\2\u0109\u00f7\3\2\2\2\u0109\u010a\3\2\2\2\u010a!\3\2\2\2\u010b\u0113"+
		"\5$\23\2\u010c\u010e\7\33\2\2\u010d\u010f\7=\2\2\u010e\u010d\3\2\2\2\u010e"+
		"\u010f\3\2\2\2\u010f\u0110\3\2\2\2\u0110\u0112\5$\23\2\u0111\u010c\3\2"+
		"\2\2\u0112\u0115\3\2\2\2\u0113\u0111\3\2\2\2\u0113\u0114\3\2\2\2\u0114"+
		"#\3\2\2\2\u0115\u0113\3\2\2\2\u0116\u0117\5*\26\2\u0117\u0118\7\3\2\2"+
		"\u0118\u0119\5\34\17\2\u0119%\3\2\2\2\u011a\u0123\7-\2\2\u011b\u0123\7"+
		"+\2\2\u011c\u0123\7,\2\2\u011d\u0123\58\35\2\u011e\u0123\5<\37\2\u011f"+
		"\u0123\5@!\2\u0120\u0123\5B\"\2\u0121\u0123\5D#\2\u0122\u011a\3\2\2\2"+
		"\u0122\u011b\3\2\2\2\u0122\u011c\3\2\2\2\u0122\u011d\3\2\2\2\u0122\u011e"+
		"\3\2\2\2\u0122\u011f\3\2\2\2\u0122\u0120\3\2\2\2\u0122\u0121\3\2\2\2\u0123"+
		"\'\3\2\2\2\u0124\u0128\5J&\2\u0125\u0128\5*\26\2\u0126\u0128\5\64\33\2"+
		"\u0127\u0124\3\2\2\2\u0127\u0125\3\2\2\2\u0127\u0126\3\2\2\2\u0128)\3"+
		"\2\2\2\u0129\u012e\5,\27\2\u012a\u012e\5.\30\2\u012b\u012e\5\60\31\2\u012c"+
		"\u012e\5\62\32\2\u012d\u0129\3\2\2\2\u012d\u012a\3\2\2\2\u012d\u012b\3"+
		"\2\2\2\u012d\u012c\3\2\2\2\u012e+\3\2\2\2\u012f\u0130\b\27\1\2\u0130\u0135"+
		"\5J&\2\u0131\u0132\7\36\2\2\u0132\u0134\5\66\34\2\u0133\u0131\3\2\2\2"+
		"\u0134\u0137\3\2\2\2\u0135\u0133\3\2\2\2\u0135\u0136\3\2\2\2\u0136\u013a"+
		"\3\2\2\2\u0137\u0135\3\2\2\2\u0138\u013a\5X-\2\u0139\u012f\3\2\2\2\u0139"+
		"\u0138\3\2\2\2\u013a\u0140\3\2\2\2\u013b\u013c\6\27\2\3\u013c\u013d\7"+
		"\35\2\2\u013d\u013f\5,\27\2\u013e\u013b\3\2\2\2\u013f\u0142\3\2\2\2\u0140"+
		"\u013e\3\2\2\2\u0140\u0141\3\2\2\2\u0141-\3\2\2\2\u0142\u0140\3\2\2\2"+
		"\u0143\u0144\b\30\1\2\u0144\u0145\5J&\2\u0145\u0146\7\36\2\2\u0146\u0147"+
		"\7\23\2\2\u0147\u014b\3\2\2\2\u0148\u014b\5> \2\u0149\u014b\7\60\2\2\u014a"+
		"\u0143\3\2\2\2\u014a\u0148\3\2\2\2\u014a\u0149\3\2\2\2\u014b\u015d\3\2"+
		"\2\2\u014c\u014d\6\30\3\3\u014d\u014e\7\30\2\2\u014e\u015c\5.\30\2\u014f"+
		"\u0150\6\30\4\3\u0150\u0151\7\r\2\2\u0151\u015c\5.\30\2\u0152\u0153\6"+
		"\30\5\3\u0153\u0154\7\31\2\2\u0154\u015c\5.\30\2\u0155\u0156\6\30\6\3"+
		"\u0156\u0157\7\26\2\2\u0157\u015c\5.\30\2\u0158\u0159\6\30\7\3\u0159\u015a"+
		"\7\27\2\2\u015a\u015c\5.\30\2\u015b\u014c\3\2\2\2\u015b\u014f\3\2\2\2"+
		"\u015b\u0152\3\2\2\2\u015b\u0155\3\2\2\2\u015b\u0158\3\2\2\2\u015c\u015f"+
		"\3\2\2\2\u015d\u015b\3\2\2\2\u015d\u015e\3\2\2\2\u015e/\3\2\2\2\u015f"+
		"\u015d\3\2\2\2\u0160\u0161\b\31\1\2\u0161\u017b\5V,\2\u0162\u017b\5> "+
		"\2\u0163\u017b\7\60\2\2\u0164\u0169\5J&\2\u0165\u0166\7\36\2\2\u0166\u0168"+
		"\5\66\34\2\u0167\u0165\3\2\2\2\u0168\u016b\3\2\2\2\u0169\u0167\3\2\2\2"+
		"\u0169\u016a\3\2\2\2\u016a\u0172\3\2\2\2\u016b\u0169\3\2\2\2\u016c\u0170"+
		"\7\36\2\2\u016d\u0171\7\23\2\2\u016e\u016f\7\22\2\2\u016f\u0171\7\34\2"+
		"\2\u0170\u016d\3\2\2\2\u0170\u016e\3\2\2\2\u0171\u0173\3\2\2\2\u0172\u016c"+
		"\3\2\2\2\u0172\u0173\3\2\2\2\u0173\u017b\3\2\2\2\u0174\u0175\5,\27\2\u0175"+
		"\u0178\7\6\2\2\u0176\u0179\5\60\31\2\u0177\u0179\5,\27\2\u0178\u0176\3"+
		"\2\2\2\u0178\u0177\3\2\2\2\u0179\u017b\3\2\2\2\u017a\u0160\3\2\2\2\u017a"+
		"\u0162\3\2\2\2\u017a\u0163\3\2\2\2\u017a\u0164\3\2\2\2\u017a\u0174\3\2"+
		"\2\2\u017b\u0184\3\2\2\2\u017c\u017d\6\31\b\3\u017d\u0180\7\6\2\2\u017e"+
		"\u0181\5\60\31\2\u017f\u0181\5,\27\2\u0180\u017e\3\2\2\2\u0180\u017f\3"+
		"\2\2\2\u0181\u0183\3\2\2\2\u0182\u017c\3\2\2\2\u0183\u0186\3\2\2\2\u0184"+
		"\u0182\3\2\2\2\u0184\u0185\3\2\2\2\u0185\61\3\2\2\2\u0186\u0184\3\2\2"+
		"\2\u0187\u0188\7\t\2\2\u0188\u0189\7\n\2\2\u0189\63\3\2\2\2\u018a\u018b"+
		"\5N(\2\u018b\u0194\7\13\2\2\u018c\u0191\5\34\17\2\u018d\u018e\7\33\2\2"+
		"\u018e\u0190\5\34\17\2\u018f\u018d\3\2\2\2\u0190\u0193\3\2\2\2\u0191\u018f"+
		"\3\2\2\2\u0191\u0192\3\2\2\2\u0192\u0195\3\2\2\2\u0193\u0191\3\2\2\2\u0194"+
		"\u018c\3\2\2\2\u0194\u0195\3\2\2\2\u0195\u0196\3\2\2\2\u0196\u0197\7\f"+
		"\2\2\u0197\65\3\2\2\2\u0198\u0199\7\22\2\2\u0199\u019d\t\2\2\2\u019a\u019d"+
		"\5T+\2\u019b\u019d\5J&\2\u019c\u0198\3\2\2\2\u019c\u019a\3\2\2\2\u019c"+
		"\u019b\3\2\2\2\u019d\67\3\2\2\2\u019e\u01ab\7\'\2\2\u019f\u01a0\7\16\2"+
		"\2\u01a0\u01a3\5:\36\2\u01a1\u01a2\7\33\2\2\u01a2\u01a4\5L\'\2\u01a3\u01a1"+
		"\3\2\2\2\u01a3\u01a4\3\2\2\2\u01a4\u01a7\3\2\2\2\u01a5\u01a6\7\33\2\2"+
		"\u01a6\u01a8\5L\'\2\u01a7\u01a5\3\2\2\2\u01a7\u01a8\3\2\2\2\u01a8\u01a9"+
		"\3\2\2\2\u01a9\u01aa\7\17\2\2\u01aa\u01ac\3\2\2\2\u01ab\u019f\3\2\2\2"+
		"\u01ab\u01ac\3\2\2\2\u01ac9\3\2\2\2\u01ad\u01ae\t\3\2\2\u01ae;\3\2\2\2"+
		"\u01af\u01b0\7\"\2\2\u01b0\u01b1\7\16\2\2\u01b1\u01b2\5L\'\2\u01b2\u01b3"+
		"\7\17\2\2\u01b3=\3\2\2\2\u01b4\u01b8\7:\2\2\u01b5\u01b7\5T+\2\u01b6\u01b5"+
		"\3\2\2\2\u01b7\u01ba\3\2\2\2\u01b8\u01b6\3\2\2\2\u01b8\u01b9\3\2\2\2\u01b9"+
		"?\3\2\2\2\u01ba\u01b8\3\2\2\2\u01bb\u01d1\7!\2\2\u01bc\u01bd\7\16\2\2"+
		"\u01bd\u01be\5J&\2\u01be\u01c1\7\n\2\2\u01bf\u01c2\5L\'\2\u01c0\u01c2"+
		"\5> \2\u01c1\u01bf\3\2\2\2\u01c1\u01c0\3\2\2\2\u01c2\u01cc\3\2\2\2\u01c3"+
		"\u01c4\7\33\2\2\u01c4\u01c5\5J&\2\u01c5\u01c8\7\n\2\2\u01c6\u01c9\5L\'"+
		"\2\u01c7\u01c9\5> \2\u01c8\u01c6\3\2\2\2\u01c8\u01c7\3\2\2\2\u01c9\u01cb"+
		"\3\2\2\2\u01ca\u01c3\3\2\2\2\u01cb\u01ce\3\2\2\2\u01cc\u01ca\3\2\2\2\u01cc"+
		"\u01cd\3\2\2\2\u01cd\u01cf\3\2\2\2\u01ce\u01cc\3\2\2\2\u01cf\u01d0\7\17"+
		"\2\2\u01d0\u01d2\3\2\2\2\u01d1\u01bc\3\2\2\2\u01d1\u01d2\3\2\2\2\u01d2"+
		"\u01db\3\2\2\2\u01d3\u01d8\7!\2\2\u01d4\u01d5\7\16\2\2\u01d5\u01d6\5>"+
		" \2\u01d6\u01d7\7\17\2\2\u01d7\u01d9\3\2\2\2\u01d8\u01d4\3\2\2\2\u01d8"+
		"\u01d9\3\2\2\2\u01d9\u01db\3\2\2\2\u01da\u01bb\3\2\2\2\u01da\u01d3\3\2"+
		"\2\2\u01dbA\3\2\2\2\u01dc\u01dd\7 \2\2\u01dd\u01de\7\16\2\2\u01de\u01df"+
		"\5L\'\2\u01df\u01e0\7\33\2\2\u01e0\u01e1\5R*\2\u01e1\u01e2\7\33\2\2\u01e2"+
		"\u01e3\5P)\2\u01e3\u01e4\7\17\2\2\u01e4C\3\2\2\2\u01e5\u01e6\7\37\2\2"+
		"\u01e6\u01e7\7\16\2\2\u01e7\u01e8\5R*\2\u01e8\u01e9\7\17\2\2\u01e9E\3"+
		"\2\2\2\u01ea\u01f0\7;\2\2\u01eb\u01ef\7\7\2\2\u01ec\u01ef\5T+\2\u01ed"+
		"\u01ef\7;\2\2\u01ee\u01eb\3\2\2\2\u01ee\u01ec\3\2\2\2\u01ee\u01ed\3\2"+
		"\2\2\u01ef\u01f2\3\2\2\2\u01f0\u01ee\3\2\2\2\u01f0\u01f1\3\2\2\2\u01f1"+
		"G\3\2\2\2\u01f2\u01f0\3\2\2\2\u01f3\u01f4\5F$\2\u01f4I\3\2\2\2\u01f5\u01f7"+
		"\5F$\2\u01f6\u01f8\7\4\2\2\u01f7\u01f6\3\2\2\2\u01f7\u01f8\3\2\2\2\u01f8"+
		"K\3\2\2\2\u01f9\u0206\5N(\2\u01fa\u01fb\5N(\2\u01fb\u01fc\7\16\2\2\u01fc"+
		"\u01fd\7\17\2\2\u01fd\u0206\3\2\2\2\u01fe\u01ff\5N(\2\u01ff\u0200\7\36"+
		"\2\2\u0200\u0201\5N(\2\u0201\u0206\3\2\2\2\u0202\u0203\5N(\2\u0203\u0204"+
		"\7\b\2\2\u0204\u0206\3\2\2\2\u0205\u01f9\3\2\2\2\u0205\u01fa\3\2\2\2\u0205"+
		"\u01fe\3\2\2\2\u0205\u0202\3\2\2\2\u0206M\3\2\2\2\u0207\u0208\5F$\2\u0208"+
		"O\3\2\2\2\u0209\u0210\5F$\2\u020a\u020c\7\36\2\2\u020b\u020a\3\2\2\2\u020b"+
		"\u020c\3\2\2\2\u020c\u020d\3\2\2\2\u020d\u020f\5F$\2\u020e\u020b\3\2\2"+
		"\2\u020f\u0212\3\2\2\2\u0210\u020e\3\2\2\2\u0210\u0211\3\2\2\2\u0211Q"+
		"\3\2\2\2\u0212\u0210\3\2\2\2\u0213\u0215\7\36\2\2\u0214\u0213\3\2\2\2"+
		"\u0214\u0215\3\2\2\2\u0215\u0217\3\2\2\2\u0216\u0218\7\r\2\2\u0217\u0216"+
		"\3\2\2\2\u0217\u0218\3\2\2\2\u0218\u0219\3\2\2\2\u0219\u021e\5P)\2\u021a"+
		"\u021b\7\r\2\2\u021b\u021d\5P)\2\u021c\u021a\3\2\2\2\u021d\u0220\3\2\2"+
		"\2\u021e\u021c\3\2\2\2\u021e\u021f\3\2\2\2\u021fS\3\2\2\2\u0220\u021e"+
		"\3\2\2\2\u0221\u0222\t\4\2\2\u0222U\3\2\2\2\u0223\u0224\7\24\2\2\u0224"+
		"W\3\2\2\2\u0225\u0228\7\20\2\2\u0226\u0229\5> \2\u0227\u0229\5V,\2\u0228"+
		"\u0226\3\2\2\2\u0228\u0227\3\2\2\2\u0229\u0231\3\2\2\2\u022a\u022d\7\33"+
		"\2\2\u022b\u022e\5> \2\u022c\u022e\5V,\2\u022d\u022b\3\2\2\2\u022d\u022c"+
		"\3\2\2\2\u022e\u0230\3\2\2\2\u022f\u022a\3\2\2\2\u0230\u0233\3\2\2\2\u0231"+
		"\u022f\3\2\2\2\u0231\u0232\3\2\2\2\u0232\u0234\3\2\2\2\u0233\u0231\3\2"+
		"\2\2\u0234\u0235\7\21\2\2\u0235Y\3\2\2\2Gbhr\u0082\u0084\u0089\u008f\u0092"+
		"\u009f\u00a5\u00ab\u00ae\u00b8\u00be\u00c9\u00ce\u00d3\u00d8\u00e0\u00e7"+
		"\u00ec\u00f4\u00fa\u00ff\u0104\u0109\u010e\u0113\u0122\u0127\u012d\u0135"+
		"\u0139\u0140\u014a\u015b\u015d\u0169\u0170\u0172\u0178\u017a\u0180\u0184"+
		"\u0191\u0194\u019c\u01a3\u01a7\u01ab\u01b8\u01c1\u01c8\u01cc\u01d1\u01d8"+
		"\u01da\u01ee\u01f0\u01f7\u0205\u020b\u0210\u0214\u0217\u021e\u0228\u022d"+
		"\u0231";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}