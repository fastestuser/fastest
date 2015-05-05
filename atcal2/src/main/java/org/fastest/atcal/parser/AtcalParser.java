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
		RULE_refinement = 21, RULE_lvalue = 22, RULE_asRef = 23, RULE_zExpr = 24;
	public static final String[] ruleNames = {
		"refinementRule", "preamble", "plcode", "preambleImport", "datatypes", 
		"type", "aliasType", "recordType", "arrayType", "contractType", "enumType", 
		"intType", "floatType", "stringType", "typeCases", "typeCase", "laws", 
		"uut", "epilogue", "law", "lawRefinement", "refinement", "lvalue", "asRef", 
		"zExpr"
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
			setState(50); 
			match(T__0);
			setState(51); 
			match(ID);
			setState(52); 
			preamble();
			setState(54);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(53); 
				datatypes();
				}
			}

			setState(56); 
			laws();
			setState(58);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(57); 
				plcode();
				}
			}

			setState(60); 
			uut();
			setState(62);
			_la = _input.LA(1);
			if (_la==T__24) {
				{
				setState(61); 
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
			setState(64); 
			match(T__1);
			setState(67); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(67);
				switch (_input.LA(1)) {
				case T__2:
					{
					setState(65); 
					plcode();
					}
					break;
				case ID:
					{
					setState(66); 
					preambleImport();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(69); 
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
			setState(71); 
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
			setState(73); 
			match(ID);
			setState(74); 
			match(T__3);
			setState(75); 
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
			setState(77); 
			match(T__4);
			setState(81);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__5) {
				{
				{
				setState(78); 
				aliasType();
				}
				}
				setState(83);
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
			setState(92);
			switch (_input.LA(1)) {
			case T__7:
				enterOuterAlt(_localctx, 1);
				{
				setState(84); 
				recordType();
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 2);
				{
				setState(85); 
				arrayType();
				}
				break;
			case T__14:
				enterOuterAlt(_localctx, 3);
				{
				setState(86); 
				enumType();
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 4);
				{
				setState(87); 
				contractType();
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 5);
				{
				setState(88); 
				aliasType();
				}
				break;
			case T__15:
				enterOuterAlt(_localctx, 6);
				{
				setState(89); 
				intType();
				}
				break;
			case T__16:
				enterOuterAlt(_localctx, 7);
				{
				setState(90); 
				floatType();
				}
				break;
			case T__17:
				enterOuterAlt(_localctx, 8);
				{
				setState(91); 
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
			setState(94); 
			match(T__5);
			setState(95); 
			match(ID);
			setState(96); 
			match(T__6);
			setState(97); 
			type();
			setState(98); 
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
			setState(100); 
			match(T__7);
			setState(101); 
			match(ID);
			setState(102); 
			match(T__8);
			setState(111);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(103); 
				match(ID);
				setState(108);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__9) {
					{
					{
					setState(104); 
					match(T__9);
					setState(105); 
					match(ID);
					}
					}
					setState(110);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(113); 
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
			setState(115); 
			match(T__11);
			setState(116); 
			match(ID);
			setState(117); 
			match(T__8);
			setState(118); 
			match(NUMBER);
			setState(119); 
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
			setState(121); 
			match(T__12);
			setState(122); 
			match(ID);
			setState(123); 
			match(T__8);
			setState(132);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(124); 
				match(ID);
				setState(129);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__9) {
					{
					{
					setState(125); 
					match(T__9);
					setState(126); 
					match(ID);
					}
					}
					setState(131);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(134); 
			match(T__10);
			setState(135); 
			match(T__13);
			setState(136); 
			match(ID);
			setState(137); 
			match(T__8);
			setState(146);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(138); 
				match(ID);
				setState(143);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__9) {
					{
					{
					setState(139); 
					match(T__9);
					setState(140); 
					match(ID);
					}
					}
					setState(145);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(148); 
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
			setState(150); 
			match(T__14);
			setState(151); 
			match(ID);
			setState(152); 
			match(T__8);
			setState(161);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(153); 
				match(ID);
				setState(158);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__9) {
					{
					{
					setState(154); 
					match(T__9);
					setState(155); 
					match(ID);
					}
					}
					setState(160);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(163); 
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
			setState(165); 
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
			setState(167); 
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
			setState(169); 
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
			setState(171); 
			match(T__18);
			setState(172); 
			match(T__19);
			setState(173); 
			typeCase();
			setState(178);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__9) {
				{
				{
				setState(174); 
				match(T__9);
				setState(175); 
				typeCase();
				}
				}
				setState(180);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(181); 
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
			setState(183); 
			match(ID);
			setState(184); 
			match(T__21);
			setState(185);
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
			setState(187); 
			match(T__22);
			setState(193);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__30) | (1L << T__32) | (1L << T__34) | (1L << ID) | (1L << NUMBER) | (1L << STRING))) != 0)) {
				{
				{
				setState(188); 
				law();
				setState(189); 
				match(STMTEND);
				}
				}
				setState(195);
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
			setState(196); 
			match(T__23);
			setState(197); 
			match(ID);
			setState(198); 
			match(T__8);
			setState(207);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(199); 
				match(ID);
				setState(204);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__9) {
					{
					{
					setState(200); 
					match(T__9);
					setState(201); 
					match(ID);
					}
					}
					setState(206);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(209); 
			match(T__10);
			setState(210); 
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
			setState(212); 
			match(T__24);
			setState(216); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(216);
				switch (_input.LA(1)) {
				case T__2:
					{
					setState(213); 
					plcode();
					}
					break;
				case ID:
					{
					setState(214); 
					match(ID);
					setState(215); 
					match(T__25);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(218); 
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
			setState(222);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				{
				setState(220); 
				match(ID);
				setState(221); 
				match(T__26);
				}
				break;
			}
			{
			setState(224); 
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
			setState(226); 
			zExpr(0);
			setState(227); 
			match(T__27);
			setState(228); 
			refinement();
			setState(233);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(229); 
					match(T__9);
					setState(230); 
					refinement();
					}
					} 
				}
				setState(235);
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
	public static class ImplRefContext extends RefinementContext {
		public LvalueContext lvalue() {
			return getRuleContext(LvalueContext.class,0);
		}
		public AsRefContext asRef() {
			return getRuleContext(AsRefContext.class,0);
		}
		public ImplRefContext(RefinementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AtcalVisitor ) return ((AtcalVisitor<? extends T>)visitor).visitImplRef(this);
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

	public final RefinementContext refinement() throws RecognitionException {
		RefinementContext _localctx = new RefinementContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_refinement);
		int _la;
		try {
			setState(241);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				_localctx = new ImplRefContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(236); 
				lvalue();
				setState(238);
				_la = _input.LA(1);
				if (_la==T__28) {
					{
					setState(237); 
					asRef();
					}
				}

				}
				break;
			case 2:
				_localctx = new ZExprRefContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(240); 
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

	public final LvalueContext lvalue() throws RecognitionException {
		LvalueContext _localctx = new LvalueContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_lvalue);
		int _la;
		try {
			setState(249);
			switch (_input.LA(1)) {
			case ID:
				_localctx = new VarLValueContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(243); 
				match(ID);
				}
				break;
			case T__19:
				_localctx = new ArrayLValueContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(244); 
				match(T__19);
				setState(246);
				_la = _input.LA(1);
				if (_la==NUMBER) {
					{
					setState(245); 
					match(NUMBER);
					}
				}

				setState(248); 
				match(T__20);
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

	public static class AsRefContext extends ParserRuleContext {
		public AsRefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_asRef; }
	 
		public AsRefContext() { }
		public void copyFrom(AsRefContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class WithRefContext extends AsRefContext {
		public List<LawRefinementContext> lawRefinement() {
			return getRuleContexts(LawRefinementContext.class);
		}
		public LawRefinementContext lawRefinement(int i) {
			return getRuleContext(LawRefinementContext.class,i);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(AtcalParser.ID, 0); }
		public WithRefContext(AsRefContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AtcalVisitor ) return ((AtcalVisitor<? extends T>)visitor).visitWithRef(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EnumRefContext extends AsRefContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(AtcalParser.ID, 0); }
		public List<TypeCaseContext> typeCase() {
			return getRuleContexts(TypeCaseContext.class);
		}
		public TypeCaseContext typeCase(int i) {
			return getRuleContext(TypeCaseContext.class,i);
		}
		public EnumRefContext(AsRefContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AtcalVisitor ) return ((AtcalVisitor<? extends T>)visitor).visitEnumRef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AsRefContext asRef() throws RecognitionException {
		AsRefContext _localctx = new AsRefContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_asRef);
		int _la;
		try {
			setState(286);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				_localctx = new EnumRefContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(251); 
				match(T__28);
				setState(254);
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
					setState(252); 
					type();
					}
					break;
				case ID:
					{
					setState(253); 
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(267);
				_la = _input.LA(1);
				if (_la==T__19) {
					{
					setState(256); 
					match(T__19);
					setState(257); 
					typeCase();
					setState(262);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__9) {
						{
						{
						setState(258); 
						match(T__9);
						setState(259); 
						typeCase();
						}
						}
						setState(264);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(265); 
					match(T__20);
					}
				}

				}
				break;
			case 2:
				_localctx = new WithRefContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(269); 
				match(T__28);
				setState(272);
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
					setState(270); 
					type();
					}
					break;
				case ID:
					{
					setState(271); 
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(274); 
				match(T__29);
				setState(275); 
				match(T__19);
				setState(276); 
				lawRefinement();
				setState(281);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__9) {
					{
					{
					setState(277); 
					match(T__9);
					setState(278); 
					lawRefinement();
					}
					}
					setState(283);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(284); 
				match(T__20);
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
		int _startState = 48;
		enterRecursionRule(_localctx, 48, RULE_zExpr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(319);
			switch (_input.LA(1)) {
			case ID:
				{
				_localctx = new IdentContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(289); 
				match(ID);
				}
				break;
			case NUMBER:
				{
				_localctx = new NumLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(290); 
				match(NUMBER);
				}
				break;
			case STRING:
				{
				_localctx = new StrLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(291); 
				match(STRING);
				}
				break;
			case T__30:
				{
				_localctx = new AutoExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(292); 
				match(T__30);
				}
				break;
			case T__32:
				{
				_localctx = new ProdConsContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(293); 
				match(T__32);
				setState(294); 
				zExpr(0);
				setState(299);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__9) {
					{
					{
					setState(295); 
					match(T__9);
					setState(296); 
					zExpr(0);
					}
					}
					setState(301);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(302); 
				match(T__33);
				}
				break;
			case T__34:
				{
				_localctx = new SetConsContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(304); 
				match(T__34);
				setState(305); 
				zExpr(0);
				setState(310);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__9) {
					{
					{
					setState(306); 
					match(T__9);
					setState(307); 
					zExpr(0);
					}
					}
					setState(312);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(313); 
				match(T__35);
				}
				break;
			case T__8:
				{
				_localctx = new GroupContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(315); 
				match(T__8);
				setState(316); 
				zExpr(0);
				setState(317); 
				match(T__10);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(367);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(365);
					switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
					case 1:
						{
						_localctx = new SetInterContext(new ZExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_zExpr);
						setState(321);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(322); 
						match(INTER);
						setState(323); 
						zExpr(13);
						}
						break;
					case 2:
						{
						_localctx = new SetUnionContext(new ZExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_zExpr);
						setState(324);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(325); 
						match(UNION);
						setState(326); 
						zExpr(12);
						}
						break;
					case 3:
						{
						_localctx = new SetDiffContext(new ZExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_zExpr);
						setState(327);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(328); 
						match(DIFF);
						setState(329); 
						zExpr(11);
						}
						break;
					case 4:
						{
						_localctx = new NumMulContext(new ZExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_zExpr);
						setState(330);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(331); 
						match(MUL);
						setState(332); 
						zExpr(8);
						}
						break;
					case 5:
						{
						_localctx = new NumDivContext(new ZExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_zExpr);
						setState(333);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(334); 
						match(DIV);
						setState(335); 
						zExpr(7);
						}
						break;
					case 6:
						{
						_localctx = new NumModContext(new ZExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_zExpr);
						setState(336);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(337); 
						match(MOD);
						setState(338); 
						zExpr(6);
						}
						break;
					case 7:
						{
						_localctx = new NumPlusContext(new ZExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_zExpr);
						setState(339);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(340); 
						match(PLUS);
						setState(341); 
						zExpr(5);
						}
						break;
					case 8:
						{
						_localctx = new NumMinusContext(new ZExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_zExpr);
						setState(342);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(343); 
						match(MINUS);
						setState(344); 
						zExpr(4);
						}
						break;
					case 9:
						{
						_localctx = new StrConcatContext(new ZExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_zExpr);
						setState(345);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(346); 
						match(T__37);
						setState(347); 
						zExpr(3);
						}
						break;
					case 10:
						{
						_localctx = new ProdProjContext(new ZExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_zExpr);
						setState(348);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(349); 
						match(T__31);
						setState(350); 
						match(TUPPROJ);
						}
						break;
					case 11:
						{
						_localctx = new SetElemContext(new ZExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_zExpr);
						setState(351);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(352); 
						match(T__31);
						setState(353); 
						match(NUMBER);
						}
						break;
					case 12:
						{
						_localctx = new SetDomContext(new ZExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_zExpr);
						setState(354);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(355); 
						match(T__31);
						setState(356); 
						match(DOM);
						}
						break;
					case 13:
						{
						_localctx = new SetRanContext(new ZExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_zExpr);
						setState(357);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(358); 
						match(T__31);
						setState(359); 
						match(RAN);
						}
						break;
					case 14:
						{
						_localctx = new SetProjContext(new ZExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_zExpr);
						setState(360);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(361); 
						match(T__31);
						setState(362); 
						match(PROJ);
						}
						break;
					case 15:
						{
						_localctx = new SetCardContext(new ZExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_zExpr);
						setState(363);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(364); 
						match(T__36);
						}
						break;
					}
					} 
				}
				setState(369);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 24: 
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\39\u0175\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\3\2\3\2\3\2\3\2\5\29\n\2\3\2\3\2\5\2=\n\2\3\2\3\2\5\2A\n\2"+
		"\3\3\3\3\3\3\6\3F\n\3\r\3\16\3G\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\7\6R\n"+
		"\6\f\6\16\6U\13\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7_\n\7\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\7\tm\n\t\f\t\16\tp\13\t\5\tr\n\t"+
		"\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\7\13\u0082"+
		"\n\13\f\13\16\13\u0085\13\13\5\13\u0087\n\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\7\13\u0090\n\13\f\13\16\13\u0093\13\13\5\13\u0095\n\13\3\13"+
		"\3\13\3\f\3\f\3\f\3\f\3\f\3\f\7\f\u009f\n\f\f\f\16\f\u00a2\13\f\5\f\u00a4"+
		"\n\f\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\20\3\20\3\20\7\20"+
		"\u00b3\n\20\f\20\16\20\u00b6\13\20\3\20\3\20\3\21\3\21\3\21\3\21\3\22"+
		"\3\22\3\22\3\22\7\22\u00c2\n\22\f\22\16\22\u00c5\13\22\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\7\23\u00cd\n\23\f\23\16\23\u00d0\13\23\5\23\u00d2\n\23"+
		"\3\23\3\23\3\23\3\24\3\24\3\24\3\24\6\24\u00db\n\24\r\24\16\24\u00dc\3"+
		"\25\3\25\5\25\u00e1\n\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\7\26\u00ea"+
		"\n\26\f\26\16\26\u00ed\13\26\3\27\3\27\5\27\u00f1\n\27\3\27\5\27\u00f4"+
		"\n\27\3\30\3\30\3\30\5\30\u00f9\n\30\3\30\5\30\u00fc\n\30\3\31\3\31\3"+
		"\31\5\31\u0101\n\31\3\31\3\31\3\31\3\31\7\31\u0107\n\31\f\31\16\31\u010a"+
		"\13\31\3\31\3\31\5\31\u010e\n\31\3\31\3\31\3\31\5\31\u0113\n\31\3\31\3"+
		"\31\3\31\3\31\3\31\7\31\u011a\n\31\f\31\16\31\u011d\13\31\3\31\3\31\5"+
		"\31\u0121\n\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\7\32\u012c"+
		"\n\32\f\32\16\32\u012f\13\32\3\32\3\32\3\32\3\32\3\32\3\32\7\32\u0137"+
		"\n\32\f\32\16\32\u013a\13\32\3\32\3\32\3\32\3\32\3\32\3\32\5\32\u0142"+
		"\n\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\7\32\u0170\n\32\f\32\16\32\u0173\13\32\3\32\2\3\62\33"+
		"\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\2\3\4\2*+88\u0199"+
		"\2\64\3\2\2\2\4B\3\2\2\2\6I\3\2\2\2\bK\3\2\2\2\nO\3\2\2\2\f^\3\2\2\2\16"+
		"`\3\2\2\2\20f\3\2\2\2\22u\3\2\2\2\24{\3\2\2\2\26\u0098\3\2\2\2\30\u00a7"+
		"\3\2\2\2\32\u00a9\3\2\2\2\34\u00ab\3\2\2\2\36\u00ad\3\2\2\2 \u00b9\3\2"+
		"\2\2\"\u00bd\3\2\2\2$\u00c6\3\2\2\2&\u00d6\3\2\2\2(\u00e0\3\2\2\2*\u00e4"+
		"\3\2\2\2,\u00f3\3\2\2\2.\u00fb\3\2\2\2\60\u0120\3\2\2\2\62\u0141\3\2\2"+
		"\2\64\65\7\3\2\2\65\66\7*\2\2\668\5\4\3\2\679\5\n\6\28\67\3\2\2\289\3"+
		"\2\2\29:\3\2\2\2:<\5\"\22\2;=\5\6\4\2<;\3\2\2\2<=\3\2\2\2=>\3\2\2\2>@"+
		"\5$\23\2?A\5&\24\2@?\3\2\2\2@A\3\2\2\2A\3\3\2\2\2BE\7\4\2\2CF\5\6\4\2"+
		"DF\5\b\5\2EC\3\2\2\2ED\3\2\2\2FG\3\2\2\2GE\3\2\2\2GH\3\2\2\2H\5\3\2\2"+
		"\2IJ\7\5\2\2J\7\3\2\2\2KL\7*\2\2LM\7\6\2\2MN\7)\2\2N\t\3\2\2\2OS\7\7\2"+
		"\2PR\5\16\b\2QP\3\2\2\2RU\3\2\2\2SQ\3\2\2\2ST\3\2\2\2T\13\3\2\2\2US\3"+
		"\2\2\2V_\5\20\t\2W_\5\22\n\2X_\5\26\f\2Y_\5\24\13\2Z_\5\16\b\2[_\5\30"+
		"\r\2\\_\5\32\16\2]_\5\34\17\2^V\3\2\2\2^W\3\2\2\2^X\3\2\2\2^Y\3\2\2\2"+
		"^Z\3\2\2\2^[\3\2\2\2^\\\3\2\2\2^]\3\2\2\2_\r\3\2\2\2`a\7\b\2\2ab\7*\2"+
		"\2bc\7\t\2\2cd\5\f\7\2de\7)\2\2e\17\3\2\2\2fg\7\n\2\2gh\7*\2\2hq\7\13"+
		"\2\2in\7*\2\2jk\7\f\2\2km\7*\2\2lj\3\2\2\2mp\3\2\2\2nl\3\2\2\2no\3\2\2"+
		"\2or\3\2\2\2pn\3\2\2\2qi\3\2\2\2qr\3\2\2\2rs\3\2\2\2st\7\r\2\2t\21\3\2"+
		"\2\2uv\7\16\2\2vw\7*\2\2wx\7\13\2\2xy\7+\2\2yz\7\r\2\2z\23\3\2\2\2{|\7"+
		"\17\2\2|}\7*\2\2}\u0086\7\13\2\2~\u0083\7*\2\2\177\u0080\7\f\2\2\u0080"+
		"\u0082\7*\2\2\u0081\177\3\2\2\2\u0082\u0085\3\2\2\2\u0083\u0081\3\2\2"+
		"\2\u0083\u0084\3\2\2\2\u0084\u0087\3\2\2\2\u0085\u0083\3\2\2\2\u0086~"+
		"\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u0088\3\2\2\2\u0088\u0089\7\r\2\2\u0089"+
		"\u008a\7\20\2\2\u008a\u008b\7*\2\2\u008b\u0094\7\13\2\2\u008c\u0091\7"+
		"*\2\2\u008d\u008e\7\f\2\2\u008e\u0090\7*\2\2\u008f\u008d\3\2\2\2\u0090"+
		"\u0093\3\2\2\2\u0091\u008f\3\2\2\2\u0091\u0092\3\2\2\2\u0092\u0095\3\2"+
		"\2\2\u0093\u0091\3\2\2\2\u0094\u008c\3\2\2\2\u0094\u0095\3\2\2\2\u0095"+
		"\u0096\3\2\2\2\u0096\u0097\7\r\2\2\u0097\25\3\2\2\2\u0098\u0099\7\21\2"+
		"\2\u0099\u009a\7*\2\2\u009a\u00a3\7\13\2\2\u009b\u00a0\7*\2\2\u009c\u009d"+
		"\7\f\2\2\u009d\u009f\7*\2\2\u009e\u009c\3\2\2\2\u009f\u00a2\3\2\2\2\u00a0"+
		"\u009e\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\u00a4\3\2\2\2\u00a2\u00a0\3\2"+
		"\2\2\u00a3\u009b\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5"+
		"\u00a6\7\r\2\2\u00a6\27\3\2\2\2\u00a7\u00a8\7\22\2\2\u00a8\31\3\2\2\2"+
		"\u00a9\u00aa\7\23\2\2\u00aa\33\3\2\2\2\u00ab\u00ac\7\24\2\2\u00ac\35\3"+
		"\2\2\2\u00ad\u00ae\7\25\2\2\u00ae\u00af\7\26\2\2\u00af\u00b4\5 \21\2\u00b0"+
		"\u00b1\7\f\2\2\u00b1\u00b3\5 \21\2\u00b2\u00b0\3\2\2\2\u00b3\u00b6\3\2"+
		"\2\2\u00b4\u00b2\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00b7\3\2\2\2\u00b6"+
		"\u00b4\3\2\2\2\u00b7\u00b8\7\27\2\2\u00b8\37\3\2\2\2\u00b9\u00ba\7*\2"+
		"\2\u00ba\u00bb\7\30\2\2\u00bb\u00bc\t\2\2\2\u00bc!\3\2\2\2\u00bd\u00c3"+
		"\7\31\2\2\u00be\u00bf\5(\25\2\u00bf\u00c0\7)\2\2\u00c0\u00c2\3\2\2\2\u00c1"+
		"\u00be\3\2\2\2\u00c2\u00c5\3\2\2\2\u00c3\u00c1\3\2\2\2\u00c3\u00c4\3\2"+
		"\2\2\u00c4#\3\2\2\2\u00c5\u00c3\3\2\2\2\u00c6\u00c7\7\32\2\2\u00c7\u00c8"+
		"\7*\2\2\u00c8\u00d1\7\13\2\2\u00c9\u00ce\7*\2\2\u00ca\u00cb\7\f\2\2\u00cb"+
		"\u00cd\7*\2\2\u00cc\u00ca\3\2\2\2\u00cd\u00d0\3\2\2\2\u00ce\u00cc\3\2"+
		"\2\2\u00ce\u00cf\3\2\2\2\u00cf\u00d2\3\2\2\2\u00d0\u00ce\3\2\2\2\u00d1"+
		"\u00c9\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3\u00d4\7\r"+
		"\2\2\u00d4\u00d5\7)\2\2\u00d5%\3\2\2\2\u00d6\u00da\7\33\2\2\u00d7\u00db"+
		"\5\6\4\2\u00d8\u00d9\7*\2\2\u00d9\u00db\7\34\2\2\u00da\u00d7\3\2\2\2\u00da"+
		"\u00d8\3\2\2\2\u00db\u00dc\3\2\2\2\u00dc\u00da\3\2\2\2\u00dc\u00dd\3\2"+
		"\2\2\u00dd\'\3\2\2\2\u00de\u00df\7*\2\2\u00df\u00e1\7\35\2\2\u00e0\u00de"+
		"\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2\u00e3\5*\26\2\u00e3"+
		")\3\2\2\2\u00e4\u00e5\5\62\32\2\u00e5\u00e6\7\36\2\2\u00e6\u00eb\5,\27"+
		"\2\u00e7\u00e8\7\f\2\2\u00e8\u00ea\5,\27\2\u00e9\u00e7\3\2\2\2\u00ea\u00ed"+
		"\3\2\2\2\u00eb\u00e9\3\2\2\2\u00eb\u00ec\3\2\2\2\u00ec+\3\2\2\2\u00ed"+
		"\u00eb\3\2\2\2\u00ee\u00f0\5.\30\2\u00ef\u00f1\5\60\31\2\u00f0\u00ef\3"+
		"\2\2\2\u00f0\u00f1\3\2\2\2\u00f1\u00f4\3\2\2\2\u00f2\u00f4\5*\26\2\u00f3"+
		"\u00ee\3\2\2\2\u00f3\u00f2\3\2\2\2\u00f4-\3\2\2\2\u00f5\u00fc\7*\2\2\u00f6"+
		"\u00f8\7\26\2\2\u00f7\u00f9\7+\2\2\u00f8\u00f7\3\2\2\2\u00f8\u00f9\3\2"+
		"\2\2\u00f9\u00fa\3\2\2\2\u00fa\u00fc\7\27\2\2\u00fb\u00f5\3\2\2\2\u00fb"+
		"\u00f6\3\2\2\2\u00fc/\3\2\2\2\u00fd\u0100\7\37\2\2\u00fe\u0101\5\f\7\2"+
		"\u00ff\u0101\7*\2\2\u0100\u00fe\3\2\2\2\u0100\u00ff\3\2\2\2\u0101\u010d"+
		"\3\2\2\2\u0102\u0103\7\26\2\2\u0103\u0108\5 \21\2\u0104\u0105\7\f\2\2"+
		"\u0105\u0107\5 \21\2\u0106\u0104\3\2\2\2\u0107\u010a\3\2\2\2\u0108\u0106"+
		"\3\2\2\2\u0108\u0109\3\2\2\2\u0109\u010b\3\2\2\2\u010a\u0108\3\2\2\2\u010b"+
		"\u010c\7\27\2\2\u010c\u010e\3\2\2\2\u010d\u0102\3\2\2\2\u010d\u010e\3"+
		"\2\2\2\u010e\u0121\3\2\2\2\u010f\u0112\7\37\2\2\u0110\u0113\5\f\7\2\u0111"+
		"\u0113\7*\2\2\u0112\u0110\3\2\2\2\u0112\u0111\3\2\2\2\u0113\u0114\3\2"+
		"\2\2\u0114\u0115\7 \2\2\u0115\u0116\7\26\2\2\u0116\u011b\5*\26\2\u0117"+
		"\u0118\7\f\2\2\u0118\u011a\5*\26\2\u0119\u0117\3\2\2\2\u011a\u011d\3\2"+
		"\2\2\u011b\u0119\3\2\2\2\u011b\u011c\3\2\2\2\u011c\u011e\3\2\2\2\u011d"+
		"\u011b\3\2\2\2\u011e\u011f\7\27\2\2\u011f\u0121\3\2\2\2\u0120\u00fd\3"+
		"\2\2\2\u0120\u010f\3\2\2\2\u0121\61\3\2\2\2\u0122\u0123\b\32\1\2\u0123"+
		"\u0142\7*\2\2\u0124\u0142\7+\2\2\u0125\u0142\78\2\2\u0126\u0142\7!\2\2"+
		"\u0127\u0128\7#\2\2\u0128\u012d\5\62\32\2\u0129\u012a\7\f\2\2\u012a\u012c"+
		"\5\62\32\2\u012b\u0129\3\2\2\2\u012c\u012f\3\2\2\2\u012d\u012b\3\2\2\2"+
		"\u012d\u012e\3\2\2\2\u012e\u0130\3\2\2\2\u012f\u012d\3\2\2\2\u0130\u0131"+
		"\7$\2\2\u0131\u0142\3\2\2\2\u0132\u0133\7%\2\2\u0133\u0138\5\62\32\2\u0134"+
		"\u0135\7\f\2\2\u0135\u0137\5\62\32\2\u0136\u0134\3\2\2\2\u0137\u013a\3"+
		"\2\2\2\u0138\u0136\3\2\2\2\u0138\u0139\3\2\2\2\u0139\u013b\3\2\2\2\u013a"+
		"\u0138\3\2\2\2\u013b\u013c\7&\2\2\u013c\u0142\3\2\2\2\u013d\u013e\7\13"+
		"\2\2\u013e\u013f\5\62\32\2\u013f\u0140\7\r\2\2\u0140\u0142\3\2\2\2\u0141"+
		"\u0122\3\2\2\2\u0141\u0124\3\2\2\2\u0141\u0125\3\2\2\2\u0141\u0126\3\2"+
		"\2\2\u0141\u0127\3\2\2\2\u0141\u0132\3\2\2\2\u0141\u013d\3\2\2\2\u0142"+
		"\u0171\3\2\2\2\u0143\u0144\f\16\2\2\u0144\u0145\7\65\2\2\u0145\u0170\5"+
		"\62\32\17\u0146\u0147\f\r\2\2\u0147\u0148\7\66\2\2\u0148\u0170\5\62\32"+
		"\16\u0149\u014a\f\f\2\2\u014a\u014b\7\67\2\2\u014b\u0170\5\62\32\r\u014c"+
		"\u014d\f\t\2\2\u014d\u014e\7.\2\2\u014e\u0170\5\62\32\n\u014f\u0150\f"+
		"\b\2\2\u0150\u0151\7/\2\2\u0151\u0170\5\62\32\t\u0152\u0153\f\7\2\2\u0153"+
		"\u0154\7\60\2\2\u0154\u0170\5\62\32\b\u0155\u0156\f\6\2\2\u0156\u0157"+
		"\7,\2\2\u0157\u0170\5\62\32\7\u0158\u0159\f\5\2\2\u0159\u015a\7-\2\2\u015a"+
		"\u0170\5\62\32\6\u015b\u015c\f\4\2\2\u015c\u015d\7(\2\2\u015d\u0170\5"+
		"\62\32\5\u015e\u015f\f\24\2\2\u015f\u0160\7\"\2\2\u0160\u0170\7\64\2\2"+
		"\u0161\u0162\f\22\2\2\u0162\u0163\7\"\2\2\u0163\u0170\7+\2\2\u0164\u0165"+
		"\f\21\2\2\u0165\u0166\7\"\2\2\u0166\u0170\7\61\2\2\u0167\u0168\f\20\2"+
		"\2\u0168\u0169\7\"\2\2\u0169\u0170\7\62\2\2\u016a\u016b\f\17\2\2\u016b"+
		"\u016c\7\"\2\2\u016c\u0170\7\63\2\2\u016d\u016e\f\n\2\2\u016e\u0170\7"+
		"\'\2\2\u016f\u0143\3\2\2\2\u016f\u0146\3\2\2\2\u016f\u0149\3\2\2\2\u016f"+
		"\u014c\3\2\2\2\u016f\u014f\3\2\2\2\u016f\u0152\3\2\2\2\u016f\u0155\3\2"+
		"\2\2\u016f\u0158\3\2\2\2\u016f\u015b\3\2\2\2\u016f\u015e\3\2\2\2\u016f"+
		"\u0161\3\2\2\2\u016f\u0164\3\2\2\2\u016f\u0167\3\2\2\2\u016f\u016a\3\2"+
		"\2\2\u016f\u016d\3\2\2\2\u0170\u0173\3\2\2\2\u0171\u016f\3\2\2\2\u0171"+
		"\u0172\3\2\2\2\u0172\63\3\2\2\2\u0173\u0171\3\2\2\2(8<@EGS^nq\u0083\u0086"+
		"\u0091\u0094\u00a0\u00a3\u00b4\u00c3\u00ce\u00d1\u00da\u00dc\u00e0\u00eb"+
		"\u00f0\u00f3\u00f8\u00fb\u0100\u0108\u010d\u0112\u011b\u0120\u012d\u0138"+
		"\u0141\u016f\u0171";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}