grammar Expr;

@header {
import java.util.HashMap;
import java.util.ArrayList;
}

@members {
String type;
int varNumber = 0;
HashMap memory = new HashMap();
String lastExpr; //variable auxiliar para solucionar el problema de la left-recursion en expression
int modoSetExpression = 0; //0 = false, 1 = true
String setExpressionDecl, setExpressionPred, setExpressionExpr;
ArrayList setExpressionVars;

public void print(String c) {
	if (modoSetExpression == 0) 
		System.out.println(c + " & ");
	else if (modoSetExpression == 1)
		setExpressionDecl = setExpressionDecl.concat(" & " + c);
	else if (modoSetExpression == 2)
		setExpressionPred = setExpressionPred.concat(" & " + c);
	else if (modoSetExpression == 3)
		setExpressionExpr = setExpressionExpr.concat(" & " + c);
}
}

specification
	:	( paragraph NL!*)+
	;

paragraph
	:	'\\begin{schema}{' NAME '}'
	schemaText '\\end{schema}'
	;
      
schemaText
	:	NL (declPart NL)? '\\where' NL (predicate NL)?
	;
	
declPart:	declaration ((';' | NL) declaration)*
	;
	
declaration
locals [ArrayList vars;]
@init{$declaration::vars = new ArrayList();}
	:	a=declName {$declaration::vars.add($a.text);} (',' b=declName {$declaration::vars.add($b.text);})* ':' {type = "";} expression 
	{
		
		
		
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
			
			if (!type.equals("")) print(type + "(" + newVarName + ")");
		}
	}
	;
	
declName:	NAME
	;
	
predicate
	:	'\\lnot' predicate
	|	e1=expression '\\in'  '\\dom' e2 = expression predicateTail
	{	String a, b;
		a = (String)memory.get($e1.text);
		b = (String)memory.get($e2.text);
		print("in_dom(" + a + "," + b + ")");
	} 
	|	e1=expression '\\in' e2=expression predicateTail
	{
		String a, b;
		a = (String)memory.get($e1.text);
		b = (String)memory.get($e2.text);
		print(a + " in " + b);
	}
	|	e1=expression '\\notin' e2=expression predicateTail
	{
		String a, b;
		a = (String)memory.get($e1.text);
		b = (String)memory.get($e2.text);
		print(a + " nin " + b);
	}
	|	e1=expression '<' e2=expression predicateTail
	{
		String a, b;
		a = (String)memory.get($e1.text);
		b = (String)memory.get($e2.text);
		print(a + " < " + b);
	}
	|	e1=expression '>' e2=expression predicateTail
	{
		String a, b;
		a = (String)memory.get($e1.text);
		b = (String)memory.get($e2.text);
		print(a + " > " + b);
	}
	|	e1=expression '\\leq' e2=expression predicateTail
	{
		String a, b;
		a = (String)memory.get($e1.text);
		b = (String)memory.get($e2.text);
		print(a + " =< " + b);
	}
	|	e1=expression '\\geq' e2=expression predicateTail
	{
		String a, b;
		a = (String)memory.get($e1.text);
		b = (String)memory.get($e2.text);
		print(a + " =< " + b);
	}
	|	e1=expression '=' e2=expression predicateTail
	{
		String a, b;
		a = (String)memory.get($e1.text);
		//System.out.println("BUSCA: " + $e1.text);
		b = (String)memory.get($e2.text);
		print(a + " = " + b);
	}
	|	e1=expression '\\neq' e2=expression predicateTail
	{
		String a, b;
		a = (String)memory.get($e1.text);
		//System.out.println("PIDO: " + $e1.text);
		b = (String)memory.get($e2.text);
		print(a + " neq " + b);
	}
	|	'(' predicate ')'
	|	'true' predicateTail
	|	'false' predicateTail
	;
	
predicateTail
	:	//empty rule
	|	NL predicate
	|	'\\iff' predicate
	|	'\\implies' predicate
	|	'\\lor' predicate
	|	'\\land' predicate
	;
	
	
expression
locals [ArrayList setVars = new ArrayList(), String internalName = "", String externalName = "";]
	:	NAME {lastExpr = $NAME.text;} expressionTail
	|	NUM {lastExpr = $NUM.text; if (memory.get($NUM.text) == null) memory.put($NUM.text, $NUM.text);} expressionTail
	|	'\\{ \\}' //empty set
	{	lastExpr = "\\{ \\}";
		if (memory.get("\\{ \\}") == null) {
			memory.put("\\{ \\}", "{}");
		}	
	} expressionTail
	|	'(' a=expression {lastExpr = $a.text;} ')'
	{
		//Guardo la expresion con los parentesis
		String e = (String) memory.get($a.text);
		if (e != null) {
			memory.put("(" + $a.text + ")", e);
		}
		//System.out.println("Guardo: " + e + " como: " + "(" + $a.text + ")");
	} expressionTail {
		e = (String) memory.get($a.text + $expressionTail.text);
		memory.put("(" + $a.text + ")" + $expressionTail.text, e);
		lastExpr = "(" + $a.text + ")" + $expressionTail.text;
	}
	|	//set extention
		SETSTART a=expression {$setVars.add($a.text);} (',' b=expression {$setVars.add($b.text);})* SETEND
	{	
		$externalName = "\\{ ";
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
		$externalName = $externalName + "\\}";
		if (memory.get($externalName) == null) {
			memory.put($externalName, "{" + $internalName + "}");
		}
		lastExpr = $externalName;
	} expressionTail
	|	SETSTART {modoSetExpression=1; setExpressionDecl = ""; setExpressionPred = ""; setExpressionExpr = ""; setExpressionVars = new ArrayList();} declPart {$externalName = "\\{ " + $declPart.text;} ( '|'{modoSetExpression=2;} predicate {$externalName = $externalName.concat("|" + $predicate.text);})? ( '@' {modoSetExpression=3;} c=expression {$externalName = $externalName.concat("@" + $c.text);})? SETEND {modoSetExpression=0; $externalName = $externalName.concat("\\}");} 
	{if (memory.get($externalName)==null) {
		String translatedSet = "";
		String newVarName1 = "VAR" + varNumber;
		varNumber++;
		String newVarName2 = "VAR" + varNumber;
		varNumber++;
		
		translatedSet = translatedSet.concat("{ " + newVarName1 + ":exists([");
		
		while(!setExpressionVars.isEmpty()){
			translatedSet = translatedSet.concat((String) setExpressionVars.remove(0));
			if (!setExpressionVars.isEmpty()) translatedSet = translatedSet.concat(",");
		}
		
		translatedSet = translatedSet.concat("], " + setExpressionDecl.substring(setExpressionDecl.indexOf('&') + 1) + ")" + setExpressionPred +
		" & " + newVarName1 + " is " + memory.get($c.text) + " }");
		
		memory.put($externalName, newVarName2);
		//System.out.println("GUARDO: " + $externalName);
		print(newVarName2 + " = " + translatedSet);
	}	
	lastExpr = $externalName;
	} expressionTail
	
	
	
/*	{modoSetExpression=1; print("{x: exists(");}
	{print(")"); }
	{print("x = " + memory.get($c.text));}
	{modoSetExpression=0;}*/
	
/*	|	SETSTART {modoSetExpression=1; print("{x: exists(");} //set
		a=declaration ( '|' b=predicate )? {print(")"); }  
		( '@' c=expression {print("x = " + memory.get($c.text));} )?
		{modoSetExpression=0;} SETEND expressionTail*/
	|	'\\nat' 
	{	lastExpr = "\\nat";
		if (memory.get("\\nat") == null) {
			memory.put("\\nat", "NAT");
			print("NAT = int(0, 10000000000)");
		}	
	} expressionTail
	|	'\\num' expressionTail
	|	relation {lastExpr = $relation.text;} //unaria, algo de la forma "dom e" y no "a \mapsto b" 
	|	function {lastExpr = $function.text;} //unaria, algo de la forma "\power A" y no "A \fun B" 
	|	arithmetic {lastExpr = $arithmetic.text;} //unaria, algo de la forma "\# A" y no "A + B"
	;
	
expressionTail
locals [String auxExpr;]
@init{$expressionTail::auxExpr = lastExpr;}
	:	//empty rule
	|	'~' e=expression
	{
		//Necesito la expression anterior, por eso creo una variable auxiliar,
		//el problema viene de la necesidad de eliminar la left-recursion de expression
		String a, b;
		a = (String)memory.get($expressionTail::auxExpr);
		b = (String)memory.get($e.text);
		String newVarName = "VAR" + varNumber;
		varNumber++;
		memory.put($expressionTail::auxExpr + "~" + $e.text, newVarName);
		print("apply(" + a + "," + b + "," + newVarName + ")");
	}
	|	relation
	|	function
	|	arithmetic
	;

arithmetic
locals[String auxExpr;]
@init{$arithmetic::auxExpr = lastExpr;}
	:	'+' e=expression
	{
		//Necesito la expression anterior, por eso creo una variable auxiliar,
		//el problema viene de la necesidad de eliminar la left-recursion de expression
		String a, b;
		a = (String)memory.get($arithmetic::auxExpr);
		b = (String)memory.get($e.text);
		memory.put($arithmetic::auxExpr + "+" + $e.text, a + "+" + b);
	}
	|	'-' e=expression
	{
		//Necesito la expression anterior, por eso creo una variable auxiliar,
		//el problema viene de la necesidad de eliminar la left-recursion de expression
		String a, b;
		a = (String)memory.get($arithmetic::auxExpr);
		b = (String)memory.get($e.text);
		memory.put($arithmetic::auxExpr + "-" + $e.text, a + "-" + b);
	}
	|	'*' e=expression
	{
		//Necesito la expression anterior, por eso creo una variable auxiliar,
		//el problema viene de la necesidad de eliminar la left-recursion de expression
		String a, b;
		a = (String)memory.get($arithmetic::auxExpr);
		b = (String)memory.get($e.text);
		memory.put($arithmetic::auxExpr + "*" + $e.text, a + "*" + b);
	}
	|	'\\div' e=expression
	{
		//Necesito la expression anterior, por eso creo una variable auxiliar,
		//el problema viene de la necesidad de eliminar la left-recursion de expression
		String a, b;
		a = (String)memory.get($arithmetic::auxExpr);
		b = (String)memory.get($e.text);
		memory.put($arithmetic::auxExpr + "\\div" + $e.text, "div(" + a + "," + b + ")");
	}
	|	'\\mod' e=expression
	{
		//Necesito la expression anterior, por eso creo una variable auxiliar,
		//el problema viene de la necesidad de eliminar la left-recursion de expression
		String a, b;
		a = (String)memory.get($arithmetic::auxExpr);
		b = (String)memory.get($e.text);
		memory.put($arithmetic::auxExpr + "\\mod" + $e.text, "mod(" + a + "," + b + ")");
	}
	|	'\\#' e=expression
	{
		//Unaria
		String a;
		a = (String)memory.get($e.text);
		if (memory.get("\\#" + $e.text) == null) {
			String newVarName = "VAR" + varNumber;
			varNumber++;
			memory.put("\\#" + $e.text, newVarName);
			print("prolog_call(length(" + a + "," + newVarName + "))");
		}
	}
	;
relation
locals[String auxExpr;]
@init{$relation::auxExpr = lastExpr;}
	:	'\\mapsto' e=expression
	{
		//Necesito la expression anterior, por eso creo una variable auxiliar,
		//el problema viene de la necesidad de eliminar la left-recursion de expression
		String a, b;
		a = (String)memory.get($relation::auxExpr);
		b = (String)memory.get($e.text);
		memory.put($relation::auxExpr + "\\mapsto" + $e.text, "[" + a + "," + b + "]");
	}
	|	'\\upto' e=expression
	{
		//Necesito la expression anterior, por eso creo una variable auxiliar,
		//el problema viene de la necesidad de eliminar la left-recursion de expression
		String a, b;
		a = (String)memory.get($relation::auxExpr);
		b = (String)memory.get($e.text);
		memory.put($relation::auxExpr + "\\upto" + $e.text, "[" + a + "," + b + "]");
			}
	|	'\\cup' e=expression
	{
		//Necesito la expression anterior, por eso creo una variable auxiliar,
		//el problema viene de la necesidad de eliminar la left-recursion de expression
		String a, b;
		a = (String)memory.get($relation::auxExpr);
		//quitamos los parentesis de e, ya que puede estar entre parentesis
		/*String e2;
		if ($e.text.charAt(0) == '(') {//si empieza con parentesis lo saco
			e2 = $e.text.substring(1, $e.text.length()-1);
		} else {
			e2 = $e.text;
		}*/
		b = (String)memory.get($e.text);
		//print("DINTERS A: " + $relation::auxExpr);
		if (memory.get($relation::auxExpr + "\\cup" + $e.text) == null) {
			String newVarName = "VAR" + varNumber;
			varNumber++;
			memory.put($relation::auxExpr + "\\cup" + $e.text, newVarName);
			//print("DINTERS SAVE: " + $relation::auxExpr + "\\cap" + $e.text + " AS: " + newVarName);
			print("dunion(" + a + "," + b + "," + newVarName + ")");
		}
	}
	|	'\\cap' e=expression
	{
		//Necesito la expression anterior, por eso creo una variable auxiliar,
		//el problema viene de la necesidad de eliminar la left-recursion de expression
		String a, b;
		a = (String)memory.get($relation::auxExpr);
		//quitamos los parentesis de e, ya que puede estar entre parentesis
		/*String e2;
		if ($e.text.charAt(0) == '(') {//si empieza con parentesis lo saco
			e2 = $e.text.substring(1, $e.text.length()-1);
		} else {
			e2 = $e.text;
		}*/
		b = (String)memory.get($e.text);
		//print("DINTERS A: " + $relation::auxExpr);
		if (memory.get($relation::auxExpr + "\\cap" + $e.text) == null) {
			String newVarName = "VAR" + varNumber;
			varNumber++;
			memory.put($relation::auxExpr + "\\cap" + $e.text, newVarName);
			//print("DINTERS SAVE: " + $relation::auxExpr + "\\cap" + $e.text + " AS: " + newVarName);
			print("dinters(" + a + "," + b + "," + newVarName + ")");
		}
	}
	|	'\\dom' e=expression
	{
		if (memory.get("\\dom" + $e.text) == null) {
			String newVarName = "VAR" + varNumber;
			varNumber++;
			memory.put("\\dom" + $e.text, newVarName);
			String e2 = (String) memory.get($e.text);
			print("dom(" + e2 + "," + newVarName + ")");
		}
	}
	;
	
function:	'\\pfun' expression {type="is_pfun";}
	|	'\\fun' expression {type="is_fun";}
	|	'\\rel' expression {type="is_rel";}
	|	'\\power' expression
	|	'\\seq' expression {type="list";}
	;
	
NAME:	('a'..'z' | 'A'..'Z' | '\\_ ' | '?' )+ ('0'..'9')*;
NUM:	'0'..'9'+ ;
NL:	'\r'? '\n' ;
WS: 	(' '|'\t'|'\r')+ {skip();} ;
SETSTART: '\\{ ';
SETEND: '\\}';
SKIP:	'\\' '\\' {skip();} ;

