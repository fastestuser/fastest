// Generated from /home/cristian/workspace/fastest/atcal2/src/main/java/org/fastest/atcal/Atcal.g4 by ANTLR 4.5
package org.fastest.atcal.parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class AtcalParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		STMTEND=39, ID=40, NUMBER=41, PLUS=42, MINUS=43, MUL=44, DIV=45, MOD=46, 
		DOM=47, RAN=48, PROJ=49, TUPPROJ=50, INTER=51, UNION=52, DIFF=53, ELEM=54, 
		AUTO=55, CARD=56, STRING=57, WS=58;
	public static final int
		RULE_refinementRule = 0, RULE_preamble = 1, RULE_plcode = 2, RULE_datatypes = 3, 
		RULE_typeDec = 4, RULE_type = 5, RULE_args = 6, RULE_constMapping = 7, 
		RULE_constMap = 8, RULE_laws = 9, RULE_uut = 10, RULE_epilogue = 11, RULE_law = 12, 
		RULE_lawRefinement = 13, RULE_zExprs = 14, RULE_refinement = 15, RULE_lvalue = 16, 
		RULE_withRef = 17, RULE_zExpr = 18;
	public static final String[] ruleNames = {
		"refinementRule", "preamble", "plcode", "datatypes", "typeDec", "type", 
		"args", "constMapping", "constMap", "laws", "uut", "epilogue", "law", 
		"lawRefinement", "zExprs", "refinement", "lvalue", "withRef", "zExpr"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'@RRULE'", "'@PREAMBLE'", "'.@PREAMBLE'", "'@CODESTART'", "'@CODEEND'", 
		"'@DATATYPES'", "'DATATYPE'", "'='", "'INT'", "'FLOAT'", "'STRING'", "'ARRAY'", 
		"'('", "')'", "'ENUM'", "'RECORD'", "':'", "','", "'CONSTRUCTOR'", "'SETTER'", 
		"'GETTER'", "'MAP'", "'['", "']'", "'->'", "'@LAWS'", "'@UUT'", "'@EPILOGUE'", 
		"'.@EPILOGUE'", "'==>'", "'AS'", "'.'", "'WITH'", "'<'", "'>'", "'{'", 
		"'}'", "'++'", null, null, null, "'+'", "'-'", "'*'", "'/'", "'%'", "'@DOM'", 
		"'@RAN'", null, null, "'/\\'", "'\\/'", "'~'", "'@ELEM'", "'@AUTOFILL'", 
		"'@CARD'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, "STMTEND", "ID", "NUMBER", "PLUS", "MINUS", "MUL", "DIV", 
		"MOD", "DOM", "RAN", "PROJ", "TUPPROJ", "INTER", "UNION", "DIFF", "ELEM", 
		"AUTO", "CARD", "STRING", "WS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override
	@NotNull
	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Atcal.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public AtcalParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class RefinementRuleContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(AtcalParser.ID, 0); }
		public LawsContext laws() {
			return getRuleContext(LawsContext.class,0);
		}
		public UutContext uut() {
			return getRuleContext(UutContext.class,0);
		}
		public PreambleContext preamble() {
			return getRuleContext(PreambleContext.class,0);
		}
		public DatatypesContext datatypes() {
			return getRuleContext(DatatypesContext.class,0);
		}
		public PlcodeContext plcode() {
			return getRuleContext(PlcodeContext.class,0);
		}
		public EpilogueContext epilogue() {
			return getRuleContext(EpilogueContext.class,0);
		}
		public RefinementRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_refinementRule; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AtcalVisitor ) return ((AtcalVisitor<? extends T>)visitor).visitRefinementRule(this);
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
			setState(38); 
			match(T__0);
			setState(39); 
			match(ID);
			setState(41);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(40); 
				preamble();
				}
			}

			setState(44);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(43); 
				datatypes();
				}
			}

			setState(46); 
			laws();
			setState(48);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(47); 
				plcode();
				}
			}

			setState(50); 
			uut();
			setState(52);
			_la = _input.LA(1);
			if (_la==T__27) {
				{
				setState(51); 
				epilogue();
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
		public List<PlcodeContext> plcode() {
			return getRuleContexts(PlcodeContext.class);
		}
		public PlcodeContext plcode(int i) {
			return getRuleContext(PlcodeContext.class,i);
		}
		public List<TerminalNode> ID() { return getTokens(AtcalParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(AtcalParser.ID, i);
		}
		public List<TerminalNode> STMTEND() { return getTokens(AtcalParser.STMTEND); }
		public TerminalNode STMTEND(int i) {
			return getToken(AtcalParser.STMTEND, i);
		}
		public PreambleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_preamble; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AtcalVisitor ) return ((AtcalVisitor<? extends T>)visitor).visitPreamble(this);
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
			setState(54); 
			match(T__1);
			setState(59); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(59);
				switch (_input.LA(1)) {
				case T__3:
					{
					setState(55); 
					plcode();
					}
					break;
				case ID:
					{
					setState(56); 
					match(ID);
					setState(57); 
					match(T__2);
					setState(58); 
					match(STMTEND);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(61); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__3 || _la==ID );
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
		public PlcodeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_plcode; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AtcalVisitor ) return ((AtcalVisitor<? extends T>)visitor).visitPlcode(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PlcodeContext plcode() throws RecognitionException {
		PlcodeContext _localctx = new PlcodeContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_plcode);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(63); 
			match(T__3);
			setState(67);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(64);
					matchWildcard();
					}
					} 
				}
				setState(69);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			setState(70); 
			match(T__4);
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

	public static class DatatypesContext extends ParserRuleContext {
		public List<TypeDecContext> typeDec() {
			return getRuleContexts(TypeDecContext.class);
		}
		public TypeDecContext typeDec(int i) {
			return getRuleContext(TypeDecContext.class,i);
		}
		public DatatypesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_datatypes; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AtcalVisitor ) return ((AtcalVisitor<? extends T>)visitor).visitDatatypes(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DatatypesContext datatypes() throws RecognitionException {
		DatatypesContext _localctx = new DatatypesContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_datatypes);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72); 
			match(T__5);
			setState(74); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(73); 
				typeDec();
				}
				}
				setState(76); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__6 );
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

	public static class TypeDecContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(AtcalParser.ID, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode STMTEND() { return getToken(AtcalParser.STMTEND, 0); }
		public TypeDecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeDec; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AtcalVisitor ) return ((AtcalVisitor<? extends T>)visitor).visitTypeDec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeDecContext typeDec() throws RecognitionException {
		TypeDecContext _localctx = new TypeDecContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_typeDec);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78); 
			match(T__6);
			setState(79); 
			match(ID);
			setState(80); 
			match(T__7);
			setState(81); 
			type();
			setState(82); 
			match(STMTEND);
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

	public static class TypeContext extends ParserRuleContext {
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	 
		public TypeContext() { }
		public void copyFrom(TypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ArrayTypeContext extends TypeContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode NUMBER() { return getToken(AtcalParser.NUMBER, 0); }
		public ArrayTypeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AtcalVisitor ) return ((AtcalVisitor<? extends T>)visitor).visitArrayType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RecordTypeContext extends TypeContext {
		public List<TerminalNode> ID() { return getTokens(AtcalParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(AtcalParser.ID, i);
		}
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public RecordTypeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AtcalVisitor ) return ((AtcalVisitor<? extends T>)visitor).visitRecordType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StringTypeContext extends TypeContext {
		public StringTypeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AtcalVisitor ) return ((AtcalVisitor<? extends T>)visitor).visitStringType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EnumTypeContext extends TypeContext {
		public TerminalNode ID() { return getToken(AtcalParser.ID, 0); }
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public EnumTypeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AtcalVisitor ) return ((AtcalVisitor<? extends T>)visitor).visitEnumType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ContractTypeContext extends TypeContext {
		public List<TerminalNode> ID() { return getTokens(AtcalParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(AtcalParser.ID, i);
		}
		public List<ArgsContext> args() {
			return getRuleContexts(ArgsContext.class);
		}
		public ArgsContext args(int i) {
			return getRuleContext(ArgsContext.class,i);
		}
		public ContractTypeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AtcalVisitor ) return ((AtcalVisitor<? extends T>)visitor).visitContractType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NameTypeContext extends TypeContext {
		public TerminalNode ID() { return getToken(AtcalParser.ID, 0); }
		public NameTypeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AtcalVisitor ) return ((AtcalVisitor<? extends T>)visitor).visitNameType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntTypeContext extends TypeContext {
		public IntTypeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AtcalVisitor ) return ((AtcalVisitor<? extends T>)visitor).visitIntType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FloatTypeContext extends TypeContext {
		public FloatTypeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AtcalVisitor ) return ((AtcalVisitor<? extends T>)visitor).visitFloatType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_type);
		int _la;
		try {
			setState(124);
			switch (_input.LA(1)) {
			case ID:
				_localctx = new NameTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(84); 
				match(ID);
				}
				break;
			case T__8:
				_localctx = new IntTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(85); 
				match(T__8);
				}
				break;
			case T__9:
				_localctx = new FloatTypeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(86); 
				match(T__9);
				}
				break;
			case T__10:
				_localctx = new StringTypeContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(87); 
				match(T__10);
				}
				break;
			case T__11:
				_localctx = new ArrayTypeContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(88); 
				match(T__11);
				setState(89); 
				type();
				setState(90); 
				match(T__12);
				setState(91); 
				match(NUMBER);
				setState(92); 
				match(T__13);
				}
				break;
			case T__14:
				_localctx = new EnumTypeContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(94); 
				match(T__14);
				setState(95); 
				match(ID);
				setState(96); 
				args();
				}
				break;
			case T__15:
				_localctx = new RecordTypeContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(97); 
				match(T__15);
				setState(98); 
				match(ID);
				setState(99); 
				match(T__12);
				setState(100); 
				match(ID);
				setState(101); 
				match(T__16);
				setState(102); 
				type();
				setState(109);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__17) {
					{
					{
					setState(103); 
					match(T__17);
					setState(104); 
					match(ID);
					setState(105); 
					match(T__16);
					setState(106); 
					type();
					}
					}
					setState(111);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(112); 
				match(T__13);
				}
				break;
			case T__18:
				_localctx = new ContractTypeContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(114); 
				match(T__18);
				setState(115); 
				match(ID);
				setState(116); 
				args();
				setState(117); 
				match(T__19);
				setState(118); 
				match(ID);
				setState(119); 
				args();
				setState(120); 
				match(T__20);
				setState(121); 
				match(ID);
				setState(122); 
				args();
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

	public static class ArgsContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(AtcalParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(AtcalParser.ID, i);
		}
		public ArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_args; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AtcalVisitor ) return ((AtcalVisitor<? extends T>)visitor).visitArgs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgsContext args() throws RecognitionException {
		ArgsContext _localctx = new ArgsContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_args);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126); 
			match(T__12);
			setState(135);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(127); 
				match(ID);
				setState(132);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__17) {
					{
					{
					setState(128); 
					match(T__17);
					setState(129); 
					match(ID);
					}
					}
					setState(134);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(137); 
			match(T__13);
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

	public static class ConstMappingContext extends ParserRuleContext {
		public List<ConstMapContext> constMap() {
			return getRuleContexts(ConstMapContext.class);
		}
		public ConstMapContext constMap(int i) {
			return getRuleContext(ConstMapContext.class,i);
		}
		public ConstMappingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constMapping; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AtcalVisitor ) return ((AtcalVisitor<? extends T>)visitor).visitConstMapping(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstMappingContext constMapping() throws RecognitionException {
		ConstMappingContext _localctx = new ConstMappingContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_constMapping);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139); 
			match(T__21);
			setState(140); 
			match(T__22);
			setState(141); 
			constMap();
			setState(146);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__17) {
				{
				{
				setState(142); 
				match(T__17);
				setState(143); 
				constMap();
				}
				}
				setState(148);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(149); 
			match(T__23);
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

	public static class ConstMapContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(AtcalParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(AtcalParser.ID, i);
		}
		public TerminalNode STRING() { return getToken(AtcalParser.STRING, 0); }
		public TerminalNode NUMBER() { return getToken(AtcalParser.NUMBER, 0); }
		public ConstMapContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constMap; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AtcalVisitor ) return ((AtcalVisitor<? extends T>)visitor).visitConstMap(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstMapContext constMap() throws RecognitionException {
		ConstMapContext _localctx = new ConstMapContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_constMap);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151); 
			match(ID);
			setState(152); 
			match(T__24);
			setState(153);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ID) | (1L << NUMBER) | (1L << STRING))) != 0)) ) {
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

	public static class LawsContext extends ParserRuleContext {
		public List<LawContext> law() {
			return getRuleContexts(LawContext.class);
		}
		public LawContext law(int i) {
			return getRuleContext(LawContext.class,i);
		}
		public List<TerminalNode> STMTEND() { return getTokens(AtcalParser.STMTEND); }
		public TerminalNode STMTEND(int i) {
			return getToken(AtcalParser.STMTEND, i);
		}
		public LawsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_laws; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AtcalVisitor ) return ((AtcalVisitor<? extends T>)visitor).visitLaws(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LawsContext laws() throws RecognitionException {
		LawsContext _localctx = new LawsContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_laws);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(155); 
			match(T__25);
			setState(161);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__12) | (1L << T__33) | (1L << T__35) | (1L << ID) | (1L << NUMBER) | (1L << ELEM) | (1L << AUTO) | (1L << STRING))) != 0)) {
				{
				{
				setState(156); 
				law();
				setState(157); 
				match(STMTEND);
				}
				}
				setState(163);
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

	public static class UutContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(AtcalParser.ID, 0); }
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public TerminalNode STMTEND() { return getToken(AtcalParser.STMTEND, 0); }
		public UutContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_uut; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AtcalVisitor ) return ((AtcalVisitor<? extends T>)visitor).visitUut(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UutContext uut() throws RecognitionException {
		UutContext _localctx = new UutContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_uut);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(164); 
			match(T__26);
			setState(165); 
			match(ID);
			setState(166); 
			args();
			setState(167); 
			match(STMTEND);
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
		public List<PlcodeContext> plcode() {
			return getRuleContexts(PlcodeContext.class);
		}
		public PlcodeContext plcode(int i) {
			return getRuleContext(PlcodeContext.class,i);
		}
		public List<TerminalNode> ID() { return getTokens(AtcalParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(AtcalParser.ID, i);
		}
		public EpilogueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_epilogue; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AtcalVisitor ) return ((AtcalVisitor<? extends T>)visitor).visitEpilogue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EpilogueContext epilogue() throws RecognitionException {
		EpilogueContext _localctx = new EpilogueContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_epilogue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169); 
			match(T__27);
			setState(173); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(173);
				switch (_input.LA(1)) {
				case T__3:
					{
					setState(170); 
					plcode();
					}
					break;
				case ID:
					{
					setState(171); 
					match(ID);
					setState(172); 
					match(T__28);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(175); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__3 || _la==ID );
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
		public LawRefinementContext lawRefinement() {
			return getRuleContext(LawRefinementContext.class,0);
		}
		public TerminalNode ID() { return getToken(AtcalParser.ID, 0); }
		public LawContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_law; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AtcalVisitor ) return ((AtcalVisitor<? extends T>)visitor).visitLaw(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LawContext law() throws RecognitionException {
		LawContext _localctx = new LawContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_law);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(179);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				setState(177); 
				match(ID);
				setState(178); 
				match(T__16);
				}
				break;
			}
			{
			setState(181); 
			lawRefinement();
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

	public static class LawRefinementContext extends ParserRuleContext {
		public ZExprsContext zExprs() {
			return getRuleContext(ZExprsContext.class,0);
		}
		public List<RefinementContext> refinement() {
			return getRuleContexts(RefinementContext.class);
		}
		public RefinementContext refinement(int i) {
			return getRuleContext(RefinementContext.class,i);
		}
		public LawRefinementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lawRefinement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AtcalVisitor ) return ((AtcalVisitor<? extends T>)visitor).visitLawRefinement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LawRefinementContext lawRefinement() throws RecognitionException {
		LawRefinementContext _localctx = new LawRefinementContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_lawRefinement);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(183); 
			zExprs();
			setState(184); 
			match(T__29);
			setState(185); 
			refinement();
			setState(190);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(186); 
					match(T__17);
					setState(187); 
					refinement();
					}
					} 
				}
				setState(192);
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

	public static class ZExprsContext extends ParserRuleContext {
		public ZExprContext zExpr() {
			return getRuleContext(ZExprContext.class,0);
		}
		public ZExprsContext zExprs() {
			return getRuleContext(ZExprsContext.class,0);
		}
		public ZExprsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_zExprs; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AtcalVisitor ) return ((AtcalVisitor<? extends T>)visitor).visitZExprs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ZExprsContext zExprs() throws RecognitionException {
		ZExprsContext _localctx = new ZExprsContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_zExprs);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(193); 
			zExpr(0);
			setState(196);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				{
				setState(194); 
				match(T__29);
				setState(195); 
				zExprs();
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

	public static class RefinementContext extends ParserRuleContext {
		public RefinementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_refinement; }
	 
		public RefinementContext() { }
		public void copyFrom(RefinementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ImplRefContext extends RefinementContext {
		public LvalueContext lvalue() {
			return getRuleContext(LvalueContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ConstMappingContext constMapping() {
			return getRuleContext(ConstMappingContext.class,0);
		}
		public WithRefContext withRef() {
			return getRuleContext(WithRefContext.class,0);
		}
		public ImplRefContext(RefinementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AtcalVisitor ) return ((AtcalVisitor<? extends T>)visitor).visitImplRef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RefinementContext refinement() throws RecognitionException {
		RefinementContext _localctx = new RefinementContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_refinement);
		int _la;
		try {
			_localctx = new ImplRefContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(198); 
			lvalue();
			setState(199); 
			match(T__30);
			setState(200); 
			type();
			setState(202);
			_la = _input.LA(1);
			if (_la==T__21) {
				{
				setState(201); 
				constMapping();
				}
			}

			setState(205);
			_la = _input.LA(1);
			if (_la==T__32) {
				{
				setState(204); 
				withRef();
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

	public static class LvalueContext extends ParserRuleContext {
		public LvalueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lvalue; }
	 
		public LvalueContext() { }
		public void copyFrom(LvalueContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class VarLValueContext extends LvalueContext {
		public TerminalNode ID() { return getToken(AtcalParser.ID, 0); }
		public VarLValueContext(LvalueContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AtcalVisitor ) return ((AtcalVisitor<? extends T>)visitor).visitVarLValue(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrayLValueContext extends LvalueContext {
		public TerminalNode NUMBER() { return getToken(AtcalParser.NUMBER, 0); }
		public ArrayLValueContext(LvalueContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AtcalVisitor ) return ((AtcalVisitor<? extends T>)visitor).visitArrayLValue(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FieldLValueContext extends LvalueContext {
		public TerminalNode ID() { return getToken(AtcalParser.ID, 0); }
		public FieldLValueContext(LvalueContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AtcalVisitor ) return ((AtcalVisitor<? extends T>)visitor).visitFieldLValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LvalueContext lvalue() throws RecognitionException {
		LvalueContext _localctx = new LvalueContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_lvalue);
		int _la;
		try {
			setState(215);
			switch (_input.LA(1)) {
			case ID:
				_localctx = new VarLValueContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(207); 
				match(ID);
				}
				break;
			case T__22:
				_localctx = new ArrayLValueContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(208); 
				match(T__22);
				setState(210);
				_la = _input.LA(1);
				if (_la==NUMBER) {
					{
					setState(209); 
					match(NUMBER);
					}
				}

				setState(212); 
				match(T__23);
				}
				break;
			case T__31:
				_localctx = new FieldLValueContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(213); 
				match(T__31);
				setState(214); 
				match(ID);
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

	public static class WithRefContext extends ParserRuleContext {
		public List<LawRefinementContext> lawRefinement() {
			return getRuleContexts(LawRefinementContext.class);
		}
		public LawRefinementContext lawRefinement(int i) {
			return getRuleContext(LawRefinementContext.class,i);
		}
		public WithRefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_withRef; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AtcalVisitor ) return ((AtcalVisitor<? extends T>)visitor).visitWithRef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WithRefContext withRef() throws RecognitionException {
		WithRefContext _localctx = new WithRefContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_withRef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(217); 
			match(T__32);
			setState(218); 
			match(T__22);
			setState(219); 
			lawRefinement();
			setState(224);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__17) {
				{
				{
				setState(220); 
				match(T__17);
				setState(221); 
				lawRefinement();
				}
				}
				setState(226);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(227); 
			match(T__23);
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
		public ZExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_zExpr; }
	 
		public ZExprContext() { }
		public void copyFrom(ZExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class GroupContext extends ZExprContext {
		public ZExprContext zExpr() {
			return getRuleContext(ZExprContext.class,0);
		}
		public GroupContext(ZExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AtcalVisitor ) return ((AtcalVisitor<? extends T>)visitor).visitGroup(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NumModContext extends ZExprContext {
		public List<ZExprContext> zExpr() {
			return getRuleContexts(ZExprContext.class);
		}
		public ZExprContext zExpr(int i) {
			return getRuleContext(ZExprContext.class,i);
		}
		public TerminalNode MOD() { return getToken(AtcalParser.MOD, 0); }
		public NumModContext(ZExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AtcalVisitor ) return ((AtcalVisitor<? extends T>)visitor).visitNumMod(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ProdProjContext extends ZExprContext {
		public ZExprContext zExpr() {
			return getRuleContext(ZExprContext.class,0);
		}
		public TerminalNode TUPPROJ() { return getToken(AtcalParser.TUPPROJ, 0); }
		public ProdProjContext(ZExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AtcalVisitor ) return ((AtcalVisitor<? extends T>)visitor).visitProdProj(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IdentContext extends ZExprContext {
		public TerminalNode ID() { return getToken(AtcalParser.ID, 0); }
		public IdentContext(ZExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AtcalVisitor ) return ((AtcalVisitor<? extends T>)visitor).visitIdent(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NumMulContext extends ZExprContext {
		public List<ZExprContext> zExpr() {
			return getRuleContexts(ZExprContext.class);
		}
		public ZExprContext zExpr(int i) {
			return getRuleContext(ZExprContext.class,i);
		}
		public TerminalNode MUL() { return getToken(AtcalParser.MUL, 0); }
		public NumMulContext(ZExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AtcalVisitor ) return ((AtcalVisitor<? extends T>)visitor).visitNumMul(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SetDiffContext extends ZExprContext {
		public List<ZExprContext> zExpr() {
			return getRuleContexts(ZExprContext.class);
		}
		public ZExprContext zExpr(int i) {
			return getRuleContext(ZExprContext.class,i);
		}
		public TerminalNode DIFF() { return getToken(AtcalParser.DIFF, 0); }
		public SetDiffContext(ZExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AtcalVisitor ) return ((AtcalVisitor<? extends T>)visitor).visitSetDiff(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StrConcatContext extends ZExprContext {
		public List<ZExprContext> zExpr() {
			return getRuleContexts(ZExprContext.class);
		}
		public ZExprContext zExpr(int i) {
			return getRuleContext(ZExprContext.class,i);
		}
		public StrConcatContext(ZExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AtcalVisitor ) return ((AtcalVisitor<? extends T>)visitor).visitStrConcat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ProdConsContext extends ZExprContext {
		public List<ZExprContext> zExpr() {
			return getRuleContexts(ZExprContext.class);
		}
		public ZExprContext zExpr(int i) {
			return getRuleContext(ZExprContext.class,i);
		}
		public ProdConsContext(ZExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AtcalVisitor ) return ((AtcalVisitor<? extends T>)visitor).visitProdCons(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SetUnionContext extends ZExprContext {
		public List<ZExprContext> zExpr() {
			return getRuleContexts(ZExprContext.class);
		}
		public ZExprContext zExpr(int i) {
			return getRuleContext(ZExprContext.class,i);
		}
		public TerminalNode UNION() { return getToken(AtcalParser.UNION, 0); }
		public SetUnionContext(ZExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AtcalVisitor ) return ((AtcalVisitor<? extends T>)visitor).visitSetUnion(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SetDomContext extends ZExprContext {
		public ZExprContext zExpr() {
			return getRuleContext(ZExprContext.class,0);
		}
		public TerminalNode DOM() { return getToken(AtcalParser.DOM, 0); }
		public SetDomContext(ZExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AtcalVisitor ) return ((AtcalVisitor<? extends T>)visitor).visitSetDom(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ElemExprContext extends ZExprContext {
		public TerminalNode ELEM() { return getToken(AtcalParser.ELEM, 0); }
		public ElemExprContext(ZExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AtcalVisitor ) return ((AtcalVisitor<? extends T>)visitor).visitElemExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NumLiteralContext extends ZExprContext {
		public TerminalNode NUMBER() { return getToken(AtcalParser.NUMBER, 0); }
		public NumLiteralContext(ZExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AtcalVisitor ) return ((AtcalVisitor<? extends T>)visitor).visitNumLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NumMinusContext extends ZExprContext {
		public List<ZExprContext> zExpr() {
			return getRuleContexts(ZExprContext.class);
		}
		public ZExprContext zExpr(int i) {
			return getRuleContext(ZExprContext.class,i);
		}
		public TerminalNode MINUS() { return getToken(AtcalParser.MINUS, 0); }
		public NumMinusContext(ZExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AtcalVisitor ) return ((AtcalVisitor<? extends T>)visitor).visitNumMinus(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StrLiteralContext extends ZExprContext {
		public TerminalNode STRING() { return getToken(AtcalParser.STRING, 0); }
		public StrLiteralContext(ZExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AtcalVisitor ) return ((AtcalVisitor<? extends T>)visitor).visitStrLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AutoExprContext extends ZExprContext {
		public TerminalNode AUTO() { return getToken(AtcalParser.AUTO, 0); }
		public AutoExprContext(ZExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AtcalVisitor ) return ((AtcalVisitor<? extends T>)visitor).visitAutoExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SetConsContext extends ZExprContext {
		public List<ZExprContext> zExpr() {
			return getRuleContexts(ZExprContext.class);
		}
		public ZExprContext zExpr(int i) {
			return getRuleContext(ZExprContext.class,i);
		}
		public SetConsContext(ZExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AtcalVisitor ) return ((AtcalVisitor<? extends T>)visitor).visitSetCons(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NumPlusContext extends ZExprContext {
		public List<ZExprContext> zExpr() {
			return getRuleContexts(ZExprContext.class);
		}
		public ZExprContext zExpr(int i) {
			return getRuleContext(ZExprContext.class,i);
		}
		public TerminalNode PLUS() { return getToken(AtcalParser.PLUS, 0); }
		public NumPlusContext(ZExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AtcalVisitor ) return ((AtcalVisitor<? extends T>)visitor).visitNumPlus(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SetElemContext extends ZExprContext {
		public ZExprContext zExpr() {
			return getRuleContext(ZExprContext.class,0);
		}
		public TerminalNode NUMBER() { return getToken(AtcalParser.NUMBER, 0); }
		public SetElemContext(ZExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AtcalVisitor ) return ((AtcalVisitor<? extends T>)visitor).visitSetElem(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SetCardContext extends ZExprContext {
		public ZExprContext zExpr() {
			return getRuleContext(ZExprContext.class,0);
		}
		public TerminalNode CARD() { return getToken(AtcalParser.CARD, 0); }
		public SetCardContext(ZExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AtcalVisitor ) return ((AtcalVisitor<? extends T>)visitor).visitSetCard(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NumDivContext extends ZExprContext {
		public List<ZExprContext> zExpr() {
			return getRuleContexts(ZExprContext.class);
		}
		public ZExprContext zExpr(int i) {
			return getRuleContext(ZExprContext.class,i);
		}
		public TerminalNode DIV() { return getToken(AtcalParser.DIV, 0); }
		public NumDivContext(ZExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AtcalVisitor ) return ((AtcalVisitor<? extends T>)visitor).visitNumDiv(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SetProjContext extends ZExprContext {
		public ZExprContext zExpr() {
			return getRuleContext(ZExprContext.class,0);
		}
		public TerminalNode PROJ() { return getToken(AtcalParser.PROJ, 0); }
		public SetProjContext(ZExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AtcalVisitor ) return ((AtcalVisitor<? extends T>)visitor).visitSetProj(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SetRanContext extends ZExprContext {
		public ZExprContext zExpr() {
			return getRuleContext(ZExprContext.class,0);
		}
		public TerminalNode RAN() { return getToken(AtcalParser.RAN, 0); }
		public SetRanContext(ZExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AtcalVisitor ) return ((AtcalVisitor<? extends T>)visitor).visitSetRan(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SetInterContext extends ZExprContext {
		public List<ZExprContext> zExpr() {
			return getRuleContexts(ZExprContext.class);
		}
		public ZExprContext zExpr(int i) {
			return getRuleContext(ZExprContext.class,i);
		}
		public TerminalNode INTER() { return getToken(AtcalParser.INTER, 0); }
		public SetInterContext(ZExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AtcalVisitor ) return ((AtcalVisitor<? extends T>)visitor).visitSetInter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ZExprContext zExpr() throws RecognitionException {
		return zExpr(0);
	}

	private ZExprContext zExpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ZExprContext _localctx = new ZExprContext(_ctx, _parentState);
		ZExprContext _prevctx = _localctx;
		int _startState = 36;
		enterRecursionRule(_localctx, 36, RULE_zExpr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(261);
			switch (_input.LA(1)) {
			case ID:
				{
				_localctx = new IdentContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(230); 
				match(ID);
				}
				break;
			case NUMBER:
				{
				_localctx = new NumLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(231); 
				match(NUMBER);
				}
				break;
			case STRING:
				{
				_localctx = new StrLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(232); 
				match(STRING);
				}
				break;
			case AUTO:
				{
				_localctx = new AutoExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(233); 
				match(AUTO);
				}
				break;
			case ELEM:
				{
				_localctx = new ElemExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(234); 
				match(ELEM);
				}
				break;
			case T__33:
				{
				_localctx = new ProdConsContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(235); 
				match(T__33);
				setState(236); 
				zExpr(0);
				setState(241);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__17) {
					{
					{
					setState(237); 
					match(T__17);
					setState(238); 
					zExpr(0);
					}
					}
					setState(243);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(244); 
				match(T__34);
				}
				break;
			case T__35:
				{
				_localctx = new SetConsContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(246); 
				match(T__35);
				setState(247); 
				zExpr(0);
				setState(252);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__17) {
					{
					{
					setState(248); 
					match(T__17);
					setState(249); 
					zExpr(0);
					}
					}
					setState(254);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(255); 
				match(T__36);
				}
				break;
			case T__12:
				{
				_localctx = new GroupContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(257); 
				match(T__12);
				setState(258); 
				zExpr(0);
				setState(259); 
				match(T__13);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(310);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(308);
					switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
					case 1:
						{
						_localctx = new SetInterContext(new ZExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_zExpr);
						setState(263);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(264); 
						match(INTER);
						setState(265); 
						zExpr(13);
						}
						break;
					case 2:
						{
						_localctx = new SetUnionContext(new ZExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_zExpr);
						setState(266);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(267); 
						match(UNION);
						setState(268); 
						zExpr(12);
						}
						break;
					case 3:
						{
						_localctx = new SetDiffContext(new ZExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_zExpr);
						setState(269);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(270); 
						match(DIFF);
						setState(271); 
						zExpr(11);
						}
						break;
					case 4:
						{
						_localctx = new NumMulContext(new ZExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_zExpr);
						setState(272);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(273); 
						match(MUL);
						setState(274); 
						zExpr(8);
						}
						break;
					case 5:
						{
						_localctx = new NumDivContext(new ZExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_zExpr);
						setState(275);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(276); 
						match(DIV);
						setState(277); 
						zExpr(7);
						}
						break;
					case 6:
						{
						_localctx = new NumModContext(new ZExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_zExpr);
						setState(278);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(279); 
						match(MOD);
						setState(280); 
						zExpr(6);
						}
						break;
					case 7:
						{
						_localctx = new NumPlusContext(new ZExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_zExpr);
						setState(281);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(282); 
						match(PLUS);
						setState(283); 
						zExpr(5);
						}
						break;
					case 8:
						{
						_localctx = new NumMinusContext(new ZExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_zExpr);
						setState(284);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(285); 
						match(MINUS);
						setState(286); 
						zExpr(4);
						}
						break;
					case 9:
						{
						_localctx = new StrConcatContext(new ZExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_zExpr);
						setState(287);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(288); 
						match(T__37);
						setState(289); 
						zExpr(3);
						}
						break;
					case 10:
						{
						_localctx = new ProdProjContext(new ZExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_zExpr);
						setState(290);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(291); 
						match(T__31);
						setState(292); 
						match(TUPPROJ);
						}
						break;
					case 11:
						{
						_localctx = new SetElemContext(new ZExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_zExpr);
						setState(293);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(294); 
						match(T__31);
						setState(295); 
						match(NUMBER);
						}
						break;
					case 12:
						{
						_localctx = new SetDomContext(new ZExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_zExpr);
						setState(296);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(297); 
						match(T__31);
						setState(298); 
						match(DOM);
						}
						break;
					case 13:
						{
						_localctx = new SetRanContext(new ZExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_zExpr);
						setState(299);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(300); 
						match(T__31);
						setState(301); 
						match(RAN);
						}
						break;
					case 14:
						{
						_localctx = new SetProjContext(new ZExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_zExpr);
						setState(302);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(303); 
						match(T__31);
						setState(304); 
						match(PROJ);
						}
						break;
					case 15:
						{
						_localctx = new SetCardContext(new ZExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_zExpr);
						setState(305);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(306); 
						match(T__31);
						setState(307); 
						match(CARD);
						}
						break;
					}
					} 
				}
				setState(312);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
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
		case 18: 
			return zExpr_sempred((ZExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean zExpr_sempred(ZExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: 
			return precpred(_ctx, 12);
		case 1: 
			return precpred(_ctx, 11);
		case 2: 
			return precpred(_ctx, 10);
		case 3: 
			return precpred(_ctx, 7);
		case 4: 
			return precpred(_ctx, 6);
		case 5: 
			return precpred(_ctx, 5);
		case 6: 
			return precpred(_ctx, 4);
		case 7: 
			return precpred(_ctx, 3);
		case 8: 
			return precpred(_ctx, 2);
		case 9: 
			return precpred(_ctx, 18);
		case 10: 
			return precpred(_ctx, 16);
		case 11: 
			return precpred(_ctx, 15);
		case 12: 
			return precpred(_ctx, 14);
		case 13: 
			return precpred(_ctx, 13);
		case 14: 
			return precpred(_ctx, 8);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3<\u013c\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\3\2\3\2\3\2\5\2,\n\2\3\2\5\2/\n\2\3\2\3\2\5\2\63"+
		"\n\2\3\2\3\2\5\2\67\n\2\3\3\3\3\3\3\3\3\3\3\6\3>\n\3\r\3\16\3?\3\4\3\4"+
		"\7\4D\n\4\f\4\16\4G\13\4\3\4\3\4\3\5\3\5\6\5M\n\5\r\5\16\5N\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7n\n\7\f\7\16\7q\13\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\177\n\7\3\b\3\b\3\b\3\b\7\b"+
		"\u0085\n\b\f\b\16\b\u0088\13\b\5\b\u008a\n\b\3\b\3\b\3\t\3\t\3\t\3\t\3"+
		"\t\7\t\u0093\n\t\f\t\16\t\u0096\13\t\3\t\3\t\3\n\3\n\3\n\3\n\3\13\3\13"+
		"\3\13\3\13\7\13\u00a2\n\13\f\13\16\13\u00a5\13\13\3\f\3\f\3\f\3\f\3\f"+
		"\3\r\3\r\3\r\3\r\6\r\u00b0\n\r\r\r\16\r\u00b1\3\16\3\16\5\16\u00b6\n\16"+
		"\3\16\3\16\3\17\3\17\3\17\3\17\3\17\7\17\u00bf\n\17\f\17\16\17\u00c2\13"+
		"\17\3\20\3\20\3\20\5\20\u00c7\n\20\3\21\3\21\3\21\3\21\5\21\u00cd\n\21"+
		"\3\21\5\21\u00d0\n\21\3\22\3\22\3\22\5\22\u00d5\n\22\3\22\3\22\3\22\5"+
		"\22\u00da\n\22\3\23\3\23\3\23\3\23\3\23\7\23\u00e1\n\23\f\23\16\23\u00e4"+
		"\13\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\7\24"+
		"\u00f2\n\24\f\24\16\24\u00f5\13\24\3\24\3\24\3\24\3\24\3\24\3\24\7\24"+
		"\u00fd\n\24\f\24\16\24\u0100\13\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24"+
		"\u0108\n\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\7\24\u0137\n\24\f\24\16\24\u013a\13\24\3\24"+
		"\3E\3&\25\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&\2\3\4\2*+;;\u015f"+
		"\2(\3\2\2\2\48\3\2\2\2\6A\3\2\2\2\bJ\3\2\2\2\nP\3\2\2\2\f~\3\2\2\2\16"+
		"\u0080\3\2\2\2\20\u008d\3\2\2\2\22\u0099\3\2\2\2\24\u009d\3\2\2\2\26\u00a6"+
		"\3\2\2\2\30\u00ab\3\2\2\2\32\u00b5\3\2\2\2\34\u00b9\3\2\2\2\36\u00c3\3"+
		"\2\2\2 \u00c8\3\2\2\2\"\u00d9\3\2\2\2$\u00db\3\2\2\2&\u0107\3\2\2\2()"+
		"\7\3\2\2)+\7*\2\2*,\5\4\3\2+*\3\2\2\2+,\3\2\2\2,.\3\2\2\2-/\5\b\5\2.-"+
		"\3\2\2\2./\3\2\2\2/\60\3\2\2\2\60\62\5\24\13\2\61\63\5\6\4\2\62\61\3\2"+
		"\2\2\62\63\3\2\2\2\63\64\3\2\2\2\64\66\5\26\f\2\65\67\5\30\r\2\66\65\3"+
		"\2\2\2\66\67\3\2\2\2\67\3\3\2\2\28=\7\4\2\29>\5\6\4\2:;\7*\2\2;<\7\5\2"+
		"\2<>\7)\2\2=9\3\2\2\2=:\3\2\2\2>?\3\2\2\2?=\3\2\2\2?@\3\2\2\2@\5\3\2\2"+
		"\2AE\7\6\2\2BD\13\2\2\2CB\3\2\2\2DG\3\2\2\2EF\3\2\2\2EC\3\2\2\2FH\3\2"+
		"\2\2GE\3\2\2\2HI\7\7\2\2I\7\3\2\2\2JL\7\b\2\2KM\5\n\6\2LK\3\2\2\2MN\3"+
		"\2\2\2NL\3\2\2\2NO\3\2\2\2O\t\3\2\2\2PQ\7\t\2\2QR\7*\2\2RS\7\n\2\2ST\5"+
		"\f\7\2TU\7)\2\2U\13\3\2\2\2V\177\7*\2\2W\177\7\13\2\2X\177\7\f\2\2Y\177"+
		"\7\r\2\2Z[\7\16\2\2[\\\5\f\7\2\\]\7\17\2\2]^\7+\2\2^_\7\20\2\2_\177\3"+
		"\2\2\2`a\7\21\2\2ab\7*\2\2b\177\5\16\b\2cd\7\22\2\2de\7*\2\2ef\7\17\2"+
		"\2fg\7*\2\2gh\7\23\2\2ho\5\f\7\2ij\7\24\2\2jk\7*\2\2kl\7\23\2\2ln\5\f"+
		"\7\2mi\3\2\2\2nq\3\2\2\2om\3\2\2\2op\3\2\2\2pr\3\2\2\2qo\3\2\2\2rs\7\20"+
		"\2\2s\177\3\2\2\2tu\7\25\2\2uv\7*\2\2vw\5\16\b\2wx\7\26\2\2xy\7*\2\2y"+
		"z\5\16\b\2z{\7\27\2\2{|\7*\2\2|}\5\16\b\2}\177\3\2\2\2~V\3\2\2\2~W\3\2"+
		"\2\2~X\3\2\2\2~Y\3\2\2\2~Z\3\2\2\2~`\3\2\2\2~c\3\2\2\2~t\3\2\2\2\177\r"+
		"\3\2\2\2\u0080\u0089\7\17\2\2\u0081\u0086\7*\2\2\u0082\u0083\7\24\2\2"+
		"\u0083\u0085\7*\2\2\u0084\u0082\3\2\2\2\u0085\u0088\3\2\2\2\u0086\u0084"+
		"\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u008a\3\2\2\2\u0088\u0086\3\2\2\2\u0089"+
		"\u0081\3\2\2\2\u0089\u008a\3\2\2\2\u008a\u008b\3\2\2\2\u008b\u008c\7\20"+
		"\2\2\u008c\17\3\2\2\2\u008d\u008e\7\30\2\2\u008e\u008f\7\31\2\2\u008f"+
		"\u0094\5\22\n\2\u0090\u0091\7\24\2\2\u0091\u0093\5\22\n\2\u0092\u0090"+
		"\3\2\2\2\u0093\u0096\3\2\2\2\u0094\u0092\3\2\2\2\u0094\u0095\3\2\2\2\u0095"+
		"\u0097\3\2\2\2\u0096\u0094\3\2\2\2\u0097\u0098\7\32\2\2\u0098\21\3\2\2"+
		"\2\u0099\u009a\7*\2\2\u009a\u009b\7\33\2\2\u009b\u009c\t\2\2\2\u009c\23"+
		"\3\2\2\2\u009d\u00a3\7\34\2\2\u009e\u009f\5\32\16\2\u009f\u00a0\7)\2\2"+
		"\u00a0\u00a2\3\2\2\2\u00a1\u009e\3\2\2\2\u00a2\u00a5\3\2\2\2\u00a3\u00a1"+
		"\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\25\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a6"+
		"\u00a7\7\35\2\2\u00a7\u00a8\7*\2\2\u00a8\u00a9\5\16\b\2\u00a9\u00aa\7"+
		")\2\2\u00aa\27\3\2\2\2\u00ab\u00af\7\36\2\2\u00ac\u00b0\5\6\4\2\u00ad"+
		"\u00ae\7*\2\2\u00ae\u00b0\7\37\2\2\u00af\u00ac\3\2\2\2\u00af\u00ad\3\2"+
		"\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00af\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2"+
		"\31\3\2\2\2\u00b3\u00b4\7*\2\2\u00b4\u00b6\7\23\2\2\u00b5\u00b3\3\2\2"+
		"\2\u00b5\u00b6\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00b8\5\34\17\2\u00b8"+
		"\33\3\2\2\2\u00b9\u00ba\5\36\20\2\u00ba\u00bb\7 \2\2\u00bb\u00c0\5 \21"+
		"\2\u00bc\u00bd\7\24\2\2\u00bd\u00bf\5 \21\2\u00be\u00bc\3\2\2\2\u00bf"+
		"\u00c2\3\2\2\2\u00c0\u00be\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1\35\3\2\2"+
		"\2\u00c2\u00c0\3\2\2\2\u00c3\u00c6\5&\24\2\u00c4\u00c5\7 \2\2\u00c5\u00c7"+
		"\5\36\20\2\u00c6\u00c4\3\2\2\2\u00c6\u00c7\3\2\2\2\u00c7\37\3\2\2\2\u00c8"+
		"\u00c9\5\"\22\2\u00c9\u00ca\7!\2\2\u00ca\u00cc\5\f\7\2\u00cb\u00cd\5\20"+
		"\t\2\u00cc\u00cb\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cd\u00cf\3\2\2\2\u00ce"+
		"\u00d0\5$\23\2\u00cf\u00ce\3\2\2\2\u00cf\u00d0\3\2\2\2\u00d0!\3\2\2\2"+
		"\u00d1\u00da\7*\2\2\u00d2\u00d4\7\31\2\2\u00d3\u00d5\7+\2\2\u00d4\u00d3"+
		"\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6\u00da\7\32\2\2"+
		"\u00d7\u00d8\7\"\2\2\u00d8\u00da\7*\2\2\u00d9\u00d1\3\2\2\2\u00d9\u00d2"+
		"\3\2\2\2\u00d9\u00d7\3\2\2\2\u00da#\3\2\2\2\u00db\u00dc\7#\2\2\u00dc\u00dd"+
		"\7\31\2\2\u00dd\u00e2\5\34\17\2\u00de\u00df\7\24\2\2\u00df\u00e1\5\34"+
		"\17\2\u00e0\u00de\3\2\2\2\u00e1\u00e4\3\2\2\2\u00e2\u00e0\3\2\2\2\u00e2"+
		"\u00e3\3\2\2\2\u00e3\u00e5\3\2\2\2\u00e4\u00e2\3\2\2\2\u00e5\u00e6\7\32"+
		"\2\2\u00e6%\3\2\2\2\u00e7\u00e8\b\24\1\2\u00e8\u0108\7*\2\2\u00e9\u0108"+
		"\7+\2\2\u00ea\u0108\7;\2\2\u00eb\u0108\79\2\2\u00ec\u0108\78\2\2\u00ed"+
		"\u00ee\7$\2\2\u00ee\u00f3\5&\24\2\u00ef\u00f0\7\24\2\2\u00f0\u00f2\5&"+
		"\24\2\u00f1\u00ef\3\2\2\2\u00f2\u00f5\3\2\2\2\u00f3\u00f1\3\2\2\2\u00f3"+
		"\u00f4\3\2\2\2\u00f4\u00f6\3\2\2\2\u00f5\u00f3\3\2\2\2\u00f6\u00f7\7%"+
		"\2\2\u00f7\u0108\3\2\2\2\u00f8\u00f9\7&\2\2\u00f9\u00fe\5&\24\2\u00fa"+
		"\u00fb\7\24\2\2\u00fb\u00fd\5&\24\2\u00fc\u00fa\3\2\2\2\u00fd\u0100\3"+
		"\2\2\2\u00fe\u00fc\3\2\2\2\u00fe\u00ff\3\2\2\2\u00ff\u0101\3\2\2\2\u0100"+
		"\u00fe\3\2\2\2\u0101\u0102\7\'\2\2\u0102\u0108\3\2\2\2\u0103\u0104\7\17"+
		"\2\2\u0104\u0105\5&\24\2\u0105\u0106\7\20\2\2\u0106\u0108\3\2\2\2\u0107"+
		"\u00e7\3\2\2\2\u0107\u00e9\3\2\2\2\u0107\u00ea\3\2\2\2\u0107\u00eb\3\2"+
		"\2\2\u0107\u00ec\3\2\2\2\u0107\u00ed\3\2\2\2\u0107\u00f8\3\2\2\2\u0107"+
		"\u0103\3\2\2\2\u0108\u0138\3\2\2\2\u0109\u010a\f\16\2\2\u010a\u010b\7"+
		"\65\2\2\u010b\u0137\5&\24\17\u010c\u010d\f\r\2\2\u010d\u010e\7\66\2\2"+
		"\u010e\u0137\5&\24\16\u010f\u0110\f\f\2\2\u0110\u0111\7\67\2\2\u0111\u0137"+
		"\5&\24\r\u0112\u0113\f\t\2\2\u0113\u0114\7.\2\2\u0114\u0137\5&\24\n\u0115"+
		"\u0116\f\b\2\2\u0116\u0117\7/\2\2\u0117\u0137\5&\24\t\u0118\u0119\f\7"+
		"\2\2\u0119\u011a\7\60\2\2\u011a\u0137\5&\24\b\u011b\u011c\f\6\2\2\u011c"+
		"\u011d\7,\2\2\u011d\u0137\5&\24\7\u011e\u011f\f\5\2\2\u011f\u0120\7-\2"+
		"\2\u0120\u0137\5&\24\6\u0121\u0122\f\4\2\2\u0122\u0123\7(\2\2\u0123\u0137"+
		"\5&\24\5\u0124\u0125\f\24\2\2\u0125\u0126\7\"\2\2\u0126\u0137\7\64\2\2"+
		"\u0127\u0128\f\22\2\2\u0128\u0129\7\"\2\2\u0129\u0137\7+\2\2\u012a\u012b"+
		"\f\21\2\2\u012b\u012c\7\"\2\2\u012c\u0137\7\61\2\2\u012d\u012e\f\20\2"+
		"\2\u012e\u012f\7\"\2\2\u012f\u0137\7\62\2\2\u0130\u0131\f\17\2\2\u0131"+
		"\u0132\7\"\2\2\u0132\u0137\7\63\2\2\u0133\u0134\f\n\2\2\u0134\u0135\7"+
		"\"\2\2\u0135\u0137\7:\2\2\u0136\u0109\3\2\2\2\u0136\u010c\3\2\2\2\u0136"+
		"\u010f\3\2\2\2\u0136\u0112\3\2\2\2\u0136\u0115\3\2\2\2\u0136\u0118\3\2"+
		"\2\2\u0136\u011b\3\2\2\2\u0136\u011e\3\2\2\2\u0136\u0121\3\2\2\2\u0136"+
		"\u0124\3\2\2\2\u0136\u0127\3\2\2\2\u0136\u012a\3\2\2\2\u0136\u012d\3\2"+
		"\2\2\u0136\u0130\3\2\2\2\u0136\u0133\3\2\2\2\u0137\u013a\3\2\2\2\u0138"+
		"\u0136\3\2\2\2\u0138\u0139\3\2\2\2\u0139\'\3\2\2\2\u013a\u0138\3\2\2\2"+
		"\37+.\62\66=?ENo~\u0086\u0089\u0094\u00a3\u00af\u00b1\u00b5\u00c0\u00c6"+
		"\u00cc\u00cf\u00d4\u00d9\u00e2\u00f3\u00fe\u0107\u0136\u0138";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}