// Generated from FTCRL.g4 by ANTLR 4.0

	package client.blogic.testing.refinamiento;

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
		DQUOTE=18, ZERO=19, PLUS=20, MINUS=21, DIV=22, MOD=23, SEMICOLON=24, COMMA=25, 
		STR=26, CUP=27, DOT=28, FILE=29, TABLE=30, ENUM=31, REF=32, SLL=33, DLL=34, 
		CLL=35, DCLL=36, LIST=37, DOM=38, RAN=39, ELEM=40, RECORD=41, MAPPING=42, 
		ARRAY=43, WITH=44, AS=45, AUTOFILL=46, EPILOGUE=47, AEPILOGUE=48, MODULE=49, 
		UUT=50, PLCODE=51, LAWS=52, ALAWS=53, PREAMBLE=54, APREAMBLE=55, RRULE=56, 
		DIGIT=57, LETTER=58, COLON=59, WS=60;
	public static final String[] tokenNames = {
		"<INVALID>", "'==>'", "'?'", "'=='", "'++'", "'_'", "'.*'", "'<'", "'>'", 
		"'('", "')'", "'/'", "'['", "']'", "LCB", "RCB", "'@'", "'#'", "'\"'", 
		"'0'", "'+'", "'-'", "'div'", "'mod'", "';'", "','", "'@STR'", "'@CUP@'", 
		"'.'", "'FILE'", "'TABLE'", "'ENUM'", "'REF'", "'SLL'", "'DLL'", "'CLL'", 
		"'DCLL'", "'LIST'", "'DOM'", "'RAN'", "'ELEM'", "'RECORD'", "'MAPPING'", 
		"'ARRAY'", "'WITH'", "'AS'", "'@AUTOFILL'", "'@EPILOGUE'", "'.@EPILOGUE'", 
		"'MODULE'", "'@UUT'", "'@PLCODE'", "LAWS", "ALAWS", "'@PREAMBLE'", "'.@PREAMBLE'", 
		"'@RRULE'", "DIGIT", "LETTER", "':'", "WS"
	};
	public static final int
		RULE_refinementRules = 0, RULE_refinementRule = 1, RULE_preamble = 2, 
		RULE_laws = 3, RULE_law = 4, RULE_reference = 5, RULE_plcode = 6, RULE_uut = 7, 
		RULE_epilogue = 8, RULE_synonymLaw = 9, RULE_asSynonym = 10, RULE_withSynonym = 11, 
		RULE_refinementLaw = 12, RULE_refinementSentence = 13, RULE_refinement = 14, 
		RULE_iExprRefinement = 15, RULE_asRefinement = 16, RULE_withRefinement = 17, 
		RULE_exprRefinement = 18, RULE_dataStruct = 19, RULE_sExprRefinement = 20, 
		RULE_zExpr = 21, RULE_zExprSet = 22, RULE_zExprNum = 23, RULE_zExprString = 24, 
		RULE_zExprSeq = 25, RULE_funAppExpr = 26, RULE_dotSetOper = 27, RULE_list = 28, 
		RULE_listType = 29, RULE_reference2 = 30, RULE_number = 31, RULE_enumeration = 32, 
		RULE_table = 33, RULE_file = 34, RULE_name = 35, RULE_lawName = 36, RULE_sName = 37, 
		RULE_iName = 38, RULE_iIdent = 39, RULE_fName = 40, RULE_path = 41, RULE_digit = 42, 
		RULE_string = 43, RULE_setExtension = 44;
	public static final String[] ruleNames = {
		"refinementRules", "refinementRule", "preamble", "laws", "law", "reference", 
		"plcode", "uut", "epilogue", "synonymLaw", "asSynonym", "withSynonym", 
		"refinementLaw", "refinementSentence", "refinement", "iExprRefinement", 
		"asRefinement", "withRefinement", "exprRefinement", "dataStruct", "sExprRefinement", 
		"zExpr", "zExprSet", "zExprNum", "zExprString", "zExprSeq", "funAppExpr", 
		"dotSetOper", "list", "listType", "reference2", "number", "enumeration", 
		"table", "file", "name", "lawName", "sName", "iName", "iIdent", "fName", 
		"path", "digit", "string", "setExtension"
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
	public static class RefinementRulesContext extends ParserRuleContext {
		public List<RefinementRuleContext> refinementRule() {
			return getRuleContexts(RefinementRuleContext.class);
		}
		public RefinementRuleContext refinementRule(int i) {
			return getRuleContext(RefinementRuleContext.class,i);
		}
		public RefinementRulesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_refinementRules; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FTCRLListener ) ((FTCRLListener)listener).enterRefinementRules(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FTCRLListener ) ((FTCRLListener)listener).exitRefinementRules(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FTCRLVisitor ) return ((FTCRLVisitor<? extends T>)visitor).visitRefinementRules(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RefinementRulesContext refinementRules() throws RecognitionException {
		RefinementRulesContext _localctx = new RefinementRulesContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_refinementRules);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(90); refinementRule();
				}
				}
				setState(93); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==RRULE );
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

	public static class RefinementRuleContext extends ParserRuleContext {
		public EpilogueContext epilogue() {
			return getRuleContext(EpilogueContext.class,0);
		}
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
		enterRule(_localctx, 2, RULE_refinementRule);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95); match(RRULE);
			setState(96); name();
			setState(97); preamble();
			setState(98); laws();
			setState(100);
			_la = _input.LA(1);
			if (_la==PLCODE) {
				{
				setState(99); plcode();
				}
			}

			setState(102); uut();
			setState(104);
			_la = _input.LA(1);
			if (_la==EPILOGUE) {
				{
				setState(103); epilogue();
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
		public List<NameContext> name() {
			return getRuleContexts(NameContext.class);
		}
		public NameContext name(int i) {
			return getRuleContext(NameContext.class,i);
		}
		public List<TerminalNode> APREAMBLE() { return getTokens(FTCRLParser.APREAMBLE); }
		public TerminalNode PREAMBLE() { return getToken(FTCRLParser.PREAMBLE, 0); }
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
		enterRule(_localctx, 4, RULE_preamble);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106); match(PREAMBLE);
			setState(112);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LETTER) {
				{
				{
				setState(107); name();
				setState(108); match(APREAMBLE);
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
		public List<NameContext> name() {
			return getRuleContexts(NameContext.class);
		}
		public NameContext name(int i) {
			return getRuleContext(NameContext.class,i);
		}
		public List<TerminalNode> ALAWS() { return getTokens(FTCRLParser.ALAWS); }
		public LawContext law(int i) {
			return getRuleContext(LawContext.class,i);
		}
		public TerminalNode LAWS() { return getToken(FTCRLParser.LAWS, 0); }
		public List<ReferenceContext> reference() {
			return getRuleContexts(ReferenceContext.class);
		}
		public TerminalNode ALAWS(int i) {
			return getToken(FTCRLParser.ALAWS, i);
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
		enterRule(_localctx, 6, RULE_laws);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115); match(LAWS);
			setState(121); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(121);
				switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
				case 1:
					{
					setState(116); law();
					}
					break;

				case 2:
					{
					setState(117); reference();
					}
					break;

				case 3:
					{
					setState(118); name();
					setState(119); match(ALAWS);
					}
					break;
				}
				}
				setState(123); 
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
		enterRule(_localctx, 8, RULE_law);
		try {
			setState(137);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(128);
				switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
				case 1:
					{
					setState(125); name();
					setState(126); match(COLON);
					}
					break;
				}
				setState(130); synonymLaw();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(134);
				switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
				case 1:
					{
					setState(131); name();
					setState(132); match(COLON);
					}
					break;
				}
				setState(136); refinementLaw();
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
		enterRule(_localctx, 10, RULE_reference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139); name();
			setState(140); match(DOT);
			setState(141); lawName();
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
		enterRule(_localctx, 12, RULE_plcode);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143); match(PLCODE);
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
		enterRule(_localctx, 14, RULE_uut);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145); match(UUT);
			setState(146); iName();
			setState(147); match(LB);
			setState(149);
			_la = _input.LA(1);
			if (_la==LETTER) {
				{
				setState(148); iName();
				}
			}

			setState(155);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(151); match(COMMA);
				setState(152); iName();
				}
				}
				setState(157);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(158); match(RB);
			setState(161);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1+1:
				{
				setState(159); match(MODULE);
				setState(160); iName();
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

	public static class EpilogueContext extends ParserRuleContext {
		public List<TerminalNode> AEPILOGUE() { return getTokens(FTCRLParser.AEPILOGUE); }
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
		enterRule(_localctx, 16, RULE_epilogue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(163); match(EPILOGUE);
			setState(167); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(164); name();
				setState(165); match(AEPILOGUE);
				}
				}
				setState(169); 
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
		enterRule(_localctx, 18, RULE_synonymLaw);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(171); name();
			setState(172); match(EQUALQAUAL);
			setState(175);
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
				setState(173); asSynonym();
				}
				break;
			case L:
			case LCB:
			case DQUOTE:
			case AUTOFILL:
			case DIGIT:
			case LETTER:
				{
				setState(174); withSynonym();
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
		enterRule(_localctx, 20, RULE_asSynonym);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(177); asRefinement();
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
		enterRule(_localctx, 22, RULE_withSynonym);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(179); withRefinement();
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
		enterRule(_localctx, 24, RULE_refinementLaw);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(181); sName();
			setState(186);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(182); match(COMMA);
				setState(183); sName();
				}
				}
				setState(188);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(190);
			_la = _input.LA(1);
			if (_la==1) {
				{
				setState(189); match(1);
				}
			}

			setState(192); refinementSentence();
			setState(199);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(194);
					_la = _input.LA(1);
					if (_la==SEMICOLON) {
						{
						setState(193); match(SEMICOLON);
						}
					}

					setState(196); refinementSentence();
					}
					} 
				}
				setState(201);
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
		enterRule(_localctx, 26, RULE_refinementSentence);
		int _la;
		try {
			setState(214);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(202); sName();
				setState(207);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(203); match(COMMA);
					setState(204); sName();
					}
					}
					setState(209);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(210); match(1);
				setState(211); refinementSentence();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(213); refinement();
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
		enterRule(_localctx, 28, RULE_refinement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(219);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				setState(216); sExprRefinement();
				setState(217); match(1);
				}
				break;
			}
			setState(221); iExprRefinement();
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
		enterRule(_localctx, 30, RULE_iExprRefinement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(223); iName();
			setState(227);
			switch (_input.LA(1)) {
			case AS:
				{
				setState(224); match(AS);
				setState(225); asRefinement();
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
				setState(226); asSynonym();
				}
				break;
			case L:
			case RB:
			case RSB:
			case LCB:
			case DQUOTE:
			case SEMICOLON:
			case COMMA:
			case AUTOFILL:
			case UUT:
			case PLCODE:
			case DIGIT:
			case LETTER:
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
		public DataStructContext dataStruct() {
			return getRuleContext(DataStructContext.class,0);
		}
		public TerminalNode RSB() { return getToken(FTCRLParser.RSB, 0); }
		public RefinementContext refinement(int i) {
			return getRuleContext(RefinementContext.class,i);
		}
		public TerminalNode LSB() { return getToken(FTCRLParser.LSB, 0); }
		public TerminalNode WITH() { return getToken(FTCRLParser.WITH, 0); }
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
		enterRule(_localctx, 32, RULE_asRefinement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(229); dataStruct();
			setState(247);
			_la = _input.LA(1);
			if (_la==WITH) {
				{
				setState(230); match(WITH);
				setState(232);
				_la = _input.LA(1);
				if (_la==LSB) {
					{
					setState(231); match(LSB);
					}
				}

				setState(234); refinement();
				setState(242);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==SEMICOLON) {
					{
					{
					setState(235); match(SEMICOLON);
					setState(237);
					switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
					case 1:
						{
						}
						break;
					}
					setState(239); refinement();
					}
					}
					setState(244);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(245); match(RSB);
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
		public List<ExprRefinementContext> exprRefinement() {
			return getRuleContexts(ExprRefinementContext.class);
		}
		public List<TerminalNode> COMMA() { return getTokens(FTCRLParser.COMMA); }
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
		enterRule(_localctx, 34, RULE_withRefinement);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(249); exprRefinement();
			setState(256);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(251);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(250); match(COMMA);
						}
					}

					setState(253); exprRefinement();
					}
					} 
				}
				setState(258);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
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
		enterRule(_localctx, 36, RULE_exprRefinement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(259); zExpr();
			setState(260); match(1);
			setState(261); refinement();
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
		enterRule(_localctx, 38, RULE_dataStruct);
		try {
			setState(271);
			switch (_input.LA(1)) {
			case ARRAY:
				enterOuterAlt(_localctx, 1);
				{
				setState(263); match(ARRAY);
				}
				break;
			case RECORD:
				enterOuterAlt(_localctx, 2);
				{
				setState(264); match(RECORD);
				}
				break;
			case MAPPING:
				enterOuterAlt(_localctx, 3);
				{
				setState(265); match(MAPPING);
				}
				break;
			case LIST:
				enterOuterAlt(_localctx, 4);
				{
				setState(266); list();
				}
				break;
			case REF:
				enterOuterAlt(_localctx, 5);
				{
				setState(267); reference2();
				}
				break;
			case ENUM:
				enterOuterAlt(_localctx, 6);
				{
				setState(268); enumeration();
				}
				break;
			case TABLE:
				enterOuterAlt(_localctx, 7);
				{
				setState(269); table();
				}
				break;
			case FILE:
				enterOuterAlt(_localctx, 8);
				{
				setState(270); file();
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
		enterRule(_localctx, 40, RULE_sExprRefinement);
		try {
			setState(276);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(273); sName();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(274); zExpr();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(275); funAppExpr();
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
		enterRule(_localctx, 42, RULE_zExpr);
		try {
			setState(282);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(278); zExprSet(0);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(279); zExprNum(0);
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(280); zExprString(0);
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(281); zExprSeq();
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
		int _startState = 44;
		enterRecursionRule(_localctx, RULE_zExprSet);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(294);
			switch (_input.LA(1)) {
			case LETTER:
				{
				setState(285); sName();
				setState(290);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
				while ( _alt!=2 && _alt!=-1 ) {
					if ( _alt==1 ) {
						{
						{
						setState(286); match(DOT);
						setState(287); dotSetOper();
						}
						} 
					}
					setState(292);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
				}
				}
				break;
			case LCB:
				{
				setState(293); setExtension();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(301);
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
					setState(296);
					if (!(1 >= _localctx._p)) throw new FailedPredicateException(this, "1 >= $_p");
					setState(297); match(CUP);
					setState(298); zExprSet(2);
					}
					} 
				}
				setState(303);
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
		int _startState = 46;
		enterRecursionRule(_localctx, RULE_zExprNum);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(311);
			switch (_input.LA(1)) {
			case LETTER:
				{
				setState(305); sName();
				setState(306); match(DOT);
				setState(307); match(CARD);
				}
				break;
			case DIGIT:
				{
				setState(309); number();
				}
				break;
			case AUTOFILL:
				{
				setState(310); match(AUTOFILL);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(330);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(328);
					switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
					case 1:
						{
						_localctx = new ZExprNumContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_zExprNum);
						setState(313);
						if (!(5 >= _localctx._p)) throw new FailedPredicateException(this, "5 >= $_p");
						setState(314); match(DIV);
						setState(315); zExprNum(6);
						}
						break;

					case 2:
						{
						_localctx = new ZExprNumContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_zExprNum);
						setState(316);
						if (!(4 >= _localctx._p)) throw new FailedPredicateException(this, "4 >= $_p");
						setState(317); match(SLASH);
						setState(318); zExprNum(5);
						}
						break;

					case 3:
						{
						_localctx = new ZExprNumContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_zExprNum);
						setState(319);
						if (!(3 >= _localctx._p)) throw new FailedPredicateException(this, "3 >= $_p");
						setState(320); match(MOD);
						setState(321); zExprNum(4);
						}
						break;

					case 4:
						{
						_localctx = new ZExprNumContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_zExprNum);
						setState(322);
						if (!(2 >= _localctx._p)) throw new FailedPredicateException(this, "2 >= $_p");
						setState(323); match(PLUS);
						setState(324); zExprNum(3);
						}
						break;

					case 5:
						{
						_localctx = new ZExprNumContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_zExprNum);
						setState(325);
						if (!(1 >= _localctx._p)) throw new FailedPredicateException(this, "1 >= $_p");
						setState(326); match(MINUS);
						setState(327); zExprNum(2);
						}
						break;
					}
					} 
				}
				setState(332);
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
		public ZExprStringContext zExprString(int i) {
			return getRuleContext(ZExprStringContext.class,i);
		}
		public StringContext string() {
			return getRuleContext(StringContext.class,0);
		}
		public TerminalNode DOT() { return getToken(FTCRLParser.DOT, 0); }
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public TerminalNode PLUSPLUS() { return getToken(FTCRLParser.PLUSPLUS, 0); }
		public TerminalNode AUTOFILL() { return getToken(FTCRLParser.AUTOFILL, 0); }
		public List<ZExprStringContext> zExprString() {
			return getRuleContexts(ZExprStringContext.class);
		}
		public SNameContext sName() {
			return getRuleContext(SNameContext.class,0);
		}
		public TerminalNode CARD() { return getToken(FTCRLParser.CARD, 0); }
		public DotSetOperContext dotSetOper() {
			return getRuleContext(DotSetOperContext.class,0);
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
		int _startState = 48;
		enterRecursionRule(_localctx, RULE_zExprString);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(351);
			switch (_input.LA(1)) {
			case DQUOTE:
				{
				setState(334); string();
				}
				break;
			case DIGIT:
				{
				setState(335); number();
				}
				break;
			case AUTOFILL:
				{
				setState(336); match(AUTOFILL);
				}
				break;
			case LETTER:
				{
				setState(337); sName();
				setState(349);
				switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
				case 1:
					{
					setState(338); match(DOT);
					setState(347);
					switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
					case 1:
						{
						setState(342);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
						while ( _alt!=2 && _alt!=-1 ) {
							if ( _alt==1 ) {
								{
								{
								setState(339); dotSetOper();
								}
								} 
							}
							setState(344);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
						}
						}
						break;

					case 2:
						{
						setState(345); match(CARD);
						}
						break;

					case 3:
						{
						setState(346); match(STR);
						}
						break;
					}
					}
					break;
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(358);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ZExprStringContext(_parentctx, _parentState, _p);
					pushNewRecursionContext(_localctx, _startState, RULE_zExprString);
					setState(353);
					if (!(1 >= _localctx._p)) throw new FailedPredicateException(this, "1 >= $_p");
					setState(354); match(PLUSPLUS);
					setState(355); zExprString(2);
					}
					} 
				}
				setState(360);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
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
		enterRule(_localctx, 50, RULE_zExprSeq);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(361); match(L);
			setState(362); match(R);
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
		enterRule(_localctx, 52, RULE_funAppExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(364); iIdent();
			setState(365); match(LB);
			setState(374);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << L) | (1L << LCB) | (1L << DQUOTE) | (1L << AUTOFILL) | (1L << DIGIT) | (1L << LETTER))) != 0)) {
				{
				setState(366); refinement();
				setState(371);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(367); match(COMMA);
					setState(368); refinement();
					}
					}
					setState(373);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(376); match(RB);
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
		enterRule(_localctx, 54, RULE_dotSetOper);
		int _la;
		try {
			setState(382);
			switch (_input.LA(1)) {
			case ARROBA:
				enterOuterAlt(_localctx, 1);
				{
				setState(378); match(ARROBA);
				setState(379);
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
				setState(380); digit();
				}
				break;
			case LETTER:
				enterOuterAlt(_localctx, 3);
				{
				setState(381); sName();
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
		enterRule(_localctx, 56, RULE_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(384); match(LIST);
			setState(397);
			_la = _input.LA(1);
			if (_la==LSB) {
				{
				setState(385); match(LSB);
				setState(386); listType();
				setState(389);
				switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
				case 1:
					{
					setState(387); match(COMMA);
					setState(388); iName();
					}
					break;
				}
				setState(393);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(391); match(COMMA);
					setState(392); iName();
					}
				}

				setState(395); match(RSB);
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
		enterRule(_localctx, 58, RULE_listType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(399);
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
		enterRule(_localctx, 60, RULE_reference2);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(401); match(REF);
			setState(402); match(LSB);
			setState(403); iName();
			setState(404); match(RSB);
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
		enterRule(_localctx, 62, RULE_number);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(406); match(DIGIT);
			setState(410);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,48,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(407); digit();
					}
					} 
				}
				setState(412);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,48,_ctx);
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
		enterRule(_localctx, 64, RULE_enumeration);
		int _la;
		try {
			setState(444);
			switch ( getInterpreter().adaptivePredict(_input,54,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(413); match(ENUM);
				setState(435);
				_la = _input.LA(1);
				if (_la==LSB) {
					{
					setState(414); match(LSB);
					setState(415); sName();
					setState(416); match(R);
					setState(419);
					switch (_input.LA(1)) {
					case LETTER:
						{
						setState(417); iName();
						}
						break;
					case DIGIT:
						{
						setState(418); number();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(430);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(421); match(COMMA);
						setState(422); sName();
						setState(423); match(R);
						setState(426);
						switch (_input.LA(1)) {
						case LETTER:
							{
							setState(424); iName();
							}
							break;
						case DIGIT:
							{
							setState(425); number();
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						}
						}
						setState(432);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(433); match(RSB);
					}
				}

				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(437); match(ENUM);
				setState(442);
				_la = _input.LA(1);
				if (_la==LSB) {
					{
					setState(438); match(LSB);
					setState(439); number();
					setState(440); match(RSB);
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
		enterRule(_localctx, 66, RULE_table);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(446); match(TABLE);
			setState(447); match(LSB);
			setState(448); iName();
			setState(449); match(COMMA);
			setState(450); path();
			setState(451); match(COMMA);
			setState(452); fName();
			setState(453); match(RSB);
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
		enterRule(_localctx, 68, RULE_file);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(455); match(FILE);
			setState(456); match(LSB);
			setState(457); path();
			setState(458); match(RSB);
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
		enterRule(_localctx, 70, RULE_name);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(460); match(LETTER);
			setState(466);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,56,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					setState(464);
					switch (_input.LA(1)) {
					case UNDERSCORE:
						{
						setState(461); match(UNDERSCORE);
						}
						break;
					case ZERO:
					case DIGIT:
						{
						setState(462); digit();
						}
						break;
					case LETTER:
						{
						setState(463); match(LETTER);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(468);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,56,_ctx);
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
		enterRule(_localctx, 72, RULE_lawName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(469); name();
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
		enterRule(_localctx, 74, RULE_sName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(471); name();
			setState(473);
			switch ( getInterpreter().adaptivePredict(_input,57,_ctx) ) {
			case 1:
				{
				setState(472); match(Q);
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
		enterRule(_localctx, 76, RULE_iName);
		try {
			setState(487);
			switch ( getInterpreter().adaptivePredict(_input,58,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(475); iIdent();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(476); iIdent();
				setState(477); match(LSB);
				setState(478); match(RSB);
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(480); iIdent();
				setState(481); match(DOT);
				setState(482); iIdent();
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(484); iIdent();
				setState(485); match(DOTA);
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
		enterRule(_localctx, 78, RULE_iIdent);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(489); name();
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
		enterRule(_localctx, 80, RULE_fName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(491); name();
			setState(498);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT || _la==LETTER) {
				{
				{
				setState(493);
				_la = _input.LA(1);
				if (_la==DOT) {
					{
					setState(492); match(DOT);
					}
				}

				setState(495); name();
				}
				}
				setState(500);
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
		enterRule(_localctx, 82, RULE_path);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(502);
			_la = _input.LA(1);
			if (_la==DOT) {
				{
				setState(501); match(DOT);
				}
			}

			setState(505);
			_la = _input.LA(1);
			if (_la==SLASH) {
				{
				setState(504); match(SLASH);
				}
			}

			setState(507); fName();
			setState(512);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SLASH) {
				{
				{
				setState(508); match(SLASH);
				setState(509); fName();
				}
				}
				setState(514);
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
		enterRule(_localctx, 84, RULE_digit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(515);
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
		public List<DigitContext> digit() {
			return getRuleContexts(DigitContext.class);
		}
		public TerminalNode LETTER(int i) {
			return getToken(FTCRLParser.LETTER, i);
		}
		public DigitContext digit(int i) {
			return getRuleContext(DigitContext.class,i);
		}
		public List<TerminalNode> DQUOTE() { return getTokens(FTCRLParser.DQUOTE); }
		public TerminalNode DQUOTE(int i) {
			return getToken(FTCRLParser.DQUOTE, i);
		}
		public List<TerminalNode> LETTER() { return getTokens(FTCRLParser.LETTER); }
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
		enterRule(_localctx, 86, RULE_string);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(517); match(DQUOTE);
			setState(522);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ZERO) | (1L << DIGIT) | (1L << LETTER))) != 0)) {
				{
				setState(520);
				switch (_input.LA(1)) {
				case ZERO:
				case DIGIT:
					{
					setState(518); digit();
					}
					break;
				case LETTER:
					{
					setState(519); match(LETTER);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(524);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(525); match(DQUOTE);
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
		public TerminalNode RCB() { return getToken(FTCRLParser.RCB, 0); }
		public TerminalNode LCB() { return getToken(FTCRLParser.LCB, 0); }
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
		enterRule(_localctx, 88, RULE_setExtension);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(527); match(LCB);
			setState(528); match(RCB);
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
		case 22: return zExprSet_sempred((ZExprSetContext)_localctx, predIndex);

		case 23: return zExprNum_sempred((ZExprNumContext)_localctx, predIndex);

		case 24: return zExprString_sempred((ZExprStringContext)_localctx, predIndex);
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
		"\2\3>\u0215\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4"+
		"\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20"+
		"\4\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27"+
		"\4\30\t\30\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36"+
		"\4\37\t\37\4 \t \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4"+
		")\t)\4*\t*\4+\t+\4,\t,\4-\t-\4.\t.\3\2\6\2^\n\2\r\2\16\2_\3\3\3\3\3\3"+
		"\3\3\3\3\5\3g\n\3\3\3\3\3\5\3k\n\3\3\4\3\4\3\4\3\4\7\4q\n\4\f\4\16\4t"+
		"\13\4\3\5\3\5\3\5\3\5\3\5\3\5\6\5|\n\5\r\5\16\5}\3\6\3\6\3\6\5\6\u0083"+
		"\n\6\3\6\3\6\3\6\3\6\5\6\u0089\n\6\3\6\5\6\u008c\n\6\3\7\3\7\3\7\3\7\3"+
		"\b\3\b\3\t\3\t\3\t\3\t\5\t\u0098\n\t\3\t\3\t\7\t\u009c\n\t\f\t\16\t\u009f"+
		"\13\t\3\t\3\t\3\t\5\t\u00a4\n\t\3\n\3\n\3\n\3\n\6\n\u00aa\n\n\r\n\16\n"+
		"\u00ab\3\13\3\13\3\13\3\13\5\13\u00b2\n\13\3\f\3\f\3\r\3\r\3\16\3\16\3"+
		"\16\7\16\u00bb\n\16\f\16\16\16\u00be\13\16\3\16\5\16\u00c1\n\16\3\16\3"+
		"\16\5\16\u00c5\n\16\3\16\7\16\u00c8\n\16\f\16\16\16\u00cb\13\16\3\17\3"+
		"\17\3\17\7\17\u00d0\n\17\f\17\16\17\u00d3\13\17\3\17\3\17\3\17\3\17\5"+
		"\17\u00d9\n\17\3\20\3\20\3\20\5\20\u00de\n\20\3\20\3\20\3\21\3\21\3\21"+
		"\3\21\5\21\u00e6\n\21\3\22\3\22\3\22\5\22\u00eb\n\22\3\22\3\22\3\22\5"+
		"\22\u00f0\n\22\3\22\7\22\u00f3\n\22\f\22\16\22\u00f6\13\22\3\22\3\22\5"+
		"\22\u00fa\n\22\3\23\3\23\5\23\u00fe\n\23\3\23\7\23\u0101\n\23\f\23\16"+
		"\23\u0104\13\23\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\5\25\u0112\n\25\3\26\3\26\3\26\5\26\u0117\n\26\3\27\3\27\3\27\3"+
		"\27\5\27\u011d\n\27\3\30\3\30\3\30\3\30\7\30\u0123\n\30\f\30\16\30\u0126"+
		"\13\30\3\30\5\30\u0129\n\30\3\30\3\30\3\30\7\30\u012e\n\30\f\30\16\30"+
		"\u0131\13\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\5\31\u013a\n\31\3\31\3"+
		"\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\7"+
		"\31\u014b\n\31\f\31\16\31\u014e\13\31\3\32\3\32\3\32\3\32\3\32\3\32\3"+
		"\32\7\32\u0157\n\32\f\32\16\32\u015a\13\32\3\32\3\32\5\32\u015e\n\32\5"+
		"\32\u0160\n\32\5\32\u0162\n\32\3\32\3\32\3\32\7\32\u0167\n\32\f\32\16"+
		"\32\u016a\13\32\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\7\34\u0174\n\34"+
		"\f\34\16\34\u0177\13\34\5\34\u0179\n\34\3\34\3\34\3\35\3\35\3\35\3\35"+
		"\5\35\u0181\n\35\3\36\3\36\3\36\3\36\3\36\5\36\u0188\n\36\3\36\3\36\5"+
		"\36\u018c\n\36\3\36\3\36\5\36\u0190\n\36\3\37\3\37\3 \3 \3 \3 \3 \3!\3"+
		"!\7!\u019b\n!\f!\16!\u019e\13!\3\"\3\"\3\"\3\"\3\"\3\"\5\"\u01a6\n\"\3"+
		"\"\3\"\3\"\3\"\3\"\5\"\u01ad\n\"\7\"\u01af\n\"\f\"\16\"\u01b2\13\"\3\""+
		"\3\"\5\"\u01b6\n\"\3\"\3\"\3\"\3\"\3\"\5\"\u01bd\n\"\5\"\u01bf\n\"\3#"+
		"\3#\3#\3#\3#\3#\3#\3#\3#\3$\3$\3$\3$\3$\3%\3%\3%\3%\7%\u01d3\n%\f%\16"+
		"%\u01d6\13%\3&\3&\3\'\3\'\5\'\u01dc\n\'\3(\3(\3(\3(\3(\3(\3(\3(\3(\3("+
		"\3(\3(\5(\u01ea\n(\3)\3)\3*\3*\5*\u01f0\n*\3*\7*\u01f3\n*\f*\16*\u01f6"+
		"\13*\3+\5+\u01f9\n+\3+\5+\u01fc\n+\3+\3+\3+\7+\u0201\n+\f+\16+\u0204\13"+
		"+\3,\3,\3-\3-\3-\7-\u020b\n-\f-\16-\u020e\13-\3-\3-\3.\3.\3.\3.\3\u00a3"+
		"/\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDF"+
		"HJLNPRTVXZ\2\5\4\23\23(*\3#&\4\25\25;;\u023f\2]\3\2\2\2\4a\3\2\2\2\6l"+
		"\3\2\2\2\bu\3\2\2\2\n\u008b\3\2\2\2\f\u008d\3\2\2\2\16\u0091\3\2\2\2\20"+
		"\u0093\3\2\2\2\22\u00a5\3\2\2\2\24\u00ad\3\2\2\2\26\u00b3\3\2\2\2\30\u00b5"+
		"\3\2\2\2\32\u00b7\3\2\2\2\34\u00d8\3\2\2\2\36\u00dd\3\2\2\2 \u00e1\3\2"+
		"\2\2\"\u00e7\3\2\2\2$\u00fb\3\2\2\2&\u0105\3\2\2\2(\u0111\3\2\2\2*\u0116"+
		"\3\2\2\2,\u011c\3\2\2\2.\u0128\3\2\2\2\60\u0139\3\2\2\2\62\u0161\3\2\2"+
		"\2\64\u016b\3\2\2\2\66\u016e\3\2\2\28\u0180\3\2\2\2:\u0182\3\2\2\2<\u0191"+
		"\3\2\2\2>\u0193\3\2\2\2@\u0198\3\2\2\2B\u01be\3\2\2\2D\u01c0\3\2\2\2F"+
		"\u01c9\3\2\2\2H\u01ce\3\2\2\2J\u01d7\3\2\2\2L\u01d9\3\2\2\2N\u01e9\3\2"+
		"\2\2P\u01eb\3\2\2\2R\u01ed\3\2\2\2T\u01f8\3\2\2\2V\u0205\3\2\2\2X\u0207"+
		"\3\2\2\2Z\u0211\3\2\2\2\\^\5\4\3\2]\\\3\2\2\2^_\3\2\2\2_]\3\2\2\2_`\3"+
		"\2\2\2`\3\3\2\2\2ab\7:\2\2bc\5H%\2cd\5\6\4\2df\5\b\5\2eg\5\16\b\2fe\3"+
		"\2\2\2fg\3\2\2\2gh\3\2\2\2hj\5\20\t\2ik\5\22\n\2ji\3\2\2\2jk\3\2\2\2k"+
		"\5\3\2\2\2lr\78\2\2mn\5H%\2no\79\2\2oq\3\2\2\2pm\3\2\2\2qt\3\2\2\2rp\3"+
		"\2\2\2rs\3\2\2\2s\7\3\2\2\2tr\3\2\2\2u{\7\66\2\2v|\5\n\6\2w|\5\f\7\2x"+
		"y\5H%\2yz\7\67\2\2z|\3\2\2\2{v\3\2\2\2{w\3\2\2\2{x\3\2\2\2|}\3\2\2\2}"+
		"{\3\2\2\2}~\3\2\2\2~\t\3\2\2\2\177\u0080\5H%\2\u0080\u0081\7=\2\2\u0081"+
		"\u0083\3\2\2\2\u0082\177\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u0084\3\2\2"+
		"\2\u0084\u008c\5\24\13\2\u0085\u0086\5H%\2\u0086\u0087\7=\2\2\u0087\u0089"+
		"\3\2\2\2\u0088\u0085\3\2\2\2\u0088\u0089\3\2\2\2\u0089\u008a\3\2\2\2\u008a"+
		"\u008c\5\32\16\2\u008b\u0082\3\2\2\2\u008b\u0088\3\2\2\2\u008c\13\3\2"+
		"\2\2\u008d\u008e\5H%\2\u008e\u008f\7\36\2\2\u008f\u0090\5J&\2\u0090\r"+
		"\3\2\2\2\u0091\u0092\7\65\2\2\u0092\17\3\2\2\2\u0093\u0094\7\64\2\2\u0094"+
		"\u0095\5N(\2\u0095\u0097\7\13\2\2\u0096\u0098\5N(\2\u0097\u0096\3\2\2"+
		"\2\u0097\u0098\3\2\2\2\u0098\u009d\3\2\2\2\u0099\u009a\7\33\2\2\u009a"+
		"\u009c\5N(\2\u009b\u0099\3\2\2\2\u009c\u009f\3\2\2\2\u009d\u009b\3\2\2"+
		"\2\u009d\u009e\3\2\2\2\u009e\u00a0\3\2\2\2\u009f\u009d\3\2\2\2\u00a0\u00a3"+
		"\7\f\2\2\u00a1\u00a2\7\63\2\2\u00a2\u00a4\5N(\2\u00a3\u00a4\3\2\2\2\u00a3"+
		"\u00a1\3\2\2\2\u00a4\21\3\2\2\2\u00a5\u00a9\7\61\2\2\u00a6\u00a7\5H%\2"+
		"\u00a7\u00a8\7\62\2\2\u00a8\u00aa\3\2\2\2\u00a9\u00a6\3\2\2\2\u00aa\u00ab"+
		"\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\23\3\2\2\2\u00ad"+
		"\u00ae\5H%\2\u00ae\u00b1\7\5\2\2\u00af\u00b2\5\26\f\2\u00b0\u00b2\5\30"+
		"\r\2\u00b1\u00af\3\2\2\2\u00b1\u00b0\3\2\2\2\u00b2\25\3\2\2\2\u00b3\u00b4"+
		"\5\"\22\2\u00b4\27\3\2\2\2\u00b5\u00b6\5$\23\2\u00b6\31\3\2\2\2\u00b7"+
		"\u00bc\5L\'\2\u00b8\u00b9\7\33\2\2\u00b9\u00bb\5L\'\2\u00ba\u00b8\3\2"+
		"\2\2\u00bb\u00be\3\2\2\2\u00bc\u00ba\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd"+
		"\u00c0\3\2\2\2\u00be\u00bc\3\2\2\2\u00bf\u00c1\7\3\2\2\u00c0\u00bf\3\2"+
		"\2\2\u00c0\u00c1\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2\u00c9\5\34\17\2\u00c3"+
		"\u00c5\7\32\2\2\u00c4\u00c3\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5\u00c6\3"+
		"\2\2\2\u00c6\u00c8\5\34\17\2\u00c7\u00c4\3\2\2\2\u00c8\u00cb\3\2\2\2\u00c9"+
		"\u00c7\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca\33\3\2\2\2\u00cb\u00c9\3\2\2"+
		"\2\u00cc\u00d1\5L\'\2\u00cd\u00ce\7\33\2\2\u00ce\u00d0\5L\'\2\u00cf\u00cd"+
		"\3\2\2\2\u00d0\u00d3\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2"+
		"\u00d4\3\2\2\2\u00d3\u00d1\3\2\2\2\u00d4\u00d5\7\3\2\2\u00d5\u00d6\5\34"+
		"\17\2\u00d6\u00d9\3\2\2\2\u00d7\u00d9\5\36\20\2\u00d8\u00cc\3\2\2\2\u00d8"+
		"\u00d7\3\2\2\2\u00d9\35\3\2\2\2\u00da\u00db\5*\26\2\u00db\u00dc\7\3\2"+
		"\2\u00dc\u00de\3\2\2\2\u00dd\u00da\3\2\2\2\u00dd\u00de\3\2\2\2\u00de\u00df"+
		"\3\2\2\2\u00df\u00e0\5 \21\2\u00e0\37\3\2\2\2\u00e1\u00e5\5N(\2\u00e2"+
		"\u00e3\7/\2\2\u00e3\u00e6\5\"\22\2\u00e4\u00e6\5\26\f\2\u00e5\u00e2\3"+
		"\2\2\2\u00e5\u00e4\3\2\2\2\u00e5\u00e6\3\2\2\2\u00e6!\3\2\2\2\u00e7\u00f9"+
		"\5(\25\2\u00e8\u00ea\7.\2\2\u00e9\u00eb\7\16\2\2\u00ea\u00e9\3\2\2\2\u00ea"+
		"\u00eb\3\2\2\2\u00eb\u00ec\3\2\2\2\u00ec\u00f4\5\36\20\2\u00ed\u00ef\7"+
		"\32\2\2\u00ee\u00f0\3\2\2\2\u00ef\u00ee\3\2\2\2\u00ef\u00f0\3\2\2\2\u00f0"+
		"\u00f1\3\2\2\2\u00f1\u00f3\5\36\20\2\u00f2\u00ed\3\2\2\2\u00f3\u00f6\3"+
		"\2\2\2\u00f4\u00f2\3\2\2\2\u00f4\u00f5\3\2\2\2\u00f5\u00f7\3\2\2\2\u00f6"+
		"\u00f4\3\2\2\2\u00f7\u00f8\7\17\2\2\u00f8\u00fa\3\2\2\2\u00f9\u00e8\3"+
		"\2\2\2\u00f9\u00fa\3\2\2\2\u00fa#\3\2\2\2\u00fb\u0102\5&\24\2\u00fc\u00fe"+
		"\7\33\2\2\u00fd\u00fc\3\2\2\2\u00fd\u00fe\3\2\2\2\u00fe\u00ff\3\2\2\2"+
		"\u00ff\u0101\5&\24\2\u0100\u00fd\3\2\2\2\u0101\u0104\3\2\2\2\u0102\u0100"+
		"\3\2\2\2\u0102\u0103\3\2\2\2\u0103%\3\2\2\2\u0104\u0102\3\2\2\2\u0105"+
		"\u0106\5,\27\2\u0106\u0107\7\3\2\2\u0107\u0108\5\36\20\2\u0108\'\3\2\2"+
		"\2\u0109\u0112\7-\2\2\u010a\u0112\7+\2\2\u010b\u0112\7,\2\2\u010c\u0112"+
		"\5:\36\2\u010d\u0112\5> \2\u010e\u0112\5B\"\2\u010f\u0112\5D#\2\u0110"+
		"\u0112\5F$\2\u0111\u0109\3\2\2\2\u0111\u010a\3\2\2\2\u0111\u010b\3\2\2"+
		"\2\u0111\u010c\3\2\2\2\u0111\u010d\3\2\2\2\u0111\u010e\3\2\2\2\u0111\u010f"+
		"\3\2\2\2\u0111\u0110\3\2\2\2\u0112)\3\2\2\2\u0113\u0117\5L\'\2\u0114\u0117"+
		"\5,\27\2\u0115\u0117\5\66\34\2\u0116\u0113\3\2\2\2\u0116\u0114\3\2\2\2"+
		"\u0116\u0115\3\2\2\2\u0117+\3\2\2\2\u0118\u011d\5.\30\2\u0119\u011d\5"+
		"\60\31\2\u011a\u011d\5\62\32\2\u011b\u011d\5\64\33\2\u011c\u0118\3\2\2"+
		"\2\u011c\u0119\3\2\2\2\u011c\u011a\3\2\2\2\u011c\u011b\3\2\2\2\u011d-"+
		"\3\2\2\2\u011e\u011f\b\30\1\2\u011f\u0124\5L\'\2\u0120\u0121\7\36\2\2"+
		"\u0121\u0123\58\35\2\u0122\u0120\3\2\2\2\u0123\u0126\3\2\2\2\u0124\u0122"+
		"\3\2\2\2\u0124\u0125\3\2\2\2\u0125\u0129\3\2\2\2\u0126\u0124\3\2\2\2\u0127"+
		"\u0129\5Z.\2\u0128\u011e\3\2\2\2\u0128\u0127\3\2\2\2\u0129\u012f\3\2\2"+
		"\2\u012a\u012b\6\30\2\3\u012b\u012c\7\35\2\2\u012c\u012e\5.\30\2\u012d"+
		"\u012a\3\2\2\2\u012e\u0131\3\2\2\2\u012f\u012d\3\2\2\2\u012f\u0130\3\2"+
		"\2\2\u0130/\3\2\2\2\u0131\u012f\3\2\2\2\u0132\u0133\b\31\1\2\u0133\u0134"+
		"\5L\'\2\u0134\u0135\7\36\2\2\u0135\u0136\7\23\2\2\u0136\u013a\3\2\2\2"+
		"\u0137\u013a\5@!\2\u0138\u013a\7\60\2\2\u0139\u0132\3\2\2\2\u0139\u0137"+
		"\3\2\2\2\u0139\u0138\3\2\2\2\u013a\u014c\3\2\2\2\u013b\u013c\6\31\3\3"+
		"\u013c\u013d\7\30\2\2\u013d\u014b\5\60\31\2\u013e\u013f\6\31\4\3\u013f"+
		"\u0140\7\r\2\2\u0140\u014b\5\60\31\2\u0141\u0142\6\31\5\3\u0142\u0143"+
		"\7\31\2\2\u0143\u014b\5\60\31\2\u0144\u0145\6\31\6\3\u0145\u0146\7\26"+
		"\2\2\u0146\u014b\5\60\31\2\u0147\u0148\6\31\7\3\u0148\u0149\7\27\2\2\u0149"+
		"\u014b\5\60\31\2\u014a\u013b\3\2\2\2\u014a\u013e\3\2\2\2\u014a\u0141\3"+
		"\2\2\2\u014a\u0144\3\2\2\2\u014a\u0147\3\2\2\2\u014b\u014e\3\2\2\2\u014c"+
		"\u014a\3\2\2\2\u014c\u014d\3\2\2\2\u014d\61\3\2\2\2\u014e\u014c\3\2\2"+
		"\2\u014f\u0150\b\32\1\2\u0150\u0162\5X-\2\u0151\u0162\5@!\2\u0152\u0162"+
		"\7\60\2\2\u0153\u015f\5L\'\2\u0154\u015d\7\36\2\2\u0155\u0157\58\35\2"+
		"\u0156\u0155\3\2\2\2\u0157\u015a\3\2\2\2\u0158\u0156\3\2\2\2\u0158\u0159"+
		"\3\2\2\2\u0159\u015e\3\2\2\2\u015a\u0158\3\2\2\2\u015b\u015e\7\23\2\2"+
		"\u015c\u015e\7\34\2\2\u015d\u0158\3\2\2\2\u015d\u015b\3\2\2\2\u015d\u015c"+
		"\3\2\2\2\u015e\u0160\3\2\2\2\u015f\u0154\3\2\2\2\u015f\u0160\3\2\2\2\u0160"+
		"\u0162\3\2\2\2\u0161\u014f\3\2\2\2\u0161\u0151\3\2\2\2\u0161\u0152\3\2"+
		"\2\2\u0161\u0153\3\2\2\2\u0162\u0168\3\2\2\2\u0163\u0164\6\32\b\3\u0164"+
		"\u0165\7\6\2\2\u0165\u0167\5\62\32\2\u0166\u0163\3\2\2\2\u0167\u016a\3"+
		"\2\2\2\u0168\u0166\3\2\2\2\u0168\u0169\3\2\2\2\u0169\63\3\2\2\2\u016a"+
		"\u0168\3\2\2\2\u016b\u016c\7\t\2\2\u016c\u016d\7\n\2\2\u016d\65\3\2\2"+
		"\2\u016e\u016f\5P)\2\u016f\u0178\7\13\2\2\u0170\u0175\5\36\20\2\u0171"+
		"\u0172\7\33\2\2\u0172\u0174\5\36\20\2\u0173\u0171\3\2\2\2\u0174\u0177"+
		"\3\2\2\2\u0175\u0173\3\2\2\2\u0175\u0176\3\2\2\2\u0176\u0179\3\2\2\2\u0177"+
		"\u0175\3\2\2\2\u0178\u0170\3\2\2\2\u0178\u0179\3\2\2\2\u0179\u017a\3\2"+
		"\2\2\u017a\u017b\7\f\2\2\u017b\67\3\2\2\2\u017c\u017d\7\22\2\2\u017d\u0181"+
		"\t\2\2\2\u017e\u0181\5V,\2\u017f\u0181\5L\'\2\u0180\u017c\3\2\2\2\u0180"+
		"\u017e\3\2\2\2\u0180\u017f\3\2\2\2\u01819\3\2\2\2\u0182\u018f\7\'\2\2"+
		"\u0183\u0184\7\16\2\2\u0184\u0187\5<\37\2\u0185\u0186\7\33\2\2\u0186\u0188"+
		"\5N(\2\u0187\u0185\3\2\2\2\u0187\u0188\3\2\2\2\u0188\u018b\3\2\2\2\u0189"+
		"\u018a\7\33\2\2\u018a\u018c\5N(\2\u018b\u0189\3\2\2\2\u018b\u018c\3\2"+
		"\2\2\u018c\u018d\3\2\2\2\u018d\u018e\7\17\2\2\u018e\u0190\3\2\2\2\u018f"+
		"\u0183\3\2\2\2\u018f\u0190\3\2\2\2\u0190;\3\2\2\2\u0191\u0192\t\3\2\2"+
		"\u0192=\3\2\2\2\u0193\u0194\7\"\2\2\u0194\u0195\7\16\2\2\u0195\u0196\5"+
		"N(\2\u0196\u0197\7\17\2\2\u0197?\3\2\2\2\u0198\u019c\7;\2\2\u0199\u019b"+
		"\5V,\2\u019a\u0199\3\2\2\2\u019b\u019e\3\2\2\2\u019c\u019a\3\2\2\2\u019c"+
		"\u019d\3\2\2\2\u019dA\3\2\2\2\u019e\u019c\3\2\2\2\u019f\u01b5\7!\2\2\u01a0"+
		"\u01a1\7\16\2\2\u01a1\u01a2\5L\'\2\u01a2\u01a5\7\n\2\2\u01a3\u01a6\5N"+
		"(\2\u01a4\u01a6\5@!\2\u01a5\u01a3\3\2\2\2\u01a5\u01a4\3\2\2\2\u01a6\u01b0"+
		"\3\2\2\2\u01a7\u01a8\7\33\2\2\u01a8\u01a9\5L\'\2\u01a9\u01ac\7\n\2\2\u01aa"+
		"\u01ad\5N(\2\u01ab\u01ad\5@!\2\u01ac\u01aa\3\2\2\2\u01ac\u01ab\3\2\2\2"+
		"\u01ad\u01af\3\2\2\2\u01ae\u01a7\3\2\2\2\u01af\u01b2\3\2\2\2\u01b0\u01ae"+
		"\3\2\2\2\u01b0\u01b1\3\2\2\2\u01b1\u01b3\3\2\2\2\u01b2\u01b0\3\2\2\2\u01b3"+
		"\u01b4\7\17\2\2\u01b4\u01b6\3\2\2\2\u01b5\u01a0\3\2\2\2\u01b5\u01b6\3"+
		"\2\2\2\u01b6\u01bf\3\2\2\2\u01b7\u01bc\7!\2\2\u01b8\u01b9\7\16\2\2\u01b9"+
		"\u01ba\5@!\2\u01ba\u01bb\7\17\2\2\u01bb\u01bd\3\2\2\2\u01bc\u01b8\3\2"+
		"\2\2\u01bc\u01bd\3\2\2\2\u01bd\u01bf\3\2\2\2\u01be\u019f\3\2\2\2\u01be"+
		"\u01b7\3\2\2\2\u01bfC\3\2\2\2\u01c0\u01c1\7 \2\2\u01c1\u01c2\7\16\2\2"+
		"\u01c2\u01c3\5N(\2\u01c3\u01c4\7\33\2\2\u01c4\u01c5\5T+\2\u01c5\u01c6"+
		"\7\33\2\2\u01c6\u01c7\5R*\2\u01c7\u01c8\7\17\2\2\u01c8E\3\2\2\2\u01c9"+
		"\u01ca\7\37\2\2\u01ca\u01cb\7\16\2\2\u01cb\u01cc\5T+\2\u01cc\u01cd\7\17"+
		"\2\2\u01cdG\3\2\2\2\u01ce\u01d4\7<\2\2\u01cf\u01d3\7\7\2\2\u01d0\u01d3"+
		"\5V,\2\u01d1\u01d3\7<\2\2\u01d2\u01cf\3\2\2\2\u01d2\u01d0\3\2\2\2\u01d2"+
		"\u01d1\3\2\2\2\u01d3\u01d6\3\2\2\2\u01d4\u01d2\3\2\2\2\u01d4\u01d5\3\2"+
		"\2\2\u01d5I\3\2\2\2\u01d6\u01d4\3\2\2\2\u01d7\u01d8\5H%\2\u01d8K\3\2\2"+
		"\2\u01d9\u01db\5H%\2\u01da\u01dc\7\4\2\2\u01db\u01da\3\2\2\2\u01db\u01dc"+
		"\3\2\2\2\u01dcM\3\2\2\2\u01dd\u01ea\5P)\2\u01de\u01df\5P)\2\u01df\u01e0"+
		"\7\16\2\2\u01e0\u01e1\7\17\2\2\u01e1\u01ea\3\2\2\2\u01e2\u01e3\5P)\2\u01e3"+
		"\u01e4\7\36\2\2\u01e4\u01e5\5P)\2\u01e5\u01ea\3\2\2\2\u01e6\u01e7\5P)"+
		"\2\u01e7\u01e8\7\b\2\2\u01e8\u01ea\3\2\2\2\u01e9\u01dd\3\2\2\2\u01e9\u01de"+
		"\3\2\2\2\u01e9\u01e2\3\2\2\2\u01e9\u01e6\3\2\2\2\u01eaO\3\2\2\2\u01eb"+
		"\u01ec\5H%\2\u01ecQ\3\2\2\2\u01ed\u01f4\5H%\2\u01ee\u01f0\7\36\2\2\u01ef"+
		"\u01ee\3\2\2\2\u01ef\u01f0\3\2\2\2\u01f0\u01f1\3\2\2\2\u01f1\u01f3\5H"+
		"%\2\u01f2\u01ef\3\2\2\2\u01f3\u01f6\3\2\2\2\u01f4\u01f2\3\2\2\2\u01f4"+
		"\u01f5\3\2\2\2\u01f5S\3\2\2\2\u01f6\u01f4\3\2\2\2\u01f7\u01f9\7\36\2\2"+
		"\u01f8\u01f7\3\2\2\2\u01f8\u01f9\3\2\2\2\u01f9\u01fb\3\2\2\2\u01fa\u01fc"+
		"\7\r\2\2\u01fb\u01fa\3\2\2\2\u01fb\u01fc\3\2\2\2\u01fc\u01fd\3\2\2\2\u01fd"+
		"\u0202\5R*\2\u01fe\u01ff\7\r\2\2\u01ff\u0201\5R*\2\u0200\u01fe\3\2\2\2"+
		"\u0201\u0204\3\2\2\2\u0202\u0200\3\2\2\2\u0202\u0203\3\2\2\2\u0203U\3"+
		"\2\2\2\u0204\u0202\3\2\2\2\u0205\u0206\t\4\2\2\u0206W\3\2\2\2\u0207\u020c"+
		"\7\24\2\2\u0208\u020b\5V,\2\u0209\u020b\7<\2\2\u020a\u0208\3\2\2\2\u020a"+
		"\u0209\3\2\2\2\u020b\u020e\3\2\2\2\u020c\u020a\3\2\2\2\u020c\u020d\3\2"+
		"\2\2\u020d\u020f\3\2\2\2\u020e\u020c\3\2\2\2\u020f\u0210\7\24\2\2\u0210"+
		"Y\3\2\2\2\u0211\u0212\7\20\2\2\u0212\u0213\7\21\2\2\u0213[\3\2\2\2D_f"+
		"jr{}\u0082\u0088\u008b\u0097\u009d\u00a3\u00ab\u00b1\u00bc\u00c0\u00c4"+
		"\u00c9\u00d1\u00d8\u00dd\u00e5\u00ea\u00ef\u00f4\u00f9\u00fd\u0102\u0111"+
		"\u0116\u011c\u0124\u0128\u012f\u0139\u014a\u014c\u0158\u015d\u015f\u0161"+
		"\u0168\u0175\u0178\u0180\u0187\u018b\u018f\u019c\u01a5\u01ac\u01b0\u01b5"+
		"\u01bc\u01be\u01d2\u01d4\u01db\u01e9\u01ef\u01f4\u01f8\u01fb\u0202\u020a"+
		"\u020c";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}