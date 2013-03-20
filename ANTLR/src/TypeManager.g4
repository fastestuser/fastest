grammar TypeManager;

//Gramatica para determinar el tipo de un determinado elemento de una expression Z.
//Para eso genera a partir de la entrada (tipo Z) un arbol correspondiente al tipo,
//el cual puede ser accedido o consultado mediante la interfaz.

@header {
	import javax.swing.tree.DefaultMutableTreeNode;
	import javax.swing.tree.DefaultTreeModel;
	import javax.swing.tree.TreeNode;
}

@members {
	TreeNode root = new DefaultMutableTreeNode();
}

typeManage: type {root = $type.node;};

type returns [TreeNode node]
		:	UNOP type {$node = new DefaultMutableTreeNode();}	
		|	a=type BINOP b=type {$node = new DefaultMutableTreeNode();}
		|	'(' type ')' {$node = $type.node;}
		|	'\\num' {$node = new DefaultMutableTreeNode("\\num");}
		|	'\\nat' {$node = new DefaultMutableTreeNode("\\nat");}
		|	NAME {$node = new DefaultMutableTreeNode($NAME.text);}
		;

BINOP	:	'\\rel'
		|	'\\pfun'
		|	'\\fun'
		|	'\\cross'
		;
		
UNOP	:	'\\power'
		;

NAME:	('a'..'z' | 'A'..'Z' | '\\_ ' | '?' )+ ('0'..'9')*;
NUM:	'0'..'9'+ ;
//SETSTART: '\\{';
//SETEND: '\\}';

//NL:	'\r'? '\n' ;
WS: 	(' '|'\t'|'\r'|'\n')+ {skip();} ;
