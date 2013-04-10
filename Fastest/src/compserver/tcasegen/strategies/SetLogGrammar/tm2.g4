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
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("\\power");
		DefaultMutableTreeNode n = new DefaultMutableTreeNode("i");
		root.add(n);
		n = new DefaultMutableTreeNode("d");
		root.add(n);

}

linea: expr 
				{
					System.out.println($expr.salida);
				}
			;

expr returns [String salida]
		:	'{' e=expr '}'
				{
					$salida = $e.salida;
				}
		|	NUM {$salida = $NUM.text;}
		;



BINOP	:	'\\rel'
		|	'\\pfun'
		|	'\\fun'
		|	'\\cross'
		;
		
UNOP	:	'\\power'
		;

NAME:	('a'..'z' | 'A'..'Z' | '\\_ ' | '?' )+ ('0'..'9')*;
NUM:	('0'..'9')+;
WS: 	(' '|'\t'|'\r'|'\n')+ {skip();} ;
