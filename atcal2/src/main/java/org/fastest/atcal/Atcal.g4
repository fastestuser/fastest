grammar Atcal;

/************* GLOBAL SRUCTURE *************/
refinementRule : '@RRULE' ID
                 preamble
                 datatypes?
                 laws
                 (plcode)?
                 uut
                 (epilogue)?;

preamble : '@PREAMBLE' ( plcode | preambleImport )+ ;

plcode : '@PLCODE' ;

preambleImport : ID '.@PREAMBLE' STMTEND ;

datatypes : '@DATATYPES' (aliasType)* ;

type : recordType
     | arrayType
     | enumType
     | contractType
     | aliasType
     | intType
     | floatType
     | stringType ;

aliasType : 'DATATYPE' ID '=' type STMTEND;

recordType: 'RECORD' ID '(' ( ID ( ',' ID )* )? ')';

arrayType: 'ARRAY' ID '(' NUMBER ')';

contractType: 'CONSTRUCTOR' ID '(' ( ID ( ',' ID )* )? ')' 'SETTER' ID '(' ( ID ( ',' ID )* )? ')';

enumType: 'ENUM' ID '(' ( ID ( ',' ID )* )? ')' ;

intType: 'INT' ;

floatType: 'FLOAT' ;

stringType: 'STRING' ;

typeCases: 'CASES' '[' typeCase (',' typeCase)* ']' ;

typeCase: ID '->' ( ID | STRING | NUMBER ) ;

laws: '@LAWS'
      (law STMTEND)* ;

uut: '@UUT' ID '(' ( ID ( ',' ID )* )? ')' STMTEND ;

epilogue: '@EPILOGUE'
        ( plcode | ID '.@EPILOGUE')+ ;

/******************* LAWS *********************/
law: ( ID ':' )? ( lawRefinement );
lawRefinement: zExpr '==>' refinement ( ',' refinement )* ;

refinement: ( ID | '[' NUMBER? ']' ) ( 'AS' asRefinement )?
          | lawRefinement ;

asRefinement: ( type | ID ) ( 'WITH' '[' lawRefinement ( ',' lawRefinement)* ']' )?
            | ( type | ID ) ( '[' typeCase (',' typeCase)* ']')? ;

// Z expressions
zExpr : ID                                   # Ident
      | NUMBER                               # NumLiteral
      | STRING                               # StrLiteral
      | '@AUTOFILL'                          # AutoExpr
      | zExpr '.' TUPPROJ                    # ProdProj
      | '<' zExpr ( ',' zExpr )* '>'         # ProdCons
      | zExpr '.' NUMBER                     # SetElem
      | zExpr '.' DOM                        # SetDom
      | zExpr '.' RAN                        # SetRan
      | zExpr '.' PROJ                       # SetProj
      | zExpr INTER zExpr                    # SetInter
      | zExpr UNION zExpr                    # SetUnion
      | zExpr DIFF zExpr                     # SetDiff
      | '{' zExpr ( ',' zExpr )* '}'         # SetCons
      | zExpr '.@CARD'                       # SetCard
      | zExpr MUL zExpr                      # NumMul
      | zExpr DIV zExpr                      # NumDiv
      | zExpr MOD zExpr                      # NumMod
      | zExpr PLUS zExpr                     # NumPlus
      | zExpr MINUS zExpr                    # NumMinus
      | zExpr '++' zExpr                     # StrConcat
      | '(' zExpr ')'                        # Group
      ;

/**************** LEXER *******************/
// Use semicolon as statement end
STMTEND : SEMICOLON+;
fragment SEMICOLON : ';';

// Match identifiers using C syntax
ID : ID_LETTER ( ID_LETTER | DIGIT )* ;
fragment ID_LETTER : 'a'..'z' | 'A'..'Z' | '_' ;
fragment DIGIT : '0'..'9' ;

// Numbers
NUMBER : DIGIT+ ;

// Z number operators
PLUS : '+' ;
MINUS : '-' ;
MUL : '*' ;
DIV : '/' ;
MOD : '%' ;
//     | 'div' ;

// Z dot set operators
DOM : '@DOM' ;
RAN : '@RAN' ;
PROJ : '@' NUMBER ;
TUPPROJ : '#' NUMBER ;
INTER : '/\\' ;
UNION : '\\/' ;
DIFF : '~' ;
//ELEM : '@ELEM' ;

// Match double-quoted strings
STRING : '"' ( ESC | . )*? '"' ;
fragment ESC : '\\' [btnr"\\] ;

// Match whitespace in lexer and remove it.
WS : [ \t\r\n]+ -> skip ;