grammar FTCRL;

@header{
	package client.blogic.testing.refinamiento;
}

@members{
}

refinementRules
	:       refinementRule+
	;


refinementRule
	:	RRULE name 
                preamble
		laws
		(plcode )?
		uut
		(epilogue )?
	;

preamble
	:	PREAMBLE 
		( name APREAMBLE )*
	;

laws
	:	LAWS 
		(law  | reference  | name ALAWS )+
	;

law
	:	(name COLON)? synonymLaw
	|	(name COLON)? refinementLaw
	;

reference
	:	name DOT lawName
	;

plcode
	:	PLCODE 
	;

uut
	:	UUT iName LB iName? (COMMA iName)* RB (MODULE iName)? ?
	;


epilogue
	:	EPILOGUE 
		( name AEPILOGUE )+
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
	:	sName (COMMA sName)* '==>' ? refinementSentence (SEMICOLON ? refinementSentence)*
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
	:	dataStruct (WITH LSB ? refinement (SEMICOLON ()? refinement)* RSB)?
	;

withRefinement
	:	exprRefinement (COMMA ? exprRefinement)*
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
	;

zExprString
	:	string
	|	number
	|	AUTOFILL
	|	sName (DOT (dotSetOper* | CARD | STR))?
	|	zExprString PLUSPLUS zExprString
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
	:	ENUM ( LSB ( sName R ( iName | number )+ ) | number RSB)?
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
	:	DQUOTE (digit | LETTER)* DQUOTE
	;
	
setExtension
	:	LCB RCB
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
RCB: '\{';         
ARROBA : '@';           
CARD : '#';           
DQUOTE: '"';           
ZERO : '0';           
PLUS : '+';           
DIV : 'div';
MOD : 'mod';           
SEMICOLON : ';';           
COMMA : ',';           
STR : '@STR';           
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
ALAWS : '@LAWS';           
PREAMBLE : '@PREAMBLE';
APREAMBLE : '.@PREAMBLE';           
RRULE : '@RRULE';		
DIGIT : '1'..'9';
LETTER : 'a'..'z' | 'A'..'Z';
COLON : ':';           
WS: 	(' '|'\t'|'\r'|'~'|'\n')+ {skip();} ;