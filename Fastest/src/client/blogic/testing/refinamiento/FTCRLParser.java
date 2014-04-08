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
		DIGIT=57, LETTER=58, COLON=59, NL=60, WS=61;
	public static final String[] tokenNames = {
		"<INVALID>", "'==>'", "'?'", "'=='", "'++'", "'_'", "'.*'", "'<'", "'>'", 
		"'('", "')'", "'/'", "'['", "']'", "'{'", "'}'", "'@'", "'#'", "'\"'", 
		"'0'", "'+'", "'-'", "'div'", "'mod'", "';'", "','", "'STR'", "'@CUP@'", 
		"'.'", "'FILE'", "'TABLE'", "'ENUM'", "'REF'", "'SLL'", "'DLL'", "'CLL'", 
		"'DCLL'", "'LIST'", "'DOM'", "'RAN'", "'ELEM'", "'RECORD'", "'MAPPING'", 
		"'ARRAY'", "'WITH'", "'AS'", "'@AUTOFILL'", "'@EPILOGUE'", "'.@EPILOGUE'", 
		"'MODULE'", "'@UUT'", "'@PLCODE'", "LAWS", "ALAWS", "'@PREAMBLE'", "'.@PREAMBLE'", 
		"'@RRULE'", "DIGIT", "LETTER", "':'", "'\n'", "WS"
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
		public TerminalNode EOF() { return getToken(FTCRLParser.EOF, 0); }
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
			setState(95); match(EOF);
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
		enterRule(_localctx, 2, RULE_refinementRule);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97); match(RRULE);
			setState(98); name();
			setState(99); match(NL);
			setState(100); preamble();
			setState(101); laws();
			setState(105);
			_la = _input.LA(1);
			if (_la==PLCODE) {
				{
				setState(102); plcode();
				setState(103); match(NL);
				}
			}

			setState(107); uut();
			setState(111);
			_la = _input.LA(1);
			if (_la==EPILOGUE) {
				{
				setState(108); epilogue();
				setState(109); match(NL);
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
		enterRule(_localctx, 4, RULE_preamble);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113); match(PREAMBLE);
			setState(114); match(NL);
			setState(121);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LETTER) {
				{
				{
				setState(115); name();
				setState(116); match(APREAMBLE);
				setState(117); match(NL);
				}
				}
				setState(123);
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
		public TerminalNode DOT(int i) {
			return getToken(FTCRLParser.DOT, i);
		}
		public TerminalNode LAWS() { return getToken(FTCRLParser.LAWS, 0); }
		public LawContext law(int i) {
			return getRuleContext(LawContext.class,i);
		}
		public List<ReferenceContext> reference() {
			return getRuleContexts(ReferenceContext.class);
		}
		public TerminalNode NL(int i) {
			return getToken(FTCRLParser.NL, i);
		}
		public ReferenceContext reference(int i) {
			return getRuleContext(ReferenceContext.class,i);
		}
		public List<TerminalNode> NL() { return getTokens(FTCRLParser.NL); }
		public List<NameContext> name() {
			return getRuleContexts(NameContext.class);
		}
		public NameContext name(int i) {
			return getRuleContext(NameContext.class,i);
		}
		public List<TerminalNode> DOT() { return getTokens(FTCRLParser.DOT); }
		public List<TerminalNode> ALAWS() { return getTokens(FTCRLParser.ALAWS); }
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
			setState(124); match(LAWS);
			setState(125); match(NL);
			setState(137); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(137);
				switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
				case 1:
					{
					setState(126); law();
					setState(127); match(NL);
					}
					break;

				case 2:
					{
					setState(129); reference();
					setState(130); match(NL);
					}
					break;

				case 3:
					{
					setState(132); name();
					setState(133); match(DOT);
					setState(134); match(ALAWS);
					setState(135); match(NL);
					}
					break;
				}
				}
				setState(139); 
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
			setState(153);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(144);
				switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
				case 1:
					{
					setState(141); name();
					setState(142); match(COLON);
					}
					break;
				}
				setState(146); synonymLaw();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(150);
				switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
				case 1:
					{
					setState(147); name();
					setState(148); match(COLON);
					}
					break;
				}
				setState(152); refinementLaw();
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
			setState(155); name();
			setState(156); match(DOT);
			setState(157); lawName();
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
		enterRule(_localctx, 12, RULE_plcode);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159); match(PLCODE);
			setState(160); match(NL);
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
		enterRule(_localctx, 14, RULE_uut);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162); match(UUT);
			setState(163); iName();
			setState(164); match(LB);
			setState(166);
			_la = _input.LA(1);
			if (_la==LETTER) {
				{
				setState(165); iName();
				}
			}

			setState(172);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(168); match(COMMA);
				setState(169); iName();
				}
				}
				setState(174);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(175); match(RB);
			setState(178);
			_la = _input.LA(1);
			if (_la==MODULE) {
				{
				setState(176); match(MODULE);
				setState(177); iName();
				}
			}

			setState(181);
			_la = _input.LA(1);
			if (_la==NL) {
				{
				setState(180); match(NL);
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
		enterRule(_localctx, 16, RULE_epilogue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(183); match(EPILOGUE);
			setState(184); match(NL);
			setState(189); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(185); name();
				setState(186); match(AEPILOGUE);
				setState(187); match(NL);
				}
				}
				setState(191); 
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
			setState(193); name();
			setState(194); match(EQUALQAUAL);
			setState(197);
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
				setState(195); asSynonym();
				}
				break;
			case L:
			case LCB:
			case DQUOTE:
			case AUTOFILL:
			case DIGIT:
			case LETTER:
				{
				setState(196); withSynonym();
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
			setState(199); asRefinement();
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
			setState(201); withRefinement();
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
		enterRule(_localctx, 24, RULE_refinementLaw);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(203); sName();
			setState(208);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(204); match(COMMA);
				setState(205); sName();
				}
				}
				setState(210);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(211); match(1);
			setState(213);
			_la = _input.LA(1);
			if (_la==NL) {
				{
				setState(212); match(NL);
				}
			}

			setState(215); refinementSentence();
			setState(223);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEMICOLON) {
				{
				{
				setState(216); match(SEMICOLON);
				setState(218);
				_la = _input.LA(1);
				if (_la==NL) {
					{
					setState(217); match(NL);
					}
				}

				setState(220); refinementSentence();
				}
				}
				setState(225);
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
		enterRule(_localctx, 26, RULE_refinementSentence);
		int _la;
		try {
			setState(238);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(226); sName();
				setState(231);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(227); match(COMMA);
					setState(228); sName();
					}
					}
					setState(233);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(234); match(1);
				setState(235); refinementSentence();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(237); refinement();
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
			setState(243);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				{
				setState(240); sExprRefinement();
				setState(241); match(1);
				}
				break;
			}
			setState(245); iExprRefinement();
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
			setState(247); iName();
			setState(251);
			switch (_input.LA(1)) {
			case AS:
				{
				setState(248); match(AS);
				setState(249); asRefinement();
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
				setState(250); asSynonym();
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
		enterRule(_localctx, 32, RULE_asRefinement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(253); dataStruct();
			setState(272);
			_la = _input.LA(1);
			if (_la==WITH) {
				{
				setState(254); match(WITH);
				setState(255); match(LSB);
				setState(257);
				_la = _input.LA(1);
				if (_la==NL) {
					{
					setState(256); match(NL);
					}
				}

				setState(259); refinement();
				setState(267);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==SEMICOLON) {
					{
					{
					setState(260); match(SEMICOLON);
					setState(262);
					_la = _input.LA(1);
					if (_la==NL) {
						{
						setState(261); match(NL);
						}
					}

					setState(264); refinement();
					}
					}
					setState(269);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(270); match(RSB);
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
		enterRule(_localctx, 34, RULE_withRefinement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(274); exprRefinement();
			setState(282);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(275); match(COMMA);
				setState(277);
				_la = _input.LA(1);
				if (_la==NL) {
					{
					setState(276); match(NL);
					}
				}

				setState(279); exprRefinement();
				}
				}
				setState(284);
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
		enterRule(_localctx, 36, RULE_exprRefinement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(285); zExpr();
			setState(286); match(1);
			setState(287); refinement();
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
			setState(297);
			switch (_input.LA(1)) {
			case ARRAY:
				enterOuterAlt(_localctx, 1);
				{
				setState(289); match(ARRAY);
				}
				break;
			case RECORD:
				enterOuterAlt(_localctx, 2);
				{
				setState(290); match(RECORD);
				}
				break;
			case MAPPING:
				enterOuterAlt(_localctx, 3);
				{
				setState(291); match(MAPPING);
				}
				break;
			case LIST:
				enterOuterAlt(_localctx, 4);
				{
				setState(292); list();
				}
				break;
			case REF:
				enterOuterAlt(_localctx, 5);
				{
				setState(293); reference2();
				}
				break;
			case ENUM:
				enterOuterAlt(_localctx, 6);
				{
				setState(294); enumeration();
				}
				break;
			case TABLE:
				enterOuterAlt(_localctx, 7);
				{
				setState(295); table();
				}
				break;
			case FILE:
				enterOuterAlt(_localctx, 8);
				{
				setState(296); file();
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
			setState(302);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(299); sName();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(300); zExpr();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(301); funAppExpr();
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
			setState(308);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(304); zExprSet(0);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(305); zExprNum(0);
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(306); zExprString(0);
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(307); zExprSeq();
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
			setState(320);
			switch (_input.LA(1)) {
			case LETTER:
				{
				setState(311); sName();
				setState(316);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
				while ( _alt!=2 && _alt!=-1 ) {
					if ( _alt==1 ) {
						{
						{
						setState(312); match(DOT);
						setState(313); dotSetOper();
						}
						} 
					}
					setState(318);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
				}
				}
				break;
			case LCB:
				{
				setState(319); setExtension();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(327);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ZExprSetContext(_parentctx, _parentState, _p);
					pushNewRecursionContext(_localctx, _startState, RULE_zExprSet);
					setState(322);
					if (!(1 >= _localctx._p)) throw new FailedPredicateException(this, "1 >= $_p");
					setState(323); match(CUP);
					setState(324); zExprSet(2);
					}
					} 
				}
				setState(329);
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
			setState(337);
			switch (_input.LA(1)) {
			case LETTER:
				{
				setState(331); sName();
				setState(332); match(DOT);
				setState(333); match(CARD);
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
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(356);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(354);
					switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
					case 1:
						{
						_localctx = new ZExprNumContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_zExprNum);
						setState(339);
						if (!(5 >= _localctx._p)) throw new FailedPredicateException(this, "5 >= $_p");
						setState(340); match(DIV);
						setState(341); zExprNum(6);
						}
						break;

					case 2:
						{
						_localctx = new ZExprNumContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_zExprNum);
						setState(342);
						if (!(4 >= _localctx._p)) throw new FailedPredicateException(this, "4 >= $_p");
						setState(343); match(SLASH);
						setState(344); zExprNum(5);
						}
						break;

					case 3:
						{
						_localctx = new ZExprNumContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_zExprNum);
						setState(345);
						if (!(3 >= _localctx._p)) throw new FailedPredicateException(this, "3 >= $_p");
						setState(346); match(MOD);
						setState(347); zExprNum(4);
						}
						break;

					case 4:
						{
						_localctx = new ZExprNumContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_zExprNum);
						setState(348);
						if (!(2 >= _localctx._p)) throw new FailedPredicateException(this, "2 >= $_p");
						setState(349); match(PLUS);
						setState(350); zExprNum(3);
						}
						break;

					case 5:
						{
						_localctx = new ZExprNumContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_zExprNum);
						setState(351);
						if (!(1 >= _localctx._p)) throw new FailedPredicateException(this, "1 >= $_p");
						setState(352); match(MINUS);
						setState(353); zExprNum(2);
						}
						break;
					}
					} 
				}
				setState(358);
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
		int _startState = 48;
		enterRecursionRule(_localctx, RULE_zExprString);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(385);
			switch ( getInterpreter().adaptivePredict(_input,42,_ctx) ) {
			case 1:
				{
				setState(360); string();
				}
				break;

			case 2:
				{
				setState(361); number();
				}
				break;

			case 3:
				{
				setState(362); match(AUTOFILL);
				}
				break;

			case 4:
				{
				setState(363); sName();
				setState(368);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
				while ( _alt!=2 && _alt!=-1 ) {
					if ( _alt==1 ) {
						{
						{
						setState(364); match(DOT);
						setState(365); dotSetOper();
						}
						} 
					}
					setState(370);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
				}
				setState(377);
				switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
				case 1:
					{
					setState(371); match(DOT);
					setState(375);
					switch (_input.LA(1)) {
					case CARD:
						{
						setState(372); match(CARD);
						}
						break;
					case ARROBA:
						{
						setState(373); match(ARROBA);
						setState(374); match(STR);
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
				setState(379); zExprSet(0);
				setState(380); match(PLUSPLUS);
				setState(383);
				switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
				case 1:
					{
					setState(381); zExprString(0);
					}
					break;

				case 2:
					{
					setState(382); zExprSet(0);
					}
					break;
				}
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(395);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,44,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ZExprStringContext(_parentctx, _parentState, _p);
					pushNewRecursionContext(_localctx, _startState, RULE_zExprString);
					setState(387);
					if (!(1 >= _localctx._p)) throw new FailedPredicateException(this, "1 >= $_p");
					setState(388); match(PLUSPLUS);
					setState(391);
					switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
					case 1:
						{
						setState(389); zExprString(0);
						}
						break;

					case 2:
						{
						setState(390); zExprSet(0);
						}
						break;
					}
					}
					} 
				}
				setState(397);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,44,_ctx);
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
			setState(398); match(L);
			setState(399); match(R);
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
			setState(401); iIdent();
			setState(402); match(LB);
			setState(411);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << L) | (1L << LCB) | (1L << DQUOTE) | (1L << AUTOFILL) | (1L << DIGIT) | (1L << LETTER))) != 0)) {
				{
				setState(403); refinement();
				setState(408);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(404); match(COMMA);
					setState(405); refinement();
					}
					}
					setState(410);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(413); match(RB);
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
			setState(419);
			switch (_input.LA(1)) {
			case ARROBA:
				enterOuterAlt(_localctx, 1);
				{
				setState(415); match(ARROBA);
				setState(416);
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
				setState(417); digit();
				}
				break;
			case LETTER:
				enterOuterAlt(_localctx, 3);
				{
				setState(418); sName();
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
			setState(421); match(LIST);
			setState(434);
			_la = _input.LA(1);
			if (_la==LSB) {
				{
				setState(422); match(LSB);
				setState(423); listType();
				setState(426);
				switch ( getInterpreter().adaptivePredict(_input,48,_ctx) ) {
				case 1:
					{
					setState(424); match(COMMA);
					setState(425); iName();
					}
					break;
				}
				setState(430);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(428); match(COMMA);
					setState(429); iName();
					}
				}

				setState(432); match(RSB);
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
			setState(436);
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
			setState(438); match(REF);
			setState(439); match(LSB);
			setState(440); iName();
			setState(441); match(RSB);
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
			setState(443); match(DIGIT);
			setState(447);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,51,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(444); digit();
					}
					} 
				}
				setState(449);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,51,_ctx);
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
			setState(481);
			switch ( getInterpreter().adaptivePredict(_input,57,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(450); match(ENUM);
				setState(472);
				_la = _input.LA(1);
				if (_la==LSB) {
					{
					setState(451); match(LSB);
					setState(452); sName();
					setState(453); match(R);
					setState(456);
					switch (_input.LA(1)) {
					case LETTER:
						{
						setState(454); iName();
						}
						break;
					case DIGIT:
						{
						setState(455); number();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(467);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(458); match(COMMA);
						setState(459); sName();
						setState(460); match(R);
						setState(463);
						switch (_input.LA(1)) {
						case LETTER:
							{
							setState(461); iName();
							}
							break;
						case DIGIT:
							{
							setState(462); number();
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						}
						}
						setState(469);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(470); match(RSB);
					}
				}

				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(474); match(ENUM);
				setState(479);
				_la = _input.LA(1);
				if (_la==LSB) {
					{
					setState(475); match(LSB);
					setState(476); number();
					setState(477); match(RSB);
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
			setState(483); match(TABLE);
			setState(484); match(LSB);
			setState(485); iName();
			setState(486); match(COMMA);
			setState(487); path();
			setState(488); match(COMMA);
			setState(489); fName();
			setState(490); match(RSB);
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
			setState(492); match(FILE);
			setState(493); match(LSB);
			setState(494); path();
			setState(495); match(RSB);
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
			setState(497); match(LETTER);
			setState(503);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,59,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					setState(501);
					switch (_input.LA(1)) {
					case UNDERSCORE:
						{
						setState(498); match(UNDERSCORE);
						}
						break;
					case ZERO:
					case DIGIT:
						{
						setState(499); digit();
						}
						break;
					case LETTER:
						{
						setState(500); match(LETTER);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(505);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,59,_ctx);
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
			setState(506); name();
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
			setState(508); name();
			setState(510);
			switch ( getInterpreter().adaptivePredict(_input,60,_ctx) ) {
			case 1:
				{
				setState(509); match(Q);
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
			setState(524);
			switch ( getInterpreter().adaptivePredict(_input,61,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(512); iIdent();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(513); iIdent();
				setState(514); match(LSB);
				setState(515); match(RSB);
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(517); iIdent();
				setState(518); match(DOT);
				setState(519); iIdent();
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(521); iIdent();
				setState(522); match(DOTA);
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
			setState(526); name();
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
			setState(528); name();
			setState(535);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT || _la==LETTER) {
				{
				{
				setState(530);
				_la = _input.LA(1);
				if (_la==DOT) {
					{
					setState(529); match(DOT);
					}
				}

				setState(532); name();
				}
				}
				setState(537);
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
			setState(539);
			_la = _input.LA(1);
			if (_la==DOT) {
				{
				setState(538); match(DOT);
				}
			}

			setState(542);
			_la = _input.LA(1);
			if (_la==SLASH) {
				{
				setState(541); match(SLASH);
				}
			}

			setState(544); fName();
			setState(549);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SLASH) {
				{
				{
				setState(545); match(SLASH);
				setState(546); fName();
				}
				}
				setState(551);
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
			setState(552);
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
			setState(554); match(DQUOTE);
			setState(559);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ZERO) | (1L << DIGIT) | (1L << LETTER))) != 0)) {
				{
				setState(557);
				switch (_input.LA(1)) {
				case ZERO:
				case DIGIT:
					{
					setState(555); digit();
					}
					break;
				case LETTER:
					{
					setState(556); match(LETTER);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(561);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(562); match(DQUOTE);
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
		enterRule(_localctx, 88, RULE_setExtension);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(564); match(LCB);
			setState(567);
			switch (_input.LA(1)) {
			case DIGIT:
				{
				setState(565); number();
				}
				break;
			case DQUOTE:
				{
				setState(566); string();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(576);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(569); match(COMMA);
				setState(572);
				switch (_input.LA(1)) {
				case DIGIT:
					{
					setState(570); number();
					}
					break;
				case DQUOTE:
					{
					setState(571); string();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				}
				setState(578);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(579); match(RCB);
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
		"\2\3?\u0248\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4"+
		"\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20"+
		"\4\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27"+
		"\4\30\t\30\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36"+
		"\4\37\t\37\4 \t \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4"+
		")\t)\4*\t*\4+\t+\4,\t,\4-\t-\4.\t.\3\2\6\2^\n\2\r\2\16\2_\3\2\3\2\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3l\n\3\3\3\3\3\3\3\3\3\5\3r\n\3\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\7\4z\n\4\f\4\16\4}\13\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\6\5\u008c\n\5\r\5\16\5\u008d\3\6\3\6\3\6\5\6\u0093"+
		"\n\6\3\6\3\6\3\6\3\6\5\6\u0099\n\6\3\6\5\6\u009c\n\6\3\7\3\7\3\7\3\7\3"+
		"\b\3\b\3\b\3\t\3\t\3\t\3\t\5\t\u00a9\n\t\3\t\3\t\7\t\u00ad\n\t\f\t\16"+
		"\t\u00b0\13\t\3\t\3\t\3\t\5\t\u00b5\n\t\3\t\5\t\u00b8\n\t\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\6\n\u00c0\n\n\r\n\16\n\u00c1\3\13\3\13\3\13\3\13\5\13\u00c8"+
		"\n\13\3\f\3\f\3\r\3\r\3\16\3\16\3\16\7\16\u00d1\n\16\f\16\16\16\u00d4"+
		"\13\16\3\16\3\16\5\16\u00d8\n\16\3\16\3\16\3\16\5\16\u00dd\n\16\3\16\7"+
		"\16\u00e0\n\16\f\16\16\16\u00e3\13\16\3\17\3\17\3\17\7\17\u00e8\n\17\f"+
		"\17\16\17\u00eb\13\17\3\17\3\17\3\17\3\17\5\17\u00f1\n\17\3\20\3\20\3"+
		"\20\5\20\u00f6\n\20\3\20\3\20\3\21\3\21\3\21\3\21\5\21\u00fe\n\21\3\22"+
		"\3\22\3\22\3\22\5\22\u0104\n\22\3\22\3\22\3\22\5\22\u0109\n\22\3\22\7"+
		"\22\u010c\n\22\f\22\16\22\u010f\13\22\3\22\3\22\5\22\u0113\n\22\3\23\3"+
		"\23\3\23\5\23\u0118\n\23\3\23\7\23\u011b\n\23\f\23\16\23\u011e\13\23\3"+
		"\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u012c"+
		"\n\25\3\26\3\26\3\26\5\26\u0131\n\26\3\27\3\27\3\27\3\27\5\27\u0137\n"+
		"\27\3\30\3\30\3\30\3\30\7\30\u013d\n\30\f\30\16\30\u0140\13\30\3\30\5"+
		"\30\u0143\n\30\3\30\3\30\3\30\7\30\u0148\n\30\f\30\16\30\u014b\13\30\3"+
		"\31\3\31\3\31\3\31\3\31\3\31\3\31\5\31\u0154\n\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\7\31\u0165\n\31"+
		"\f\31\16\31\u0168\13\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\7\32\u0171"+
		"\n\32\f\32\16\32\u0174\13\32\3\32\3\32\3\32\3\32\5\32\u017a\n\32\5\32"+
		"\u017c\n\32\3\32\3\32\3\32\3\32\5\32\u0182\n\32\5\32\u0184\n\32\3\32\3"+
		"\32\3\32\3\32\5\32\u018a\n\32\7\32\u018c\n\32\f\32\16\32\u018f\13\32\3"+
		"\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\7\34\u0199\n\34\f\34\16\34\u019c"+
		"\13\34\5\34\u019e\n\34\3\34\3\34\3\35\3\35\3\35\3\35\5\35\u01a6\n\35\3"+
		"\36\3\36\3\36\3\36\3\36\5\36\u01ad\n\36\3\36\3\36\5\36\u01b1\n\36\3\36"+
		"\3\36\5\36\u01b5\n\36\3\37\3\37\3 \3 \3 \3 \3 \3!\3!\7!\u01c0\n!\f!\16"+
		"!\u01c3\13!\3\"\3\"\3\"\3\"\3\"\3\"\5\"\u01cb\n\"\3\"\3\"\3\"\3\"\3\""+
		"\5\"\u01d2\n\"\7\"\u01d4\n\"\f\"\16\"\u01d7\13\"\3\"\3\"\5\"\u01db\n\""+
		"\3\"\3\"\3\"\3\"\3\"\5\"\u01e2\n\"\5\"\u01e4\n\"\3#\3#\3#\3#\3#\3#\3#"+
		"\3#\3#\3$\3$\3$\3$\3$\3%\3%\3%\3%\7%\u01f8\n%\f%\16%\u01fb\13%\3&\3&\3"+
		"\'\3\'\5\'\u0201\n\'\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\5(\u020f\n(\3"+
		")\3)\3*\3*\5*\u0215\n*\3*\7*\u0218\n*\f*\16*\u021b\13*\3+\5+\u021e\n+"+
		"\3+\5+\u0221\n+\3+\3+\3+\7+\u0226\n+\f+\16+\u0229\13+\3,\3,\3-\3-\3-\7"+
		"-\u0230\n-\f-\16-\u0233\13-\3-\3-\3.\3.\3.\5.\u023a\n.\3.\3.\3.\5.\u023f"+
		"\n.\7.\u0241\n.\f.\16.\u0244\13.\3.\3.\3.\2/\2\4\6\b\n\f\16\20\22\24\26"+
		"\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\2\5\4\23\23(*\3#&"+
		"\4\25\25;;\u0278\2]\3\2\2\2\4c\3\2\2\2\6s\3\2\2\2\b~\3\2\2\2\n\u009b\3"+
		"\2\2\2\f\u009d\3\2\2\2\16\u00a1\3\2\2\2\20\u00a4\3\2\2\2\22\u00b9\3\2"+
		"\2\2\24\u00c3\3\2\2\2\26\u00c9\3\2\2\2\30\u00cb\3\2\2\2\32\u00cd\3\2\2"+
		"\2\34\u00f0\3\2\2\2\36\u00f5\3\2\2\2 \u00f9\3\2\2\2\"\u00ff\3\2\2\2$\u0114"+
		"\3\2\2\2&\u011f\3\2\2\2(\u012b\3\2\2\2*\u0130\3\2\2\2,\u0136\3\2\2\2."+
		"\u0142\3\2\2\2\60\u0153\3\2\2\2\62\u0183\3\2\2\2\64\u0190\3\2\2\2\66\u0193"+
		"\3\2\2\28\u01a5\3\2\2\2:\u01a7\3\2\2\2<\u01b6\3\2\2\2>\u01b8\3\2\2\2@"+
		"\u01bd\3\2\2\2B\u01e3\3\2\2\2D\u01e5\3\2\2\2F\u01ee\3\2\2\2H\u01f3\3\2"+
		"\2\2J\u01fc\3\2\2\2L\u01fe\3\2\2\2N\u020e\3\2\2\2P\u0210\3\2\2\2R\u0212"+
		"\3\2\2\2T\u021d\3\2\2\2V\u022a\3\2\2\2X\u022c\3\2\2\2Z\u0236\3\2\2\2\\"+
		"^\5\4\3\2]\\\3\2\2\2^_\3\2\2\2_]\3\2\2\2_`\3\2\2\2`a\3\2\2\2ab\7\1\2\2"+
		"b\3\3\2\2\2cd\7:\2\2de\5H%\2ef\7>\2\2fg\5\6\4\2gk\5\b\5\2hi\5\16\b\2i"+
		"j\7>\2\2jl\3\2\2\2kh\3\2\2\2kl\3\2\2\2lm\3\2\2\2mq\5\20\t\2no\5\22\n\2"+
		"op\7>\2\2pr\3\2\2\2qn\3\2\2\2qr\3\2\2\2r\5\3\2\2\2st\78\2\2t{\7>\2\2u"+
		"v\5H%\2vw\79\2\2wx\7>\2\2xz\3\2\2\2yu\3\2\2\2z}\3\2\2\2{y\3\2\2\2{|\3"+
		"\2\2\2|\7\3\2\2\2}{\3\2\2\2~\177\7\66\2\2\177\u008b\7>\2\2\u0080\u0081"+
		"\5\n\6\2\u0081\u0082\7>\2\2\u0082\u008c\3\2\2\2\u0083\u0084\5\f\7\2\u0084"+
		"\u0085\7>\2\2\u0085\u008c\3\2\2\2\u0086\u0087\5H%\2\u0087\u0088\7\36\2"+
		"\2\u0088\u0089\7\67\2\2\u0089\u008a\7>\2\2\u008a\u008c\3\2\2\2\u008b\u0080"+
		"\3\2\2\2\u008b\u0083\3\2\2\2\u008b\u0086\3\2\2\2\u008c\u008d\3\2\2\2\u008d"+
		"\u008b\3\2\2\2\u008d\u008e\3\2\2\2\u008e\t\3\2\2\2\u008f\u0090\5H%\2\u0090"+
		"\u0091\7=\2\2\u0091\u0093\3\2\2\2\u0092\u008f\3\2\2\2\u0092\u0093\3\2"+
		"\2\2\u0093\u0094\3\2\2\2\u0094\u009c\5\24\13\2\u0095\u0096\5H%\2\u0096"+
		"\u0097\7=\2\2\u0097\u0099\3\2\2\2\u0098\u0095\3\2\2\2\u0098\u0099\3\2"+
		"\2\2\u0099\u009a\3\2\2\2\u009a\u009c\5\32\16\2\u009b\u0092\3\2\2\2\u009b"+
		"\u0098\3\2\2\2\u009c\13\3\2\2\2\u009d\u009e\5H%\2\u009e\u009f\7\36\2\2"+
		"\u009f\u00a0\5J&\2\u00a0\r\3\2\2\2\u00a1\u00a2\7\65\2\2\u00a2\u00a3\7"+
		">\2\2\u00a3\17\3\2\2\2\u00a4\u00a5\7\64\2\2\u00a5\u00a6\5N(\2\u00a6\u00a8"+
		"\7\13\2\2\u00a7\u00a9\5N(\2\u00a8\u00a7\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9"+
		"\u00ae\3\2\2\2\u00aa\u00ab\7\33\2\2\u00ab\u00ad\5N(\2\u00ac\u00aa\3\2"+
		"\2\2\u00ad\u00b0\3\2\2\2\u00ae\u00ac\3\2\2\2\u00ae\u00af\3\2\2\2\u00af"+
		"\u00b1\3\2\2\2\u00b0\u00ae\3\2\2\2\u00b1\u00b4\7\f\2\2\u00b2\u00b3\7\63"+
		"\2\2\u00b3\u00b5\5N(\2\u00b4\u00b2\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00b7"+
		"\3\2\2\2\u00b6\u00b8\7>\2\2\u00b7\u00b6\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8"+
		"\21\3\2\2\2\u00b9\u00ba\7\61\2\2\u00ba\u00bf\7>\2\2\u00bb\u00bc\5H%\2"+
		"\u00bc\u00bd\7\62\2\2\u00bd\u00be\7>\2\2\u00be\u00c0\3\2\2\2\u00bf\u00bb"+
		"\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1\u00bf\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2"+
		"\23\3\2\2\2\u00c3\u00c4\5H%\2\u00c4\u00c7\7\5\2\2\u00c5\u00c8\5\26\f\2"+
		"\u00c6\u00c8\5\30\r\2\u00c7\u00c5\3\2\2\2\u00c7\u00c6\3\2\2\2\u00c8\25"+
		"\3\2\2\2\u00c9\u00ca\5\"\22\2\u00ca\27\3\2\2\2\u00cb\u00cc\5$\23\2\u00cc"+
		"\31\3\2\2\2\u00cd\u00d2\5L\'\2\u00ce\u00cf\7\33\2\2\u00cf\u00d1\5L\'\2"+
		"\u00d0\u00ce\3\2\2\2\u00d1\u00d4\3\2\2\2\u00d2\u00d0\3\2\2\2\u00d2\u00d3"+
		"\3\2\2\2\u00d3\u00d5\3\2\2\2\u00d4\u00d2\3\2\2\2\u00d5\u00d7\7\3\2\2\u00d6"+
		"\u00d8\7>\2\2\u00d7\u00d6\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8\u00d9\3\2"+
		"\2\2\u00d9\u00e1\5\34\17\2\u00da\u00dc\7\32\2\2\u00db\u00dd\7>\2\2\u00dc"+
		"\u00db\3\2\2\2\u00dc\u00dd\3\2\2\2\u00dd\u00de\3\2\2\2\u00de\u00e0\5\34"+
		"\17\2\u00df\u00da\3\2\2\2\u00e0\u00e3\3\2\2\2\u00e1\u00df\3\2\2\2\u00e1"+
		"\u00e2\3\2\2\2\u00e2\33\3\2\2\2\u00e3\u00e1\3\2\2\2\u00e4\u00e9\5L\'\2"+
		"\u00e5\u00e6\7\33\2\2\u00e6\u00e8\5L\'\2\u00e7\u00e5\3\2\2\2\u00e8\u00eb"+
		"\3\2\2\2\u00e9\u00e7\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea\u00ec\3\2\2\2\u00eb"+
		"\u00e9\3\2\2\2\u00ec\u00ed\7\3\2\2\u00ed\u00ee\5\34\17\2\u00ee\u00f1\3"+
		"\2\2\2\u00ef\u00f1\5\36\20\2\u00f0\u00e4\3\2\2\2\u00f0\u00ef\3\2\2\2\u00f1"+
		"\35\3\2\2\2\u00f2\u00f3\5*\26\2\u00f3\u00f4\7\3\2\2\u00f4\u00f6\3\2\2"+
		"\2\u00f5\u00f2\3\2\2\2\u00f5\u00f6\3\2\2\2\u00f6\u00f7\3\2\2\2\u00f7\u00f8"+
		"\5 \21\2\u00f8\37\3\2\2\2\u00f9\u00fd\5N(\2\u00fa\u00fb\7/\2\2\u00fb\u00fe"+
		"\5\"\22\2\u00fc\u00fe\5\26\f\2\u00fd\u00fa\3\2\2\2\u00fd\u00fc\3\2\2\2"+
		"\u00fd\u00fe\3\2\2\2\u00fe!\3\2\2\2\u00ff\u0112\5(\25\2\u0100\u0101\7"+
		".\2\2\u0101\u0103\7\16\2\2\u0102\u0104\7>\2\2\u0103\u0102\3\2\2\2\u0103"+
		"\u0104\3\2\2\2\u0104\u0105\3\2\2\2\u0105\u010d\5\36\20\2\u0106\u0108\7"+
		"\32\2\2\u0107\u0109\7>\2\2\u0108\u0107\3\2\2\2\u0108\u0109\3\2\2\2\u0109"+
		"\u010a\3\2\2\2\u010a\u010c\5\36\20\2\u010b\u0106\3\2\2\2\u010c\u010f\3"+
		"\2\2\2\u010d\u010b\3\2\2\2\u010d\u010e\3\2\2\2\u010e\u0110\3\2\2\2\u010f"+
		"\u010d\3\2\2\2\u0110\u0111\7\17\2\2\u0111\u0113\3\2\2\2\u0112\u0100\3"+
		"\2\2\2\u0112\u0113\3\2\2\2\u0113#\3\2\2\2\u0114\u011c\5&\24\2\u0115\u0117"+
		"\7\33\2\2\u0116\u0118\7>\2\2\u0117\u0116\3\2\2\2\u0117\u0118\3\2\2\2\u0118"+
		"\u0119\3\2\2\2\u0119\u011b\5&\24\2\u011a\u0115\3\2\2\2\u011b\u011e\3\2"+
		"\2\2\u011c\u011a\3\2\2\2\u011c\u011d\3\2\2\2\u011d%\3\2\2\2\u011e\u011c"+
		"\3\2\2\2\u011f\u0120\5,\27\2\u0120\u0121\7\3\2\2\u0121\u0122\5\36\20\2"+
		"\u0122\'\3\2\2\2\u0123\u012c\7-\2\2\u0124\u012c\7+\2\2\u0125\u012c\7,"+
		"\2\2\u0126\u012c\5:\36\2\u0127\u012c\5> \2\u0128\u012c\5B\"\2\u0129\u012c"+
		"\5D#\2\u012a\u012c\5F$\2\u012b\u0123\3\2\2\2\u012b\u0124\3\2\2\2\u012b"+
		"\u0125\3\2\2\2\u012b\u0126\3\2\2\2\u012b\u0127\3\2\2\2\u012b\u0128\3\2"+
		"\2\2\u012b\u0129\3\2\2\2\u012b\u012a\3\2\2\2\u012c)\3\2\2\2\u012d\u0131"+
		"\5L\'\2\u012e\u0131\5,\27\2\u012f\u0131\5\66\34\2\u0130\u012d\3\2\2\2"+
		"\u0130\u012e\3\2\2\2\u0130\u012f\3\2\2\2\u0131+\3\2\2\2\u0132\u0137\5"+
		".\30\2\u0133\u0137\5\60\31\2\u0134\u0137\5\62\32\2\u0135\u0137\5\64\33"+
		"\2\u0136\u0132\3\2\2\2\u0136\u0133\3\2\2\2\u0136\u0134\3\2\2\2\u0136\u0135"+
		"\3\2\2\2\u0137-\3\2\2\2\u0138\u0139\b\30\1\2\u0139\u013e\5L\'\2\u013a"+
		"\u013b\7\36\2\2\u013b\u013d\58\35\2\u013c\u013a\3\2\2\2\u013d\u0140\3"+
		"\2\2\2\u013e\u013c\3\2\2\2\u013e\u013f\3\2\2\2\u013f\u0143\3\2\2\2\u0140"+
		"\u013e\3\2\2\2\u0141\u0143\5Z.\2\u0142\u0138\3\2\2\2\u0142\u0141\3\2\2"+
		"\2\u0143\u0149\3\2\2\2\u0144\u0145\6\30\2\3\u0145\u0146\7\35\2\2\u0146"+
		"\u0148\5.\30\2\u0147\u0144\3\2\2\2\u0148\u014b\3\2\2\2\u0149\u0147\3\2"+
		"\2\2\u0149\u014a\3\2\2\2\u014a/\3\2\2\2\u014b\u0149\3\2\2\2\u014c\u014d"+
		"\b\31\1\2\u014d\u014e\5L\'\2\u014e\u014f\7\36\2\2\u014f\u0150\7\23\2\2"+
		"\u0150\u0154\3\2\2\2\u0151\u0154\5@!\2\u0152\u0154\7\60\2\2\u0153\u014c"+
		"\3\2\2\2\u0153\u0151\3\2\2\2\u0153\u0152\3\2\2\2\u0154\u0166\3\2\2\2\u0155"+
		"\u0156\6\31\3\3\u0156\u0157\7\30\2\2\u0157\u0165\5\60\31\2\u0158\u0159"+
		"\6\31\4\3\u0159\u015a\7\r\2\2\u015a\u0165\5\60\31\2\u015b\u015c\6\31\5"+
		"\3\u015c\u015d\7\31\2\2\u015d\u0165\5\60\31\2\u015e\u015f\6\31\6\3\u015f"+
		"\u0160\7\26\2\2\u0160\u0165\5\60\31\2\u0161\u0162\6\31\7\3\u0162\u0163"+
		"\7\27\2\2\u0163\u0165\5\60\31\2\u0164\u0155\3\2\2\2\u0164\u0158\3\2\2"+
		"\2\u0164\u015b\3\2\2\2\u0164\u015e\3\2\2\2\u0164\u0161\3\2\2\2\u0165\u0168"+
		"\3\2\2\2\u0166\u0164\3\2\2\2\u0166\u0167\3\2\2\2\u0167\61\3\2\2\2\u0168"+
		"\u0166\3\2\2\2\u0169\u016a\b\32\1\2\u016a\u0184\5X-\2\u016b\u0184\5@!"+
		"\2\u016c\u0184\7\60\2\2\u016d\u0172\5L\'\2\u016e\u016f\7\36\2\2\u016f"+
		"\u0171\58\35\2\u0170\u016e\3\2\2\2\u0171\u0174\3\2\2\2\u0172\u0170\3\2"+
		"\2\2\u0172\u0173\3\2\2\2\u0173\u017b\3\2\2\2\u0174\u0172\3\2\2\2\u0175"+
		"\u0179\7\36\2\2\u0176\u017a\7\23\2\2\u0177\u0178\7\22\2\2\u0178\u017a"+
		"\7\34\2\2\u0179\u0176\3\2\2\2\u0179\u0177\3\2\2\2\u017a\u017c\3\2\2\2"+
		"\u017b\u0175\3\2\2\2\u017b\u017c\3\2\2\2\u017c\u0184\3\2\2\2\u017d\u017e"+
		"\5.\30\2\u017e\u0181\7\6\2\2\u017f\u0182\5\62\32\2\u0180\u0182\5.\30\2"+
		"\u0181\u017f\3\2\2\2\u0181\u0180\3\2\2\2\u0182\u0184\3\2\2\2\u0183\u0169"+
		"\3\2\2\2\u0183\u016b\3\2\2\2\u0183\u016c\3\2\2\2\u0183\u016d\3\2\2\2\u0183"+
		"\u017d\3\2\2\2\u0184\u018d\3\2\2\2\u0185\u0186\6\32\b\3\u0186\u0189\7"+
		"\6\2\2\u0187\u018a\5\62\32\2\u0188\u018a\5.\30\2\u0189\u0187\3\2\2\2\u0189"+
		"\u0188\3\2\2\2\u018a\u018c\3\2\2\2\u018b\u0185\3\2\2\2\u018c\u018f\3\2"+
		"\2\2\u018d\u018b\3\2\2\2\u018d\u018e\3\2\2\2\u018e\63\3\2\2\2\u018f\u018d"+
		"\3\2\2\2\u0190\u0191\7\t\2\2\u0191\u0192\7\n\2\2\u0192\65\3\2\2\2\u0193"+
		"\u0194\5P)\2\u0194\u019d\7\13\2\2\u0195\u019a\5\36\20\2\u0196\u0197\7"+
		"\33\2\2\u0197\u0199\5\36\20\2\u0198\u0196\3\2\2\2\u0199\u019c\3\2\2\2"+
		"\u019a\u0198\3\2\2\2\u019a\u019b\3\2\2\2\u019b\u019e\3\2\2\2\u019c\u019a"+
		"\3\2\2\2\u019d\u0195\3\2\2\2\u019d\u019e\3\2\2\2\u019e\u019f\3\2\2\2\u019f"+
		"\u01a0\7\f\2\2\u01a0\67\3\2\2\2\u01a1\u01a2\7\22\2\2\u01a2\u01a6\t\2\2"+
		"\2\u01a3\u01a6\5V,\2\u01a4\u01a6\5L\'\2\u01a5\u01a1\3\2\2\2\u01a5\u01a3"+
		"\3\2\2\2\u01a5\u01a4\3\2\2\2\u01a69\3\2\2\2\u01a7\u01b4\7\'\2\2\u01a8"+
		"\u01a9\7\16\2\2\u01a9\u01ac\5<\37\2\u01aa\u01ab\7\33\2\2\u01ab\u01ad\5"+
		"N(\2\u01ac\u01aa\3\2\2\2\u01ac\u01ad\3\2\2\2\u01ad\u01b0\3\2\2\2\u01ae"+
		"\u01af\7\33\2\2\u01af\u01b1\5N(\2\u01b0\u01ae\3\2\2\2\u01b0\u01b1\3\2"+
		"\2\2\u01b1\u01b2\3\2\2\2\u01b2\u01b3\7\17\2\2\u01b3\u01b5\3\2\2\2\u01b4"+
		"\u01a8\3\2\2\2\u01b4\u01b5\3\2\2\2\u01b5;\3\2\2\2\u01b6\u01b7\t\3\2\2"+
		"\u01b7=\3\2\2\2\u01b8\u01b9\7\"\2\2\u01b9\u01ba\7\16\2\2\u01ba\u01bb\5"+
		"N(\2\u01bb\u01bc\7\17\2\2\u01bc?\3\2\2\2\u01bd\u01c1\7;\2\2\u01be\u01c0"+
		"\5V,\2\u01bf\u01be\3\2\2\2\u01c0\u01c3\3\2\2\2\u01c1\u01bf\3\2\2\2\u01c1"+
		"\u01c2\3\2\2\2\u01c2A\3\2\2\2\u01c3\u01c1\3\2\2\2\u01c4\u01da\7!\2\2\u01c5"+
		"\u01c6\7\16\2\2\u01c6\u01c7\5L\'\2\u01c7\u01ca\7\n\2\2\u01c8\u01cb\5N"+
		"(\2\u01c9\u01cb\5@!\2\u01ca\u01c8\3\2\2\2\u01ca\u01c9\3\2\2\2\u01cb\u01d5"+
		"\3\2\2\2\u01cc\u01cd\7\33\2\2\u01cd\u01ce\5L\'\2\u01ce\u01d1\7\n\2\2\u01cf"+
		"\u01d2\5N(\2\u01d0\u01d2\5@!\2\u01d1\u01cf\3\2\2\2\u01d1\u01d0\3\2\2\2"+
		"\u01d2\u01d4\3\2\2\2\u01d3\u01cc\3\2\2\2\u01d4\u01d7\3\2\2\2\u01d5\u01d3"+
		"\3\2\2\2\u01d5\u01d6\3\2\2\2\u01d6\u01d8\3\2\2\2\u01d7\u01d5\3\2\2\2\u01d8"+
		"\u01d9\7\17\2\2\u01d9\u01db\3\2\2\2\u01da\u01c5\3\2\2\2\u01da\u01db\3"+
		"\2\2\2\u01db\u01e4\3\2\2\2\u01dc\u01e1\7!\2\2\u01dd\u01de\7\16\2\2\u01de"+
		"\u01df\5@!\2\u01df\u01e0\7\17\2\2\u01e0\u01e2\3\2\2\2\u01e1\u01dd\3\2"+
		"\2\2\u01e1\u01e2\3\2\2\2\u01e2\u01e4\3\2\2\2\u01e3\u01c4\3\2\2\2\u01e3"+
		"\u01dc\3\2\2\2\u01e4C\3\2\2\2\u01e5\u01e6\7 \2\2\u01e6\u01e7\7\16\2\2"+
		"\u01e7\u01e8\5N(\2\u01e8\u01e9\7\33\2\2\u01e9\u01ea\5T+\2\u01ea\u01eb"+
		"\7\33\2\2\u01eb\u01ec\5R*\2\u01ec\u01ed\7\17\2\2\u01edE\3\2\2\2\u01ee"+
		"\u01ef\7\37\2\2\u01ef\u01f0\7\16\2\2\u01f0\u01f1\5T+\2\u01f1\u01f2\7\17"+
		"\2\2\u01f2G\3\2\2\2\u01f3\u01f9\7<\2\2\u01f4\u01f8\7\7\2\2\u01f5\u01f8"+
		"\5V,\2\u01f6\u01f8\7<\2\2\u01f7\u01f4\3\2\2\2\u01f7\u01f5\3\2\2\2\u01f7"+
		"\u01f6\3\2\2\2\u01f8\u01fb\3\2\2\2\u01f9\u01f7\3\2\2\2\u01f9\u01fa\3\2"+
		"\2\2\u01faI\3\2\2\2\u01fb\u01f9\3\2\2\2\u01fc\u01fd\5H%\2\u01fdK\3\2\2"+
		"\2\u01fe\u0200\5H%\2\u01ff\u0201\7\4\2\2\u0200\u01ff\3\2\2\2\u0200\u0201"+
		"\3\2\2\2\u0201M\3\2\2\2\u0202\u020f\5P)\2\u0203\u0204\5P)\2\u0204\u0205"+
		"\7\16\2\2\u0205\u0206\7\17\2\2\u0206\u020f\3\2\2\2\u0207\u0208\5P)\2\u0208"+
		"\u0209\7\36\2\2\u0209\u020a\5P)\2\u020a\u020f\3\2\2\2\u020b\u020c\5P)"+
		"\2\u020c\u020d\7\b\2\2\u020d\u020f\3\2\2\2\u020e\u0202\3\2\2\2\u020e\u0203"+
		"\3\2\2\2\u020e\u0207\3\2\2\2\u020e\u020b\3\2\2\2\u020fO\3\2\2\2\u0210"+
		"\u0211\5H%\2\u0211Q\3\2\2\2\u0212\u0219\5H%\2\u0213\u0215\7\36\2\2\u0214"+
		"\u0213\3\2\2\2\u0214\u0215\3\2\2\2\u0215\u0216\3\2\2\2\u0216\u0218\5H"+
		"%\2\u0217\u0214\3\2\2\2\u0218\u021b\3\2\2\2\u0219\u0217\3\2\2\2\u0219"+
		"\u021a\3\2\2\2\u021aS\3\2\2\2\u021b\u0219\3\2\2\2\u021c\u021e\7\36\2\2"+
		"\u021d\u021c\3\2\2\2\u021d\u021e\3\2\2\2\u021e\u0220\3\2\2\2\u021f\u0221"+
		"\7\r\2\2\u0220\u021f\3\2\2\2\u0220\u0221\3\2\2\2\u0221\u0222\3\2\2\2\u0222"+
		"\u0227\5R*\2\u0223\u0224\7\r\2\2\u0224\u0226\5R*\2\u0225\u0223\3\2\2\2"+
		"\u0226\u0229\3\2\2\2\u0227\u0225\3\2\2\2\u0227\u0228\3\2\2\2\u0228U\3"+
		"\2\2\2\u0229\u0227\3\2\2\2\u022a\u022b\t\4\2\2\u022bW\3\2\2\2\u022c\u0231"+
		"\7\24\2\2\u022d\u0230\5V,\2\u022e\u0230\7<\2\2\u022f\u022d\3\2\2\2\u022f"+
		"\u022e\3\2\2\2\u0230\u0233\3\2\2\2\u0231\u022f\3\2\2\2\u0231\u0232\3\2"+
		"\2\2\u0232\u0234\3\2\2\2\u0233\u0231\3\2\2\2\u0234\u0235\7\24\2\2\u0235"+
		"Y\3\2\2\2\u0236\u0239\7\20\2\2\u0237\u023a\5@!\2\u0238\u023a\5X-\2\u0239"+
		"\u0237\3\2\2\2\u0239\u0238\3\2\2\2\u023a\u0242\3\2\2\2\u023b\u023e\7\33"+
		"\2\2\u023c\u023f\5@!\2\u023d\u023f\5X-\2\u023e\u023c\3\2\2\2\u023e\u023d"+
		"\3\2\2\2\u023f\u0241\3\2\2\2\u0240\u023b\3\2\2\2\u0241\u0244\3\2\2\2\u0242"+
		"\u0240\3\2\2\2\u0242\u0243\3\2\2\2\u0243\u0245\3\2\2\2\u0244\u0242\3\2"+
		"\2\2\u0245\u0246\7\21\2\2\u0246[\3\2\2\2J_kq{\u008b\u008d\u0092\u0098"+
		"\u009b\u00a8\u00ae\u00b4\u00b7\u00c1\u00c7\u00d2\u00d7\u00dc\u00e1\u00e9"+
		"\u00f0\u00f5\u00fd\u0103\u0108\u010d\u0112\u0117\u011c\u012b\u0130\u0136"+
		"\u013e\u0142\u0149\u0153\u0164\u0166\u0172\u0179\u017b\u0181\u0183\u0189"+
		"\u018d\u019a\u019d\u01a5\u01ac\u01b0\u01b4\u01c1\u01ca\u01d1\u01d5\u01da"+
		"\u01e1\u01e3\u01f7\u01f9\u0200\u020e\u0214\u0219\u021d\u0220\u0227\u022f"+
		"\u0231\u0239\u023e\u0242";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}