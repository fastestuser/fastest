grammar FTCRL;

@header{
package client.blogic.testing.refinamiento;
}

@members{
}

refinementRule
	:	'@RRULE' name NL
        preamble
		laws
		(plcode NL)?
		uut
		( epilogue NL)?
	;

preamble
	:	'@PREAMBLE' NL
		(pLCode NL | name '.@PREAMBLE' NL)*
	;

laws
	:	'@LAWS' NL
		(law NL | reference NL | name '.@LAWS' NL)+
	;

law
	:	(name ':')? synonymLaw
	|	(name ':')? refinementLaw
	;

reference
	:	name '.' lawName
	;

plcode
	:	'@PLCODE' NL pLCode NL
	;

uut
	:	'@UUT' iName '(' iName? (',' iName)* ')' ('MODULE' iName)? NL?
	;

epilogue
	:	'@EPILOGUE' NL
		(pLCode | name '.@EPILOGUE' NL)+
	;

synonymLaw
	:	name '==' (asSynonym | withSynonym)
	;

asSynonym
	:	asRefinement
	;

withSynonym
	:	withRefinement
	;

refinementLaw
	:	sName (',' sName)* '==>' NL? refinementSentence (';' NL? refinementSentence)*
	;

refinementSentence
	:	sName (',' sName)* '==>' refinementSentence
	|	refinement
	;

refinement
	:	(sExprRefinement '==>')? iExprRefinement
	;
	
iExprRefinement
	:	iName ('AS' asRefinement | asSynonym)?
	;

asRefinement
	:	dataStruct ('WITH' '[' NL? refinement (';' (NL)? refinement)* ']')?
	;

withRefinement
	:	exprRefinement (',' NL? exprRefinement)*
	;
	
exprRefinement
	:	zExpr '==>' refinement
	;

dataStruct
	:	'ARRAY'
	|	'RECORD'
	|	'MAPPING'
	|	list
	|	reference2
	|	enumeration
	|	table
	|	file
	;

sExprRefinement
	:	sName
	|	zExprSet
	|	zExprNum
	|	zExprString
	|	zExprSeq
	|	funAppExpr
	;

zExpr
	:	zExprSet
	|	zExprNum
	|	zExprString
	|	zExprSeq
	;

zExprSet
	:	sName ('.' dotSetOper)*
	|	setExtension
	|	zExprSet '@CUP@' zExprSet
	;

zExprNum
	:	sName '.' '#'
	|	number
	|	'@AUTOFILL'
	|	zExprNum 'div' zExprNum
	|	zExprNum '/' zExprNum
	|	zExprNum 'mod' zExprNum
	|	zExprNum '+' zExprNum
	;

zExprString
	:	string
	|	number
	|	'@AUTOFILL'
	|	sName ('.' (dotSetOper* | '#' | '@STR'))?
	|	zExprString '++' zExprString
	;

zExprSeq
	:	'<>'
	;

funAppExpr
	:	iIdent '(' (refinement (',' refinement)* )? ')'
	;

dotSetOper
	:	'@' ('DOM' | 'RAN' | 'ELEM' | '#')
	|	digit
	|	sName
	;

list
	:	'LIST' ( '[' listType (',' iName)? (',' iName)? ']' )?
	;

listType
	:	'SLL'
	|	'DLL'
	|	'CLL'
	|	'DCLL'
	;

reference2
	:	'REF' '[' iName ']'
	;

enumeration
	:	'ENUM' ( '[' ( sName '>' ( iName | number )+ ) | number ']')?
	;

table
	:	'TABLE' '[' iName ',' path ',' fName ']'
	;

file
	:	'FILE' '[' path ']'
	;

name
	:	LETTER ('_' | digit | LETTER )*
	;

lawName
	:	name
	;

sName
	:	name '?'?
	;

iName
	:	iIdent
	|	iIdent '[' ']'
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
	:	'"' (digit | LETTER)* '"'
	;
	
setExtension
	:	'\{' '\}'
	;

number
	:	DIGIT (digit)*
	;

pLCode
	:	'\\\\beginJava' NL anychar NL '\\\\endJava'
	;

anychar
	:	(ANYCHAR | '#' | digit | LETTER | '.' | '>' | ';' | NL)*
	;
	
digit : '0' | DIGIT; 
		
DIGIT : '1'..'9';
LETTER : 'a'..'z' | 'A'..'Z';
NL:	'\n' ;
WS: 	(' '|'\t'|'\r'|'~')+ {skip();} ;
ANYCHAR: . ;
		
