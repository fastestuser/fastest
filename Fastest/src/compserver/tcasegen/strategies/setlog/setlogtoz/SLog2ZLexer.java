// Generated from SLog2Z.g4 by ANTLR 4.0

package compserver.tcasegen.strategies.setlog.setlogtoz;
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

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SLog2ZLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__16=1, T__15=2, T__14=3, T__13=4, T__12=5, T__11=6, T__10=7, T__9=8, 
		T__8=9, T__7=10, T__6=11, T__5=12, T__4=13, T__3=14, T__2=15, T__1=16, 
		T__0=17, NAME=18, CTE=19, NUM=20, NL=21, WS=22, SKIP=23;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"']'", "')'", "','", "'list('", "'set('", "'['", "'-'", "'('", "'int'", 
		"'='", "'_CONSTR'", "'integer('", "'\\'", "'{'", "'neq'", "'}'", "'|'", 
		"NAME", "CTE", "NUM", "'\n'", "WS", "SKIP"
	};
	public static final String[] ruleNames = {
		"T__16", "T__15", "T__14", "T__13", "T__12", "T__11", "T__10", "T__9", 
		"T__8", "T__7", "T__6", "T__5", "T__4", "T__3", "T__2", "T__1", "T__0", 
		"NAME", "CTE", "NUM", "NL", "WS", "SKIP"
	};


		HashMap<String,StringPointer> slvars = new HashMap();	
		HashMap<String,String> zNames = new HashMap();
		HashMap<String,String> tipos = new HashMap();
		HashMap<String,String> zVars = new HashMap();
		HashMap<String,String> valoresProhibidos = new HashMap();
		ConstantCreator cc;
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
			cc = new ConstantCreator(tipos,slvars,valoresProhibidos,this.zNames);
			
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
		


	public SLog2ZLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "SLog2Z.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 21: WS_action((RuleContext)_localctx, actionIndex); break;

		case 22: SKIP_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: skip(); break;
		}
	}
	private void SKIP_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1: skip(); break;
		}
	}

	public static final String _serializedATN =
		"\2\4\31\u008b\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b"+
		"\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20"+
		"\t\20\4\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27"+
		"\t\27\4\30\t\30\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3"+
		"\6\3\6\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\n\3\13\3\13\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3"+
		"\16\3\17\3\17\3\20\3\20\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\7\23n"+
		"\n\23\f\23\16\23q\13\23\3\24\3\24\7\24u\n\24\f\24\16\24x\13\24\3\25\6"+
		"\25{\n\25\r\25\16\25|\3\26\3\26\3\27\6\27\u0082\n\27\r\27\16\27\u0083"+
		"\3\27\3\27\3\30\3\30\3\30\3\30\2\31\3\3\1\5\4\1\7\5\1\t\6\1\13\7\1\r\b"+
		"\1\17\t\1\21\n\1\23\13\1\25\f\1\27\r\1\31\16\1\33\17\1\35\20\1\37\21\1"+
		"!\22\1#\23\1%\24\1\'\25\1)\26\1+\27\1-\30\2/\31\3\3\2\7\4C\\aa\5\62;C"+
		"\\c|\5//\62;c|\5\62;C\\c|\5\13\13\17\17\"\"\u008e\2\3\3\2\2\2\2\5\3\2"+
		"\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21"+
		"\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2"+
		"\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3"+
		"\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\3\61\3\2\2\2\5\63\3"+
		"\2\2\2\7\65\3\2\2\2\t\67\3\2\2\2\13=\3\2\2\2\rB\3\2\2\2\17D\3\2\2\2\21"+
		"F\3\2\2\2\23H\3\2\2\2\25L\3\2\2\2\27N\3\2\2\2\31V\3\2\2\2\33_\3\2\2\2"+
		"\35a\3\2\2\2\37c\3\2\2\2!g\3\2\2\2#i\3\2\2\2%k\3\2\2\2\'r\3\2\2\2)z\3"+
		"\2\2\2+~\3\2\2\2-\u0081\3\2\2\2/\u0087\3\2\2\2\61\62\7_\2\2\62\4\3\2\2"+
		"\2\63\64\7+\2\2\64\6\3\2\2\2\65\66\7.\2\2\66\b\3\2\2\2\678\7n\2\289\7"+
		"k\2\29:\7u\2\2:;\7v\2\2;<\7*\2\2<\n\3\2\2\2=>\7u\2\2>?\7g\2\2?@\7v\2\2"+
		"@A\7*\2\2A\f\3\2\2\2BC\7]\2\2C\16\3\2\2\2DE\7/\2\2E\20\3\2\2\2FG\7*\2"+
		"\2G\22\3\2\2\2HI\7k\2\2IJ\7p\2\2JK\7v\2\2K\24\3\2\2\2LM\7?\2\2M\26\3\2"+
		"\2\2NO\7a\2\2OP\7E\2\2PQ\7Q\2\2QR\7P\2\2RS\7U\2\2ST\7V\2\2TU\7T\2\2U\30"+
		"\3\2\2\2VW\7k\2\2WX\7p\2\2XY\7v\2\2YZ\7g\2\2Z[\7i\2\2[\\\7g\2\2\\]\7t"+
		"\2\2]^\7*\2\2^\32\3\2\2\2_`\7^\2\2`\34\3\2\2\2ab\7}\2\2b\36\3\2\2\2cd"+
		"\7p\2\2de\7g\2\2ef\7s\2\2f \3\2\2\2gh\7\177\2\2h\"\3\2\2\2ij\7~\2\2j$"+
		"\3\2\2\2ko\t\2\2\2ln\t\3\2\2ml\3\2\2\2nq\3\2\2\2om\3\2\2\2op\3\2\2\2p"+
		"&\3\2\2\2qo\3\2\2\2rv\t\4\2\2su\t\5\2\2ts\3\2\2\2ux\3\2\2\2vt\3\2\2\2"+
		"vw\3\2\2\2w(\3\2\2\2xv\3\2\2\2y{\4\62;\2zy\3\2\2\2{|\3\2\2\2|z\3\2\2\2"+
		"|}\3\2\2\2}*\3\2\2\2~\177\7\f\2\2\177,\3\2\2\2\u0080\u0082\t\6\2\2\u0081"+
		"\u0080\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u0081\3\2\2\2\u0083\u0084\3\2"+
		"\2\2\u0084\u0085\3\2\2\2\u0085\u0086\b\27\2\2\u0086.\3\2\2\2\u0087\u0088"+
		"\7^\2\2\u0088\u0089\7^\2\2\u0089\u008a\b\30\3\2\u008a\60\3\2\2\2\7\2o"+
		"v|\u0083";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}