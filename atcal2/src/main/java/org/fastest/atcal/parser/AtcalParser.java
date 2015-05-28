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
		T__38=39, STMTEND=40, ID=41, NUMBER=42, PLUS=43, MINUS=44, MUL=45, DIV=46, 
		MOD=47, DOM=48, RAN=49, PROJ=50, TUPPROJ=51, INTER=52, UNION=53, DIFF=54, 
		ELEM=55, STRING=56, WS=57;
	public static final int
		RULE_refinementRule = 0, RULE_preamble = 1, RULE_plcode = 2, RULE_preambleImport = 3, 
		RULE_datatypes = 4, RULE_typeDec = 5, RULE_type = 6, RULE_args = 7, RULE_typeCases = 8, 
		RULE_typeCase = 9, RULE_laws = 10, RULE_uut = 11, RULE_epilogue = 12, 
		RULE_law = 13, RULE_lawRefinement = 14, RULE_refinement = 15, RULE_lvalue = 16, 
		RULE_asRef = 17, RULE_zExpr = 18;
	public static final String[] ruleNames = {
		"refinementRule", "preamble", "plcode", "preambleImport", "datatypes", 
		"typeDec", "type", "args", "typeCases", "typeCase", "laws", "uut", "epilogue", 
		"law", "lawRefinement", "refinement", "lvalue", "asRef", "zExpr"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'@RRULE'", "'@PREAMBLE'", "'@PLCODE'", "'.@PREAMBLE'", "'@DATATYPES'", 
		"'DATATYPE'", "'='", "'INT'", "'FLOAT'", "'STRING'", "'ARRAY'", "'('", 
		"')'", "'ENUM'", "'RECORD'", "':'", "','", "'CONSTRUCTOR'", "'SETTER'", 
		"'GETTER'", "'MAP'", "'['", "']'", "'->'", "'@LAWS'", "'@UUT'", "'@EPILOGUE'", 
		"'.@EPILOGUE'", "'==>'", "'.'", "'AS'", "'WITH'", "'@AUTOFILL'", "'<'", 
		"'>'", "'{'", "'}'", "'.@CARD'", "'++'", null, null, null, "'+'", "'-'", 
		"'*'", "'/'", "'%'", "'@DOM'", "'@RAN'", null, null, "'/\\'", "'\\/'", 
		"'~'", "'@ELEM'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, "STMTEND", "ID", "NUMBER", "PLUS", "MINUS", "MUL", 
		"DIV", "MOD", "DOM", "RAN", "PROJ", "TUPPROJ", "INTER", "UNION", "DIFF", 
		"ELEM", "STRING", "WS"
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
			setState(38); 
			match(T__0);
			setState(39); 
			match(ID);
			setState(40); 
			preamble();
			setState(42);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(41); 
				datatypes();
				}
			}

			setState(44); 
			laws();
			setState(46);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(45); 
				plcode();
				}
			}

			setState(48); 
			uut();
			setState(50);
			_la = _input.LA(1);
			if (_la==T__26) {
				{
				setState(49); 
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
			setState(52); 
			match(T__1);
			setState(55); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(55);
				switch (_input.LA(1)) {
				case T__2:
					{
					setState(53); 
					plcode();
					}
					break;
				case ID:
					{
					setState(54); 
					preambleImport();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(57); 
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
			setState(59); 
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
			setState(61); 
			match(ID);
			setState(62); 
			match(T__3);
			setState(63); 
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
		enterRule(_localctx, 8, RULE_datatypes);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(65); 
			match(T__4);
			setState(69);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__5) {
				{
				{
				setState(66); 
				typeDec();
				}
				}
				setState(71);
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
		enterRule(_localctx, 10, RULE_typeDec);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72); 
			match(T__5);
			setState(73); 
			match(ID);
			setState(74); 
			match(T__6);
			setState(75); 
			type();
			setState(76); 
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
		public TerminalNode ID() { return getToken(AtcalParser.ID, 0); }
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
		enterRule(_localctx, 12, RULE_type);
		int _la;
		try {
			setState(117);
			switch (_input.LA(1)) {
			case ID:
				_localctx = new NameTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(78); 
				match(ID);
				}
				break;
			case T__7:
				_localctx = new IntTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(79); 
				match(T__7);
				}
				break;
			case T__8:
				_localctx = new FloatTypeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(80); 
				match(T__8);
				}
				break;
			case T__9:
				_localctx = new StringTypeContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(81); 
				match(T__9);
				}
				break;
			case T__10:
				_localctx = new ArrayTypeContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(82); 
				match(T__10);
				setState(83); 
				match(ID);
				setState(84); 
				match(T__11);
				setState(85); 
				match(NUMBER);
				setState(86); 
				match(T__12);
				}
				break;
			case T__13:
				_localctx = new EnumTypeContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(87); 
				match(T__13);
				setState(88); 
				match(ID);
				setState(89); 
				args();
				}
				break;
			case T__14:
				_localctx = new RecordTypeContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(90); 
				match(T__14);
				setState(91); 
				match(ID);
				setState(92); 
				match(T__11);
				setState(93); 
				match(ID);
				setState(94); 
				match(T__15);
				setState(95); 
				type();
				setState(102);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__16) {
					{
					{
					setState(96); 
					match(T__16);
					setState(97); 
					match(ID);
					setState(98); 
					match(T__15);
					setState(99); 
					type();
					}
					}
					setState(104);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(105); 
				match(T__12);
				}
				break;
			case T__17:
				_localctx = new ContractTypeContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(107); 
				match(T__17);
				setState(108); 
				match(ID);
				setState(109); 
				args();
				setState(110); 
				match(T__18);
				setState(111); 
				match(ID);
				setState(112); 
				args();
				setState(113); 
				match(T__19);
				setState(114); 
				match(ID);
				setState(115); 
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
		enterRule(_localctx, 14, RULE_args);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119); 
			match(T__11);
			setState(128);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(120); 
				match(ID);
				setState(125);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__16) {
					{
					{
					setState(121); 
					match(T__16);
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
			match(T__12);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 16, RULE_typeCases);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132); 
			match(T__20);
			setState(133); 
			match(T__21);
			setState(134); 
			typeCase();
			setState(139);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__16) {
				{
				{
				setState(135); 
				match(T__16);
				setState(136); 
				typeCase();
				}
				}
				setState(141);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(142); 
			match(T__22);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 18, RULE_typeCase);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144); 
			match(ID);
			setState(145); 
			match(T__23);
			setState(146);
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
		enterRule(_localctx, 20, RULE_laws);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(148); 
			match(T__24);
			setState(154);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__11) | (1L << T__32) | (1L << T__33) | (1L << T__35) | (1L << ID) | (1L << NUMBER) | (1L << ELEM) | (1L << STRING))) != 0)) {
				{
				{
				setState(149); 
				law();
				setState(150); 
				match(STMTEND);
				}
				}
				setState(156);
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
		enterRule(_localctx, 22, RULE_uut);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(157); 
			match(T__25);
			setState(158); 
			match(ID);
			setState(159); 
			match(T__11);
			setState(168);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(160); 
				match(ID);
				setState(165);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__16) {
					{
					{
					setState(161); 
					match(T__16);
					setState(162); 
					match(ID);
					}
					}
					setState(167);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(170); 
			match(T__12);
			setState(171); 
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
		enterRule(_localctx, 24, RULE_epilogue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(173); 
			match(T__26);
			setState(177); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(177);
				switch (_input.LA(1)) {
				case T__2:
					{
					setState(174); 
					plcode();
					}
					break;
				case ID:
					{
					setState(175); 
					match(ID);
					setState(176); 
					match(T__27);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(179); 
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
		enterRule(_localctx, 26, RULE_law);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(183);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				setState(181); 
				match(ID);
				setState(182); 
				match(T__15);
				}
				break;
			}
			{
			setState(185); 
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
		enterRule(_localctx, 28, RULE_lawRefinement);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(187); 
			zExpr(0);
			setState(188); 
			match(T__28);
			setState(189); 
			refinement();
			setState(194);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(190); 
					match(T__16);
					setState(191); 
					refinement();
					}
					} 
				}
				setState(196);
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
		enterRule(_localctx, 30, RULE_refinement);
		try {
			setState(201);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				_localctx = new ImplRefContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(197); 
				lvalue();
				setState(198); 
				asRef();
				}
				break;
			case 2:
				_localctx = new ZExprRefContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(200); 
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
			setState(211);
			switch (_input.LA(1)) {
			case ID:
				_localctx = new VarLValueContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(203); 
				match(ID);
				}
				break;
			case T__21:
				_localctx = new ArrayLValueContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(204); 
				match(T__21);
				setState(206);
				_la = _input.LA(1);
				if (_la==NUMBER) {
					{
					setState(205); 
					match(NUMBER);
					}
				}

				setState(208); 
				match(T__22);
				}
				break;
			case T__29:
				_localctx = new FieldLValueContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(209); 
				match(T__29);
				setState(210); 
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
	public static class SimpleRefContext extends AsRefContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public SimpleRefContext(AsRefContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AtcalVisitor ) return ((AtcalVisitor<? extends T>)visitor).visitSimpleRef(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class WithRefContext extends AsRefContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<LawRefinementContext> lawRefinement() {
			return getRuleContexts(LawRefinementContext.class);
		}
		public LawRefinementContext lawRefinement(int i) {
			return getRuleContext(LawRefinementContext.class,i);
		}
		public WithRefContext(AsRefContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AtcalVisitor ) return ((AtcalVisitor<? extends T>)visitor).visitWithRef(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BijMapRefContext extends AsRefContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TypeCasesContext typeCases() {
			return getRuleContext(TypeCasesContext.class,0);
		}
		public BijMapRefContext(AsRefContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AtcalVisitor ) return ((AtcalVisitor<? extends T>)visitor).visitBijMapRef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AsRefContext asRef() throws RecognitionException {
		AsRefContext _localctx = new AsRefContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_asRef);
		int _la;
		try {
			setState(233);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				_localctx = new SimpleRefContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(213); 
				match(T__30);
				setState(214); 
				type();
				}
				break;
			case 2:
				_localctx = new BijMapRefContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(215); 
				match(T__30);
				setState(216); 
				type();
				setState(217); 
				typeCases();
				}
				break;
			case 3:
				_localctx = new WithRefContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(219); 
				match(T__30);
				setState(220); 
				type();
				setState(221); 
				match(T__31);
				setState(222); 
				match(T__21);
				setState(223); 
				lawRefinement();
				setState(228);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__16) {
					{
					{
					setState(224); 
					match(T__16);
					setState(225); 
					lawRefinement();
					}
					}
					setState(230);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(231); 
				match(T__22);
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
		int _startState = 36;
		enterRecursionRule(_localctx, 36, RULE_zExpr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(267);
			switch (_input.LA(1)) {
			case ID:
				{
				_localctx = new IdentContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(236); 
				match(ID);
				}
				break;
			case NUMBER:
				{
				_localctx = new NumLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(237); 
				match(NUMBER);
				}
				break;
			case STRING:
				{
				_localctx = new StrLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(238); 
				match(STRING);
				}
				break;
			case T__32:
				{
				_localctx = new AutoExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(239); 
				match(T__32);
				}
				break;
			case ELEM:
				{
				_localctx = new ElemExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(240); 
				match(ELEM);
				}
				break;
			case T__33:
				{
				_localctx = new ProdConsContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(241); 
				match(T__33);
				setState(242); 
				zExpr(0);
				setState(247);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__16) {
					{
					{
					setState(243); 
					match(T__16);
					setState(244); 
					zExpr(0);
					}
					}
					setState(249);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(250); 
				match(T__34);
				}
				break;
			case T__35:
				{
				_localctx = new SetConsContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(252); 
				match(T__35);
				setState(253); 
				zExpr(0);
				setState(258);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__16) {
					{
					{
					setState(254); 
					match(T__16);
					setState(255); 
					zExpr(0);
					}
					}
					setState(260);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(261); 
				match(T__36);
				}
				break;
			case T__11:
				{
				_localctx = new GroupContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(263); 
				match(T__11);
				setState(264); 
				zExpr(0);
				setState(265); 
				match(T__12);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(315);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(313);
					switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
					case 1:
						{
						_localctx = new SetInterContext(new ZExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_zExpr);
						setState(269);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(270); 
						match(INTER);
						setState(271); 
						zExpr(13);
						}
						break;
					case 2:
						{
						_localctx = new SetUnionContext(new ZExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_zExpr);
						setState(272);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(273); 
						match(UNION);
						setState(274); 
						zExpr(12);
						}
						break;
					case 3:
						{
						_localctx = new SetDiffContext(new ZExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_zExpr);
						setState(275);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(276); 
						match(DIFF);
						setState(277); 
						zExpr(11);
						}
						break;
					case 4:
						{
						_localctx = new NumMulContext(new ZExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_zExpr);
						setState(278);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(279); 
						match(MUL);
						setState(280); 
						zExpr(8);
						}
						break;
					case 5:
						{
						_localctx = new NumDivContext(new ZExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_zExpr);
						setState(281);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(282); 
						match(DIV);
						setState(283); 
						zExpr(7);
						}
						break;
					case 6:
						{
						_localctx = new NumModContext(new ZExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_zExpr);
						setState(284);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(285); 
						match(MOD);
						setState(286); 
						zExpr(6);
						}
						break;
					case 7:
						{
						_localctx = new NumPlusContext(new ZExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_zExpr);
						setState(287);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(288); 
						match(PLUS);
						setState(289); 
						zExpr(5);
						}
						break;
					case 8:
						{
						_localctx = new NumMinusContext(new ZExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_zExpr);
						setState(290);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(291); 
						match(MINUS);
						setState(292); 
						zExpr(4);
						}
						break;
					case 9:
						{
						_localctx = new StrConcatContext(new ZExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_zExpr);
						setState(293);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(294); 
						match(T__38);
						setState(295); 
						zExpr(3);
						}
						break;
					case 10:
						{
						_localctx = new ProdProjContext(new ZExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_zExpr);
						setState(296);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(297); 
						match(T__29);
						setState(298); 
						match(TUPPROJ);
						}
						break;
					case 11:
						{
						_localctx = new SetElemContext(new ZExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_zExpr);
						setState(299);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(300); 
						match(T__29);
						setState(301); 
						match(NUMBER);
						}
						break;
					case 12:
						{
						_localctx = new SetDomContext(new ZExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_zExpr);
						setState(302);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(303); 
						match(T__29);
						setState(304); 
						match(DOM);
						}
						break;
					case 13:
						{
						_localctx = new SetRanContext(new ZExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_zExpr);
						setState(305);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(306); 
						match(T__29);
						setState(307); 
						match(RAN);
						}
						break;
					case 14:
						{
						_localctx = new SetProjContext(new ZExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_zExpr);
						setState(308);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(309); 
						match(T__29);
						setState(310); 
						match(PROJ);
						}
						break;
					case 15:
						{
						_localctx = new SetCardContext(new ZExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_zExpr);
						setState(311);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(312); 
						match(T__37);
						}
						break;
					}
					} 
				}
				setState(317);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3;\u0141\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\3\2\3\2\3\2\3\2\5\2-\n\2\3\2\3\2\5\2\61\n\2\3\2\3"+
		"\2\5\2\65\n\2\3\3\3\3\3\3\6\3:\n\3\r\3\16\3;\3\4\3\4\3\5\3\5\3\5\3\5\3"+
		"\6\3\6\7\6F\n\6\f\6\16\6I\13\6\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\7\bg\n\b\f\b\16\bj\13\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\5\bx\n\b\3\t\3\t\3\t\3\t\7\t~\n\t\f\t\16\t\u0081\13\t\5\t\u0083\n"+
		"\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\7\n\u008c\n\n\f\n\16\n\u008f\13\n\3\n\3"+
		"\n\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\7\f\u009b\n\f\f\f\16\f\u009e\13"+
		"\f\3\r\3\r\3\r\3\r\3\r\3\r\7\r\u00a6\n\r\f\r\16\r\u00a9\13\r\5\r\u00ab"+
		"\n\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\6\16\u00b4\n\16\r\16\16\16\u00b5"+
		"\3\17\3\17\5\17\u00ba\n\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\7\20\u00c3"+
		"\n\20\f\20\16\20\u00c6\13\20\3\21\3\21\3\21\3\21\5\21\u00cc\n\21\3\22"+
		"\3\22\3\22\5\22\u00d1\n\22\3\22\3\22\3\22\5\22\u00d6\n\22\3\23\3\23\3"+
		"\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\7\23\u00e5\n\23"+
		"\f\23\16\23\u00e8\13\23\3\23\3\23\5\23\u00ec\n\23\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\7\24\u00f8\n\24\f\24\16\24\u00fb\13\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\7\24\u0103\n\24\f\24\16\24\u0106\13\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u010e\n\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\7\24\u013c\n\24"+
		"\f\24\16\24\u013f\13\24\3\24\2\3&\25\2\4\6\b\n\f\16\20\22\24\26\30\32"+
		"\34\36 \"$&\2\3\4\2+,::\u0164\2(\3\2\2\2\4\66\3\2\2\2\6=\3\2\2\2\b?\3"+
		"\2\2\2\nC\3\2\2\2\fJ\3\2\2\2\16w\3\2\2\2\20y\3\2\2\2\22\u0086\3\2\2\2"+
		"\24\u0092\3\2\2\2\26\u0096\3\2\2\2\30\u009f\3\2\2\2\32\u00af\3\2\2\2\34"+
		"\u00b9\3\2\2\2\36\u00bd\3\2\2\2 \u00cb\3\2\2\2\"\u00d5\3\2\2\2$\u00eb"+
		"\3\2\2\2&\u010d\3\2\2\2()\7\3\2\2)*\7+\2\2*,\5\4\3\2+-\5\n\6\2,+\3\2\2"+
		"\2,-\3\2\2\2-.\3\2\2\2.\60\5\26\f\2/\61\5\6\4\2\60/\3\2\2\2\60\61\3\2"+
		"\2\2\61\62\3\2\2\2\62\64\5\30\r\2\63\65\5\32\16\2\64\63\3\2\2\2\64\65"+
		"\3\2\2\2\65\3\3\2\2\2\669\7\4\2\2\67:\5\6\4\28:\5\b\5\29\67\3\2\2\298"+
		"\3\2\2\2:;\3\2\2\2;9\3\2\2\2;<\3\2\2\2<\5\3\2\2\2=>\7\5\2\2>\7\3\2\2\2"+
		"?@\7+\2\2@A\7\6\2\2AB\7*\2\2B\t\3\2\2\2CG\7\7\2\2DF\5\f\7\2ED\3\2\2\2"+
		"FI\3\2\2\2GE\3\2\2\2GH\3\2\2\2H\13\3\2\2\2IG\3\2\2\2JK\7\b\2\2KL\7+\2"+
		"\2LM\7\t\2\2MN\5\16\b\2NO\7*\2\2O\r\3\2\2\2Px\7+\2\2Qx\7\n\2\2Rx\7\13"+
		"\2\2Sx\7\f\2\2TU\7\r\2\2UV\7+\2\2VW\7\16\2\2WX\7,\2\2Xx\7\17\2\2YZ\7\20"+
		"\2\2Z[\7+\2\2[x\5\20\t\2\\]\7\21\2\2]^\7+\2\2^_\7\16\2\2_`\7+\2\2`a\7"+
		"\22\2\2ah\5\16\b\2bc\7\23\2\2cd\7+\2\2de\7\22\2\2eg\5\16\b\2fb\3\2\2\2"+
		"gj\3\2\2\2hf\3\2\2\2hi\3\2\2\2ik\3\2\2\2jh\3\2\2\2kl\7\17\2\2lx\3\2\2"+
		"\2mn\7\24\2\2no\7+\2\2op\5\20\t\2pq\7\25\2\2qr\7+\2\2rs\5\20\t\2st\7\26"+
		"\2\2tu\7+\2\2uv\5\20\t\2vx\3\2\2\2wP\3\2\2\2wQ\3\2\2\2wR\3\2\2\2wS\3\2"+
		"\2\2wT\3\2\2\2wY\3\2\2\2w\\\3\2\2\2wm\3\2\2\2x\17\3\2\2\2y\u0082\7\16"+
		"\2\2z\177\7+\2\2{|\7\23\2\2|~\7+\2\2}{\3\2\2\2~\u0081\3\2\2\2\177}\3\2"+
		"\2\2\177\u0080\3\2\2\2\u0080\u0083\3\2\2\2\u0081\177\3\2\2\2\u0082z\3"+
		"\2\2\2\u0082\u0083\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0085\7\17\2\2\u0085"+
		"\21\3\2\2\2\u0086\u0087\7\27\2\2\u0087\u0088\7\30\2\2\u0088\u008d\5\24"+
		"\13\2\u0089\u008a\7\23\2\2\u008a\u008c\5\24\13\2\u008b\u0089\3\2\2\2\u008c"+
		"\u008f\3\2\2\2\u008d\u008b\3\2\2\2\u008d\u008e\3\2\2\2\u008e\u0090\3\2"+
		"\2\2\u008f\u008d\3\2\2\2\u0090\u0091\7\31\2\2\u0091\23\3\2\2\2\u0092\u0093"+
		"\7+\2\2\u0093\u0094\7\32\2\2\u0094\u0095\t\2\2\2\u0095\25\3\2\2\2\u0096"+
		"\u009c\7\33\2\2\u0097\u0098\5\34\17\2\u0098\u0099\7*\2\2\u0099\u009b\3"+
		"\2\2\2\u009a\u0097\3\2\2\2\u009b\u009e\3\2\2\2\u009c\u009a\3\2\2\2\u009c"+
		"\u009d\3\2\2\2\u009d\27\3\2\2\2\u009e\u009c\3\2\2\2\u009f\u00a0\7\34\2"+
		"\2\u00a0\u00a1\7+\2\2\u00a1\u00aa\7\16\2\2\u00a2\u00a7\7+\2\2\u00a3\u00a4"+
		"\7\23\2\2\u00a4\u00a6\7+\2\2\u00a5\u00a3\3\2\2\2\u00a6\u00a9\3\2\2\2\u00a7"+
		"\u00a5\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8\u00ab\3\2\2\2\u00a9\u00a7\3\2"+
		"\2\2\u00aa\u00a2\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac"+
		"\u00ad\7\17\2\2\u00ad\u00ae\7*\2\2\u00ae\31\3\2\2\2\u00af\u00b3\7\35\2"+
		"\2\u00b0\u00b4\5\6\4\2\u00b1\u00b2\7+\2\2\u00b2\u00b4\7\36\2\2\u00b3\u00b0"+
		"\3\2\2\2\u00b3\u00b1\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b5"+
		"\u00b6\3\2\2\2\u00b6\33\3\2\2\2\u00b7\u00b8\7+\2\2\u00b8\u00ba\7\22\2"+
		"\2\u00b9\u00b7\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba\u00bb\3\2\2\2\u00bb\u00bc"+
		"\5\36\20\2\u00bc\35\3\2\2\2\u00bd\u00be\5&\24\2\u00be\u00bf\7\37\2\2\u00bf"+
		"\u00c4\5 \21\2\u00c0\u00c1\7\23\2\2\u00c1\u00c3\5 \21\2\u00c2\u00c0\3"+
		"\2\2\2\u00c3\u00c6\3\2\2\2\u00c4\u00c2\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5"+
		"\37\3\2\2\2\u00c6\u00c4\3\2\2\2\u00c7\u00c8\5\"\22\2\u00c8\u00c9\5$\23"+
		"\2\u00c9\u00cc\3\2\2\2\u00ca\u00cc\5\36\20\2\u00cb\u00c7\3\2\2\2\u00cb"+
		"\u00ca\3\2\2\2\u00cc!\3\2\2\2\u00cd\u00d6\7+\2\2\u00ce\u00d0\7\30\2\2"+
		"\u00cf\u00d1\7,\2\2\u00d0\u00cf\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1\u00d2"+
		"\3\2\2\2\u00d2\u00d6\7\31\2\2\u00d3\u00d4\7 \2\2\u00d4\u00d6\7+\2\2\u00d5"+
		"\u00cd\3\2\2\2\u00d5\u00ce\3\2\2\2\u00d5\u00d3\3\2\2\2\u00d6#\3\2\2\2"+
		"\u00d7\u00d8\7!\2\2\u00d8\u00ec\5\16\b\2\u00d9\u00da\7!\2\2\u00da\u00db"+
		"\5\16\b\2\u00db\u00dc\5\22\n\2\u00dc\u00ec\3\2\2\2\u00dd\u00de\7!\2\2"+
		"\u00de\u00df\5\16\b\2\u00df\u00e0\7\"\2\2\u00e0\u00e1\7\30\2\2\u00e1\u00e6"+
		"\5\36\20\2\u00e2\u00e3\7\23\2\2\u00e3\u00e5\5\36\20\2\u00e4\u00e2\3\2"+
		"\2\2\u00e5\u00e8\3\2\2\2\u00e6\u00e4\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7"+
		"\u00e9\3\2\2\2\u00e8\u00e6\3\2\2\2\u00e9\u00ea\7\31\2\2\u00ea\u00ec\3"+
		"\2\2\2\u00eb\u00d7\3\2\2\2\u00eb\u00d9\3\2\2\2\u00eb\u00dd\3\2\2\2\u00ec"+
		"%\3\2\2\2\u00ed\u00ee\b\24\1\2\u00ee\u010e\7+\2\2\u00ef\u010e\7,\2\2\u00f0"+
		"\u010e\7:\2\2\u00f1\u010e\7#\2\2\u00f2\u010e\79\2\2\u00f3\u00f4\7$\2\2"+
		"\u00f4\u00f9\5&\24\2\u00f5\u00f6\7\23\2\2\u00f6\u00f8\5&\24\2\u00f7\u00f5"+
		"\3\2\2\2\u00f8\u00fb\3\2\2\2\u00f9\u00f7\3\2\2\2\u00f9\u00fa\3\2\2\2\u00fa"+
		"\u00fc\3\2\2\2\u00fb\u00f9\3\2\2\2\u00fc\u00fd\7%\2\2\u00fd\u010e\3\2"+
		"\2\2\u00fe\u00ff\7&\2\2\u00ff\u0104\5&\24\2\u0100\u0101\7\23\2\2\u0101"+
		"\u0103\5&\24\2\u0102\u0100\3\2\2\2\u0103\u0106\3\2\2\2\u0104\u0102\3\2"+
		"\2\2\u0104\u0105\3\2\2\2\u0105\u0107\3\2\2\2\u0106\u0104\3\2\2\2\u0107"+
		"\u0108\7\'\2\2\u0108\u010e\3\2\2\2\u0109\u010a\7\16\2\2\u010a\u010b\5"+
		"&\24\2\u010b\u010c\7\17\2\2\u010c\u010e\3\2\2\2\u010d\u00ed\3\2\2\2\u010d"+
		"\u00ef\3\2\2\2\u010d\u00f0\3\2\2\2\u010d\u00f1\3\2\2\2\u010d\u00f2\3\2"+
		"\2\2\u010d\u00f3\3\2\2\2\u010d\u00fe\3\2\2\2\u010d\u0109\3\2\2\2\u010e"+
		"\u013d\3\2\2\2\u010f\u0110\f\16\2\2\u0110\u0111\7\66\2\2\u0111\u013c\5"+
		"&\24\17\u0112\u0113\f\r\2\2\u0113\u0114\7\67\2\2\u0114\u013c\5&\24\16"+
		"\u0115\u0116\f\f\2\2\u0116\u0117\78\2\2\u0117\u013c\5&\24\r\u0118\u0119"+
		"\f\t\2\2\u0119\u011a\7/\2\2\u011a\u013c\5&\24\n\u011b\u011c\f\b\2\2\u011c"+
		"\u011d\7\60\2\2\u011d\u013c\5&\24\t\u011e\u011f\f\7\2\2\u011f\u0120\7"+
		"\61\2\2\u0120\u013c\5&\24\b\u0121\u0122\f\6\2\2\u0122\u0123\7-\2\2\u0123"+
		"\u013c\5&\24\7\u0124\u0125\f\5\2\2\u0125\u0126\7.\2\2\u0126\u013c\5&\24"+
		"\6\u0127\u0128\f\4\2\2\u0128\u0129\7)\2\2\u0129\u013c\5&\24\5\u012a\u012b"+
		"\f\24\2\2\u012b\u012c\7 \2\2\u012c\u013c\7\65\2\2\u012d\u012e\f\22\2\2"+
		"\u012e\u012f\7 \2\2\u012f\u013c\7,\2\2\u0130\u0131\f\21\2\2\u0131\u0132"+
		"\7 \2\2\u0132\u013c\7\62\2\2\u0133\u0134\f\20\2\2\u0134\u0135\7 \2\2\u0135"+
		"\u013c\7\63\2\2\u0136\u0137\f\17\2\2\u0137\u0138\7 \2\2\u0138\u013c\7"+
		"\64\2\2\u0139\u013a\f\n\2\2\u013a\u013c\7(\2\2\u013b\u010f\3\2\2\2\u013b"+
		"\u0112\3\2\2\2\u013b\u0115\3\2\2\2\u013b\u0118\3\2\2\2\u013b\u011b\3\2"+
		"\2\2\u013b\u011e\3\2\2\2\u013b\u0121\3\2\2\2\u013b\u0124\3\2\2\2\u013b"+
		"\u0127\3\2\2\2\u013b\u012a\3\2\2\2\u013b\u012d\3\2\2\2\u013b\u0130\3\2"+
		"\2\2\u013b\u0133\3\2\2\2\u013b\u0136\3\2\2\2\u013b\u0139\3\2\2\2\u013c"+
		"\u013f\3\2\2\2\u013d\u013b\3\2\2\2\u013d\u013e\3\2\2\2\u013e\'\3\2\2\2"+
		"\u013f\u013d\3\2\2\2\36,\60\649;Ghw\177\u0082\u008d\u009c\u00a7\u00aa"+
		"\u00b3\u00b5\u00b9\u00c4\u00cb\u00d0\u00d5\u00e6\u00eb\u00f9\u0104\u010d"+
		"\u013b\u013d";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}