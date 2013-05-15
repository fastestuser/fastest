// Generated from Expr.g4 by ANTLR 4.0

	package compserver.tcasegen.strategies.setlog.ztosetlog;
	import compserver.tcasegen.strategies.setlog.TypeManagerParser;
	import compserver.tcasegen.strategies.setlog.TypeManagerLexer;
	import java.util.HashMap;
	import java.util.ArrayList;
	import java.util.regex.Matcher;
	import java.util.regex.Pattern;
	import javax.swing.tree.DefaultMutableTreeNode;

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
		T__62=1, T__61=2, T__60=3, T__59=4, T__58=5, T__57=6, T__56=7, T__55=8, 
		T__54=9, T__53=10, T__52=11, T__51=12, T__50=13, T__49=14, T__48=15, T__47=16, 
		T__46=17, T__45=18, T__44=19, T__43=20, T__42=21, T__41=22, T__40=23, 
		T__39=24, T__38=25, T__37=26, T__36=27, T__35=28, T__34=29, T__33=30, 
		T__32=31, T__31=32, T__30=33, T__29=34, T__28=35, T__27=36, T__26=37, 
		T__25=38, T__24=39, T__23=40, T__22=41, T__21=42, T__20=43, T__19=44, 
		T__18=45, T__17=46, T__16=47, T__15=48, T__14=49, T__13=50, T__12=51, 
		T__11=52, T__10=53, T__9=54, T__8=55, T__7=56, T__6=57, T__5=58, T__4=59, 
		T__3=60, T__2=61, T__1=62, T__0=63, NAME=64, NUM=65, IN_FUN_P3=66, IN_FUN_P4=67, 
		IN_FUN_P5=68, IN_FUN_P6=69, IN_GEN=70, DECORATION=71, NL=72, WS=73, SETSTART=74, 
		SETEND=75, LISTSTART=76, LISTEND=77, IMGSTART=78, IMGEND=79, SKIP=80;
	public static final String[] tokenNames = {
		"<INVALID>", "'schema'", "'\\lnot'", "'\\#'", "'rev'", "'min'", "'['", 
		"'<'", "'false'", "'_{1}'", "'\\dom'", "'\\emptyset'", "'\\upto'", "'tail'", 
		"'}'", "'\\notin'", "'max'", "'\\land'", "')'", "'@'", "'\\seq'", "'head'", 
		"'='", "'\\leq'", "'\\prefix'", "'squash'", "'\\nat'", "'\\neq'", "'\\where'", 
		"'\\geq'", "'\\bigcup'", "'::='", "'\\subseteq'", "'|'", "'\\end{'", "'\\suffix'", 
		"']'", "'last'", "','", "'}{'", "'('", "':'", "'\\lor'", "'\\end{zed}'", 
		"'\\ran'", "'\\in'", "'seq_{1}'", "'\\inv'", "'\\cross'", "'true'", "'\\begin{'", 
		"'\\subset'", "'\\power'", "'.'", "'\\iff'", "'schemaType'", "'\\implies'", 
		"';'", "'front'", "'>'", "'\\begin{zed}'", "'\\num'", "'=='", "'\\mapsto'", 
		"NAME", "NUM", "IN_FUN_P3", "IN_FUN_P4", "IN_FUN_P5", "IN_FUN_P6", "IN_GEN", 
		"'~'", "NL", "WS", "'\\{'", "'\\}'", "'\\langle'", "'\\rangle'", "'\\limg'", 
		"'\\rimg'", "SKIP"
	};
	public static final int
		RULE_specification = 0, RULE_paragraph = 1, RULE_basic_type = 2, RULE_equivalent_type = 3, 
		RULE_enumeration_type = 4, RULE_schemaText = 5, RULE_declPart = 6, RULE_declaration = 7, 
		RULE_declName = 8, RULE_predicate = 9, RULE_expression0 = 10, RULE_expression = 11, 
		RULE_expression1 = 12, RULE_expression2 = 13, RULE_expression3 = 14, RULE_expression4 = 15, 
		RULE_post_fun = 16, RULE_pre_gen = 17, RULE_seq_op = 18;
	public static final String[] ruleNames = {
		"specification", "paragraph", "basic_type", "equivalent_type", "enumeration_type", 
		"schemaText", "declPart", "declaration", "declName", "predicate", "expression0", 
		"expression", "expression1", "expression2", "expression3", "expression4", 
		"post_fun", "pre_gen", "seq_op"
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
		String schemaTypeVars = new String();
		
		int varNumber = 0;
		int modoSetExpression = 0; //0 = false, 1 = true
		int tipoSchema = 0;        //0 = false, 1 = true, esta variable se utiliza para no imprimir ciertas cosas,
						           //cuando trabajamos en tipos schema
		
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
			if (modoSetExpression == 0 && tipoSchema == 0) 
				//System.out.println(c + " &");
				out = out.concat(c + " &");
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
			if (memory.containsValue(newVarName) || modoSetExpression==1) { 
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
						if (nodeType.equals("\\seq_{1}"))
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
					if (tipoSchema == 0) printAtEnd("is_fun(" + var + ")");
				}
				else if (type.equals("\\nat") || type.equals("\\num") || type.equals("\\nat_{1}")) {
					if (tipoSchema == 0) {
						print(var + " in " + printInfo(type));
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
				else if (nodeType.contains("\\upto")) {
					String nodeName = memory.get(nodeType);
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
		
		private String printInfo(String type) {
			String translation = memory.get(type);
			
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
			}
			
			if (!out.contains( translation + " = int(")){ //Chequeo si ya se imprimio informacion del tipo
				if (type.equals("\\num"))
					print(translation + " = int(-10000000000, 10000000000)");
				else if (type.equals("\\nat"))
					print(translation + " = int(0, 10000000000)");
				else if (type.equals("\\nat_{1}"))
					print(translation + " = int(1, 10000000000)");
			}
			
			return translation;
		}
		
		private boolean isBasic(String type) {
			if (type.startsWith("BasicType") || type.startsWith("EnumerationType") || type.startsWith("SchemaType"))
				return true;
			return false;
		}
		
		private boolean isSequence(String type) {
			if (type.startsWith("\\seq"))
				return true;
			return false;
		}
		
		String convertToSet(String zVar, String setlogVar) { //si es una lista, debemos aplicar list_to_rel
			
			String type = types.get(zVar);
			if (isSequence(getType(type))) 
				if (memory.get("list_to_rel(" + zVar + ")") == null) {
					String newVarName = newVar();
					print("list_to_rel(" + setlogVar + "," + newVarName + ")");
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
			setState(45); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(38); paragraph();
				setState(42);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(39); match(NL);
					}
					}
					setState(44);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(47); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==50 || _la==60 );

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
			setState(87);
			switch (_input.LA(1)) {
			case 50:
				enterOuterAlt(_localctx, 1);
				{
				setState(51); match(50);
				setState(55);
				switch (_input.LA(1)) {
				case 1:
					{
					setState(52); match(1);
					}
					break;
				case 55:
					{
					{
					setState(53); match(55);
					tipoSchema = 1; schemaTypeVars = "";
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(57); match(39);
				setState(58); ((ParagraphContext)_localctx).NAME = match(NAME);
				setState(59); match(14);
				setState(60); schemaText();

							if (tipoSchema == 1) {
								String newVarName = newVar((((ParagraphContext)_localctx).NAME!=null?((ParagraphContext)_localctx).NAME.getText():null));
								memory.put((((ParagraphContext)_localctx).NAME!=null?((ParagraphContext)_localctx).NAME.getText():null), newVarName);
								types.put((((ParagraphContext)_localctx).NAME!=null?((ParagraphContext)_localctx).NAME.getText():null), "SchemaType:" + newVarName + ":[" + schemaTypeVars + "]");
								schemaTypeVars = "";
							}
						
				setState(62); match(34);
				setState(66);
				switch (_input.LA(1)) {
				case 1:
					{
					setState(63); match(1);
					}
					break;
				case 55:
					{
					{
					setState(64); match(55);
					tipoSchema = 0;
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(68); match(14);
				}
				break;
			case 60:
				enterOuterAlt(_localctx, 2);
				{
				setState(70); match(60);
				setState(72);
				_la = _input.LA(1);
				if (_la==NL) {
					{
					setState(71); match(NL);
					}
				}

				setState(81); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(77);
					switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
					case 1:
						{
						setState(74); basic_type();
						}
						break;

					case 2:
						{
						setState(75); equivalent_type();
						}
						break;

					case 3:
						{
						setState(76); enumeration_type();
						}
						break;
					}
					setState(79); match(NL);
					}
					}
					setState(83); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==6 || _la==NAME );
				setState(85); match(43);
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
			setState(89); match(6);
			setState(90); ((Basic_typeContext)_localctx).a = ((Basic_typeContext)_localctx).declName = declName();
			((Basic_typeContext)getInvokingContext(2)).typeList.add((((Basic_typeContext)_localctx).a!=null?_input.getText(((Basic_typeContext)_localctx).a.start,((Basic_typeContext)_localctx).a.stop):null));
			setState(98);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==38) {
				{
				{
				setState(92); match(38);
				setState(93); ((Basic_typeContext)_localctx).b = ((Basic_typeContext)_localctx).declName = declName();
				((Basic_typeContext)getInvokingContext(2)).typeList.add((((Basic_typeContext)_localctx).b!=null?_input.getText(((Basic_typeContext)_localctx).b.start,((Basic_typeContext)_localctx).b.stop):null));
				}
				}
				setState(100);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(101); match(36);

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
			setState(104); ((Equivalent_typeContext)_localctx).declName = declName();
			setState(105); match(62);
			setState(106); ((Equivalent_typeContext)_localctx).expression = expression();
			 
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
			setState(109); ((Enumeration_typeContext)_localctx).d = declName();
			setState(110); match(31);
			setState(111); ((Enumeration_typeContext)_localctx).a = declName();
			((Enumeration_typeContext)getInvokingContext(4)).cases.add((((Enumeration_typeContext)_localctx).a!=null?_input.getText(((Enumeration_typeContext)_localctx).a.start,((Enumeration_typeContext)_localctx).a.stop):null));
			setState(114);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 3) | (1L << 4) | (1L << 5) | (1L << 10) | (1L << 11) | (1L << 13) | (1L << 16) | (1L << 20) | (1L << 21) | (1L << 25) | (1L << 26) | (1L << 30) | (1L << 37) | (1L << 40) | (1L << 44) | (1L << 46) | (1L << 52) | (1L << 58) | (1L << 61))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (NAME - 64)) | (1L << (NUM - 64)) | (1L << (DECORATION - 64)) | (1L << (SETSTART - 64)) | (1L << (LISTSTART - 64)))) != 0)) {
				{
				setState(113); expression();
				}
			}

			setState(124);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==33) {
				{
				{
				setState(116); match(33);
				setState(117); ((Enumeration_typeContext)_localctx).b = declName();
				((Enumeration_typeContext)getInvokingContext(4)).cases.add((((Enumeration_typeContext)_localctx).b!=null?_input.getText(((Enumeration_typeContext)_localctx).b.start,((Enumeration_typeContext)_localctx).b.stop):null));
				setState(120);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 3) | (1L << 4) | (1L << 5) | (1L << 10) | (1L << 11) | (1L << 13) | (1L << 16) | (1L << 20) | (1L << 21) | (1L << 25) | (1L << 26) | (1L << 30) | (1L << 37) | (1L << 40) | (1L << 44) | (1L << 46) | (1L << 52) | (1L << 58) | (1L << 61))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (NAME - 64)) | (1L << (NUM - 64)) | (1L << (DECORATION - 64)) | (1L << (SETSTART - 64)) | (1L << (LISTSTART - 64)))) != 0)) {
					{
					setState(119); expression();
					}
				}

				}
				}
				setState(126);
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
			setState(129); match(NL);
			setState(133);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				setState(130); declPart();
				setState(131); match(NL);
				}
				break;
			}
			setState(137);
			_la = _input.LA(1);
			if (_la==28) {
				{
				setState(135); match(28);
				setState(136); match(NL);
				}
			}

			setState(144);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 2) | (1L << 3) | (1L << 4) | (1L << 5) | (1L << 8) | (1L << 10) | (1L << 11) | (1L << 13) | (1L << 16) | (1L << 20) | (1L << 21) | (1L << 25) | (1L << 26) | (1L << 30) | (1L << 37) | (1L << 40) | (1L << 44) | (1L << 46) | (1L << 49) | (1L << 52) | (1L << 58) | (1L << 61))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (NAME - 64)) | (1L << (NUM - 64)) | (1L << (DECORATION - 64)) | (1L << (SETSTART - 64)) | (1L << (LISTSTART - 64)))) != 0)) {
				{
				{
				setState(139); predicate(0);
				setState(140); match(NL);
				}
				}
				setState(146);
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
			setState(147); declaration();
			setState(152);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(148);
					_la = _input.LA(1);
					if ( !(_la==57 || _la==NL) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					setState(149); declaration();
					}
					} 
				}
				setState(154);
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
			setState(155); ((DeclarationContext)_localctx).a = declName();
			((DeclarationContext)getInvokingContext(7)).vars.add((((DeclarationContext)_localctx).a!=null?_input.getText(((DeclarationContext)_localctx).a.start,((DeclarationContext)_localctx).a.stop):null));
			setState(163);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==38) {
				{
				{
				setState(157); match(38);
				setState(158); ((DeclarationContext)_localctx).b = declName();
				((DeclarationContext)getInvokingContext(7)).vars.add((((DeclarationContext)_localctx).b!=null?_input.getText(((DeclarationContext)_localctx).b.start,((DeclarationContext)_localctx).b.stop):null));
				}
				}
				setState(165);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(166); match(41);
			setState(167); ((DeclarationContext)_localctx).expression = expression();

					//Para cada variable realizamos el procesamiento
					while( !((DeclarationContext)getInvokingContext(7)).vars.isEmpty() ) {

						String var = ((DeclarationContext)getInvokingContext(7)).vars.remove(0);

						if (tipoSchema == 0)
							zVars.put(var, null); //Marcamos la variable como variable Z, a la cual posiblemente se le deba asignarsele un valor

						String newVarName = newVar(var);
						if (tipoSchema == 0)
							memory.put(var, newVarName);
						if (modoSetExpression==1)
							setExpressionVars.put(var, newVarName); //Falta ver que hacemos para variables ligadas con el mismo nombre en distintas ligaduras
						
						String expType = types.get((((DeclarationContext)_localctx).expression!=null?_input.getText(((DeclarationContext)_localctx).expression.start,((DeclarationContext)_localctx).expression.stop):null));
						expType = typeInfo(newVarName, expType);
						//Chequeo si es un tipo basico, ej [ACCNUM], ya que estos no se imprimen en typeInfo
						String t = types.get(expType);
						if (t != null && t.startsWith("BasicType"))
							print(newVarName + " in " + expType);
						
						if (tipoSchema == 0)
							types.put(var, expType);
						else { //La agregamos como variable del esquema
							if (!schemaTypeVars.equals(""))
								schemaTypeVars = schemaTypeVars.concat(",");
							schemaTypeVars = schemaTypeVars.concat(var + ":" + expType);
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
			setState(170); match(NAME);
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
			setState(295);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				{
				setState(173); ((PredicateContext)_localctx).e1 = expression();
				setState(174); match(45);
				setState(175); ((PredicateContext)_localctx).e2 = expression();

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
				setState(190);
				switch (_input.LA(1)) {
				case 3:
				case 4:
				case 5:
				case 10:
				case 11:
				case 13:
				case 16:
				case 20:
				case 21:
				case 25:
				case 26:
				case 30:
				case 37:
				case 40:
				case 44:
				case 46:
				case 52:
				case 58:
				case 61:
				case NAME:
				case NUM:
				case DECORATION:
				case SETSTART:
				case LISTSTART:
					{
					setState(178); ((PredicateContext)_localctx).e1 = expression();
					setState(179); match(15);
					setState(181);
					switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
					case 1:
						{
						setState(180); match(DECORATION);
						}
						break;
					}
					setState(183); ((PredicateContext)_localctx).e2 = expression();
					}
					break;
				case 2:
					{
					setState(185); match(2);
					setState(186); ((PredicateContext)_localctx).e1 = expression();
					setState(187); match(45);
					setState(188); ((PredicateContext)_localctx).e2 = expression();
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
				setState(194); ((PredicateContext)_localctx).e1 = expression();
				setState(195); match(7);
				setState(197);
				switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
				case 1:
					{
					setState(196); match(DECORATION);
					}
					break;
				}
				setState(199); ((PredicateContext)_localctx).e2 = expression();

						String a, b;
						a = memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						print(a + " < " + b);
					
				}
				break;

			case 4:
				{
				setState(202); ((PredicateContext)_localctx).e1 = expression();
				setState(203); match(59);
				setState(205);
				switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
				case 1:
					{
					setState(204); match(DECORATION);
					}
					break;
				}
				setState(207); ((PredicateContext)_localctx).e2 = expression();

						String a, b;
						a = memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						print(a + " > " + b);
					
				}
				break;

			case 5:
				{
				setState(210); ((PredicateContext)_localctx).e1 = expression();
				setState(211); match(23);
				setState(213);
				switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
				case 1:
					{
					setState(212); match(DECORATION);
					}
					break;
				}
				setState(215); ((PredicateContext)_localctx).e2 = expression();

						String a, b;
						a = memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						
						print(a + " =< " + b);
					
				}
				break;

			case 6:
				{
				setState(218); ((PredicateContext)_localctx).e1 = expression();
				setState(219); match(29);
				setState(221);
				switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
				case 1:
					{
					setState(220); match(DECORATION);
					}
					break;
				}
				setState(223); ((PredicateContext)_localctx).e2 = expression();

						String a, b;
						a = memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						print(a + " =< " + b);
					
				}
				break;

			case 7:
				{
				setState(226); ((PredicateContext)_localctx).e1 = expression();
				setState(227); match(22);
				setState(228); ((PredicateContext)_localctx).e2 = expression();

						String a, b;
						a = memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						print(a + " = " + b);
					
				}
				break;

			case 8:
				{
				setState(231); ((PredicateContext)_localctx).e1 = expression();
				setState(232); match(32);
				setState(234);
				switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
				case 1:
					{
					setState(233); match(DECORATION);
					}
					break;
				}
				setState(236); ((PredicateContext)_localctx).e2 = expression();

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
				setState(239); match(2);
				setState(240); ((PredicateContext)_localctx).e1 = expression();
				setState(241); match(32);
				setState(243);
				switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
				case 1:
					{
					setState(242); match(DECORATION);
					}
					break;
				}
				setState(245); ((PredicateContext)_localctx).e2 = expression();

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
				setState(248); ((PredicateContext)_localctx).e1 = expression();
				setState(249); match(51);
				setState(251);
				switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
				case 1:
					{
					setState(250); match(DECORATION);
					}
					break;
				}
				setState(253); ((PredicateContext)_localctx).e2 = expression();

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
				setState(256); match(2);
				setState(257); ((PredicateContext)_localctx).e1 = expression();
				setState(258); match(51);
				setState(260);
				switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
				case 1:
					{
					setState(259); match(DECORATION);
					}
					break;
				}
				setState(262); ((PredicateContext)_localctx).e2 = expression();

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
				setState(265); ((PredicateContext)_localctx).e1 = expression();
				setState(266); match(27);
				setState(268);
				switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
				case 1:
					{
					setState(267); match(DECORATION);
					}
					break;
				}
				setState(270); ((PredicateContext)_localctx).e2 = expression();

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
				setState(273); ((PredicateContext)_localctx).e1 = expression();
				setState(274); match(24);
				setState(276);
				switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
				case 1:
					{
					setState(275); match(DECORATION);
					}
					break;
				}
				setState(278); ((PredicateContext)_localctx).e2 = expression();

						String a, b;
						a = memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						print("prolog_call(append(" + a + ",_," + b + "))");
					
				}
				break;

			case 14:
				{
				setState(281); ((PredicateContext)_localctx).e1 = expression();
				setState(282); match(35);
				setState(284);
				switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
				case 1:
					{
					setState(283); match(DECORATION);
					}
					break;
				}
				setState(286); ((PredicateContext)_localctx).e2 = expression();

						String a, b;
						a = memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						print("prolog_call(append(_," + a + "," + b + "))");
					
				}
				break;

			case 15:
				{
				setState(289); match(40);
				setState(290); predicate(0);
				setState(291); match(18);
				}
				break;

			case 16:
				{
				setState(293); match(49);
				}
				break;

			case 17:
				{
				setState(294); match(8);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(311);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(309);
					switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
					case 1:
						{
						_localctx = new PredicateContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_predicate);
						setState(297);
						if (!(4 >= _localctx._p)) throw new FailedPredicateException(this, "4 >= $_p");
						setState(298); match(54);
						setState(299); predicate(5);
						}
						break;

					case 2:
						{
						_localctx = new PredicateContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_predicate);
						setState(300);
						if (!(3 >= _localctx._p)) throw new FailedPredicateException(this, "3 >= $_p");
						setState(301); match(56);
						setState(302); predicate(4);
						}
						break;

					case 3:
						{
						_localctx = new PredicateContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_predicate);
						setState(303);
						if (!(2 >= _localctx._p)) throw new FailedPredicateException(this, "2 >= $_p");
						setState(304); match(42);
						setState(305); predicate(3);
						}
						break;

					case 4:
						{
						_localctx = new PredicateContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_predicate);
						setState(306);
						if (!(1 >= _localctx._p)) throw new FailedPredicateException(this, "1 >= $_p");
						setState(307); match(17);
						setState(308); predicate(2);
						}
						break;
					}
					} 
				}
				setState(313);
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

	public static class Expression0Context extends ParserRuleContext {
		public ArrayList<String> elements = new ArrayList<String>();
		public String setlogName = "";
		public String zName = "";
		public String operator = "";
		public String newVarName1 = "";
		public String newVarName2 = "";
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Expression0Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression0; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterExpression0(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitExpression0(this);
		}
	}

	public final Expression0Context expression0() throws RecognitionException {
		Expression0Context _localctx = new Expression0Context(_ctx, getState());
		enterRule(_localctx, 20, RULE_expression0);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(314); expression();
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

	public static class ExpressionContext extends ParserRuleContext {
		public ArrayList<String> elements = new ArrayList<String>();
		public String setlogName = "";
		public String zName = "";
		public String operator = "";
		public String newVarName1 = "";
		public String newVarName2 = "";
		public Expression1Context expression1() {
			return getRuleContext(Expression1Context.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
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

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(316); expression1(0);
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

	public static class Expression1Context extends ParserRuleContext {
		public int _p;
		public ArrayList<String> elements = new ArrayList<String>();
		public String setlogName = "";
		public String zName = "";
		public String operator = "";
		public String newVarName1 = "";
		public String newVarName2 = "";
		public Expression1Context a;
		public Expression2Context e21;
		public Expression2Context e22;
		public Seq_opContext seq_op;
		public Expression2Context e2;
		public Token IN_GEN;
		public Expression1Context b;
		public Seq_opContext seq_op() {
			return getRuleContext(Seq_opContext.class,0);
		}
		public List<Expression1Context> expression1() {
			return getRuleContexts(Expression1Context.class);
		}
		public List<Expression2Context> expression2() {
			return getRuleContexts(Expression2Context.class);
		}
		public Expression2Context expression2(int i) {
			return getRuleContext(Expression2Context.class,i);
		}
		public Expression1Context expression1(int i) {
			return getRuleContext(Expression1Context.class,i);
		}
		public TerminalNode IN_GEN() { return getToken(ExprParser.IN_GEN, 0); }
		public Expression1Context(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Expression1Context(ParserRuleContext parent, int invokingState, int _p) {
			super(parent, invokingState);
			this._p = _p;
		}
		@Override public int getRuleIndex() { return RULE_expression1; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterExpression1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitExpression1(this);
		}
	}

	public final Expression1Context expression1(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Expression1Context _localctx = new Expression1Context(_ctx, _parentState, _p);
		Expression1Context _prevctx = _localctx;
		int _startState = 24;
		enterRecursionRule(_localctx, RULE_expression1);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(336);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				{
				setState(319); ((Expression1Context)_localctx).e21 = expression2(0);
				((Expression1Context)getInvokingContext(12)).elements.add((((Expression1Context)_localctx).e21!=null?_input.getText(((Expression1Context)_localctx).e21.start,((Expression1Context)_localctx).e21.stop):null));
				setState(325); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(321); match(48);
						setState(322); ((Expression1Context)_localctx).e22 = expression2(0);
						((Expression1Context)getInvokingContext(12)).elements.add((((Expression1Context)_localctx).e22!=null?_input.getText(((Expression1Context)_localctx).e22.start,((Expression1Context)_localctx).e22.stop):null));
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(327); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
				} while ( _alt!=2 && _alt!=-1 );

						String unfoldedType = "";
						
						//Para cada exp realizamos el procesamiento
						while( !((Expression1Context)getInvokingContext(12)).elements.isEmpty() ) {
							String exp = ((Expression1Context)getInvokingContext(12)).elements.remove(0);
							
							((Expression1Context)_localctx).zName =  _localctx.zName.concat(exp);
							
							String expType = types.get(exp);
							if (isBasic(expType))
								unfoldedType = unfoldedType.concat(exp);
							else
								unfoldedType = unfoldedType.concat(expType);
								
							if (!((Expression1Context)getInvokingContext(12)).elements.isEmpty()) {
								((Expression1Context)_localctx).zName =  _localctx.zName.concat("\\cross");
								unfoldedType = unfoldedType.concat("\\cross");
							}
						}
						
						types.put(_localctx.zName, unfoldedType);
					
				}
				break;

			case 2:
				{
				setState(331); ((Expression1Context)_localctx).seq_op = seq_op();
				setState(332); ((Expression1Context)_localctx).e2 = expression2(0);

						String a;
						a = memory.get((((Expression1Context)_localctx).e2!=null?_input.getText(((Expression1Context)_localctx).e2.start,((Expression1Context)_localctx).e2.stop):null));
						
						if (memory.get( (((Expression1Context)_localctx).seq_op!=null?_input.getText(((Expression1Context)_localctx).seq_op.start,((Expression1Context)_localctx).seq_op.stop):null) + (((Expression1Context)_localctx).e2!=null?_input.getText(((Expression1Context)_localctx).e2.start,((Expression1Context)_localctx).e2.stop):null)) == null) {
						
							String newVarName = newVar();
						
							if ((((Expression1Context)_localctx).seq_op!=null?_input.getText(((Expression1Context)_localctx).seq_op.start,((Expression1Context)_localctx).seq_op.stop):null).startsWith("rev")){
								print("prolog_call(reverse(" + a + "," + newVarName + "))");
								memory.put((((Expression1Context)_localctx).seq_op!=null?_input.getText(((Expression1Context)_localctx).seq_op.start,((Expression1Context)_localctx).seq_op.stop):null) + (((Expression1Context)_localctx).e2!=null?_input.getText(((Expression1Context)_localctx).e2.start,((Expression1Context)_localctx).e2.stop):null), newVarName);
								String type = types.get((((Expression1Context)_localctx).e2!=null?_input.getText(((Expression1Context)_localctx).e2.start,((Expression1Context)_localctx).e2.stop):null));
								types.put((((Expression1Context)_localctx).seq_op!=null?_input.getText(((Expression1Context)_localctx).seq_op.start,((Expression1Context)_localctx).seq_op.stop):null) + (((Expression1Context)_localctx).e2!=null?_input.getText(((Expression1Context)_localctx).e2.start,((Expression1Context)_localctx).e2.stop):null), type);
								typeInfo(newVarName, type);
								if (modoSetExpression != 0 )
									setExpressionVars.put((((Expression1Context)_localctx).seq_op!=null?_input.getText(((Expression1Context)_localctx).seq_op.start,((Expression1Context)_localctx).seq_op.stop):null) + (((Expression1Context)_localctx).e2!=null?_input.getText(((Expression1Context)_localctx).e2.start,((Expression1Context)_localctx).e2.stop):null), newVarName);
							}
							else if ((((Expression1Context)_localctx).seq_op!=null?_input.getText(((Expression1Context)_localctx).seq_op.start,((Expression1Context)_localctx).seq_op.stop):null).startsWith("head")){
								print("nth1(1," + a + "," + newVarName + ")");
								memory.put((((Expression1Context)_localctx).seq_op!=null?_input.getText(((Expression1Context)_localctx).seq_op.start,((Expression1Context)_localctx).seq_op.stop):null) + (((Expression1Context)_localctx).e2!=null?_input.getText(((Expression1Context)_localctx).e2.start,((Expression1Context)_localctx).e2.stop):null), newVarName);
								String type = getChildType(types.get((((Expression1Context)_localctx).e2!=null?_input.getText(((Expression1Context)_localctx).e2.start,((Expression1Context)_localctx).e2.stop):null)), 0);
								types.put((((Expression1Context)_localctx).seq_op!=null?_input.getText(((Expression1Context)_localctx).seq_op.start,((Expression1Context)_localctx).seq_op.stop):null) + (((Expression1Context)_localctx).e2!=null?_input.getText(((Expression1Context)_localctx).e2.start,((Expression1Context)_localctx).e2.stop):null), type);
								typeInfo(newVarName, type);
								if (modoSetExpression != 0 )
									setExpressionVars.put((((Expression1Context)_localctx).seq_op!=null?_input.getText(((Expression1Context)_localctx).seq_op.start,((Expression1Context)_localctx).seq_op.stop):null) + (((Expression1Context)_localctx).e2!=null?_input.getText(((Expression1Context)_localctx).e2.start,((Expression1Context)_localctx).e2.stop):null), newVarName);
							}
							else if ((((Expression1Context)_localctx).seq_op!=null?_input.getText(((Expression1Context)_localctx).seq_op.start,((Expression1Context)_localctx).seq_op.stop):null).startsWith("last")){
								print("prolog_call(last(" + a + "," + newVarName + "))");
								memory.put((((Expression1Context)_localctx).seq_op!=null?_input.getText(((Expression1Context)_localctx).seq_op.start,((Expression1Context)_localctx).seq_op.stop):null) + (((Expression1Context)_localctx).e2!=null?_input.getText(((Expression1Context)_localctx).e2.start,((Expression1Context)_localctx).e2.stop):null), newVarName);
								String type = getChildType(types.get((((Expression1Context)_localctx).e2!=null?_input.getText(((Expression1Context)_localctx).e2.start,((Expression1Context)_localctx).e2.stop):null)), 0);
								types.put((((Expression1Context)_localctx).seq_op!=null?_input.getText(((Expression1Context)_localctx).seq_op.start,((Expression1Context)_localctx).seq_op.stop):null) + (((Expression1Context)_localctx).e2!=null?_input.getText(((Expression1Context)_localctx).e2.start,((Expression1Context)_localctx).e2.stop):null), type);
								typeInfo(newVarName, type);
								if (modoSetExpression != 0 )
									setExpressionVars.put((((Expression1Context)_localctx).seq_op!=null?_input.getText(((Expression1Context)_localctx).seq_op.start,((Expression1Context)_localctx).seq_op.stop):null) + (((Expression1Context)_localctx).e2!=null?_input.getText(((Expression1Context)_localctx).e2.start,((Expression1Context)_localctx).e2.stop):null), newVarName);
							}
							else if ((((Expression1Context)_localctx).seq_op!=null?_input.getText(((Expression1Context)_localctx).seq_op.start,((Expression1Context)_localctx).seq_op.stop):null).startsWith("tail")){
								print("prolog_call(drop(1," + a + "," + newVarName + "))");
								memory.put((((Expression1Context)_localctx).seq_op!=null?_input.getText(((Expression1Context)_localctx).seq_op.start,((Expression1Context)_localctx).seq_op.stop):null) + (((Expression1Context)_localctx).e2!=null?_input.getText(((Expression1Context)_localctx).e2.start,((Expression1Context)_localctx).e2.stop):null), newVarName);
								String type = types.get((((Expression1Context)_localctx).e2!=null?_input.getText(((Expression1Context)_localctx).e2.start,((Expression1Context)_localctx).e2.stop):null));
								types.put((((Expression1Context)_localctx).seq_op!=null?_input.getText(((Expression1Context)_localctx).seq_op.start,((Expression1Context)_localctx).seq_op.stop):null) + (((Expression1Context)_localctx).e2!=null?_input.getText(((Expression1Context)_localctx).e2.start,((Expression1Context)_localctx).e2.stop):null), type);
								typeInfo(newVarName, type);
								if (modoSetExpression != 0 )
									setExpressionVars.put((((Expression1Context)_localctx).seq_op!=null?_input.getText(((Expression1Context)_localctx).seq_op.start,((Expression1Context)_localctx).seq_op.stop):null) + (((Expression1Context)_localctx).e2!=null?_input.getText(((Expression1Context)_localctx).e2.start,((Expression1Context)_localctx).e2.stop):null), newVarName);
							}
							else if ((((Expression1Context)_localctx).seq_op!=null?_input.getText(((Expression1Context)_localctx).seq_op.start,((Expression1Context)_localctx).seq_op.stop):null).startsWith("front")){
								String n = newVar();
								print("prolog_call(length(" + a + "," + n + "))");
								print(n + " in " + printInfo("\\nat"));
								print("prolog_call(take(" + n + "-1" + "," + a + "," + newVarName + "))");
								memory.put((((Expression1Context)_localctx).seq_op!=null?_input.getText(((Expression1Context)_localctx).seq_op.start,((Expression1Context)_localctx).seq_op.stop):null) + (((Expression1Context)_localctx).e2!=null?_input.getText(((Expression1Context)_localctx).e2.start,((Expression1Context)_localctx).e2.stop):null), newVarName);
								String type = types.get((((Expression1Context)_localctx).e2!=null?_input.getText(((Expression1Context)_localctx).e2.start,((Expression1Context)_localctx).e2.stop):null));
								types.put((((Expression1Context)_localctx).seq_op!=null?_input.getText(((Expression1Context)_localctx).seq_op.start,((Expression1Context)_localctx).seq_op.stop):null) + (((Expression1Context)_localctx).e2!=null?_input.getText(((Expression1Context)_localctx).e2.start,((Expression1Context)_localctx).e2.stop):null), type);
								typeInfo(newVarName, type);
								if (modoSetExpression != 0 )
									setExpressionVars.put((((Expression1Context)_localctx).seq_op!=null?_input.getText(((Expression1Context)_localctx).seq_op.start,((Expression1Context)_localctx).seq_op.stop):null) + (((Expression1Context)_localctx).e2!=null?_input.getText(((Expression1Context)_localctx).e2.start,((Expression1Context)_localctx).e2.stop):null), newVarName);
							}
							else if ((((Expression1Context)_localctx).seq_op!=null?_input.getText(((Expression1Context)_localctx).seq_op.start,((Expression1Context)_localctx).seq_op.stop):null).startsWith("squash")){
								print("squash(" + a + "," + newVarName + ")");
								memory.put((((Expression1Context)_localctx).seq_op!=null?_input.getText(((Expression1Context)_localctx).seq_op.start,((Expression1Context)_localctx).seq_op.stop):null) + (((Expression1Context)_localctx).e2!=null?_input.getText(((Expression1Context)_localctx).e2.start,((Expression1Context)_localctx).e2.stop):null), newVarName);
								String type = types.get((((Expression1Context)_localctx).e2!=null?_input.getText(((Expression1Context)_localctx).e2.start,((Expression1Context)_localctx).e2.stop):null));
								ArrayList<String> leftAndRight = leftAndRightTypes(type);
								type = "\\seq(" + leftAndRight.get(1) + ")";
								types.put((((Expression1Context)_localctx).seq_op!=null?_input.getText(((Expression1Context)_localctx).seq_op.start,((Expression1Context)_localctx).seq_op.stop):null) + (((Expression1Context)_localctx).e2!=null?_input.getText(((Expression1Context)_localctx).e2.start,((Expression1Context)_localctx).e2.stop):null), type);
								typeInfo(newVarName, type);
								if (modoSetExpression != 0 )
									setExpressionVars.put((((Expression1Context)_localctx).seq_op!=null?_input.getText(((Expression1Context)_localctx).seq_op.start,((Expression1Context)_localctx).seq_op.stop):null) + (((Expression1Context)_localctx).e2!=null?_input.getText(((Expression1Context)_localctx).e2.start,((Expression1Context)_localctx).e2.stop):null), newVarName);
							}
						}
					
				}
				break;

			case 3:
				{
				setState(335); ((Expression1Context)_localctx).e2 = expression2(0);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(345);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Expression1Context(_parentctx, _parentState, _p);
					_localctx.a = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_expression1);
					setState(338);
					if (!(4 >= _localctx._p)) throw new FailedPredicateException(this, "4 >= $_p");
					setState(339); ((Expression1Context)_localctx).IN_GEN = match(IN_GEN);
					setState(340); ((Expression1Context)_localctx).b = expression1(5);

					          		//Guardo el tipo
					          		String aType = types.get((((Expression1Context)_localctx).a!=null?_input.getText(((Expression1Context)_localctx).a.start,((Expression1Context)_localctx).a.stop):null));
					          		if (isBasic(aType)) {
					          			aType = (((Expression1Context)_localctx).a!=null?_input.getText(((Expression1Context)_localctx).a.start,((Expression1Context)_localctx).a.stop):null);
					          		}
					          		String bType = types.get((((Expression1Context)_localctx).b!=null?_input.getText(((Expression1Context)_localctx).b.start,((Expression1Context)_localctx).b.stop):null));
					          		if (isBasic(bType))
					          			bType = (((Expression1Context)_localctx).b!=null?_input.getText(((Expression1Context)_localctx).b.start,((Expression1Context)_localctx).b.stop):null);
					          		
					          		if ((((Expression1Context)_localctx).IN_GEN!=null?((Expression1Context)_localctx).IN_GEN.getText():null).equals("\\ffun"))
					          			types.put((((Expression1Context)_localctx).a!=null?_input.getText(((Expression1Context)_localctx).a.start,((Expression1Context)_localctx).a.stop):null) + (((Expression1Context)_localctx).IN_GEN!=null?((Expression1Context)_localctx).IN_GEN.getText():null) + (((Expression1Context)_localctx).b!=null?_input.getText(((Expression1Context)_localctx).b.start,((Expression1Context)_localctx).b.stop):null), aType + "\\pfun" + bType );
					          		else
					          			types.put((((Expression1Context)_localctx).a!=null?_input.getText(((Expression1Context)_localctx).a.start,((Expression1Context)_localctx).a.stop):null) + (((Expression1Context)_localctx).IN_GEN!=null?((Expression1Context)_localctx).IN_GEN.getText():null) + (((Expression1Context)_localctx).b!=null?_input.getText(((Expression1Context)_localctx).b.start,((Expression1Context)_localctx).b.stop):null), aType + (((Expression1Context)_localctx).IN_GEN!=null?((Expression1Context)_localctx).IN_GEN.getText():null) + bType );
					          	
					}
					} 
				}
				setState(347);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
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

	public static class Expression2Context extends ParserRuleContext {
		public int _p;
		public ArrayList<String> elements = new ArrayList<String>();
		public String setlogName = "";
		public String zName = "";
		public String operator = "";
		public String newVarName1 = "";
		public String newVarName2 = "";
		public Expression2Context e21;
		public Expression4Context e4;
		public Pre_genContext pre_gen;
		public ExpressionContext e;
		public Token IMGSTART;
		public Expression0Context e0;
		public Token IMGEND;
		public Token DECORATION;
		public Token IN_FUN_P6;
		public Expression2Context e22;
		public Token IN_FUN_P5;
		public Token IN_FUN_P4;
		public Token IN_FUN_P3;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode IN_FUN_P6() { return getToken(ExprParser.IN_FUN_P6, 0); }
		public Expression0Context expression0() {
			return getRuleContext(Expression0Context.class,0);
		}
		public List<Expression2Context> expression2() {
			return getRuleContexts(Expression2Context.class);
		}
		public Expression3Context expression3() {
			return getRuleContext(Expression3Context.class,0);
		}
		public Expression4Context expression4() {
			return getRuleContext(Expression4Context.class,0);
		}
		public Expression2Context expression2(int i) {
			return getRuleContext(Expression2Context.class,i);
		}
		public TerminalNode DECORATION() { return getToken(ExprParser.DECORATION, 0); }
		public Pre_genContext pre_gen() {
			return getRuleContext(Pre_genContext.class,0);
		}
		public TerminalNode IMGSTART() { return getToken(ExprParser.IMGSTART, 0); }
		public TerminalNode IMGEND() { return getToken(ExprParser.IMGEND, 0); }
		public TerminalNode IN_FUN_P3() { return getToken(ExprParser.IN_FUN_P3, 0); }
		public TerminalNode IN_FUN_P4() { return getToken(ExprParser.IN_FUN_P4, 0); }
		public TerminalNode IN_FUN_P5() { return getToken(ExprParser.IN_FUN_P5, 0); }
		public Expression2Context(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Expression2Context(ParserRuleContext parent, int invokingState, int _p) {
			super(parent, invokingState);
			this._p = _p;
		}
		@Override public int getRuleIndex() { return RULE_expression2; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterExpression2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitExpression2(this);
		}
	}

	public final Expression2Context expression2(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Expression2Context _localctx = new Expression2Context(_ctx, _parentState, _p);
		Expression2Context _prevctx = _localctx;
		int _startState = 26;
		enterRecursionRule(_localctx, RULE_expression2);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(367);
			switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
			case 1:
				{
				setState(349); match(52);
				setState(350); ((Expression2Context)_localctx).e4 = expression4(0);

						String eType = types.get((((Expression2Context)_localctx).e4!=null?_input.getText(((Expression2Context)_localctx).e4.start,((Expression2Context)_localctx).e4.stop):null));
						if (isBasic(eType))
							eType = (((Expression2Context)_localctx).e4!=null?_input.getText(((Expression2Context)_localctx).e4.start,((Expression2Context)_localctx).e4.stop):null);
					
						types.put("\\power" + (((Expression2Context)_localctx).e4!=null?_input.getText(((Expression2Context)_localctx).e4.start,((Expression2Context)_localctx).e4.stop):null), "\\power" + eType );
					
				}
				break;

			case 2:
				{
				setState(353); ((Expression2Context)_localctx).pre_gen = pre_gen();
				setState(354); ((Expression2Context)_localctx).e = expression();

						String a;
						a = memory.get((((Expression2Context)_localctx).e!=null?_input.getText(((Expression2Context)_localctx).e.start,((Expression2Context)_localctx).e.stop):null));
						
						if ((((Expression2Context)_localctx).pre_gen!=null?_input.getText(((Expression2Context)_localctx).pre_gen.start,((Expression2Context)_localctx).pre_gen.stop):null).equals("\\#")){
							if (memory.get("\\#" + (((Expression2Context)_localctx).e!=null?_input.getText(((Expression2Context)_localctx).e.start,((Expression2Context)_localctx).e.stop):null)) == null) {
								String newVarName = newVar();
								memory.put("\\#" + (((Expression2Context)_localctx).e!=null?_input.getText(((Expression2Context)_localctx).e.start,((Expression2Context)_localctx).e.stop):null), newVarName);
								types.put("\\#" + (((Expression2Context)_localctx).e!=null?_input.getText(((Expression2Context)_localctx).e.start,((Expression2Context)_localctx).e.stop):null), "\\nat");
								if (modoSetExpression != 0 )
									setExpressionVars.put("\\#" + (((Expression2Context)_localctx).e!=null?_input.getText(((Expression2Context)_localctx).e.start,((Expression2Context)_localctx).e.stop):null), newVarName);
									
								String type = getType(types.get((((Expression2Context)_localctx).e!=null?_input.getText(((Expression2Context)_localctx).e.start,((Expression2Context)_localctx).e.stop):null)));
								if (isSequence(type))
									print("prolog_call(length(" + a + "," + newVarName + "))");
								else
									print("size(" + a + "," + newVarName + ")");					
								
								print(newVarName + " in " + printInfo("\\nat"));
							}
						}
						else if ((((Expression2Context)_localctx).pre_gen!=null?_input.getText(((Expression2Context)_localctx).pre_gen.start,((Expression2Context)_localctx).pre_gen.stop):null).equals("\\dom")){
							if (memory.get("\\dom" + (((Expression2Context)_localctx).e!=null?_input.getText(((Expression2Context)_localctx).e.start,((Expression2Context)_localctx).e.stop):null)) == null) {
								String newVarName = newVar();
								memory.put("\\dom" + (((Expression2Context)_localctx).e!=null?_input.getText(((Expression2Context)_localctx).e.start,((Expression2Context)_localctx).e.stop):null), newVarName);
								if (modoSetExpression != 0 )
									setExpressionVars.put("\\dom" + (((Expression2Context)_localctx).e!=null?_input.getText(((Expression2Context)_localctx).e.start,((Expression2Context)_localctx).e.stop):null), newVarName);
								types.put("\\dom" + (((Expression2Context)_localctx).e!=null?_input.getText(((Expression2Context)_localctx).e.start,((Expression2Context)_localctx).e.stop):null), "\\power(" + getChildType(types.get((((Expression2Context)_localctx).e!=null?_input.getText(((Expression2Context)_localctx).e.start,((Expression2Context)_localctx).e.stop):null)), 0) + ")");
								
								String e = memory.get((((Expression2Context)_localctx).e!=null?_input.getText(((Expression2Context)_localctx).e.start,((Expression2Context)_localctx).e.stop):null));
								
								//Chequeamos si e es una lista, estas son tratadas de forma diferente
								String type = getType(types.get((((Expression2Context)_localctx).e!=null?_input.getText(((Expression2Context)_localctx).e.start,((Expression2Context)_localctx).e.stop):null)));
								if (isSequence(type))
									print("ddom_list(" + e + "," + newVarName + ")");
								else
									print("dom(" + e + "," + newVarName + ")");
							}
						}
						else if ((((Expression2Context)_localctx).pre_gen!=null?_input.getText(((Expression2Context)_localctx).pre_gen.start,((Expression2Context)_localctx).pre_gen.stop):null).equals("\\ran")){
							if (memory.get("\\ran" + (((Expression2Context)_localctx).e!=null?_input.getText(((Expression2Context)_localctx).e.start,((Expression2Context)_localctx).e.stop):null)) == null) {
								String newVarName = newVar();
								memory.put("\\ran" + (((Expression2Context)_localctx).e!=null?_input.getText(((Expression2Context)_localctx).e.start,((Expression2Context)_localctx).e.stop):null), newVarName);
								if (modoSetExpression != 0 )
									setExpressionVars.put("\\ran" + (((Expression2Context)_localctx).e!=null?_input.getText(((Expression2Context)_localctx).e.start,((Expression2Context)_localctx).e.stop):null), newVarName);
								types.put("\\ran" + (((Expression2Context)_localctx).e!=null?_input.getText(((Expression2Context)_localctx).e.start,((Expression2Context)_localctx).e.stop):null), "\\power(" + getChildType(types.get((((Expression2Context)_localctx).e!=null?_input.getText(((Expression2Context)_localctx).e.start,((Expression2Context)_localctx).e.stop):null)), 1) + ")");
								
								String e = memory.get((((Expression2Context)_localctx).e!=null?_input.getText(((Expression2Context)_localctx).e.start,((Expression2Context)_localctx).e.stop):null));
								
								//Chequeamos si e es una lista, estas son tratadas de forma diferente
								String type = getType(types.get((((Expression2Context)_localctx).e!=null?_input.getText(((Expression2Context)_localctx).e.start,((Expression2Context)_localctx).e.stop):null)));
								if (isSequence(type))
									print("list_to_set(" + e + "," + newVarName + ")");
								else
									print("ran(" + e + "," + newVarName + ")");
							}
						}
						else if ((((Expression2Context)_localctx).pre_gen!=null?_input.getText(((Expression2Context)_localctx).pre_gen.start,((Expression2Context)_localctx).pre_gen.stop):null).startsWith("seq_{1}")) {
							String eType = types.get((((Expression2Context)_localctx).e!=null?_input.getText(((Expression2Context)_localctx).e.start,((Expression2Context)_localctx).e.stop):null));
							if (isBasic(eType))
								eType = (((Expression2Context)_localctx).e!=null?_input.getText(((Expression2Context)_localctx).e.start,((Expression2Context)_localctx).e.stop):null);
						
							types.put((((Expression2Context)_localctx).pre_gen!=null?_input.getText(((Expression2Context)_localctx).pre_gen.start,((Expression2Context)_localctx).pre_gen.stop):null) + (((Expression2Context)_localctx).e!=null?_input.getText(((Expression2Context)_localctx).e.start,((Expression2Context)_localctx).e.stop):null), "\\seq_{1}" + eType);
						}
						else if ((((Expression2Context)_localctx).pre_gen!=null?_input.getText(((Expression2Context)_localctx).pre_gen.start,((Expression2Context)_localctx).pre_gen.stop):null).equals("\\seq")) {
							String eType = types.get((((Expression2Context)_localctx).e!=null?_input.getText(((Expression2Context)_localctx).e.start,((Expression2Context)_localctx).e.stop):null));
							if (isBasic(eType))
								eType = (((Expression2Context)_localctx).e!=null?_input.getText(((Expression2Context)_localctx).e.start,((Expression2Context)_localctx).e.stop):null);
						
							types.put("\\seq" + (((Expression2Context)_localctx).e!=null?_input.getText(((Expression2Context)_localctx).e.start,((Expression2Context)_localctx).e.stop):null), "\\seq" + eType);
						}
						else if ((((Expression2Context)_localctx).pre_gen!=null?_input.getText(((Expression2Context)_localctx).pre_gen.start,((Expression2Context)_localctx).pre_gen.stop):null).equals("\\bigcup")){
							if (memory.get("\\bigcup" + (((Expression2Context)_localctx).e!=null?_input.getText(((Expression2Context)_localctx).e.start,((Expression2Context)_localctx).e.stop):null)) == null) {
								String newVarName = newVar();
								memory.put("\\bigcup" + (((Expression2Context)_localctx).e!=null?_input.getText(((Expression2Context)_localctx).e.start,((Expression2Context)_localctx).e.stop):null), newVarName);
								if (modoSetExpression != 0 )
									setExpressionVars.put("\\bigcup" + (((Expression2Context)_localctx).e!=null?_input.getText(((Expression2Context)_localctx).e.start,((Expression2Context)_localctx).e.stop):null), newVarName);
								types.put("\\bigcup" + (((Expression2Context)_localctx).e!=null?_input.getText(((Expression2Context)_localctx).e.start,((Expression2Context)_localctx).e.stop):null), getChildType(types.get((((Expression2Context)_localctx).e!=null?_input.getText(((Expression2Context)_localctx).e.start,((Expression2Context)_localctx).e.stop):null)), 0));
								
								String e = memory.get((((Expression2Context)_localctx).e!=null?_input.getText(((Expression2Context)_localctx).e.start,((Expression2Context)_localctx).e.stop):null));
								print("bun(" + e + "," + newVarName + ")");
							}
						}
						else if ((((Expression2Context)_localctx).pre_gen!=null?_input.getText(((Expression2Context)_localctx).pre_gen.start,((Expression2Context)_localctx).pre_gen.stop):null).equals("\\bigcap")){
							if (memory.get("\\bigcap" + (((Expression2Context)_localctx).e!=null?_input.getText(((Expression2Context)_localctx).e.start,((Expression2Context)_localctx).e.stop):null)) == null) {
								String newVarName = newVar();
								memory.put("\\bigcap" + (((Expression2Context)_localctx).e!=null?_input.getText(((Expression2Context)_localctx).e.start,((Expression2Context)_localctx).e.stop):null), newVarName);
								if (modoSetExpression != 0 )
									setExpressionVars.put("\\bigcap" + (((Expression2Context)_localctx).e!=null?_input.getText(((Expression2Context)_localctx).e.start,((Expression2Context)_localctx).e.stop):null), newVarName);
								types.put("\\bigcap" + (((Expression2Context)_localctx).e!=null?_input.getText(((Expression2Context)_localctx).e.start,((Expression2Context)_localctx).e.stop):null), getChildType(types.get((((Expression2Context)_localctx).e!=null?_input.getText(((Expression2Context)_localctx).e.start,((Expression2Context)_localctx).e.stop):null)), 0));
								
								String e = memory.get((((Expression2Context)_localctx).e!=null?_input.getText(((Expression2Context)_localctx).e.start,((Expression2Context)_localctx).e.stop):null));
								print("bdinters(" + e + "," + newVarName + ")");
							}
						}
						else if ((((Expression2Context)_localctx).pre_gen!=null?_input.getText(((Expression2Context)_localctx).pre_gen.start,((Expression2Context)_localctx).pre_gen.stop):null).startsWith("min")){
							if (memory.get((((Expression2Context)_localctx).pre_gen!=null?_input.getText(((Expression2Context)_localctx).pre_gen.start,((Expression2Context)_localctx).pre_gen.stop):null) + (((Expression2Context)_localctx).e!=null?_input.getText(((Expression2Context)_localctx).e.start,((Expression2Context)_localctx).e.stop):null)) == null) {
								String newVarName = newVar();
								memory.put((((Expression2Context)_localctx).pre_gen!=null?_input.getText(((Expression2Context)_localctx).pre_gen.start,((Expression2Context)_localctx).pre_gen.stop):null) + (((Expression2Context)_localctx).e!=null?_input.getText(((Expression2Context)_localctx).e.start,((Expression2Context)_localctx).e.stop):null), newVarName);
								if (modoSetExpression != 0 )
									setExpressionVars.put((((Expression2Context)_localctx).pre_gen!=null?_input.getText(((Expression2Context)_localctx).pre_gen.start,((Expression2Context)_localctx).pre_gen.stop):null) + (((Expression2Context)_localctx).e!=null?_input.getText(((Expression2Context)_localctx).e.start,((Expression2Context)_localctx).e.stop):null), newVarName);
								types.put((((Expression2Context)_localctx).pre_gen!=null?_input.getText(((Expression2Context)_localctx).pre_gen.start,((Expression2Context)_localctx).pre_gen.stop):null) + (((Expression2Context)_localctx).e!=null?_input.getText(((Expression2Context)_localctx).e.start,((Expression2Context)_localctx).e.stop):null), getChildType(types.get((((Expression2Context)_localctx).e!=null?_input.getText(((Expression2Context)_localctx).e.start,((Expression2Context)_localctx).e.stop):null)), 0));
								
								String e = memory.get((((Expression2Context)_localctx).e!=null?_input.getText(((Expression2Context)_localctx).e.start,((Expression2Context)_localctx).e.stop):null));
								print("prolog_call(min(" + e + "," + newVarName + "))");
							}
						}
						else if ((((Expression2Context)_localctx).pre_gen!=null?_input.getText(((Expression2Context)_localctx).pre_gen.start,((Expression2Context)_localctx).pre_gen.stop):null).startsWith("max")){
							if (memory.get((((Expression2Context)_localctx).pre_gen!=null?_input.getText(((Expression2Context)_localctx).pre_gen.start,((Expression2Context)_localctx).pre_gen.stop):null) + (((Expression2Context)_localctx).e!=null?_input.getText(((Expression2Context)_localctx).e.start,((Expression2Context)_localctx).e.stop):null)) == null) {
								String newVarName = newVar();
								memory.put((((Expression2Context)_localctx).pre_gen!=null?_input.getText(((Expression2Context)_localctx).pre_gen.start,((Expression2Context)_localctx).pre_gen.stop):null) + (((Expression2Context)_localctx).e!=null?_input.getText(((Expression2Context)_localctx).e.start,((Expression2Context)_localctx).e.stop):null), newVarName);
								if (modoSetExpression != 0 )
									setExpressionVars.put((((Expression2Context)_localctx).pre_gen!=null?_input.getText(((Expression2Context)_localctx).pre_gen.start,((Expression2Context)_localctx).pre_gen.stop):null) + (((Expression2Context)_localctx).e!=null?_input.getText(((Expression2Context)_localctx).e.start,((Expression2Context)_localctx).e.stop):null), newVarName);
								types.put((((Expression2Context)_localctx).pre_gen!=null?_input.getText(((Expression2Context)_localctx).pre_gen.start,((Expression2Context)_localctx).pre_gen.stop):null) + (((Expression2Context)_localctx).e!=null?_input.getText(((Expression2Context)_localctx).e.start,((Expression2Context)_localctx).e.stop):null), getChildType(types.get((((Expression2Context)_localctx).e!=null?_input.getText(((Expression2Context)_localctx).e.start,((Expression2Context)_localctx).e.stop):null)), 0));
								
								String e = memory.get((((Expression2Context)_localctx).e!=null?_input.getText(((Expression2Context)_localctx).e.start,((Expression2Context)_localctx).e.stop):null));
								print("max(" + e + "," + newVarName + ")");
							}
						}
					
				}
				break;

			case 3:
				{
				setState(357); ((Expression2Context)_localctx).e4 = expression4(0);
				setState(358); ((Expression2Context)_localctx).IMGSTART = match(IMGSTART);
				setState(359); ((Expression2Context)_localctx).e0 = expression0();
				setState(360); ((Expression2Context)_localctx).IMGEND = match(IMGEND);
				setState(362);
				switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
				case 1:
					{
					setState(361); ((Expression2Context)_localctx).DECORATION = match(DECORATION);
					}
					break;
				}

						String a, b;
						a = memory.get((((Expression2Context)_localctx).e4!=null?_input.getText(((Expression2Context)_localctx).e4.start,((Expression2Context)_localctx).e4.stop):null));
						b = memory.get((((Expression2Context)_localctx).e0!=null?_input.getText(((Expression2Context)_localctx).e0.start,((Expression2Context)_localctx).e0.stop):null));
						
						if (memory.get((((Expression2Context)_localctx).e4!=null?_input.getText(((Expression2Context)_localctx).e4.start,((Expression2Context)_localctx).e4.stop):null) + (((Expression2Context)_localctx).IMGSTART!=null?((Expression2Context)_localctx).IMGSTART.getText():null) + (((Expression2Context)_localctx).e0!=null?_input.getText(((Expression2Context)_localctx).e0.start,((Expression2Context)_localctx).e0.stop):null) + (((Expression2Context)_localctx).IMGEND!=null?((Expression2Context)_localctx).IMGEND.getText():null) + (((Expression2Context)_localctx).DECORATION!=null?((Expression2Context)_localctx).DECORATION.getText():null)) == null) {
							String newVarName = newVar();
							print("rimg(" + a + "," + b + "," + newVarName + ")");
							memory.put((((Expression2Context)_localctx).e4!=null?_input.getText(((Expression2Context)_localctx).e4.start,((Expression2Context)_localctx).e4.stop):null) + (((Expression2Context)_localctx).IMGSTART!=null?((Expression2Context)_localctx).IMGSTART.getText():null) + (((Expression2Context)_localctx).e0!=null?_input.getText(((Expression2Context)_localctx).e0.start,((Expression2Context)_localctx).e0.stop):null) + (((Expression2Context)_localctx).IMGEND!=null?((Expression2Context)_localctx).IMGEND.getText():null) + (((Expression2Context)_localctx).DECORATION!=null?((Expression2Context)_localctx).DECORATION.getText():null), newVarName);
							String type1 = types.get((((Expression2Context)_localctx).e4!=null?_input.getText(((Expression2Context)_localctx).e4.start,((Expression2Context)_localctx).e4.stop):null));
							String type = "\\power(" + getChildType(type1, 1) + ")";
							types.put((((Expression2Context)_localctx).e4!=null?_input.getText(((Expression2Context)_localctx).e4.start,((Expression2Context)_localctx).e4.stop):null) + (((Expression2Context)_localctx).IMGSTART!=null?((Expression2Context)_localctx).IMGSTART.getText():null) + (((Expression2Context)_localctx).e0!=null?_input.getText(((Expression2Context)_localctx).e0.start,((Expression2Context)_localctx).e0.stop):null) + (((Expression2Context)_localctx).IMGEND!=null?((Expression2Context)_localctx).IMGEND.getText():null) + (((Expression2Context)_localctx).DECORATION!=null?((Expression2Context)_localctx).DECORATION.getText():null), type);
							typeInfo(newVarName, type);
							if (modoSetExpression != 0 )
								setExpressionVars.put((((Expression2Context)_localctx).e4!=null?_input.getText(((Expression2Context)_localctx).e4.start,((Expression2Context)_localctx).e4.stop):null) + (((Expression2Context)_localctx).IMGSTART!=null?((Expression2Context)_localctx).IMGSTART.getText():null) + (((Expression2Context)_localctx).e0!=null?_input.getText(((Expression2Context)_localctx).e0.start,((Expression2Context)_localctx).e0.stop):null) + (((Expression2Context)_localctx).IMGEND!=null?((Expression2Context)_localctx).IMGEND.getText():null) + (((Expression2Context)_localctx).DECORATION!=null?((Expression2Context)_localctx).DECORATION.getText():null), newVarName);
						}
					
				}
				break;

			case 4:
				{
				setState(366); expression3(0);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(401);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(399);
					switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
					case 1:
						{
						_localctx = new Expression2Context(_parentctx, _parentState, _p);
						_localctx.e21 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression2);
						setState(369);
						if (!(10 >= _localctx._p)) throw new FailedPredicateException(this, "10 >= $_p");
						setState(370); ((Expression2Context)_localctx).IN_FUN_P6 = match(IN_FUN_P6);
						setState(371); ((Expression2Context)_localctx).e22 = expression2(11);

						          		String a, b;
						          		a = memory.get((((Expression2Context)_localctx).e21!=null?_input.getText(((Expression2Context)_localctx).e21.start,((Expression2Context)_localctx).e21.stop):null));
						          		b = memory.get((((Expression2Context)_localctx).e22!=null?_input.getText(((Expression2Context)_localctx).e22.start,((Expression2Context)_localctx).e22.stop):null));
						          		
						          		//Si a es una lista, debo convertirla
						          		a = convertToSet((((Expression2Context)_localctx).e21!=null?_input.getText(((Expression2Context)_localctx).e21.start,((Expression2Context)_localctx).e21.stop):null), a);
						          		//Si b es una lista, debo convertirla
						          		b = convertToSet((((Expression2Context)_localctx).e22!=null?_input.getText(((Expression2Context)_localctx).e22.start,((Expression2Context)_localctx).e22.stop):null), b);
						          		
						          		if (memory.get((((Expression2Context)_localctx).e21!=null?_input.getText(((Expression2Context)_localctx).e21.start,((Expression2Context)_localctx).e21.stop):null) + (((Expression2Context)_localctx).IN_FUN_P6!=null?((Expression2Context)_localctx).IN_FUN_P6.getText():null) + (((Expression2Context)_localctx).e22!=null?_input.getText(((Expression2Context)_localctx).e22.start,((Expression2Context)_localctx).e22.stop):null)) == null) {
						          		
						          			String newVarName = newVar();
						          		
						          			if ((((Expression2Context)_localctx).IN_FUN_P6!=null?((Expression2Context)_localctx).IN_FUN_P6.getText():null).equals("\\dres")){
						          				print("dres(" + a + "," + b + "," + newVarName + ")");
						          				memory.put((((Expression2Context)_localctx).e21!=null?_input.getText(((Expression2Context)_localctx).e21.start,((Expression2Context)_localctx).e21.stop):null) + "\\dres" + (((Expression2Context)_localctx).e22!=null?_input.getText(((Expression2Context)_localctx).e22.start,((Expression2Context)_localctx).e22.stop):null), newVarName);
						          				String type2 = types.get((((Expression2Context)_localctx).e22!=null?_input.getText(((Expression2Context)_localctx).e22.start,((Expression2Context)_localctx).e22.stop):null));
						          				ArrayList<String> leftAndRight = leftAndRightTypes(type2);
						          				String type = "\\power((" + leftAndRight.get(0) + ")\\cross(" + leftAndRight.get(1) + "))";
						          				types.put((((Expression2Context)_localctx).e21!=null?_input.getText(((Expression2Context)_localctx).e21.start,((Expression2Context)_localctx).e21.stop):null) + "\\dres" + (((Expression2Context)_localctx).e22!=null?_input.getText(((Expression2Context)_localctx).e22.start,((Expression2Context)_localctx).e22.stop):null), type);
						          				typeInfo(newVarName, type);
						          				if (modoSetExpression != 0 )
						          					setExpressionVars.put((((Expression2Context)_localctx).e21!=null?_input.getText(((Expression2Context)_localctx).e21.start,((Expression2Context)_localctx).e21.stop):null) + "\\dres" + (((Expression2Context)_localctx).e22!=null?_input.getText(((Expression2Context)_localctx).e22.start,((Expression2Context)_localctx).e22.stop):null), newVarName);
						          			}
						          			else if ((((Expression2Context)_localctx).IN_FUN_P6!=null?((Expression2Context)_localctx).IN_FUN_P6.getText():null).equals("\\ndres")){
						          				print("ndres(" + a + "," + b + "," + newVarName + ")");
						          				memory.put((((Expression2Context)_localctx).e21!=null?_input.getText(((Expression2Context)_localctx).e21.start,((Expression2Context)_localctx).e21.stop):null) + "\\ndres" + (((Expression2Context)_localctx).e22!=null?_input.getText(((Expression2Context)_localctx).e22.start,((Expression2Context)_localctx).e22.stop):null), newVarName);
						          				String type2 = types.get((((Expression2Context)_localctx).e22!=null?_input.getText(((Expression2Context)_localctx).e22.start,((Expression2Context)_localctx).e22.stop):null));
						          				ArrayList<String> leftAndRight = leftAndRightTypes(type2);
						          				String type = "\\power((" + leftAndRight.get(0) + ")\\cross(" + leftAndRight.get(1) + "))";
						          				types.put((((Expression2Context)_localctx).e21!=null?_input.getText(((Expression2Context)_localctx).e21.start,((Expression2Context)_localctx).e21.stop):null) + "\\ndres" + (((Expression2Context)_localctx).e22!=null?_input.getText(((Expression2Context)_localctx).e22.start,((Expression2Context)_localctx).e22.stop):null), type);
						          				typeInfo(newVarName, type);
						          				if (modoSetExpression != 0 )
						          					setExpressionVars.put((((Expression2Context)_localctx).e21!=null?_input.getText(((Expression2Context)_localctx).e21.start,((Expression2Context)_localctx).e21.stop):null) + "\\ndres" + (((Expression2Context)_localctx).e22!=null?_input.getText(((Expression2Context)_localctx).e22.start,((Expression2Context)_localctx).e22.stop):null), newVarName);
						          			}
						          			else if ((((Expression2Context)_localctx).IN_FUN_P6!=null?((Expression2Context)_localctx).IN_FUN_P6.getText():null).equals("\\rres")){
						          				print("rres(" + b + "," + a + "," + newVarName + ")");
						          				memory.put((((Expression2Context)_localctx).e21!=null?_input.getText(((Expression2Context)_localctx).e21.start,((Expression2Context)_localctx).e21.stop):null) + "\\rres" + (((Expression2Context)_localctx).e22!=null?_input.getText(((Expression2Context)_localctx).e22.start,((Expression2Context)_localctx).e22.stop):null), newVarName);
						          				String type1 = types.get((((Expression2Context)_localctx).e21!=null?_input.getText(((Expression2Context)_localctx).e21.start,((Expression2Context)_localctx).e21.stop):null));
						          				ArrayList<String> leftAndRight = leftAndRightTypes(type1);
						          				String type = "\\power((" + leftAndRight.get(0) + ")\\cross(" + leftAndRight.get(1) + "))";
						          				types.put((((Expression2Context)_localctx).e21!=null?_input.getText(((Expression2Context)_localctx).e21.start,((Expression2Context)_localctx).e21.stop):null) + "\\rres" + (((Expression2Context)_localctx).e22!=null?_input.getText(((Expression2Context)_localctx).e22.start,((Expression2Context)_localctx).e22.stop):null), type);
						          				typeInfo(newVarName, type);
						          				if (modoSetExpression != 0 )
						          					setExpressionVars.put((((Expression2Context)_localctx).e21!=null?_input.getText(((Expression2Context)_localctx).e21.start,((Expression2Context)_localctx).e21.stop):null) + "\\rres" + (((Expression2Context)_localctx).e22!=null?_input.getText(((Expression2Context)_localctx).e22.start,((Expression2Context)_localctx).e22.stop):null), newVarName);
						          			}
						          			else if ((((Expression2Context)_localctx).IN_FUN_P6!=null?((Expression2Context)_localctx).IN_FUN_P6.getText():null).equals("\\nrres")){
						          				print("nrres(" + b + "," + a + "," + newVarName + ")");
						          				memory.put((((Expression2Context)_localctx).e21!=null?_input.getText(((Expression2Context)_localctx).e21.start,((Expression2Context)_localctx).e21.stop):null) + "\\nrres" + (((Expression2Context)_localctx).e22!=null?_input.getText(((Expression2Context)_localctx).e22.start,((Expression2Context)_localctx).e22.stop):null), newVarName);
						          				String type1 = types.get((((Expression2Context)_localctx).e21!=null?_input.getText(((Expression2Context)_localctx).e21.start,((Expression2Context)_localctx).e21.stop):null));
						          				ArrayList<String> leftAndRight = leftAndRightTypes(type1);
						          				String type = "\\power((" + leftAndRight.get(0) + ")\\cross(" + leftAndRight.get(1) + "))";
						          				types.put((((Expression2Context)_localctx).e21!=null?_input.getText(((Expression2Context)_localctx).e21.start,((Expression2Context)_localctx).e21.stop):null) + "\\nrres" + (((Expression2Context)_localctx).e22!=null?_input.getText(((Expression2Context)_localctx).e22.start,((Expression2Context)_localctx).e22.stop):null), type);
						          				typeInfo(newVarName, type);
						          				if (modoSetExpression != 0 )
						          					setExpressionVars.put((((Expression2Context)_localctx).e21!=null?_input.getText(((Expression2Context)_localctx).e21.start,((Expression2Context)_localctx).e21.stop):null) + "\\nrres" + (((Expression2Context)_localctx).e22!=null?_input.getText(((Expression2Context)_localctx).e22.start,((Expression2Context)_localctx).e22.stop):null), newVarName);
						          			}
						          		}
						          	
						}
						break;

					case 2:
						{
						_localctx = new Expression2Context(_parentctx, _parentState, _p);
						_localctx.e21 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression2);
						setState(374);
						if (!(9 >= _localctx._p)) throw new FailedPredicateException(this, "9 >= $_p");
						setState(375); ((Expression2Context)_localctx).IN_FUN_P5 = match(IN_FUN_P5);
						setState(376); ((Expression2Context)_localctx).e22 = expression2(10);

						          		String a, b;
						          		a = memory.get((((Expression2Context)_localctx).e21!=null?_input.getText(((Expression2Context)_localctx).e21.start,((Expression2Context)_localctx).e21.stop):null));
						          		b = memory.get((((Expression2Context)_localctx).e22!=null?_input.getText(((Expression2Context)_localctx).e22.start,((Expression2Context)_localctx).e22.stop):null));
						          		
						          		//Si a es una lista, debo convertirla
						          		a = convertToSet((((Expression2Context)_localctx).e21!=null?_input.getText(((Expression2Context)_localctx).e21.start,((Expression2Context)_localctx).e21.stop):null), a);
						          		//Si b es una lista, debo convertirla
						          		b = convertToSet((((Expression2Context)_localctx).e22!=null?_input.getText(((Expression2Context)_localctx).e22.start,((Expression2Context)_localctx).e22.stop):null), b);
						          		
						          		if (memory.get((((Expression2Context)_localctx).e21!=null?_input.getText(((Expression2Context)_localctx).e21.start,((Expression2Context)_localctx).e21.stop):null) + (((Expression2Context)_localctx).IN_FUN_P5!=null?((Expression2Context)_localctx).IN_FUN_P5.getText():null) + (((Expression2Context)_localctx).e22!=null?_input.getText(((Expression2Context)_localctx).e22.start,((Expression2Context)_localctx).e22.stop):null)) == null) {
						          		
						          			String newVarName = newVar();
						          		
						          			if ((((Expression2Context)_localctx).IN_FUN_P5!=null?((Expression2Context)_localctx).IN_FUN_P5.getText():null).equals("\\oplus")){
						          				print("oplus(" + a + "," + b + "," + newVarName + ")");
						          				memory.put((((Expression2Context)_localctx).e21!=null?_input.getText(((Expression2Context)_localctx).e21.start,((Expression2Context)_localctx).e21.stop):null) + "\\oplus" + (((Expression2Context)_localctx).e22!=null?_input.getText(((Expression2Context)_localctx).e22.start,((Expression2Context)_localctx).e22.stop):null), newVarName);
						          				String type1 = types.get((((Expression2Context)_localctx).e21!=null?_input.getText(((Expression2Context)_localctx).e21.start,((Expression2Context)_localctx).e21.stop):null));
						          				ArrayList<String> leftAndRight = leftAndRightTypes(type1);
						          				String type = "\\power((" + leftAndRight.get(0) + ")\\cross(" + leftAndRight.get(1) + "))";
						          				types.put((((Expression2Context)_localctx).e21!=null?_input.getText(((Expression2Context)_localctx).e21.start,((Expression2Context)_localctx).e21.stop):null) + "\\oplus" + (((Expression2Context)_localctx).e22!=null?_input.getText(((Expression2Context)_localctx).e22.start,((Expression2Context)_localctx).e22.stop):null), type);
						          				typeInfo(newVarName, type);
						          				if (modoSetExpression != 0 )
						          					setExpressionVars.put((((Expression2Context)_localctx).e21!=null?_input.getText(((Expression2Context)_localctx).e21.start,((Expression2Context)_localctx).e21.stop):null) + "\\oplus" + (((Expression2Context)_localctx).e22!=null?_input.getText(((Expression2Context)_localctx).e22.start,((Expression2Context)_localctx).e22.stop):null), newVarName);
						          			}
						          		}
						          	
						}
						break;

					case 3:
						{
						_localctx = new Expression2Context(_parentctx, _parentState, _p);
						_localctx.e21 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression2);
						setState(379);
						if (!(8 >= _localctx._p)) throw new FailedPredicateException(this, "8 >= $_p");
						setState(380); ((Expression2Context)_localctx).IN_FUN_P4 = match(IN_FUN_P4);
						setState(381); ((Expression2Context)_localctx).e22 = expression2(9);

						          		String a, b;
						          		
						          		a = memory.get((((Expression2Context)_localctx).e21!=null?_input.getText(((Expression2Context)_localctx).e21.start,((Expression2Context)_localctx).e21.stop):null));
						          		b = memory.get((((Expression2Context)_localctx).e22!=null?_input.getText(((Expression2Context)_localctx).e22.start,((Expression2Context)_localctx).e22.stop):null));

						          		if (memory.get((((Expression2Context)_localctx).e21!=null?_input.getText(((Expression2Context)_localctx).e21.start,((Expression2Context)_localctx).e21.stop):null) + (((Expression2Context)_localctx).IN_FUN_P4!=null?((Expression2Context)_localctx).IN_FUN_P4.getText():null) + (((Expression2Context)_localctx).e22!=null?_input.getText(((Expression2Context)_localctx).e22.start,((Expression2Context)_localctx).e22.stop):null)) == null) {
						          		
						          			String newVarName = newVar();
						          			Boolean isNumeric = false; 
						          		
						          			if ((((Expression2Context)_localctx).IN_FUN_P4!=null?((Expression2Context)_localctx).IN_FUN_P4.getText():null).equals("*")){
						          				print( newVarName + " is " + a + "*" + b );
						          				memory.put((((Expression2Context)_localctx).e21!=null?_input.getText(((Expression2Context)_localctx).e21.start,((Expression2Context)_localctx).e21.stop):null) + "*" + (((Expression2Context)_localctx).e22!=null?_input.getText(((Expression2Context)_localctx).e22.start,((Expression2Context)_localctx).e22.stop):null), newVarName);
						          				if (modoSetExpression != 0 )
						          					setExpressionVars.put((((Expression2Context)_localctx).e21!=null?_input.getText(((Expression2Context)_localctx).e21.start,((Expression2Context)_localctx).e21.stop):null) + "*" + (((Expression2Context)_localctx).e22!=null?_input.getText(((Expression2Context)_localctx).e22.start,((Expression2Context)_localctx).e22.stop):null), newVarName);
						          				isNumeric = true;
						          			}
						          			else if ((((Expression2Context)_localctx).IN_FUN_P4!=null?((Expression2Context)_localctx).IN_FUN_P4.getText():null).equals("\\div")) {
						          				print( newVarName + " is div(" + a + "," + b + ")" );
						          				memory.put((((Expression2Context)_localctx).e21!=null?_input.getText(((Expression2Context)_localctx).e21.start,((Expression2Context)_localctx).e21.stop):null) + "\\div" + (((Expression2Context)_localctx).e22!=null?_input.getText(((Expression2Context)_localctx).e22.start,((Expression2Context)_localctx).e22.stop):null), newVarName);
						          				if (modoSetExpression != 0 )
						          					setExpressionVars.put((((Expression2Context)_localctx).e21!=null?_input.getText(((Expression2Context)_localctx).e21.start,((Expression2Context)_localctx).e21.stop):null) + "\\div" + (((Expression2Context)_localctx).e22!=null?_input.getText(((Expression2Context)_localctx).e22.start,((Expression2Context)_localctx).e22.stop):null), newVarName);
						          				isNumeric = true;
						          			}
						          			else if ((((Expression2Context)_localctx).IN_FUN_P4!=null?((Expression2Context)_localctx).IN_FUN_P4.getText():null).equals("\\mod")){
						          				print( newVarName + " is mod(" + a + "," + b + ")" );
						          				memory.put((((Expression2Context)_localctx).e21!=null?_input.getText(((Expression2Context)_localctx).e21.start,((Expression2Context)_localctx).e21.stop):null) + "\\mod" + (((Expression2Context)_localctx).e22!=null?_input.getText(((Expression2Context)_localctx).e22.start,((Expression2Context)_localctx).e22.stop):null), newVarName);
						          				if (modoSetExpression != 0 )
						          					setExpressionVars.put((((Expression2Context)_localctx).e21!=null?_input.getText(((Expression2Context)_localctx).e21.start,((Expression2Context)_localctx).e21.stop):null) + "\\mod" + (((Expression2Context)_localctx).e22!=null?_input.getText(((Expression2Context)_localctx).e22.start,((Expression2Context)_localctx).e22.stop):null), newVarName);
						          				isNumeric = true;
						          			}
						          			else if ((((Expression2Context)_localctx).IN_FUN_P4!=null?((Expression2Context)_localctx).IN_FUN_P4.getText():null).equals("\\cap")){
						          				//Si a es una lista, debo convertirla
						          				a = convertToSet((((Expression2Context)_localctx).e21!=null?_input.getText(((Expression2Context)_localctx).e21.start,((Expression2Context)_localctx).e21.stop):null), a);
						          				//Si b es una lista, debo convertirla
						          				b = convertToSet((((Expression2Context)_localctx).e22!=null?_input.getText(((Expression2Context)_localctx).e22.start,((Expression2Context)_localctx).e22.stop):null), b);
						          								
						          				print("dinters(" + a + "," + b + "," + newVarName + ")");
						          				memory.put((((Expression2Context)_localctx).e21!=null?_input.getText(((Expression2Context)_localctx).e21.start,((Expression2Context)_localctx).e21.stop):null) + "\\cap" + (((Expression2Context)_localctx).e22!=null?_input.getText(((Expression2Context)_localctx).e22.start,((Expression2Context)_localctx).e22.stop):null), newVarName);
						          				String type = types.get((((Expression2Context)_localctx).e21!=null?_input.getText(((Expression2Context)_localctx).e21.start,((Expression2Context)_localctx).e21.stop):null));
						          				if (isSequence(getType(type)))
						          					type = "\\power(\\nat\\cross(" + leftAndRightTypes(type).get(1) + "))";
						          				types.put((((Expression2Context)_localctx).e21!=null?_input.getText(((Expression2Context)_localctx).e21.start,((Expression2Context)_localctx).e21.stop):null) + "\\cap" + (((Expression2Context)_localctx).e22!=null?_input.getText(((Expression2Context)_localctx).e22.start,((Expression2Context)_localctx).e22.stop):null), type);
						          				//typeInfo(newVarName, type);
						          				if (modoSetExpression != 0 )
						          					setExpressionVars.put((((Expression2Context)_localctx).e21!=null?_input.getText(((Expression2Context)_localctx).e21.start,((Expression2Context)_localctx).e21.stop):null) + "\\cap" + (((Expression2Context)_localctx).e22!=null?_input.getText(((Expression2Context)_localctx).e22.start,((Expression2Context)_localctx).e22.stop):null), newVarName);
						          			}
						          			else if ((((Expression2Context)_localctx).IN_FUN_P4!=null?((Expression2Context)_localctx).IN_FUN_P4.getText():null).equals("\\comp")){
						          				//Si a es una lista, debo convertirla
						          				a = convertToSet((((Expression2Context)_localctx).e21!=null?_input.getText(((Expression2Context)_localctx).e21.start,((Expression2Context)_localctx).e21.stop):null), a);
						          				//Si b es una lista, debo convertirla
						          				b = convertToSet((((Expression2Context)_localctx).e22!=null?_input.getText(((Expression2Context)_localctx).e22.start,((Expression2Context)_localctx).e22.stop):null), b);
						          						
						          				print("comp(" + a + "," + b + "," + newVarName + ")");
						          				memory.put((((Expression2Context)_localctx).e21!=null?_input.getText(((Expression2Context)_localctx).e21.start,((Expression2Context)_localctx).e21.stop):null) + "\\comp" + (((Expression2Context)_localctx).e22!=null?_input.getText(((Expression2Context)_localctx).e22.start,((Expression2Context)_localctx).e22.stop):null), newVarName);
						          				String type1 = types.get((((Expression2Context)_localctx).e21!=null?_input.getText(((Expression2Context)_localctx).e21.start,((Expression2Context)_localctx).e21.stop):null));
						          				String type2 = types.get((((Expression2Context)_localctx).e22!=null?_input.getText(((Expression2Context)_localctx).e22.start,((Expression2Context)_localctx).e22.stop):null));
						          				String type = "\\power((" + leftAndRightTypes(type1).get(0) + ")\\cross(" + leftAndRightTypes(type2).get(1) + "))";
						          				types.put((((Expression2Context)_localctx).e21!=null?_input.getText(((Expression2Context)_localctx).e21.start,((Expression2Context)_localctx).e21.stop):null) + "\\comp" + (((Expression2Context)_localctx).e22!=null?_input.getText(((Expression2Context)_localctx).e22.start,((Expression2Context)_localctx).e22.stop):null), type);
						          				typeInfo(newVarName, type);
						          				if (modoSetExpression != 0 )
						          					setExpressionVars.put((((Expression2Context)_localctx).e21!=null?_input.getText(((Expression2Context)_localctx).e21.start,((Expression2Context)_localctx).e21.stop):null) + "\\comp" + (((Expression2Context)_localctx).e22!=null?_input.getText(((Expression2Context)_localctx).e22.start,((Expression2Context)_localctx).e22.stop):null), newVarName);
						          			}
						          			else if ((((Expression2Context)_localctx).IN_FUN_P4!=null?((Expression2Context)_localctx).IN_FUN_P4.getText():null).equals("\\circ")){
						          				//Si a es una lista, debo convertirla
						          				a = convertToSet((((Expression2Context)_localctx).e21!=null?_input.getText(((Expression2Context)_localctx).e21.start,((Expression2Context)_localctx).e21.stop):null), a);
						          				//Si b es una lista, debo convertirla
						          				b = convertToSet((((Expression2Context)_localctx).e22!=null?_input.getText(((Expression2Context)_localctx).e22.start,((Expression2Context)_localctx).e22.stop):null), b);
						          				
						          				print("circ(" + a + "," + b + "," + newVarName + ")");
						          				memory.put((((Expression2Context)_localctx).e21!=null?_input.getText(((Expression2Context)_localctx).e21.start,((Expression2Context)_localctx).e21.stop):null) + "\\circ" + (((Expression2Context)_localctx).e22!=null?_input.getText(((Expression2Context)_localctx).e22.start,((Expression2Context)_localctx).e22.stop):null), newVarName);
						          				String type1 = types.get((((Expression2Context)_localctx).e21!=null?_input.getText(((Expression2Context)_localctx).e21.start,((Expression2Context)_localctx).e21.stop):null));
						          				type1 = leftAndRightTypes(type1).get(1);
						          				String type = "\\power((" + type1 + ")\\cross(" + type1 + "))";
						          				types.put((((Expression2Context)_localctx).e21!=null?_input.getText(((Expression2Context)_localctx).e21.start,((Expression2Context)_localctx).e21.stop):null) + "\\circ" + (((Expression2Context)_localctx).e22!=null?_input.getText(((Expression2Context)_localctx).e22.start,((Expression2Context)_localctx).e22.stop):null), type);
						          				typeInfo(newVarName, type);
						          				if (modoSetExpression != 0 )
						          					setExpressionVars.put((((Expression2Context)_localctx).e21!=null?_input.getText(((Expression2Context)_localctx).e21.start,((Expression2Context)_localctx).e21.stop):null) + "\\circ" + (((Expression2Context)_localctx).e22!=null?_input.getText(((Expression2Context)_localctx).e22.start,((Expression2Context)_localctx).e22.stop):null), newVarName);
						          			}
						          			else if ((((Expression2Context)_localctx).IN_FUN_P4!=null?((Expression2Context)_localctx).IN_FUN_P4.getText():null).equals("\\extract")){
						          				print("extract(" + a + "," + b + "," + newVarName + ")");
						          				memory.put((((Expression2Context)_localctx).e21!=null?_input.getText(((Expression2Context)_localctx).e21.start,((Expression2Context)_localctx).e21.stop):null) + "\\extract" + (((Expression2Context)_localctx).e22!=null?_input.getText(((Expression2Context)_localctx).e22.start,((Expression2Context)_localctx).e22.stop):null), newVarName);
						          				String type = types.get((((Expression2Context)_localctx).e22!=null?_input.getText(((Expression2Context)_localctx).e22.start,((Expression2Context)_localctx).e22.stop):null));
						          				types.put((((Expression2Context)_localctx).e21!=null?_input.getText(((Expression2Context)_localctx).e21.start,((Expression2Context)_localctx).e21.stop):null) + "\\extract" + (((Expression2Context)_localctx).e22!=null?_input.getText(((Expression2Context)_localctx).e22.start,((Expression2Context)_localctx).e22.stop):null), type);
						          				typeInfo(newVarName, type);
						          				if (modoSetExpression != 0 )
						          					setExpressionVars.put((((Expression2Context)_localctx).e21!=null?_input.getText(((Expression2Context)_localctx).e21.start,((Expression2Context)_localctx).e21.stop):null) + "\\extract" + (((Expression2Context)_localctx).e22!=null?_input.getText(((Expression2Context)_localctx).e22.start,((Expression2Context)_localctx).e22.stop):null), newVarName);
						          			}
						          			else if ((((Expression2Context)_localctx).IN_FUN_P4!=null?((Expression2Context)_localctx).IN_FUN_P4.getText():null).equals("\\filter")){
						          				print("filter(" + a + "," + b + "," + newVarName + ")");
						          				memory.put((((Expression2Context)_localctx).e21!=null?_input.getText(((Expression2Context)_localctx).e21.start,((Expression2Context)_localctx).e21.stop):null) + "\\filter" + (((Expression2Context)_localctx).e22!=null?_input.getText(((Expression2Context)_localctx).e22.start,((Expression2Context)_localctx).e22.stop):null), newVarName);
						          				String type = types.get((((Expression2Context)_localctx).e21!=null?_input.getText(((Expression2Context)_localctx).e21.start,((Expression2Context)_localctx).e21.stop):null));
						          				types.put((((Expression2Context)_localctx).e21!=null?_input.getText(((Expression2Context)_localctx).e21.start,((Expression2Context)_localctx).e21.stop):null) + "\\filter" + (((Expression2Context)_localctx).e22!=null?_input.getText(((Expression2Context)_localctx).e22.start,((Expression2Context)_localctx).e22.stop):null), type);
						          				typeInfo(newVarName, type);
						          				if (modoSetExpression != 0 )
						          					setExpressionVars.put((((Expression2Context)_localctx).e21!=null?_input.getText(((Expression2Context)_localctx).e21.start,((Expression2Context)_localctx).e21.stop):null) + "\\filter" + (((Expression2Context)_localctx).e22!=null?_input.getText(((Expression2Context)_localctx).e22.start,((Expression2Context)_localctx).e22.stop):null), newVarName);
						          			}
						          			
						          			if (isNumeric) {
						          				print(newVarName + " in " + printInfo("\\num"));
						          				types.put((((Expression2Context)_localctx).e21!=null?_input.getText(((Expression2Context)_localctx).e21.start,((Expression2Context)_localctx).e21.stop):null) + (((Expression2Context)_localctx).IN_FUN_P4!=null?((Expression2Context)_localctx).IN_FUN_P4.getText():null) + (((Expression2Context)_localctx).e22!=null?_input.getText(((Expression2Context)_localctx).e22.start,((Expression2Context)_localctx).e22.stop):null), "\\num");
						          			}
						          		}
						          	
						}
						break;

					case 4:
						{
						_localctx = new Expression2Context(_parentctx, _parentState, _p);
						_localctx.e21 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression2);
						setState(384);
						if (!(7 >= _localctx._p)) throw new FailedPredicateException(this, "7 >= $_p");
						setState(385); ((Expression2Context)_localctx).IN_FUN_P3 = match(IN_FUN_P3);
						setState(386); ((Expression2Context)_localctx).e22 = expression2(8);

						          		String a, b;
						          		a = memory.get((((Expression2Context)_localctx).e21!=null?_input.getText(((Expression2Context)_localctx).e21.start,((Expression2Context)_localctx).e21.stop):null));
						          		b = memory.get((((Expression2Context)_localctx).e22!=null?_input.getText(((Expression2Context)_localctx).e22.start,((Expression2Context)_localctx).e22.stop):null));
						          		
						          		if (memory.get((((Expression2Context)_localctx).e21!=null?_input.getText(((Expression2Context)_localctx).e21.start,((Expression2Context)_localctx).e21.stop):null) + (((Expression2Context)_localctx).IN_FUN_P3!=null?((Expression2Context)_localctx).IN_FUN_P3.getText():null) + (((Expression2Context)_localctx).e22!=null?_input.getText(((Expression2Context)_localctx).e22.start,((Expression2Context)_localctx).e22.stop):null)) == null) {
						          		
						          			String newVarName = newVar();
						          			Boolean isNumeric = false; 
						          			
						          		
						          			if ((((Expression2Context)_localctx).IN_FUN_P3!=null?((Expression2Context)_localctx).IN_FUN_P3.getText():null).equals("+")){
						          				print( newVarName + " is " + a + "+" + b );
						          				memory.put((((Expression2Context)_localctx).e21!=null?_input.getText(((Expression2Context)_localctx).e21.start,((Expression2Context)_localctx).e21.stop):null) + "+" + (((Expression2Context)_localctx).e22!=null?_input.getText(((Expression2Context)_localctx).e22.start,((Expression2Context)_localctx).e22.stop):null), newVarName);
						          				if (modoSetExpression != 0 )
						          					setExpressionVars.put((((Expression2Context)_localctx).e21!=null?_input.getText(((Expression2Context)_localctx).e21.start,((Expression2Context)_localctx).e21.stop):null) + "+" + (((Expression2Context)_localctx).e22!=null?_input.getText(((Expression2Context)_localctx).e22.start,((Expression2Context)_localctx).e22.stop):null), newVarName);
						          				isNumeric = true;
						          			}
						          			else if ((((Expression2Context)_localctx).IN_FUN_P3!=null?((Expression2Context)_localctx).IN_FUN_P3.getText():null).equals("-")) {
						          				print( newVarName + " is " + a + "-" + b );
						          				memory.put((((Expression2Context)_localctx).e21!=null?_input.getText(((Expression2Context)_localctx).e21.start,((Expression2Context)_localctx).e21.stop):null) + "-" + (((Expression2Context)_localctx).e22!=null?_input.getText(((Expression2Context)_localctx).e22.start,((Expression2Context)_localctx).e22.stop):null), newVarName);
						          				if (modoSetExpression != 0 )
						          					setExpressionVars.put((((Expression2Context)_localctx).e21!=null?_input.getText(((Expression2Context)_localctx).e21.start,((Expression2Context)_localctx).e21.stop):null) + "-" + (((Expression2Context)_localctx).e22!=null?_input.getText(((Expression2Context)_localctx).e22.start,((Expression2Context)_localctx).e22.stop):null), newVarName);
						          				isNumeric = true;
						          			}
						          			else if ((((Expression2Context)_localctx).IN_FUN_P3!=null?((Expression2Context)_localctx).IN_FUN_P3.getText():null).equals("\\cup")){
						          			
						          				//Si a es una lista, debo convertirla
						          				a = convertToSet((((Expression2Context)_localctx).e21!=null?_input.getText(((Expression2Context)_localctx).e21.start,((Expression2Context)_localctx).e21.stop):null), a);
						          				//Si b es una lista, debo convertirla
						          				b = convertToSet((((Expression2Context)_localctx).e22!=null?_input.getText(((Expression2Context)_localctx).e22.start,((Expression2Context)_localctx).e22.stop):null), b);
						          				
						          				print("dun(" + a + "," + b + "," + newVarName + ")");
						          				memory.put((((Expression2Context)_localctx).e21!=null?_input.getText(((Expression2Context)_localctx).e21.start,((Expression2Context)_localctx).e21.stop):null) + "\\cup" + (((Expression2Context)_localctx).e22!=null?_input.getText(((Expression2Context)_localctx).e22.start,((Expression2Context)_localctx).e22.stop):null), newVarName);
						          				String type = types.get((((Expression2Context)_localctx).e21!=null?_input.getText(((Expression2Context)_localctx).e21.start,((Expression2Context)_localctx).e21.stop):null));
						          				if (isSequence(getType(type)))
						          					type = "\\power(\\nat\\cross(" + leftAndRightTypes(type).get(1) + "))";
						          				types.put((((Expression2Context)_localctx).e21!=null?_input.getText(((Expression2Context)_localctx).e21.start,((Expression2Context)_localctx).e21.stop):null) + "\\cup" + (((Expression2Context)_localctx).e22!=null?_input.getText(((Expression2Context)_localctx).e22.start,((Expression2Context)_localctx).e22.stop):null), type);
						          				typeInfo(newVarName, type);
						          				if (modoSetExpression != 0 )
						          					setExpressionVars.put((((Expression2Context)_localctx).e21!=null?_input.getText(((Expression2Context)_localctx).e21.start,((Expression2Context)_localctx).e21.stop):null) + "\\cup" + (((Expression2Context)_localctx).e22!=null?_input.getText(((Expression2Context)_localctx).e22.start,((Expression2Context)_localctx).e22.stop):null), newVarName);
						          			}
						          			else if ((((Expression2Context)_localctx).IN_FUN_P3!=null?((Expression2Context)_localctx).IN_FUN_P3.getText():null).equals("\\setminus")){
						          				//Si a es una lista, debo convertirla
						          				a = convertToSet((((Expression2Context)_localctx).e21!=null?_input.getText(((Expression2Context)_localctx).e21.start,((Expression2Context)_localctx).e21.stop):null), a);
						          				//Si b es una lista, debo convertirla
						          				b = convertToSet((((Expression2Context)_localctx).e22!=null?_input.getText(((Expression2Context)_localctx).e22.start,((Expression2Context)_localctx).e22.stop):null), b);
						          		
						          				print("diff(" + a + "," + b + "," + newVarName + ")");
						          				memory.put((((Expression2Context)_localctx).e21!=null?_input.getText(((Expression2Context)_localctx).e21.start,((Expression2Context)_localctx).e21.stop):null) + "\\setminus" + (((Expression2Context)_localctx).e22!=null?_input.getText(((Expression2Context)_localctx).e22.start,((Expression2Context)_localctx).e22.stop):null), newVarName);
						          				String type = types.get((((Expression2Context)_localctx).e21!=null?_input.getText(((Expression2Context)_localctx).e21.start,((Expression2Context)_localctx).e21.stop):null));
						          				if (isSequence(getType(type)))
						          					type = "\\power(\\nat\\cross(" + leftAndRightTypes(type).get(1) + "))";
						          				types.put((((Expression2Context)_localctx).e21!=null?_input.getText(((Expression2Context)_localctx).e21.start,((Expression2Context)_localctx).e21.stop):null) + "\\setminus" + (((Expression2Context)_localctx).e22!=null?_input.getText(((Expression2Context)_localctx).e22.start,((Expression2Context)_localctx).e22.stop):null), type);
						          				typeInfo(newVarName, type);
						          				if (modoSetExpression != 0 )
						          					setExpressionVars.put((((Expression2Context)_localctx).e21!=null?_input.getText(((Expression2Context)_localctx).e21.start,((Expression2Context)_localctx).e21.stop):null) + "\\setminus" + (((Expression2Context)_localctx).e22!=null?_input.getText(((Expression2Context)_localctx).e22.start,((Expression2Context)_localctx).e22.stop):null), newVarName);
						          			}
						          			else if ((((Expression2Context)_localctx).IN_FUN_P3!=null?((Expression2Context)_localctx).IN_FUN_P3.getText():null).equals("\\cat")){
						          				print("prolog_call(append(" + a + "," + b + "," + newVarName + "))");
						          				memory.put((((Expression2Context)_localctx).e21!=null?_input.getText(((Expression2Context)_localctx).e21.start,((Expression2Context)_localctx).e21.stop):null) + "\\cat" + (((Expression2Context)_localctx).e22!=null?_input.getText(((Expression2Context)_localctx).e22.start,((Expression2Context)_localctx).e22.stop):null), newVarName);
						          				String type = types.get((((Expression2Context)_localctx).e21!=null?_input.getText(((Expression2Context)_localctx).e21.start,((Expression2Context)_localctx).e21.stop):null));
						          				types.put((((Expression2Context)_localctx).e21!=null?_input.getText(((Expression2Context)_localctx).e21.start,((Expression2Context)_localctx).e21.stop):null) + "\\cat" + (((Expression2Context)_localctx).e22!=null?_input.getText(((Expression2Context)_localctx).e22.start,((Expression2Context)_localctx).e22.stop):null), type);
						          				typeInfo(newVarName, type);
						          				if (modoSetExpression != 0 )
						          					setExpressionVars.put((((Expression2Context)_localctx).e21!=null?_input.getText(((Expression2Context)_localctx).e21.start,((Expression2Context)_localctx).e21.stop):null) + "\\cat" + (((Expression2Context)_localctx).e22!=null?_input.getText(((Expression2Context)_localctx).e22.start,((Expression2Context)_localctx).e22.stop):null), newVarName);
						          			}
						          			
						          			if (isNumeric) {
						          				print(newVarName + " in " + printInfo("\\num"));
						          				types.put((((Expression2Context)_localctx).e21!=null?_input.getText(((Expression2Context)_localctx).e21.start,((Expression2Context)_localctx).e21.stop):null) + (((Expression2Context)_localctx).IN_FUN_P3!=null?((Expression2Context)_localctx).IN_FUN_P3.getText():null) + (((Expression2Context)_localctx).e22!=null?_input.getText(((Expression2Context)_localctx).e22.start,((Expression2Context)_localctx).e22.stop):null), "\\num");
						          			}
						          		}
						          	
						}
						break;

					case 5:
						{
						_localctx = new Expression2Context(_parentctx, _parentState, _p);
						_localctx.e21 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression2);
						setState(389);
						if (!(6 >= _localctx._p)) throw new FailedPredicateException(this, "6 >= $_p");
						setState(390); match(12);
						setState(391); ((Expression2Context)_localctx).e22 = expression2(7);

						          		String a, b;
						          		a = memory.get((((Expression2Context)_localctx).e21!=null?_input.getText(((Expression2Context)_localctx).e21.start,((Expression2Context)_localctx).e21.stop):null));
						          		b = memory.get((((Expression2Context)_localctx).e22!=null?_input.getText(((Expression2Context)_localctx).e22.start,((Expression2Context)_localctx).e22.stop):null));
						          		if (memory.get((((Expression2Context)_localctx).e21!=null?_input.getText(((Expression2Context)_localctx).e21.start,((Expression2Context)_localctx).e21.stop):null) + "\\upto" + (((Expression2Context)_localctx).e22!=null?_input.getText(((Expression2Context)_localctx).e22.start,((Expression2Context)_localctx).e22.stop):null)) == null) {
						          			String newVarName = newVar();
						          			memory.put((((Expression2Context)_localctx).e21!=null?_input.getText(((Expression2Context)_localctx).e21.start,((Expression2Context)_localctx).e21.stop):null) + "\\upto" + (((Expression2Context)_localctx).e22!=null?_input.getText(((Expression2Context)_localctx).e22.start,((Expression2Context)_localctx).e22.stop):null), newVarName);
						          			types.put((((Expression2Context)_localctx).e21!=null?_input.getText(((Expression2Context)_localctx).e21.start,((Expression2Context)_localctx).e21.stop):null) + "\\upto" + (((Expression2Context)_localctx).e22!=null?_input.getText(((Expression2Context)_localctx).e22.start,((Expression2Context)_localctx).e22.stop):null), (((Expression2Context)_localctx).e21!=null?_input.getText(((Expression2Context)_localctx).e21.start,((Expression2Context)_localctx).e21.stop):null) + "\\upto" + (((Expression2Context)_localctx).e22!=null?_input.getText(((Expression2Context)_localctx).e22.start,((Expression2Context)_localctx).e22.stop):null));
						          			if (modoSetExpression != 0 )
						          				setExpressionVars.put((((Expression2Context)_localctx).e21!=null?_input.getText(((Expression2Context)_localctx).e21.start,((Expression2Context)_localctx).e21.stop):null) + "\\upto" + (((Expression2Context)_localctx).e22!=null?_input.getText(((Expression2Context)_localctx).e22.start,((Expression2Context)_localctx).e22.stop):null), newVarName);
						          			print(newVarName + " = int(" + a + "," + b + ")");
						          		}
						          	
						}
						break;

					case 6:
						{
						_localctx = new Expression2Context(_parentctx, _parentState, _p);
						_localctx.e21 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression2);
						setState(394);
						if (!(5 >= _localctx._p)) throw new FailedPredicateException(this, "5 >= $_p");
						setState(395); match(63);
						setState(396); ((Expression2Context)_localctx).e22 = expression2(6);

						          		String a, b;
						          		a = memory.get((((Expression2Context)_localctx).e21!=null?_input.getText(((Expression2Context)_localctx).e21.start,((Expression2Context)_localctx).e21.stop):null));
						          		b = memory.get((((Expression2Context)_localctx).e22!=null?_input.getText(((Expression2Context)_localctx).e22.start,((Expression2Context)_localctx).e22.stop):null));
						          		memory.put((((Expression2Context)_localctx).e21!=null?_input.getText(((Expression2Context)_localctx).e21.start,((Expression2Context)_localctx).e21.stop):null) + "\\mapsto" + (((Expression2Context)_localctx).e22!=null?_input.getText(((Expression2Context)_localctx).e22.start,((Expression2Context)_localctx).e22.stop):null), "[" + a + "," + b + "]");
						          		types.put((((Expression2Context)_localctx).e21!=null?_input.getText(((Expression2Context)_localctx).e21.start,((Expression2Context)_localctx).e21.stop):null) + "\\mapsto" + (((Expression2Context)_localctx).e22!=null?_input.getText(((Expression2Context)_localctx).e22.start,((Expression2Context)_localctx).e22.stop):null), types.get((((Expression2Context)_localctx).e21!=null?_input.getText(((Expression2Context)_localctx).e21.start,((Expression2Context)_localctx).e21.stop):null)) + "\\cross" + types.get((((Expression2Context)_localctx).e22!=null?_input.getText(((Expression2Context)_localctx).e22.start,((Expression2Context)_localctx).e22.stop):null)));
						          	
						}
						break;
					}
					} 
				}
				setState(403);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
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

	public static class Expression3Context extends ParserRuleContext {
		public int _p;
		public ArrayList<String> elements = new ArrayList<String>();
		public String setlogName = "";
		public String zName = "";
		public String operator = "";
		public String newVarName1 = "";
		public String newVarName2 = "";
		public Expression3Context e3;
		public Token DECORATION;
		public Expression4Context e4;
		public TerminalNode DECORATION() { return getToken(ExprParser.DECORATION, 0); }
		public Expression3Context expression3() {
			return getRuleContext(Expression3Context.class,0);
		}
		public Expression4Context expression4() {
			return getRuleContext(Expression4Context.class,0);
		}
		public Expression3Context(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Expression3Context(ParserRuleContext parent, int invokingState, int _p) {
			super(parent, invokingState);
			this._p = _p;
		}
		@Override public int getRuleIndex() { return RULE_expression3; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterExpression3(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitExpression3(this);
		}
	}

	public final Expression3Context expression3(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Expression3Context _localctx = new Expression3Context(_ctx, _parentState, _p);
		Expression3Context _prevctx = _localctx;
		int _startState = 28;
		enterRecursionRule(_localctx, RULE_expression3);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(405); expression4(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(416);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Expression3Context(_parentctx, _parentState, _p);
					_localctx.e3 = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_expression3);
					setState(407);
					if (!(2 >= _localctx._p)) throw new FailedPredicateException(this, "2 >= $_p");
					setState(409);
					switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
					case 1:
						{
						setState(408); ((Expression3Context)_localctx).DECORATION = match(DECORATION);
						}
						break;
					}
					setState(411); ((Expression3Context)_localctx).e4 = expression4(0);

					          		String a, b;
					          		a = memory.get((((Expression3Context)_localctx).e3!=null?_input.getText(((Expression3Context)_localctx).e3.start,((Expression3Context)_localctx).e3.stop):null));
					          		b = memory.get((((Expression3Context)_localctx).e4!=null?_input.getText(((Expression3Context)_localctx).e4.start,((Expression3Context)_localctx).e4.stop):null));
					          		String op = "";
					          		if ((((Expression3Context)_localctx).DECORATION!=null?((Expression3Context)_localctx).DECORATION.getText():null) != null) op = "~";
					          		
					          		//Si a es una lista, debo convertirla
					          		a = convertToSet((((Expression3Context)_localctx).e3!=null?_input.getText(((Expression3Context)_localctx).e3.start,((Expression3Context)_localctx).e3.stop):null), a);
					          		
					          		if (memory.get((((Expression3Context)_localctx).e3!=null?_input.getText(((Expression3Context)_localctx).e3.start,((Expression3Context)_localctx).e3.stop):null) + op + (((Expression3Context)_localctx).e4!=null?_input.getText(((Expression3Context)_localctx).e4.start,((Expression3Context)_localctx).e4.stop):null)) == null) {
					          			String newVarName = newVar();
					          			memory.put((((Expression3Context)_localctx).e3!=null?_input.getText(((Expression3Context)_localctx).e3.start,((Expression3Context)_localctx).e3.stop):null) + op + (((Expression3Context)_localctx).e4!=null?_input.getText(((Expression3Context)_localctx).e4.start,((Expression3Context)_localctx).e4.stop):null), newVarName);
					          			
					          			if (modoSetExpression != 0 )
					          				setExpressionVars.put((((Expression3Context)_localctx).e3!=null?_input.getText(((Expression3Context)_localctx).e3.start,((Expression3Context)_localctx).e3.stop):null) + op + (((Expression3Context)_localctx).e4!=null?_input.getText(((Expression3Context)_localctx).e4.start,((Expression3Context)_localctx).e4.stop):null), newVarName);

					          			String type1 = types.get((((Expression3Context)_localctx).e3!=null?_input.getText(((Expression3Context)_localctx).e3.start,((Expression3Context)_localctx).e3.stop):null));
					          			//getType(type1);
					          			String newVarType = leftAndRightTypes(type1).get(1);
					          			types.put((((Expression3Context)_localctx).e3!=null?_input.getText(((Expression3Context)_localctx).e3.start,((Expression3Context)_localctx).e3.stop):null) + op + (((Expression3Context)_localctx).e4!=null?_input.getText(((Expression3Context)_localctx).e4.start,((Expression3Context)_localctx).e4.stop):null), newVarType);
					          			print("apply(" + a + "," + b + "," + newVarName + ")");
					          			
					          			//Imprimimos la informacion del tipo de la variable
					          			typeInfo(newVarName, newVarType);
					          		}
					          	
					}
					} 
				}
				setState(418);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
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

	public static class Expression4Context extends ParserRuleContext {
		public int _p;
		public ArrayList<String> elements = new ArrayList<String>();
		public String setlogName = "";
		public String zName = "";
		public String operator = "";
		public String newVarName1 = "";
		public String newVarName2 = "";
		public Expression4Context e41;
		public Expression4Context e4;
		public Token NAME;
		public Token NUM;
		public Token SETSTART;
		public ExpressionContext a;
		public ExpressionContext b;
		public Token SETEND;
		public DeclPartContext declPart;
		public PredicateContext predicate;
		public ExpressionContext c;
		public Token DECORATION;
		public Token LISTSTART;
		public Token LISTEND;
		public Expression0Context e0;
		public Expression4Context e42;
		public Expression4Context expression4;
		public Post_funContext post_fun;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public TerminalNode SETSTART() { return getToken(ExprParser.SETSTART, 0); }
		public TerminalNode NAME() { return getToken(ExprParser.NAME, 0); }
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public Post_funContext post_fun() {
			return getRuleContext(Post_funContext.class,0);
		}
		public PredicateContext predicate() {
			return getRuleContext(PredicateContext.class,0);
		}
		public Expression0Context expression0() {
			return getRuleContext(Expression0Context.class,0);
		}
		public Expression4Context expression4(int i) {
			return getRuleContext(Expression4Context.class,i);
		}
		public List<Expression4Context> expression4() {
			return getRuleContexts(Expression4Context.class);
		}
		public DeclPartContext declPart() {
			return getRuleContext(DeclPartContext.class,0);
		}
		public TerminalNode SETEND() { return getToken(ExprParser.SETEND, 0); }
		public TerminalNode DECORATION() { return getToken(ExprParser.DECORATION, 0); }
		public TerminalNode LISTSTART() { return getToken(ExprParser.LISTSTART, 0); }
		public TerminalNode LISTEND() { return getToken(ExprParser.LISTEND, 0); }
		public TerminalNode NUM() { return getToken(ExprParser.NUM, 0); }
		public Expression4Context(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Expression4Context(ParserRuleContext parent, int invokingState, int _p) {
			super(parent, invokingState);
			this._p = _p;
		}
		@Override public int getRuleIndex() { return RULE_expression4; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterExpression4(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitExpression4(this);
		}
	}

	public final Expression4Context expression4(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Expression4Context _localctx = new Expression4Context(_ctx, _parentState, _p);
		Expression4Context _prevctx = _localctx;
		int _startState = 30;
		enterRecursionRule(_localctx, RULE_expression4);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(511);
			switch ( getInterpreter().adaptivePredict(_input,50,_ctx) ) {
			case 1:
				{
				setState(420); ((Expression4Context)_localctx).NAME = match(NAME);

						if (memory.get((((Expression4Context)_localctx).NAME!=null?((Expression4Context)_localctx).NAME.getText():null)) == null)
						{
							String newVarName = newVar((((Expression4Context)_localctx).NAME!=null?((Expression4Context)_localctx).NAME.getText():null));
							
							memory.put((((Expression4Context)_localctx).NAME!=null?((Expression4Context)_localctx).NAME.getText():null), newVarName);
							if (modoSetExpression != 0 )
								setExpressionVars.put((((Expression4Context)_localctx).NAME!=null?((Expression4Context)_localctx).NAME.getText():null), newVarName);
						}
					
				}
				break;

			case 2:
				{
				setState(422); ((Expression4Context)_localctx).NUM = match(NUM);

						if (memory.get((((Expression4Context)_localctx).NUM!=null?((Expression4Context)_localctx).NUM.getText():null)) == null) {
							memory.put((((Expression4Context)_localctx).NUM!=null?((Expression4Context)_localctx).NUM.getText():null), (((Expression4Context)_localctx).NUM!=null?((Expression4Context)_localctx).NUM.getText():null));
							types.put((((Expression4Context)_localctx).NUM!=null?((Expression4Context)_localctx).NUM.getText():null), "\\num");
						}
					
				}
				break;

			case 3:
				{
				setState(424); match(11);

						if (memory.get("\\emptyset") == null) {
							memory.put("\\emptyset", "{}");
							types.put("\\emptyset", "\\power(" + "generic" + ")");
						}
					
				}
				break;

			case 4:
				{
				setState(426); ((Expression4Context)_localctx).SETSTART = match(SETSTART);
				setState(430);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 3) | (1L << 4) | (1L << 5) | (1L << 10) | (1L << 11) | (1L << 13) | (1L << 16) | (1L << 20) | (1L << 21) | (1L << 25) | (1L << 26) | (1L << 30) | (1L << 37) | (1L << 40) | (1L << 44) | (1L << 46) | (1L << 52) | (1L << 58) | (1L << 61))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (NAME - 64)) | (1L << (NUM - 64)) | (1L << (DECORATION - 64)) | (1L << (SETSTART - 64)) | (1L << (LISTSTART - 64)))) != 0)) {
					{
					setState(427); ((Expression4Context)_localctx).a = expression();
					_localctx.elements.add((((Expression4Context)_localctx).a!=null?_input.getText(((Expression4Context)_localctx).a.start,((Expression4Context)_localctx).a.stop):null));
					}
				}

				setState(438);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==38) {
					{
					{
					setState(432); match(38);
					setState(433); ((Expression4Context)_localctx).b = expression();
					_localctx.elements.add((((Expression4Context)_localctx).b!=null?_input.getText(((Expression4Context)_localctx).b.start,((Expression4Context)_localctx).b.stop):null));
					}
					}
					setState(440);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(441); ((Expression4Context)_localctx).SETEND = match(SETEND);
					
						((Expression4Context)_localctx).zName =  (((Expression4Context)_localctx).SETSTART!=null?((Expression4Context)_localctx).SETSTART.getText():null);
						String type = new String();
						//Llenamos elements y ponemos cada expression en la memory
						while( !_localctx.elements.isEmpty() ){
							String e = _localctx.elements.remove(0);
							if (type.equals("")) {
								type = types.get(e);
							}
							((Expression4Context)_localctx).zName =  _localctx.zName.concat(e);
							//guardamos tambien las traducciones del conjunto
							((Expression4Context)_localctx).setlogName =  _localctx.setlogName.concat(memory.get(e));
							
							if (!_localctx.elements.isEmpty()){
								((Expression4Context)_localctx).zName =  _localctx.zName + ",";
								((Expression4Context)_localctx).setlogName =  _localctx.setlogName + ",";
							}
						}
						((Expression4Context)_localctx).zName =  _localctx.zName + (((Expression4Context)_localctx).SETEND!=null?((Expression4Context)_localctx).SETEND.getText():null);
						if (memory.get(_localctx.zName) == null) {
							memory.put(_localctx.zName, "{" + _localctx.setlogName + "}");
							if (_localctx.setlogName.equals(""))
								types.put(_localctx.zName, "\\power(" + "generic" + ")");
							else
								types.put(_localctx.zName, "\\power(" + type + ")");
						}
					
				}
				break;

			case 5:
				{
				setState(443); ((Expression4Context)_localctx).SETSTART = match(SETSTART);
				modoSetExpression=1; setExpressionDecl = ""; setExpressionPred = ""; setExpressionExpr = ""; setExpressionVars = new HashMap();
				setState(445); ((Expression4Context)_localctx).declPart = declPart();
				((Expression4Context)_localctx).zName =  (((Expression4Context)_localctx).SETSTART!=null?((Expression4Context)_localctx).SETSTART.getText():null) + (((Expression4Context)_localctx).declPart!=null?_input.getText(((Expression4Context)_localctx).declPart.start,((Expression4Context)_localctx).declPart.stop):null);
				setState(452);
				_la = _input.LA(1);
				if (_la==33) {
					{
					setState(447); match(33);
					modoSetExpression=2;
					setState(449); ((Expression4Context)_localctx).predicate = predicate(0);
					((Expression4Context)_localctx).zName =  _localctx.zName.concat("|" + (((Expression4Context)_localctx).predicate!=null?_input.getText(((Expression4Context)_localctx).predicate.start,((Expression4Context)_localctx).predicate.stop):null));
					}
				}

				setState(459);
				_la = _input.LA(1);
				if (_la==19) {
					{
					setState(454); match(19);
					modoSetExpression=3;
					setState(456); ((Expression4Context)_localctx).c = expression();
					((Expression4Context)_localctx).zName =  _localctx.zName.concat("@" + (((Expression4Context)_localctx).c!=null?_input.getText(((Expression4Context)_localctx).c.start,((Expression4Context)_localctx).c.stop):null));
					}
				}

				setState(461); ((Expression4Context)_localctx).SETEND = match(SETEND);
				modoSetExpression=0; ((Expression4Context)_localctx).zName =  _localctx.zName.concat((((Expression4Context)_localctx).SETEND!=null?((Expression4Context)_localctx).SETEND.getText():null));

						if (memory.get(_localctx.zName)==null) {
						
							((Expression4Context)_localctx).setlogName =  "";
							((Expression4Context)_localctx).newVarName1 =  newVar();
							((Expression4Context)_localctx).newVarName2 =  newVar();
							
							((Expression4Context)_localctx).setlogName =  _localctx.setlogName.concat("{ " + _localctx.newVarName1 + ":exists([");
							
							Iterator<String> keysIt = setExpressionVars.keySet().iterator();
							while (keysIt.hasNext()){
								((Expression4Context)_localctx).setlogName =  _localctx.setlogName.concat(setExpressionVars.get(keysIt.next()));
								if (keysIt.hasNext()) ((Expression4Context)_localctx).setlogName =  _localctx.setlogName.concat(",");
							}
						
							((Expression4Context)_localctx).setlogName =  _localctx.setlogName.concat("], " + setExpressionDecl.substring(setExpressionDecl.indexOf('&') + 1) +
							setExpressionPred + setExpressionExpr + " & " + _localctx.newVarName1 + " is " + memory.get((((Expression4Context)_localctx).c!=null?_input.getText(((Expression4Context)_localctx).c.start,((Expression4Context)_localctx).c.stop):null)) + ")" + " }");
						
							memory.put(_localctx.zName, _localctx.newVarName2);
							types.put(_localctx.zName, "\\power(" + types.get((((Expression4Context)_localctx).c!=null?_input.getText(((Expression4Context)_localctx).c.start,((Expression4Context)_localctx).c.stop):null)) + ")"); //REVISAR!!!
							print(_localctx.newVarName2 + " = " + _localctx.setlogName);
							
							keysIt = setExpressionVars.keySet().iterator();
							while (keysIt.hasNext()){
								String var = keysIt.next();
								memory.remove(var);
								keysIt.remove();
								//setExpressionVars.remove(var);
							}
						}
					
				}
				break;

			case 6:
				{
				setState(466);
				_la = _input.LA(1);
				if (_la==DECORATION) {
					{
					setState(465); ((Expression4Context)_localctx).DECORATION = match(DECORATION);
					}
				}

				setState(468); ((Expression4Context)_localctx).LISTSTART = match(LISTSTART);
				setState(472);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 3) | (1L << 4) | (1L << 5) | (1L << 10) | (1L << 11) | (1L << 13) | (1L << 16) | (1L << 20) | (1L << 21) | (1L << 25) | (1L << 26) | (1L << 30) | (1L << 37) | (1L << 40) | (1L << 44) | (1L << 46) | (1L << 52) | (1L << 58) | (1L << 61))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (NAME - 64)) | (1L << (NUM - 64)) | (1L << (DECORATION - 64)) | (1L << (SETSTART - 64)) | (1L << (LISTSTART - 64)))) != 0)) {
					{
					setState(469); ((Expression4Context)_localctx).a = expression();
					_localctx.elements.add((((Expression4Context)_localctx).a!=null?_input.getText(((Expression4Context)_localctx).a.start,((Expression4Context)_localctx).a.stop):null));
					}
				}

				setState(480);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==38) {
					{
					{
					setState(474); match(38);
					setState(475); ((Expression4Context)_localctx).b = expression();
					_localctx.elements.add((((Expression4Context)_localctx).b!=null?_input.getText(((Expression4Context)_localctx).b.start,((Expression4Context)_localctx).b.stop):null));
					}
					}
					setState(482);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(483); ((Expression4Context)_localctx).LISTEND = match(LISTEND);
					
						if ((((Expression4Context)_localctx).DECORATION!=null?((Expression4Context)_localctx).DECORATION.getText():null) != null)
							((Expression4Context)_localctx).zName =  (((Expression4Context)_localctx).DECORATION!=null?((Expression4Context)_localctx).DECORATION.getText():null);
						((Expression4Context)_localctx).zName =  _localctx.zName.concat((((Expression4Context)_localctx).LISTSTART!=null?((Expression4Context)_localctx).LISTSTART.getText():null));
						String type = new String();
						//Llenamos elements y ponemos cada expression en la memory
						while( !_localctx.elements.isEmpty() ){
							String e = _localctx.elements.remove(0);
							if (type.equals("")) {
								type = types.get(e);
							}
							((Expression4Context)_localctx).zName =  _localctx.zName.concat(e);
							//guardamos tambien las traducciones del conjunto
							((Expression4Context)_localctx).setlogName =  _localctx.setlogName.concat(memory.get(e));
							
							if (!_localctx.elements.isEmpty()){
								((Expression4Context)_localctx).zName =  _localctx.zName + ",";
								((Expression4Context)_localctx).setlogName =  _localctx.setlogName + ",";
							}
						}
						((Expression4Context)_localctx).zName =  _localctx.zName + (((Expression4Context)_localctx).LISTEND!=null?((Expression4Context)_localctx).LISTEND.getText():null);
						if (memory.get(_localctx.zName) == null) {
							memory.put(_localctx.zName, "[" + _localctx.setlogName + "]");
							if (_localctx.setlogName.equals(""))
								types.put(_localctx.zName, "\\seq(" + "generic" + ")");
							else
								types.put(_localctx.zName, "\\seq(" + type + ")");
						}
					
				}
				break;

			case 7:
				{
				setState(485); match(40);
				setState(486); ((Expression4Context)_localctx).a = expression();
				_localctx.elements.add((((Expression4Context)_localctx).a!=null?_input.getText(((Expression4Context)_localctx).a.start,((Expression4Context)_localctx).a.stop):null));
				setState(492); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(488); match(38);
					setState(489); ((Expression4Context)_localctx).b = expression();
					_localctx.elements.add((((Expression4Context)_localctx).b!=null?_input.getText(((Expression4Context)_localctx).b.start,((Expression4Context)_localctx).b.stop):null));
					}
					}
					setState(494); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==38 );
				setState(496); match(18);
					
						((Expression4Context)_localctx).zName =  "(";
						String type = new String();
						//Llenamos elements y ponemos cada expression en la memory
						while( !_localctx.elements.isEmpty() ){
							String e = _localctx.elements.remove(0);
							if (type.equals(""))
								type = "(" + types.get(e) + ")";
							else
								type = type.concat("\\cross(" + types.get(e) + ")");
								 
							((Expression4Context)_localctx).zName =  _localctx.zName.concat(e);
							//guardamos tambien las traducciones del conjunto
							((Expression4Context)_localctx).setlogName =  _localctx.setlogName.concat(memory.get(e));
							
							if (!_localctx.elements.isEmpty()){
								((Expression4Context)_localctx).zName =  _localctx.zName + ",";
								((Expression4Context)_localctx).setlogName =  _localctx.setlogName + ",";
							}
						}
						((Expression4Context)_localctx).zName =  _localctx.zName + ")";
						if (memory.get(_localctx.zName) == null) {
							memory.put(_localctx.zName, "[" + _localctx.setlogName + "]");
							types.put(_localctx.zName, type);
						}
					
				}
				break;

			case 8:
				{
				setState(499); match(40);
				setState(500); ((Expression4Context)_localctx).e0 = expression0();
				setState(501); match(18);

						String a = memory.get((((Expression4Context)_localctx).e0!=null?_input.getText(((Expression4Context)_localctx).e0.start,((Expression4Context)_localctx).e0.stop):null));
						
						//Chequeo el nombre para ver si se trata de una sola variable, en ese caso no guardo en la memoria
						//los parentesis, en otro caso si
						
						if (a != null) { //Si no estoy en la parte de declaracion
							Pattern p = Pattern.compile("[^a-zA-Z0-9_]");
							boolean hasSpecialChar = p.matcher(a).find();
							
							if (hasSpecialChar){
								memory.put("(" + (((Expression4Context)_localctx).e0!=null?_input.getText(((Expression4Context)_localctx).e0.start,((Expression4Context)_localctx).e0.stop):null) + ")", "(" + a + ")");
								if (types.get((((Expression4Context)_localctx).e0!=null?_input.getText(((Expression4Context)_localctx).e0.start,((Expression4Context)_localctx).e0.stop):null)) != null) {
									types.put("(" + (((Expression4Context)_localctx).e0!=null?_input.getText(((Expression4Context)_localctx).e0.start,((Expression4Context)_localctx).e0.stop):null) + ")", types.get((((Expression4Context)_localctx).e0!=null?_input.getText(((Expression4Context)_localctx).e0.start,((Expression4Context)_localctx).e0.stop):null)));
								}
							}
							else {
								memory.put("(" + (((Expression4Context)_localctx).e0!=null?_input.getText(((Expression4Context)_localctx).e0.start,((Expression4Context)_localctx).e0.stop):null) + ")", a);
								if (types.get((((Expression4Context)_localctx).e0!=null?_input.getText(((Expression4Context)_localctx).e0.start,((Expression4Context)_localctx).e0.stop):null)) != null) {
									types.put("(" + (((Expression4Context)_localctx).e0!=null?_input.getText(((Expression4Context)_localctx).e0.start,((Expression4Context)_localctx).e0.stop):null) + ")", types.get((((Expression4Context)_localctx).e0!=null?_input.getText(((Expression4Context)_localctx).e0.start,((Expression4Context)_localctx).e0.stop):null)));
								}
							}
						} else  //Si estoy en la parte de declaracion
							if (types.get((((Expression4Context)_localctx).e0!=null?_input.getText(((Expression4Context)_localctx).e0.start,((Expression4Context)_localctx).e0.stop):null)) != null)
								types.put("(" + (((Expression4Context)_localctx).e0!=null?_input.getText(((Expression4Context)_localctx).e0.start,((Expression4Context)_localctx).e0.stop):null) + ")", "(" + types.get((((Expression4Context)_localctx).e0!=null?_input.getText(((Expression4Context)_localctx).e0.start,((Expression4Context)_localctx).e0.stop):null)) + ")");
					
				}
				break;

			case 9:
				{
				setState(504); match(26);
				setState(505); match(9);
					
						printInfo(_input.getText(_localctx.start, _input.LT(-1)));	
					
				}
				break;

			case 10:
				{
				setState(507); match(26);
					
						printInfo(_input.getText(_localctx.start, _input.LT(-1)));	
					
				}
				break;

			case 11:
				{
				setState(509); match(61);
					
						printInfo(_input.getText(_localctx.start, _input.LT(-1)));	
					
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(524);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,52,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(522);
					switch ( getInterpreter().adaptivePredict(_input,51,_ctx) ) {
					case 1:
						{
						_localctx = new Expression4Context(_parentctx, _parentState, _p);
						_localctx.e41 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression4);
						setState(513);
						if (!(6 >= _localctx._p)) throw new FailedPredicateException(this, "6 >= $_p");
						setState(514); match(53);
						setState(515); ((Expression4Context)_localctx).e42 = ((Expression4Context)_localctx).expression4 = expression4(7);

						          		if (memory.get((((Expression4Context)_localctx).e41!=null?_input.getText(((Expression4Context)_localctx).e41.start,((Expression4Context)_localctx).e41.stop):null) + "." + (((Expression4Context)_localctx).e42!=null?_input.getText(((Expression4Context)_localctx).e42.start,((Expression4Context)_localctx).e42.stop):null)) == null) {
						          		
						          			String e1Type = types.get((((Expression4Context)_localctx).e41!=null?_input.getText(((Expression4Context)_localctx).e41.start,((Expression4Context)_localctx).e41.stop):null));
						          			if (!e1Type.startsWith("SchemaType:")) //Debo llegar a obtener la lista con las variables
						          				e1Type = types.get(e1Type);
						          			
						          			if (e1Type.startsWith("SchemaType:")) {
						          				String schemaVars = e1Type.split(":", 3)[2];
						          				//Obtengo el indice de la variable e2 dentro de la lista de variables del tipo schema
						          				//Primero obtenemos la lista de variables
						          				schemaVars = schemaVars.substring(1, schemaVars.length()-1);
						          				String[] vars = schemaVars.split(",");
						          				//Buscamos la posicion de la variable
						          				int position = 1;
						          				while (!vars[position-1].contains((((Expression4Context)_localctx).e42!=null?_input.getText(((Expression4Context)_localctx).e42.start,((Expression4Context)_localctx).e42.stop):null) + ":")) //Se resta 1 porque en setlog empiezan en 1, no en 0 como en java
						          					position++;
						          				//Creamos una nueva variable
						          				String newVarName = newVar();
						          				//Vemos su tipo
						          				String type = vars[position-1].substring((((Expression4Context)_localctx).e42!=null?_input.getText(((Expression4Context)_localctx).e42.start,((Expression4Context)_localctx).e42.stop):null).length()+1);
						          				memory.put((((Expression4Context)_localctx).e41!=null?_input.getText(((Expression4Context)_localctx).e41.start,((Expression4Context)_localctx).e41.stop):null) + "." + (((Expression4Context)_localctx).e42!=null?_input.getText(((Expression4Context)_localctx).e42.start,((Expression4Context)_localctx).e42.stop):null), newVarName);
						          				if (modoSetExpression != 0 )
						          					setExpressionVars.put((((Expression4Context)_localctx).e41!=null?_input.getText(((Expression4Context)_localctx).e41.start,((Expression4Context)_localctx).e41.stop):null) + "." + (((Expression4Context)_localctx).e42!=null?_input.getText(((Expression4Context)_localctx).e42.start,((Expression4Context)_localctx).e42.stop):null), newVarName);
						          				types.put((((Expression4Context)_localctx).e41!=null?_input.getText(((Expression4Context)_localctx).e41.start,((Expression4Context)_localctx).e41.stop):null) + "." + (((Expression4Context)_localctx).e42!=null?_input.getText(((Expression4Context)_localctx).e42.start,((Expression4Context)_localctx).e42.stop):null), type);
						          				print("nth1(" + position + "," + memory.get((((Expression4Context)_localctx).e41!=null?_input.getText(((Expression4Context)_localctx).e41.start,((Expression4Context)_localctx).e41.stop):null)) + "," + newVarName + ")");
						          				
						          				typeInfo(newVarName, type);
						          				
						          			}
						          		}
						          	
						}
						break;

					case 2:
						{
						_localctx = new Expression4Context(_parentctx, _parentState, _p);
						_localctx.e4 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression4);
						setState(518);
						if (!(5 >= _localctx._p)) throw new FailedPredicateException(this, "5 >= $_p");
						setState(519); ((Expression4Context)_localctx).post_fun = post_fun();

						          		String a;
						          		a = memory.get((((Expression4Context)_localctx).e4!=null?_input.getText(((Expression4Context)_localctx).e4.start,((Expression4Context)_localctx).e4.stop):null));
						          		String op = (((Expression4Context)_localctx).post_fun!=null?_input.getText(((Expression4Context)_localctx).post_fun.start,((Expression4Context)_localctx).post_fun.stop):null);
						          		
						          		if (memory.get((((Expression4Context)_localctx).e4!=null?_input.getText(((Expression4Context)_localctx).e4.start,((Expression4Context)_localctx).e4.stop):null) + op) == null) {
						          		
						          			String newVarName = newVar();
						          		
						          			if (op.startsWith("\\inv")){
						          				//Si a es una lista, debo convertirla
						          				a = convertToSet((((Expression4Context)_localctx).e4!=null?_input.getText(((Expression4Context)_localctx).e4.start,((Expression4Context)_localctx).e4.stop):null), a);
						          			
						          				print("inv(" + newVarName + "," + a + ")");
						          				memory.put((((Expression4Context)_localctx).e4!=null?_input.getText(((Expression4Context)_localctx).e4.start,((Expression4Context)_localctx).e4.stop):null) + op, newVarName);
						          				String type = types.get((((Expression4Context)_localctx).e4!=null?_input.getText(((Expression4Context)_localctx).e4.start,((Expression4Context)_localctx).e4.stop):null));
						          				if (isSequence(getType(type)))
						          					type = "\\power(\\nat\\cross(" + leftAndRightTypes(type).get(1) + "))";
						          				type = invertType(type); 
						          				types.put((((Expression4Context)_localctx).e4!=null?_input.getText(((Expression4Context)_localctx).e4.start,((Expression4Context)_localctx).e4.stop):null) + op, type);
						          				typeInfo(newVarName, type);
						          				if (modoSetExpression != 0 )
						          					setExpressionVars.put((((Expression4Context)_localctx).e4!=null?_input.getText(((Expression4Context)_localctx).e4.start,((Expression4Context)_localctx).e4.stop):null) + op, newVarName);
						          			}
						          		}
						          	
						}
						break;
					}
					} 
				}
				setState(526);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,52,_ctx);
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

	public static class Post_funContext extends ParserRuleContext {
		public TerminalNode DECORATION() { return getToken(ExprParser.DECORATION, 0); }
		public Post_funContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_post_fun; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterPost_fun(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitPost_fun(this);
		}
	}

	public final Post_funContext post_fun() throws RecognitionException {
		Post_funContext _localctx = new Post_funContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_post_fun);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(527); match(47);
			setState(529);
			switch ( getInterpreter().adaptivePredict(_input,53,_ctx) ) {
			case 1:
				{
				setState(528); match(DECORATION);
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

	public static class Pre_genContext extends ParserRuleContext {
		public TerminalNode DECORATION() { return getToken(ExprParser.DECORATION, 0); }
		public Pre_genContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pre_gen; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterPre_gen(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitPre_gen(this);
		}
	}

	public final Pre_genContext pre_gen() throws RecognitionException {
		Pre_genContext _localctx = new Pre_genContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_pre_gen);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(543);
			switch ( getInterpreter().adaptivePredict(_input,54,_ctx) ) {
			case 1:
				{
				setState(531); match(44);
				}
				break;

			case 2:
				{
				setState(532); match(10);
				}
				break;

			case 3:
				{
				setState(533); match(46);
				setState(534); match(DECORATION);
				}
				break;

			case 4:
				{
				setState(535); match(20);
				}
				break;

			case 5:
				{
				setState(536); match(3);
				}
				break;

			case 6:
				{
				setState(537); match(30);
				}
				break;

			case 7:
				{
				setState(538); match(30);
				}
				break;

			case 8:
				{
				setState(539); match(16);
				setState(540); match(DECORATION);
				}
				break;

			case 9:
				{
				setState(541); match(5);
				setState(542); match(DECORATION);
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

	public static class Seq_opContext extends ParserRuleContext {
		public TerminalNode DECORATION() { return getToken(ExprParser.DECORATION, 0); }
		public Seq_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_seq_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterSeq_op(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitSeq_op(this);
		}
	}

	public final Seq_opContext seq_op() throws RecognitionException {
		Seq_opContext _localctx = new Seq_opContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_seq_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(545);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 4) | (1L << 13) | (1L << 21) | (1L << 25) | (1L << 37) | (1L << 58))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(546); match(DECORATION);
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

		case 12: return expression1_sempred((Expression1Context)_localctx, predIndex);

		case 13: return expression2_sempred((Expression2Context)_localctx, predIndex);

		case 14: return expression3_sempred((Expression3Context)_localctx, predIndex);

		case 15: return expression4_sempred((Expression4Context)_localctx, predIndex);
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
	private boolean expression1_sempred(Expression1Context _localctx, int predIndex) {
		switch (predIndex) {
		case 4: return 4 >= _localctx._p;
		}
		return true;
	}
	private boolean expression2_sempred(Expression2Context _localctx, int predIndex) {
		switch (predIndex) {
		case 5: return 10 >= _localctx._p;

		case 6: return 9 >= _localctx._p;

		case 7: return 8 >= _localctx._p;

		case 8: return 7 >= _localctx._p;

		case 9: return 6 >= _localctx._p;

		case 10: return 5 >= _localctx._p;
		}
		return true;
	}
	private boolean expression3_sempred(Expression3Context _localctx, int predIndex) {
		switch (predIndex) {
		case 11: return 2 >= _localctx._p;
		}
		return true;
	}
	private boolean expression4_sempred(Expression4Context _localctx, int predIndex) {
		switch (predIndex) {
		case 12: return 6 >= _localctx._p;

		case 13: return 5 >= _localctx._p;
		}
		return true;
	}

	public static final String _serializedATN =
		"\2\3R\u0227\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4"+
		"\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20"+
		"\4\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\3\2\3\2\7\2+\n\2\f\2\16\2.\13"+
		"\2\6\2\60\n\2\r\2\16\2\61\3\2\3\2\3\3\3\3\3\3\3\3\5\3:\n\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\5\3E\n\3\3\3\3\3\3\3\3\3\5\3K\n\3\3\3\3\3\3\3"+
		"\5\3P\n\3\3\3\3\3\6\3T\n\3\r\3\16\3U\3\3\3\3\5\3Z\n\3\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\7\4c\n\4\f\4\16\4f\13\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3"+
		"\6\3\6\3\6\3\6\3\6\5\6u\n\6\3\6\3\6\3\6\3\6\5\6{\n\6\7\6}\n\6\f\6\16\6"+
		"\u0080\13\6\3\6\3\6\3\7\3\7\3\7\3\7\5\7\u0088\n\7\3\7\3\7\5\7\u008c\n"+
		"\7\3\7\3\7\3\7\7\7\u0091\n\7\f\7\16\7\u0094\13\7\3\b\3\b\3\b\7\b\u0099"+
		"\n\b\f\b\16\b\u009c\13\b\3\t\3\t\3\t\3\t\3\t\3\t\7\t\u00a4\n\t\f\t\16"+
		"\t\u00a7\13\t\3\t\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\5\13\u00b8\n\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13"+
		"\u00c1\n\13\3\13\3\13\3\13\3\13\3\13\5\13\u00c8\n\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\5\13\u00d0\n\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u00d8"+
		"\n\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u00e0\n\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u00ed\n\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\5\13\u00f6\n\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u00fe"+
		"\n\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u0107\n\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\5\13\u010f\n\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u0117"+
		"\n\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u011f\n\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\5\13\u012a\n\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\7\13\u0138\n\13\f\13\16\13\u013b\13\13"+
		"\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\6\16\u0148\n\16\r"+
		"\16\16\16\u0149\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u0153\n\16\3\16"+
		"\3\16\3\16\3\16\3\16\7\16\u015a\n\16\f\16\16\16\u015d\13\16\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u016d"+
		"\n\17\3\17\3\17\3\17\5\17\u0172\n\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\7\17\u0192\n\17\f\17\16"+
		"\17\u0195\13\17\3\20\3\20\3\20\3\20\3\20\5\20\u019c\n\20\3\20\3\20\3\20"+
		"\7\20\u01a1\n\20\f\20\16\20\u01a4\13\20\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\5\21\u01b1\n\21\3\21\3\21\3\21\3\21\7\21\u01b7"+
		"\n\21\f\21\16\21\u01ba\13\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3"+
		"\21\3\21\3\21\5\21\u01c7\n\21\3\21\3\21\3\21\3\21\3\21\5\21\u01ce\n\21"+
		"\3\21\3\21\3\21\3\21\3\21\5\21\u01d5\n\21\3\21\3\21\3\21\3\21\5\21\u01db"+
		"\n\21\3\21\3\21\3\21\3\21\7\21\u01e1\n\21\f\21\16\21\u01e4\13\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\6\21\u01ef\n\21\r\21\16\21\u01f0"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\5\21\u0202\n\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\7\21"+
		"\u020d\n\21\f\21\16\21\u0210\13\21\3\22\3\22\5\22\u0214\n\22\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u0222\n\23\3\24"+
		"\3\24\3\24\3\24\2\25\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&\2\4\4"+
		";;JJ\b\6\6\17\17\27\27\33\33\'\'<<\u0273\2/\3\2\2\2\4Y\3\2\2\2\6[\3\2"+
		"\2\2\bj\3\2\2\2\no\3\2\2\2\f\u0083\3\2\2\2\16\u0095\3\2\2\2\20\u009d\3"+
		"\2\2\2\22\u00ac\3\2\2\2\24\u0129\3\2\2\2\26\u013c\3\2\2\2\30\u013e\3\2"+
		"\2\2\32\u0152\3\2\2\2\34\u0171\3\2\2\2\36\u0196\3\2\2\2 \u0201\3\2\2\2"+
		"\"\u0211\3\2\2\2$\u0221\3\2\2\2&\u0223\3\2\2\2(,\5\4\3\2)+\7J\2\2*)\3"+
		"\2\2\2+.\3\2\2\2,*\3\2\2\2,-\3\2\2\2-\60\3\2\2\2.,\3\2\2\2/(\3\2\2\2\60"+
		"\61\3\2\2\2\61/\3\2\2\2\61\62\3\2\2\2\62\63\3\2\2\2\63\64\b\2\1\2\64\3"+
		"\3\2\2\2\659\7\64\2\2\66:\7\3\2\2\678\79\2\28:\b\3\1\29\66\3\2\2\29\67"+
		"\3\2\2\2:;\3\2\2\2;<\7)\2\2<=\7B\2\2=>\7\20\2\2>?\5\f\7\2?@\b\3\1\2@D"+
		"\7$\2\2AE\7\3\2\2BC\79\2\2CE\b\3\1\2DA\3\2\2\2DB\3\2\2\2EF\3\2\2\2FG\7"+
		"\20\2\2GZ\3\2\2\2HJ\7>\2\2IK\7J\2\2JI\3\2\2\2JK\3\2\2\2KS\3\2\2\2LP\5"+
		"\6\4\2MP\5\b\5\2NP\5\n\6\2OL\3\2\2\2OM\3\2\2\2ON\3\2\2\2PQ\3\2\2\2QR\7"+
		"J\2\2RT\3\2\2\2SO\3\2\2\2TU\3\2\2\2US\3\2\2\2UV\3\2\2\2VW\3\2\2\2WX\7"+
		"-\2\2XZ\3\2\2\2Y\65\3\2\2\2YH\3\2\2\2Z\5\3\2\2\2[\\\7\b\2\2\\]\5\22\n"+
		"\2]d\b\4\1\2^_\7(\2\2_`\5\22\n\2`a\b\4\1\2ac\3\2\2\2b^\3\2\2\2cf\3\2\2"+
		"\2db\3\2\2\2de\3\2\2\2eg\3\2\2\2fd\3\2\2\2gh\7&\2\2hi\b\4\1\2i\7\3\2\2"+
		"\2jk\5\22\n\2kl\7@\2\2lm\5\30\r\2mn\b\5\1\2n\t\3\2\2\2op\5\22\n\2pq\7"+
		"!\2\2qr\5\22\n\2rt\b\6\1\2su\5\30\r\2ts\3\2\2\2tu\3\2\2\2u~\3\2\2\2vw"+
		"\7#\2\2wx\5\22\n\2xz\b\6\1\2y{\5\30\r\2zy\3\2\2\2z{\3\2\2\2{}\3\2\2\2"+
		"|v\3\2\2\2}\u0080\3\2\2\2~|\3\2\2\2~\177\3\2\2\2\177\u0081\3\2\2\2\u0080"+
		"~\3\2\2\2\u0081\u0082\b\6\1\2\u0082\13\3\2\2\2\u0083\u0087\7J\2\2\u0084"+
		"\u0085\5\16\b\2\u0085\u0086\7J\2\2\u0086\u0088\3\2\2\2\u0087\u0084\3\2"+
		"\2\2\u0087\u0088\3\2\2\2\u0088\u008b\3\2\2\2\u0089\u008a\7\36\2\2\u008a"+
		"\u008c\7J\2\2\u008b\u0089\3\2\2\2\u008b\u008c\3\2\2\2\u008c\u0092\3\2"+
		"\2\2\u008d\u008e\5\24\13\2\u008e\u008f\7J\2\2\u008f\u0091\3\2\2\2\u0090"+
		"\u008d\3\2\2\2\u0091\u0094\3\2\2\2\u0092\u0090\3\2\2\2\u0092\u0093\3\2"+
		"\2\2\u0093\r\3\2\2\2\u0094\u0092\3\2\2\2\u0095\u009a\5\20\t\2\u0096\u0097"+
		"\t\2\2\2\u0097\u0099\5\20\t\2\u0098\u0096\3\2\2\2\u0099\u009c\3\2\2\2"+
		"\u009a\u0098\3\2\2\2\u009a\u009b\3\2\2\2\u009b\17\3\2\2\2\u009c\u009a"+
		"\3\2\2\2\u009d\u009e\5\22\n\2\u009e\u00a5\b\t\1\2\u009f\u00a0\7(\2\2\u00a0"+
		"\u00a1\5\22\n\2\u00a1\u00a2\b\t\1\2\u00a2\u00a4\3\2\2\2\u00a3\u009f\3"+
		"\2\2\2\u00a4\u00a7\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6"+
		"\u00a8\3\2\2\2\u00a7\u00a5\3\2\2\2\u00a8\u00a9\7+\2\2\u00a9\u00aa\5\30"+
		"\r\2\u00aa\u00ab\b\t\1\2\u00ab\21\3\2\2\2\u00ac\u00ad\7B\2\2\u00ad\23"+
		"\3\2\2\2\u00ae\u00af\b\13\1\2\u00af\u00b0\5\30\r\2\u00b0\u00b1\7/\2\2"+
		"\u00b1\u00b2\5\30\r\2\u00b2\u00b3\b\13\1\2\u00b3\u012a\3\2\2\2\u00b4\u00b5"+
		"\5\30\r\2\u00b5\u00b7\7\21\2\2\u00b6\u00b8\7I\2\2\u00b7\u00b6\3\2\2\2"+
		"\u00b7\u00b8\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9\u00ba\5\30\r\2\u00ba\u00c1"+
		"\3\2\2\2\u00bb\u00bc\7\4\2\2\u00bc\u00bd\5\30\r\2\u00bd\u00be\7/\2\2\u00be"+
		"\u00bf\5\30\r\2\u00bf\u00c1\3\2\2\2\u00c0\u00b4\3\2\2\2\u00c0\u00bb\3"+
		"\2\2\2\u00c1\u00c2\3\2\2\2\u00c2\u00c3\b\13\1\2\u00c3\u012a\3\2\2\2\u00c4"+
		"\u00c5\5\30\r\2\u00c5\u00c7\7\t\2\2\u00c6\u00c8\7I\2\2\u00c7\u00c6\3\2"+
		"\2\2\u00c7\u00c8\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9\u00ca\5\30\r\2\u00ca"+
		"\u00cb\b\13\1\2\u00cb\u012a\3\2\2\2\u00cc\u00cd\5\30\r\2\u00cd\u00cf\7"+
		"=\2\2\u00ce\u00d0\7I\2\2\u00cf\u00ce\3\2\2\2\u00cf\u00d0\3\2\2\2\u00d0"+
		"\u00d1\3\2\2\2\u00d1\u00d2\5\30\r\2\u00d2\u00d3\b\13\1\2\u00d3\u012a\3"+
		"\2\2\2\u00d4\u00d5\5\30\r\2\u00d5\u00d7\7\31\2\2\u00d6\u00d8\7I\2\2\u00d7"+
		"\u00d6\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8\u00d9\3\2\2\2\u00d9\u00da\5\30"+
		"\r\2\u00da\u00db\b\13\1\2\u00db\u012a\3\2\2\2\u00dc\u00dd\5\30\r\2\u00dd"+
		"\u00df\7\37\2\2\u00de\u00e0\7I\2\2\u00df\u00de\3\2\2\2\u00df\u00e0\3\2"+
		"\2\2\u00e0\u00e1\3\2\2\2\u00e1\u00e2\5\30\r\2\u00e2\u00e3\b\13\1\2\u00e3"+
		"\u012a\3\2\2\2\u00e4\u00e5\5\30\r\2\u00e5\u00e6\7\30\2\2\u00e6\u00e7\5"+
		"\30\r\2\u00e7\u00e8\b\13\1\2\u00e8\u012a\3\2\2\2\u00e9\u00ea\5\30\r\2"+
		"\u00ea\u00ec\7\"\2\2\u00eb\u00ed\7I\2\2\u00ec\u00eb\3\2\2\2\u00ec\u00ed"+
		"\3\2\2\2\u00ed\u00ee\3\2\2\2\u00ee\u00ef\5\30\r\2\u00ef\u00f0\b\13\1\2"+
		"\u00f0\u012a\3\2\2\2\u00f1\u00f2\7\4\2\2\u00f2\u00f3\5\30\r\2\u00f3\u00f5"+
		"\7\"\2\2\u00f4\u00f6\7I\2\2\u00f5\u00f4\3\2\2\2\u00f5\u00f6\3\2\2\2\u00f6"+
		"\u00f7\3\2\2\2\u00f7\u00f8\5\30\r\2\u00f8\u00f9\b\13\1\2\u00f9\u012a\3"+
		"\2\2\2\u00fa\u00fb\5\30\r\2\u00fb\u00fd\7\65\2\2\u00fc\u00fe\7I\2\2\u00fd"+
		"\u00fc\3\2\2\2\u00fd\u00fe\3\2\2\2\u00fe\u00ff\3\2\2\2\u00ff\u0100\5\30"+
		"\r\2\u0100\u0101\b\13\1\2\u0101\u012a\3\2\2\2\u0102\u0103\7\4\2\2\u0103"+
		"\u0104\5\30\r\2\u0104\u0106\7\65\2\2\u0105\u0107\7I\2\2\u0106\u0105\3"+
		"\2\2\2\u0106\u0107\3\2\2\2\u0107\u0108\3\2\2\2\u0108\u0109\5\30\r\2\u0109"+
		"\u010a\b\13\1\2\u010a\u012a\3\2\2\2\u010b\u010c\5\30\r\2\u010c\u010e\7"+
		"\35\2\2\u010d\u010f\7I\2\2\u010e\u010d\3\2\2\2\u010e\u010f\3\2\2\2\u010f"+
		"\u0110\3\2\2\2\u0110\u0111\5\30\r\2\u0111\u0112\b\13\1\2\u0112\u012a\3"+
		"\2\2\2\u0113\u0114\5\30\r\2\u0114\u0116\7\32\2\2\u0115\u0117\7I\2\2\u0116"+
		"\u0115\3\2\2\2\u0116\u0117\3\2\2\2\u0117\u0118\3\2\2\2\u0118\u0119\5\30"+
		"\r\2\u0119\u011a\b\13\1\2\u011a\u012a\3\2\2\2\u011b\u011c\5\30\r\2\u011c"+
		"\u011e\7%\2\2\u011d\u011f\7I\2\2\u011e\u011d\3\2\2\2\u011e\u011f\3\2\2"+
		"\2\u011f\u0120\3\2\2\2\u0120\u0121\5\30\r\2\u0121\u0122\b\13\1\2\u0122"+
		"\u012a\3\2\2\2\u0123\u0124\7*\2\2\u0124\u0125\5\24\13\2\u0125\u0126\7"+
		"\24\2\2\u0126\u012a\3\2\2\2\u0127\u012a\7\63\2\2\u0128\u012a\7\n\2\2\u0129"+
		"\u00ae\3\2\2\2\u0129\u00c0\3\2\2\2\u0129\u00c4\3\2\2\2\u0129\u00cc\3\2"+
		"\2\2\u0129\u00d4\3\2\2\2\u0129\u00dc\3\2\2\2\u0129\u00e4\3\2\2\2\u0129"+
		"\u00e9\3\2\2\2\u0129\u00f1\3\2\2\2\u0129\u00fa\3\2\2\2\u0129\u0102\3\2"+
		"\2\2\u0129\u010b\3\2\2\2\u0129\u0113\3\2\2\2\u0129\u011b\3\2\2\2\u0129"+
		"\u0123\3\2\2\2\u0129\u0127\3\2\2\2\u0129\u0128\3\2\2\2\u012a\u0139\3\2"+
		"\2\2\u012b\u012c\6\13\2\3\u012c\u012d\78\2\2\u012d\u0138\5\24\13\2\u012e"+
		"\u012f\6\13\3\3\u012f\u0130\7:\2\2\u0130\u0138\5\24\13\2\u0131\u0132\6"+
		"\13\4\3\u0132\u0133\7,\2\2\u0133\u0138\5\24\13\2\u0134\u0135\6\13\5\3"+
		"\u0135\u0136\7\23\2\2\u0136\u0138\5\24\13\2\u0137\u012b\3\2\2\2\u0137"+
		"\u012e\3\2\2\2\u0137\u0131\3\2\2\2\u0137\u0134\3\2\2\2\u0138\u013b\3\2"+
		"\2\2\u0139\u0137\3\2\2\2\u0139\u013a\3\2\2\2\u013a\25\3\2\2\2\u013b\u0139"+
		"\3\2\2\2\u013c\u013d\5\30\r\2\u013d\27\3\2\2\2\u013e\u013f\5\32\16\2\u013f"+
		"\31\3\2\2\2\u0140\u0141\b\16\1\2\u0141\u0142\5\34\17\2\u0142\u0147\b\16"+
		"\1\2\u0143\u0144\7\62\2\2\u0144\u0145\5\34\17\2\u0145\u0146\b\16\1\2\u0146"+
		"\u0148\3\2\2\2\u0147\u0143\3\2\2\2\u0148\u0149\3\2\2\2\u0149\u0147\3\2"+
		"\2\2\u0149\u014a\3\2\2\2\u014a\u014b\3\2\2\2\u014b\u014c\b\16\1\2\u014c"+
		"\u0153\3\2\2\2\u014d\u014e\5&\24\2\u014e\u014f\5\34\17\2\u014f\u0150\b"+
		"\16\1\2\u0150\u0153\3\2\2\2\u0151\u0153\5\34\17\2\u0152\u0140\3\2\2\2"+
		"\u0152\u014d\3\2\2\2\u0152\u0151\3\2\2\2\u0153\u015b\3\2\2\2\u0154\u0155"+
		"\6\16\6\3\u0155\u0156\7H\2\2\u0156\u0157\5\32\16\2\u0157\u0158\b\16\1"+
		"\2\u0158\u015a\3\2\2\2\u0159\u0154\3\2\2\2\u015a\u015d\3\2\2\2\u015b\u0159"+
		"\3\2\2\2\u015b\u015c\3\2\2\2\u015c\33\3\2\2\2\u015d\u015b\3\2\2\2\u015e"+
		"\u015f\b\17\1\2\u015f\u0160\7\66\2\2\u0160\u0161\5 \21\2\u0161\u0162\b"+
		"\17\1\2\u0162\u0172\3\2\2\2\u0163\u0164\5$\23\2\u0164\u0165\5\30\r\2\u0165"+
		"\u0166\b\17\1\2\u0166\u0172\3\2\2\2\u0167\u0168\5 \21\2\u0168\u0169\7"+
		"P\2\2\u0169\u016a\5\26\f\2\u016a\u016c\7Q\2\2\u016b\u016d\7I\2\2\u016c"+
		"\u016b\3\2\2\2\u016c\u016d\3\2\2\2\u016d\u016e\3\2\2\2\u016e\u016f\b\17"+
		"\1\2\u016f\u0172\3\2\2\2\u0170\u0172\5\36\20\2\u0171\u015e\3\2\2\2\u0171"+
		"\u0163\3\2\2\2\u0171\u0167\3\2\2\2\u0171\u0170\3\2\2\2\u0172\u0193\3\2"+
		"\2\2\u0173\u0174\6\17\7\3\u0174\u0175\7G\2\2\u0175\u0176\5\34\17\2\u0176"+
		"\u0177\b\17\1\2\u0177\u0192\3\2\2\2\u0178\u0179\6\17\b\3\u0179\u017a\7"+
		"F\2\2\u017a\u017b\5\34\17\2\u017b\u017c\b\17\1\2\u017c\u0192\3\2\2\2\u017d"+
		"\u017e\6\17\t\3\u017e\u017f\7E\2\2\u017f\u0180\5\34\17\2\u0180\u0181\b"+
		"\17\1\2\u0181\u0192\3\2\2\2\u0182\u0183\6\17\n\3\u0183\u0184\7D\2\2\u0184"+
		"\u0185\5\34\17\2\u0185\u0186\b\17\1\2\u0186\u0192\3\2\2\2\u0187\u0188"+
		"\6\17\13\3\u0188\u0189\7\16\2\2\u0189\u018a\5\34\17\2\u018a\u018b\b\17"+
		"\1\2\u018b\u0192\3\2\2\2\u018c\u018d\6\17\f\3\u018d\u018e\7A\2\2\u018e"+
		"\u018f\5\34\17\2\u018f\u0190\b\17\1\2\u0190\u0192\3\2\2\2\u0191\u0173"+
		"\3\2\2\2\u0191\u0178\3\2\2\2\u0191\u017d\3\2\2\2\u0191\u0182\3\2\2\2\u0191"+
		"\u0187\3\2\2\2\u0191\u018c\3\2\2\2\u0192\u0195\3\2\2\2\u0193\u0191\3\2"+
		"\2\2\u0193\u0194\3\2\2\2\u0194\35\3\2\2\2\u0195\u0193\3\2\2\2\u0196\u0197"+
		"\b\20\1\2\u0197\u0198\5 \21\2\u0198\u01a2\3\2\2\2\u0199\u019b\6\20\r\3"+
		"\u019a\u019c\7I\2\2\u019b\u019a\3\2\2\2\u019b\u019c\3\2\2\2\u019c\u019d"+
		"\3\2\2\2\u019d\u019e\5 \21\2\u019e\u019f\b\20\1\2\u019f\u01a1\3\2\2\2"+
		"\u01a0\u0199\3\2\2\2\u01a1\u01a4\3\2\2\2\u01a2\u01a0\3\2\2\2\u01a2\u01a3"+
		"\3\2\2\2\u01a3\37\3\2\2\2\u01a4\u01a2\3\2\2\2\u01a5\u01a6\b\21\1\2\u01a6"+
		"\u01a7\7B\2\2\u01a7\u0202\b\21\1\2\u01a8\u01a9\7C\2\2\u01a9\u0202\b\21"+
		"\1\2\u01aa\u01ab\7\r\2\2\u01ab\u0202\b\21\1\2\u01ac\u01b0\7L\2\2\u01ad"+
		"\u01ae\5\30\r\2\u01ae\u01af\b\21\1\2\u01af\u01b1\3\2\2\2\u01b0\u01ad\3"+
		"\2\2\2\u01b0\u01b1\3\2\2\2\u01b1\u01b8\3\2\2\2\u01b2\u01b3\7(\2\2\u01b3"+
		"\u01b4\5\30\r\2\u01b4\u01b5\b\21\1\2\u01b5\u01b7\3\2\2\2\u01b6\u01b2\3"+
		"\2\2\2\u01b7\u01ba\3\2\2\2\u01b8\u01b6\3\2\2\2\u01b8\u01b9\3\2\2\2\u01b9"+
		"\u01bb\3\2\2\2\u01ba\u01b8\3\2\2\2\u01bb\u01bc\7M\2\2\u01bc\u0202\b\21"+
		"\1\2\u01bd\u01be\7L\2\2\u01be\u01bf\b\21\1\2\u01bf\u01c0\5\16\b\2\u01c0"+
		"\u01c6\b\21\1\2\u01c1\u01c2\7#\2\2\u01c2\u01c3\b\21\1\2\u01c3\u01c4\5"+
		"\24\13\2\u01c4\u01c5\b\21\1\2\u01c5\u01c7\3\2\2\2\u01c6\u01c1\3\2\2\2"+
		"\u01c6\u01c7\3\2\2\2\u01c7\u01cd\3\2\2\2\u01c8\u01c9\7\25\2\2\u01c9\u01ca"+
		"\b\21\1\2\u01ca\u01cb\5\30\r\2\u01cb\u01cc\b\21\1\2\u01cc\u01ce\3\2\2"+
		"\2\u01cd\u01c8\3\2\2\2\u01cd\u01ce\3\2\2\2\u01ce\u01cf\3\2\2\2\u01cf\u01d0"+
		"\7M\2\2\u01d0\u01d1\b\21\1\2\u01d1\u01d2\b\21\1\2\u01d2\u0202\3\2\2\2"+
		"\u01d3\u01d5\7I\2\2\u01d4\u01d3\3\2\2\2\u01d4\u01d5\3\2\2\2\u01d5\u01d6"+
		"\3\2\2\2\u01d6\u01da\7N\2\2\u01d7\u01d8\5\30\r\2\u01d8\u01d9\b\21\1\2"+
		"\u01d9\u01db\3\2\2\2\u01da\u01d7\3\2\2\2\u01da\u01db\3\2\2\2\u01db\u01e2"+
		"\3\2\2\2\u01dc\u01dd\7(\2\2\u01dd\u01de\5\30\r\2\u01de\u01df\b\21\1\2"+
		"\u01df\u01e1\3\2\2\2\u01e0\u01dc\3\2\2\2\u01e1\u01e4\3\2\2\2\u01e2\u01e0"+
		"\3\2\2\2\u01e2\u01e3\3\2\2\2\u01e3\u01e5\3\2\2\2\u01e4\u01e2\3\2\2\2\u01e5"+
		"\u01e6\7O\2\2\u01e6\u0202\b\21\1\2\u01e7\u01e8\7*\2\2\u01e8\u01e9\5\30"+
		"\r\2\u01e9\u01ee\b\21\1\2\u01ea\u01eb\7(\2\2\u01eb\u01ec\5\30\r\2\u01ec"+
		"\u01ed\b\21\1\2\u01ed\u01ef\3\2\2\2\u01ee\u01ea\3\2\2\2\u01ef\u01f0\3"+
		"\2\2\2\u01f0\u01ee\3\2\2\2\u01f0\u01f1\3\2\2\2\u01f1\u01f2\3\2\2\2\u01f2"+
		"\u01f3\7\24\2\2\u01f3\u01f4\b\21\1\2\u01f4\u0202\3\2\2\2\u01f5\u01f6\7"+
		"*\2\2\u01f6\u01f7\5\26\f\2\u01f7\u01f8\7\24\2\2\u01f8\u01f9\b\21\1\2\u01f9"+
		"\u0202\3\2\2\2\u01fa\u01fb\7\34\2\2\u01fb\u01fc\7\13\2\2\u01fc\u0202\b"+
		"\21\1\2\u01fd\u01fe\7\34\2\2\u01fe\u0202\b\21\1\2\u01ff\u0200\7?\2\2\u0200"+
		"\u0202\b\21\1\2\u0201\u01a5\3\2\2\2\u0201\u01a8\3\2\2\2\u0201\u01aa\3"+
		"\2\2\2\u0201\u01ac\3\2\2\2\u0201\u01bd\3\2\2\2\u0201\u01d4\3\2\2\2\u0201"+
		"\u01e7\3\2\2\2\u0201\u01f5\3\2\2\2\u0201\u01fa\3\2\2\2\u0201\u01fd\3\2"+
		"\2\2\u0201\u01ff\3\2\2\2\u0202\u020e\3\2\2\2\u0203\u0204\6\21\16\3\u0204"+
		"\u0205\7\67\2\2\u0205\u0206\5 \21\2\u0206\u0207\b\21\1\2\u0207\u020d\3"+
		"\2\2\2\u0208\u0209\6\21\17\3\u0209\u020a\5\"\22\2\u020a\u020b\b\21\1\2"+
		"\u020b\u020d\3\2\2\2\u020c\u0203\3\2\2\2\u020c\u0208\3\2\2\2\u020d\u0210"+
		"\3\2\2\2\u020e\u020c\3\2\2\2\u020e\u020f\3\2\2\2\u020f!\3\2\2\2\u0210"+
		"\u020e\3\2\2\2\u0211\u0213\7\61\2\2\u0212\u0214\7I\2\2\u0213\u0212\3\2"+
		"\2\2\u0213\u0214\3\2\2\2\u0214#\3\2\2\2\u0215\u0222\7.\2\2\u0216\u0222"+
		"\7\f\2\2\u0217\u0218\7\60\2\2\u0218\u0222\7I\2\2\u0219\u0222\7\26\2\2"+
		"\u021a\u0222\7\5\2\2\u021b\u0222\7 \2\2\u021c\u0222\7 \2\2\u021d\u021e"+
		"\7\22\2\2\u021e\u0222\7I\2\2\u021f\u0220\7\7\2\2\u0220\u0222\7I\2\2\u0221"+
		"\u0215\3\2\2\2\u0221\u0216\3\2\2\2\u0221\u0217\3\2\2\2\u0221\u0219\3\2"+
		"\2\2\u0221\u021a\3\2\2\2\u0221\u021b\3\2\2\2\u0221\u021c\3\2\2\2\u0221"+
		"\u021d\3\2\2\2\u0221\u021f\3\2\2\2\u0222%\3\2\2\2\u0223\u0224\t\3\2\2"+
		"\u0224\u0225\7I\2\2\u0225\'\3\2\2\29,\619DJOUYdtz~\u0087\u008b\u0092\u009a"+
		"\u00a5\u00b7\u00c0\u00c7\u00cf\u00d7\u00df\u00ec\u00f5\u00fd\u0106\u010e"+
		"\u0116\u011e\u0129\u0137\u0139\u0149\u0152\u015b\u016c\u0171\u0191\u0193"+
		"\u019b\u01a2\u01b0\u01b8\u01c6\u01cd\u01d4\u01da\u01e2\u01f0\u0201\u020c"+
		"\u020e\u0213\u0221";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}