// Generated from /home/cristian/workspace/fastest/Fastest/src/main/java/compserver/tcasegen/strategies/setlog/ztosetlog/Expr.g4 by ANTLR 4.5.1
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
	

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ExprLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, T__40=41, T__41=42, T__42=43, T__43=44, T__44=45, 
		T__45=46, T__46=47, T__47=48, T__48=49, T__49=50, T__50=51, T__51=52, 
		T__52=53, T__53=54, T__54=55, T__55=56, T__56=57, T__57=58, T__58=59, 
		T__59=60, T__60=61, T__61=62, CROSS=63, POWER=64, IN_FUN_65=65, IN_FUN_60=66, 
		IN_FUN_50=67, IN_FUN_45=68, IN_FUN_40=69, IN_FUN_30=70, IN_FUN_20=71, 
		IN_FUN_10=72, IN_FUN_5=73, SELECTION=74, NAME=75, NUM=76, NL=77, WS=78, 
		SETSTART=79, SETEND=80, LISTSTART=81, LISTEND=82, IMGSTART=83, IMGEND=84, 
		SKIP=85;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
		"T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "T__23", "T__24", 
		"T__25", "T__26", "T__27", "T__28", "T__29", "T__30", "T__31", "T__32", 
		"T__33", "T__34", "T__35", "T__36", "T__37", "T__38", "T__39", "T__40", 
		"T__41", "T__42", "T__43", "T__44", "T__45", "T__46", "T__47", "T__48", 
		"T__49", "T__50", "T__51", "T__52", "T__53", "T__54", "T__55", "T__56", 
		"T__57", "T__58", "T__59", "T__60", "T__61", "CROSS", "POWER", "IN_FUN_65", 
		"IN_FUN_60", "IN_FUN_50", "IN_FUN_45", "IN_FUN_40", "IN_FUN_30", "IN_FUN_20", 
		"IN_FUN_10", "IN_FUN_5", "SELECTION", "NAME", "NUM", "NL", "WS", "SETSTART", 
		"SETEND", "LISTSTART", "LISTEND", "IMGSTART", "IMGEND", "SKIP"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'\\begin{'", "'schema'", "'}{'", "'}'", "'\\end{'", "'schemaType'", 
		"'\\begin{zed}'", "'\\end{zed}'", "'['", "','", "']'", "'=='", "'::='", 
		"'|'", "'\\where'", "';'", "':'", "'\\in'", "'\\notin'", "'\\lnot'", "'<'", 
		"'>'", "'\\leq'", "'\\geq'", "'='", "'\\subseteq'", "'\\subset'", "'\\neq'", 
		"'\\prefix'", "'\\suffix'", "'('", "')'", "'true'", "'false'", "'\\iff'", 
		"'\\implies'", "'\\lor'", "'\\land'", "'\\emptyset'", "'@'", "'\\lblot'", 
		"'\\rblot'", "'\\nat'", "'_{1}'", "'\\num'", "'\\inv'", "'\\negate'", 
		"'\\ran'", "'\\dom'", "'seq_{1}'", "'\\seq'", "'\\#'", "'\\bigcup'", "'\\bigcap'", 
		"'max'", "'min'", "'rev'", "'head'", "'last'", "'tail'", "'front'", "'squash'", 
		"'\\cross'", null, null, null, null, null, null, null, null, null, null, 
		"'.'", null, null, null, null, "'\\{'", "'\\}'", "'\\langle'", "'\\rangle'", 
		"'\\limg'", "'\\rimg'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, "CROSS", "POWER", "IN_FUN_65", "IN_FUN_60", "IN_FUN_50", 
		"IN_FUN_45", "IN_FUN_40", "IN_FUN_30", "IN_FUN_20", "IN_FUN_10", "IN_FUN_5", 
		"SELECTION", "NAME", "NUM", "NL", "WS", "SETSTART", "SETEND", "LISTSTART", 
		"LISTEND", "IMGSTART", "IMGEND", "SKIP"
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

		int num_inf = -2147483648;
		int num_sup = 2147483647;	
		int nat_inf = 0;
		int nat_sup = 2147483647;
		int nat1_inf = 1;
		int nat1_sup = 2147483647;
		
		//
		//  Sets basic axiomatic definitions, so they are used as values and not as variables
		//
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
		
		//
		//  Returns the output that is passed to setlog.
		//
		public String getSalida() {
			return out.concat(functionsOut);
		}
		
		//
		//  Returns 'memory', the hash map where all the name translations are stored.
		//
		public HashMap<String,String> getMemory() {
			return memory;
		}
		
		//
		//  Returns 'types', the hash map where all the expression types are stored.
		//
		public HashMap<String,String> getTypes() {
			return types;
		}
		
		//
		//  Returns 'zVars', the hash map where all the Z variables that has to be fulled with a value are stored.
		//
		public HashMap<String,String> getZVars() {
			return zVars;
		}

		//
		//  Metodo principal para imprimir normalmente una linea de entrada para setlog.
		//
		public void print(String c) {
			//Si no estamos dentro de una expression de conjuntos o tipo esquema,
			//concatenamos en la salida normal
			if (modoSetExpression == 0 && tipoSchema == 0) { 
				out = out.concat(c + " & ");
			}
			//Y sino, concatenamos en la variable auxiliar correspondiente
			else if (modoSetExpression == 1)
				setExpressionDecl = setExpressionDecl.concat(" & " + c);
			else if (modoSetExpression == 2)
				setExpressionPred = setExpressionPred.concat(" & " + c);
			else if (modoSetExpression == 3)
				setExpressionExpr = setExpressionExpr.concat(" & " + c);
		}
		
		//
		//  Este metodo se utiliza para imprimir informacion de tipo de una variable: is_pfun, is_rel, etc
		//  ya que debe ir al final de todo
		//
		public void printAtEnd(String c) {
			//Si no estamos dentro de una expression de conjuntos o tipo esquema,
			//concatenamos en la salida normal
			if (modoSetExpression == 0 && tipoSchema == 0) 
				functionsOut = functionsOut.concat(c + " & ");
			//Y sino, concatenamos en la variable auxiliar correspondiente
			else if (modoSetExpression == 1)
				setExpressionDecl = setExpressionDecl.concat(" & " + c);
			else if (modoSetExpression == 2)
				setExpressionPred = setExpressionPred.concat(" & " + c);
			else if (modoSetExpression == 3)
				setExpressionExpr = setExpressionExpr.concat(" & " + c);
		}
		
		//
		//  Metodo para la determinacion del tipo de nodo mas externo de un tipo.
		//  Ej:  type = A \cross B ----> return \cross
		//
		String getType(String type) {
			//El calculo se realiza mediante la construccion del arbol de tipos con la gramatica TypeManager
			ANTLRInputStream input = new ANTLRInputStream(type);
	        TypeManagerLexer lexer = new TypeManagerLexer(input);
	        CommonTokenStream tokens = new CommonTokenStream(lexer);
	        TypeManagerParser parser = new TypeManagerParser(tokens);
	        parser.typeManage();
	        DefaultMutableTreeNode root = parser.getRoot();
	        
	        //root es la raiz del arbol, como puede contener parentesis, los elimino
	        while (((String) root.getUserObject()).equals("()")) {
	        	root = (DefaultMutableTreeNode) root.getChildAt(0);
	        }
	        
	        //se retorna la informacion de la raiz
	        return (String) root.getUserObject();
		}
		
		//
		//  Metodo para quitar los parentesis exteriores en expresiones de tipo.
		//
		String removeParenthesis(String type) {
			//El calculo se realiza mediante la construccion del arbol de tipos con la gramatica TypeManager
			ANTLRInputStream input = new ANTLRInputStream(type);
	        TypeManagerLexer lexer = new TypeManagerLexer(input);
	        CommonTokenStream tokens = new CommonTokenStream(lexer);
	        TypeManagerParser parser = new TypeManagerParser(tokens);
	        parser.typeManage();
	        DefaultMutableTreeNode root = parser.getRoot();
	        
	        //root es la raiz del arbol, como puede contener parentesis, los elimino
	        while (((String) root.getUserObject()).equals("()")) {
	        	root = (DefaultMutableTreeNode) root.getChildAt(0);
	        }
	        
	        //se retorna una impresion del arbol entero
	        return parser.printTree(root);
		}
		
		//
		//  Metodo para la determinacion del tipo de un hijo de una expresion.
		//
		String getChildType(String type, int pos) {
			//El calculo se realiza mediante la construccion del arbol de tipos con la gramatica TypeManager
			ANTLRInputStream input = new ANTLRInputStream(type);
	        TypeManagerLexer lexer = new TypeManagerLexer(input);
	        CommonTokenStream tokens = new CommonTokenStream(lexer);
	        TypeManagerParser parser = new TypeManagerParser(tokens);
	        parser.typeManage();
	        DefaultMutableTreeNode root = parser.getRoot();
	        
	        //si tiene parentesis se eliminan
	        while (((String) root.getUserObject()).equals("()")) {
	        	root = (DefaultMutableTreeNode) root.getChildAt(0);
	        }
	        
	        DefaultMutableTreeNode child = (DefaultMutableTreeNode) root.getChildAt(pos);
	        
	        while (((String) child.getUserObject()).equals("()")) {
	        	child = (DefaultMutableTreeNode) child.getChildAt(0);
	        }
	        
	        //se retorna la impresion del hijo correspondiente
	        return parser.printTree(child);
		}
		
		//
		//  Metodo para obtener los tipos de los hijos.
		//  Se usa para unificar los tipos de funciones, conjuntos y secuencias
		//  Acepta solo: A \pfun B
		//               \power (A cross) B
		//               \seq A
		//               A \cross B 
		//
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
				
				if (childType.equals("\\cross")) { //Cambiar para multiples cross?
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
		
		//
		//  Metodo para realizar la inversion de un tipo en Z.
		//
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
		
		//
		//  Metodo para crear un nuevo nombre de variable
		//
		private String newVar() {
			String newVarName = "VAR" + varNumber;
			varNumber++;
			return newVarName;
		}
		
		//
		//  Metodo para crear un nuevo nombre de variable partiendo de un nombre en Z
		//
		private String newVar(String zName) {
			String newVarName = zName.substring(0,1).toUpperCase() + zName.substring(1).replace("?","");
			if (memory.containsValue(newVarName)) { 
				newVarName = "VAR" + varNumber;
				varNumber++;
			}
			return newVarName;
		}
		
		///////////////////////////////
		//private String readType(String type) {
		//	String readedType = types.get(type);
		//	if (readedType == null)
		//		readedType = types.get("(" + type + ")");
		//	return readedType;
		//	
		//}
		
		//
		//  Metodo para obtener e imprimir informacion de tipo de una variable
		//
		private String typeInfo(String var, String type) {
			return typeInfo(var, type, "");
		}
		
		//
		//  Metodo para obtener e imprimir informacion de tipo de una variable
		//
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
				
				if (nodeType.equals("\\cross")) {
						return type;
					}
				else if (isSequence(nodeType)){
					if (tipoSchema == 0) {
						if (nodeType.startsWith("seq_{1}"))
							print(var + " neq []");
						printAtEnd("list(" + var + ")");
						
						//Inicio regla que Maxi tiene duda
						//Imprimimos informacion sobre la cardinalidad
						//Primero buscamos el nombre de la variable
						//String zVar = getKey(var, memory); //Nombre de la variable en Z
						//Si nunca vimos el cardinal, lo buscamos ahora
						//String cardVar = memory.get("\\#"+zVar);
						//if (cardVar == null) {
						//	cardVar = newVar();
						//	memory.put("\\#"+zVar, cardVar);
						//	types.put("\\#"+zVar,"\\nat");
						//}
						//Buscamos NAT
						//String nat = printInfo("\\nat", true);
						//Imprimimos la info
						//print("solve(" + cardVar + " ein " + nat + ") & length(" + var + "," + cardVar + ")");
						
						
						//Tambien imprimimos informacion sobre su rango
						//Obtenemos el rango de la variable
				    	String zRanTypeName = getChildType(type,0);
				    	String zRanType = types.get(zRanTypeName);
				    	String zVar = getKey(var, memory); //Nombre de la variable en Z
				    	if (zRanType != null && zRanType.startsWith("EnumerationType")){
				    		String ran = memory.get("\\ran" + zVar);
				    		//verificamos si ya creamos una variable para el dominio,
				    		//y sino creamos una
				    		if (ran == null && zVar != null){
								ran = newVar();
								memory.put("\\ran" + zVar, ran);
								types.put("\\ran" + zVar, "\\power(" + zRanType + ")");
				    			print("list_to_set(" + var + "," + ran + ")");
							}
							print("dsubset(" + ran + "," + zRanTypeName + ")");
				    	}
					}
				}
				else if (nodeType.equals("\\rel")) {
					if (tipoSchema == 0) {
						printAtEnd("is_rel(" + var + ")");
						
						//Tambien imprimimos informacion sobre su rango y dominio
						
						//Empezamos por el dominio
						//Obtenemos el dominio de la variable
				    	String zDomTypeName = getChildType(type,0);
				    	String zDomType = types.get(zDomTypeName);
				    	String zVar = getKey(var, memory); //Nombre de la variable en Z
				    	if (zDomType != null && zDomType.startsWith("EnumerationType")){
				    		String dom = memory.get("\\dom" + zVar);
				    		//verificamos si ya creamos una variable para el dominio,
				    		//y sino creamos una
				    		if (dom == null && zVar != null){
								dom = newVar();
								memory.put("\\dom" + zVar, dom);
								types.put("\\dom" + zVar, "\\power(" + zDomType + ")");
				    			print("dom(" + var + "," + dom + ")");
							}
							print("dsubset(" + dom + "," + zDomTypeName + ")");
				    	}
				    	
				    	//Y luego lo mismo para el rango
				    	//Obtenemos el rango de la variable
				    	String zRanTypeName = getChildType(type,1);
				    	String zRanType = types.get(zRanTypeName);
				    	if (zRanType != null && zRanType.startsWith("EnumerationType")){
				    		String ran = memory.get("\\ran" + zVar);
				    		//verificamos si ya creamos una variable para el dominio,
				    		//y sino creamos una
				    		if (ran == null && zVar != null){
								ran = newVar();
								memory.put("\\ran" + zVar, ran);
								types.put("\\ran" + zVar, "\\power(" + zRanType + ")");
				    			print("ran(" + var + "," + ran + ")");
							}
							print("dsubset(" + ran + "," + zRanTypeName + ")");
				    	}		
					}
				}
				else if (nodeType.equals("\\pfun") || nodeType.equals("\\ffun")) {
					if (tipoSchema == 0) {
						printAtEnd("is_pfun(" + var + ")");
						
						//Tambien imprimimos informacion sobre su rango y dominio
						
						//Empezamos por el dominio
						//Obtenemos el dominio de la variable
				    	String zDomTypeName = getChildType(type,0);
				    	String zDomType = types.get(zDomTypeName);
				    	String zVar = getKey(var, memory); //Nombre de la variable en Z
				    	if (zDomType != null && zDomType.startsWith("EnumerationType")){
				    		String dom = memory.get("\\dom" + zVar);
				    		//verificamos si ya creamos una variable para el dominio,
				    		//y sino creamos una
				    		if (dom == null && zVar != null){
								dom = newVar();
								memory.put("\\dom" + zVar, dom);
								types.put("\\dom" + zVar, "\\power(" + zDomType + ")");
				    			print("dom(" + var + "," + dom + ")");
							}
							print("dsubset(" + dom + "," + zDomTypeName + ")");
				    	}
				    	
				    	//Y luego lo mismo para el rango
				    	//Obtenemos el rango de la variable
				    	String zRanTypeName = getChildType(type,1);
				    	String zRanType = types.get(zRanTypeName);
				    	if (zRanType != null && zRanType.startsWith("EnumerationType")){
				    		String ran = memory.get("\\ran" + zVar);
				    		//verificamos si ya creamos una variable para el dominio,
				    		//y sino creamos una
				    		if (ran == null && zVar != null){
								ran = newVar();
								memory.put("\\ran" + zVar, ran);
								types.put("\\ran" + zVar, "\\power(" + zRanType + ")");
				    			print("ran(" + var + "," + ran + ")");
							}
							print("dsubset(" + ran + "," + zRanTypeName + ")");
				    	}
					}
				}
				else if (nodeType.equals("\\fun")) {
				    if (tipoSchema == 0) {
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
						
						//Y luego trabajamos con el rango
				    	//Obtenemos el rango de la variable
				    	String zRanTypeName = getChildType(type,1);
				    	String zRanType = types.get(zRanTypeName);
				    	if (zRanType != null && zRanType.startsWith("EnumerationType")){
				    		String ran = memory.get("\\ran" + zVar);
				    		//verificamos si ya creamos una variable para el dominio,
				    		//y sino creamos una
				    		if (ran == null && zVar != null){
								ran = newVar();
								memory.put("\\ran" + zVar, ran);
								types.put("\\ran" + zVar, "\\power(" + zRanType + ")");
				    			print("ran(" + var + "," + ran + ")");
							}
							print("dsubset(" + ran + "," + zRanTypeName + ")");
				    	}
						
						printAtEnd("is_pfun(" + var + ")");
					}
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
							if ((tipoSchema == 0) && (exp != null) && (exp != "") && (!exp.contains("\\power")))
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
						if (tipoSchema == 0) print(var + " ein " + nodeName);
					}
				}
				else { //double check
					type = types.get(type);
					if (isBasic(type)) {
						if(type.startsWith("EnumerationType")) {
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
		
		
		//
		//  Metodo para generar variables setlog que representen un determinado tipo.
		//
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
			} else if (nodeType.contains("\\upto")) {
				String varName = memory.get(nodeType);
				if (varName != null)
					return varName;
				else { //No debería entrar nunca acá
					return "";
				}
			}
			
			return "";
		}
		
		//
		//  Metodo para obtener la key de un determinado valor de un hashmap
		//
		private String getKey(String value, HashMap<String,String> hashmap) {
			Iterator<String> keysIt= hashmap.keySet().iterator();
			while (keysIt.hasNext()) {
				String key = keysIt.next();
				if (hashmap.get(key).equals(value))
					return key;
			}
			return null;
		}
		
		
		//
		//  Metodo para crear variables y traducir, en caso de que no hayan sido creadas aun,
		//  para los tipos numericos basicos. La informacion es luego imprimida si asi se indica,
		//  en 'wantToPrint'
		//
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
					print(translation + " = int(" + num_inf + ", " + num_sup + ")");
				else if (type.equals("\\nat"))
					print(translation + " = int(" + nat_inf + ", " + nat_sup + ")");
				else if (type.equals("\\nat_{1}"))
					print(translation + " = int(" + nat1_inf + ", " + nat1_sup + ")");
				modoSetExpression = modoSetExpressionBk;
			}
			
			return translation;
		}
		
		//
		//  Determina si es un tipo basico de Z
		//
		private boolean isBasic(String type) {
			if (type.startsWith("BasicType") || type.startsWith("EnumerationType") || type.startsWith("SchemaType"))
				return true;
			return false;
		}
		
		//
		//  Determina si es un tipo numerico de Z
		//
		private boolean isNumeric(String type) {
			if (type.equals("\\num") || type.equals("\\nat") || type.equals("\\nat_{1}"))
				return true;
			return false;
		}
		
		//
		//  Determina si es una secuencia de Z
		//
		private boolean isSequence(String type) {
			if (type.equals("\\seq") || type.startsWith("seq_{1}"))
				return true;
			return false;
		}
		
		//
		//  Determina si es un tipo Schema
		//
		private boolean isSchemaType(String type) {
			if (type.startsWith("SchemaType"))
				return true;
				
			String auxType = types.get(type); //Double Check
			if (auxType != null && auxType.startsWith("SchemaType"))
				return true;
				
			return false;
		}
		
		//
		//  Convierte una lista en un conjunto, esto es requerido para aplicar algunas operaciones
		//  de conjunto a listas. Asi lo permite Z. Si es una lista, debemos aplicar list_to_rel
		//
		String convertToSet(String zVar, String setlogVar) {
			
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


	public ExprLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Expr.g4"; }

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
		case 77:
			WS_action((RuleContext)_localctx, actionIndex);
			break;
		case 84:
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2W\u02dc\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\4U\tU\4V\tV\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3"+
		"\r\3\r\3\16\3\16\3\16\3\16\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\21\3\21\3\22\3\22\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\30"+
		"\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\33\3\33\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\35"+
		"\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\37\3\37"+
		"\3\37\3\37\3\37\3\37\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3\"\3\"\3\"\3#\3#\3"+
		"#\3#\3#\3#\3$\3$\3$\3$\3$\3%\3%\3%\3%\3%\3%\3%\3%\3%\3&\3&\3&\3&\3&\3"+
		"\'\3\'\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3)\3)\3*\3*\3*\3"+
		"*\3*\3*\3*\3+\3+\3+\3+\3+\3+\3+\3,\3,\3,\3,\3,\3-\3-\3-\3-\3-\3.\3.\3"+
		".\3.\3.\3/\3/\3/\3/\3/\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\61\3"+
		"\61\3\61\3\61\3\61\3\62\3\62\3\62\3\62\3\62\3\63\3\63\3\63\3\63\3\63\3"+
		"\63\3\63\3\63\3\64\3\64\3\64\3\64\3\64\3\65\3\65\3\65\3\66\3\66\3\66\3"+
		"\66\3\66\3\66\3\66\3\66\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67\38\38"+
		"\38\38\39\39\39\39\3:\3:\3:\3:\3;\3;\3;\3;\3;\3<\3<\3<\3<\3<\3=\3=\3="+
		"\3=\3=\3>\3>\3>\3>\3>\3>\3?\3?\3?\3?\3?\3?\3?\3@\3@\3@\3@\3@\3@\3@\3A"+
		"\3A\3A\3A\3A\3A\3A\3A\3A\3A\3A\3A\3A\5A\u020f\nA\3B\3B\3B\3B\3B\3B\3B"+
		"\3B\3B\3B\3B\5B\u021c\nB\3C\3C\3C\3C\3C\3C\3C\3C\3C\3C\3C\5C\u0229\nC"+
		"\3D\3D\3D\3D\3D\3D\3D\3E\3E\3E\3E\3E\3E\3E\3E\3E\3F\3F\3F\3F\3F\3F\3F"+
		"\3F\3F\3F\3F\3F\3F\3F\3F\3F\3F\3F\3F\3F\3F\3F\3F\3F\3F\3F\3F\3F\3F\3F"+
		"\5F\u0259\nF\3G\3G\3G\3G\3G\3G\3G\3G\3G\3G\3G\3G\3G\3G\3G\3G\3G\3G\5G"+
		"\u026d\nG\3H\3H\3H\3H\3H\3H\3I\3I\3I\3I\3I\3I\3I\3I\3J\3J\3J\3J\3J\3J"+
		"\3J\3J\3J\3J\3J\3J\3J\3J\3J\3J\3J\3J\5J\u028f\nJ\3K\3K\3L\3L\3L\3L\3L"+
		"\6L\u0298\nL\rL\16L\u0299\3L\3L\3L\3L\3L\7L\u02a1\nL\fL\16L\u02a4\13L"+
		"\3M\6M\u02a7\nM\rM\16M\u02a8\3N\5N\u02ac\nN\3N\3N\3O\6O\u02b1\nO\rO\16"+
		"O\u02b2\3O\3O\3P\3P\3P\3Q\3Q\3Q\3R\3R\3R\3R\3R\3R\3R\3R\3S\3S\3S\3S\3"+
		"S\3S\3S\3S\3T\3T\3T\3T\3T\3T\3U\3U\3U\3U\3U\3U\3V\3V\3V\3V\2\2W\3\3\5"+
		"\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21"+
		"!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!"+
		"A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67m8o9q:s"+
		";u<w=y>{?}@\177A\u0081B\u0083C\u0085D\u0087E\u0089F\u008bG\u008dH\u008f"+
		"I\u0091J\u0093K\u0095L\u0097M\u0099N\u009bO\u009dP\u009fQ\u00a1R\u00a3"+
		"S\u00a5T\u00a7U\u00a9V\u00abW\3\2\6\4\2--//\4\2C\\c|\4\2\62;AA\6\2\13"+
		"\13\17\17\"\"\u0080\u0080\u02f3\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2"+
		"\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2"+
		"\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2"+
		"\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2"+
		"\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2"+
		"\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2"+
		"\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O"+
		"\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2"+
		"\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2"+
		"\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u"+
		"\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\2\177\3\2\2\2\2\u0081"+
		"\3\2\2\2\2\u0083\3\2\2\2\2\u0085\3\2\2\2\2\u0087\3\2\2\2\2\u0089\3\2\2"+
		"\2\2\u008b\3\2\2\2\2\u008d\3\2\2\2\2\u008f\3\2\2\2\2\u0091\3\2\2\2\2\u0093"+
		"\3\2\2\2\2\u0095\3\2\2\2\2\u0097\3\2\2\2\2\u0099\3\2\2\2\2\u009b\3\2\2"+
		"\2\2\u009d\3\2\2\2\2\u009f\3\2\2\2\2\u00a1\3\2\2\2\2\u00a3\3\2\2\2\2\u00a5"+
		"\3\2\2\2\2\u00a7\3\2\2\2\2\u00a9\3\2\2\2\2\u00ab\3\2\2\2\3\u00ad\3\2\2"+
		"\2\5\u00b5\3\2\2\2\7\u00bc\3\2\2\2\t\u00bf\3\2\2\2\13\u00c1\3\2\2\2\r"+
		"\u00c7\3\2\2\2\17\u00d2\3\2\2\2\21\u00de\3\2\2\2\23\u00e8\3\2\2\2\25\u00ea"+
		"\3\2\2\2\27\u00ec\3\2\2\2\31\u00ee\3\2\2\2\33\u00f1\3\2\2\2\35\u00f5\3"+
		"\2\2\2\37\u00f7\3\2\2\2!\u00fe\3\2\2\2#\u0100\3\2\2\2%\u0102\3\2\2\2\'"+
		"\u0106\3\2\2\2)\u010d\3\2\2\2+\u0113\3\2\2\2-\u0115\3\2\2\2/\u0117\3\2"+
		"\2\2\61\u011c\3\2\2\2\63\u0121\3\2\2\2\65\u0123\3\2\2\2\67\u012d\3\2\2"+
		"\29\u0135\3\2\2\2;\u013a\3\2\2\2=\u0142\3\2\2\2?\u014a\3\2\2\2A\u014c"+
		"\3\2\2\2C\u014e\3\2\2\2E\u0153\3\2\2\2G\u0159\3\2\2\2I\u015e\3\2\2\2K"+
		"\u0167\3\2\2\2M\u016c\3\2\2\2O\u0172\3\2\2\2Q\u017c\3\2\2\2S\u017e\3\2"+
		"\2\2U\u0185\3\2\2\2W\u018c\3\2\2\2Y\u0191\3\2\2\2[\u0196\3\2\2\2]\u019b"+
		"\3\2\2\2_\u01a0\3\2\2\2a\u01a8\3\2\2\2c\u01ad\3\2\2\2e\u01b2\3\2\2\2g"+
		"\u01ba\3\2\2\2i\u01bf\3\2\2\2k\u01c2\3\2\2\2m\u01ca\3\2\2\2o\u01d2\3\2"+
		"\2\2q\u01d6\3\2\2\2s\u01da\3\2\2\2u\u01de\3\2\2\2w\u01e3\3\2\2\2y\u01e8"+
		"\3\2\2\2{\u01ed\3\2\2\2}\u01f3\3\2\2\2\177\u01fa\3\2\2\2\u0081\u020e\3"+
		"\2\2\2\u0083\u021b\3\2\2\2\u0085\u0228\3\2\2\2\u0087\u022a\3\2\2\2\u0089"+
		"\u0231\3\2\2\2\u008b\u0258\3\2\2\2\u008d\u026c\3\2\2\2\u008f\u026e\3\2"+
		"\2\2\u0091\u0274\3\2\2\2\u0093\u028e\3\2\2\2\u0095\u0290\3\2\2\2\u0097"+
		"\u0297\3\2\2\2\u0099\u02a6\3\2\2\2\u009b\u02ab\3\2\2\2\u009d\u02b0\3\2"+
		"\2\2\u009f\u02b6\3\2\2\2\u00a1\u02b9\3\2\2\2\u00a3\u02bc\3\2\2\2\u00a5"+
		"\u02c4\3\2\2\2\u00a7\u02cc\3\2\2\2\u00a9\u02d2\3\2\2\2\u00ab\u02d8\3\2"+
		"\2\2\u00ad\u00ae\7^\2\2\u00ae\u00af\7d\2\2\u00af\u00b0\7g\2\2\u00b0\u00b1"+
		"\7i\2\2\u00b1\u00b2\7k\2\2\u00b2\u00b3\7p\2\2\u00b3\u00b4\7}\2\2\u00b4"+
		"\4\3\2\2\2\u00b5\u00b6\7u\2\2\u00b6\u00b7\7e\2\2\u00b7\u00b8\7j\2\2\u00b8"+
		"\u00b9\7g\2\2\u00b9\u00ba\7o\2\2\u00ba\u00bb\7c\2\2\u00bb\6\3\2\2\2\u00bc"+
		"\u00bd\7\177\2\2\u00bd\u00be\7}\2\2\u00be\b\3\2\2\2\u00bf\u00c0\7\177"+
		"\2\2\u00c0\n\3\2\2\2\u00c1\u00c2\7^\2\2\u00c2\u00c3\7g\2\2\u00c3\u00c4"+
		"\7p\2\2\u00c4\u00c5\7f\2\2\u00c5\u00c6\7}\2\2\u00c6\f\3\2\2\2\u00c7\u00c8"+
		"\7u\2\2\u00c8\u00c9\7e\2\2\u00c9\u00ca\7j\2\2\u00ca\u00cb\7g\2\2\u00cb"+
		"\u00cc\7o\2\2\u00cc\u00cd\7c\2\2\u00cd\u00ce\7V\2\2\u00ce\u00cf\7{\2\2"+
		"\u00cf\u00d0\7r\2\2\u00d0\u00d1\7g\2\2\u00d1\16\3\2\2\2\u00d2\u00d3\7"+
		"^\2\2\u00d3\u00d4\7d\2\2\u00d4\u00d5\7g\2\2\u00d5\u00d6\7i\2\2\u00d6\u00d7"+
		"\7k\2\2\u00d7\u00d8\7p\2\2\u00d8\u00d9\7}\2\2\u00d9\u00da\7|\2\2\u00da"+
		"\u00db\7g\2\2\u00db\u00dc\7f\2\2\u00dc\u00dd\7\177\2\2\u00dd\20\3\2\2"+
		"\2\u00de\u00df\7^\2\2\u00df\u00e0\7g\2\2\u00e0\u00e1\7p\2\2\u00e1\u00e2"+
		"\7f\2\2\u00e2\u00e3\7}\2\2\u00e3\u00e4\7|\2\2\u00e4\u00e5\7g\2\2\u00e5"+
		"\u00e6\7f\2\2\u00e6\u00e7\7\177\2\2\u00e7\22\3\2\2\2\u00e8\u00e9\7]\2"+
		"\2\u00e9\24\3\2\2\2\u00ea\u00eb\7.\2\2\u00eb\26\3\2\2\2\u00ec\u00ed\7"+
		"_\2\2\u00ed\30\3\2\2\2\u00ee\u00ef\7?\2\2\u00ef\u00f0\7?\2\2\u00f0\32"+
		"\3\2\2\2\u00f1\u00f2\7<\2\2\u00f2\u00f3\7<\2\2\u00f3\u00f4\7?\2\2\u00f4"+
		"\34\3\2\2\2\u00f5\u00f6\7~\2\2\u00f6\36\3\2\2\2\u00f7\u00f8\7^\2\2\u00f8"+
		"\u00f9\7y\2\2\u00f9\u00fa\7j\2\2\u00fa\u00fb\7g\2\2\u00fb\u00fc\7t\2\2"+
		"\u00fc\u00fd\7g\2\2\u00fd \3\2\2\2\u00fe\u00ff\7=\2\2\u00ff\"\3\2\2\2"+
		"\u0100\u0101\7<\2\2\u0101$\3\2\2\2\u0102\u0103\7^\2\2\u0103\u0104\7k\2"+
		"\2\u0104\u0105\7p\2\2\u0105&\3\2\2\2\u0106\u0107\7^\2\2\u0107\u0108\7"+
		"p\2\2\u0108\u0109\7q\2\2\u0109\u010a\7v\2\2\u010a\u010b\7k\2\2\u010b\u010c"+
		"\7p\2\2\u010c(\3\2\2\2\u010d\u010e\7^\2\2\u010e\u010f\7n\2\2\u010f\u0110"+
		"\7p\2\2\u0110\u0111\7q\2\2\u0111\u0112\7v\2\2\u0112*\3\2\2\2\u0113\u0114"+
		"\7>\2\2\u0114,\3\2\2\2\u0115\u0116\7@\2\2\u0116.\3\2\2\2\u0117\u0118\7"+
		"^\2\2\u0118\u0119\7n\2\2\u0119\u011a\7g\2\2\u011a\u011b\7s\2\2\u011b\60"+
		"\3\2\2\2\u011c\u011d\7^\2\2\u011d\u011e\7i\2\2\u011e\u011f\7g\2\2\u011f"+
		"\u0120\7s\2\2\u0120\62\3\2\2\2\u0121\u0122\7?\2\2\u0122\64\3\2\2\2\u0123"+
		"\u0124\7^\2\2\u0124\u0125\7u\2\2\u0125\u0126\7w\2\2\u0126\u0127\7d\2\2"+
		"\u0127\u0128\7u\2\2\u0128\u0129\7g\2\2\u0129\u012a\7v\2\2\u012a\u012b"+
		"\7g\2\2\u012b\u012c\7s\2\2\u012c\66\3\2\2\2\u012d\u012e\7^\2\2\u012e\u012f"+
		"\7u\2\2\u012f\u0130\7w\2\2\u0130\u0131\7d\2\2\u0131\u0132\7u\2\2\u0132"+
		"\u0133\7g\2\2\u0133\u0134\7v\2\2\u01348\3\2\2\2\u0135\u0136\7^\2\2\u0136"+
		"\u0137\7p\2\2\u0137\u0138\7g\2\2\u0138\u0139\7s\2\2\u0139:\3\2\2\2\u013a"+
		"\u013b\7^\2\2\u013b\u013c\7r\2\2\u013c\u013d\7t\2\2\u013d\u013e\7g\2\2"+
		"\u013e\u013f\7h\2\2\u013f\u0140\7k\2\2\u0140\u0141\7z\2\2\u0141<\3\2\2"+
		"\2\u0142\u0143\7^\2\2\u0143\u0144\7u\2\2\u0144\u0145\7w\2\2\u0145\u0146"+
		"\7h\2\2\u0146\u0147\7h\2\2\u0147\u0148\7k\2\2\u0148\u0149\7z\2\2\u0149"+
		">\3\2\2\2\u014a\u014b\7*\2\2\u014b@\3\2\2\2\u014c\u014d\7+\2\2\u014dB"+
		"\3\2\2\2\u014e\u014f\7v\2\2\u014f\u0150\7t\2\2\u0150\u0151\7w\2\2\u0151"+
		"\u0152\7g\2\2\u0152D\3\2\2\2\u0153\u0154\7h\2\2\u0154\u0155\7c\2\2\u0155"+
		"\u0156\7n\2\2\u0156\u0157\7u\2\2\u0157\u0158\7g\2\2\u0158F\3\2\2\2\u0159"+
		"\u015a\7^\2\2\u015a\u015b\7k\2\2\u015b\u015c\7h\2\2\u015c\u015d\7h\2\2"+
		"\u015dH\3\2\2\2\u015e\u015f\7^\2\2\u015f\u0160\7k\2\2\u0160\u0161\7o\2"+
		"\2\u0161\u0162\7r\2\2\u0162\u0163\7n\2\2\u0163\u0164\7k\2\2\u0164\u0165"+
		"\7g\2\2\u0165\u0166\7u\2\2\u0166J\3\2\2\2\u0167\u0168\7^\2\2\u0168\u0169"+
		"\7n\2\2\u0169\u016a\7q\2\2\u016a\u016b\7t\2\2\u016bL\3\2\2\2\u016c\u016d"+
		"\7^\2\2\u016d\u016e\7n\2\2\u016e\u016f\7c\2\2\u016f\u0170\7p\2\2\u0170"+
		"\u0171\7f\2\2\u0171N\3\2\2\2\u0172\u0173\7^\2\2\u0173\u0174\7g\2\2\u0174"+
		"\u0175\7o\2\2\u0175\u0176\7r\2\2\u0176\u0177\7v\2\2\u0177\u0178\7{\2\2"+
		"\u0178\u0179\7u\2\2\u0179\u017a\7g\2\2\u017a\u017b\7v\2\2\u017bP\3\2\2"+
		"\2\u017c\u017d\7B\2\2\u017dR\3\2\2\2\u017e\u017f\7^\2\2\u017f\u0180\7"+
		"n\2\2\u0180\u0181\7d\2\2\u0181\u0182\7n\2\2\u0182\u0183\7q\2\2\u0183\u0184"+
		"\7v\2\2\u0184T\3\2\2\2\u0185\u0186\7^\2\2\u0186\u0187\7t\2\2\u0187\u0188"+
		"\7d\2\2\u0188\u0189\7n\2\2\u0189\u018a\7q\2\2\u018a\u018b\7v\2\2\u018b"+
		"V\3\2\2\2\u018c\u018d\7^\2\2\u018d\u018e\7p\2\2\u018e\u018f\7c\2\2\u018f"+
		"\u0190\7v\2\2\u0190X\3\2\2\2\u0191\u0192\7a\2\2\u0192\u0193\7}\2\2\u0193"+
		"\u0194\7\63\2\2\u0194\u0195\7\177\2\2\u0195Z\3\2\2\2\u0196\u0197\7^\2"+
		"\2\u0197\u0198\7p\2\2\u0198\u0199\7w\2\2\u0199\u019a\7o\2\2\u019a\\\3"+
		"\2\2\2\u019b\u019c\7^\2\2\u019c\u019d\7k\2\2\u019d\u019e\7p\2\2\u019e"+
		"\u019f\7x\2\2\u019f^\3\2\2\2\u01a0\u01a1\7^\2\2\u01a1\u01a2\7p\2\2\u01a2"+
		"\u01a3\7g\2\2\u01a3\u01a4\7i\2\2\u01a4\u01a5\7c\2\2\u01a5\u01a6\7v\2\2"+
		"\u01a6\u01a7\7g\2\2\u01a7`\3\2\2\2\u01a8\u01a9\7^\2\2\u01a9\u01aa\7t\2"+
		"\2\u01aa\u01ab\7c\2\2\u01ab\u01ac\7p\2\2\u01acb\3\2\2\2\u01ad\u01ae\7"+
		"^\2\2\u01ae\u01af\7f\2\2\u01af\u01b0\7q\2\2\u01b0\u01b1\7o\2\2\u01b1d"+
		"\3\2\2\2\u01b2\u01b3\7u\2\2\u01b3\u01b4\7g\2\2\u01b4\u01b5\7s\2\2\u01b5"+
		"\u01b6\7a\2\2\u01b6\u01b7\7}\2\2\u01b7\u01b8\7\63\2\2\u01b8\u01b9\7\177"+
		"\2\2\u01b9f\3\2\2\2\u01ba\u01bb\7^\2\2\u01bb\u01bc\7u\2\2\u01bc\u01bd"+
		"\7g\2\2\u01bd\u01be\7s\2\2\u01beh\3\2\2\2\u01bf\u01c0\7^\2\2\u01c0\u01c1"+
		"\7%\2\2\u01c1j\3\2\2\2\u01c2\u01c3\7^\2\2\u01c3\u01c4\7d\2\2\u01c4\u01c5"+
		"\7k\2\2\u01c5\u01c6\7i\2\2\u01c6\u01c7\7e\2\2\u01c7\u01c8\7w\2\2\u01c8"+
		"\u01c9\7r\2\2\u01c9l\3\2\2\2\u01ca\u01cb\7^\2\2\u01cb\u01cc\7d\2\2\u01cc"+
		"\u01cd\7k\2\2\u01cd\u01ce\7i\2\2\u01ce\u01cf\7e\2\2\u01cf\u01d0\7c\2\2"+
		"\u01d0\u01d1\7r\2\2\u01d1n\3\2\2\2\u01d2\u01d3\7o\2\2\u01d3\u01d4\7c\2"+
		"\2\u01d4\u01d5\7z\2\2\u01d5p\3\2\2\2\u01d6\u01d7\7o\2\2\u01d7\u01d8\7"+
		"k\2\2\u01d8\u01d9\7p\2\2\u01d9r\3\2\2\2\u01da\u01db\7t\2\2\u01db\u01dc"+
		"\7g\2\2\u01dc\u01dd\7x\2\2\u01ddt\3\2\2\2\u01de\u01df\7j\2\2\u01df\u01e0"+
		"\7g\2\2\u01e0\u01e1\7c\2\2\u01e1\u01e2\7f\2\2\u01e2v\3\2\2\2\u01e3\u01e4"+
		"\7n\2\2\u01e4\u01e5\7c\2\2\u01e5\u01e6\7u\2\2\u01e6\u01e7\7v\2\2\u01e7"+
		"x\3\2\2\2\u01e8\u01e9\7v\2\2\u01e9\u01ea\7c\2\2\u01ea\u01eb\7k\2\2\u01eb"+
		"\u01ec\7n\2\2\u01ecz\3\2\2\2\u01ed\u01ee\7h\2\2\u01ee\u01ef\7t\2\2\u01ef"+
		"\u01f0\7q\2\2\u01f0\u01f1\7p\2\2\u01f1\u01f2\7v\2\2\u01f2|\3\2\2\2\u01f3"+
		"\u01f4\7u\2\2\u01f4\u01f5\7s\2\2\u01f5\u01f6\7w\2\2\u01f6\u01f7\7c\2\2"+
		"\u01f7\u01f8\7u\2\2\u01f8\u01f9\7j\2\2\u01f9~\3\2\2\2\u01fa\u01fb\7^\2"+
		"\2\u01fb\u01fc\7e\2\2\u01fc\u01fd\7t\2\2\u01fd\u01fe\7q\2\2\u01fe\u01ff"+
		"\7u\2\2\u01ff\u0200\7u\2\2\u0200\u0080\3\2\2\2\u0201\u0202\7^\2\2\u0202"+
		"\u0203\7r\2\2\u0203\u0204\7q\2\2\u0204\u0205\7y\2\2\u0205\u0206\7g\2\2"+
		"\u0206\u020f\7t\2\2\u0207\u0208\7^\2\2\u0208\u0209\7h\2\2\u0209\u020a"+
		"\7k\2\2\u020a\u020b\7p\2\2\u020b\u020c\7u\2\2\u020c\u020d\7g\2\2\u020d"+
		"\u020f\7v\2\2\u020e\u0201\3\2\2\2\u020e\u0207\3\2\2\2\u020f\u0082\3\2"+
		"\2\2\u0210\u0211\7^\2\2\u0211\u0212\7f\2\2\u0212\u0213\7t\2\2\u0213\u0214"+
		"\7g\2\2\u0214\u021c\7u\2\2\u0215\u0216\7^\2\2\u0216\u0217\7p\2\2\u0217"+
		"\u0218\7f\2\2\u0218\u0219\7t\2\2\u0219\u021a\7g\2\2\u021a\u021c\7u\2\2"+
		"\u021b\u0210\3\2\2\2\u021b\u0215\3\2\2\2\u021c\u0084\3\2\2\2\u021d\u021e"+
		"\7^\2\2\u021e\u021f\7t\2\2\u021f\u0220\7t\2\2\u0220\u0221\7g\2\2\u0221"+
		"\u0229\7u\2\2\u0222\u0223\7^\2\2\u0223\u0224\7p\2\2\u0224\u0225\7t\2\2"+
		"\u0225\u0226\7t\2\2\u0226\u0227\7g\2\2\u0227\u0229\7u\2\2\u0228\u021d"+
		"\3\2\2\2\u0228\u0222\3\2\2\2\u0229\u0086\3\2\2\2\u022a\u022b\7^\2\2\u022b"+
		"\u022c\7q\2\2\u022c\u022d\7r\2\2\u022d\u022e\7n\2\2\u022e\u022f\7w\2\2"+
		"\u022f\u0230\7u\2\2\u0230\u0088\3\2\2\2\u0231\u0232\7^\2\2\u0232\u0233"+
		"\7g\2\2\u0233\u0234\7z\2\2\u0234\u0235\7v\2\2\u0235\u0236\7t\2\2\u0236"+
		"\u0237\7c\2\2\u0237\u0238\7e\2\2\u0238\u0239\7v\2\2\u0239\u008a\3\2\2"+
		"\2\u023a\u0259\7,\2\2\u023b\u023c\7^\2\2\u023c\u023d\7f\2\2\u023d\u023e"+
		"\7k\2\2\u023e\u0259\7x\2\2\u023f\u0240\7^\2\2\u0240\u0241\7o\2\2\u0241"+
		"\u0242\7q\2\2\u0242\u0259\7f\2\2\u0243\u0244\7^\2\2\u0244\u0245\7e\2\2"+
		"\u0245\u0246\7c\2\2\u0246\u0259\7r\2\2\u0247\u0248\7^\2\2\u0248\u0249"+
		"\7h\2\2\u0249\u024a\7k\2\2\u024a\u024b\7n\2\2\u024b\u024c\7v\2\2\u024c"+
		"\u024d\7g\2\2\u024d\u0259\7t\2\2\u024e\u024f\7^\2\2\u024f\u0250\7e\2\2"+
		"\u0250\u0251\7q\2\2\u0251\u0252\7o\2\2\u0252\u0259\7r\2\2\u0253\u0254"+
		"\7^\2\2\u0254\u0255\7e\2\2\u0255\u0256\7k\2\2\u0256\u0257\7t\2\2\u0257"+
		"\u0259\7e\2\2\u0258\u023a\3\2\2\2\u0258\u023b\3\2\2\2\u0258\u023f\3\2"+
		"\2\2\u0258\u0243\3\2\2\2\u0258\u0247\3\2\2\2\u0258\u024e\3\2\2\2\u0258"+
		"\u0253\3\2\2\2\u0259\u008c\3\2\2\2\u025a\u026d\t\2\2\2\u025b\u025c\7^"+
		"\2\2\u025c\u025d\7e\2\2\u025d\u025e\7w\2\2\u025e\u026d\7r\2\2\u025f\u0260"+
		"\7^\2\2\u0260\u0261\7u\2\2\u0261\u0262\7g\2\2\u0262\u0263\7v\2\2\u0263"+
		"\u0264\7o\2\2\u0264\u0265\7k\2\2\u0265\u0266\7p\2\2\u0266\u0267\7w\2\2"+
		"\u0267\u026d\7u\2\2\u0268\u0269\7^\2\2\u0269\u026a\7e\2\2\u026a\u026b"+
		"\7c\2\2\u026b\u026d\7v\2\2\u026c\u025a\3\2\2\2\u026c\u025b\3\2\2\2\u026c"+
		"\u025f\3\2\2\2\u026c\u0268\3\2\2\2\u026d\u008e\3\2\2\2\u026e\u026f\7^"+
		"\2\2\u026f\u0270\7w\2\2\u0270\u0271\7r\2\2\u0271\u0272\7v\2\2\u0272\u0273"+
		"\7q\2\2\u0273\u0090\3\2\2\2\u0274\u0275\7^\2\2\u0275\u0276\7o\2\2\u0276"+
		"\u0277\7c\2\2\u0277\u0278\7r\2\2\u0278\u0279\7u\2\2\u0279\u027a\7v\2\2"+
		"\u027a\u027b\7q\2\2\u027b\u0092\3\2\2\2\u027c\u027d\7^\2\2\u027d\u027e"+
		"\7t\2\2\u027e\u027f\7g\2\2\u027f\u028f\7n\2\2\u0280\u0281\7^\2\2\u0281"+
		"\u0282\7r\2\2\u0282\u0283\7h\2\2\u0283\u0284\7w\2\2\u0284\u028f\7p\2\2"+
		"\u0285\u0286\7^\2\2\u0286\u0287\7h\2\2\u0287\u0288\7w\2\2\u0288\u028f"+
		"\7p\2\2\u0289\u028a\7^\2\2\u028a\u028b\7h\2\2\u028b\u028c\7h\2\2\u028c"+
		"\u028d\7w\2\2\u028d\u028f\7p\2\2\u028e\u027c\3\2\2\2\u028e\u0280\3\2\2"+
		"\2\u028e\u0285\3\2\2\2\u028e\u0289\3\2\2\2\u028f\u0094\3\2\2\2\u0290\u0291"+
		"\7\60\2\2\u0291\u0096\3\2\2\2\u0292\u0298\t\3\2\2\u0293\u0294\7^\2\2\u0294"+
		"\u0295\7a\2\2\u0295\u0298\7\"\2\2\u0296\u0298\7A\2\2\u0297\u0292\3\2\2"+
		"\2\u0297\u0293\3\2\2\2\u0297\u0296\3\2\2\2\u0298\u0299\3\2\2\2\u0299\u0297"+
		"\3\2\2\2\u0299\u029a\3\2\2\2\u029a\u02a2\3\2\2\2\u029b\u02a1\t\3\2\2\u029c"+
		"\u029d\7^\2\2\u029d\u029e\7a\2\2\u029e\u02a1\7\"\2\2\u029f\u02a1\t\4\2"+
		"\2\u02a0\u029b\3\2\2\2\u02a0\u029c\3\2\2\2\u02a0\u029f\3\2\2\2\u02a1\u02a4"+
		"\3\2\2\2\u02a2\u02a0\3\2\2\2\u02a2\u02a3\3\2\2\2\u02a3\u0098\3\2\2\2\u02a4"+
		"\u02a2\3\2\2\2\u02a5\u02a7\4\62;\2\u02a6\u02a5\3\2\2\2\u02a7\u02a8\3\2"+
		"\2\2\u02a8\u02a6\3\2\2\2\u02a8\u02a9\3\2\2\2\u02a9\u009a\3\2\2\2\u02aa"+
		"\u02ac\7\17\2\2\u02ab\u02aa\3\2\2\2\u02ab\u02ac\3\2\2\2\u02ac\u02ad\3"+
		"\2\2\2\u02ad\u02ae\7\f\2\2\u02ae\u009c\3\2\2\2\u02af\u02b1\t\5\2\2\u02b0"+
		"\u02af\3\2\2\2\u02b1\u02b2\3\2\2\2\u02b2\u02b0\3\2\2\2\u02b2\u02b3\3\2"+
		"\2\2\u02b3\u02b4\3\2\2\2\u02b4\u02b5\bO\2\2\u02b5\u009e\3\2\2\2\u02b6"+
		"\u02b7\7^\2\2\u02b7\u02b8\7}\2\2\u02b8\u00a0\3\2\2\2\u02b9\u02ba\7^\2"+
		"\2\u02ba\u02bb\7\177\2\2\u02bb\u00a2\3\2\2\2\u02bc\u02bd\7^\2\2\u02bd"+
		"\u02be\7n\2\2\u02be\u02bf\7c\2\2\u02bf\u02c0\7p\2\2\u02c0\u02c1\7i\2\2"+
		"\u02c1\u02c2\7n\2\2\u02c2\u02c3\7g\2\2\u02c3\u00a4\3\2\2\2\u02c4\u02c5"+
		"\7^\2\2\u02c5\u02c6\7t\2\2\u02c6\u02c7\7c\2\2\u02c7\u02c8\7p\2\2\u02c8"+
		"\u02c9\7i\2\2\u02c9\u02ca\7n\2\2\u02ca\u02cb\7g\2\2\u02cb\u00a6\3\2\2"+
		"\2\u02cc\u02cd\7^\2\2\u02cd\u02ce\7n\2\2\u02ce\u02cf\7k\2\2\u02cf\u02d0"+
		"\7o\2\2\u02d0\u02d1\7i\2\2\u02d1\u00a8\3\2\2\2\u02d2\u02d3\7^\2\2\u02d3"+
		"\u02d4\7t\2\2\u02d4\u02d5\7k\2\2\u02d5\u02d6\7o\2\2\u02d6\u02d7\7i\2\2"+
		"\u02d7\u00aa\3\2\2\2\u02d8\u02d9\7^\2\2\u02d9\u02da\7^\2\2\u02da\u02db"+
		"\bV\3\2\u02db\u00ac\3\2\2\2\20\2\u020e\u021b\u0228\u0258\u026c\u028e\u0297"+
		"\u0299\u02a0\u02a2\u02a8\u02ab\u02b2\4\3O\2\3V\3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}