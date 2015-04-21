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
		DOM=47, RAN=48, PROJ=49, TUPPROJ=50, INTER=51, UNION=52, DIFF=53, STRING=54, 
		WS=55;
	public static final int
		RULE_refinementRule = 0, RULE_preamble = 1, RULE_plcode = 2, RULE_preambleImport = 3, 
		RULE_datatypes = 4, RULE_type = 5, RULE_aliasType = 6, RULE_recordType = 7, 
		RULE_arrayType = 8, RULE_contractType = 9, RULE_enumType = 10, RULE_intType = 11, 
		RULE_floatType = 12, RULE_stringType = 13, RULE_typeCases = 14, RULE_typeCase = 15, 
		RULE_laws = 16, RULE_uut = 17, RULE_epilogue = 18, RULE_law = 19, RULE_lawRefinement = 20, 
		RULE_refinement = 21, RULE_zExpr = 22;
	public static final String[] ruleNames = {
		"refinementRule", "preamble", "plcode", "preambleImport", "datatypes", 
		"type", "aliasType", "recordType", "arrayType", "contractType", "enumType", 
		"intType", "floatType", "stringType", "typeCases", "typeCase", "laws", 
		"uut", "epilogue", "law", "lawRefinement", "refinement", "zExpr"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'@RRULE'", "'@PREAMBLE'", "'@PLCODE'", "'.@PREAMBLE'", "'@DATATYPES'", 
		"'DATATYPE'", "'='", "'RECORD'", "'('", "','", "')'", "'ARRAY'", "'CONSTRUCTOR'", 
		"'SETTER'", "'ENUM'", "'INT'", "'FLOAT'", "'STRING'", "'CASES'", "'['", 
		"']'", "'->'", "'@LAWS'", "'@UUT'", "'@EPILOGUE'", "'.@EPILOGUE'", "':'", 
		"'==>'", "'AS'", "'WITH'", "'@AUTOFILL'", "'.'", "'<'", "'>'", "'{'", 
		"'}'", "'.@CARD'", "'++'", null, null, null, "'+'", "'-'", "'*'", "'/'", 
		"'%'", "'@DOM'", "'@RAN'", null, null, "'/\\'", "'\\/'", "'~'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, "STMTEND", "ID", "NUMBER", "PLUS", "MINUS", "MUL", "DIV", 
		"MOD", "DOM", "RAN", "PROJ", "TUPPROJ", "INTER", "UNION", "DIFF", "STRING", 
		"WS"
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
		public PreambleContext preamble() {
			return getRuleContext(PreambleContext.class,0);
		}
		public LawsContext laws() {
			return getRuleContext(LawsContext.class,0);
		}
		public UutContext uut() {
			return getRuleContext(UutContext.class,0);
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
			setState(46); 
			match(T__0);
			setState(47); 
			match(ID);
			setState(48); 
			preamble();
			setState(50);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(49); 
				datatypes();
				}
			}

			setState(52); 
			laws();
			setState(54);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(53); 
				plcode();
				}
			}

			setState(56); 
			uut();
			setState(58);
			_la = _input.LA(1);
			if (_la==T__24) {
				{
				setState(57); 
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
		public List<PreambleImportContext> preambleImport() {
			return getRuleContexts(PreambleImportContext.class);
		}
		public PreambleImportContext preambleImport(int i) {
			return getRuleContext(PreambleImportContext.class,i);
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
			setState(60); 
			match(T__1);
			setState(63); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(63);
				switch (_input.LA(1)) {
				case T__2:
					{
					setState(61); 
					plcode();
					}
					break;
				case ID:
					{
					setState(62); 
					preambleImport();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(65); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__2 || _la==ID );
			}
		}
		catch (RecognitionException re) {
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
			enterOuterAlt(_localctx, 1);
			{
			setState(67); 
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PreambleImportContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(AtcalParser.ID, 0); }
		public TerminalNode STMTEND() { return getToken(AtcalParser.STMTEND, 0); }
		public PreambleImportContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_preambleImport; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AtcalVisitor ) return ((AtcalVisitor<? extends T>)visitor).visitPreambleImport(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PreambleImportContext preambleImport() throws RecognitionException {
		PreambleImportContext _localctx = new PreambleImportContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_preambleImport);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69); 
			match(ID);
			setState(70); 
			match(T__3);
			setState(71); 
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

	public static class DatatypesContext extends ParserRuleContext {
		public List<AliasTypeContext> aliasType() {
			return getRuleContexts(AliasTypeContext.class);
		}
		public AliasTypeContext aliasType(int i) {
			return getRuleContext(AliasTypeContext.class,i);
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
		enterRule(_localctx, 8, RULE_datatypes);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73); 
			match(T__4);
			setState(77);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__5) {
				{
				{
				setState(74); 
				aliasType();
				}
				}
				setState(79);
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

	public static class TypeContext extends ParserRuleContext {
		public RecordTypeContext recordType() {
			return getRuleContext(RecordTypeContext.class,0);
		}
		public ArrayTypeContext arrayType() {
			return getRuleContext(ArrayTypeContext.class,0);
		}
		public EnumTypeContext enumType() {
			return getRuleContext(EnumTypeContext.class,0);
		}
		public ContractTypeContext contractType() {
			return getRuleContext(ContractTypeContext.class,0);
		}
		public AliasTypeContext aliasType() {
			return getRuleContext(AliasTypeContext.class,0);
		}
		public IntTypeContext intType() {
			return getRuleContext(IntTypeContext.class,0);
		}
		public FloatTypeContext floatType() {
			return getRuleContext(FloatTypeContext.class,0);
		}
		public StringTypeContext stringType() {
			return getRuleContext(StringTypeContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AtcalVisitor ) return ((AtcalVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_type);
		try {
			setState(88);
			switch (_input.LA(1)) {
			case T__7:
				enterOuterAlt(_localctx, 1);
				{
				setState(80); 
				recordType();
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 2);
				{
				setState(81); 
				arrayType();
				}
				break;
			case T__14:
				enterOuterAlt(_localctx, 3);
				{
				setState(82); 
				enumType();
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 4);
				{
				setState(83); 
				contractType();
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 5);
				{
				setState(84); 
				aliasType();
				}
				break;
			case T__15:
				enterOuterAlt(_localctx, 6);
				{
				setState(85); 
				intType();
				}
				break;
			case T__16:
				enterOuterAlt(_localctx, 7);
				{
				setState(86); 
				floatType();
				}
				break;
			case T__17:
				enterOuterAlt(_localctx, 8);
				{
				setState(87); 
				stringType();
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

	public static class AliasTypeContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(AtcalParser.ID, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode STMTEND() { return getToken(AtcalParser.STMTEND, 0); }
		public AliasTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aliasType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AtcalVisitor ) return ((AtcalVisitor<? extends T>)visitor).visitAliasType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AliasTypeContext aliasType() throws RecognitionException {
		AliasTypeContext _localctx = new AliasTypeContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_aliasType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90); 
			match(T__5);
			setState(91); 
			match(ID);
			setState(92); 
			match(T__6);
			setState(93); 
			type();
			setState(94); 
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

	public static class RecordTypeContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(AtcalParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(AtcalParser.ID, i);
		}
		public RecordTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_recordType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AtcalVisitor ) return ((AtcalVisitor<? extends T>)visitor).visitRecordType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RecordTypeContext recordType() throws RecognitionException {
		RecordTypeContext _localctx = new RecordTypeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_recordType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96); 
			match(T__7);
			setState(97); 
			match(ID);
			setState(98); 
			match(T__8);
			setState(107);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(99); 
				match(ID);
				setState(104);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__9) {
					{
					{
					setState(100); 
					match(T__9);
					setState(101); 
					match(ID);
					}
					}
					setState(106);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(109); 
			match(T__10);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayTypeContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(AtcalParser.ID, 0); }
		public TerminalNode NUMBER() { return getToken(AtcalParser.NUMBER, 0); }
		public ArrayTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AtcalVisitor ) return ((AtcalVisitor<? extends T>)visitor).visitArrayType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayTypeContext arrayType() throws RecognitionException {
		ArrayTypeContext _localctx = new ArrayTypeContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_arrayType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111); 
			match(T__11);
			setState(112); 
			match(ID);
			setState(113); 
			match(T__8);
			setState(114); 
			match(NUMBER);
			setState(115); 
			match(T__10);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ContractTypeContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(AtcalParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(AtcalParser.ID, i);
		}
		public ContractTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_contractType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AtcalVisitor ) return ((AtcalVisitor<? extends T>)visitor).visitContractType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ContractTypeContext contractType() throws RecognitionException {
		ContractTypeContext _localctx = new ContractTypeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_contractType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(117); 
			match(T__12);
			setState(118); 
			match(ID);
			setState(119); 
			match(T__8);
			setState(128);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(120); 
				match(ID);
				setState(125);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__9) {
					{
					{
					setState(121); 
					match(T__9);
					setState(122); 
					match(ID);
					}
					}
					setState(127);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(130); 
			match(T__10);
			setState(131); 
			match(T__13);
			setState(132); 
			match(ID);
			setState(133); 
			match(T__8);
			setState(142);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(134); 
				match(ID);
				setState(139);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__9) {
					{
					{
					setState(135); 
					match(T__9);
					setState(136); 
					match(ID);
					}
					}
					setState(141);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(144); 
			match(T__10);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EnumTypeContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(AtcalParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(AtcalParser.ID, i);
		}
		public EnumTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AtcalVisitor ) return ((AtcalVisitor<? extends T>)visitor).visitEnumType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnumTypeContext enumType() throws RecognitionException {
		EnumTypeContext _localctx = new EnumTypeContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_enumType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146); 
			match(T__14);
			setState(147); 
			match(ID);
			setState(148); 
			match(T__8);
			setState(157);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(149); 
				match(ID);
				setState(154);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__9) {
					{
					{
					setState(150); 
					match(T__9);
					setState(151); 
					match(ID);
					}
					}
					setState(156);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(159); 
			match(T__10);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IntTypeContext extends ParserRuleContext {
		public IntTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_intType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AtcalVisitor ) return ((AtcalVisitor<? extends T>)visitor).visitIntType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntTypeContext intType() throws RecognitionException {
		IntTypeContext _localctx = new IntTypeContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_intType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(161); 
			match(T__15);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FloatTypeContext extends ParserRuleContext {
		public FloatTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_floatType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AtcalVisitor ) return ((AtcalVisitor<? extends T>)visitor).visitFloatType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FloatTypeContext floatType() throws RecognitionException {
		FloatTypeContext _localctx = new FloatTypeContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_floatType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(163); 
			match(T__16);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StringTypeContext extends ParserRuleContext {
		public StringTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AtcalVisitor ) return ((AtcalVisitor<? extends T>)visitor).visitStringType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringTypeContext stringType() throws RecognitionException {
		StringTypeContext _localctx = new StringTypeContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_stringType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(165); 
			match(T__17);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeCasesContext extends ParserRuleContext {
		public List<TypeCaseContext> typeCase() {
			return getRuleContexts(TypeCaseContext.class);
		}
		public TypeCaseContext typeCase(int i) {
			return getRuleContext(TypeCaseContext.class,i);
		}
		public TypeCasesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeCases; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AtcalVisitor ) return ((AtcalVisitor<? extends T>)visitor).visitTypeCases(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeCasesContext typeCases() throws RecognitionException {
		TypeCasesContext _localctx = new TypeCasesContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_typeCases);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(167); 
			match(T__18);
			setState(168); 
			match(T__19);
			setState(169); 
			typeCase();
			setState(174);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__9) {
				{
				{
				setState(170); 
				match(T__9);
				setState(171); 
				typeCase();
				}
				}
				setState(176);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(177); 
			match(T__20);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeCaseContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(AtcalParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(AtcalParser.ID, i);
		}
		public TerminalNode STRING() { return getToken(AtcalParser.STRING, 0); }
		public TerminalNode NUMBER() { return getToken(AtcalParser.NUMBER, 0); }
		public TypeCaseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeCase; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AtcalVisitor ) return ((AtcalVisitor<? extends T>)visitor).visitTypeCase(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeCaseContext typeCase() throws RecognitionException {
		TypeCaseContext _localctx = new TypeCaseContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_typeCase);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(179); 
			match(ID);
			setState(180); 
			match(T__21);
			setState(181);
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
		enterRule(_localctx, 32, RULE_laws);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(183); 
			match(T__22);
			setState(189);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__30) | (1L << T__32) | (1L << T__34) | (1L << ID) | (1L << NUMBER) | (1L << STRING))) != 0)) {
				{
				{
				setState(184); 
				law();
				setState(185); 
				match(STMTEND);
				}
				}
				setState(191);
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
		public List<TerminalNode> ID() { return getTokens(AtcalParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(AtcalParser.ID, i);
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
		enterRule(_localctx, 34, RULE_uut);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(192); 
			match(T__23);
			setState(193); 
			match(ID);
			setState(194); 
			match(T__8);
			setState(203);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(195); 
				match(ID);
				setState(200);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__9) {
					{
					{
					setState(196); 
					match(T__9);
					setState(197); 
					match(ID);
					}
					}
					setState(202);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(205); 
			match(T__10);
			setState(206); 
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
		enterRule(_localctx, 36, RULE_epilogue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(208); 
			match(T__24);
			setState(212); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(212);
				switch (_input.LA(1)) {
				case T__2:
					{
					setState(209); 
					plcode();
					}
					break;
				case ID:
					{
					setState(210); 
					match(ID);
					setState(211); 
					match(T__25);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(214); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__2 || _la==ID );
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 38, RULE_law);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(218);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				{
				setState(216); 
				match(ID);
				setState(217); 
				match(T__26);
				}
				break;
			}
			{
			setState(220); 
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
		public ZExprContext zExpr() {
			return getRuleContext(ZExprContext.class,0);
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
		enterRule(_localctx, 40, RULE_lawRefinement);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(222); 
			zExpr(0);
			setState(223); 
			match(T__27);
			setState(224); 
			refinement();
			setState(229);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(225); 
					match(T__9);
					setState(226); 
					refinement();
					}
					} 
				}
				setState(231);
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
	public static class BasicRefContext extends RefinementContext {
		public TerminalNode ID() { return getToken(AtcalParser.ID, 0); }
		public TerminalNode NUMBER() { return getToken(AtcalParser.NUMBER, 0); }
		public BasicRefContext(RefinementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AtcalVisitor ) return ((AtcalVisitor<? extends T>)visitor).visitBasicRef(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ZExprRefContext extends RefinementContext {
		public LawRefinementContext lawRefinement() {
			return getRuleContext(LawRefinementContext.class,0);
		}
		public ZExprRefContext(RefinementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AtcalVisitor ) return ((AtcalVisitor<? extends T>)visitor).visitZExprRef(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EnumRefContext extends RefinementContext {
		public List<TerminalNode> ID() { return getTokens(AtcalParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(AtcalParser.ID, i);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<TypeCaseContext> typeCase() {
			return getRuleContexts(TypeCaseContext.class);
		}
		public TypeCaseContext typeCase(int i) {
			return getRuleContext(TypeCaseContext.class,i);
		}
		public TerminalNode NUMBER() { return getToken(AtcalParser.NUMBER, 0); }
		public EnumRefContext(RefinementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AtcalVisitor ) return ((AtcalVisitor<? extends T>)visitor).visitEnumRef(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class WithRefContext extends RefinementContext {
		public List<LawRefinementContext> lawRefinement() {
			return getRuleContexts(LawRefinementContext.class);
		}
		public LawRefinementContext lawRefinement(int i) {
			return getRuleContext(LawRefinementContext.class,i);
		}
		public List<TerminalNode> ID() { return getTokens(AtcalParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(AtcalParser.ID, i);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode NUMBER() { return getToken(AtcalParser.NUMBER, 0); }
		public WithRefContext(RefinementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AtcalVisitor ) return ((AtcalVisitor<? extends T>)visitor).visitWithRef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RefinementContext refinement() throws RecognitionException {
		RefinementContext _localctx = new RefinementContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_refinement);
		int _la;
		try {
			setState(292);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				_localctx = new BasicRefContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(238);
				switch (_input.LA(1)) {
				case ID:
					{
					setState(232); 
					match(ID);
					}
					break;
				case T__19:
					{
					setState(233); 
					match(T__19);
					setState(235);
					_la = _input.LA(1);
					if (_la==NUMBER) {
						{
						setState(234); 
						match(NUMBER);
						}
					}

					setState(237); 
					match(T__20);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 2:
				_localctx = new EnumRefContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(246);
				switch (_input.LA(1)) {
				case ID:
					{
					setState(240); 
					match(ID);
					}
					break;
				case T__19:
					{
					setState(241); 
					match(T__19);
					setState(243);
					_la = _input.LA(1);
					if (_la==NUMBER) {
						{
						setState(242); 
						match(NUMBER);
						}
					}

					setState(245); 
					match(T__20);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(248); 
				match(T__28);
				setState(251);
				switch (_input.LA(1)) {
				case T__5:
				case T__7:
				case T__11:
				case T__12:
				case T__14:
				case T__15:
				case T__16:
				case T__17:
					{
					setState(249); 
					type();
					}
					break;
				case ID:
					{
					setState(250); 
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(264);
				_la = _input.LA(1);
				if (_la==T__19) {
					{
					setState(253); 
					match(T__19);
					setState(254); 
					typeCase();
					setState(259);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__9) {
						{
						{
						setState(255); 
						match(T__9);
						setState(256); 
						typeCase();
						}
						}
						setState(261);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(262); 
					match(T__20);
					}
				}

				}
				break;
			case 3:
				_localctx = new WithRefContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(272);
				switch (_input.LA(1)) {
				case ID:
					{
					setState(266); 
					match(ID);
					}
					break;
				case T__19:
					{
					setState(267); 
					match(T__19);
					setState(269);
					_la = _input.LA(1);
					if (_la==NUMBER) {
						{
						setState(268); 
						match(NUMBER);
						}
					}

					setState(271); 
					match(T__20);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(274); 
				match(T__28);
				setState(277);
				switch (_input.LA(1)) {
				case T__5:
				case T__7:
				case T__11:
				case T__12:
				case T__14:
				case T__15:
				case T__16:
				case T__17:
					{
					setState(275); 
					type();
					}
					break;
				case ID:
					{
					setState(276); 
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(279); 
				match(T__29);
				setState(280); 
				match(T__19);
				setState(281); 
				lawRefinement();
				setState(286);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__9) {
					{
					{
					setState(282); 
					match(T__9);
					setState(283); 
					lawRefinement();
					}
					}
					setState(288);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(289); 
				match(T__20);
				}
				break;
			case 4:
				_localctx = new ZExprRefContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(291); 
				lawRefinement();
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
		public ZExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_zExpr; }
	 
		public ZExprContext() { }
		public void copyFrom(ZExprContext ctx) {
			super.copyFrom(ctx);
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
	public static class SetCardContext extends ZExprContext {
		public ZExprContext zExpr() {
			return getRuleContext(ZExprContext.class,0);
		}
		public SetCardContext(ZExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AtcalVisitor ) return ((AtcalVisitor<? extends T>)visitor).visitSetCard(this);
			else return visitor.visitChildren(this);
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
	public static class StrLiteralContext extends ZExprContext {
		public TerminalNode STRING() { return getToken(AtcalParser.STRING, 0); }
		public StrLiteralContext(ZExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AtcalVisitor ) return ((AtcalVisitor<? extends T>)visitor).visitStrLiteral(this);
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
	public static class NumLiteralContext extends ZExprContext {
		public TerminalNode NUMBER() { return getToken(AtcalParser.NUMBER, 0); }
		public NumLiteralContext(ZExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AtcalVisitor ) return ((AtcalVisitor<? extends T>)visitor).visitNumLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AutoExprContext extends ZExprContext {
		public AutoExprContext(ZExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AtcalVisitor ) return ((AtcalVisitor<? extends T>)visitor).visitAutoExpr(this);
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

	public final ZExprContext zExpr() throws RecognitionException {
		return zExpr(0);
	}

	private ZExprContext zExpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ZExprContext _localctx = new ZExprContext(_ctx, _parentState);
		ZExprContext _prevctx = _localctx;
		int _startState = 44;
		enterRecursionRule(_localctx, 44, RULE_zExpr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(325);
			switch (_input.LA(1)) {
			case ID:
				{
				_localctx = new IdentContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(295); 
				match(ID);
				}
				break;
			case NUMBER:
				{
				_localctx = new NumLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(296); 
				match(NUMBER);
				}
				break;
			case STRING:
				{
				_localctx = new StrLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(297); 
				match(STRING);
				}
				break;
			case T__30:
				{
				_localctx = new AutoExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(298); 
				match(T__30);
				}
				break;
			case T__32:
				{
				_localctx = new ProdConsContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(299); 
				match(T__32);
				setState(300); 
				zExpr(0);
				setState(305);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__9) {
					{
					{
					setState(301); 
					match(T__9);
					setState(302); 
					zExpr(0);
					}
					}
					setState(307);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(308); 
				match(T__33);
				}
				break;
			case T__34:
				{
				_localctx = new SetConsContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(310); 
				match(T__34);
				setState(311); 
				zExpr(0);
				setState(316);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__9) {
					{
					{
					setState(312); 
					match(T__9);
					setState(313); 
					zExpr(0);
					}
					}
					setState(318);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(319); 
				match(T__35);
				}
				break;
			case T__8:
				{
				_localctx = new GroupContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(321); 
				match(T__8);
				setState(322); 
				zExpr(0);
				setState(323); 
				match(T__10);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(373);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(371);
					switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
					case 1:
						{
						_localctx = new SetInterContext(new ZExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_zExpr);
						setState(327);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(328); 
						match(INTER);
						setState(329); 
						zExpr(13);
						}
						break;
					case 2:
						{
						_localctx = new SetUnionContext(new ZExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_zExpr);
						setState(330);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(331); 
						match(UNION);
						setState(332); 
						zExpr(12);
						}
						break;
					case 3:
						{
						_localctx = new SetDiffContext(new ZExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_zExpr);
						setState(333);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(334); 
						match(DIFF);
						setState(335); 
						zExpr(11);
						}
						break;
					case 4:
						{
						_localctx = new NumMulContext(new ZExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_zExpr);
						setState(336);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(337); 
						match(MUL);
						setState(338); 
						zExpr(8);
						}
						break;
					case 5:
						{
						_localctx = new NumDivContext(new ZExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_zExpr);
						setState(339);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(340); 
						match(DIV);
						setState(341); 
						zExpr(7);
						}
						break;
					case 6:
						{
						_localctx = new NumModContext(new ZExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_zExpr);
						setState(342);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(343); 
						match(MOD);
						setState(344); 
						zExpr(6);
						}
						break;
					case 7:
						{
						_localctx = new NumPlusContext(new ZExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_zExpr);
						setState(345);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(346); 
						match(PLUS);
						setState(347); 
						zExpr(5);
						}
						break;
					case 8:
						{
						_localctx = new NumMinusContext(new ZExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_zExpr);
						setState(348);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(349); 
						match(MINUS);
						setState(350); 
						zExpr(4);
						}
						break;
					case 9:
						{
						_localctx = new StrConcatContext(new ZExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_zExpr);
						setState(351);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(352); 
						match(T__37);
						setState(353); 
						zExpr(3);
						}
						break;
					case 10:
						{
						_localctx = new ProdProjContext(new ZExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_zExpr);
						setState(354);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(355); 
						match(T__31);
						setState(356); 
						match(TUPPROJ);
						}
						break;
					case 11:
						{
						_localctx = new SetElemContext(new ZExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_zExpr);
						setState(357);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(358); 
						match(T__31);
						setState(359); 
						match(NUMBER);
						}
						break;
					case 12:
						{
						_localctx = new SetDomContext(new ZExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_zExpr);
						setState(360);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(361); 
						match(T__31);
						setState(362); 
						match(DOM);
						}
						break;
					case 13:
						{
						_localctx = new SetRanContext(new ZExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_zExpr);
						setState(363);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(364); 
						match(T__31);
						setState(365); 
						match(RAN);
						}
						break;
					case 14:
						{
						_localctx = new SetProjContext(new ZExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_zExpr);
						setState(366);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(367); 
						match(T__31);
						setState(368); 
						match(PROJ);
						}
						break;
					case 15:
						{
						_localctx = new SetCardContext(new ZExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_zExpr);
						setState(369);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(370); 
						match(T__36);
						}
						break;
					}
					} 
				}
				setState(375);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 22: 
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\39\u017b\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\3\2\3\2\3"+
		"\2\3\2\5\2\65\n\2\3\2\3\2\5\29\n\2\3\2\3\2\5\2=\n\2\3\3\3\3\3\3\6\3B\n"+
		"\3\r\3\16\3C\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\7\6N\n\6\f\6\16\6Q\13\6\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7[\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\7\ti\n\t\f\t\16\tl\13\t\5\tn\n\t\3\t\3\t\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\7\13~\n\13\f\13\16\13\u0081"+
		"\13\13\5\13\u0083\n\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\7\13\u008c\n"+
		"\13\f\13\16\13\u008f\13\13\5\13\u0091\n\13\3\13\3\13\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\7\f\u009b\n\f\f\f\16\f\u009e\13\f\5\f\u00a0\n\f\3\f\3\f\3\r\3\r"+
		"\3\16\3\16\3\17\3\17\3\20\3\20\3\20\3\20\3\20\7\20\u00af\n\20\f\20\16"+
		"\20\u00b2\13\20\3\20\3\20\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\7\22"+
		"\u00be\n\22\f\22\16\22\u00c1\13\22\3\23\3\23\3\23\3\23\3\23\3\23\7\23"+
		"\u00c9\n\23\f\23\16\23\u00cc\13\23\5\23\u00ce\n\23\3\23\3\23\3\23\3\24"+
		"\3\24\3\24\3\24\6\24\u00d7\n\24\r\24\16\24\u00d8\3\25\3\25\5\25\u00dd"+
		"\n\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\7\26\u00e6\n\26\f\26\16\26\u00e9"+
		"\13\26\3\27\3\27\3\27\5\27\u00ee\n\27\3\27\5\27\u00f1\n\27\3\27\3\27\3"+
		"\27\5\27\u00f6\n\27\3\27\5\27\u00f9\n\27\3\27\3\27\3\27\5\27\u00fe\n\27"+
		"\3\27\3\27\3\27\3\27\7\27\u0104\n\27\f\27\16\27\u0107\13\27\3\27\3\27"+
		"\5\27\u010b\n\27\3\27\3\27\3\27\5\27\u0110\n\27\3\27\5\27\u0113\n\27\3"+
		"\27\3\27\3\27\5\27\u0118\n\27\3\27\3\27\3\27\3\27\3\27\7\27\u011f\n\27"+
		"\f\27\16\27\u0122\13\27\3\27\3\27\3\27\5\27\u0127\n\27\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\7\30\u0132\n\30\f\30\16\30\u0135\13\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\7\30\u013d\n\30\f\30\16\30\u0140\13\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\5\30\u0148\n\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\7\30\u0176\n\30"+
		"\f\30\16\30\u0179\13\30\3\30\2\3.\31\2\4\6\b\n\f\16\20\22\24\26\30\32"+
		"\34\36 \"$&(*,.\2\3\4\2*+88\u01a5\2\60\3\2\2\2\4>\3\2\2\2\6E\3\2\2\2\b"+
		"G\3\2\2\2\nK\3\2\2\2\fZ\3\2\2\2\16\\\3\2\2\2\20b\3\2\2\2\22q\3\2\2\2\24"+
		"w\3\2\2\2\26\u0094\3\2\2\2\30\u00a3\3\2\2\2\32\u00a5\3\2\2\2\34\u00a7"+
		"\3\2\2\2\36\u00a9\3\2\2\2 \u00b5\3\2\2\2\"\u00b9\3\2\2\2$\u00c2\3\2\2"+
		"\2&\u00d2\3\2\2\2(\u00dc\3\2\2\2*\u00e0\3\2\2\2,\u0126\3\2\2\2.\u0147"+
		"\3\2\2\2\60\61\7\3\2\2\61\62\7*\2\2\62\64\5\4\3\2\63\65\5\n\6\2\64\63"+
		"\3\2\2\2\64\65\3\2\2\2\65\66\3\2\2\2\668\5\"\22\2\679\5\6\4\28\67\3\2"+
		"\2\289\3\2\2\29:\3\2\2\2:<\5$\23\2;=\5&\24\2<;\3\2\2\2<=\3\2\2\2=\3\3"+
		"\2\2\2>A\7\4\2\2?B\5\6\4\2@B\5\b\5\2A?\3\2\2\2A@\3\2\2\2BC\3\2\2\2CA\3"+
		"\2\2\2CD\3\2\2\2D\5\3\2\2\2EF\7\5\2\2F\7\3\2\2\2GH\7*\2\2HI\7\6\2\2IJ"+
		"\7)\2\2J\t\3\2\2\2KO\7\7\2\2LN\5\16\b\2ML\3\2\2\2NQ\3\2\2\2OM\3\2\2\2"+
		"OP\3\2\2\2P\13\3\2\2\2QO\3\2\2\2R[\5\20\t\2S[\5\22\n\2T[\5\26\f\2U[\5"+
		"\24\13\2V[\5\16\b\2W[\5\30\r\2X[\5\32\16\2Y[\5\34\17\2ZR\3\2\2\2ZS\3\2"+
		"\2\2ZT\3\2\2\2ZU\3\2\2\2ZV\3\2\2\2ZW\3\2\2\2ZX\3\2\2\2ZY\3\2\2\2[\r\3"+
		"\2\2\2\\]\7\b\2\2]^\7*\2\2^_\7\t\2\2_`\5\f\7\2`a\7)\2\2a\17\3\2\2\2bc"+
		"\7\n\2\2cd\7*\2\2dm\7\13\2\2ej\7*\2\2fg\7\f\2\2gi\7*\2\2hf\3\2\2\2il\3"+
		"\2\2\2jh\3\2\2\2jk\3\2\2\2kn\3\2\2\2lj\3\2\2\2me\3\2\2\2mn\3\2\2\2no\3"+
		"\2\2\2op\7\r\2\2p\21\3\2\2\2qr\7\16\2\2rs\7*\2\2st\7\13\2\2tu\7+\2\2u"+
		"v\7\r\2\2v\23\3\2\2\2wx\7\17\2\2xy\7*\2\2y\u0082\7\13\2\2z\177\7*\2\2"+
		"{|\7\f\2\2|~\7*\2\2}{\3\2\2\2~\u0081\3\2\2\2\177}\3\2\2\2\177\u0080\3"+
		"\2\2\2\u0080\u0083\3\2\2\2\u0081\177\3\2\2\2\u0082z\3\2\2\2\u0082\u0083"+
		"\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0085\7\r\2\2\u0085\u0086\7\20\2\2"+
		"\u0086\u0087\7*\2\2\u0087\u0090\7\13\2\2\u0088\u008d\7*\2\2\u0089\u008a"+
		"\7\f\2\2\u008a\u008c\7*\2\2\u008b\u0089\3\2\2\2\u008c\u008f\3\2\2\2\u008d"+
		"\u008b\3\2\2\2\u008d\u008e\3\2\2\2\u008e\u0091\3\2\2\2\u008f\u008d\3\2"+
		"\2\2\u0090\u0088\3\2\2\2\u0090\u0091\3\2\2\2\u0091\u0092\3\2\2\2\u0092"+
		"\u0093\7\r\2\2\u0093\25\3\2\2\2\u0094\u0095\7\21\2\2\u0095\u0096\7*\2"+
		"\2\u0096\u009f\7\13\2\2\u0097\u009c\7*\2\2\u0098\u0099\7\f\2\2\u0099\u009b"+
		"\7*\2\2\u009a\u0098\3\2\2\2\u009b\u009e\3\2\2\2\u009c\u009a\3\2\2\2\u009c"+
		"\u009d\3\2\2\2\u009d\u00a0\3\2\2\2\u009e\u009c\3\2\2\2\u009f\u0097\3\2"+
		"\2\2\u009f\u00a0\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\u00a2\7\r\2\2\u00a2"+
		"\27\3\2\2\2\u00a3\u00a4\7\22\2\2\u00a4\31\3\2\2\2\u00a5\u00a6\7\23\2\2"+
		"\u00a6\33\3\2\2\2\u00a7\u00a8\7\24\2\2\u00a8\35\3\2\2\2\u00a9\u00aa\7"+
		"\25\2\2\u00aa\u00ab\7\26\2\2\u00ab\u00b0\5 \21\2\u00ac\u00ad\7\f\2\2\u00ad"+
		"\u00af\5 \21\2\u00ae\u00ac\3\2\2\2\u00af\u00b2\3\2\2\2\u00b0\u00ae\3\2"+
		"\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00b3\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b3"+
		"\u00b4\7\27\2\2\u00b4\37\3\2\2\2\u00b5\u00b6\7*\2\2\u00b6\u00b7\7\30\2"+
		"\2\u00b7\u00b8\t\2\2\2\u00b8!\3\2\2\2\u00b9\u00bf\7\31\2\2\u00ba\u00bb"+
		"\5(\25\2\u00bb\u00bc\7)\2\2\u00bc\u00be\3\2\2\2\u00bd\u00ba\3\2\2\2\u00be"+
		"\u00c1\3\2\2\2\u00bf\u00bd\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0#\3\2\2\2"+
		"\u00c1\u00bf\3\2\2\2\u00c2\u00c3\7\32\2\2\u00c3\u00c4\7*\2\2\u00c4\u00cd"+
		"\7\13\2\2\u00c5\u00ca\7*\2\2\u00c6\u00c7\7\f\2\2\u00c7\u00c9\7*\2\2\u00c8"+
		"\u00c6\3\2\2\2\u00c9\u00cc\3\2\2\2\u00ca\u00c8\3\2\2\2\u00ca\u00cb\3\2"+
		"\2\2\u00cb\u00ce\3\2\2\2\u00cc\u00ca\3\2\2\2\u00cd\u00c5\3\2\2\2\u00cd"+
		"\u00ce\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf\u00d0\7\r\2\2\u00d0\u00d1\7)"+
		"\2\2\u00d1%\3\2\2\2\u00d2\u00d6\7\33\2\2\u00d3\u00d7\5\6\4\2\u00d4\u00d5"+
		"\7*\2\2\u00d5\u00d7\7\34\2\2\u00d6\u00d3\3\2\2\2\u00d6\u00d4\3\2\2\2\u00d7"+
		"\u00d8\3\2\2\2\u00d8\u00d6\3\2\2\2\u00d8\u00d9\3\2\2\2\u00d9\'\3\2\2\2"+
		"\u00da\u00db\7*\2\2\u00db\u00dd\7\35\2\2\u00dc\u00da\3\2\2\2\u00dc\u00dd"+
		"\3\2\2\2\u00dd\u00de\3\2\2\2\u00de\u00df\5*\26\2\u00df)\3\2\2\2\u00e0"+
		"\u00e1\5.\30\2\u00e1\u00e2\7\36\2\2\u00e2\u00e7\5,\27\2\u00e3\u00e4\7"+
		"\f\2\2\u00e4\u00e6\5,\27\2\u00e5\u00e3\3\2\2\2\u00e6\u00e9\3\2\2\2\u00e7"+
		"\u00e5\3\2\2\2\u00e7\u00e8\3\2\2\2\u00e8+\3\2\2\2\u00e9\u00e7\3\2\2\2"+
		"\u00ea\u00f1\7*\2\2\u00eb\u00ed\7\26\2\2\u00ec\u00ee\7+\2\2\u00ed\u00ec"+
		"\3\2\2\2\u00ed\u00ee\3\2\2\2\u00ee\u00ef\3\2\2\2\u00ef\u00f1\7\27\2\2"+
		"\u00f0\u00ea\3\2\2\2\u00f0\u00eb\3\2\2\2\u00f1\u0127\3\2\2\2\u00f2\u00f9"+
		"\7*\2\2\u00f3\u00f5\7\26\2\2\u00f4\u00f6\7+\2\2\u00f5\u00f4\3\2\2\2\u00f5"+
		"\u00f6\3\2\2\2\u00f6\u00f7\3\2\2\2\u00f7\u00f9\7\27\2\2\u00f8\u00f2\3"+
		"\2\2\2\u00f8\u00f3\3\2\2\2\u00f9\u00fa\3\2\2\2\u00fa\u00fd\7\37\2\2\u00fb"+
		"\u00fe\5\f\7\2\u00fc\u00fe\7*\2\2\u00fd\u00fb\3\2\2\2\u00fd\u00fc\3\2"+
		"\2\2\u00fe\u010a\3\2\2\2\u00ff\u0100\7\26\2\2\u0100\u0105\5 \21\2\u0101"+
		"\u0102\7\f\2\2\u0102\u0104\5 \21\2\u0103\u0101\3\2\2\2\u0104\u0107\3\2"+
		"\2\2\u0105\u0103\3\2\2\2\u0105\u0106\3\2\2\2\u0106\u0108\3\2\2\2\u0107"+
		"\u0105\3\2\2\2\u0108\u0109\7\27\2\2\u0109\u010b\3\2\2\2\u010a\u00ff\3"+
		"\2\2\2\u010a\u010b\3\2\2\2\u010b\u0127\3\2\2\2\u010c\u0113\7*\2\2\u010d"+
		"\u010f\7\26\2\2\u010e\u0110\7+\2\2\u010f\u010e\3\2\2\2\u010f\u0110\3\2"+
		"\2\2\u0110\u0111\3\2\2\2\u0111\u0113\7\27\2\2\u0112\u010c\3\2\2\2\u0112"+
		"\u010d\3\2\2\2\u0113\u0114\3\2\2\2\u0114\u0117\7\37\2\2\u0115\u0118\5"+
		"\f\7\2\u0116\u0118\7*\2\2\u0117\u0115\3\2\2\2\u0117\u0116\3\2\2\2\u0118"+
		"\u0119\3\2\2\2\u0119\u011a\7 \2\2\u011a\u011b\7\26\2\2\u011b\u0120\5*"+
		"\26\2\u011c\u011d\7\f\2\2\u011d\u011f\5*\26\2\u011e\u011c\3\2\2\2\u011f"+
		"\u0122\3\2\2\2\u0120\u011e\3\2\2\2\u0120\u0121\3\2\2\2\u0121\u0123\3\2"+
		"\2\2\u0122\u0120\3\2\2\2\u0123\u0124\7\27\2\2\u0124\u0127\3\2\2\2\u0125"+
		"\u0127\5*\26\2\u0126\u00f0\3\2\2\2\u0126\u00f8\3\2\2\2\u0126\u0112\3\2"+
		"\2\2\u0126\u0125\3\2\2\2\u0127-\3\2\2\2\u0128\u0129\b\30\1\2\u0129\u0148"+
		"\7*\2\2\u012a\u0148\7+\2\2\u012b\u0148\78\2\2\u012c\u0148\7!\2\2\u012d"+
		"\u012e\7#\2\2\u012e\u0133\5.\30\2\u012f\u0130\7\f\2\2\u0130\u0132\5.\30"+
		"\2\u0131\u012f\3\2\2\2\u0132\u0135\3\2\2\2\u0133\u0131\3\2\2\2\u0133\u0134"+
		"\3\2\2\2\u0134\u0136\3\2\2\2\u0135\u0133\3\2\2\2\u0136\u0137\7$\2\2\u0137"+
		"\u0148\3\2\2\2\u0138\u0139\7%\2\2\u0139\u013e\5.\30\2\u013a\u013b\7\f"+
		"\2\2\u013b\u013d\5.\30\2\u013c\u013a\3\2\2\2\u013d\u0140\3\2\2\2\u013e"+
		"\u013c\3\2\2\2\u013e\u013f\3\2\2\2\u013f\u0141\3\2\2\2\u0140\u013e\3\2"+
		"\2\2\u0141\u0142\7&\2\2\u0142\u0148\3\2\2\2\u0143\u0144\7\13\2\2\u0144"+
		"\u0145\5.\30\2\u0145\u0146\7\r\2\2\u0146\u0148\3\2\2\2\u0147\u0128\3\2"+
		"\2\2\u0147\u012a\3\2\2\2\u0147\u012b\3\2\2\2\u0147\u012c\3\2\2\2\u0147"+
		"\u012d\3\2\2\2\u0147\u0138\3\2\2\2\u0147\u0143\3\2\2\2\u0148\u0177\3\2"+
		"\2\2\u0149\u014a\f\16\2\2\u014a\u014b\7\65\2\2\u014b\u0176\5.\30\17\u014c"+
		"\u014d\f\r\2\2\u014d\u014e\7\66\2\2\u014e\u0176\5.\30\16\u014f\u0150\f"+
		"\f\2\2\u0150\u0151\7\67\2\2\u0151\u0176\5.\30\r\u0152\u0153\f\t\2\2\u0153"+
		"\u0154\7.\2\2\u0154\u0176\5.\30\n\u0155\u0156\f\b\2\2\u0156\u0157\7/\2"+
		"\2\u0157\u0176\5.\30\t\u0158\u0159\f\7\2\2\u0159\u015a\7\60\2\2\u015a"+
		"\u0176\5.\30\b\u015b\u015c\f\6\2\2\u015c\u015d\7,\2\2\u015d\u0176\5.\30"+
		"\7\u015e\u015f\f\5\2\2\u015f\u0160\7-\2\2\u0160\u0176\5.\30\6\u0161\u0162"+
		"\f\4\2\2\u0162\u0163\7(\2\2\u0163\u0176\5.\30\5\u0164\u0165\f\24\2\2\u0165"+
		"\u0166\7\"\2\2\u0166\u0176\7\64\2\2\u0167\u0168\f\22\2\2\u0168\u0169\7"+
		"\"\2\2\u0169\u0176\7+\2\2\u016a\u016b\f\21\2\2\u016b\u016c\7\"\2\2\u016c"+
		"\u0176\7\61\2\2\u016d\u016e\f\20\2\2\u016e\u016f\7\"\2\2\u016f\u0176\7"+
		"\62\2\2\u0170\u0171\f\17\2\2\u0171\u0172\7\"\2\2\u0172\u0176\7\63\2\2"+
		"\u0173\u0174\f\n\2\2\u0174\u0176\7\'\2\2\u0175\u0149\3\2\2\2\u0175\u014c"+
		"\3\2\2\2\u0175\u014f\3\2\2\2\u0175\u0152\3\2\2\2\u0175\u0155\3\2\2\2\u0175"+
		"\u0158\3\2\2\2\u0175\u015b\3\2\2\2\u0175\u015e\3\2\2\2\u0175\u0161\3\2"+
		"\2\2\u0175\u0164\3\2\2\2\u0175\u0167\3\2\2\2\u0175\u016a\3\2\2\2\u0175"+
		"\u016d\3\2\2\2\u0175\u0170\3\2\2\2\u0175\u0173\3\2\2\2\u0176\u0179\3\2"+
		"\2\2\u0177\u0175\3\2\2\2\u0177\u0178\3\2\2\2\u0178/\3\2\2\2\u0179\u0177"+
		"\3\2\2\2*\648<ACOZjm\177\u0082\u008d\u0090\u009c\u009f\u00b0\u00bf\u00ca"+
		"\u00cd\u00d6\u00d8\u00dc\u00e7\u00ed\u00f0\u00f5\u00f8\u00fd\u0105\u010a"+
		"\u010f\u0112\u0117\u0120\u0126\u0133\u013e\u0147\u0175\u0177";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}