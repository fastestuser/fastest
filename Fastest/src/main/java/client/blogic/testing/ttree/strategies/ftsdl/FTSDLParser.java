// Generated from FTSDL.g4 by ANTLR 4.5.1

package client.blogic.testing.ttree.strategies.ftsdl;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class FTSDLParser extends Parser {
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
		T__38=39, T__39=40, T__40=41, T__41=42, T__42=43, T__43=44, T__44=45, 
		T__45=46, T__46=47, T__47=48, T__48=49, T__49=50, T__50=51, T__51=52, 
		T__52=53, T__53=54, T__54=55, T__55=56, T__56=57, TestingOP=58, IDENTIFIER=59, 
		INTEGER=60, NL=61, WS=62;
	public static final int
		RULE_strategies = 0, RULE_strategy = 1, RULE_statement = 2, RULE_statementBlock = 3, 
		RULE_variableAssignment = 4, RULE_ifStatement = 5, RULE_forStatement = 6, 
		RULE_whileStatement = 7, RULE_foreachStatement = 8, RULE_expression = 9, 
		RULE_logicalExpression = 10, RULE_command = 11, RULE_function = 12, RULE_treeManagement = 13, 
		RULE_parametersManagement = 14, RULE_tacticManagement = 15, RULE_expressionManagement = 16, 
		RULE_stringManagement = 17, RULE_enumerationManagement = 18, RULE_tactic = 19, 
		RULE_zOperator = 20, RULE_arglist = 21, RULE_literalExpression = 22;
	public static final String[] ruleNames = {
		"strategies", "strategy", "statement", "statementBlock", "variableAssignment", 
		"ifStatement", "forStatement", "whileStatement", "foreachStatement", "expression", 
		"logicalExpression", "command", "function", "treeManagement", "parametersManagement", 
		"tacticManagement", "expressionManagement", "stringManagement", "enumerationManagement", 
		"tactic", "zOperator", "arglist", "literalExpression"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'STRATEGY'", "'END'", "'exit'", "'='", "'IF'", "'('", "')'", "'ELSE'", 
		"'FOR'", "';'", "'WHILE'", "'FOREACH'", "':'", "'-'", "'++'", "'--'", 
		"'+'", "'*'", "'/'", "'&&'", "'||'", "'.'", "'OP'", "'TI'", "'!'", "'true'", 
		"'false'", "'genalltt'", "'prunett'", "'addtactic'", "'applystrategy'", 
		"'treeRoot'", "'leaves'", "'getName'", "'children'", "'getParent'", "'isLeaf'", 
		"'getSPOperators'", "'getSPExpressions'", "'getNRVariables'", "'getFTVariables'", 
		"'getISEExpressions'", "'expressionSPAppearsIn'", "'expressionNRAppearsIn'", 
		"'variableFTAppearsIn'", "'expressionISEAppearsIn'", "'getOperator'", 
		"'getString'", "'compare'", "'hasMore'", "'next'", "'SP'", "'NR'", "'FT'", 
		"'ISE'", "'\\cup'", "','", null, null, null, "'\n'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, "TestingOP", 
		"IDENTIFIER", "INTEGER", "NL", "WS"
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
	public String getGrammarFileName() { return "FTSDL.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public FTSDLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class StrategiesContext extends ParserRuleContext {
		public List<StrategyContext> strategy() {
			return getRuleContexts(StrategyContext.class);
		}
		public StrategyContext strategy(int i) {
			return getRuleContext(StrategyContext.class,i);
		}
		public List<TerminalNode> EOF() { return getTokens(FTSDLParser.EOF); }
		public TerminalNode EOF(int i) {
			return getToken(FTSDLParser.EOF, i);
		}
		public List<TerminalNode> NL() { return getTokens(FTSDLParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(FTSDLParser.NL, i);
		}
		public StrategiesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_strategies; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FTSDLVisitor ) return ((FTSDLVisitor<? extends T>)visitor).visitStrategies(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StrategiesContext strategies() throws RecognitionException {
		StrategiesContext _localctx = new StrategiesContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_strategies);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(46);
				strategy();
				setState(54);
				switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
				case 1:
					{
					setState(50);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(47);
						match(NL);
						}
						}
						setState(52);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					break;
				case 2:
					{
					setState(53);
					match(EOF);
					}
					break;
				}
				}
				}
				setState(58); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__0 );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StrategyContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(FTSDLParser.IDENTIFIER, 0); }
		public TerminalNode NL() { return getToken(FTSDLParser.NL, 0); }
		public StatementBlockContext statementBlock() {
			return getRuleContext(StatementBlockContext.class,0);
		}
		public StrategyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_strategy; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FTSDLVisitor ) return ((FTSDLVisitor<? extends T>)visitor).visitStrategy(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StrategyContext strategy() throws RecognitionException {
		StrategyContext _localctx = new StrategyContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_strategy);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			match(T__0);
			setState(61);
			match(IDENTIFIER);
			setState(62);
			match(NL);
			setState(63);
			statementBlock();
			setState(64);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode NL() { return getToken(FTSDLParser.NL, 0); }
		public VariableAssignmentContext variableAssignment() {
			return getRuleContext(VariableAssignmentContext.class,0);
		}
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public ForStatementContext forStatement() {
			return getRuleContext(ForStatementContext.class,0);
		}
		public WhileStatementContext whileStatement() {
			return getRuleContext(WhileStatementContext.class,0);
		}
		public ForeachStatementContext foreachStatement() {
			return getRuleContext(ForeachStatementContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FTSDLVisitor ) return ((FTSDLVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_statement);
		try {
			setState(78);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(66);
				expression(0);
				setState(67);
				match(NL);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(69);
				variableAssignment();
				setState(70);
				match(NL);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(72);
				match(T__2);
				setState(73);
				match(NL);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(74);
				ifStatement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(75);
				forStatement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(76);
				whileStatement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(77);
				foreachStatement();
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

	public static class StatementBlockContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public StatementBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statementBlock; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FTSDLVisitor ) return ((FTSDLVisitor<? extends T>)visitor).visitStatementBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementBlockContext statementBlock() throws RecognitionException {
		StatementBlockContext _localctx = new StatementBlockContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_statementBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__4) | (1L << T__5) | (1L << T__8) | (1L << T__10) | (1L << T__11) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << IDENTIFIER) | (1L << INTEGER))) != 0)) {
				{
				{
				setState(80);
				statement();
				}
				}
				setState(85);
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

	public static class VariableAssignmentContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(FTSDLParser.IDENTIFIER, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public VariableAssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableAssignment; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FTSDLVisitor ) return ((FTSDLVisitor<? extends T>)visitor).visitVariableAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableAssignmentContext variableAssignment() throws RecognitionException {
		VariableAssignmentContext _localctx = new VariableAssignmentContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_variableAssignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			match(IDENTIFIER);
			setState(87);
			match(T__3);
			setState(88);
			expression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfStatementContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<StatementBlockContext> statementBlock() {
			return getRuleContexts(StatementBlockContext.class);
		}
		public StatementBlockContext statementBlock(int i) {
			return getRuleContext(StatementBlockContext.class,i);
		}
		public List<TerminalNode> NL() { return getTokens(FTSDLParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(FTSDLParser.NL, i);
		}
		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FTSDLVisitor ) return ((FTSDLVisitor<? extends T>)visitor).visitIfStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_ifStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			match(T__4);
			setState(91);
			match(T__5);
			setState(92);
			expression(0);
			setState(93);
			match(T__6);
			setState(95);
			_la = _input.LA(1);
			if (_la==NL) {
				{
				setState(94);
				match(NL);
				}
			}

			setState(97);
			statementBlock();
			setState(103);
			_la = _input.LA(1);
			if (_la==T__7) {
				{
				setState(98);
				match(T__7);
				setState(100);
				_la = _input.LA(1);
				if (_la==NL) {
					{
					setState(99);
					match(NL);
					}
				}

				setState(102);
				statementBlock();
				}
			}

			setState(105);
			match(T__1);
			setState(106);
			match(NL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ForStatementContext extends ParserRuleContext {
		public StatementBlockContext statementBlock() {
			return getRuleContext(StatementBlockContext.class,0);
		}
		public List<TerminalNode> NL() { return getTokens(FTSDLParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(FTSDLParser.NL, i);
		}
		public VariableAssignmentContext variableAssignment() {
			return getRuleContext(VariableAssignmentContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ForStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FTSDLVisitor ) return ((FTSDLVisitor<? extends T>)visitor).visitForStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForStatementContext forStatement() throws RecognitionException {
		ForStatementContext _localctx = new ForStatementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_forStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			match(T__8);
			setState(109);
			match(T__5);
			setState(114);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(110);
				variableAssignment();
				}
				break;
			case 2:
				{
				setState(112);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << IDENTIFIER) | (1L << INTEGER))) != 0)) {
					{
					setState(111);
					expression(0);
					}
				}

				}
				break;
			}
			setState(116);
			match(T__9);
			setState(118);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << IDENTIFIER) | (1L << INTEGER))) != 0)) {
				{
				setState(117);
				expression(0);
				}
			}

			setState(120);
			match(T__9);
			setState(122);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << IDENTIFIER) | (1L << INTEGER))) != 0)) {
				{
				setState(121);
				expression(0);
				}
			}

			setState(124);
			match(T__6);
			setState(126);
			_la = _input.LA(1);
			if (_la==NL) {
				{
				setState(125);
				match(NL);
				}
			}

			setState(128);
			statementBlock();
			setState(129);
			match(T__1);
			setState(130);
			match(NL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WhileStatementContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatementBlockContext statementBlock() {
			return getRuleContext(StatementBlockContext.class,0);
		}
		public TerminalNode NL() { return getToken(FTSDLParser.NL, 0); }
		public WhileStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FTSDLVisitor ) return ((FTSDLVisitor<? extends T>)visitor).visitWhileStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileStatementContext whileStatement() throws RecognitionException {
		WhileStatementContext _localctx = new WhileStatementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_whileStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			match(T__10);
			setState(133);
			match(T__5);
			setState(134);
			expression(0);
			setState(135);
			match(T__6);
			setState(136);
			statementBlock();
			setState(137);
			match(T__1);
			setState(138);
			match(NL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ForeachStatementContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(FTSDLParser.IDENTIFIER, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatementBlockContext statementBlock() {
			return getRuleContext(StatementBlockContext.class,0);
		}
		public List<TerminalNode> NL() { return getTokens(FTSDLParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(FTSDLParser.NL, i);
		}
		public ForeachStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_foreachStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FTSDLVisitor ) return ((FTSDLVisitor<? extends T>)visitor).visitForeachStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForeachStatementContext foreachStatement() throws RecognitionException {
		ForeachStatementContext _localctx = new ForeachStatementContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_foreachStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
			match(T__11);
			setState(141);
			match(T__5);
			setState(142);
			match(IDENTIFIER);
			setState(143);
			match(T__12);
			setState(144);
			expression(0);
			setState(145);
			match(T__6);
			setState(147);
			_la = _input.LA(1);
			if (_la==NL) {
				{
				setState(146);
				match(NL);
				}
			}

			setState(149);
			statementBlock();
			setState(150);
			match(T__1);
			setState(151);
			match(NL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public LogicalExpressionContext logicalExpression() {
			return getRuleContext(LogicalExpressionContext.class,0);
		}
		public LiteralExpressionContext literalExpression() {
			return getRuleContext(LiteralExpressionContext.class,0);
		}
		public TacticContext tactic() {
			return getRuleContext(TacticContext.class,0);
		}
		public ZOperatorContext zOperator() {
			return getRuleContext(ZOperatorContext.class,0);
		}
		public CommandContext command() {
			return getRuleContext(CommandContext.class,0);
		}
		public FunctionContext function() {
			return getRuleContext(FunctionContext.class,0);
		}
		public ArglistContext arglist() {
			return getRuleContext(ArglistContext.class,0);
		}
		public TerminalNode TestingOP() { return getToken(FTSDLParser.TestingOP, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FTSDLVisitor ) return ((FTSDLVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(178);
			switch (_input.LA(1)) {
			case T__13:
				{
				setState(154);
				match(T__13);
				setState(155);
				expression(23);
				}
				break;
			case T__14:
				{
				setState(156);
				match(T__14);
				setState(157);
				expression(22);
				}
				break;
			case T__15:
				{
				setState(158);
				match(T__15);
				setState(159);
				expression(21);
				}
				break;
			case T__24:
			case T__25:
			case T__26:
				{
				setState(160);
				logicalExpression();
				}
				break;
			case IDENTIFIER:
			case INTEGER:
				{
				setState(161);
				literalExpression();
				}
				break;
			case T__51:
			case T__52:
			case T__53:
			case T__54:
				{
				setState(162);
				tactic();
				}
				break;
			case T__55:
				{
				setState(163);
				zOperator();
				}
				break;
			case T__5:
				{
				setState(164);
				match(T__5);
				setState(165);
				expression(0);
				setState(166);
				match(T__6);
				}
				break;
			case T__27:
			case T__28:
			case T__29:
			case T__30:
				{
				setState(168);
				command();
				}
				break;
			case T__31:
			case T__32:
			case T__33:
			case T__34:
			case T__35:
			case T__36:
			case T__37:
			case T__38:
			case T__39:
			case T__40:
			case T__41:
			case T__42:
			case T__43:
			case T__44:
			case T__45:
			case T__46:
			case T__47:
			case T__48:
			case T__49:
			case T__50:
				{
				setState(169);
				function();
				setState(170);
				match(T__5);
				setState(172);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << IDENTIFIER) | (1L << INTEGER))) != 0)) {
					{
					setState(171);
					arglist();
					}
				}

				setState(174);
				match(T__6);
				}
				break;
			case T__22:
				{
				setState(176);
				match(T__22);
				}
				break;
			case T__23:
				{
				setState(177);
				match(T__23);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(216);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(214);
					switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(180);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(181);
						match(T__16);
						setState(182);
						expression(19);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(183);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(184);
						match(T__13);
						setState(185);
						expression(18);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(186);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(187);
						match(T__17);
						setState(188);
						expression(17);
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(189);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(190);
						match(T__18);
						setState(191);
						expression(16);
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(192);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(193);
						match(TestingOP);
						setState(194);
						expression(15);
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(195);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(196);
						match(T__19);
						setState(197);
						expression(14);
						}
						break;
					case 7:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(198);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(199);
						match(T__20);
						setState(200);
						expression(13);
						}
						break;
					case 8:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(201);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(202);
						match(T__21);
						setState(203);
						expression(4);
						}
						break;
					case 9:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(204);
						if (!(precpred(_ctx, 20))) throw new FailedPredicateException(this, "precpred(_ctx, 20)");
						setState(205);
						match(T__14);
						}
						break;
					case 10:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(206);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(207);
						match(T__15);
						}
						break;
					case 11:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(208);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(209);
						match(T__5);
						setState(211);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << IDENTIFIER) | (1L << INTEGER))) != 0)) {
							{
							setState(210);
							arglist();
							}
						}

						setState(213);
						match(T__6);
						}
						break;
					}
					} 
				}
				setState(218);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
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

	public static class LogicalExpressionContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public LogicalExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicalExpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FTSDLVisitor ) return ((FTSDLVisitor<? extends T>)visitor).visitLogicalExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LogicalExpressionContext logicalExpression() throws RecognitionException {
		LogicalExpressionContext _localctx = new LogicalExpressionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_logicalExpression);
		try {
			setState(223);
			switch (_input.LA(1)) {
			case T__24:
				enterOuterAlt(_localctx, 1);
				{
				setState(219);
				match(T__24);
				setState(220);
				expression(0);
				}
				break;
			case T__25:
				enterOuterAlt(_localctx, 2);
				{
				setState(221);
				match(T__25);
				}
				break;
			case T__26:
				enterOuterAlt(_localctx, 3);
				{
				setState(222);
				match(T__26);
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

	public static class CommandContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TacticContext tactic() {
			return getRuleContext(TacticContext.class,0);
		}
		public CommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_command; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FTSDLVisitor ) return ((FTSDLVisitor<? extends T>)visitor).visitCommand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CommandContext command() throws RecognitionException {
		CommandContext _localctx = new CommandContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_command);
		try {
			setState(238);
			switch (_input.LA(1)) {
			case T__27:
				enterOuterAlt(_localctx, 1);
				{
				setState(225);
				match(T__27);
				}
				break;
			case T__28:
				enterOuterAlt(_localctx, 2);
				{
				setState(226);
				match(T__28);
				}
				break;
			case T__29:
				enterOuterAlt(_localctx, 3);
				{
				setState(227);
				match(T__29);
				setState(228);
				expression(0);
				setState(229);
				tactic();
				setState(230);
				expression(0);
				setState(232);
				switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
				case 1:
					{
					setState(231);
					expression(0);
					}
					break;
				}
				}
				break;
			case T__30:
				enterOuterAlt(_localctx, 4);
				{
				setState(234);
				match(T__30);
				setState(235);
				expression(0);
				setState(236);
				expression(0);
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

	public static class FunctionContext extends ParserRuleContext {
		public TreeManagementContext treeManagement() {
			return getRuleContext(TreeManagementContext.class,0);
		}
		public ParametersManagementContext parametersManagement() {
			return getRuleContext(ParametersManagementContext.class,0);
		}
		public ExpressionManagementContext expressionManagement() {
			return getRuleContext(ExpressionManagementContext.class,0);
		}
		public StringManagementContext stringManagement() {
			return getRuleContext(StringManagementContext.class,0);
		}
		public EnumerationManagementContext enumerationManagement() {
			return getRuleContext(EnumerationManagementContext.class,0);
		}
		public TacticManagementContext tacticManagement() {
			return getRuleContext(TacticManagementContext.class,0);
		}
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FTSDLVisitor ) return ((FTSDLVisitor<? extends T>)visitor).visitFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_function);
		try {
			setState(246);
			switch (_input.LA(1)) {
			case T__31:
			case T__32:
			case T__33:
			case T__34:
			case T__35:
			case T__36:
				enterOuterAlt(_localctx, 1);
				{
				setState(240);
				treeManagement();
				}
				break;
			case T__37:
			case T__38:
			case T__39:
			case T__40:
			case T__41:
				enterOuterAlt(_localctx, 2);
				{
				setState(241);
				parametersManagement();
				}
				break;
			case T__46:
			case T__47:
				enterOuterAlt(_localctx, 3);
				{
				setState(242);
				expressionManagement();
				}
				break;
			case T__48:
				enterOuterAlt(_localctx, 4);
				{
				setState(243);
				stringManagement();
				}
				break;
			case T__49:
			case T__50:
				enterOuterAlt(_localctx, 5);
				{
				setState(244);
				enumerationManagement();
				}
				break;
			case T__42:
			case T__43:
			case T__44:
			case T__45:
				enterOuterAlt(_localctx, 6);
				{
				setState(245);
				tacticManagement();
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

	public static class TreeManagementContext extends ParserRuleContext {
		public TreeManagementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_treeManagement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FTSDLVisitor ) return ((FTSDLVisitor<? extends T>)visitor).visitTreeManagement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TreeManagementContext treeManagement() throws RecognitionException {
		TreeManagementContext _localctx = new TreeManagementContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_treeManagement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(248);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36))) != 0)) ) {
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

	public static class ParametersManagementContext extends ParserRuleContext {
		public ParametersManagementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parametersManagement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FTSDLVisitor ) return ((FTSDLVisitor<? extends T>)visitor).visitParametersManagement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParametersManagementContext parametersManagement() throws RecognitionException {
		ParametersManagementContext _localctx = new ParametersManagementContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_parametersManagement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(250);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41))) != 0)) ) {
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

	public static class TacticManagementContext extends ParserRuleContext {
		public TacticManagementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tacticManagement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FTSDLVisitor ) return ((FTSDLVisitor<? extends T>)visitor).visitTacticManagement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TacticManagementContext tacticManagement() throws RecognitionException {
		TacticManagementContext _localctx = new TacticManagementContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_tacticManagement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(252);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45))) != 0)) ) {
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

	public static class ExpressionManagementContext extends ParserRuleContext {
		public ExpressionManagementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionManagement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FTSDLVisitor ) return ((FTSDLVisitor<? extends T>)visitor).visitExpressionManagement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionManagementContext expressionManagement() throws RecognitionException {
		ExpressionManagementContext _localctx = new ExpressionManagementContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_expressionManagement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(254);
			_la = _input.LA(1);
			if ( !(_la==T__46 || _la==T__47) ) {
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

	public static class StringManagementContext extends ParserRuleContext {
		public StringManagementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringManagement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FTSDLVisitor ) return ((FTSDLVisitor<? extends T>)visitor).visitStringManagement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringManagementContext stringManagement() throws RecognitionException {
		StringManagementContext _localctx = new StringManagementContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_stringManagement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(256);
			match(T__48);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EnumerationManagementContext extends ParserRuleContext {
		public EnumerationManagementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumerationManagement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FTSDLVisitor ) return ((FTSDLVisitor<? extends T>)visitor).visitEnumerationManagement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnumerationManagementContext enumerationManagement() throws RecognitionException {
		EnumerationManagementContext _localctx = new EnumerationManagementContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_enumerationManagement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(258);
			_la = _input.LA(1);
			if ( !(_la==T__49 || _la==T__50) ) {
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

	public static class TacticContext extends ParserRuleContext {
		public TacticContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tactic; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FTSDLVisitor ) return ((FTSDLVisitor<? extends T>)visitor).visitTactic(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TacticContext tactic() throws RecognitionException {
		TacticContext _localctx = new TacticContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_tactic);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(260);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54))) != 0)) ) {
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

	public static class ZOperatorContext extends ParserRuleContext {
		public ZOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_zOperator; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FTSDLVisitor ) return ((FTSDLVisitor<? extends T>)visitor).visitZOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ZOperatorContext zOperator() throws RecognitionException {
		ZOperatorContext _localctx = new ZOperatorContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_zOperator);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(262);
			match(T__55);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArglistContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ArglistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arglist; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FTSDLVisitor ) return ((FTSDLVisitor<? extends T>)visitor).visitArglist(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArglistContext arglist() throws RecognitionException {
		ArglistContext _localctx = new ArglistContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_arglist);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(264);
			expression(0);
			setState(269);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__56) {
				{
				{
				setState(265);
				match(T__56);
				setState(266);
				expression(0);
				}
				}
				setState(271);
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

	public static class LiteralExpressionContext extends ParserRuleContext {
		public TerminalNode INTEGER() { return getToken(FTSDLParser.INTEGER, 0); }
		public TerminalNode IDENTIFIER() { return getToken(FTSDLParser.IDENTIFIER, 0); }
		public LiteralExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literalExpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FTSDLVisitor ) return ((FTSDLVisitor<? extends T>)visitor).visitLiteralExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralExpressionContext literalExpression() throws RecognitionException {
		LiteralExpressionContext _localctx = new LiteralExpressionContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_literalExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(272);
			_la = _input.LA(1);
			if ( !(_la==IDENTIFIER || _la==INTEGER) ) {
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 9:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 18);
		case 1:
			return precpred(_ctx, 17);
		case 2:
			return precpred(_ctx, 16);
		case 3:
			return precpred(_ctx, 15);
		case 4:
			return precpred(_ctx, 14);
		case 5:
			return precpred(_ctx, 13);
		case 6:
			return precpred(_ctx, 12);
		case 7:
			return precpred(_ctx, 3);
		case 8:
			return precpred(_ctx, 20);
		case 9:
			return precpred(_ctx, 19);
		case 10:
			return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3@\u0115\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\3\2\3\2\7"+
		"\2\63\n\2\f\2\16\2\66\13\2\3\2\5\29\n\2\6\2;\n\2\r\2\16\2<\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4Q\n\4"+
		"\3\5\7\5T\n\5\f\5\16\5W\13\5\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\5\7b"+
		"\n\7\3\7\3\7\3\7\5\7g\n\7\3\7\5\7j\n\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\5\b"+
		"s\n\b\5\bu\n\b\3\b\3\b\5\by\n\b\3\b\3\b\5\b}\n\b\3\b\3\b\5\b\u0081\n\b"+
		"\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\5\n\u0096\n\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u00af"+
		"\n\13\3\13\3\13\3\13\3\13\5\13\u00b5\n\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u00d6\n\13"+
		"\3\13\7\13\u00d9\n\13\f\13\16\13\u00dc\13\13\3\f\3\f\3\f\3\f\5\f\u00e2"+
		"\n\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00eb\n\r\3\r\3\r\3\r\3\r\5\r\u00f1"+
		"\n\r\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u00f9\n\16\3\17\3\17\3\20\3\20"+
		"\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27"+
		"\3\27\7\27\u010e\n\27\f\27\16\27\u0111\13\27\3\30\3\30\3\30\2\3\24\31"+
		"\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\2\t\3\2\"\'\3\2(,\3\2"+
		"-\60\3\2\61\62\3\2\64\65\3\2\669\3\2=>\u0134\2:\3\2\2\2\4>\3\2\2\2\6P"+
		"\3\2\2\2\bU\3\2\2\2\nX\3\2\2\2\f\\\3\2\2\2\16n\3\2\2\2\20\u0086\3\2\2"+
		"\2\22\u008e\3\2\2\2\24\u00b4\3\2\2\2\26\u00e1\3\2\2\2\30\u00f0\3\2\2\2"+
		"\32\u00f8\3\2\2\2\34\u00fa\3\2\2\2\36\u00fc\3\2\2\2 \u00fe\3\2\2\2\"\u0100"+
		"\3\2\2\2$\u0102\3\2\2\2&\u0104\3\2\2\2(\u0106\3\2\2\2*\u0108\3\2\2\2,"+
		"\u010a\3\2\2\2.\u0112\3\2\2\2\608\5\4\3\2\61\63\7?\2\2\62\61\3\2\2\2\63"+
		"\66\3\2\2\2\64\62\3\2\2\2\64\65\3\2\2\2\659\3\2\2\2\66\64\3\2\2\2\679"+
		"\7\2\2\38\64\3\2\2\28\67\3\2\2\29;\3\2\2\2:\60\3\2\2\2;<\3\2\2\2<:\3\2"+
		"\2\2<=\3\2\2\2=\3\3\2\2\2>?\7\3\2\2?@\7=\2\2@A\7?\2\2AB\5\b\5\2BC\7\4"+
		"\2\2C\5\3\2\2\2DE\5\24\13\2EF\7?\2\2FQ\3\2\2\2GH\5\n\6\2HI\7?\2\2IQ\3"+
		"\2\2\2JK\7\5\2\2KQ\7?\2\2LQ\5\f\7\2MQ\5\16\b\2NQ\5\20\t\2OQ\5\22\n\2P"+
		"D\3\2\2\2PG\3\2\2\2PJ\3\2\2\2PL\3\2\2\2PM\3\2\2\2PN\3\2\2\2PO\3\2\2\2"+
		"Q\7\3\2\2\2RT\5\6\4\2SR\3\2\2\2TW\3\2\2\2US\3\2\2\2UV\3\2\2\2V\t\3\2\2"+
		"\2WU\3\2\2\2XY\7=\2\2YZ\7\6\2\2Z[\5\24\13\2[\13\3\2\2\2\\]\7\7\2\2]^\7"+
		"\b\2\2^_\5\24\13\2_a\7\t\2\2`b\7?\2\2a`\3\2\2\2ab\3\2\2\2bc\3\2\2\2ci"+
		"\5\b\5\2df\7\n\2\2eg\7?\2\2fe\3\2\2\2fg\3\2\2\2gh\3\2\2\2hj\5\b\5\2id"+
		"\3\2\2\2ij\3\2\2\2jk\3\2\2\2kl\7\4\2\2lm\7?\2\2m\r\3\2\2\2no\7\13\2\2"+
		"ot\7\b\2\2pu\5\n\6\2qs\5\24\13\2rq\3\2\2\2rs\3\2\2\2su\3\2\2\2tp\3\2\2"+
		"\2tr\3\2\2\2uv\3\2\2\2vx\7\f\2\2wy\5\24\13\2xw\3\2\2\2xy\3\2\2\2yz\3\2"+
		"\2\2z|\7\f\2\2{}\5\24\13\2|{\3\2\2\2|}\3\2\2\2}~\3\2\2\2~\u0080\7\t\2"+
		"\2\177\u0081\7?\2\2\u0080\177\3\2\2\2\u0080\u0081\3\2\2\2\u0081\u0082"+
		"\3\2\2\2\u0082\u0083\5\b\5\2\u0083\u0084\7\4\2\2\u0084\u0085\7?\2\2\u0085"+
		"\17\3\2\2\2\u0086\u0087\7\r\2\2\u0087\u0088\7\b\2\2\u0088\u0089\5\24\13"+
		"\2\u0089\u008a\7\t\2\2\u008a\u008b\5\b\5\2\u008b\u008c\7\4\2\2\u008c\u008d"+
		"\7?\2\2\u008d\21\3\2\2\2\u008e\u008f\7\16\2\2\u008f\u0090\7\b\2\2\u0090"+
		"\u0091\7=\2\2\u0091\u0092\7\17\2\2\u0092\u0093\5\24\13\2\u0093\u0095\7"+
		"\t\2\2\u0094\u0096\7?\2\2\u0095\u0094\3\2\2\2\u0095\u0096\3\2\2\2\u0096"+
		"\u0097\3\2\2\2\u0097\u0098\5\b\5\2\u0098\u0099\7\4\2\2\u0099\u009a\7?"+
		"\2\2\u009a\23\3\2\2\2\u009b\u009c\b\13\1\2\u009c\u009d\7\20\2\2\u009d"+
		"\u00b5\5\24\13\31\u009e\u009f\7\21\2\2\u009f\u00b5\5\24\13\30\u00a0\u00a1"+
		"\7\22\2\2\u00a1\u00b5\5\24\13\27\u00a2\u00b5\5\26\f\2\u00a3\u00b5\5.\30"+
		"\2\u00a4\u00b5\5(\25\2\u00a5\u00b5\5*\26\2\u00a6\u00a7\7\b\2\2\u00a7\u00a8"+
		"\5\24\13\2\u00a8\u00a9\7\t\2\2\u00a9\u00b5\3\2\2\2\u00aa\u00b5\5\30\r"+
		"\2\u00ab\u00ac\5\32\16\2\u00ac\u00ae\7\b\2\2\u00ad\u00af\5,\27\2\u00ae"+
		"\u00ad\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0\u00b1\7\t"+
		"\2\2\u00b1\u00b5\3\2\2\2\u00b2\u00b5\7\31\2\2\u00b3\u00b5\7\32\2\2\u00b4"+
		"\u009b\3\2\2\2\u00b4\u009e\3\2\2\2\u00b4\u00a0\3\2\2\2\u00b4\u00a2\3\2"+
		"\2\2\u00b4\u00a3\3\2\2\2\u00b4\u00a4\3\2\2\2\u00b4\u00a5\3\2\2\2\u00b4"+
		"\u00a6\3\2\2\2\u00b4\u00aa\3\2\2\2\u00b4\u00ab\3\2\2\2\u00b4\u00b2\3\2"+
		"\2\2\u00b4\u00b3\3\2\2\2\u00b5\u00da\3\2\2\2\u00b6\u00b7\f\24\2\2\u00b7"+
		"\u00b8\7\23\2\2\u00b8\u00d9\5\24\13\25\u00b9\u00ba\f\23\2\2\u00ba\u00bb"+
		"\7\20\2\2\u00bb\u00d9\5\24\13\24\u00bc\u00bd\f\22\2\2\u00bd\u00be\7\24"+
		"\2\2\u00be\u00d9\5\24\13\23\u00bf\u00c0\f\21\2\2\u00c0\u00c1\7\25\2\2"+
		"\u00c1\u00d9\5\24\13\22\u00c2\u00c3\f\20\2\2\u00c3\u00c4\7<\2\2\u00c4"+
		"\u00d9\5\24\13\21\u00c5\u00c6\f\17\2\2\u00c6\u00c7\7\26\2\2\u00c7\u00d9"+
		"\5\24\13\20\u00c8\u00c9\f\16\2\2\u00c9\u00ca\7\27\2\2\u00ca\u00d9\5\24"+
		"\13\17\u00cb\u00cc\f\5\2\2\u00cc\u00cd\7\30\2\2\u00cd\u00d9\5\24\13\6"+
		"\u00ce\u00cf\f\26\2\2\u00cf\u00d9\7\21\2\2\u00d0\u00d1\f\25\2\2\u00d1"+
		"\u00d9\7\22\2\2\u00d2\u00d3\f\6\2\2\u00d3\u00d5\7\b\2\2\u00d4\u00d6\5"+
		",\27\2\u00d5\u00d4\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7"+
		"\u00d9\7\t\2\2\u00d8\u00b6\3\2\2\2\u00d8\u00b9\3\2\2\2\u00d8\u00bc\3\2"+
		"\2\2\u00d8\u00bf\3\2\2\2\u00d8\u00c2\3\2\2\2\u00d8\u00c5\3\2\2\2\u00d8"+
		"\u00c8\3\2\2\2\u00d8\u00cb\3\2\2\2\u00d8\u00ce\3\2\2\2\u00d8\u00d0\3\2"+
		"\2\2\u00d8\u00d2\3\2\2\2\u00d9\u00dc\3\2\2\2\u00da\u00d8\3\2\2\2\u00da"+
		"\u00db\3\2\2\2\u00db\25\3\2\2\2\u00dc\u00da\3\2\2\2\u00dd\u00de\7\33\2"+
		"\2\u00de\u00e2\5\24\13\2\u00df\u00e2\7\34\2\2\u00e0\u00e2\7\35\2\2\u00e1"+
		"\u00dd\3\2\2\2\u00e1\u00df\3\2\2\2\u00e1\u00e0\3\2\2\2\u00e2\27\3\2\2"+
		"\2\u00e3\u00f1\7\36\2\2\u00e4\u00f1\7\37\2\2\u00e5\u00e6\7 \2\2\u00e6"+
		"\u00e7\5\24\13\2\u00e7\u00e8\5(\25\2\u00e8\u00ea\5\24\13\2\u00e9\u00eb"+
		"\5\24\13\2\u00ea\u00e9\3\2\2\2\u00ea\u00eb\3\2\2\2\u00eb\u00f1\3\2\2\2"+
		"\u00ec\u00ed\7!\2\2\u00ed\u00ee\5\24\13\2\u00ee\u00ef\5\24\13\2\u00ef"+
		"\u00f1\3\2\2\2\u00f0\u00e3\3\2\2\2\u00f0\u00e4\3\2\2\2\u00f0\u00e5\3\2"+
		"\2\2\u00f0\u00ec\3\2\2\2\u00f1\31\3\2\2\2\u00f2\u00f9\5\34\17\2\u00f3"+
		"\u00f9\5\36\20\2\u00f4\u00f9\5\"\22\2\u00f5\u00f9\5$\23\2\u00f6\u00f9"+
		"\5&\24\2\u00f7\u00f9\5 \21\2\u00f8\u00f2\3\2\2\2\u00f8\u00f3\3\2\2\2\u00f8"+
		"\u00f4\3\2\2\2\u00f8\u00f5\3\2\2\2\u00f8\u00f6\3\2\2\2\u00f8\u00f7\3\2"+
		"\2\2\u00f9\33\3\2\2\2\u00fa\u00fb\t\2\2\2\u00fb\35\3\2\2\2\u00fc\u00fd"+
		"\t\3\2\2\u00fd\37\3\2\2\2\u00fe\u00ff\t\4\2\2\u00ff!\3\2\2\2\u0100\u0101"+
		"\t\5\2\2\u0101#\3\2\2\2\u0102\u0103\7\63\2\2\u0103%\3\2\2\2\u0104\u0105"+
		"\t\6\2\2\u0105\'\3\2\2\2\u0106\u0107\t\7\2\2\u0107)\3\2\2\2\u0108\u0109"+
		"\7:\2\2\u0109+\3\2\2\2\u010a\u010f\5\24\13\2\u010b\u010c\7;\2\2\u010c"+
		"\u010e\5\24\13\2\u010d\u010b\3\2\2\2\u010e\u0111\3\2\2\2\u010f\u010d\3"+
		"\2\2\2\u010f\u0110\3\2\2\2\u0110-\3\2\2\2\u0111\u010f\3\2\2\2\u0112\u0113"+
		"\t\b\2\2\u0113/\3\2\2\2\32\648<PUafirtx|\u0080\u0095\u00ae\u00b4\u00d5"+
		"\u00d8\u00da\u00e1\u00ea\u00f0\u00f8\u010f";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}