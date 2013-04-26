// Generated from Expr.g4 by ANTLR 4.0

	package compserver.tcasegen.strategies.SetLogGrammar;
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
		T__61=1, T__60=2, T__59=3, T__58=4, T__57=5, T__56=6, T__55=7, T__54=8, 
		T__53=9, T__52=10, T__51=11, T__50=12, T__49=13, T__48=14, T__47=15, T__46=16, 
		T__45=17, T__44=18, T__43=19, T__42=20, T__41=21, T__40=22, T__39=23, 
		T__38=24, T__37=25, T__36=26, T__35=27, T__34=28, T__33=29, T__32=30, 
		T__31=31, T__30=32, T__29=33, T__28=34, T__27=35, T__26=36, T__25=37, 
		T__24=38, T__23=39, T__22=40, T__21=41, T__20=42, T__19=43, T__18=44, 
		T__17=45, T__16=46, T__15=47, T__14=48, T__13=49, T__12=50, T__11=51, 
		T__10=52, T__9=53, T__8=54, T__7=55, T__6=56, T__5=57, T__4=58, T__3=59, 
		T__2=60, T__1=61, T__0=62, NAME=63, NUM=64, IN_FUN_P3=65, IN_FUN_P4=66, 
		IN_FUN_P5=67, IN_FUN_P6=68, POST_FUN=69, IN_GEN=70, DECORATION=71, NL=72, 
		WS=73, SETSTART=74, SETEND=75, LISTSTART=76, LISTEND=77, IMGSTART=78, 
		IMGEND=79, SKIP=80;
	public static final String[] tokenNames = {
		"<INVALID>", "'schema'", "'\\lnot'", "'\\#'", "'rev'", "'min'", "'['", 
		"'<'", "'false'", "'_{1}'", "'\\dom'", "'\\emptyset'", "'\\upto'", "'tail'", 
		"'}'", "'\\notin'", "'max'", "'\\land'", "')'", "'@'", "'\\seq'", "'head'", 
		"'='", "'\\leq'", "'\\prefix'", "'squash'", "'\\nat'", "'\\neq'", "'\\where'", 
		"'\\geq'", "'\\bigcup'", "'::='", "'\\subseteq'", "'|'", "'\\end{'", "'\\suffix'", 
		"']'", "'last'", "','", "'}{'", "'('", "':'", "'\\lor'", "'\\ran'", "'\\end{zed}'", 
		"'\\in'", "'seq_{1}'", "'\\cross'", "'true'", "'\\begin{'", "'\\subset'", 
		"'\\power'", "'.'", "'\\iff'", "'schemaType'", "'\\implies'", "';'", "'front'", 
		"'>'", "'\\begin{zed}'", "'\\num'", "'=='", "'\\mapsto'", "NAME", "NUM", 
		"IN_FUN_P3", "IN_FUN_P4", "IN_FUN_P5", "IN_FUN_P6", "'\\inv'", "IN_GEN", 
		"'~'", "NL", "WS", "'\\{'", "'\\}'", "'\\langle'", "'\\rangle'", "'\\limg'", 
		"'\\rimg'", "SKIP"
	};
	public static final int
		RULE_specification = 0, RULE_paragraph = 1, RULE_basic_type = 2, RULE_equivalent_type = 3, 
		RULE_enumeration_type = 4, RULE_schemaText = 5, RULE_declPart = 6, RULE_declaration = 7, 
		RULE_declName = 8, RULE_predicate = 9, RULE_expression = 10, RULE_pre_gen = 11, 
		RULE_seq_op = 12;
	public static final String[] ruleNames = {
		"specification", "paragraph", "basic_type", "equivalent_type", "enumeration_type", 
		"schemaText", "declPart", "declaration", "declName", "predicate", "expression", 
		"pre_gen", "seq_op"
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
					invertedType = invertedType.concat((String) ((DefaultMutableTreeNode) child.getChildAt(1)).getUserObject());
					invertedType = invertedType.concat("\\cross");
					invertedType = invertedType.concat((String) ((DefaultMutableTreeNode) child.getChildAt(0)).getUserObject());
				}
				invertedType = invertedType.concat(")");
			
			} else { //Entonces empieza con pfun, rel etc
			
				invertedType = invertedType.concat((String) ((DefaultMutableTreeNode) root.getChildAt(1)).getUserObject());
				invertedType = invertedType.concat(rootType);
				invertedType = invertedType.concat((String) ((DefaultMutableTreeNode) root.getChildAt(0)).getUserObject());
			
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
					
					leftAndRight.add((String) left.getUserObject());
					leftAndRight.add((String) right.getUserObject());
				}
			
			}
			else if (isSequence(rootType)) { //Entonces empieza con pfun, rel etc

				leftAndRight.add("\\nat");
				right = (DefaultMutableTreeNode) root.getChildAt(0);
				while (((String) right.getUserObject()).equals("()"))
					right = (DefaultMutableTreeNode) right.getChildAt(0);
				leftAndRight.add((String) right.getUserObject());

			}
			else { //Entonces empieza con pfun, rel etc

			left = (DefaultMutableTreeNode) root.getChildAt(0);
			while (((String) left.getUserObject()).equals("()"))
				left = (DefaultMutableTreeNode) left.getChildAt(0);
			right = (DefaultMutableTreeNode) root.getChildAt(1);
			while (((String) right.getUserObject()).equals("()"))
				right = (DefaultMutableTreeNode) right.getChildAt(0);
				
			leftAndRight.add((String) left.getUserObject());
			leftAndRight.add((String) right.getUserObject());
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
			
			if (tipoSchema == 0 & type != null) {
				if (isBasic(type)) {
					if(!type.startsWith("BasicType")) {
						type = type.split(":")[1];
						print(var + " in " + type);
					} else
						type = type.split(":")[1];
					return type;
				}
			
				String nodeType = getType(type);
				
				if (isSequence(nodeType)){
					if (nodeType.equals("\\seq_{1}"))
						print(var + " neq []");
					printAtEnd("list(" + var + ")");
				}
				else if (nodeType.equals("\\rel"))
					printAtEnd("is_rel(" + var + ")");
				else if (nodeType.equals("\\pfun"))
					printAtEnd("is_pfun(" + var + ")");
				else if (nodeType.equals("\\fun"))
					printAtEnd("is_fun(" + var + ")");
				else if (type.equals("\\nat") || type.equals("\\num") || type.equals("\\nat_{1}"))
					print(var + " in " + memory.get(type));
				else if (nodeType.equals("\\power")) {
					//Veo si lo que sigue es un tipo enumerado
					String childType = getChildType(type,0);
					childType = types.get(childType);
					if (childType != null && childType.startsWith("EnumerationType"))
						print("subset(" + var + "," + childType.split(":")[1] + ")");
				}
				else { //double check
					type = types.get(type);
					if (type != null && isBasic(type)) {
						if(!type.startsWith("BasicType")) {
							type = type.split(":")[1];
							print(var + " in " + type);
						} else
							type = type.split(":")[1];
						return type;
					}
				}
			}
			return type;
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
			setState(33); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(26); paragraph();
				setState(30);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(27); match(NL);
					}
					}
					setState(32);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(35); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==49 || _la==59 );
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
			setState(75);
			switch (_input.LA(1)) {
			case 49:
				enterOuterAlt(_localctx, 1);
				{
				setState(39); match(49);
				setState(43);
				switch (_input.LA(1)) {
				case 1:
					{
					setState(40); match(1);
					}
					break;
				case 54:
					{
					{
					setState(41); match(54);
					tipoSchema = 1; schemaTypeVars = "";
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(45); match(39);
				setState(46); ((ParagraphContext)_localctx).NAME = match(NAME);
				setState(47); match(14);
				setState(48); schemaText();

							if (tipoSchema == 1) {
								String newVarName = newVar((((ParagraphContext)_localctx).NAME!=null?((ParagraphContext)_localctx).NAME.getText():null));
								memory.put((((ParagraphContext)_localctx).NAME!=null?((ParagraphContext)_localctx).NAME.getText():null), newVarName);
								types.put((((ParagraphContext)_localctx).NAME!=null?((ParagraphContext)_localctx).NAME.getText():null), "SchemaType:" + newVarName + ":[" + schemaTypeVars + "]");
								schemaTypeVars = "";
							}
						
				setState(50); match(34);
				setState(54);
				switch (_input.LA(1)) {
				case 1:
					{
					setState(51); match(1);
					}
					break;
				case 54:
					{
					{
					setState(52); match(54);
					tipoSchema = 0;
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(56); match(14);
				}
				break;
			case 59:
				enterOuterAlt(_localctx, 2);
				{
				setState(58); match(59);
				setState(60);
				_la = _input.LA(1);
				if (_la==NL) {
					{
					setState(59); match(NL);
					}
				}

				setState(69); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(65);
					switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
					case 1:
						{
						setState(62); basic_type();
						}
						break;

					case 2:
						{
						setState(63); equivalent_type();
						}
						break;

					case 3:
						{
						setState(64); enumeration_type();
						}
						break;
					}
					setState(67); match(NL);
					}
					}
					setState(71); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==6 || _la==NAME );
				setState(73); match(44);
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
			setState(77); match(6);
			setState(78); ((Basic_typeContext)_localctx).a = ((Basic_typeContext)_localctx).declName = declName();
			((Basic_typeContext)getInvokingContext(2)).typeList.add((((Basic_typeContext)_localctx).a!=null?_input.getText(((Basic_typeContext)_localctx).a.start,((Basic_typeContext)_localctx).a.stop):null));
			setState(86);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==38) {
				{
				{
				setState(80); match(38);
				setState(81); ((Basic_typeContext)_localctx).b = ((Basic_typeContext)_localctx).declName = declName();
				((Basic_typeContext)getInvokingContext(2)).typeList.add((((Basic_typeContext)_localctx).b!=null?_input.getText(((Basic_typeContext)_localctx).b.start,((Basic_typeContext)_localctx).b.stop):null));
				}
				}
				setState(88);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(89); match(36);

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
			setState(92); ((Equivalent_typeContext)_localctx).declName = declName();
			setState(93); match(61);
			setState(94); ((Equivalent_typeContext)_localctx).expression = expression(0);
			 
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
			setState(97); ((Enumeration_typeContext)_localctx).d = declName();
			setState(98); match(31);
			setState(99); ((Enumeration_typeContext)_localctx).a = declName();
			((Enumeration_typeContext)getInvokingContext(4)).cases.add((((Enumeration_typeContext)_localctx).a!=null?_input.getText(((Enumeration_typeContext)_localctx).a.start,((Enumeration_typeContext)_localctx).a.stop):null));
			setState(102);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 3) | (1L << 4) | (1L << 5) | (1L << 10) | (1L << 11) | (1L << 13) | (1L << 16) | (1L << 20) | (1L << 21) | (1L << 25) | (1L << 26) | (1L << 30) | (1L << 37) | (1L << 40) | (1L << 43) | (1L << 46) | (1L << 51) | (1L << 57) | (1L << 60) | (1L << NAME))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (NUM - 64)) | (1L << (DECORATION - 64)) | (1L << (SETSTART - 64)) | (1L << (LISTSTART - 64)))) != 0)) {
				{
				setState(101); expression(0);
				}
			}

			setState(112);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==33) {
				{
				{
				setState(104); match(33);
				setState(105); ((Enumeration_typeContext)_localctx).b = declName();
				((Enumeration_typeContext)getInvokingContext(4)).cases.add((((Enumeration_typeContext)_localctx).b!=null?_input.getText(((Enumeration_typeContext)_localctx).b.start,((Enumeration_typeContext)_localctx).b.stop):null));
				setState(108);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 3) | (1L << 4) | (1L << 5) | (1L << 10) | (1L << 11) | (1L << 13) | (1L << 16) | (1L << 20) | (1L << 21) | (1L << 25) | (1L << 26) | (1L << 30) | (1L << 37) | (1L << 40) | (1L << 43) | (1L << 46) | (1L << 51) | (1L << 57) | (1L << 60) | (1L << NAME))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (NUM - 64)) | (1L << (DECORATION - 64)) | (1L << (SETSTART - 64)) | (1L << (LISTSTART - 64)))) != 0)) {
					{
					setState(107); expression(0);
					}
				}

				}
				}
				setState(114);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
				
					String elements = new String();
					while( !((Enumeration_typeContext)getInvokingContext(4)).cases.isEmpty() ){
						String e = ((Enumeration_typeContext)getInvokingContext(4)).cases.remove(0);
						String eMinus = e.substring(0,1).toLowerCase() + e.substring(1); //Pasamos la primer mayuscula a minuscula ya que setlog asi lo precisa
						elements = elements.concat(eMinus);
						
						memory.put(e,eMinus);
						
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
			setState(117); match(NL);
			setState(121);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				setState(118); declPart();
				setState(119); match(NL);
				}
				break;
			}
			setState(125);
			_la = _input.LA(1);
			if (_la==28) {
				{
				setState(123); match(28);
				setState(124); match(NL);
				}
			}

			setState(132);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 2) | (1L << 3) | (1L << 4) | (1L << 5) | (1L << 8) | (1L << 10) | (1L << 11) | (1L << 13) | (1L << 16) | (1L << 20) | (1L << 21) | (1L << 25) | (1L << 26) | (1L << 30) | (1L << 37) | (1L << 40) | (1L << 43) | (1L << 46) | (1L << 48) | (1L << 51) | (1L << 57) | (1L << 60) | (1L << NAME))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (NUM - 64)) | (1L << (DECORATION - 64)) | (1L << (SETSTART - 64)) | (1L << (LISTSTART - 64)))) != 0)) {
				{
				{
				setState(127); predicate(0);
				setState(128); match(NL);
				}
				}
				setState(134);
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
			setState(135); declaration();
			setState(140);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(136);
					_la = _input.LA(1);
					if ( !(_la==56 || _la==NL) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					setState(137); declaration();
					}
					} 
				}
				setState(142);
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
			setState(143); ((DeclarationContext)_localctx).a = declName();
			((DeclarationContext)getInvokingContext(7)).vars.add((((DeclarationContext)_localctx).a!=null?_input.getText(((DeclarationContext)_localctx).a.start,((DeclarationContext)_localctx).a.stop):null));
			setState(151);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==38) {
				{
				{
				setState(145); match(38);
				setState(146); ((DeclarationContext)_localctx).b = declName();
				((DeclarationContext)getInvokingContext(7)).vars.add((((DeclarationContext)_localctx).b!=null?_input.getText(((DeclarationContext)_localctx).b.start,((DeclarationContext)_localctx).b.stop):null));
				}
				}
				setState(153);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(154); match(41);
			setState(155); ((DeclarationContext)_localctx).expression = expression(0);

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
			setState(158); match(NAME);
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
			setState(283);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				{
				setState(161); ((PredicateContext)_localctx).e1 = expression(0);
				setState(162); match(45);
				setState(163); ((PredicateContext)_localctx).e2 = expression(0);

						String a, b;
						a = memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						
						print(a + " in " + b);
					/*	//Impresion de tipo
						String type = types.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						if (type != null)
							if (type.equals("\\power\\num") || type.equals("\\power\\nat"))
								print(a + " in " + memory.get(type.substring(6)));*/
					
				}
				break;

			case 2:
				{
				setState(178);
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
				case 43:
				case 46:
				case 51:
				case 57:
				case 60:
				case NAME:
				case NUM:
				case DECORATION:
				case SETSTART:
				case LISTSTART:
					{
					setState(166); ((PredicateContext)_localctx).e1 = expression(0);
					setState(167); match(15);
					setState(169);
					switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
					case 1:
						{
						setState(168); match(DECORATION);
						}
						break;
					}
					setState(171); ((PredicateContext)_localctx).e2 = expression(0);
					}
					break;
				case 2:
					{
					setState(173); match(2);
					setState(174); ((PredicateContext)_localctx).e1 = expression(0);
					setState(175); match(45);
					setState(176); ((PredicateContext)_localctx).e2 = expression(0);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}

						String a, b;
						a = memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						print(a + " nin " + b);
						/*
						//Impresion de tipo
						String type = types.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						if (type != null)
							if (type.equals("\\power\\num") || type.equals("\\power\\nat"))
								print(a + " in " + memory.get(type.substring(6)));*/
					
				}
				break;

			case 3:
				{
				setState(182); ((PredicateContext)_localctx).e1 = expression(0);
				setState(183); match(7);
				setState(185);
				switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
				case 1:
					{
					setState(184); match(DECORATION);
					}
					break;
				}
				setState(187); ((PredicateContext)_localctx).e2 = expression(0);

						String a, b;
						a = memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						print(a + " < " + b);
					
				}
				break;

			case 4:
				{
				setState(190); ((PredicateContext)_localctx).e1 = expression(0);
				setState(191); match(58);
				setState(193);
				switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
				case 1:
					{
					setState(192); match(DECORATION);
					}
					break;
				}
				setState(195); ((PredicateContext)_localctx).e2 = expression(0);

						String a, b;
						a = memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						print(a + " > " + b);
					
				}
				break;

			case 5:
				{
				setState(198); ((PredicateContext)_localctx).e1 = expression(0);
				setState(199); match(23);
				setState(201);
				switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
				case 1:
					{
					setState(200); match(DECORATION);
					}
					break;
				}
				setState(203); ((PredicateContext)_localctx).e2 = expression(0);

						String a, b;
						a = memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						print(a + " =< " + b);
					
				}
				break;

			case 6:
				{
				setState(206); ((PredicateContext)_localctx).e1 = expression(0);
				setState(207); match(29);
				setState(209);
				switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
				case 1:
					{
					setState(208); match(DECORATION);
					}
					break;
				}
				setState(211); ((PredicateContext)_localctx).e2 = expression(0);

						String a, b;
						a = memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						print(a + " =< " + b);
					
				}
				break;

			case 7:
				{
				setState(214); ((PredicateContext)_localctx).e1 = expression(0);
				setState(215); match(22);
				setState(216); ((PredicateContext)_localctx).e2 = expression(0);

						String a, b;
						a = memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						print(a + " = " + b);
					
				}
				break;

			case 8:
				{
				setState(219); ((PredicateContext)_localctx).e1 = expression(0);
				setState(220); match(32);
				setState(222);
				switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
				case 1:
					{
					setState(221); match(DECORATION);
					}
					break;
				}
				setState(224); ((PredicateContext)_localctx).e2 = expression(0);

						String a, b;
						a = memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						print("dsubset(" + a + "," + b + ")");
					
				}
				break;

			case 9:
				{
				setState(227); match(2);
				setState(228); ((PredicateContext)_localctx).e1 = expression(0);
				setState(229); match(32);
				setState(231);
				switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
				case 1:
					{
					setState(230); match(DECORATION);
					}
					break;
				}
				setState(233); ((PredicateContext)_localctx).e2 = expression(0);

						String a, b;
						a = memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						print("dnsubset(" + a + "," + b + ")");
					
				}
				break;

			case 10:
				{
				setState(236); ((PredicateContext)_localctx).e1 = expression(0);
				setState(237); match(50);
				setState(239);
				switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
				case 1:
					{
					setState(238); match(DECORATION);
					}
					break;
				}
				setState(241); ((PredicateContext)_localctx).e2 = expression(0);

						String a, b;
						a = memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						print("dssubset(" + a + "," + b + ")");
					
				}
				break;

			case 11:
				{
				setState(244); match(2);
				setState(245); ((PredicateContext)_localctx).e1 = expression(0);
				setState(246); match(50);
				setState(248);
				switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
				case 1:
					{
					setState(247); match(DECORATION);
					}
					break;
				}
				setState(250); ((PredicateContext)_localctx).e2 = expression(0);

						String a, b;
						a = memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						String c = memory.get( (((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null) + "\\cap" + (((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						if (c == null) {
							c = newVar();
							memory.put( (((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null) + "\\cap" + (((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null), c);
							print("dinters(" + a + "," + b + "," + c + ")");
							String type = types.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
							types.put((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null) + "\\cap" + (((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null), type);
							typeInfo(c, type);
						}
						
						print(c + " neq " + a);
					
				}
				break;

			case 12:
				{
				setState(253); ((PredicateContext)_localctx).e1 = expression(0);
				setState(254); match(27);
				setState(256);
				switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
				case 1:
					{
					setState(255); match(DECORATION);
					}
					break;
				}
				setState(258); ((PredicateContext)_localctx).e2 = expression(0);

						String a, b;
						a = memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						print(a + " neq " + b);
					
				}
				break;

			case 13:
				{
				setState(261); ((PredicateContext)_localctx).e1 = expression(0);
				setState(262); match(24);
				setState(264);
				switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
				case 1:
					{
					setState(263); match(DECORATION);
					}
					break;
				}
				setState(266); ((PredicateContext)_localctx).e2 = expression(0);

						String a, b;
						a = memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						print("prolog_call(append(" + a + ",_," + b + "))");
					
				}
				break;

			case 14:
				{
				setState(269); ((PredicateContext)_localctx).e1 = expression(0);
				setState(270); match(35);
				setState(272);
				switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
				case 1:
					{
					setState(271); match(DECORATION);
					}
					break;
				}
				setState(274); ((PredicateContext)_localctx).e2 = expression(0);

						String a, b;
						a = memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						print("prolog_call(append(_," + a + "," + b + "))");
					
				}
				break;

			case 15:
				{
				setState(277); match(40);
				setState(278); predicate(0);
				setState(279); match(18);
				}
				break;

			case 16:
				{
				setState(281); match(48);
				}
				break;

			case 17:
				{
				setState(282); match(8);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(299);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(297);
					switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
					case 1:
						{
						_localctx = new PredicateContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_predicate);
						setState(285);
						if (!(4 >= _localctx._p)) throw new FailedPredicateException(this, "4 >= $_p");
						setState(286); match(53);
						setState(287); predicate(5);
						}
						break;

					case 2:
						{
						_localctx = new PredicateContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_predicate);
						setState(288);
						if (!(3 >= _localctx._p)) throw new FailedPredicateException(this, "3 >= $_p");
						setState(289); match(55);
						setState(290); predicate(4);
						}
						break;

					case 3:
						{
						_localctx = new PredicateContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_predicate);
						setState(291);
						if (!(2 >= _localctx._p)) throw new FailedPredicateException(this, "2 >= $_p");
						setState(292); match(42);
						setState(293); predicate(3);
						}
						break;

					case 4:
						{
						_localctx = new PredicateContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_predicate);
						setState(294);
						if (!(1 >= _localctx._p)) throw new FailedPredicateException(this, "1 >= $_p");
						setState(295); match(17);
						setState(296); predicate(2);
						}
						break;
					}
					} 
				}
				setState(301);
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
		public ExpressionContext a;
		public ExpressionContext e1;
		public ExpressionContext e;
		public Seq_opContext seq_op;
		public ExpressionContext expression;
		public Pre_genContext pre_gen;
		public Token NAME;
		public Token NUM;
		public Token SETSTART;
		public ExpressionContext b;
		public Token SETEND;
		public DeclPartContext declPart;
		public PredicateContext predicate;
		public ExpressionContext c;
		public Token DECORATION;
		public Token LISTSTART;
		public Token LISTEND;
		public Token IN_GEN;
		public Token IN_FUN_P6;
		public ExpressionContext e2;
		public Token IN_FUN_P5;
		public Token IN_FUN_P4;
		public Token IN_FUN_P3;
		public Token IMGSTART;
		public Token IMGEND;
		public Token POST_FUN;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public TerminalNode SETSTART() { return getToken(ExprParser.SETSTART, 0); }
		public TerminalNode IN_FUN_P6() { return getToken(ExprParser.IN_FUN_P6, 0); }
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode NAME() { return getToken(ExprParser.NAME, 0); }
		public PredicateContext predicate() {
			return getRuleContext(PredicateContext.class,0);
		}
		public DeclPartContext declPart() {
			return getRuleContext(DeclPartContext.class,0);
		}
		public TerminalNode POST_FUN() { return getToken(ExprParser.POST_FUN, 0); }
		public TerminalNode SETEND() { return getToken(ExprParser.SETEND, 0); }
		public Seq_opContext seq_op() {
			return getRuleContext(Seq_opContext.class,0);
		}
		public TerminalNode DECORATION() { return getToken(ExprParser.DECORATION, 0); }
		public Pre_genContext pre_gen() {
			return getRuleContext(Pre_genContext.class,0);
		}
		public TerminalNode LISTSTART() { return getToken(ExprParser.LISTSTART, 0); }
		public TerminalNode IMGEND() { return getToken(ExprParser.IMGEND, 0); }
		public TerminalNode IMGSTART() { return getToken(ExprParser.IMGSTART, 0); }
		public TerminalNode LISTEND() { return getToken(ExprParser.LISTEND, 0); }
		public TerminalNode IN_FUN_P3() { return getToken(ExprParser.IN_FUN_P3, 0); }
		public TerminalNode NUM() { return getToken(ExprParser.NUM, 0); }
		public TerminalNode IN_FUN_P4() { return getToken(ExprParser.IN_FUN_P4, 0); }
		public TerminalNode IN_FUN_P5() { return getToken(ExprParser.IN_FUN_P5, 0); }
		public TerminalNode IN_GEN() { return getToken(ExprParser.IN_GEN, 0); }
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
			setState(406);
			switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
			case 1:
				{
				setState(303); ((ExpressionContext)_localctx).seq_op = seq_op();
				setState(304); ((ExpressionContext)_localctx).e = ((ExpressionContext)_localctx).expression = expression(24);

						String a;
						a = memory.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null));
						
						if (memory.get( (((ExpressionContext)_localctx).seq_op!=null?_input.getText(((ExpressionContext)_localctx).seq_op.start,((ExpressionContext)_localctx).seq_op.stop):null) + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null)) == null) {
						
							String newVarName = newVar();
						
							if ((((ExpressionContext)_localctx).seq_op!=null?_input.getText(((ExpressionContext)_localctx).seq_op.start,((ExpressionContext)_localctx).seq_op.stop):null).startsWith("rev")){
								print("prolog_call(reverse(" + a + "," + newVarName + "))");
								memory.put((((ExpressionContext)_localctx).seq_op!=null?_input.getText(((ExpressionContext)_localctx).seq_op.start,((ExpressionContext)_localctx).seq_op.stop):null) + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), newVarName);
								String type = types.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null));
								types.put((((ExpressionContext)_localctx).seq_op!=null?_input.getText(((ExpressionContext)_localctx).seq_op.start,((ExpressionContext)_localctx).seq_op.stop):null) + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), type);
								typeInfo(newVarName, type);
								if (modoSetExpression != 0 )
									setExpressionVars.put((((ExpressionContext)_localctx).seq_op!=null?_input.getText(((ExpressionContext)_localctx).seq_op.start,((ExpressionContext)_localctx).seq_op.stop):null) + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), newVarName);
							}
							else if ((((ExpressionContext)_localctx).seq_op!=null?_input.getText(((ExpressionContext)_localctx).seq_op.start,((ExpressionContext)_localctx).seq_op.stop):null).startsWith("head")){
								print("nth1(1," + a + "," + newVarName + ")");
								memory.put((((ExpressionContext)_localctx).seq_op!=null?_input.getText(((ExpressionContext)_localctx).seq_op.start,((ExpressionContext)_localctx).seq_op.stop):null) + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), newVarName);
								String type = getChildType(types.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null)), 0);
								types.put((((ExpressionContext)_localctx).seq_op!=null?_input.getText(((ExpressionContext)_localctx).seq_op.start,((ExpressionContext)_localctx).seq_op.stop):null) + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), type);
								typeInfo(newVarName, type);
								if (modoSetExpression != 0 )
									setExpressionVars.put((((ExpressionContext)_localctx).seq_op!=null?_input.getText(((ExpressionContext)_localctx).seq_op.start,((ExpressionContext)_localctx).seq_op.stop):null) + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), newVarName);
							}
							else if ((((ExpressionContext)_localctx).seq_op!=null?_input.getText(((ExpressionContext)_localctx).seq_op.start,((ExpressionContext)_localctx).seq_op.stop):null).startsWith("last")){
								print("prolog_call(last(" + a + "," + newVarName + "))");
								memory.put((((ExpressionContext)_localctx).seq_op!=null?_input.getText(((ExpressionContext)_localctx).seq_op.start,((ExpressionContext)_localctx).seq_op.stop):null) + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), newVarName);
								String type = getChildType(types.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null)), 0);
								types.put((((ExpressionContext)_localctx).seq_op!=null?_input.getText(((ExpressionContext)_localctx).seq_op.start,((ExpressionContext)_localctx).seq_op.stop):null) + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), type);
								typeInfo(newVarName, type);
								if (modoSetExpression != 0 )
									setExpressionVars.put((((ExpressionContext)_localctx).seq_op!=null?_input.getText(((ExpressionContext)_localctx).seq_op.start,((ExpressionContext)_localctx).seq_op.stop):null) + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), newVarName);
							}
							else if ((((ExpressionContext)_localctx).seq_op!=null?_input.getText(((ExpressionContext)_localctx).seq_op.start,((ExpressionContext)_localctx).seq_op.stop):null).startsWith("tail")){
								print("prolog_call(drop(1," + a + "," + newVarName + "))");
								memory.put((((ExpressionContext)_localctx).seq_op!=null?_input.getText(((ExpressionContext)_localctx).seq_op.start,((ExpressionContext)_localctx).seq_op.stop):null) + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), newVarName);
								String type = types.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null));
								types.put((((ExpressionContext)_localctx).seq_op!=null?_input.getText(((ExpressionContext)_localctx).seq_op.start,((ExpressionContext)_localctx).seq_op.stop):null) + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), type);
								typeInfo(newVarName, type);
								if (modoSetExpression != 0 )
									setExpressionVars.put((((ExpressionContext)_localctx).seq_op!=null?_input.getText(((ExpressionContext)_localctx).seq_op.start,((ExpressionContext)_localctx).seq_op.stop):null) + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), newVarName);
							}
							else if ((((ExpressionContext)_localctx).seq_op!=null?_input.getText(((ExpressionContext)_localctx).seq_op.start,((ExpressionContext)_localctx).seq_op.stop):null).startsWith("front")){
								String n = newVar();
								print("prolog_call(length(" + a + "," + n + "))");
								String natName = memory.get("\\nat");
								if (natName == null) {
								    natName = newVar("NAT");
									memory.put("\\nat", natName);
									print(natName + " = int(0, 10000000000)");
									types.put("\\nat", "\\nat");
								}
								print(n + " in " + natName);
								print("prolog_call(take(" + n + "-1" + "," + a + "," + newVarName + "))");
								memory.put((((ExpressionContext)_localctx).seq_op!=null?_input.getText(((ExpressionContext)_localctx).seq_op.start,((ExpressionContext)_localctx).seq_op.stop):null) + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), newVarName);
								String type = types.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null));
								types.put((((ExpressionContext)_localctx).seq_op!=null?_input.getText(((ExpressionContext)_localctx).seq_op.start,((ExpressionContext)_localctx).seq_op.stop):null) + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), type);
								typeInfo(newVarName, type);
								if (modoSetExpression != 0 )
									setExpressionVars.put((((ExpressionContext)_localctx).seq_op!=null?_input.getText(((ExpressionContext)_localctx).seq_op.start,((ExpressionContext)_localctx).seq_op.stop):null) + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), newVarName);
							}
							else if ((((ExpressionContext)_localctx).seq_op!=null?_input.getText(((ExpressionContext)_localctx).seq_op.start,((ExpressionContext)_localctx).seq_op.stop):null).startsWith("squash")){
								print("squash(" + a + "," + newVarName + ")");
								memory.put((((ExpressionContext)_localctx).seq_op!=null?_input.getText(((ExpressionContext)_localctx).seq_op.start,((ExpressionContext)_localctx).seq_op.stop):null) + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), newVarName);
								String type = types.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null));
								ArrayList<String> leftAndRight = leftAndRightTypes(type);
								type = "\\seq(" + leftAndRight.get(1) + ")";
								types.put((((ExpressionContext)_localctx).seq_op!=null?_input.getText(((ExpressionContext)_localctx).seq_op.start,((ExpressionContext)_localctx).seq_op.stop):null) + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), type);
								typeInfo(newVarName, type);
								if (modoSetExpression != 0 )
									setExpressionVars.put((((ExpressionContext)_localctx).seq_op!=null?_input.getText(((ExpressionContext)_localctx).seq_op.start,((ExpressionContext)_localctx).seq_op.stop):null) + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), newVarName);
							}
						}
					
				}
				break;

			case 2:
				{
				setState(307); match(51);
				setState(308); ((ExpressionContext)_localctx).e = ((ExpressionContext)_localctx).expression = expression(17);

						String eType = types.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null));
						if (isBasic(eType))
							eType = (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null);
					
						types.put("\\power" + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), "\\power" + eType );
					
				}
				break;

			case 3:
				{
				setState(311); ((ExpressionContext)_localctx).pre_gen = pre_gen();
				setState(312); ((ExpressionContext)_localctx).e = ((ExpressionContext)_localctx).expression = expression(16);

						String a;
						a = memory.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null));
						
						if ((((ExpressionContext)_localctx).pre_gen!=null?_input.getText(((ExpressionContext)_localctx).pre_gen.start,((ExpressionContext)_localctx).pre_gen.stop):null).equals("\\#")){
							if (memory.get("\\#" + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null)) == null) {
								String newVarName = newVar();
								memory.put("\\#" + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), newVarName);
								types.put("\\#" + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), "\\nat");
								if (modoSetExpression != 0 )
									setExpressionVars.put("\\#" + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), newVarName);
									
								String type = getType(types.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null)));
								if (isSequence(type))
									print("prolog_call(length(" + a + "," + newVarName + "))");
								else
									print("size(" + a + "," + newVarName + ")");					
								
								String natName = memory.get("\\nat");
								if (natName == null) {
								    natName = newVar("NAT");
									memory.put("\\nat", natName);
									print(natName + " = int(0, 10000000000)");
									types.put("\\nat", "\\nat");
								}
								print(newVarName + " in " + natName);
							}
						}
						else if ((((ExpressionContext)_localctx).pre_gen!=null?_input.getText(((ExpressionContext)_localctx).pre_gen.start,((ExpressionContext)_localctx).pre_gen.stop):null).equals("\\dom")){
							if (memory.get("\\dom" + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null)) == null) {
								String newVarName = newVar();
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
						}
						else if ((((ExpressionContext)_localctx).pre_gen!=null?_input.getText(((ExpressionContext)_localctx).pre_gen.start,((ExpressionContext)_localctx).pre_gen.stop):null).equals("\\ran")){
							if (memory.get("\\ran" + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null)) == null) {
								String newVarName = newVar();
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
						}
						else if ((((ExpressionContext)_localctx).pre_gen!=null?_input.getText(((ExpressionContext)_localctx).pre_gen.start,((ExpressionContext)_localctx).pre_gen.stop):null).startsWith("seq_{1}")) {
							String eType = types.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null));
							if (isBasic(eType))
								eType = (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null);
						
							types.put((((ExpressionContext)_localctx).pre_gen!=null?_input.getText(((ExpressionContext)_localctx).pre_gen.start,((ExpressionContext)_localctx).pre_gen.stop):null) + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), "\\seq_{1}" + eType);
						}
						else if ((((ExpressionContext)_localctx).pre_gen!=null?_input.getText(((ExpressionContext)_localctx).pre_gen.start,((ExpressionContext)_localctx).pre_gen.stop):null).equals("\\seq")) {
							String eType = types.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null));
							if (isBasic(eType))
								eType = (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null);
						
							types.put("\\seq" + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), "\\seq" + eType);
						}
						else if ((((ExpressionContext)_localctx).pre_gen!=null?_input.getText(((ExpressionContext)_localctx).pre_gen.start,((ExpressionContext)_localctx).pre_gen.stop):null).equals("\\bigcup")){
							if (memory.get("\\bigcup" + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null)) == null) {
								String newVarName = newVar();
								memory.put("\\bigcup" + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), newVarName);
								if (modoSetExpression != 0 )
									setExpressionVars.put("\\bigcup" + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), newVarName);
								types.put("\\bigcup" + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), getChildType(types.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null)), 0));
								
								String e = memory.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null));
								print("bun(" + e + "," + newVarName + ")");
							}
						}
						else if ((((ExpressionContext)_localctx).pre_gen!=null?_input.getText(((ExpressionContext)_localctx).pre_gen.start,((ExpressionContext)_localctx).pre_gen.stop):null).equals("\\bigcap")){
							if (memory.get("\\bigcap" + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null)) == null) {
								String newVarName = newVar();
								memory.put("\\bigcap" + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), newVarName);
								if (modoSetExpression != 0 )
									setExpressionVars.put("\\bigcap" + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), newVarName);
								types.put("\\bigcap" + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), getChildType(types.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null)), 0));
								
								String e = memory.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null));
								print("bdinters(" + e + "," + newVarName + ")");
							}
						}
						else if ((((ExpressionContext)_localctx).pre_gen!=null?_input.getText(((ExpressionContext)_localctx).pre_gen.start,((ExpressionContext)_localctx).pre_gen.stop):null).startsWith("min")){
							if (memory.get((((ExpressionContext)_localctx).pre_gen!=null?_input.getText(((ExpressionContext)_localctx).pre_gen.start,((ExpressionContext)_localctx).pre_gen.stop):null) + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null)) == null) {
								String newVarName = newVar();
								memory.put((((ExpressionContext)_localctx).pre_gen!=null?_input.getText(((ExpressionContext)_localctx).pre_gen.start,((ExpressionContext)_localctx).pre_gen.stop):null) + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), newVarName);
								if (modoSetExpression != 0 )
									setExpressionVars.put((((ExpressionContext)_localctx).pre_gen!=null?_input.getText(((ExpressionContext)_localctx).pre_gen.start,((ExpressionContext)_localctx).pre_gen.stop):null) + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), newVarName);
								types.put((((ExpressionContext)_localctx).pre_gen!=null?_input.getText(((ExpressionContext)_localctx).pre_gen.start,((ExpressionContext)_localctx).pre_gen.stop):null) + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), getChildType(types.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null)), 0));
								
								String e = memory.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null));
								print("prolog_call(min(" + e + "," + newVarName + "))");
							}
						}
						else if ((((ExpressionContext)_localctx).pre_gen!=null?_input.getText(((ExpressionContext)_localctx).pre_gen.start,((ExpressionContext)_localctx).pre_gen.stop):null).startsWith("max")){
							if (memory.get((((ExpressionContext)_localctx).pre_gen!=null?_input.getText(((ExpressionContext)_localctx).pre_gen.start,((ExpressionContext)_localctx).pre_gen.stop):null) + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null)) == null) {
								String newVarName = newVar();
								memory.put((((ExpressionContext)_localctx).pre_gen!=null?_input.getText(((ExpressionContext)_localctx).pre_gen.start,((ExpressionContext)_localctx).pre_gen.stop):null) + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), newVarName);
								if (modoSetExpression != 0 )
									setExpressionVars.put((((ExpressionContext)_localctx).pre_gen!=null?_input.getText(((ExpressionContext)_localctx).pre_gen.start,((ExpressionContext)_localctx).pre_gen.stop):null) + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), newVarName);
								types.put((((ExpressionContext)_localctx).pre_gen!=null?_input.getText(((ExpressionContext)_localctx).pre_gen.start,((ExpressionContext)_localctx).pre_gen.stop):null) + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), getChildType(types.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null)), 0));
								
								String e = memory.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null));
								print("max(" + e + "," + newVarName + ")");
							}
						}
					
				}
				break;

			case 4:
				{
				setState(315); ((ExpressionContext)_localctx).NAME = match(NAME);

						if (memory.get((((ExpressionContext)_localctx).NAME!=null?((ExpressionContext)_localctx).NAME.getText():null)) == null)
						{
							String newVarName = newVar((((ExpressionContext)_localctx).NAME!=null?((ExpressionContext)_localctx).NAME.getText():null));
							
							memory.put((((ExpressionContext)_localctx).NAME!=null?((ExpressionContext)_localctx).NAME.getText():null), newVarName);
							if (modoSetExpression != 0 )
								setExpressionVars.put((((ExpressionContext)_localctx).NAME!=null?((ExpressionContext)_localctx).NAME.getText():null), newVarName);
						}
					
				}
				break;

			case 5:
				{
				setState(317); ((ExpressionContext)_localctx).NUM = match(NUM);

						if (memory.get((((ExpressionContext)_localctx).NUM!=null?((ExpressionContext)_localctx).NUM.getText():null)) == null) {
							memory.put((((ExpressionContext)_localctx).NUM!=null?((ExpressionContext)_localctx).NUM.getText():null), (((ExpressionContext)_localctx).NUM!=null?((ExpressionContext)_localctx).NUM.getText():null));
							types.put((((ExpressionContext)_localctx).NUM!=null?((ExpressionContext)_localctx).NUM.getText():null), "\\num");
						}
					
				}
				break;

			case 6:
				{
				setState(319); match(11);

						if (memory.get("\\emptyset") == null) {
							memory.put("\\emptyset", "{}");
							types.put("\\emptyset", "\\power(" + "generic" + ")");
						}
					
				}
				break;

			case 7:
				{
				setState(321); ((ExpressionContext)_localctx).SETSTART = match(SETSTART);
				setState(325);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 3) | (1L << 4) | (1L << 5) | (1L << 10) | (1L << 11) | (1L << 13) | (1L << 16) | (1L << 20) | (1L << 21) | (1L << 25) | (1L << 26) | (1L << 30) | (1L << 37) | (1L << 40) | (1L << 43) | (1L << 46) | (1L << 51) | (1L << 57) | (1L << 60) | (1L << NAME))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (NUM - 64)) | (1L << (DECORATION - 64)) | (1L << (SETSTART - 64)) | (1L << (LISTSTART - 64)))) != 0)) {
					{
					setState(322); ((ExpressionContext)_localctx).a = ((ExpressionContext)_localctx).expression = expression(0);
					_localctx.elements.add((((ExpressionContext)_localctx).a!=null?_input.getText(((ExpressionContext)_localctx).a.start,((ExpressionContext)_localctx).a.stop):null));
					}
				}

				setState(333);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==38) {
					{
					{
					setState(327); match(38);
					setState(328); ((ExpressionContext)_localctx).b = ((ExpressionContext)_localctx).expression = expression(0);
					_localctx.elements.add((((ExpressionContext)_localctx).b!=null?_input.getText(((ExpressionContext)_localctx).b.start,((ExpressionContext)_localctx).b.stop):null));
					}
					}
					setState(335);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(336); ((ExpressionContext)_localctx).SETEND = match(SETEND);
					
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

			case 8:
				{
				setState(338); ((ExpressionContext)_localctx).SETSTART = match(SETSTART);
				modoSetExpression=1; setExpressionDecl = ""; setExpressionPred = ""; setExpressionExpr = ""; setExpressionVars = new HashMap();
				setState(340); ((ExpressionContext)_localctx).declPart = declPart();
				((ExpressionContext)_localctx).zName =  (((ExpressionContext)_localctx).SETSTART!=null?((ExpressionContext)_localctx).SETSTART.getText():null) + (((ExpressionContext)_localctx).declPart!=null?_input.getText(((ExpressionContext)_localctx).declPart.start,((ExpressionContext)_localctx).declPart.stop):null);
				setState(347);
				_la = _input.LA(1);
				if (_la==33) {
					{
					setState(342); match(33);
					modoSetExpression=2;
					setState(344); ((ExpressionContext)_localctx).predicate = predicate(0);
					((ExpressionContext)_localctx).zName =  _localctx.zName.concat("|" + (((ExpressionContext)_localctx).predicate!=null?_input.getText(((ExpressionContext)_localctx).predicate.start,((ExpressionContext)_localctx).predicate.stop):null));
					}
				}

				setState(354);
				_la = _input.LA(1);
				if (_la==19) {
					{
					setState(349); match(19);
					modoSetExpression=3;
					setState(351); ((ExpressionContext)_localctx).c = ((ExpressionContext)_localctx).expression = expression(0);
					((ExpressionContext)_localctx).zName =  _localctx.zName.concat("@" + (((ExpressionContext)_localctx).c!=null?_input.getText(((ExpressionContext)_localctx).c.start,((ExpressionContext)_localctx).c.stop):null));
					}
				}

				setState(356); ((ExpressionContext)_localctx).SETEND = match(SETEND);
				modoSetExpression=0; ((ExpressionContext)_localctx).zName =  _localctx.zName.concat((((ExpressionContext)_localctx).SETEND!=null?((ExpressionContext)_localctx).SETEND.getText():null));

						if (memory.get(_localctx.zName)==null) {
						
							((ExpressionContext)_localctx).setlogName =  "";
							((ExpressionContext)_localctx).newVarName1 =  newVar();
							((ExpressionContext)_localctx).newVarName2 =  newVar();
							
							((ExpressionContext)_localctx).setlogName =  _localctx.setlogName.concat("{ " + _localctx.newVarName1 + ":exists([");
							
							Iterator<String> keysIt = setExpressionVars.keySet().iterator();
							while (keysIt.hasNext()){
								((ExpressionContext)_localctx).setlogName =  _localctx.setlogName.concat(setExpressionVars.get(keysIt.next()));
								if (keysIt.hasNext()) ((ExpressionContext)_localctx).setlogName =  _localctx.setlogName.concat(",");
							}
						
							((ExpressionContext)_localctx).setlogName =  _localctx.setlogName.concat("], " + setExpressionDecl.substring(setExpressionDecl.indexOf('&') + 1) +
							setExpressionPred + setExpressionExpr + " & " + _localctx.newVarName1 + " is " + memory.get((((ExpressionContext)_localctx).c!=null?_input.getText(((ExpressionContext)_localctx).c.start,((ExpressionContext)_localctx).c.stop):null)) + ")" + " }");
						
							memory.put(_localctx.zName, _localctx.newVarName2);
							types.put(_localctx.zName, "\\power(" + types.get((((ExpressionContext)_localctx).c!=null?_input.getText(((ExpressionContext)_localctx).c.start,((ExpressionContext)_localctx).c.stop):null)) + ")"); //REVISAR!!!
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

			case 9:
				{
				setState(361);
				_la = _input.LA(1);
				if (_la==DECORATION) {
					{
					setState(360); ((ExpressionContext)_localctx).DECORATION = match(DECORATION);
					}
				}

				setState(363); ((ExpressionContext)_localctx).LISTSTART = match(LISTSTART);
				setState(367);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 3) | (1L << 4) | (1L << 5) | (1L << 10) | (1L << 11) | (1L << 13) | (1L << 16) | (1L << 20) | (1L << 21) | (1L << 25) | (1L << 26) | (1L << 30) | (1L << 37) | (1L << 40) | (1L << 43) | (1L << 46) | (1L << 51) | (1L << 57) | (1L << 60) | (1L << NAME))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (NUM - 64)) | (1L << (DECORATION - 64)) | (1L << (SETSTART - 64)) | (1L << (LISTSTART - 64)))) != 0)) {
					{
					setState(364); ((ExpressionContext)_localctx).a = ((ExpressionContext)_localctx).expression = expression(0);
					_localctx.elements.add((((ExpressionContext)_localctx).a!=null?_input.getText(((ExpressionContext)_localctx).a.start,((ExpressionContext)_localctx).a.stop):null));
					}
				}

				setState(375);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==38) {
					{
					{
					setState(369); match(38);
					setState(370); ((ExpressionContext)_localctx).b = ((ExpressionContext)_localctx).expression = expression(0);
					_localctx.elements.add((((ExpressionContext)_localctx).b!=null?_input.getText(((ExpressionContext)_localctx).b.start,((ExpressionContext)_localctx).b.stop):null));
					}
					}
					setState(377);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(378); ((ExpressionContext)_localctx).LISTEND = match(LISTEND);
					
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
				setState(380); match(40);
				setState(381); ((ExpressionContext)_localctx).a = ((ExpressionContext)_localctx).expression = expression(0);
				_localctx.elements.add((((ExpressionContext)_localctx).a!=null?_input.getText(((ExpressionContext)_localctx).a.start,((ExpressionContext)_localctx).a.stop):null));
				setState(387); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(383); match(38);
					setState(384); ((ExpressionContext)_localctx).b = ((ExpressionContext)_localctx).expression = expression(0);
					_localctx.elements.add((((ExpressionContext)_localctx).b!=null?_input.getText(((ExpressionContext)_localctx).b.start,((ExpressionContext)_localctx).b.stop):null));
					}
					}
					setState(389); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==38 );
				setState(391); match(18);
					
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
				setState(394); match(40);
				setState(395); ((ExpressionContext)_localctx).e = ((ExpressionContext)_localctx).expression = expression(0);
				setState(396); match(18);

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
				setState(399); match(26);
				setState(400); match(9);
					
						if (memory.get(_input.getText(_localctx.start, _input.LT(-1))) == null) {
						    String newVarName = newVar("NAT1");
							memory.put(_input.getText(_localctx.start, _input.LT(-1)), newVarName);
							print(newVarName + " = int(1, 10000000000)");
							types.put(_input.getText(_localctx.start, _input.LT(-1)), _input.getText(_localctx.start, _input.LT(-1)));
						}	
					
				}
				break;

			case 13:
				{
				setState(402); match(26);
					
						if (memory.get(_input.getText(_localctx.start, _input.LT(-1))) == null) {
						    String newVarName = newVar("NAT");
							memory.put(_input.getText(_localctx.start, _input.LT(-1)), newVarName);
							print(newVarName + " = int(0, 10000000000)");
							types.put(_input.getText(_localctx.start, _input.LT(-1)), _input.getText(_localctx.start, _input.LT(-1)));
						}	
					
				}
				break;

			case 14:
				{
				setState(404); match(60);
					
						if (memory.get(_input.getText(_localctx.start, _input.LT(-1))) == null) {
						    String newVarName = newVar("INT");
							memory.put(_input.getText(_localctx.start, _input.LT(-1)), newVarName);
							print(newVarName + " = int(-10000000000, 10000000000)");
							types.put(_input.getText(_localctx.start, _input.LT(-1)), _input.getText(_localctx.start, _input.LT(-1)));
						}	
					
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(482);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,46,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(480);
					switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(408);
						if (!(26 >= _localctx._p)) throw new FailedPredicateException(this, "26 >= $_p");
						setState(409); ((ExpressionContext)_localctx).IN_GEN = match(IN_GEN);
						setState(410); ((ExpressionContext)_localctx).b = ((ExpressionContext)_localctx).expression = expression(27);

						          		//Guardo el tipo
						          		String aType = types.get((((ExpressionContext)_localctx).a!=null?_input.getText(((ExpressionContext)_localctx).a.start,((ExpressionContext)_localctx).a.stop):null));
						          		if (isBasic(aType)) {
						          			aType = (((ExpressionContext)_localctx).a!=null?_input.getText(((ExpressionContext)_localctx).a.start,((ExpressionContext)_localctx).a.stop):null);
						          		}
						          		String bType = types.get((((ExpressionContext)_localctx).b!=null?_input.getText(((ExpressionContext)_localctx).b.start,((ExpressionContext)_localctx).b.stop):null));
						          		if (isBasic(bType))
						          			bType = (((ExpressionContext)_localctx).b!=null?_input.getText(((ExpressionContext)_localctx).b.start,((ExpressionContext)_localctx).b.stop):null);
						          		
						          		if ((((ExpressionContext)_localctx).IN_GEN!=null?((ExpressionContext)_localctx).IN_GEN.getText():null).equals("\\ffun"))
						          			types.put((((ExpressionContext)_localctx).a!=null?_input.getText(((ExpressionContext)_localctx).a.start,((ExpressionContext)_localctx).a.stop):null) + (((ExpressionContext)_localctx).IN_GEN!=null?((ExpressionContext)_localctx).IN_GEN.getText():null) + (((ExpressionContext)_localctx).b!=null?_input.getText(((ExpressionContext)_localctx).b.start,((ExpressionContext)_localctx).b.stop):null), aType + "\\pfun" + bType );
						          		else
						          			types.put((((ExpressionContext)_localctx).a!=null?_input.getText(((ExpressionContext)_localctx).a.start,((ExpressionContext)_localctx).a.stop):null) + (((ExpressionContext)_localctx).IN_GEN!=null?((ExpressionContext)_localctx).IN_GEN.getText():null) + (((ExpressionContext)_localctx).b!=null?_input.getText(((ExpressionContext)_localctx).b.start,((ExpressionContext)_localctx).b.stop):null), aType + (((ExpressionContext)_localctx).IN_GEN!=null?((ExpressionContext)_localctx).IN_GEN.getText():null) + bType );
						          	
						}
						break;

					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(413);
						if (!(23 >= _localctx._p)) throw new FailedPredicateException(this, "23 >= $_p");
						setState(414); ((ExpressionContext)_localctx).IN_FUN_P6 = match(IN_FUN_P6);
						setState(415); ((ExpressionContext)_localctx).e2 = ((ExpressionContext)_localctx).expression = expression(24);

						          		String a, b;
						          		a = memory.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null));
						          		b = memory.get((((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null));
						          		
						          		if (memory.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + (((ExpressionContext)_localctx).IN_FUN_P6!=null?((ExpressionContext)_localctx).IN_FUN_P6.getText():null) + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null)) == null) {
						          		
						          			String newVarName = newVar();
						          		
						          			if ((((ExpressionContext)_localctx).IN_FUN_P6!=null?((ExpressionContext)_localctx).IN_FUN_P6.getText():null).equals("\\dres")){
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
						          			else if ((((ExpressionContext)_localctx).IN_FUN_P6!=null?((ExpressionContext)_localctx).IN_FUN_P6.getText():null).equals("\\ndres")){
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
						          			else if ((((ExpressionContext)_localctx).IN_FUN_P6!=null?((ExpressionContext)_localctx).IN_FUN_P6.getText():null).equals("\\rres")){
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
						          			else if ((((ExpressionContext)_localctx).IN_FUN_P6!=null?((ExpressionContext)_localctx).IN_FUN_P6.getText():null).equals("\\nrres")){
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

					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(418);
						if (!(22 >= _localctx._p)) throw new FailedPredicateException(this, "22 >= $_p");
						setState(419); ((ExpressionContext)_localctx).IN_FUN_P5 = match(IN_FUN_P5);
						setState(420); ((ExpressionContext)_localctx).e2 = ((ExpressionContext)_localctx).expression = expression(23);

						          		String a, b;
						          		a = memory.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null));
						          		b = memory.get((((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null));
						          		
						          		if (memory.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + (((ExpressionContext)_localctx).IN_FUN_P5!=null?((ExpressionContext)_localctx).IN_FUN_P5.getText():null) + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null)) == null) {
						          		
						          			String newVarName = newVar();
						          		
						          			if ((((ExpressionContext)_localctx).IN_FUN_P5!=null?((ExpressionContext)_localctx).IN_FUN_P5.getText():null).equals("\\oplus")){
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
						          	
						}
						break;

					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(423);
						if (!(21 >= _localctx._p)) throw new FailedPredicateException(this, "21 >= $_p");
						setState(424); ((ExpressionContext)_localctx).IN_FUN_P4 = match(IN_FUN_P4);
						setState(425); ((ExpressionContext)_localctx).e2 = ((ExpressionContext)_localctx).expression = expression(22);

						          		String a, b;
						          		a = memory.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null));
						          		b = memory.get((((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null));
						          		
						          		if (memory.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + (((ExpressionContext)_localctx).IN_FUN_P4!=null?((ExpressionContext)_localctx).IN_FUN_P4.getText():null) + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null)) == null) {
						          		
						          			String newVarName = newVar();
						          			Boolean isNumeric = false; 
						          		
						          			if ((((ExpressionContext)_localctx).IN_FUN_P4!=null?((ExpressionContext)_localctx).IN_FUN_P4.getText():null).equals("*")){
						          				print( newVarName + " is " + a + "*" + b );
						          				memory.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "*" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          				if (modoSetExpression != 0 )
						          					setExpressionVars.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "*" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          				isNumeric = true;
						          			}
						          			else if ((((ExpressionContext)_localctx).IN_FUN_P4!=null?((ExpressionContext)_localctx).IN_FUN_P4.getText():null).equals("\\div")) {
						          				print( newVarName + " is div(" + a + "," + b + ")" );
						          				memory.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\div" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          				if (modoSetExpression != 0 )
						          					setExpressionVars.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\div" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          				isNumeric = true;
						          			}
						          			else if ((((ExpressionContext)_localctx).IN_FUN_P4!=null?((ExpressionContext)_localctx).IN_FUN_P4.getText():null).equals("\\mod")){
						          				print( newVarName + " is mod(" + a + "," + b + ")" );
						          				memory.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\mod" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          				if (modoSetExpression != 0 )
						          					setExpressionVars.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\mod" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          				isNumeric = true;
						          			}
						          			else if ((((ExpressionContext)_localctx).IN_FUN_P4!=null?((ExpressionContext)_localctx).IN_FUN_P4.getText():null).equals("\\cap")){
						          					print("dinters(" + a + "," + b + "," + newVarName + ")");
						          					memory.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\cap" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          					String type = types.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null));
						          					types.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\cap" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), type);
						          					typeInfo(newVarName, type);
						          					if (modoSetExpression != 0 )
						          						setExpressionVars.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\cap" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          			}
						          			else if ((((ExpressionContext)_localctx).IN_FUN_P4!=null?((ExpressionContext)_localctx).IN_FUN_P4.getText():null).equals("\\comp")){
						          					print("comp(" + a + "," + b + "," + newVarName + ")");
						          					memory.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\comp" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          					String type1 = types.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null));
						          					String type2 = types.get((((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null));
						          					String type = "\\power((" + getChildType(type1, 0) + ")\\cross(" + getChildType(type2, 1) + "))";
						          					types.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\comp" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), type);
						          					typeInfo(newVarName, type);
						          					if (modoSetExpression != 0 )
						          						setExpressionVars.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\comp" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          			}
						          			else if ((((ExpressionContext)_localctx).IN_FUN_P4!=null?((ExpressionContext)_localctx).IN_FUN_P4.getText():null).equals("\\circ")){
						          					print("circ(" + a + "," + b + "," + newVarName + ")");
						          					memory.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\circ" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          					String type1 = getChildType(types.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null)), 1);
						          					String type = "\\power((" + type1 + ")\\cross(" + type1 + "))";
						          					types.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\circ" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), type);
						          					typeInfo(newVarName, type);
						          					if (modoSetExpression != 0 )
						          						setExpressionVars.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\circ" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          			}
						          			else if ((((ExpressionContext)_localctx).IN_FUN_P4!=null?((ExpressionContext)_localctx).IN_FUN_P4.getText():null).equals("\\extract")){
						          					print("extract(" + a + "," + b + "," + newVarName + ")");
						          					memory.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\extract" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          					String type = types.get((((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null));
						          					types.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\extract" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), type);
						          					typeInfo(newVarName, type);
						          					if (modoSetExpression != 0 )
						          						setExpressionVars.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\extract" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          			}
						          			else if ((((ExpressionContext)_localctx).IN_FUN_P4!=null?((ExpressionContext)_localctx).IN_FUN_P4.getText():null).equals("\\filter")){
						          					print("filter(" + a + "," + b + "," + newVarName + ")");
						          					memory.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\filter" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          					String type = types.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null));
						          					types.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\filter" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), type);
						          					typeInfo(newVarName, type);
						          					if (modoSetExpression != 0 )
						          						setExpressionVars.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\filter" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          			}
						          			
						          			if (isNumeric) {
						          				String numName = memory.get("\\num");
						          				if (numName == null) {
						          				    numName = newVar("INT");
						          					memory.put("\\num", numName);
						          					print(numName + " = int(-10000000000, 10000000000)");
						          					types.put("\\num", "\\num");
						          				}
						          				print(newVarName + " in " + numName);
						          				types.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + (((ExpressionContext)_localctx).IN_FUN_P4!=null?((ExpressionContext)_localctx).IN_FUN_P4.getText():null) + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), "\\num");
						          			}
						          		}
						          	
						}
						break;

					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(428);
						if (!(20 >= _localctx._p)) throw new FailedPredicateException(this, "20 >= $_p");
						setState(429); ((ExpressionContext)_localctx).IN_FUN_P3 = match(IN_FUN_P3);
						setState(430); ((ExpressionContext)_localctx).e2 = ((ExpressionContext)_localctx).expression = expression(21);

						          		String a, b;
						          		a = memory.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null));
						          		b = memory.get((((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null));
						          		
						          		if (memory.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + (((ExpressionContext)_localctx).IN_FUN_P3!=null?((ExpressionContext)_localctx).IN_FUN_P3.getText():null) + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null)) == null) {
						          		
						          			String newVarName = newVar();
						          			Boolean isNumeric = false; 
						          			
						          		
						          			if ((((ExpressionContext)_localctx).IN_FUN_P3!=null?((ExpressionContext)_localctx).IN_FUN_P3.getText():null).equals("+")){
						          				print( newVarName + " is " + a + "+" + b );
						          				memory.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "+" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          				if (modoSetExpression != 0 )
						          					setExpressionVars.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "+" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          				isNumeric = true;
						          			}
						          			else if ((((ExpressionContext)_localctx).IN_FUN_P3!=null?((ExpressionContext)_localctx).IN_FUN_P3.getText():null).equals("-")) {
						          				print( newVarName + " is " + a + "-" + b );
						          				memory.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "-" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          				if (modoSetExpression != 0 )
						          					setExpressionVars.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "-" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          				isNumeric = true;
						          			}
						          			else if ((((ExpressionContext)_localctx).IN_FUN_P3!=null?((ExpressionContext)_localctx).IN_FUN_P3.getText():null).equals("\\cup")){
						          					print("dun(" + a + "," + b + "," + newVarName + ")");
						          					memory.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\cup" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          					String type = types.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null));
						          					types.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\cup" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), type);
						          					typeInfo(newVarName, type);
						          					if (modoSetExpression != 0 )
						          						setExpressionVars.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\cup" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          			}
						          			else if ((((ExpressionContext)_localctx).IN_FUN_P3!=null?((ExpressionContext)_localctx).IN_FUN_P3.getText():null).equals("\\setminus")){
						          					print("diff(" + a + "," + b + "," + newVarName + ")");
						          					memory.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\setminus" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          					String type = types.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null));
						          					types.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\setminus" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), type);
						          					typeInfo(newVarName, type);
						          					if (modoSetExpression != 0 )
						          						setExpressionVars.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\setminus" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          			}
						          			else if ((((ExpressionContext)_localctx).IN_FUN_P3!=null?((ExpressionContext)_localctx).IN_FUN_P3.getText():null).equals("\\cat")){
						          					print("prolog_call(append(" + a + "," + b + "," + newVarName + "))");
						          					memory.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\cat" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          					String type = types.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null));
						          					types.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\cat" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), type);
						          					typeInfo(newVarName, type);
						          					if (modoSetExpression != 0 )
						          						setExpressionVars.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\cat" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          			}
						          			
						          			if (isNumeric) {
						          				String numName = memory.get("\\num");
						          				if (numName == null) {
						          				    numName = newVar("INT");
						          					memory.put("\\num", numName);
						          					print(numName + " = int(-10000000000, 10000000000)");
						          					types.put("\\num", "\\num");
						          				}
						          				print(newVarName + " in " + numName);
						          				types.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + (((ExpressionContext)_localctx).IN_FUN_P3!=null?((ExpressionContext)_localctx).IN_FUN_P3.getText():null) + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), "\\num");
						          			}
						          		}
						          	
						}
						break;

					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(433);
						if (!(19 >= _localctx._p)) throw new FailedPredicateException(this, "19 >= $_p");
						setState(434); match(12);
						setState(435); ((ExpressionContext)_localctx).e2 = ((ExpressionContext)_localctx).expression = expression(20);

						          		String a, b;
						          		a = memory.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null));
						          		b = memory.get((((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null));
						          		if (memory.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\upto" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null)) == null) {
						          			String newVarName = newVar();
						          			memory.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\upto" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          			if (modoSetExpression != 0 )
						          				setExpressionVars.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\upto" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          			print(newVarName + " = int(" + a + "," + b + ")");
						          		}
						          	
						}
						break;

					case 7:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(438);
						if (!(18 >= _localctx._p)) throw new FailedPredicateException(this, "18 >= $_p");
						setState(439); match(62);
						setState(440); ((ExpressionContext)_localctx).e2 = ((ExpressionContext)_localctx).expression = expression(19);

						          		String a, b;
						          		a = memory.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null));
						          		b = memory.get((((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null));
						          		memory.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\mapsto" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), "[" + a + "," + b + "]");
						          		types.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\mapsto" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), types.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null)) + "\\cross" + types.get((((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null)));
						          	
						}
						break;

					case 8:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(443);
						if (!(14 >= _localctx._p)) throw new FailedPredicateException(this, "14 >= $_p");
						setState(444); ((ExpressionContext)_localctx).DECORATION = match(DECORATION);
						setState(445); ((ExpressionContext)_localctx).e2 = ((ExpressionContext)_localctx).expression = expression(15);

						          		String a, b;
						          		a = memory.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null));
						          		b = memory.get((((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null));
						          		
						          		if (memory.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "~" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null)) == null) {
						          			String newVarName = newVar();
						          			memory.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "~" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          			
						          			if (modoSetExpression != 0 )
						          				setExpressionVars.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "~" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);

						          			//Si es una lista debo transformarla
						          			String type1 = types.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null));
						          			if (isSequence(getType(type1))) {
						          				String newVarName2 = newVar();
						          				print("list_to_rel(" + a + "," + newVarName2 +  ")");
						          				a = newVarName2;
						          			}

						          			String newVarType = leftAndRightTypes(type1).get(1);
						          			types.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "~" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarType);
						          			print("apply(" + a + "," + b + "," + newVarName + ")");
						          			
						          			//Imprimimos la informacion del tipo de la variable
						          			typeInfo(newVarName, newVarType);
						          		}
						          	
						}
						break;

					case 9:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(448);
						if (!(6 >= _localctx._p)) throw new FailedPredicateException(this, "6 >= $_p");
						setState(449); match(52);
						setState(450); ((ExpressionContext)_localctx).e2 = ((ExpressionContext)_localctx).expression = expression(7);

						          		if (memory.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "." + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null)) == null) {
						          		
						          			String e1Type = types.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null));
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
						          				while (!vars[position-1].contains((((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null) + ":")) //Se resta 1 porque en setlog empiezan en 1, no en 0 como en java
						          					position++;
						          				//Creamos una nueva variable
						          				String newVarName = newVar();
						          				//Vemos su tipo
						          				String type = vars[position-1].substring((((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null).length()+1);
						          				memory.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "." + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          				if (modoSetExpression != 0 )
						          					setExpressionVars.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "." + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          				types.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "." + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), type);
						          				print("nth1(" + position + "," + memory.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null)) + "," + newVarName + ")");
						          				
						          				typeInfo(newVarName, type);
						          				
						          			}
						          		}
						          	
						}
						break;

					case 10:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(453);
						if (!(25 >= _localctx._p)) throw new FailedPredicateException(this, "25 >= $_p");
						((ExpressionContext)getInvokingContext(10)).elements.add((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null));
						setState(459); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,42,_ctx);
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(455); match(47);
								setState(456); ((ExpressionContext)_localctx).e2 = ((ExpressionContext)_localctx).expression = expression(0);
								((ExpressionContext)getInvokingContext(10)).elements.add((((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null));
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(461); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,42,_ctx);
						} while ( _alt!=2 && _alt!=-1 );

						          		String unfoldedType = "";
						          		
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
						          				((ExpressionContext)_localctx).zName =  _localctx.zName.concat("\\cross");
						          				unfoldedType = unfoldedType.concat("\\cross");
						          			}
						          		}
						          		
						          		types.put(_localctx.zName, unfoldedType);
						          	
						}
						break;

					case 11:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(465);
						if (!(15 >= _localctx._p)) throw new FailedPredicateException(this, "15 >= $_p");
						setState(466); ((ExpressionContext)_localctx).IMGSTART = match(IMGSTART);
						setState(467); ((ExpressionContext)_localctx).e2 = ((ExpressionContext)_localctx).expression = expression(0);
						setState(468); ((ExpressionContext)_localctx).IMGEND = match(IMGEND);
						setState(470);
						switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
						case 1:
							{
							setState(469); ((ExpressionContext)_localctx).DECORATION = match(DECORATION);
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

					case 12:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						_localctx.e = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(474);
						if (!(5 >= _localctx._p)) throw new FailedPredicateException(this, "5 >= $_p");
						setState(475); ((ExpressionContext)_localctx).POST_FUN = match(POST_FUN);
						setState(477);
						switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
						case 1:
							{
							setState(476); ((ExpressionContext)_localctx).DECORATION = match(DECORATION);
							}
							break;
						}

						          		String a;
						          		a = memory.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null));
						          		String op = (((ExpressionContext)_localctx).POST_FUN!=null?((ExpressionContext)_localctx).POST_FUN.getText():null);
						          		if ((((ExpressionContext)_localctx).DECORATION!=null?((ExpressionContext)_localctx).DECORATION.getText():null) != null)
						          			op = op.concat((((ExpressionContext)_localctx).DECORATION!=null?((ExpressionContext)_localctx).DECORATION.getText():null));
						          		
						          		if (memory.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null) + op) == null) {
						          		
						          			String newVarName = newVar();
						          		
						          			if (op.startsWith("\\inv")){
						          				print("inv(" + newVarName + "," + a + ")");
						          				memory.put((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null) + op, newVarName);
						          				String type1 = types.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null));
						          				String type = invertType(type1); 
						          				types.put((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null) + op, type);
						          				typeInfo(newVarName, type);
						          				if (modoSetExpression != 0 )
						          					setExpressionVars.put((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null) + op, newVarName);
						          			}
						          		}
						          	
						}
						break;
					}
					} 
				}
				setState(484);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,46,_ctx);
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
		enterRule(_localctx, 22, RULE_pre_gen);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(497);
			switch ( getInterpreter().adaptivePredict(_input,47,_ctx) ) {
			case 1:
				{
				setState(485); match(43);
				}
				break;

			case 2:
				{
				setState(486); match(10);
				}
				break;

			case 3:
				{
				setState(487); match(46);
				setState(488); match(DECORATION);
				}
				break;

			case 4:
				{
				setState(489); match(20);
				}
				break;

			case 5:
				{
				setState(490); match(3);
				}
				break;

			case 6:
				{
				setState(491); match(30);
				}
				break;

			case 7:
				{
				setState(492); match(30);
				}
				break;

			case 8:
				{
				setState(493); match(16);
				setState(494); match(DECORATION);
				}
				break;

			case 9:
				{
				setState(495); match(5);
				setState(496); match(DECORATION);
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
		enterRule(_localctx, 24, RULE_seq_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(499);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 4) | (1L << 13) | (1L << 21) | (1L << 25) | (1L << 37) | (1L << 57))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(500); match(DECORATION);
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
		case 4: return 26 >= _localctx._p;

		case 5: return 23 >= _localctx._p;

		case 6: return 22 >= _localctx._p;

		case 7: return 21 >= _localctx._p;

		case 8: return 20 >= _localctx._p;

		case 9: return 19 >= _localctx._p;

		case 10: return 18 >= _localctx._p;

		case 11: return 14 >= _localctx._p;

		case 12: return 6 >= _localctx._p;

		case 13: return 25 >= _localctx._p;

		case 14: return 15 >= _localctx._p;

		case 15: return 5 >= _localctx._p;
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
		"\2\3R\u01f9\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4"+
		"\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\3\2\7\2\37\n\2"+
		"\f\2\16\2\"\13\2\6\2$\n\2\r\2\16\2%\3\2\3\2\3\3\3\3\3\3\3\3\5\3.\n\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\39\n\3\3\3\3\3\3\3\3\3\5\3?\n\3\3"+
		"\3\3\3\3\3\5\3D\n\3\3\3\3\3\6\3H\n\3\r\3\16\3I\3\3\3\3\5\3N\n\3\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\7\4W\n\4\f\4\16\4Z\13\4\3\4\3\4\3\4\3\5\3\5\3\5"+
		"\3\5\3\5\3\6\3\6\3\6\3\6\3\6\5\6i\n\6\3\6\3\6\3\6\3\6\5\6o\n\6\7\6q\n"+
		"\6\f\6\16\6t\13\6\3\6\3\6\3\7\3\7\3\7\3\7\5\7|\n\7\3\7\3\7\5\7\u0080\n"+
		"\7\3\7\3\7\3\7\7\7\u0085\n\7\f\7\16\7\u0088\13\7\3\b\3\b\3\b\7\b\u008d"+
		"\n\b\f\b\16\b\u0090\13\b\3\t\3\t\3\t\3\t\3\t\3\t\7\t\u0098\n\t\f\t\16"+
		"\t\u009b\13\t\3\t\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\5\13\u00ac\n\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13"+
		"\u00b5\n\13\3\13\3\13\3\13\3\13\3\13\5\13\u00bc\n\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\5\13\u00c4\n\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u00cc"+
		"\n\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u00d4\n\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u00e1\n\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\5\13\u00ea\n\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u00f2"+
		"\n\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u00fb\n\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\5\13\u0103\n\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u010b"+
		"\n\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u0113\n\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\5\13\u011e\n\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\7\13\u012c\n\13\f\13\16\13\u012f\13\13"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\5\f\u0148\n\f\3\f\3\f\3\f\3\f\7\f\u014e\n\f\f\f"+
		"\16\f\u0151\13\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u015e"+
		"\n\f\3\f\3\f\3\f\3\f\3\f\5\f\u0165\n\f\3\f\3\f\3\f\3\f\3\f\5\f\u016c\n"+
		"\f\3\f\3\f\3\f\3\f\5\f\u0172\n\f\3\f\3\f\3\f\3\f\7\f\u0178\n\f\f\f\16"+
		"\f\u017b\13\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\6\f\u0186\n\f\r\f\16"+
		"\f\u0187\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5"+
		"\f\u0199\n\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\6\f\u01ce\n\f\r\f\16\f\u01cf\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u01d9"+
		"\n\f\3\f\3\f\3\f\3\f\3\f\5\f\u01e0\n\f\3\f\7\f\u01e3\n\f\f\f\16\f\u01e6"+
		"\13\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u01f4\n\r\3"+
		"\16\3\16\3\16\3\16\2\17\2\4\6\b\n\f\16\20\22\24\26\30\32\2\4\4::JJ\b\6"+
		"\6\17\17\27\27\33\33\'\';;\u024a\2#\3\2\2\2\4M\3\2\2\2\6O\3\2\2\2\b^\3"+
		"\2\2\2\nc\3\2\2\2\fw\3\2\2\2\16\u0089\3\2\2\2\20\u0091\3\2\2\2\22\u00a0"+
		"\3\2\2\2\24\u011d\3\2\2\2\26\u0198\3\2\2\2\30\u01f3\3\2\2\2\32\u01f5\3"+
		"\2\2\2\34 \5\4\3\2\35\37\7J\2\2\36\35\3\2\2\2\37\"\3\2\2\2 \36\3\2\2\2"+
		" !\3\2\2\2!$\3\2\2\2\" \3\2\2\2#\34\3\2\2\2$%\3\2\2\2%#\3\2\2\2%&\3\2"+
		"\2\2&\'\3\2\2\2\'(\b\2\1\2(\3\3\2\2\2)-\7\63\2\2*.\7\3\2\2+,\78\2\2,."+
		"\b\3\1\2-*\3\2\2\2-+\3\2\2\2./\3\2\2\2/\60\7)\2\2\60\61\7A\2\2\61\62\7"+
		"\20\2\2\62\63\5\f\7\2\63\64\b\3\1\2\648\7$\2\2\659\7\3\2\2\66\67\78\2"+
		"\2\679\b\3\1\28\65\3\2\2\28\66\3\2\2\29:\3\2\2\2:;\7\20\2\2;N\3\2\2\2"+
		"<>\7=\2\2=?\7J\2\2>=\3\2\2\2>?\3\2\2\2?G\3\2\2\2@D\5\6\4\2AD\5\b\5\2B"+
		"D\5\n\6\2C@\3\2\2\2CA\3\2\2\2CB\3\2\2\2DE\3\2\2\2EF\7J\2\2FH\3\2\2\2G"+
		"C\3\2\2\2HI\3\2\2\2IG\3\2\2\2IJ\3\2\2\2JK\3\2\2\2KL\7.\2\2LN\3\2\2\2M"+
		")\3\2\2\2M<\3\2\2\2N\5\3\2\2\2OP\7\b\2\2PQ\5\22\n\2QX\b\4\1\2RS\7(\2\2"+
		"ST\5\22\n\2TU\b\4\1\2UW\3\2\2\2VR\3\2\2\2WZ\3\2\2\2XV\3\2\2\2XY\3\2\2"+
		"\2Y[\3\2\2\2ZX\3\2\2\2[\\\7&\2\2\\]\b\4\1\2]\7\3\2\2\2^_\5\22\n\2_`\7"+
		"?\2\2`a\5\26\f\2ab\b\5\1\2b\t\3\2\2\2cd\5\22\n\2de\7!\2\2ef\5\22\n\2f"+
		"h\b\6\1\2gi\5\26\f\2hg\3\2\2\2hi\3\2\2\2ir\3\2\2\2jk\7#\2\2kl\5\22\n\2"+
		"ln\b\6\1\2mo\5\26\f\2nm\3\2\2\2no\3\2\2\2oq\3\2\2\2pj\3\2\2\2qt\3\2\2"+
		"\2rp\3\2\2\2rs\3\2\2\2su\3\2\2\2tr\3\2\2\2uv\b\6\1\2v\13\3\2\2\2w{\7J"+
		"\2\2xy\5\16\b\2yz\7J\2\2z|\3\2\2\2{x\3\2\2\2{|\3\2\2\2|\177\3\2\2\2}~"+
		"\7\36\2\2~\u0080\7J\2\2\177}\3\2\2\2\177\u0080\3\2\2\2\u0080\u0086\3\2"+
		"\2\2\u0081\u0082\5\24\13\2\u0082\u0083\7J\2\2\u0083\u0085\3\2\2\2\u0084"+
		"\u0081\3\2\2\2\u0085\u0088\3\2\2\2\u0086\u0084\3\2\2\2\u0086\u0087\3\2"+
		"\2\2\u0087\r\3\2\2\2\u0088\u0086\3\2\2\2\u0089\u008e\5\20\t\2\u008a\u008b"+
		"\t\2\2\2\u008b\u008d\5\20\t\2\u008c\u008a\3\2\2\2\u008d\u0090\3\2\2\2"+
		"\u008e\u008c\3\2\2\2\u008e\u008f\3\2\2\2\u008f\17\3\2\2\2\u0090\u008e"+
		"\3\2\2\2\u0091\u0092\5\22\n\2\u0092\u0099\b\t\1\2\u0093\u0094\7(\2\2\u0094"+
		"\u0095\5\22\n\2\u0095\u0096\b\t\1\2\u0096\u0098\3\2\2\2\u0097\u0093\3"+
		"\2\2\2\u0098\u009b\3\2\2\2\u0099\u0097\3\2\2\2\u0099\u009a\3\2\2\2\u009a"+
		"\u009c\3\2\2\2\u009b\u0099\3\2\2\2\u009c\u009d\7+\2\2\u009d\u009e\5\26"+
		"\f\2\u009e\u009f\b\t\1\2\u009f\21\3\2\2\2\u00a0\u00a1\7A\2\2\u00a1\23"+
		"\3\2\2\2\u00a2\u00a3\b\13\1\2\u00a3\u00a4\5\26\f\2\u00a4\u00a5\7/\2\2"+
		"\u00a5\u00a6\5\26\f\2\u00a6\u00a7\b\13\1\2\u00a7\u011e\3\2\2\2\u00a8\u00a9"+
		"\5\26\f\2\u00a9\u00ab\7\21\2\2\u00aa\u00ac\7I\2\2\u00ab\u00aa\3\2\2\2"+
		"\u00ab\u00ac\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00ae\5\26\f\2\u00ae\u00b5"+
		"\3\2\2\2\u00af\u00b0\7\4\2\2\u00b0\u00b1\5\26\f\2\u00b1\u00b2\7/\2\2\u00b2"+
		"\u00b3\5\26\f\2\u00b3\u00b5\3\2\2\2\u00b4\u00a8\3\2\2\2\u00b4\u00af\3"+
		"\2\2\2\u00b5\u00b6\3\2\2\2\u00b6\u00b7\b\13\1\2\u00b7\u011e\3\2\2\2\u00b8"+
		"\u00b9\5\26\f\2\u00b9\u00bb\7\t\2\2\u00ba\u00bc\7I\2\2\u00bb\u00ba\3\2"+
		"\2\2\u00bb\u00bc\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd\u00be\5\26\f\2\u00be"+
		"\u00bf\b\13\1\2\u00bf\u011e\3\2\2\2\u00c0\u00c1\5\26\f\2\u00c1\u00c3\7"+
		"<\2\2\u00c2\u00c4\7I\2\2\u00c3\u00c2\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4"+
		"\u00c5\3\2\2\2\u00c5\u00c6\5\26\f\2\u00c6\u00c7\b\13\1\2\u00c7\u011e\3"+
		"\2\2\2\u00c8\u00c9\5\26\f\2\u00c9\u00cb\7\31\2\2\u00ca\u00cc\7I\2\2\u00cb"+
		"\u00ca\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cd\u00ce\5\26"+
		"\f\2\u00ce\u00cf\b\13\1\2\u00cf\u011e\3\2\2\2\u00d0\u00d1\5\26\f\2\u00d1"+
		"\u00d3\7\37\2\2\u00d2\u00d4\7I\2\2\u00d3\u00d2\3\2\2\2\u00d3\u00d4\3\2"+
		"\2\2\u00d4\u00d5\3\2\2\2\u00d5\u00d6\5\26\f\2\u00d6\u00d7\b\13\1\2\u00d7"+
		"\u011e\3\2\2\2\u00d8\u00d9\5\26\f\2\u00d9\u00da\7\30\2\2\u00da\u00db\5"+
		"\26\f\2\u00db\u00dc\b\13\1\2\u00dc\u011e\3\2\2\2\u00dd\u00de\5\26\f\2"+
		"\u00de\u00e0\7\"\2\2\u00df\u00e1\7I\2\2\u00e0\u00df\3\2\2\2\u00e0\u00e1"+
		"\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2\u00e3\5\26\f\2\u00e3\u00e4\b\13\1\2"+
		"\u00e4\u011e\3\2\2\2\u00e5\u00e6\7\4\2\2\u00e6\u00e7\5\26\f\2\u00e7\u00e9"+
		"\7\"\2\2\u00e8\u00ea\7I\2\2\u00e9\u00e8\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea"+
		"\u00eb\3\2\2\2\u00eb\u00ec\5\26\f\2\u00ec\u00ed\b\13\1\2\u00ed\u011e\3"+
		"\2\2\2\u00ee\u00ef\5\26\f\2\u00ef\u00f1\7\64\2\2\u00f0\u00f2\7I\2\2\u00f1"+
		"\u00f0\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2\u00f3\3\2\2\2\u00f3\u00f4\5\26"+
		"\f\2\u00f4\u00f5\b\13\1\2\u00f5\u011e\3\2\2\2\u00f6\u00f7\7\4\2\2\u00f7"+
		"\u00f8\5\26\f\2\u00f8\u00fa\7\64\2\2\u00f9\u00fb\7I\2\2\u00fa\u00f9\3"+
		"\2\2\2\u00fa\u00fb\3\2\2\2\u00fb\u00fc\3\2\2\2\u00fc\u00fd\5\26\f\2\u00fd"+
		"\u00fe\b\13\1\2\u00fe\u011e\3\2\2\2\u00ff\u0100\5\26\f\2\u0100\u0102\7"+
		"\35\2\2\u0101\u0103\7I\2\2\u0102\u0101\3\2\2\2\u0102\u0103\3\2\2\2\u0103"+
		"\u0104\3\2\2\2\u0104\u0105\5\26\f\2\u0105\u0106\b\13\1\2\u0106\u011e\3"+
		"\2\2\2\u0107\u0108\5\26\f\2\u0108\u010a\7\32\2\2\u0109\u010b\7I\2\2\u010a"+
		"\u0109\3\2\2\2\u010a\u010b\3\2\2\2\u010b\u010c\3\2\2\2\u010c\u010d\5\26"+
		"\f\2\u010d\u010e\b\13\1\2\u010e\u011e\3\2\2\2\u010f\u0110\5\26\f\2\u0110"+
		"\u0112\7%\2\2\u0111\u0113\7I\2\2\u0112\u0111\3\2\2\2\u0112\u0113\3\2\2"+
		"\2\u0113\u0114\3\2\2\2\u0114\u0115\5\26\f\2\u0115\u0116\b\13\1\2\u0116"+
		"\u011e\3\2\2\2\u0117\u0118\7*\2\2\u0118\u0119\5\24\13\2\u0119\u011a\7"+
		"\24\2\2\u011a\u011e\3\2\2\2\u011b\u011e\7\62\2\2\u011c\u011e\7\n\2\2\u011d"+
		"\u00a2\3\2\2\2\u011d\u00b4\3\2\2\2\u011d\u00b8\3\2\2\2\u011d\u00c0\3\2"+
		"\2\2\u011d\u00c8\3\2\2\2\u011d\u00d0\3\2\2\2\u011d\u00d8\3\2\2\2\u011d"+
		"\u00dd\3\2\2\2\u011d\u00e5\3\2\2\2\u011d\u00ee\3\2\2\2\u011d\u00f6\3\2"+
		"\2\2\u011d\u00ff\3\2\2\2\u011d\u0107\3\2\2\2\u011d\u010f\3\2\2\2\u011d"+
		"\u0117\3\2\2\2\u011d\u011b\3\2\2\2\u011d\u011c\3\2\2\2\u011e\u012d\3\2"+
		"\2\2\u011f\u0120\6\13\2\3\u0120\u0121\7\67\2\2\u0121\u012c\5\24\13\2\u0122"+
		"\u0123\6\13\3\3\u0123\u0124\79\2\2\u0124\u012c\5\24\13\2\u0125\u0126\6"+
		"\13\4\3\u0126\u0127\7,\2\2\u0127\u012c\5\24\13\2\u0128\u0129\6\13\5\3"+
		"\u0129\u012a\7\23\2\2\u012a\u012c\5\24\13\2\u012b\u011f\3\2\2\2\u012b"+
		"\u0122\3\2\2\2\u012b\u0125\3\2\2\2\u012b\u0128\3\2\2\2\u012c\u012f\3\2"+
		"\2\2\u012d\u012b\3\2\2\2\u012d\u012e\3\2\2\2\u012e\25\3\2\2\2\u012f\u012d"+
		"\3\2\2\2\u0130\u0131\b\f\1\2\u0131\u0132\5\32\16\2\u0132\u0133\5\26\f"+
		"\2\u0133\u0134\b\f\1\2\u0134\u0199\3\2\2\2\u0135\u0136\7\65\2\2\u0136"+
		"\u0137\5\26\f\2\u0137\u0138\b\f\1\2\u0138\u0199\3\2\2\2\u0139\u013a\5"+
		"\30\r\2\u013a\u013b\5\26\f\2\u013b\u013c\b\f\1\2\u013c\u0199\3\2\2\2\u013d"+
		"\u013e\7A\2\2\u013e\u0199\b\f\1\2\u013f\u0140\7B\2\2\u0140\u0199\b\f\1"+
		"\2\u0141\u0142\7\r\2\2\u0142\u0199\b\f\1\2\u0143\u0147\7L\2\2\u0144\u0145"+
		"\5\26\f\2\u0145\u0146\b\f\1\2\u0146\u0148\3\2\2\2\u0147\u0144\3\2\2\2"+
		"\u0147\u0148\3\2\2\2\u0148\u014f\3\2\2\2\u0149\u014a\7(\2\2\u014a\u014b"+
		"\5\26\f\2\u014b\u014c\b\f\1\2\u014c\u014e\3\2\2\2\u014d\u0149\3\2\2\2"+
		"\u014e\u0151\3\2\2\2\u014f\u014d\3\2\2\2\u014f\u0150\3\2\2\2\u0150\u0152"+
		"\3\2\2\2\u0151\u014f\3\2\2\2\u0152\u0153\7M\2\2\u0153\u0199\b\f\1\2\u0154"+
		"\u0155\7L\2\2\u0155\u0156\b\f\1\2\u0156\u0157\5\16\b\2\u0157\u015d\b\f"+
		"\1\2\u0158\u0159\7#\2\2\u0159\u015a\b\f\1\2\u015a\u015b\5\24\13\2\u015b"+
		"\u015c\b\f\1\2\u015c\u015e\3\2\2\2\u015d\u0158\3\2\2\2\u015d\u015e\3\2"+
		"\2\2\u015e\u0164\3\2\2\2\u015f\u0160\7\25\2\2\u0160\u0161\b\f\1\2\u0161"+
		"\u0162\5\26\f\2\u0162\u0163\b\f\1\2\u0163\u0165\3\2\2\2\u0164\u015f\3"+
		"\2\2\2\u0164\u0165\3\2\2\2\u0165\u0166\3\2\2\2\u0166\u0167\7M\2\2\u0167"+
		"\u0168\b\f\1\2\u0168\u0169\b\f\1\2\u0169\u0199\3\2\2\2\u016a\u016c\7I"+
		"\2\2\u016b\u016a\3\2\2\2\u016b\u016c\3\2\2\2\u016c\u016d\3\2\2\2\u016d"+
		"\u0171\7N\2\2\u016e\u016f\5\26\f\2\u016f\u0170\b\f\1\2\u0170\u0172\3\2"+
		"\2\2\u0171\u016e\3\2\2\2\u0171\u0172\3\2\2\2\u0172\u0179\3\2\2\2\u0173"+
		"\u0174\7(\2\2\u0174\u0175\5\26\f\2\u0175\u0176\b\f\1\2\u0176\u0178\3\2"+
		"\2\2\u0177\u0173\3\2\2\2\u0178\u017b\3\2\2\2\u0179\u0177\3\2\2\2\u0179"+
		"\u017a\3\2\2\2\u017a\u017c\3\2\2\2\u017b\u0179\3\2\2\2\u017c\u017d\7O"+
		"\2\2\u017d\u0199\b\f\1\2\u017e\u017f\7*\2\2\u017f\u0180\5\26\f\2\u0180"+
		"\u0185\b\f\1\2\u0181\u0182\7(\2\2\u0182\u0183\5\26\f\2\u0183\u0184\b\f"+
		"\1\2\u0184\u0186\3\2\2\2\u0185\u0181\3\2\2\2\u0186\u0187\3\2\2\2\u0187"+
		"\u0185\3\2\2\2\u0187\u0188\3\2\2\2\u0188\u0189\3\2\2\2\u0189\u018a\7\24"+
		"\2\2\u018a\u018b\b\f\1\2\u018b\u0199\3\2\2\2\u018c\u018d\7*\2\2\u018d"+
		"\u018e\5\26\f\2\u018e\u018f\7\24\2\2\u018f\u0190\b\f\1\2\u0190\u0199\3"+
		"\2\2\2\u0191\u0192\7\34\2\2\u0192\u0193\7\13\2\2\u0193\u0199\b\f\1\2\u0194"+
		"\u0195\7\34\2\2\u0195\u0199\b\f\1\2\u0196\u0197\7>\2\2\u0197\u0199\b\f"+
		"\1\2\u0198\u0130\3\2\2\2\u0198\u0135\3\2\2\2\u0198\u0139\3\2\2\2\u0198"+
		"\u013d\3\2\2\2\u0198\u013f\3\2\2\2\u0198\u0141\3\2\2\2\u0198\u0143\3\2"+
		"\2\2\u0198\u0154\3\2\2\2\u0198\u016b\3\2\2\2\u0198\u017e\3\2\2\2\u0198"+
		"\u018c\3\2\2\2\u0198\u0191\3\2\2\2\u0198\u0194\3\2\2\2\u0198\u0196\3\2"+
		"\2\2\u0199\u01e4\3\2\2\2\u019a\u019b\6\f\6\3\u019b\u019c\7H\2\2\u019c"+
		"\u019d\5\26\f\2\u019d\u019e\b\f\1\2\u019e\u01e3\3\2\2\2\u019f\u01a0\6"+
		"\f\7\3\u01a0\u01a1\7F\2\2\u01a1\u01a2\5\26\f\2\u01a2\u01a3\b\f\1\2\u01a3"+
		"\u01e3\3\2\2\2\u01a4\u01a5\6\f\b\3\u01a5\u01a6\7E\2\2\u01a6\u01a7\5\26"+
		"\f\2\u01a7\u01a8\b\f\1\2\u01a8\u01e3\3\2\2\2\u01a9\u01aa\6\f\t\3\u01aa"+
		"\u01ab\7D\2\2\u01ab\u01ac\5\26\f\2\u01ac\u01ad\b\f\1\2\u01ad\u01e3\3\2"+
		"\2\2\u01ae\u01af\6\f\n\3\u01af\u01b0\7C\2\2\u01b0\u01b1\5\26\f\2\u01b1"+
		"\u01b2\b\f\1\2\u01b2\u01e3\3\2\2\2\u01b3\u01b4\6\f\13\3\u01b4\u01b5\7"+
		"\16\2\2\u01b5\u01b6\5\26\f\2\u01b6\u01b7\b\f\1\2\u01b7\u01e3\3\2\2\2\u01b8"+
		"\u01b9\6\f\f\3\u01b9\u01ba\7@\2\2\u01ba\u01bb\5\26\f\2\u01bb\u01bc\b\f"+
		"\1\2\u01bc\u01e3\3\2\2\2\u01bd\u01be\6\f\r\3\u01be\u01bf\7I\2\2\u01bf"+
		"\u01c0\5\26\f\2\u01c0\u01c1\b\f\1\2\u01c1\u01e3\3\2\2\2\u01c2\u01c3\6"+
		"\f\16\3\u01c3\u01c4\7\66\2\2\u01c4\u01c5\5\26\f\2\u01c5\u01c6\b\f\1\2"+
		"\u01c6\u01e3\3\2\2\2\u01c7\u01c8\6\f\17\3\u01c8\u01cd\b\f\1\2\u01c9\u01ca"+
		"\7\61\2\2\u01ca\u01cb\5\26\f\2\u01cb\u01cc\b\f\1\2\u01cc\u01ce\3\2\2\2"+
		"\u01cd\u01c9\3\2\2\2\u01ce\u01cf\3\2\2\2\u01cf\u01cd\3\2\2\2\u01cf\u01d0"+
		"\3\2\2\2\u01d0\u01d1\3\2\2\2\u01d1\u01d2\b\f\1\2\u01d2\u01e3\3\2\2\2\u01d3"+
		"\u01d4\6\f\20\3\u01d4\u01d5\7P\2\2\u01d5\u01d6\5\26\f\2\u01d6\u01d8\7"+
		"Q\2\2\u01d7\u01d9\7I\2\2\u01d8\u01d7\3\2\2\2\u01d8\u01d9\3\2\2\2\u01d9"+
		"\u01da\3\2\2\2\u01da\u01db\b\f\1\2\u01db\u01e3\3\2\2\2\u01dc\u01dd\6\f"+
		"\21\3\u01dd\u01df\7G\2\2\u01de\u01e0\7I\2\2\u01df\u01de\3\2\2\2\u01df"+
		"\u01e0\3\2\2\2\u01e0\u01e1\3\2\2\2\u01e1\u01e3\b\f\1\2\u01e2\u019a\3\2"+
		"\2\2\u01e2\u019f\3\2\2\2\u01e2\u01a4\3\2\2\2\u01e2\u01a9\3\2\2\2\u01e2"+
		"\u01ae\3\2\2\2\u01e2\u01b3\3\2\2\2\u01e2\u01b8\3\2\2\2\u01e2\u01bd\3\2"+
		"\2\2\u01e2\u01c2\3\2\2\2\u01e2\u01c7\3\2\2\2\u01e2\u01d3\3\2\2\2\u01e2"+
		"\u01dc\3\2\2\2\u01e3\u01e6\3\2\2\2\u01e4\u01e2\3\2\2\2\u01e4\u01e5\3\2"+
		"\2\2\u01e5\27\3\2\2\2\u01e6\u01e4\3\2\2\2\u01e7\u01f4\7-\2\2\u01e8\u01f4"+
		"\7\f\2\2\u01e9\u01ea\7\60\2\2\u01ea\u01f4\7I\2\2\u01eb\u01f4\7\26\2\2"+
		"\u01ec\u01f4\7\5\2\2\u01ed\u01f4\7 \2\2\u01ee\u01f4\7 \2\2\u01ef\u01f0"+
		"\7\22\2\2\u01f0\u01f4\7I\2\2\u01f1\u01f2\7\7\2\2\u01f2\u01f4\7I\2\2\u01f3"+
		"\u01e7\3\2\2\2\u01f3\u01e8\3\2\2\2\u01f3\u01e9\3\2\2\2\u01f3\u01eb\3\2"+
		"\2\2\u01f3\u01ec\3\2\2\2\u01f3\u01ed\3\2\2\2\u01f3\u01ee\3\2\2\2\u01f3"+
		"\u01ef\3\2\2\2\u01f3\u01f1\3\2\2\2\u01f4\31\3\2\2\2\u01f5\u01f6\t\3\2"+
		"\2\u01f6\u01f7\7I\2\2\u01f7\33\3\2\2\2\62 %-8>CIMXhnr{\177\u0086\u008e"+
		"\u0099\u00ab\u00b4\u00bb\u00c3\u00cb\u00d3\u00e0\u00e9\u00f1\u00fa\u0102"+
		"\u010a\u0112\u011d\u012b\u012d\u0147\u014f\u015d\u0164\u016b\u0171\u0179"+
		"\u0187\u0198\u01cf\u01d8\u01df\u01e2\u01e4\u01f3";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}