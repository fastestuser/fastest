grammar FTCRL;

@header{
package client.blogic.testing.refinement;
}

@members{
}


refinementRule
	:	RRULE name NL
        preamble
		laws
		(plcode NL)?
		uut
		(epilogue NL)?
	;

preamble
	:	PREAMBLE NL
		( name APREAMBLE NL)*
	;

laws
	:	LAWS NL
		(law  NL| reference NL | name DOT LAWS NL)+
	;

law
	:	(name COLON)? synonymLaw
	|	(name COLON)? refinementLaw
	;

reference
	:	name DOT lawName
	;

plcode
	:	PLCODE NL
	;

uut
	:	UUT iName LB iName? (COMMA iName)* RB (MODULE iName)? NL?
	;


epilogue
	:	EPILOGUE NL
		( name AEPILOGUE NL)+
	;

synonymLaw
	:	name EQUALQAUAL (asSynonym | withSynonym)
	;

asSynonym
	:	asRefinement
	;

withSynonym
	:	withRefinement
	;

refinementLaw
	:	sName (COMMA sName)* '==>' NL? refinementSentence (SEMICOLON NL? refinementSentence)*
	;

refinementSentence
	:	sName (COMMA sName)* '==>' refinementSentence
	|	refinement
	;

refinement
	:	(sExprRefinement '==>')? iExprRefinement
	;
	
iExprRefinement
	:	iName (AS asRefinement | asSynonym)?
	;

asRefinement
	:	dataStruct (WITH LSB NL? refinement (SEMICOLON (NL)? refinement)* RSB)?
	;

withRefinement
	:	exprRefinement (COMMA NL? exprRefinement)*
	;
	
exprRefinement
	:	zExpr '==>' refinement
	;

dataStruct
	:	ARRAY
	|	RECORD
	|	MAPPING
	|	list
	|	reference2
	|	enumeration
	|	table
	|	file
	;

sExprRefinement
	:	sName
	|	zExpr
	|	funAppExpr
	;

zExpr
	:	zExprSet
	|	zExprNum
	|	zExprString
	|	zExprSeq
	;

zExprSet
	:	sName (DOT dotSetOper)*
	|	setExtension
	|	zExprSet CUP zExprSet
	;

zExprNum
	:	sName DOT CARD
	|	number
	|	AUTOFILL
	|	zExprNum DIV zExprNum
	|	zExprNum SLASH zExprNum
	|	zExprNum MOD zExprNum
	|	zExprNum PLUS zExprNum
	|	zExprNum MINUS zExprNum
	;

zExprString
	:	string
	|	number
	|	AUTOFILL
	|	sName (DOT dotSetOper)* (DOT (CARD | ARROBA STR))?
	|	zExprSet PLUSPLUS (zExprString | zExprSet)
	|	zExprString PLUSPLUS (zExprString | zExprSet)
	;

zExprSeq
	:	L R 
	;

funAppExpr
	:	iIdent LB (refinement (COMMA refinement)* )? RB
	;

dotSetOper
	:	ARROBA (DOM | RAN | ELEM | CARD)
	|	digit
	|	sName
	;

list
	:	LIST ( LSB listType (COMMA iName)? (COMMA iName)? RSB )?
	;

listType
	:	SLL
	|	DLL
	|	CLL
	|	DCLL
	;

reference2
	:	REF LSB iName RSB
	;

number
	:	DIGIT (digit)*
	;

enumeration
	:	ENUM (LSB sName R ( iName | number ) (COMMA sName R ( iName | number ))* RSB)?
	|	ENUM (LSB number RSB)?
	;

table
	:	TABLE LSB iName COMMA path COMMA fName RSB
	;

file
	:	FILE LSB path RSB
	;

name
	:	LETTER (UNDERSCORE | digit | LETTER )*
	;

lawName
	:	name
	;

sName
	:	name Q?
	;

iName
	:	iIdent
	|	iIdent LSB RSB
	|	iIdent DOT iIdent
	|	iIdent DOTA
	;

iIdent
	:	name
	;
	
fName
	:	name ((DOT)? name)*
	;
	
path
	:	DOT? SLASH? fName (SLASH fName)*
	;

digit :         ZERO | DIGIT; 

string
	:	DQUOTE (.*?) DQUOTE
	;
	
setExtension
	:	LCB (number | string) (COMMA (number | string))* RCB
	;


Q : '?';
EQUALQAUAL : '==';
PLUSPLUS : '++';
UNDERSCORE : '_';
DOTA : '.*';
L : '<';
R : '>';
LB : '(';
RB : ')';
SLASH : '/';
LSB : '[';
RSB : ']';
LCB: '\{';
RCB: '\}';         
ARROBA : '@';           
CARD : '#';           
DQUOTE: '"';           
ZERO : '0';           
PLUS : '+';
MINUS : '-';           
DIV : 'div';
MOD : 'mod';           
SEMICOLON : ';';           
COMMA : ',';           
STR : 'STR';           
CUP : '@CUP@';           
DOT : '.';           
FILE : 'FILE';           
TABLE : 'TABLE';           
ENUM : 'ENUM';           
REF : 'REF';           
SLL : 'SLL';
DLL : 'DLL';
CLL : 'CLL';
DCLL : 'DCLL';           
LIST : 'LIST';           
DOM : 'DOM';
RAN : 'RAN';
ELEM : 'ELEM';
RECORD : 'RECORD';
MAPPING : 'MAPPING';
ARRAY : 'ARRAY';           
WITH : 'WITH';           
AS : 'AS';        
AUTOFILL : '@AUTOFILL';
EPILOGUE : '@EPILOGUE';
AEPILOGUE : '.@EPILOGUE';           
MODULE : 'MODULE';           
UUT : '@UUT';
PLCODE : '@PLCODE';
LAWS : '@LAWS';
PREAMBLE : '@PREAMBLE';
APREAMBLE : '.@PREAMBLE';           
RRULE : '@RRULE';		
DIGIT : '1'..'9';
LETTER : 'a'..'z' | 'A'..'Z';
COLON : ':';
NL:'\n';           
WS: 	(' '|'\t'|'\r'|'~')+ {skip();} ;