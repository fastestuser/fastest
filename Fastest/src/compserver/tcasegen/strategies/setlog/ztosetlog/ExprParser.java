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
	import java.util.List;
	

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
		T__2=60, T__1=61, T__0=62, CROSS=63, POWER=64, IN_FUN_65=65, IN_FUN_60=66, 
		IN_FUN_50=67, IN_FUN_45=68, IN_FUN_40=69, IN_FUN_30=70, IN_FUN_20=71, 
		IN_FUN_10=72, IN_FUN_5=73, SELECTION=74, NAME=75, NUM=76, NL=77, WS=78, 
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
		"'front'", "'>'", "'\\negate'", "'\\begin{zed}'", "'\\num'", "'=='", "'\\cross'", 
		"POWER", "IN_FUN_65", "IN_FUN_60", "IN_FUN_50", "IN_FUN_45", "IN_FUN_40", 
		"IN_FUN_30", "IN_FUN_20", "IN_FUN_10", "IN_FUN_5", "'.'", "NAME", "NUM", 
		"NL", "WS", "'\\{'", "'\\}'", "'\\langle'", "'\\rangle'", "'\\limg'", 
		"'\\rimg'", "SKIP"
	};
	public static final int
		RULE_specification = 0, RULE_paragraph = 1, RULE_basic_type = 2, RULE_equivalent_type = 3, 
		RULE_enumeration_type = 4, RULE_schemaText = 5, RULE_schemaTypeText = 6, 
		RULE_declPart = 7, RULE_declaration = 8, RULE_declName = 9, RULE_predicate = 10, 
		RULE_expression = 11, RULE_endExpression = 12, RULE_refName = 13, RULE_post = 14, 
		RULE_pre = 15;
	public static final String[] ruleNames = {
		"specification", "paragraph", "basic_type", "equivalent_type", "enumeration_type", 
		"schemaText", "schemaTypeText", "declPart", "declaration", "declName", 
		"predicate", "expression", "endExpression", "refName", "post", "pre"
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
		int modoSetExpression = 0; //indica en que etapa del conjuntos por comprension estamos trabajando
		int tipoSchema = 0;        //0 = false, 1 = true, indica si estamos trabajando con tipos esquema
		
		HashMap<String,String> schemaTypeVars;

		HashMap<String,String> setExpressionVars;
		HashMap<String,String> memory = new HashMap<String,String>(); //En memory se guardan las variables y expressiones leidas
		HashMap<String,String> types = new HashMap<String,String>();  //En types se guarda informacion sobre los tipos definidos
		HashMap<String,String> zVars = new HashMap<String,String>();  //En zVars se almacenan las variables Z, a las cuales luego (antes de generar
		                                                              //el caso de prueba) se les dara un valor.
		
		String out = new String();
		String functionsOut = new String();
		
		public void setBasicAxDef(HashMap<String, List<String>> basicAxDef){
			Iterator<String> itmap = basicAxDef.keySet().iterator();
			Iterator<String> itlist = basicAxDef.keySet().iterator();
			String key,cte;
			List<String> value ;
			while (itmap.hasNext()) {  
				key = itmap.next().toString();
				value =  basicAxDef.get(key);
				if (value == null)
					cte = "nullc";
				else{ 
					itlist = value.iterator();
					while(itlist.hasNext()){
						cte = itlist.next().toString();
						memory.put(cte,cte);
						types.put(cte,"BasicConstant:" + key);
					}
				}
			} 
		}
		
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

		//Metodo para imprimir normalmente una linea de setlog
		public void print(String c) {
			if (modoSetExpression == 0 && tipoSchema == 0) { 
				//System.out.println(c + " & ");
				out = out.concat(c + " & ");
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
				functionsOut = functionsOut.concat(c + " & ");
			else if (modoSetExpression == 1)
				setExpressionDecl = setExpressionDecl.concat(" & " + c);
			else if (modoSetExpression == 2)
				setExpressionPred = setExpressionPred.concat(" & " + c);
			else if (modoSetExpression == 3)
				setExpressionExpr = setExpressionExpr.concat(" & " + c);
		}
		
		//Metodo para la determinacion del typo mas externo de un tipo.
		//Ej:  type = A \cross B ----> return \cross
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
		
		//Metodo para quitar los parentesis exteriores en expresiones de tipo.
		String removeParenthesis(String type) {
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
	        
	        return parser.printTree(root);
		}
		
		//Metodo para la determinacion del tipo de un hijo de una expresion.
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
		
		//Metodo para realizar la inversion de un tipo en Z.
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
		
		//Metodo para obtener los tipos de los hijos.
		//EJ: A \pfun B devuelve A y B
		ArrayList<String> childsTypes(String type) {
			ANTLRInputStream input = new ANTLRInputStream(type);
	        TypeManagerLexer lexer = new TypeManagerLexer(input);
	        CommonTokenStream tokens = new CommonTokenStream(lexer);
	        TypeManagerParser parser = new TypeManagerParser(tokens);
	        parser.typeManage();
	        DefaultMutableTreeNode root = parser.getRoot();
	        
			ArrayList<String> childsTypes = new ArrayList<String>();
			DefaultMutableTreeNode aux;
			String rootType = (String) root.getUserObject();
			
			while (rootType.equals("()")) {
					root = (DefaultMutableTreeNode) root.getChildAt(0);
					rootType = (String) root.getUserObject();
			}
			
			if (rootType.equals("\\power")) {
				DefaultMutableTreeNode child = (DefaultMutableTreeNode) root.getChildAt(0);
				String childType = (String) child.getUserObject();
				
				while (childType.equals("()")) {
					child = (DefaultMutableTreeNode) child.getChildAt(0);
					childType = (String) child.getUserObject();
				}
				
				if (childType.equals("\\cross")) { //Cambiar para multiples cross
					int childsAmount = child.getChildCount();
					for (int i = 0; i < childsAmount; i++) {
						aux = (DefaultMutableTreeNode) child.getChildAt(i);
						while (((String) aux.getUserObject()).equals("()"))
							aux = (DefaultMutableTreeNode) aux.getChildAt(0);
						childsTypes.add(parser.printTree(aux));
					}
				}
			
			}
			else if (isSequence(rootType)) { //Entonces empieza con pfun, rel etc

				childsTypes.add("\\nat");
				aux = (DefaultMutableTreeNode) root.getChildAt(0);
				while (((String) aux.getUserObject()).equals("()"))
					aux = (DefaultMutableTreeNode) aux.getChildAt(0);
				childsTypes.add(parser.printTree(aux));

			}
			else if (rootType.equals("\\cross")) {
			
				int childsAmount = root.getChildCount();
				for (int i = 0; i < childsAmount; i++) {
					aux = (DefaultMutableTreeNode) root.getChildAt(i);
					while (((String) aux.getUserObject()).equals("()"))
						aux = (DefaultMutableTreeNode) aux.getChildAt(0);
					childsTypes.add(parser.printTree(aux));
				}
			}
			
			else { //Entonces empieza con pfun, rel etc

			aux = (DefaultMutableTreeNode) root.getChildAt(0);
			while (((String) aux.getUserObject()).equals("()"))
				aux = (DefaultMutableTreeNode) aux.getChildAt(0);
			childsTypes.add(parser.printTree(aux));
			
			aux = (DefaultMutableTreeNode) root.getChildAt(1);
			while (((String) aux.getUserObject()).equals("()"))
				aux = (DefaultMutableTreeNode) aux.getChildAt(0);
				
			childsTypes.add(parser.printTree(aux));
			}
			
			return childsTypes;
		}
		
		private String newVar() {
			String newVarName = "VAR" + varNumber;
			varNumber++;
			return newVarName;
		}
		
		private String newVar(String zName) {
			String newVarName = zName.substring(0,1).toUpperCase() + zName.substring(1).replace("?","");
			if (memory.containsValue(newVarName)) { 
				newVarName = "VAR" + varNumber;
				varNumber++;
			}
			return newVarName;
		}
		
		private String typeInfo(String var, String type) {
			return typeInfo(var, type, "");
		}
		
		//Funcion para imprimir la informacion de tipo de una variable.
		private String typeInfo(String var, String type, String exp) {
				
			if (type != null) {
				if (isBasic(type)) {
					if(type.startsWith("EnumerationType")) {
						type = type.split(":")[1];
						if (tipoSchema == 0) print(var + " in " + type);
					} else
						type = type.split(":")[1];
					return getKey(type, memory);
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
				    //Calculamos el dominio de la variable
				    String zDomType = getChildType(type,0);
				    String domType = generateSetlogFiniteType(zDomType);
				    String zVar = getKey(var, memory);
				    String dom = memory.get("\\dom" + zVar);
				    if (dom == null && zVar != null){
						dom = newVar();
						memory.put("\\dom" + zVar, dom);
						types.put("\\dom" + zVar, "\\power(" + zDomType + ")");
				    	print("dom(" + var + "," + dom + ")");
					}
					print(dom + " = " + domType);
					if (tipoSchema == 0) printAtEnd("is_pfun(" + var + ")");
				}
				else if (type.equals("\\nat") || type.equals("\\num") || type.equals("\\nat_{1}")) {
					if (tipoSchema == 0) {
						print(var + " ein " + printInfo(type, true));
					}
				}
				else if (nodeType.equals("\\power")) {
					//Veo si lo que sigue es un tipo enumerado
					String childType = getChildType(type,0);
					childType = types.get(childType);
					if (childType != null) {
						if (childType.startsWith("EnumerationType")){
							if (tipoSchema == 0) print("subset(" + var + "," + childType.split(":")[1] + ")");
						} else
							if ((tipoSchema == 0) && (exp != null) && (!exp.contains("\\power")))
							//Si no contiene power, imprimimos, ya que si lo contiene, es realmente una expresion de tipo y no una expresion con valor!
								 print(var + " in " + exp);
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
						return getKey(type, memory);
					}
				}
			}
			return type;
		}
		
		private String generateSetlogFiniteType(String type) {
		
			if (isBasic(types.get(type)))
				return type;
			
			if (isNumeric(types.get(type))) {
				printInfo(type, true);
				return memory.get(type);
			}
			
			String mType = memory.get("\\power(" + type + ")");
			if (mType != null) {
				return mType;
			}
			
			String nodeType = getType(type);
			if (nodeType.equals("\\power")) {
				String newVarName = newVar();
				String zChild = getChildType(type,0);
				String child = generateSetlogFiniteType(zChild);
				print("powerset(" + child + "," + newVarName + ")");
				memory.put("\\power(" + type + ")", newVarName);
				if (types.get("\\power(" + type + ")") == null)
					types.put("\\power(" + type + ")", "\\power(" + type + ")");
				types.put(newVarName, "\\power(" + type + ")");
				return newVarName;		
			} else if (nodeType.equals("\\cross")) {
				String newVarName = newVar();
				String zChild1 = getChildType(type,0);
				String zChild2 = getChildType(type,1);
				String child1 = generateSetlogFiniteType(zChild1);
				String child2 = generateSetlogFiniteType(zChild2);
				print("cross_product(" + child1 + "," + child2 + "," + newVarName + ")");
				memory.put("\\power(" + type + ")", newVarName);
				if (types.get("\\power(" + type + ")") == null)
					types.put("\\power(" + type + ")", "\\power(" + type + ")");
				types.put(newVarName, "\\power(" + type + ")");
				return newVarName;		
			}
			
			return "";
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
					print(translation + " = int(-2147483648, 2147483647)");
				else if (type.equals("\\nat"))
					print(translation + " = int(0, 2147483647)");
				else if (type.equals("\\nat_{1}"))
					print(translation + " = int(1, 2147483647)");
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
						setExpressionVars.put("list_to_rel(" + zVar + ")", newVarName);				
					//Hace falta ver el tipo?
					String seqType = childsTypes(type).get(1);
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
			setState(39); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(32); paragraph();
				setState(36);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(33); match(NL);
					}
					}
					setState(38);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(41); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==50 || _la==60 );
			/*
				   System.out.println("Tabla Types");
				   System.out.println("-------------------");
				   String key, value;
				   Iterator<String> iterator = types.keySet().iterator();
				   while (iterator.hasNext()) {
				           key = iterator.next();
				           value = types.get(key);
				           System.out.println(key + "\t\t| " + value);
				   }
				   System.out.println("\nTabla Memory");
				   System.out.println("-------------------");
				   iterator = memory.keySet().iterator();
				   while (iterator.hasNext()) {
				           key = iterator.next();
				           value = memory.get(key);
				           System.out.println(key + "\t\t| " + value);
				   }
				   System.out.println("\nTabla zVars");
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
		public SchemaTypeTextContext schemaTypeText() {
			return getRuleContext(SchemaTypeTextContext.class,0);
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
			setState(88);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(45); match(50);
				setState(46); match(1);
				setState(47); match(39);
				setState(48); match(NAME);
				setState(49); match(14);
				setState(50); schemaText();
				setState(51); match(34);
				setState(52); match(1);
				setState(53); match(14);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(55); match(50);
				setState(56); match(54);
				tipoSchema = 1; schemaTypeVars = new HashMap<String,String>();
				setState(58); match(39);
				setState(59); ((ParagraphContext)_localctx).NAME = match(NAME);
				setState(60); match(14);
				setState(61); schemaTypeText();

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
						
				setState(63); match(34);
				setState(67);
				switch (_input.LA(1)) {
				case 1:
					{
					setState(64); match(1);
					}
					break;
				case 54:
					{
					{
					setState(65); match(54);
					tipoSchema = 0;
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(69); match(14);
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(71); match(60);
				setState(73);
				_la = _input.LA(1);
				if (_la==NL) {
					{
					setState(72); match(NL);
					}
				}

				setState(82); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(78);
					switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
					case 1:
						{
						setState(75); basic_type();
						}
						break;

					case 2:
						{
						setState(76); equivalent_type();
						}
						break;

					case 3:
						{
						setState(77); enumeration_type();
						}
						break;
					}
					setState(80); match(NL);
					}
					}
					setState(84); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==6 || _la==NAME );
				setState(86); match(44);
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
			setState(90); match(6);
			setState(91); ((Basic_typeContext)_localctx).a = ((Basic_typeContext)_localctx).declName = declName();
			((Basic_typeContext)getInvokingContext(2)).typeList.add((((Basic_typeContext)_localctx).a!=null?_input.getText(((Basic_typeContext)_localctx).a.start,((Basic_typeContext)_localctx).a.stop):null));
			setState(99);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==38) {
				{
				{
				setState(93); match(38);
				setState(94); ((Basic_typeContext)_localctx).b = ((Basic_typeContext)_localctx).declName = declName();
				((Basic_typeContext)getInvokingContext(2)).typeList.add((((Basic_typeContext)_localctx).b!=null?_input.getText(((Basic_typeContext)_localctx).b.start,((Basic_typeContext)_localctx).b.stop):null));
				}
				}
				setState(101);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(102); match(36);

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
			setState(105); ((Equivalent_typeContext)_localctx).declName = declName();
			setState(106); match(62);
			setState(107); ((Equivalent_typeContext)_localctx).expression = expression(0);
			 
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
			setState(110); ((Enumeration_typeContext)_localctx).d = declName();
			setState(111); match(31);
			setState(112); ((Enumeration_typeContext)_localctx).a = declName();
			((Enumeration_typeContext)getInvokingContext(4)).cases.add((((Enumeration_typeContext)_localctx).a!=null?_input.getText(((Enumeration_typeContext)_localctx).a.start,((Enumeration_typeContext)_localctx).a.stop):null));
			setState(115);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 3) | (1L << 4) | (1L << 5) | (1L << 10) | (1L << 11) | (1L << 12) | (1L << 13) | (1L << 16) | (1L << 20) | (1L << 21) | (1L << 25) | (1L << 26) | (1L << 30) | (1L << 37) | (1L << 40) | (1L << 43) | (1L << 46) | (1L << 51) | (1L << 57) | (1L << 59) | (1L << 61))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (POWER - 64)) | (1L << (NAME - 64)) | (1L << (NUM - 64)) | (1L << (SETSTART - 64)) | (1L << (LISTSTART - 64)))) != 0)) {
				{
				setState(114); expression(0);
				}
			}

			setState(125);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==33) {
				{
				{
				setState(117); match(33);
				setState(118); ((Enumeration_typeContext)_localctx).b = declName();
				((Enumeration_typeContext)getInvokingContext(4)).cases.add((((Enumeration_typeContext)_localctx).b!=null?_input.getText(((Enumeration_typeContext)_localctx).b.start,((Enumeration_typeContext)_localctx).b.stop):null));
				setState(121);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 3) | (1L << 4) | (1L << 5) | (1L << 10) | (1L << 11) | (1L << 12) | (1L << 13) | (1L << 16) | (1L << 20) | (1L << 21) | (1L << 25) | (1L << 26) | (1L << 30) | (1L << 37) | (1L << 40) | (1L << 43) | (1L << 46) | (1L << 51) | (1L << 57) | (1L << 59) | (1L << 61))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (POWER - 64)) | (1L << (NAME - 64)) | (1L << (NUM - 64)) | (1L << (SETSTART - 64)) | (1L << (LISTSTART - 64)))) != 0)) {
					{
					setState(120); expression(0);
					}
				}

				}
				}
				setState(127);
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
			setState(130); match(NL);
			setState(134);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(131); declPart();
				setState(132); match(NL);
				}
				break;
			}
			setState(138);
			_la = _input.LA(1);
			if (_la==28) {
				{
				setState(136); match(28);
				setState(137); match(NL);
				}
			}

			setState(145);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 2) | (1L << 3) | (1L << 4) | (1L << 5) | (1L << 8) | (1L << 10) | (1L << 11) | (1L << 12) | (1L << 13) | (1L << 16) | (1L << 20) | (1L << 21) | (1L << 25) | (1L << 26) | (1L << 30) | (1L << 37) | (1L << 40) | (1L << 43) | (1L << 46) | (1L << 49) | (1L << 51) | (1L << 57) | (1L << 59) | (1L << 61))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (POWER - 64)) | (1L << (NAME - 64)) | (1L << (NUM - 64)) | (1L << (SETSTART - 64)) | (1L << (LISTSTART - 64)))) != 0)) {
				{
				{
				setState(140); predicate(0);
				setState(141); match(NL);
				}
				}
				setState(147);
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

	public static class SchemaTypeTextContext extends ParserRuleContext {
		public List<TerminalNode> NL() { return getTokens(ExprParser.NL); }
		public DeclPartContext declPart() {
			return getRuleContext(DeclPartContext.class,0);
		}
		public TerminalNode NL(int i) {
			return getToken(ExprParser.NL, i);
		}
		public SchemaTypeTextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_schemaTypeText; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterSchemaTypeText(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitSchemaTypeText(this);
		}
	}

	public final SchemaTypeTextContext schemaTypeText() throws RecognitionException {
		SchemaTypeTextContext _localctx = new SchemaTypeTextContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_schemaTypeText);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(148); match(NL);
			setState(152);
			_la = _input.LA(1);
			if (_la==NAME) {
				{
				setState(149); declPart();
				setState(150); match(NL);
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
		enterRule(_localctx, 14, RULE_declPart);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(154); declaration();
			setState(159);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(155);
					_la = _input.LA(1);
					if ( !(_la==56 || _la==NL) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					setState(156); declaration();
					}
					} 
				}
				setState(161);
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
		enterRule(_localctx, 16, RULE_declaration);
		((DeclarationContext)getInvokingContext(8)).vars =  new ArrayList<String>();
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162); ((DeclarationContext)_localctx).a = declName();
			((DeclarationContext)getInvokingContext(8)).vars.add((((DeclarationContext)_localctx).a!=null?_input.getText(((DeclarationContext)_localctx).a.start,((DeclarationContext)_localctx).a.stop):null));
			setState(170);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==38) {
				{
				{
				setState(164); match(38);
				setState(165); ((DeclarationContext)_localctx).b = declName();
				((DeclarationContext)getInvokingContext(8)).vars.add((((DeclarationContext)_localctx).b!=null?_input.getText(((DeclarationContext)_localctx).b.start,((DeclarationContext)_localctx).b.stop):null));
				}
				}
				setState(172);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(173); match(41);
			setState(174); ((DeclarationContext)_localctx).expression = expression(0);

					//Para cada variable realizamos el procesamiento
					while( !((DeclarationContext)getInvokingContext(8)).vars.isEmpty() ) {

						String var = ((DeclarationContext)getInvokingContext(8)).vars.remove(0);

						if ((tipoSchema == 0) && (modoSetExpression!=1)) {
							zVars.put(var, null); //Marcamos la variable como variable Z, a la cual posiblemente se le deba asignarsele un valor
							//System.out.println("Agregamos:" + var);	
						}

						String newVarName = newVar(var);
						if (tipoSchema == 0)
							memory.put(var, newVarName);
						if (modoSetExpression==1)
							setExpressionVars.put(var, newVarName);
						
						String expType = types.get((((DeclarationContext)_localctx).expression!=null?_input.getText(((DeclarationContext)_localctx).expression.start,((DeclarationContext)_localctx).expression.stop):null));
						expType = typeInfo(newVarName, expType, memory.get((((DeclarationContext)_localctx).expression!=null?_input.getText(((DeclarationContext)_localctx).expression.start,((DeclarationContext)_localctx).expression.stop):null)));
						
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
		enterRule(_localctx, 18, RULE_declName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(177); match(NAME);
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
		int _startState = 20;
		enterRecursionRule(_localctx, RULE_predicate);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(266);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				{
				setState(180); ((PredicateContext)_localctx).e1 = expression(0);
				setState(181); match(45);
				setState(182); ((PredicateContext)_localctx).e2 = expression(0);

						String a, b;
						a = memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						
						//Si b es una lista, debo convertirla
						b = convertToSet((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null), b);
						
						//Si alguna de las expressiones es de la forma \\upto, se trata de forma distinta
						if ((getType(types.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null))).contains("\\upto")) || (getType(types.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null))).contains("\\upto")))
							print(a + " ein " + b);
						else
							print(a + " in " + b);
					
				}
				break;

			case 2:
				{
				setState(194);
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
				case 59:
				case 61:
				case POWER:
				case NAME:
				case NUM:
				case SETSTART:
				case LISTSTART:
					{
					setState(185); ((PredicateContext)_localctx).e1 = expression(0);
					setState(186); match(15);
					setState(187); ((PredicateContext)_localctx).e2 = expression(0);
					}
					break;
				case 2:
					{
					setState(189); match(2);
					setState(190); ((PredicateContext)_localctx).e1 = expression(0);
					setState(191); match(45);
					setState(192); ((PredicateContext)_localctx).e2 = expression(0);
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
						
						//Si alguna de las expressiones es de la forma \\upto, se trata de forma distinta
						if ((getType(types.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null))).contains("\\upto")) || (getType(types.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null))).contains("\\upto")))
							print(a + " enin " + b);
						else
							print(a + " nin " + b);
					
				}
				break;

			case 3:
				{
				setState(198); ((PredicateContext)_localctx).e1 = expression(0);
				setState(199); match(7);
				setState(200); ((PredicateContext)_localctx).e2 = expression(0);

						String a, b;
						a = memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						print(a + " < " + b);
					
				}
				break;

			case 4:
				{
				setState(203); ((PredicateContext)_localctx).e1 = expression(0);
				setState(204); match(58);
				setState(205); ((PredicateContext)_localctx).e2 = expression(0);

						String a, b;
						a = memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						print(a + " > " + b);
					
				}
				break;

			case 5:
				{
				setState(208); ((PredicateContext)_localctx).e1 = expression(0);
				setState(209); match(23);
				setState(210); ((PredicateContext)_localctx).e2 = expression(0);

						String a, b;
						a = memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						
						print(a + " =< " + b);
					
				}
				break;

			case 6:
				{
				setState(213); ((PredicateContext)_localctx).e1 = expression(0);
				setState(214); match(29);
				setState(215); ((PredicateContext)_localctx).e2 = expression(0);

						String a, b;
						a = memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						print(a + " =< " + b);
					
				}
				break;

			case 7:
				{
				setState(218); ((PredicateContext)_localctx).e1 = expression(0);
				setState(219); match(22);
				setState(220); ((PredicateContext)_localctx).e2 = expression(0);

						String a, b;
						a = memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						print(a + " = " + b);
					
				}
				break;

			case 8:
				{
				setState(223); ((PredicateContext)_localctx).e1 = expression(0);
				setState(224); match(32);
				setState(225); ((PredicateContext)_localctx).e2 = expression(0);

						String a, b;
						a = memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						
						//Si a es una lista, debo convertirla
						a = convertToSet((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null), a);
						//Si b es una lista, debo convertirla
						b = convertToSet((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null), b);
						
						//Si alguna de las expressiones es de la forma \\upto, se trata de forma distinta
						if ((getType(types.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null))).contains("\\upto")) || (getType(types.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null))).contains("\\upto")))
							print("esubset(" + a + "," + b + ")");
						else
							print("dsubset(" + a + "," + b + ")");
					
				}
				break;

			case 9:
				{
				setState(228); match(2);
				setState(229); ((PredicateContext)_localctx).e1 = expression(0);
				setState(230); match(32);
				setState(231); ((PredicateContext)_localctx).e2 = expression(0);

						String a, b;
						a = memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						
						//Si a es una lista, debo convertirla
						a = convertToSet((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null), a);
						//Si b es una lista, debo convertirla
						b = convertToSet((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null), b);
						
						//Si alguna de las expressiones es de la forma \\upto, se trata de forma distinta
						if ((getType(types.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null))).contains("\\upto")) || (getType(types.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null))).contains("\\upto")))
							print("ensubset(" + a + "," + b + ")");
						else
							print("dnsubset(" + a + "," + b + ")");
					
				}
				break;

			case 10:
				{
				setState(234); ((PredicateContext)_localctx).e1 = expression(0);
				setState(235); match(52);
				setState(236); ((PredicateContext)_localctx).e2 = expression(0);

						String a, b;
						a = memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						
						//Si a es una lista, debo convertirla
						a = convertToSet((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null), a);
						//Si b es una lista, debo convertirla
						b = convertToSet((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null), b);
						
						//Si alguna de las expressiones es de la forma \\upto, se trata de forma distinta
						if ((getType(types.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null))).contains("\\upto")) || (getType(types.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null))).contains("\\upto")))
							print("essubset(" + a + "," + b + ")");
						else
							print("dssubset(" + a + "," + b + ")");
					
				}
				break;

			case 11:
				{
				setState(239); match(2);
				setState(240); ((PredicateContext)_localctx).e1 = expression(0);
				setState(241); match(52);
				setState(242); ((PredicateContext)_localctx).e2 = expression(0);

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
							//Si alguna de las expressiones es de la forma \\upto, se trata de forma distinta
							if ((getType(types.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null))).contains("\\upto")) || (getType(types.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null))).contains("\\upto")))
								print("einters(" + a + "," + b + "," + c + ")");
							else								
								print("dinters(" + a + "," + b + "," + c + ")");
							String type = types.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
							if (isSequence(getType(type)))
								type = "\\power(\\nat\\cross(" + childsTypes(type).get(1) + "))";
							types.put((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null) + "\\cap" + (((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null), type);
							//typeInfo(c, type);
						}
						
						print(c + " neq " + a);
					
				}
				break;

			case 12:
				{
				setState(245); ((PredicateContext)_localctx).e1 = expression(0);
				setState(246); match(27);
				setState(247); ((PredicateContext)_localctx).e2 = expression(0);

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
				setState(250); ((PredicateContext)_localctx).e1 = expression(0);
				setState(251); match(24);
				setState(252); ((PredicateContext)_localctx).e2 = expression(0);

						String a, b;
						a = memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						print("prolog_call(append(" + a + ",_," + b + "))");
					
				}
				break;

			case 14:
				{
				setState(255); ((PredicateContext)_localctx).e1 = expression(0);
				setState(256); match(35);
				setState(257); ((PredicateContext)_localctx).e2 = expression(0);

						String a, b;
						a = memory.get((((PredicateContext)_localctx).e1!=null?_input.getText(((PredicateContext)_localctx).e1.start,((PredicateContext)_localctx).e1.stop):null));
						b = memory.get((((PredicateContext)_localctx).e2!=null?_input.getText(((PredicateContext)_localctx).e2.start,((PredicateContext)_localctx).e2.stop):null));
						print("prolog_call(append(_," + a + "," + b + "))");
					
				}
				break;

			case 15:
				{
				setState(260); match(40);
				setState(261); predicate(0);
				setState(262); match(18);
				}
				break;

			case 16:
				{
				setState(264); match(49);
				}
				break;

			case 17:
				{
				setState(265); match(8);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(282);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(280);
					switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
					case 1:
						{
						_localctx = new PredicateContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_predicate);
						setState(268);
						if (!(4 >= _localctx._p)) throw new FailedPredicateException(this, "4 >= $_p");
						setState(269); match(53);
						setState(270); predicate(5);
						}
						break;

					case 2:
						{
						_localctx = new PredicateContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_predicate);
						setState(271);
						if (!(3 >= _localctx._p)) throw new FailedPredicateException(this, "3 >= $_p");
						setState(272); match(55);
						setState(273); predicate(4);
						}
						break;

					case 3:
						{
						_localctx = new PredicateContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_predicate);
						setState(274);
						if (!(2 >= _localctx._p)) throw new FailedPredicateException(this, "2 >= $_p");
						setState(275); match(42);
						setState(276); predicate(3);
						}
						break;

					case 4:
						{
						_localctx = new PredicateContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_predicate);
						setState(277);
						if (!(1 >= _localctx._p)) throw new FailedPredicateException(this, "1 >= $_p");
						setState(278); match(17);
						setState(279); predicate(2);
						}
						break;
					}
					} 
				}
				setState(284);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
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
		public ExpressionContext e1;
		public ExpressionContext a;
		public PreContext pre;
		public ExpressionContext e;
		public ExpressionContext expression;
		public Token CROSS;
		public ExpressionContext e2;
		public Token IN_FUN_65;
		public Token IN_FUN_60;
		public Token IN_FUN_40;
		public Token IN_FUN_30;
		public Token IN_FUN_20;
		public Token IN_FUN_10;
		public Token IN_FUN_5;
		public ExpressionContext b;
		public EndExpressionContext end;
		public Token IMGSTART;
		public Token IMGEND;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public EndExpressionContext endExpression() {
			return getRuleContext(EndExpressionContext.class,0);
		}
		public TerminalNode IN_FUN_50() { return getToken(ExprParser.IN_FUN_50, 0); }
		public TerminalNode IN_FUN_5() { return getToken(ExprParser.IN_FUN_5, 0); }
		public TerminalNode POWER() { return getToken(ExprParser.POWER, 0); }
		public TerminalNode IN_FUN_60() { return getToken(ExprParser.IN_FUN_60, 0); }
		public TerminalNode IN_FUN_10() { return getToken(ExprParser.IN_FUN_10, 0); }
		public TerminalNode IN_FUN_40() { return getToken(ExprParser.IN_FUN_40, 0); }
		public TerminalNode IN_FUN_20() { return getToken(ExprParser.IN_FUN_20, 0); }
		public PreContext pre() {
			return getRuleContext(PreContext.class,0);
		}
		public TerminalNode IN_FUN_30() { return getToken(ExprParser.IN_FUN_30, 0); }
		public TerminalNode IN_FUN_45() { return getToken(ExprParser.IN_FUN_45, 0); }
		public TerminalNode CROSS() { return getToken(ExprParser.CROSS, 0); }
		public TerminalNode IMGEND() { return getToken(ExprParser.IMGEND, 0); }
		public TerminalNode IMGSTART() { return getToken(ExprParser.IMGSTART, 0); }
		public TerminalNode IN_FUN_65() { return getToken(ExprParser.IN_FUN_65, 0); }
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
		int _startState = 22;
		enterRecursionRule(_localctx, RULE_expression);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(295);
			switch (_input.LA(1)) {
			case 3:
			case 4:
			case 5:
			case 10:
			case 12:
			case 13:
			case 16:
			case 20:
			case 21:
			case 25:
			case 30:
			case 37:
			case 43:
			case 46:
			case 57:
			case 59:
				{
				setState(286); ((ExpressionContext)_localctx).pre = pre();
				setState(287); ((ExpressionContext)_localctx).e = ((ExpressionContext)_localctx).expression = expression(15);

						if (memory.get((((ExpressionContext)_localctx).pre!=null?_input.getText(((ExpressionContext)_localctx).pre.start,((ExpressionContext)_localctx).pre.stop):null) + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null)) == null) {
						
							String a;
							a = memory.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null));
							String newVarName = newVar();
						
							if ((((ExpressionContext)_localctx).pre!=null?_input.getText(((ExpressionContext)_localctx).pre.start,((ExpressionContext)_localctx).pre.stop):null).equals("\\negate")){
								memory.put("\\negate" + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), "-" + a);
								types.put("\\negate" + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), "\\num");
								if (modoSetExpression != 0 )
									setExpressionVars.put("\\negate" + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), "-" + a);
							}
							else if ((((ExpressionContext)_localctx).pre!=null?_input.getText(((ExpressionContext)_localctx).pre.start,((ExpressionContext)_localctx).pre.stop):null).equals("\\#")){
								memory.put("\\#" + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), newVarName);
								types.put("\\#" + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), "\\nat");
								if (modoSetExpression != 0 )
									setExpressionVars.put("\\#" + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), newVarName);
								
								String type = getType(types.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null)));
								if (isSequence(type))
									print("prolog_call(length(" + a + "," + newVarName + "))");
								else
									print("size(" + a + "," + newVarName + ")");					
							
								print(newVarName + " ein " + printInfo("\\nat", true));
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
									print("dom_list(" + e + "," + newVarName + ")");
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
								print(n + " ein " + printInfo("\\nat", true));
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
								ArrayList<String> childsTypes = childsTypes(type);
								type = "\\seq(" + childsTypes.get(1) + ")";
								types.put((((ExpressionContext)_localctx).pre!=null?_input.getText(((ExpressionContext)_localctx).pre.start,((ExpressionContext)_localctx).pre.stop):null) + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), type);
								typeInfo(newVarName, type);
								if (modoSetExpression != 0 )
									setExpressionVars.put((((ExpressionContext)_localctx).pre!=null?_input.getText(((ExpressionContext)_localctx).pre.start,((ExpressionContext)_localctx).pre.stop):null) + (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null), newVarName);
							}
						}
					
				}
				break;
			case POWER:
				{
				setState(290); match(POWER);
				setState(291); ((ExpressionContext)_localctx).e = ((ExpressionContext)_localctx).expression = expression(13);

						String eType = types.get((((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null));
						if (isBasic(eType))
							eType = (((ExpressionContext)_localctx).e!=null?_input.getText(((ExpressionContext)_localctx).e.start,((ExpressionContext)_localctx).e.stop):null);
					
						types.put(_input.getText(_localctx.start, _input.LT(-1)), "\\power" + eType );
					
				}
				break;
			case 11:
			case 26:
			case 40:
			case 51:
			case 61:
			case NAME:
			case NUM:
			case SETSTART:
			case LISTSTART:
				{
				setState(294); endExpression(0);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(359);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(357);
					switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(297);
						if (!(12 >= _localctx._p)) throw new FailedPredicateException(this, "12 >= $_p");
						setState(298); ((ExpressionContext)_localctx).CROSS = match(CROSS);
						setState(299); ((ExpressionContext)_localctx).e2 = ((ExpressionContext)_localctx).expression = expression(13);

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
						          		while( !((ExpressionContext)getInvokingContext(11)).elements.isEmpty() ) {
						          			String exp = ((ExpressionContext)getInvokingContext(11)).elements.remove(0);
						          			
						          			((ExpressionContext)_localctx).zName =  _localctx.zName.concat(exp);
						          			
						          			String expType = types.get(exp);
						          			if (isBasic(expType))
						          				unfoldedType = unfoldedType.concat(exp);
						          			else
						          				unfoldedType = unfoldedType.concat(expType);
						          				
						          			if (!((ExpressionContext)getInvokingContext(11)).elements.isEmpty()) {
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
						setState(302);
						if (!(11 >= _localctx._p)) throw new FailedPredicateException(this, "11 >= $_p");
						setState(303); ((ExpressionContext)_localctx).IN_FUN_65 = match(IN_FUN_65);
						setState(304); ((ExpressionContext)_localctx).e2 = ((ExpressionContext)_localctx).expression = expression(12);

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
						          				ArrayList<String> childsTypes = childsTypes(type2);
						          				String type = "\\power((" + childsTypes.get(0) + ")\\cross(" + childsTypes.get(1) + "))";
						          				types.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\dres" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), type);
						          				typeInfo(newVarName, type);
						          				if (modoSetExpression != 0 )
						          					setExpressionVars.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\dres" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          			}
						          			else if ((((ExpressionContext)_localctx).IN_FUN_65!=null?((ExpressionContext)_localctx).IN_FUN_65.getText():null).equals("\\ndres")){
						          				print("ndres(" + a + "," + b + "," + newVarName + ")");
						          				memory.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\ndres" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          				String type2 = types.get((((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null));
						          				ArrayList<String> childsTypes = childsTypes(type2);
						          				String type = "\\power((" + childsTypes.get(0) + ")\\cross(" + childsTypes.get(1) + "))";
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
						setState(307);
						if (!(10 >= _localctx._p)) throw new FailedPredicateException(this, "10 >= $_p");
						setState(308); ((ExpressionContext)_localctx).IN_FUN_60 = match(IN_FUN_60);
						setState(309); ((ExpressionContext)_localctx).e2 = ((ExpressionContext)_localctx).expression = expression(11);

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
						          				ArrayList<String> childsTypes = childsTypes(type1);
						          				String type = "\\power((" + childsTypes.get(0) + ")\\cross(" + childsTypes.get(1) + "))";
						          				types.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\rres" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), type);
						          				typeInfo(newVarName, type);
						          				if (modoSetExpression != 0 )
						          					setExpressionVars.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\rres" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          			}
						          			else if ((((ExpressionContext)_localctx).IN_FUN_60!=null?((ExpressionContext)_localctx).IN_FUN_60.getText():null).equals("\\nrres")){
						          				print("nrres(" + b + "," + a + "," + newVarName + ")");
						          				memory.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\nrres" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          				String type1 = types.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null));
						          				ArrayList<String> childsTypes = childsTypes(type1);
						          				String type = "\\power((" + childsTypes.get(0) + ")\\cross(" + childsTypes.get(1) + "))";
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
						setState(312);
						if (!(9 >= _localctx._p)) throw new FailedPredicateException(this, "9 >= $_p");
						setState(313); match(IN_FUN_50);
						setState(314); ((ExpressionContext)_localctx).e2 = ((ExpressionContext)_localctx).expression = expression(10);

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
						          			ArrayList<String> childsTypes = childsTypes(type1);
						          			String type = "\\power((" + childsTypes.get(0) + ")\\cross(" + childsTypes.get(1) + "))";
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
						setState(317);
						if (!(8 >= _localctx._p)) throw new FailedPredicateException(this, "8 >= $_p");
						setState(318); match(IN_FUN_45);
						setState(319); ((ExpressionContext)_localctx).e2 = ((ExpressionContext)_localctx).expression = expression(9);

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
						setState(322);
						if (!(7 >= _localctx._p)) throw new FailedPredicateException(this, "7 >= $_p");
						setState(323); ((ExpressionContext)_localctx).IN_FUN_40 = match(IN_FUN_40);
						setState(324); ((ExpressionContext)_localctx).e2 = ((ExpressionContext)_localctx).expression = expression(8);

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
						          				
						          				//Si alguna de las expressiones es de la forma \\upto, se trata de forma distinta
						          				if ((getType(types.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null))).contains("\\upto")) || (getType(types.get((((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null))).contains("\\upto")))
						          					print("einters(" + a + "," + b + "," + newVarName + ")");
						          				else								
						          					print("dinters(" + a + "," + b + "," + newVarName + ")");
						          					
						          				memory.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\cap" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          				String type = types.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null));
						          				if (getType(type).contains("\\upto"))
						          					type = "\\power\\num";
						          				else if (isSequence(getType(type)))
						          					type = "\\power(\\nat\\cross(" + childsTypes(type).get(1) + "))";
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
						          				String type = "\\power((" + childsTypes(type1).get(0) + ")\\cross(" + childsTypes(type2).get(1) + "))";
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
						          				type1 = childsTypes(type1).get(1);
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
						          				print(newVarName + " ein " + printInfo("\\num", true));
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
						setState(327);
						if (!(6 >= _localctx._p)) throw new FailedPredicateException(this, "6 >= $_p");
						setState(328); ((ExpressionContext)_localctx).IN_FUN_30 = match(IN_FUN_30);
						setState(329); ((ExpressionContext)_localctx).e2 = ((ExpressionContext)_localctx).expression = expression(7);

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
						          				
						          				print("eun(" + a + "," + b + "," + newVarName + ")");
						          				memory.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + "\\cup" + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null), newVarName);
						          				String type = types.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null));
						          				if (getType(type).contains("\\upto"))
						          					type = "\\power\\num";
						          				else if (isSequence(getType(type)))
						          					type = "\\power(\\nat\\cross(" + childsTypes(type).get(1) + "))";
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
						          				if (getType(type).contains("\\upto"))
						          					type = "\\power\\num";
						          				else if (isSequence(getType(type)))
						          					type = "\\power(\\nat\\cross(" + childsTypes(type).get(1) + "))";
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
						          				print(newVarName + " ein " + printInfo("\\num", true));
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
						setState(332);
						if (!(5 >= _localctx._p)) throw new FailedPredicateException(this, "5 >= $_p");
						setState(333); ((ExpressionContext)_localctx).IN_FUN_20 = match(IN_FUN_20);
						setState(334); ((ExpressionContext)_localctx).e2 = ((ExpressionContext)_localctx).expression = expression(6);

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
						setState(337);
						if (!(4 >= _localctx._p)) throw new FailedPredicateException(this, "4 >= $_p");
						setState(338); ((ExpressionContext)_localctx).IN_FUN_10 = match(IN_FUN_10);
						setState(339); ((ExpressionContext)_localctx).e2 = ((ExpressionContext)_localctx).expression = expression(5);

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
						setState(342);
						if (!(3 >= _localctx._p)) throw new FailedPredicateException(this, "3 >= $_p");
						setState(343); ((ExpressionContext)_localctx).IN_FUN_5 = match(IN_FUN_5);
						setState(344); ((ExpressionContext)_localctx).b = ((ExpressionContext)_localctx).expression = expression(4);

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
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(347);
						if (!(14 >= _localctx._p)) throw new FailedPredicateException(this, "14 >= $_p");
						setState(348); ((ExpressionContext)_localctx).end = endExpression(0);

						          		String a, b;
						          		a = memory.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null));
						          		b = memory.get((((ExpressionContext)_localctx).end!=null?_input.getText(((ExpressionContext)_localctx).end.start,((ExpressionContext)_localctx).end.stop):null));
						          		String op = "";
						          				
						          		//Si a es una lista, debo convertirla
						          		a = convertToSet((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null), a);
						          		
						          		if (memory.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + op + (((ExpressionContext)_localctx).end!=null?_input.getText(((ExpressionContext)_localctx).end.start,((ExpressionContext)_localctx).end.stop):null)) == null) {
						          			String newVarName = newVar();
						          			memory.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + op + (((ExpressionContext)_localctx).end!=null?_input.getText(((ExpressionContext)_localctx).end.start,((ExpressionContext)_localctx).end.stop):null), newVarName);
						          			
						          			if (modoSetExpression != 0 )
						          				setExpressionVars.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + op + (((ExpressionContext)_localctx).end!=null?_input.getText(((ExpressionContext)_localctx).end.start,((ExpressionContext)_localctx).end.stop):null), newVarName);

						          			String type1 = types.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null));
						          			//getType(type1);
						          			String newVarType = childsTypes(type1).get(1);
						          			types.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + op + (((ExpressionContext)_localctx).end!=null?_input.getText(((ExpressionContext)_localctx).end.start,((ExpressionContext)_localctx).end.stop):null), newVarType);
						          			print("apply(" + a + "," + b + "," + newVarName + ")");
						          			
						          			//Imprimimos la informacion del tipo de la variable
						          			typeInfo(newVarName, newVarType);
						          		}
						          	
						}
						break;

					case 12:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(351);
						if (!(2 >= _localctx._p)) throw new FailedPredicateException(this, "2 >= $_p");
						setState(352); ((ExpressionContext)_localctx).IMGSTART = match(IMGSTART);
						setState(353); ((ExpressionContext)_localctx).e2 = ((ExpressionContext)_localctx).expression = expression(0);
						setState(354); ((ExpressionContext)_localctx).IMGEND = match(IMGEND);

						          		String a, b;
						          		a = memory.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null));
						          		b = memory.get((((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null));
						          		
						          		if (memory.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + (((ExpressionContext)_localctx).IMGSTART!=null?((ExpressionContext)_localctx).IMGSTART.getText():null) + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null) + (((ExpressionContext)_localctx).IMGEND!=null?((ExpressionContext)_localctx).IMGEND.getText():null)) == null) {
						          			String newVarName = newVar();
						          			print("rimg(" + a + "," + b + "," + newVarName + ")");
						          			memory.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + (((ExpressionContext)_localctx).IMGSTART!=null?((ExpressionContext)_localctx).IMGSTART.getText():null) + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null) + (((ExpressionContext)_localctx).IMGEND!=null?((ExpressionContext)_localctx).IMGEND.getText():null), newVarName);
						          			String type1 = types.get((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null));
						          			String type = "\\power(" + getChildType(type1, 1) + ")";
						          			types.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + (((ExpressionContext)_localctx).IMGSTART!=null?((ExpressionContext)_localctx).IMGSTART.getText():null) + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null) + (((ExpressionContext)_localctx).IMGEND!=null?((ExpressionContext)_localctx).IMGEND.getText():null), type);
						          			typeInfo(newVarName, type);
						          			if (modoSetExpression != 0 )
						          				setExpressionVars.put((((ExpressionContext)_localctx).e1!=null?_input.getText(((ExpressionContext)_localctx).e1.start,((ExpressionContext)_localctx).e1.stop):null) + (((ExpressionContext)_localctx).IMGSTART!=null?((ExpressionContext)_localctx).IMGSTART.getText():null) + (((ExpressionContext)_localctx).e2!=null?_input.getText(((ExpressionContext)_localctx).e2.start,((ExpressionContext)_localctx).e2.stop):null) + (((ExpressionContext)_localctx).IMGEND!=null?((ExpressionContext)_localctx).IMGEND.getText():null), newVarName);
						          		}
						          	
						}
						break;
					}
					} 
				}
				setState(361);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
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

	public static class EndExpressionContext extends ParserRuleContext {
		public int _p;
		public ArrayList<String> elements = new ArrayList<String>();
		public String setlogName = "";
		public String zName = "";
		public String operator = "";
		public String newVarName1 = "";
		public String newVarName2 = "";
		public EndExpressionContext end;
		public RefNameContext refName;
		public Token NUM;
		public Token SETSTART;
		public ExpressionContext a;
		public ExpressionContext expression;
		public ExpressionContext b;
		public Token SETEND;
		public DeclPartContext declPart;
		public PredicateContext predicate;
		public ExpressionContext c;
		public Token n;
		public ExpressionContext e;
		public Token LISTSTART;
		public Token LISTEND;
		public PostContext post;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public TerminalNode SETSTART() { return getToken(ExprParser.SETSTART, 0); }
		public PostContext post() {
			return getRuleContext(PostContext.class,0);
		}
		public EndExpressionContext endExpression() {
			return getRuleContext(EndExpressionContext.class,0);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> NAME() { return getTokens(ExprParser.NAME); }
		public PredicateContext predicate() {
			return getRuleContext(PredicateContext.class,0);
		}
		public TerminalNode NAME(int i) {
			return getToken(ExprParser.NAME, i);
		}
		public DeclPartContext declPart() {
			return getRuleContext(DeclPartContext.class,0);
		}
		public TerminalNode SETEND() { return getToken(ExprParser.SETEND, 0); }
		public RefNameContext refName() {
			return getRuleContext(RefNameContext.class,0);
		}
		public TerminalNode LISTSTART() { return getToken(ExprParser.LISTSTART, 0); }
		public TerminalNode LISTEND() { return getToken(ExprParser.LISTEND, 0); }
		public TerminalNode NUM() { return getToken(ExprParser.NUM, 0); }
		public TerminalNode SELECTION() { return getToken(ExprParser.SELECTION, 0); }
		public EndExpressionContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public EndExpressionContext(ParserRuleContext parent, int invokingState, int _p) {
			super(parent, invokingState);
			this._p = _p;
		}
		@Override public int getRuleIndex() { return RULE_endExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterEndExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitEndExpression(this);
		}
	}

	public final EndExpressionContext endExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		EndExpressionContext _localctx = new EndExpressionContext(_ctx, _parentState, _p);
		EndExpressionContext _prevctx = _localctx;
		int _startState = 24;
		enterRecursionRule(_localctx, RULE_endExpression);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(466);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				{
				setState(363); ((EndExpressionContext)_localctx).refName = refName();
				}
				break;

			case 2:
				{
				setState(364); ((EndExpressionContext)_localctx).NUM = match(NUM);

						if (memory.get((((EndExpressionContext)_localctx).NUM!=null?((EndExpressionContext)_localctx).NUM.getText():null)) == null) {
							memory.put((((EndExpressionContext)_localctx).NUM!=null?((EndExpressionContext)_localctx).NUM.getText():null), (((EndExpressionContext)_localctx).NUM!=null?((EndExpressionContext)_localctx).NUM.getText():null));
							types.put((((EndExpressionContext)_localctx).NUM!=null?((EndExpressionContext)_localctx).NUM.getText():null), "\\num");
						}
					
				}
				break;

			case 3:
				{
				setState(366); match(11);

						if (memory.get("\\emptyset") == null) {
							memory.put("\\emptyset", "{}");
							types.put("\\emptyset", "\\power(" + "generic" + ")");
						}
					
				}
				break;

			case 4:
				{
				setState(368); ((EndExpressionContext)_localctx).SETSTART = match(SETSTART);
				setState(372);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 3) | (1L << 4) | (1L << 5) | (1L << 10) | (1L << 11) | (1L << 12) | (1L << 13) | (1L << 16) | (1L << 20) | (1L << 21) | (1L << 25) | (1L << 26) | (1L << 30) | (1L << 37) | (1L << 40) | (1L << 43) | (1L << 46) | (1L << 51) | (1L << 57) | (1L << 59) | (1L << 61))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (POWER - 64)) | (1L << (NAME - 64)) | (1L << (NUM - 64)) | (1L << (SETSTART - 64)) | (1L << (LISTSTART - 64)))) != 0)) {
					{
					setState(369); ((EndExpressionContext)_localctx).a = ((EndExpressionContext)_localctx).expression = expression(0);
					_localctx.elements.add((((EndExpressionContext)_localctx).a!=null?_input.getText(((EndExpressionContext)_localctx).a.start,((EndExpressionContext)_localctx).a.stop):null));
					}
				}

				setState(380);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==38) {
					{
					{
					setState(374); match(38);
					setState(375); ((EndExpressionContext)_localctx).b = ((EndExpressionContext)_localctx).expression = expression(0);
					_localctx.elements.add((((EndExpressionContext)_localctx).b!=null?_input.getText(((EndExpressionContext)_localctx).b.start,((EndExpressionContext)_localctx).b.stop):null));
					}
					}
					setState(382);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(383); ((EndExpressionContext)_localctx).SETEND = match(SETEND);
					
						((EndExpressionContext)_localctx).zName =  (((EndExpressionContext)_localctx).SETSTART!=null?((EndExpressionContext)_localctx).SETSTART.getText():null);
						String type = new String();
						//Llenamos elements y ponemos cada expression en la memory
						while( !_localctx.elements.isEmpty() ){
							String e = _localctx.elements.remove(0);
							if (type.equals("")) {
								type = types.get(e);
								if (getType(type).contains("\\upto"))
									type = "\\power\\num";
							}
							((EndExpressionContext)_localctx).zName =  _localctx.zName.concat(e);
							//guardamos tambien las traducciones del conjunto
							((EndExpressionContext)_localctx).setlogName =  _localctx.setlogName.concat(memory.get(e));
							
							if (!_localctx.elements.isEmpty()){
								((EndExpressionContext)_localctx).zName =  _localctx.zName + ",";
								((EndExpressionContext)_localctx).setlogName =  _localctx.setlogName + ",";
							}
						}
						((EndExpressionContext)_localctx).zName =  _localctx.zName + (((EndExpressionContext)_localctx).SETEND!=null?((EndExpressionContext)_localctx).SETEND.getText():null);
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
				setState(385); ((EndExpressionContext)_localctx).SETSTART = match(SETSTART);
				modoSetExpression=1; setExpressionDecl = ""; setExpressionPred = ""; setExpressionExpr = ""; setExpressionVars = new HashMap();
				setState(387); ((EndExpressionContext)_localctx).declPart = declPart();
				((EndExpressionContext)_localctx).zName =  (((EndExpressionContext)_localctx).SETSTART!=null?((EndExpressionContext)_localctx).SETSTART.getText():null) + (((EndExpressionContext)_localctx).declPart!=null?_input.getText(((EndExpressionContext)_localctx).declPart.start,((EndExpressionContext)_localctx).declPart.stop):null);
				setState(394);
				_la = _input.LA(1);
				if (_la==33) {
					{
					setState(389); match(33);
					modoSetExpression=2;
					setState(391); ((EndExpressionContext)_localctx).predicate = predicate(0);
					((EndExpressionContext)_localctx).zName =  _localctx.zName.concat("|" + (((EndExpressionContext)_localctx).predicate!=null?_input.getText(((EndExpressionContext)_localctx).predicate.start,((EndExpressionContext)_localctx).predicate.stop):null));
					}
				}

				setState(401);
				_la = _input.LA(1);
				if (_la==19) {
					{
					setState(396); match(19);
					modoSetExpression=3;
					setState(398); ((EndExpressionContext)_localctx).c = ((EndExpressionContext)_localctx).expression = expression(0);
					((EndExpressionContext)_localctx).zName =  _localctx.zName.concat("@" + (((EndExpressionContext)_localctx).c!=null?_input.getText(((EndExpressionContext)_localctx).c.start,((EndExpressionContext)_localctx).c.stop):null));
					}
				}

				setState(403); ((EndExpressionContext)_localctx).SETEND = match(SETEND);
				modoSetExpression=0; ((EndExpressionContext)_localctx).zName =  _localctx.zName.concat((((EndExpressionContext)_localctx).SETEND!=null?((EndExpressionContext)_localctx).SETEND.getText():null));

						if (memory.get(_localctx.zName)==null) {
						
							// Probando eliminar la variable extra y usar '=' en vez de 'is' cuando corresponde
							String varName = memory.get((((EndExpressionContext)_localctx).c!=null?_input.getText(((EndExpressionContext)_localctx).c.start,((EndExpressionContext)_localctx).c.stop):null));
							String op = getType(types.get((((EndExpressionContext)_localctx).c!=null?_input.getText(((EndExpressionContext)_localctx).c.start,((EndExpressionContext)_localctx).c.stop):null)));
							if (isNumeric(op))
								op = " is ";
							else
								op = " = ";
							
							boolean needsNewName = false;
							if ((varName == null) || (varName.matches("^.*[^a-zA-Z0-9 ].*"))) { //Si es nulo o tiene caracteres que no son letras o numeros
								varName = newVar();
								needsNewName = true;
							}
						
							((EndExpressionContext)_localctx).setlogName =  "";
							((EndExpressionContext)_localctx).newVarName2 =  newVar();
							
							((EndExpressionContext)_localctx).setlogName =  _localctx.setlogName.concat("{ " + varName + " :exists([");
							
							Collection<String> values = setExpressionVars.values();
							if (!needsNewName)
								values.remove(varName);
							
							Iterator<String> valuesIt = values.iterator();
							while (valuesIt.hasNext()){
								((EndExpressionContext)_localctx).setlogName =   _localctx.setlogName.concat(valuesIt.next());
								if (valuesIt.hasNext()) ((EndExpressionContext)_localctx).setlogName =   _localctx.setlogName.concat(",");
							}
						
							String content = setExpressionDecl + setExpressionPred + setExpressionExpr;
							content = content.substring(content.indexOf('&') + 1);
							if (!content.equals("") && needsNewName)
								content = content.concat(" & ");
							
							((EndExpressionContext)_localctx).setlogName =  _localctx.setlogName.concat("], " + content);
							if (needsNewName)
								((EndExpressionContext)_localctx).setlogName =  _localctx.setlogName.concat(varName + op + memory.get((((EndExpressionContext)_localctx).c!=null?_input.getText(((EndExpressionContext)_localctx).c.start,((EndExpressionContext)_localctx).c.stop):null)));
							((EndExpressionContext)_localctx).setlogName =  _localctx.setlogName.concat(")" + " }");
						
							memory.put(_localctx.zName, _localctx.newVarName2);
							types.put(_localctx.zName, "\\power(" + types.get((((EndExpressionContext)_localctx).c!=null?_input.getText(((EndExpressionContext)_localctx).c.start,((EndExpressionContext)_localctx).c.stop):null)) + ")"); //REVISAR!!!
							print(_localctx.newVarName2 + " = " + _localctx.setlogName);
							
							Iterator<String> keysIt = setExpressionVars.keySet().iterator();
							while (keysIt.hasNext()){
								String var = keysIt.next();
								memory.remove(var);
								keysIt.remove();
								zVars.remove(var);
								//System.out.println("Sacamos" + var);
								//setExpressionVars.remove(var);
							}
						}
					
				}
				break;

			case 6:
				{
				setState(407); match(51);
				setExpressionVars = new HashMap();
				setState(416); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(409); ((EndExpressionContext)_localctx).n = match(NAME);
					setState(410); match(62);
					setState(411); ((EndExpressionContext)_localctx).e = ((EndExpressionContext)_localctx).expression = expression(0);
					setExpressionVars.put((((EndExpressionContext)_localctx).n!=null?((EndExpressionContext)_localctx).n.getText():null), (((EndExpressionContext)_localctx).e!=null?_input.getText(((EndExpressionContext)_localctx).e.start,((EndExpressionContext)_localctx).e.stop):null));
					setState(414);
					_la = _input.LA(1);
					if (_la==38) {
						{
						setState(413); match(38);
						}
					}

					}
					}
					setState(418); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NAME );
				setState(420); match(47);

						((EndExpressionContext)_localctx).setlogName =  "[";
						List<String> sortedVars = new ArrayList<String>(setExpressionVars.keySet());
						java.util.Collections.sort(sortedVars);
						
						int i = 0;
						while( i < sortedVars.size() ){
							String value = setExpressionVars.get(sortedVars.get(i));

							((EndExpressionContext)_localctx).setlogName =  _localctx.setlogName.concat(value);
							
							if (i+1 < sortedVars.size()){
								((EndExpressionContext)_localctx).setlogName =  _localctx.setlogName.concat(",");
							}
							i++;
						}
						
						((EndExpressionContext)_localctx).setlogName =  _localctx.setlogName.concat("]");
						
						if (memory.get((((EndExpressionContext)_localctx).expression!=null?_input.getText(((EndExpressionContext)_localctx).expression.start,((EndExpressionContext)_localctx).expression.stop):null)) == null) {
							memory.put((((EndExpressionContext)_localctx).expression!=null?_input.getText(((EndExpressionContext)_localctx).expression.start,((EndExpressionContext)_localctx).expression.stop):null), _localctx.setlogName);
							types.put((((EndExpressionContext)_localctx).expression!=null?_input.getText(((EndExpressionContext)_localctx).expression.start,((EndExpressionContext)_localctx).expression.stop):null), "\\seq(" + "generic" + ")");
						}
					
				}
				break;

			case 7:
				{
				setState(423); ((EndExpressionContext)_localctx).LISTSTART = match(LISTSTART);
				setState(427);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 3) | (1L << 4) | (1L << 5) | (1L << 10) | (1L << 11) | (1L << 12) | (1L << 13) | (1L << 16) | (1L << 20) | (1L << 21) | (1L << 25) | (1L << 26) | (1L << 30) | (1L << 37) | (1L << 40) | (1L << 43) | (1L << 46) | (1L << 51) | (1L << 57) | (1L << 59) | (1L << 61))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (POWER - 64)) | (1L << (NAME - 64)) | (1L << (NUM - 64)) | (1L << (SETSTART - 64)) | (1L << (LISTSTART - 64)))) != 0)) {
					{
					setState(424); ((EndExpressionContext)_localctx).a = ((EndExpressionContext)_localctx).expression = expression(0);
					_localctx.elements.add((((EndExpressionContext)_localctx).a!=null?_input.getText(((EndExpressionContext)_localctx).a.start,((EndExpressionContext)_localctx).a.stop):null));
					}
				}

				setState(435);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==38) {
					{
					{
					setState(429); match(38);
					setState(430); ((EndExpressionContext)_localctx).b = ((EndExpressionContext)_localctx).expression = expression(0);
					_localctx.elements.add((((EndExpressionContext)_localctx).b!=null?_input.getText(((EndExpressionContext)_localctx).b.start,((EndExpressionContext)_localctx).b.stop):null));
					}
					}
					setState(437);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(438); ((EndExpressionContext)_localctx).LISTEND = match(LISTEND);
					
						((EndExpressionContext)_localctx).zName =  _localctx.zName.concat((((EndExpressionContext)_localctx).LISTSTART!=null?((EndExpressionContext)_localctx).LISTSTART.getText():null));
						String type = new String();
						//Llenamos elements y ponemos cada expression en la memory
						while( !_localctx.elements.isEmpty() ){
							String e = _localctx.elements.remove(0);
							if (type.equals("")) {
								type = types.get(e);
								if (getType(type).contains("\\upto"))
									type = "\\power\\num";
							}
							((EndExpressionContext)_localctx).zName =  _localctx.zName.concat(e);
							//guardamos tambien las traducciones del conjunto
							((EndExpressionContext)_localctx).setlogName =  _localctx.setlogName.concat(memory.get(e));
							
							if (!_localctx.elements.isEmpty()){
								((EndExpressionContext)_localctx).zName =  _localctx.zName + ",";
								((EndExpressionContext)_localctx).setlogName =  _localctx.setlogName + ",";
							}
						}
						((EndExpressionContext)_localctx).zName =  _localctx.zName + (((EndExpressionContext)_localctx).LISTEND!=null?((EndExpressionContext)_localctx).LISTEND.getText():null);
						if (memory.get(_localctx.zName) == null) {
							memory.put(_localctx.zName, "[" + _localctx.setlogName + "]");
							if (_localctx.setlogName.equals(""))
								types.put(_localctx.zName, "\\seq(" + "generic" + ")");
							else
								types.put(_localctx.zName, "\\seq(" + type + ")");
						}
					
				}
				break;

			case 8:
				{
				setState(440); match(40);
				setState(441); ((EndExpressionContext)_localctx).a = ((EndExpressionContext)_localctx).expression = expression(0);
				_localctx.elements.add((((EndExpressionContext)_localctx).a!=null?_input.getText(((EndExpressionContext)_localctx).a.start,((EndExpressionContext)_localctx).a.stop):null));
				setState(447); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(443); match(38);
					setState(444); ((EndExpressionContext)_localctx).b = ((EndExpressionContext)_localctx).expression = expression(0);
					_localctx.elements.add((((EndExpressionContext)_localctx).b!=null?_input.getText(((EndExpressionContext)_localctx).b.start,((EndExpressionContext)_localctx).b.stop):null));
					}
					}
					setState(449); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==38 );
				setState(451); match(18);
					
						((EndExpressionContext)_localctx).zName =  "(";
						String type = new String();
						//Llenamos elements y ponemos cada expression en la memory
						while( !_localctx.elements.isEmpty() ){
							String e = _localctx.elements.remove(0);
							if (type.equals(""))
								type = "(" + types.get(e) + ")";
							else
								type = type.concat("\\cross(" + types.get(e) + ")");
								 
							((EndExpressionContext)_localctx).zName =  _localctx.zName.concat(e);
							//guardamos tambien las traducciones del conjunto
							((EndExpressionContext)_localctx).setlogName =  _localctx.setlogName.concat(memory.get(e));
							
							if (!_localctx.elements.isEmpty()){
								((EndExpressionContext)_localctx).zName =  _localctx.zName + ",";
								((EndExpressionContext)_localctx).setlogName =  _localctx.setlogName + ",";
							}
						}
						((EndExpressionContext)_localctx).zName =  _localctx.zName + ")";
						if (memory.get(_localctx.zName) == null) {
							memory.put(_localctx.zName, "[" + _localctx.setlogName + "]");
							types.put(_localctx.zName, type);
						}
					
				}
				break;

			case 9:
				{
				setState(454); match(40);
				setState(455); ((EndExpressionContext)_localctx).e = ((EndExpressionContext)_localctx).expression = expression(0);
				setState(456); match(18);

						String a = memory.get((((EndExpressionContext)_localctx).e!=null?_input.getText(((EndExpressionContext)_localctx).e.start,((EndExpressionContext)_localctx).e.stop):null));
						
						//Chequeo el nombre para ver si se trata de una sola variable, en ese caso no guardo en la memoria
						//los parentesis, en otro caso si
						
						if (a != null) { //Si no estoy en la parte de declaracion
							Pattern p = Pattern.compile("[^a-zA-Z0-9_]");
							boolean hasSpecialChar = p.matcher(a).find();
							
							if (hasSpecialChar){
								memory.put("(" + (((EndExpressionContext)_localctx).e!=null?_input.getText(((EndExpressionContext)_localctx).e.start,((EndExpressionContext)_localctx).e.stop):null) + ")", "(" + a + ")");
								if (types.get((((EndExpressionContext)_localctx).e!=null?_input.getText(((EndExpressionContext)_localctx).e.start,((EndExpressionContext)_localctx).e.stop):null)) != null) {
									types.put("(" + (((EndExpressionContext)_localctx).e!=null?_input.getText(((EndExpressionContext)_localctx).e.start,((EndExpressionContext)_localctx).e.stop):null) + ")", "(" + types.get((((EndExpressionContext)_localctx).e!=null?_input.getText(((EndExpressionContext)_localctx).e.start,((EndExpressionContext)_localctx).e.stop):null)) + ")");
								}
							}
							else {
								memory.put("(" + (((EndExpressionContext)_localctx).e!=null?_input.getText(((EndExpressionContext)_localctx).e.start,((EndExpressionContext)_localctx).e.stop):null) + ")", a);
								if (types.get((((EndExpressionContext)_localctx).e!=null?_input.getText(((EndExpressionContext)_localctx).e.start,((EndExpressionContext)_localctx).e.stop):null)) != null) {
									types.put("(" + (((EndExpressionContext)_localctx).e!=null?_input.getText(((EndExpressionContext)_localctx).e.start,((EndExpressionContext)_localctx).e.stop):null) + ")", "(" + types.get((((EndExpressionContext)_localctx).e!=null?_input.getText(((EndExpressionContext)_localctx).e.start,((EndExpressionContext)_localctx).e.stop):null)) + ")");
								}
							}
						} else  //Si estoy en la parte de declaracion
							if (types.get((((EndExpressionContext)_localctx).e!=null?_input.getText(((EndExpressionContext)_localctx).e.start,((EndExpressionContext)_localctx).e.stop):null)) != null)
								types.put("(" + (((EndExpressionContext)_localctx).e!=null?_input.getText(((EndExpressionContext)_localctx).e.start,((EndExpressionContext)_localctx).e.stop):null) + ")", "(" + types.get((((EndExpressionContext)_localctx).e!=null?_input.getText(((EndExpressionContext)_localctx).e.start,((EndExpressionContext)_localctx).e.stop):null)) + ")");
					
				}
				break;

			case 10:
				{
				setState(459); match(26);
				setState(460); match(9);
					
						printInfo(_input.getText(_localctx.start, _input.LT(-1)), false);	
					
				}
				break;

			case 11:
				{
				setState(462); match(26);
					
						printInfo(_input.getText(_localctx.start, _input.LT(-1)), false);	
					
				}
				break;

			case 12:
				{
				setState(464); match(61);
					
						printInfo(_input.getText(_localctx.start, _input.LT(-1)), false);	
					
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(481);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(479);
					switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
					case 1:
						{
						_localctx = new EndExpressionContext(_parentctx, _parentState, _p);
						_localctx.end = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_endExpression);
						setState(468);
						if (!(6 >= _localctx._p)) throw new FailedPredicateException(this, "6 >= $_p");
						setState(469); match(SELECTION);
						setState(472);
						switch (_input.LA(1)) {
						case NAME:
							{
							setState(470); ((EndExpressionContext)_localctx).refName = refName();
							}
							break;
						case NUM:
							{
							setState(471); ((EndExpressionContext)_localctx).NUM = match(NUM);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}

						          		String n;
						          		if ((((EndExpressionContext)_localctx).refName!=null?_input.getText(((EndExpressionContext)_localctx).refName.start,((EndExpressionContext)_localctx).refName.stop):null) == null)
						          			n = (((EndExpressionContext)_localctx).NUM!=null?((EndExpressionContext)_localctx).NUM.getText():null);
						          		else
						          			n = (((EndExpressionContext)_localctx).refName!=null?_input.getText(((EndExpressionContext)_localctx).refName.start,((EndExpressionContext)_localctx).refName.stop):null);
						          			
						          		if (memory.get((((EndExpressionContext)_localctx).end!=null?_input.getText(((EndExpressionContext)_localctx).end.start,((EndExpressionContext)_localctx).end.stop):null) + "." + n) == null) {
						          		
						          			String eType = types.get((((EndExpressionContext)_localctx).end!=null?_input.getText(((EndExpressionContext)_localctx).end.start,((EndExpressionContext)_localctx).end.stop):null));
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
						          				memory.put((((EndExpressionContext)_localctx).end!=null?_input.getText(((EndExpressionContext)_localctx).end.start,((EndExpressionContext)_localctx).end.stop):null) + "." + n, newVarName);
						          				if (modoSetExpression != 0 )
						          					setExpressionVars.put((((EndExpressionContext)_localctx).end!=null?_input.getText(((EndExpressionContext)_localctx).end.start,((EndExpressionContext)_localctx).end.stop):null) + "." + n, newVarName);
						          				types.put((((EndExpressionContext)_localctx).end!=null?_input.getText(((EndExpressionContext)_localctx).end.start,((EndExpressionContext)_localctx).end.stop):null) + "." + n, type);
						          				print("nth1(" + position + "," + memory.get((((EndExpressionContext)_localctx).end!=null?_input.getText(((EndExpressionContext)_localctx).end.start,((EndExpressionContext)_localctx).end.stop):null)) + "," + newVarName + ")");
						          				
						          				typeInfo(newVarName, type);
						          				
						          			}
						          			else { //Se pide el elemento de una tupla
						          				String newVarName = newVar();
						          				memory.put((((EndExpressionContext)_localctx).end!=null?_input.getText(((EndExpressionContext)_localctx).end.start,((EndExpressionContext)_localctx).end.stop):null) + "." + n, newVarName);
						          				eType = childsTypes(eType).get(Integer.parseInt(n)-1);
						          				types.put((((EndExpressionContext)_localctx).end!=null?_input.getText(((EndExpressionContext)_localctx).end.start,((EndExpressionContext)_localctx).end.stop):null) + "." + n, eType); //Arreglar
						          				print("nth1(" + n + "," + memory.get((((EndExpressionContext)_localctx).end!=null?_input.getText(((EndExpressionContext)_localctx).end.start,((EndExpressionContext)_localctx).end.stop):null)) + "," + newVarName + ")");
						          			}
						          		}
						          	
						}
						break;

					case 2:
						{
						_localctx = new EndExpressionContext(_parentctx, _parentState, _p);
						_localctx.end = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_endExpression);
						setState(475);
						if (!(5 >= _localctx._p)) throw new FailedPredicateException(this, "5 >= $_p");
						setState(476); ((EndExpressionContext)_localctx).post = post();

						          		String a;
						          		a = memory.get((((EndExpressionContext)_localctx).end!=null?_input.getText(((EndExpressionContext)_localctx).end.start,((EndExpressionContext)_localctx).end.stop):null));
						          		String op = (((EndExpressionContext)_localctx).post!=null?_input.getText(((EndExpressionContext)_localctx).post.start,((EndExpressionContext)_localctx).post.stop):null);
						          		
						          		if (memory.get((((EndExpressionContext)_localctx).end!=null?_input.getText(((EndExpressionContext)_localctx).end.start,((EndExpressionContext)_localctx).end.stop):null) + op) == null) {
						          		
						          			String newVarName = newVar();
						          		
						          			if (op.startsWith("\\inv")){
						          				//Si a es una lista, debo convertirla
						          				a = convertToSet((((EndExpressionContext)_localctx).end!=null?_input.getText(((EndExpressionContext)_localctx).end.start,((EndExpressionContext)_localctx).end.stop):null), a);
						          			
						          				print("inv(" + newVarName + "," + a + ")");
						          				memory.put((((EndExpressionContext)_localctx).end!=null?_input.getText(((EndExpressionContext)_localctx).end.start,((EndExpressionContext)_localctx).end.stop):null) + op, newVarName);
						          				String type = types.get((((EndExpressionContext)_localctx).end!=null?_input.getText(((EndExpressionContext)_localctx).end.start,((EndExpressionContext)_localctx).end.stop):null));
						          				if (isSequence(getType(type)))
						          					type = "\\power(\\nat\\cross(" + childsTypes(type).get(1) + "))";
						          				type = invertType(type); 
						          				types.put((((EndExpressionContext)_localctx).end!=null?_input.getText(((EndExpressionContext)_localctx).end.start,((EndExpressionContext)_localctx).end.stop):null) + op, type);
						          				typeInfo(newVarName, type);
						          				if (modoSetExpression != 0 )
						          					setExpressionVars.put((((EndExpressionContext)_localctx).end!=null?_input.getText(((EndExpressionContext)_localctx).end.start,((EndExpressionContext)_localctx).end.stop):null) + op, newVarName);
						          			}
						          		}
						          	
						}
						break;
					}
					} 
				}
				setState(483);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
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
		enterRule(_localctx, 26, RULE_refName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(484); ((RefNameContext)_localctx).NAME = match(NAME);

					if (memory.get((((RefNameContext)_localctx).NAME!=null?((RefNameContext)_localctx).NAME.getText():null)) == null)
					{
						String newVarName = newVar((((RefNameContext)_localctx).NAME!=null?((RefNameContext)_localctx).NAME.getText():null));
						
						memory.put((((RefNameContext)_localctx).NAME!=null?((RefNameContext)_localctx).NAME.getText():null), newVarName);
						if (modoSetExpression != 0 ) {
							setExpressionVars.put((((RefNameContext)_localctx).NAME!=null?((RefNameContext)_localctx).NAME.getText():null), newVarName);
							//System.out.println("Agregamos" + (((RefNameContext)_localctx).NAME!=null?((RefNameContext)_localctx).NAME.getText():null) + "---" +  newVarName);
						}
					} else if (types.get((((RefNameContext)_localctx).NAME!=null?((RefNameContext)_localctx).NAME.getText():null)).startsWith("BasicConstant:")) { //Es una constante basica
						String line = (((RefNameContext)_localctx).NAME!=null?((RefNameContext)_localctx).NAME.getText():null) + " in " + (types.get((((RefNameContext)_localctx).NAME!=null?((RefNameContext)_localctx).NAME.getText():null)).split(":",2)[1]);
						if (!out.contains(line)) {
							print(line);
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

	public static class PostContext extends ParserRuleContext {
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
		enterRule(_localctx, 28, RULE_post);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(487); match(48);
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
		enterRule(_localctx, 30, RULE_pre);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(489);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 3) | (1L << 4) | (1L << 5) | (1L << 10) | (1L << 12) | (1L << 13) | (1L << 16) | (1L << 20) | (1L << 21) | (1L << 25) | (1L << 30) | (1L << 37) | (1L << 43) | (1L << 46) | (1L << 57) | (1L << 59))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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
		case 10: return predicate_sempred((PredicateContext)_localctx, predIndex);

		case 11: return expression_sempred((ExpressionContext)_localctx, predIndex);

		case 12: return endExpression_sempred((EndExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4: return 12 >= _localctx._p;

		case 5: return 11 >= _localctx._p;

		case 6: return 10 >= _localctx._p;

		case 7: return 9 >= _localctx._p;

		case 8: return 8 >= _localctx._p;

		case 9: return 7 >= _localctx._p;

		case 10: return 6 >= _localctx._p;

		case 11: return 5 >= _localctx._p;

		case 12: return 4 >= _localctx._p;

		case 13: return 3 >= _localctx._p;

		case 14: return 14 >= _localctx._p;

		case 15: return 2 >= _localctx._p;
		}
		return true;
	}
	private boolean endExpression_sempred(EndExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 17: return 5 >= _localctx._p;

		case 16: return 6 >= _localctx._p;
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
		"\2\3W\u01ee\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4"+
		"\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20"+
		"\4\21\t\21\3\2\3\2\7\2%\n\2\f\2\16\2(\13\2\6\2*\n\2\r\2\16\2+\3\2\3\2"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\5\3F\n\3\3\3\3\3\3\3\3\3\5\3L\n\3\3\3\3\3\3\3\5\3Q"+
		"\n\3\3\3\3\3\6\3U\n\3\r\3\16\3V\3\3\3\3\5\3[\n\3\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\7\4d\n\4\f\4\16\4g\13\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6"+
		"\3\6\3\6\3\6\5\6v\n\6\3\6\3\6\3\6\3\6\5\6|\n\6\7\6~\n\6\f\6\16\6\u0081"+
		"\13\6\3\6\3\6\3\7\3\7\3\7\3\7\5\7\u0089\n\7\3\7\3\7\5\7\u008d\n\7\3\7"+
		"\3\7\3\7\7\7\u0092\n\7\f\7\16\7\u0095\13\7\3\b\3\b\3\b\3\b\5\b\u009b\n"+
		"\b\3\t\3\t\3\t\7\t\u00a0\n\t\f\t\16\t\u00a3\13\t\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\7\n\u00ab\n\n\f\n\16\n\u00ae\13\n\3\n\3\n\3\n\3\n\3\13\3\13\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00c5\n\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f"+
		"\u010d\n\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\7\f\u011b\n"+
		"\f\f\f\16\f\u011e\13\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u012a"+
		"\n\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\7\r\u0168\n\r\f\r\16\r\u016b\13\r\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u0177\n\16\3\16"+
		"\3\16\3\16\3\16\7\16\u017d\n\16\f\16\16\16\u0180\13\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u018d\n\16\3\16\3\16\3\16"+
		"\3\16\3\16\5\16\u0194\n\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\5\16\u01a1\n\16\6\16\u01a3\n\16\r\16\16\16\u01a4\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\5\16\u01ae\n\16\3\16\3\16\3\16\3\16\7\16\u01b4"+
		"\n\16\f\16\16\16\u01b7\13\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\6\16\u01c2\n\16\r\16\16\16\u01c3\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u01d5\n\16\3\16\3\16\3\16"+
		"\3\16\5\16\u01db\n\16\3\16\3\16\3\16\3\16\3\16\7\16\u01e2\n\16\f\16\16"+
		"\16\u01e5\13\16\3\17\3\17\3\17\3\20\3\20\3\21\3\21\3\21\2\22\2\4\6\b\n"+
		"\f\16\20\22\24\26\30\32\34\36 \2\4\4::OO\16\5\7\f\f\16\17\22\22\26\27"+
		"\33\33  \'\'--\60\60;;==\u022a\2)\3\2\2\2\4Z\3\2\2\2\6\\\3\2\2\2\bk\3"+
		"\2\2\2\np\3\2\2\2\f\u0084\3\2\2\2\16\u0096\3\2\2\2\20\u009c\3\2\2\2\22"+
		"\u00a4\3\2\2\2\24\u00b3\3\2\2\2\26\u010c\3\2\2\2\30\u0129\3\2\2\2\32\u01d4"+
		"\3\2\2\2\34\u01e6\3\2\2\2\36\u01e9\3\2\2\2 \u01eb\3\2\2\2\"&\5\4\3\2#"+
		"%\7O\2\2$#\3\2\2\2%(\3\2\2\2&$\3\2\2\2&\'\3\2\2\2\'*\3\2\2\2(&\3\2\2\2"+
		")\"\3\2\2\2*+\3\2\2\2+)\3\2\2\2+,\3\2\2\2,-\3\2\2\2-.\b\2\1\2.\3\3\2\2"+
		"\2/\60\7\64\2\2\60\61\7\3\2\2\61\62\7)\2\2\62\63\7M\2\2\63\64\7\20\2\2"+
		"\64\65\5\f\7\2\65\66\7$\2\2\66\67\7\3\2\2\678\7\20\2\28[\3\2\2\29:\7\64"+
		"\2\2:;\78\2\2;<\b\3\1\2<=\7)\2\2=>\7M\2\2>?\7\20\2\2?@\5\16\b\2@A\b\3"+
		"\1\2AE\7$\2\2BF\7\3\2\2CD\78\2\2DF\b\3\1\2EB\3\2\2\2EC\3\2\2\2FG\3\2\2"+
		"\2GH\7\20\2\2H[\3\2\2\2IK\7>\2\2JL\7O\2\2KJ\3\2\2\2KL\3\2\2\2LT\3\2\2"+
		"\2MQ\5\6\4\2NQ\5\b\5\2OQ\5\n\6\2PM\3\2\2\2PN\3\2\2\2PO\3\2\2\2QR\3\2\2"+
		"\2RS\7O\2\2SU\3\2\2\2TP\3\2\2\2UV\3\2\2\2VT\3\2\2\2VW\3\2\2\2WX\3\2\2"+
		"\2XY\7.\2\2Y[\3\2\2\2Z/\3\2\2\2Z9\3\2\2\2ZI\3\2\2\2[\5\3\2\2\2\\]\7\b"+
		"\2\2]^\5\24\13\2^e\b\4\1\2_`\7(\2\2`a\5\24\13\2ab\b\4\1\2bd\3\2\2\2c_"+
		"\3\2\2\2dg\3\2\2\2ec\3\2\2\2ef\3\2\2\2fh\3\2\2\2ge\3\2\2\2hi\7&\2\2ij"+
		"\b\4\1\2j\7\3\2\2\2kl\5\24\13\2lm\7@\2\2mn\5\30\r\2no\b\5\1\2o\t\3\2\2"+
		"\2pq\5\24\13\2qr\7!\2\2rs\5\24\13\2su\b\6\1\2tv\5\30\r\2ut\3\2\2\2uv\3"+
		"\2\2\2v\177\3\2\2\2wx\7#\2\2xy\5\24\13\2y{\b\6\1\2z|\5\30\r\2{z\3\2\2"+
		"\2{|\3\2\2\2|~\3\2\2\2}w\3\2\2\2~\u0081\3\2\2\2\177}\3\2\2\2\177\u0080"+
		"\3\2\2\2\u0080\u0082\3\2\2\2\u0081\177\3\2\2\2\u0082\u0083\b\6\1\2\u0083"+
		"\13\3\2\2\2\u0084\u0088\7O\2\2\u0085\u0086\5\20\t\2\u0086\u0087\7O\2\2"+
		"\u0087\u0089\3\2\2\2\u0088\u0085\3\2\2\2\u0088\u0089\3\2\2\2\u0089\u008c"+
		"\3\2\2\2\u008a\u008b\7\36\2\2\u008b\u008d\7O\2\2\u008c\u008a\3\2\2\2\u008c"+
		"\u008d\3\2\2\2\u008d\u0093\3\2\2\2\u008e\u008f\5\26\f\2\u008f\u0090\7"+
		"O\2\2\u0090\u0092\3\2\2\2\u0091\u008e\3\2\2\2\u0092\u0095\3\2\2\2\u0093"+
		"\u0091\3\2\2\2\u0093\u0094\3\2\2\2\u0094\r\3\2\2\2\u0095\u0093\3\2\2\2"+
		"\u0096\u009a\7O\2\2\u0097\u0098\5\20\t\2\u0098\u0099\7O\2\2\u0099\u009b"+
		"\3\2\2\2\u009a\u0097\3\2\2\2\u009a\u009b\3\2\2\2\u009b\17\3\2\2\2\u009c"+
		"\u00a1\5\22\n\2\u009d\u009e\t\2\2\2\u009e\u00a0\5\22\n\2\u009f\u009d\3"+
		"\2\2\2\u00a0\u00a3\3\2\2\2\u00a1\u009f\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2"+
		"\21\3\2\2\2\u00a3\u00a1\3\2\2\2\u00a4\u00a5\5\24\13\2\u00a5\u00ac\b\n"+
		"\1\2\u00a6\u00a7\7(\2\2\u00a7\u00a8\5\24\13\2\u00a8\u00a9\b\n\1\2\u00a9"+
		"\u00ab\3\2\2\2\u00aa\u00a6\3\2\2\2\u00ab\u00ae\3\2\2\2\u00ac\u00aa\3\2"+
		"\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00af\3\2\2\2\u00ae\u00ac\3\2\2\2\u00af"+
		"\u00b0\7+\2\2\u00b0\u00b1\5\30\r\2\u00b1\u00b2\b\n\1\2\u00b2\23\3\2\2"+
		"\2\u00b3\u00b4\7M\2\2\u00b4\25\3\2\2\2\u00b5\u00b6\b\f\1\2\u00b6\u00b7"+
		"\5\30\r\2\u00b7\u00b8\7/\2\2\u00b8\u00b9\5\30\r\2\u00b9\u00ba\b\f\1\2"+
		"\u00ba\u010d\3\2\2\2\u00bb\u00bc\5\30\r\2\u00bc\u00bd\7\21\2\2\u00bd\u00be"+
		"\5\30\r\2\u00be\u00c5\3\2\2\2\u00bf\u00c0\7\4\2\2\u00c0\u00c1\5\30\r\2"+
		"\u00c1\u00c2\7/\2\2\u00c2\u00c3\5\30\r\2\u00c3\u00c5\3\2\2\2\u00c4\u00bb"+
		"\3\2\2\2\u00c4\u00bf\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6\u00c7\b\f\1\2\u00c7"+
		"\u010d\3\2\2\2\u00c8\u00c9\5\30\r\2\u00c9\u00ca\7\t\2\2\u00ca\u00cb\5"+
		"\30\r\2\u00cb\u00cc\b\f\1\2\u00cc\u010d\3\2\2\2\u00cd\u00ce\5\30\r\2\u00ce"+
		"\u00cf\7<\2\2\u00cf\u00d0\5\30\r\2\u00d0\u00d1\b\f\1\2\u00d1\u010d\3\2"+
		"\2\2\u00d2\u00d3\5\30\r\2\u00d3\u00d4\7\31\2\2\u00d4\u00d5\5\30\r\2\u00d5"+
		"\u00d6\b\f\1\2\u00d6\u010d\3\2\2\2\u00d7\u00d8\5\30\r\2\u00d8\u00d9\7"+
		"\37\2\2\u00d9\u00da\5\30\r\2\u00da\u00db\b\f\1\2\u00db\u010d\3\2\2\2\u00dc"+
		"\u00dd\5\30\r\2\u00dd\u00de\7\30\2\2\u00de\u00df\5\30\r\2\u00df\u00e0"+
		"\b\f\1\2\u00e0\u010d\3\2\2\2\u00e1\u00e2\5\30\r\2\u00e2\u00e3\7\"\2\2"+
		"\u00e3\u00e4\5\30\r\2\u00e4\u00e5\b\f\1\2\u00e5\u010d\3\2\2\2\u00e6\u00e7"+
		"\7\4\2\2\u00e7\u00e8\5\30\r\2\u00e8\u00e9\7\"\2\2\u00e9\u00ea\5\30\r\2"+
		"\u00ea\u00eb\b\f\1\2\u00eb\u010d\3\2\2\2\u00ec\u00ed\5\30\r\2\u00ed\u00ee"+
		"\7\66\2\2\u00ee\u00ef\5\30\r\2\u00ef\u00f0\b\f\1\2\u00f0\u010d\3\2\2\2"+
		"\u00f1\u00f2\7\4\2\2\u00f2\u00f3\5\30\r\2\u00f3\u00f4\7\66\2\2\u00f4\u00f5"+
		"\5\30\r\2\u00f5\u00f6\b\f\1\2\u00f6\u010d\3\2\2\2\u00f7\u00f8\5\30\r\2"+
		"\u00f8\u00f9\7\35\2\2\u00f9\u00fa\5\30\r\2\u00fa\u00fb\b\f\1\2\u00fb\u010d"+
		"\3\2\2\2\u00fc\u00fd\5\30\r\2\u00fd\u00fe\7\32\2\2\u00fe\u00ff\5\30\r"+
		"\2\u00ff\u0100\b\f\1\2\u0100\u010d\3\2\2\2\u0101\u0102\5\30\r\2\u0102"+
		"\u0103\7%\2\2\u0103\u0104\5\30\r\2\u0104\u0105\b\f\1\2\u0105\u010d\3\2"+
		"\2\2\u0106\u0107\7*\2\2\u0107\u0108\5\26\f\2\u0108\u0109\7\24\2\2\u0109"+
		"\u010d\3\2\2\2\u010a\u010d\7\63\2\2\u010b\u010d\7\n\2\2\u010c\u00b5\3"+
		"\2\2\2\u010c\u00c4\3\2\2\2\u010c\u00c8\3\2\2\2\u010c\u00cd\3\2\2\2\u010c"+
		"\u00d2\3\2\2\2\u010c\u00d7\3\2\2\2\u010c\u00dc\3\2\2\2\u010c\u00e1\3\2"+
		"\2\2\u010c\u00e6\3\2\2\2\u010c\u00ec\3\2\2\2\u010c\u00f1\3\2\2\2\u010c"+
		"\u00f7\3\2\2\2\u010c\u00fc\3\2\2\2\u010c\u0101\3\2\2\2\u010c\u0106\3\2"+
		"\2\2\u010c\u010a\3\2\2\2\u010c\u010b\3\2\2\2\u010d\u011c\3\2\2\2\u010e"+
		"\u010f\6\f\2\3\u010f\u0110\7\67\2\2\u0110\u011b\5\26\f\2\u0111\u0112\6"+
		"\f\3\3\u0112\u0113\79\2\2\u0113\u011b\5\26\f\2\u0114\u0115\6\f\4\3\u0115"+
		"\u0116\7,\2\2\u0116\u011b\5\26\f\2\u0117\u0118\6\f\5\3\u0118\u0119\7\23"+
		"\2\2\u0119\u011b\5\26\f\2\u011a\u010e\3\2\2\2\u011a\u0111\3\2\2\2\u011a"+
		"\u0114\3\2\2\2\u011a\u0117\3\2\2\2\u011b\u011e\3\2\2\2\u011c\u011a\3\2"+
		"\2\2\u011c\u011d\3\2\2\2\u011d\27\3\2\2\2\u011e\u011c\3\2\2\2\u011f\u0120"+
		"\b\r\1\2\u0120\u0121\5 \21\2\u0121\u0122\5\30\r\2\u0122\u0123\b\r\1\2"+
		"\u0123\u012a\3\2\2\2\u0124\u0125\7B\2\2\u0125\u0126\5\30\r\2\u0126\u0127"+
		"\b\r\1\2\u0127\u012a\3\2\2\2\u0128\u012a\5\32\16\2\u0129\u011f\3\2\2\2"+
		"\u0129\u0124\3\2\2\2\u0129\u0128\3\2\2\2\u012a\u0169\3\2\2\2\u012b\u012c"+
		"\6\r\6\3\u012c\u012d\7A\2\2\u012d\u012e\5\30\r\2\u012e\u012f\b\r\1\2\u012f"+
		"\u0168\3\2\2\2\u0130\u0131\6\r\7\3\u0131\u0132\7C\2\2\u0132\u0133\5\30"+
		"\r\2\u0133\u0134\b\r\1\2\u0134\u0168\3\2\2\2\u0135\u0136\6\r\b\3\u0136"+
		"\u0137\7D\2\2\u0137\u0138\5\30\r\2\u0138\u0139\b\r\1\2\u0139\u0168\3\2"+
		"\2\2\u013a\u013b\6\r\t\3\u013b\u013c\7E\2\2\u013c\u013d\5\30\r\2\u013d"+
		"\u013e\b\r\1\2\u013e\u0168\3\2\2\2\u013f\u0140\6\r\n\3\u0140\u0141\7F"+
		"\2\2\u0141\u0142\5\30\r\2\u0142\u0143\b\r\1\2\u0143\u0168\3\2\2\2\u0144"+
		"\u0145\6\r\13\3\u0145\u0146\7G\2\2\u0146\u0147\5\30\r\2\u0147\u0148\b"+
		"\r\1\2\u0148\u0168\3\2\2\2\u0149\u014a\6\r\f\3\u014a\u014b\7H\2\2\u014b"+
		"\u014c\5\30\r\2\u014c\u014d\b\r\1\2\u014d\u0168\3\2\2\2\u014e\u014f\6"+
		"\r\r\3\u014f\u0150\7I\2\2\u0150\u0151\5\30\r\2\u0151\u0152\b\r\1\2\u0152"+
		"\u0168\3\2\2\2\u0153\u0154\6\r\16\3\u0154\u0155\7J\2\2\u0155\u0156\5\30"+
		"\r\2\u0156\u0157\b\r\1\2\u0157\u0168\3\2\2\2\u0158\u0159\6\r\17\3\u0159"+
		"\u015a\7K\2\2\u015a\u015b\5\30\r\2\u015b\u015c\b\r\1\2\u015c\u0168\3\2"+
		"\2\2\u015d\u015e\6\r\20\3\u015e\u015f\5\32\16\2\u015f\u0160\b\r\1\2\u0160"+
		"\u0168\3\2\2\2\u0161\u0162\6\r\21\3\u0162\u0163\7U\2\2\u0163\u0164\5\30"+
		"\r\2\u0164\u0165\7V\2\2\u0165\u0166\b\r\1\2\u0166\u0168\3\2\2\2\u0167"+
		"\u012b\3\2\2\2\u0167\u0130\3\2\2\2\u0167\u0135\3\2\2\2\u0167\u013a\3\2"+
		"\2\2\u0167\u013f\3\2\2\2\u0167\u0144\3\2\2\2\u0167\u0149\3\2\2\2\u0167"+
		"\u014e\3\2\2\2\u0167\u0153\3\2\2\2\u0167\u0158\3\2\2\2\u0167\u015d\3\2"+
		"\2\2\u0167\u0161\3\2\2\2\u0168\u016b\3\2\2\2\u0169\u0167\3\2\2\2\u0169"+
		"\u016a\3\2\2\2\u016a\31\3\2\2\2\u016b\u0169\3\2\2\2\u016c\u016d\b\16\1"+
		"\2\u016d\u01d5\5\34\17\2\u016e\u016f\7N\2\2\u016f\u01d5\b\16\1\2\u0170"+
		"\u0171\7\r\2\2\u0171\u01d5\b\16\1\2\u0172\u0176\7Q\2\2\u0173\u0174\5\30"+
		"\r\2\u0174\u0175\b\16\1\2\u0175\u0177\3\2\2\2\u0176\u0173\3\2\2\2\u0176"+
		"\u0177\3\2\2\2\u0177\u017e\3\2\2\2\u0178\u0179\7(\2\2\u0179\u017a\5\30"+
		"\r\2\u017a\u017b\b\16\1\2\u017b\u017d\3\2\2\2\u017c\u0178\3\2\2\2\u017d"+
		"\u0180\3\2\2\2\u017e\u017c\3\2\2\2\u017e\u017f\3\2\2\2\u017f\u0181\3\2"+
		"\2\2\u0180\u017e\3\2\2\2\u0181\u0182\7R\2\2\u0182\u01d5\b\16\1\2\u0183"+
		"\u0184\7Q\2\2\u0184\u0185\b\16\1\2\u0185\u0186\5\20\t\2\u0186\u018c\b"+
		"\16\1\2\u0187\u0188\7#\2\2\u0188\u0189\b\16\1\2\u0189\u018a\5\26\f\2\u018a"+
		"\u018b\b\16\1\2\u018b\u018d\3\2\2\2\u018c\u0187\3\2\2\2\u018c\u018d\3"+
		"\2\2\2\u018d\u0193\3\2\2\2\u018e\u018f\7\25\2\2\u018f\u0190\b\16\1\2\u0190"+
		"\u0191\5\30\r\2\u0191\u0192\b\16\1\2\u0192\u0194\3\2\2\2\u0193\u018e\3"+
		"\2\2\2\u0193\u0194\3\2\2\2\u0194\u0195\3\2\2\2\u0195\u0196\7R\2\2\u0196"+
		"\u0197\b\16\1\2\u0197\u0198\b\16\1\2\u0198\u01d5\3\2\2\2\u0199\u019a\7"+
		"\65\2\2\u019a\u01a2\b\16\1\2\u019b\u019c\7M\2\2\u019c\u019d\7@\2\2\u019d"+
		"\u019e\5\30\r\2\u019e\u01a0\b\16\1\2\u019f\u01a1\7(\2\2\u01a0\u019f\3"+
		"\2\2\2\u01a0\u01a1\3\2\2\2\u01a1\u01a3\3\2\2\2\u01a2\u019b\3\2\2\2\u01a3"+
		"\u01a4\3\2\2\2\u01a4\u01a2\3\2\2\2\u01a4\u01a5\3\2\2\2\u01a5\u01a6\3\2"+
		"\2\2\u01a6\u01a7\7\61\2\2\u01a7\u01a8\b\16\1\2\u01a8\u01d5\3\2\2\2\u01a9"+
		"\u01ad\7S\2\2\u01aa\u01ab\5\30\r\2\u01ab\u01ac\b\16\1\2\u01ac\u01ae\3"+
		"\2\2\2\u01ad\u01aa\3\2\2\2\u01ad\u01ae\3\2\2\2\u01ae\u01b5\3\2\2\2\u01af"+
		"\u01b0\7(\2\2\u01b0\u01b1\5\30\r\2\u01b1\u01b2\b\16\1\2\u01b2\u01b4\3"+
		"\2\2\2\u01b3\u01af\3\2\2\2\u01b4\u01b7\3\2\2\2\u01b5\u01b3\3\2\2\2\u01b5"+
		"\u01b6\3\2\2\2\u01b6\u01b8\3\2\2\2\u01b7\u01b5\3\2\2\2\u01b8\u01b9\7T"+
		"\2\2\u01b9\u01d5\b\16\1\2\u01ba\u01bb\7*\2\2\u01bb\u01bc\5\30\r\2\u01bc"+
		"\u01c1\b\16\1\2\u01bd\u01be\7(\2\2\u01be\u01bf\5\30\r\2\u01bf\u01c0\b"+
		"\16\1\2\u01c0\u01c2\3\2\2\2\u01c1\u01bd\3\2\2\2\u01c2\u01c3\3\2\2\2\u01c3"+
		"\u01c1\3\2\2\2\u01c3\u01c4\3\2\2\2\u01c4\u01c5\3\2\2\2\u01c5\u01c6\7\24"+
		"\2\2\u01c6\u01c7\b\16\1\2\u01c7\u01d5\3\2\2\2\u01c8\u01c9\7*\2\2\u01c9"+
		"\u01ca\5\30\r\2\u01ca\u01cb\7\24\2\2\u01cb\u01cc\b\16\1\2\u01cc\u01d5"+
		"\3\2\2\2\u01cd\u01ce\7\34\2\2\u01ce\u01cf\7\13\2\2\u01cf\u01d5\b\16\1"+
		"\2\u01d0\u01d1\7\34\2\2\u01d1\u01d5\b\16\1\2\u01d2\u01d3\7?\2\2\u01d3"+
		"\u01d5\b\16\1\2\u01d4\u016c\3\2\2\2\u01d4\u016e\3\2\2\2\u01d4\u0170\3"+
		"\2\2\2\u01d4\u0172\3\2\2\2\u01d4\u0183\3\2\2\2\u01d4\u0199\3\2\2\2\u01d4"+
		"\u01a9\3\2\2\2\u01d4\u01ba\3\2\2\2\u01d4\u01c8\3\2\2\2\u01d4\u01cd\3\2"+
		"\2\2\u01d4\u01d0\3\2\2\2\u01d4\u01d2\3\2\2\2\u01d5\u01e3\3\2\2\2\u01d6"+
		"\u01d7\6\16\22\3\u01d7\u01da\7L\2\2\u01d8\u01db\5\34\17\2\u01d9\u01db"+
		"\7N\2\2\u01da\u01d8\3\2\2\2\u01da\u01d9\3\2\2\2\u01db\u01dc\3\2\2\2\u01dc"+
		"\u01e2\b\16\1\2\u01dd\u01de\6\16\23\3\u01de\u01df\5\36\20\2\u01df\u01e0"+
		"\b\16\1\2\u01e0\u01e2\3\2\2\2\u01e1\u01d6\3\2\2\2\u01e1\u01dd\3\2\2\2"+
		"\u01e2\u01e5\3\2\2\2\u01e3\u01e1\3\2\2\2\u01e3\u01e4\3\2\2\2\u01e4\33"+
		"\3\2\2\2\u01e5\u01e3\3\2\2\2\u01e6\u01e7\7M\2\2\u01e7\u01e8\b\17\1\2\u01e8"+
		"\35\3\2\2\2\u01e9\u01ea\7\62\2\2\u01ea\37\3\2\2\2\u01eb\u01ec\t\3\2\2"+
		"\u01ec!\3\2\2\2\'&+EKPVZeu{\177\u0088\u008c\u0093\u009a\u00a1\u00ac\u00c4"+
		"\u010c\u011a\u011c\u0129\u0167\u0169\u0176\u017e\u018c\u0193\u01a0\u01a4"+
		"\u01ad\u01b5\u01c3\u01d4\u01da\u01e1\u01e3";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}