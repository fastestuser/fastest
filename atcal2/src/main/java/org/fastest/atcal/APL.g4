// The Abstract Programming Language grammar (APL)
// This grammar is written for documentation and experimentation purposes.
// ATCAL does not use any code generated from this grammar, instead it uses an internal tree representation that does
// not require an intermediate parsing step.
grammar APL;

prog : stat+ ;

stat : type ID ('['INT']')? NEWLINE
     | lvalue '=' expr NEWLINE
     | NEWLINE
     ;

type : 'int'
     | 'float'
     | 'enum' ID '[' ID (',' ID)* ']'
     | type '[]'
     | 'record' ID '[' type ID (',' type ID)* ']'
     | 'datatype' ID
     ;

lvalue : ID
       | lvalue '[' INT ']'
       | lvalue '.' ID
       ;

expr : ID
     | INT
     | STRING
     | 'CALL' ID '(' expr (',' expr)* ')'
     ;

//LEXER
ID : [a-zA-Z]+ ; // match identifiers
INT : [0-9]+ ; // match integers
NEWLINE:'\r'? '\n' ; // return newlines to parser (end-statement signal)
WS : [ \t]+ -> skip ; // toss out whitespace

// Match double-quoted strings
STRING : '"' ( ESC | . )*? '"' ;
fragment ESC : '\\' [btnr"\\] ;