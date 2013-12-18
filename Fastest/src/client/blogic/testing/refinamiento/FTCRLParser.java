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
		T__59=1, T__58=2, T__57=3, T__56=4, T__55=5, T__54=6, T__53=7, T__52=8, 
		T__51=9, T__50=10, T__49=11, T__48=12, T__47=13, T__46=14, T__45=15, T__44=16, 
		T__43=17, T__42=18, T__41=19, T__40=20, T__39=21, T__38=22, T__37=23, 
		T__36=24, T__35=25, T__34=26, T__33=27, T__32=28, T__31=29, T__30=30, 
		T__29=31, T__28=32, T__27=33, T__26=34, T__25=35, T__24=36, T__23=37, 
		T__22=38, T__21=39, T__20=40, T__19=41, T__18=42, T__17=43, T__16=44, 
		T__15=45, T__14=46, T__13=47, T__12=48, T__11=49, T__10=50, T__9=51, T__8=52, 
		T__7=53, T__6=54, T__5=55, T__4=56, T__3=57, T__2=58, T__1=59, T__0=60, 
		DIGIT=61, LETTER=62, NL=63, WS=64, ANYCHAR=65;
	public static final String[] tokenNames = {
		"<INVALID>", "'@EPILOGUE'", "'DLL'", "'['", "'SLL'", "'AS'", "'@LAWS'", 
		"'@PLCODE'", "'REF['", "'\"'", "'0'", "'ran'", "'[]'", "'@UUT'", "'.@PREAMBLE'", 
		"'ARRAY'", "')'", "'∪'", "'_'", "'MAPVAL['", "'@'", "'ELEM'", "'.#'", 
		"'div'", "'RECORD'", "'WITH['", "'.*'", "'}'", "'.@EPILOGUE'", "']'", 
		"','", "'('", "':'", "'==>'", "'DCLL'", "'CLL'", "'?'", "'TABLE['", "'LIST'", 
		"'dom'", "'@RRULE'", "'@STR'", "'{'", "'\\\\beginJava'", "'MAPKEY['", 
		"'@AUTOFILL'", "'++'", "'\\\\endJava'", "'@PREAMBLE'", "'.'", "'ENUM'", 
		"'<>'", "';'", "'.@LAWS'", "'>'", "'MODULE'", "'.('", "'FILE['", "'=='", 
		"'/'", "'#'", "DIGIT", "LETTER", "'\n'", "WS", "ANYCHAR"
	};
	public static final int
		RULE_refinementLaw = 0, RULE_preamble = 1, RULE_plcode = 2, RULE_uut = 3, 
		RULE_epilogue = 4, RULE_laws = 5, RULE_reference = 6, RULE_lawName = 7, 
		RULE_law = 8, RULE_lawSynonym = 9, RULE_asSynonym = 10, RULE_withSynonym = 11, 
		RULE_lawRefinement = 12, RULE_refinement = 13, RULE_asRefinement = 14, 
		RULE_withRefinement = 15, RULE_exprRefinement = 16, RULE_zExpr = 17, RULE_zExprSet = 18, 
		RULE_zExprNum = 19, RULE_zExprString = 20, RULE_zExprSeq = 21, RULE_dotSetOper = 22, 
		RULE_dataStruct = 23, RULE_list = 24, RULE_map = 25, RULE_iType = 26, 
		RULE_reference2 = 27, RULE_enumeration = 28, RULE_table = 29, RULE_file = 30, 
		RULE_listType = 31, RULE_pLCode = 32, RULE_anychar = 33, RULE_name = 34, 
		RULE_sName = 35, RULE_iName = 36, RULE_iIdent = 37, RULE_fName = 38, RULE_path = 39, 
		RULE_string = 40, RULE_setExtension = 41, RULE_number = 42;
	public static final String[] ruleNames = {
		"refinementLaw", "preamble", "plcode", "uut", "epilogue", "laws", "reference", 
		"lawName", "law", "lawSynonym", "asSynonym", "withSynonym", "lawRefinement", 
		"refinement", "asRefinement", "withRefinement", "exprRefinement", "zExpr", 
		"zExprSet", "zExprNum", "zExprString", "zExprSeq", "dotSetOper", "dataStruct", 
		"list", "map", "iType", "reference2", "enumeration", "table", "file", 
		"listType", "pLCode", "anychar", "name", "sName", "iName", "iIdent", "fName", 
		"path", "string", "setExtension", "number"
	};

	@Override
	public String getGrammarFileName() { return "FTCRL.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public ATN getATN() { return _ATN; }


	//Devuelve el valor, como string, obtenido del caso de prueba
	String getValor(String var) {
		if (var.equals("u?"))
			return "345";
		else if (var.equals("name?"))
			return "name0";
		else if (var.equals("n?"))
			return "n0";
		return "";
	}

	//Devuelve el tipo, como string, obtenido del codigo java
	String getType(String var) {
		if (var.equals("u?"))
			return "int";
		else if (var.equals("name?"))
			return "char *";
		else if (var.equals("n?"))
			return "char *";
			
		return "";
	}


	public FTCRLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class RefinementLawContext extends ParserRuleContext {
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
		public TerminalNode EOF() { return getToken(FTCRLParser.EOF, 0); }
		public PlcodeContext plcode() {
			return getRuleContext(PlcodeContext.class,0);
		}
		public UutContext uut() {
			return getRuleContext(UutContext.class,0);
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
		enterRule(_localctx, 0, RULE_refinementLaw);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86); match(40);
			setState(87); name();
			setState(88); match(NL);
			setState(89); preamble();
			setState(90); match(NL);
			setState(91); laws();
			setState(95);
			_la = _input.LA(1);
			if (_la==7) {
				{
				setState(92); plcode();
				setState(93); match(NL);
				}
			}

			setState(97); uut();
			setState(101);
			_la = _input.LA(1);
			if (_la==1) {
				{
				setState(98); epilogue();
				setState(99); match(NL);
				}
			}

			setState(103); match(EOF);
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
			setState(105); match(48);
			setState(106); match(NL);
			setState(112); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(112);
				switch (_input.LA(1)) {
				case 43:
					{
					setState(107); pLCode();
					}
					break;
				case LETTER:
					{
					setState(108); name();
					setState(109); match(14);
					setState(110); match(NL);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(114); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==43 || _la==LETTER );
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
		enterRule(_localctx, 4, RULE_plcode);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116); match(7);
			setState(117); match(NL);
			setState(118); pLCode();
			setState(119); match(NL);
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
		public String code = "";;
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
		enterRule(_localctx, 6, RULE_uut);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121); match(13);
			setState(122); iName();
			setState(123); match(31);
			setState(125);
			_la = _input.LA(1);
			if (_la==LETTER) {
				{
				setState(124); iName();
				}
			}

			setState(131);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==30) {
				{
				{
				setState(127); match(30);
				setState(128); iName();
				}
				}
				setState(133);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(134); match(16);
			setState(137);
			_la = _input.LA(1);
			if (_la==55) {
				{
				setState(135); match(55);
				setState(136); iName();
				}
			}

			setState(139); match(NL);
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
		enterRule(_localctx, 8, RULE_epilogue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141); match(1);
			setState(142); match(NL);
			setState(148); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(148);
				switch (_input.LA(1)) {
				case 43:
					{
					setState(143); pLCode();
					}
					break;
				case LETTER:
					{
					setState(144); name();
					setState(145); match(28);
					setState(146); match(NL);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(150); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==43 || _la==LETTER );
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
		enterRule(_localctx, 10, RULE_laws);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(152); match(6);
			setState(153); match(NL);
			setState(164); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(164);
				switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
				case 1:
					{
					setState(154); law();
					setState(155); match(NL);
					}
					break;

				case 2:
					{
					setState(157); reference();
					setState(158); match(NL);
					}
					break;

				case 3:
					{
					setState(160); name();
					setState(161); match(53);
					setState(162); match(NL);
					}
					break;
				}
				}
				setState(166); 
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
		enterRule(_localctx, 12, RULE_reference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(168); name();
			setState(169); match(49);
			setState(170); lawName();
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
		enterRule(_localctx, 14, RULE_lawName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172); name();
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
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public LawSynonymContext lawSynonym() {
			return getRuleContext(LawSynonymContext.class,0);
		}
		public LawRefinementContext lawRefinement() {
			return getRuleContext(LawRefinementContext.class,0);
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
		enterRule(_localctx, 16, RULE_law);
		try {
			setState(186);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(177);
				switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
				case 1:
					{
					setState(174); name();
					setState(175); match(32);
					}
					break;
				}
				setState(179); lawSynonym();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(183);
				switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
				case 1:
					{
					setState(180); name();
					setState(181); match(32);
					}
					break;
				}
				setState(185); lawRefinement();
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

	public static class LawSynonymContext extends ParserRuleContext {
		public WithSynonymContext withSynonym() {
			return getRuleContext(WithSynonymContext.class,0);
		}
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public AsSynonymContext asSynonym() {
			return getRuleContext(AsSynonymContext.class,0);
		}
		public LawSynonymContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lawSynonym; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FTCRLListener ) ((FTCRLListener)listener).enterLawSynonym(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FTCRLListener ) ((FTCRLListener)listener).exitLawSynonym(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FTCRLVisitor ) return ((FTCRLVisitor<? extends T>)visitor).visitLawSynonym(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LawSynonymContext lawSynonym() throws RecognitionException {
		LawSynonymContext _localctx = new LawSynonymContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_lawSynonym);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(188); name();
			setState(189); match(58);
			setState(192);
			switch (_input.LA(1)) {
			case 8:
			case 15:
			case 19:
			case 24:
			case 37:
			case 38:
			case 44:
			case 50:
			case 57:
				{
				setState(190); asSynonym();
				}
				break;
			case 9:
			case 42:
			case 45:
			case 51:
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
		enterRule(_localctx, 20, RULE_asSynonym);
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
		enterRule(_localctx, 22, RULE_withSynonym);
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

	public static class LawRefinementContext extends ParserRuleContext {
		public List<RefinementContext> refinement() {
			return getRuleContexts(RefinementContext.class);
		}
		public List<TerminalNode> NL() { return getTokens(FTCRLParser.NL); }
		public SNameContext sName(int i) {
			return getRuleContext(SNameContext.class,i);
		}
		public List<SNameContext> sName() {
			return getRuleContexts(SNameContext.class);
		}
		public RefinementContext refinement(int i) {
			return getRuleContext(RefinementContext.class,i);
		}
		public TerminalNode NL(int i) {
			return getToken(FTCRLParser.NL, i);
		}
		public LawRefinementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lawRefinement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FTCRLListener ) ((FTCRLListener)listener).enterLawRefinement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FTCRLListener ) ((FTCRLListener)listener).exitLawRefinement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FTCRLVisitor ) return ((FTCRLVisitor<? extends T>)visitor).visitLawRefinement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LawRefinementContext lawRefinement() throws RecognitionException {
		LawRefinementContext _localctx = new LawRefinementContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_lawRefinement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(198); sName();
			setState(203);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==30) {
				{
				{
				setState(199); match(30);
				setState(200); sName();
				}
				}
				setState(205);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(206); match(33);
			setState(207); refinement();
			setState(215);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==52) {
				{
				{
				setState(208); match(52);
				setState(210);
				_la = _input.LA(1);
				if (_la==NL) {
					{
					setState(209); match(NL);
					}
				}

				setState(212); refinement();
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

	public static class RefinementContext extends ParserRuleContext {
		public String varName;
		public AsRefinementContext asRefinement() {
			return getRuleContext(AsRefinementContext.class,0);
		}
		public ExprRefinementContext exprRefinement() {
			return getRuleContext(ExprRefinementContext.class,0);
		}
		public INameContext iName() {
			return getRuleContext(INameContext.class,0);
		}
		public AsSynonymContext asSynonym() {
			return getRuleContext(AsSynonymContext.class,0);
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
			setState(225);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(218); iName();
				setState(222);
				switch (_input.LA(1)) {
				case 5:
					{
					setState(219); match(5);
					setState(220); asRefinement();
					}
					break;
				case 8:
				case 15:
				case 19:
				case 24:
				case 37:
				case 38:
				case 44:
				case 50:
				case 57:
					{
					setState(221); asSynonym();
					}
					break;
				case 29:
				case 30:
				case 52:
				case NL:
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(224); exprRefinement();
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

	public static class AsRefinementContext extends ParserRuleContext {
		public WithRefinementContext withRefinement() {
			return getRuleContext(WithRefinementContext.class,0);
		}
		public DataStructContext dataStruct() {
			return getRuleContext(DataStructContext.class,0);
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
		enterRule(_localctx, 28, RULE_asRefinement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(227); dataStruct();
			setState(232);
			_la = _input.LA(1);
			if (_la==25) {
				{
				setState(228); match(25);
				setState(229); withRefinement();
				setState(230); match(29);
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
		enterRule(_localctx, 30, RULE_withRefinement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(234); exprRefinement();
			setState(242);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==30) {
				{
				{
				setState(235); match(30);
				setState(237);
				_la = _input.LA(1);
				if (_la==NL) {
					{
					setState(236); match(NL);
					}
				}

				setState(239); exprRefinement();
				}
				}
				setState(244);
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
		enterRule(_localctx, 32, RULE_exprRefinement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(245); zExpr();
			setState(246); match(33);
			setState(247); refinement();
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
		enterRule(_localctx, 34, RULE_zExpr);
		try {
			setState(253);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(249); zExprSet(0);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(250); zExprNum(0);
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(251); zExprString(0);
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(252); zExprSeq();
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
		int _startState = 36;
		enterRecursionRule(_localctx, RULE_zExprSet);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(262);
			switch (_input.LA(1)) {
			case LETTER:
				{
				setState(256); sName();
				setState(259);
				switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
				case 1:
					{
					setState(257); match(49);
					setState(258); dotSetOper(0);
					}
					break;
				}
				}
				break;
			case 42:
				{
				setState(261); setExtension();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(269);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ZExprSetContext(_parentctx, _parentState, _p);
					pushNewRecursionContext(_localctx, _startState, RULE_zExprSet);
					setState(264);
					if (!(1 >= _localctx._p)) throw new FailedPredicateException(this, "1 >= $_p");
					setState(265); match(17);
					setState(266); zExprSet(2);
					}
					} 
				}
				setState(271);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
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
		int _startState = 38;
		enterRecursionRule(_localctx, RULE_zExprNum);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(279);
			switch (_input.LA(1)) {
			case LETTER:
				{
				setState(273); sName();
				setState(275);
				switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
				case 1:
					{
					setState(274); match(22);
					}
					break;
				}
				}
				break;
			case DIGIT:
				{
				setState(277); number();
				}
				break;
			case 45:
				{
				setState(278); match(45);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(286);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ZExprNumContext(_parentctx, _parentState, _p);
					pushNewRecursionContext(_localctx, _startState, RULE_zExprNum);
					setState(281);
					if (!(1 >= _localctx._p)) throw new FailedPredicateException(this, "1 >= $_p");
					setState(282); match(23);
					setState(283); zExprNum(2);
					}
					} 
				}
				setState(288);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
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
		int _startState = 40;
		enterRecursionRule(_localctx, RULE_zExprString);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(303);
			switch (_input.LA(1)) {
			case 9:
				{
				setState(290); string();
				}
				break;
			case DIGIT:
				{
				setState(291); number();
				}
				break;
			case 45:
				{
				setState(292); match(45);
				}
				break;
			case LETTER:
				{
				setState(293); sName();
				setState(301);
				switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
				case 1:
					{
					setState(294); match(56);
					setState(298);
					switch (_input.LA(1)) {
					case 20:
					case DIGIT:
					case LETTER:
						{
						setState(295); dotSetOper(0);
						}
						break;
					case 60:
						{
						setState(296); match(60);
						}
						break;
					case 41:
						{
						setState(297); match(41);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(300); match(16);
					}
					break;
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(310);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ZExprStringContext(_parentctx, _parentState, _p);
					pushNewRecursionContext(_localctx, _startState, RULE_zExprString);
					setState(305);
					if (!(1 >= _localctx._p)) throw new FailedPredicateException(this, "1 >= $_p");
					setState(306); match(46);
					setState(307); zExprString(2);
					}
					} 
				}
				setState(312);
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
		enterRule(_localctx, 42, RULE_zExprSeq);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(313); match(51);
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
		int _startState = 44;
		enterRecursionRule(_localctx, RULE_dotSetOper);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(320);
			switch (_input.LA(1)) {
			case 20:
				{
				setState(316); match(20);
				setState(317);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 11) | (1L << 21) | (1L << 39) | (1L << 60))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				break;
			case DIGIT:
				{
				setState(318); match(DIGIT);
				}
				break;
			case LETTER:
				{
				setState(319); sName();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(327);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new DotSetOperContext(_parentctx, _parentState, _p);
					pushNewRecursionContext(_localctx, _startState, RULE_dotSetOper);
					setState(322);
					if (!(1 >= _localctx._p)) throw new FailedPredicateException(this, "1 >= $_p");
					setState(323); match(49);
					setState(324); dotSetOper(2);
					}
					} 
				}
				setState(329);
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

	public static class DataStructContext extends ParserRuleContext {
		public Reference2Context reference2() {
			return getRuleContext(Reference2Context.class,0);
		}
		public FileContext file() {
			return getRuleContext(FileContext.class,0);
		}
		public MapContext map() {
			return getRuleContext(MapContext.class,0);
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
		enterRule(_localctx, 46, RULE_dataStruct);
		try {
			setState(338);
			switch (_input.LA(1)) {
			case 15:
				enterOuterAlt(_localctx, 1);
				{
				setState(330); match(15);
				}
				break;
			case 24:
				enterOuterAlt(_localctx, 2);
				{
				setState(331); match(24);
				}
				break;
			case 38:
				enterOuterAlt(_localctx, 3);
				{
				setState(332); list();
				}
				break;
			case 19:
			case 44:
				enterOuterAlt(_localctx, 4);
				{
				setState(333); map();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 5);
				{
				setState(334); reference2();
				}
				break;
			case 50:
				enterOuterAlt(_localctx, 6);
				{
				setState(335); enumeration();
				}
				break;
			case 37:
				enterOuterAlt(_localctx, 7);
				{
				setState(336); table();
				}
				break;
			case 57:
				enterOuterAlt(_localctx, 8);
				{
				setState(337); file();
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
		enterRule(_localctx, 48, RULE_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(340); match(38);
			setState(353);
			_la = _input.LA(1);
			if (_la==3) {
				{
				setState(341); match(3);
				setState(342); listType();
				setState(343); match(30);
				setState(349);
				switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
				case 1:
					{
					setState(344); iName();
					}
					break;

				case 2:
					{
					setState(345); iName();
					setState(346); match(30);
					setState(347); iName();
					}
					break;
				}
				setState(351); match(29);
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

	public static class MapContext extends ParserRuleContext {
		public INameContext iName(int i) {
			return getRuleContext(INameContext.class,i);
		}
		public ITypeContext iType() {
			return getRuleContext(ITypeContext.class,0);
		}
		public List<INameContext> iName() {
			return getRuleContexts(INameContext.class);
		}
		public MapContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_map; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FTCRLListener ) ((FTCRLListener)listener).enterMap(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FTCRLListener ) ((FTCRLListener)listener).exitMap(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FTCRLVisitor ) return ((FTCRLVisitor<? extends T>)visitor).visitMap(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MapContext map() throws RecognitionException {
		MapContext _localctx = new MapContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_map);
		int _la;
		try {
			setState(371);
			switch (_input.LA(1)) {
			case 44:
				enterOuterAlt(_localctx, 1);
				{
				setState(355); match(44);
				setState(356); iName();
				setState(357); match(30);
				setState(358); iType();
				setState(361);
				_la = _input.LA(1);
				if (_la==30) {
					{
					setState(359); match(30);
					setState(360); iName();
					}
				}

				setState(363); match(29);
				}
				break;
			case 19:
				enterOuterAlt(_localctx, 2);
				{
				setState(365); match(19);
				setState(366); iName();
				setState(367); match(30);
				setState(368); iType();
				setState(369); match(29);
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

	public static class ITypeContext extends ParserRuleContext {
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public ITypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_iType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FTCRLListener ) ((FTCRLListener)listener).enterIType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FTCRLListener ) ((FTCRLListener)listener).exitIType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FTCRLVisitor ) return ((FTCRLVisitor<? extends T>)visitor).visitIType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ITypeContext iType() throws RecognitionException {
		ITypeContext _localctx = new ITypeContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_iType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(373); name();
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
		enterRule(_localctx, 54, RULE_reference2);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(375); match(8);
			setState(376); iName();
			setState(377); match(29);
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
		enterRule(_localctx, 56, RULE_enumeration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(379); match(50);
			setState(390);
			switch (_input.LA(1)) {
			case 3:
				{
				setState(380); match(3);
				{
				setState(381); sName();
				setState(382); match(54);
				setState(385); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					setState(385);
					switch (_input.LA(1)) {
					case LETTER:
						{
						setState(383); iName();
						}
						break;
					case DIGIT:
						{
						setState(384); number();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(387); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==DIGIT || _la==LETTER );
				}
				}
				break;
			case DIGIT:
				{
				setState(389); number();
				}
				break;
			case 25:
			case 29:
			case 30:
			case 52:
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
		enterRule(_localctx, 58, RULE_table);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(392); match(37);
			setState(393); iName();
			setState(394); match(30);
			setState(395); path();
			setState(396); match(30);
			setState(397); fName();
			setState(398); match(29);
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
		enterRule(_localctx, 60, RULE_file);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(400); match(57);
			setState(401); path();
			setState(402); match(29);
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
		enterRule(_localctx, 62, RULE_listType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(404);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 2) | (1L << 4) | (1L << 34) | (1L << 35))) != 0)) ) {
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

	public static class PLCodeContext extends ParserRuleContext {
		public String code;
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
		enterRule(_localctx, 64, RULE_pLCode);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(406); match(43);
			setState(407); match(NL);
			setState(408); anychar();
			setState(409); match(NL);
			setState(410); match(47);
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
		enterRule(_localctx, 66, RULE_anychar);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(415);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,44,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(412);
					_la = _input.LA(1);
					if ( !(((((_la - 49)) & ~0x3f) == 0 && ((1L << (_la - 49)) & ((1L << (49 - 49)) | (1L << (54 - 49)) | (1L << (60 - 49)) | (1L << (DIGIT - 49)) | (1L << (LETTER - 49)) | (1L << (NL - 49)) | (1L << (ANYCHAR - 49)))) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
					} 
				}
				setState(417);
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
		enterRule(_localctx, 68, RULE_name);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(418); match(LETTER);
			setState(422);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,45,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(419);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 18) | (1L << DIGIT) | (1L << LETTER))) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
					} 
				}
				setState(424);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,45,_ctx);
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
			setState(425); name();
			setState(427);
			switch ( getInterpreter().adaptivePredict(_input,46,_ctx) ) {
			case 1:
				{
				setState(426); match(36);
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
			setState(440);
			switch ( getInterpreter().adaptivePredict(_input,47,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(429); iIdent();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(430); iIdent();
				setState(431); match(12);
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(433); iIdent();
				setState(434); match(49);
				setState(435); iIdent();
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(437); iIdent();
				setState(438); match(26);
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
			setState(442); name();
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
			setState(444); name();
			setState(451);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==49 || _la==LETTER) {
				{
				{
				setState(446);
				_la = _input.LA(1);
				if (_la==49) {
					{
					setState(445); match(49);
					}
				}

				setState(448); name();
				}
				}
				setState(453);
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
			setState(455);
			_la = _input.LA(1);
			if (_la==49) {
				{
				setState(454); match(49);
				}
			}

			setState(458);
			_la = _input.LA(1);
			if (_la==59) {
				{
				setState(457); match(59);
				}
			}

			setState(460); fName();
			setState(465);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==59) {
				{
				{
				setState(461); match(59);
				setState(462); fName();
				}
				}
				setState(467);
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
			setState(468); match(9);
			setState(472);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DIGIT || _la==LETTER) {
				{
				{
				setState(469);
				_la = _input.LA(1);
				if ( !(_la==DIGIT || _la==LETTER) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				}
				setState(474);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(475); match(9);
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
			setState(477); match(42);
			setState(478); match(27);
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
			setState(480); match(DIGIT);
			setState(484);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,54,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(481);
					_la = _input.LA(1);
					if ( !(_la==10 || _la==DIGIT) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
					} 
				}
				setState(486);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,54,_ctx);
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
		case 18: return zExprSet_sempred((ZExprSetContext)_localctx, predIndex);

		case 19: return zExprNum_sempred((ZExprNumContext)_localctx, predIndex);

		case 20: return zExprString_sempred((ZExprStringContext)_localctx, predIndex);

		case 22: return dotSetOper_sempred((DotSetOperContext)_localctx, predIndex);
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
		case 1: return 1 >= _localctx._p;
		}
		return true;
	}
	private boolean zExprString_sempred(ZExprStringContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2: return 1 >= _localctx._p;
		}
		return true;
	}
	private boolean dotSetOper_sempred(DotSetOperContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3: return 1 >= _localctx._p;
		}
		return true;
	}

	public static final String _serializedATN =
		"\2\3C\u01ea\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4"+
		"\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20"+
		"\4\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27"+
		"\4\30\t\30\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36"+
		"\4\37\t\37\4 \t \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4"+
		")\t)\4*\t*\4+\t+\4,\t,\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2b\n\2\3"+
		"\2\3\2\3\2\3\2\5\2h\n\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\6\3s\n\3\r"+
		"\3\16\3t\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\5\5\u0080\n\5\3\5\3\5\7\5"+
		"\u0084\n\5\f\5\16\5\u0087\13\5\3\5\3\5\3\5\5\5\u008c\n\5\3\5\3\5\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\6\6\u0097\n\6\r\6\16\6\u0098\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\6\7\u00a7\n\7\r\7\16\7\u00a8\3\b\3\b\3"+
		"\b\3\b\3\t\3\t\3\n\3\n\3\n\5\n\u00b4\n\n\3\n\3\n\3\n\3\n\5\n\u00ba\n\n"+
		"\3\n\5\n\u00bd\n\n\3\13\3\13\3\13\3\13\5\13\u00c3\n\13\3\f\3\f\3\r\3\r"+
		"\3\16\3\16\3\16\7\16\u00cc\n\16\f\16\16\16\u00cf\13\16\3\16\3\16\3\16"+
		"\3\16\5\16\u00d5\n\16\3\16\7\16\u00d8\n\16\f\16\16\16\u00db\13\16\3\17"+
		"\3\17\3\17\3\17\5\17\u00e1\n\17\3\17\5\17\u00e4\n\17\3\20\3\20\3\20\3"+
		"\20\3\20\5\20\u00eb\n\20\3\21\3\21\3\21\5\21\u00f0\n\21\3\21\7\21\u00f3"+
		"\n\21\f\21\16\21\u00f6\13\21\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\5"+
		"\23\u0100\n\23\3\24\3\24\3\24\3\24\5\24\u0106\n\24\3\24\5\24\u0109\n\24"+
		"\3\24\3\24\3\24\7\24\u010e\n\24\f\24\16\24\u0111\13\24\3\25\3\25\3\25"+
		"\5\25\u0116\n\25\3\25\3\25\5\25\u011a\n\25\3\25\3\25\3\25\7\25\u011f\n"+
		"\25\f\25\16\25\u0122\13\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\5\26\u012d\n\26\3\26\5\26\u0130\n\26\5\26\u0132\n\26\3\26\3\26\3\26\7"+
		"\26\u0137\n\26\f\26\16\26\u013a\13\26\3\27\3\27\3\30\3\30\3\30\3\30\3"+
		"\30\5\30\u0143\n\30\3\30\3\30\3\30\7\30\u0148\n\30\f\30\16\30\u014b\13"+
		"\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\5\31\u0155\n\31\3\32\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\3\32\5\32\u0160\n\32\3\32\3\32\5\32\u0164"+
		"\n\32\3\33\3\33\3\33\3\33\3\33\3\33\5\33\u016c\n\33\3\33\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\3\33\5\33\u0176\n\33\3\34\3\34\3\35\3\35\3\35\3\35\3\36"+
		"\3\36\3\36\3\36\3\36\3\36\6\36\u0184\n\36\r\36\16\36\u0185\3\36\5\36\u0189"+
		"\n\36\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3!\3!\3\"\3"+
		"\"\3\"\3\"\3\"\3\"\3#\7#\u01a0\n#\f#\16#\u01a3\13#\3$\3$\7$\u01a7\n$\f"+
		"$\16$\u01aa\13$\3%\3%\5%\u01ae\n%\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\5&"+
		"\u01bb\n&\3\'\3\'\3(\3(\5(\u01c1\n(\3(\7(\u01c4\n(\f(\16(\u01c7\13(\3"+
		")\5)\u01ca\n)\3)\5)\u01cd\n)\3)\3)\3)\7)\u01d2\n)\f)\16)\u01d5\13)\3*"+
		"\3*\7*\u01d9\n*\f*\16*\u01dc\13*\3*\3*\3+\3+\3+\3,\3,\7,\u01e5\n,\f,\16"+
		",\u01e8\13,\3,\2-\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62"+
		"\64\668:<>@BDFHJLNPRTV\2\b\6\r\r\27\27))>>\5\4\4\6\6$%\6\63\6388>ACC\4"+
		"\24\24?@\3?@\4\f\f??\u0207\2X\3\2\2\2\4k\3\2\2\2\6v\3\2\2\2\b{\3\2\2\2"+
		"\n\u008f\3\2\2\2\f\u009a\3\2\2\2\16\u00aa\3\2\2\2\20\u00ae\3\2\2\2\22"+
		"\u00bc\3\2\2\2\24\u00be\3\2\2\2\26\u00c4\3\2\2\2\30\u00c6\3\2\2\2\32\u00c8"+
		"\3\2\2\2\34\u00e3\3\2\2\2\36\u00e5\3\2\2\2 \u00ec\3\2\2\2\"\u00f7\3\2"+
		"\2\2$\u00ff\3\2\2\2&\u0108\3\2\2\2(\u0119\3\2\2\2*\u0131\3\2\2\2,\u013b"+
		"\3\2\2\2.\u0142\3\2\2\2\60\u0154\3\2\2\2\62\u0156\3\2\2\2\64\u0175\3\2"+
		"\2\2\66\u0177\3\2\2\28\u0179\3\2\2\2:\u017d\3\2\2\2<\u018a\3\2\2\2>\u0192"+
		"\3\2\2\2@\u0196\3\2\2\2B\u0198\3\2\2\2D\u01a1\3\2\2\2F\u01a4\3\2\2\2H"+
		"\u01ab\3\2\2\2J\u01ba\3\2\2\2L\u01bc\3\2\2\2N\u01be\3\2\2\2P\u01c9\3\2"+
		"\2\2R\u01d6\3\2\2\2T\u01df\3\2\2\2V\u01e2\3\2\2\2XY\7*\2\2YZ\5F$\2Z[\7"+
		"A\2\2[\\\5\4\3\2\\]\7A\2\2]a\5\f\7\2^_\5\6\4\2_`\7A\2\2`b\3\2\2\2a^\3"+
		"\2\2\2ab\3\2\2\2bc\3\2\2\2cg\5\b\5\2de\5\n\6\2ef\7A\2\2fh\3\2\2\2gd\3"+
		"\2\2\2gh\3\2\2\2hi\3\2\2\2ij\7\1\2\2j\3\3\2\2\2kl\7\62\2\2lr\7A\2\2ms"+
		"\5B\"\2no\5F$\2op\7\20\2\2pq\7A\2\2qs\3\2\2\2rm\3\2\2\2rn\3\2\2\2st\3"+
		"\2\2\2tr\3\2\2\2tu\3\2\2\2u\5\3\2\2\2vw\7\t\2\2wx\7A\2\2xy\5B\"\2yz\7"+
		"A\2\2z\7\3\2\2\2{|\7\17\2\2|}\5J&\2}\177\7!\2\2~\u0080\5J&\2\177~\3\2"+
		"\2\2\177\u0080\3\2\2\2\u0080\u0085\3\2\2\2\u0081\u0082\7 \2\2\u0082\u0084"+
		"\5J&\2\u0083\u0081\3\2\2\2\u0084\u0087\3\2\2\2\u0085\u0083\3\2\2\2\u0085"+
		"\u0086\3\2\2\2\u0086\u0088\3\2\2\2\u0087\u0085\3\2\2\2\u0088\u008b\7\22"+
		"\2\2\u0089\u008a\79\2\2\u008a\u008c\5J&\2\u008b\u0089\3\2\2\2\u008b\u008c"+
		"\3\2\2\2\u008c\u008d\3\2\2\2\u008d\u008e\7A\2\2\u008e\t\3\2\2\2\u008f"+
		"\u0090\7\3\2\2\u0090\u0096\7A\2\2\u0091\u0097\5B\"\2\u0092\u0093\5F$\2"+
		"\u0093\u0094\7\36\2\2\u0094\u0095\7A\2\2\u0095\u0097\3\2\2\2\u0096\u0091"+
		"\3\2\2\2\u0096\u0092\3\2\2\2\u0097\u0098\3\2\2\2\u0098\u0096\3\2\2\2\u0098"+
		"\u0099\3\2\2\2\u0099\13\3\2\2\2\u009a\u009b\7\b\2\2\u009b\u00a6\7A\2\2"+
		"\u009c\u009d\5\22\n\2\u009d\u009e\7A\2\2\u009e\u00a7\3\2\2\2\u009f\u00a0"+
		"\5\16\b\2\u00a0\u00a1\7A\2\2\u00a1\u00a7\3\2\2\2\u00a2\u00a3\5F$\2\u00a3"+
		"\u00a4\7\67\2\2\u00a4\u00a5\7A\2\2\u00a5\u00a7\3\2\2\2\u00a6\u009c\3\2"+
		"\2\2\u00a6\u009f\3\2\2\2\u00a6\u00a2\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8"+
		"\u00a6\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\r\3\2\2\2\u00aa\u00ab\5F$\2\u00ab"+
		"\u00ac\7\63\2\2\u00ac\u00ad\5\20\t\2\u00ad\17\3\2\2\2\u00ae\u00af\5F$"+
		"\2\u00af\21\3\2\2\2\u00b0\u00b1\5F$\2\u00b1\u00b2\7\"\2\2\u00b2\u00b4"+
		"\3\2\2\2\u00b3\u00b0\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5"+
		"\u00bd\5\24\13\2\u00b6\u00b7\5F$\2\u00b7\u00b8\7\"\2\2\u00b8\u00ba\3\2"+
		"\2\2\u00b9\u00b6\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba\u00bb\3\2\2\2\u00bb"+
		"\u00bd\5\32\16\2\u00bc\u00b3\3\2\2\2\u00bc\u00b9\3\2\2\2\u00bd\23\3\2"+
		"\2\2\u00be\u00bf\5F$\2\u00bf\u00c2\7<\2\2\u00c0\u00c3\5\26\f\2\u00c1\u00c3"+
		"\5\30\r\2\u00c2\u00c0\3\2\2\2\u00c2\u00c1\3\2\2\2\u00c3\25\3\2\2\2\u00c4"+
		"\u00c5\5\36\20\2\u00c5\27\3\2\2\2\u00c6\u00c7\5 \21\2\u00c7\31\3\2\2\2"+
		"\u00c8\u00cd\5H%\2\u00c9\u00ca\7 \2\2\u00ca\u00cc\5H%\2\u00cb\u00c9\3"+
		"\2\2\2\u00cc\u00cf\3\2\2\2\u00cd\u00cb\3\2\2\2\u00cd\u00ce\3\2\2\2\u00ce"+
		"\u00d0\3\2\2\2\u00cf\u00cd\3\2\2\2\u00d0\u00d1\7#\2\2\u00d1\u00d9\5\34"+
		"\17\2\u00d2\u00d4\7\66\2\2\u00d3\u00d5\7A\2\2\u00d4\u00d3\3\2\2\2\u00d4"+
		"\u00d5\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6\u00d8\5\34\17\2\u00d7\u00d2\3"+
		"\2\2\2\u00d8\u00db\3\2\2\2\u00d9\u00d7\3\2\2\2\u00d9\u00da\3\2\2\2\u00da"+
		"\33\3\2\2\2\u00db\u00d9\3\2\2\2\u00dc\u00e0\5J&\2\u00dd\u00de\7\7\2\2"+
		"\u00de\u00e1\5\36\20\2\u00df\u00e1\5\26\f\2\u00e0\u00dd\3\2\2\2\u00e0"+
		"\u00df\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1\u00e4\3\2\2\2\u00e2\u00e4\5\""+
		"\22\2\u00e3\u00dc\3\2\2\2\u00e3\u00e2\3\2\2\2\u00e4\35\3\2\2\2\u00e5\u00ea"+
		"\5\60\31\2\u00e6\u00e7\7\33\2\2\u00e7\u00e8\5 \21\2\u00e8\u00e9\7\37\2"+
		"\2\u00e9\u00eb\3\2\2\2\u00ea\u00e6\3\2\2\2\u00ea\u00eb\3\2\2\2\u00eb\37"+
		"\3\2\2\2\u00ec\u00f4\5\"\22\2\u00ed\u00ef\7 \2\2\u00ee\u00f0\7A\2\2\u00ef"+
		"\u00ee\3\2\2\2\u00ef\u00f0\3\2\2\2\u00f0\u00f1\3\2\2\2\u00f1\u00f3\5\""+
		"\22\2\u00f2\u00ed\3\2\2\2\u00f3\u00f6\3\2\2\2\u00f4\u00f2\3\2\2\2\u00f4"+
		"\u00f5\3\2\2\2\u00f5!\3\2\2\2\u00f6\u00f4\3\2\2\2\u00f7\u00f8\5$\23\2"+
		"\u00f8\u00f9\7#\2\2\u00f9\u00fa\5\34\17\2\u00fa#\3\2\2\2\u00fb\u0100\5"+
		"&\24\2\u00fc\u0100\5(\25\2\u00fd\u0100\5*\26\2\u00fe\u0100\5,\27\2\u00ff"+
		"\u00fb\3\2\2\2\u00ff\u00fc\3\2\2\2\u00ff\u00fd\3\2\2\2\u00ff\u00fe\3\2"+
		"\2\2\u0100%\3\2\2\2\u0101\u0102\b\24\1\2\u0102\u0105\5H%\2\u0103\u0104"+
		"\7\63\2\2\u0104\u0106\5.\30\2\u0105\u0103\3\2\2\2\u0105\u0106\3\2\2\2"+
		"\u0106\u0109\3\2\2\2\u0107\u0109\5T+\2\u0108\u0101\3\2\2\2\u0108\u0107"+
		"\3\2\2\2\u0109\u010f\3\2\2\2\u010a\u010b\6\24\2\3\u010b\u010c\7\23\2\2"+
		"\u010c\u010e\5&\24\2\u010d\u010a\3\2\2\2\u010e\u0111\3\2\2\2\u010f\u010d"+
		"\3\2\2\2\u010f\u0110\3\2\2\2\u0110\'\3\2\2\2\u0111\u010f\3\2\2\2\u0112"+
		"\u0113\b\25\1\2\u0113\u0115\5H%\2\u0114\u0116\7\30\2\2\u0115\u0114\3\2"+
		"\2\2\u0115\u0116\3\2\2\2\u0116\u011a\3\2\2\2\u0117\u011a\5V,\2\u0118\u011a"+
		"\7/\2\2\u0119\u0112\3\2\2\2\u0119\u0117\3\2\2\2\u0119\u0118\3\2\2\2\u011a"+
		"\u0120\3\2\2\2\u011b\u011c\6\25\3\3\u011c\u011d\7\31\2\2\u011d\u011f\5"+
		"(\25\2\u011e\u011b\3\2\2\2\u011f\u0122\3\2\2\2\u0120\u011e\3\2\2\2\u0120"+
		"\u0121\3\2\2\2\u0121)\3\2\2\2\u0122\u0120\3\2\2\2\u0123\u0124\b\26\1\2"+
		"\u0124\u0132\5R*\2\u0125\u0132\5V,\2\u0126\u0132\7/\2\2\u0127\u012f\5"+
		"H%\2\u0128\u012c\7:\2\2\u0129\u012d\5.\30\2\u012a\u012d\7>\2\2\u012b\u012d"+
		"\7+\2\2\u012c\u0129\3\2\2\2\u012c\u012a\3\2\2\2\u012c\u012b\3\2\2\2\u012d"+
		"\u012e\3\2\2\2\u012e\u0130\7\22\2\2\u012f\u0128\3\2\2\2\u012f\u0130\3"+
		"\2\2\2\u0130\u0132\3\2\2\2\u0131\u0123\3\2\2\2\u0131\u0125\3\2\2\2\u0131"+
		"\u0126\3\2\2\2\u0131\u0127\3\2\2\2\u0132\u0138\3\2\2\2\u0133\u0134\6\26"+
		"\4\3\u0134\u0135\7\60\2\2\u0135\u0137\5*\26\2\u0136\u0133\3\2\2\2\u0137"+
		"\u013a\3\2\2\2\u0138\u0136\3\2\2\2\u0138\u0139\3\2\2\2\u0139+\3\2\2\2"+
		"\u013a\u0138\3\2\2\2\u013b\u013c\7\65\2\2\u013c-\3\2\2\2\u013d\u013e\b"+
		"\30\1\2\u013e\u013f\7\26\2\2\u013f\u0143\t\2\2\2\u0140\u0143\7?\2\2\u0141"+
		"\u0143\5H%\2\u0142\u013d\3\2\2\2\u0142\u0140\3\2\2\2\u0142\u0141\3\2\2"+
		"\2\u0143\u0149\3\2\2\2\u0144\u0145\6\30\5\3\u0145\u0146\7\63\2\2\u0146"+
		"\u0148\5.\30\2\u0147\u0144\3\2\2\2\u0148\u014b\3\2\2\2\u0149\u0147\3\2"+
		"\2\2\u0149\u014a\3\2\2\2\u014a/\3\2\2\2\u014b\u0149\3\2\2\2\u014c\u0155"+
		"\7\21\2\2\u014d\u0155\7\32\2\2\u014e\u0155\5\62\32\2\u014f\u0155\5\64"+
		"\33\2\u0150\u0155\58\35\2\u0151\u0155\5:\36\2\u0152\u0155\5<\37\2\u0153"+
		"\u0155\5> \2\u0154\u014c\3\2\2\2\u0154\u014d\3\2\2\2\u0154\u014e\3\2\2"+
		"\2\u0154\u014f\3\2\2\2\u0154\u0150\3\2\2\2\u0154\u0151\3\2\2\2\u0154\u0152"+
		"\3\2\2\2\u0154\u0153\3\2\2\2\u0155\61\3\2\2\2\u0156\u0163\7(\2\2\u0157"+
		"\u0158\7\5\2\2\u0158\u0159\5@!\2\u0159\u015f\7 \2\2\u015a\u0160\5J&\2"+
		"\u015b\u015c\5J&\2\u015c\u015d\7 \2\2\u015d\u015e\5J&\2\u015e\u0160\3"+
		"\2\2\2\u015f\u015a\3\2\2\2\u015f\u015b\3\2\2\2\u0160\u0161\3\2\2\2\u0161"+
		"\u0162\7\37\2\2\u0162\u0164\3\2\2\2\u0163\u0157\3\2\2\2\u0163\u0164\3"+
		"\2\2\2\u0164\63\3\2\2\2\u0165\u0166\7.\2\2\u0166\u0167\5J&\2\u0167\u0168"+
		"\7 \2\2\u0168\u016b\5\66\34\2\u0169\u016a\7 \2\2\u016a\u016c\5J&\2\u016b"+
		"\u0169\3\2\2\2\u016b\u016c\3\2\2\2\u016c\u016d\3\2\2\2\u016d\u016e\7\37"+
		"\2\2\u016e\u0176\3\2\2\2\u016f\u0170\7\25\2\2\u0170\u0171\5J&\2\u0171"+
		"\u0172\7 \2\2\u0172\u0173\5\66\34\2\u0173\u0174\7\37\2\2\u0174\u0176\3"+
		"\2\2\2\u0175\u0165\3\2\2\2\u0175\u016f\3\2\2\2\u0176\65\3\2\2\2\u0177"+
		"\u0178\5F$\2\u0178\67\3\2\2\2\u0179\u017a\7\n\2\2\u017a\u017b\5J&\2\u017b"+
		"\u017c\7\37\2\2\u017c9\3\2\2\2\u017d\u0188\7\64\2\2\u017e\u017f\7\5\2"+
		"\2\u017f\u0180\5H%\2\u0180\u0183\78\2\2\u0181\u0184\5J&\2\u0182\u0184"+
		"\5V,\2\u0183\u0181\3\2\2\2\u0183\u0182\3\2\2\2\u0184\u0185\3\2\2\2\u0185"+
		"\u0183\3\2\2\2\u0185\u0186\3\2\2\2\u0186\u0189\3\2\2\2\u0187\u0189\5V"+
		",\2\u0188\u017e\3\2\2\2\u0188\u0187\3\2\2\2\u0188\u0189\3\2\2\2\u0189"+
		";\3\2\2\2\u018a\u018b\7\'\2\2\u018b\u018c\5J&\2\u018c\u018d\7 \2\2\u018d"+
		"\u018e\5P)\2\u018e\u018f\7 \2\2\u018f\u0190\5N(\2\u0190\u0191\7\37\2\2"+
		"\u0191=\3\2\2\2\u0192\u0193\7;\2\2\u0193\u0194\5P)\2\u0194\u0195\7\37"+
		"\2\2\u0195?\3\2\2\2\u0196\u0197\t\3\2\2\u0197A\3\2\2\2\u0198\u0199\7-"+
		"\2\2\u0199\u019a\7A\2\2\u019a\u019b\5D#\2\u019b\u019c\7A\2\2\u019c\u019d"+
		"\7\61\2\2\u019dC\3\2\2\2\u019e\u01a0\t\4\2\2\u019f\u019e\3\2\2\2\u01a0"+
		"\u01a3\3\2\2\2\u01a1\u019f\3\2\2\2\u01a1\u01a2\3\2\2\2\u01a2E\3\2\2\2"+
		"\u01a3\u01a1\3\2\2\2\u01a4\u01a8\7@\2\2\u01a5\u01a7\t\5\2\2\u01a6\u01a5"+
		"\3\2\2\2\u01a7\u01aa\3\2\2\2\u01a8\u01a6\3\2\2\2\u01a8\u01a9\3\2\2\2\u01a9"+
		"G\3\2\2\2\u01aa\u01a8\3\2\2\2\u01ab\u01ad\5F$\2\u01ac\u01ae\7&\2\2\u01ad"+
		"\u01ac\3\2\2\2\u01ad\u01ae\3\2\2\2\u01aeI\3\2\2\2\u01af\u01bb\5L\'\2\u01b0"+
		"\u01b1\5L\'\2\u01b1\u01b2\7\16\2\2\u01b2\u01bb\3\2\2\2\u01b3\u01b4\5L"+
		"\'\2\u01b4\u01b5\7\63\2\2\u01b5\u01b6\5L\'\2\u01b6\u01bb\3\2\2\2\u01b7"+
		"\u01b8\5L\'\2\u01b8\u01b9\7\34\2\2\u01b9\u01bb\3\2\2\2\u01ba\u01af\3\2"+
		"\2\2\u01ba\u01b0\3\2\2\2\u01ba\u01b3\3\2\2\2\u01ba\u01b7\3\2\2\2\u01bb"+
		"K\3\2\2\2\u01bc\u01bd\5F$\2\u01bdM\3\2\2\2\u01be\u01c5\5F$\2\u01bf\u01c1"+
		"\7\63\2\2\u01c0\u01bf\3\2\2\2\u01c0\u01c1\3\2\2\2\u01c1\u01c2\3\2\2\2"+
		"\u01c2\u01c4\5F$\2\u01c3\u01c0\3\2\2\2\u01c4\u01c7\3\2\2\2\u01c5\u01c3"+
		"\3\2\2\2\u01c5\u01c6\3\2\2\2\u01c6O\3\2\2\2\u01c7\u01c5\3\2\2\2\u01c8"+
		"\u01ca\7\63\2\2\u01c9\u01c8\3\2\2\2\u01c9\u01ca\3\2\2\2\u01ca\u01cc\3"+
		"\2\2\2\u01cb\u01cd\7=\2\2\u01cc\u01cb\3\2\2\2\u01cc\u01cd\3\2\2\2\u01cd"+
		"\u01ce\3\2\2\2\u01ce\u01d3\5N(\2\u01cf\u01d0\7=\2\2\u01d0\u01d2\5N(\2"+
		"\u01d1\u01cf\3\2\2\2\u01d2\u01d5\3\2\2\2\u01d3\u01d1\3\2\2\2\u01d3\u01d4"+
		"\3\2\2\2\u01d4Q\3\2\2\2\u01d5\u01d3\3\2\2\2\u01d6\u01da\7\13\2\2\u01d7"+
		"\u01d9\t\6\2\2\u01d8\u01d7\3\2\2\2\u01d9\u01dc\3\2\2\2\u01da\u01d8\3\2"+
		"\2\2\u01da\u01db\3\2\2\2\u01db\u01dd\3\2\2\2\u01dc\u01da\3\2\2\2\u01dd"+
		"\u01de\7\13\2\2\u01deS\3\2\2\2\u01df\u01e0\7,\2\2\u01e0\u01e1\7\35\2\2"+
		"\u01e1U\3\2\2\2\u01e2\u01e6\7?\2\2\u01e3\u01e5\t\7\2\2\u01e4\u01e3\3\2"+
		"\2\2\u01e5\u01e8\3\2\2\2\u01e6\u01e4\3\2\2\2\u01e6\u01e7\3\2\2\2\u01e7"+
		"W\3\2\2\2\u01e8\u01e6\3\2\2\29agrt\177\u0085\u008b\u0096\u0098\u00a6\u00a8"+
		"\u00b3\u00b9\u00bc\u00c2\u00cd\u00d4\u00d9\u00e0\u00e3\u00ea\u00ef\u00f4"+
		"\u00ff\u0105\u0108\u010f\u0115\u0119\u0120\u012c\u012f\u0131\u0138\u0142"+
		"\u0149\u0154\u015f\u0163\u016b\u0175\u0183\u0185\u0188\u01a1\u01a8\u01ad"+
		"\u01ba\u01c0\u01c5\u01c9\u01cc\u01d3\u01da\u01e6";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}