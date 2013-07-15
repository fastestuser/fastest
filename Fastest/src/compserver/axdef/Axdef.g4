grammar Axdef;

@header {
	package compserver.axdef;
	import java.util.HashMap;
	import java.util.ArrayList;
	import java.util.regex.Matcher;
	import java.util.regex.Pattern;
	import java.util.Collection;
	import java.util.Iterator;
	import java.util.Set;
	import java.lang.String;
	import javax.swing.tree.DefaultMutableTreeNode;
	import javax.rmi.CORBA.Util;
 }

@members {
	ArrayList<String> arguments = new ArrayList<String>();
	String functionName;
	int argAmmount;

	DefaultMutableTreeNode root = new DefaultMutableTreeNode();
	public DefaultMutableTreeNode getRoot() {
		return root;
	}
}

strategy
	: expression {root = $expression.node;}
	;

expression returns [DefaultMutableTreeNode node]
	:	e1=expression {$node = new DefaultMutableTreeNode("APPLY");$node.add($e1.node);} ('~' simpleArgument {$node.add($simpleArgument.node);}| complexArgument {$node.add($complexArgument.node);})+
	|	e1=expression OP e2=expression {$node = new DefaultMutableTreeNode($OP.text); $node.add($e1.node); $node.add($e2.node);}
	//|	e1=expression IMGSTART e2=expression IMGEND {$node = new DefaultMutableTreeNode("\\limg\\rimg"); $node.add($e1.node); $node.add($e2.node);}
	|	simpleArgument {$node = $simpleArgument.node;}
	|	complexArgument {$node = $simpleArgument.node;}
	; 

simpleArgument returns [DefaultMutableTreeNode node]
	:	WORD {$node = new DefaultMutableTreeNode($WORD.text);}
	|	NUM {$node = new DefaultMutableTreeNode($NUM.text);}
	|	'\\emptyset' {$node = new DefaultMutableTreeNode("\\emptyset");}
	; 

complexArgument returns [DefaultMutableTreeNode node]
	:	'(' {$node = new DefaultMutableTreeNode("()");} c1=expression {$node.add($c1.node);} (',' c2=expression {$node.add($c2.node);})* ')'
	//|	'\\{' {$node = new DefaultMutableTreeNode("\\{}\\");} (e1=expression {$node.add($e1.node);})? (',' e2=expression {$node.add($e2.node);})* '}'
	//|	'\\{' {$node = new DefaultMutableTreeNode("\\{}\\");} declPart ('|' predicate)? ('@' e1=expression)? '}'
	//	{ $node.add($declPart.node); $node.add($predicate.node); $node.add($e1.node); 
	//	}
	//|	\\langle {$node = new DefaultMutableTreeNode("\\langle\\rangle");} (e1=expression {$node.add($e1.node);})? (',' e2=expression {$node.add($e2.node);})* \\rangle
	//|	expression '.' (WORD | NUM)
	;

OP: ('+' | '>');

WORD: ('a'..'z'|'A'..'Z') ('a'..'z'|'A'..'Z'|'?'|'_')* ;
NUM: ('0'..'9')+ ;
WS	: (' '|'\n'|'\r')+ {skip();};