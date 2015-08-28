grammar FTSDL;

@header{
package client.blogic.testing.ttree.strategies.ftsdl;
}

strategies
	:	(strategy (NL* | EOF))+
	;

strategy 
	:	'STRATEGY' IDENTIFIER NL
		statementBlock
                'END'
	;

statement
	:	expression NL	
	|	variableAssignment NL
	|	'exit' NL
	|	ifStatement
	|	forStatement
	|	whileStatement
	|	foreachStatement
	;
	
statementBlock
	:	statement*
	;

variableAssignment
	:	IDENTIFIER '=' expression
	;

ifStatement
	:	'IF' '(' expression ')' NL? statementBlock ('ELSE' NL? statementBlock)? 'END' NL
	;

forStatement
	:	'FOR' '(' ( variableAssignment | expression? ) ';'
 		expression? ';'
                expression? ')' NL? statementBlock
		'END' NL
	;

whileStatement
	:	'WHILE' '(' expression ')'
                statementBlock 'END' NL
	;

foreachStatement
	:	'FOREACH' '(' IDENTIFIER ':' expression ')' NL? statementBlock 'END' NL
	;

expression
	:	'-' expression
	|	'++' expression
	|	'--' expression
	|	expression '++'
	|	expression '--'
	|	expression '+' expression
	|	expression '-' expression
	|	expression '*' expression
	|	expression '/' expression
	|	expression TestingOP expression
	|	expression '&&' expression
	|	expression '||' expression
	|	logicalExpression
	|	literalExpression
	|	tactic
	|	zOperator
	|	'(' expression ')'
	|	command
	|	function '(' arglist? ')'
	|	expression '(' arglist? ')'
	|	expression '.' expression
	|	'OP'
	|	'TI'
	;

logicalExpression
	:	'!' expression
	|	'true'
	|	'false'
	;

command
	:	'genalltt'
	|	'prunett'
	|	'addtactic' expression tactic expression expression?
	|	'applystrategy' expression expression
	; 

function
	:	treeManagement
	|	parametersManagement
	|	expressionManagement
	|	stringManagement
	|	enumerationManagement
	|	tacticManagement
	;

treeManagement
	:	'treeRoot'
	|	'leaves'
	|	'getName'
	|	'children'
	|	'getParent'
	|	'isLeaf'
	;

parametersManagement
	:	'getSPOperators'
	|	'getSPExpressions'
	|	'getNRVariables'
	|	'getFTVariables'
	|	'getISEExpressions'
	;

tacticManagement
	:	'expressionSPAppearsIn'
        |	'expressionNRAppearsIn'
	|	'variableFTAppearsIn'
	|	'expressionISEAppearsIn'
	;


expressionManagement
	:	'getOperator'
        |	'getString'
	;

stringManagement
	:	'compare'
	;

enumerationManagement
	:	'hasMore'
        |	'next'
	;

tactic
	:	'SP'
	|	'NR'
	|	'FT'
	|	'ISE'
	;

zOperator
	:	'\\cup'
	;

arglist
	:	expression (',' expression)*
	;

literalExpression
	:	INTEGER
	|	IDENTIFIER
	;

TestingOP
	:	'>'
	|	'<'
	|	'>='
	|	'<='
	|	'=='
	|	'!='
	|	'IN'
	;

IDENTIFIER
	: ('a'..'z' | 'A'..'Z') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')*
	;

INTEGER
	: ('0'..'9')+
	;

NL	:	'\n' ;

WS
	: (' '|'\r'|'\t')+ {skip();}
	;

