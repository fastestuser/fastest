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
	
	public DefaultMutableTreeNode getRoot() {
		return root;
	}
	
	//Interfaz para la determinacion del tipo del root.
	//Constraits: El arbol debio ser previamente generado.
	//Output: String, con el valor del root.
	String getReturnRootType(){
		return (String)	((DefaultMutableTreeNode) root).getUserObject();
	}
	
	//Interfaz para la determinacion del tipo de salida de una funcion.
	//Constraits: El arbol debio ser previamente generado, para un tipo "funcion"
	//Input: Int, con la posicion del hijo deseado (empieza en 0).
	//Output: String, con el valor del nodo.
	String getReturnChildNodeType(int posicion){
		return (String)	((DefaultMutableTreeNode) root.getChildAt(posicion)).getUserObject();
	}
	
	String printTree(DefaultMutableTreeNode tree){
		if (tree.isLeaf()) 
			return (String) tree.getUserObject();
		else if (tree.getChildCount() == 1)
			if ( ((String) tree.getUserObject()).equals("()")) //REVISAR
				return "(" + printTree((DefaultMutableTreeNode) tree.getChildAt(0)) + ")";
			else
				return (String) tree.getUserObject() + printTree((DefaultMutableTreeNode) tree.getChildAt(0));
		else //tiene dos hijos
			return printTree((DefaultMutableTreeNode) tree.getChildAt(0)) + ((String) tree.getUserObject()) + printTree((DefaultMutableTreeNode) tree.getChildAt(1));
	}
	
	String printChild(int posicion) {
		return printTree((DefaultMutableTreeNode) root.getChildAt(posicion));
	}
}

typeManage: type {root = $type.node; /*System.out.println("Root: " + printTree(root)); System.out.println("Node1: " + getReturnNodeType(0));*/};

type returns [DefaultMutableTreeNode node]
		:	UNOP a=type {$node = new DefaultMutableTreeNode($UNOP.text); $node.add($a.node);}	
		|	a=type BINOP b=type {$node = new DefaultMutableTreeNode($BINOP.text); $node.add($a.node); $node.add($b.node);}
		|	'(' a=type ')' {$node = new DefaultMutableTreeNode("()"); $node.add($a.node);}
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
		|	'\\seq'
		;

NAME:	('a'..'z' | 'A'..'Z' | '\\_ ' | '?' )+ ('0'..'9')*;
WS: 	(' '|'\t'|'\r'|'\n')+ {skip();} ;
