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
	DefaultMutableTreeNode root = new DefaultMutableTreeNode();
	
	//Interfaz para la determinacion del tipo de salida de una funcion.
	//Constraits: El arbol debio ser previamente generado, para un tipo "funcion"
	//Input: Int, con la posicion del hijo deseado (empieza en 0).
	//Output: String, con el valor del nodo.
	String getReturnNodeType(int posicion){
		return (String)	((DefaultMutableTreeNode) root.getChildAt(posicion)).getUserObject();
	}
}

typeManage: type {root = $type.node; System.out.println("Depth: " + root.getDepth()); System.out.println("Node1: " + getReturnNodeType(1));};

type returns [DefaultMutableTreeNode node]
		:	UNOP a=type {$node = new DefaultMutableTreeNode($UNOP.text); $node.add($a.node);}	
		|	a=type BINOP b=type {$node = new DefaultMutableTreeNode($BINOP.text); $node.add($a.node); $node.add($b.node);}
		|	'(' a=type ')' {$node = $a.node;}
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
WS: 	(' '|'\t'|'\r'|'\n')+ {skip();} ;
