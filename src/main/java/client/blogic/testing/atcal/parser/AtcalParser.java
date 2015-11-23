// Generated from /home/cristian/workspace/fastest/Fastest/src/main/java/client/blogic/testing/atcal/Atcal.g4 by ANTLR 4.5.1
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
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, STMTEND=38, 
		PLCODE=39, ID=40, NUMBER=41, PLUS=42, MINUS=43, MUL=44, DIV=45, MOD=46, 
		DOM=47, RAN=48, PROJ=49, TUPPROJ=50, INTER=51, UNION=52, DIFF=53, ELEM=54, 
		AUTO=55, CARD=56, STRING=57, WS=58;
	public static final int
		RULE_refinementRule = 0, RULE_preamble = 1, RULE_datatypes = 2, RULE_typeDec = 3, 
		RULE_type = 4, RULE_args = 5, RULE_constMapping = 6, RULE_constMap = 7, 
		RULE_laws = 8, RULE_uut = 9, RULE_epilogue = 10, RULE_law = 11, RULE_lawRefinement = 12, 
		RULE_zExprs = 13, RULE_refinement = 14, RULE_lvalue = 15, RULE_withRef = 16, 
		RULE_zExpr = 17;
	public static final String[] ruleNames = {
		"refinementRule", "preamble", "datatypes", "typeDec", "type", "args", 
		"constMapping", "constMap", "laws", "uut", "epilogue", "law", "lawRefinement", 
		"zExprs", "refinement", "lvalue", "withRef", "zExpr"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'@RRULE'", "'@PREAMBLE'", "'.@PREAMBLE'", "'@DATATYPES'", "'DATATYPE'", 
		"'='", "'INT'", "'FLOAT'", "'STRING'", "'ARRAY'", "'('", "')'", "'ENUM'", 
		"'RECORD'", "':'", "','", "'MODULE'", "'CONSTRUCTOR'", "'SETTER'", "'GETTER'", 
		"'MAP'", "'['", "']'", "'->'", "'@LAWS'", "'@UUT'", "'@EPILOGUE'", "'.@EPILOGUE'", 
		"'==>'", "'AS'", "'.'", "'WITH'", "'<'", "'>'", "'{'", "'}'", "'++'", 
		null, null, null, null, "'+'", "'-'", "'*'", "'/'", "'%'", "'@DOM'", "'@RAN'", 
		null, null, "'/\\'", "'\\/'", "'~'", "'@ELEM'", "'@AUTOFILL'", "'@CARD'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, "STMTEND", "PLCODE", "ID", "NUMBER", "PLUS", "MINUS", "MUL", 
		"DIV", "MOD", "DOM", "RAN", "PROJ", "TUPPROJ", "INTER", "UNION", "DIFF", 
		"ELEM", "AUTO", "CARD", "STRING", "WS"
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
			setState(36);
			match(T__0);
			setState(37);
			match(ID);
			setState(39);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(38);
				preamble();
				}
			}

			setState(42);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(41);
				datatypes();
				}
			}

			setState(44);
			laws();
			setState(46);
			_la = _input.LA(1);
			if (_la==PLCODE) {
				{
				setState(45);
				match(PLCODE);
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
			setState(52);
			match(T__1);
			setState(57); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(57);
				switch (_input.LA(1)) {
				case PLCODE:
					{
					setState(53);
					match(PLCODE);
					}
					break;
				case ID:
					{
					setState(54);
					match(ID);
					setState(55);
					match(T__2);
					setState(56);
					match(STMTEND);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(59); 
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
			setState(61);
			match(T__3);
			setState(63); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(62);
				typeDec();
				}
				}
				setState(65); 
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
			setState(67);
			match(T__4);
			setState(68);
			match(ID);
			setState(69);
			match(T__5);
			setState(70);
			type();
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
			setState(117);
			switch (_input.LA(1)) {
			case ID:
				_localctx = new NameTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(73);
				match(ID);
				}
				break;
			case T__6:
				_localctx = new IntTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(74);
				match(T__6);
				}
				break;
			case T__7:
				_localctx = new FloatTypeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(75);
				match(T__7);
				}
				break;
			case T__8:
				_localctx = new StringTypeContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(76);
				match(T__8);
				}
				break;
			case T__9:
				_localctx = new ArrayTypeContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(77);
				match(T__9);
				setState(78);
				type();
				setState(79);
				match(T__10);
				setState(80);
				match(NUMBER);
				setState(81);
				match(T__11);
				}
				break;
			case T__12:
				_localctx = new EnumTypeContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(83);
				match(T__12);
				setState(84);
				match(ID);
				setState(85);
				args();
				}
				break;
			case T__13:
				_localctx = new RecordTypeContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(86);
				match(T__13);
				setState(87);
				match(ID);
				setState(88);
				match(T__10);
				setState(89);
				match(ID);
				setState(90);
				match(T__14);
				setState(91);
				type();
				setState(98);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__15) {
					{
					{
					setState(92);
					match(T__15);
					setState(93);
					match(ID);
					setState(94);
					match(T__14);
					setState(95);
					type();
					}
					}
					setState(100);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(101);
				match(T__11);
				}
				break;
			case T__16:
			case T__17:
				_localctx = new ContractTypeContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(105);
				_la = _input.LA(1);
				if (_la==T__16) {
					{
					setState(103);
					match(T__16);
					setState(104);
					match(STRING);
					}
				}

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
		enterRule(_localctx, 10, RULE_args);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			match(T__10);
			setState(128);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(120);
				match(ID);
				setState(125);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__15) {
					{
					{
					setState(121);
					match(T__15);
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
			setState(132);
			match(T__20);
			setState(133);
			match(T__21);
			setState(134);
			constMap();
			setState(139);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__15) {
				{
				{
				setState(135);
				match(T__15);
				setState(136);
				constMap();
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
			setState(144);
			match(ID);
			setState(145);
			match(T__23);
			setState(146);
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(148);
			match(T__24);
			setState(154);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__10) | (1L << T__32) | (1L << T__34) | (1L << ID) | (1L << NUMBER) | (1L << ELEM) | (1L << AUTO) | (1L << STRING))) != 0)) {
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
		enterRule(_localctx, 18, RULE_uut);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(157);
			match(T__25);
			setState(158);
			match(ID);
			setState(159);
			args();
			setState(160);
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
			setState(162);
			match(T__26);
			setState(166); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(166);
				switch (_input.LA(1)) {
				case PLCODE:
					{
					setState(163);
					match(PLCODE);
					}
					break;
				case ID:
					{
					setState(164);
					match(ID);
					setState(165);
					match(T__27);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(168); 
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
			setState(172);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				setState(170);
				match(ID);
				setState(171);
				match(T__14);
				}
				break;
			}
			{
			setState(174);
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
		enterRule(_localctx, 24, RULE_lawRefinement);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(176);
			zExprs();
			setState(177);
			match(T__28);
			setState(178);
			refinement();
			setState(183);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(179);
					match(T__15);
					setState(180);
					refinement();
					}
					} 
				}
				setState(185);
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
		enterRule(_localctx, 26, RULE_zExprs);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(186);
			zExpr(0);
			setState(189);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				{
				setState(187);
				match(T__28);
				setState(188);
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
		enterRule(_localctx, 28, RULE_refinement);
		int _la;
		try {
			_localctx = new ImplRefContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(191);
			lvalue();
			setState(192);
			match(T__29);
			setState(193);
			type();
			setState(195);
			_la = _input.LA(1);
			if (_la==T__20) {
				{
				setState(194);
				constMapping();
				}
			}

			setState(198);
			_la = _input.LA(1);
			if (_la==T__31) {
				{
				setState(197);
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
		enterRule(_localctx, 30, RULE_lvalue);
		int _la;
		try {
			setState(208);
			switch (_input.LA(1)) {
			case ID:
				_localctx = new VarLValueContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(200);
				match(ID);
				}
				break;
			case T__21:
				_localctx = new ArrayLValueContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(201);
				match(T__21);
				setState(203);
				_la = _input.LA(1);
				if (_la==NUMBER) {
					{
					setState(202);
					match(NUMBER);
					}
				}

				setState(205);
				match(T__22);
				}
				break;
			case T__30:
				_localctx = new FieldLValueContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(206);
				match(T__30);
				setState(207);
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
		enterRule(_localctx, 32, RULE_withRef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(210);
			match(T__31);
			setState(211);
			match(T__21);
			setState(212);
			lawRefinement();
			setState(217);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__15) {
				{
				{
				setState(213);
				match(T__15);
				setState(214);
				lawRefinement();
				}
				}
				setState(219);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(220);
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
		int _startState = 34;
		enterRecursionRule(_localctx, 34, RULE_zExpr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(254);
			switch (_input.LA(1)) {
			case ID:
				{
				_localctx = new IdentContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(223);
				match(ID);
				}
				break;
			case NUMBER:
				{
				_localctx = new NumLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(224);
				match(NUMBER);
				}
				break;
			case STRING:
				{
				_localctx = new StrLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(225);
				match(STRING);
				}
				break;
			case AUTO:
				{
				_localctx = new AutoExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(226);
				match(AUTO);
				}
				break;
			case ELEM:
				{
				_localctx = new ElemExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(227);
				match(ELEM);
				}
				break;
			case T__32:
				{
				_localctx = new ProdConsContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(228);
				match(T__32);
				setState(229);
				zExpr(0);
				setState(234);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__15) {
					{
					{
					setState(230);
					match(T__15);
					setState(231);
					zExpr(0);
					}
					}
					setState(236);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(237);
				match(T__33);
				}
				break;
			case T__34:
				{
				_localctx = new SetConsContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(239);
				match(T__34);
				setState(240);
				zExpr(0);
				setState(245);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__15) {
					{
					{
					setState(241);
					match(T__15);
					setState(242);
					zExpr(0);
					}
					}
					setState(247);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(248);
				match(T__35);
				}
				break;
			case T__10:
				{
				_localctx = new GroupContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(250);
				match(T__10);
				setState(251);
				zExpr(0);
				setState(252);
				match(T__11);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(303);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(301);
					switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
					case 1:
						{
						_localctx = new SetInterContext(new ZExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_zExpr);
						setState(256);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(257);
						match(INTER);
						setState(258);
						zExpr(13);
						}
						break;
					case 2:
						{
						_localctx = new SetUnionContext(new ZExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_zExpr);
						setState(259);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(260);
						match(UNION);
						setState(261);
						zExpr(12);
						}
						break;
					case 3:
						{
						_localctx = new SetDiffContext(new ZExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_zExpr);
						setState(262);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(263);
						match(DIFF);
						setState(264);
						zExpr(11);
						}
						break;
					case 4:
						{
						_localctx = new NumMulContext(new ZExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_zExpr);
						setState(265);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(266);
						match(MUL);
						setState(267);
						zExpr(8);
						}
						break;
					case 5:
						{
						_localctx = new NumDivContext(new ZExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_zExpr);
						setState(268);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(269);
						match(DIV);
						setState(270);
						zExpr(7);
						}
						break;
					case 6:
						{
						_localctx = new NumModContext(new ZExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_zExpr);
						setState(271);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(272);
						match(MOD);
						setState(273);
						zExpr(6);
						}
						break;
					case 7:
						{
						_localctx = new NumPlusContext(new ZExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_zExpr);
						setState(274);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(275);
						match(PLUS);
						setState(276);
						zExpr(5);
						}
						break;
					case 8:
						{
						_localctx = new NumMinusContext(new ZExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_zExpr);
						setState(277);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(278);
						match(MINUS);
						setState(279);
						zExpr(4);
						}
						break;
					case 9:
						{
						_localctx = new StrConcatContext(new ZExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_zExpr);
						setState(280);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(281);
						match(T__36);
						setState(282);
						zExpr(3);
						}
						break;
					case 10:
						{
						_localctx = new ProdProjContext(new ZExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_zExpr);
						setState(283);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(284);
						match(T__30);
						setState(285);
						match(TUPPROJ);
						}
						break;
					case 11:
						{
						_localctx = new SetElemContext(new ZExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_zExpr);
						setState(286);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(287);
						match(T__30);
						setState(288);
						match(NUMBER);
						}
						break;
					case 12:
						{
						_localctx = new SetDomContext(new ZExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_zExpr);
						setState(289);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(290);
						match(T__30);
						setState(291);
						match(DOM);
						}
						break;
					case 13:
						{
						_localctx = new SetRanContext(new ZExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_zExpr);
						setState(292);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(293);
						match(T__30);
						setState(294);
						match(RAN);
						}
						break;
					case 14:
						{
						_localctx = new SetProjContext(new ZExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_zExpr);
						setState(295);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(296);
						match(T__30);
						setState(297);
						match(PROJ);
						}
						break;
					case 15:
						{
						_localctx = new SetCardContext(new ZExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_zExpr);
						setState(298);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(299);
						match(T__30);
						setState(300);
						match(CARD);
						}
						break;
					}
					} 
				}
				setState(305);
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
		case 17:
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3<\u0135\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\3\2\3\2\3\2\5\2*\n\2\3\2\5\2-\n\2\3\2\3\2\5\2\61\n\2\3\2\3"+
		"\2\5\2\65\n\2\3\3\3\3\3\3\3\3\3\3\6\3<\n\3\r\3\16\3=\3\4\3\4\6\4B\n\4"+
		"\r\4\16\4C\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6c\n\6\f\6"+
		"\16\6f\13\6\3\6\3\6\3\6\3\6\5\6l\n\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\5\6x\n\6\3\7\3\7\3\7\3\7\7\7~\n\7\f\7\16\7\u0081\13\7\5\7\u0083"+
		"\n\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\7\b\u008c\n\b\f\b\16\b\u008f\13\b\3\b"+
		"\3\b\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\7\n\u009b\n\n\f\n\16\n\u009e\13\n"+
		"\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\6\f\u00a9\n\f\r\f\16\f\u00aa"+
		"\3\r\3\r\5\r\u00af\n\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\7\16\u00b8\n\16"+
		"\f\16\16\16\u00bb\13\16\3\17\3\17\3\17\5\17\u00c0\n\17\3\20\3\20\3\20"+
		"\3\20\5\20\u00c6\n\20\3\20\5\20\u00c9\n\20\3\21\3\21\3\21\5\21\u00ce\n"+
		"\21\3\21\3\21\3\21\5\21\u00d3\n\21\3\22\3\22\3\22\3\22\3\22\7\22\u00da"+
		"\n\22\f\22\16\22\u00dd\13\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3"+
		"\23\3\23\3\23\3\23\7\23\u00eb\n\23\f\23\16\23\u00ee\13\23\3\23\3\23\3"+
		"\23\3\23\3\23\3\23\7\23\u00f6\n\23\f\23\16\23\u00f9\13\23\3\23\3\23\3"+
		"\23\3\23\3\23\3\23\5\23\u0101\n\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\7\23\u0130\n\23\f\23"+
		"\16\23\u0133\13\23\3\23\2\3$\24\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36"+
		" \"$\2\3\4\2*+;;\u0159\2&\3\2\2\2\4\66\3\2\2\2\6?\3\2\2\2\bE\3\2\2\2\n"+
		"w\3\2\2\2\fy\3\2\2\2\16\u0086\3\2\2\2\20\u0092\3\2\2\2\22\u0096\3\2\2"+
		"\2\24\u009f\3\2\2\2\26\u00a4\3\2\2\2\30\u00ae\3\2\2\2\32\u00b2\3\2\2\2"+
		"\34\u00bc\3\2\2\2\36\u00c1\3\2\2\2 \u00d2\3\2\2\2\"\u00d4\3\2\2\2$\u0100"+
		"\3\2\2\2&\'\7\3\2\2\')\7*\2\2(*\5\4\3\2)(\3\2\2\2)*\3\2\2\2*,\3\2\2\2"+
		"+-\5\6\4\2,+\3\2\2\2,-\3\2\2\2-.\3\2\2\2.\60\5\22\n\2/\61\7)\2\2\60/\3"+
		"\2\2\2\60\61\3\2\2\2\61\62\3\2\2\2\62\64\5\24\13\2\63\65\5\26\f\2\64\63"+
		"\3\2\2\2\64\65\3\2\2\2\65\3\3\2\2\2\66;\7\4\2\2\67<\7)\2\289\7*\2\29:"+
		"\7\5\2\2:<\7(\2\2;\67\3\2\2\2;8\3\2\2\2<=\3\2\2\2=;\3\2\2\2=>\3\2\2\2"+
		">\5\3\2\2\2?A\7\6\2\2@B\5\b\5\2A@\3\2\2\2BC\3\2\2\2CA\3\2\2\2CD\3\2\2"+
		"\2D\7\3\2\2\2EF\7\7\2\2FG\7*\2\2GH\7\b\2\2HI\5\n\6\2IJ\7(\2\2J\t\3\2\2"+
		"\2Kx\7*\2\2Lx\7\t\2\2Mx\7\n\2\2Nx\7\13\2\2OP\7\f\2\2PQ\5\n\6\2QR\7\r\2"+
		"\2RS\7+\2\2ST\7\16\2\2Tx\3\2\2\2UV\7\17\2\2VW\7*\2\2Wx\5\f\7\2XY\7\20"+
		"\2\2YZ\7*\2\2Z[\7\r\2\2[\\\7*\2\2\\]\7\21\2\2]d\5\n\6\2^_\7\22\2\2_`\7"+
		"*\2\2`a\7\21\2\2ac\5\n\6\2b^\3\2\2\2cf\3\2\2\2db\3\2\2\2de\3\2\2\2eg\3"+
		"\2\2\2fd\3\2\2\2gh\7\16\2\2hx\3\2\2\2ij\7\23\2\2jl\7;\2\2ki\3\2\2\2kl"+
		"\3\2\2\2lm\3\2\2\2mn\7\24\2\2no\7*\2\2op\5\f\7\2pq\7\25\2\2qr\7*\2\2r"+
		"s\5\f\7\2st\7\26\2\2tu\7*\2\2uv\5\f\7\2vx\3\2\2\2wK\3\2\2\2wL\3\2\2\2"+
		"wM\3\2\2\2wN\3\2\2\2wO\3\2\2\2wU\3\2\2\2wX\3\2\2\2wk\3\2\2\2x\13\3\2\2"+
		"\2y\u0082\7\r\2\2z\177\7*\2\2{|\7\22\2\2|~\7*\2\2}{\3\2\2\2~\u0081\3\2"+
		"\2\2\177}\3\2\2\2\177\u0080\3\2\2\2\u0080\u0083\3\2\2\2\u0081\177\3\2"+
		"\2\2\u0082z\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0085"+
		"\7\16\2\2\u0085\r\3\2\2\2\u0086\u0087\7\27\2\2\u0087\u0088\7\30\2\2\u0088"+
		"\u008d\5\20\t\2\u0089\u008a\7\22\2\2\u008a\u008c\5\20\t\2\u008b\u0089"+
		"\3\2\2\2\u008c\u008f\3\2\2\2\u008d\u008b\3\2\2\2\u008d\u008e\3\2\2\2\u008e"+
		"\u0090\3\2\2\2\u008f\u008d\3\2\2\2\u0090\u0091\7\31\2\2\u0091\17\3\2\2"+
		"\2\u0092\u0093\7*\2\2\u0093\u0094\7\32\2\2\u0094\u0095\t\2\2\2\u0095\21"+
		"\3\2\2\2\u0096\u009c\7\33\2\2\u0097\u0098\5\30\r\2\u0098\u0099\7(\2\2"+
		"\u0099\u009b\3\2\2\2\u009a\u0097\3\2\2\2\u009b\u009e\3\2\2\2\u009c\u009a"+
		"\3\2\2\2\u009c\u009d\3\2\2\2\u009d\23\3\2\2\2\u009e\u009c\3\2\2\2\u009f"+
		"\u00a0\7\34\2\2\u00a0\u00a1\7*\2\2\u00a1\u00a2\5\f\7\2\u00a2\u00a3\7("+
		"\2\2\u00a3\25\3\2\2\2\u00a4\u00a8\7\35\2\2\u00a5\u00a9\7)\2\2\u00a6\u00a7"+
		"\7*\2\2\u00a7\u00a9\7\36\2\2\u00a8\u00a5\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a9"+
		"\u00aa\3\2\2\2\u00aa\u00a8\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\27\3\2\2"+
		"\2\u00ac\u00ad\7*\2\2\u00ad\u00af\7\21\2\2\u00ae\u00ac\3\2\2\2\u00ae\u00af"+
		"\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0\u00b1\5\32\16\2\u00b1\31\3\2\2\2\u00b2"+
		"\u00b3\5\34\17\2\u00b3\u00b4\7\37\2\2\u00b4\u00b9\5\36\20\2\u00b5\u00b6"+
		"\7\22\2\2\u00b6\u00b8\5\36\20\2\u00b7\u00b5\3\2\2\2\u00b8\u00bb\3\2\2"+
		"\2\u00b9\u00b7\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba\33\3\2\2\2\u00bb\u00b9"+
		"\3\2\2\2\u00bc\u00bf\5$\23\2\u00bd\u00be\7\37\2\2\u00be\u00c0\5\34\17"+
		"\2\u00bf\u00bd\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0\35\3\2\2\2\u00c1\u00c2"+
		"\5 \21\2\u00c2\u00c3\7 \2\2\u00c3\u00c5\5\n\6\2\u00c4\u00c6\5\16\b\2\u00c5"+
		"\u00c4\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6\u00c8\3\2\2\2\u00c7\u00c9\5\""+
		"\22\2\u00c8\u00c7\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9\37\3\2\2\2\u00ca\u00d3"+
		"\7*\2\2\u00cb\u00cd\7\30\2\2\u00cc\u00ce\7+\2\2\u00cd\u00cc\3\2\2\2\u00cd"+
		"\u00ce\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf\u00d3\7\31\2\2\u00d0\u00d1\7"+
		"!\2\2\u00d1\u00d3\7*\2\2\u00d2\u00ca\3\2\2\2\u00d2\u00cb\3\2\2\2\u00d2"+
		"\u00d0\3\2\2\2\u00d3!\3\2\2\2\u00d4\u00d5\7\"\2\2\u00d5\u00d6\7\30\2\2"+
		"\u00d6\u00db\5\32\16\2\u00d7\u00d8\7\22\2\2\u00d8\u00da\5\32\16\2\u00d9"+
		"\u00d7\3\2\2\2\u00da\u00dd\3\2\2\2\u00db\u00d9\3\2\2\2\u00db\u00dc\3\2"+
		"\2\2\u00dc\u00de\3\2\2\2\u00dd\u00db\3\2\2\2\u00de\u00df\7\31\2\2\u00df"+
		"#\3\2\2\2\u00e0\u00e1\b\23\1\2\u00e1\u0101\7*\2\2\u00e2\u0101\7+\2\2\u00e3"+
		"\u0101\7;\2\2\u00e4\u0101\79\2\2\u00e5\u0101\78\2\2\u00e6\u00e7\7#\2\2"+
		"\u00e7\u00ec\5$\23\2\u00e8\u00e9\7\22\2\2\u00e9\u00eb\5$\23\2\u00ea\u00e8"+
		"\3\2\2\2\u00eb\u00ee\3\2\2\2\u00ec\u00ea\3\2\2\2\u00ec\u00ed\3\2\2\2\u00ed"+
		"\u00ef\3\2\2\2\u00ee\u00ec\3\2\2\2\u00ef\u00f0\7$\2\2\u00f0\u0101\3\2"+
		"\2\2\u00f1\u00f2\7%\2\2\u00f2\u00f7\5$\23\2\u00f3\u00f4\7\22\2\2\u00f4"+
		"\u00f6\5$\23\2\u00f5\u00f3\3\2\2\2\u00f6\u00f9\3\2\2\2\u00f7\u00f5\3\2"+
		"\2\2\u00f7\u00f8\3\2\2\2\u00f8\u00fa\3\2\2\2\u00f9\u00f7\3\2\2\2\u00fa"+
		"\u00fb\7&\2\2\u00fb\u0101\3\2\2\2\u00fc\u00fd\7\r\2\2\u00fd\u00fe\5$\23"+
		"\2\u00fe\u00ff\7\16\2\2\u00ff\u0101\3\2\2\2\u0100\u00e0\3\2\2\2\u0100"+
		"\u00e2\3\2\2\2\u0100\u00e3\3\2\2\2\u0100\u00e4\3\2\2\2\u0100\u00e5\3\2"+
		"\2\2\u0100\u00e6\3\2\2\2\u0100\u00f1\3\2\2\2\u0100\u00fc\3\2\2\2\u0101"+
		"\u0131\3\2\2\2\u0102\u0103\f\16\2\2\u0103\u0104\7\65\2\2\u0104\u0130\5"+
		"$\23\17\u0105\u0106\f\r\2\2\u0106\u0107\7\66\2\2\u0107\u0130\5$\23\16"+
		"\u0108\u0109\f\f\2\2\u0109\u010a\7\67\2\2\u010a\u0130\5$\23\r\u010b\u010c"+
		"\f\t\2\2\u010c\u010d\7.\2\2\u010d\u0130\5$\23\n\u010e\u010f\f\b\2\2\u010f"+
		"\u0110\7/\2\2\u0110\u0130\5$\23\t\u0111\u0112\f\7\2\2\u0112\u0113\7\60"+
		"\2\2\u0113\u0130\5$\23\b\u0114\u0115\f\6\2\2\u0115\u0116\7,\2\2\u0116"+
		"\u0130\5$\23\7\u0117\u0118\f\5\2\2\u0118\u0119\7-\2\2\u0119\u0130\5$\23"+
		"\6\u011a\u011b\f\4\2\2\u011b\u011c\7\'\2\2\u011c\u0130\5$\23\5\u011d\u011e"+
		"\f\24\2\2\u011e\u011f\7!\2\2\u011f\u0130\7\64\2\2\u0120\u0121\f\22\2\2"+
		"\u0121\u0122\7!\2\2\u0122\u0130\7+\2\2\u0123\u0124\f\21\2\2\u0124\u0125"+
		"\7!\2\2\u0125\u0130\7\61\2\2\u0126\u0127\f\20\2\2\u0127\u0128\7!\2\2\u0128"+
		"\u0130\7\62\2\2\u0129\u012a\f\17\2\2\u012a\u012b\7!\2\2\u012b\u0130\7"+
		"\63\2\2\u012c\u012d\f\n\2\2\u012d\u012e\7!\2\2\u012e\u0130\7:\2\2\u012f"+
		"\u0102\3\2\2\2\u012f\u0105\3\2\2\2\u012f\u0108\3\2\2\2\u012f\u010b\3\2"+
		"\2\2\u012f\u010e\3\2\2\2\u012f\u0111\3\2\2\2\u012f\u0114\3\2\2\2\u012f"+
		"\u0117\3\2\2\2\u012f\u011a\3\2\2\2\u012f\u011d\3\2\2\2\u012f\u0120\3\2"+
		"\2\2\u012f\u0123\3\2\2\2\u012f\u0126\3\2\2\2\u012f\u0129\3\2\2\2\u012f"+
		"\u012c\3\2\2\2\u0130\u0133\3\2\2\2\u0131\u012f\3\2\2\2\u0131\u0132\3\2"+
		"\2\2\u0132%\3\2\2\2\u0133\u0131\3\2\2\2\37),\60\64;=Cdkw\177\u0082\u008d"+
		"\u009c\u00a8\u00aa\u00ae\u00b9\u00bf\u00c5\u00c8\u00cd\u00d2\u00db\u00ec"+
		"\u00f7\u0100\u012f\u0131";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}