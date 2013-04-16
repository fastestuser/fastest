// Generated from SLog2Z.g4 by ANTLR 4.0

package compserver.tcasegen.strategies.SetLogGrammar;
	import java.util.HashMap;
	import java.util.ArrayList;
	import java.util.regex.Matcher;
	import java.util.regex.Pattern;
	import java.util.Iterator;
	import javax.swing.tree.DefaultMutableTreeNode;
	import javax.swing.tree.DefaultTreeModel;
	import javax.swing.tree.TreeNode;
	import compserver.tcasegen.strategies.SetLogGrammar.StringPointer;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SLog2ZParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__17=1, T__16=2, T__15=3, T__14=4, T__13=5, T__12=6, T__11=7, T__10=8, 
		T__9=9, T__8=10, T__7=11, T__6=12, T__5=13, T__4=14, T__3=15, T__2=16, 
		T__1=17, T__0=18, NAME=19, CTE=20, NUM=21, NL=22, WS=23, SKIP=24;
	public static final String[] tokenNames = {
		"<INVALID>", "']'", "')'", "'],'", "','", "'list('", "'set('", "'['", 
		"'-'", "'='", "'_CONSTR'", "'integer('", "'\\'", "'{'", "'neq'", "'NUM = int(-10000000000, 10000000000),'", 
		"'NAT = int(0, 10000000000),'", "'}'", "'|'", "NAME", "CTE", "NUM", "'\n'", 
		"WS", "SKIP"
	};
	public static final int
		RULE_lineas = 0, RULE_constr = 1, RULE_restr = 2, RULE_seqIgual = 3, RULE_expr = 4;
	public static final String[] ruleNames = {
		"lineas", "constr", "restr", "seqIgual", "expr"
	};

	@Override
	public String getGrammarFileName() { return "SLog2Z.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public ATN getATN() { return _ATN; }


		HashMap<String,StringPointer> vars = new HashMap();	
		HashMap<String,String> zNames = new HashMap();
		HashMap<String,String> tipos = new HashMap();
		HashMap<String,String> zVars = new HashMap();
		
		
		public HashMap<String,String> getZVars(){
			return zVars;
		}
		
		
		public void print(String s){
			System.out.println(s);
		}
		public void loadTablas(ExprParser parser){
			zNames = invertMemory(parser.getMemory());
			tipos = parser.getTypes();
			zVars = parser.getZVars();
			
			System.out.println("\n");System.out.println("memory: "); printHashMap(zNames);
			System.out.println("\n tipos: "); printHashMap(tipos);System.out.println("\n");
			
		}
		private String getCte(String cte, String tipo) {
			ANTLRInputStream input = new ANTLRInputStream(tipo);
	        TypeManagerLexer lexer = new TypeManagerLexer(input);
	        CommonTokenStream tokens = new CommonTokenStream(lexer);
	        TypeManagerParser parser = new TypeManagerParser(tokens);
	        parser.typeManage();
	        DefaultMutableTreeNode root =  parser.getRoot();
	        
	        System.out.println("\narbol " + parser.printTree(root)); 
	        System.out.println("cte " + cte);
	        System.out.println("tipo " + tipo);
	        System.out.println("root " + root.toString());
	         
	        
	        
	        ConstantCreator cc = new ConstantCreator(cte,root,tipos,zNames,vars);
	        return cc.getCte();
		}
		
		private HashMap invertMemory(HashMap m){
			Iterator iterator = m.keySet().iterator();  
	   		HashMap s = new HashMap();
	   		
			while (iterator.hasNext()) {  
			   String key = iterator.next().toString();  
			   String value = m.get(key).toString();  
			   s.put(value,key);
			} 	
			return s;
		}
		
		public void printHashMap(HashMap map){
			Iterator iterator = map.keySet().iterator();  
			String key,value;
			while (iterator.hasNext()) {  
			   key = iterator.next().toString();
			   if (map.get(key) == null)
				   value = "nullc";
			   else 
				   value = map.get(key).toString();
			   System.out.println(key + " = " + value);  
			} 
		}
		
		public void llenarZVars(){
			Iterator iterator = vars.keySet().iterator();  
			String slname,zname,valor;
			while (iterator.hasNext()) {  
				slname = iterator.next().toString();
				if (vars.get(slname)!=null){	
					valor = vars.get(slname).toString();
					zname = zNames.get(slname);
					if (zVars.containsKey(zname)){
						zVars.put(zname,valor);
					} 	
				}  
			} 
		}
		

	public SLog2ZParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class LineasContext extends ParserRuleContext {
		public List<SeqIgualContext> seqIgual() {
			return getRuleContexts(SeqIgualContext.class);
		}
		public List<TerminalNode> NL() { return getTokens(SLog2ZParser.NL); }
		public SeqIgualContext seqIgual(int i) {
			return getRuleContext(SeqIgualContext.class,i);
		}
		public TerminalNode NL(int i) {
			return getToken(SLog2ZParser.NL, i);
		}
		public LineasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lineas; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SLog2ZListener ) ((SLog2ZListener)listener).enterLineas(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SLog2ZListener ) ((SLog2ZListener)listener).exitLineas(this);
		}
	}

	public final LineasContext lineas() throws RecognitionException {
		LineasContext _localctx = new LineasContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_lineas);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(14); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(10); seqIgual();
				setState(12);
				_la = _input.LA(1);
				if (_la==NL) {
					{
					setState(11); match(NL);
					}
				}

				}
				}
				setState(16); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 15) | (1L << 16) | (1L << NAME))) != 0) );

						System.out.println("salida: \n");
						printHashMap( vars );llenarZVars();
						System.out.println("\nzVars vacias +++++++++:");
						printHashMap(zVars);
						
					
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

	public static class ConstrContext extends ParserRuleContext {
		public RestrContext restr(int i) {
			return getRuleContext(RestrContext.class,i);
		}
		public List<RestrContext> restr() {
			return getRuleContexts(RestrContext.class);
		}
		public ConstrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SLog2ZListener ) ((SLog2ZListener)listener).enterConstr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SLog2ZListener ) ((SLog2ZListener)listener).exitConstr(this);
		}
	}

	public final ConstrContext constr() throws RecognitionException {
		ConstrContext _localctx = new ConstrContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_constr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(20); match(10);
			setState(21); match(9);
			setState(22); match(7);
			setState(31);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 11) | (1L << 13) | (1L << NAME) | (1L << CTE))) != 0)) {
				{
				setState(23); restr();
				setState(28);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==4) {
					{
					{
					setState(24); match(4);
					setState(25); restr();
					}
					}
					setState(30);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(33); match(3);
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

	public static class RestrContext extends ParserRuleContext {
		public StringPointer valor;;
		public ExprContext expr;
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public RestrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_restr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SLog2ZListener ) ((SLog2ZListener)listener).enterRestr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SLog2ZListener ) ((SLog2ZListener)listener).exitRestr(this);
		}
	}

	public final RestrContext restr() throws RecognitionException {
		RestrContext _localctx = new RestrContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_restr);
		((RestrContext)getInvokingContext(2)).valor =  new StringPointer();
		try {
			setState(54);
			switch (_input.LA(1)) {
			case 6:
				enterOuterAlt(_localctx, 1);
				{
				setState(35); match(6);
				setState(36); ((RestrContext)_localctx).expr = expr();
				setState(37); match(2);
				((RestrContext)getInvokingContext(2)).valor.setString("\\{\\}"); vars.put((((RestrContext)_localctx).expr!=null?_input.getText(((RestrContext)_localctx).expr.start,((RestrContext)_localctx).expr.stop):null),((RestrContext)getInvokingContext(2)).valor);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 2);
				{
				setState(40); match(5);
				setState(41); ((RestrContext)_localctx).expr = expr();
				setState(42); match(2);
				((RestrContext)getInvokingContext(2)).valor.setString("\\langle\\rangle"); vars.put((((RestrContext)_localctx).expr!=null?_input.getText(((RestrContext)_localctx).expr.start,((RestrContext)_localctx).expr.stop):null),((RestrContext)getInvokingContext(2)).valor);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 3);
				{
				setState(45); match(11);
				setState(46); ((RestrContext)_localctx).expr = expr();
				setState(47); match(2);
				((RestrContext)getInvokingContext(2)).valor.setString("666"); vars.put((((RestrContext)_localctx).expr!=null?_input.getText(((RestrContext)_localctx).expr.start,((RestrContext)_localctx).expr.stop):null),((RestrContext)getInvokingContext(2)).valor);
				}
				break;
			case 7:
			case 8:
			case 13:
			case NAME:
			case CTE:
				enterOuterAlt(_localctx, 4);
				{
				setState(50); expr();
				setState(51); match(14);
				setState(52); expr();
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

	public static class SeqIgualContext extends ParserRuleContext {
		public StringPointer valor;;
		public Token v1;
		public ExprContext v2;
		public List<TerminalNode> NAME() { return getTokens(SLog2ZParser.NAME); }
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode NAME(int i) {
			return getToken(SLog2ZParser.NAME, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public SeqIgualContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_seqIgual; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SLog2ZListener ) ((SLog2ZListener)listener).enterSeqIgual(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SLog2ZListener ) ((SLog2ZListener)listener).exitSeqIgual(this);
		}
	}

	public final SeqIgualContext seqIgual() throws RecognitionException {
		SeqIgualContext _localctx = new SeqIgualContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_seqIgual);
		((SeqIgualContext)getInvokingContext(3)).valor =  new StringPointer();
		try {
			int _alt;
			setState(71);
			switch (_input.LA(1)) {
			case 15:
				enterOuterAlt(_localctx, 1);
				{
				setState(56); match(15);
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 2);
				{
				setState(57); match(16);
				}
				break;
			case NAME:
				enterOuterAlt(_localctx, 3);
				{
				setState(65); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(58); ((SeqIgualContext)_localctx).v1 = match(NAME);
						vars.put((((SeqIgualContext)_localctx).v1!=null?((SeqIgualContext)_localctx).v1.getText():null),((SeqIgualContext)getInvokingContext(3)).valor);
						setState(60); match(9);
						setState(61); ((SeqIgualContext)_localctx).v2 = expr();
						vars.put((((SeqIgualContext)_localctx).v2!=null?_input.getText(((SeqIgualContext)_localctx).v2.start,((SeqIgualContext)_localctx).v2.stop):null),((SeqIgualContext)getInvokingContext(3)).valor);
						setState(63); match(4);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(67); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
				} while ( _alt!=2 && _alt!=-1 );

							String zname = zNames.get((((SeqIgualContext)_localctx).v1!=null?((SeqIgualContext)_localctx).v1.getText():null));
							String tipo = tipos.get(zname);
							if (!tipo.startsWith("BasicType") && !tipo.startsWith("EnumerationType") )
							{
								String var = ((SeqIgualContext)_localctx).v2.valor;
								((SeqIgualContext)getInvokingContext(3)).valor.setString(getCte(var,tipo));
							}
							 	
						 
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

	public static class ExprContext extends ParserRuleContext {
		public String valor;
		public Token CTE;
		public Token NAME;
		public ExprContext e;
		public TerminalNode CTE() { return getToken(SLog2ZParser.CTE, 0); }
		public TerminalNode NAME() { return getToken(SLog2ZParser.NAME, 0); }
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SLog2ZListener ) ((SLog2ZListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SLog2ZListener ) ((SLog2ZListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_expr);
		int _la;
		try {
			setState(127);
			switch (_input.LA(1)) {
			case CTE:
				enterOuterAlt(_localctx, 1);
				{
				setState(73); ((ExprContext)_localctx).CTE = match(CTE);
				((ExprContext)_localctx).valor =  (((ExprContext)_localctx).CTE!=null?((ExprContext)_localctx).CTE.getText():null);
				}
				break;
			case NAME:
				enterOuterAlt(_localctx, 2);
				{
				setState(75); ((ExprContext)_localctx).NAME = match(NAME);
				((ExprContext)_localctx).valor =  (((ExprContext)_localctx).NAME!=null?((ExprContext)_localctx).NAME.getText():null);
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 3);
				{
				setState(77); match(13);
				((ExprContext)_localctx).valor =  "{";
				setState(88);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 4) | (1L << 7) | (1L << 8) | (1L << 13) | (1L << NAME) | (1L << CTE))) != 0)) {
					{
					{
					setState(81);
					_la = _input.LA(1);
					if (_la==4) {
						{
						setState(79); match(4);
						((ExprContext)_localctx).valor =  _localctx.valor + ",";
						}
					}

					setState(83); ((ExprContext)_localctx).e = expr();
					((ExprContext)_localctx).valor =  _localctx.valor + ((ExprContext)_localctx).e.valor;
					}
					}
					setState(90);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(95);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==12) {
					{
					{
					setState(91); match(12);
					setState(92); expr();
					}
					}
					setState(97);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(98); match(17);
				((ExprContext)_localctx).valor =  _localctx.valor + "}";
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 4);
				{
				setState(100); match(7);
				((ExprContext)_localctx).valor =  "[";
				setState(111);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 4) | (1L << 7) | (1L << 8) | (1L << 13) | (1L << NAME) | (1L << CTE))) != 0)) {
					{
					{
					setState(104);
					_la = _input.LA(1);
					if (_la==4) {
						{
						setState(102); match(4);
						((ExprContext)_localctx).valor =  _localctx.valor + ",";
						}
					}

					setState(106); ((ExprContext)_localctx).e = expr();
					((ExprContext)_localctx).valor =  _localctx.valor + ((ExprContext)_localctx).e.valor;
					}
					}
					setState(113);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(118);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==18) {
					{
					{
					setState(114); match(18);
					setState(115); expr();
					}
					}
					setState(120);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(121); match(1);
				((ExprContext)_localctx).valor =  _localctx.valor + "]";
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 5);
				{
				setState(123); match(8);
				setState(124); expr();
				((ExprContext)_localctx).valor =  "-" + _localctx.valor ;
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

	public static final String _serializedATN =
		"\2\3\32\u0084\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\3\2\5\2\17\n"+
		"\2\6\2\21\n\2\r\2\16\2\22\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\7\3\35\n\3\f"+
		"\3\16\3 \13\3\5\3\"\n\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\49\n\4\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\6\5D\n\5\r\5\16\5E\3\5\3\5\5\5J\n\5\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\5\6T\n\6\3\6\3\6\3\6\7\6Y\n\6\f\6\16\6\\\13\6\3\6\3\6\7\6"+
		"`\n\6\f\6\16\6c\13\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6k\n\6\3\6\3\6\3\6\7\6"+
		"p\n\6\f\6\16\6s\13\6\3\6\3\6\7\6w\n\6\f\6\16\6z\13\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\5\6\u0082\n\6\3\6\2\7\2\4\6\b\n\2\2\u0092\2\20\3\2\2\2\4\26\3\2"+
		"\2\2\68\3\2\2\2\bI\3\2\2\2\n\u0081\3\2\2\2\f\16\5\b\5\2\r\17\7\30\2\2"+
		"\16\r\3\2\2\2\16\17\3\2\2\2\17\21\3\2\2\2\20\f\3\2\2\2\21\22\3\2\2\2\22"+
		"\20\3\2\2\2\22\23\3\2\2\2\23\24\3\2\2\2\24\25\b\2\1\2\25\3\3\2\2\2\26"+
		"\27\7\f\2\2\27\30\7\13\2\2\30!\7\t\2\2\31\36\5\6\4\2\32\33\7\6\2\2\33"+
		"\35\5\6\4\2\34\32\3\2\2\2\35 \3\2\2\2\36\34\3\2\2\2\36\37\3\2\2\2\37\""+
		"\3\2\2\2 \36\3\2\2\2!\31\3\2\2\2!\"\3\2\2\2\"#\3\2\2\2#$\7\5\2\2$\5\3"+
		"\2\2\2%&\7\b\2\2&\'\5\n\6\2\'(\7\4\2\2()\b\4\1\2)9\3\2\2\2*+\7\7\2\2+"+
		",\5\n\6\2,-\7\4\2\2-.\b\4\1\2.9\3\2\2\2/\60\7\r\2\2\60\61\5\n\6\2\61\62"+
		"\7\4\2\2\62\63\b\4\1\2\639\3\2\2\2\64\65\5\n\6\2\65\66\7\20\2\2\66\67"+
		"\5\n\6\2\679\3\2\2\28%\3\2\2\28*\3\2\2\28/\3\2\2\28\64\3\2\2\29\7\3\2"+
		"\2\2:J\7\21\2\2;J\7\22\2\2<=\7\25\2\2=>\b\5\1\2>?\7\13\2\2?@\5\n\6\2@"+
		"A\b\5\1\2AB\7\6\2\2BD\3\2\2\2C<\3\2\2\2DE\3\2\2\2EC\3\2\2\2EF\3\2\2\2"+
		"FG\3\2\2\2GH\b\5\1\2HJ\3\2\2\2I:\3\2\2\2I;\3\2\2\2IC\3\2\2\2J\t\3\2\2"+
		"\2KL\7\26\2\2L\u0082\b\6\1\2MN\7\25\2\2N\u0082\b\6\1\2OP\7\17\2\2PZ\b"+
		"\6\1\2QR\7\6\2\2RT\b\6\1\2SQ\3\2\2\2ST\3\2\2\2TU\3\2\2\2UV\5\n\6\2VW\b"+
		"\6\1\2WY\3\2\2\2XS\3\2\2\2Y\\\3\2\2\2ZX\3\2\2\2Z[\3\2\2\2[a\3\2\2\2\\"+
		"Z\3\2\2\2]^\7\16\2\2^`\5\n\6\2_]\3\2\2\2`c\3\2\2\2a_\3\2\2\2ab\3\2\2\2"+
		"bd\3\2\2\2ca\3\2\2\2de\7\23\2\2e\u0082\b\6\1\2fg\7\t\2\2gq\b\6\1\2hi\7"+
		"\6\2\2ik\b\6\1\2jh\3\2\2\2jk\3\2\2\2kl\3\2\2\2lm\5\n\6\2mn\b\6\1\2np\3"+
		"\2\2\2oj\3\2\2\2ps\3\2\2\2qo\3\2\2\2qr\3\2\2\2rx\3\2\2\2sq\3\2\2\2tu\7"+
		"\24\2\2uw\5\n\6\2vt\3\2\2\2wz\3\2\2\2xv\3\2\2\2xy\3\2\2\2y{\3\2\2\2zx"+
		"\3\2\2\2{|\7\3\2\2|\u0082\b\6\1\2}~\7\n\2\2~\177\5\n\6\2\177\u0080\b\6"+
		"\1\2\u0080\u0082\3\2\2\2\u0081K\3\2\2\2\u0081M\3\2\2\2\u0081O\3\2\2\2"+
		"\u0081f\3\2\2\2\u0081}\3\2\2\2\u0082\13\3\2\2\2\20\16\22\36!8EISZajqx"+
		"\u0081";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}