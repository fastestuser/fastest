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


		HashMap<String,StringPointer> slvars = new HashMap();	
		HashMap<String,String> zNames = new HashMap();
		HashMap<String,String> tipos = new HashMap();
		HashMap<String,String> zVars = new HashMap();
		
		
		public HashMap<String,String> getZVars(){
			return zVars;
		}
		
		
		public void loadTablas(ExprParser parser){
			zNames = invertMap(parser.getMemory());
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
	         
	        
	        
	        ConstantCreator cc = new ConstantCreator(cte,root,tipos,zNames,slvars);
	        return cc.getCte();
		}
		
		private HashMap<String,String> invertMap(HashMap<String,String> m){
			Iterator<String> iterator = m.keySet().iterator();  
	   		HashMap<String,String> s = new HashMap<String,String>();
	   		
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
			Iterator iterator = slvars.keySet().iterator();  
			String slname,zname,valor;
			while (iterator.hasNext()) {  
				slname = iterator.next().toString();
				if (slvars.get(slname)!=null){	
					valor = slvars.get(slname).toString();
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
		public ConstrContext constr;
		public List<SeqIgualContext> seqIgual() {
			return getRuleContexts(SeqIgualContext.class);
		}
		public List<TerminalNode> NL() { return getTokens(SLog2ZParser.NL); }
		public SeqIgualContext seqIgual(int i) {
			return getRuleContext(SeqIgualContext.class,i);
		}
		public ConstrContext constr() {
			return getRuleContext(ConstrContext.class,0);
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
			setState(10); ((LineasContext)_localctx).constr = constr();
			setState(11); match(NL);
			setState(16); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(12); seqIgual();
				setState(14);
				_la = _input.LA(1);
				if (_la==NL) {
					{
					setState(13); match(NL);
					}
				}

				}
				}
				setState(18); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 15) | (1L << 16) | (1L << NAME))) != 0) );

						System.out.println("salida: \n");
						printHashMap( slvars );
						System.out.println("constrains: \n" + (((LineasContext)_localctx).constr!=null?_input.getText(((LineasContext)_localctx).constr.start,((LineasContext)_localctx).constr.stop):null));			
						llenarZVars();
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
			setState(22); match(10);
			setState(23); match(9);
			setState(24); match(7);
			setState(33);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 11) | (1L << 13) | (1L << NAME) | (1L << CTE))) != 0)) {
				{
				setState(25); restr();
				setState(30);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==4) {
					{
					{
					setState(26); match(4);
					setState(27); restr();
					}
					}
					setState(32);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(35); match(3);
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
			setState(56);
			switch (_input.LA(1)) {
			case 6:
				enterOuterAlt(_localctx, 1);
				{
				setState(37); match(6);
				setState(38); ((RestrContext)_localctx).expr = expr();
				setState(39); match(2);
				((RestrContext)getInvokingContext(2)).valor.setString("\\{\\}"); slvars.put((((RestrContext)_localctx).expr!=null?_input.getText(((RestrContext)_localctx).expr.start,((RestrContext)_localctx).expr.stop):null),((RestrContext)getInvokingContext(2)).valor);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 2);
				{
				setState(42); match(5);
				setState(43); ((RestrContext)_localctx).expr = expr();
				setState(44); match(2);
				((RestrContext)getInvokingContext(2)).valor.setString("\\langle\\rangle"); slvars.put((((RestrContext)_localctx).expr!=null?_input.getText(((RestrContext)_localctx).expr.start,((RestrContext)_localctx).expr.stop):null),((RestrContext)getInvokingContext(2)).valor);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 3);
				{
				setState(47); match(11);
				setState(48); ((RestrContext)_localctx).expr = expr();
				setState(49); match(2);
				((RestrContext)getInvokingContext(2)).valor.setString("666"); slvars.put((((RestrContext)_localctx).expr!=null?_input.getText(((RestrContext)_localctx).expr.start,((RestrContext)_localctx).expr.stop):null),((RestrContext)getInvokingContext(2)).valor);
				}
				break;
			case 7:
			case 8:
			case 13:
			case NAME:
			case CTE:
				enterOuterAlt(_localctx, 4);
				{
				setState(52); expr();
				setState(53); match(14);
				setState(54); expr();
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
			setState(73);
			switch (_input.LA(1)) {
			case 15:
				enterOuterAlt(_localctx, 1);
				{
				setState(58); match(15);
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 2);
				{
				setState(59); match(16);
				}
				break;
			case NAME:
				enterOuterAlt(_localctx, 3);
				{
				setState(67); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(60); ((SeqIgualContext)_localctx).v1 = match(NAME);
						slvars.put((((SeqIgualContext)_localctx).v1!=null?((SeqIgualContext)_localctx).v1.getText():null),((SeqIgualContext)getInvokingContext(3)).valor);
						setState(62); match(9);
						setState(63); ((SeqIgualContext)_localctx).v2 = expr();
						slvars.put((((SeqIgualContext)_localctx).v2!=null?_input.getText(((SeqIgualContext)_localctx).v2.start,((SeqIgualContext)_localctx).v2.stop):null),((SeqIgualContext)getInvokingContext(3)).valor);
						setState(65); match(4);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(69); 
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
			setState(129);
			switch (_input.LA(1)) {
			case CTE:
				enterOuterAlt(_localctx, 1);
				{
				setState(75); ((ExprContext)_localctx).CTE = match(CTE);
				((ExprContext)_localctx).valor =  (((ExprContext)_localctx).CTE!=null?((ExprContext)_localctx).CTE.getText():null);
				}
				break;
			case NAME:
				enterOuterAlt(_localctx, 2);
				{
				setState(77); ((ExprContext)_localctx).NAME = match(NAME);
				((ExprContext)_localctx).valor =  (((ExprContext)_localctx).NAME!=null?((ExprContext)_localctx).NAME.getText():null);
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 3);
				{
				setState(79); match(13);
				((ExprContext)_localctx).valor =  "{";
				setState(90);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 4) | (1L << 7) | (1L << 8) | (1L << 13) | (1L << NAME) | (1L << CTE))) != 0)) {
					{
					{
					setState(83);
					_la = _input.LA(1);
					if (_la==4) {
						{
						setState(81); match(4);
						((ExprContext)_localctx).valor =  _localctx.valor + ",";
						}
					}

					setState(85); ((ExprContext)_localctx).e = expr();
					((ExprContext)_localctx).valor =  _localctx.valor + ((ExprContext)_localctx).e.valor;
					}
					}
					setState(92);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(97);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==12) {
					{
					{
					setState(93); match(12);
					setState(94); expr();
					}
					}
					setState(99);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(100); match(17);
				((ExprContext)_localctx).valor =  _localctx.valor + "}";
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 4);
				{
				setState(102); match(7);
				((ExprContext)_localctx).valor =  "[";
				setState(113);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 4) | (1L << 7) | (1L << 8) | (1L << 13) | (1L << NAME) | (1L << CTE))) != 0)) {
					{
					{
					setState(106);
					_la = _input.LA(1);
					if (_la==4) {
						{
						setState(104); match(4);
						((ExprContext)_localctx).valor =  _localctx.valor + ",";
						}
					}

					setState(108); ((ExprContext)_localctx).e = expr();
					((ExprContext)_localctx).valor =  _localctx.valor + ((ExprContext)_localctx).e.valor;
					}
					}
					setState(115);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(120);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==18) {
					{
					{
					setState(116); match(18);
					setState(117); expr();
					}
					}
					setState(122);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(123); match(1);
				((ExprContext)_localctx).valor =  _localctx.valor + "]";
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 5);
				{
				setState(125); match(8);
				setState(126); expr();
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
		"\2\3\32\u0086\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\3\2\3\2\3\2"+
		"\5\2\21\n\2\6\2\23\n\2\r\2\16\2\24\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\7\3"+
		"\37\n\3\f\3\16\3\"\13\3\5\3$\n\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4;\n\4\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\6\5F\n\5\r\5\16\5G\3\5\3\5\5\5L\n\5\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\5\6V\n\6\3\6\3\6\3\6\7\6[\n\6\f\6\16\6^\13\6\3\6"+
		"\3\6\7\6b\n\6\f\6\16\6e\13\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6m\n\6\3\6\3\6"+
		"\3\6\7\6r\n\6\f\6\16\6u\13\6\3\6\3\6\7\6y\n\6\f\6\16\6|\13\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\5\6\u0084\n\6\3\6\2\7\2\4\6\b\n\2\2\u0094\2\f\3\2\2\2\4"+
		"\30\3\2\2\2\6:\3\2\2\2\bK\3\2\2\2\n\u0083\3\2\2\2\f\r\5\4\3\2\r\22\7\30"+
		"\2\2\16\20\5\b\5\2\17\21\7\30\2\2\20\17\3\2\2\2\20\21\3\2\2\2\21\23\3"+
		"\2\2\2\22\16\3\2\2\2\23\24\3\2\2\2\24\22\3\2\2\2\24\25\3\2\2\2\25\26\3"+
		"\2\2\2\26\27\b\2\1\2\27\3\3\2\2\2\30\31\7\f\2\2\31\32\7\13\2\2\32#\7\t"+
		"\2\2\33 \5\6\4\2\34\35\7\6\2\2\35\37\5\6\4\2\36\34\3\2\2\2\37\"\3\2\2"+
		"\2 \36\3\2\2\2 !\3\2\2\2!$\3\2\2\2\" \3\2\2\2#\33\3\2\2\2#$\3\2\2\2$%"+
		"\3\2\2\2%&\7\5\2\2&\5\3\2\2\2\'(\7\b\2\2()\5\n\6\2)*\7\4\2\2*+\b\4\1\2"+
		"+;\3\2\2\2,-\7\7\2\2-.\5\n\6\2./\7\4\2\2/\60\b\4\1\2\60;\3\2\2\2\61\62"+
		"\7\r\2\2\62\63\5\n\6\2\63\64\7\4\2\2\64\65\b\4\1\2\65;\3\2\2\2\66\67\5"+
		"\n\6\2\678\7\20\2\289\5\n\6\29;\3\2\2\2:\'\3\2\2\2:,\3\2\2\2:\61\3\2\2"+
		"\2:\66\3\2\2\2;\7\3\2\2\2<L\7\21\2\2=L\7\22\2\2>?\7\25\2\2?@\b\5\1\2@"+
		"A\7\13\2\2AB\5\n\6\2BC\b\5\1\2CD\7\6\2\2DF\3\2\2\2E>\3\2\2\2FG\3\2\2\2"+
		"GE\3\2\2\2GH\3\2\2\2HI\3\2\2\2IJ\b\5\1\2JL\3\2\2\2K<\3\2\2\2K=\3\2\2\2"+
		"KE\3\2\2\2L\t\3\2\2\2MN\7\26\2\2N\u0084\b\6\1\2OP\7\25\2\2P\u0084\b\6"+
		"\1\2QR\7\17\2\2R\\\b\6\1\2ST\7\6\2\2TV\b\6\1\2US\3\2\2\2UV\3\2\2\2VW\3"+
		"\2\2\2WX\5\n\6\2XY\b\6\1\2Y[\3\2\2\2ZU\3\2\2\2[^\3\2\2\2\\Z\3\2\2\2\\"+
		"]\3\2\2\2]c\3\2\2\2^\\\3\2\2\2_`\7\16\2\2`b\5\n\6\2a_\3\2\2\2be\3\2\2"+
		"\2ca\3\2\2\2cd\3\2\2\2df\3\2\2\2ec\3\2\2\2fg\7\23\2\2g\u0084\b\6\1\2h"+
		"i\7\t\2\2is\b\6\1\2jk\7\6\2\2km\b\6\1\2lj\3\2\2\2lm\3\2\2\2mn\3\2\2\2"+
		"no\5\n\6\2op\b\6\1\2pr\3\2\2\2ql\3\2\2\2ru\3\2\2\2sq\3\2\2\2st\3\2\2\2"+
		"tz\3\2\2\2us\3\2\2\2vw\7\24\2\2wy\5\n\6\2xv\3\2\2\2y|\3\2\2\2zx\3\2\2"+
		"\2z{\3\2\2\2{}\3\2\2\2|z\3\2\2\2}~\7\3\2\2~\u0084\b\6\1\2\177\u0080\7"+
		"\n\2\2\u0080\u0081\5\n\6\2\u0081\u0082\b\6\1\2\u0082\u0084\3\2\2\2\u0083"+
		"M\3\2\2\2\u0083O\3\2\2\2\u0083Q\3\2\2\2\u0083h\3\2\2\2\u0083\177\3\2\2"+
		"\2\u0084\13\3\2\2\2\20\20\24 #:GKU\\clsz\u0083";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}