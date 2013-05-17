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
		"']'", "'int(0, 10000000000),'", "')'", "','", "'int(-10000000000, 10000000000),'", 
		"'list('", "'set('", "'['", "'-'", "'='", "'_CONSTR'", "'integer('", "'\\'", 
		"'{'", "'neq'", "'}'", "'|'", "NAME", "CTE", "NUM", "'\n'", "WS", "SKIP"
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
		HashMap<String,String> freeTypes = new HashMap();
		HashMap<String,String> valoresProhibidos = new HashMap();
		ConstantCreator cc;
		public HashMap<String,String> getZVars(){
			return zVars;
		}
		//devuelve un elemento que pertenece a la resta de dos conjuntos de String
		// e = "aaa,bbb,ccc,ddd", ne = "bbb,aaa,ddd" , devuelve ccc
		private static String getNotEqType(String e, String ne){
			String[] aux1 = e.split(",");
			int m = aux1.length;
			int i;
			String s; 
			for (i = 0; i < m; i++){
				s = aux1[i];
				if(!ne.contains(s))
					return s;
			
			}	
			
			return null;
		}
		//usa la estructura tipos, conjunto de valores posible de las variables enumeradas
		//y los valores prohibidos de la estructura valoresProhibidos, y pone un valor por variable en slvars
		private void putNotEqInSlvars(){
			Iterator<String> iterator = valoresProhibidos.keySet().iterator();  
			String key,value,e,cte;String[] aux;
			while (iterator.hasNext()) {  
			   key = iterator.next().toString();
			   e = tipos.get(key);
			   e = e.substring(1,e.length()-1);
			   cte = getNotEqType(e,valoresProhibidos.get(key));
			   slvars.put(key, new StringPointer(cte));
			} 
		}
		//llena la estructura freeTypes, la cual se usa para saber el tipo de una variabla
		//que no figura en slvars, a partir de un elemento que esta en desigualdad en contraint
		private HashMap<String,String> llenarFreeTypes(){
	    	HashMap<String,String> s = new HashMap<String,String>();
	    	Iterator<String> iterator = tipos.keySet().iterator();
	    	String key,valor,nomtipo;
	    	while (iterator.hasNext()) { 
	    		key = iterator.next().toString();
				valor = tipos.get(key);
				//EnumerationType:FT:{elem1,elem2}
				if (valor.startsWith("EnumerationType")){
					String[] aux = valor.split(":");
					nomtipo =  aux[1];
					//aux = ((String) (aux[2]).subSequence(1, (aux[2]).length()-1)).split(",");
					s.put(nomtipo, ((String) (aux[2]).subSequence(1, (aux[2]).length()-1)));
				}
	    	}
	    	
	    	return s;
	    }
	    
		public void loadTablas(HashMap<String,String> zVars, HashMap<String,String> tipos, HashMap<String,String> memory){
			zNames = CCUtils.invertHashMap(memory);
			this.tipos = tipos;
			this.zVars = zVars;
			
			
			System.out.println("\n");
			System.out.println("memory: "); 
			printHashMap(zNames);
			System.out.println("\n tipos: "); 
			printHashMap(tipos);
			System.out.println("\n");
			freeTypes = llenarFreeTypes();
			System.out.println("\n tipos Libres: "); 
			printHashMap(freeTypes);
			System.out.println("\n");
			cc = new ConstantCreator(tipos,zNames,slvars,valoresProhibidos);
			
		}
		
		
		private String getTipoLibre(String elem){
	    	Iterator<String> iterator = freeTypes.keySet().iterator();  
			String key;	String value;
			while (iterator.hasNext()) { 
				key = iterator.next().toString();
				value = freeTypes.get(key);
				if(value !=null){
					if (value.contains(elem))
						return value;
				}
			}
	    	
	    	return "null";
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
		"\2\4\31\u00ba\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b"+
		"\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20"+
		"\t\20\4\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27"+
		"\t\27\4\30\t\30\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\b"+
		"\3\b\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20"+
		"\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\7\23\u009d\n\23\f\23\16\23\u00a0"+
		"\13\23\3\24\3\24\7\24\u00a4\n\24\f\24\16\24\u00a7\13\24\3\25\6\25\u00aa"+
		"\n\25\r\25\16\25\u00ab\3\26\3\26\3\27\6\27\u00b1\n\27\r\27\16\27\u00b2"+
		"\3\27\3\27\3\30\3\30\3\30\3\30\2\31\3\3\1\5\4\1\7\5\1\t\6\1\13\7\1\r\b"+
		"\1\17\t\1\21\n\1\23\13\1\25\f\1\27\r\1\31\16\1\33\17\1\35\20\1\37\21\1"+
		"!\22\1#\23\1%\24\1\'\25\1)\26\1+\27\1-\30\2/\31\3\3\2\7\4C\\aa\5\62;C"+
		"\\c|\5//\62;c|\5\62;C\\c|\5\13\13\17\17\"\"\u00bd\2\3\3\2\2\2\2\5\3\2"+
		"\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21"+
		"\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2"+
		"\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3"+
		"\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\3\61\3\2\2\2\5\63\3"+
		"\2\2\2\7H\3\2\2\2\tJ\3\2\2\2\13L\3\2\2\2\rl\3\2\2\2\17r\3\2\2\2\21w\3"+
		"\2\2\2\23y\3\2\2\2\25{\3\2\2\2\27}\3\2\2\2\31\u0085\3\2\2\2\33\u008e\3"+
		"\2\2\2\35\u0090\3\2\2\2\37\u0092\3\2\2\2!\u0096\3\2\2\2#\u0098\3\2\2\2"+
		"%\u009a\3\2\2\2\'\u00a1\3\2\2\2)\u00a9\3\2\2\2+\u00ad\3\2\2\2-\u00b0\3"+
		"\2\2\2/\u00b6\3\2\2\2\61\62\7_\2\2\62\4\3\2\2\2\63\64\7k\2\2\64\65\7p"+
		"\2\2\65\66\7v\2\2\66\67\7*\2\2\678\7\62\2\289\7.\2\29:\7\"\2\2:;\7\63"+
		"\2\2;<\7\62\2\2<=\7\62\2\2=>\7\62\2\2>?\7\62\2\2?@\7\62\2\2@A\7\62\2\2"+
		"AB\7\62\2\2BC\7\62\2\2CD\7\62\2\2DE\7\62\2\2EF\7+\2\2FG\7.\2\2G\6\3\2"+
		"\2\2HI\7+\2\2I\b\3\2\2\2JK\7.\2\2K\n\3\2\2\2LM\7k\2\2MN\7p\2\2NO\7v\2"+
		"\2OP\7*\2\2PQ\7/\2\2QR\7\63\2\2RS\7\62\2\2ST\7\62\2\2TU\7\62\2\2UV\7\62"+
		"\2\2VW\7\62\2\2WX\7\62\2\2XY\7\62\2\2YZ\7\62\2\2Z[\7\62\2\2[\\\7\62\2"+
		"\2\\]\7.\2\2]^\7\"\2\2^_\7\63\2\2_`\7\62\2\2`a\7\62\2\2ab\7\62\2\2bc\7"+
		"\62\2\2cd\7\62\2\2de\7\62\2\2ef\7\62\2\2fg\7\62\2\2gh\7\62\2\2hi\7\62"+
		"\2\2ij\7+\2\2jk\7.\2\2k\f\3\2\2\2lm\7n\2\2mn\7k\2\2no\7u\2\2op\7v\2\2"+
		"pq\7*\2\2q\16\3\2\2\2rs\7u\2\2st\7g\2\2tu\7v\2\2uv\7*\2\2v\20\3\2\2\2"+
		"wx\7]\2\2x\22\3\2\2\2yz\7/\2\2z\24\3\2\2\2{|\7?\2\2|\26\3\2\2\2}~\7a\2"+
		"\2~\177\7E\2\2\177\u0080\7Q\2\2\u0080\u0081\7P\2\2\u0081\u0082\7U\2\2"+
		"\u0082\u0083\7V\2\2\u0083\u0084\7T\2\2\u0084\30\3\2\2\2\u0085\u0086\7"+
		"k\2\2\u0086\u0087\7p\2\2\u0087\u0088\7v\2\2\u0088\u0089\7g\2\2\u0089\u008a"+
		"\7i\2\2\u008a\u008b\7g\2\2\u008b\u008c\7t\2\2\u008c\u008d\7*\2\2\u008d"+
		"\32\3\2\2\2\u008e\u008f\7^\2\2\u008f\34\3\2\2\2\u0090\u0091\7}\2\2\u0091"+
		"\36\3\2\2\2\u0092\u0093\7p\2\2\u0093\u0094\7g\2\2\u0094\u0095\7s\2\2\u0095"+
		" \3\2\2\2\u0096\u0097\7\177\2\2\u0097\"\3\2\2\2\u0098\u0099\7~\2\2\u0099"+
		"$\3\2\2\2\u009a\u009e\t\2\2\2\u009b\u009d\t\3\2\2\u009c\u009b\3\2\2\2"+
		"\u009d\u00a0\3\2\2\2\u009e\u009c\3\2\2\2\u009e\u009f\3\2\2\2\u009f&\3"+
		"\2\2\2\u00a0\u009e\3\2\2\2\u00a1\u00a5\t\4\2\2\u00a2\u00a4\t\5\2\2\u00a3"+
		"\u00a2\3\2\2\2\u00a4\u00a7\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a5\u00a6\3\2"+
		"\2\2\u00a6(\3\2\2\2\u00a7\u00a5\3\2\2\2\u00a8\u00aa\4\62;\2\u00a9\u00a8"+
		"\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac"+
		"*\3\2\2\2\u00ad\u00ae\7\f\2\2\u00ae,\3\2\2\2\u00af\u00b1\t\6\2\2\u00b0"+
		"\u00af\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b2\u00b3\3\2"+
		"\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00b5\b\27\2\2\u00b5.\3\2\2\2\u00b6\u00b7"+
		"\7^\2\2\u00b7\u00b8\7^\2\2\u00b8\u00b9\b\30\3\2\u00b9\60\3\2\2\2\7\2\u009e"+
		"\u00a5\u00ab\u00b2";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}