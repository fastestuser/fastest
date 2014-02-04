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
		T__57=1, T__56=2, T__55=3, T__54=4, T__53=5, T__52=6, T__51=7, T__50=8, 
		T__49=9, T__48=10, T__47=11, T__46=12, T__45=13, T__44=14, T__43=15, T__42=16, 
		T__41=17, T__40=18, T__39=19, T__38=20, T__37=21, T__36=22, T__35=23, 
		T__34=24, T__33=25, T__32=26, T__31=27, T__30=28, T__29=29, T__28=30, 
		T__27=31, T__26=32, T__25=33, T__24=34, T__23=35, T__22=36, T__21=37, 
		T__20=38, T__19=39, T__18=40, T__17=41, T__16=42, T__15=43, T__14=44, 
		T__13=45, T__12=46, T__11=47, T__10=48, T__9=49, T__8=50, T__7=51, T__6=52, 
		T__5=53, T__4=54, T__3=55, T__2=56, T__1=57, T__0=58, DIGIT=59, LETTER=60, 
		NL=61, WS=62, ANYCHAR=63;
	public static final String[] tokenNames = {
		"<INVALID>", "'@EPILOGUE'", "'DLL'", "'['", "'SLL'", "'AS'", "'@LAWS'", 
		"'@PLCODE'", "'\"'", "'0'", "'@UUT'", "'.@PREAMBLE'", "')'", "'ARRAY'", 
		"'TABLE'", "'_'", "'@'", "'ELEM'", "'div'", "'RECORD'", "'.*'", "'}'", 
		"'mod'", "'.@EPILOGUE'", "']'", "'DOM'", "','", "'DCLL'", "'('", "':'", 
		"'==>'", "'CLL'", "'?'", "'LIST'", "'@RRULE'", "'@STR'", "'{'", "'FILE'", 
		"'\\\\beginJava'", "'@AUTOFILL'", "'++'", "'\\\\endJava'", "'@PREAMBLE'", 
		"'.'", "'+'", "'ENUM'", "'<>'", "'MAPPING'", "';'", "'RAN'", "'.@LAWS'", 
		"'>'", "'MODULE'", "'REF'", "'WITH'", "'/'", "'=='", "'#'", "'@CUP@'", 
		"DIGIT", "LETTER", "'\n'", "WS", "ANYCHAR"
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
		RULE_enumeration = 30, RULE_table = 31, RULE_file = 32, RULE_name = 33, 
		RULE_lawName = 34, RULE_sName = 35, RULE_iName = 36, RULE_iIdent = 37, 
		RULE_fName = 38, RULE_path = 39, RULE_string = 40, RULE_setExtension = 41, 
		RULE_number = 42, RULE_pLCode = 43, RULE_anychar = 44;
	public static final String[] ruleNames = {
		"refinementRule", "preamble", "laws", "law", "reference", "plcode", "uut", 
		"epilogue", "synonymLaw", "asSynonym", "withSynonym", "refinementLaw", 
		"refinementSentence", "refinement", "iExprRefinement", "asRefinement", 
		"withRefinement", "exprRefinement", "dataStruct", "sExprRefinement", "zExpr", 
		"zExprSet", "zExprNum", "zExprString", "zExprSeq", "funAppExpr", "dotSetOper", 
		"list", "listType", "reference2", "enumeration", "table", "file", "name", 
		"lawName", "sName", "iName", "iIdent", "fName", "path", "string", "setExtension", 
		"number", "pLCode", "anychar"
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
			setState(90); match(34);
			setState(91); name();
			setState(92); match(NL);
			setState(93); preamble();
			setState(94); match(NL);
			setState(95); laws();
			setState(99);
			_la = _input.LA(1);
			if (_la==7) {
				{
				setState(96); plcode();
				setState(97); match(NL);
				}
			}

			setState(101); uut();
			setState(105);
			_la = _input.LA(1);
			if (_la==1) {
				{
				setState(102); epilogue();
				setState(103); match(NL);
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
		public List<TerminalNode> NL() { return getTokens(FTCRLParser.NL); }
		public List<NameContext> name() {
			return getRuleContexts(NameContext.class);
		}
		public List<PLCodeContext> pLCode() {
			return getRuleContexts(PLCodeContext.class);
		}
		public NameContext name(int i) {
			return getRuleContext(NameContext.class,i);
		}
		public PLCodeContext pLCode(int i) {
			return getRuleContext(PLCodeContext.class,i);
		}
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
			setState(107); match(42);
			setState(108); match(NL);
			setState(114); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(114);
				switch (_input.LA(1)) {
				case 38:
					{
					setState(109); pLCode();
					}
					break;
				case LETTER:
					{
					setState(110); name();
					setState(111); match(11);
					setState(112); match(NL);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(116); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==38 || _la==LETTER );
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
		public List<TerminalNode> NL() { return getTokens(FTCRLParser.NL); }
		public List<NameContext> name() {
			return getRuleContexts(NameContext.class);
		}
		public NameContext name(int i) {
			return getRuleContext(NameContext.class,i);
		}
		public LawContext law(int i) {
			return getRuleContext(LawContext.class,i);
		}
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
			setState(118); match(6);
			setState(119); match(NL);
			setState(130); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(130);
				switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
				case 1:
					{
					setState(120); law();
					setState(121); match(NL);
					}
					break;

				case 2:
					{
					setState(123); reference();
					setState(124); match(NL);
					}
					break;

				case 3:
					{
					setState(126); name();
					setState(127); match(50);
					setState(128); match(NL);
					}
					break;
				}
				}
				setState(132); 
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
			setState(146);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(137);
				switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
				case 1:
					{
					setState(134); name();
					setState(135); match(29);
					}
					break;
				}
				setState(139); synonymLaw();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(143);
				switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
				case 1:
					{
					setState(140); name();
					setState(141); match(29);
					}
					break;
				}
				setState(145); refinementLaw();
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
			setState(148); name();
			setState(149); match(43);
			setState(150); lawName();
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
		public List<TerminalNode> NL() { return getTokens(FTCRLParser.NL); }
		public PLCodeContext pLCode() {
			return getRuleContext(PLCodeContext.class,0);
		}
		public TerminalNode NL(int i) {
			return getToken(FTCRLParser.NL, i);
		}
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
			setState(152); match(7);
			setState(153); match(NL);
			setState(154); pLCode();
			setState(155); match(NL);
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
		public INameContext iName(int i) {
			return getRuleContext(INameContext.class,i);
		}
		public TerminalNode NL() { return getToken(FTCRLParser.NL, 0); }
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
			setState(157); match(10);
			setState(158); iName();
			setState(159); match(28);
			setState(161);
			_la = _input.LA(1);
			if (_la==LETTER) {
				{
				setState(160); iName();
				}
			}

			setState(167);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==26) {
				{
				{
				setState(163); match(26);
				setState(164); iName();
				}
				}
				setState(169);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(170); match(12);
			setState(173);
			_la = _input.LA(1);
			if (_la==52) {
				{
				setState(171); match(52);
				setState(172); iName();
				}
			}

			setState(175); match(NL);
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
		public List<TerminalNode> NL() { return getTokens(FTCRLParser.NL); }
		public List<NameContext> name() {
			return getRuleContexts(NameContext.class);
		}
		public List<PLCodeContext> pLCode() {
			return getRuleContexts(PLCodeContext.class);
		}
		public NameContext name(int i) {
			return getRuleContext(NameContext.class,i);
		}
		public PLCodeContext pLCode(int i) {
			return getRuleContext(PLCodeContext.class,i);
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
			setState(177); match(1);
			setState(178); match(NL);
			setState(184); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(184);
				switch (_input.LA(1)) {
				case 38:
					{
					setState(179); pLCode();
					}
					break;
				case LETTER:
					{
					setState(180); name();
					setState(181); match(23);
					setState(182); match(NL);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(186); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==38 || _la==LETTER );
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
			setState(188); name();
			setState(189); match(56);
			setState(192);
			switch (_input.LA(1)) {
			case 13:
			case 14:
			case 19:
			case 33:
			case 37:
			case 45:
			case 47:
			case 53:
				{
				setState(190); asSynonym();
				}
				break;
			case 8:
			case 36:
			case 39:
			case 46:
			case DIGIT:
			case LETTER:
				{
				setState(191); withSynonym();
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
			setState(194); asRefinement();
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
			setState(196); withRefinement();
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
		public List<TerminalNode> NL() { return getTokens(FTCRLParser.NL); }
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
			setState(198); sName();
			setState(203);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==26) {
				{
				{
				setState(199); match(26);
				setState(200); sName();
				}
				}
				setState(205);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(206); match(30);
			setState(207); refinementSentence();
			setState(215);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==48) {
				{
				{
				setState(208); match(48);
				setState(210);
				_la = _input.LA(1);
				if (_la==NL) {
					{
					setState(209); match(NL);
					}
				}

				setState(212); refinementSentence();
				}
				}
				setState(217);
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
			setState(230);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(218); sName();
				setState(223);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==26) {
					{
					{
					setState(219); match(26);
					setState(220); sName();
					}
					}
					setState(225);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(226); match(30);
				setState(227); refinementSentence();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(229); refinement();
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
			setState(235);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				setState(232); sExprRefinement();
				setState(233); match(30);
				}
				break;
			}
			setState(237); iExprRefinement();
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
			setState(239); iName();
			setState(243);
			switch (_input.LA(1)) {
			case 5:
				{
				setState(240); match(5);
				setState(241); asRefinement();
				}
				break;
			case 13:
			case 14:
			case 19:
			case 33:
			case 37:
			case 45:
			case 47:
			case 53:
				{
				setState(242); asSynonym();
				}
				break;
			case 12:
			case 24:
			case 26:
			case 48:
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
		public List<RefinementContext> refinement() {
			return getRuleContexts(RefinementContext.class);
		}
		public List<TerminalNode> NL() { return getTokens(FTCRLParser.NL); }
		public DataStructContext dataStruct() {
			return getRuleContext(DataStructContext.class,0);
		}
		public RefinementContext refinement(int i) {
			return getRuleContext(RefinementContext.class,i);
		}
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
			setState(245); dataStruct();
			setState(261);
			_la = _input.LA(1);
			if (_la==54) {
				{
				setState(246); match(54);
				setState(247); match(3);
				setState(248); refinement();
				setState(256);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==48) {
					{
					{
					setState(249); match(48);
					setState(251);
					_la = _input.LA(1);
					if (_la==NL) {
						{
						setState(250); match(NL);
						}
					}

					setState(253); refinement();
					}
					}
					setState(258);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(259); match(24);
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
		public List<TerminalNode> NL() { return getTokens(FTCRLParser.NL); }
		public List<ExprRefinementContext> exprRefinement() {
			return getRuleContexts(ExprRefinementContext.class);
		}
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
			setState(263); exprRefinement();
			setState(271);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==26) {
				{
				{
				setState(264); match(26);
				setState(266);
				_la = _input.LA(1);
				if (_la==NL) {
					{
					setState(265); match(NL);
					}
				}

				setState(268); exprRefinement();
				}
				}
				setState(273);
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
			setState(274); zExpr();
			setState(275); match(30);
			setState(276); refinement();
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
		public FileContext file() {
			return getRuleContext(FileContext.class,0);
		}
		public ListContext list() {
			return getRuleContext(ListContext.class,0);
		}
		public TableContext table() {
			return getRuleContext(TableContext.class,0);
		}
		public EnumerationContext enumeration() {
			return getRuleContext(EnumerationContext.class,0);
		}
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
			setState(286);
			switch (_input.LA(1)) {
			case 13:
				enterOuterAlt(_localctx, 1);
				{
				setState(278); match(13);
				}
				break;
			case 19:
				enterOuterAlt(_localctx, 2);
				{
				setState(279); match(19);
				}
				break;
			case 47:
				enterOuterAlt(_localctx, 3);
				{
				setState(280); match(47);
				}
				break;
			case 33:
				enterOuterAlt(_localctx, 4);
				{
				setState(281); list();
				}
				break;
			case 53:
				enterOuterAlt(_localctx, 5);
				{
				setState(282); reference2();
				}
				break;
			case 45:
				enterOuterAlt(_localctx, 6);
				{
				setState(283); enumeration();
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 7);
				{
				setState(284); table();
				}
				break;
			case 37:
				enterOuterAlt(_localctx, 8);
				{
				setState(285); file();
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
			setState(294);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(288); sName();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(289); zExprSet(0);
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(290); zExprNum(0);
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(291); zExprString(0);
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(292); zExprSeq();
				}
				break;

			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(293); funAppExpr();
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
			setState(300);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(296); zExprSet(0);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(297); zExprNum(0);
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(298); zExprString(0);
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(299); zExprSeq();
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
		public List<ZExprSetContext> zExprSet() {
			return getRuleContexts(ZExprSetContext.class);
		}
		public SetExtensionContext setExtension() {
			return getRuleContext(SetExtensionContext.class,0);
		}
		public ZExprSetContext zExprSet(int i) {
			return getRuleContext(ZExprSetContext.class,i);
		}
		public SNameContext sName() {
			return getRuleContext(SNameContext.class,0);
		}
		public DotSetOperContext dotSetOper() {
			return getRuleContext(DotSetOperContext.class,0);
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
			setState(309);
			switch (_input.LA(1)) {
			case LETTER:
				{
				setState(303); sName();
				setState(306);
				switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
				case 1:
					{
					setState(304); match(43);
					setState(305); dotSetOper(0);
					}
					break;
				}
				}
				break;
			case 36:
				{
				setState(308); setExtension();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(316);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ZExprSetContext(_parentctx, _parentState, _p);
					pushNewRecursionContext(_localctx, _startState, RULE_zExprSet);
					setState(311);
					if (!(1 >= _localctx._p)) throw new FailedPredicateException(this, "1 >= $_p");
					setState(312); match(58);
					setState(313); zExprSet(2);
					}
					} 
				}
				setState(318);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
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
		public ZExprNumContext zExprNum(int i) {
			return getRuleContext(ZExprNumContext.class,i);
		}
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public List<ZExprNumContext> zExprNum() {
			return getRuleContexts(ZExprNumContext.class);
		}
		public SNameContext sName() {
			return getRuleContext(SNameContext.class,0);
		}
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
			setState(326);
			switch (_input.LA(1)) {
			case LETTER:
				{
				setState(320); sName();
				setState(321); match(43);
				setState(322); match(57);
				}
				break;
			case DIGIT:
				{
				setState(324); number();
				}
				break;
			case 39:
				{
				setState(325); match(39);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(342);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(340);
					switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
					case 1:
						{
						_localctx = new ZExprNumContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_zExprNum);
						setState(328);
						if (!(4 >= _localctx._p)) throw new FailedPredicateException(this, "4 >= $_p");
						setState(329); match(18);
						setState(330); zExprNum(5);
						}
						break;

					case 2:
						{
						_localctx = new ZExprNumContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_zExprNum);
						setState(331);
						if (!(3 >= _localctx._p)) throw new FailedPredicateException(this, "3 >= $_p");
						setState(332); match(55);
						setState(333); zExprNum(4);
						}
						break;

					case 3:
						{
						_localctx = new ZExprNumContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_zExprNum);
						setState(334);
						if (!(2 >= _localctx._p)) throw new FailedPredicateException(this, "2 >= $_p");
						setState(335); match(22);
						setState(336); zExprNum(3);
						}
						break;

					case 4:
						{
						_localctx = new ZExprNumContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_zExprNum);
						setState(337);
						if (!(1 >= _localctx._p)) throw new FailedPredicateException(this, "1 >= $_p");
						setState(338); match(44);
						setState(339); zExprNum(2);
						}
						break;
					}
					} 
				}
				setState(344);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
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
		public ZExprStringContext zExprString(int i) {
			return getRuleContext(ZExprStringContext.class,i);
		}
		public StringContext string() {
			return getRuleContext(StringContext.class,0);
		}
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public List<ZExprStringContext> zExprString() {
			return getRuleContexts(ZExprStringContext.class);
		}
		public SNameContext sName() {
			return getRuleContext(SNameContext.class,0);
		}
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
		int _startState = 46;
		enterRecursionRule(_localctx, RULE_zExprString);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(358);
			switch (_input.LA(1)) {
			case 8:
				{
				setState(346); string();
				}
				break;
			case DIGIT:
				{
				setState(347); number();
				}
				break;
			case 39:
				{
				setState(348); match(39);
				}
				break;
			case LETTER:
				{
				setState(349); sName();
				setState(356);
				switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
				case 1:
					{
					setState(350); match(43);
					setState(354);
					switch (_input.LA(1)) {
					case 16:
					case DIGIT:
					case LETTER:
						{
						setState(351); dotSetOper(0);
						}
						break;
					case 57:
						{
						setState(352); match(57);
						}
						break;
					case 35:
						{
						setState(353); match(35);
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
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(365);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ZExprStringContext(_parentctx, _parentState, _p);
					pushNewRecursionContext(_localctx, _startState, RULE_zExprString);
					setState(360);
					if (!(1 >= _localctx._p)) throw new FailedPredicateException(this, "1 >= $_p");
					setState(361); match(40);
					setState(362); zExprString(2);
					}
					} 
				}
				setState(367);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
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
			setState(368); match(46);
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
			setState(370); iIdent();
			setState(371); match(28);
			setState(380);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 8) | (1L << 36) | (1L << 39) | (1L << 46) | (1L << DIGIT) | (1L << LETTER))) != 0)) {
				{
				setState(372); refinement();
				setState(377);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==26) {
					{
					{
					setState(373); match(26);
					setState(374); refinement();
					}
					}
					setState(379);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(382); match(12);
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
		public int _p;
		public DotSetOperContext dotSetOper(int i) {
			return getRuleContext(DotSetOperContext.class,i);
		}
		public TerminalNode DIGIT() { return getToken(FTCRLParser.DIGIT, 0); }
		public SNameContext sName() {
			return getRuleContext(SNameContext.class,0);
		}
		public List<DotSetOperContext> dotSetOper() {
			return getRuleContexts(DotSetOperContext.class);
		}
		public DotSetOperContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public DotSetOperContext(ParserRuleContext parent, int invokingState, int _p) {
			super(parent, invokingState);
			this._p = _p;
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

	public final DotSetOperContext dotSetOper(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		DotSetOperContext _localctx = new DotSetOperContext(_ctx, _parentState, _p);
		DotSetOperContext _prevctx = _localctx;
		int _startState = 52;
		enterRecursionRule(_localctx, RULE_dotSetOper);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(389);
			switch (_input.LA(1)) {
			case 16:
				{
				setState(385); match(16);
				setState(386);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 17) | (1L << 25) | (1L << 49) | (1L << 57))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				break;
			case DIGIT:
				{
				setState(387); match(DIGIT);
				}
				break;
			case LETTER:
				{
				setState(388); sName();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(396);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,43,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new DotSetOperContext(_parentctx, _parentState, _p);
					pushNewRecursionContext(_localctx, _startState, RULE_dotSetOper);
					setState(391);
					if (!(1 >= _localctx._p)) throw new FailedPredicateException(this, "1 >= $_p");
					setState(392); match(43);
					setState(393); dotSetOper(2);
					}
					} 
				}
				setState(398);
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

	public static class ListContext extends ParserRuleContext {
		public INameContext iName(int i) {
			return getRuleContext(INameContext.class,i);
		}
		public ListTypeContext listType() {
			return getRuleContext(ListTypeContext.class,0);
		}
		public List<INameContext> iName() {
			return getRuleContexts(INameContext.class);
		}
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
			setState(399); match(33);
			setState(412);
			_la = _input.LA(1);
			if (_la==3) {
				{
				setState(400); match(3);
				setState(401); listType();
				setState(404);
				switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
				case 1:
					{
					setState(402); match(26);
					setState(403); iName();
					}
					break;
				}
				setState(408);
				_la = _input.LA(1);
				if (_la==26) {
					{
					setState(406); match(26);
					setState(407); iName();
					}
				}

				setState(410); match(24);
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
			setState(414);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 2) | (1L << 4) | (1L << 27) | (1L << 31))) != 0)) ) {
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
			setState(416); match(53);
			setState(417); match(3);
			setState(418); iName();
			setState(419); match(24);
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
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public INameContext iName() {
			return getRuleContext(INameContext.class,0);
		}
		public SNameContext sName() {
			return getRuleContext(SNameContext.class,0);
		}
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
		enterRule(_localctx, 60, RULE_enumeration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(421); match(45);
			setState(434);
			switch (_input.LA(1)) {
			case 3:
				{
				setState(422); match(3);
				{
				setState(423); sName();
				setState(424); match(51);
				setState(427); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					setState(427);
					switch (_input.LA(1)) {
					case LETTER:
						{
						setState(425); iName();
						}
						break;
					case DIGIT:
						{
						setState(426); number();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(429); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==DIGIT || _la==LETTER );
				}
				}
				break;
			case DIGIT:
				{
				setState(431); number();
				setState(432); match(24);
				}
				break;
			case 12:
			case 24:
			case 26:
			case 48:
			case 54:
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

	public static class TableContext extends ParserRuleContext {
		public PathContext path() {
			return getRuleContext(PathContext.class,0);
		}
		public INameContext iName() {
			return getRuleContext(INameContext.class,0);
		}
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
		enterRule(_localctx, 62, RULE_table);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(436); match(14);
			setState(437); match(3);
			setState(438); iName();
			setState(439); match(26);
			setState(440); path();
			setState(441); match(26);
			setState(442); fName();
			setState(443); match(24);
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
		enterRule(_localctx, 64, RULE_file);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(445); match(37);
			setState(446); match(3);
			setState(447); path();
			setState(448); match(24);
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
		public TerminalNode DIGIT(int i) {
			return getToken(FTCRLParser.DIGIT, i);
		}
		public TerminalNode LETTER(int i) {
			return getToken(FTCRLParser.LETTER, i);
		}
		public List<TerminalNode> DIGIT() { return getTokens(FTCRLParser.DIGIT); }
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
		enterRule(_localctx, 66, RULE_name);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(450); match(LETTER);
			setState(454);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,50,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(451);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 15) | (1L << DIGIT) | (1L << LETTER))) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
					} 
				}
				setState(456);
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
		enterRule(_localctx, 68, RULE_lawName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(457); name();
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
		enterRule(_localctx, 70, RULE_sName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(459); name();
			setState(461);
			switch ( getInterpreter().adaptivePredict(_input,51,_ctx) ) {
			case 1:
				{
				setState(460); match(32);
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
		public IIdentContext iIdent(int i) {
			return getRuleContext(IIdentContext.class,i);
		}
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
		enterRule(_localctx, 72, RULE_iName);
		try {
			setState(475);
			switch ( getInterpreter().adaptivePredict(_input,52,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(463); iIdent();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(464); iIdent();
				setState(465); match(3);
				setState(466); match(24);
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(468); iIdent();
				setState(469); match(43);
				setState(470); iIdent();
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(472); iIdent();
				setState(473); match(20);
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
		enterRule(_localctx, 74, RULE_iIdent);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(477); name();
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
		public List<NameContext> name() {
			return getRuleContexts(NameContext.class);
		}
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
		enterRule(_localctx, 76, RULE_fName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(479); name();
			setState(486);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==43 || _la==LETTER) {
				{
				{
				setState(481);
				_la = _input.LA(1);
				if (_la==43) {
					{
					setState(480); match(43);
					}
				}

				setState(483); name();
				}
				}
				setState(488);
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
		public FNameContext fName(int i) {
			return getRuleContext(FNameContext.class,i);
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
		enterRule(_localctx, 78, RULE_path);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(490);
			_la = _input.LA(1);
			if (_la==43) {
				{
				setState(489); match(43);
				}
			}

			setState(493);
			_la = _input.LA(1);
			if (_la==55) {
				{
				setState(492); match(55);
				}
			}

			setState(495); fName();
			setState(500);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==55) {
				{
				{
				setState(496); match(55);
				setState(497); fName();
				}
				}
				setState(502);
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

	public static class StringContext extends ParserRuleContext {
		public TerminalNode DIGIT(int i) {
			return getToken(FTCRLParser.DIGIT, i);
		}
		public TerminalNode LETTER(int i) {
			return getToken(FTCRLParser.LETTER, i);
		}
		public List<TerminalNode> DIGIT() { return getTokens(FTCRLParser.DIGIT); }
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
		enterRule(_localctx, 80, RULE_string);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(503); match(8);
			setState(507);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DIGIT || _la==LETTER) {
				{
				{
				setState(504);
				_la = _input.LA(1);
				if ( !(_la==DIGIT || _la==LETTER) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				}
				setState(509);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(510); match(8);
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
		enterRule(_localctx, 82, RULE_setExtension);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(512); match(36);
			setState(513); match(21);
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
		public TerminalNode DIGIT(int i) {
			return getToken(FTCRLParser.DIGIT, i);
		}
		public List<TerminalNode> DIGIT() { return getTokens(FTCRLParser.DIGIT); }
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
		enterRule(_localctx, 84, RULE_number);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(515); match(DIGIT);
			setState(519);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,59,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(516);
					_la = _input.LA(1);
					if ( !(_la==9 || _la==DIGIT) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
					} 
				}
				setState(521);
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

	public static class PLCodeContext extends ParserRuleContext {
		public AnycharContext anychar() {
			return getRuleContext(AnycharContext.class,0);
		}
		public List<TerminalNode> NL() { return getTokens(FTCRLParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(FTCRLParser.NL, i);
		}
		public PLCodeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pLCode; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FTCRLListener ) ((FTCRLListener)listener).enterPLCode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FTCRLListener ) ((FTCRLListener)listener).exitPLCode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FTCRLVisitor ) return ((FTCRLVisitor<? extends T>)visitor).visitPLCode(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PLCodeContext pLCode() throws RecognitionException {
		PLCodeContext _localctx = new PLCodeContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_pLCode);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(522); match(38);
			setState(523); match(NL);
			setState(524); anychar();
			setState(525); match(NL);
			setState(526); match(41);
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

	public static class AnycharContext extends ParserRuleContext {
		public TerminalNode DIGIT(int i) {
			return getToken(FTCRLParser.DIGIT, i);
		}
		public TerminalNode LETTER(int i) {
			return getToken(FTCRLParser.LETTER, i);
		}
		public List<TerminalNode> ANYCHAR() { return getTokens(FTCRLParser.ANYCHAR); }
		public List<TerminalNode> NL() { return getTokens(FTCRLParser.NL); }
		public List<TerminalNode> DIGIT() { return getTokens(FTCRLParser.DIGIT); }
		public TerminalNode ANYCHAR(int i) {
			return getToken(FTCRLParser.ANYCHAR, i);
		}
		public List<TerminalNode> LETTER() { return getTokens(FTCRLParser.LETTER); }
		public TerminalNode NL(int i) {
			return getToken(FTCRLParser.NL, i);
		}
		public AnycharContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_anychar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FTCRLListener ) ((FTCRLListener)listener).enterAnychar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FTCRLListener ) ((FTCRLListener)listener).exitAnychar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FTCRLVisitor ) return ((FTCRLVisitor<? extends T>)visitor).visitAnychar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnycharContext anychar() throws RecognitionException {
		AnycharContext _localctx = new AnycharContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_anychar);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(531);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,60,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(528);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 43) | (1L << 48) | (1L << 51) | (1L << 57) | (1L << DIGIT) | (1L << LETTER) | (1L << NL) | (1L << ANYCHAR))) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
					} 
				}
				setState(533);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,60,_ctx);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 21: return zExprSet_sempred((ZExprSetContext)_localctx, predIndex);

		case 22: return zExprNum_sempred((ZExprNumContext)_localctx, predIndex);

		case 23: return zExprString_sempred((ZExprStringContext)_localctx, predIndex);

		case 26: return dotSetOper_sempred((DotSetOperContext)_localctx, predIndex);
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
		case 1: return 4 >= _localctx._p;

		case 2: return 3 >= _localctx._p;

		case 3: return 2 >= _localctx._p;

		case 4: return 1 >= _localctx._p;
		}
		return true;
	}
	private boolean zExprString_sempred(ZExprStringContext _localctx, int predIndex) {
		switch (predIndex) {
		case 5: return 1 >= _localctx._p;
		}
		return true;
	}
	private boolean dotSetOper_sempred(DotSetOperContext _localctx, int predIndex) {
		switch (predIndex) {
		case 6: return 1 >= _localctx._p;
		}
		return true;
	}

	public static final String _serializedATN =
		"\2\3A\u0219\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4"+
		"\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20"+
		"\4\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27"+
		"\4\30\t\30\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36"+
		"\4\37\t\37\4 \t \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4"+
		")\t)\4*\t*\4+\t+\4,\t,\4-\t-\4.\t.\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\5\2f\n\2\3\2\3\2\3\2\3\2\5\2l\n\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\6\3u\n"+
		"\3\r\3\16\3v\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\6\4\u0085"+
		"\n\4\r\4\16\4\u0086\3\5\3\5\3\5\5\5\u008c\n\5\3\5\3\5\3\5\3\5\5\5\u0092"+
		"\n\5\3\5\5\5\u0095\n\5\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b"+
		"\3\b\5\b\u00a4\n\b\3\b\3\b\7\b\u00a8\n\b\f\b\16\b\u00ab\13\b\3\b\3\b\3"+
		"\b\5\b\u00b0\n\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\6\t\u00bb\n\t\r\t"+
		"\16\t\u00bc\3\n\3\n\3\n\3\n\5\n\u00c3\n\n\3\13\3\13\3\f\3\f\3\r\3\r\3"+
		"\r\7\r\u00cc\n\r\f\r\16\r\u00cf\13\r\3\r\3\r\3\r\3\r\5\r\u00d5\n\r\3\r"+
		"\7\r\u00d8\n\r\f\r\16\r\u00db\13\r\3\16\3\16\3\16\7\16\u00e0\n\16\f\16"+
		"\16\16\u00e3\13\16\3\16\3\16\3\16\3\16\5\16\u00e9\n\16\3\17\3\17\3\17"+
		"\5\17\u00ee\n\17\3\17\3\17\3\20\3\20\3\20\3\20\5\20\u00f6\n\20\3\21\3"+
		"\21\3\21\3\21\3\21\3\21\5\21\u00fe\n\21\3\21\7\21\u0101\n\21\f\21\16\21"+
		"\u0104\13\21\3\21\3\21\5\21\u0108\n\21\3\22\3\22\3\22\5\22\u010d\n\22"+
		"\3\22\7\22\u0110\n\22\f\22\16\22\u0113\13\22\3\23\3\23\3\23\3\23\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u0121\n\24\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\5\25\u0129\n\25\3\26\3\26\3\26\3\26\5\26\u012f\n\26\3\27\3"+
		"\27\3\27\3\27\5\27\u0135\n\27\3\27\5\27\u0138\n\27\3\27\3\27\3\27\7\27"+
		"\u013d\n\27\f\27\16\27\u0140\13\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\5\30\u0149\n\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\7\30\u0157\n\30\f\30\16\30\u015a\13\30\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\5\31\u0165\n\31\5\31\u0167\n\31\5\31\u0169\n\31\3"+
		"\31\3\31\3\31\7\31\u016e\n\31\f\31\16\31\u0171\13\31\3\32\3\32\3\33\3"+
		"\33\3\33\3\33\3\33\7\33\u017a\n\33\f\33\16\33\u017d\13\33\5\33\u017f\n"+
		"\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\5\34\u0188\n\34\3\34\3\34\3\34"+
		"\7\34\u018d\n\34\f\34\16\34\u0190\13\34\3\35\3\35\3\35\3\35\3\35\5\35"+
		"\u0197\n\35\3\35\3\35\5\35\u019b\n\35\3\35\3\35\5\35\u019f\n\35\3\36\3"+
		"\36\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3 \3 \6 \u01ae\n \r \16 \u01af"+
		"\3 \3 \3 \5 \u01b5\n \3!\3!\3!\3!\3!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3"+
		"#\3#\7#\u01c7\n#\f#\16#\u01ca\13#\3$\3$\3%\3%\5%\u01d0\n%\3&\3&\3&\3&"+
		"\3&\3&\3&\3&\3&\3&\3&\3&\5&\u01de\n&\3\'\3\'\3(\3(\5(\u01e4\n(\3(\7(\u01e7"+
		"\n(\f(\16(\u01ea\13(\3)\5)\u01ed\n)\3)\5)\u01f0\n)\3)\3)\3)\7)\u01f5\n"+
		")\f)\16)\u01f8\13)\3*\3*\7*\u01fc\n*\f*\16*\u01ff\13*\3*\3*\3+\3+\3+\3"+
		",\3,\7,\u0208\n,\f,\16,\u020b\13,\3-\3-\3-\3-\3-\3-\3.\7.\u0214\n.\f."+
		"\16.\u0217\13.\3.\2/\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60"+
		"\62\64\668:<>@BDFHJLNPRTVXZ\2\b\6\23\23\33\33\63\63;;\6\4\4\6\6\35\35"+
		"!!\4\21\21=>\3=>\4\13\13==\b--\62\62\65\65;;=?AA\u0240\2\\\3\2\2\2\4m"+
		"\3\2\2\2\6x\3\2\2\2\b\u0094\3\2\2\2\n\u0096\3\2\2\2\f\u009a\3\2\2\2\16"+
		"\u009f\3\2\2\2\20\u00b3\3\2\2\2\22\u00be\3\2\2\2\24\u00c4\3\2\2\2\26\u00c6"+
		"\3\2\2\2\30\u00c8\3\2\2\2\32\u00e8\3\2\2\2\34\u00ed\3\2\2\2\36\u00f1\3"+
		"\2\2\2 \u00f7\3\2\2\2\"\u0109\3\2\2\2$\u0114\3\2\2\2&\u0120\3\2\2\2(\u0128"+
		"\3\2\2\2*\u012e\3\2\2\2,\u0137\3\2\2\2.\u0148\3\2\2\2\60\u0168\3\2\2\2"+
		"\62\u0172\3\2\2\2\64\u0174\3\2\2\2\66\u0187\3\2\2\28\u0191\3\2\2\2:\u01a0"+
		"\3\2\2\2<\u01a2\3\2\2\2>\u01a7\3\2\2\2@\u01b6\3\2\2\2B\u01bf\3\2\2\2D"+
		"\u01c4\3\2\2\2F\u01cb\3\2\2\2H\u01cd\3\2\2\2J\u01dd\3\2\2\2L\u01df\3\2"+
		"\2\2N\u01e1\3\2\2\2P\u01ec\3\2\2\2R\u01f9\3\2\2\2T\u0202\3\2\2\2V\u0205"+
		"\3\2\2\2X\u020c\3\2\2\2Z\u0215\3\2\2\2\\]\7$\2\2]^\5D#\2^_\7?\2\2_`\5"+
		"\4\3\2`a\7?\2\2ae\5\6\4\2bc\5\f\7\2cd\7?\2\2df\3\2\2\2eb\3\2\2\2ef\3\2"+
		"\2\2fg\3\2\2\2gk\5\16\b\2hi\5\20\t\2ij\7?\2\2jl\3\2\2\2kh\3\2\2\2kl\3"+
		"\2\2\2l\3\3\2\2\2mn\7,\2\2nt\7?\2\2ou\5X-\2pq\5D#\2qr\7\r\2\2rs\7?\2\2"+
		"su\3\2\2\2to\3\2\2\2tp\3\2\2\2uv\3\2\2\2vt\3\2\2\2vw\3\2\2\2w\5\3\2\2"+
		"\2xy\7\b\2\2y\u0084\7?\2\2z{\5\b\5\2{|\7?\2\2|\u0085\3\2\2\2}~\5\n\6\2"+
		"~\177\7?\2\2\177\u0085\3\2\2\2\u0080\u0081\5D#\2\u0081\u0082\7\64\2\2"+
		"\u0082\u0083\7?\2\2\u0083\u0085\3\2\2\2\u0084z\3\2\2\2\u0084}\3\2\2\2"+
		"\u0084\u0080\3\2\2\2\u0085\u0086\3\2\2\2\u0086\u0084\3\2\2\2\u0086\u0087"+
		"\3\2\2\2\u0087\7\3\2\2\2\u0088\u0089\5D#\2\u0089\u008a\7\37\2\2\u008a"+
		"\u008c\3\2\2\2\u008b\u0088\3\2\2\2\u008b\u008c\3\2\2\2\u008c\u008d\3\2"+
		"\2\2\u008d\u0095\5\22\n\2\u008e\u008f\5D#\2\u008f\u0090\7\37\2\2\u0090"+
		"\u0092\3\2\2\2\u0091\u008e\3\2\2\2\u0091\u0092\3\2\2\2\u0092\u0093\3\2"+
		"\2\2\u0093\u0095\5\30\r\2\u0094\u008b\3\2\2\2\u0094\u0091\3\2\2\2\u0095"+
		"\t\3\2\2\2\u0096\u0097\5D#\2\u0097\u0098\7-\2\2\u0098\u0099\5F$\2\u0099"+
		"\13\3\2\2\2\u009a\u009b\7\t\2\2\u009b\u009c\7?\2\2\u009c\u009d\5X-\2\u009d"+
		"\u009e\7?\2\2\u009e\r\3\2\2\2\u009f\u00a0\7\f\2\2\u00a0\u00a1\5J&\2\u00a1"+
		"\u00a3\7\36\2\2\u00a2\u00a4\5J&\2\u00a3\u00a2\3\2\2\2\u00a3\u00a4\3\2"+
		"\2\2\u00a4\u00a9\3\2\2\2\u00a5\u00a6\7\34\2\2\u00a6\u00a8\5J&\2\u00a7"+
		"\u00a5\3\2\2\2\u00a8\u00ab\3\2\2\2\u00a9\u00a7\3\2\2\2\u00a9\u00aa\3\2"+
		"\2\2\u00aa\u00ac\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ac\u00af\7\16\2\2\u00ad"+
		"\u00ae\7\66\2\2\u00ae\u00b0\5J&\2\u00af\u00ad\3\2\2\2\u00af\u00b0\3\2"+
		"\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00b2\7?\2\2\u00b2\17\3\2\2\2\u00b3\u00b4"+
		"\7\3\2\2\u00b4\u00ba\7?\2\2\u00b5\u00bb\5X-\2\u00b6\u00b7\5D#\2\u00b7"+
		"\u00b8\7\31\2\2\u00b8\u00b9\7?\2\2\u00b9\u00bb\3\2\2\2\u00ba\u00b5\3\2"+
		"\2\2\u00ba\u00b6\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc\u00ba\3\2\2\2\u00bc"+
		"\u00bd\3\2\2\2\u00bd\21\3\2\2\2\u00be\u00bf\5D#\2\u00bf\u00c2\7:\2\2\u00c0"+
		"\u00c3\5\24\13\2\u00c1\u00c3\5\26\f\2\u00c2\u00c0\3\2\2\2\u00c2\u00c1"+
		"\3\2\2\2\u00c3\23\3\2\2\2\u00c4\u00c5\5 \21\2\u00c5\25\3\2\2\2\u00c6\u00c7"+
		"\5\"\22\2\u00c7\27\3\2\2\2\u00c8\u00cd\5H%\2\u00c9\u00ca\7\34\2\2\u00ca"+
		"\u00cc\5H%\2\u00cb\u00c9\3\2\2\2\u00cc\u00cf\3\2\2\2\u00cd\u00cb\3\2\2"+
		"\2\u00cd\u00ce\3\2\2\2\u00ce\u00d0\3\2\2\2\u00cf\u00cd\3\2\2\2\u00d0\u00d1"+
		"\7 \2\2\u00d1\u00d9\5\32\16\2\u00d2\u00d4\7\62\2\2\u00d3\u00d5\7?\2\2"+
		"\u00d4\u00d3\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6\u00d8"+
		"\5\32\16\2\u00d7\u00d2\3\2\2\2\u00d8\u00db\3\2\2\2\u00d9\u00d7\3\2\2\2"+
		"\u00d9\u00da\3\2\2\2\u00da\31\3\2\2\2\u00db\u00d9\3\2\2\2\u00dc\u00e1"+
		"\5H%\2\u00dd\u00de\7\34\2\2\u00de\u00e0\5H%\2\u00df\u00dd\3\2\2\2\u00e0"+
		"\u00e3\3\2\2\2\u00e1\u00df\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2\u00e4\3\2"+
		"\2\2\u00e3\u00e1\3\2\2\2\u00e4\u00e5\7 \2\2\u00e5\u00e6\5\32\16\2\u00e6"+
		"\u00e9\3\2\2\2\u00e7\u00e9\5\34\17\2\u00e8\u00dc\3\2\2\2\u00e8\u00e7\3"+
		"\2\2\2\u00e9\33\3\2\2\2\u00ea\u00eb\5(\25\2\u00eb\u00ec\7 \2\2\u00ec\u00ee"+
		"\3\2\2\2\u00ed\u00ea\3\2\2\2\u00ed\u00ee\3\2\2\2\u00ee\u00ef\3\2\2\2\u00ef"+
		"\u00f0\5\36\20\2\u00f0\35\3\2\2\2\u00f1\u00f5\5J&\2\u00f2\u00f3\7\7\2"+
		"\2\u00f3\u00f6\5 \21\2\u00f4\u00f6\5\24\13\2\u00f5\u00f2\3\2\2\2\u00f5"+
		"\u00f4\3\2\2\2\u00f5\u00f6\3\2\2\2\u00f6\37\3\2\2\2\u00f7\u0107\5&\24"+
		"\2\u00f8\u00f9\78\2\2\u00f9\u00fa\7\5\2\2\u00fa\u0102\5\34\17\2\u00fb"+
		"\u00fd\7\62\2\2\u00fc\u00fe\7?\2\2\u00fd\u00fc\3\2\2\2\u00fd\u00fe\3\2"+
		"\2\2\u00fe\u00ff\3\2\2\2\u00ff\u0101\5\34\17\2\u0100\u00fb\3\2\2\2\u0101"+
		"\u0104\3\2\2\2\u0102\u0100\3\2\2\2\u0102\u0103\3\2\2\2\u0103\u0105\3\2"+
		"\2\2\u0104\u0102\3\2\2\2\u0105\u0106\7\32\2\2\u0106\u0108\3\2\2\2\u0107"+
		"\u00f8\3\2\2\2\u0107\u0108\3\2\2\2\u0108!\3\2\2\2\u0109\u0111\5$\23\2"+
		"\u010a\u010c\7\34\2\2\u010b\u010d\7?\2\2\u010c\u010b\3\2\2\2\u010c\u010d"+
		"\3\2\2\2\u010d\u010e\3\2\2\2\u010e\u0110\5$\23\2\u010f\u010a\3\2\2\2\u0110"+
		"\u0113\3\2\2\2\u0111\u010f\3\2\2\2\u0111\u0112\3\2\2\2\u0112#\3\2\2\2"+
		"\u0113\u0111\3\2\2\2\u0114\u0115\5*\26\2\u0115\u0116\7 \2\2\u0116\u0117"+
		"\5\34\17\2\u0117%\3\2\2\2\u0118\u0121\7\17\2\2\u0119\u0121\7\25\2\2\u011a"+
		"\u0121\7\61\2\2\u011b\u0121\58\35\2\u011c\u0121\5<\37\2\u011d\u0121\5"+
		"> \2\u011e\u0121\5@!\2\u011f\u0121\5B\"\2\u0120\u0118\3\2\2\2\u0120\u0119"+
		"\3\2\2\2\u0120\u011a\3\2\2\2\u0120\u011b\3\2\2\2\u0120\u011c\3\2\2\2\u0120"+
		"\u011d\3\2\2\2\u0120\u011e\3\2\2\2\u0120\u011f\3\2\2\2\u0121\'\3\2\2\2"+
		"\u0122\u0129\5H%\2\u0123\u0129\5,\27\2\u0124\u0129\5.\30\2\u0125\u0129"+
		"\5\60\31\2\u0126\u0129\5\62\32\2\u0127\u0129\5\64\33\2\u0128\u0122\3\2"+
		"\2\2\u0128\u0123\3\2\2\2\u0128\u0124\3\2\2\2\u0128\u0125\3\2\2\2\u0128"+
		"\u0126\3\2\2\2\u0128\u0127\3\2\2\2\u0129)\3\2\2\2\u012a\u012f\5,\27\2"+
		"\u012b\u012f\5.\30\2\u012c\u012f\5\60\31\2\u012d\u012f\5\62\32\2\u012e"+
		"\u012a\3\2\2\2\u012e\u012b\3\2\2\2\u012e\u012c\3\2\2\2\u012e\u012d\3\2"+
		"\2\2\u012f+\3\2\2\2\u0130\u0131\b\27\1\2\u0131\u0134\5H%\2\u0132\u0133"+
		"\7-\2\2\u0133\u0135\5\66\34\2\u0134\u0132\3\2\2\2\u0134\u0135\3\2\2\2"+
		"\u0135\u0138\3\2\2\2\u0136\u0138\5T+\2\u0137\u0130\3\2\2\2\u0137\u0136"+
		"\3\2\2\2\u0138\u013e\3\2\2\2\u0139\u013a\6\27\2\3\u013a\u013b\7<\2\2\u013b"+
		"\u013d\5,\27\2\u013c\u0139\3\2\2\2\u013d\u0140\3\2\2\2\u013e\u013c\3\2"+
		"\2\2\u013e\u013f\3\2\2\2\u013f-\3\2\2\2\u0140\u013e\3\2\2\2\u0141\u0142"+
		"\b\30\1\2\u0142\u0143\5H%\2\u0143\u0144\7-\2\2\u0144\u0145\7;\2\2\u0145"+
		"\u0149\3\2\2\2\u0146\u0149\5V,\2\u0147\u0149\7)\2\2\u0148\u0141\3\2\2"+
		"\2\u0148\u0146\3\2\2\2\u0148\u0147\3\2\2\2\u0149\u0158\3\2\2\2\u014a\u014b"+
		"\6\30\3\3\u014b\u014c\7\24\2\2\u014c\u0157\5.\30\2\u014d\u014e\6\30\4"+
		"\3\u014e\u014f\79\2\2\u014f\u0157\5.\30\2\u0150\u0151\6\30\5\3\u0151\u0152"+
		"\7\30\2\2\u0152\u0157\5.\30\2\u0153\u0154\6\30\6\3\u0154\u0155\7.\2\2"+
		"\u0155\u0157\5.\30\2\u0156\u014a\3\2\2\2\u0156\u014d\3\2\2\2\u0156\u0150"+
		"\3\2\2\2\u0156\u0153\3\2\2\2\u0157\u015a\3\2\2\2\u0158\u0156\3\2\2\2\u0158"+
		"\u0159\3\2\2\2\u0159/\3\2\2\2\u015a\u0158\3\2\2\2\u015b\u015c\b\31\1\2"+
		"\u015c\u0169\5R*\2\u015d\u0169\5V,\2\u015e\u0169\7)\2\2\u015f\u0166\5"+
		"H%\2\u0160\u0164\7-\2\2\u0161\u0165\5\66\34\2\u0162\u0165\7;\2\2\u0163"+
		"\u0165\7%\2\2\u0164\u0161\3\2\2\2\u0164\u0162\3\2\2\2\u0164\u0163\3\2"+
		"\2\2\u0165\u0167\3\2\2\2\u0166\u0160\3\2\2\2\u0166\u0167\3\2\2\2\u0167"+
		"\u0169\3\2\2\2\u0168\u015b\3\2\2\2\u0168\u015d\3\2\2\2\u0168\u015e\3\2"+
		"\2\2\u0168\u015f\3\2\2\2\u0169\u016f\3\2\2\2\u016a\u016b\6\31\7\3\u016b"+
		"\u016c\7*\2\2\u016c\u016e\5\60\31\2\u016d\u016a\3\2\2\2\u016e\u0171\3"+
		"\2\2\2\u016f\u016d\3\2\2\2\u016f\u0170\3\2\2\2\u0170\61\3\2\2\2\u0171"+
		"\u016f\3\2\2\2\u0172\u0173\7\60\2\2\u0173\63\3\2\2\2\u0174\u0175\5L\'"+
		"\2\u0175\u017e\7\36\2\2\u0176\u017b\5\34\17\2\u0177\u0178\7\34\2\2\u0178"+
		"\u017a\5\34\17\2\u0179\u0177\3\2\2\2\u017a\u017d\3\2\2\2\u017b\u0179\3"+
		"\2\2\2\u017b\u017c\3\2\2\2\u017c\u017f\3\2\2\2\u017d\u017b\3\2\2\2\u017e"+
		"\u0176\3\2\2\2\u017e\u017f\3\2\2\2\u017f\u0180\3\2\2\2\u0180\u0181\7\16"+
		"\2\2\u0181\65\3\2\2\2\u0182\u0183\b\34\1\2\u0183\u0184\7\22\2\2\u0184"+
		"\u0188\t\2\2\2\u0185\u0188\7=\2\2\u0186\u0188\5H%\2\u0187\u0182\3\2\2"+
		"\2\u0187\u0185\3\2\2\2\u0187\u0186\3\2\2\2\u0188\u018e\3\2\2\2\u0189\u018a"+
		"\6\34\b\3\u018a\u018b\7-\2\2\u018b\u018d\5\66\34\2\u018c\u0189\3\2\2\2"+
		"\u018d\u0190\3\2\2\2\u018e\u018c\3\2\2\2\u018e\u018f\3\2\2\2\u018f\67"+
		"\3\2\2\2\u0190\u018e\3\2\2\2\u0191\u019e\7#\2\2\u0192\u0193\7\5\2\2\u0193"+
		"\u0196\5:\36\2\u0194\u0195\7\34\2\2\u0195\u0197\5J&\2\u0196\u0194\3\2"+
		"\2\2\u0196\u0197\3\2\2\2\u0197\u019a\3\2\2\2\u0198\u0199\7\34\2\2\u0199"+
		"\u019b\5J&\2\u019a\u0198\3\2\2\2\u019a\u019b\3\2\2\2\u019b\u019c\3\2\2"+
		"\2\u019c\u019d\7\32\2\2\u019d\u019f\3\2\2\2\u019e\u0192\3\2\2\2\u019e"+
		"\u019f\3\2\2\2\u019f9\3\2\2\2\u01a0\u01a1\t\3\2\2\u01a1;\3\2\2\2\u01a2"+
		"\u01a3\7\67\2\2\u01a3\u01a4\7\5\2\2\u01a4\u01a5\5J&\2\u01a5\u01a6\7\32"+
		"\2\2\u01a6=\3\2\2\2\u01a7\u01b4\7/\2\2\u01a8\u01a9\7\5\2\2\u01a9\u01aa"+
		"\5H%\2\u01aa\u01ad\7\65\2\2\u01ab\u01ae\5J&\2\u01ac\u01ae\5V,\2\u01ad"+
		"\u01ab\3\2\2\2\u01ad\u01ac\3\2\2\2\u01ae\u01af\3\2\2\2\u01af\u01ad\3\2"+
		"\2\2\u01af\u01b0\3\2\2\2\u01b0\u01b5\3\2\2\2\u01b1\u01b2\5V,\2\u01b2\u01b3"+
		"\7\32\2\2\u01b3\u01b5\3\2\2\2\u01b4\u01a8\3\2\2\2\u01b4\u01b1\3\2\2\2"+
		"\u01b4\u01b5\3\2\2\2\u01b5?\3\2\2\2\u01b6\u01b7\7\20\2\2\u01b7\u01b8\7"+
		"\5\2\2\u01b8\u01b9\5J&\2\u01b9\u01ba\7\34\2\2\u01ba\u01bb\5P)\2\u01bb"+
		"\u01bc\7\34\2\2\u01bc\u01bd\5N(\2\u01bd\u01be\7\32\2\2\u01beA\3\2\2\2"+
		"\u01bf\u01c0\7\'\2\2\u01c0\u01c1\7\5\2\2\u01c1\u01c2\5P)\2\u01c2\u01c3"+
		"\7\32\2\2\u01c3C\3\2\2\2\u01c4\u01c8\7>\2\2\u01c5\u01c7\t\4\2\2\u01c6"+
		"\u01c5\3\2\2\2\u01c7\u01ca\3\2\2\2\u01c8\u01c6\3\2\2\2\u01c8\u01c9\3\2"+
		"\2\2\u01c9E\3\2\2\2\u01ca\u01c8\3\2\2\2\u01cb\u01cc\5D#\2\u01ccG\3\2\2"+
		"\2\u01cd\u01cf\5D#\2\u01ce\u01d0\7\"\2\2\u01cf\u01ce\3\2\2\2\u01cf\u01d0"+
		"\3\2\2\2\u01d0I\3\2\2\2\u01d1\u01de\5L\'\2\u01d2\u01d3\5L\'\2\u01d3\u01d4"+
		"\7\5\2\2\u01d4\u01d5\7\32\2\2\u01d5\u01de\3\2\2\2\u01d6\u01d7\5L\'\2\u01d7"+
		"\u01d8\7-\2\2\u01d8\u01d9\5L\'\2\u01d9\u01de\3\2\2\2\u01da\u01db\5L\'"+
		"\2\u01db\u01dc\7\26\2\2\u01dc\u01de\3\2\2\2\u01dd\u01d1\3\2\2\2\u01dd"+
		"\u01d2\3\2\2\2\u01dd\u01d6\3\2\2\2\u01dd\u01da\3\2\2\2\u01deK\3\2\2\2"+
		"\u01df\u01e0\5D#\2\u01e0M\3\2\2\2\u01e1\u01e8\5D#\2\u01e2\u01e4\7-\2\2"+
		"\u01e3\u01e2\3\2\2\2\u01e3\u01e4\3\2\2\2\u01e4\u01e5\3\2\2\2\u01e5\u01e7"+
		"\5D#\2\u01e6\u01e3\3\2\2\2\u01e7\u01ea\3\2\2\2\u01e8\u01e6\3\2\2\2\u01e8"+
		"\u01e9\3\2\2\2\u01e9O\3\2\2\2\u01ea\u01e8\3\2\2\2\u01eb\u01ed\7-\2\2\u01ec"+
		"\u01eb\3\2\2\2\u01ec\u01ed\3\2\2\2\u01ed\u01ef\3\2\2\2\u01ee\u01f0\79"+
		"\2\2\u01ef\u01ee\3\2\2\2\u01ef\u01f0\3\2\2\2\u01f0\u01f1\3\2\2\2\u01f1"+
		"\u01f6\5N(\2\u01f2\u01f3\79\2\2\u01f3\u01f5\5N(\2\u01f4\u01f2\3\2\2\2"+
		"\u01f5\u01f8\3\2\2\2\u01f6\u01f4\3\2\2\2\u01f6\u01f7\3\2\2\2\u01f7Q\3"+
		"\2\2\2\u01f8\u01f6\3\2\2\2\u01f9\u01fd\7\n\2\2\u01fa\u01fc\t\5\2\2\u01fb"+
		"\u01fa\3\2\2\2\u01fc\u01ff\3\2\2\2\u01fd\u01fb\3\2\2\2\u01fd\u01fe\3\2"+
		"\2\2\u01fe\u0200\3\2\2\2\u01ff\u01fd\3\2\2\2\u0200\u0201\7\n\2\2\u0201"+
		"S\3\2\2\2\u0202\u0203\7&\2\2\u0203\u0204\7\27\2\2\u0204U\3\2\2\2\u0205"+
		"\u0209\7=\2\2\u0206\u0208\t\6\2\2\u0207\u0206\3\2\2\2\u0208\u020b\3\2"+
		"\2\2\u0209\u0207\3\2\2\2\u0209\u020a\3\2\2\2\u020aW\3\2\2\2\u020b\u0209"+
		"\3\2\2\2\u020c\u020d\7(\2\2\u020d\u020e\7?\2\2\u020e\u020f\5Z.\2\u020f"+
		"\u0210\7?\2\2\u0210\u0211\7+\2\2\u0211Y\3\2\2\2\u0212\u0214\t\7\2\2\u0213"+
		"\u0212\3\2\2\2\u0214\u0217\3\2\2\2\u0215\u0213\3\2\2\2\u0215\u0216\3\2"+
		"\2\2\u0216[\3\2\2\2\u0217\u0215\3\2\2\2?ektv\u0084\u0086\u008b\u0091\u0094"+
		"\u00a3\u00a9\u00af\u00ba\u00bc\u00c2\u00cd\u00d4\u00d9\u00e1\u00e8\u00ed"+
		"\u00f5\u00fd\u0102\u0107\u010c\u0111\u0120\u0128\u012e\u0134\u0137\u013e"+
		"\u0148\u0156\u0158\u0164\u0166\u0168\u016f\u017b\u017e\u0187\u018e\u0196"+
		"\u019a\u019e\u01ad\u01af\u01b4\u01c8\u01cf\u01dd\u01e3\u01e8\u01ec\u01ef"+
		"\u01f6\u01fd\u0209\u0215";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}