// Generated from Axdef.g4 by ANTLR 4.0

	package compserver.axdef;
	import java.util.HashMap;
	import java.util.ArrayList;
	import java.util.regex.Matcher;
	import java.util.regex.Pattern;
	import java.util.Collection;
	import java.util.Iterator;
	import java.util.Set;
	import java.lang.String;
	import javax.swing.tree.DefaultMutableTreeNode;
	import javax.rmi.CORBA.Util;
	

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class AxdefParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__4=1, T__3=2, T__2=3, T__1=4, T__0=5, OP=6, WORD=7, NUM=8, WS=9;
	public static final String[] tokenNames = {
		"<INVALID>", "'\\emptyset'", "')'", "','", "'('", "'~'", "OP", "WORD", 
		"NUM", "WS"
	};
	public static final int
		RULE_strategy = 0, RULE_expression = 1, RULE_simpleArgument = 2, RULE_complexArgument = 3;
	public static final String[] ruleNames = {
		"strategy", "expression", "simpleArgument", "complexArgument"
	};

	@Override
	public String getGrammarFileName() { return "Axdef.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public ATN getATN() { return _ATN; }


		ArrayList<String> arguments = new ArrayList<String>();
		String functionName;
		int argAmmount;

		DefaultMutableTreeNode root = new DefaultMutableTreeNode();
		public DefaultMutableTreeNode getRoot() {
			return root;
		}

	public AxdefParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class StrategyContext extends ParserRuleContext {
		public ExpressionContext expression;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StrategyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_strategy; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AxdefListener ) ((AxdefListener)listener).enterStrategy(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AxdefListener ) ((AxdefListener)listener).exitStrategy(this);
		}
	}

	public final StrategyContext strategy() throws RecognitionException {
		StrategyContext _localctx = new StrategyContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_strategy);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(8); ((StrategyContext)_localctx).expression = expression(0);
			root = ((StrategyContext)_localctx).expression.node;
			}
		}
		catch (RecognitionException re) {
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
		public int _p;
		public DefaultMutableTreeNode node;
		public ExpressionContext e1;
		public SimpleArgumentContext simpleArgument;
		public ComplexArgumentContext complexArgument;
		public Token OP;
		public ExpressionContext e2;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public SimpleArgumentContext simpleArgument(int i) {
			return getRuleContext(SimpleArgumentContext.class,i);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<SimpleArgumentContext> simpleArgument() {
			return getRuleContexts(SimpleArgumentContext.class);
		}
		public ComplexArgumentContext complexArgument(int i) {
			return getRuleContext(ComplexArgumentContext.class,i);
		}
		public TerminalNode OP() { return getToken(AxdefParser.OP, 0); }
		public List<ComplexArgumentContext> complexArgument() {
			return getRuleContexts(ComplexArgumentContext.class);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public ExpressionContext(ParserRuleContext parent, int invokingState, int _p) {
			super(parent, invokingState);
			this._p = _p;
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AxdefListener ) ((AxdefListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AxdefListener ) ((AxdefListener)listener).exitExpression(this);
		}
	}

	public final ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState, _p);
		ExpressionContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, RULE_expression);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(18);
			switch (_input.LA(1)) {
			case 1:
			case WORD:
			case NUM:
				{
				setState(12); ((ExpressionContext)_localctx).simpleArgument = simpleArgument();
				((ExpressionContext)_localctx).node =  ((ExpressionContext)_localctx).simpleArgument.node;
				}
				break;
			case 4:
				{
				setState(15); ((ExpressionContext)_localctx).complexArgument = complexArgument();
				((ExpressionContext)_localctx).node =  ((ExpressionContext)_localctx).simpleArgument.node;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(40);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(38);
					switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(20);
						if (!(3 >= _localctx._p)) throw new FailedPredicateException(this, "3 >= $_p");
						setState(21); ((ExpressionContext)_localctx).OP = match(OP);
						setState(22); ((ExpressionContext)_localctx).e2 = expression(4);
						((ExpressionContext)_localctx).node =  new DefaultMutableTreeNode((((ExpressionContext)_localctx).OP!=null?((ExpressionContext)_localctx).OP.getText():null)); _localctx.node.add(((ExpressionContext)_localctx).e1.node); _localctx.node.add(((ExpressionContext)_localctx).e2.node);
						}
						break;

					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(25);
						if (!(4 >= _localctx._p)) throw new FailedPredicateException(this, "4 >= $_p");
						((ExpressionContext)_localctx).node =  new DefaultMutableTreeNode("APPLY");_localctx.node.add(((ExpressionContext)_localctx).e1.node);
						setState(34); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
						do {
							switch (_alt) {
							case 1:
								{
								setState(34);
								switch (_input.LA(1)) {
								case 5:
									{
									setState(27); match(5);
									setState(28); ((ExpressionContext)_localctx).simpleArgument = simpleArgument();
									_localctx.node.add(((ExpressionContext)_localctx).simpleArgument.node);
									}
									break;
								case 4:
									{
									setState(31); ((ExpressionContext)_localctx).complexArgument = complexArgument();
									_localctx.node.add(((ExpressionContext)_localctx).complexArgument.node);
									}
									break;
								default:
									throw new NoViableAltException(this);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(36); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
						} while ( _alt!=2 && _alt!=-1 );
						}
						break;
					}
					} 
				}
				setState(42);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
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

	public static class SimpleArgumentContext extends ParserRuleContext {
		public DefaultMutableTreeNode node;
		public Token WORD;
		public Token NUM;
		public TerminalNode WORD() { return getToken(AxdefParser.WORD, 0); }
		public TerminalNode NUM() { return getToken(AxdefParser.NUM, 0); }
		public SimpleArgumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleArgument; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AxdefListener ) ((AxdefListener)listener).enterSimpleArgument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AxdefListener ) ((AxdefListener)listener).exitSimpleArgument(this);
		}
	}

	public final SimpleArgumentContext simpleArgument() throws RecognitionException {
		SimpleArgumentContext _localctx = new SimpleArgumentContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_simpleArgument);
		try {
			setState(49);
			switch (_input.LA(1)) {
			case WORD:
				enterOuterAlt(_localctx, 1);
				{
				setState(43); ((SimpleArgumentContext)_localctx).WORD = match(WORD);
				((SimpleArgumentContext)_localctx).node =  new DefaultMutableTreeNode((((SimpleArgumentContext)_localctx).WORD!=null?((SimpleArgumentContext)_localctx).WORD.getText():null));
				}
				break;
			case NUM:
				enterOuterAlt(_localctx, 2);
				{
				setState(45); ((SimpleArgumentContext)_localctx).NUM = match(NUM);
				((SimpleArgumentContext)_localctx).node =  new DefaultMutableTreeNode((((SimpleArgumentContext)_localctx).NUM!=null?((SimpleArgumentContext)_localctx).NUM.getText():null));
				}
				break;
			case 1:
				enterOuterAlt(_localctx, 3);
				{
				setState(47); match(1);
				((SimpleArgumentContext)_localctx).node =  new DefaultMutableTreeNode("\\emptyset");
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

	public static class ComplexArgumentContext extends ParserRuleContext {
		public DefaultMutableTreeNode node;
		public ExpressionContext c1;
		public ExpressionContext c2;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ComplexArgumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_complexArgument; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AxdefListener ) ((AxdefListener)listener).enterComplexArgument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AxdefListener ) ((AxdefListener)listener).exitComplexArgument(this);
		}
	}

	public final ComplexArgumentContext complexArgument() throws RecognitionException {
		ComplexArgumentContext _localctx = new ComplexArgumentContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_complexArgument);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51); match(4);
			((ComplexArgumentContext)_localctx).node =  new DefaultMutableTreeNode("()");
			setState(53); ((ComplexArgumentContext)_localctx).c1 = expression(0);
			_localctx.node.add(((ComplexArgumentContext)_localctx).c1.node);
			setState(61);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==3) {
				{
				{
				setState(55); match(3);
				setState(56); ((ComplexArgumentContext)_localctx).c2 = expression(0);
				_localctx.node.add(((ComplexArgumentContext)_localctx).c2.node);
				}
				}
				setState(63);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(64); match(2);
			}
		}
		catch (RecognitionException re) {
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
		case 1: return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return 3 >= _localctx._p;

		case 1: return 4 >= _localctx._p;
		}
		return true;
	}

	public static final String _serializedATN =
		"\2\3\13E\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\5\3\25\n\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\6\3%\n\3\r\3\16\3&\7\3)\n\3\f\3\16\3,\13\3\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\5\4\64\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5>\n\5\f\5\16\5A\13"+
		"\5\3\5\3\5\3\5\2\6\2\4\6\b\2\2H\2\n\3\2\2\2\4\24\3\2\2\2\6\63\3\2\2\2"+
		"\b\65\3\2\2\2\n\13\5\4\3\2\13\f\b\2\1\2\f\3\3\2\2\2\r\16\b\3\1\2\16\17"+
		"\5\6\4\2\17\20\b\3\1\2\20\25\3\2\2\2\21\22\5\b\5\2\22\23\b\3\1\2\23\25"+
		"\3\2\2\2\24\r\3\2\2\2\24\21\3\2\2\2\25*\3\2\2\2\26\27\6\3\2\3\27\30\7"+
		"\b\2\2\30\31\5\4\3\2\31\32\b\3\1\2\32)\3\2\2\2\33\34\6\3\3\3\34$\b\3\1"+
		"\2\35\36\7\7\2\2\36\37\5\6\4\2\37 \b\3\1\2 %\3\2\2\2!\"\5\b\5\2\"#\b\3"+
		"\1\2#%\3\2\2\2$\35\3\2\2\2$!\3\2\2\2%&\3\2\2\2&$\3\2\2\2&\'\3\2\2\2\'"+
		")\3\2\2\2(\26\3\2\2\2(\33\3\2\2\2),\3\2\2\2*(\3\2\2\2*+\3\2\2\2+\5\3\2"+
		"\2\2,*\3\2\2\2-.\7\t\2\2.\64\b\4\1\2/\60\7\n\2\2\60\64\b\4\1\2\61\62\7"+
		"\3\2\2\62\64\b\4\1\2\63-\3\2\2\2\63/\3\2\2\2\63\61\3\2\2\2\64\7\3\2\2"+
		"\2\65\66\7\6\2\2\66\67\b\5\1\2\678\5\4\3\28?\b\5\1\29:\7\5\2\2:;\5\4\3"+
		"\2;<\b\5\1\2<>\3\2\2\2=9\3\2\2\2>A\3\2\2\2?=\3\2\2\2?@\3\2\2\2@B\3\2\2"+
		"\2A?\3\2\2\2BC\7\4\2\2C\t\3\2\2\2\t\24$&(*\63?";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}