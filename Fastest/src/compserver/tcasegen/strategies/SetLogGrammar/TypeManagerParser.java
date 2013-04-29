// Generated from TypeManager.g4 by ANTLR 4.0

	package compserver.tcasegen.strategies.SetLogGrammar;
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
		T__4=1, T__3=2, T__2=3, T__1=4, T__0=5, BINOP=6, UNOP=7, NAME=8, WS=9;
	public static final String[] tokenNames = {
		"<INVALID>", "'\\nat'", "')'", "'('", "'\\num'", "'\\nat_{1}'", "BINOP", 
		"UNOP", "NAME", "WS"
	};
	public static final int
		RULE_typeManage = 0, RULE_type = 1;
	public static final String[] ruleNames = {
		"typeManage", "type"
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
		
		public String printTree(DefaultMutableTreeNode tree){
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
			setState(4); ((TypeManageContext)_localctx).type = type(0);
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

	public static class TypeContext extends ParserRuleContext {
		public int _p;
		public DefaultMutableTreeNode node;
		public TypeContext a;
		public Token UNOP;
		public Token NAME;
		public Token BINOP;
		public TypeContext b;
		public TerminalNode UNOP() { return getToken(TypeManagerParser.UNOP, 0); }
		public TerminalNode NAME() { return getToken(TypeManagerParser.NAME, 0); }
		public TerminalNode BINOP() { return getToken(TypeManagerParser.BINOP, 0); }
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
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
		int _startState = 2;
		enterRecursionRule(_localctx, RULE_type);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(25);
			switch (_input.LA(1)) {
			case UNOP:
				{
				setState(8); ((TypeContext)_localctx).UNOP = match(UNOP);
				setState(9); ((TypeContext)_localctx).a = type(7);
				((TypeContext)_localctx).node =  new DefaultMutableTreeNode((((TypeContext)_localctx).UNOP!=null?((TypeContext)_localctx).UNOP.getText():null)); _localctx.node.add(((TypeContext)_localctx).a.node);
				}
				break;
			case 3:
				{
				setState(12); match(3);
				setState(13); ((TypeContext)_localctx).a = type(0);
				setState(14); match(2);
				((TypeContext)_localctx).node =  new DefaultMutableTreeNode("()"); _localctx.node.add(((TypeContext)_localctx).a.node);
				}
				break;
			case 4:
				{
				setState(17); match(4);
				((TypeContext)_localctx).node =  new DefaultMutableTreeNode("\\num");
				}
				break;
			case 5:
				{
				setState(19); match(5);
				((TypeContext)_localctx).node =  new DefaultMutableTreeNode("\\nat_{1}");
				}
				break;
			case 1:
				{
				setState(21); match(1);
				((TypeContext)_localctx).node =  new DefaultMutableTreeNode("\\nat");
				}
				break;
			case NAME:
				{
				setState(23); ((TypeContext)_localctx).NAME = match(NAME);
				((TypeContext)_localctx).node =  new DefaultMutableTreeNode((((TypeContext)_localctx).NAME!=null?((TypeContext)_localctx).NAME.getText():null));
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(34);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TypeContext(_parentctx, _parentState, _p);
					_localctx.a = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_type);
					setState(27);
					if (!(6 >= _localctx._p)) throw new FailedPredicateException(this, "6 >= $_p");
					setState(28); ((TypeContext)_localctx).BINOP = match(BINOP);
					setState(29); ((TypeContext)_localctx).b = type(7);
					((TypeContext)_localctx).node =  new DefaultMutableTreeNode((((TypeContext)_localctx).BINOP!=null?((TypeContext)_localctx).BINOP.getText():null)); _localctx.node.add(((TypeContext)_localctx).a.node); _localctx.node.add(((TypeContext)_localctx).b.node);
					}
					} 
				}
				setState(36);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
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
		case 1: return type_sempred((TypeContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean type_sempred(TypeContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return 6 >= _localctx._p;
		}
		return true;
	}

	public static final String _serializedATN =
		"\2\3\13(\4\2\t\2\4\3\t\3\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3\34\n\3\3\3\3\3\3\3\3\3\3\3"+
		"\7\3#\n\3\f\3\16\3&\13\3\3\3\2\4\2\4\2\2+\2\6\3\2\2\2\4\33\3\2\2\2\6\7"+
		"\5\4\3\2\7\b\b\2\1\2\b\3\3\2\2\2\t\n\b\3\1\2\n\13\7\t\2\2\13\f\5\4\3\2"+
		"\f\r\b\3\1\2\r\34\3\2\2\2\16\17\7\5\2\2\17\20\5\4\3\2\20\21\7\4\2\2\21"+
		"\22\b\3\1\2\22\34\3\2\2\2\23\24\7\6\2\2\24\34\b\3\1\2\25\26\7\7\2\2\26"+
		"\34\b\3\1\2\27\30\7\3\2\2\30\34\b\3\1\2\31\32\7\n\2\2\32\34\b\3\1\2\33"+
		"\t\3\2\2\2\33\16\3\2\2\2\33\23\3\2\2\2\33\25\3\2\2\2\33\27\3\2\2\2\33"+
		"\31\3\2\2\2\34$\3\2\2\2\35\36\6\3\2\3\36\37\7\b\2\2\37 \5\4\3\2 !\b\3"+
		"\1\2!#\3\2\2\2\"\35\3\2\2\2#&\3\2\2\2$\"\3\2\2\2$%\3\2\2\2%\5\3\2\2\2"+
		"&$\3\2\2\2\4\33$";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}