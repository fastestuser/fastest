grammar Expr;

//Gramatica utilizada para la creacion, a partir de una clase de prueba Z, la entrada necesaria
//para setlog. Es parte del proceso de generacion de casos de prueba.

@header {
	import java.util.HashMap;
	import java.util.ArrayList;
	import java.util.regex.Matcher;
	import java.util.regex.Pattern;
}

@members {
	
	String setExpressionDecl, setExpressionPred, setExpressionExpr;
	
	int varNumber = 0;
	int modoSetExpression = 0; //0 = false, 1 = true
	
	ArrayList setExpressionVars;
	
	HashMap memory = new HashMap(); //En memory se guardan las variables y expressiones leidas
	HashMap types = new HashMap();	//En types se guarda informacion sobre los tipos definidos
	HashMap zVars = new HashMap();  //En zVars se almacenan las variables Z, a las cuales luego (antes de generar
	                                //el caso de prueba) se les dara un valor.
	
	String salida = new String();
	public String getSalida() {
		return salida;
	}
	
	public HashMap getMemory() {
		return memory;
	}
	
	public HashMap getTypes() {
		return types;
	}

	public void print(String c) {
		if (modoSetExpression == 0) 
			System.out.println(c + " &");
			//salida = salida.concat(c + " &");
		else if (modoSetExpression == 1)
			setExpressionDecl = setExpressionDecl.concat(" & " + c);
		else if (modoSetExpression == 2)
			setExpressionPred = setExpressionPred.concat(" & " + c);
		else if (modoSetExpression == 3)
			setExpressionExpr = setExpressionExpr.concat(" & " + c);
	}
	
	//Metodo para la determinacion del tipo.
	//Constraits: El arbol debio ser previamente generado
	//Input: String representando el tipo.
	//Output: String, con el valor del root.
	String getType(String type) {
		//El calculo se realiza mediante la construccion del arbol de tipos con la gramatica TypeManager
		ANTLRInputStream input = new ANTLRInputStream(type);
        TypeManagerLexer lexer = new TypeManagerLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        TypeManagerParser parser = new TypeManagerParser(tokens);
        parser.typeManage();
        return parser.getReturnRootType();
	}
	
	//Metodo para la determinacion del tipo de salida de una funcion.
	//Constraits: El arbol debio ser previamente generado, para un tipo "funcion"
	//Input: String representando el tipo y Int con la posicion del hijo deseado (empieza en 0).
	//Output: String, con el valor del nodo.
	String getChildType(String type, int pos) {
		//El calculo se realiza mediante la construccion del arbol de tipos con la gramatica TypeManager
		ANTLRInputStream input = new ANTLRInputStream(type);
        TypeManagerLexer lexer = new TypeManagerLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        TypeManagerParser parser = new TypeManagerParser(tokens);
        parser.typeManage();
        return parser.printChild(pos);
	}
}

specification
	:	( paragraph NL*)+
	{
	   System.out.println("tablita de tippos");
	   System.out.println("-------------------");
	   String key, value;
	   Iterator iterator = types.keySet().iterator();
	   while (iterator.hasNext()) {
	           key = (String) iterator.next();
	           value = (String) types.get(key);
	           System.out.println(key + "\t\t| " + value);
	   }
	   System.out.println("\ntablita de memory");
	   System.out.println("-------------------");
	   iterator = memory.keySet().iterator();
	   while (iterator.hasNext()) {
	           key = (String) iterator.next();
	           value = (String) memory.get(key);
	           System.out.println(key + "\t\t| " + value);
	   }
	   System.out.println("\ntablita de zVars");
	   System.out.println("-------------------");
	   iterator = zVars.keySet().iterator();
	   while (iterator.hasNext()) {
	           key = (String) iterator.next();
	           value = (String) zVars.get(key);
	           System.out.println(key + "\t\t| " + value);
               }
	}
	;

paragraph
	:	'\\begin{schema}{' NAME '}' schemaText '\\end{schema}'
	%|	'\\begin{axdef}' NL declPart NL '\\end{axdef}'
	|	'\\begin{zed}' NL ((basic_type | equivalent_type | enumeration_type) NL )+ '\\end{zed}'
	;
      
basic_type
locals [ArrayList typeList;]
@init{$basic_type::typeList = new ArrayList();}
	:	'[' a=declName {$basic_type::typeList.add($a.text);} (',' b=declName {$basic_type::typeList.add($b.text);})* ']'
	{
		while( !$basic_type::typeList.isEmpty() ) {
			String type = (String) $basic_type::typeList.remove(0);
			
			String newVarName = $declName.text.substring(0,1).toUpperCase() + $declName.text.substring(1).replace("?","");
			if (memory.containsValue(newVarName)) { 
				newVarName = "VAR" + varNumber;
				varNumber++;
			}
			memory.put(type, newVarName);
			print("set(" + newVarName + ")");
			
			types.put(type, "BasicType:" + newVarName);
			
		}
	}	
	;
	
equivalent_type
	:	declName '==' expression
	{ 
		String type = (String) types.get($expression.text);
		if (type != null) {
			types.put($declName.text, type);
		}
	}
	;
	
enumeration_type
locals [ArrayList cases;]
@init{$enumeration_type::cases = new ArrayList();}
	:	d=declName '::=' a=declName {$enumeration_type::cases.add($a.text);} (expression)? 
	    ('|' b=declName {$enumeration_type::cases.add($b.text);} (expression)? )* 
	    //Soporta solo constantes, falta ver que hacer si tiene expressiones
	{	
		String elements = new String();
		while( !$enumeration_type::cases.isEmpty() ){
			String e = (String) $enumeration_type::cases.remove(0);
			elements = elements.concat(e);
			
			memory.put(e,e); //REVISAR!!!
			
			if (!$enumeration_type::cases.isEmpty()){
				elements = elements.concat(",");
			}
		}
		if (types.get($d.text) == null) {
			//Le asigno un nombre al conjunto
			String newVarName = $d.text.substring(0,1).toUpperCase() + $d.text.substring(1).replace("?","");
			if (memory.containsValue(newVarName)) { 
				newVarName = "VAR" + varNumber;
				varNumber++;
			}
		
			memory.put($d.text, newVarName);
			types.put($d.text, "EnumerationType:" + newVarName + ":{" + elements + "}");
			print(newVarName + " = {" + elements + "}");
		}
	}
	;
      
schemaText
	:	NL (declPart NL)? '\\where' NL (predicate NL)*
	;
	
declPart:	declaration ((';' | NL) declaration)*
	;
	
declaration
locals [ArrayList vars;]
@init{$declaration::vars = new ArrayList();}
	:	a=declName {$declaration::vars.add($a.text);} (',' b=declName {$declaration::vars.add($b.text);})* ':' expression 
	{
		//Para cada variable realizamos el procesamiento
		while( !$declaration::vars.isEmpty() ) {
			String var = (String) $declaration::vars.remove(0);
			zVars.put(var, null); //Marcamos la variable como variable Z, a la cual debera asignarsele un valor
			String newVarName = var.substring(0,1).toUpperCase() + var.substring(1).replace("?","");
			if (memory.containsValue(newVarName)) { 
				newVarName = "VAR" + varNumber;
				varNumber++;
			}
			
			memory.put(var, newVarName);
			if (modoSetExpression==1)
				setExpressionVars.add(newVarName); //Falta ver que hacemos para variables ligadas con el mismo nombre en distintas ligaduras
			
			String expType = (String) types.get($expression.text);
			types.put(var, expType);

			//Imprimimos el tipo de la variable segun cual sea este			
			if (expType != null) {
				String type = getType(expType);
				if (type.equals("\\seq"))
					print("list(" + newVarName + ")");
				else if (type.equals("\\rel"))
					print("is_rel(" + newVarName + ")");
				else if (type.equals("\\pfun"))
					print("is_pfun(" + newVarName + ")");
				else if (type.equals("\\fun"))
					print("is_fun(" + newVarName + ")");
				else if (expType.equals("\\nat") || expType.equals("\\num"))
					print(newVarName + " in " + memory.get(expType));
				else if (expType.startsWith("BasicType:"))
					print(newVarName + " in " + expType.substring(10));
				else if (expType.startsWith("EnumerationType:"))
					print(newVarName + " in " + expType.substring(16));
			}
		}
	}
	;
	
declName:	NAME
	;
	
predicate
	:	'\\lnot' predicate
	|	e1=expression '\\in' '\\dom' e2 = expression
	{	String a, b;
		a = (String)memory.get($e1.text);
		b = (String)memory.get($e2.text);
		print("in_dom(" + a + "," + b + ")");
	} 
	|	e1=expression '\\in' e2=expression
	{
		String a, b;
		a = (String)memory.get($e1.text);
		b = (String)memory.get($e2.text);
		print(a + " in " + b);
		
		//Impresion de tipo
		String type = (String) types.get($e2.text);
		if (type != null)
			if (type.equals("\\power\\num") || type.equals("\\power\\nat"))
				print(a + " in " + memory.get(type.substring(6)));
	}
	|	e1=expression '\\notin' e2=expression
	{
		String a, b;
		a = (String)memory.get($e1.text);
		b = (String)memory.get($e2.text);
		print(a + " nin " + b);
		
		//Impresion de tipo
		String type = (String) types.get($e2.text);
		if (type != null)
			if (type.equals("\\power\\num") || type.equals("\\power\\nat"))
				print(a + " in " + memory.get(type.substring(6)));
	}
	|	e1=expression '<' e2=expression
	{
		String a, b;
		a = (String)memory.get($e1.text);
		b = (String)memory.get($e2.text);
		print(a + " < " + b);
	}
	|	e1=expression '>' e2=expression
	{
		String a, b;
		a = (String)memory.get($e1.text);
		b = (String)memory.get($e2.text);
		print(a + " > " + b);
	}
	|	e1=expression '\\leq' e2=expression
	{
		String a, b;
		a = (String)memory.get($e1.text);
		b = (String)memory.get($e2.text);
		print(a + " =< " + b);
	}
	|	e1=expression '\\geq' e2=expression
	{
		String a, b;
		a = (String)memory.get($e1.text);
		b = (String)memory.get($e2.text);
		print(a + " =< " + b);
	}
	|	e1=expression '=' e2=expression
	{
		String a, b;
		a = (String)memory.get($e1.text);
		b = (String)memory.get($e2.text);
		print(a + " = " + b);
	}
	|	e1=expression '\\subset' e2=expression
	{
		String a, b;
		a = (String)memory.get($e1.text);
		b = (String)memory.get($e2.text);
		print("dsubset(" + a + "," + b + ")");
	}
	|	e1=expression '\\neq' e2=expression
	{
		String a, b;
		a = (String)memory.get($e1.text);
		b = (String)memory.get($e2.text);
		print(a + " neq " + b);
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
locals [ArrayList elements = new ArrayList(), String setlogName = "", String zName = "", String operator = "",
	String newVarName1 = "", String newVarName2 = ""]
	:	a=expression '\\rel' b=expression  //In-Gen 
	{
		//Guardo el tipo
		String aType = (String) types.get($a.text);
		if (aType.startsWith("BasicType") || aType.startsWith("EnumerationType")) {
			aType = $a.text;
		}
		String bType = (String) types.get($b.text);
		if (bType.startsWith("BasicType") || bType.startsWith("EnumerationType"))
			bType = $b.text;
			
		types.put($a.text + "\\rel" + $b.text, aType + "\\rel" + bType );
	}
	|	a=expression op=('\\pfun' | '\\ffun') b=expression
	{
		//Guardo el tipo
		String aType = (String) types.get($a.text);
		if (aType.startsWith("BasicType") || aType.startsWith("EnumerationType")) {
			aType = $a.text;
		}
		String bType = (String) types.get($b.text);
		if (bType.startsWith("BasicType") || bType.startsWith("EnumerationType"))
			bType = $b.text;
			
		types.put($a.text + $op.text + $b.text, aType + "\\pfun" + bType );
	}
	|	a=expression '\\fun' b=expression
	{
		//Guardo el tipo
		String aType = (String) types.get($a.text);
		if (aType.startsWith("BasicType") || aType.startsWith("EnumerationType")) {
			aType = $a.text;
		}
		String bType = (String) types.get($b.text);
		if (bType.startsWith("BasicType") || bType.startsWith("EnumerationType"))
			bType = $b.text;
			
		types.put($a.text + "\\fun" + $b.text, aType + "\\fun" + bType );
	}
	|	e1=expression {$expression::elements.add($e1.text);} ('\\cross' e2=expression {$expression::elements.add($e2.text);})+
	{
		String unfoldedType = "";
		
		//Para cada exp realizamos el procesamiento
		while( !$expression::elements.isEmpty() ) {
			String exp = (String) $expression::elements.remove(0);
			
			$zName = $zName.concat(exp);
			
			String expType = (String) types.get(exp);
			if (expType.startsWith("BasicType") || expType.startsWith("EnumerationType"))
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
	|	e1=expression '~' e2=expression
	{
		String a, b;
		a = (String)memory.get($e1.text);
		b = (String)memory.get($e2.text);
		
		if (memory.get($e1.text + "~" + $e2.text) == null) {
			String newVarName = "VAR" + varNumber;
			varNumber++;
			memory.put($e1.text + "~" + $e2.text, newVarName);
			types.put($e1.text + "~" + $e2.text, getChildType((String) types.get($e1.text), 1));
			print("apply(" + a + "," + b + "," + newVarName + ")");
			
			//Consulto el tipo para ver si es numerico
			String newVarType = getChildType((String) types.get($e1.text), 1);
			
			if (newVarType.equals("\\num"))
				print(newVarName + " in NUM");
			else if (newVarType.equals("\\nat"))
				print(newVarName + " in NAT");
		}
	}
	|	e1=expression '\\mapsto' e2=expression //In-Fun
	{
		String a, b;
		a = (String)memory.get($e1.text);
		b = (String)memory.get($e2.text);
		memory.put($e1.text + "\\mapsto" + $e2.text, "[" + a + "," + b + "]");
	}
	|	e1=expression '\\upto' e2=expression
	{
		String a, b;
		a = (String)memory.get($e1.text);
		b = (String)memory.get($e2.text);
		if (memory.get($e1.text + "\\upto" + $e2.text) == null) {
			String newVarName = "VAR" + varNumber;
			varNumber++;
			memory.put($e1.text + "\\upto" + $e2.text, newVarName);
			print(newVarName + " = int(" + a + "," + b + ")");
		}
	}
	|	pre_gen e=expression //Pre-Gen
	{
		String a;
		a = (String)memory.get($e.text);
		
		if ($pre_gen.text.equals("\\#")){
			if (memory.get("\\#" + $e.text) == null) {
				String newVarName = "VAR" + varNumber;
				varNumber++;
				memory.put("\\#" + $e.text, newVarName);
				print("prolog_call(length(" + a + "," + newVarName + "))");
				
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
				String newVarName = "VAR" + varNumber;
				varNumber++;
				memory.put("\\dom" + $e.text, newVarName);
				types.put("\\dom" + $e.text, getChildType((String) types.get($e.text), 0));
				
				String e = (String) memory.get($e.text);
				
				//Chequeamos si e es una lista, estas son tratadas de forma diferente
				//System.out.println("ESTE ES EL TIPO: " + types.get($e.text) + " DE: " + $e.text);
				String type = getType((String) types.get($e.text));
				if (type.equals("\\seq"))
					print("ddom_list(" + e + "," + newVarName + ")");
				else
					print("dom(" + e + "," + newVarName + ")");
			}
		}
		else if ($pre_gen.text.equals("\\ran")){
			if (memory.get("\\ran" + $e.text) == null) {
				String newVarName = "VAR" + varNumber;
				varNumber++;
				memory.put("\\ran" + $e.text, newVarName);
				types.put("\\ran" + $e.text, getChildType((String) types.get($e.text), 0));
				
				String e = (String) memory.get($e.text);
				
				//Chequeamos si e es una lista, estas son tratadas de forma diferente
				String type = getType((String) types.get($e.text));
				if (type.equals("\\seq"))
					print("list_to_set(" + e + "," + newVarName + ")");
				else
					print("ran(" + e + "," + newVarName + ")");
			}
		}
		else if ($pre_gen.text.equals("\\seq")) {
			types.put("\\seq" + $e.text, "\\seq" + types.get($e.text));
		}
	}	
	|	e1=expression IN_FUN_P4 e2=expression
	{
		String a, b;
		a = (String)memory.get($e1.text);
		b = (String)memory.get($e2.text);
		
		if (memory.get($e1.text + $IN_FUN_P4.text + $e2.text) == null) {
		
			String newVarName = "VAR" + varNumber;
			varNumber++;
			Boolean isNumeric = false; 
		
			if ($IN_FUN_P4.text.equals("*")){
				print( newVarName + " is " + a + "*" + b );
				memory.put($e1.text + "*" + $e2.text, newVarName);
				isNumeric = true;
			}
			else if ($IN_FUN_P4.text.equals("\\div")) {
				print( newVarName + " is div(" + a + "," + b + ")" );
				memory.put($e1.text + "\\div" + $e2.text, newVarName);
				isNumeric = true;
			}
			else if ($IN_FUN_P4.text.equals("\\mod")){
				print( newVarName + " is mod(" + a + "," + b + ")" );
				memory.put($e1.text + "\\mod" + $e2.text, newVarName);
				isNumeric = true;
			}
			else if ($IN_FUN_P4.text.equals("\\cap")){
					print("dinters(" + a + "," + b + "," + newVarName + ")");
					memory.put($e1.text + "\\cap" + $e2.text, newVarName);
			}
			
			if (isNumeric) {
				if (memory.get("\\num") == null) {
					memory.put("\\num", "NUM");
					print("NUM = int(-10000000000, 10000000000)");
					types.put("\\num", "\\num");
				}
				print(newVarName + " in NUM");
			}
		}
	}
	|	e1=expression IN_FUN_P3 e2=expression
	{
		String a, b;
		a = (String)memory.get($e1.text);
		b = (String)memory.get($e2.text);
		
		if (memory.get($e1.text + $IN_FUN_P3.text + $e2.text) == null) {
		
			String newVarName = "VAR" + varNumber;
			varNumber++;
			Boolean isNumeric = false; 
			
		
			if ($IN_FUN_P3.text.equals("+")){
				print( newVarName + " is " + a + "+" + b );
				memory.put($e1.text + "+" + $e2.text, newVarName);
				isNumeric = true;
			}
			else if ($IN_FUN_P3.text.equals("-")) {
				print( newVarName + " is " + a + "-" + b );
				memory.put($e1.text + "-" + $e2.text, newVarName);
				isNumeric = true;
			}
			else if ($IN_FUN_P3.text.equals("\\cup")){
					print("dunion(" + a + "," + b + "," + newVarName + ")");
					memory.put($e1.text + "\\cup" + $e2.text, newVarName);
			}
			
			if (isNumeric) {
				if (memory.get("\\num") == null) {
					memory.put("\\num", "NUM");
					print("NUM = int(-10000000000, 10000000000)");
					types.put("\\num", "\\num");
				}
				print(newVarName + " in NUM");
			}
		}
	}
	|	'\\power' e=expression
	{
		types.put("\\power" + $e.text, "\\power" + types.get($e.text));
	}
	|	NAME
	{
		if (memory.get($NAME.text) == null)
		{
			String newVarName = $NAME.text.substring(0,1).toUpperCase() + $NAME.text.substring(1).replace("?","");
		
			if (memory.containsValue(newVarName)) { 
				newVarName = "VAR" + varNumber;
				varNumber++;
			}
			
			memory.put($NAME.text, newVarName);
		}
	}
	|	NUM
	{
		if (memory.get($NUM.text) == null)
			memory.put($NUM.text, $NUM.text);
	}
	|	//set extension
		SETSTART (a=expression {$elements.add($a.text);})? (',' b=expression {$elements.add($b.text);})* SETEND
	{	
		$zName = $SETSTART.text;
		//Llenamos elements y ponemos cada expression en la memory
		while( !$elements.isEmpty() ){
			String e = (String) $elements.remove(0);
			$zName = $zName.concat(e);
			//guardamos tambien las traducciones del conjunto
			$setlogName = $setlogName.concat((String)memory.get(e));
			
			if (!$elements.isEmpty()){
				$zName = $zName + ",";
				$setlogName = $setlogName + ",";
			}
		}
		$zName = $zName + $SETEND.text;
		if (memory.get($zName) == null) {
			memory.put($zName, "{" + $setlogName + "}");
		}
	}
	|	SETSTART {modoSetExpression=1; setExpressionDecl = ""; setExpressionPred = ""; setExpressionExpr = ""; setExpressionVars = new ArrayList();}
	    declPart {$zName = $SETSTART.text + $declPart.text;}
	    ( '|'{modoSetExpression=2;} predicate {$zName = $zName.concat("|" + $predicate.text);})?
	    ( '@' {modoSetExpression=3;} c=expression {$zName = $zName.concat("@" + $c.text);})?
	    SETEND {modoSetExpression=0; $zName = $zName.concat($SETEND.text);} 
	{
		if (memory.get($zName)==null) {
			$setlogName = "";
			$newVarName1 = "VAR" + varNumber;
			varNumber++;
			$newVarName2 = "VAR" + varNumber;
			varNumber++;
			
			$setlogName = $setlogName.concat("{ " + $newVarName1 + ":exists([");
			
			while(!setExpressionVars.isEmpty()){
				$setlogName = $setlogName.concat((String) setExpressionVars.remove(0));
				if (!setExpressionVars.isEmpty()) $setlogName = $setlogName.concat(",");
			}
		
			$setlogName = $setlogName.concat("], " + setExpressionDecl.substring(setExpressionDecl.indexOf('&') + 1) + ")" +
			setExpressionPred + " & " + $newVarName1 + " is " + memory.get($c.text) + " }");
		
			memory.put($zName, $newVarName2);
			print($newVarName2 + " = " + $setlogName);
		}
	}
	|	'(' e=expression ')'
	{
		String a = (String) memory.get($e.text);
		
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


NAME:	('a'..'z' | 'A'..'Z' | '\\_ ' | '?' )+ ('0'..'9')*;
NUM:	'0'..'9'+ ;

IN_FUN_P3: ('+' | '-' | '\\cup')	;
IN_FUN_P4: ('*' | '\\div' | '\\mod' | '\\cap')	;

pre_gen: ( '\\ran' | '\\dom' | '\\seq' | '\\#' )	;

NL:	'\r'? '\n' ;
WS: 	(' '|'\t'|'\r')+ {skip();} ;
SETSTART: '\\{';
SETEND: '\\}';
SKIP:	'\\' '\\' {skip();} ;
