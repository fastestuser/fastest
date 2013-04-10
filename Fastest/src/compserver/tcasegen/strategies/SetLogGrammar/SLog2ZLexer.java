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
		T__17=1, T__16=2, T__15=3, T__14=4, T__13=5, T__12=6, T__11=7, T__10=8, 
		T__9=9, T__8=10, T__7=11, T__6=12, T__5=13, T__4=14, T__3=15, T__2=16, 
		T__1=17, T__0=18, NAME=19, CTE=20, NUM=21, NL=22, WS=23, SKIP=24;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"']'", "')'", "'],'", "','", "'list('", "'set('", "'['", "'-'", "'='", 
		"'_CONSTR'", "'integer('", "'\\'", "'{'", "'neq'", "'NUM = int(-10000000000, 10000000000),'", 
		"'NAT = int(0, 10000000000),'", "'}'", "'|'", "NAME", "CTE", "NUM", "'\n'", 
		"WS", "SKIP"
	};
	public static final String[] ruleNames = {
		"T__17", "T__16", "T__15", "T__14", "T__13", "T__12", "T__11", "T__10", 
		"T__9", "T__8", "T__7", "T__6", "T__5", "T__4", "T__3", "T__2", "T__1", 
		"T__0", "NAME", "CTE", "NUM", "NL", "WS", "SKIP"
	};


		HashMap<String,StringValor> salida = new HashMap();	
		HashMap<String,String> zNames = new HashMap();
		HashMap<String,String> tipos = new HashMap();
		HashMap<String,String> zVars = new HashMap();
		
		public HashMap<String,String> getZVars(){
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
		case 22: WS_action((RuleContext)_localctx, actionIndex); break;

		case 23: SKIP_action((RuleContext)_localctx, actionIndex); break;
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
		"\2\4\32\u00cb\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b"+
		"\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20"+
		"\t\20\4\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27"+
		"\t\27\4\30\t\30\4\31\t\31\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r"+
		"\3\r\3\16\3\16\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\7\24\u00ae\n\24\f\24\16\24\u00b1"+
		"\13\24\3\25\3\25\7\25\u00b5\n\25\f\25\16\25\u00b8\13\25\3\26\6\26\u00bb"+
		"\n\26\r\26\16\26\u00bc\3\27\3\27\3\30\6\30\u00c2\n\30\r\30\16\30\u00c3"+
		"\3\30\3\30\3\31\3\31\3\31\3\31\2\32\3\3\1\5\4\1\7\5\1\t\6\1\13\7\1\r\b"+
		"\1\17\t\1\21\n\1\23\13\1\25\f\1\27\r\1\31\16\1\33\17\1\35\20\1\37\21\1"+
		"!\22\1#\23\1%\24\1\'\25\1)\26\1+\27\1-\30\1/\31\2\61\32\3\3\2\6\5\62;"+
		"C\\c|\6//\62;aac|\5\62;C\\c|\5\13\13\17\17\"\"\u00ce\2\3\3\2\2\2\2\5\3"+
		"\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2"+
		"\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3"+
		"\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'"+
		"\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\3\63"+
		"\3\2\2\2\5\65\3\2\2\2\7\67\3\2\2\2\t:\3\2\2\2\13<\3\2\2\2\rB\3\2\2\2\17"+
		"G\3\2\2\2\21I\3\2\2\2\23K\3\2\2\2\25M\3\2\2\2\27U\3\2\2\2\31^\3\2\2\2"+
		"\33`\3\2\2\2\35b\3\2\2\2\37f\3\2\2\2!\u008c\3\2\2\2#\u00a7\3\2\2\2%\u00a9"+
		"\3\2\2\2\'\u00ab\3\2\2\2)\u00b2\3\2\2\2+\u00ba\3\2\2\2-\u00be\3\2\2\2"+
		"/\u00c1\3\2\2\2\61\u00c7\3\2\2\2\63\64\7_\2\2\64\4\3\2\2\2\65\66\7+\2"+
		"\2\66\6\3\2\2\2\678\7_\2\289\7.\2\29\b\3\2\2\2:;\7.\2\2;\n\3\2\2\2<=\7"+
		"n\2\2=>\7k\2\2>?\7u\2\2?@\7v\2\2@A\7*\2\2A\f\3\2\2\2BC\7u\2\2CD\7g\2\2"+
		"DE\7v\2\2EF\7*\2\2F\16\3\2\2\2GH\7]\2\2H\20\3\2\2\2IJ\7/\2\2J\22\3\2\2"+
		"\2KL\7?\2\2L\24\3\2\2\2MN\7a\2\2NO\7E\2\2OP\7Q\2\2PQ\7P\2\2QR\7U\2\2R"+
		"S\7V\2\2ST\7T\2\2T\26\3\2\2\2UV\7k\2\2VW\7p\2\2WX\7v\2\2XY\7g\2\2YZ\7"+
		"i\2\2Z[\7g\2\2[\\\7t\2\2\\]\7*\2\2]\30\3\2\2\2^_\7^\2\2_\32\3\2\2\2`a"+
		"\7}\2\2a\34\3\2\2\2bc\7p\2\2cd\7g\2\2de\7s\2\2e\36\3\2\2\2fg\7P\2\2gh"+
		"\7W\2\2hi\7O\2\2ij\7\"\2\2jk\7?\2\2kl\7\"\2\2lm\7k\2\2mn\7p\2\2no\7v\2"+
		"\2op\7*\2\2pq\7/\2\2qr\7\63\2\2rs\7\62\2\2st\7\62\2\2tu\7\62\2\2uv\7\62"+
		"\2\2vw\7\62\2\2wx\7\62\2\2xy\7\62\2\2yz\7\62\2\2z{\7\62\2\2{|\7\62\2\2"+
		"|}\7.\2\2}~\7\"\2\2~\177\7\63\2\2\177\u0080\7\62\2\2\u0080\u0081\7\62"+
		"\2\2\u0081\u0082\7\62\2\2\u0082\u0083\7\62\2\2\u0083\u0084\7\62\2\2\u0084"+
		"\u0085\7\62\2\2\u0085\u0086\7\62\2\2\u0086\u0087\7\62\2\2\u0087\u0088"+
		"\7\62\2\2\u0088\u0089\7\62\2\2\u0089\u008a\7+\2\2\u008a\u008b\7.\2\2\u008b"+
		" \3\2\2\2\u008c\u008d\7P\2\2\u008d\u008e\7C\2\2\u008e\u008f\7V\2\2\u008f"+
		"\u0090\7\"\2\2\u0090\u0091\7?\2\2\u0091\u0092\7\"\2\2\u0092\u0093\7k\2"+
		"\2\u0093\u0094\7p\2\2\u0094\u0095\7v\2\2\u0095\u0096\7*\2\2\u0096\u0097"+
		"\7\62\2\2\u0097\u0098\7.\2\2\u0098\u0099\7\"\2\2\u0099\u009a\7\63\2\2"+
		"\u009a\u009b\7\62\2\2\u009b\u009c\7\62\2\2\u009c\u009d\7\62\2\2\u009d"+
		"\u009e\7\62\2\2\u009e\u009f\7\62\2\2\u009f\u00a0\7\62\2\2\u00a0\u00a1"+
		"\7\62\2\2\u00a1\u00a2\7\62\2\2\u00a2\u00a3\7\62\2\2\u00a3\u00a4\7\62\2"+
		"\2\u00a4\u00a5\7+\2\2\u00a5\u00a6\7.\2\2\u00a6\"\3\2\2\2\u00a7\u00a8\7"+
		"\177\2\2\u00a8$\3\2\2\2\u00a9\u00aa\7~\2\2\u00aa&\3\2\2\2\u00ab\u00af"+
		"\4C\\\2\u00ac\u00ae\t\2\2\2\u00ad\u00ac\3\2\2\2\u00ae\u00b1\3\2\2\2\u00af"+
		"\u00ad\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0(\3\2\2\2\u00b1\u00af\3\2\2\2"+
		"\u00b2\u00b6\t\3\2\2\u00b3\u00b5\t\4\2\2\u00b4\u00b3\3\2\2\2\u00b5\u00b8"+
		"\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7*\3\2\2\2\u00b8"+
		"\u00b6\3\2\2\2\u00b9\u00bb\4\62;\2\u00ba\u00b9\3\2\2\2\u00bb\u00bc\3\2"+
		"\2\2\u00bc\u00ba\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd,\3\2\2\2\u00be\u00bf"+
		"\7\f\2\2\u00bf.\3\2\2\2\u00c0\u00c2\t\5\2\2\u00c1\u00c0\3\2\2\2\u00c2"+
		"\u00c3\3\2\2\2\u00c3\u00c1\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4\u00c5\3\2"+
		"\2\2\u00c5\u00c6\b\30\2\2\u00c6\60\3\2\2\2\u00c7\u00c8\7^\2\2\u00c8\u00c9"+
		"\7^\2\2\u00c9\u00ca\b\31\3\2\u00ca\62\3\2\2\2\7\2\u00af\u00b6\u00bc\u00c3";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}