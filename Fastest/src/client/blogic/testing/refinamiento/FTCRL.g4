grammar FTCRL;

@header{
package client.blogic.testing.refinamiento;
}

@members{
//Devuelve el valor, como string, obtenido del caso de prueba
String getValor(String var) {
	if (var.equals("u?"))
		return "345";
	else if (var.equals("name?"))
		return "name0";
	else if (var.equals("n?"))
		return "n0";
	return "";
}

//Devuelve el tipo, como string, obtenido del codigo java
String getType(String var) {
	if (var.equals("u?"))
		return "int";
	else if (var.equals("name?"))
		return "char *";
	else if (var.equals("n?"))
		return "char *";
		
	return "";
}

}

//Gramática
refinementLaw
	:	'@RRULE' name NL
    	preamble NL
		laws
		(plcode NL)?
		uut
		( epilogue NL)?
		EOF
	;
		
preamble
	:	'@PREAMBLE' NL 
		(pLCode | name '.@PREAMBLE' NL)+
		
	;

plcode
	:	'@PLCODE' NL pLCode NL
	;
	
uut returns [String code = "";]
	:	'@UUT' iName
		'(' (iName)? (',' iName)*  ')' ('MODULE' iName)? NL
	;
	
epilogue
	:	'@EPILOGUE' NL
		(pLCode | name '.@EPILOGUE' NL)+
	;
	
laws
	:	'@LAWS' NL
		(law NL | reference NL | name '.@LAWS' NL)+
	;

reference
	:	name '.' lawName
	;

lawName
	:	name
	;

law
	:	(name ':')? lawSynonym
	|	(name ':')? lawRefinement
	;
	
lawSynonym
	:	name '==' ( asSynonym | withSynonym )
	;
	
asSynonym
	:	asRefinement
	;
	
withSynonym
	:	withRefinement
	;
	
lawRefinement
	:	sName (',' sName)*
		 '==>' refinement (';' NL? refinement)*
	;
	
refinement returns [String varName]
	:	iName ('AS' asRefinement | asSynonym)?
	|	exprRefinement
	;
	
asRefinement
	:	dataStruct ('WITH[' withRefinement ']')?
	;
	
withRefinement
	:	exprRefinement (',' NL? exprRefinement)*
	;
	
exprRefinement
	:	zExpr '==>' refinement
	;
	
zExpr
	:	zExprSet
	|	zExprNum
	|	zExprString
	|	zExprSeq
	;
	
zExprSet
	:	sName ('.' dotSetOper)?
	|	setExtension
	|	zExprSet '∪' zExprSet
	;
	
zExprNum
	:	sName ('.#')?
	|	number
	|	'@AUTOFILL'
	|	zExprNum 'div' zExprNum 
	;
	
zExprString
	:	string
	|	number
	|	'@AUTOFILL'
	|	sName ('.(' (dotSetOper | '#' | '@STR') ')')?
	|	zExprString '++' zExprString
	;
	
zExprSeq : '<>';

dotSetOper
	:	'@' ('dom' | 'ran' | 'ELEM' | '#') 
	|	DIGIT
	|	sName
	|	dotSetOper '.' dotSetOper
	;
	
dataStruct
	:	'ARRAY'
	| 'RECORD'
	| list
	| map
	| reference2
	| enumeration
	| table
	| file
	;

list
	:	'LIST' ('[' listType ',' ( iName | iName ',' iName ) ']' )?
	;
	
map
	:	'MAPKEY[' iName ',' iType (',' iName )? ']' 
	| 'MAPVAL[' iName ',' iType ']'
	;
	
iType
	:	name
	;
	
reference2
	:	'REF[' iName ']'
	;
	
enumeration
	:	'ENUM' ( '[' ( sName '>' ( iName | number )+ ) | number ])?
	;
	
table
	:	'TABLE[' iName ',' path ',' fName ']'
	;
	
file
	:	'FILE[' path ']'
	;
	
listType
	:	'SLL'
	|	'DLL'
	|	'CLL'
	|	'DCLL'
	;
	
pLCode returns [String code]
	:	'\\\\beginJava' NL anychar NL '\\\\endJava'
	;
	
anychar
	:	(ANYCHAR | '#' | DIGIT | LETTER | '.' | '>' | NL)*
	;
	
name
	:	LETTER ( '_' | DIGIT | LETTER )*
	;
	
sName
	:	name '?'?
	;
	
iName
	:	iIdent
	|	iIdent '[]'
	|	iIdent '.' iIdent
	|	iIdent '.*'
	;

iIdent
	:	name
	;
	
fName
	:	name (('.')? name)*
	;
	
path
	:	'.'? '/'? fName ('/' fName)*
	;
	
string
	:	'"' (DIGIT | LETTER)* '"'
	;
	
setExtension
	:	'\{' '\}'
	;

number
	:	DIGIT ('0' | DIGIT)*
	;
		
DIGIT : '1'..'9';
LETTER : 'a'..'z' | 'A'..'Z';
NL:	'\n' ;
WS: 	(' '|'\t'|'\r'|'~')+ {skip();} ;
ANYCHAR: . ;