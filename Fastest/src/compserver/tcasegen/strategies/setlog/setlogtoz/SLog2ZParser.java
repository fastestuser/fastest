// Generated from SLog2Z.g4 by ANTLR 4.0

package compserver.tcasegen.strategies.setlog.setlogtoz;
	import java.util.LinkedList;
	import java.util.List;
	import java.util.HashMap;
	import java.util.ArrayList;
	import java.util.regex.Matcher;
	import java.util.regex.Pattern;
	import java.util.Iterator;
	import javax.swing.tree.DefaultMutableTreeNode;
	import javax.swing.tree.DefaultTreeModel;
	import javax.swing.tree.TreeNode;
	import compserver.tcasegen.strategies.setlog.ztosetlog.ExprParser;
	import compserver.tcasegen.strategies.setlog.TypeManagerLexer;
	import compserver.tcasegen.strategies.setlog.TypeManagerParser;
	import compserver.tcasegen.strategies.setlog.SetLogUtils;

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
		T__16=1, T__15=2, T__14=3, T__13=4, T__12=5, T__11=6, T__10=7, T__9=8, 
		T__8=9, T__7=10, T__6=11, T__5=12, T__4=13, T__3=14, T__2=15, T__1=16, 
		T__0=17, NAME=18, CTE=19, NUM=20, NL=21, WS=22, SKIP=23;
	public static final String[] tokenNames = {
		"<INVALID>", "']'", "')'", "','", "'list('", "'set('", "'['", "'-'", "'('", 
		"'int'", "'='", "'_CONSTR'", "'integer('", "'\\'", "'{'", "'neq'", "'}'", 
		"'|'", "NAME", "CTE", "NUM", "'\n'", "WS", "SKIP"
	};
	public static final int
		RULE_lineas = 0, RULE_constr = 1, RULE_restr = 2, RULE_seqIgual = 3, RULE_expr = 4, 
		RULE_exprCte = 5;
	public static final String[] ruleNames = {
		"lineas", "constr", "restr", "seqIgual", "expr", "exprCte"
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
		HashMap<String,String> valoresProhibidos = new HashMap();
		List<String> varNoGenerar = new LinkedList<String>();
		ConstantCreator cc;
		
		public HashMap<String,StringPointer> getSlvars(){
			return slvars;
		}
		
		public HashMap<String,String> getZVars(){
			return zVars;
		}
		
		public ConstantCreator getCC(){
			return cc;
		}

	    
		public void loadTablas(HashMap<String,String> zVars, HashMap<String,String> tipos, HashMap<String,String> zNames){
			this.zNames = zNames;
			this.tipos = tipos;
			this.zVars = zVars;
			
			
			//System.out.println("\n");
			//System.out.println("zNames: "); 
			//printHashMap(zNames);
			//System.out.println("\n tipos: "); 
			//printHashMap(tipos);
			//System.out.println("\n");
			//System.out.println("\n");
			cc = new ConstantCreator(tipos,slvars,valoresProhibidos);
			
		}
		
		
		private void printHashMap(HashMap map){
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
		
		private void printHashMap2(HashMap<String,String[]> map){
			Iterator<String> iterator = map.keySet().iterator();  
			String key;	String[] value;
			while (iterator.hasNext()) {  
			   key = iterator.next().toString();
			   if (map.get(key) == null){
				   System.out.println(key + " = " + "nullc");
				   continue;
			   }
			   else{ 
				   
				   value = map.get(key);
				   System.out.print(key + " = "); 
				   for (int i = 0; i<value.length;i++) 
					   System.out.print(value[i] + ",");
				   System.out.println(); 
			   }
			} 
		}
		
		private void preprocesarConstraint(){
		// por que pueden venir variables Z, que solo aparezcan en constraint, no hay que llenarlas en ZVarFiller
			// por que ahi ya pueden tener valor erroneor ej constraint [V neq [], list(V)], con list V se le da valors
				if(valoresProhibidos != null){
				Iterator<String> it = valoresProhibidos.keySet().iterator();
				String var,tipo;
				StringPointer valor;
				while (it.hasNext()) { 
					var = it.next().toString();
					if (zNames != null && zNames.get(var)!=null){
						tipo = tipos.get(zNames.get(var));
						DefaultMutableTreeNode nodo = SetLogUtils.toTreeNorm(tipo);
						valor = new StringPointer(cc.getCte(var,nodo));
						if(slvars != null)
							slvars.put(var, valor);
						}
					}
				}
		}
		
		private void llenarZVars(){
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
			setState(12); ((LineasContext)_localctx).constr = constr();
			setState(13); match(NL);

						System.out.println("\n valoresProhibidos desigualdades: \n");
						printHashMap(valoresProhibidos);
						//System.out.println("asaaaaaaa" + "\n");
						preprocesarConstraint();
					
			setState(19); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(15); seqIgual();
				setState(17);
				_la = _input.LA(1);
				if (_la==NL) {
					{
					setState(16); match(NL);
					}
				}

				}
				}
				setState(21); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NAME );

						//System.out.println("\n**salida SLog2Z**: \n");
						//System.out.println("constraint: " + (((LineasContext)_localctx).constr!=null?_input.getText(((LineasContext)_localctx).constr.start,((LineasContext)_localctx).constr.stop):null) );
						System.out.println("\nslvars:");
						printHashMap( slvars );
						llenarZVars();
						//System.out.println("\nzVars vacias +++++++++:");
						//printHashMap(zVars);
						//System.out.println("\n**fin SLog2Z**");
						
					
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
			setState(25); match(11);

				              	//System.out.println("CONTATNANTOANTs");
				              
			setState(27); match(10);
			setState(28); match(6);
			setState(37);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 4) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 9) | (1L << 12) | (1L << 14) | (1L << NAME) | (1L << CTE))) != 0)) {
				{
				setState(29); restr();
				setState(34);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==3) {
					{
					{
					setState(30); match(3);
					setState(31); restr();
					}
					}
					setState(36);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(39); match(1);
			setState(40); match(3);
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
		public Token a;
		public Token b;
		public Token NAME;
		public ExprCteContext exprCte;
		public ExprCteContext exprCte() {
			return getRuleContext(ExprCteContext.class,0);
		}
		public List<TerminalNode> NAME() { return getTokens(SLog2ZParser.NAME); }
		public TerminalNode NAME(int i) {
			return getToken(SLog2ZParser.NAME, i);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
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
			setState(84);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(42); match(5);
				setState(43); ((RestrContext)_localctx).expr = expr();
				setState(44); match(2);
				((RestrContext)getInvokingContext(2)).valor.setString("{}"); slvars.put((((RestrContext)_localctx).expr!=null?_input.getText(((RestrContext)_localctx).expr.start,((RestrContext)_localctx).expr.stop):null),((RestrContext)getInvokingContext(2)).valor);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(47); match(4);
				setState(48); ((RestrContext)_localctx).expr = expr();
				setState(49); match(2);
				((RestrContext)getInvokingContext(2)).valor.setString("[]"); slvars.put((((RestrContext)_localctx).expr!=null?_input.getText(((RestrContext)_localctx).expr.start,((RestrContext)_localctx).expr.stop):null),((RestrContext)getInvokingContext(2)).valor);
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(52); match(12);
				setState(53); ((RestrContext)_localctx).expr = expr();
				setState(54); match(2);
				((RestrContext)getInvokingContext(2)).valor.setString(cc.getNumber()); slvars.put((((RestrContext)_localctx).expr!=null?_input.getText(((RestrContext)_localctx).expr.start,((RestrContext)_localctx).expr.stop):null),((RestrContext)getInvokingContext(2)).valor);
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				{
				setState(57); ((RestrContext)_localctx).a = match(NAME);
				setState(58); match(15);
				setState(59); ((RestrContext)_localctx).b = match(NAME);
				}

							String var1 = (((RestrContext)_localctx).a!=null?((RestrContext)_localctx).a.getText():null);
							String var2 = (((RestrContext)_localctx).b!=null?((RestrContext)_localctx).b.getText():null);
							String s = valoresProhibidos.get(var1);
							 
							if (s!=null && !s.contains(var2)) 
								valoresProhibidos.put(var1,s.concat("," + var2));
							else{
								s = new String(var2);
								valoresProhibidos.put(var1, s);
								}
								
							s = valoresProhibidos.get(var2);
							if (s!=null && !s.contains(var1)) 
								valoresProhibidos.put(var2,s.concat("," + var1));
							else{
								s = new String(var1);
								valoresProhibidos.put(var2, s);
								}
						
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(69);
				switch (_input.LA(1)) {
				case NAME:
					{
					setState(62); ((RestrContext)_localctx).NAME = match(NAME);
					setState(63); match(15);
					setState(64); ((RestrContext)_localctx).exprCte = exprCte();
					}
					break;
				case 6:
				case 7:
				case 9:
				case 14:
				case CTE:
					{
					setState(65); ((RestrContext)_localctx).exprCte = exprCte();
					setState(66); match(15);
					setState(67); ((RestrContext)_localctx).NAME = match(NAME);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}

							String var = (((RestrContext)_localctx).NAME!=null?((RestrContext)_localctx).NAME.getText():null);
							String cte = (((RestrContext)_localctx).exprCte!=null?_input.getText(((RestrContext)_localctx).exprCte.start,((RestrContext)_localctx).exprCte.stop):null);
							String s = valoresProhibidos.get(var);
							if (s!=null && !s.contains(cte)) 
								valoresProhibidos.put(var,s.concat("," + cte));
							else{
								s = new String(cte);
								valoresProhibidos.put(var, s);
								}
						
				}
				break;

			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(80);
				switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
				case 1:
					{
					setState(73); ((RestrContext)_localctx).NAME = match(NAME);
					setState(74); match(15);
					setState(75); expr();
					}
					break;

				case 2:
					{
					setState(76); expr();
					setState(77); match(15);
					setState(78); ((RestrContext)_localctx).NAME = match(NAME);
					}
					break;
				}

							varNoGenerar.add((((RestrContext)_localctx).NAME!=null?((RestrContext)_localctx).NAME.getText():null));	
							slvars.put((((RestrContext)_localctx).NAME!=null?((RestrContext)_localctx).NAME.getText():null),new StringPointer("ValueNotAssigned"));
						
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
			enterOuterAlt(_localctx, 1);
			{
			setState(93); 
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(86); ((SeqIgualContext)_localctx).v1 = match(NAME);
					slvars.put((((SeqIgualContext)_localctx).v1!=null?((SeqIgualContext)_localctx).v1.getText():null),((SeqIgualContext)getInvokingContext(3)).valor);
					setState(88); match(10);
					setState(89); ((SeqIgualContext)_localctx).v2 = expr();
					slvars.put((((SeqIgualContext)_localctx).v2!=null?_input.getText(((SeqIgualContext)_localctx).v2.start,((SeqIgualContext)_localctx).v2.stop):null),((SeqIgualContext)getInvokingContext(3)).valor);
					setState(91); match(3);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(95); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			} while ( _alt!=2 && _alt!=-1 );

						String zname = zNames.get((((SeqIgualContext)_localctx).v1!=null?((SeqIgualContext)_localctx).v1.getText():null));
						String tipo = tipos.get(zname);
						String var = ((SeqIgualContext)_localctx).v2.valor;
						if (varNoGenerar.contains(var) || varNoGenerar.contains((((SeqIgualContext)_localctx).v1!=null?((SeqIgualContext)_localctx).v1.getText():null))){
							((SeqIgualContext)getInvokingContext(3)).valor.setString("ValueNotAssigned");
							}			
						else if ( !((SeqIgualContext)getInvokingContext(3)).valor.contains("ValueNotAssigned") && !varNoGenerar.contains(var) && !zname.startsWith("\\n") && !tipo.startsWith("BasicType") && !tipo.startsWith("EnumerationType") && !tipo.startsWith("SchemaType") )
							((SeqIgualContext)getInvokingContext(3)).valor.setString(cc.getCte(var,SetLogUtils.toTreeNorm(tipo)));
						 	
					 
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
		public Token a;
		public Token b;
		public ExprContext e;
		public List<TerminalNode> CTE() { return getTokens(SLog2ZParser.CTE); }
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
		public TerminalNode CTE(int i) {
			return getToken(SLog2ZParser.CTE, i);
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
			setState(160);
			switch (_input.LA(1)) {
			case CTE:
				enterOuterAlt(_localctx, 1);
				{
				setState(99); ((ExprContext)_localctx).CTE = match(CTE);
				((ExprContext)_localctx).valor =  (((ExprContext)_localctx).CTE!=null?((ExprContext)_localctx).CTE.getText():null);
				}
				break;
			case NAME:
				enterOuterAlt(_localctx, 2);
				{
				setState(101); ((ExprContext)_localctx).NAME = match(NAME);
				((ExprContext)_localctx).valor =  (((ExprContext)_localctx).NAME!=null?((ExprContext)_localctx).NAME.getText():null);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 3);
				{
				setState(103); match(9);
				setState(104); match(8);
				setState(105);
				((ExprContext)_localctx).a = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==NAME || _la==CTE) ) {
					((ExprContext)_localctx).a = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(106); match(3);
				setState(107);
				((ExprContext)_localctx).b = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==NAME || _la==CTE) ) {
					((ExprContext)_localctx).b = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(108); match(2);
				((ExprContext)_localctx).valor =  "int(" + (((ExprContext)_localctx).a!=null?((ExprContext)_localctx).a.getText():null) + "," + (((ExprContext)_localctx).b!=null?((ExprContext)_localctx).b.getText():null) + ")";
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 4);
				{
				setState(110); match(14);
				((ExprContext)_localctx).valor =  "{";
				setState(121);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 3) | (1L << 6) | (1L << 7) | (1L << 9) | (1L << 14) | (1L << NAME) | (1L << CTE))) != 0)) {
					{
					{
					setState(114);
					_la = _input.LA(1);
					if (_la==3) {
						{
						setState(112); match(3);
						((ExprContext)_localctx).valor =  _localctx.valor + ",";
						}
					}

					setState(116); ((ExprContext)_localctx).e = expr();
					((ExprContext)_localctx).valor =  _localctx.valor + ((ExprContext)_localctx).e.valor;
					}
					}
					setState(123);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(128);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==13) {
					{
					{
					setState(124); match(13);
					setState(125); expr();
					}
					}
					setState(130);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(131); match(16);
				((ExprContext)_localctx).valor =  _localctx.valor + "}";
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 5);
				{
				setState(133); match(6);
				((ExprContext)_localctx).valor =  "[";
				setState(144);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 3) | (1L << 6) | (1L << 7) | (1L << 9) | (1L << 14) | (1L << NAME) | (1L << CTE))) != 0)) {
					{
					{
					setState(137);
					_la = _input.LA(1);
					if (_la==3) {
						{
						setState(135); match(3);
						((ExprContext)_localctx).valor =  _localctx.valor + ",";
						}
					}

					setState(139); ((ExprContext)_localctx).e = expr();
					((ExprContext)_localctx).valor =  _localctx.valor + ((ExprContext)_localctx).e.valor;
					}
					}
					setState(146);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(151);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==17) {
					{
					{
					setState(147); match(17);
					setState(148); expr();
					}
					}
					setState(153);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(154); match(1);
				((ExprContext)_localctx).valor =  _localctx.valor + "]";
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 6);
				{
				setState(156); match(7);
				setState(157); expr();
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

	public static class ExprCteContext extends ParserRuleContext {
		public String valor;
		public Token CTE;
		public Token a;
		public Token b;
		public ExprCteContext e;
		public List<ExprCteContext> exprCte() {
			return getRuleContexts(ExprCteContext.class);
		}
		public List<TerminalNode> CTE() { return getTokens(SLog2ZParser.CTE); }
		public List<TerminalNode> NAME() { return getTokens(SLog2ZParser.NAME); }
		public TerminalNode NAME(int i) {
			return getToken(SLog2ZParser.NAME, i);
		}
		public ExprCteContext exprCte(int i) {
			return getRuleContext(ExprCteContext.class,i);
		}
		public TerminalNode CTE(int i) {
			return getToken(SLog2ZParser.CTE, i);
		}
		public ExprCteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprCte; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SLog2ZListener ) ((SLog2ZListener)listener).enterExprCte(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SLog2ZListener ) ((SLog2ZListener)listener).exitExprCte(this);
		}
	}

	public final ExprCteContext exprCte() throws RecognitionException {
		ExprCteContext _localctx = new ExprCteContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_exprCte);
		int _la;
		try {
			setState(221);
			switch (_input.LA(1)) {
			case CTE:
				enterOuterAlt(_localctx, 1);
				{
				setState(162); ((ExprCteContext)_localctx).CTE = match(CTE);
				((ExprCteContext)_localctx).valor =  (((ExprCteContext)_localctx).CTE!=null?((ExprCteContext)_localctx).CTE.getText():null);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 2);
				{
				setState(164); match(9);
				setState(165); match(8);
				setState(166);
				((ExprCteContext)_localctx).a = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==NAME || _la==CTE) ) {
					((ExprCteContext)_localctx).a = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(167); match(3);
				setState(168);
				((ExprCteContext)_localctx).b = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==NAME || _la==CTE) ) {
					((ExprCteContext)_localctx).b = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(169); match(2);
				((ExprCteContext)_localctx).valor =  "int(" + (((ExprCteContext)_localctx).a!=null?((ExprCteContext)_localctx).a.getText():null) + "," + (((ExprCteContext)_localctx).b!=null?((ExprCteContext)_localctx).b.getText():null) + ")";
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 3);
				{
				setState(171); match(14);
				((ExprCteContext)_localctx).valor =  "{";
				setState(182);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 3) | (1L << 6) | (1L << 7) | (1L << 9) | (1L << 14) | (1L << CTE))) != 0)) {
					{
					{
					setState(175);
					_la = _input.LA(1);
					if (_la==3) {
						{
						setState(173); match(3);
						((ExprCteContext)_localctx).valor =  _localctx.valor + ",";
						}
					}

					setState(177); ((ExprCteContext)_localctx).e = exprCte();
					((ExprCteContext)_localctx).valor =  _localctx.valor + ((ExprCteContext)_localctx).e.valor;
					}
					}
					setState(184);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(189);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==13) {
					{
					{
					setState(185); match(13);
					setState(186); exprCte();
					}
					}
					setState(191);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(192); match(16);
				((ExprCteContext)_localctx).valor =  _localctx.valor + "}";
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 4);
				{
				setState(194); match(6);
				((ExprCteContext)_localctx).valor =  "[";
				setState(205);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 3) | (1L << 6) | (1L << 7) | (1L << 9) | (1L << 14) | (1L << CTE))) != 0)) {
					{
					{
					setState(198);
					_la = _input.LA(1);
					if (_la==3) {
						{
						setState(196); match(3);
						((ExprCteContext)_localctx).valor =  _localctx.valor + ",";
						}
					}

					setState(200); ((ExprCteContext)_localctx).e = exprCte();
					((ExprCteContext)_localctx).valor =  _localctx.valor + ((ExprCteContext)_localctx).e.valor;
					}
					}
					setState(207);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(212);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==17) {
					{
					{
					setState(208); match(17);
					setState(209); exprCte();
					}
					}
					setState(214);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(215); match(1);
				((ExprCteContext)_localctx).valor =  _localctx.valor + "]";
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 5);
				{
				setState(217); match(7);
				setState(218); exprCte();
				((ExprCteContext)_localctx).valor =  "-" + _localctx.valor ;
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
		"\2\3\31\u00e2\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\3\2"+
		"\3\2\3\2\3\2\5\2\24\n\2\6\2\26\n\2\r\2\16\2\27\3\2\3\2\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\7\3#\n\3\f\3\16\3&\13\3\5\3(\n\3\3\3\3\3\3\3\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4H\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\5\4S\n\4\3\4\3\4\5\4W\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\6\5`\n\5\r\5"+
		"\16\5a\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\5\6u\n\6\3\6\3\6\3\6\7\6z\n\6\f\6\16\6}\13\6\3\6\3\6\7\6\u0081\n"+
		"\6\f\6\16\6\u0084\13\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6\u008c\n\6\3\6\3\6\3"+
		"\6\7\6\u0091\n\6\f\6\16\6\u0094\13\6\3\6\3\6\7\6\u0098\n\6\f\6\16\6\u009b"+
		"\13\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6\u00a3\n\6\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u00b2\n\7\3\7\3\7\3\7\7\7\u00b7\n\7\f\7"+
		"\16\7\u00ba\13\7\3\7\3\7\7\7\u00be\n\7\f\7\16\7\u00c1\13\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\5\7\u00c9\n\7\3\7\3\7\3\7\7\7\u00ce\n\7\f\7\16\7\u00d1\13"+
		"\7\3\7\3\7\7\7\u00d5\n\7\f\7\16\7\u00d8\13\7\3\7\3\7\3\7\3\7\3\7\3\7\5"+
		"\7\u00e0\n\7\3\7\2\b\2\4\6\b\n\f\2\6\3\24\25\3\24\25\3\24\25\3\24\25\u00fc"+
		"\2\16\3\2\2\2\4\33\3\2\2\2\6V\3\2\2\2\b_\3\2\2\2\n\u00a2\3\2\2\2\f\u00df"+
		"\3\2\2\2\16\17\5\4\3\2\17\20\7\27\2\2\20\25\b\2\1\2\21\23\5\b\5\2\22\24"+
		"\7\27\2\2\23\22\3\2\2\2\23\24\3\2\2\2\24\26\3\2\2\2\25\21\3\2\2\2\26\27"+
		"\3\2\2\2\27\25\3\2\2\2\27\30\3\2\2\2\30\31\3\2\2\2\31\32\b\2\1\2\32\3"+
		"\3\2\2\2\33\34\7\r\2\2\34\35\b\3\1\2\35\36\7\f\2\2\36\'\7\b\2\2\37$\5"+
		"\6\4\2 !\7\5\2\2!#\5\6\4\2\" \3\2\2\2#&\3\2\2\2$\"\3\2\2\2$%\3\2\2\2%"+
		"(\3\2\2\2&$\3\2\2\2\'\37\3\2\2\2\'(\3\2\2\2()\3\2\2\2)*\7\3\2\2*+\7\5"+
		"\2\2+\5\3\2\2\2,-\7\7\2\2-.\5\n\6\2./\7\4\2\2/\60\b\4\1\2\60W\3\2\2\2"+
		"\61\62\7\6\2\2\62\63\5\n\6\2\63\64\7\4\2\2\64\65\b\4\1\2\65W\3\2\2\2\66"+
		"\67\7\16\2\2\678\5\n\6\289\7\4\2\29:\b\4\1\2:W\3\2\2\2;<\7\24\2\2<=\7"+
		"\21\2\2=>\7\24\2\2>?\3\2\2\2?W\b\4\1\2@A\7\24\2\2AB\7\21\2\2BH\5\f\7\2"+
		"CD\5\f\7\2DE\7\21\2\2EF\7\24\2\2FH\3\2\2\2G@\3\2\2\2GC\3\2\2\2HI\3\2\2"+
		"\2IJ\b\4\1\2JW\3\2\2\2KL\7\24\2\2LM\7\21\2\2MS\5\n\6\2NO\5\n\6\2OP\7\21"+
		"\2\2PQ\7\24\2\2QS\3\2\2\2RK\3\2\2\2RN\3\2\2\2ST\3\2\2\2TU\b\4\1\2UW\3"+
		"\2\2\2V,\3\2\2\2V\61\3\2\2\2V\66\3\2\2\2V;\3\2\2\2VG\3\2\2\2VR\3\2\2\2"+
		"W\7\3\2\2\2XY\7\24\2\2YZ\b\5\1\2Z[\7\f\2\2[\\\5\n\6\2\\]\b\5\1\2]^\7\5"+
		"\2\2^`\3\2\2\2_X\3\2\2\2`a\3\2\2\2a_\3\2\2\2ab\3\2\2\2bc\3\2\2\2cd\b\5"+
		"\1\2d\t\3\2\2\2ef\7\25\2\2f\u00a3\b\6\1\2gh\7\24\2\2h\u00a3\b\6\1\2ij"+
		"\7\13\2\2jk\7\n\2\2kl\t\2\2\2lm\7\5\2\2mn\t\3\2\2no\7\4\2\2o\u00a3\b\6"+
		"\1\2pq\7\20\2\2q{\b\6\1\2rs\7\5\2\2su\b\6\1\2tr\3\2\2\2tu\3\2\2\2uv\3"+
		"\2\2\2vw\5\n\6\2wx\b\6\1\2xz\3\2\2\2yt\3\2\2\2z}\3\2\2\2{y\3\2\2\2{|\3"+
		"\2\2\2|\u0082\3\2\2\2}{\3\2\2\2~\177\7\17\2\2\177\u0081\5\n\6\2\u0080"+
		"~\3\2\2\2\u0081\u0084\3\2\2\2\u0082\u0080\3\2\2\2\u0082\u0083\3\2\2\2"+
		"\u0083\u0085\3\2\2\2\u0084\u0082\3\2\2\2\u0085\u0086\7\22\2\2\u0086\u00a3"+
		"\b\6\1\2\u0087\u0088\7\b\2\2\u0088\u0092\b\6\1\2\u0089\u008a\7\5\2\2\u008a"+
		"\u008c\b\6\1\2\u008b\u0089\3\2\2\2\u008b\u008c\3\2\2\2\u008c\u008d\3\2"+
		"\2\2\u008d\u008e\5\n\6\2\u008e\u008f\b\6\1\2\u008f\u0091\3\2\2\2\u0090"+
		"\u008b\3\2\2\2\u0091\u0094\3\2\2\2\u0092\u0090\3\2\2\2\u0092\u0093\3\2"+
		"\2\2\u0093\u0099\3\2\2\2\u0094\u0092\3\2\2\2\u0095\u0096\7\23\2\2\u0096"+
		"\u0098\5\n\6\2\u0097\u0095\3\2\2\2\u0098\u009b\3\2\2\2\u0099\u0097\3\2"+
		"\2\2\u0099\u009a\3\2\2\2\u009a\u009c\3\2\2\2\u009b\u0099\3\2\2\2\u009c"+
		"\u009d\7\3\2\2\u009d\u00a3\b\6\1\2\u009e\u009f\7\t\2\2\u009f\u00a0\5\n"+
		"\6\2\u00a0\u00a1\b\6\1\2\u00a1\u00a3\3\2\2\2\u00a2e\3\2\2\2\u00a2g\3\2"+
		"\2\2\u00a2i\3\2\2\2\u00a2p\3\2\2\2\u00a2\u0087\3\2\2\2\u00a2\u009e\3\2"+
		"\2\2\u00a3\13\3\2\2\2\u00a4\u00a5\7\25\2\2\u00a5\u00e0\b\7\1\2\u00a6\u00a7"+
		"\7\13\2\2\u00a7\u00a8\7\n\2\2\u00a8\u00a9\t\4\2\2\u00a9\u00aa\7\5\2\2"+
		"\u00aa\u00ab\t\5\2\2\u00ab\u00ac\7\4\2\2\u00ac\u00e0\b\7\1\2\u00ad\u00ae"+
		"\7\20\2\2\u00ae\u00b8\b\7\1\2\u00af\u00b0\7\5\2\2\u00b0\u00b2\b\7\1\2"+
		"\u00b1\u00af\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00b4"+
		"\5\f\7\2\u00b4\u00b5\b\7\1\2\u00b5\u00b7\3\2\2\2\u00b6\u00b1\3\2\2\2\u00b7"+
		"\u00ba\3\2\2\2\u00b8\u00b6\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9\u00bf\3\2"+
		"\2\2\u00ba\u00b8\3\2\2\2\u00bb\u00bc\7\17\2\2\u00bc\u00be\5\f\7\2\u00bd"+
		"\u00bb\3\2\2\2\u00be\u00c1\3\2\2\2\u00bf\u00bd\3\2\2\2\u00bf\u00c0\3\2"+
		"\2\2\u00c0\u00c2\3\2\2\2\u00c1\u00bf\3\2\2\2\u00c2\u00c3\7\22\2\2\u00c3"+
		"\u00e0\b\7\1\2\u00c4\u00c5\7\b\2\2\u00c5\u00cf\b\7\1\2\u00c6\u00c7\7\5"+
		"\2\2\u00c7\u00c9\b\7\1\2\u00c8\u00c6\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9"+
		"\u00ca\3\2\2\2\u00ca\u00cb\5\f\7\2\u00cb\u00cc\b\7\1\2\u00cc\u00ce\3\2"+
		"\2\2\u00cd\u00c8\3\2\2\2\u00ce\u00d1\3\2\2\2\u00cf\u00cd\3\2\2\2\u00cf"+
		"\u00d0\3\2\2\2\u00d0\u00d6\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d2\u00d3\7\23"+
		"\2\2\u00d3\u00d5\5\f\7\2\u00d4\u00d2\3\2\2\2\u00d5\u00d8\3\2\2\2\u00d6"+
		"\u00d4\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7\u00d9\3\2\2\2\u00d8\u00d6\3\2"+
		"\2\2\u00d9\u00da\7\3\2\2\u00da\u00e0\b\7\1\2\u00db\u00dc\7\t\2\2\u00dc"+
		"\u00dd\5\f\7\2\u00dd\u00de\b\7\1\2\u00de\u00e0\3\2\2\2\u00df\u00a4\3\2"+
		"\2\2\u00df\u00a6\3\2\2\2\u00df\u00ad\3\2\2\2\u00df\u00c4\3\2\2\2\u00df"+
		"\u00db\3\2\2\2\u00e0\r\3\2\2\2\30\23\27$\'GRVat{\u0082\u008b\u0092\u0099"+
		"\u00a2\u00b1\u00b8\u00bf\u00c8\u00cf\u00d6\u00df";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}