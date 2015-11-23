// Generated from /home/cristian/workspace/fastest/Fastest/src/main/java/compserver/tcasegen/strategies/setlog/setlogtoz/SLog2Z.g4 by ANTLR 4.5.1
package compserver.tcasegen.strategies.setlog.setlogtoz;

//package compserver.tcasegen.strategies.setlog.setlogtoz;
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
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		NAME=18, CTE=19, NUM=20, NL=21, WS=22, SKIP=23;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
		"NAME", "CTE", "NUM", "NL", "WS", "SKIP"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'_CONSTR'", "'='", "'['", "','", "']'", "'set('", "')'", "'list('", 
		"'integer('", "'neq'", "'int'", "'('", "'{'", "'\\'", "'}'", "'|'", "'-'", 
		null, null, null, "'\n'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, "NAME", "CTE", "NUM", "NL", "WS", 
		"SKIP"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


		HashMap<String,StringPointer> slVars = new HashMap();	
		HashMap<String,String> zNames = new HashMap();
		HashMap<String,String> tipos = new HashMap();
		HashMap<String,String> zVars = new HashMap();
		HashMap<String,String> valoresProhibidos = new HashMap();
		List<String> varNoGenerar = new LinkedList<String>();
		ConstantCreator cc;
		
		public HashMap<String,StringPointer> getSlvars(){
			return slVars;
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
			cc = new ConstantCreator(tipos,slVars,zNames,valoresProhibidos);
			
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
						if(slVars != null)
							slVars.put(var, valor);
						}
					}
				}
		}
		
		private void llenarZVars(){
			Iterator iterator = slVars.keySet().iterator();  
			String slname,zname,valor;
			while (iterator.hasNext()) {  
				slname = iterator.next().toString();
				if (slVars.get(slname)!=null){	
					valor = slVars.get(slname).toString();
					
					
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
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 21:
			WS_action((RuleContext)_localctx, actionIndex);
			break;
		case 22:
			SKIP_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:
			skip();
			break;
		}
	}
	private void SKIP_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1:
			skip();
			break;
		}
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\31\u008b\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3"+
		"\7\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3"+
		"\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\7\23n\n\23\f\23\16\23q\13"+
		"\23\3\24\3\24\7\24u\n\24\f\24\16\24x\13\24\3\25\6\25{\n\25\r\25\16\25"+
		"|\3\26\3\26\3\27\6\27\u0082\n\27\r\27\16\27\u0083\3\27\3\27\3\30\3\30"+
		"\3\30\3\30\2\2\31\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31"+
		"\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\3\2\6\4\2C\\aa"+
		"\5\2\62;C\\c|\5\2//\62;c|\5\2\13\13\17\17\"\"\u008e\2\3\3\2\2\2\2\5\3"+
		"\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2"+
		"\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3"+
		"\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'"+
		"\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\3\61\3\2\2\2\59\3"+
		"\2\2\2\7;\3\2\2\2\t=\3\2\2\2\13?\3\2\2\2\rA\3\2\2\2\17F\3\2\2\2\21H\3"+
		"\2\2\2\23N\3\2\2\2\25W\3\2\2\2\27[\3\2\2\2\31_\3\2\2\2\33a\3\2\2\2\35"+
		"c\3\2\2\2\37e\3\2\2\2!g\3\2\2\2#i\3\2\2\2%k\3\2\2\2\'r\3\2\2\2)z\3\2\2"+
		"\2+~\3\2\2\2-\u0081\3\2\2\2/\u0087\3\2\2\2\61\62\7a\2\2\62\63\7E\2\2\63"+
		"\64\7Q\2\2\64\65\7P\2\2\65\66\7U\2\2\66\67\7V\2\2\678\7T\2\28\4\3\2\2"+
		"\29:\7?\2\2:\6\3\2\2\2;<\7]\2\2<\b\3\2\2\2=>\7.\2\2>\n\3\2\2\2?@\7_\2"+
		"\2@\f\3\2\2\2AB\7u\2\2BC\7g\2\2CD\7v\2\2DE\7*\2\2E\16\3\2\2\2FG\7+\2\2"+
		"G\20\3\2\2\2HI\7n\2\2IJ\7k\2\2JK\7u\2\2KL\7v\2\2LM\7*\2\2M\22\3\2\2\2"+
		"NO\7k\2\2OP\7p\2\2PQ\7v\2\2QR\7g\2\2RS\7i\2\2ST\7g\2\2TU\7t\2\2UV\7*\2"+
		"\2V\24\3\2\2\2WX\7p\2\2XY\7g\2\2YZ\7s\2\2Z\26\3\2\2\2[\\\7k\2\2\\]\7p"+
		"\2\2]^\7v\2\2^\30\3\2\2\2_`\7*\2\2`\32\3\2\2\2ab\7}\2\2b\34\3\2\2\2cd"+
		"\7^\2\2d\36\3\2\2\2ef\7\177\2\2f \3\2\2\2gh\7~\2\2h\"\3\2\2\2ij\7/\2\2"+
		"j$\3\2\2\2ko\t\2\2\2ln\t\3\2\2ml\3\2\2\2nq\3\2\2\2om\3\2\2\2op\3\2\2\2"+
		"p&\3\2\2\2qo\3\2\2\2rv\t\4\2\2su\t\3\2\2ts\3\2\2\2ux\3\2\2\2vt\3\2\2\2"+
		"vw\3\2\2\2w(\3\2\2\2xv\3\2\2\2y{\4\62;\2zy\3\2\2\2{|\3\2\2\2|z\3\2\2\2"+
		"|}\3\2\2\2}*\3\2\2\2~\177\7\f\2\2\177,\3\2\2\2\u0080\u0082\t\5\2\2\u0081"+
		"\u0080\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u0081\3\2\2\2\u0083\u0084\3\2"+
		"\2\2\u0084\u0085\3\2\2\2\u0085\u0086\b\27\2\2\u0086.\3\2\2\2\u0087\u0088"+
		"\7^\2\2\u0088\u0089\7^\2\2\u0089\u008a\b\30\3\2\u008a\60\3\2\2\2\7\2o"+
		"v|\u0083\4\3\27\2\3\30\3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}