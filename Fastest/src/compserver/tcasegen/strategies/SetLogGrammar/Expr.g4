grammar Expr;

//Gramatica utilizada para la creacion, a partir de una clase de prueba Z, la entrada necesaria
//para setlog. Es parte del proceso de generacion de casos de prueba.

@header {
	package compserver.tcasegen.strategies.SetLogGrammar;
	import java.util.HashMap;
	import java.util.ArrayList;
	import java.util.regex.Matcher;
	import java.util.regex.Pattern;
	import javax.swing.tree.DefaultMutableTreeNode;
}

@members {
	
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
		else if (rootType.equals("\\seq")) { //Entonces empieza con pfun, rel etc

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
				type = type.split(":")[1];
				print(var + " in " + type);
				return type;
			}
		
			String nodeType = getType(type);
			
			if (nodeType.equals("\\seq"))
				printAtEnd("list(" + var + ")");
			else if (nodeType.equals("\\rel"))
				printAtEnd("is_rel(" + var + ")");
			else if (nodeType.equals("\\pfun"))
				printAtEnd("is_pfun(" + var + ")");
			else if (nodeType.equals("\\fun"))
				printAtEnd("is_fun(" + var + ")");
			else if (type.equals("\\nat") || type.equals("\\num"))
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
					type = type.split(":")[1];
					print(var + " in " + type);
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
     */
	}
	;

paragraph
	//Aceptamos 3 tipos de schemas: la clase de prueba (schema), los tipos esquema necesarios (schemaType) y
	//las definiciones de tipos basicos y enumerados
	:	'\\begin{' ('schema' | ('schemaType' {tipoSchema = 1; schemaTypeVars = "";})) '}{' NAME '}'
		schemaText
		{
			if (tipoSchema == 1) {
				String newVarName = newVar($NAME.text);
				memory.put($NAME.text, newVarName);
				types.put($NAME.text, "SchemaType:" + newVarName + ":[" + schemaTypeVars + "]");
				schemaTypeVars = "";
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
			elements = elements.concat(e);
			
			memory.put(e,e); //REVISAR!!!
			
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
				setExpressionVars.put(var, newVarName); //Falta ver que hacemos para variables ligadas con el mismo nombre en distintas ligaduras
			
			String expType = types.get($expression.text);
			expType = typeInfo(newVarName, expType);
			
			if (tipoSchema == 0)
				types.put(var, expType);
			else { //La agregamos como variable del esquema
				if (!schemaTypeVars.equals(""))
					schemaTypeVars = schemaTypeVars.concat(",");
				schemaTypeVars = schemaTypeVars.concat(var + ":" + expType);
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
		
		print(a + " in " + b);
	/*	//Impresion de tipo
		String type = types.get($e2.text);
		if (type != null)
			if (type.equals("\\power\\num") || type.equals("\\power\\nat"))
				print(a + " in " + memory.get(type.substring(6)));*/
	}
	|	(e1=expression '\\notin' e2=expression | '\\lnot' e1=expression '\\in' e2=expression)
	{
		String a, b;
		a = memory.get($e1.text);
		b = memory.get($e2.text);
		print(a + " nin " + b);
		/*
		//Impresion de tipo
		String type = types.get($e2.text);
		if (type != null)
			if (type.equals("\\power\\num") || type.equals("\\power\\nat"))
				print(a + " in " + memory.get(type.substring(6)));*/
	}
	|	e1=expression '<' e2=expression
	{
		String a, b;
		a = memory.get($e1.text);
		b = memory.get($e2.text);
		print(a + " < " + b);
	}
	|	e1=expression '>' e2=expression
	{
		String a, b;
		a = memory.get($e1.text);
		b = memory.get($e2.text);
		print(a + " > " + b);
	}
	|	e1=expression '\\leq' e2=expression
	{
		String a, b;
		a = memory.get($e1.text);
		b = memory.get($e2.text);
		print(a + " =< " + b);
	}
	|	e1=expression '\\geq' e2=expression
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
	|	e1=expression '\\subseteq' e2=expression
	{
		String a, b;
		a = memory.get($e1.text);
		b = memory.get($e2.text);
		print("dsubset(" + a + "," + b + ")");
	}
	|	'\\lnot' e1=expression '\\subseteq' e2=expression
	{
		String a, b;
		a = memory.get($e1.text);
		b = memory.get($e2.text);
		print("dnsubset(" + a + "," + b + ")");
	}
	|	e1=expression '\\subset' e2=expression
	{
		String a, b;
		a = memory.get($e1.text);
		b = memory.get($e2.text);
		print("dssubset(" + a + "," + b + ")");
	}
	|	'\\lnot' e1=expression '\\subset' e2=expression
	{
		String a, b;
		a = memory.get($e1.text);
		b = memory.get($e2.text);
		String c = memory.get( $e1.text + "\\cap" + $e2.text);
		if (c == null) {
			c = newVar();
			memory.put( $e1.text + "\\cap" + $e2.text, c);
			print("dinters(" + a + "," + b + "," + c + ")");
			String type = types.get($e1.text);
			types.put($e1.text + "\\cap" + $e2.text, type);
			typeInfo(c, type);
		}
		
		print(c + " neq " + a);
	}
	|	e1=expression '\\neq' e2=expression
	{
		String a, b;
		a = memory.get($e1.text);
		b = memory.get($e2.text);
		print(a + " neq " + b);
	}
	|	e1=expression '\\prefix' e2=expression
	{
		String a, b;
		a = memory.get($e1.text);
		b = memory.get($e2.text);
		print("prolog_call(append(" + a + ",_," + b + "))");
	}
	|	e1=expression '\\suffix' e2=expression
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
	
expression
locals [ArrayList<String> elements = new ArrayList<String>(), String setlogName = "", String zName = "", String operator = "",
	String newVarName1 = "", String newVarName2 = ""]
	:	a=expression IN_GEN b=expression 
	{
		//Guardo el tipo
		String aType = types.get($a.text);
		if (isBasic(aType)) {
			aType = $a.text;
		}
		String bType = types.get($b.text);
		if (isBasic(bType))
			bType = $b.text;
		
		if ($IN_GEN.text.equals("\\ffun"))
			types.put($a.text + $IN_GEN.text + $b.text, aType + "\\pfun" + bType );
		else
			types.put($a.text + $IN_GEN.text + $b.text, aType + $IN_GEN.text + bType );
	}
	|	e1=expression {$expression::elements.add($e1.text);} ('\\cross' e2=expression {$expression::elements.add($e2.text);})+
	{
		String unfoldedType = "";
		
		//Para cada exp realizamos el procesamiento
		while( !$expression::elements.isEmpty() ) {
			String exp = $expression::elements.remove(0);
			
			$zName = $zName.concat(exp);
			
			String expType = types.get(exp);
			if (isBasic(expType))
				unfoldedType = unfoldedType.concat(exp);
			else
				unfoldedType = unfoldedType.concat(expType);
				
			if (!$expression::elements.isEmpty()) {
				$zName = $zName.concat("\\cross");
				unfoldedType = unfoldedType.concat("\\cross");
			}
		}
		
		types.put($zName, unfoldedType);
	}
	|	seq_op e=expression
	{
		String a;
		a = memory.get($e.text);
		
		if (memory.get( $seq_op.text + $e.text) == null) {
		
			String newVarName = newVar();
		
			if ($seq_op.text.startsWith("rev")){
				print("prolog_call(reverse(" + a + "," + newVarName + "))");
				memory.put($seq_op.text + $e.text, newVarName);
				String type = types.get($e.text);
				types.put($seq_op.text + $e.text, type);
				typeInfo(newVarName, type);
				if (modoSetExpression != 0 )
					setExpressionVars.put($seq_op.text + $e.text, newVarName);
			}
			else if ($seq_op.text.startsWith("head")){
				print("nth1(1," + a + "," + newVarName + ")");
				memory.put($seq_op.text + $e.text, newVarName);
				String type = getChildType(types.get($e.text), 0);
				types.put($seq_op.text + $e.text, type);
				typeInfo(newVarName, type);
				if (modoSetExpression != 0 )
					setExpressionVars.put($seq_op.text + $e.text, newVarName);
			}
			else if ($seq_op.text.startsWith("last")){
				print("prolog_call(last(" + a + "," + newVarName + "))");
				memory.put($seq_op.text + $e.text, newVarName);
				String type = getChildType(types.get($e.text), 0);
				types.put($seq_op.text + $e.text, type);
				typeInfo(newVarName, type);
				if (modoSetExpression != 0 )
					setExpressionVars.put($seq_op.text + $e.text, newVarName);
			}
			else if ($seq_op.text.startsWith("tail")){
				print("prolog_call(drop(1," + a + "," + newVarName + "))");
				memory.put($seq_op.text + $e.text, newVarName);
				String type = types.get($e.text);
				types.put($seq_op.text + $e.text, type);
				typeInfo(newVarName, type);
				if (modoSetExpression != 0 )
					setExpressionVars.put($seq_op.text + $e.text, newVarName);
			}
			else if ($seq_op.text.startsWith("front")){
				String n = newVar();
				print("prolog_call(length(" + a + "," + n + "))");
				if (memory.get("\\nat") == null) {
					memory.put("\\nat", "NAT");
					print("NAT = int(0, 10000000000)");
					types.put("\\nat", "\\nat");
				}
				print(n + " in NAT");
				print("prolog_call(take(" + n + "-1" + "," + a + "," + newVarName + "))");
				memory.put($seq_op.text + $e.text, newVarName);
				String type = types.get($e.text);
				types.put($seq_op.text + $e.text, type);
				typeInfo(newVarName, type);
				if (modoSetExpression != 0 )
					setExpressionVars.put($seq_op.text + $e.text, newVarName);
			}
			else if ($seq_op.text.startsWith("squash")){
				print("squash(" + a + "," + newVarName + ")");
				memory.put($seq_op.text + $e.text, newVarName);
				String type = types.get($e.text);
				ArrayList<String> leftAndRight = leftAndRightTypes(type);
				type = "\\seq(" + leftAndRight.get(1) + ")";
				types.put($seq_op.text + $e.text, type);
				typeInfo(newVarName, type);
				if (modoSetExpression != 0 )
					setExpressionVars.put($seq_op.text + $e.text, newVarName);
			}
		}
	}	
	|	e1=expression IN_FUN_P6 e2=expression
	{
		String a, b;
		a = memory.get($e1.text);
		b = memory.get($e2.text);
		
		if (memory.get($e1.text + $IN_FUN_P6.text + $e2.text) == null) {
		
			String newVarName = newVar();
		
			if ($IN_FUN_P6.text.equals("\\dres")){
					print("dres(" + a + "," + b + "," + newVarName + ")");
					memory.put($e1.text + "\\dres" + $e2.text, newVarName);
					String type2 = types.get($e2.text);
					ArrayList<String> leftAndRight = leftAndRightTypes(type2);
					String type = "\\power((" + leftAndRight.get(0) + ")\\cross(" + leftAndRight.get(1) + "))";
					types.put($e1.text + "\\dres" + $e2.text, type);
					typeInfo(newVarName, type);
					if (modoSetExpression != 0 )
						setExpressionVars.put($e1.text + "\\dres" + $e2.text, newVarName);
			}
			else if ($IN_FUN_P6.text.equals("\\ndres")){
					print("ndres(" + a + "," + b + "," + newVarName + ")");
					memory.put($e1.text + "\\ndres" + $e2.text, newVarName);
					String type2 = types.get($e2.text);
					ArrayList<String> leftAndRight = leftAndRightTypes(type2);
					String type = "\\power((" + leftAndRight.get(0) + ")\\cross(" + leftAndRight.get(1) + "))";
					types.put($e1.text + "\\ndres" + $e2.text, type);
					typeInfo(newVarName, type);
					if (modoSetExpression != 0 )
						setExpressionVars.put($e1.text + "\\ndres" + $e2.text, newVarName);
			}
			else if ($IN_FUN_P6.text.equals("\\rres")){
					print("rres(" + b + "," + a + "," + newVarName + ")");
					memory.put($e1.text + "\\rres" + $e2.text, newVarName);
					String type1 = types.get($e1.text);
					ArrayList<String> leftAndRight = leftAndRightTypes(type1);
					String type = "\\power((" + leftAndRight.get(0) + ")\\cross(" + leftAndRight.get(1) + "))";
					types.put($e1.text + "\\rres" + $e2.text, type);
					typeInfo(newVarName, type);
					if (modoSetExpression != 0 )
						setExpressionVars.put($e1.text + "\\rres" + $e2.text, newVarName);
			}
			else if ($IN_FUN_P6.text.equals("\\nrres")){
					print("nrres(" + b + "," + a + "," + newVarName + ")");
					memory.put($e1.text + "\\nrres" + $e2.text, newVarName);
					String type1 = types.get($e1.text);
					ArrayList<String> leftAndRight = leftAndRightTypes(type1);
					String type = "\\power((" + leftAndRight.get(0) + ")\\cross(" + leftAndRight.get(1) + "))";
					types.put($e1.text + "\\nrres" + $e2.text, type);
					typeInfo(newVarName, type);
					if (modoSetExpression != 0 )
						setExpressionVars.put($e1.text + "\\nrres" + $e2.text, newVarName);
			}
		}
	}
	|	e1=expression IN_FUN_P5 e2=expression
	{
		String a, b;
		a = memory.get($e1.text);
		b = memory.get($e2.text);
		
		if (memory.get($e1.text + $IN_FUN_P5.text + $e2.text) == null) {
		
			String newVarName = newVar();
		
			if ($IN_FUN_P5.text.equals("\\oplus")){
					print("oplus(" + a + "," + b + "," + newVarName + ")");
					memory.put($e1.text + "\\oplus" + $e2.text, newVarName);
					String type1 = types.get($e1.text);
					ArrayList<String> leftAndRight = leftAndRightTypes(type1);
					String type = "\\power((" + leftAndRight.get(0) + ")\\cross(" + leftAndRight.get(1) + "))";
					types.put($e1.text + "\\oplus" + $e2.text, type);
					typeInfo(newVarName, type);
					if (modoSetExpression != 0 )
						setExpressionVars.put($e1.text + "\\oplus" + $e2.text, newVarName);
			}
		}
	}
	|	e1=expression IN_FUN_P4 e2=expression
	{
		String a, b;
		a = memory.get($e1.text);
		b = memory.get($e2.text);
		
		if (memory.get($e1.text + $IN_FUN_P4.text + $e2.text) == null) {
		
			String newVarName = newVar();
			Boolean isNumeric = false; 
		
			if ($IN_FUN_P4.text.equals("*")){
				print( newVarName + " is " + a + "*" + b );
				memory.put($e1.text + "*" + $e2.text, newVarName);
				if (modoSetExpression != 0 )
					setExpressionVars.put($e1.text + "*" + $e2.text, newVarName);
				isNumeric = true;
			}
			else if ($IN_FUN_P4.text.equals("\\div")) {
				print( newVarName + " is div(" + a + "," + b + ")" );
				memory.put($e1.text + "\\div" + $e2.text, newVarName);
				if (modoSetExpression != 0 )
					setExpressionVars.put($e1.text + "\\div" + $e2.text, newVarName);
				isNumeric = true;
			}
			else if ($IN_FUN_P4.text.equals("\\mod")){
				print( newVarName + " is mod(" + a + "," + b + ")" );
				memory.put($e1.text + "\\mod" + $e2.text, newVarName);
				if (modoSetExpression != 0 )
					setExpressionVars.put($e1.text + "\\mod" + $e2.text, newVarName);
				isNumeric = true;
			}
			else if ($IN_FUN_P4.text.equals("\\cap")){
					print("dinters(" + a + "," + b + "," + newVarName + ")");
					memory.put($e1.text + "\\cap" + $e2.text, newVarName);
					String type = types.get($e1.text);
					types.put($e1.text + "\\cap" + $e2.text, type);
					typeInfo(newVarName, type);
					if (modoSetExpression != 0 )
						setExpressionVars.put($e1.text + "\\cap" + $e2.text, newVarName);
			}
			else if ($IN_FUN_P4.text.equals("\\comp")){
					print("comp(" + a + "," + b + "," + newVarName + ")");
					memory.put($e1.text + "\\comp" + $e2.text, newVarName);
					String type1 = types.get($e1.text);
					String type2 = types.get($e2.text);
					String type = "\\power((" + getChildType(type1, 0) + ")\\cross(" + getChildType(type2, 1) + "))";
					types.put($e1.text + "\\comp" + $e2.text, type);
					typeInfo(newVarName, type);
					if (modoSetExpression != 0 )
						setExpressionVars.put($e1.text + "\\comp" + $e2.text, newVarName);
			}
			else if ($IN_FUN_P4.text.equals("\\circ")){
					print("circ(" + a + "," + b + "," + newVarName + ")");
					memory.put($e1.text + "\\circ" + $e2.text, newVarName);
					String type1 = getChildType(types.get($e1.text), 1);
					String type = "\\power((" + type1 + ")\\cross(" + type1 + "))";
					types.put($e1.text + "\\circ" + $e2.text, type);
					typeInfo(newVarName, type);
					if (modoSetExpression != 0 )
						setExpressionVars.put($e1.text + "\\circ" + $e2.text, newVarName);
			}
			else if ($IN_FUN_P4.text.equals("\\extract")){
					print("extract(" + a + "," + b + "," + newVarName + ")");
					memory.put($e1.text + "\\extract" + $e2.text, newVarName);
					String type = types.get($e2.text);
					types.put($e1.text + "\\extract" + $e2.text, type);
					typeInfo(newVarName, type);
					if (modoSetExpression != 0 )
						setExpressionVars.put($e1.text + "\\extract" + $e2.text, newVarName);
			}
			else if ($IN_FUN_P4.text.equals("\\filter")){
					print("filter(" + a + "," + b + "," + newVarName + ")");
					memory.put($e1.text + "\\filter" + $e2.text, newVarName);
					String type = types.get($e1.text);
					types.put($e1.text + "\\filter" + $e2.text, type);
					typeInfo(newVarName, type);
					if (modoSetExpression != 0 )
						setExpressionVars.put($e1.text + "\\filter" + $e2.text, newVarName);
			}
			
			if (isNumeric) {
				if (memory.get("\\num") == null) {
					memory.put("\\num", "NUM");
					print("NUM = int(-10000000000, 10000000000)");
					types.put("\\num", "\\num");
				}
				print(newVarName + " in NUM");
				types.put($e1.text + $IN_FUN_P4.text + $e2.text, "\\num");
			}
		}
	}
	|	e1=expression IN_FUN_P3 e2=expression
	{
		String a, b;
		a = memory.get($e1.text);
		b = memory.get($e2.text);
		
		if (memory.get($e1.text + $IN_FUN_P3.text + $e2.text) == null) {
		
			String newVarName = newVar();
			Boolean isNumeric = false; 
			
		
			if ($IN_FUN_P3.text.equals("+")){
				print( newVarName + " is " + a + "+" + b );
				memory.put($e1.text + "+" + $e2.text, newVarName);
				if (modoSetExpression != 0 )
					setExpressionVars.put($e1.text + "+" + $e2.text, newVarName);
				isNumeric = true;
			}
			else if ($IN_FUN_P3.text.equals("-")) {
				print( newVarName + " is " + a + "-" + b );
				memory.put($e1.text + "-" + $e2.text, newVarName);
				if (modoSetExpression != 0 )
					setExpressionVars.put($e1.text + "-" + $e2.text, newVarName);
				isNumeric = true;
			}
			else if ($IN_FUN_P3.text.equals("\\cup")){
					print("dun(" + a + "," + b + "," + newVarName + ")");
					memory.put($e1.text + "\\cup" + $e2.text, newVarName);
					String type = types.get($e1.text);
					types.put($e1.text + "\\cup" + $e2.text, type);
					typeInfo(newVarName, type);
					if (modoSetExpression != 0 )
						setExpressionVars.put($e1.text + "\\cup" + $e2.text, newVarName);
			}
			else if ($IN_FUN_P3.text.equals("\\setminus")){
					print("diff(" + a + "," + b + "," + newVarName + ")");
					memory.put($e1.text + "\\setminus" + $e2.text, newVarName);
					String type = types.get($e1.text);
					types.put($e1.text + "\\setminus" + $e2.text, type);
					typeInfo(newVarName, type);
					if (modoSetExpression != 0 )
						setExpressionVars.put($e1.text + "\\setminus" + $e2.text, newVarName);
			}
			else if ($IN_FUN_P3.text.equals("\\cat")){
					print("prolog_call(append(" + a + "," + b + "," + newVarName + "))");
					memory.put($e1.text + "\\cat" + $e2.text, newVarName);
					String type = types.get($e1.text);
					types.put($e1.text + "\\cat" + $e2.text, type);
					typeInfo(newVarName, type);
					if (modoSetExpression != 0 )
						setExpressionVars.put($e1.text + "\\cat" + $e2.text, newVarName);
			}
			
			if (isNumeric) {
				if (memory.get("\\num") == null) {
					memory.put("\\num", "NUM");
					print("NUM = int(-10000000000, 10000000000)");
					types.put("\\num", "\\num");
				}
				print(newVarName + " in NUM");
				types.put($e1.text + $IN_FUN_P3.text + $e2.text, "\\num");
			}
		}
	}
	|	e1=expression '\\upto' e2=expression //IN_FUN_2
	{
		String a, b;
		a = memory.get($e1.text);
		b = memory.get($e2.text);
		if (memory.get($e1.text + "\\upto" + $e2.text) == null) {
			String newVarName = newVar();
			memory.put($e1.text + "\\upto" + $e2.text, newVarName);
			if (modoSetExpression != 0 )
				setExpressionVars.put($e1.text + "\\upto" + $e2.text, newVarName);
			print(newVarName + " = int(" + a + "," + b + ")");
		}
	}
	|	e1=expression '\\mapsto' e2=expression //IN_FUN_1
	{
		String a, b;
		a = memory.get($e1.text);
		b = memory.get($e2.text);
		memory.put($e1.text + "\\mapsto" + $e2.text, "[" + a + "," + b + "]");
		types.put($e1.text + "\\mapsto" + $e2.text, types.get($e1.text) + "\\cross" + types.get($e2.text));
	}
	|	'\\power' e=expression
	{
		String eType = types.get($e.text);
		if (isBasic(eType))
			eType = $e.text;
	
		types.put("\\power" + $e.text, "\\power" + eType );
	}
	|	pre_gen e=expression //Pre-Gen
	{
		String a;
		a = memory.get($e.text);
		
		if ($pre_gen.text.equals("\\#")){
			if (memory.get("\\#" + $e.text) == null) {
				String newVarName = newVar();
				memory.put("\\#" + $e.text, newVarName);
				types.put("\\#" + $e.text, "\\nat");
				if (modoSetExpression != 0 )
					setExpressionVars.put("\\#" + $e.text, newVarName);
					
				String type = getType(types.get($e.text));
				if (type.equals("\\seq"))
					print("prolog_call(length(" + a + "," + newVarName + "))");
				else
					print("size(" + a + "," + newVarName + ")");					
				
				if (memory.get("\\nat") == null) {
					memory.put("\\nat", "NAT");
					print("NAT = int(0, 10000000000)");
					types.put("\\nat", "\\nat");
				}
				print(newVarName + " in NAT");
			}
		}
		else if ($pre_gen.text.equals("\\dom")){
			if (memory.get("\\dom" + $e.text) == null) {
				String newVarName = newVar();
				memory.put("\\dom" + $e.text, newVarName);
				if (modoSetExpression != 0 )
					setExpressionVars.put("\\dom" + $e.text, newVarName);
				types.put("\\dom" + $e.text, "\\power(" + getChildType(types.get($e.text), 0) + ")");
				
				String e = memory.get($e.text);
				
				//Chequeamos si e es una lista, estas son tratadas de forma diferente
				String type = getType(types.get($e.text));
				if (type.equals("\\seq"))
					print("ddom_list(" + e + "," + newVarName + ")");
				else
					print("dom(" + e + "," + newVarName + ")");
			}
		}
		else if ($pre_gen.text.equals("\\ran")){
			if (memory.get("\\ran" + $e.text) == null) {
				String newVarName = newVar();
				memory.put("\\ran" + $e.text, newVarName);
				if (modoSetExpression != 0 )
					setExpressionVars.put("\\ran" + $e.text, newVarName);
				types.put("\\ran" + $e.text, "\\power(" + getChildType(types.get($e.text), 1) + ")");
				
				String e = memory.get($e.text);
				
				//Chequeamos si e es una lista, estas son tratadas de forma diferente
				String type = getType(types.get($e.text));
				if (type.equals("\\seq"))
					print("list_to_set(" + e + "," + newVarName + ")");
				else
					print("ran(" + e + "," + newVarName + ")");
			}
		}
		else if ($pre_gen.text.equals("\\seq")) {
			String eType = types.get($e.text);
			if (isBasic(eType))
				eType = $e.text;
		
			types.put("\\seq" + $e.text, "\\seq" + eType);
		}
		else if ($pre_gen.text.equals("\\bigcup")){
			if (memory.get("\\bigcup" + $e.text) == null) {
				String newVarName = newVar();
				memory.put("\\bigcup" + $e.text, newVarName);
				if (modoSetExpression != 0 )
					setExpressionVars.put("\\bigcup" + $e.text, newVarName);
				types.put("\\bigcup" + $e.text, getChildType(types.get($e.text), 0));
				
				String e = memory.get($e.text);
				print("bun(" + e + "," + newVarName + ")");
			}
		}
		else if ($pre_gen.text.equals("\\bigcap")){
			if (memory.get("\\bigcap" + $e.text) == null) {
				String newVarName = newVar();
				memory.put("\\bigcap" + $e.text, newVarName);
				if (modoSetExpression != 0 )
					setExpressionVars.put("\\bigcap" + $e.text, newVarName);
				types.put("\\bigcap" + $e.text, getChildType(types.get($e.text), 0));
				
				String e = memory.get($e.text);
				print("bdinters(" + e + "," + newVarName + ")");
			}
		}
		else if ($pre_gen.text.startsWith("min")){
			if (memory.get($pre_gen.text + $e.text) == null) {
				String newVarName = newVar();
				memory.put($pre_gen.text + $e.text, newVarName);
				if (modoSetExpression != 0 )
					setExpressionVars.put($pre_gen.text + $e.text, newVarName);
				types.put($pre_gen.text + $e.text, getChildType(types.get($e.text), 0));
				
				String e = memory.get($e.text);
				print("prolog_call(min(" + e + "," + newVarName + "))");
			}
		}
		else if ($pre_gen.text.startsWith("max")){
			if (memory.get($pre_gen.text + $e.text) == null) {
				String newVarName = newVar();
				memory.put($pre_gen.text + $e.text, newVarName);
				if (modoSetExpression != 0 )
					setExpressionVars.put($pre_gen.text + $e.text, newVarName);
				types.put($pre_gen.text + $e.text, getChildType(types.get($e.text), 0));
				
				String e = memory.get($e.text);
				print("max(" + e + "," + newVarName + ")");
			}
		}
	}
	|	e1=expression IMGSTART e2=expression IMGEND (DECORATION)?
	{
		String a, b;
		a = memory.get($e1.text);
		b = memory.get($e2.text);
		
		if (memory.get($e1.text + $IMGSTART.text + $e2.text + $IMGEND.text + $DECORATION.text) == null) {
			String newVarName = newVar();
			print("rimg(" + a + "," + b + "," + newVarName + ")");
			memory.put($e1.text + $IMGSTART.text + $e2.text + $IMGEND.text + $DECORATION.text, newVarName);
			String type1 = types.get($e1.text);
			String type = "\\power(" + getChildType(type1, 1) + ")";
			types.put($e1.text + $IMGSTART.text + $e2.text + $IMGEND.text + $DECORATION.text, type);
			typeInfo(newVarName, type);
			if (modoSetExpression != 0 )
				setExpressionVars.put($e1.text + $IMGSTART.text + $e2.text + $IMGEND.text + $DECORATION.text, newVarName);
		}
	}
	|	e1=expression DECORATION e2=expression
	{
		String a, b;
		a = memory.get($e1.text);
		b = memory.get($e2.text);
		
		if (memory.get($e1.text + "~" + $e2.text) == null) {
			String newVarName = newVar();
			memory.put($e1.text + "~" + $e2.text, newVarName);
			
			if (modoSetExpression != 0 )
				setExpressionVars.put($e1.text + "~" + $e2.text, newVarName);

			//Si es una lista debo transformarla
			String type1 = types.get($e1.text);
			if (getType(type1).equals("\\seq")) {
				String newVarName2 = newVar();
				print("list_to_rel(" + a + "," + newVarName2 +  ")");
				a = newVarName2;
			}

			String newVarType = leftAndRightTypes(type1).get(1);
			types.put($e1.text + "~" + $e2.text, newVarType);
			print("apply(" + a + "," + b + "," + newVarName + ")");
			
			//Imprimimos la informacion del tipo de la variable
			typeInfo(newVarName, newVarType);
		}
	}
	|	NAME
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
		
			$setlogName = "";
			$newVarName1 = newVar();
			$newVarName2 = newVar();
			
			$setlogName = $setlogName.concat("{ " + $newVarName1 + ":exists([");
			
			Iterator<String> keysIt = setExpressionVars.keySet().iterator();
			while (keysIt.hasNext()){
				$setlogName = $setlogName.concat(setExpressionVars.get(keysIt.next()));
				if (keysIt.hasNext()) $setlogName = $setlogName.concat(",");
			}
		
			$setlogName = $setlogName.concat("], " + setExpressionDecl.substring(setExpressionDecl.indexOf('&') + 1) +
			setExpressionPred + setExpressionExpr + " & " + $newVarName1 + " is " + memory.get($c.text) + ")" + " }");
		
			memory.put($zName, $newVarName2);
			types.put($zName, "\\power(" + types.get($c.text) + ")"); //REVISAR!!!
			print($newVarName2 + " = " + $setlogName);
			
			keysIt = setExpressionVars.keySet().iterator();
			while (keysIt.hasNext()){
				String var = keysIt.next();
				memory.remove(var);
				keysIt.remove();
				//setExpressionVars.remove(var);
			}
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
	|	e1=expression '.' e2=expression
	{
		if (memory.get($e1.text + "." + $e2.text) == null) {
		
			String e1Type = types.get($e1.text);
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
				while (!vars[position-1].contains($e2.text + ":")) //Se resta 1 porque en setlog empiezan en 1, no en 0 como en java
					position++;
				//Creamos una nueva variable
				String newVarName = newVar();
				//Vemos su tipo
				String type = vars[position-1].substring($e2.text.length()+1);
				memory.put($e1.text + "." + $e2.text, newVarName);
				if (modoSetExpression != 0 )
					setExpressionVars.put($e1.text + "." + $e2.text, newVarName);
				types.put($e1.text + "." + $e2.text, type);
				print("nth1(" + position + "," + memory.get($e1.text) + "," + newVarName + ")");
				
				typeInfo(newVarName, type);
				
			}
		}
	}
	|	e=expression POST_FUN (DECORATION)?
	{
		String a;
		a = memory.get($e.text);
		String op = $POST_FUN.text;
		if ($DECORATION.text != null)
			op = op.concat($DECORATION.text);
		
		if (memory.get($e.text + op) == null) {
		
			String newVarName = newVar();
		
			if (op.startsWith("\\inv")){
				print("inv(" + newVarName + "," + a + ")");
				memory.put($e.text + op, newVarName);
				String type1 = types.get($e.text);
				String type = invertType(type1); 
				types.put($e.text + op, type);
				typeInfo(newVarName, type);
				if (modoSetExpression != 0 )
					setExpressionVars.put($e.text + op, newVarName);
			}
		}
	}
	|	'(' e=expression ')'
	{
		String a = memory.get($e.text);
		
		//Chequeo el nombre para ver si se trata de una sola variable, en ese caso no guardo en la memoria
		//los parentesis, en otro caso si
		
		if (a != null) { //Si no estoy en la parte de declaracion
			Pattern p = Pattern.compile("[^a-zA-Z0-9_]");
			boolean hasSpecialChar = p.matcher(a).find();
			
			if (hasSpecialChar){
				memory.put("(" + $e.text + ")", "(" + a + ")");
				if (types.get($e.text) != null) {
					types.put("(" + $e.text + ")", types.get($e.text));
				}
			}
			else {
				memory.put("(" + $e.text + ")", a);
				if (types.get($e.text) != null) {
					types.put("(" + $e.text + ")", types.get($e.text));
				}
			}
		} else  //Si estoy en la parte de declaracion
			if (types.get($e.text) != null)
				types.put("(" + $e.text + ")", "(" + types.get($e.text) + ")");
	}
	|	'\\nat' 
	{	
		if (memory.get("\\nat") == null) {
			memory.put("\\nat", "NAT");
			print("NAT = int(0, 10000000000)");
			types.put("\\nat", "\\nat");
		}	
	}
	|	'\\num'
	{	
		if (memory.get("\\num") == null) {
			memory.put("\\num", "NUM");
			print("NUM = int(-10000000000, 10000000000)");
			types.put("\\num", "\\num");
		}	
	}
	;
	


NAME:	('a'..'z' | 'A'..'Z' | '\\_ ' | '?' )+ ('a'..'z' | 'A'..'Z' | '\\_ ' | '?' | '0'..'9')*;
NUM:	'0'..'9'+ ;

IN_FUN_P3: ('+' | '-' | '\\cup' | '\\setminus' | '\\cat')	;
IN_FUN_P4: ('*' | '\\div' | '\\mod' | '\\cap' | '\\comp' | '\\circ' | '\\extract' | '\\filter')	;
IN_FUN_P5: ('\\oplus')	;
IN_FUN_P6: ('\\dres' | '\\rres' | '\\ndres' | '\\nrres')	;

POST_FUN: '\\inv'	;

IN_GEN: ('\\rel' | '\\pfun' | '\\fun' | '\\ffun') ;
pre_gen: ( '\\ran' | '\\dom' | '\\seq' | '\\#' | '\\bigcup' | '\\bigcup' | 'max' DECORATION | 'min' DECORATION)	;

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
