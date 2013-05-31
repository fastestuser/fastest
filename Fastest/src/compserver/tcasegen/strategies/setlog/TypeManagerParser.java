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
		RULE_typeManage = 0, RULE_typeManageNorm = 1, RULE_typeManageNCross = 2, 
		RULE_type = 3, RULE_typeNorm = 4, RULE_typeNormNCross = 5;
	public static final String[] ruleNames = {
		"typeManage", "typeManageNorm", "typeManageNCross", "type", "typeNorm", 
		"typeNormNCross"
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
		
		public static String printTreeNCross(DefaultMutableTreeNode tree){
			if (tree.isLeaf()) 
				return tree.toString();
			if (tree.toString().equals("()"))
				return "(" + printTreeNCross((DefaultMutableTreeNode) tree.getChildAt(0)) + ")";
			int i;
			String salida=tree.toString();
			for (i=0;i<tree.getChildCount();i++)
				salida += " " + printTreeNCross((DefaultMutableTreeNode) tree.getChildAt(i));
			return salida; 
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
			setState(15); ((TypeManageNormContext)_localctx).typeNorm = typeNorm(0);
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

	public static class TypeManageNCrossContext extends ParserRuleContext {
		public TypeNormNCrossContext typeNormNCross;
		public TypeNormNCrossContext typeNormNCross() {
			return getRuleContext(TypeNormNCrossContext.class,0);
		}
		public TypeManageNCrossContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeManageNCross; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypeManagerListener ) ((TypeManagerListener)listener).enterTypeManageNCross(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypeManagerListener ) ((TypeManagerListener)listener).exitTypeManageNCross(this);
		}
	}

	public final TypeManageNCrossContext typeManageNCross() throws RecognitionException {
		TypeManageNCrossContext _localctx = new TypeManageNCrossContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_typeManageNCross);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(18); ((TypeManageNCrossContext)_localctx).typeNormNCross = typeNormNCross(0);
			root = ((TypeManageNCrossContext)_localctx).typeNormNCross.node; /*System.out.println("Root: " + printTree(root)); System.out.println("Node1: " + getReturnNodeType(0));*/
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
		int _startState = 6;
		enterRecursionRule(_localctx, RULE_type);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(43);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				{
				setState(22); ((TypeContext)_localctx).UNOP = match(UNOP);
				setState(23); ((TypeContext)_localctx).a = type(9);
				((TypeContext)_localctx).node =  new DefaultMutableTreeNode((((TypeContext)_localctx).UNOP!=null?((TypeContext)_localctx).UNOP.getText():null)); _localctx.node.add(((TypeContext)_localctx).a.node);
				}
				break;

			case 2:
				{
				setState(26); match(4);
				setState(27); ((TypeContext)_localctx).a = type(0);
				setState(28); match(3);
				((TypeContext)_localctx).node =  new DefaultMutableTreeNode("()"); _localctx.node.add(((TypeContext)_localctx).a.node);
				}
				break;

			case 3:
				{
				setState(31); match(5);
				((TypeContext)_localctx).node =  new DefaultMutableTreeNode("\\num");
				}
				break;

			case 4:
				{
				setState(33); match(7);
				((TypeContext)_localctx).node =  new DefaultMutableTreeNode("\\nat_{1}");
				}
				break;

			case 5:
				{
				setState(35); match(1);
				((TypeContext)_localctx).node =  new DefaultMutableTreeNode("\\nat");
				}
				break;

			case 6:
				{
				setState(37); ((TypeContext)_localctx).NAME = match(NAME);
				((TypeContext)_localctx).node =  new DefaultMutableTreeNode((((TypeContext)_localctx).NAME!=null?((TypeContext)_localctx).NAME.getText():null));
				}
				break;

			case 7:
				{
				setState(39);
				((TypeContext)_localctx).e1 = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==NAME || _la==NUM) ) {
					((TypeContext)_localctx).e1 = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(40); match(2);
				setState(41);
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
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(55);
					switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
					case 1:
						{
						_localctx = new TypeContext(_parentctx, _parentState, _p);
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_type);
						setState(45);
						if (!(8 >= _localctx._p)) throw new FailedPredicateException(this, "8 >= $_p");
						setState(46); ((TypeContext)_localctx).BINOP = match(BINOP);
						setState(47); ((TypeContext)_localctx).b = type(9);
						((TypeContext)_localctx).node =  new DefaultMutableTreeNode((((TypeContext)_localctx).BINOP!=null?((TypeContext)_localctx).BINOP.getText():null)); _localctx.node.add(((TypeContext)_localctx).a.node); _localctx.node.add(((TypeContext)_localctx).b.node);
						}
						break;

					case 2:
						{
						_localctx = new TypeContext(_parentctx, _parentState, _p);
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_type);
						setState(50);
						if (!(7 >= _localctx._p)) throw new FailedPredicateException(this, "7 >= $_p");
						setState(51); match(6);
						setState(52); ((TypeContext)_localctx).b = type(8);
						((TypeContext)_localctx).node =  new DefaultMutableTreeNode("\\cross"); _localctx.node.add(((TypeContext)_localctx).a.node); _localctx.node.add(((TypeContext)_localctx).b.node);
						}
						break;
					}
					} 
				}
				setState(59);
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
		int _startState = 8;
		enterRecursionRule(_localctx, RULE_typeNorm);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(61); ((TypeNormContext)_localctx).UNOP = match(UNOP);
				setState(62); ((TypeNormContext)_localctx).a = typeNorm(9);
				((TypeNormContext)_localctx).node =  new DefaultMutableTreeNode((((TypeNormContext)_localctx).UNOP!=null?((TypeNormContext)_localctx).UNOP.getText():null)); _localctx.node.add(((TypeNormContext)_localctx).a.node);
				}
				break;

			case 2:
				{
				setState(65); match(4);
				setState(66); ((TypeNormContext)_localctx).a = typeNorm(0);
				setState(67); match(3);
				((TypeNormContext)_localctx).node =  ((TypeNormContext)_localctx).a.node;
				}
				break;

			case 3:
				{
				setState(70); match(5);
				((TypeNormContext)_localctx).node =  new DefaultMutableTreeNode("\\num");
				}
				break;

			case 4:
				{
				setState(72); match(7);
				((TypeNormContext)_localctx).node =  new DefaultMutableTreeNode("\\nat_{1}");
				}
				break;

			case 5:
				{
				setState(74); match(1);
				((TypeNormContext)_localctx).node =  new DefaultMutableTreeNode("\\nat");
				}
				break;

			case 6:
				{
				setState(76); ((TypeNormContext)_localctx).NAME = match(NAME);
				((TypeNormContext)_localctx).node =  new DefaultMutableTreeNode((((TypeNormContext)_localctx).NAME!=null?((TypeNormContext)_localctx).NAME.getText():null));
				}
				break;

			case 7:
				{
				setState(78);
				((TypeNormContext)_localctx).e1 = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==NAME || _la==NUM) ) {
					((TypeNormContext)_localctx).e1 = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(79); match(2);
				setState(80);
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
			setState(96);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(94);
					switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
					case 1:
						{
						_localctx = new TypeNormContext(_parentctx, _parentState, _p);
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_typeNorm);
						setState(84);
						if (!(8 >= _localctx._p)) throw new FailedPredicateException(this, "8 >= $_p");
						setState(85); match(BINOP);
						setState(86); ((TypeNormContext)_localctx).b = typeNorm(9);

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
						setState(89);
						if (!(7 >= _localctx._p)) throw new FailedPredicateException(this, "7 >= $_p");
						setState(90); match(6);
						setState(91); ((TypeNormContext)_localctx).b = typeNorm(8);

						          					((TypeNormContext)_localctx).node =  new DefaultMutableTreeNode("\\cross");
						          					_localctx.node.add(((TypeNormContext)_localctx).a.node); 
						          					_localctx.node.add(((TypeNormContext)_localctx).b.node);
						          				
						}
						break;
					}
					} 
				}
				setState(98);
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

	public static class TypeNormNCrossContext extends ParserRuleContext {
		public int _p;
		public DefaultMutableTreeNode node;
		public TypeNormNCrossContext a;
		public Token UNOP;
		public Token NAME;
		public Token e1;
		public Token e2;
		public TypeNormNCrossContext b;
		public TerminalNode NUM(int i) {
			return getToken(TypeManagerParser.NUM, i);
		}
		public List<TypeNormNCrossContext> typeNormNCross() {
			return getRuleContexts(TypeNormNCrossContext.class);
		}
		public TerminalNode UNOP() { return getToken(TypeManagerParser.UNOP, 0); }
		public List<TerminalNode> NAME() { return getTokens(TypeManagerParser.NAME); }
		public TypeNormNCrossContext typeNormNCross(int i) {
			return getRuleContext(TypeNormNCrossContext.class,i);
		}
		public TerminalNode BINOP() { return getToken(TypeManagerParser.BINOP, 0); }
		public TerminalNode NAME(int i) {
			return getToken(TypeManagerParser.NAME, i);
		}
		public List<TerminalNode> NUM() { return getTokens(TypeManagerParser.NUM); }
		public TypeNormNCrossContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public TypeNormNCrossContext(ParserRuleContext parent, int invokingState, int _p) {
			super(parent, invokingState);
			this._p = _p;
		}
		@Override public int getRuleIndex() { return RULE_typeNormNCross; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypeManagerListener ) ((TypeManagerListener)listener).enterTypeNormNCross(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypeManagerListener ) ((TypeManagerListener)listener).exitTypeNormNCross(this);
		}
	}

	public final TypeNormNCrossContext typeNormNCross(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TypeNormNCrossContext _localctx = new TypeNormNCrossContext(_ctx, _parentState, _p);
		TypeNormNCrossContext _prevctx = _localctx;
		int _startState = 10;
		enterRecursionRule(_localctx, RULE_typeNormNCross);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				setState(100); ((TypeNormNCrossContext)_localctx).UNOP = match(UNOP);
				setState(101); ((TypeNormNCrossContext)_localctx).a = typeNormNCross(9);
				((TypeNormNCrossContext)_localctx).node =  new DefaultMutableTreeNode((((TypeNormNCrossContext)_localctx).UNOP!=null?((TypeNormNCrossContext)_localctx).UNOP.getText():null)); _localctx.node.add(((TypeNormNCrossContext)_localctx).a.node);
				}
				break;

			case 2:
				{
				setState(104); match(6);
				((TypeNormNCrossContext)_localctx).node =  new DefaultMutableTreeNode("\\cross");
				setState(109); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(106); ((TypeNormNCrossContext)_localctx).a = typeNormNCross(0);
						_localctx.node.add(((TypeNormNCrossContext)_localctx).a.node);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(111); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
				} while ( _alt!=2 && _alt!=-1 );
				}
				break;

			case 3:
				{
				setState(113); match(4);
				setState(114); ((TypeNormNCrossContext)_localctx).a = typeNormNCross(0);
				setState(115); match(3);
				((TypeNormNCrossContext)_localctx).node =  ((TypeNormNCrossContext)_localctx).a.node;
				}
				break;

			case 4:
				{
				setState(118); match(5);
				((TypeNormNCrossContext)_localctx).node =  new DefaultMutableTreeNode("\\num");
				}
				break;

			case 5:
				{
				setState(120); match(7);
				((TypeNormNCrossContext)_localctx).node =  new DefaultMutableTreeNode("\\nat_{1}");
				}
				break;

			case 6:
				{
				setState(122); match(1);
				((TypeNormNCrossContext)_localctx).node =  new DefaultMutableTreeNode("\\nat");
				}
				break;

			case 7:
				{
				setState(124); ((TypeNormNCrossContext)_localctx).NAME = match(NAME);
				((TypeNormNCrossContext)_localctx).node =  new DefaultMutableTreeNode((((TypeNormNCrossContext)_localctx).NAME!=null?((TypeNormNCrossContext)_localctx).NAME.getText():null));
				}
				break;

			case 8:
				{
				setState(126);
				((TypeNormNCrossContext)_localctx).e1 = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==NAME || _la==NUM) ) {
					((TypeNormNCrossContext)_localctx).e1 = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(127); match(2);
				setState(128);
				((TypeNormNCrossContext)_localctx).e2 = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==NAME || _la==NUM) ) {
					((TypeNormNCrossContext)_localctx).e2 = (Token)_errHandler.recoverInline(this);
				}
				consume();
				((TypeNormNCrossContext)_localctx).node =  new DefaultMutableTreeNode((((TypeNormNCrossContext)_localctx).e1!=null?((TypeNormNCrossContext)_localctx).e1.getText():null) + "\\upto" + (((TypeNormNCrossContext)_localctx).e2!=null?((TypeNormNCrossContext)_localctx).e2.getText():null));
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(139);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TypeNormNCrossContext(_parentctx, _parentState, _p);
					_localctx.a = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_typeNormNCross);
					setState(132);
					if (!(8 >= _localctx._p)) throw new FailedPredicateException(this, "8 >= $_p");
					setState(133); match(BINOP);
					setState(134); ((TypeNormNCrossContext)_localctx).b = typeNormNCross(9);

					          					((TypeNormNCrossContext)_localctx).node =  new DefaultMutableTreeNode("\\power"); 
					          					DefaultMutableTreeNode cross = new DefaultMutableTreeNode("\\cross");
					          					_localctx.node.add(cross);
					          					cross.add(((TypeNormNCrossContext)_localctx).a.node); 
					          					cross.add(((TypeNormNCrossContext)_localctx).b.node);
					          				
					}
					} 
				}
				setState(141);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 3: return type_sempred((TypeContext)_localctx, predIndex);

		case 4: return typeNorm_sempred((TypeNormContext)_localctx, predIndex);

		case 5: return typeNormNCross_sempred((TypeNormNCrossContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean typeNormNCross_sempred(TypeNormNCrossContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4: return 8 >= _localctx._p;
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
		"\2\3\16\u0091\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\3\2"+
		"\3\2\3\3\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5.\n\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5:\n\5\f\5\16\5=\13\5\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5"+
		"\6U\n\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6a\n\6\f\6\16\6d\13"+
		"\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\6\7p\n\7\r\7\16\7q\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u0085"+
		"\n\7\3\7\3\7\3\7\3\7\3\7\7\7\u008c\n\7\f\7\16\7\u008f\13\7\3\7\2\b\2\4"+
		"\6\b\n\f\2\b\3\f\r\3\f\r\3\f\r\3\f\r\3\f\r\3\f\r\u00a3\2\16\3\2\2\2\4"+
		"\21\3\2\2\2\6\24\3\2\2\2\b-\3\2\2\2\nT\3\2\2\2\f\u0084\3\2\2\2\16\17\5"+
		"\b\5\2\17\20\b\2\1\2\20\3\3\2\2\2\21\22\5\n\6\2\22\23\b\3\1\2\23\5\3\2"+
		"\2\2\24\25\5\f\7\2\25\26\b\4\1\2\26\7\3\2\2\2\27\30\b\5\1\2\30\31\7\13"+
		"\2\2\31\32\5\b\5\2\32\33\b\5\1\2\33.\3\2\2\2\34\35\7\6\2\2\35\36\5\b\5"+
		"\2\36\37\7\5\2\2\37 \b\5\1\2 .\3\2\2\2!\"\7\7\2\2\".\b\5\1\2#$\7\t\2\2"+
		"$.\b\5\1\2%&\7\3\2\2&.\b\5\1\2\'(\7\f\2\2(.\b\5\1\2)*\t\2\2\2*+\7\4\2"+
		"\2+,\t\3\2\2,.\b\5\1\2-\27\3\2\2\2-\34\3\2\2\2-!\3\2\2\2-#\3\2\2\2-%\3"+
		"\2\2\2-\'\3\2\2\2-)\3\2\2\2.;\3\2\2\2/\60\6\5\2\3\60\61\7\n\2\2\61\62"+
		"\5\b\5\2\62\63\b\5\1\2\63:\3\2\2\2\64\65\6\5\3\3\65\66\7\b\2\2\66\67\5"+
		"\b\5\2\678\b\5\1\28:\3\2\2\29/\3\2\2\29\64\3\2\2\2:=\3\2\2\2;9\3\2\2\2"+
		";<\3\2\2\2<\t\3\2\2\2=;\3\2\2\2>?\b\6\1\2?@\7\13\2\2@A\5\n\6\2AB\b\6\1"+
		"\2BU\3\2\2\2CD\7\6\2\2DE\5\n\6\2EF\7\5\2\2FG\b\6\1\2GU\3\2\2\2HI\7\7\2"+
		"\2IU\b\6\1\2JK\7\t\2\2KU\b\6\1\2LM\7\3\2\2MU\b\6\1\2NO\7\f\2\2OU\b\6\1"+
		"\2PQ\t\4\2\2QR\7\4\2\2RS\t\5\2\2SU\b\6\1\2T>\3\2\2\2TC\3\2\2\2TH\3\2\2"+
		"\2TJ\3\2\2\2TL\3\2\2\2TN\3\2\2\2TP\3\2\2\2Ub\3\2\2\2VW\6\6\4\3WX\7\n\2"+
		"\2XY\5\n\6\2YZ\b\6\1\2Za\3\2\2\2[\\\6\6\5\3\\]\7\b\2\2]^\5\n\6\2^_\b\6"+
		"\1\2_a\3\2\2\2`V\3\2\2\2`[\3\2\2\2ad\3\2\2\2b`\3\2\2\2bc\3\2\2\2c\13\3"+
		"\2\2\2db\3\2\2\2ef\b\7\1\2fg\7\13\2\2gh\5\f\7\2hi\b\7\1\2i\u0085\3\2\2"+
		"\2jk\7\b\2\2ko\b\7\1\2lm\5\f\7\2mn\b\7\1\2np\3\2\2\2ol\3\2\2\2pq\3\2\2"+
		"\2qo\3\2\2\2qr\3\2\2\2r\u0085\3\2\2\2st\7\6\2\2tu\5\f\7\2uv\7\5\2\2vw"+
		"\b\7\1\2w\u0085\3\2\2\2xy\7\7\2\2y\u0085\b\7\1\2z{\7\t\2\2{\u0085\b\7"+
		"\1\2|}\7\3\2\2}\u0085\b\7\1\2~\177\7\f\2\2\177\u0085\b\7\1\2\u0080\u0081"+
		"\t\6\2\2\u0081\u0082\7\4\2\2\u0082\u0083\t\7\2\2\u0083\u0085\b\7\1\2\u0084"+
		"e\3\2\2\2\u0084j\3\2\2\2\u0084s\3\2\2\2\u0084x\3\2\2\2\u0084z\3\2\2\2"+
		"\u0084|\3\2\2\2\u0084~\3\2\2\2\u0084\u0080\3\2\2\2\u0085\u008d\3\2\2\2"+
		"\u0086\u0087\6\7\6\3\u0087\u0088\7\n\2\2\u0088\u0089\5\f\7\2\u0089\u008a"+
		"\b\7\1\2\u008a\u008c\3\2\2\2\u008b\u0086\3\2\2\2\u008c\u008f\3\2\2\2\u008d"+
		"\u008b\3\2\2\2\u008d\u008e\3\2\2\2\u008e\r\3\2\2\2\u008f\u008d\3\2\2\2"+
		"\13-9;T`bq\u0084\u008d";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}