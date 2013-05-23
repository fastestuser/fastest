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
		T__5=1, T__4=2, T__3=3, T__2=4, T__1=5, T__0=6, BINOP=7, UNOP=8, NAME=9, 
		NUM=10, WS=11;
	public static final String[] tokenNames = {
		"<INVALID>", "'\\nat'", "'\\upto'", "')'", "'('", "'\\num'", "'\\nat_{1}'", 
		"BINOP", "UNOP", "NAME", "NUM", "WS"
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
		public TerminalNode NAME() { return getToken(TypeManagerParser.NAME, 0); }
		public TerminalNode BINOP() { return getToken(TypeManagerParser.BINOP, 0); }
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
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
			switch (_input.LA(1)) {
			case UNOP:
				{
				setState(15); ((TypeContext)_localctx).UNOP = match(UNOP);
				setState(16); ((TypeContext)_localctx).a = type(8);
				((TypeContext)_localctx).node =  new DefaultMutableTreeNode((((TypeContext)_localctx).UNOP!=null?((TypeContext)_localctx).UNOP.getText():null)); _localctx.node.add(((TypeContext)_localctx).a.node);
				}
				break;
			case 4:
				{
				setState(19); match(4);
				setState(20); ((TypeContext)_localctx).a = type(0);
				setState(21); match(3);
				((TypeContext)_localctx).node =  new DefaultMutableTreeNode("()"); _localctx.node.add(((TypeContext)_localctx).a.node);
				}
				break;
			case 5:
				{
				setState(24); match(5);
				((TypeContext)_localctx).node =  new DefaultMutableTreeNode("\\num");
				}
				break;
			case 6:
				{
				setState(26); match(6);
				((TypeContext)_localctx).node =  new DefaultMutableTreeNode("\\nat_{1}");
				}
				break;
			case 1:
				{
				setState(28); match(1);
				((TypeContext)_localctx).node =  new DefaultMutableTreeNode("\\nat");
				}
				break;
			case NAME:
				{
				setState(30); ((TypeContext)_localctx).NAME = match(NAME);
				((TypeContext)_localctx).node =  new DefaultMutableTreeNode((((TypeContext)_localctx).NAME!=null?((TypeContext)_localctx).NAME.getText():null));
				}
				break;
			case NUM:
				{
				setState(32); ((TypeContext)_localctx).e1 = match(NUM);
				setState(33); match(2);
				setState(34); ((TypeContext)_localctx).e2 = match(NUM);
				((TypeContext)_localctx).node =  new DefaultMutableTreeNode((((TypeContext)_localctx).e1!=null?((TypeContext)_localctx).e1.getText():null) + "\\upto" + (((TypeContext)_localctx).e2!=null?((TypeContext)_localctx).e2.getText():null));
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(45);
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
					setState(38);
					if (!(7 >= _localctx._p)) throw new FailedPredicateException(this, "7 >= $_p");
					setState(39); ((TypeContext)_localctx).BINOP = match(BINOP);
					setState(40); ((TypeContext)_localctx).b = type(8);
					((TypeContext)_localctx).node =  new DefaultMutableTreeNode((((TypeContext)_localctx).BINOP!=null?((TypeContext)_localctx).BINOP.getText():null)); _localctx.node.add(((TypeContext)_localctx).a.node); _localctx.node.add(((TypeContext)_localctx).b.node);
					}
					} 
				}
				setState(47);
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

	public static class TypeNormContext extends ParserRuleContext {
		public int _p;
		public DefaultMutableTreeNode node;
		public TypeNormContext a;
		public Token UNOP;
		public Token NAME;
		public Token e1;
		public Token e2;
		public Token BINOP;
		public TypeNormContext b;
		public TerminalNode NUM(int i) {
			return getToken(TypeManagerParser.NUM, i);
		}
		public TerminalNode UNOP() { return getToken(TypeManagerParser.UNOP, 0); }
		public TerminalNode NAME() { return getToken(TypeManagerParser.NAME, 0); }
		public TypeNormContext typeNorm(int i) {
			return getRuleContext(TypeNormContext.class,i);
		}
		public TerminalNode BINOP() { return getToken(TypeManagerParser.BINOP, 0); }
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
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			switch (_input.LA(1)) {
			case UNOP:
				{
				setState(49); ((TypeNormContext)_localctx).UNOP = match(UNOP);
				setState(50); ((TypeNormContext)_localctx).a = typeNorm(8);
				((TypeNormContext)_localctx).node =  new DefaultMutableTreeNode((((TypeNormContext)_localctx).UNOP!=null?((TypeNormContext)_localctx).UNOP.getText():null)); _localctx.node.add(((TypeNormContext)_localctx).a.node);
				}
				break;
			case 4:
				{
				setState(53); match(4);
				setState(54); ((TypeNormContext)_localctx).a = typeNorm(0);
				setState(55); match(3);
				((TypeNormContext)_localctx).node =  ((TypeNormContext)_localctx).a.node;
				}
				break;
			case 5:
				{
				setState(58); match(5);
				((TypeNormContext)_localctx).node =  new DefaultMutableTreeNode("\\num");
				}
				break;
			case 6:
				{
				setState(60); match(6);
				((TypeNormContext)_localctx).node =  new DefaultMutableTreeNode("\\nat_{1}");
				}
				break;
			case 1:
				{
				setState(62); match(1);
				((TypeNormContext)_localctx).node =  new DefaultMutableTreeNode("\\nat");
				}
				break;
			case NAME:
				{
				setState(64); ((TypeNormContext)_localctx).NAME = match(NAME);
				((TypeNormContext)_localctx).node =  new DefaultMutableTreeNode((((TypeNormContext)_localctx).NAME!=null?((TypeNormContext)_localctx).NAME.getText():null));
				}
				break;
			case NUM:
				{
				setState(66); ((TypeNormContext)_localctx).e1 = match(NUM);
				setState(67); match(2);
				setState(68); ((TypeNormContext)_localctx).e2 = match(NUM);
				((TypeNormContext)_localctx).node =  new DefaultMutableTreeNode((((TypeNormContext)_localctx).e1!=null?((TypeNormContext)_localctx).e1.getText():null) + "\\upto" + (((TypeNormContext)_localctx).e2!=null?((TypeNormContext)_localctx).e2.getText():null));
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(79);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TypeNormContext(_parentctx, _parentState, _p);
					_localctx.a = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_typeNorm);
					setState(72);
					if (!(7 >= _localctx._p)) throw new FailedPredicateException(this, "7 >= $_p");
					setState(73); ((TypeNormContext)_localctx).BINOP = match(BINOP);
					setState(74); ((TypeNormContext)_localctx).b = typeNorm(8);

					          					if(!((((TypeNormContext)_localctx).BINOP!=null?((TypeNormContext)_localctx).BINOP.getText():null).equals("\\cross"))){
					          						((TypeNormContext)_localctx).node =  new DefaultMutableTreeNode("\\power"); 
					          						DefaultMutableTreeNode cross = new DefaultMutableTreeNode("\\cross");
					          						_localctx.node.add(cross);
					          						cross.add(((TypeNormContext)_localctx).a.node); 
					          						cross.add(((TypeNormContext)_localctx).b.node);
					          					}
					          					else{
					          						((TypeNormContext)_localctx).node =  new DefaultMutableTreeNode("\\cross");
					          						_localctx.node.add(((TypeNormContext)_localctx).a.node); 
					          						_localctx.node.add(((TypeNormContext)_localctx).b.node);
					          					}
					          				
					}
					} 
				}
				setState(81);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 2: return type_sempred((TypeContext)_localctx, predIndex);

		case 3: return typeNorm_sempred((TypeNormContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean typeNorm_sempred(TypeNormContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1: return 7 >= _localctx._p;
		}
		return true;
	}
	private boolean type_sempred(TypeContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return 7 >= _localctx._p;
		}
		return true;
	}

	public static final String _serializedATN =
		"\2\3\rU\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\3\2\3\2\3\2\3\3\3\3\3\3\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\5\4\'\n\4\3\4\3\4\3\4\3\4\3\4\7\4.\n\4\f\4\16\4\61\13\4\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\5\5I\n\5\3\5\3\5\3\5\3\5\3\5\7\5P\n\5\f\5\16\5S\13\5"+
		"\3\5\2\6\2\4\6\b\2\2^\2\n\3\2\2\2\4\r\3\2\2\2\6&\3\2\2\2\bH\3\2\2\2\n"+
		"\13\5\6\4\2\13\f\b\2\1\2\f\3\3\2\2\2\r\16\5\b\5\2\16\17\b\3\1\2\17\5\3"+
		"\2\2\2\20\21\b\4\1\2\21\22\7\n\2\2\22\23\5\6\4\2\23\24\b\4\1\2\24\'\3"+
		"\2\2\2\25\26\7\6\2\2\26\27\5\6\4\2\27\30\7\5\2\2\30\31\b\4\1\2\31\'\3"+
		"\2\2\2\32\33\7\7\2\2\33\'\b\4\1\2\34\35\7\b\2\2\35\'\b\4\1\2\36\37\7\3"+
		"\2\2\37\'\b\4\1\2 !\7\13\2\2!\'\b\4\1\2\"#\7\f\2\2#$\7\4\2\2$%\7\f\2\2"+
		"%\'\b\4\1\2&\20\3\2\2\2&\25\3\2\2\2&\32\3\2\2\2&\34\3\2\2\2&\36\3\2\2"+
		"\2& \3\2\2\2&\"\3\2\2\2\'/\3\2\2\2()\6\4\2\3)*\7\t\2\2*+\5\6\4\2+,\b\4"+
		"\1\2,.\3\2\2\2-(\3\2\2\2.\61\3\2\2\2/-\3\2\2\2/\60\3\2\2\2\60\7\3\2\2"+
		"\2\61/\3\2\2\2\62\63\b\5\1\2\63\64\7\n\2\2\64\65\5\b\5\2\65\66\b\5\1\2"+
		"\66I\3\2\2\2\678\7\6\2\289\5\b\5\29:\7\5\2\2:;\b\5\1\2;I\3\2\2\2<=\7\7"+
		"\2\2=I\b\5\1\2>?\7\b\2\2?I\b\5\1\2@A\7\3\2\2AI\b\5\1\2BC\7\13\2\2CI\b"+
		"\5\1\2DE\7\f\2\2EF\7\4\2\2FG\7\f\2\2GI\b\5\1\2H\62\3\2\2\2H\67\3\2\2\2"+
		"H<\3\2\2\2H>\3\2\2\2H@\3\2\2\2HB\3\2\2\2HD\3\2\2\2IQ\3\2\2\2JK\6\5\3\3"+
		"KL\7\t\2\2LM\5\b\5\2MN\b\5\1\2NP\3\2\2\2OJ\3\2\2\2PS\3\2\2\2QO\3\2\2\2"+
		"QR\3\2\2\2R\t\3\2\2\2SQ\3\2\2\2\6&/HQ";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}