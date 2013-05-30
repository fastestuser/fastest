grammar Expr;

//Gramatica utilizada para la creacion, a partir de una clase de prueba Z, la entrada necesaria
//para setlog. Es parte del proceso de generacion de casos de prueba.

@header {
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
	
}

@members {
	
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
}

specification
	:	( paragraph NL*)+
	{/*
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
     
	*/}
	;

paragraph
	//Aceptamos 3 tipos de schemas: la clase de prueba (schema), los tipos esquema necesarios (schemaType) y
	//las definiciones de tipos basicos y enumerados
	:	'\\begin{' ('schema' | ('schemaType' {tipoSchema = 1; schemaTypeVars = new HashMap<String,String>();})) '}{' NAME '}'
		schemaText
		{
			if (tipoSchema == 1) {
				String newVarName = newVar($NAME.text);
				memory.put($NAME.text, newVarName);
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
				
				types.put($NAME.text, "SchemaType:" + newVarName + ":[" + vars + "]");
				vars = "";
			}
		}
		'\\end{' ('schema' | ('schemaType' {tipoSchema = 0;})) '}'
	|	'\\begin{zed}' NL? ((basic_type | equivalent_type | enumeration_type) NL )+ '\\end{zed}'
	;
      
basic_type
locals [ArrayList<String> typeList;]
@init{$basic_type::typeList = new ArrayList<String>();}
	:	'[' a=declName {$basic_type::typeList.add($a.text);} (',' b=declName {$basic_type::typeList.add($b.text);})* ']'
	{
		while( !$basic_type::typeList.isEmpty() ) {
			String type = $basic_type::typeList.remove(0);
			
			String newVarName = newVar($declName.text);
			memory.put(type, newVarName);
			print("set(" + newVarName + ")");
			types.put(type, "BasicType:" + newVarName);
		}
	}	
	;
	
equivalent_type
	:	declName '==' expression
	{ 
		String type = types.get($expression.text);
		if (type != null) {
			types.put($declName.text, type);
		}
	}
	;
	
enumeration_type
locals [ArrayList<String> cases;]
@init{$enumeration_type::cases = new ArrayList<String>();}
	:	d=declName '::=' a=declName {$enumeration_type::cases.add($a.text);} (expression)? 
	    ('|' b=declName {$enumeration_type::cases.add($b.text);} (expression)? )* 
	    //Soporta solo constantes, falta ver que hacer si tiene expressiones
	{	
		String elements = new String();
		while( !$enumeration_type::cases.isEmpty() ){
			String e = $enumeration_type::cases.remove(0);
			String eMinus = e.substring(0,1).toLowerCase() + e.substring(1); //Pasamos la primer mayuscula a minuscula ya que setlog asi lo precisa
			elements = elements.concat(eMinus);
			
			memory.put(e, eMinus);
			types.put(e, $d.text);
			
			if (!$enumeration_type::cases.isEmpty()){
				elements = elements.concat(",");
			}
		}
		if (types.get($d.text) == null) {
			//Le asigno un nombre al conjunto
			String newVarName = newVar($d.text);
			memory.put($d.text, newVarName);
			types.put($d.text, "EnumerationType:" + newVarName + ":{" + elements + "}");
			print(newVarName + " = {" + elements + "}");
		}
	}
	;
      
schemaText
	:	NL (declPart NL)? ('\\where' NL)? (predicate NL)*
	;
	
declPart:	declaration ((';' | NL) declaration)*
	;
	
declaration
locals [ArrayList<String> vars;]
@init{$declaration::vars = new ArrayList<String>();}
	:	a=declName {$declaration::vars.add($a.text);} (',' b=declName {$declaration::vars.add($b.text);})* ':' expression 
	{
		//Para cada variable realizamos el procesamiento
		while( !$declaration::vars.isEmpty() ) {

			String var = $declaration::vars.remove(0);

			if (tipoSchema == 0)
				zVars.put(var, null); //Marcamos la variable como variable Z, a la cual posiblemente se le deba asignarsele un valor

			String newVarName = newVar(var);
			if (tipoSchema == 0)
				memory.put(var, newVarName);
			if (modoSetExpression==1)
				setExpressionVars.put(var, newVarName);
			
			String expType = types.get($expression.text);
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
	;
	
declName:	NAME
	;
	
predicate
	:	e1=expression '\\in' e2=expression
	{
		String a, b;
		a = memory.get($e1.text);
		b = memory.get($e2.text);
		
		//Si b es una lista, debo convertirla
		b = convertToSet($e2.text, b);
		
		print(a + " in " + b);
	}
	|	(e1=expression '\\notin' (DECORATION)? e2=expression | '\\lnot' e1=expression '\\in' e2=expression)
	{
		String a, b;
		a = memory.get($e1.text);
		b = memory.get($e2.text);
		
		//Si b es una lista, debo convertirla
		b = convertToSet($e2.text, b);
		
		print(a + " nin " + b);
	}
	|	e1=expression '<' (DECORATION)? e2=expression
	{
		String a, b;
		a = memory.get($e1.text);
		b = memory.get($e2.text);
		print(a + " < " + b);
	}
	|	e1=expression '>' (DECORATION)? e2=expression
	{
		String a, b;
		a = memory.get($e1.text);
		b = memory.get($e2.text);
		print(a + " > " + b);
	}
	|	e1=expression '\\leq' (DECORATION)? e2=expression
	{
		String a, b;
		a = memory.get($e1.text);
		b = memory.get($e2.text);
		
		print(a + " =< " + b);
	}
	|	e1=expression '\\geq' (DECORATION)? e2=expression
	{
		String a, b;
		a = memory.get($e1.text);
		b = memory.get($e2.text);
		print(a + " =< " + b);
	}
	|	e1=expression '=' e2=expression
	{
		String a, b;
		a = memory.get($e1.text);
		b = memory.get($e2.text);
		print(a + " = " + b);
	}
	|	e1=expression '\\subseteq' (DECORATION)? e2=expression
	{
		String a, b;
		a = memory.get($e1.text);
		b = memory.get($e2.text);
		
		//Si a es una lista, debo convertirla
		a = convertToSet($e1.text, a);
		//Si b es una lista, debo convertirla
		b = convertToSet($e2.text, b);
		
		print("dsubset(" + a + "," + b + ")");
	}
	|	'\\lnot' e1=expression '\\subseteq' (DECORATION)? e2=expression
	{
		String a, b;
		a = memory.get($e1.text);
		b = memory.get($e2.text);
		
		//Si a es una lista, debo convertirla
		a = convertToSet($e1.text, a);
		//Si b es una lista, debo convertirla
		b = convertToSet($e2.text, b);
		
		print("dnsubset(" + a + "," + b + ")");
	}
	|	e1=expression '\\subset' (DECORATION)? e2=expression
	{
		String a, b;
		a = memory.get($e1.text);
		b = memory.get($e2.text);
		
		//Si a es una lista, debo convertirla
		a = convertToSet($e1.text, a);
		//Si b es una lista, debo convertirla
		b = convertToSet($e2.text, b);
		
		print("dssubset(" + a + "," + b + ")");
	}
	|	'\\lnot' e1=expression '\\subset' (DECORATION)? e2=expression
	{
		String a, b;
		a = memory.get($e1.text);
		b = memory.get($e2.text);
		
		//Si a es una lista, debo convertirla
		a = convertToSet($e1.text, a);
		//Si b es una lista, debo convertirla
		b = convertToSet($e2.text, b);
		
		String c = memory.get( $e1.text + "\\cap" + $e2.text);
		if (c == null) {
			c = newVar();
			memory.put( $e1.text + "\\cap" + $e2.text, c);
			print("dinters(" + a + "," + b + "," + c + ")");
			String type = types.get($e1.text);
			if (isSequence(getType(type)))
				type = "\\power(\\nat\\cross(" + leftAndRightTypes(type).get(1) + "))";
			types.put($e1.text + "\\cap" + $e2.text, type);
			//typeInfo(c, type);
		}
		
		print(c + " neq " + a);
	}
	|	e1=expression '\\neq' (DECORATION)? e2=expression
	{
		String a, b;
		a = memory.get($e1.text);
		b = memory.get($e2.text);
		
		if (!getType(types.get($e1.text)).equals(getType(types.get($e2.text)))) {
			//Si a es una lista, debo convertirla
			a = convertToSet($e1.text, a);
			//Si b es una lista, debo convertirla
			b = convertToSet($e2.text, b);
		}
			
		
		print(a + " neq " + b);
	}
	|	e1=expression '\\prefix' (DECORATION)? e2=expression
	{
		String a, b;
		a = memory.get($e1.text);
		b = memory.get($e2.text);
		print("prolog_call(append(" + a + ",_," + b + "))");
	}
	|	e1=expression '\\suffix' (DECORATION)? e2=expression
	{
		String a, b;
		a = memory.get($e1.text);
		b = memory.get($e2.text);
		print("prolog_call(append(_," + a + "," + b + "))");
	}
	|	'(' predicate ')'
	|	'true'
	|	'false'
	|	predicate '\\iff' predicate
	|	predicate '\\implies' predicate
	|	predicate '\\lor' predicate
	|	predicate '\\land' predicate
	;

expression0
locals [ArrayList<String> elements = new ArrayList<String>(), String setlogName = "", String zName = "", String operator = "",
	String newVarName1 = "", String newVarName2 = ""]
	:	expression
	;
	
expression
locals [ArrayList<String> elements = new ArrayList<String>(), String setlogName = "", String zName = "", String operator = "",
	String newVarName1 = "", String newVarName2 = ""]
	:	expression1
	;
	
expression1
locals [ArrayList<String> elements = new ArrayList<String>(), String setlogName = "", String zName = "", String operator = "",
	String newVarName1 = "", String newVarName2 = ""]
	:	a=expression1 IN_GEN b=expression1 
	{
		//Guardo el tipo
		String aType = types.get($a.text);
		if (isBasic(aType)) {
			aType = $a.text;
		}
		String bType = types.get($b.text);
		if (isBasic(bType))
			bType = $b.text;
		
		//if ($IN_GEN.text.equals("\\fun"))
		//	types.put($a.text + $IN_GEN.text + $b.text, aType + "\\pfun" + bType );
		//else
			types.put($a.text + $IN_GEN.text + $b.text, aType + $IN_GEN.text + bType );
	}
	|	e21=expression2 {$expression1::elements.add($e21.text);} ('\\cross' e22=expression2 {$expression1::elements.add($e22.text);})+
	{
		String unfoldedType = "";
		
		//Para cada exp realizamos el procesamiento
		while( !$expression1::elements.isEmpty() ) {
			String exp = $expression1::elements.remove(0);
			
			$zName = $zName.concat(exp);
			
			String expType = types.get(exp);
			if (isBasic(expType))
				unfoldedType = unfoldedType.concat(exp);
			else
				unfoldedType = unfoldedType.concat(expType);
				
			if (!$expression1::elements.isEmpty()) {
				$zName = $zName.concat("\\cross");
				unfoldedType = unfoldedType.concat("\\cross");
			}
		}
		
		types.put($zName, unfoldedType);
	}
	|	seq_op e2=expression2
	{
		String a;
		a = memory.get($e2.text);
		
		if (memory.get( $seq_op.text + $e2.text) == null) {
		
			String newVarName = newVar();
		
			if ($seq_op.text.startsWith("rev")){
				print("prolog_call(reverse(" + a + "," + newVarName + "))");
				memory.put($seq_op.text + $e2.text, newVarName);
				String type = types.get($e2.text);
				types.put($seq_op.text + $e2.text, type);
				typeInfo(newVarName, type);
				if (modoSetExpression != 0 )
					setExpressionVars.put($seq_op.text + $e2.text, newVarName);
			}
			else if ($seq_op.text.startsWith("head")){
				print("nth1(1," + a + "," + newVarName + ")");
				memory.put($seq_op.text + $e2.text, newVarName);
				String type = getChildType(types.get($e2.text), 0);
				types.put($seq_op.text + $e2.text, type);
				typeInfo(newVarName, type);
				if (modoSetExpression != 0 )
					setExpressionVars.put($seq_op.text + $e2.text, newVarName);
			}
			else if ($seq_op.text.startsWith("last")){
				print("prolog_call(last(" + a + "," + newVarName + "))");
				memory.put($seq_op.text + $e2.text, newVarName);
				String type = getChildType(types.get($e2.text), 0);
				types.put($seq_op.text + $e2.text, type);
				typeInfo(newVarName, type);
				if (modoSetExpression != 0 )
					setExpressionVars.put($seq_op.text + $e2.text, newVarName);
			}
			else if ($seq_op.text.startsWith("tail")){
				print("prolog_call(drop(1," + a + "," + newVarName + "))");
				memory.put($seq_op.text + $e2.text, newVarName);
				String type = types.get($e2.text);
				types.put($seq_op.text + $e2.text, type);
				typeInfo(newVarName, type);
				if (modoSetExpression != 0 )
					setExpressionVars.put($seq_op.text + $e2.text, newVarName);
			}
			else if ($seq_op.text.startsWith("front")){
				String n = newVar();
				print("prolog_call(length(" + a + "," + n + "))");
				print(n + " in " + printInfo("\\nat", true));
				print("prolog_call(take(" + n + "-1" + "," + a + "," + newVarName + "))");
				memory.put($seq_op.text + $e2.text, newVarName);
				String type = types.get($e2.text);
				types.put($seq_op.text + $e2.text, type);
				typeInfo(newVarName, type);
				if (modoSetExpression != 0 )
					setExpressionVars.put($seq_op.text + $e2.text, newVarName);
			}
			else if ($seq_op.text.startsWith("squash")){
				print("squash(" + a + "," + newVarName + ")");
				memory.put($seq_op.text + $e2.text, newVarName);
				String type = types.get($e2.text);
				ArrayList<String> leftAndRight = leftAndRightTypes(type);
				type = "\\seq(" + leftAndRight.get(1) + ")";
				types.put($seq_op.text + $e2.text, type);
				typeInfo(newVarName, type);
				if (modoSetExpression != 0 )
					setExpressionVars.put($seq_op.text + $e2.text, newVarName);
			}
		}
	}
	|	e2=expression2
	;
	
	
	
expression2
	locals [ArrayList<String> elements = new ArrayList<String>(), String setlogName = "", String zName = "", String operator = "",
	String newVarName1 = "", String newVarName2 = ""]
	:	e21=expression2 IN_FUN_P6 e22=expression2
	{
		String a, b;
		a = memory.get($e21.text);
		b = memory.get($e22.text);
		
		//Si a es una lista, debo convertirla
		a = convertToSet($e21.text, a);
		//Si b es una lista, debo convertirla
		b = convertToSet($e22.text, b);
		
		if (memory.get($e21.text + $IN_FUN_P6.text + $e22.text) == null) {
		
			String newVarName = newVar();
		
			if ($IN_FUN_P6.text.equals("\\dres")){
				print("dres(" + a + "," + b + "," + newVarName + ")");
				memory.put($e21.text + "\\dres" + $e22.text, newVarName);
				String type2 = types.get($e22.text);
				ArrayList<String> leftAndRight = leftAndRightTypes(type2);
				String type = "\\power((" + leftAndRight.get(0) + ")\\cross(" + leftAndRight.get(1) + "))";
				types.put($e21.text + "\\dres" + $e22.text, type);
				typeInfo(newVarName, type);
				if (modoSetExpression != 0 )
					setExpressionVars.put($e21.text + "\\dres" + $e22.text, newVarName);
			}
			else if ($IN_FUN_P6.text.equals("\\ndres")){
				print("ndres(" + a + "," + b + "," + newVarName + ")");
				memory.put($e21.text + "\\ndres" + $e22.text, newVarName);
				String type2 = types.get($e22.text);
				ArrayList<String> leftAndRight = leftAndRightTypes(type2);
				String type = "\\power((" + leftAndRight.get(0) + ")\\cross(" + leftAndRight.get(1) + "))";
				types.put($e21.text + "\\ndres" + $e22.text, type);
				typeInfo(newVarName, type);
				if (modoSetExpression != 0 )
					setExpressionVars.put($e21.text + "\\ndres" + $e22.text, newVarName);
			}
			else if ($IN_FUN_P6.text.equals("\\rres")){
				print("rres(" + b + "," + a + "," + newVarName + ")");
				memory.put($e21.text + "\\rres" + $e22.text, newVarName);
				String type1 = types.get($e21.text);
				ArrayList<String> leftAndRight = leftAndRightTypes(type1);
				String type = "\\power((" + leftAndRight.get(0) + ")\\cross(" + leftAndRight.get(1) + "))";
				types.put($e21.text + "\\rres" + $e22.text, type);
				typeInfo(newVarName, type);
				if (modoSetExpression != 0 )
					setExpressionVars.put($e21.text + "\\rres" + $e22.text, newVarName);
			}
			else if ($IN_FUN_P6.text.equals("\\nrres")){
				print("nrres(" + b + "," + a + "," + newVarName + ")");
				memory.put($e21.text + "\\nrres" + $e22.text, newVarName);
				String type1 = types.get($e21.text);
				ArrayList<String> leftAndRight = leftAndRightTypes(type1);
				String type = "\\power((" + leftAndRight.get(0) + ")\\cross(" + leftAndRight.get(1) + "))";
				types.put($e21.text + "\\nrres" + $e22.text, type);
				typeInfo(newVarName, type);
				if (modoSetExpression != 0 )
					setExpressionVars.put($e21.text + "\\nrres" + $e22.text, newVarName);
			}
		}
	}
	|	e21=expression2 IN_FUN_P5 e22=expression2
	{
		String a, b;
		a = memory.get($e21.text);
		b = memory.get($e22.text);
		
		//Si a es una lista, debo convertirla
		a = convertToSet($e21.text, a);
		//Si b es una lista, debo convertirla
		b = convertToSet($e22.text, b);
		
		if (memory.get($e21.text + $IN_FUN_P5.text + $e22.text) == null) {
		
			String newVarName = newVar();
		
			if ($IN_FUN_P5.text.equals("\\oplus")){
				print("oplus(" + a + "," + b + "," + newVarName + ")");
				memory.put($e21.text + "\\oplus" + $e22.text, newVarName);
				String type1 = types.get($e21.text);
				ArrayList<String> leftAndRight = leftAndRightTypes(type1);
				String type = "\\power((" + leftAndRight.get(0) + ")\\cross(" + leftAndRight.get(1) + "))";
				types.put($e21.text + "\\oplus" + $e22.text, type);
				typeInfo(newVarName, type);
				if (modoSetExpression != 0 )
					setExpressionVars.put($e21.text + "\\oplus" + $e22.text, newVarName);
			}
		}
	}
	|	e21=expression2 IN_FUN_P4 e22=expression2
	{
		String a, b;
		
		a = memory.get($e21.text);
		b = memory.get($e22.text);

		if (memory.get($e21.text + $IN_FUN_P4.text + $e22.text) == null) {
		
			String newVarName = newVar();
			Boolean isNumeric = false; 
		
			if ($IN_FUN_P4.text.equals("*")){
				print( newVarName + " is " + a + "*" + b );
				memory.put($e21.text + "*" + $e22.text, newVarName);
				if (modoSetExpression != 0 )
					setExpressionVars.put($e21.text + "*" + $e22.text, newVarName);
				isNumeric = true;
			}
			else if ($IN_FUN_P4.text.equals("\\div")) {
				print( newVarName + " is div(" + a + "," + b + ")" );
				memory.put($e21.text + "\\div" + $e22.text, newVarName);
				if (modoSetExpression != 0 )
					setExpressionVars.put($e21.text + "\\div" + $e22.text, newVarName);
				isNumeric = true;
			}
			else if ($IN_FUN_P4.text.equals("\\mod")){
				print( newVarName + " is mod(" + a + "," + b + ")" );
				memory.put($e21.text + "\\mod" + $e22.text, newVarName);
				if (modoSetExpression != 0 )
					setExpressionVars.put($e21.text + "\\mod" + $e22.text, newVarName);
				isNumeric = true;
			}
			else if ($IN_FUN_P4.text.equals("\\cap")){
				//Si a es una lista, debo convertirla
				a = convertToSet($e21.text, a);
				//Si b es una lista, debo convertirla
				b = convertToSet($e22.text, b);
								
				print("dinters(" + a + "," + b + "," + newVarName + ")");
				memory.put($e21.text + "\\cap" + $e22.text, newVarName);
				String type = types.get($e21.text);
				if (isSequence(getType(type)))
					type = "\\power(\\nat\\cross(" + leftAndRightTypes(type).get(1) + "))";
				types.put($e21.text + "\\cap" + $e22.text, type);
				//typeInfo(newVarName, type);
				if (modoSetExpression != 0 )
					setExpressionVars.put($e21.text + "\\cap" + $e22.text, newVarName);
			}
			else if ($IN_FUN_P4.text.equals("\\comp")){
				//Si a es una lista, debo convertirla
				a = convertToSet($e21.text, a);
				//Si b es una lista, debo convertirla
				b = convertToSet($e22.text, b);
						
				print("comp(" + a + "," + b + "," + newVarName + ")");
				memory.put($e21.text + "\\comp" + $e22.text, newVarName);
				String type1 = types.get($e21.text);
				String type2 = types.get($e22.text);
				String type = "\\power((" + leftAndRightTypes(type1).get(0) + ")\\cross(" + leftAndRightTypes(type2).get(1) + "))";
				types.put($e21.text + "\\comp" + $e22.text, type);
				typeInfo(newVarName, type);
				if (modoSetExpression != 0 )
					setExpressionVars.put($e21.text + "\\comp" + $e22.text, newVarName);
			}
			else if ($IN_FUN_P4.text.equals("\\circ")){
				//Si a es una lista, debo convertirla
				a = convertToSet($e21.text, a);
				//Si b es una lista, debo convertirla
				b = convertToSet($e22.text, b);
				
				print("circ(" + a + "," + b + "," + newVarName + ")");
				memory.put($e21.text + "\\circ" + $e22.text, newVarName);
				String type1 = types.get($e21.text);
				type1 = leftAndRightTypes(type1).get(1);
				String type = "\\power((" + type1 + ")\\cross(" + type1 + "))";
				types.put($e21.text + "\\circ" + $e22.text, type);
				typeInfo(newVarName, type);
				if (modoSetExpression != 0 )
					setExpressionVars.put($e21.text + "\\circ" + $e22.text, newVarName);
			}
			else if ($IN_FUN_P4.text.equals("\\extract")){
				print("extract(" + a + "," + b + "," + newVarName + ")");
				memory.put($e21.text + "\\extract" + $e22.text, newVarName);
				String type = types.get($e22.text);
				types.put($e21.text + "\\extract" + $e22.text, type);
				typeInfo(newVarName, type);
				if (modoSetExpression != 0 )
					setExpressionVars.put($e21.text + "\\extract" + $e22.text, newVarName);
			}
			else if ($IN_FUN_P4.text.equals("\\filter")){
				print("filter(" + a + "," + b + "," + newVarName + ")");
				memory.put($e21.text + "\\filter" + $e22.text, newVarName);
				String type = types.get($e21.text);
				types.put($e21.text + "\\filter" + $e22.text, type);
				typeInfo(newVarName, type);
				if (modoSetExpression != 0 )
					setExpressionVars.put($e21.text + "\\filter" + $e22.text, newVarName);
			}
			
			if (isNumeric) {
				print(newVarName + " in " + printInfo("\\num", true));
				types.put($e21.text + $IN_FUN_P4.text + $e22.text, "\\num");
			}
		}
	}
	|	e21=expression2 IN_FUN_P3 e22=expression2
	{
		String a, b;
		a = memory.get($e21.text);
		b = memory.get($e22.text);
		
		if (memory.get($e21.text + $IN_FUN_P3.text + $e22.text) == null) {
		
			String newVarName = newVar();
			Boolean isNumeric = false; 
			
		
			if ($IN_FUN_P3.text.equals("+")){
				print( newVarName + " is " + a + "+" + b );
				memory.put($e21.text + "+" + $e22.text, newVarName);
				if (modoSetExpression != 0 )
					setExpressionVars.put($e21.text + "+" + $e22.text, newVarName);
				isNumeric = true;
			}
			else if ($IN_FUN_P3.text.equals("-")) {
				print( newVarName + " is " + a + "-" + b );
				memory.put($e21.text + "-" + $e22.text, newVarName);
				if (modoSetExpression != 0 )
					setExpressionVars.put($e21.text + "-" + $e22.text, newVarName);
				isNumeric = true;
			}
			else if ($IN_FUN_P3.text.equals("\\cup")){
			
				//Si a es una lista, debo convertirla
				a = convertToSet($e21.text, a);
				//Si b es una lista, debo convertirla
				b = convertToSet($e22.text, b);
				
				print("dun(" + a + "," + b + "," + newVarName + ")");
				memory.put($e21.text + "\\cup" + $e22.text, newVarName);
				String type = types.get($e21.text);
				if (isSequence(getType(type)))
					type = "\\power(\\nat\\cross(" + leftAndRightTypes(type).get(1) + "))";
				types.put($e21.text + "\\cup" + $e22.text, type);
				typeInfo(newVarName, type);
				if (modoSetExpression != 0 )
					setExpressionVars.put($e21.text + "\\cup" + $e22.text, newVarName);
			}
			else if ($IN_FUN_P3.text.equals("\\setminus")){
				//Si a es una lista, debo convertirla
				a = convertToSet($e21.text, a);
				//Si b es una lista, debo convertirla
				b = convertToSet($e22.text, b);
		
				print("diff(" + a + "," + b + "," + newVarName + ")");
				memory.put($e21.text + "\\setminus" + $e22.text, newVarName);
				String type = types.get($e21.text);
				if (isSequence(getType(type)))
					type = "\\power(\\nat\\cross(" + leftAndRightTypes(type).get(1) + "))";
				types.put($e21.text + "\\setminus" + $e22.text, type);
				typeInfo(newVarName, type);
				if (modoSetExpression != 0 )
					setExpressionVars.put($e21.text + "\\setminus" + $e22.text, newVarName);
			}
			else if ($IN_FUN_P3.text.equals("\\cat")){
				print("prolog_call(append(" + a + "," + b + "," + newVarName + "))");
				memory.put($e21.text + "\\cat" + $e22.text, newVarName);
				String type = types.get($e21.text);
				types.put($e21.text + "\\cat" + $e22.text, type);
				typeInfo(newVarName, type);
				if (modoSetExpression != 0 )
					setExpressionVars.put($e21.text + "\\cat" + $e22.text, newVarName);
			}
			
			if (isNumeric) {
				print(newVarName + " in " + printInfo("\\num", true));
				types.put($e21.text + $IN_FUN_P3.text + $e22.text, "\\num");
			}
		}
	}
	|	e21=expression2 '\\upto' e22=expression2 //IN_FUN_2
	{
		String a, b;
		a = memory.get($e21.text);
		b = memory.get($e22.text);
		if (memory.get($e21.text + "\\upto" + $e22.text) == null) {
			String newVarName = newVar();
			memory.put($e21.text + "\\upto" + $e22.text, newVarName);
			types.put($e21.text + "\\upto" + $e22.text, memory.get($e21.text) + "\\upto" + memory.get($e22.text));
			if (modoSetExpression != 0 )
				setExpressionVars.put($e21.text + "\\upto" + $e22.text, newVarName);
			print(newVarName + " = int(" + a + "," + b + ")");
		}
	}
	|	e21=expression2 '\\mapsto' e22=expression2 //IN_FUN_1
	{
		String a, b;
		a = memory.get($e21.text);
		b = memory.get($e22.text);
		memory.put($e21.text + "\\mapsto" + $e22.text, "[" + a + "," + b + "]");
		types.put($e21.text + "\\mapsto" + $e22.text, types.get($e21.text) + "\\cross" + types.get($e22.text));
	}
	|	('\\power' | '\\finset') e2=expression2
	{
		String eType = types.get($e2.text);
		if (isBasic(eType))
			eType = $e2.text;
	
		types.put($expression2.text, "\\power" + eType );
	}
	|	pre_gen e4=expression4 //Pre-Gen //REVISAR, ya que pre-gen no dice tener todo lo que aca hay!
	{
		String a;
		a = memory.get($e4.text);
		
		if ($pre_gen.text.equals("\\#")){
			if (memory.get("\\#" + $e4.text) == null) {
				String newVarName = newVar();
				memory.put("\\#" + $e4.text, newVarName);
				types.put("\\#" + $e4.text, "\\nat");
				if (modoSetExpression != 0 )
					setExpressionVars.put("\\#" + $e4.text, newVarName);
					
				String type = getType(types.get($e4.text));
				if (isSequence(type))
					print("prolog_call(length(" + a + "," + newVarName + "))");
				else
					print("size(" + a + "," + newVarName + ")");					
				
				print(newVarName + " in " + printInfo("\\nat", true));
			}
		}
		else if ($pre_gen.text.equals("\\dom")){
			if (memory.get("\\dom" + $e4.text) == null) {
				String newVarName = newVar();
				memory.put("\\dom" + $e4.text, newVarName);
				if (modoSetExpression != 0 )
					setExpressionVars.put("\\dom" + $e4.text, newVarName);
				types.put("\\dom" + $e4.text, "\\power(" + getChildType(types.get($e4.text), 0) + ")");
				
				String e = memory.get($e4.text);
				
				//Chequeamos si e es una lista, estas son tratadas de forma diferente
				String type = getType(types.get($e4.text));
				if (isSequence(type))
					print("ddom_list(" + e + "," + newVarName + ")");
				else
					print("dom(" + e + "," + newVarName + ")");
			}
		}
		else if ($pre_gen.text.equals("\\ran")){
			if (memory.get("\\ran" + $e4.text) == null) {
				String newVarName = newVar();
				memory.put("\\ran" + $e4.text, newVarName);
				if (modoSetExpression != 0 )
					setExpressionVars.put("\\ran" + $e4.text, newVarName);
				types.put("\\ran" + $e4.text, "\\power(" + getChildType(types.get($e4.text), 1) + ")");
				
				String e = memory.get($e4.text);
				
				//Chequeamos si e es una lista, estas son tratadas de forma diferente
				String type = getType(types.get($e4.text));
				if (isSequence(type))
					print("list_to_set(" + e + "," + newVarName + ")");
				else
					print("ran(" + e + "," + newVarName + ")");
			}
		}
		else if ($pre_gen.text.startsWith("seq_{1}")) {
			String eType = types.get($e4.text);
			if (isBasic(eType))
				eType = $e4.text;
		
			types.put($pre_gen.text + $e4.text, "\\seq_{1}" + eType);
		}
		else if ($pre_gen.text.equals("\\seq")) {
			String eType = types.get($e4.text);
			if (isBasic(eType))
				eType = $e4.text;
		
			types.put("\\seq" + $e4.text, "\\seq" + eType);
		}
		else if ($pre_gen.text.equals("\\bigcup")){
			if (memory.get("\\bigcup" + $e4.text) == null) {
				String newVarName = newVar();
				memory.put("\\bigcup" + $e4.text, newVarName);
				if (modoSetExpression != 0 )
					setExpressionVars.put("\\bigcup" + $e4.text, newVarName);
				types.put("\\bigcup" + $e4.text, getChildType(types.get($e4.text), 0));
				
				String e = memory.get($e4.text);
				print("bun(" + e + "," + newVarName + ")");
			}
		}
		else if ($pre_gen.text.equals("\\bigcap")){
			if (memory.get("\\bigcap" + $e4.text) == null) {
				String newVarName = newVar();
				memory.put("\\bigcap" + $e4.text, newVarName);
				if (modoSetExpression != 0 )
					setExpressionVars.put("\\bigcap" + $e4.text, newVarName);
				types.put("\\bigcap" + $e4.text, getChildType(types.get($e4.text), 0));
				
				String e = memory.get($e4.text);
				print("bdinters(" + e + "," + newVarName + ")");
			}
		}
		else if ($pre_gen.text.startsWith("min")){
			if (memory.get($pre_gen.text + $e4.text) == null) {
				String newVarName = newVar();
				memory.put($pre_gen.text + $e4.text, newVarName);
				if (modoSetExpression != 0 )
					setExpressionVars.put($pre_gen.text + $e4.text, newVarName);
				types.put($pre_gen.text + $e4.text, getChildType(types.get($e4.text), 0));
				
				String e = memory.get($e4.text);
				print("prolog_call(min(" + e + "," + newVarName + "))");
			}
		}
		else if ($pre_gen.text.startsWith("max")){
			if (memory.get($pre_gen.text + $e4.text) == null) {
				String newVarName = newVar();
				memory.put($pre_gen.text + $e4.text, newVarName);
				if (modoSetExpression != 0 )
					setExpressionVars.put($pre_gen.text + $e4.text, newVarName);
				types.put($pre_gen.text + $e4.text, getChildType(types.get($e4.text), 0));
				
				String e = memory.get($e4.text);
				print("max(" + e + "," + newVarName + ")");
			}
		}
	}
	|	e4=expression4 IMGSTART e0=expression0 IMGEND (DECORATION)?
	{
		String a, b;
		a = memory.get($e4.text);
		b = memory.get($e0.text);
		
		if (memory.get($e4.text + $IMGSTART.text + $e0.text + $IMGEND.text + $DECORATION.text) == null) {
			String newVarName = newVar();
			print("rimg(" + a + "," + b + "," + newVarName + ")");
			memory.put($e4.text + $IMGSTART.text + $e0.text + $IMGEND.text + $DECORATION.text, newVarName);
			String type1 = types.get($e4.text);
			String type = "\\power(" + getChildType(type1, 1) + ")";
			types.put($e4.text + $IMGSTART.text + $e0.text + $IMGEND.text + $DECORATION.text, type);
			typeInfo(newVarName, type);
			if (modoSetExpression != 0 )
				setExpressionVars.put($e4.text + $IMGSTART.text + $e0.text + $IMGEND.text + $DECORATION.text, newVarName);
		}
	}
	|	expression3
	;
	
expression3
	locals [ArrayList<String> elements = new ArrayList<String>(), String setlogName = "", String zName = "", String operator = "",
	String newVarName1 = "", String newVarName2 = ""]
	:	e3=expression3 DECORATION? e4=expression4
	{
		String a, b;
		a = memory.get($e3.text);
		b = memory.get($e4.text);
		String op = "";
		if ($DECORATION.text != null) op = "~";
		
		//Si a es una lista, debo convertirla
		a = convertToSet($e3.text, a);
		
		if (memory.get($e3.text + op + $e4.text) == null) {
			String newVarName = newVar();
			memory.put($e3.text + op + $e4.text, newVarName);
			
			if (modoSetExpression != 0 )
				setExpressionVars.put($e3.text + op + $e4.text, newVarName);

			String type1 = types.get($e3.text);
			//getType(type1);
			String newVarType = leftAndRightTypes(type1).get(1);
			types.put($e3.text + op + $e4.text, newVarType);
			print("apply(" + a + "," + b + "," + newVarName + ")");
			
			//Imprimimos la informacion del tipo de la variable
			typeInfo(newVarName, newVarType);
		}
	}
	|	expression4
	;
	
expression4
	locals [ArrayList<String> elements = new ArrayList<String>(), String setlogName = "", String zName = "", String operator = "",
	String newVarName1 = "", String newVarName2 = ""]
	:	NAME
	{
		if (memory.get($NAME.text) == null)
		{
			String newVarName = newVar($NAME.text);
			
			memory.put($NAME.text, newVarName);
			if (modoSetExpression != 0 )
				setExpressionVars.put($NAME.text, newVarName);
		}
	}
	|	NUM
	{
		if (memory.get($NUM.text) == null) {
			memory.put($NUM.text, $NUM.text);
			types.put($NUM.text, "\\num");
		}
	}
	|	'\\emptyset'
	{
		if (memory.get("\\emptyset") == null) {
			memory.put("\\emptyset", "{}");
			types.put("\\emptyset", "\\power(" + "generic" + ")");
		}
	}
	|	//set extension
		SETSTART (a=expression {$elements.add($a.text);})? (',' b=expression {$elements.add($b.text);})* SETEND
	{	
		$zName = $SETSTART.text;
		String type = new String();
		//Llenamos elements y ponemos cada expression en la memory
		while( !$elements.isEmpty() ){
			String e = $elements.remove(0);
			if (type.equals("")) {
				type = types.get(e);
			}
			$zName = $zName.concat(e);
			//guardamos tambien las traducciones del conjunto
			$setlogName = $setlogName.concat(memory.get(e));
			
			if (!$elements.isEmpty()){
				$zName = $zName + ",";
				$setlogName = $setlogName + ",";
			}
		}
		$zName = $zName + $SETEND.text;
		if (memory.get($zName) == null) {
			memory.put($zName, "{" + $setlogName + "}");
			if ($setlogName.equals(""))
				types.put($zName, "\\power(" + "generic" + ")");
			else
				types.put($zName, "\\power(" + type + ")");
		}
	}
	|	SETSTART {modoSetExpression=1; setExpressionDecl = ""; setExpressionPred = ""; setExpressionExpr = ""; setExpressionVars = new HashMap();}
	    declPart {$zName = $SETSTART.text + $declPart.text;}
	    ( '|'{modoSetExpression=2;} predicate {$zName = $zName.concat("|" + $predicate.text);})?
	    ( '@' {modoSetExpression=3;} c=expression {$zName = $zName.concat("@" + $c.text);})?
	    SETEND {modoSetExpression=0; $zName = $zName.concat($SETEND.text);} 
	    
	    //Faltan crean nuevas variables, es decir, nuevos nombres
	{
		if (memory.get($zName)==null) {
		
			// Probando eliminar la variable extra y usar '=' en vez de 'is' cuando corresponde
			String varName = memory.get($c.text);
			String op = getType(types.get($c.text));
			if (isNumeric(op))
				op = " is ";
			else
				op = " = ";
			
			boolean needsNewName = false;
			if ((varName == null) || (varName.matches("^.*[^a-zA-Z0-9 ].*$"))) { //Si es nulo o tiene caracteres que no son letras o numeros
				varName = newVar();
				needsNewName = true;
			}
		
			$setlogName = "";
			$newVarName2 = newVar();
			
			$setlogName = $setlogName.concat("{ " + varName + " :exists([");
			
			Collection<String> values = setExpressionVars.values();
			if (!needsNewName)
				values.remove(varName);
			
			Iterator<String> valuesIt = values.iterator();
			while (valuesIt.hasNext()){
				((Expression4Context)_localctx).setlogName =  _localctx.setlogName.concat(valuesIt.next());
				if (valuesIt.hasNext()) ((Expression4Context)_localctx).setlogName =  _localctx.setlogName.concat(",");
			}
		
			String content = setExpressionDecl + setExpressionPred + setExpressionExpr;
			content = content.substring(content.indexOf('&') + 1);
			if (!content.equals("") && needsNewName)
				content = content.concat(" & ");
			
			$setlogName = $setlogName.concat("], " + content);
			if (needsNewName)
				$setlogName = $setlogName.concat(varName + op + memory.get($c.text));
			$setlogName = $setlogName.concat(")" + " }");
		
			memory.put($zName, $newVarName2);
			types.put($zName, "\\power(" + types.get($c.text) + ")"); //REVISAR!!!
			print($newVarName2 + " = " + $setlogName);
			
			Iterator<String> keysIt = setExpressionVars.keySet().iterator();
			while (keysIt.hasNext()){
				String var = keysIt.next();
				memory.remove(var);
				keysIt.remove();
				//setExpressionVars.remove(var);
			}
		}
	}
	|	'\\lblot' {setExpressionVars = new HashMap();} (n=NAME '==' e=expression {setExpressionVars.put($n.text, $e.text);} (',')?)+ '\\rblot' //Tipos schema
	{
		$setlogName = "[";
		List<String> sortedVars = new ArrayList<String>(setExpressionVars.keySet());
		java.util.Collections.sort(sortedVars);
		
		int i = 0;
		while( i < sortedVars.size() ){
			String value = setExpressionVars.get(sortedVars.get(i));

			$setlogName = $setlogName.concat(value);
			
			if (i+1 < sortedVars.size()){
				$setlogName = $setlogName.concat(",");
			}
			i++;
		}
		
		$setlogName = $setlogName.concat("]");
		
		if (memory.get($expression4.text) == null) {
			memory.put($expression4.text, $setlogName);
			types.put($expression4.text, "\\seq(" + "generic" + ")");
		}
	}
	|	//list extension
		(DECORATION)? LISTSTART (a=expression {$elements.add($a.text);})? (',' b=expression {$elements.add($b.text);})* LISTEND
	{	
		if ($DECORATION.text != null)
			$zName = $DECORATION.text;
		$zName = $zName.concat($LISTSTART.text);
		String type = new String();
		//Llenamos elements y ponemos cada expression en la memory
		while( !$elements.isEmpty() ){
			String e = $elements.remove(0);
			if (type.equals("")) {
				type = types.get(e);
			}
			$zName = $zName.concat(e);
			//guardamos tambien las traducciones del conjunto
			$setlogName = $setlogName.concat(memory.get(e));
			
			if (!$elements.isEmpty()){
				$zName = $zName + ",";
				$setlogName = $setlogName + ",";
			}
		}
		$zName = $zName + $LISTEND.text;
		if (memory.get($zName) == null) {
			memory.put($zName, "[" + $setlogName + "]");
			if ($setlogName.equals(""))
				types.put($zName, "\\seq(" + "generic" + ")");
			else
				types.put($zName, "\\seq(" + type + ")");
		}
	}
	|	//tuple
		'(' a=expression {$elements.add($a.text);} (',' b=expression {$elements.add($b.text);})+ ')'
	{	
		$zName = "(";
		String type = new String();
		//Llenamos elements y ponemos cada expression en la memory
		while( !$elements.isEmpty() ){
			String e = $elements.remove(0);
			if (type.equals(""))
				type = "(" + types.get(e) + ")";
			else
				type = type.concat("\\cross(" + types.get(e) + ")");
				 
			$zName = $zName.concat(e);
			//guardamos tambien las traducciones del conjunto
			$setlogName = $setlogName.concat(memory.get(e));
			
			if (!$elements.isEmpty()){
				$zName = $zName + ",";
				$setlogName = $setlogName + ",";
			}
		}
		$zName = $zName + ")";
		if (memory.get($zName) == null) {
			memory.put($zName, "[" + $setlogName + "]");
			types.put($zName, type);
		}
	}
	|	e41=expression4 '.' e42=expression4
	{
		if (memory.get($e41.text + "." + $e42.text) == null) {
		
			String e1Type = types.get($e41.text);
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
				while (!vars[position-1].contains($e42.text + ":")) //Se resta 1 porque en setlog empiezan en 1, no en 0 como en java
					position++;
				//Creamos una nueva variable
				String newVarName = newVar();
				//Vemos su tipo
				String type = vars[position-1].substring($e42.text.length()+1);
				memory.put($e41.text + "." + $e42.text, newVarName);
				if (modoSetExpression != 0 )
					setExpressionVars.put($e41.text + "." + $e42.text, newVarName);
				types.put($e41.text + "." + $e42.text, type);
				print("nth1(" + position + "," + memory.get($e41.text) + "," + newVarName + ")");
				
				typeInfo(newVarName, type);
				
			}
		}
	}
	|	e4=expression4 post_fun
	{
		String a;
		a = memory.get($e4.text);
		String op = $post_fun.text;
		
		if (memory.get($e4.text + op) == null) {
		
			String newVarName = newVar();
		
			if (op.startsWith("\\inv")){
				//Si a es una lista, debo convertirla
				a = convertToSet($e4.text, a);
			
				print("inv(" + newVarName + "," + a + ")");
				memory.put($e4.text + op, newVarName);
				String type = types.get($e4.text);
				if (isSequence(getType(type)))
					type = "\\power(\\nat\\cross(" + leftAndRightTypes(type).get(1) + "))";
				type = invertType(type); 
				types.put($e4.text + op, type);
				typeInfo(newVarName, type);
				if (modoSetExpression != 0 )
					setExpressionVars.put($e4.text + op, newVarName);
			}
		}
	}
	|	'(' e0=expression0 ')'
	{
		String a = memory.get($e0.text);
		
		//Chequeo el nombre para ver si se trata de una sola variable, en ese caso no guardo en la memoria
		//los parentesis, en otro caso si
		
		if (a != null) { //Si no estoy en la parte de declaracion
			Pattern p = Pattern.compile("[^a-zA-Z0-9_]");
			boolean hasSpecialChar = p.matcher(a).find();
			
			if (hasSpecialChar){
				memory.put("(" + $e0.text + ")", "(" + a + ")");
				if (types.get($e0.text) != null) {
					types.put("(" + $e0.text + ")", types.get($e0.text));
				}
			}
			else {
				memory.put("(" + $e0.text + ")", a);
				if (types.get($e0.text) != null) {
					types.put("(" + $e0.text + ")", types.get($e0.text));
				}
			}
		} else  //Si estoy en la parte de declaracion
			if (types.get($e0.text) != null)
				types.put("(" + $e0.text + ")", "(" + types.get($e0.text) + ")");
	}
	|	'\\nat' '_{1}' 
	{	
		printInfo($expression4.text, false);	
	}
	|	'\\nat' 
	{	
		printInfo($expression4.text, false);	
	}
	|	'\\num'
	{	
		printInfo($expression4.text, false);	
	}
	;
	


NAME:	('a'..'z' | 'A'..'Z' | '\\_ ' | '?' )+ ('a'..'z' | 'A'..'Z' | '\\_ ' | '?' | '0'..'9')*;
NUM:	'0'..'9'+ ;

IN_FUN_P3: ('+' | '-' | '\\cup' | '\\setminus' | '\\cat')	;
IN_FUN_P4: ('*' | '\\div' | '\\mod' | '\\cap' | '\\comp' | '\\circ' | '\\extract' | '\\filter')	;
IN_FUN_P5: ('\\oplus')	;
IN_FUN_P6: ('\\dres' | '\\rres' | '\\ndres' | '\\nrres')	;

post_fun: '\\inv' (DECORATION)?	;

IN_GEN: ('\\rel' | '\\pfun' | '\\fun' | '\\ffun') ;
pre_gen: ( '\\ran' | '\\dom' | 'seq_{1}' DECORATION | '\\seq' | '\\#' | '\\bigcup' | '\\bigcup' | 'max' DECORATION | 'min' DECORATION)	;

seq_op: ('rev' | 'head' | 'last' | 'tail' | 'front' | 'squash') DECORATION ;

DECORATION: '~' ;

NL:	'\r'? '\n' ;
WS: 	(' '|'\t'|'\r')+ {skip();} ;
SETSTART: '\\{';
SETEND: '\\}';
LISTSTART: '\\langle';
LISTEND: '\\rangle';
IMGSTART: '\\limg';
IMGEND: '\\rimg';
SKIP:	'\\' '\\' {skip();} ;