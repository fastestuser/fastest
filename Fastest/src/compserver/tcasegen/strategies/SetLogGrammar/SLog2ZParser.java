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
		T__15=1, T__14=2, T__13=3, T__12=4, T__11=5, T__10=6, T__9=7, T__8=8, 
		T__7=9, T__6=10, T__5=11, T__4=12, T__3=13, T__2=14, T__1=15, T__0=16, 
		NAME=17, CTE=18, NUM=19, NL=20, WS=21, SKIP=22;
	public static final String[] tokenNames = {
		"<INVALID>", "']'", "')'", "'],'", "','", "'set('", "'['", "'-'", "'='", 
		"'_CONSTR'", "'\\'", "'{'", "'neq'", "'NUM = int(-10000000000, 10000000000),'", 
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


		HashMap<String,StringValor> salida = new HashMap();	
		HashMap<String,String> zNames = new HashMap();
		HashMap<String,String> tipos = new HashMap();
		HashMap<String,String> zVars = new HashMap();
		
		public HashMap getZVars(){
			return zVars;
		}
		
		public class StringValor{
			private String valor;
			public void setValor(String s){
				this.valor = s;		
			}
			public String toString(){
				return this.valor;		
			}
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
	         
	        
	        
	        ConstantCreator cc = new ConstantCreator(cte,root,tipos,zNames);
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
				   value = "null";
			   else 
				   value = map.get(key).toString();
			   System.out.println(key + " = " + value);  
			} 
		}
		
		public void llenarZVars(){
			Iterator iterator = salida.keySet().iterator();  
	   		String slname,zname,valor;
			while (iterator.hasNext()) {  
			   slname = iterator.next().toString();
			   valor = salida.get(slname).toString(); 
			   if (zNames.containsKey(slname)){
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
			setState(15); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(12); seqIgual();
				setState(13); match(NL);
				}
				}
				setState(17); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 13) | (1L << 14) | (1L << NAME))) != 0) );

						System.out.println("salida: \n");
						printHashMap( salida );llenarZVars();
						System.out.println("\nzVars:");
						printHashMap(zVars);
						System.out.println("const***** " + (((LineasContext)_localctx).constr!=null?_input.getText(((LineasContext)_localctx).constr.start,((LineasContext)_localctx).constr.stop):null));
					
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
			setState(21); match(9);
			setState(22); match(8);
			setState(23); match(6);
			setState(32);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 5) | (1L << 6) | (1L << 7) | (1L << 11) | (1L << NAME) | (1L << CTE))) != 0)) {
				{
				setState(24); restr();
				setState(29);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==4) {
					{
					{
					setState(25); match(4);
					setState(26); restr();
					}
					}
					setState(31);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(34); match(3);
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
		public StringValor valor;;
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
		((RestrContext)getInvokingContext(2)).valor =  new StringValor();
		try {
			setState(45);
			switch (_input.LA(1)) {
			case 5:
				enterOuterAlt(_localctx, 1);
				{
				setState(36); match(5);
				setState(37); ((RestrContext)_localctx).expr = expr();
				setState(38); match(2);
				((RestrContext)getInvokingContext(2)).valor.setValor("\\{\\}"); salida.put((((RestrContext)_localctx).expr!=null?_input.getText(((RestrContext)_localctx).expr.start,((RestrContext)_localctx).expr.stop):null),((RestrContext)getInvokingContext(2)).valor);
				}
				break;
			case 6:
			case 7:
			case 11:
			case NAME:
			case CTE:
				enterOuterAlt(_localctx, 2);
				{
				setState(41); expr();
				setState(42); match(12);
				setState(43); expr();
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
		public StringValor valor;;
		public Token a;
		public ExprContext b;
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
		((SeqIgualContext)getInvokingContext(3)).valor =  new StringValor();
		int _la;
		try {
			setState(62);
			switch (_input.LA(1)) {
			case 13:
				enterOuterAlt(_localctx, 1);
				{
				setState(47); match(13);
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 2);
				{
				setState(48); match(14);
				}
				break;
			case NAME:
				enterOuterAlt(_localctx, 3);
				{
				setState(56); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(49); ((SeqIgualContext)_localctx).a = match(NAME);
					salida.put((((SeqIgualContext)_localctx).a!=null?((SeqIgualContext)_localctx).a.getText():null),((SeqIgualContext)getInvokingContext(3)).valor);
					setState(51); match(8);
					setState(52); ((SeqIgualContext)_localctx).b = expr();
					salida.put(((SeqIgualContext)_localctx).b.valor,((SeqIgualContext)getInvokingContext(3)).valor);
					setState(54); match(4);
					}
					}
					setState(58); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NAME );

							String zname = zNames.get((((SeqIgualContext)_localctx).a!=null?((SeqIgualContext)_localctx).a.getText():null));
							String tipo = tipos.get(zname);
							if (!tipo.startsWith("BasicType") && !tipo.startsWith("EnumerationType")){
								String var = ((SeqIgualContext)_localctx).b.valor;
								((SeqIgualContext)getInvokingContext(3)).valor.setValor(getCte(var,tipo));
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
		public ExprContext a;
		public ExprContext b;
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
			setState(116);
			switch (_input.LA(1)) {
			case CTE:
				enterOuterAlt(_localctx, 1);
				{
				setState(64); ((ExprContext)_localctx).CTE = match(CTE);
				((ExprContext)_localctx).valor =  (((ExprContext)_localctx).CTE!=null?((ExprContext)_localctx).CTE.getText():null);
				}
				break;
			case NAME:
				enterOuterAlt(_localctx, 2);
				{
				setState(66); ((ExprContext)_localctx).NAME = match(NAME);
				((ExprContext)_localctx).valor =  (((ExprContext)_localctx).NAME!=null?((ExprContext)_localctx).NAME.getText():null);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 3);
				{
				setState(68); match(11);
				setState(69); ((ExprContext)_localctx).a = expr();
				((ExprContext)_localctx).valor =  "{" + ((ExprContext)_localctx).a.valor;
				setState(77);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==4) {
					{
					{
					setState(71); match(4);
					setState(72); ((ExprContext)_localctx).b = expr();
					((ExprContext)_localctx).valor =  _localctx.valor + "," + ((ExprContext)_localctx).b.valor;
					}
					}
					setState(79);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(84);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==10) {
					{
					{
					setState(80); match(10);
					setState(81); expr();
					}
					}
					setState(86);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(87); match(15);
				((ExprContext)_localctx).valor =  _localctx.valor + "}";
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 4);
				{
				setState(90); match(6);
				setState(91); ((ExprContext)_localctx).a = expr();
				((ExprContext)_localctx).valor =  "[" + ((ExprContext)_localctx).a.valor;
				setState(99);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==4) {
					{
					{
					setState(93); match(4);
					setState(94); ((ExprContext)_localctx).b = expr();
					((ExprContext)_localctx).valor =  _localctx.valor + "," + ((ExprContext)_localctx).b.valor;
					}
					}
					setState(101);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(106);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==16) {
					{
					{
					setState(102); match(16);
					setState(103); expr();
					}
					}
					setState(108);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(109); match(1);
				((ExprContext)_localctx).valor =  _localctx.valor + "]";
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 5);
				{
				setState(112); match(7);
				setState(113); expr();
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
		"\2\3\30y\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\3\2\3\2\3\2\3\2\6"+
		"\2\22\n\2\r\2\16\2\23\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\7\3\36\n\3\f\3\16"+
		"\3!\13\3\5\3#\n\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\60\n"+
		"\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\6\5;\n\5\r\5\16\5<\3\5\3\5\5\5"+
		"A\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6N\n\6\f\6\16\6Q\13"+
		"\6\3\6\3\6\7\6U\n\6\f\6\16\6X\13\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\7\6d\n\6\f\6\16\6g\13\6\3\6\3\6\7\6k\n\6\f\6\16\6n\13\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\5\6w\n\6\3\6\2\7\2\4\6\b\n\2\2\u0082\2\f\3\2\2\2\4"+
		"\27\3\2\2\2\6/\3\2\2\2\b@\3\2\2\2\nv\3\2\2\2\f\r\5\4\3\2\r\21\7\26\2\2"+
		"\16\17\5\b\5\2\17\20\7\26\2\2\20\22\3\2\2\2\21\16\3\2\2\2\22\23\3\2\2"+
		"\2\23\21\3\2\2\2\23\24\3\2\2\2\24\25\3\2\2\2\25\26\b\2\1\2\26\3\3\2\2"+
		"\2\27\30\7\13\2\2\30\31\7\n\2\2\31\"\7\b\2\2\32\37\5\6\4\2\33\34\7\6\2"+
		"\2\34\36\5\6\4\2\35\33\3\2\2\2\36!\3\2\2\2\37\35\3\2\2\2\37 \3\2\2\2 "+
		"#\3\2\2\2!\37\3\2\2\2\"\32\3\2\2\2\"#\3\2\2\2#$\3\2\2\2$%\7\5\2\2%\5\3"+
		"\2\2\2&\'\7\7\2\2\'(\5\n\6\2()\7\4\2\2)*\b\4\1\2*\60\3\2\2\2+,\5\n\6\2"+
		",-\7\16\2\2-.\5\n\6\2.\60\3\2\2\2/&\3\2\2\2/+\3\2\2\2\60\7\3\2\2\2\61"+
		"A\7\17\2\2\62A\7\20\2\2\63\64\7\23\2\2\64\65\b\5\1\2\65\66\7\n\2\2\66"+
		"\67\5\n\6\2\678\b\5\1\289\7\6\2\29;\3\2\2\2:\63\3\2\2\2;<\3\2\2\2<:\3"+
		"\2\2\2<=\3\2\2\2=>\3\2\2\2>?\b\5\1\2?A\3\2\2\2@\61\3\2\2\2@\62\3\2\2\2"+
		"@:\3\2\2\2A\t\3\2\2\2BC\7\24\2\2Cw\b\6\1\2DE\7\23\2\2Ew\b\6\1\2FG\7\r"+
		"\2\2GH\5\n\6\2HO\b\6\1\2IJ\7\6\2\2JK\5\n\6\2KL\b\6\1\2LN\3\2\2\2MI\3\2"+
		"\2\2NQ\3\2\2\2OM\3\2\2\2OP\3\2\2\2PV\3\2\2\2QO\3\2\2\2RS\7\f\2\2SU\5\n"+
		"\6\2TR\3\2\2\2UX\3\2\2\2VT\3\2\2\2VW\3\2\2\2WY\3\2\2\2XV\3\2\2\2YZ\7\21"+
		"\2\2Z[\b\6\1\2[w\3\2\2\2\\]\7\b\2\2]^\5\n\6\2^e\b\6\1\2_`\7\6\2\2`a\5"+
		"\n\6\2ab\b\6\1\2bd\3\2\2\2c_\3\2\2\2dg\3\2\2\2ec\3\2\2\2ef\3\2\2\2fl\3"+
		"\2\2\2ge\3\2\2\2hi\7\22\2\2ik\5\n\6\2jh\3\2\2\2kn\3\2\2\2lj\3\2\2\2lm"+
		"\3\2\2\2mo\3\2\2\2nl\3\2\2\2op\7\3\2\2pq\b\6\1\2qw\3\2\2\2rs\7\t\2\2s"+
		"t\5\n\6\2tu\b\6\1\2uw\3\2\2\2vB\3\2\2\2vD\3\2\2\2vF\3\2\2\2v\\\3\2\2\2"+
		"vr\3\2\2\2w\13\3\2\2\2\r\23\37\"/<@OVelv";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}