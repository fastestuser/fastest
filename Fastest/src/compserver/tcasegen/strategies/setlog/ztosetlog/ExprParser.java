// Generated from Expr.g4 by ANTLR 4.0

	package compserver.tcasegen.strategies.setlog.ztosetlog;
	import compserver.tcasegen.strategies.setlog.TypeManagerParser;
	import compserver.tcasegen.strategies.setlog.TypeManagerLexer;
	import java.util.HashMap;
	import java.util.ArrayList;
	import java.util.regex.Matcher;
	import java.util.regex.Pattern;
	import java.util.Collection;
	import java.util.Iterator;
	import java.util.Set;
	import java.lang.String;
	import javax.swing.tree.DefaultMutableTreeNode;
	import javax.rmi.CORBA.Util;
	

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ExprParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__60=1, T__59=2, T__58=3, T__57=4, T__56=5, T__55=6, T__54=7, T__53=8, 
		T__52=9, T__51=10, T__50=11, T__49=12, T__48=13, T__47=14, T__46=15, T__45=16, 
		T__44=17, T__43=18, T__42=19, T__41=20, T__40=21, T__39=22, T__38=23, 
		T__37=24, T__36=25, T__35=26, T__34=27, T__33=28, T__32=29, T__31=30, 
		T__30=31, T__29=32, T__28=33, T__27=34, T__26=35, T__25=36, T__24=37, 
		T__23=38, T__22=39, T__21=40, T__20=41, T__19=42, T__18=43, T__17=44, 
		T__16=45, T__15=46, T__14=47, T__13=48, T__12=49, T__11=50, T__10=51, 
		T__9=52, T__8=53, T__7=54, T__6=55, T__5=56, T__4=57, T__3=58, T__2=59, 
		T__1=60, T__0=61, CROSS=62, POWER=63, IN_FUN_65=64, IN_FUN_60=65, IN_FUN_50=66, 
		IN_FUN_45=67, IN_FUN_40=68, IN_FUN_30=69, IN_FUN_20=70, IN_FUN_10=71, 
		IN_FUN_5=72, SELECTION=73, NAME=74, NUM=75, DECORATION=76, NL=77, WS=78, 
		SETSTART=79, SETEND=80, LISTSTART=81, LISTEND=82, IMGSTART=83, IMGEND=84, 
		SKIP=85;
	public static final String[] tokenNames = {
		"<INVALID>", "'schema'", "'\\lnot'", "'\\#'", "'rev'", "'min'", "'['", 
		"'<'", "'false'", "'_{1}'", "'\\dom'", "'\\emptyset'", "'\\bigcap'", "'tail'", 
		"'}'", "'\\notin'", "'max'", "'\\land'", "')'", "'@'", "'\\seq'", "'head'", 
		"'='", "'\\leq'", "'\\prefix'", "'squash'", "'\\nat'", "'\\neq'", "'\\where'", 
		"'\\geq'", "'\\bigcup'", "'::='", "'\\subseteq'", "'|'", "'\\end{'", "'\\suffix'", 
		"']'", "'last'", "','", "'}{'", "'('", "':'", "'\\lor'", "'\\ran'", "'\\end{zed}'", 
		"'\\in'", "'seq_{1}'", "'\\rblot'", "'\\inv'", "'true'", "'\\begin{'", 
		"'\\lblot'", "'\\subset'", "'\\iff'", "'schemaType'", "'\\implies'", "';'", 
		"'front'", "'>'", "'\\begin{zed}'", "'\\num'", "'=='", "'\\cross'", "POWER", 
		"IN_FUN_65", "IN_FUN_60", "IN_FUN_50", "IN_FUN_45", "IN_FUN_40", "IN_FUN_30", 
		"IN_FUN_20", "IN_FUN_10", "IN_FUN_5", "'.'", "NAME", "NUM", "'~'", "NL", 
		"WS", "'\\{'", "'\\}'", "'\\langle'", "'\\rangle'", "'\\limg'", "'\\rimg'", 
		"SKIP"
	};
	public static final int
		RULE_specification = 0, RULE_paragraph = 1, RULE_basic_type = 2, RULE_equivalent_type = 3, 
		RULE_enumeration_type = 4, RULE_schemaText = 5, RULE_declPart = 6, RULE_declaration = 7, 
		RULE_declName = 8, RULE_predicate = 9, RULE_expression = 10, RULE_refName = 11, 
		RULE_post = 12, RULE_pre = 13;
	public static final String[] ruleNames = {
		"specification", "paragraph", "basic_type", "equivalent_type", "enumeration_type", 
		"schemaText", "declPart", "declaration", "declName", "predicate", "expression", 
		"refName", "post", "pre"
	};

	@Override
	public String getGrammarFileName() { return "Expr.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public ATN getATN() { return _ATN; }


		
		String setExpressionDecl, setExpressionPred, setExpressionExpr;
		
		int varNumber = 0;
		int modoSetExpression = 0; //0 = false, 1 = true
		int tipoSchema = 0;        //0 = false, 1 = true, esta variable se utiliza para no imprimir ciertas cosas,
						           //cuando trabajamos en tipos schema
		
		HashMap<String,String> schemaTypeVars;

		HashMap<String,String> setExpressionVars;
		HashMap<String,String> memory = new HashMap<String,String>(); //En memory se guardan las variables y expressiones leidas
		HashMap<String,String> types = new HashMap<String,String>();  //En types se guarda informacion sobre los tipos definidos
		HashMap<String,String> zVars = new HashMap<String,String>();  //En zVars se almacenan las variables Z, a las cuales luego (antes de generar
		                                                              //el caso de prueba) se les dara un valor.
		
		String out = new String();
		String functionsOut = new String();
		
		public String getSalida() {
			return out.concat(functionsOut);
		}
		
		public HashMap<String,String> getMemory() {
			return memory;
		}
		
		public HashMap<String,String> getTypes() {
			return types;
		}
		
		public HashMap<String,String> getZVars() {
			return zVars;
		}

		public void print(String c) {
			if (modoSetExpression == 0 && tipoSchema == 0) { 
				System.out.println(c + " &");
				out = out.concat(c + " &");
			}
			else if (modoSetExpression == 1)
				setExpressionDecl = setExpressionDecl.concat(" & " + c);
			else if (modoSetExpression == 2)
				setExpressionPred = setExpressionPred.concat(" & " + c);
			else if (modoSetExpression == 3)
				setExpressionExpr = setExpressionExpr.concat(" & " + c);
		}
		
		//Este metodo se utiliza para imprimir informacion del tipo: is_pfun, is_rel, etc
		//ya que debe ir al final de todo
		public void printAtEnd(String c) {
			if (modoSetExpression == 0 && tipoSchema == 0) 
				functionsOut = functionsOut.concat(c + " &");
			else if (modoSetExpression == 1)
				setExpressionDecl = setExpressionDecl.concat(" & " + c);
			else if (modoSetExpression == 2)
				setExpressionPred = setExpressionPred.concat(" & " + c);
			else if (modoSetExpression == 3)
				setExpressionExpr = setExpressionExpr.concat(" & " + c);
		}
		
		//Metodo para la determinacion del tipo mas externo.
		String getType(String type) {
			//El calculo se realiza mediante la construccion del arbol de tipos con la gramatica TypeManager
			ANTLRInputStream input = new ANTLRInputStream(type);
	        TypeManagerLexer lexer = new TypeManagerLexer(input);
	        CommonTokenStream tokens = new CommonTokenStream(lexer);
	        TypeManagerParser parser = new TypeManagerParser(tokens);
	        parser.typeManage();
	        DefaultMutableTreeNode root = parser.getRoot();
	        
	        //Elimino parentesis externos
	        while (((String) root.getUserObject()).equals("()")) {
	        	root = (DefaultMutableTreeNode) root.getChildAt(0);
	        }
	        
	        return (String) root.getUserObject();
		}
		
		//Metodo para la determinacion del tipo de salida o entrada de una funcion.
		String getChildType(String type, int pos) {
			//El calculo se realiza mediante la construccion del arbol de tipos con la gramatica TypeManager
			ANTLRInputStream input = new ANTLRInputStream(type);
	        TypeManagerLexer lexer = new TypeManagerLexer(input);
	        CommonTokenStream tokens = new CommonTokenStream(lexer);
	        TypeManagerParser parser = new TypeManagerParser(tokens);
	        parser.typeManage();
	        DefaultMutableTreeNode root = parser.getRoot();
	        
	        while (((String) root.getUserObject()).equals("()")) {
	        	root = (DefaultMutableTreeNode) root.getChildAt(0);
	        }
	        
	        DefaultMutableTreeNode child = (DefaultMutableTreeNode) root.getChildAt(pos);
	        
	        while (((String) child.getUserObject()).equals("()")) {
	        	child = (DefaultMutableTreeNode) child.getChildAt(0);
	        }
	        
	        return parser.printTree(child);
		}
		
		//Metodo para realizar la inversion de un tipo en Z, debe ser una funcion o un \power de \cross.
		String invertType(String type) {
			ANTLRInputStream input = new ANTLRInputStream(type);
	        TypeManagerLexer lexer = new TypeManagerLexer(input);
	        CommonTokenStream tokens = new CommonTokenStream(lexer);
	        TypeManagerParser parser = new TypeManagerParser(tokens);
	        parser.typeManage();
	        DefaultMutableTreeNode root = parser.getRoot();
	        
			String invertedType = new String();
			String rootType = (String) root.getUserObject();
			if (rootType.equals("\\power")) {
				invertedType = invertedType.concat("\\power(");
				DefaultMutableTreeNode child = (DefaultMutableTreeNode) root.getChildAt(0);
				String childType = (String) child.getUserObject();
				
				if (childType.equals("()")) {
					child = (DefaultMutableTreeNode) child.getChildAt(0);
					childType = (String) child.getUserObject();
				}
				
				if (childType.equals("\\cross")) {
					invertedType = invertedType.concat(parser.printTree((DefaultMutableTreeNode) child.getChildAt(1)));
					invertedType = invertedType.concat("\\cross");
					invertedType = invertedType.concat(parser.printTree((DefaultMutableTreeNode) child.getChildAt(0)));
				}
				invertedType = invertedType.concat(")");
			
			} else { //Entonces empieza con pfun, rel etc
			
				invertedType = invertedType.concat(parser.printTree((DefaultMutableTreeNode) root.getChildAt(1)));
				invertedType = invertedType.concat(rootType);
				invertedType = invertedType.concat(parser.printTree((DefaultMutableTreeNode) root.getChildAt(0)));
			
			}
			
			return invertedType;
		}
		
		//Metodo para obtener los tipos izquierdo y derecho.
		//Debe ser una funcion, un \power de \cross o una \seq
		//EJ: A \pfun B devuelve A y B
		ArrayList<String> leftAndRightTypes(String type) {
			ANTLRInputStream input = new ANTLRInputStream(type);
	        TypeManagerLexer lexer = new TypeManagerLexer(input);
	        CommonTokenStream tokens = new CommonTokenStream(lexer);
	        TypeManagerParser parser = new TypeManagerParser(tokens);
	        parser.typeManage();
	        DefaultMutableTreeNode root = parser.getRoot();
	        
			ArrayList<String> leftAndRight = new ArrayList<String>();
			DefaultMutableTreeNode left, right;
			String rootType = (String) root.getUserObject();
			if (rootType.equals("\\power")) {
				DefaultMutableTreeNode child = (DefaultMutableTreeNode) root.getChildAt(0);
				String childType = (String) child.getUserObject();
				
				while (childType.equals("()")) {
					child = (DefaultMutableTreeNode) child.getChildAt(0);
					childType = (String) child.getUserObject();
				}
				
				if (childType.equals("\\cross")) {
					left = (DefaultMutableTreeNode) child.getChildAt(0);
					while (((String) left.getUserObject()).equals("()"))
						left = (DefaultMutableTreeNode) left.getChildAt(0);
					right = (DefaultMutableTreeNode) child.getChildAt(1);
					while (((String) right.getUserObject()).equals("()"))
						right = (DefaultMutableTreeNode) right.getChildAt(0);
					
					leftAndRight.add(parser.printTree(left));
					leftAndRight.add(parser.printTree(right));
				}
			
			}
			else if (isSequence(rootType)) { //Entonces empieza con pfun, rel etc

				leftAndRight.add("\\nat");
				right = (DefaultMutableTreeNode) root.getChildAt(0);
				while (((String) right.getUserObject()).equals("()"))
					right = (DefaultMutableTreeNode) right.getChildAt(0);
				leftAndRight.add(parser.printTree(right));

			}
			else { //Entonces empieza con pfun, rel etc

			left = (DefaultMutableTreeNode) root.getChildAt(0);
			while (((String) left.getUserObject()).equals("()"))
				left = (DefaultMutableTreeNode) left.getChildAt(0);
			right = (DefaultMutableTreeNode) root.getChildAt(1);
			while (((String) right.getUserObject()).equals("()"))
				right = (DefaultMutableTreeNode) right.getChildAt(0);
				
			leftAndRight.add(parser.printTree(left));
			leftAndRight.add(parser.printTree(right));
			}
			
			return leftAndRight;
		}
		
		private String newVar() {
			String newVarName = "VAR" + varNumber;
			varNumber++;
			return newVarName;
		}
		
		private String newVar(String zName) {
			String newVarName = zName.substring(0,1).toUpperCase() + zName.substring(1).replace("?","");
			if (memory.containsValue(newVarName) /*|| modoSetExpression==1*/) { 
				newVarName = "VAR" + varNumber;
				varNumber++;
			}
			return newVarName;
		}
		
		private String typeInfo(String var, String type) {
				
			if (type != null) {
				if (isBasic(type)) {
					if(type.startsWith("EnumerationType")) {
						type = type.split(":")[1];
						if (tipoSchema == 0) print(var + " in " + type);
					} else
						type = type.split(":")[1];
					return type;
				}
			
				String nodeType = getType(type);
				
				if (isSequence(nodeType)){
					if (tipoSchema == 0) {
						if (nodeType.startsWith("seq_{1}"))
							print(var + " neq []");
						printAtEnd("list(" + var + ")");
					}
				}
				else if (nodeType.equals("\\rel")) {
					if (tipoSchema == 0) printAtEnd("is_rel(" + var + ")");
				}
				else if (nodeType.equals("\\pfun")) {
					if (tipoSchema == 0) printAtEnd("is_pfun(" + var + ")");
				}
				else if (nodeType.equals("\\fun")) {
					if (tipoSchema == 0) printAtEnd("is_pfun(" + var + ")");
				}
				else if (type.equals("\\nat") || type.equals("\\num") || type.equals("\\nat_{1}")) {
					if (tipoSchema == 0) {
						print(var + " in " + printInfo(type, true));
					}
				}
				else if (nodeType.equals("\\power")) {
					//Veo si lo que sigue es un tipo enumerado
					String childType = getChildType(type,0);
					childType = types.get(childType);
					if (childType != null && childType.startsWith("EnumerationType")) {
						if (tipoSchema == 0) print("subset(" + var + "," + childType.split(":")[1] + ")");
					}
				}
				else if (nodeType.contains("\\upto")) { //En este caso, los hijos pueden ser variables Setlog. (Se podra mejorar?)
					String[] childs = nodeType.split("\\\\upto");
					String childa = childs[0];
					String childb = childs[1];
					
					//Como pueden ser variables de setlog, debo buscar su equivalente Z
					childa = getKey(childa, memory);
					childb = getKey(childb, memory);
					
					//Obtengo la variable de setlg que representa el upto
					String nodeName = memory.get(childa + "\\upto" + childb); 
					if (nodeName != null) {
						if (tipoSchema == 0) print(var + " in " + nodeName);
					}
				}
				else { //double check
					type = types.get(type);
					if (type.startsWith("EnumerationType")) {
						if(!type.startsWith("BasicType")) {
							type = type.split(":")[1];
							if (tipoSchema == 0) print(var + " in " + type);
						} else
							type = type.split(":")[1];
						return type;
					}
				}
			}
			return type;
		}
		
		private String getKey(String value, HashMap<String,String> hashmap) {
			Iterator<String> keysIt= hashmap.keySet().iterator();
			while (keysIt.hasNext()) {
				String key = keysIt.next();
				if (hashmap.get(key).equals(value))
					return key;
			}
			return null;
		}
		
		private String printInfo(String type, boolean wantToPrint) {
			String translation = memory.get(type);
			int modoSetExpressionBk = modoSetExpression;
			
			if (translation == null) {
				if (type.equals("\\num"))
					translation = newVar("INT");
				else if (type.equals("\\nat"))
					translation = newVar("NAT");
				else if (type.equals("\\nat_{1}"))
					translation = newVar("NAT1");
				else
					translation = newVar();
			
				memory.put(type, translation);
				types.put(type, type);
				//if (modoSetExpression > 0)
				//	setExpressionVars.put(type, translation);
			}
			
			if (wantToPrint && (!out.contains(translation + " = int(")) && ((modoSetExpression == 0) || !((setExpressionDecl+setExpressionExpr+setExpressionPred).contains(translation + " = int(")))){ //Chequeo si ya se imprimio informacion del tipo
				modoSetExpression = 0;
				if (type.equals("\\num"))
					print(translation + " = int(-10000000000, 10000000000)");
				else if (type.equals("\\nat"))
					print(translation + " = int(0, 10000000000)");
				else if (type.equals("\\nat_{1}"))
					print(translation + " = int(1, 10000000000)");
				modoSetExpression = modoSetExpressionBk;
			}
			
			return translation;
		}
		
		private boolean isBasic(String type) {
			if (type.startsWith("BasicType") || type.startsWith("EnumerationType") || type.startsWith("SchemaType"))
				return true;
			return false;
		}
		
		private boolean isNumeric(String type) {
			if (type.equals("\\num") || type.equals("\\nat") || type.equals("\\nat_{1}"))
				return true;
			return false;
		}
		
		private boolean isSequence(String type) {
			if (type.equals("\\seq") || type.startsWith("seq_{1}"))
				return true;
			return false;
		}
		
		String convertToSet(String zVar, String setlogVar) { //si es una lista, debemos aplicar list_to_rel
			
			String type = types.get(zVar);
			if (isSequence(getType(type))) 
				if (memory.get("list_to_rel(" + zVar + ")") == null) {
					String newVarName = newVar();
					print("list_to_rel(" + setlogVar + "," + newVarName + ")");
					if (modoSetExpression != 0 ) //Si estoy dentro de un conjunto
						setExpressionVars.put(zVar, newVarName);				
					//Hace falta ver el tipo?
					String seqType = leftAndRightTypes(type).get(1);
					//typeInfo(newVarName, "\\power(\\nat\\cross(" + seqType + "))");
					types.put("list_to_rel(" + zVar + ")", "\\power(\\nat\\cross(" + seqType + "))");
					memory.put("list_to_rel(" + zVar + ")", newVarName);
					return newVarName;
				} else {
					return memory.get("list_to_rel(" + zVar + ")");
				}
			else
				return setlogVar;
		}

	public ExprParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class SpecificationContext extends ParserRuleContext {
		public ParagraphContext paragraph(int i) {
			return getRuleContext(ParagraphContext.class,i);
		}
		public List<ParagraphContext> paragraph() {
			return getRuleContexts(ParagraphContext.class);
		}
		public List<TerminalNode> NL() { return getTokens(ExprParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(ExprParser.NL, i);
		}
		public SpecificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_specification; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterSpecification(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitSpecification(this);
		}
	}

	public final SpecificationContext specification() throws RecognitionException {
		SpecificationContext _localctx = new SpecificationContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_specification);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(35); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(28); paragraph();
				setState(32);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(29); match(NL);
					}
					}
					setState(34);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(37); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==50 || _la==59 );
			/*
				   System.out.println("tablita de tippos");
				   System.out.println("-------------------");
				   String key, value;
				   Iterator<String> iterator = types.keySet().iterator();
				   while (iterator.hasNext()) {
				           key = iterator.next();
				           value = types.get(key);
				           System.out.println(key + "\t\t| " + value);
				   }
				   System.out.println("\ntablita de memory");
				   System.out.println("-------------------");
				   iterator = memory.keySet().iterator();
				   while (iterator.hasNext()) {
				           key = iterator.next();
				           value = memory.get(key);
				           System.out.println(key + "\t\t| " + value);
				   }
				   System.out.println("\ntablita de zVars");
				   System.out.println("-------------------");
				   iterator = zVars.keySet().iterator();
				   while (iterator.hasNext()) {
			           key = iterator.next();
			           value = zVars.get(key);
			           System.out.println(key + "\t\t| " + value);
			  	   }
			     
				*/
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

	public static class ParagraphContext extends ParserRuleContext {
		public Token NAME;
		public SchemaTextContext schemaText() {
			return getRuleContext(SchemaTextContext.class,0);
		}
		public Equivalent_typeContext equivalent_type(int i) {
			return getRuleContext(Equivalent_typeContext.class,i);
		}
		public TerminalNode NAME() { return getToken(ExprParser.NAME, 0); }
		public List<Basic_typeContext> basic_type() {
			return getRuleContexts(Basic_typeContext.class);
		}
		public List<Enumeration_typeContext> enumeration_type() {
			return getRuleContexts(Enumeration_typeContext.class);
		}
		public List<TerminalNode> NL() { return getTokens(ExprParser.NL); }
		public List<Equivalent_typeContext> equivalent_type() {
			return getRuleContexts(Equivalent_typeContext.class);
		}
		public Basic_typeContext basic_type(int i) {
			return getRuleContext(Basic_typeContext.class,i);
		}
		public Enumeration_typeContext enumeration_type(int i) {
			return getRuleContext(Enumeration_typeContext.class,i);
		}
		public TerminalNode NL(int i) {
			return getToken(ExprParser.NL, i);
		}
		public ParagraphContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paragraph; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterParagraph(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitParagraph(this);
		}
	}

	public final ParagraphContext paragraph() throws RecognitionException {
		ParagraphContext _localctx = new ParagraphContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_paragraph);
		int _la;
		try {
			setState(77);
			switch (_input.LA(1)) {
			case 50:
				enterOuterAlt(_localctx, 1);
				{
				setState(41); match(50);
				setState(45);
				switch (_input.LA(1)) {
				case 1:
					{
					setState(42); match(1);
					}
					break;
				case 54:
					{
					{
					setState(43); match(54);
					tipoSchema = 1; schemaTypeVars = new HashMap<String,String>();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(47); match(39);
				setState(48); ((ParagraphContext)_localctx).NAME = match(NAME);
				setState(49); match(14);
				setState(50); schemaText();

							if (tipoSchema == 1) {
								String newVarName = newVar((((ParagraphContext)_localctx).NAME!=null?((ParagraphContext)_localctx).NAME.getText():null));
								memory.put((((ParagraphContext)_localctx).NAME!=null?((ParagraphContext)_localctx).NAME.getText():null), newVarName);
								String vars = "";
								
								List<String> sortedVars = new ArrayList<String>(schemaTypeVars.keySet());
								java.util.Collections.sort(sortedVars);
								
								int i = 0;
								while( i < sortedVars.size() ){
								
									String type = schemaTypeVars.get(sortedVars.get(i));
								
									vars = vars.concat(sortedVars.get(i) + ":" + type);
						
									if (i+1 < sortedVars.size()){
										vars = vars.concat(",");
									}
									i++;
								}
								
								types.put((((ParagraphContext)_localctx).NAME!=null?((ParagraphContext)_localctx).NAME.getText():null), "SchemaType:" + newVarName + ":[" + vars + "]");
								vars = "";
							}
						
				setState(52); match(34);
				setState(56);
				switch (_input.LA(1)) {
				case 1:
					{
					setState(53); match(1);
					}
					break;
				case 54:
					{
					{
					setState(54); match(54);
					tipoSchema = 0;
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(58); match(14);
				}
				break;
			case 59:
				enterOuterAlt(_localctx, 2);
				{
				setState(60); match(59);
				setState(62);
				_la = _input.LA(1);
				if (_la==NL) {
					{
					setState(61); match(NL);
					}
				}

				setState(71); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(67);
					switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
					case 1:
						{
						setState(64); basic_type();
						}
						break;

					case 2:
						{
						setState(65); equivalent_type();
						}
						break;

					case 3:
						{
						setState(66); enumeration_type();
						}
						break;
					}
					setState(69); match(NL);
					}
					}
					setState(73); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==6 || _la==NAME );
				setState(75); match(44);
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

	public static class Basic_typeContext extends ParserRuleContext {
		public ArrayList<String> typeList;;
		public DeclNameContext a;
		public DeclNameContext declName;
		public DeclNameContext b;
		public List<DeclNameContext> declName() {
			return getRuleContexts(DeclNameContext.class);
		}
		public DeclNameContext declName(int i) {
			return getRuleContext(DeclNameContext.class,i);
		}
		public Basic_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_basic_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterBasic_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitBasic_type(this);
		}
	}

	public final Basic_typeContext basic_type() throws RecognitionException {
		Basic_typeContext _localctx = new Basic_typeContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_basic_type);
		((Basic_typeContext)getInvokingContext(2)).typeList =  new ArrayList<String>();
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(79); match(6);
			setState(80); ((Basic_typeContext)_localctx).a = ((Basic_typeContext)_localctx).declName = declName();
			((Basic_typeContext)getInvokingContext(2)).typeList.add((((Basic_typeContext)_localctx).a!=null?_input.getText(((Basic_typeContext)_localctx).a.start,((Basic_typeContext)_localctx).a.stop):null));
			setState(88);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==38) {
				{
				{
				setState(82); match(38);
				setState(83); ((Basic_typeContext)_localctx).b = ((Basic_typeContext)_localctx).declName = declName();
				((Basic_typeContext)getInvokingContext(2)).typeList.add((((Basic_typeContext)_localctx).b!=null?_input.getText(((Basic_typeContext)_localctx).b.start,((Basic_typeContext)_localctx).b.stop):null));
				}
				}
				setState(90);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(91); match(36);

					while( !((Basic_typeContext)getInvokingContext(2)).typeList.isEmpty() ) {
						String type = ((Basic_typeContext)getInvokingContext(2)).typeList.remove(0);
						
						String newVarName = newVar((((Basic_typeContext)_localctx).declName!=null?_input.getText(((Basic_typeContext)_localctx).declName.start,((Basic_typeContext)_localctx).declName.stop):null));
						memory.put(type, newVarName);
						print("set(" + newVarName + ")");
						types.put(type, "BasicType:" + newVarName);
					}
				
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

	public static class Equivalent_typeContext extends ParserRuleContext {
		public DeclNameContext declName;
		public ExpressionContext expression;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public DeclNameContext declName() {
			return getRuleContext(DeclNameContext.class,0);
		}
		public Equivalent_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equivalent_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterEquivalent_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitEquivalent_type(this);
		}
	}

	public final Equivalent_typeContext equivalent_type() throws RecognitionException {
		Equivalent_typeContext _localctx = new Equivalent_typeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_equivalent_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94); ((Equivalent_typeContext)_localctx).declName = declName();
			setState(95); match(61);
			setState(96); ((Equivalent_typeContext)_localctx).expression = expression(0);
			 
					String type = types.get((((Equivalent_typeContext)_localctx).expression!=null?_input.getText(((Equivalent_typeContext)_localctx).expression.start,((Equivalent_typeContext)_localctx).expression.stop):null));
					if (type != null) {
						types.put((((Equivalent_typeContext)_localctx).declName!=null?_input.getText(((Equivalent_typeContext)_localctx).declName.start,((Equivalent_typeContext)_localctx).declName.stop):null), type);
					}
				
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

	public static class Enumeration_typeContext extends ParserRuleContext {
		public ArrayList<String> cases;;
		public DeclNameContext d;
		public DeclNameContext a;
		public DeclNameContext b;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<DeclNameContext> declName() {
			return getRuleContexts(DeclNameContext.class);
		}
		public DeclNameContext declName(int i) {
			return getRuleContext(DeclNameContext.class,i);
		}
		public Enumeration_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumeration_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterEnumeration_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitEnumeration_type(this);
		}
	}

	public final Enumeration_typeContext enumeration_type() throws RecognitionException {
		Enumeration_typeContext _localctx = new Enumeration_typeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_enumeration_type);
		((Enumeration_typeContext)getInvokingContext(4)).cases =  new ArrayList<String>();
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99); ((Enumeration_typeContext)_localctx).d = declName();
			setState(100); match(31);
			setState(101); ((Enumeration_typeContext)_localctx).a = declName();
			((Enumeration_typeContext)getInvokingContext(4)).cases.add((((Enumeration_typeContext)_localctx).a!=null?_input.getText(((Enumeration_typeContext)_localctx).a.start,((Enumeration_typeContext)_localctx).a.stop):null));
			setState(104);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 3) | (1L << 4) | (1L << 5) | (1L << 10) | (1L << 11) | (1L << 12) | (1L << 13) | (1L << 16) | (1L << 20) | (1L << 21) | (1L << 25) | (1L << 26) | (1L << 30) | (1L << 37) | (1L << 40) | (1L << 43) | (1L << 46) | (1L << 51) | (1L << 57) | (1L << 60) | (1L << POWER))) != 0) || ((((_la - 74)) & ~0x3f) == 0 && ((1L << (_la - 74)) & ((1L << (NAME - 74)) | (1L << (NUM - 74)) | (1L << (DECORATION - 74)) | (1L << (SETSTART - 74)) | (1L << (LISTSTART - 74)))) != 0)) {
				{
				setState(103); expression(0);
				}
			}

			setState(114);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==33) {
				{
				{
				setState(106); match(33);
				setState(107); ((Enumeration_typeContext)_localctx).b = declName();
				((Enumeration_typeContext)getInvokingContext(4)).cases.add((((Enumeration_typeContext)_localctx).b!=null?_input.getText(((Enumeration_typeContext)_localctx).b.start,((Enumeration_typeContext)_localctx).b.stop):null));
				setState(110);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 3) | (1L << 4) | (1L << 5) | (1L << 10) | (1L << 11) | (1L << 12) | (1L << 13) | (1L << 16) | (1L << 20) | (1L << 21) | (1L << 25) | (1L << 26) | (1L << 30) | (1L << 37) | (1L << 40) | (1L << 43) | (1L << 46) | (1L << 51) | (1L << 57) | (1L << 60) | (1L << POWER))) != 0) || ((((_la - 74)) & ~0x3f) == 0 && ((1L << (_la - 74)) & ((1L << (NAME - 74)) | (1L << (NUM - 74)) | (1L << (DECORATION - 74)) | (1L << (SETSTART - 74)) | (1L << (LISTSTART - 74)))) != 0)) {
					{
					setState(109); expression(0);
					}
				}

				}
				}
				setState(116);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
				
					String elements = new String();
					while( !((Enumeration_typeContext)getInvokingContext(4)).cases.isEmpty() ){
						String e = ((Enumeration_typeContext)getInvokingContext(4)).cases.remove(0);
						String eMinus = e.substring(0,1).toLowerCase() + e.substring(1); //Pasamos la primer mayuscula a minuscula ya que setlog asi lo precisa
						elements = elements.concat(eMinus);
						
						memory.put(e, eMinus);
						types.put(e, (((Enumeration_typeContext)_localctx).d!=null?_input.getText(((Enumeration_typeContext)_localctx).d.start,((Enumeration_typeContext)_localctx).d.stop):null));
						
						if (!((Enumeration_typeContext)getInvokingContext(4)).cases.isEmpty()){
							elements = elements.concat(",");
						}
					}
					if (types.get((((Enumeration_typeContext)_localctx).d!=null?_input.getText(((Enumeration_typeContext)_localctx).d.start,((Enumeration_typeContext)_localctx).d.stop):null)) == null) {
						//Le asigno un nombre al conjunto
						String newVarName = newVar((((Enumeration_typeContext)_localctx).d!=null?_input.getText(((Enumeration_typeContext)_localctx).d.start,((Enumeration_typeContext)_localctx).d.stop):null));
						memory.put((((Enumeration_typeContext)_localctx).d!=null?_input.getText(((Enumeration_typeContext)_localctx).d.start,((Enumeration_typeContext)_localctx).d.stop):null), newVarName);
						types.put((((Enumeration_typeContext)_localctx).d!=null?_input.getText(((Enumeration_typeContext)_localctx).d.start,((Enumeration_typeContext)_localctx).d.stop):null), "EnumerationType:" + newVarName + ":{" + elements + "}");
						print(newVarName + " = {" + elements + "}");
					}
				
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

	public static class SchemaTextContext extends ParserRuleContext {
		public PredicateContext predicate(int i) {
			return getRuleContext(PredicateContext.class,i);
		}
		public List<TerminalNode> NL() { return getTokens(ExprParser.NL); }
		public List<PredicateContext> predicate() {
			return getRuleContexts(PredicateContext.class);
		}
		public DeclPartContext declPart() {
			return getRuleContext(DeclPartContext.class,0);
		}
		public TerminalNode NL(int i) {
			return getToken(ExprParser.NL, i);
		}
		public SchemaTextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_schemaText; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterSchemaText(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitSchemaText(this);
		}
	}

	public final SchemaTextContext schemaText() throws RecognitionException {
		SchemaTextContext _localctx = new SchemaTextContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_schemaText);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119); match(NL);
			setState(123);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				setState(120); declPart();
				setState(121); match(NL);
				}
				break;
			}
			setState(127);
			_la = _input.LA(1);
			if (_la==28) {
				{
				setState(125); match(28);
				setState(126); match(NL);
				}
			}

			setState(134);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 2) | (1L << 3) | (1L << 4) | (1L << 5) | (1L << 8) | (1L << 10) | (1L << 11) | (1L << 12) | (1L << 13) | (1L << 16) | (1L << 20) | (1L << 21) | (1L << 25) | (1L << 26) | (1L << 30) | (1L << 37) | (1L << 40) | (1L << 43) | (1L << 46) | (1L << 49) | (1L << 51) | (1L << 57) | (1L << 60) | (1L << POWER))) != 0) || ((((_la - 74)) & ~0x3f) == 0 && ((1L << (_la - 74)) & ((1L << (NAME - 74)) | (1L << (NUM - 74)) | (1L << (DECORATION - 74)) | (1L << (SETSTART - 74)) | (1L << (LISTSTART - 74)))) != 0)) {
				{
				{
				setState(129); predicate(0);
				setState(130); match(NL);
				}
				}
				setState(136);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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

	public static class DeclPartContext extends ParserRuleContext {
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public List<TerminalNode> NL() { return getTokens(ExprParser.NL); }
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public TerminalNode NL(int i) {
			return getToken(ExprParser.NL, i);
		}
		public DeclPartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declPart; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterDeclPart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitDeclPart(this);
		}
	}

	public final DeclPartContext declPart() throws RecognitionException {
		DeclPartContext _localctx = new DeclPartContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_declPart);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(137); declaration();
			setState(142);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(138);
					_la = _input.LA(1);
					if ( !(_la==56 || _la==NL) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					setState(139); declaration();
					}
					} 
				}
				setState(144);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			}
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

	public static class DeclarationContext extends ParserRuleContext {
		public ArrayList<String> vars;;
		public DeclNameContext a;
		public DeclNameContext b;
		public ExpressionContext expression;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<DeclNameContext> declName() {
			return getRuleContexts(DeclNameContext.class);
		}
		public DeclNameContext declName(int i) {
			return getRuleContext(DeclNameContext.class,i);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitDeclaration(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_declaration);
		((DeclarationContext)getInvokingContext(7)).vars =  new ArrayList<String>();
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145); ((DeclarationContext)_localctx).a = declName();
			((DeclarationContext)getInvokingContext(7)).vars.add((((DeclarationContext)_localctx).a!=null?_input.getText(((DeclarationContext)_localctx).a.start,((DeclarationContext)_localctx).a.stop):null));
			setState(153);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==38) {
				{
				{
				setState(147); match(38);
				setState(148); ((DeclarationContext)_localctx).b = declName();
				((DeclarationContext)getInvokingContext(7)).vars.add((((DeclarationContext)_localctx).b!=null?_input.getText(((DeclarationContext)_localctx).b.start,((DeclarationContext)_localctx).b.stop):null));
				}
				}
				setState(155);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(156); match(41);
			setState(157); ((DeclarationContext)_localctx).expression = expression(0);

					//Para cada variable realizamos el procesamiento
					while( !((DeclarationContext)getInvokingContext(7)).vars.isEmpty() ) {

						String var = ((DeclarationContext)getInvokingContext(7)).vars.remove(0);

						if (tipoSchema == 0)
							zVars.put(var, null); //Marcamos la variable como variable Z, a la cual posiblemente se le deba asignarsele un valor

						String newVarName = newVar(var);
						if (tipoSchema == 0)
							memory.put(var, newVarName);
						if (modoSetExpression==1)
							setExpressionVars.put(var, newVarName);
						
						String expType = types.get((((DeclarationContext)_localctx).expression!=null?_input.getText(((DeclarationContext)_localctx).expression.start,((DeclarationContext)_localctx).expression.stop):null));
						expType = typeInfo(newVarName, expType);
						
						/*
						//Chequeo si es un tipo basico, ej [ACCNUM], ya que estos no se imprimen en typeInfo
						String t = types.get(expType);
						if (t != null && t.startsWith("BasicType"))
							print(newVarName + " in " + expType);
						*/
						
						if (tipoSchema == 0)
							types.put(var, expType);
						else { //La agregamos como variable del esquema
							schemaTypeVars.put(var,expType);
						}
					}
				
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

	public static class DeclNameContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(ExprParser.NAME, 0); }
		public DeclNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterDeclName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitDeclName(this);
		}
	}

	public final DeclNameContext declName() throws RecognitionException {
		DeclNameContext _localctx = new DeclNameContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_declName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160); match(NAME);
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

	public static class PredicateContext extends ParserRuleContext {
		public int _p;
		public ExpressionContext e1;
		public ExpressionContext e2;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode DECORATION() { return getToken(ExprParser.DECORATION, 0); }
		public PredicateContext predicate(int i) {
			return getRuleContext(PredicateContext.class,i);
		}
		public List<PredicateContext> predicate() {
			return getRuleContexts(PredicateContext.class);
		}
		public PredicateContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public PredicateContext(ParserRuleContext parent, int invokingState, int _p) {
			super(parent, invokingState);
			this._p = _p;
		}
		@Override public int getRuleIndex() { return RULE_predicate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterPredicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitPredicate(this);
		}
	}

	public final PredicateContext predicate(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		PredicateContext _localctx = new PredicateContext(_ctx, _parentState, _p);
		PredicateContext _prevctx = _localctx;
		int _startState = 18;
		enterRecursionRule(_localctx, RULE_predicate);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(285);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				{
				setState(163); ((PredicateContext)_localctx).e1 = expression(0);
				setState(164); match(45);
				setState(165); ((PredicateContext)_localctx).e2 = expression(0);

						String a, b;
						a = memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						
						//Si b es una lista, debo convertirla
						b = convertToSet((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null), b);
						
						print(a + " in " + b);
					
				}
				break;

			case 2:
				{
				setState(180);
				switch (_input.LA(1)) {
				case 3:
				case 4:
				case 5:
				case 10:
				case 11:
				case 12:
				case 13:
				case 16:
				case 20:
				case 21:
				case 25:
				case 26:
				case 30:
				case 37:
				case 40:
				case 43:
				case 46:
				case 51:
				case 57:
				case 60:
				case POWER:
				case NAME:
				case NUM:
				case DECORATION:
				case SETSTART:
				case LISTSTART:
					{
					setState(168); ((PredicateContext)_localctx).e1 = expression(0);
					setState(169); match(15);
					setState(171);
					switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
					case 1:
						{
						setState(170); match(DECORATION);
						}
						break;
					}
					setState(173); ((PredicateContext)_localctx).e2 = expression(0);
					}
					break;
				case 2:
					{
					setState(175); match(2);
					setState(176); ((PredicateContext)_localctx).e1 = expression(0);
					setState(177); match(45);
					setState(178); ((PredicateContext)_localctx).e2 = expression(0);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}

						String a, b;
						a = memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						
						//Si b es una lista, debo convertirla
						b = convertToSet((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null), b);
						
						print(a + " nin " + b);
					
				}
				break;

			case 3:
				{
				setState(184); ((PredicateContext)_localctx).e1 = expression(0);
				setState(185); match(7);
				setState(187);
				switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
				case 1:
					{
					setState(186); match(DECORATION);
					}
					break;
				}
				setState(189); ((PredicateContext)_localctx).e2 = expression(0);

						String a, b;
						a = memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						print(a + " < " + b);
					
				}
				break;

			case 4:
				{
				setState(192); ((PredicateContext)_localctx).e1 = expression(0);
				setState(193); match(58);
				setState(195);
				switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
				case 1:
					{
					setState(194); match(DECORATION);
					}
					break;
				}
				setState(197); ((PredicateContext)_localctx).e2 = expression(0);

						String a, b;
						a = memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						print(a + " > " + b);
					
				}
				break;

			case 5:
				{
				setState(200); ((PredicateContext)_localctx).e1 = expression(0);
				setState(201); match(23);
				setState(203);
				switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
				case 1:
					{
					setState(202); match(DECORATION);
					}
					break;
				}
				setState(205); ((PredicateContext)_localctx).e2 = expression(0);

						String a, b;
						a = memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						
						print(a + " =< " + b);
					
				}
				break;

			case 6:
				{
				setState(208); ((PredicateContext)_localctx).e1 = expression(0);
				setState(209); match(29);
				setState(211);
				switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
				case 1:
					{
					setState(210); match(DECORATION);
					}
					break;
				}
				setState(213); ((PredicateContext)_localctx).e2 = expression(0);

						String a, b;
						a = memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						print(a + " =< " + b);
					
				}
				break;

			case 7:
				{
				setState(216); ((PredicateContext)_localctx).e1 = expression(0);
				setState(217); match(22);
				setState(218); ((PredicateContext)_localctx).e2 = expression(0);

						String a, b;
						a = memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						print(a + " = " + b);
					
				}
				break;

			case 8:
				{
				setState(221); ((PredicateContext)_localctx).e1 = expression(0);
				setState(222); match(32);
				setState(224);
				switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
				case 1:
					{
					setState(223); match(DECORATION);
					}
					break;
				}
				setState(226); ((PredicateContext)_localctx).e2 = expression(0);

						String a, b;
						a = memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						
						//Si a es una lista, debo convertirla
						a = convertToSet((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null), a);
						//Si b es una lista, debo convertirla
						b = convertToSet((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null), b);
						
						print("dsubset(" + a + "," + b + ")");
					
				}
				break;

			case 9:
				{
				setState(229); match(2);
				setState(230); ((PredicateContext)_localctx).e1 = expression(0);
				setState(231); match(32);
				setState(233);
				switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
				case 1:
					{
					setState(232); match(DECORATION);
					}
					break;
				}
				setState(235); ((PredicateContext)_localctx).e2 = expression(0);

						String a, b;
						a = memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						
						//Si a es una lista, debo convertirla
						a = convertToSet((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null), a);
						//Si b es una lista, debo convertirla
						b = convertToSet((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null), b);
						
						print("dnsubset(" + a + "," + b + ")");
					
				}
				break;

			case 10:
				{
				setState(238); ((PredicateContext)_localctx).e1 = expression(0);
				setState(239); match(52);
				setState(241);
				switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
				case 1:
					{
					setState(240); match(DECORATION);
					}
					break;
				}
				setState(243); ((PredicateContext)_localctx).e2 = expression(0);

						String a, b;
						a = memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						
						//Si a es una lista, debo convertirla
						a = convertToSet((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null), a);
						//Si b es una lista, debo convertirla
						b = convertToSet((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null), b);
						
						print("dssubset(" + a + "," + b + ")");
					
				}
				break;

			case 11:
				{
				setState(246); match(2);
				setState(247); ((PredicateContext)_localctx).e1 = expression(0);
				setState(248); match(52);
				setState(250);
				switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
				case 1:
					{
					setState(249); match(DECORATION);
					}
					break;
				}
				setState(252); ((PredicateContext)_localctx).e2 = expression(0);

						String a, b;
						a = memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						
						//Si a es una lista, debo convertirla
						a = convertToSet((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null), a);
						//Si b es una lista, debo convertirla
						b = convertToSet((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null), b);
						
						String c = memory.get( (((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null) + "\\cap" + (((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						if (c == null) {
							c = newVar();
							memory.put( (((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null) + "\\cap" + (((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null), c);
							print("dinters(" + a + "," + b + "," + c + ")");
							String type = types.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
							if (isSequence(getType(type)))
								type = "\\power(\\nat\\cross(" + leftAndRightTypes(type).get(1) + "))";
							types.put((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null) + "\\cap" + (((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null), type);
							//typeInfo(c, type);
						}
						
						print(c + " neq " + a);
					
				}
				break;

			case 12:
				{
				setState(255); ((PredicateContext)_localctx).e1 = expression(0);
				setState(256); match(27);
				setState(258);
				switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
				case 1:
					{
					setState(257); match(DECORATION);
					}
					break;
				}
				setState(260); ((PredicateContext)_localctx).e2 = expression(0);

						String a, b;
						a = memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						
						if (!getType(types.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null))).equals(getType(types.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null))))) {
							//Si a es una lista, debo convertirla
							a = convertToSet((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null), a);
							//Si b es una lista, debo convertirla
							b = convertToSet((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null), b);
						}
							
						
						print(a + " neq " + b);
					
				}
				break;

			case 13:
				{
				setState(263); ((PredicateContext)_localctx).e1 = expression(0);
				setState(264); match(24);
				setState(266);
				switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
				case 1:
					{
					setState(265); match(DECORATION);
					}
					break;
				}
				setState(268); ((PredicateContext)_localctx).e2 = expression(0);

						String a, b;
						a = memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						print("prolog_call(append(" + a + ",_," + b + "))");
					
				}
				break;

			case 14:
				{
				setState(271); ((PredicateContext)_localctx).e1 = expression(0);
				setState(272); match(35);
				setState(274);
				switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
				case 1:
					{
					setState(273); match(DECORATION);
					}
					break;
				}
				setState(276); ((PredicateContext)_localctx).e2 = expression(0);

						String a, b;
						a = memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						print("prolog_call(append(_," + a + "," + b + "))");
					
				}
				break;

			case 15:
				{
				setState(279); match(40);
				setState(280); predicate(0);
				setState(281); match(18);
				}
				break;

			case 16:
				{
				setState(283); match(49);
				}
				break;

			case 17:
				{
				setState(284); match(8);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(301);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(299);
					switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
					case 1:
						{
						_localctx = new PredicateContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_predicate);
						setState(287);
						if (!(4 >= _localctx._p)) throw new FailedPredicateException(this, "4 >= $_p");
						setState(288); match(53);
						setState(289); predicate(5);
						}
						break;

					case 2:
						{
						_localctx = new PredicateContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_predicate);
						setState(290);
						if (!(3 >= _localctx._p)) throw new FailedPredicateException(this, "3 >= $_p");
						setState(291); match(55);
						setState(292); predicate(4);
						}
						break;

					case 3:
						{
						_localctx = new PredicateContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_predicate);
						setState(293);
						if (!(2 >= _localctx._p)) throw new FailedPredicateException(this, "2 >= $_p");
						setState(294); match(42);
						setState(295); predicate(3);
						}
						break;

					case 4:
						{
						_localctx = new PredicateContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_predicate);
						setState(296);
						if (!(1 >= _localctx._p)) throw new FailedPredicateException(this, "1 >= $_p");
						setState(297); match(17);
						setState(298); predicate(2);
						}
						break;
					}
					} 
				}
				setState(303);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
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

	public static class ExpressionContext extends ParserRuleContext {
		public int _p;
		public ArrayList<String> elements = new ArrayList<String>();
		public String setlogName = "";
		public String zName = "";
		public String operator = "";
		public String newVarName1 = "";
		public String newVarName2 = "";
		public ExpressionContext e;
		public ExpressionContext e1;
		public ExpressionContext a;
		public PreContext pre;
		public ExpressionContext expression;
		public RefNameContext refName;
		public Token NUM;
		public Token SETSTART;
		public ExpressionContext b;
		public Token SETEND;
		public DeclPartContext declPart;
		public PredicateContext predicate;
		public ExpressionContext c;
		public Token n;
		public Token DECORATION;
		public Token LISTSTART;
		public Token LISTEND;
		public Token CROSS;
		public ExpressionContext e2;
		public Token IN_FUN_65;
		public Token IN_FUN_60;
		public Token IN_FUN_40;
		public Token IN_FUN_30;
		public Token IN_FUN_20;
		public Token IN_FUN_10;
		public Token IN_FUN_5;
		public PostContext post;
		public Token IMGSTART;
		public Token IMGEND;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public PredicateContext predicate() {
			return getRuleContext(PredicateContext.class,0);
		}
		public TerminalNode NAME(int i) {
			return getToken(ExprParser.NAME, i);
		}
		public TerminalNode SETEND() { return getToken(ExprParser.SETEND, 0); }
		public TerminalNode POWER() { return getToken(ExprParser.POWER, 0); }
		public TerminalNode IN_FUN_60() { return getToken(ExprParser.IN_FUN_60, 0); }
		public TerminalNode IN_FUN_40() { return getToken(ExprParser.IN_FUN_40, 0); }
		public TerminalNode IN_FUN_20() { return getToken(ExprParser.IN_FUN_20, 0); }
		public TerminalNode IN_FUN_45() { return getToken(ExprParser.IN_FUN_45, 0); }
		public TerminalNode LISTSTART() { return getToken(ExprParser.LISTSTART, 0); }
		public TerminalNode CROSS() { return getToken(ExprParser.CROSS, 0); }
		public TerminalNode NUM() { return getToken(ExprParser.NUM, 0); }
		public TerminalNode IN_FUN_65() { return getToken(ExprParser.IN_FUN_65, 0); }
		public TerminalNode SELECTION() { return getToken(ExprParser.SELECTION, 0); }
		public TerminalNode SETSTART() { return getToken(ExprParser.SETSTART, 0); }
		public PostContext post() {
			return getRuleContext(PostContext.class,0);
		}
		public List<TerminalNode> NAME() { return getTokens(ExprParser.NAME); }
		public DeclPartContext declPart() {
			return getRuleContext(DeclPartContext.class,0);
		}
		public TerminalNode IN_FUN_50() { return getToken(ExprParser.IN_FUN_50, 0); }
		public TerminalNode IN_FUN_5() { return getToken(ExprParser.IN_FUN_5, 0); }
		public TerminalNode DECORATION() { return getToken(ExprParser.DECORATION, 0); }
		public TerminalNode IN_FUN_10() { return getToken(ExprParser.IN_FUN_10, 0); }
		public PreContext pre() {
			return getRuleContext(PreContext.class,0);
		}
		public TerminalNode IN_FUN_30() { return getToken(ExprParser.IN_FUN_30, 0); }
		public RefNameContext refName() {
			return getRuleContext(RefNameContext.class,0);
		}
		public TerminalNode IMGEND() { return getToken(ExprParser.IMGEND, 0); }
		public TerminalNode IMGSTART() { return getToken(ExprParser.IMGSTART, 0); }
		public TerminalNode LISTEND() { return getToken(ExprParser.LISTEND, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public ExpressionContext(ParserRuleContext parent, int invokingState, int _p) {
			super(parent, invokingState);
			this._p = _p;
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitExpression(this);
		}
	}

	public final ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState, _p);
		ExpressionContext _prevctx = _localctx;
		int _startState = 20;
		enterRecursionRule(_localctx, RULE_expression);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(419);
			switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
			case 1:
				{
				setState(305); ((ExpressionContext)_localctx).pre = pre();
				setState(306); ((ExpressionContext)_localctx).e = ((ExpressionContext)_localctx).expression = expression(26);

						if (memory.get((((ExpressionContext)_localctx).pre!=null?_input.getText(((ExpressionContext)_localctx).pre.start,((ExpressionContext)_localctx).pre.stop):null) + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null)) == null) {
						
							String a;
							a = memory.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null));
							String newVarName = newVar();
						
							if ((((ExpressionContext)_localctx).pre!=null?_input.getText(((ExpressionContext)_localctx).pre.start,((ExpressionContext)_localctx).pre.stop):null).equals("\\#")){
								memory.put("\\#" + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), newVarName);
								types.put("\\#" + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), "\\nat");
								if (modoSetExpression != 0 )
									setExpressionVars.put("\\#" + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), newVarName);
								
								String type = getType(types.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null)));
								if (isSequence(type))
									print("prolog_call(length(" + a + "," + newVarName + "))");
								else
									print("size(" + a + "," + newVarName + ")");					
							
								print(newVarName + " in " + printInfo("\\nat", true));
							}
							else if ((((ExpressionContext)_localctx).pre!=null?_input.getText(((ExpressionContext)_localctx).pre.start,((ExpressionContext)_localctx).pre.stop):null).equals("\\dom")){
								memory.put("\\dom" + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), newVarName);
								if (modoSetExpression != 0 )
									setExpressionVars.put("\\dom" + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), newVarName);
								types.put("\\dom" + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), "\\power(" + getChildType(types.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null)), 0) + ")");
							
								String e = memory.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null));
							
								//Chequeamos si e es una lista, estas son tratadas de forma diferente
								String type = getType(types.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null)));
								if (isSequence(type))
									print("ddom_list(" + e + "," + newVarName + ")");
								else
									print("dom(" + e + "," + newVarName + ")");
							}
							else if ((((ExpressionContext)_localctx).pre!=null?_input.getText(((ExpressionContext)_localctx).pre.start,((ExpressionContext)_localctx).pre.stop):null).equals("\\ran")){
								memory.put("\\ran" + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), newVarName);
								if (modoSetExpression != 0 )
									setExpressionVars.put("\\ran" + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), newVarName);
								types.put("\\ran" + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), "\\power(" + getChildType(types.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null)), 1) + ")");
							
								String e = memory.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null));
							
								//Chequeamos si e es una lista, estas son tratadas de forma diferente
								String type = getType(types.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null)));
								if (isSequence(type))
									print("list_to_set(" + e + "," + newVarName + ")");
								else
									print("ran(" + e + "," + newVarName + ")");
							}
							else if ((((ExpressionContext)_localctx).pre!=null?_input.getText(((ExpressionContext)_localctx).pre.start,((ExpressionContext)_localctx).pre.stop):null).startsWith("seq_{1}")) {
								String eType = types.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null));
								if (isBasic(eType))
									eType = (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null);
						
								types.put((((ExpressionContext)_localctx).pre!=null?_input.getText(((ExpressionContext)_localctx).pre.start,((ExpressionContext)_localctx).pre.stop):null) + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), (((ExpressionContext)_localctx).pre!=null?_input.getText(((ExpressionContext)_localctx).pre.start,((ExpressionContext)_localctx).pre.stop):null) + eType);
							}
							else if ((((ExpressionContext)_localctx).pre!=null?_input.getText(((ExpressionContext)_localctx).pre.start,((ExpressionContext)_localctx).pre.stop):null).equals("\\seq")) {
								String eType = types.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null));
								if (isBasic(eType))
									eType = (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null);
						
								types.put("\\seq" + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), "\\seq" + eType);
							}
							else if ((((ExpressionContext)_localctx).pre!=null?_input.getText(((ExpressionContext)_localctx).pre.start,((ExpressionContext)_localctx).pre.stop):null).equals("\\bigcup")){
								memory.put("\\bigcup" + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), newVarName);
								if (modoSetExpression != 0 )
									setExpressionVars.put("\\bigcup" + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), newVarName);
								types.put("\\bigcup" + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), getChildType(types.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null)), 0));
							
								String e = memory.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null));
								print("bun(" + e + "," + newVarName + ")");
							}
							else if ((((ExpressionContext)_localctx).pre!=null?_input.getText(((ExpressionContext)_localctx).pre.start,((ExpressionContext)_localctx).pre.stop):null).equals("\\bigcap")){
								memory.put("\\bigcap" + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), newVarName);
								if (modoSetExpression != 0 )
									setExpressionVars.put("\\bigcap" + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), newVarName);
								types.put("\\bigcap" + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), getChildType(types.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null)), 0));
							
								String e = memory.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null));
								print("bdinters(" + e + "," + newVarName + ")");
							}
							else if ((((ExpressionContext)_localctx).pre!=null?_input.getText(((ExpressionContext)_localctx).pre.start,((ExpressionContext)_localctx).pre.stop):null).startsWith("min")){
								memory.put((((ExpressionContext)_localctx).pre!=null?_input.getText(((ExpressionContext)_localctx).pre.start,((ExpressionContext)_localctx).pre.stop):null) + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), newVarName);
								if (modoSetExpression != 0 )
									setExpressionVars.put((((ExpressionContext)_localctx).pre!=null?_input.getText(((ExpressionContext)_localctx).pre.start,((ExpressionContext)_localctx).pre.stop):null) + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), newVarName);
								types.put((((ExpressionContext)_localctx).pre!=null?_input.getText(((ExpressionContext)_localctx).pre.start,((ExpressionContext)_localctx).pre.stop):null) + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), getChildType(types.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null)), 0));
							
								String e = memory.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null));
								print("prolog_call(min(" + e + "," + newVarName + "))");
							}
							else if ((((ExpressionContext)_localctx).pre!=null?_input.getText(((ExpressionContext)_localctx).pre.start,((ExpressionContext)_localctx).pre.stop):null).startsWith("max")){
								memory.put((((ExpressionContext)_localctx).pre!=null?_input.getText(((ExpressionContext)_localctx).pre.start,((ExpressionContext)_localctx).pre.stop):null) + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), newVarName);
								if (modoSetExpression != 0 )
									setExpressionVars.put((((ExpressionContext)_localctx).pre!=null?_input.getText(((ExpressionContext)_localctx).pre.start,((ExpressionContext)_localctx).pre.stop):null) + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), newVarName);
								types.put((((ExpressionContext)_localctx).pre!=null?_input.getText(((ExpressionContext)_localctx).pre.start,((ExpressionContext)_localctx).pre.stop):null) + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), getChildType(types.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null)), 0));
							
								String e = memory.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null));
								print("max(" + e + "," + newVarName + ")");
							}
							else if ((((ExpressionContext)_localctx).pre!=null?_input.getText(((ExpressionContext)_localctx).pre.start,((ExpressionContext)_localctx).pre.stop):null).startsWith("rev")){
								print("prolog_call(reverse(" + a + "," + newVarName + "))");
								memory.put((((ExpressionContext)_localctx).pre!=null?_input.getText(((ExpressionContext)_localctx).pre.start,((ExpressionContext)_localctx).pre.stop):null) + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), newVarName);
								String type = types.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null));
								types.put((((ExpressionContext)_localctx).pre!=null?_input.getText(((ExpressionContext)_localctx).pre.start,((ExpressionContext)_localctx).pre.stop):null) + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), type);
								typeInfo(newVarName, type);
								if (modoSetExpression != 0 )
									setExpressionVars.put((((ExpressionContext)_localctx).pre!=null?_input.getText(((ExpressionContext)_localctx).pre.start,((ExpressionContext)_localctx).pre.stop):null) + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), newVarName);
							}
							else if ((((ExpressionContext)_localctx).pre!=null?_input.getText(((ExpressionContext)_localctx).pre.start,((ExpressionContext)_localctx).pre.stop):null).startsWith("head")){
								print("nth1(1," + a + "," + newVarName + ")");
								memory.put((((ExpressionContext)_localctx).pre!=null?_input.getText(((ExpressionContext)_localctx).pre.start,((ExpressionContext)_localctx).pre.stop):null) + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), newVarName);
								String type = getChildType(types.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null)), 0);
								types.put((((ExpressionContext)_localctx).pre!=null?_input.getText(((ExpressionContext)_localctx).pre.start,((ExpressionContext)_localctx).pre.stop):null) + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), type);
								typeInfo(newVarName, type);
								if (modoSetExpression != 0 )
									setExpressionVars.put((((ExpressionContext)_localctx).pre!=null?_input.getText(((ExpressionContext)_localctx).pre.start,((ExpressionContext)_localctx).pre.stop):null) + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), newVarName);
							}
							else if ((((ExpressionContext)_localctx).pre!=null?_input.getText(((ExpressionContext)_localctx).pre.start,((ExpressionContext)_localctx).pre.stop):null).startsWith("last")){
								print("prolog_call(last(" + a + "," + newVarName + "))");
								memory.put((((ExpressionContext)_localctx).pre!=null?_input.getText(((ExpressionContext)_localctx).pre.start,((ExpressionContext)_localctx).pre.stop):null) + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), newVarName);
								String type = getChildType(types.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null)), 0);
								types.put((((ExpressionContext)_localctx).pre!=null?_input.getText(((ExpressionContext)_localctx).pre.start,((ExpressionContext)_localctx).pre.stop):null) + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), type);
								typeInfo(newVarName, type);
								if (modoSetExpression != 0 )
									setExpressionVars.put((((ExpressionContext)_localctx).pre!=null?_input.getText(((ExpressionContext)_localctx).pre.start,((ExpressionContext)_localctx).pre.stop):null) + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), newVarName);
							}
							else if ((((ExpressionContext)_localctx).pre!=null?_input.getText(((ExpressionContext)_localctx).pre.start,((ExpressionContext)_localctx).pre.stop):null).startsWith("tail")){
								print("prolog_call(drop(1," + a + "," + newVarName + "))");
								memory.put((((ExpressionContext)_localctx).pre!=null?_input.getText(((ExpressionContext)_localctx).pre.start,((ExpressionContext)_localctx).pre.stop):null) + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), newVarName);
								String type = types.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null));
								types.put((((ExpressionContext)_localctx).pre!=null?_input.getText(((ExpressionContext)_localctx).pre.start,((ExpressionContext)_localctx).pre.stop):null) + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), type);
								typeInfo(newVarName, type);
								if (modoSetExpression != 0 )
									setExpressionVars.put((((ExpressionContext)_localctx).pre!=null?_input.getText(((ExpressionContext)_localctx).pre.start,((ExpressionContext)_localctx).pre.stop):null) + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), newVarName);
							}
							else if ((((ExpressionContext)_localctx).pre!=null?_input.getText(((ExpressionContext)_localctx).pre.start,((ExpressionContext)_localctx).pre.stop):null).startsWith("front")){
								String n = newVar();
								print("prolog_call(length(" + a + "," + n + "))");
								print(n + " in " + printInfo("\\nat", true));
								print("prolog_call(take(" + n + "-1" + "," + a + "," + newVarName + "))");
								memory.put((((ExpressionContext)_localctx).pre!=null?_input.getText(((ExpressionContext)_localctx).pre.start,((ExpressionContext)_localctx).pre.stop):null) + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), newVarName);
								String type = types.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null));
								types.put((((ExpressionContext)_localctx).pre!=null?_input.getText(((ExpressionContext)_localctx).pre.start,((ExpressionContext)_localctx).pre.stop):null) + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), type);
								typeInfo(newVarName, type);
								if (modoSetExpression != 0 )
									setExpressionVars.put((((ExpressionContext)_localctx).pre!=null?_input.getText(((ExpressionContext)_localctx).pre.start,((ExpressionContext)_localctx).pre.stop):null) + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), newVarName);
							}
							else if ((((ExpressionContext)_localctx).pre!=null?_input.getText(((ExpressionContext)_localctx).pre.start,((ExpressionContext)_localctx).pre.stop):null).startsWith("squash")){
								print("squash(" + a + "," + newVarName + ")");
								memory.put((((ExpressionContext)_localctx).pre!=null?_input.getText(((ExpressionContext)_localctx).pre.start,((ExpressionContext)_localctx).pre.stop):null) + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), newVarName);
								String type = types.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null));
								ArrayList<String> leftAndRight = leftAndRightTypes(type);
								type = "\\seq(" + leftAndRight.get(1) + ")";
								types.put((((ExpressionContext)_localctx).pre!=null?_input.getText(((ExpressionContext)_localctx).pre.start,((ExpressionContext)_localctx).pre.stop):null) + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), type);
								typeInfo(newVarName, type);
								if (modoSetExpression != 0 )
									setExpressionVars.put((((ExpressionContext)_localctx).pre!=null?_input.getText(((ExpressionContext)_localctx).pre.start,((ExpressionContext)_localctx).pre.stop):null) + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), newVarName);
							}
						}
					
				}
				break;

			case 2:
				{
				setState(309); match(POWER);
				setState(310); ((ExpressionContext)_localctx).e = ((ExpressionContext)_localctx).expression = expression(24);

						String eType = types.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null));
						if (isBasic(eType))
							eType = (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null);
					
						types.put(_input.getText(_localctx.start, _input.LT(-1)), "\\power" + eType );
					
				}
				break;

			case 3:
				{
				setState(313); ((ExpressionContext)_localctx).refName = refName();
				}
				break;

			case 4:
				{
				setState(314); ((ExpressionContext)_localctx).NUM = match(NUM);

						if (memory.get((((ExpressionContext)_localctx).NUM!=null?((ExpressionContext)_localctx).NUM.getText():null)) == null) {
							memory.put((((ExpressionContext)_localctx).NUM!=null?((ExpressionContext)_localctx).NUM.getText():null), (((ExpressionContext)_localctx).NUM!=null?((ExpressionContext)_localctx).NUM.getText():null));
							types.put((((ExpressionContext)_localctx).NUM!=null?((ExpressionContext)_localctx).NUM.getText():null), "\\num");
						}
					
				}
				break;

			case 5:
				{
				setState(316); match(11);

						if (memory.get("\\emptyset") == null) {
							memory.put("\\emptyset", "{}");
							types.put("\\emptyset", "\\power(" + "generic" + ")");
						}
					
				}
				break;

			case 6:
				{
				setState(318); ((ExpressionContext)_localctx).SETSTART = match(SETSTART);
				setState(322);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 3) | (1L << 4) | (1L << 5) | (1L << 10) | (1L << 11) | (1L << 12) | (1L << 13) | (1L << 16) | (1L << 20) | (1L << 21) | (1L << 25) | (1L << 26) | (1L << 30) | (1L << 37) | (1L << 40) | (1L << 43) | (1L << 46) | (1L << 51) | (1L << 57) | (1L << 60) | (1L << POWER))) != 0) || ((((_la - 74)) & ~0x3f) == 0 && ((1L << (_la - 74)) & ((1L << (NAME - 74)) | (1L << (NUM - 74)) | (1L << (DECORATION - 74)) | (1L << (SETSTART - 74)) | (1L << (LISTSTART - 74)))) != 0)) {
					{
					setState(319); ((ExpressionContext)_localctx).a = ((ExpressionContext)_localctx).expression = expression(0);
					_localctx.elements.add((((ExpressionContext)_localctx).a!=null?_input.getText(((ExpressionContext)_localctx).a.start,((ExpressionContext)_localctx).a.stop):null));
					}
				}

				setState(330);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==38) {
					{
					{
					setState(324); match(38);
					setState(325); ((ExpressionContext)_localctx).b = ((ExpressionContext)_localctx).expression = expression(0);
					_localctx.elements.add((((ExpressionContext)_localctx).b!=null?_input.getText(((ExpressionContext)_localctx).b.start,((ExpressionContext)_localctx).b.stop):null));
					}
					}
					setState(332);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(333); ((ExpressionContext)_localctx).SETEND = match(SETEND);
					
						((ExpressionContext)_localctx).zName =  (((ExpressionContext)_localctx).SETSTART!=null?((ExpressionContext)_localctx).SETSTART.getText():null);
						String type = new String();
						//Llenamos elements y ponemos cada expression en la memory
						while( !_localctx.elements.isEmpty() ){
							String e = _localctx.elements.remove(0);
							if (type.equals("")) {
								type = types.get(e);
							}
							((ExpressionContext)_localctx).zName =  _localctx.zName.concat(e);
							//guardamos tambien las traducciones del conjunto
							((ExpressionContext)_localctx).setlogName =  _localctx.setlogName.concat(memory.get(e));
							
							if (!_localctx.elements.isEmpty()){
								((ExpressionContext)_localctx).zName =  _localctx.zName + ",";
								((ExpressionContext)_localctx).setlogName =  _localctx.setlogName + ",";
							}
						}
						((ExpressionContext)_localctx).zName =  _localctx.zName + (((ExpressionContext)_localctx).SETEND!=null?((ExpressionContext)_localctx).SETEND.getText():null);
						if (memory.get(_localctx.zName) == null) {
							memory.put(_localctx.zName, "{" + _localctx.setlogName + "}");
							if (_localctx.setlogName.equals(""))
								types.put(_localctx.zName, "\\power(" + "generic" + ")");
							else
								types.put(_localctx.zName, "\\power(" + type + ")");
						}
					
				}
				break;

			case 7:
				{
				setState(335); ((ExpressionContext)_localctx).SETSTART = match(SETSTART);
				modoSetExpression=1; setExpressionDecl = ""; setExpressionPred = ""; setExpressionExpr = ""; setExpressionVars = new HashMap();
				setState(337); ((ExpressionContext)_localctx).declPart = declPart();
				((ExpressionContext)_localctx).zName =  (((ExpressionContext)_localctx).SETSTART!=null?((ExpressionContext)_localctx).SETSTART.getText():null) + (((ExpressionContext)_localctx).declPart!=null?_input.getText(((ExpressionContext)_localctx).declPart.start,((ExpressionContext)_localctx).declPart.stop):null);
				setState(344);
				_la = _input.LA(1);
				if (_la==33) {
					{
					setState(339); match(33);
					modoSetExpression=2;
					setState(341); ((ExpressionContext)_localctx).predicate = predicate(0);
					((ExpressionContext)_localctx).zName =  _localctx.zName.concat("|" + (((ExpressionContext)_localctx).predicate!=null?_input.getText(((ExpressionContext)_localctx).predicate.start,((ExpressionContext)_localctx).predicate.stop):null));
					}
				}

				setState(351);
				_la = _input.LA(1);
				if (_la==19) {
					{
					setState(346); match(19);
					modoSetExpression=3;
					setState(348); ((ExpressionContext)_localctx).c = ((ExpressionContext)_localctx).expression = expression(0);
					((ExpressionContext)_localctx).zName =  _localctx.zName.concat("@" + (((ExpressionContext)_localctx).c!=null?_input.getText(((ExpressionContext)_localctx).c.start,((ExpressionContext)_localctx).c.stop):null));
					}
				}

				setState(353); ((ExpressionContext)_localctx).SETEND = match(SETEND);
				modoSetExpression=0; ((ExpressionContext)_localctx).zName =  _localctx.zName.concat((((ExpressionContext)_localctx).SETEND!=null?((ExpressionContext)_localctx).SETEND.getText():null));

						if (memory.get(_localctx.zName)==null) {
						
							// Probando eliminar la variable extra y usar '=' en vez de 'is' cuando corresponde
							String varName = memory.get((((ExpressionContext)_localctx).c!=null?_input.getText(((ExpressionContext)_localctx).c.start,((ExpressionContext)_localctx).c.stop):null));
							String op = getType(types.get((((ExpressionContext)_localctx).c!=null?_input.getText(((ExpressionContext)_localctx).c.start,((ExpressionContext)_localctx).c.stop):null)));
							if (isNumeric(op))
								op = " is ";
							else
								op = " = ";
							
							boolean needsNewName = false;
							if ((varName == null) || (varName.matches("^.*[^a-zA-Z0-9 ].*"))) { //Si es nulo o tiene caracteres que no son letras o numeros
								varName = newVar();
								needsNewName = true;
							}
						
							((ExpressionContext)_localctx).setlogName =  "";
							((ExpressionContext)_localctx).newVarName2 =  newVar();
							
							((ExpressionContext)_localctx).setlogName =  _localctx.setlogName.concat("{ " + varName + " :exists([");
							
							Collection<String> values = setExpressionVars.values();
							if (!needsNewName)
								values.remove(varName);
							
							Iterator<String> valuesIt = values.iterator();
							while (valuesIt.hasNext()){
								((ExpressionContext)_localctx).setlogName =   _localctx.setlogName.concat(valuesIt.next());
								if (valuesIt.hasNext()) ((ExpressionContext)_localctx).setlogName =   _localctx.setlogName.concat(",");
							}
						
							String content = setExpressionDecl + setExpressionPred + setExpressionExpr;
							content = content.substring(content.indexOf('&') + 1);
							if (!content.equals("") && needsNewName)
								content = content.concat(" & ");
							
							((ExpressionContext)_localctx).setlogName =  _localctx.setlogName.concat("], " + content);
							if (needsNewName)
								((ExpressionContext)_localctx).setlogName =  _localctx.setlogName.concat(varName + op + memory.get((((ExpressionContext)_localctx).c!=null?_input.getText(((ExpressionContext)_localctx).c.start,((ExpressionContext)_localctx).c.stop):null)));
							((ExpressionContext)_localctx).setlogName =  _localctx.setlogName.concat(")" + " }");
						
							memory.put(_localctx.zName, _localctx.newVarName2);
							types.put(_localctx.zName, "\\power(" + types.get((((ExpressionContext)_localctx).c!=null?_input.getText(((ExpressionContext)_localctx).c.start,((ExpressionContext)_localctx).c.stop):null)) + ")"); //REVISAR!!!
							print(_localctx.newVarName2 + " = " + _localctx.setlogName);
							
							Iterator<String> keysIt = setExpressionVars.keySet().iterator();
							while (keysIt.hasNext()){
								String var = keysIt.next();
								memory.remove(var);
								keysIt.remove();
								//setExpressionVars.remove(var);
							}
						}
					
				}
				break;

			case 8:
				{
				setState(357); match(51);
				setExpressionVars = new HashMap();
				setState(366); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(359); ((ExpressionContext)_localctx).n = match(NAME);
					setState(360); match(61);
					setState(361); ((ExpressionContext)_localctx).e = ((ExpressionContext)_localctx).expression = expression(0);
					setExpressionVars.put((((ExpressionContext)_localctx).n!=null?((ExpressionContext)_localctx).n.getText():null), (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null));
					setState(364);
					_la = _input.LA(1);
					if (_la==38) {
						{
						setState(363); match(38);
						}
					}

					}
					}
					setState(368); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NAME );
				setState(370); match(47);

						((ExpressionContext)_localctx).setlogName =  "[";
						List<String> sortedVars = new ArrayList<String>(setExpressionVars.keySet());
						java.util.Collections.sort(sortedVars);
						
						int i = 0;
						while( i < sortedVars.size() ){
							String value = setExpressionVars.get(sortedVars.get(i));

							((ExpressionContext)_localctx).setlogName =  _localctx.setlogName.concat(value);
							
							if (i+1 < sortedVars.size()){
								((ExpressionContext)_localctx).setlogName =  _localctx.setlogName.concat(",");
							}
							i++;
						}
						
						((ExpressionContext)_localctx).setlogName =  _localctx.setlogName.concat("]");
						
						if (memory.get(_input.getText(_localctx.start, _input.LT(-1))) == null) {
							memory.put(_input.getText(_localctx.start, _input.LT(-1)), _localctx.setlogName);
							types.put(_input.getText(_localctx.start, _input.LT(-1)), "\\seq(" + "generic" + ")");
						}
					
				}
				break;

			case 9:
				{
				setState(374);
				_la = _input.LA(1);
				if (_la==DECORATION) {
					{
					setState(373); ((ExpressionContext)_localctx).DECORATION = match(DECORATION);
					}
				}

				setState(376); ((ExpressionContext)_localctx).LISTSTART = match(LISTSTART);
				setState(380);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 3) | (1L << 4) | (1L << 5) | (1L << 10) | (1L << 11) | (1L << 12) | (1L << 13) | (1L << 16) | (1L << 20) | (1L << 21) | (1L << 25) | (1L << 26) | (1L << 30) | (1L << 37) | (1L << 40) | (1L << 43) | (1L << 46) | (1L << 51) | (1L << 57) | (1L << 60) | (1L << POWER))) != 0) || ((((_la - 74)) & ~0x3f) == 0 && ((1L << (_la - 74)) & ((1L << (NAME - 74)) | (1L << (NUM - 74)) | (1L << (DECORATION - 74)) | (1L << (SETSTART - 74)) | (1L << (LISTSTART - 74)))) != 0)) {
					{
					setState(377); ((ExpressionContext)_localctx).a = ((ExpressionContext)_localctx).expression = expression(0);
					_localctx.elements.add((((ExpressionContext)_localctx).a!=null?_input.getText(((ExpressionContext)_localctx).a.start,((ExpressionContext)_localctx).a.stop):null));
					}
				}

				setState(388);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==38) {
					{
					{
					setState(382); match(38);
					setState(383); ((ExpressionContext)_localctx).b = ((ExpressionContext)_localctx).expression = expression(0);
					_localctx.elements.add((((ExpressionContext)_localctx).b!=null?_input.getText(((ExpressionContext)_localctx).b.start,((ExpressionContext)_localctx).b.stop):null));
					}
					}
					setState(390);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(391); ((ExpressionContext)_localctx).LISTEND = match(LISTEND);
					
						if ((((ExpressionContext)_localctx).DECORATION!=null?((ExpressionContext)_localctx).DECORATION.getText():null) != null)
							((ExpressionContext)_localctx).zName =  (((ExpressionContext)_localctx).DECORATION!=null?((ExpressionContext)_localctx).DECORATION.getText():null);
						((ExpressionContext)_localctx).zName =  _localctx.zName.concat((((ExpressionContext)_localctx).LISTSTART!=null?((ExpressionContext)_localctx).LISTSTART.getText():null));
						String type = new String();
						//Llenamos elements y ponemos cada expression en la memory
						while( !_localctx.elements.isEmpty() ){
							String e = _localctx.elements.remove(0);
							if (type.equals("")) {
								type = types.get(e);
							}
							((ExpressionContext)_localctx).zName =  _localctx.zName.concat(e);
							//guardamos tambien las traducciones del conjunto
							((ExpressionContext)_localctx).setlogName =  _localctx.setlogName.concat(memory.get(e));
							
							if (!_localctx.elements.isEmpty()){
								((ExpressionContext)_localctx).zName =  _localctx.zName + ",";
								((ExpressionContext)_localctx).setlogName =  _localctx.setlogName + ",";
							}
						}
						((ExpressionContext)_localctx).zName =  _localctx.zName + (((ExpressionContext)_localctx).LISTEND!=null?((ExpressionContext)_localctx).LISTEND.getText():null);
						if (memory.get(_localctx.zName) == null) {
							memory.put(_localctx.zName, "[" + _localctx.setlogName + "]");
							if (_localctx.setlogName.equals(""))
								types.put(_localctx.zName, "\\seq(" + "generic" + ")");
							else
								types.put(_localctx.zName, "\\seq(" + type + ")");
						}
					
				}
				break;

			case 10:
				{
				setState(393); match(40);
				setState(394); ((ExpressionContext)_localctx).a = ((ExpressionContext)_localctx).expression = expression(0);
				_localctx.elements.add((((ExpressionContext)_localctx).a!=null?_input.getText(((ExpressionContext)_localctx).a.start,((ExpressionContext)_localctx).a.stop):null));
				setState(400); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(396); match(38);
					setState(397); ((ExpressionContext)_localctx).b = ((ExpressionContext)_localctx).expression = expression(0);
					_localctx.elements.add((((ExpressionContext)_localctx).b!=null?_input.getText(((ExpressionContext)_localctx).b.start,((ExpressionContext)_localctx).b.stop):null));
					}
					}
					setState(402); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==38 );
				setState(404); match(18);
					
						((ExpressionContext)_localctx).zName =  "(";
						String type = new String();
						//Llenamos elements y ponemos cada expression en la memory
						while( !_localctx.elements.isEmpty() ){
							String e = _localctx.elements.remove(0);
							if (type.equals(""))
								type = "(" + types.get(e) + ")";
							else
								type = type.concat("\\cross(" + types.get(e) + ")");
								 
							((ExpressionContext)_localctx).zName =  _localctx.zName.concat(e);
							//guardamos tambien las traducciones del conjunto
							((ExpressionContext)_localctx).setlogName =  _localctx.setlogName.concat(memory.get(e));
							
							if (!_localctx.elements.isEmpty()){
								((ExpressionContext)_localctx).zName =  _localctx.zName + ",";
								((ExpressionContext)_localctx).setlogName =  _localctx.setlogName + ",";
							}
						}
						((ExpressionContext)_localctx).zName =  _localctx.zName + ")";
						if (memory.get(_localctx.zName) == null) {
							memory.put(_localctx.zName, "[" + _localctx.setlogName + "]");
							types.put(_localctx.zName, type);
						}
					
				}
				break;

			case 11:
				{
				setState(407); match(40);
				setState(408); ((ExpressionContext)_localctx).e = ((ExpressionContext)_localctx).expression = expression(0);
				setState(409); match(18);

						String a = memory.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null));
						
						//Chequeo el nombre para ver si se trata de una sola variable, en ese caso no guardo en la memoria
						//los parentesis, en otro caso si
						
						if (a != null) { //Si no estoy en la parte de declaracion
							Pattern p = Pattern.compile("[^a-zA-Z0-9_]");
							boolean hasSpecialChar = p.matcher(a).find();
							
							if (hasSpecialChar){
								memory.put("(" + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null) + ")", "(" + a + ")");
								if (types.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null)) != null) {
									types.put("(" + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null) + ")", types.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null)));
								}
							}
							else {
								memory.put("(" + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null) + ")", a);
								if (types.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null)) != null) {
									types.put("(" + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null) + ")", types.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null)));
								}
							}
						} else  //Si estoy en la parte de declaracion
							if (types.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null)) != null)
								types.put("(" + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null) + ")", "(" + types.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null)) + ")");
					
				}
				break;

			case 12:
				{
				setState(412); match(26);
				setState(413); match(9);
					
						printInfo(_input.getText(_localctx.start, _input.LT(-1)), false);	
					
				}
				break;

			case 13:
				{
				setState(415); match(26);
					
						printInfo(_input.getText(_localctx.start, _input.LT(-1)), false);	
					
				}
				break;

			case 14:
				{
				setState(417); match(60);
					
						printInfo(_input.getText(_localctx.start, _input.LT(-1)), false);	
					
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(502);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,48,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(500);
					switch ( getInterpreter().adaptivePredict(_input,47,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(421);
						if (!(23 >= _localctx._p)) throw new FailedPredicateException(this, "23 >= $_p");
						setState(422); ((ExpressionContext)_localctx).CROSS = match(CROSS);
						setState(423); ((ExpressionContext)_localctx).e2 = ((ExpressionContext)_localctx).expression = expression(24);

						          		String unfoldedType = "";

						          		String exp = (((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null);
						          		((ExpressionContext)_localctx).zName =  _localctx.zName.concat(exp);
						          		String expType = types.get(exp);
						          		if (isBasic(expType))
						          			unfoldedType = unfoldedType.concat(exp);
						          		else
						          			unfoldedType = unfoldedType.concat(expType);
						          				
						          		((ExpressionContext)_localctx).zName =  _localctx.zName.concat((((ExpressionContext)_localctx).CROSS!=null?((ExpressionContext)_localctx).CROSS.getText():null));
						          		unfoldedType = unfoldedType.concat((((ExpressionContext)_localctx).CROSS!=null?((ExpressionContext)_localctx).CROSS.getText():null));
						          			
						          		exp = (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null);
						          		((ExpressionContext)_localctx).zName =  _localctx.zName.concat(exp);
						          		expType = types.get(exp);
						          		if (isBasic(expType))
						          			unfoldedType = unfoldedType.concat(exp);
						          		else
						          			unfoldedType = unfoldedType.concat(expType);
						          			
						          		/*
						          		//Para cada exp realizamos el procesamiento
						          		while( !((ExpressionContext)getInvokingContext(10)).elements.isEmpty() ) {
						          			String exp = ((ExpressionContext)getInvokingContext(10)).elements.remove(0);
						          			
						          			((ExpressionContext)_localctx).zName =  _localctx.zName.concat(exp);
						          			
						          			String expType = types.get(exp);
						          			if (isBasic(expType))
						          				unfoldedType = unfoldedType.concat(exp);
						          			else
						          				unfoldedType = unfoldedType.concat(expType);
						          				
						          			if (!((ExpressionContext)getInvokingContext(10)).elements.isEmpty()) {
						          				((ExpressionContext)_localctx).zName =  _localctx.zName.concat((((ExpressionContext)_localctx).CROSS!=null?((ExpressionContext)_localctx).CROSS.getText():null));
						          				unfoldedType = unfoldedType.concat((((ExpressionContext)_localctx).CROSS!=null?((ExpressionContext)_localctx).CROSS.getText():null));
						          			}
						          		}*/
						          		
						          		types.put(_localctx.zName, unfoldedType);
						          	
						}
						break;

					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(426);
						if (!(22 >= _localctx._p)) throw new FailedPredicateException(this, "22 >= $_p");
						setState(427); ((ExpressionContext)_localctx).IN_FUN_65 = match(IN_FUN_65);
						setState(428); ((ExpressionContext)_localctx).e2 = ((ExpressionContext)_localctx).expression = expression(23);

						          		String a, b;
						          		a = memory.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null));
						          		b = memory.get((((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null));
						          		
						          		//Si a es una lista, debo convertirla
						          		a = convertToSet((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null), a);
						          		//Si b es una lista, debo convertirla
						          		b = convertToSet((((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), b);
						          		
						          		if (memory.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + (((ExpressionContext)_localctx).IN_FUN_65!=null?((ExpressionContext)_localctx).IN_FUN_65.getText():null) + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null)) == null) {
						          		
						          			String newVarName = newVar();
						          		
						          			if ((((ExpressionContext)_localctx).IN_FUN_65!=null?((ExpressionContext)_localctx).IN_FUN_65.getText():null).equals("\\dres")){
						          				print("dres(" + a + "," + b + "," + newVarName + ")");
						          				memory.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\dres" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          				String type2 = types.get((((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null));
						          				ArrayList<String> leftAndRight = leftAndRightTypes(type2);
						          				String type = "\\power((" + leftAndRight.get(0) + ")\\cross(" + leftAndRight.get(1) + "))";
						          				types.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\dres" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), type);
						          				typeInfo(newVarName, type);
						          				if (modoSetExpression != 0 )
						          					setExpressionVars.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\dres" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          			}
						          			else if ((((ExpressionContext)_localctx).IN_FUN_65!=null?((ExpressionContext)_localctx).IN_FUN_65.getText():null).equals("\\ndres")){
						          				print("ndres(" + a + "," + b + "," + newVarName + ")");
						          				memory.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\ndres" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          				String type2 = types.get((((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null));
						          				ArrayList<String> leftAndRight = leftAndRightTypes(type2);
						          				String type = "\\power((" + leftAndRight.get(0) + ")\\cross(" + leftAndRight.get(1) + "))";
						          				types.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\ndres" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), type);
						          				typeInfo(newVarName, type);
						          				if (modoSetExpression != 0 )
						          					setExpressionVars.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\ndres" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          			}
						          		}
						          	
						}
						break;

					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(431);
						if (!(21 >= _localctx._p)) throw new FailedPredicateException(this, "21 >= $_p");
						setState(432); ((ExpressionContext)_localctx).IN_FUN_60 = match(IN_FUN_60);
						setState(433); ((ExpressionContext)_localctx).e2 = ((ExpressionContext)_localctx).expression = expression(22);

						          		String a, b;
						          		a = memory.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null));
						          		b = memory.get((((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null));
						          		
						          		//Si a es una lista, debo convertirla
						          		a = convertToSet((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null), a);
						          		//Si b es una lista, debo convertirla
						          		b = convertToSet((((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), b);
						          		
						          		if (memory.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + (((ExpressionContext)_localctx).IN_FUN_60!=null?((ExpressionContext)_localctx).IN_FUN_60.getText():null) + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null)) == null) {
						          		
						          			String newVarName = newVar();
						          		
						          			if ((((ExpressionContext)_localctx).IN_FUN_60!=null?((ExpressionContext)_localctx).IN_FUN_60.getText():null).equals("\\rres")){
						          				print("rres(" + b + "," + a + "," + newVarName + ")");
						          				memory.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\rres" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          				String type1 = types.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null));
						          				ArrayList<String> leftAndRight = leftAndRightTypes(type1);
						          				String type = "\\power((" + leftAndRight.get(0) + ")\\cross(" + leftAndRight.get(1) + "))";
						          				types.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\rres" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), type);
						          				typeInfo(newVarName, type);
						          				if (modoSetExpression != 0 )
						          					setExpressionVars.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\rres" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          			}
						          			else if ((((ExpressionContext)_localctx).IN_FUN_60!=null?((ExpressionContext)_localctx).IN_FUN_60.getText():null).equals("\\nrres")){
						          				print("nrres(" + b + "," + a + "," + newVarName + ")");
						          				memory.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\nrres" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          				String type1 = types.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null));
						          				ArrayList<String> leftAndRight = leftAndRightTypes(type1);
						          				String type = "\\power((" + leftAndRight.get(0) + ")\\cross(" + leftAndRight.get(1) + "))";
						          				types.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\nrres" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), type);
						          				typeInfo(newVarName, type);
						          				if (modoSetExpression != 0 )
						          					setExpressionVars.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\nrres" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          			}
						          		}
						          	
						}
						break;

					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(436);
						if (!(20 >= _localctx._p)) throw new FailedPredicateException(this, "20 >= $_p");
						setState(437); match(IN_FUN_50);
						setState(438); ((ExpressionContext)_localctx).e2 = ((ExpressionContext)_localctx).expression = expression(21);

						          		String a, b;
						          		a = memory.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null));
						          		b = memory.get((((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null));
						          		
						          		//Si a es una lista, debo convertirla
						          		a = convertToSet((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null), a);
						          		//Si b es una lista, debo convertirla
						          		b = convertToSet((((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), b);
						          		
						          		if (memory.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\oplus" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null)) == null) {
						          		
						          			String newVarName = newVar();
						          		
						          			print("oplus(" + a + "," + b + "," + newVarName + ")");
						          			memory.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\oplus" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          			String type1 = types.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null));
						          			ArrayList<String> leftAndRight = leftAndRightTypes(type1);
						          			String type = "\\power((" + leftAndRight.get(0) + ")\\cross(" + leftAndRight.get(1) + "))";
						          			types.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\oplus" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), type);
						          			typeInfo(newVarName, type);
						          			if (modoSetExpression != 0 )
						          				setExpressionVars.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\oplus" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          		}
						          	
						}
						break;

					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(441);
						if (!(19 >= _localctx._p)) throw new FailedPredicateException(this, "19 >= $_p");
						setState(442); match(IN_FUN_45);
						setState(443); ((ExpressionContext)_localctx).e2 = ((ExpressionContext)_localctx).expression = expression(20);

						          		String a, b;
						          		
						          		a = memory.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null));
						          		b = memory.get((((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null));

						          		if (memory.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\extract" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null)) == null) {
						          		
						          			String newVarName = newVar();

						          			print("extract(" + a + "," + b + "," + newVarName + ")");
						          			memory.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\extract" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          			String type = types.get((((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null));
						          			types.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\extract" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), type);
						          			typeInfo(newVarName, type);
						          			if (modoSetExpression != 0 )
						          				setExpressionVars.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\extract" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          		}
						          	
						}
						break;

					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(446);
						if (!(18 >= _localctx._p)) throw new FailedPredicateException(this, "18 >= $_p");
						setState(447); ((ExpressionContext)_localctx).IN_FUN_40 = match(IN_FUN_40);
						setState(448); ((ExpressionContext)_localctx).e2 = ((ExpressionContext)_localctx).expression = expression(19);

						          		String a, b;
						          		
						          		a = memory.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null));
						          		b = memory.get((((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null));

						          		if (memory.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + (((ExpressionContext)_localctx).IN_FUN_40!=null?((ExpressionContext)_localctx).IN_FUN_40.getText():null) + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null)) == null) {
						          		
						          			String newVarName = newVar();
						          			Boolean isNumeric = false; 
						          		
						          			if ((((ExpressionContext)_localctx).IN_FUN_40!=null?((ExpressionContext)_localctx).IN_FUN_40.getText():null).equals("*")){
						          				print( newVarName + " is " + a + "*" + b );
						          				memory.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "*" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          				if (modoSetExpression != 0 )
						          					setExpressionVars.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "*" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          				isNumeric = true;
						          			}
						          			else if ((((ExpressionContext)_localctx).IN_FUN_40!=null?((ExpressionContext)_localctx).IN_FUN_40.getText():null).equals("\\div")) {
						          				print( newVarName + " is div(" + a + "," + b + ")" );
						          				memory.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\div" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          				if (modoSetExpression != 0 )
						          					setExpressionVars.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\div" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          				isNumeric = true;
						          			}
						          			else if ((((ExpressionContext)_localctx).IN_FUN_40!=null?((ExpressionContext)_localctx).IN_FUN_40.getText():null).equals("\\mod")){
						          				print( newVarName + " is mod(" + a + "," + b + ")" );
						          				memory.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\mod" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          				if (modoSetExpression != 0 )
						          					setExpressionVars.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\mod" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          				isNumeric = true;
						          			}
						          			else if ((((ExpressionContext)_localctx).IN_FUN_40!=null?((ExpressionContext)_localctx).IN_FUN_40.getText():null).equals("\\cap")){
						          				//Si a es una lista, debo convertirla
						          				a = convertToSet((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null), a);
						          				//Si b es una lista, debo convertirla
						          				b = convertToSet((((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), b);
						          								
						          				print("dinters(" + a + "," + b + "," + newVarName + ")");
						          				memory.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\cap" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          				String type = types.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null));
						          				if (isSequence(getType(type)))
						          					type = "\\power(\\nat\\cross(" + leftAndRightTypes(type).get(1) + "))";
						          				types.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\cap" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), type);
						          				//typeInfo(newVarName, type);
						          				if (modoSetExpression != 0 )
						          					setExpressionVars.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\cap" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          			}
						          			else if ((((ExpressionContext)_localctx).IN_FUN_40!=null?((ExpressionContext)_localctx).IN_FUN_40.getText():null).equals("\\comp")){
						          				//Si a es una lista, debo convertirla
						          				a = convertToSet((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null), a);
						          				//Si b es una lista, debo convertirla
						          				b = convertToSet((((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), b);
						          						
						          				print("comp(" + a + "," + b + "," + newVarName + ")");
						          				memory.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\comp" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          				String type1 = types.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null));
						          				String type2 = types.get((((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null));
						          				String type = "\\power((" + leftAndRightTypes(type1).get(0) + ")\\cross(" + leftAndRightTypes(type2).get(1) + "))";
						          				types.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\comp" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), type);
						          				typeInfo(newVarName, type);
						          				if (modoSetExpression != 0 )
						          					setExpressionVars.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\comp" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          			}
						          			else if ((((ExpressionContext)_localctx).IN_FUN_40!=null?((ExpressionContext)_localctx).IN_FUN_40.getText():null).equals("\\circ")){
						          				//Si a es una lista, debo convertirla
						          				a = convertToSet((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null), a);
						          				//Si b es una lista, debo convertirla
						          				b = convertToSet((((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), b);
						          				
						          				print("circ(" + a + "," + b + "," + newVarName + ")");
						          				memory.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\circ" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          				String type1 = types.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null));
						          				type1 = leftAndRightTypes(type1).get(1);
						          				String type = "\\power((" + type1 + ")\\cross(" + type1 + "))";
						          				types.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\circ" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), type);
						          				typeInfo(newVarName, type);
						          				if (modoSetExpression != 0 )
						          					setExpressionVars.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\circ" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          			}
						          			else if ((((ExpressionContext)_localctx).IN_FUN_40!=null?((ExpressionContext)_localctx).IN_FUN_40.getText():null).equals("\\filter")){
						          				print("filter(" + a + "," + b + "," + newVarName + ")");
						          				memory.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\filter" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          				String type = types.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null));
						          				types.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\filter" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), type);
						          				typeInfo(newVarName, type);
						          				if (modoSetExpression != 0 )
						          					setExpressionVars.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\filter" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          			}
						          			
						          			if (isNumeric) {
						          				print(newVarName + " in " + printInfo("\\num", true));
						          				types.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + (((ExpressionContext)_localctx).IN_FUN_40!=null?((ExpressionContext)_localctx).IN_FUN_40.getText():null) + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), "\\num");
						          			}
						          		}
						          	
						}
						break;

					case 7:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(451);
						if (!(17 >= _localctx._p)) throw new FailedPredicateException(this, "17 >= $_p");
						setState(452); ((ExpressionContext)_localctx).IN_FUN_30 = match(IN_FUN_30);
						setState(453); ((ExpressionContext)_localctx).e2 = ((ExpressionContext)_localctx).expression = expression(18);

						          		String a, b;
						          		a = memory.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null));
						          		b = memory.get((((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null));
						          		
						          		if (memory.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + (((ExpressionContext)_localctx).IN_FUN_30!=null?((ExpressionContext)_localctx).IN_FUN_30.getText():null) + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null)) == null) {
						          		
						          			String newVarName = newVar();
						          			Boolean isNumeric = false; 
						          			
						          		
						          			if ((((ExpressionContext)_localctx).IN_FUN_30!=null?((ExpressionContext)_localctx).IN_FUN_30.getText():null).equals("+")){
						          				print( newVarName + " is " + a + "+" + b );
						          				memory.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "+" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          				if (modoSetExpression != 0 )
						          					setExpressionVars.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "+" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          				isNumeric = true;
						          			}
						          			else if ((((ExpressionContext)_localctx).IN_FUN_30!=null?((ExpressionContext)_localctx).IN_FUN_30.getText():null).equals("-")) {
						          				print( newVarName + " is " + a + "-" + b );
						          				memory.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "-" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          				if (modoSetExpression != 0 )
						          					setExpressionVars.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "-" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          				isNumeric = true;
						          			}
						          			else if ((((ExpressionContext)_localctx).IN_FUN_30!=null?((ExpressionContext)_localctx).IN_FUN_30.getText():null).equals("\\cup")){
						          			
						          				//Si a es una lista, debo convertirla
						          				a = convertToSet((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null), a);
						          				//Si b es una lista, debo convertirla
						          				b = convertToSet((((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), b);
						          				
						          				print("dun(" + a + "," + b + "," + newVarName + ")");
						          				memory.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\cup" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          				String type = types.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null));
						          				if (isSequence(getType(type)))
						          					type = "\\power(\\nat\\cross(" + leftAndRightTypes(type).get(1) + "))";
						          				types.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\cup" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), type);
						          				typeInfo(newVarName, type);
						          				if (modoSetExpression != 0 )
						          					setExpressionVars.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\cup" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          			}
						          			else if ((((ExpressionContext)_localctx).IN_FUN_30!=null?((ExpressionContext)_localctx).IN_FUN_30.getText():null).equals("\\setminus")){
						          				//Si a es una lista, debo convertirla
						          				a = convertToSet((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null), a);
						          				//Si b es una lista, debo convertirla
						          				b = convertToSet((((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), b);
						          		
						          				print("diff(" + a + "," + b + "," + newVarName + ")");
						          				memory.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\setminus" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          				String type = types.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null));
						          				if (isSequence(getType(type)))
						          					type = "\\power(\\nat\\cross(" + leftAndRightTypes(type).get(1) + "))";
						          				types.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\setminus" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), type);
						          				typeInfo(newVarName, type);
						          				if (modoSetExpression != 0 )
						          					setExpressionVars.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\setminus" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          			}
						          			else if ((((ExpressionContext)_localctx).IN_FUN_30!=null?((ExpressionContext)_localctx).IN_FUN_30.getText():null).equals("\\cat")){
						          				print("prolog_call(append(" + a + "," + b + "," + newVarName + "))");
						          				memory.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\cat" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          				String type = types.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null));
						          				types.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\cat" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), type);
						          				typeInfo(newVarName, type);
						          				if (modoSetExpression != 0 )
						          					setExpressionVars.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\cat" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          			}
						          			
						          			if (isNumeric) {
						          				print(newVarName + " in " + printInfo("\\num", true));
						          				types.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + (((ExpressionContext)_localctx).IN_FUN_30!=null?((ExpressionContext)_localctx).IN_FUN_30.getText():null) + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), "\\num");
						          			}
						          		}
						          	
						}
						break;

					case 8:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(456);
						if (!(16 >= _localctx._p)) throw new FailedPredicateException(this, "16 >= $_p");
						setState(457); ((ExpressionContext)_localctx).IN_FUN_20 = match(IN_FUN_20);
						setState(458); ((ExpressionContext)_localctx).e2 = ((ExpressionContext)_localctx).expression = expression(17);

						          		String a, b;
						          		a = memory.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null));
						          		b = memory.get((((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null));
						          		if (memory.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + (((ExpressionContext)_localctx).IN_FUN_20!=null?((ExpressionContext)_localctx).IN_FUN_20.getText():null) + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null)) == null) {
						          			String newVarName = newVar();
						          			memory.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + (((ExpressionContext)_localctx).IN_FUN_20!=null?((ExpressionContext)_localctx).IN_FUN_20.getText():null) + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          			types.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + (((ExpressionContext)_localctx).IN_FUN_20!=null?((ExpressionContext)_localctx).IN_FUN_20.getText():null) + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), memory.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null)) + (((ExpressionContext)_localctx).IN_FUN_20!=null?((ExpressionContext)_localctx).IN_FUN_20.getText():null) + memory.get((((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null)));
						          			if (modoSetExpression != 0 )
						          				setExpressionVars.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + (((ExpressionContext)_localctx).IN_FUN_20!=null?((ExpressionContext)_localctx).IN_FUN_20.getText():null) + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          			print(newVarName + " = int(" + a + "," + b + ")");
						          		}
						          	
						}
						break;

					case 9:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(461);
						if (!(15 >= _localctx._p)) throw new FailedPredicateException(this, "15 >= $_p");
						setState(462); ((ExpressionContext)_localctx).IN_FUN_10 = match(IN_FUN_10);
						setState(463); ((ExpressionContext)_localctx).e2 = ((ExpressionContext)_localctx).expression = expression(16);

						          		String a, b;
						          		a = memory.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null));
						          		b = memory.get((((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null));
						          		memory.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + (((ExpressionContext)_localctx).IN_FUN_10!=null?((ExpressionContext)_localctx).IN_FUN_10.getText():null) + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), "[" + a + "," + b + "]");
						          		types.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + (((ExpressionContext)_localctx).IN_FUN_10!=null?((ExpressionContext)_localctx).IN_FUN_10.getText():null) + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), types.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null)) + "\\cross" + types.get((((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null)));
						          	
						}
						break;

					case 10:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(466);
						if (!(14 >= _localctx._p)) throw new FailedPredicateException(this, "14 >= $_p");
						setState(467); ((ExpressionContext)_localctx).IN_FUN_5 = match(IN_FUN_5);
						setState(468); ((ExpressionContext)_localctx).b = ((ExpressionContext)_localctx).expression = expression(15);

						          		//Guardo el tipo
						          		String aType = types.get((((ExpressionContext)_localctx).a!=null?_input.getText(((ExpressionContext)_localctx).a.start,((ExpressionContext)_localctx).a.stop):null));
						          		if (isBasic(aType)) {
						          			aType = (((ExpressionContext)_localctx).a!=null?_input.getText(((ExpressionContext)_localctx).a.start,((ExpressionContext)_localctx).a.stop):null);
						          		}
						          		String bType = types.get((((ExpressionContext)_localctx).b!=null?_input.getText(((ExpressionContext)_localctx).b.start,((ExpressionContext)_localctx).b.stop):null));
						          		if (isBasic(bType))
						          			bType = (((ExpressionContext)_localctx).b!=null?_input.getText(((ExpressionContext)_localctx).b.start,((ExpressionContext)_localctx).b.stop):null);
						          		
						          		types.put((((ExpressionContext)_localctx).a!=null?_input.getText(((ExpressionContext)_localctx).a.start,((ExpressionContext)_localctx).a.stop):null) + (((ExpressionContext)_localctx).IN_FUN_5!=null?((ExpressionContext)_localctx).IN_FUN_5.getText():null) + (((ExpressionContext)_localctx).b!=null?_input.getText(((ExpressionContext)_localctx).b.start,((ExpressionContext)_localctx).b.stop):null), aType + (((ExpressionContext)_localctx).IN_FUN_5!=null?((ExpressionContext)_localctx).IN_FUN_5.getText():null) + bType );
						          	
						}
						break;

					case 11:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						_localctx.e = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(471);
						if (!(28 >= _localctx._p)) throw new FailedPredicateException(this, "28 >= $_p");
						setState(472); ((ExpressionContext)_localctx).post = post();

						          		String a;
						          		a = memory.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null));
						          		String op = (((ExpressionContext)_localctx).post!=null?_input.getText(((ExpressionContext)_localctx).post.start,((ExpressionContext)_localctx).post.stop):null);
						          		
						          		if (memory.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null) + op) == null) {
						          		
						          			String newVarName = newVar();
						          		
						          			if (op.startsWith("\\inv")){
						          				//Si a es una lista, debo convertirla
						          				a = convertToSet((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), a);
						          			
						          				print("inv(" + newVarName + "," + a + ")");
						          				memory.put((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null) + op, newVarName);
						          				String type = types.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null));
						          				if (isSequence(getType(type)))
						          					type = "\\power(\\nat\\cross(" + leftAndRightTypes(type).get(1) + "))";
						          				type = invertType(type); 
						          				types.put((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null) + op, type);
						          				typeInfo(newVarName, type);
						          				if (modoSetExpression != 0 )
						          					setExpressionVars.put((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null) + op, newVarName);
						          			}
						          		}
						          	
						}
						break;

					case 12:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						_localctx.e = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(475);
						if (!(27 >= _localctx._p)) throw new FailedPredicateException(this, "27 >= $_p");
						setState(476); match(SELECTION);
						setState(479);
						switch (_input.LA(1)) {
						case NAME:
							{
							setState(477); ((ExpressionContext)_localctx).refName = refName();
							}
							break;
						case NUM:
							{
							setState(478); ((ExpressionContext)_localctx).NUM = match(NUM);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}

						          		String n;
						          		if ((((ExpressionContext)_localctx).refName!=null?_input.getText(((ExpressionContext)_localctx).refName.start,((ExpressionContext)_localctx).refName.stop):null) == null)
						          			n = (((ExpressionContext)_localctx).NUM!=null?((ExpressionContext)_localctx).NUM.getText():null);
						          		else
						          			n = (((ExpressionContext)_localctx).refName!=null?_input.getText(((ExpressionContext)_localctx).refName.start,((ExpressionContext)_localctx).refName.stop):null);
						          			
						          		if (memory.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null) + "." + n) == null) {
						          		
						          			String eType = types.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null));
						          			if (!eType.startsWith("SchemaType:")) //Debo llegar a obtener la lista con las variables
						          				eType = types.get(eType);
						          			
						          			if (eType.startsWith("SchemaType:")) {
						          				String schemaVars = eType.split(":", 3)[2];
						          				//Obtengo el indice de la variable e2 dentro de la lista de variables del tipo schema
						          				//Primero obtenemos la lista de variables
						          				schemaVars = schemaVars.substring(1, schemaVars.length()-1);
						          				String[] vars = schemaVars.split(",");
						          				//Buscamos la posicion de la variable
						          				int position = 1;
						          				while (!vars[position-1].contains(n + ":")) //Se resta 1 porque en setlog empiezan en 1, no en 0 como en java
						          					position++;
						          				//Creamos una nueva variable
						          				String newVarName = newVar();
						          				//Vemos su tipo
						          				String type = vars[position-1].substring(n.length()+1);
						          				memory.put((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null) + "." + n, newVarName);
						          				if (modoSetExpression != 0 )
						          					setExpressionVars.put((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null) + "." + n, newVarName);
						          				types.put((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null) + "." + n, type);
						          				print("nth1(" + position + "," + memory.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null)) + "," + newVarName + ")");
						          				
						          				typeInfo(newVarName, type);
						          				
						          			}
						          			else { //Se pide el elemento de una tupla
						          				String newVarName = newVar();
						          				memory.put((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null) + "." + n, newVarName);
						          				eType = leftAndRightTypes(eType).get(Integer.parseInt(n)-1);
						          				types.put((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null) + "." + n, eType); //Arreglar
						          				print("nth1(" + n + "," + memory.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null)) + "," + newVarName + ")");
						          			}
						          		}
						          	
						}
						break;

					case 13:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(482);
						if (!(25 >= _localctx._p)) throw new FailedPredicateException(this, "25 >= $_p");
						setState(484);
						_la = _input.LA(1);
						if (_la==DECORATION) {
							{
							setState(483); ((ExpressionContext)_localctx).DECORATION = match(DECORATION);
							}
						}

						setState(486); match(40);
						setState(487); ((ExpressionContext)_localctx).e2 = ((ExpressionContext)_localctx).expression = expression(0);
						setState(488); match(18);

						          		String a, b;
						          		a = memory.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null));
						          		b = memory.get((((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null));
						          		String op = "";
						          		if ((((ExpressionContext)_localctx).DECORATION!=null?((ExpressionContext)_localctx).DECORATION.getText():null) != null) op = "~";
						          		
						          		//Si a es una lista, debo convertirla
						          		a = convertToSet((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null), a);
						          		
						          		if (memory.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + op + "(" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null) + ")") == null) {
						          			String newVarName = newVar();
						          			memory.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + op + "(" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null) + ")", newVarName);
						          			
						          			if (modoSetExpression != 0 )
						          				setExpressionVars.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + op + "(" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null) + ")", newVarName);

						          			String type1 = types.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null));
						          			//getType(type1);
						          			String newVarType = leftAndRightTypes(type1).get(1);
						          			types.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + op + "(" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null) + ")", newVarType);
						          			print("apply(" + a + "," + b + "," + newVarName + ")");
						          			
						          			//Imprimimos la informacion del tipo de la variable
						          			typeInfo(newVarName, newVarType);
						          		}
						          	
						}
						break;

					case 14:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(491);
						if (!(13 >= _localctx._p)) throw new FailedPredicateException(this, "13 >= $_p");
						setState(492); ((ExpressionContext)_localctx).IMGSTART = match(IMGSTART);
						setState(493); ((ExpressionContext)_localctx).e2 = ((ExpressionContext)_localctx).expression = expression(0);
						setState(494); ((ExpressionContext)_localctx).IMGEND = match(IMGEND);
						setState(496);
						switch ( getInterpreter().adaptivePredict(_input,46,_ctx) ) {
						case 1:
							{
							setState(495); ((ExpressionContext)_localctx).DECORATION = match(DECORATION);
							}
							break;
						}

						          		String a, b;
						          		a = memory.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null));
						          		b = memory.get((((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null));
						          		
						          		if (memory.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + (((ExpressionContext)_localctx).IMGSTART!=null?((ExpressionContext)_localctx).IMGSTART.getText():null) + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null) + (((ExpressionContext)_localctx).IMGEND!=null?((ExpressionContext)_localctx).IMGEND.getText():null) + (((ExpressionContext)_localctx).DECORATION!=null?((ExpressionContext)_localctx).DECORATION.getText():null)) == null) {
						          			String newVarName = newVar();
						          			print("rimg(" + a + "," + b + "," + newVarName + ")");
						          			memory.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + (((ExpressionContext)_localctx).IMGSTART!=null?((ExpressionContext)_localctx).IMGSTART.getText():null) + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null) + (((ExpressionContext)_localctx).IMGEND!=null?((ExpressionContext)_localctx).IMGEND.getText():null) + (((ExpressionContext)_localctx).DECORATION!=null?((ExpressionContext)_localctx).DECORATION.getText():null), newVarName);
						          			String type1 = types.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null));
						          			String type = "\\power(" + getChildType(type1, 1) + ")";
						          			types.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + (((ExpressionContext)_localctx).IMGSTART!=null?((ExpressionContext)_localctx).IMGSTART.getText():null) + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null) + (((ExpressionContext)_localctx).IMGEND!=null?((ExpressionContext)_localctx).IMGEND.getText():null) + (((ExpressionContext)_localctx).DECORATION!=null?((ExpressionContext)_localctx).DECORATION.getText():null), type);
						          			typeInfo(newVarName, type);
						          			if (modoSetExpression != 0 )
						          				setExpressionVars.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + (((ExpressionContext)_localctx).IMGSTART!=null?((ExpressionContext)_localctx).IMGSTART.getText():null) + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null) + (((ExpressionContext)_localctx).IMGEND!=null?((ExpressionContext)_localctx).IMGEND.getText():null) + (((ExpressionContext)_localctx).DECORATION!=null?((ExpressionContext)_localctx).DECORATION.getText():null), newVarName);
						          		}
						          	
						}
						break;
					}
					} 
				}
				setState(504);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,48,_ctx);
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

	public static class RefNameContext extends ParserRuleContext {
		public Token NAME;
		public TerminalNode NAME() { return getToken(ExprParser.NAME, 0); }
		public RefNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_refName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterRefName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitRefName(this);
		}
	}

	public final RefNameContext refName() throws RecognitionException {
		RefNameContext _localctx = new RefNameContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_refName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(505); ((RefNameContext)_localctx).NAME = match(NAME);

					if (memory.get((((RefNameContext)_localctx).NAME!=null?((RefNameContext)_localctx).NAME.getText():null)) == null)
					{
						String newVarName = newVar((((RefNameContext)_localctx).NAME!=null?((RefNameContext)_localctx).NAME.getText():null));
						
						memory.put((((RefNameContext)_localctx).NAME!=null?((RefNameContext)_localctx).NAME.getText():null), newVarName);
						if (modoSetExpression != 0 )
							setExpressionVars.put((((RefNameContext)_localctx).NAME!=null?((RefNameContext)_localctx).NAME.getText():null), newVarName);
					}
				
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

	public static class PostContext extends ParserRuleContext {
		public TerminalNode DECORATION() { return getToken(ExprParser.DECORATION, 0); }
		public PostContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_post; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterPost(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitPost(this);
		}
	}

	public final PostContext post() throws RecognitionException {
		PostContext _localctx = new PostContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_post);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(508); match(48);
			setState(510);
			switch ( getInterpreter().adaptivePredict(_input,49,_ctx) ) {
			case 1:
				{
				setState(509); match(DECORATION);
				}
				break;
			}
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

	public static class PreContext extends ParserRuleContext {
		public TerminalNode DECORATION() { return getToken(ExprParser.DECORATION, 0); }
		public PreContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pre; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterPre(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitPre(this);
		}
	}

	public final PreContext pre() throws RecognitionException {
		PreContext _localctx = new PreContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_pre);
		try {
			setState(536);
			switch (_input.LA(1)) {
			case 43:
				enterOuterAlt(_localctx, 1);
				{
				setState(512); match(43);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 2);
				{
				setState(513); match(10);
				}
				break;
			case 46:
				enterOuterAlt(_localctx, 3);
				{
				setState(514); match(46);
				setState(515); match(DECORATION);
				}
				break;
			case 20:
				enterOuterAlt(_localctx, 4);
				{
				setState(516); match(20);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 5);
				{
				setState(517); match(3);
				}
				break;
			case 30:
				enterOuterAlt(_localctx, 6);
				{
				setState(518); match(30);
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 7);
				{
				setState(519); match(12);
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 8);
				{
				setState(520); match(16);
				setState(521); match(DECORATION);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 9);
				{
				setState(522); match(5);
				setState(523); match(DECORATION);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 10);
				{
				setState(524); match(4);
				setState(525); match(DECORATION);
				}
				break;
			case 21:
				enterOuterAlt(_localctx, 11);
				{
				setState(526); match(21);
				setState(527); match(DECORATION);
				}
				break;
			case 37:
				enterOuterAlt(_localctx, 12);
				{
				setState(528); match(37);
				setState(529); match(DECORATION);
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(530); match(13);
				setState(531); match(DECORATION);
				}
				break;
			case 57:
				enterOuterAlt(_localctx, 14);
				{
				setState(532); match(57);
				setState(533); match(DECORATION);
				}
				break;
			case 25:
				enterOuterAlt(_localctx, 15);
				{
				setState(534); match(25);
				setState(535); match(DECORATION);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 9: return predicate_sempred((PredicateContext)_localctx, predIndex);

		case 10: return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 17: return 13 >= _localctx._p;

		case 16: return 25 >= _localctx._p;

		case 4: return 23 >= _localctx._p;

		case 5: return 22 >= _localctx._p;

		case 6: return 21 >= _localctx._p;

		case 7: return 20 >= _localctx._p;

		case 8: return 19 >= _localctx._p;

		case 9: return 18 >= _localctx._p;

		case 10: return 17 >= _localctx._p;

		case 11: return 16 >= _localctx._p;

		case 12: return 15 >= _localctx._p;

		case 13: return 14 >= _localctx._p;

		case 14: return 28 >= _localctx._p;

		case 15: return 27 >= _localctx._p;
		}
		return true;
	}
	private boolean predicate_sempred(PredicateContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return 4 >= _localctx._p;

		case 1: return 3 >= _localctx._p;

		case 2: return 2 >= _localctx._p;

		case 3: return 1 >= _localctx._p;
		}
		return true;
	}

	public static final String _serializedATN =
		"\2\3W\u021d\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4"+
		"\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\7"+
		"\2!\n\2\f\2\16\2$\13\2\6\2&\n\2\r\2\16\2\'\3\2\3\2\3\3\3\3\3\3\3\3\5\3"+
		"\60\n\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3;\n\3\3\3\3\3\3\3\3\3\5"+
		"\3A\n\3\3\3\3\3\3\3\5\3F\n\3\3\3\3\3\6\3J\n\3\r\3\16\3K\3\3\3\3\5\3P\n"+
		"\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4Y\n\4\f\4\16\4\\\13\4\3\4\3\4\3\4\3"+
		"\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\5\6k\n\6\3\6\3\6\3\6\3\6\5\6q\n"+
		"\6\7\6s\n\6\f\6\16\6v\13\6\3\6\3\6\3\7\3\7\3\7\3\7\5\7~\n\7\3\7\3\7\5"+
		"\7\u0082\n\7\3\7\3\7\3\7\7\7\u0087\n\7\f\7\16\7\u008a\13\7\3\b\3\b\3\b"+
		"\7\b\u008f\n\b\f\b\16\b\u0092\13\b\3\t\3\t\3\t\3\t\3\t\3\t\7\t\u009a\n"+
		"\t\f\t\16\t\u009d\13\t\3\t\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\5\13\u00ae\n\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\5\13\u00b7\n\13\3\13\3\13\3\13\3\13\3\13\5\13\u00be\n\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\5\13\u00c6\n\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13"+
		"\u00ce\n\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u00d6\n\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u00e3\n\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\5\13\u00ec\n\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\5\13\u00f4\n\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u00fd\n\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\5\13\u0105\n\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\5\13\u010d\n\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u0115\n\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u0120\n\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\7\13\u012e\n\13\f\13"+
		"\16\13\u0131\13\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\5\f\u0145\n\f\3\f\3\f\3\f\3\f\7\f\u014b\n\f\f\f\16"+
		"\f\u014e\13\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u015b\n"+
		"\f\3\f\3\f\3\f\3\f\3\f\5\f\u0162\n\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\5\f\u016f\n\f\6\f\u0171\n\f\r\f\16\f\u0172\3\f\3\f\3\f\3\f"+
		"\5\f\u0179\n\f\3\f\3\f\3\f\3\f\5\f\u017f\n\f\3\f\3\f\3\f\3\f\7\f\u0185"+
		"\n\f\f\f\16\f\u0188\13\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\6\f\u0193"+
		"\n\f\r\f\16\f\u0194\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\5\f\u01a6\n\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u01e2\n\f\3\f\3\f\3"+
		"\f\5\f\u01e7\n\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u01f3\n\f"+
		"\3\f\3\f\7\f\u01f7\n\f\f\f\16\f\u01fa\13\f\3\r\3\r\3\r\3\16\3\16\5\16"+
		"\u0201\n\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u021b"+
		"\n\17\3\17\2\20\2\4\6\b\n\f\16\20\22\24\26\30\32\34\2\3\4::OO\u0278\2"+
		"%\3\2\2\2\4O\3\2\2\2\6Q\3\2\2\2\b`\3\2\2\2\ne\3\2\2\2\fy\3\2\2\2\16\u008b"+
		"\3\2\2\2\20\u0093\3\2\2\2\22\u00a2\3\2\2\2\24\u011f\3\2\2\2\26\u01a5\3"+
		"\2\2\2\30\u01fb\3\2\2\2\32\u01fe\3\2\2\2\34\u021a\3\2\2\2\36\"\5\4\3\2"+
		"\37!\7O\2\2 \37\3\2\2\2!$\3\2\2\2\" \3\2\2\2\"#\3\2\2\2#&\3\2\2\2$\"\3"+
		"\2\2\2%\36\3\2\2\2&\'\3\2\2\2\'%\3\2\2\2\'(\3\2\2\2()\3\2\2\2)*\b\2\1"+
		"\2*\3\3\2\2\2+/\7\64\2\2,\60\7\3\2\2-.\78\2\2.\60\b\3\1\2/,\3\2\2\2/-"+
		"\3\2\2\2\60\61\3\2\2\2\61\62\7)\2\2\62\63\7L\2\2\63\64\7\20\2\2\64\65"+
		"\5\f\7\2\65\66\b\3\1\2\66:\7$\2\2\67;\7\3\2\289\78\2\29;\b\3\1\2:\67\3"+
		"\2\2\2:8\3\2\2\2;<\3\2\2\2<=\7\20\2\2=P\3\2\2\2>@\7=\2\2?A\7O\2\2@?\3"+
		"\2\2\2@A\3\2\2\2AI\3\2\2\2BF\5\6\4\2CF\5\b\5\2DF\5\n\6\2EB\3\2\2\2EC\3"+
		"\2\2\2ED\3\2\2\2FG\3\2\2\2GH\7O\2\2HJ\3\2\2\2IE\3\2\2\2JK\3\2\2\2KI\3"+
		"\2\2\2KL\3\2\2\2LM\3\2\2\2MN\7.\2\2NP\3\2\2\2O+\3\2\2\2O>\3\2\2\2P\5\3"+
		"\2\2\2QR\7\b\2\2RS\5\22\n\2SZ\b\4\1\2TU\7(\2\2UV\5\22\n\2VW\b\4\1\2WY"+
		"\3\2\2\2XT\3\2\2\2Y\\\3\2\2\2ZX\3\2\2\2Z[\3\2\2\2[]\3\2\2\2\\Z\3\2\2\2"+
		"]^\7&\2\2^_\b\4\1\2_\7\3\2\2\2`a\5\22\n\2ab\7?\2\2bc\5\26\f\2cd\b\5\1"+
		"\2d\t\3\2\2\2ef\5\22\n\2fg\7!\2\2gh\5\22\n\2hj\b\6\1\2ik\5\26\f\2ji\3"+
		"\2\2\2jk\3\2\2\2kt\3\2\2\2lm\7#\2\2mn\5\22\n\2np\b\6\1\2oq\5\26\f\2po"+
		"\3\2\2\2pq\3\2\2\2qs\3\2\2\2rl\3\2\2\2sv\3\2\2\2tr\3\2\2\2tu\3\2\2\2u"+
		"w\3\2\2\2vt\3\2\2\2wx\b\6\1\2x\13\3\2\2\2y}\7O\2\2z{\5\16\b\2{|\7O\2\2"+
		"|~\3\2\2\2}z\3\2\2\2}~\3\2\2\2~\u0081\3\2\2\2\177\u0080\7\36\2\2\u0080"+
		"\u0082\7O\2\2\u0081\177\3\2\2\2\u0081\u0082\3\2\2\2\u0082\u0088\3\2\2"+
		"\2\u0083\u0084\5\24\13\2\u0084\u0085\7O\2\2\u0085\u0087\3\2\2\2\u0086"+
		"\u0083\3\2\2\2\u0087\u008a\3\2\2\2\u0088\u0086\3\2\2\2\u0088\u0089\3\2"+
		"\2\2\u0089\r\3\2\2\2\u008a\u0088\3\2\2\2\u008b\u0090\5\20\t\2\u008c\u008d"+
		"\t\2\2\2\u008d\u008f\5\20\t\2\u008e\u008c\3\2\2\2\u008f\u0092\3\2\2\2"+
		"\u0090\u008e\3\2\2\2\u0090\u0091\3\2\2\2\u0091\17\3\2\2\2\u0092\u0090"+
		"\3\2\2\2\u0093\u0094\5\22\n\2\u0094\u009b\b\t\1\2\u0095\u0096\7(\2\2\u0096"+
		"\u0097\5\22\n\2\u0097\u0098\b\t\1\2\u0098\u009a\3\2\2\2\u0099\u0095\3"+
		"\2\2\2\u009a\u009d\3\2\2\2\u009b\u0099\3\2\2\2\u009b\u009c\3\2\2\2\u009c"+
		"\u009e\3\2\2\2\u009d\u009b\3\2\2\2\u009e\u009f\7+\2\2\u009f\u00a0\5\26"+
		"\f\2\u00a0\u00a1\b\t\1\2\u00a1\21\3\2\2\2\u00a2\u00a3\7L\2\2\u00a3\23"+
		"\3\2\2\2\u00a4\u00a5\b\13\1\2\u00a5\u00a6\5\26\f\2\u00a6\u00a7\7/\2\2"+
		"\u00a7\u00a8\5\26\f\2\u00a8\u00a9\b\13\1\2\u00a9\u0120\3\2\2\2\u00aa\u00ab"+
		"\5\26\f\2\u00ab\u00ad\7\21\2\2\u00ac\u00ae\7N\2\2\u00ad\u00ac\3\2\2\2"+
		"\u00ad\u00ae\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00b0\5\26\f\2\u00b0\u00b7"+
		"\3\2\2\2\u00b1\u00b2\7\4\2\2\u00b2\u00b3\5\26\f\2\u00b3\u00b4\7/\2\2\u00b4"+
		"\u00b5\5\26\f\2\u00b5\u00b7\3\2\2\2\u00b6\u00aa\3\2\2\2\u00b6\u00b1\3"+
		"\2\2\2\u00b7\u00b8\3\2\2\2\u00b8\u00b9\b\13\1\2\u00b9\u0120\3\2\2\2\u00ba"+
		"\u00bb\5\26\f\2\u00bb\u00bd\7\t\2\2\u00bc\u00be\7N\2\2\u00bd\u00bc\3\2"+
		"\2\2\u00bd\u00be\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf\u00c0\5\26\f\2\u00c0"+
		"\u00c1\b\13\1\2\u00c1\u0120\3\2\2\2\u00c2\u00c3\5\26\f\2\u00c3\u00c5\7"+
		"<\2\2\u00c4\u00c6\7N\2\2\u00c5\u00c4\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6"+
		"\u00c7\3\2\2\2\u00c7\u00c8\5\26\f\2\u00c8\u00c9\b\13\1\2\u00c9\u0120\3"+
		"\2\2\2\u00ca\u00cb\5\26\f\2\u00cb\u00cd\7\31\2\2\u00cc\u00ce\7N\2\2\u00cd"+
		"\u00cc\3\2\2\2\u00cd\u00ce\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf\u00d0\5\26"+
		"\f\2\u00d0\u00d1\b\13\1\2\u00d1\u0120\3\2\2\2\u00d2\u00d3\5\26\f\2\u00d3"+
		"\u00d5\7\37\2\2\u00d4\u00d6\7N\2\2\u00d5\u00d4\3\2\2\2\u00d5\u00d6\3\2"+
		"\2\2\u00d6\u00d7\3\2\2\2\u00d7\u00d8\5\26\f\2\u00d8\u00d9\b\13\1\2\u00d9"+
		"\u0120\3\2\2\2\u00da\u00db\5\26\f\2\u00db\u00dc\7\30\2\2\u00dc\u00dd\5"+
		"\26\f\2\u00dd\u00de\b\13\1\2\u00de\u0120\3\2\2\2\u00df\u00e0\5\26\f\2"+
		"\u00e0\u00e2\7\"\2\2\u00e1\u00e3\7N\2\2\u00e2\u00e1\3\2\2\2\u00e2\u00e3"+
		"\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4\u00e5\5\26\f\2\u00e5\u00e6\b\13\1\2"+
		"\u00e6\u0120\3\2\2\2\u00e7\u00e8\7\4\2\2\u00e8\u00e9\5\26\f\2\u00e9\u00eb"+
		"\7\"\2\2\u00ea\u00ec\7N\2\2\u00eb\u00ea\3\2\2\2\u00eb\u00ec\3\2\2\2\u00ec"+
		"\u00ed\3\2\2\2\u00ed\u00ee\5\26\f\2\u00ee\u00ef\b\13\1\2\u00ef\u0120\3"+
		"\2\2\2\u00f0\u00f1\5\26\f\2\u00f1\u00f3\7\66\2\2\u00f2\u00f4\7N\2\2\u00f3"+
		"\u00f2\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4\u00f5\3\2\2\2\u00f5\u00f6\5\26"+
		"\f\2\u00f6\u00f7\b\13\1\2\u00f7\u0120\3\2\2\2\u00f8\u00f9\7\4\2\2\u00f9"+
		"\u00fa\5\26\f\2\u00fa\u00fc\7\66\2\2\u00fb\u00fd\7N\2\2\u00fc\u00fb\3"+
		"\2\2\2\u00fc\u00fd\3\2\2\2\u00fd\u00fe\3\2\2\2\u00fe\u00ff\5\26\f\2\u00ff"+
		"\u0100\b\13\1\2\u0100\u0120\3\2\2\2\u0101\u0102\5\26\f\2\u0102\u0104\7"+
		"\35\2\2\u0103\u0105\7N\2\2\u0104\u0103\3\2\2\2\u0104\u0105\3\2\2\2\u0105"+
		"\u0106\3\2\2\2\u0106\u0107\5\26\f\2\u0107\u0108\b\13\1\2\u0108\u0120\3"+
		"\2\2\2\u0109\u010a\5\26\f\2\u010a\u010c\7\32\2\2\u010b\u010d\7N\2\2\u010c"+
		"\u010b\3\2\2\2\u010c\u010d\3\2\2\2\u010d\u010e\3\2\2\2\u010e\u010f\5\26"+
		"\f\2\u010f\u0110\b\13\1\2\u0110\u0120\3\2\2\2\u0111\u0112\5\26\f\2\u0112"+
		"\u0114\7%\2\2\u0113\u0115\7N\2\2\u0114\u0113\3\2\2\2\u0114\u0115\3\2\2"+
		"\2\u0115\u0116\3\2\2\2\u0116\u0117\5\26\f\2\u0117\u0118\b\13\1\2\u0118"+
		"\u0120\3\2\2\2\u0119\u011a\7*\2\2\u011a\u011b\5\24\13\2\u011b\u011c\7"+
		"\24\2\2\u011c\u0120\3\2\2\2\u011d\u0120\7\63\2\2\u011e\u0120\7\n\2\2\u011f"+
		"\u00a4\3\2\2\2\u011f\u00b6\3\2\2\2\u011f\u00ba\3\2\2\2\u011f\u00c2\3\2"+
		"\2\2\u011f\u00ca\3\2\2\2\u011f\u00d2\3\2\2\2\u011f\u00da\3\2\2\2\u011f"+
		"\u00df\3\2\2\2\u011f\u00e7\3\2\2\2\u011f\u00f0\3\2\2\2\u011f\u00f8\3\2"+
		"\2\2\u011f\u0101\3\2\2\2\u011f\u0109\3\2\2\2\u011f\u0111\3\2\2\2\u011f"+
		"\u0119\3\2\2\2\u011f\u011d\3\2\2\2\u011f\u011e\3\2\2\2\u0120\u012f\3\2"+
		"\2\2\u0121\u0122\6\13\2\3\u0122\u0123\7\67\2\2\u0123\u012e\5\24\13\2\u0124"+
		"\u0125\6\13\3\3\u0125\u0126\79\2\2\u0126\u012e\5\24\13\2\u0127\u0128\6"+
		"\13\4\3\u0128\u0129\7,\2\2\u0129\u012e\5\24\13\2\u012a\u012b\6\13\5\3"+
		"\u012b\u012c\7\23\2\2\u012c\u012e\5\24\13\2\u012d\u0121\3\2\2\2\u012d"+
		"\u0124\3\2\2\2\u012d\u0127\3\2\2\2\u012d\u012a\3\2\2\2\u012e\u0131\3\2"+
		"\2\2\u012f\u012d\3\2\2\2\u012f\u0130\3\2\2\2\u0130\25\3\2\2\2\u0131\u012f"+
		"\3\2\2\2\u0132\u0133\b\f\1\2\u0133\u0134\5\34\17\2\u0134\u0135\5\26\f"+
		"\2\u0135\u0136\b\f\1\2\u0136\u01a6\3\2\2\2\u0137\u0138\7A\2\2\u0138\u0139"+
		"\5\26\f\2\u0139\u013a\b\f\1\2\u013a\u01a6\3\2\2\2\u013b\u01a6\5\30\r\2"+
		"\u013c\u013d\7M\2\2\u013d\u01a6\b\f\1\2\u013e\u013f\7\r\2\2\u013f\u01a6"+
		"\b\f\1\2\u0140\u0144\7Q\2\2\u0141\u0142\5\26\f\2\u0142\u0143\b\f\1\2\u0143"+
		"\u0145\3\2\2\2\u0144\u0141\3\2\2\2\u0144\u0145\3\2\2\2\u0145\u014c\3\2"+
		"\2\2\u0146\u0147\7(\2\2\u0147\u0148\5\26\f\2\u0148\u0149\b\f\1\2\u0149"+
		"\u014b\3\2\2\2\u014a\u0146\3\2\2\2\u014b\u014e\3\2\2\2\u014c\u014a\3\2"+
		"\2\2\u014c\u014d\3\2\2\2\u014d\u014f\3\2\2\2\u014e\u014c\3\2\2\2\u014f"+
		"\u0150\7R\2\2\u0150\u01a6\b\f\1\2\u0151\u0152\7Q\2\2\u0152\u0153\b\f\1"+
		"\2\u0153\u0154\5\16\b\2\u0154\u015a\b\f\1\2\u0155\u0156\7#\2\2\u0156\u0157"+
		"\b\f\1\2\u0157\u0158\5\24\13\2\u0158\u0159\b\f\1\2\u0159\u015b\3\2\2\2"+
		"\u015a\u0155\3\2\2\2\u015a\u015b\3\2\2\2\u015b\u0161\3\2\2\2\u015c\u015d"+
		"\7\25\2\2\u015d\u015e\b\f\1\2\u015e\u015f\5\26\f\2\u015f\u0160\b\f\1\2"+
		"\u0160\u0162\3\2\2\2\u0161\u015c\3\2\2\2\u0161\u0162\3\2\2\2\u0162\u0163"+
		"\3\2\2\2\u0163\u0164\7R\2\2\u0164\u0165\b\f\1\2\u0165\u0166\b\f\1\2\u0166"+
		"\u01a6\3\2\2\2\u0167\u0168\7\65\2\2\u0168\u0170\b\f\1\2\u0169\u016a\7"+
		"L\2\2\u016a\u016b\7?\2\2\u016b\u016c\5\26\f\2\u016c\u016e\b\f\1\2\u016d"+
		"\u016f\7(\2\2\u016e\u016d\3\2\2\2\u016e\u016f\3\2\2\2\u016f\u0171\3\2"+
		"\2\2\u0170\u0169\3\2\2\2\u0171\u0172\3\2\2\2\u0172\u0170\3\2\2\2\u0172"+
		"\u0173\3\2\2\2\u0173\u0174\3\2\2\2\u0174\u0175\7\61\2\2\u0175\u0176\b"+
		"\f\1\2\u0176\u01a6\3\2\2\2\u0177\u0179\7N\2\2\u0178\u0177\3\2\2\2\u0178"+
		"\u0179\3\2\2\2\u0179\u017a\3\2\2\2\u017a\u017e\7S\2\2\u017b\u017c\5\26"+
		"\f\2\u017c\u017d\b\f\1\2\u017d\u017f\3\2\2\2\u017e\u017b\3\2\2\2\u017e"+
		"\u017f\3\2\2\2\u017f\u0186\3\2\2\2\u0180\u0181\7(\2\2\u0181\u0182\5\26"+
		"\f\2\u0182\u0183\b\f\1\2\u0183\u0185\3\2\2\2\u0184\u0180\3\2\2\2\u0185"+
		"\u0188\3\2\2\2\u0186\u0184\3\2\2\2\u0186\u0187\3\2\2\2\u0187\u0189\3\2"+
		"\2\2\u0188\u0186\3\2\2\2\u0189\u018a\7T\2\2\u018a\u01a6\b\f\1\2\u018b"+
		"\u018c\7*\2\2\u018c\u018d\5\26\f\2\u018d\u0192\b\f\1\2\u018e\u018f\7("+
		"\2\2\u018f\u0190\5\26\f\2\u0190\u0191\b\f\1\2\u0191\u0193\3\2\2\2\u0192"+
		"\u018e\3\2\2\2\u0193\u0194\3\2\2\2\u0194\u0192\3\2\2\2\u0194\u0195\3\2"+
		"\2\2\u0195\u0196\3\2\2\2\u0196\u0197\7\24\2\2\u0197\u0198\b\f\1\2\u0198"+
		"\u01a6\3\2\2\2\u0199\u019a\7*\2\2\u019a\u019b\5\26\f\2\u019b\u019c\7\24"+
		"\2\2\u019c\u019d\b\f\1\2\u019d\u01a6\3\2\2\2\u019e\u019f\7\34\2\2\u019f"+
		"\u01a0\7\13\2\2\u01a0\u01a6\b\f\1\2\u01a1\u01a2\7\34\2\2\u01a2\u01a6\b"+
		"\f\1\2\u01a3\u01a4\7>\2\2\u01a4\u01a6\b\f\1\2\u01a5\u0132\3\2\2\2\u01a5"+
		"\u0137\3\2\2\2\u01a5\u013b\3\2\2\2\u01a5\u013c\3\2\2\2\u01a5\u013e\3\2"+
		"\2\2\u01a5\u0140\3\2\2\2\u01a5\u0151\3\2\2\2\u01a5\u0167\3\2\2\2\u01a5"+
		"\u0178\3\2\2\2\u01a5\u018b\3\2\2\2\u01a5\u0199\3\2\2\2\u01a5\u019e\3\2"+
		"\2\2\u01a5\u01a1\3\2\2\2\u01a5\u01a3\3\2\2\2\u01a6\u01f8\3\2\2\2\u01a7"+
		"\u01a8\6\f\6\3\u01a8\u01a9\7@\2\2\u01a9\u01aa\5\26\f\2\u01aa\u01ab\b\f"+
		"\1\2\u01ab\u01f7\3\2\2\2\u01ac\u01ad\6\f\7\3\u01ad\u01ae\7B\2\2\u01ae"+
		"\u01af\5\26\f\2\u01af\u01b0\b\f\1\2\u01b0\u01f7\3\2\2\2\u01b1\u01b2\6"+
		"\f\b\3\u01b2\u01b3\7C\2\2\u01b3\u01b4\5\26\f\2\u01b4\u01b5\b\f\1\2\u01b5"+
		"\u01f7\3\2\2\2\u01b6\u01b7\6\f\t\3\u01b7\u01b8\7D\2\2\u01b8\u01b9\5\26"+
		"\f\2\u01b9\u01ba\b\f\1\2\u01ba\u01f7\3\2\2\2\u01bb\u01bc\6\f\n\3\u01bc"+
		"\u01bd\7E\2\2\u01bd\u01be\5\26\f\2\u01be\u01bf\b\f\1\2\u01bf\u01f7\3\2"+
		"\2\2\u01c0\u01c1\6\f\13\3\u01c1\u01c2\7F\2\2\u01c2\u01c3\5\26\f\2\u01c3"+
		"\u01c4\b\f\1\2\u01c4\u01f7\3\2\2\2\u01c5\u01c6\6\f\f\3\u01c6\u01c7\7G"+
		"\2\2\u01c7\u01c8\5\26\f\2\u01c8\u01c9\b\f\1\2\u01c9\u01f7\3\2\2\2\u01ca"+
		"\u01cb\6\f\r\3\u01cb\u01cc\7H\2\2\u01cc\u01cd\5\26\f\2\u01cd\u01ce\b\f"+
		"\1\2\u01ce\u01f7\3\2\2\2\u01cf\u01d0\6\f\16\3\u01d0\u01d1\7I\2\2\u01d1"+
		"\u01d2\5\26\f\2\u01d2\u01d3\b\f\1\2\u01d3\u01f7\3\2\2\2\u01d4\u01d5\6"+
		"\f\17\3\u01d5\u01d6\7J\2\2\u01d6\u01d7\5\26\f\2\u01d7\u01d8\b\f\1\2\u01d8"+
		"\u01f7\3\2\2\2\u01d9\u01da\6\f\20\3\u01da\u01db\5\32\16\2\u01db\u01dc"+
		"\b\f\1\2\u01dc\u01f7\3\2\2\2\u01dd\u01de\6\f\21\3\u01de\u01e1\7K\2\2\u01df"+
		"\u01e2\5\30\r\2\u01e0\u01e2\7M\2\2\u01e1\u01df\3\2\2\2\u01e1\u01e0\3\2"+
		"\2\2\u01e2\u01e3\3\2\2\2\u01e3\u01f7\b\f\1\2\u01e4\u01e6\6\f\22\3\u01e5"+
		"\u01e7\7N\2\2\u01e6\u01e5\3\2\2\2\u01e6\u01e7\3\2\2\2\u01e7\u01e8\3\2"+
		"\2\2\u01e8\u01e9\7*\2\2\u01e9\u01ea\5\26\f\2\u01ea\u01eb\7\24\2\2\u01eb"+
		"\u01ec\b\f\1\2\u01ec\u01f7\3\2\2\2\u01ed\u01ee\6\f\23\3\u01ee\u01ef\7"+
		"U\2\2\u01ef\u01f0\5\26\f\2\u01f0\u01f2\7V\2\2\u01f1\u01f3\7N\2\2\u01f2"+
		"\u01f1\3\2\2\2\u01f2\u01f3\3\2\2\2\u01f3\u01f4\3\2\2\2\u01f4\u01f5\b\f"+
		"\1\2\u01f5\u01f7\3\2\2\2\u01f6\u01a7\3\2\2\2\u01f6\u01ac\3\2\2\2\u01f6"+
		"\u01b1\3\2\2\2\u01f6\u01b6\3\2\2\2\u01f6\u01bb\3\2\2\2\u01f6\u01c0\3\2"+
		"\2\2\u01f6\u01c5\3\2\2\2\u01f6\u01ca\3\2\2\2\u01f6\u01cf\3\2\2\2\u01f6"+
		"\u01d4\3\2\2\2\u01f6\u01d9\3\2\2\2\u01f6\u01dd\3\2\2\2\u01f6\u01e4\3\2"+
		"\2\2\u01f6\u01ed\3\2\2\2\u01f7\u01fa\3\2\2\2\u01f8\u01f6\3\2\2\2\u01f8"+
		"\u01f9\3\2\2\2\u01f9\27\3\2\2\2\u01fa\u01f8\3\2\2\2\u01fb\u01fc\7L\2\2"+
		"\u01fc\u01fd\b\r\1\2\u01fd\31\3\2\2\2\u01fe\u0200\7\62\2\2\u01ff\u0201"+
		"\7N\2\2\u0200\u01ff\3\2\2\2\u0200\u0201\3\2\2\2\u0201\33\3\2\2\2\u0202"+
		"\u021b\7-\2\2\u0203\u021b\7\f\2\2\u0204\u0205\7\60\2\2\u0205\u021b\7N"+
		"\2\2\u0206\u021b\7\26\2\2\u0207\u021b\7\5\2\2\u0208\u021b\7 \2\2\u0209"+
		"\u021b\7\16\2\2\u020a\u020b\7\22\2\2\u020b\u021b\7N\2\2\u020c\u020d\7"+
		"\7\2\2\u020d\u021b\7N\2\2\u020e\u020f\7\6\2\2\u020f\u021b\7N\2\2\u0210"+
		"\u0211\7\27\2\2\u0211\u021b\7N\2\2\u0212\u0213\7\'\2\2\u0213\u021b\7N"+
		"\2\2\u0214\u0215\7\17\2\2\u0215\u021b\7N\2\2\u0216\u0217\7;\2\2\u0217"+
		"\u021b\7N\2\2\u0218\u0219\7\33\2\2\u0219\u021b\7N\2\2\u021a\u0202\3\2"+
		"\2\2\u021a\u0203\3\2\2\2\u021a\u0204\3\2\2\2\u021a\u0206\3\2\2\2\u021a"+
		"\u0207\3\2\2\2\u021a\u0208\3\2\2\2\u021a\u0209\3\2\2\2\u021a\u020a\3\2"+
		"\2\2\u021a\u020c\3\2\2\2\u021a\u020e\3\2\2\2\u021a\u0210\3\2\2\2\u021a"+
		"\u0212\3\2\2\2\u021a\u0214\3\2\2\2\u021a\u0216\3\2\2\2\u021a\u0218\3\2"+
		"\2\2\u021b\35\3\2\2\2\65\"\'/:@EKOZjpt}\u0081\u0088\u0090\u009b\u00ad"+
		"\u00b6\u00bd\u00c5\u00cd\u00d5\u00e2\u00eb\u00f3\u00fc\u0104\u010c\u0114"+
		"\u011f\u012d\u012f\u0144\u014c\u015a\u0161\u016e\u0172\u0178\u017e\u0186"+
		"\u0194\u01a5\u01e1\u01e6\u01f2\u01f6\u01f8\u0200\u021a";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}