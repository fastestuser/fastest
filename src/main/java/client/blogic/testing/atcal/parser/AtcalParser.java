// Generated from /home/cristian/workspace/fastest/src/main/java/client/blogic/testing/atcal/Atcal.g4 by ANTLR 4.5.1
package client.blogic.testing.atcal.parser;
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
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, STMTEND=40, PLCODE=41, ID=42, NUMBER=43, PLUS=44, MINUS=45, 
		MUL=46, DIV=47, MOD=48, DOM=49, RAN=50, PROJ=51, TUPPROJ=52, INTER=53, 
		UNION=54, DIFF=55, ELEM=56, AUTO=57, CARD=58, STRING=59, WS=60;
	public static final int
		RULE_refinementRule = 0, RULE_preamble = 1, RULE_datatypes = 2, RULE_typeDec = 3, 
		RULE_type = 4, RULE_args = 5, RULE_constMapping = 6, RULE_constMap = 7, 
		RULE_laws = 8, RULE_uut = 9, RULE_epilogue = 10, RULE_law = 11, RULE_biRefLaw = 12, 
		RULE_lawRefinement = 13, RULE_zExprs = 14, RULE_refinement = 15, RULE_lvalue = 16, 
		RULE_withRef = 17, RULE_zExpr = 18;
	public static final String[] ruleNames = {
		"refinementRule", "preamble", "datatypes", "typeDec", "type", "args", 
		"constMapping", "constMap", "laws", "uut", "epilogue", "law", "biRefLaw", 
		"lawRefinement", "zExprs", "refinement", "lvalue", "withRef", "zExpr"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'@RRULE'", "'@PREAMBLE'", "'.@PREAMBLE'", "'@DATATYPES'", "'DATATYPE'", 
		"'='", "'INT'", "'FLOAT'", "'STRING'", "'ARRAY'", "'('", "')'", "'ENUM'", 
		"'RECORD'", "':'", "','", "'MODULE'", "'CONSTRUCTOR'", "'SETTER'", "'GETTER'", 
		"'MAP'", "'['", "']'", "'->'", "'@LAWS'", "'@UUT'", "'<=='", "'AS'", "'@EPILOGUE'", 
		"'.@EPILOGUE'", "'<==>'", "'==>'", "'.'", "'WITH'", "'<'", "'>'", "'{'", 
		"'}'", "'++'", null, null, null, null, "'+'", "'-'", "'*'", "'/'", "'%'", 
		"'@DOM'", "'@RAN'", null, null, "'/\\'", "'\\/'", "'~'", "'@ELEM'", "'@AUTOFILL'", 
		"'@CARD'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, "STMTEND", "PLCODE", "ID", "NUMBER", "PLUS", "MINUS", 
		"MUL", "DIV", "MOD", "DOM", "RAN", "PROJ", "TUPPROJ", "INTER", "UNION", 
		"DIFF", "ELEM", "AUTO", "CARD", "STRING", "WS"
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
		public TerminalNode PLCODE() { return getToken(AtcalParser.PLCODE, 0); }
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
			if (_la==T__3) {
				{
				setState(43);
				datatypes();
				}
			}

			setState(46);
			laws();
			setState(48);
			_la = _input.LA(1);
			if (_la==PLCODE) {
				{
				setState(47);
				match(PLCODE);
				}
			}

			setState(50);
			uut();
			setState(52);
			_la = _input.LA(1);
			if (_la==T__28) {
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
		public List<TerminalNode> PLCODE() { return getTokens(AtcalParser.PLCODE); }
		public TerminalNode PLCODE(int i) {
			return getToken(AtcalParser.PLCODE, i);
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
				case PLCODE:
					{
					setState(55);
					match(PLCODE);
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
			} while ( _la==PLCODE || _la==ID );
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 4, RULE_datatypes);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
			match(T__3);
			setState(65); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(64);
				typeDec();
				}
				}
				setState(67); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__4 );
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 6, RULE_typeDec);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			match(T__4);
			setState(70);
			match(ID);
			setState(71);
			match(T__5);
			setState(72);
			type();
			setState(73);
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
		public TerminalNode STRING() { return getToken(AtcalParser.STRING, 0); }
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
		enterRule(_localctx, 8, RULE_type);
		int _la;
		try {
			setState(119);
			switch (_input.LA(1)) {
			case ID:
				_localctx = new NameTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(75);
				match(ID);
				}
				break;
			case T__6:
				_localctx = new IntTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(76);
				match(T__6);
				}
				break;
			case T__7:
				_localctx = new FloatTypeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(77);
				match(T__7);
				}
				break;
			case T__8:
				_localctx = new StringTypeContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(78);
				match(T__8);
				}
				break;
			case T__9:
				_localctx = new ArrayTypeContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(79);
				match(T__9);
				setState(80);
				type();
				setState(81);
				match(T__10);
				setState(82);
				match(NUMBER);
				setState(83);
				match(T__11);
				}
				break;
			case T__12:
				_localctx = new EnumTypeContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(85);
				match(T__12);
				setState(86);
				match(ID);
				setState(87);
				args();
				}
				break;
			case T__13:
				_localctx = new RecordTypeContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(88);
				match(T__13);
				setState(89);
				match(ID);
				setState(90);
				match(T__10);
				setState(91);
				match(ID);
				setState(92);
				match(T__14);
				setState(93);
				type();
				setState(100);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__15) {
					{
					{
					setState(94);
					match(T__15);
					setState(95);
					match(ID);
					setState(96);
					match(T__14);
					setState(97);
					type();
					}
					}
					setState(102);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(103);
				match(T__11);
				}
				break;
			case T__16:
			case T__17:
				_localctx = new ContractTypeContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(107);
				_la = _input.LA(1);
				if (_la==T__16) {
					{
					setState(105);
					match(T__16);
					setState(106);
					match(STRING);
					}
				}

				setState(109);
				match(T__17);
				setState(110);
				match(ID);
				setState(111);
				args();
				setState(112);
				match(T__18);
				setState(113);
				match(ID);
				setState(114);
				args();
				setState(115);
				match(T__19);
				setState(116);
				match(ID);
				setState(117);
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
		enterRule(_localctx, 10, RULE_args);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
			match(T__10);
			setState(130);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(122);
				match(ID);
				setState(127);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__15) {
					{
					{
					setState(123);
					match(T__15);
					setState(124);
					match(ID);
					}
					}
					setState(129);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(132);
			match(T__11);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 12, RULE_constMapping);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
			match(T__20);
			setState(135);
			match(T__21);
			setState(136);
			constMap();
			setState(141);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__15) {
				{
				{
				setState(137);
				match(T__15);
				setState(138);
				constMap();
				}
				}
				setState(143);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(144);
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
		enterRule(_localctx, 14, RULE_constMap);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
			match(ID);
			setState(147);
			match(T__23);
			setState(148);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ID) | (1L << NUMBER) | (1L << STRING))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
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
		enterRule(_localctx, 16, RULE_laws);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
			match(T__24);
			setState(156);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(151);
					law();
					setState(152);
					match(STMTEND);
					}
					} 
				}
				setState(158);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
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
		public UutContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_uut; }
	 
		public UutContext() { }
		public void copyFrom(UutContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class UUTNoRetValContext extends UutContext {
		public TerminalNode ID() { return getToken(AtcalParser.ID, 0); }
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public TerminalNode STMTEND() { return getToken(AtcalParser.STMTEND, 0); }
		public UUTNoRetValContext(UutContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AtcalVisitor ) return ((AtcalVisitor<? extends T>)visitor).visitUUTNoRetVal(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UUTRetValContext extends UutContext {
		public List<TerminalNode> ID() { return getTokens(AtcalParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(AtcalParser.ID, i);
		}
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode STMTEND() { return getToken(AtcalParser.STMTEND, 0); }
		public UUTRetValContext(UutContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AtcalVisitor ) return ((AtcalVisitor<? extends T>)visitor).visitUUTRetVal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UutContext uut() throws RecognitionException {
		UutContext _localctx = new UutContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_uut);
		try {
			setState(173);
			switch (_input.LA(1)) {
			case T__25:
				_localctx = new UUTNoRetValContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(159);
				match(T__25);
				setState(160);
				match(ID);
				setState(161);
				args();
				setState(162);
				match(STMTEND);
				}
				break;
			case ID:
				_localctx = new UUTRetValContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(164);
				match(ID);
				setState(165);
				match(T__26);
				setState(166);
				match(T__25);
				setState(167);
				match(ID);
				setState(168);
				args();
				setState(169);
				match(T__27);
				setState(170);
				type();
				setState(171);
				match(STMTEND);
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

	public static class EpilogueContext extends ParserRuleContext {
		public List<TerminalNode> PLCODE() { return getTokens(AtcalParser.PLCODE); }
		public TerminalNode PLCODE(int i) {
			return getToken(AtcalParser.PLCODE, i);
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
		enterRule(_localctx, 20, RULE_epilogue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(175);
			match(T__28);
			setState(179); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(179);
				switch (_input.LA(1)) {
				case PLCODE:
					{
					setState(176);
					match(PLCODE);
					}
					break;
				case ID:
					{
					setState(177);
					match(ID);
					setState(178);
					match(T__29);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(181); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==PLCODE || _la==ID );
			}
		}
		catch (RecognitionException re) {
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
		public BiRefLawContext biRefLaw() {
			return getRuleContext(BiRefLawContext.class,0);
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
		enterRule(_localctx, 22, RULE_law);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(185);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				{
				setState(183);
				match(ID);
				setState(184);
				match(T__14);
				}
				break;
			}
			setState(189);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				{
				setState(187);
				lawRefinement();
				}
				break;
			case 2:
				{
				setState(188);
				biRefLaw();
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

	public static class BiRefLawContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(AtcalParser.ID, 0); }
		public List<RefinementContext> refinement() {
			return getRuleContexts(RefinementContext.class);
		}
		public RefinementContext refinement(int i) {
			return getRuleContext(RefinementContext.class,i);
		}
		public BiRefLawContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_biRefLaw; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AtcalVisitor ) return ((AtcalVisitor<? extends T>)visitor).visitBiRefLaw(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BiRefLawContext biRefLaw() throws RecognitionException {
		BiRefLawContext _localctx = new BiRefLawContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_biRefLaw);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(191);
			match(ID);
			setState(192);
			match(T__30);
			setState(193);
			refinement();
			setState(198);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__15) {
				{
				{
				setState(194);
				match(T__15);
				setState(195);
				refinement();
				}
				}
				setState(200);
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
			setState(201);
			zExprs();
			setState(202);
			match(T__31);
			setState(203);
			refinement();
			setState(208);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(204);
					match(T__15);
					setState(205);
					refinement();
					}
					} 
				}
				setState(210);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
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
			setState(211);
			zExpr(0);
			setState(214);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				{
				setState(212);
				match(T__31);
				setState(213);
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
		public RefinementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_refinement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AtcalVisitor ) return ((AtcalVisitor<? extends T>)visitor).visitRefinement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RefinementContext refinement() throws RecognitionException {
		RefinementContext _localctx = new RefinementContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_refinement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(216);
			lvalue();
			setState(217);
			match(T__27);
			setState(218);
			type();
			setState(220);
			_la = _input.LA(1);
			if (_la==T__20) {
				{
				setState(219);
				constMapping();
				}
			}

			setState(223);
			_la = _input.LA(1);
			if (_la==T__33) {
				{
				setState(222);
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
			setState(233);
			switch (_input.LA(1)) {
			case ID:
				_localctx = new VarLValueContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(225);
				match(ID);
				}
				break;
			case T__21:
				_localctx = new ArrayLValueContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(226);
				match(T__21);
				setState(228);
				_la = _input.LA(1);
				if (_la==NUMBER) {
					{
					setState(227);
					match(NUMBER);
					}
				}

				setState(230);
				match(T__22);
				}
				break;
			case T__32:
				_localctx = new FieldLValueContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(231);
				match(T__32);
				setState(232);
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
			setState(235);
			match(T__33);
			setState(236);
			match(T__21);
			setState(237);
			lawRefinement();
			setState(242);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__15) {
				{
				{
				setState(238);
				match(T__15);
				setState(239);
				lawRefinement();
				}
				}
				setState(244);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(245);
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
			setState(279);
			switch (_input.LA(1)) {
			case ID:
				{
				_localctx = new IdentContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(248);
				match(ID);
				}
				break;
			case NUMBER:
				{
				_localctx = new NumLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(249);
				match(NUMBER);
				}
				break;
			case STRING:
				{
				_localctx = new StrLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(250);
				match(STRING);
				}
				break;
			case AUTO:
				{
				_localctx = new AutoExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(251);
				match(AUTO);
				}
				break;
			case ELEM:
				{
				_localctx = new ElemExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(252);
				match(ELEM);
				}
				break;
			case T__34:
				{
				_localctx = new ProdConsContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(253);
				match(T__34);
				setState(254);
				zExpr(0);
				setState(259);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__15) {
					{
					{
					setState(255);
					match(T__15);
					setState(256);
					zExpr(0);
					}
					}
					setState(261);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(262);
				match(T__35);
				}
				break;
			case T__36:
				{
				_localctx = new SetConsContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(264);
				match(T__36);
				setState(265);
				zExpr(0);
				setState(270);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__15) {
					{
					{
					setState(266);
					match(T__15);
					setState(267);
					zExpr(0);
					}
					}
					setState(272);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(273);
				match(T__37);
				}
				break;
			case T__10:
				{
				_localctx = new GroupContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(275);
				match(T__10);
				setState(276);
				zExpr(0);
				setState(277);
				match(T__11);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(328);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(326);
					switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
					case 1:
						{
						_localctx = new SetInterContext(new ZExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_zExpr);
						setState(281);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(282);
						match(INTER);
						setState(283);
						zExpr(13);
						}
						break;
					case 2:
						{
						_localctx = new SetUnionContext(new ZExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_zExpr);
						setState(284);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(285);
						match(UNION);
						setState(286);
						zExpr(12);
						}
						break;
					case 3:
						{
						_localctx = new SetDiffContext(new ZExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_zExpr);
						setState(287);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(288);
						match(DIFF);
						setState(289);
						zExpr(11);
						}
						break;
					case 4:
						{
						_localctx = new NumMulContext(new ZExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_zExpr);
						setState(290);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(291);
						match(MUL);
						setState(292);
						zExpr(8);
						}
						break;
					case 5:
						{
						_localctx = new NumDivContext(new ZExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_zExpr);
						setState(293);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(294);
						match(DIV);
						setState(295);
						zExpr(7);
						}
						break;
					case 6:
						{
						_localctx = new NumModContext(new ZExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_zExpr);
						setState(296);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(297);
						match(MOD);
						setState(298);
						zExpr(6);
						}
						break;
					case 7:
						{
						_localctx = new NumPlusContext(new ZExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_zExpr);
						setState(299);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(300);
						match(PLUS);
						setState(301);
						zExpr(5);
						}
						break;
					case 8:
						{
						_localctx = new NumMinusContext(new ZExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_zExpr);
						setState(302);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(303);
						match(MINUS);
						setState(304);
						zExpr(4);
						}
						break;
					case 9:
						{
						_localctx = new StrConcatContext(new ZExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_zExpr);
						setState(305);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(306);
						match(T__38);
						setState(307);
						zExpr(3);
						}
						break;
					case 10:
						{
						_localctx = new ProdProjContext(new ZExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_zExpr);
						setState(308);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(309);
						match(T__32);
						setState(310);
						match(TUPPROJ);
						}
						break;
					case 11:
						{
						_localctx = new SetElemContext(new ZExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_zExpr);
						setState(311);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(312);
						match(T__32);
						setState(313);
						match(NUMBER);
						}
						break;
					case 12:
						{
						_localctx = new SetDomContext(new ZExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_zExpr);
						setState(314);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(315);
						match(T__32);
						setState(316);
						match(DOM);
						}
						break;
					case 13:
						{
						_localctx = new SetRanContext(new ZExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_zExpr);
						setState(317);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(318);
						match(T__32);
						setState(319);
						match(RAN);
						}
						break;
					case 14:
						{
						_localctx = new SetProjContext(new ZExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_zExpr);
						setState(320);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(321);
						match(T__32);
						setState(322);
						match(PROJ);
						}
						break;
					case 15:
						{
						_localctx = new SetCardContext(new ZExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_zExpr);
						setState(323);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(324);
						match(T__32);
						setState(325);
						match(CARD);
						}
						break;
					}
					} 
				}
				setState(330);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3>\u014e\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\3\2\3\2\3\2\5\2,\n\2\3\2\5\2/\n\2\3\2\3\2\5\2\63"+
		"\n\2\3\2\3\2\5\2\67\n\2\3\3\3\3\3\3\3\3\3\3\6\3>\n\3\r\3\16\3?\3\4\3\4"+
		"\6\4D\n\4\r\4\16\4E\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6"+
		"e\n\6\f\6\16\6h\13\6\3\6\3\6\3\6\3\6\5\6n\n\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\5\6z\n\6\3\7\3\7\3\7\3\7\7\7\u0080\n\7\f\7\16\7\u0083"+
		"\13\7\5\7\u0085\n\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\7\b\u008e\n\b\f\b\16\b"+
		"\u0091\13\b\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\7\n\u009d\n\n\f\n"+
		"\16\n\u00a0\13\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\5\13\u00b0\n\13\3\f\3\f\3\f\3\f\6\f\u00b6\n\f\r\f\16\f"+
		"\u00b7\3\r\3\r\5\r\u00bc\n\r\3\r\3\r\5\r\u00c0\n\r\3\16\3\16\3\16\3\16"+
		"\3\16\7\16\u00c7\n\16\f\16\16\16\u00ca\13\16\3\17\3\17\3\17\3\17\3\17"+
		"\7\17\u00d1\n\17\f\17\16\17\u00d4\13\17\3\20\3\20\3\20\5\20\u00d9\n\20"+
		"\3\21\3\21\3\21\3\21\5\21\u00df\n\21\3\21\5\21\u00e2\n\21\3\22\3\22\3"+
		"\22\5\22\u00e7\n\22\3\22\3\22\3\22\5\22\u00ec\n\22\3\23\3\23\3\23\3\23"+
		"\3\23\7\23\u00f3\n\23\f\23\16\23\u00f6\13\23\3\23\3\23\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\7\24\u0104\n\24\f\24\16\24\u0107\13"+
		"\24\3\24\3\24\3\24\3\24\3\24\3\24\7\24\u010f\n\24\f\24\16\24\u0112\13"+
		"\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u011a\n\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\7\24"+
		"\u0149\n\24\f\24\16\24\u014c\13\24\3\24\2\3&\25\2\4\6\b\n\f\16\20\22\24"+
		"\26\30\32\34\36 \"$&\2\3\4\2,-==\u0174\2(\3\2\2\2\48\3\2\2\2\6A\3\2\2"+
		"\2\bG\3\2\2\2\ny\3\2\2\2\f{\3\2\2\2\16\u0088\3\2\2\2\20\u0094\3\2\2\2"+
		"\22\u0098\3\2\2\2\24\u00af\3\2\2\2\26\u00b1\3\2\2\2\30\u00bb\3\2\2\2\32"+
		"\u00c1\3\2\2\2\34\u00cb\3\2\2\2\36\u00d5\3\2\2\2 \u00da\3\2\2\2\"\u00eb"+
		"\3\2\2\2$\u00ed\3\2\2\2&\u0119\3\2\2\2()\7\3\2\2)+\7,\2\2*,\5\4\3\2+*"+
		"\3\2\2\2+,\3\2\2\2,.\3\2\2\2-/\5\6\4\2.-\3\2\2\2./\3\2\2\2/\60\3\2\2\2"+
		"\60\62\5\22\n\2\61\63\7+\2\2\62\61\3\2\2\2\62\63\3\2\2\2\63\64\3\2\2\2"+
		"\64\66\5\24\13\2\65\67\5\26\f\2\66\65\3\2\2\2\66\67\3\2\2\2\67\3\3\2\2"+
		"\28=\7\4\2\29>\7+\2\2:;\7,\2\2;<\7\5\2\2<>\7*\2\2=9\3\2\2\2=:\3\2\2\2"+
		">?\3\2\2\2?=\3\2\2\2?@\3\2\2\2@\5\3\2\2\2AC\7\6\2\2BD\5\b\5\2CB\3\2\2"+
		"\2DE\3\2\2\2EC\3\2\2\2EF\3\2\2\2F\7\3\2\2\2GH\7\7\2\2HI\7,\2\2IJ\7\b\2"+
		"\2JK\5\n\6\2KL\7*\2\2L\t\3\2\2\2Mz\7,\2\2Nz\7\t\2\2Oz\7\n\2\2Pz\7\13\2"+
		"\2QR\7\f\2\2RS\5\n\6\2ST\7\r\2\2TU\7-\2\2UV\7\16\2\2Vz\3\2\2\2WX\7\17"+
		"\2\2XY\7,\2\2Yz\5\f\7\2Z[\7\20\2\2[\\\7,\2\2\\]\7\r\2\2]^\7,\2\2^_\7\21"+
		"\2\2_f\5\n\6\2`a\7\22\2\2ab\7,\2\2bc\7\21\2\2ce\5\n\6\2d`\3\2\2\2eh\3"+
		"\2\2\2fd\3\2\2\2fg\3\2\2\2gi\3\2\2\2hf\3\2\2\2ij\7\16\2\2jz\3\2\2\2kl"+
		"\7\23\2\2ln\7=\2\2mk\3\2\2\2mn\3\2\2\2no\3\2\2\2op\7\24\2\2pq\7,\2\2q"+
		"r\5\f\7\2rs\7\25\2\2st\7,\2\2tu\5\f\7\2uv\7\26\2\2vw\7,\2\2wx\5\f\7\2"+
		"xz\3\2\2\2yM\3\2\2\2yN\3\2\2\2yO\3\2\2\2yP\3\2\2\2yQ\3\2\2\2yW\3\2\2\2"+
		"yZ\3\2\2\2ym\3\2\2\2z\13\3\2\2\2{\u0084\7\r\2\2|\u0081\7,\2\2}~\7\22\2"+
		"\2~\u0080\7,\2\2\177}\3\2\2\2\u0080\u0083\3\2\2\2\u0081\177\3\2\2\2\u0081"+
		"\u0082\3\2\2\2\u0082\u0085\3\2\2\2\u0083\u0081\3\2\2\2\u0084|\3\2\2\2"+
		"\u0084\u0085\3\2\2\2\u0085\u0086\3\2\2\2\u0086\u0087\7\16\2\2\u0087\r"+
		"\3\2\2\2\u0088\u0089\7\27\2\2\u0089\u008a\7\30\2\2\u008a\u008f\5\20\t"+
		"\2\u008b\u008c\7\22\2\2\u008c\u008e\5\20\t\2\u008d\u008b\3\2\2\2\u008e"+
		"\u0091\3\2\2\2\u008f\u008d\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u0092\3\2"+
		"\2\2\u0091\u008f\3\2\2\2\u0092\u0093\7\31\2\2\u0093\17\3\2\2\2\u0094\u0095"+
		"\7,\2\2\u0095\u0096\7\32\2\2\u0096\u0097\t\2\2\2\u0097\21\3\2\2\2\u0098"+
		"\u009e\7\33\2\2\u0099\u009a\5\30\r\2\u009a\u009b\7*\2\2\u009b\u009d\3"+
		"\2\2\2\u009c\u0099\3\2\2\2\u009d\u00a0\3\2\2\2\u009e\u009c\3\2\2\2\u009e"+
		"\u009f\3\2\2\2\u009f\23\3\2\2\2\u00a0\u009e\3\2\2\2\u00a1\u00a2\7\34\2"+
		"\2\u00a2\u00a3\7,\2\2\u00a3\u00a4\5\f\7\2\u00a4\u00a5\7*\2\2\u00a5\u00b0"+
		"\3\2\2\2\u00a6\u00a7\7,\2\2\u00a7\u00a8\7\35\2\2\u00a8\u00a9\7\34\2\2"+
		"\u00a9\u00aa\7,\2\2\u00aa\u00ab\5\f\7\2\u00ab\u00ac\7\36\2\2\u00ac\u00ad"+
		"\5\n\6\2\u00ad\u00ae\7*\2\2\u00ae\u00b0\3\2\2\2\u00af\u00a1\3\2\2\2\u00af"+
		"\u00a6\3\2\2\2\u00b0\25\3\2\2\2\u00b1\u00b5\7\37\2\2\u00b2\u00b6\7+\2"+
		"\2\u00b3\u00b4\7,\2\2\u00b4\u00b6\7 \2\2\u00b5\u00b2\3\2\2\2\u00b5\u00b3"+
		"\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00b5\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8"+
		"\27\3\2\2\2\u00b9\u00ba\7,\2\2\u00ba\u00bc\7\21\2\2\u00bb\u00b9\3\2\2"+
		"\2\u00bb\u00bc\3\2\2\2\u00bc\u00bf\3\2\2\2\u00bd\u00c0\5\34\17\2\u00be"+
		"\u00c0\5\32\16\2\u00bf\u00bd\3\2\2\2\u00bf\u00be\3\2\2\2\u00c0\31\3\2"+
		"\2\2\u00c1\u00c2\7,\2\2\u00c2\u00c3\7!\2\2\u00c3\u00c8\5 \21\2\u00c4\u00c5"+
		"\7\22\2\2\u00c5\u00c7\5 \21\2\u00c6\u00c4\3\2\2\2\u00c7\u00ca\3\2\2\2"+
		"\u00c8\u00c6\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9\33\3\2\2\2\u00ca\u00c8"+
		"\3\2\2\2\u00cb\u00cc\5\36\20\2\u00cc\u00cd\7\"\2\2\u00cd\u00d2\5 \21\2"+
		"\u00ce\u00cf\7\22\2\2\u00cf\u00d1\5 \21\2\u00d0\u00ce\3\2\2\2\u00d1\u00d4"+
		"\3\2\2\2\u00d2\u00d0\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3\35\3\2\2\2\u00d4"+
		"\u00d2\3\2\2\2\u00d5\u00d8\5&\24\2\u00d6\u00d7\7\"\2\2\u00d7\u00d9\5\36"+
		"\20\2\u00d8\u00d6\3\2\2\2\u00d8\u00d9\3\2\2\2\u00d9\37\3\2\2\2\u00da\u00db"+
		"\5\"\22\2\u00db\u00dc\7\36\2\2\u00dc\u00de\5\n\6\2\u00dd\u00df\5\16\b"+
		"\2\u00de\u00dd\3\2\2\2\u00de\u00df\3\2\2\2\u00df\u00e1\3\2\2\2\u00e0\u00e2"+
		"\5$\23\2\u00e1\u00e0\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2!\3\2\2\2\u00e3"+
		"\u00ec\7,\2\2\u00e4\u00e6\7\30\2\2\u00e5\u00e7\7-\2\2\u00e6\u00e5\3\2"+
		"\2\2\u00e6\u00e7\3\2\2\2\u00e7\u00e8\3\2\2\2\u00e8\u00ec\7\31\2\2\u00e9"+
		"\u00ea\7#\2\2\u00ea\u00ec\7,\2\2\u00eb\u00e3\3\2\2\2\u00eb\u00e4\3\2\2"+
		"\2\u00eb\u00e9\3\2\2\2\u00ec#\3\2\2\2\u00ed\u00ee\7$\2\2\u00ee\u00ef\7"+
		"\30\2\2\u00ef\u00f4\5\34\17\2\u00f0\u00f1\7\22\2\2\u00f1\u00f3\5\34\17"+
		"\2\u00f2\u00f0\3\2\2\2\u00f3\u00f6\3\2\2\2\u00f4\u00f2\3\2\2\2\u00f4\u00f5"+
		"\3\2\2\2\u00f5\u00f7\3\2\2\2\u00f6\u00f4\3\2\2\2\u00f7\u00f8\7\31\2\2"+
		"\u00f8%\3\2\2\2\u00f9\u00fa\b\24\1\2\u00fa\u011a\7,\2\2\u00fb\u011a\7"+
		"-\2\2\u00fc\u011a\7=\2\2\u00fd\u011a\7;\2\2\u00fe\u011a\7:\2\2\u00ff\u0100"+
		"\7%\2\2\u0100\u0105\5&\24\2\u0101\u0102\7\22\2\2\u0102\u0104\5&\24\2\u0103"+
		"\u0101\3\2\2\2\u0104\u0107\3\2\2\2\u0105\u0103\3\2\2\2\u0105\u0106\3\2"+
		"\2\2\u0106\u0108\3\2\2\2\u0107\u0105\3\2\2\2\u0108\u0109\7&\2\2\u0109"+
		"\u011a\3\2\2\2\u010a\u010b\7\'\2\2\u010b\u0110\5&\24\2\u010c\u010d\7\22"+
		"\2\2\u010d\u010f\5&\24\2\u010e\u010c\3\2\2\2\u010f\u0112\3\2\2\2\u0110"+
		"\u010e\3\2\2\2\u0110\u0111\3\2\2\2\u0111\u0113\3\2\2\2\u0112\u0110\3\2"+
		"\2\2\u0113\u0114\7(\2\2\u0114\u011a\3\2\2\2\u0115\u0116\7\r\2\2\u0116"+
		"\u0117\5&\24\2\u0117\u0118\7\16\2\2\u0118\u011a\3\2\2\2\u0119\u00f9\3"+
		"\2\2\2\u0119\u00fb\3\2\2\2\u0119\u00fc\3\2\2\2\u0119\u00fd\3\2\2\2\u0119"+
		"\u00fe\3\2\2\2\u0119\u00ff\3\2\2\2\u0119\u010a\3\2\2\2\u0119\u0115\3\2"+
		"\2\2\u011a\u014a\3\2\2\2\u011b\u011c\f\16\2\2\u011c\u011d\7\67\2\2\u011d"+
		"\u0149\5&\24\17\u011e\u011f\f\r\2\2\u011f\u0120\78\2\2\u0120\u0149\5&"+
		"\24\16\u0121\u0122\f\f\2\2\u0122\u0123\79\2\2\u0123\u0149\5&\24\r\u0124"+
		"\u0125\f\t\2\2\u0125\u0126\7\60\2\2\u0126\u0149\5&\24\n\u0127\u0128\f"+
		"\b\2\2\u0128\u0129\7\61\2\2\u0129\u0149\5&\24\t\u012a\u012b\f\7\2\2\u012b"+
		"\u012c\7\62\2\2\u012c\u0149\5&\24\b\u012d\u012e\f\6\2\2\u012e\u012f\7"+
		".\2\2\u012f\u0149\5&\24\7\u0130\u0131\f\5\2\2\u0131\u0132\7/\2\2\u0132"+
		"\u0149\5&\24\6\u0133\u0134\f\4\2\2\u0134\u0135\7)\2\2\u0135\u0149\5&\24"+
		"\5\u0136\u0137\f\24\2\2\u0137\u0138\7#\2\2\u0138\u0149\7\66\2\2\u0139"+
		"\u013a\f\22\2\2\u013a\u013b\7#\2\2\u013b\u0149\7-\2\2\u013c\u013d\f\21"+
		"\2\2\u013d\u013e\7#\2\2\u013e\u0149\7\63\2\2\u013f\u0140\f\20\2\2\u0140"+
		"\u0141\7#\2\2\u0141\u0149\7\64\2\2\u0142\u0143\f\17\2\2\u0143\u0144\7"+
		"#\2\2\u0144\u0149\7\65\2\2\u0145\u0146\f\n\2\2\u0146\u0147\7#\2\2\u0147"+
		"\u0149\7<\2\2\u0148\u011b\3\2\2\2\u0148\u011e\3\2\2\2\u0148\u0121\3\2"+
		"\2\2\u0148\u0124\3\2\2\2\u0148\u0127\3\2\2\2\u0148\u012a\3\2\2\2\u0148"+
		"\u012d\3\2\2\2\u0148\u0130\3\2\2\2\u0148\u0133\3\2\2\2\u0148\u0136\3\2"+
		"\2\2\u0148\u0139\3\2\2\2\u0148\u013c\3\2\2\2\u0148\u013f\3\2\2\2\u0148"+
		"\u0142\3\2\2\2\u0148\u0145\3\2\2\2\u0149\u014c\3\2\2\2\u014a\u0148\3\2"+
		"\2\2\u014a\u014b\3\2\2\2\u014b\'\3\2\2\2\u014c\u014a\3\2\2\2\"+.\62\66"+
		"=?Efmy\u0081\u0084\u008f\u009e\u00af\u00b5\u00b7\u00bb\u00bf\u00c8\u00d2"+
		"\u00d8\u00de\u00e1\u00e6\u00eb\u00f4\u0105\u0110\u0119\u0148\u014a";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}