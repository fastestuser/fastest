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
		T__14=1, T__13=2, T__12=3, T__11=4, T__10=5, T__9=6, T__8=7, T__7=8, T__6=9, 
		T__5=10, T__4=11, T__3=12, T__2=13, T__1=14, T__0=15, NAME=16, CTE=17, 
		NUM=18, CORCHETESTART=19, CORCHETEEND=20, NL=21, WS=22, SKIP=23;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"')'", "','", "'list('", "'set('", "'-'", "'='", "'_CONSTR'", "'integer('", 
		"'\\'", "'{'", "'neq'", "'NUM = int(-10000000000, 10000000000),'", "'NAT = int(0, 10000000000),'", 
		"'}'", "'|'", "NAME", "CTE", "NUM", "'['", "']'", "'\n'", "WS", "SKIP"
	};
	public static final String[] ruleNames = {
		"T__14", "T__13", "T__12", "T__11", "T__10", "T__9", "T__8", "T__7", "T__6", 
		"T__5", "T__4", "T__3", "T__2", "T__1", "T__0", "NAME", "CTE", "NUM", 
		"CORCHETESTART", "CORCHETEEND", "NL", "WS", "SKIP"
	};


		HashMap<String,StringPointer> slvars = new HashMap();	
		HashMap<String,String> zNames = new HashMap();
		HashMap<String,String> tipos = new HashMap();
		HashMap<String,String> zVars = new HashMap();
		HashMap<String,String> freeTypes = new HashMap();
		HashMap<String,String> notEqual = new HashMap();
		
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
		//y los valores prohibidos de la estructura notEqual, y pone un valor por variable en slvars
		private void putNotEqInSlvars(){
			Iterator<String> iterator = notEqual.keySet().iterator();  
			String key,value,e,cte;String[] aux;
			while (iterator.hasNext()) {  
			   key = iterator.next().toString();
			   e = tipos.get(key);
			   e = e.substring(1,e.length()-1);
			   cte = getNotEqType(e,notEqual.get(key));
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
	    
		public void loadTablas(ExprParser parser){
			zNames = invertMap(parser.getMemory());
			tipos = parser.getTypes();
			zVars = parser.getZVars();
			
			
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
		"\2\4\31\u00c6\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b"+
		"\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20"+
		"\t\20\4\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27"+
		"\t\27\4\30\t\30\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3"+
		"\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17"+
		"\3\20\3\20\3\21\3\21\7\21\u00a5\n\21\f\21\16\21\u00a8\13\21\3\22\3\22"+
		"\7\22\u00ac\n\22\f\22\16\22\u00af\13\22\3\23\6\23\u00b2\n\23\r\23\16\23"+
		"\u00b3\3\24\3\24\3\25\3\25\3\26\3\26\3\27\6\27\u00bd\n\27\r\27\16\27\u00be"+
		"\3\27\3\27\3\30\3\30\3\30\3\30\2\31\3\3\1\5\4\1\7\5\1\t\6\1\13\7\1\r\b"+
		"\1\17\t\1\21\n\1\23\13\1\25\f\1\27\r\1\31\16\1\33\17\1\35\20\1\37\21\1"+
		"!\22\1#\23\1%\24\1\'\25\1)\26\1+\27\1-\30\2/\31\3\3\2\6\5\62;C\\c|\6/"+
		"/\62;aac|\5\62;C\\c|\5\13\13\17\17\"\"\u00c9\2\3\3\2\2\2\2\5\3\2\2\2\2"+
		"\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2"+
		"\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2"+
		"\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2"+
		"\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\3\61\3\2\2\2\5\63\3\2\2"+
		"\2\7\65\3\2\2\2\t;\3\2\2\2\13@\3\2\2\2\rB\3\2\2\2\17D\3\2\2\2\21L\3\2"+
		"\2\2\23U\3\2\2\2\25W\3\2\2\2\27Y\3\2\2\2\31]\3\2\2\2\33\u0083\3\2\2\2"+
		"\35\u009e\3\2\2\2\37\u00a0\3\2\2\2!\u00a2\3\2\2\2#\u00a9\3\2\2\2%\u00b1"+
		"\3\2\2\2\'\u00b5\3\2\2\2)\u00b7\3\2\2\2+\u00b9\3\2\2\2-\u00bc\3\2\2\2"+
		"/\u00c2\3\2\2\2\61\62\7+\2\2\62\4\3\2\2\2\63\64\7.\2\2\64\6\3\2\2\2\65"+
		"\66\7n\2\2\66\67\7k\2\2\678\7u\2\289\7v\2\29:\7*\2\2:\b\3\2\2\2;<\7u\2"+
		"\2<=\7g\2\2=>\7v\2\2>?\7*\2\2?\n\3\2\2\2@A\7/\2\2A\f\3\2\2\2BC\7?\2\2"+
		"C\16\3\2\2\2DE\7a\2\2EF\7E\2\2FG\7Q\2\2GH\7P\2\2HI\7U\2\2IJ\7V\2\2JK\7"+
		"T\2\2K\20\3\2\2\2LM\7k\2\2MN\7p\2\2NO\7v\2\2OP\7g\2\2PQ\7i\2\2QR\7g\2"+
		"\2RS\7t\2\2ST\7*\2\2T\22\3\2\2\2UV\7^\2\2V\24\3\2\2\2WX\7}\2\2X\26\3\2"+
		"\2\2YZ\7p\2\2Z[\7g\2\2[\\\7s\2\2\\\30\3\2\2\2]^\7P\2\2^_\7W\2\2_`\7O\2"+
		"\2`a\7\"\2\2ab\7?\2\2bc\7\"\2\2cd\7k\2\2de\7p\2\2ef\7v\2\2fg\7*\2\2gh"+
		"\7/\2\2hi\7\63\2\2ij\7\62\2\2jk\7\62\2\2kl\7\62\2\2lm\7\62\2\2mn\7\62"+
		"\2\2no\7\62\2\2op\7\62\2\2pq\7\62\2\2qr\7\62\2\2rs\7\62\2\2st\7.\2\2t"+
		"u\7\"\2\2uv\7\63\2\2vw\7\62\2\2wx\7\62\2\2xy\7\62\2\2yz\7\62\2\2z{\7\62"+
		"\2\2{|\7\62\2\2|}\7\62\2\2}~\7\62\2\2~\177\7\62\2\2\177\u0080\7\62\2\2"+
		"\u0080\u0081\7+\2\2\u0081\u0082\7.\2\2\u0082\32\3\2\2\2\u0083\u0084\7"+
		"P\2\2\u0084\u0085\7C\2\2\u0085\u0086\7V\2\2\u0086\u0087\7\"\2\2\u0087"+
		"\u0088\7?\2\2\u0088\u0089\7\"\2\2\u0089\u008a\7k\2\2\u008a\u008b\7p\2"+
		"\2\u008b\u008c\7v\2\2\u008c\u008d\7*\2\2\u008d\u008e\7\62\2\2\u008e\u008f"+
		"\7.\2\2\u008f\u0090\7\"\2\2\u0090\u0091\7\63\2\2\u0091\u0092\7\62\2\2"+
		"\u0092\u0093\7\62\2\2\u0093\u0094\7\62\2\2\u0094\u0095\7\62\2\2\u0095"+
		"\u0096\7\62\2\2\u0096\u0097\7\62\2\2\u0097\u0098\7\62\2\2\u0098\u0099"+
		"\7\62\2\2\u0099\u009a\7\62\2\2\u009a\u009b\7\62\2\2\u009b\u009c\7+\2\2"+
		"\u009c\u009d\7.\2\2\u009d\34\3\2\2\2\u009e\u009f\7\177\2\2\u009f\36\3"+
		"\2\2\2\u00a0\u00a1\7~\2\2\u00a1 \3\2\2\2\u00a2\u00a6\4C\\\2\u00a3\u00a5"+
		"\t\2\2\2\u00a4\u00a3\3\2\2\2\u00a5\u00a8\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a6"+
		"\u00a7\3\2\2\2\u00a7\"\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a9\u00ad\t\3\2\2"+
		"\u00aa\u00ac\t\4\2\2\u00ab\u00aa\3\2\2\2\u00ac\u00af\3\2\2\2\u00ad\u00ab"+
		"\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae$\3\2\2\2\u00af\u00ad\3\2\2\2\u00b0"+
		"\u00b2\4\62;\2\u00b1\u00b0\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00b1\3\2"+
		"\2\2\u00b3\u00b4\3\2\2\2\u00b4&\3\2\2\2\u00b5\u00b6\7]\2\2\u00b6(\3\2"+
		"\2\2\u00b7\u00b8\7_\2\2\u00b8*\3\2\2\2\u00b9\u00ba\7\f\2\2\u00ba,\3\2"+
		"\2\2\u00bb\u00bd\t\5\2\2\u00bc\u00bb\3\2\2\2\u00bd\u00be\3\2\2\2\u00be"+
		"\u00bc\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0\u00c1\b\27"+
		"\2\2\u00c1.\3\2\2\2\u00c2\u00c3\7^\2\2\u00c3\u00c4\7^\2\2\u00c4\u00c5"+
		"\b\30\3\2\u00c5\60\3\2\2\2\7\2\u00a6\u00ad\u00b3\u00be";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}