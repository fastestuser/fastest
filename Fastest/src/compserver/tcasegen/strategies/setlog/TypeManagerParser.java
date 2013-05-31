// Generated from TypeManager.g4 by ANTLR 4.0

	package compserver.tcasegen.strategies.setlog;
	import javax.swing.tree.DefaultMutableTreeNode;
	import javax.swing.tree.DefaultTreeModel;
	import javax.swing.tree.TreeNode;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class TypeManagerParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__6=1, T__5=2, T__4=3, T__3=4, T__2=5, T__1=6, T__0=7, BINOP=8, UNOP=9, 
		NAME=10, NUM=11, WS=12;
	public static final String[] tokenNames = {
		"<INVALID>", "'\\nat'", "'\\upto'", "')'", "'('", "'\\num'", "'\\cross'", 
		"'\\nat_{1}'", "BINOP", "UNOP", "NAME", "NUM", "WS"
	};
	public static final int
		RULE_typeManage = 0, RULE_typeManageNorm = 1, RULE_type = 2, RULE_typeNorm = 3;
	public static final String[] ruleNames = {
		"typeManage", "typeManageNorm", "type", "typeNorm"
	};

	@Override
	public String getGrammarFileName() { return "TypeManager.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public ATN getATN() { return _ATN; }


		DefaultMutableTreeNode root = new DefaultMutableTreeNode();
		
		public DefaultMutableTreeNode getRoot() {
			return root;
		}
		
		public static String printTree(DefaultMutableTreeNode tree){
			if (tree.isLeaf()) 
				return (String) tree.getUserObject();
			else if (tree.getChildCount() == 1)
				if ( ((String) tree.getUserObject()).equals("()")) //REVISAR
					return "(" + printTree((DefaultMutableTreeNode) tree.getChildAt(0)) + ")";
				else
					return (String) tree.getUserObject() + printTree((DefaultMutableTreeNode) tree.getChildAt(0));
			else //tiene dos hijos
				return printTree((DefaultMutableTreeNode) tree.getChildAt(0)) + ((String) tree.getUserObject()) + printTree((DefaultMutableTreeNode) tree.getChildAt(1));
		}

	public TypeManagerParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class TypeManageContext extends ParserRuleContext {
		public TypeContext type;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TypeManageContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeManage; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypeManagerListener ) ((TypeManagerListener)listener).enterTypeManage(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypeManagerListener ) ((TypeManagerListener)listener).exitTypeManage(this);
		}
	}

	public final TypeManageContext typeManage() throws RecognitionException {
		TypeManageContext _localctx = new TypeManageContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_typeManage);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(8); ((TypeManageContext)_localctx).type = type(0);
			root = ((TypeManageContext)_localctx).type.node; /*System.out.println("Root: " + printTree(root)); System.out.println("Node1: " + getReturnNodeType(0));*/
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

	public static class TypeManageNormContext extends ParserRuleContext {
		public TypeNormContext typeNorm;
		public TypeNormContext typeNorm() {
			return getRuleContext(TypeNormContext.class,0);
		}
		public TypeManageNormContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeManageNorm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypeManagerListener ) ((TypeManagerListener)listener).enterTypeManageNorm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypeManagerListener ) ((TypeManagerListener)listener).exitTypeManageNorm(this);
		}
	}

	public final TypeManageNormContext typeManageNorm() throws RecognitionException {
		TypeManageNormContext _localctx = new TypeManageNormContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_typeManageNorm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(11); ((TypeManageNormContext)_localctx).typeNorm = typeNorm(0);
			root = ((TypeManageNormContext)_localctx).typeNorm.node; /*System.out.println("Root: " + printTree(root)); System.out.println("Node1: " + getReturnNodeType(0));*/
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
		public int _p;
		public DefaultMutableTreeNode node;
		public TypeContext a;
		public Token UNOP;
		public Token NAME;
		public Token e1;
		public Token e2;
		public Token BINOP;
		public TypeContext b;
		public TerminalNode NUM(int i) {
			return getToken(TypeManagerParser.NUM, i);
		}
		public TerminalNode UNOP() { return getToken(TypeManagerParser.UNOP, 0); }
		public List<TerminalNode> NAME() { return getTokens(TypeManagerParser.NAME); }
		public TerminalNode BINOP() { return getToken(TypeManagerParser.BINOP, 0); }
		public TerminalNode NAME(int i) {
			return getToken(TypeManagerParser.NAME, i);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public List<TerminalNode> NUM() { return getTokens(TypeManagerParser.NUM); }
		public TypeContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public TypeContext(ParserRuleContext parent, int invokingState, int _p) {
			super(parent, invokingState);
			this._p = _p;
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypeManagerListener ) ((TypeManagerListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypeManagerListener ) ((TypeManagerListener)listener).exitType(this);
		}
	}

	public final TypeContext type(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TypeContext _localctx = new TypeContext(_ctx, _parentState, _p);
		TypeContext _prevctx = _localctx;
		int _startState = 4;
		enterRecursionRule(_localctx, RULE_type);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				{
				setState(15); ((TypeContext)_localctx).UNOP = match(UNOP);
				setState(16); ((TypeContext)_localctx).a = type(9);
				((TypeContext)_localctx).node =  new DefaultMutableTreeNode((((TypeContext)_localctx).UNOP!=null?((TypeContext)_localctx).UNOP.getText():null)); _localctx.node.add(((TypeContext)_localctx).a.node);
				}
				break;

			case 2:
				{
				setState(19); match(4);
				setState(20); ((TypeContext)_localctx).a = type(0);
				setState(21); match(3);
				((TypeContext)_localctx).node =  new DefaultMutableTreeNode("()"); _localctx.node.add(((TypeContext)_localctx).a.node);
				}
				break;

			case 3:
				{
				setState(24); match(5);
				((TypeContext)_localctx).node =  new DefaultMutableTreeNode("\\num");
				}
				break;

			case 4:
				{
				setState(26); match(7);
				((TypeContext)_localctx).node =  new DefaultMutableTreeNode("\\nat_{1}");
				}
				break;

			case 5:
				{
				setState(28); match(1);
				((TypeContext)_localctx).node =  new DefaultMutableTreeNode("\\nat");
				}
				break;

			case 6:
				{
				setState(30); ((TypeContext)_localctx).NAME = match(NAME);
				((TypeContext)_localctx).node =  new DefaultMutableTreeNode((((TypeContext)_localctx).NAME!=null?((TypeContext)_localctx).NAME.getText():null));
				}
				break;

			case 7:
				{
				setState(32);
				((TypeContext)_localctx).e1 = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==NAME || _la==NUM) ) {
					((TypeContext)_localctx).e1 = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(33); match(2);
				setState(34);
				((TypeContext)_localctx).e2 = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==NAME || _la==NUM) ) {
					((TypeContext)_localctx).e2 = (Token)_errHandler.recoverInline(this);
				}
				consume();
				((TypeContext)_localctx).node =  new DefaultMutableTreeNode((((TypeContext)_localctx).e1!=null?((TypeContext)_localctx).e1.getText():null) + "\\upto" + (((TypeContext)_localctx).e2!=null?((TypeContext)_localctx).e2.getText():null));
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(50);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(48);
					switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
					case 1:
						{
						_localctx = new TypeContext(_parentctx, _parentState, _p);
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_type);
						setState(38);
						if (!(8 >= _localctx._p)) throw new FailedPredicateException(this, "8 >= $_p");
						setState(39); ((TypeContext)_localctx).BINOP = match(BINOP);
						setState(40); ((TypeContext)_localctx).b = type(9);
						((TypeContext)_localctx).node =  new DefaultMutableTreeNode((((TypeContext)_localctx).BINOP!=null?((TypeContext)_localctx).BINOP.getText():null)); _localctx.node.add(((TypeContext)_localctx).a.node); _localctx.node.add(((TypeContext)_localctx).b.node);
						}
						break;

					case 2:
						{
						_localctx = new TypeContext(_parentctx, _parentState, _p);
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_type);
						setState(43);
						if (!(7 >= _localctx._p)) throw new FailedPredicateException(this, "7 >= $_p");
						setState(44); match(6);
						setState(45); ((TypeContext)_localctx).b = type(8);
						((TypeContext)_localctx).node =  new DefaultMutableTreeNode("\\cross"); _localctx.node.add(((TypeContext)_localctx).a.node); _localctx.node.add(((TypeContext)_localctx).b.node);
						}
						break;
					}
					} 
				}
				setState(52);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
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

	public static class TypeNormContext extends ParserRuleContext {
		public int _p;
		public DefaultMutableTreeNode node;
		public TypeNormContext a;
		public Token UNOP;
		public Token NAME;
		public Token e1;
		public Token e2;
		public TypeNormContext b;
		public TerminalNode NUM(int i) {
			return getToken(TypeManagerParser.NUM, i);
		}
		public TerminalNode UNOP() { return getToken(TypeManagerParser.UNOP, 0); }
		public List<TerminalNode> NAME() { return getTokens(TypeManagerParser.NAME); }
		public TypeNormContext typeNorm(int i) {
			return getRuleContext(TypeNormContext.class,i);
		}
		public TerminalNode BINOP() { return getToken(TypeManagerParser.BINOP, 0); }
		public TerminalNode NAME(int i) {
			return getToken(TypeManagerParser.NAME, i);
		}
		public List<TypeNormContext> typeNorm() {
			return getRuleContexts(TypeNormContext.class);
		}
		public List<TerminalNode> NUM() { return getTokens(TypeManagerParser.NUM); }
		public TypeNormContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public TypeNormContext(ParserRuleContext parent, int invokingState, int _p) {
			super(parent, invokingState);
			this._p = _p;
		}
		@Override public int getRuleIndex() { return RULE_typeNorm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypeManagerListener ) ((TypeManagerListener)listener).enterTypeNorm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypeManagerListener ) ((TypeManagerListener)listener).exitTypeNorm(this);
		}
	}

	public final TypeNormContext typeNorm(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TypeNormContext _localctx = new TypeNormContext(_ctx, _parentState, _p);
		TypeNormContext _prevctx = _localctx;
		int _startState = 6;
		enterRecursionRule(_localctx, RULE_typeNorm);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(54); ((TypeNormContext)_localctx).UNOP = match(UNOP);
				setState(55); ((TypeNormContext)_localctx).a = typeNorm(9);
				((TypeNormContext)_localctx).node =  new DefaultMutableTreeNode((((TypeNormContext)_localctx).UNOP!=null?((TypeNormContext)_localctx).UNOP.getText():null)); _localctx.node.add(((TypeNormContext)_localctx).a.node);
				}
				break;

			case 2:
				{
				setState(58); match(4);
				setState(59); ((TypeNormContext)_localctx).a = typeNorm(0);
				setState(60); match(3);
				((TypeNormContext)_localctx).node =  ((TypeNormContext)_localctx).a.node;
				}
				break;

			case 3:
				{
				setState(63); match(5);
				((TypeNormContext)_localctx).node =  new DefaultMutableTreeNode("\\num");
				}
				break;

			case 4:
				{
				setState(65); match(7);
				((TypeNormContext)_localctx).node =  new DefaultMutableTreeNode("\\nat_{1}");
				}
				break;

			case 5:
				{
				setState(67); match(1);
				((TypeNormContext)_localctx).node =  new DefaultMutableTreeNode("\\nat");
				}
				break;

			case 6:
				{
				setState(69); ((TypeNormContext)_localctx).NAME = match(NAME);
				((TypeNormContext)_localctx).node =  new DefaultMutableTreeNode((((TypeNormContext)_localctx).NAME!=null?((TypeNormContext)_localctx).NAME.getText():null));
				}
				break;

			case 7:
				{
				setState(71);
				((TypeNormContext)_localctx).e1 = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==NAME || _la==NUM) ) {
					((TypeNormContext)_localctx).e1 = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(72); match(2);
				setState(73);
				((TypeNormContext)_localctx).e2 = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==NAME || _la==NUM) ) {
					((TypeNormContext)_localctx).e2 = (Token)_errHandler.recoverInline(this);
				}
				consume();
				((TypeNormContext)_localctx).node =  new DefaultMutableTreeNode((((TypeNormContext)_localctx).e1!=null?((TypeNormContext)_localctx).e1.getText():null) + "\\upto" + (((TypeNormContext)_localctx).e2!=null?((TypeNormContext)_localctx).e2.getText():null));
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(89);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(87);
					switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
					case 1:
						{
						_localctx = new TypeNormContext(_parentctx, _parentState, _p);
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_typeNorm);
						setState(77);
						if (!(8 >= _localctx._p)) throw new FailedPredicateException(this, "8 >= $_p");
						setState(78); match(BINOP);
						setState(79); ((TypeNormContext)_localctx).b = typeNorm(9);

						          					((TypeNormContext)_localctx).node =  new DefaultMutableTreeNode("\\power"); 
						          					DefaultMutableTreeNode cross = new DefaultMutableTreeNode("\\cross");
						          					_localctx.node.add(cross);
						          					cross.add(((TypeNormContext)_localctx).a.node); 
						          					cross.add(((TypeNormContext)_localctx).b.node);
						          				
						}
						break;

					case 2:
						{
						_localctx = new TypeNormContext(_parentctx, _parentState, _p);
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_typeNorm);
						setState(82);
						if (!(7 >= _localctx._p)) throw new FailedPredicateException(this, "7 >= $_p");
						setState(83); match(6);
						setState(84); ((TypeNormContext)_localctx).b = typeNorm(8);

						          					((TypeNormContext)_localctx).node =  new DefaultMutableTreeNode("\\cross");
						          					_localctx.node.add(((TypeNormContext)_localctx).a.node); 
						          					_localctx.node.add(((TypeNormContext)_localctx).b.node);
						          				
						}
						break;
					}
					} 
				}
				setState(91);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
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
		case 2: return type_sempred((TypeContext)_localctx, predIndex);

		case 3: return typeNorm_sempred((TypeNormContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean typeNorm_sempred(TypeNormContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2: return 8 >= _localctx._p;

		case 3: return 7 >= _localctx._p;
		}
		return true;
	}
	private boolean type_sempred(TypeContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return 8 >= _localctx._p;

		case 1: return 7 >= _localctx._p;
		}
		return true;
	}

	public static final String _serializedATN =
		"\2\3\16_\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\3\2\3\2\3\2\3\3\3\3\3\3\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\5\4\'\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4\63"+
		"\n\4\f\4\16\4\66\13\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5N\n\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\7\5Z\n\5\f\5\16\5]\13\5\3\5\2\6\2\4\6\b\2\6\3\f\r"+
		"\3\f\r\3\f\r\3\f\rj\2\n\3\2\2\2\4\r\3\2\2\2\6&\3\2\2\2\bM\3\2\2\2\n\13"+
		"\5\6\4\2\13\f\b\2\1\2\f\3\3\2\2\2\r\16\5\b\5\2\16\17\b\3\1\2\17\5\3\2"+
		"\2\2\20\21\b\4\1\2\21\22\7\13\2\2\22\23\5\6\4\2\23\24\b\4\1\2\24\'\3\2"+
		"\2\2\25\26\7\6\2\2\26\27\5\6\4\2\27\30\7\5\2\2\30\31\b\4\1\2\31\'\3\2"+
		"\2\2\32\33\7\7\2\2\33\'\b\4\1\2\34\35\7\t\2\2\35\'\b\4\1\2\36\37\7\3\2"+
		"\2\37\'\b\4\1\2 !\7\f\2\2!\'\b\4\1\2\"#\t\2\2\2#$\7\4\2\2$%\t\3\2\2%\'"+
		"\b\4\1\2&\20\3\2\2\2&\25\3\2\2\2&\32\3\2\2\2&\34\3\2\2\2&\36\3\2\2\2&"+
		" \3\2\2\2&\"\3\2\2\2\'\64\3\2\2\2()\6\4\2\3)*\7\n\2\2*+\5\6\4\2+,\b\4"+
		"\1\2,\63\3\2\2\2-.\6\4\3\3./\7\b\2\2/\60\5\6\4\2\60\61\b\4\1\2\61\63\3"+
		"\2\2\2\62(\3\2\2\2\62-\3\2\2\2\63\66\3\2\2\2\64\62\3\2\2\2\64\65\3\2\2"+
		"\2\65\7\3\2\2\2\66\64\3\2\2\2\678\b\5\1\289\7\13\2\29:\5\b\5\2:;\b\5\1"+
		"\2;N\3\2\2\2<=\7\6\2\2=>\5\b\5\2>?\7\5\2\2?@\b\5\1\2@N\3\2\2\2AB\7\7\2"+
		"\2BN\b\5\1\2CD\7\t\2\2DN\b\5\1\2EF\7\3\2\2FN\b\5\1\2GH\7\f\2\2HN\b\5\1"+
		"\2IJ\t\4\2\2JK\7\4\2\2KL\t\5\2\2LN\b\5\1\2M\67\3\2\2\2M<\3\2\2\2MA\3\2"+
		"\2\2MC\3\2\2\2ME\3\2\2\2MG\3\2\2\2MI\3\2\2\2N[\3\2\2\2OP\6\5\4\3PQ\7\n"+
		"\2\2QR\5\b\5\2RS\b\5\1\2SZ\3\2\2\2TU\6\5\5\3UV\7\b\2\2VW\5\b\5\2WX\b\5"+
		"\1\2XZ\3\2\2\2YO\3\2\2\2YT\3\2\2\2Z]\3\2\2\2[Y\3\2\2\2[\\\3\2\2\2\\\t"+
		"\3\2\2\2][\3\2\2\2\b&\62\64MY[";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}