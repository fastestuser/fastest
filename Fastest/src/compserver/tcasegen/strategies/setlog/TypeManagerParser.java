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
		RULE_typeNorm = 4;
	public static final String[] ruleNames = {
		"typeManage", "typeManageNorm", "type", "typeCross", "typeNorm"
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
			setState(10); ((TypeManageContext)_localctx).type = type(0);
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
			setState(13); ((TypeManageNormContext)_localctx).typeNorm = typeNorm(0);
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
			setState(38);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				{
				setState(17); ((TypeContext)_localctx).UNOP = match(UNOP);
				setState(18); ((TypeContext)_localctx).a = type(9);
				((TypeContext)_localctx).node =  new DefaultMutableTreeNode((((TypeContext)_localctx).UNOP!=null?((TypeContext)_localctx).UNOP.getText():null)); _localctx.node.add(((TypeContext)_localctx).a.node);
				}
				break;

			case 2:
				{
				setState(21); match(4);
				setState(22); ((TypeContext)_localctx).a = type(0);
				setState(23); match(3);
				((TypeContext)_localctx).node =  new DefaultMutableTreeNode("()"); _localctx.node.add(((TypeContext)_localctx).a.node);
				}
				break;

			case 3:
				{
				setState(26); match(5);
				((TypeContext)_localctx).node =  new DefaultMutableTreeNode("\\num");
				}
				break;

			case 4:
				{
				setState(28); match(7);
				((TypeContext)_localctx).node =  new DefaultMutableTreeNode("\\nat_{1}");
				}
				break;

			case 5:
				{
				setState(30); match(1);
				((TypeContext)_localctx).node =  new DefaultMutableTreeNode("\\nat");
				}
				break;

			case 6:
				{
				setState(32); ((TypeContext)_localctx).NAME = match(NAME);
				((TypeContext)_localctx).node =  new DefaultMutableTreeNode((((TypeContext)_localctx).NAME!=null?((TypeContext)_localctx).NAME.getText():null));
				}
				break;

			case 7:
				{
				setState(34);
				((TypeContext)_localctx).e1 = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==NAME || _la==NUM) ) {
					((TypeContext)_localctx).e1 = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(35); match(2);
				setState(36);
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
			setState(57);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(55);
					switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
					case 1:
						{
						_localctx = new TypeContext(_parentctx, _parentState, _p);
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_type);
						setState(40);
						if (!(7 >= _localctx._p)) throw new FailedPredicateException(this, "7 >= $_p");
						setState(41); ((TypeContext)_localctx).BINOP = match(BINOP);
						setState(42); ((TypeContext)_localctx).b = type(8);
						((TypeContext)_localctx).node =  new DefaultMutableTreeNode((((TypeContext)_localctx).BINOP!=null?((TypeContext)_localctx).BINOP.getText():null)); _localctx.node.add(((TypeContext)_localctx).a.node); _localctx.node.add(((TypeContext)_localctx).b.node);
						}
						break;

					case 2:
						{
						_localctx = new TypeContext(_parentctx, _parentState, _p);
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_type);
						setState(45);
						if (!(8 >= _localctx._p)) throw new FailedPredicateException(this, "8 >= $_p");
						((TypeContext)_localctx).node =  new DefaultMutableTreeNode("\\cross"); _localctx.node.add(((TypeContext)_localctx).a.node);
						setState(51); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(47); match(6);
								setState(48); ((TypeContext)_localctx).c = typeCross();
								_localctx.node.add(((TypeContext)_localctx).c.node);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(53); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
						} while ( _alt!=2 && _alt!=-1 );
						}
						break;
					}
					} 
				}
				setState(59);
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
			setState(86);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(60); ((TypeCrossContext)_localctx).UNOP = match(UNOP);
				setState(61); ((TypeCrossContext)_localctx).a = type(0);
				((TypeCrossContext)_localctx).node =  new DefaultMutableTreeNode((((TypeCrossContext)_localctx).UNOP!=null?((TypeCrossContext)_localctx).UNOP.getText():null)); _localctx.node.add(((TypeCrossContext)_localctx).a.node);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(64); ((TypeCrossContext)_localctx).a = type(0);
				setState(65); ((TypeCrossContext)_localctx).BINOP = match(BINOP);
				setState(66); ((TypeCrossContext)_localctx).b = type(0);
				((TypeCrossContext)_localctx).node =  new DefaultMutableTreeNode((((TypeCrossContext)_localctx).BINOP!=null?((TypeCrossContext)_localctx).BINOP.getText():null)); _localctx.node.add(((TypeCrossContext)_localctx).a.node); _localctx.node.add(((TypeCrossContext)_localctx).b.node);
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(69); match(4);
				setState(70); ((TypeCrossContext)_localctx).a = type(0);
				setState(71); match(3);
				((TypeCrossContext)_localctx).node =  new DefaultMutableTreeNode("()"); _localctx.node.add(((TypeCrossContext)_localctx).a.node);
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(74); match(5);
				((TypeCrossContext)_localctx).node =  new DefaultMutableTreeNode("\\num");
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(76); match(7);
				((TypeCrossContext)_localctx).node =  new DefaultMutableTreeNode("\\nat_{1}");
				}
				break;

			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(78); match(1);
				((TypeCrossContext)_localctx).node =  new DefaultMutableTreeNode("\\nat");
				}
				break;

			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(80); ((TypeCrossContext)_localctx).NAME = match(NAME);
				((TypeCrossContext)_localctx).node =  new DefaultMutableTreeNode((((TypeCrossContext)_localctx).NAME!=null?((TypeCrossContext)_localctx).NAME.getText():null));
				}
				break;

			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(82);
				((TypeCrossContext)_localctx).e1 = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==NAME || _la==NUM) ) {
					((TypeCrossContext)_localctx).e1 = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(83); match(2);
				setState(84);
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
		int _startState = 8;
		enterRecursionRule(_localctx, RULE_typeNorm);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				setState(89); ((TypeNormContext)_localctx).UNOP = match(UNOP);
				setState(90); ((TypeNormContext)_localctx).a = typeNorm(9);
				((TypeNormContext)_localctx).node =  new DefaultMutableTreeNode((((TypeNormContext)_localctx).UNOP!=null?((TypeNormContext)_localctx).UNOP.getText():null)); _localctx.node.add(((TypeNormContext)_localctx).a.node);
				}
				break;

			case 2:
				{
				setState(93); match(4);
				setState(94); ((TypeNormContext)_localctx).a = typeNorm(0);
				setState(95); match(3);
				((TypeNormContext)_localctx).node =  ((TypeNormContext)_localctx).a.node;
				}
				break;

			case 3:
				{
				setState(98); match(5);
				((TypeNormContext)_localctx).node =  new DefaultMutableTreeNode("\\num");
				}
				break;

			case 4:
				{
				setState(100); match(7);
				((TypeNormContext)_localctx).node =  new DefaultMutableTreeNode("\\nat_{1}");
				}
				break;

			case 5:
				{
				setState(102); match(1);
				((TypeNormContext)_localctx).node =  new DefaultMutableTreeNode("\\nat");
				}
				break;

			case 6:
				{
				setState(104); ((TypeNormContext)_localctx).NAME = match(NAME);
				((TypeNormContext)_localctx).node =  new DefaultMutableTreeNode((((TypeNormContext)_localctx).NAME!=null?((TypeNormContext)_localctx).NAME.getText():null));
				}
				break;

			case 7:
				{
				setState(106);
				((TypeNormContext)_localctx).e1 = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==NAME || _la==NUM) ) {
					((TypeNormContext)_localctx).e1 = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(107); match(2);
				setState(108);
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
			setState(124);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(122);
					switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
					case 1:
						{
						_localctx = new TypeNormContext(_parentctx, _parentState, _p);
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_typeNorm);
						setState(112);
						if (!(8 >= _localctx._p)) throw new FailedPredicateException(this, "8 >= $_p");
						setState(113); match(6);
						setState(114); ((TypeNormContext)_localctx).b = typeNorm(9);

						          					((TypeNormContext)_localctx).node =  new DefaultMutableTreeNode("\\cross");
						          					_localctx.node.add(((TypeNormContext)_localctx).a.node); 
						          					_localctx.node.add(((TypeNormContext)_localctx).b.node);
						          				
						}
						break;

					case 2:
						{
						_localctx = new TypeNormContext(_parentctx, _parentState, _p);
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_typeNorm);
						setState(117);
						if (!(7 >= _localctx._p)) throw new FailedPredicateException(this, "7 >= $_p");
						setState(118); match(BINOP);
						setState(119); ((TypeNormContext)_localctx).b = typeNorm(8);

						          					((TypeNormContext)_localctx).node =  new DefaultMutableTreeNode("\\power"); 
						          					DefaultMutableTreeNode cross = new DefaultMutableTreeNode("\\cross");
						          					_localctx.node.add(cross);
						          					cross.add(((TypeNormContext)_localctx).a.node); 
						          					cross.add(((TypeNormContext)_localctx).b.node);
						          				
						}
						break;
					}
					} 
				}
				setState(126);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
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

		case 4: return typeNorm_sempred((TypeNormContext)_localctx, predIndex);
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
		case 0: return 7 >= _localctx._p;

		case 1: return 8 >= _localctx._p;
		}
		return true;
	}

	public static final String _serializedATN =
		"\2\3\16\u0082\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\3\2\3\2\3\3"+
		"\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4)\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\6\4\66\n\4\r\4\16\4\67\7\4:\n\4\f\4\16\4=\13\4\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\5\5Y\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6q\n\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6}\n\6\f\6\16\6\u0080\13\6\3\6\2\7\2"+
		"\4\6\b\n\2\b\4\13\13\r\r\4\13\13\r\r\4\13\13\r\r\4\13\13\r\r\4\13\13\r"+
		"\r\4\13\13\r\r\u0094\2\f\3\2\2\2\4\17\3\2\2\2\6(\3\2\2\2\bX\3\2\2\2\n"+
		"p\3\2\2\2\f\r\5\6\4\2\r\16\b\2\1\2\16\3\3\2\2\2\17\20\5\n\6\2\20\21\b"+
		"\3\1\2\21\5\3\2\2\2\22\23\b\4\1\2\23\24\7\f\2\2\24\25\5\6\4\2\25\26\b"+
		"\4\1\2\26)\3\2\2\2\27\30\7\6\2\2\30\31\5\6\4\2\31\32\7\5\2\2\32\33\b\4"+
		"\1\2\33)\3\2\2\2\34\35\7\7\2\2\35)\b\4\1\2\36\37\7\t\2\2\37)\b\4\1\2 "+
		"!\7\3\2\2!)\b\4\1\2\"#\7\13\2\2#)\b\4\1\2$%\t\2\2\2%&\7\4\2\2&\'\t\3\2"+
		"\2\')\b\4\1\2(\22\3\2\2\2(\27\3\2\2\2(\34\3\2\2\2(\36\3\2\2\2( \3\2\2"+
		"\2(\"\3\2\2\2($\3\2\2\2);\3\2\2\2*+\6\4\2\3+,\7\n\2\2,-\5\6\4\2-.\b\4"+
		"\1\2.:\3\2\2\2/\60\6\4\3\3\60\65\b\4\1\2\61\62\7\b\2\2\62\63\5\b\5\2\63"+
		"\64\b\4\1\2\64\66\3\2\2\2\65\61\3\2\2\2\66\67\3\2\2\2\67\65\3\2\2\2\67"+
		"8\3\2\2\28:\3\2\2\29*\3\2\2\29/\3\2\2\2:=\3\2\2\2;9\3\2\2\2;<\3\2\2\2"+
		"<\7\3\2\2\2=;\3\2\2\2>?\7\f\2\2?@\5\6\4\2@A\b\5\1\2AY\3\2\2\2BC\5\6\4"+
		"\2CD\7\n\2\2DE\5\6\4\2EF\b\5\1\2FY\3\2\2\2GH\7\6\2\2HI\5\6\4\2IJ\7\5\2"+
		"\2JK\b\5\1\2KY\3\2\2\2LM\7\7\2\2MY\b\5\1\2NO\7\t\2\2OY\b\5\1\2PQ\7\3\2"+
		"\2QY\b\5\1\2RS\7\13\2\2SY\b\5\1\2TU\t\4\2\2UV\7\4\2\2VW\t\5\2\2WY\b\5"+
		"\1\2X>\3\2\2\2XB\3\2\2\2XG\3\2\2\2XL\3\2\2\2XN\3\2\2\2XP\3\2\2\2XR\3\2"+
		"\2\2XT\3\2\2\2Y\t\3\2\2\2Z[\b\6\1\2[\\\7\f\2\2\\]\5\n\6\2]^\b\6\1\2^q"+
		"\3\2\2\2_`\7\6\2\2`a\5\n\6\2ab\7\5\2\2bc\b\6\1\2cq\3\2\2\2de\7\7\2\2e"+
		"q\b\6\1\2fg\7\t\2\2gq\b\6\1\2hi\7\3\2\2iq\b\6\1\2jk\7\13\2\2kq\b\6\1\2"+
		"lm\t\6\2\2mn\7\4\2\2no\t\7\2\2oq\b\6\1\2pZ\3\2\2\2p_\3\2\2\2pd\3\2\2\2"+
		"pf\3\2\2\2ph\3\2\2\2pj\3\2\2\2pl\3\2\2\2q~\3\2\2\2rs\6\6\4\3st\7\b\2\2"+
		"tu\5\n\6\2uv\b\6\1\2v}\3\2\2\2wx\6\6\5\3xy\7\n\2\2yz\5\n\6\2z{\b\6\1\2"+
		"{}\3\2\2\2|r\3\2\2\2|w\3\2\2\2}\u0080\3\2\2\2~|\3\2\2\2~\177\3\2\2\2\177"+
		"\13\3\2\2\2\u0080~\3\2\2\2\n(\679;Xp|~";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}