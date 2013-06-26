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
		T__6=1, T__5=2, T__4=3, T__3=4, T__2=5, T__1=6, T__0=7, BINOP=8, NAME=9, 
		UNOP=10, NUM=11, WS=12;
	public static final String[] tokenNames = {
		"<INVALID>", "'\\nat'", "'\\upto'", "')'", "'('", "'\\num'", "'\\cross'", 
		"'\\nat_{1}'", "BINOP", "NAME", "UNOP", "NUM", "WS"
	};
	public static final int
		RULE_typeManage = 0, RULE_typeManageNorm = 1, RULE_type = 2, RULE_typeCross = 3, 
		RULE_typeNorm = 4, RULE_typeNormCross = 5;
	public static final String[] ruleNames = {
		"typeManage", "typeManageNorm", "type", "typeCross", "typeNorm", "typeNormCross"
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
			setState(12); ((TypeManageContext)_localctx).type = type(0);
			root = ((TypeManageContext)_localctx).type.node;
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
			setState(15); ((TypeManageNormContext)_localctx).typeNorm = typeNorm(0);
			root = ((TypeManageNormContext)_localctx).typeNorm.node;
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
		public TypeCrossContext c;
		public TerminalNode NUM(int i) {
			return getToken(TypeManagerParser.NUM, i);
		}
		public TerminalNode UNOP() { return getToken(TypeManagerParser.UNOP, 0); }
		public TypeCrossContext typeCross(int i) {
			return getRuleContext(TypeCrossContext.class,i);
		}
		public List<TerminalNode> NAME() { return getTokens(TypeManagerParser.NAME); }
		public TerminalNode BINOP() { return getToken(TypeManagerParser.BINOP, 0); }
		public TerminalNode NAME(int i) {
			return getToken(TypeManagerParser.NAME, i);
		}
		public List<TypeCrossContext> typeCross() {
			return getRuleContexts(TypeCrossContext.class);
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
			setState(40);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				{
				setState(19); ((TypeContext)_localctx).UNOP = match(UNOP);
				setState(20); ((TypeContext)_localctx).a = type(9);
				((TypeContext)_localctx).node =  new DefaultMutableTreeNode((((TypeContext)_localctx).UNOP!=null?((TypeContext)_localctx).UNOP.getText():null)); _localctx.node.add(((TypeContext)_localctx).a.node);
				}
				break;

			case 2:
				{
				setState(23); match(4);
				setState(24); ((TypeContext)_localctx).a = type(0);
				setState(25); match(3);
				((TypeContext)_localctx).node =  new DefaultMutableTreeNode("()"); _localctx.node.add(((TypeContext)_localctx).a.node);
				}
				break;

			case 3:
				{
				setState(28); match(5);
				((TypeContext)_localctx).node =  new DefaultMutableTreeNode("\\num");
				}
				break;

			case 4:
				{
				setState(30); match(7);
				((TypeContext)_localctx).node =  new DefaultMutableTreeNode("\\nat_{1}");
				}
				break;

			case 5:
				{
				setState(32); match(1);
				((TypeContext)_localctx).node =  new DefaultMutableTreeNode("\\nat");
				}
				break;

			case 6:
				{
				setState(34); ((TypeContext)_localctx).NAME = match(NAME);
				((TypeContext)_localctx).node =  new DefaultMutableTreeNode((((TypeContext)_localctx).NAME!=null?((TypeContext)_localctx).NAME.getText():null));
				}
				break;

			case 7:
				{
				setState(36);
				((TypeContext)_localctx).e1 = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==NAME || _la==NUM) ) {
					((TypeContext)_localctx).e1 = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(37); match(2);
				setState(38);
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
			setState(59);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(57);
					switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
					case 1:
						{
						_localctx = new TypeContext(_parentctx, _parentState, _p);
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_type);
						setState(42);
						if (!(7 >= _localctx._p)) throw new FailedPredicateException(this, "7 >= $_p");
						setState(43); ((TypeContext)_localctx).BINOP = match(BINOP);
						setState(44); ((TypeContext)_localctx).b = type(8);
						((TypeContext)_localctx).node =  new DefaultMutableTreeNode((((TypeContext)_localctx).BINOP!=null?((TypeContext)_localctx).BINOP.getText():null)); _localctx.node.add(((TypeContext)_localctx).a.node); _localctx.node.add(((TypeContext)_localctx).b.node);
						}
						break;

					case 2:
						{
						_localctx = new TypeContext(_parentctx, _parentState, _p);
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_type);
						setState(47);
						if (!(8 >= _localctx._p)) throw new FailedPredicateException(this, "8 >= $_p");
						((TypeContext)_localctx).node =  new DefaultMutableTreeNode("\\cross"); _localctx.node.add(((TypeContext)_localctx).a.node);
						setState(53); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(49); match(6);
								setState(50); ((TypeContext)_localctx).c = typeCross();
								_localctx.node.add(((TypeContext)_localctx).c.node);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(55); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
						} while ( _alt!=2 && _alt!=-1 );
						}
						break;
					}
					} 
				}
				setState(61);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
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

	public static class TypeCrossContext extends ParserRuleContext {
		public DefaultMutableTreeNode node;
		public Token UNOP;
		public TypeContext a;
		public Token BINOP;
		public TypeContext b;
		public Token NAME;
		public Token e1;
		public Token e2;
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
		public TypeCrossContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeCross; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypeManagerListener ) ((TypeManagerListener)listener).enterTypeCross(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypeManagerListener ) ((TypeManagerListener)listener).exitTypeCross(this);
		}
	}

	public final TypeCrossContext typeCross() throws RecognitionException {
		TypeCrossContext _localctx = new TypeCrossContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_typeCross);
		int _la;
		try {
			setState(88);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(62); ((TypeCrossContext)_localctx).UNOP = match(UNOP);
				setState(63); ((TypeCrossContext)_localctx).a = type(0);
				((TypeCrossContext)_localctx).node =  new DefaultMutableTreeNode((((TypeCrossContext)_localctx).UNOP!=null?((TypeCrossContext)_localctx).UNOP.getText():null)); _localctx.node.add(((TypeCrossContext)_localctx).a.node);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(66); ((TypeCrossContext)_localctx).a = type(0);
				setState(67); ((TypeCrossContext)_localctx).BINOP = match(BINOP);
				setState(68); ((TypeCrossContext)_localctx).b = type(0);
				((TypeCrossContext)_localctx).node =  new DefaultMutableTreeNode((((TypeCrossContext)_localctx).BINOP!=null?((TypeCrossContext)_localctx).BINOP.getText():null)); _localctx.node.add(((TypeCrossContext)_localctx).a.node); _localctx.node.add(((TypeCrossContext)_localctx).b.node);
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(71); match(4);
				setState(72); ((TypeCrossContext)_localctx).a = type(0);
				setState(73); match(3);
				((TypeCrossContext)_localctx).node =  new DefaultMutableTreeNode("()"); _localctx.node.add(((TypeCrossContext)_localctx).a.node);
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(76); match(5);
				((TypeCrossContext)_localctx).node =  new DefaultMutableTreeNode("\\num");
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(78); match(7);
				((TypeCrossContext)_localctx).node =  new DefaultMutableTreeNode("\\nat_{1}");
				}
				break;

			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(80); match(1);
				((TypeCrossContext)_localctx).node =  new DefaultMutableTreeNode("\\nat");
				}
				break;

			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(82); ((TypeCrossContext)_localctx).NAME = match(NAME);
				((TypeCrossContext)_localctx).node =  new DefaultMutableTreeNode((((TypeCrossContext)_localctx).NAME!=null?((TypeCrossContext)_localctx).NAME.getText():null));
				}
				break;

			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(84);
				((TypeCrossContext)_localctx).e1 = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==NAME || _la==NUM) ) {
					((TypeCrossContext)_localctx).e1 = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(85); match(2);
				setState(86);
				((TypeCrossContext)_localctx).e2 = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==NAME || _la==NUM) ) {
					((TypeCrossContext)_localctx).e2 = (Token)_errHandler.recoverInline(this);
				}
				consume();
				((TypeCrossContext)_localctx).node =  new DefaultMutableTreeNode((((TypeCrossContext)_localctx).e1!=null?((TypeCrossContext)_localctx).e1.getText():null) + "\\upto" + (((TypeCrossContext)_localctx).e2!=null?((TypeCrossContext)_localctx).e2.getText():null));
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

	public static class TypeNormContext extends ParserRuleContext {
		public int _p;
		public DefaultMutableTreeNode node;
		public TypeNormContext a;
		public Token UNOP;
		public Token NAME;
		public Token e1;
		public Token e2;
		public TypeNormContext b;
		public TypeNormCrossContext c;
		public TerminalNode NUM(int i) {
			return getToken(TypeManagerParser.NUM, i);
		}
		public TypeNormCrossContext typeNormCross(int i) {
			return getRuleContext(TypeNormCrossContext.class,i);
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
		public List<TypeNormCrossContext> typeNormCross() {
			return getRuleContexts(TypeNormCrossContext.class);
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
		int _startState = 8;
		enterRecursionRule(_localctx, RULE_typeNorm);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				setState(91); ((TypeNormContext)_localctx).UNOP = match(UNOP);
				setState(92); ((TypeNormContext)_localctx).a = typeNorm(9);
				((TypeNormContext)_localctx).node =  new DefaultMutableTreeNode((((TypeNormContext)_localctx).UNOP!=null?((TypeNormContext)_localctx).UNOP.getText():null)); _localctx.node.add(((TypeNormContext)_localctx).a.node);
				}
				break;

			case 2:
				{
				setState(95); match(4);
				setState(96); ((TypeNormContext)_localctx).a = typeNorm(0);
				setState(97); match(3);
				((TypeNormContext)_localctx).node =  ((TypeNormContext)_localctx).a.node;
				}
				break;

			case 3:
				{
				setState(100); match(5);
				((TypeNormContext)_localctx).node =  new DefaultMutableTreeNode("\\num");
				}
				break;

			case 4:
				{
				setState(102); match(7);
				((TypeNormContext)_localctx).node =  new DefaultMutableTreeNode("\\nat_{1}");
				}
				break;

			case 5:
				{
				setState(104); match(1);
				((TypeNormContext)_localctx).node =  new DefaultMutableTreeNode("\\nat");
				}
				break;

			case 6:
				{
				setState(106); ((TypeNormContext)_localctx).NAME = match(NAME);
				((TypeNormContext)_localctx).node =  new DefaultMutableTreeNode((((TypeNormContext)_localctx).NAME!=null?((TypeNormContext)_localctx).NAME.getText():null));
				}
				break;

			case 7:
				{
				setState(108);
				((TypeNormContext)_localctx).e1 = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==NAME || _la==NUM) ) {
					((TypeNormContext)_localctx).e1 = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(109); match(2);
				setState(110);
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
			setState(131);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(129);
					switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
					case 1:
						{
						_localctx = new TypeNormContext(_parentctx, _parentState, _p);
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_typeNorm);
						setState(114);
						if (!(7 >= _localctx._p)) throw new FailedPredicateException(this, "7 >= $_p");
						setState(115); match(BINOP);
						setState(116); ((TypeNormContext)_localctx).b = typeNorm(8);

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
						setState(119);
						if (!(8 >= _localctx._p)) throw new FailedPredicateException(this, "8 >= $_p");
						((TypeNormContext)_localctx).node =  new DefaultMutableTreeNode("\\cross"); _localctx.node.add(((TypeNormContext)_localctx).a.node);
						setState(125); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(121); match(6);
								setState(122); ((TypeNormContext)_localctx).c = typeNormCross();
								_localctx.node.add(((TypeNormContext)_localctx).c.node);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(127); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
						} while ( _alt!=2 && _alt!=-1 );
						}
						break;
					}
					} 
				}
				setState(133);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
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

	public static class TypeNormCrossContext extends ParserRuleContext {
		public DefaultMutableTreeNode node;
		public Token UNOP;
		public TypeNormContext a;
		public Token BINOP;
		public TypeNormContext b;
		public Token NAME;
		public Token e1;
		public Token e2;
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
		public TypeNormCrossContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeNormCross; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypeManagerListener ) ((TypeManagerListener)listener).enterTypeNormCross(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypeManagerListener ) ((TypeManagerListener)listener).exitTypeNormCross(this);
		}
	}

	public final TypeNormCrossContext typeNormCross() throws RecognitionException {
		TypeNormCrossContext _localctx = new TypeNormCrossContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_typeNormCross);
		int _la;
		try {
			setState(160);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(134); ((TypeNormCrossContext)_localctx).UNOP = match(UNOP);
				setState(135); ((TypeNormCrossContext)_localctx).a = typeNorm(0);
				((TypeNormCrossContext)_localctx).node =  new DefaultMutableTreeNode((((TypeNormCrossContext)_localctx).UNOP!=null?((TypeNormCrossContext)_localctx).UNOP.getText():null)); _localctx.node.add(((TypeNormCrossContext)_localctx).a.node);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(138); ((TypeNormCrossContext)_localctx).a = typeNorm(0);
				setState(139); ((TypeNormCrossContext)_localctx).BINOP = match(BINOP);
				setState(140); ((TypeNormCrossContext)_localctx).b = typeNorm(0);
				((TypeNormCrossContext)_localctx).node =  new DefaultMutableTreeNode((((TypeNormCrossContext)_localctx).BINOP!=null?((TypeNormCrossContext)_localctx).BINOP.getText():null)); _localctx.node.add(((TypeNormCrossContext)_localctx).a.node); _localctx.node.add(((TypeNormCrossContext)_localctx).b.node);
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(143); match(4);
				setState(144); ((TypeNormCrossContext)_localctx).a = typeNorm(0);
				setState(145); match(3);
				((TypeNormCrossContext)_localctx).node =  new DefaultMutableTreeNode("()"); _localctx.node.add(((TypeNormCrossContext)_localctx).a.node);
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(148); match(5);
				((TypeNormCrossContext)_localctx).node =  new DefaultMutableTreeNode("\\num");
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(150); match(7);
				((TypeNormCrossContext)_localctx).node =  new DefaultMutableTreeNode("\\nat_{1}");
				}
				break;

			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(152); match(1);
				((TypeNormCrossContext)_localctx).node =  new DefaultMutableTreeNode("\\nat");
				}
				break;

			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(154); ((TypeNormCrossContext)_localctx).NAME = match(NAME);
				((TypeNormCrossContext)_localctx).node =  new DefaultMutableTreeNode((((TypeNormCrossContext)_localctx).NAME!=null?((TypeNormCrossContext)_localctx).NAME.getText():null));
				}
				break;

			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(156);
				((TypeNormCrossContext)_localctx).e1 = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==NAME || _la==NUM) ) {
					((TypeNormCrossContext)_localctx).e1 = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(157); match(2);
				setState(158);
				((TypeNormCrossContext)_localctx).e2 = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==NAME || _la==NUM) ) {
					((TypeNormCrossContext)_localctx).e2 = (Token)_errHandler.recoverInline(this);
				}
				consume();
				((TypeNormCrossContext)_localctx).node =  new DefaultMutableTreeNode((((TypeNormCrossContext)_localctx).e1!=null?((TypeNormCrossContext)_localctx).e1.getText():null) + "\\upto" + (((TypeNormCrossContext)_localctx).e2!=null?((TypeNormCrossContext)_localctx).e2.getText():null));
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 2: return type_sempred((TypeContext)_localctx, predIndex);

		case 4: return typeNorm_sempred((TypeNormContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean typeNorm_sempred(TypeNormContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2: return 7 >= _localctx._p;

		case 3: return 8 >= _localctx._p;
		}
		return true;
	}
	private boolean type_sempred(TypeContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return 7 >= _localctx._p;

		case 1: return 8 >= _localctx._p;
		}
		return true;
	}

	public static final String _serializedATN =
		"\2\3\16\u00a5\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\3\2"+
		"\3\2\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4+\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\6\48\n\4\r\4\16\49\7\4<\n\4\f\4\16\4?\13\4\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5[\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6s\n\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\6\6\u0080\n\6\r\6\16\6\u0081\7"+
		"\6\u0084\n\6\f\6\16\6\u0087\13\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7"+
		"\u00a3\n\7\3\7\2\b\2\4\6\b\n\f\2\n\4\13\13\r\r\4\13\13\r\r\4\13\13\r\r"+
		"\4\13\13\r\r\4\13\13\r\r\4\13\13\r\r\4\13\13\r\r\4\13\13\r\r\u00be\2\16"+
		"\3\2\2\2\4\21\3\2\2\2\6*\3\2\2\2\bZ\3\2\2\2\nr\3\2\2\2\f\u00a2\3\2\2\2"+
		"\16\17\5\6\4\2\17\20\b\2\1\2\20\3\3\2\2\2\21\22\5\n\6\2\22\23\b\3\1\2"+
		"\23\5\3\2\2\2\24\25\b\4\1\2\25\26\7\f\2\2\26\27\5\6\4\2\27\30\b\4\1\2"+
		"\30+\3\2\2\2\31\32\7\6\2\2\32\33\5\6\4\2\33\34\7\5\2\2\34\35\b\4\1\2\35"+
		"+\3\2\2\2\36\37\7\7\2\2\37+\b\4\1\2 !\7\t\2\2!+\b\4\1\2\"#\7\3\2\2#+\b"+
		"\4\1\2$%\7\13\2\2%+\b\4\1\2&\'\t\2\2\2\'(\7\4\2\2()\t\3\2\2)+\b\4\1\2"+
		"*\24\3\2\2\2*\31\3\2\2\2*\36\3\2\2\2* \3\2\2\2*\"\3\2\2\2*$\3\2\2\2*&"+
		"\3\2\2\2+=\3\2\2\2,-\6\4\2\3-.\7\n\2\2./\5\6\4\2/\60\b\4\1\2\60<\3\2\2"+
		"\2\61\62\6\4\3\3\62\67\b\4\1\2\63\64\7\b\2\2\64\65\5\b\5\2\65\66\b\4\1"+
		"\2\668\3\2\2\2\67\63\3\2\2\289\3\2\2\29\67\3\2\2\29:\3\2\2\2:<\3\2\2\2"+
		";,\3\2\2\2;\61\3\2\2\2<?\3\2\2\2=;\3\2\2\2=>\3\2\2\2>\7\3\2\2\2?=\3\2"+
		"\2\2@A\7\f\2\2AB\5\6\4\2BC\b\5\1\2C[\3\2\2\2DE\5\6\4\2EF\7\n\2\2FG\5\6"+
		"\4\2GH\b\5\1\2H[\3\2\2\2IJ\7\6\2\2JK\5\6\4\2KL\7\5\2\2LM\b\5\1\2M[\3\2"+
		"\2\2NO\7\7\2\2O[\b\5\1\2PQ\7\t\2\2Q[\b\5\1\2RS\7\3\2\2S[\b\5\1\2TU\7\13"+
		"\2\2U[\b\5\1\2VW\t\4\2\2WX\7\4\2\2XY\t\5\2\2Y[\b\5\1\2Z@\3\2\2\2ZD\3\2"+
		"\2\2ZI\3\2\2\2ZN\3\2\2\2ZP\3\2\2\2ZR\3\2\2\2ZT\3\2\2\2ZV\3\2\2\2[\t\3"+
		"\2\2\2\\]\b\6\1\2]^\7\f\2\2^_\5\n\6\2_`\b\6\1\2`s\3\2\2\2ab\7\6\2\2bc"+
		"\5\n\6\2cd\7\5\2\2de\b\6\1\2es\3\2\2\2fg\7\7\2\2gs\b\6\1\2hi\7\t\2\2i"+
		"s\b\6\1\2jk\7\3\2\2ks\b\6\1\2lm\7\13\2\2ms\b\6\1\2no\t\6\2\2op\7\4\2\2"+
		"pq\t\7\2\2qs\b\6\1\2r\\\3\2\2\2ra\3\2\2\2rf\3\2\2\2rh\3\2\2\2rj\3\2\2"+
		"\2rl\3\2\2\2rn\3\2\2\2s\u0085\3\2\2\2tu\6\6\4\3uv\7\n\2\2vw\5\n\6\2wx"+
		"\b\6\1\2x\u0084\3\2\2\2yz\6\6\5\3z\177\b\6\1\2{|\7\b\2\2|}\5\f\7\2}~\b"+
		"\6\1\2~\u0080\3\2\2\2\177{\3\2\2\2\u0080\u0081\3\2\2\2\u0081\177\3\2\2"+
		"\2\u0081\u0082\3\2\2\2\u0082\u0084\3\2\2\2\u0083t\3\2\2\2\u0083y\3\2\2"+
		"\2\u0084\u0087\3\2\2\2\u0085\u0083\3\2\2\2\u0085\u0086\3\2\2\2\u0086\13"+
		"\3\2\2\2\u0087\u0085\3\2\2\2\u0088\u0089\7\f\2\2\u0089\u008a\5\n\6\2\u008a"+
		"\u008b\b\7\1\2\u008b\u00a3\3\2\2\2\u008c\u008d\5\n\6\2\u008d\u008e\7\n"+
		"\2\2\u008e\u008f\5\n\6\2\u008f\u0090\b\7\1\2\u0090\u00a3\3\2\2\2\u0091"+
		"\u0092\7\6\2\2\u0092\u0093\5\n\6\2\u0093\u0094\7\5\2\2\u0094\u0095\b\7"+
		"\1\2\u0095\u00a3\3\2\2\2\u0096\u0097\7\7\2\2\u0097\u00a3\b\7\1\2\u0098"+
		"\u0099\7\t\2\2\u0099\u00a3\b\7\1\2\u009a\u009b\7\3\2\2\u009b\u00a3\b\7"+
		"\1\2\u009c\u009d\7\13\2\2\u009d\u00a3\b\7\1\2\u009e\u009f\t\b\2\2\u009f"+
		"\u00a0\7\4\2\2\u00a0\u00a1\t\t\2\2\u00a1\u00a3\b\7\1\2\u00a2\u0088\3\2"+
		"\2\2\u00a2\u008c\3\2\2\2\u00a2\u0091\3\2\2\2\u00a2\u0096\3\2\2\2\u00a2"+
		"\u0098\3\2\2\2\u00a2\u009a\3\2\2\2\u00a2\u009c\3\2\2\2\u00a2\u009e\3\2"+
		"\2\2\u00a3\r\3\2\2\2\f*9;=Zr\u0081\u0083\u0085\u00a2";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}