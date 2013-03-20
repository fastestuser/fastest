grammar Expr;

@header {
	import java.util.HashMap;
	import java.util.ArrayList;
	import java.util.regex.Matcher;
	import java.util.regex.Pattern;
}

@members {
	String type;
	int varNumber = 0;
	HashMap memory = new HashMap(); //En memory se guardan las variables y expressiones leidas
	HashMap types = new HashMap();	//En types se guarda informacion sobre los tipos definidos
	int modoSetExpression = 0; //0 = false, 1 = true
	String setExpressionDecl, setExpressionPred, setExpressionExpr;
	ArrayList setExpressionVars;

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
		/* esto ya no se hace, porque simplemente declName es una etiqueta de tipos
		String newVarName = $declName.text.substring(0,1).toUpperCase() + $declName.text.substring(1).replace("?","");
		if (memory.containsValue(newVarName)) { 
			newVarName = "VAR" + varNumber;
			varNumber++;
		}
	
		memory.put($declName.text, newVarName);
		*/
		
		String type = (String) types.get($expression.text);
		if (type != null) {
			types.put($declName.text, type);
		}
		//print(newVarName + " = " + memory.get($expression.text)); esto ya no se hace, porque simplemente declName es una etiqueta de tipos
	}
	;
	
enumeration_type
locals [ArrayList cases;]
@init{$enumeration_type::cases = new ArrayList();}
	:	d=declName '::=' a=declName {$enumeration_type::cases.add($a.text);} (expression)? ('|' b=declName {$enumeration_type::cases.add($b.text);} (expression)? )* //Soporta solo constantes, falta ver que hacer si tiene expressiones
	{	
		String internalName = new String();
		while( !$enumeration_type::cases.isEmpty() ){
			String e = (String) $enumeration_type::cases.remove(0);
			internalName = internalName.concat(e);
			
			memory.put(e,e); //REVISAR!!!
			
			if (!$enumeration_type::cases.isEmpty()){
				internalName = internalName.concat(",");
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
			types.put($d.text, "EnumerationType:" + newVarName);
			print(newVarName + " = {" + internalName + "}");
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
	:	a=declName {$declaration::vars.add($a.text);} (',' b=declName {$declaration::vars.add($b.text);})* ':' {type = "";} expression 
	{
		//Para cada variable realizamos el procesamiento
		while( !$declaration::vars.isEmpty() ) {
			String var = (String) $declaration::vars.remove(0);
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
			
			if (!type.equals(""))
				print(type + "(" + newVarName + ")");
			else if (expType != null) {	
				if (expType.equals("\\nat") || expType.equals("\\num"))
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
locals [ArrayList setVars = new ArrayList(), String internalName = "", String externalName = "", String translatedSet = "", String operator = "",
	String newVarName1 = "", String newVarName2 = ""]
	:	a=expression '\\rel' b=expression  //In-Gen 
	{
		type="is_rel";
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
		type="is_pfun";

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
		type="is_fun";
		
		//Guardo el tipo
		String aType = (String) types.get($a.text);
		if (aType.startsWith("BasicType") || aType.startsWith("EnumerationType")) {
			System.out.println("jojo");
			aType = $a.text;
		}
		String bType = (String) types.get($b.text);
		if (bType.startsWith("BasicType") || bType.startsWith("EnumerationType"))
			bType = $b.text;
			
		types.put($a.text + "\\fun" + $b.text, aType + "\\fun" + bType );
	}
	|	e1=expression {$expression::setVars.add($e1.text);} ('\\cross' e2=expression {$expression::setVars.add($e2.text);})+
	//uso setVars, habria que cambiar el nombre por prolijidad
	{
	
		type = "";
		//Para cada exp realizamos el procesamiento
		while( !$expression::setVars.isEmpty() ) {
			String exp = (String) $expression::setVars.remove(0);
			
			$internalName = $internalName.concat(exp);
			
			String expType = (String) types.get(exp);
			if (expType.startsWith("BasicType") || expType.startsWith("EnumerationType"))
				$externalName = $externalName.concat(exp);
			else
				$externalName = $externalName.concat(expType);
				
			if (!$expression::setVars.isEmpty()) {
				$internalName = $internalName.concat("\\cross");
				$externalName = $externalName.concat("\\cross");
			}
		}
		
		types.put($internalName, $externalName);
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
			print("apply(" + a + "," + b + "," + newVarName + ")");
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
			}
		}
		else if ($pre_gen.text.equals("\\dom")){
			if (memory.get("\\dom" + $e.text) == null) {
				String newVarName = "VAR" + varNumber;
				varNumber++;
				memory.put("\\dom" + $e.text, newVarName);
				String e = (String) memory.get($e.text);
				print("dom(" + e + "," + newVarName + ")");
			}
		}
		else if ($pre_gen.text.equals("\\ran")){
			if (memory.get("\\ran" + $e.text) == null) {
				String newVarName = "VAR" + varNumber;
				varNumber++;
				memory.put("\\ran" + $e.text, newVarName);
				String e = (String) memory.get($e.text);
				print("ran(" + e + "," + newVarName + ")");
			}
		}
		else if ($pre_gen.text.equals("\\seq")) {
			type="list";
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
		
			if ($IN_FUN_P4.text.equals("*")){
				print( newVarName + " is " + a + "*" + b );
				memory.put($e1.text + "*" + $e2.text, newVarName);
			}
			else if ($IN_FUN_P4.text.equals("\\div")) {
				print( newVarName + " is div(" + a + "," + b + ")" );
				memory.put($e1.text + "\\div" + $e2.text, newVarName);
			}
			else if ($IN_FUN_P4.text.equals("\\mod")){
				print( newVarName + " is mod(" + a + "," + b + ")" );
				memory.put($e1.text + "\\mod" + $e2.text, newVarName);
			}
			else if ($IN_FUN_P4.text.equals("\\cap")){
					print("dinters(" + a + "," + b + "," + newVarName + ")");
					memory.put($e1.text + "\\cap" + $e2.text, newVarName);
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
		
			if ($IN_FUN_P3.text.equals("+")){
				print( newVarName + " is " + a + "+" + b );
				memory.put($e1.text + "+" + $e2.text, newVarName);
			}
			else if ($IN_FUN_P3.text.equals("-")) {
				print( newVarName + " is " + a + "-" + b );
				memory.put($e1.text + "-" + $e2.text, newVarName);
			}
			else if ($IN_FUN_P3.text.equals("\\cup")){
					print("dunion(" + a + "," + b + "," + newVarName + ")");
					memory.put($e1.text + "\\cup" + $e2.text, newVarName);
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
	|	//set extention
		SETSTART (a=expression {$setVars.add($a.text);})? (',' b=expression {$setVars.add($b.text);})* SETEND
	{	
		$externalName = $SETSTART.text;
		//Llenamos $externalName y ponemos cada expression en la memory
		while( !$setVars.isEmpty() ){
			String e = (String) $setVars.remove(0);
			$externalName = $externalName + e;
			//guardamos tambien las traducciones interiores del conjunto
			$internalName = $internalName + (String)memory.get(e);
			
			if (!$setVars.isEmpty()){
				$externalName = $externalName + ",";
				$internalName = $internalName + ",";
			}
		}
		$externalName = $externalName + $SETEND.text;
		if (memory.get($externalName) == null) {
			memory.put($externalName, "{" + $internalName + "}");
		}
	}
	|	SETSTART {modoSetExpression=1; setExpressionDecl = ""; setExpressionPred = ""; setExpressionExpr = ""; setExpressionVars = new ArrayList();} declPart {$externalName = $SETSTART.text + $declPart.text;} ( '|'{modoSetExpression=2;} predicate {$externalName = $externalName.concat("|" + $predicate.text);})? ( '@' {modoSetExpression=3;} c=expression {$externalName = $externalName.concat("@" + $c.text);})? SETEND {modoSetExpression=0; $externalName = $externalName.concat($SETEND.text);} 
	{
		if (memory.get($externalName)==null) {
			$translatedSet = "";
			$newVarName1 = "VAR" + varNumber;
			varNumber++;
			$newVarName2 = "VAR" + varNumber;
			varNumber++;
			
			$translatedSet = $translatedSet.concat("{ " + $newVarName1 + ":exists([");
			
			while(!setExpressionVars.isEmpty()){
				$translatedSet = $translatedSet.concat((String) setExpressionVars.remove(0));
				if (!setExpressionVars.isEmpty()) $translatedSet = $translatedSet.concat(",");
			}
		
			$translatedSet = $translatedSet.concat("], " + setExpressionDecl.substring(setExpressionDecl.indexOf('&') + 1) + ")" + setExpressionPred +
		" & " + $newVarName1 + " is " + memory.get($c.text) + " }");
		
			memory.put($externalName, $newVarName2);
			print($newVarName2 + " = " + $translatedSet);
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
