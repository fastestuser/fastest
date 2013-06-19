grammar TypeManager;

//Gramatica para determinar el tipo de un determinado elemento de una expression Z.
//Para eso genera a partir de la entrada (tipo Z) un arbol correspondiente al tipo,
//el cual puede ser accedido o consultado mediante la interfaz.

@header {
	package compserver.tcasegen.strategies.setlog;
	import javax.swing.tree.DefaultMutableTreeNode;
	import javax.swing.tree.DefaultTreeModel;
	import javax.swing.tree.TreeNode;
}

@members {
	DefaultMutableTreeNode root = new DefaultMutableTreeNode();
	
	public DefaultMutableTreeNode getRoot() {
		return root;
	}
	
	public static String printTree(DefaultMutableTreeNode tree){
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
}

typeManage: type {root = $type.node; /*System.out.println("Root: " + printTree(root)); System.out.println("Node1: " + getReturnNodeType(0));*/};
typeManageNorm: typeNorm {root = $typeNorm.node; /*System.out.println("Root: " + printTree(root)); System.out.println("Node1: " + getReturnNodeType(0));*/};

type returns [DefaultMutableTreeNode node]
		:	UNOP a=type {$node = new DefaultMutableTreeNode($UNOP.text); $node.add($a.node);}
		|	a=type '\\cross' b=type {$node = new DefaultMutableTreeNode("\\cross"); $node.add($a.node); $node.add($b.node);}
		|	a=type BINOP b=type {$node = new DefaultMutableTreeNode($BINOP.text); $node.add($a.node); $node.add($b.node);}
		|	'(' a=type ')' {$node = new DefaultMutableTreeNode("()"); $node.add($a.node);}
		|	'\\num' {$node = new DefaultMutableTreeNode("\\num");}
		|	'\\nat_{1}' {$node = new DefaultMutableTreeNode("\\nat_{1}");}
		|	'\\nat' {$node = new DefaultMutableTreeNode("\\nat");}
		|	NAME {$node = new DefaultMutableTreeNode($NAME.text);}
		| 	e1=(NUM|NAME) '\\upto' e2=(NUM|NAME) {$node = new DefaultMutableTreeNode($e1.text + "\\upto" + $e2.text);}
		;

typeNorm returns [DefaultMutableTreeNode node]
		:	UNOP a=typeNorm {$node = new DefaultMutableTreeNode($UNOP.text); $node.add($a.node);}
		|	a=typeNorm '\\cross' b=typeNorm
				{
					$node = new DefaultMutableTreeNode("\\cross");
					$node.add($a.node); 
					$node.add($b.node);
				}	
		|	a=typeNorm BINOP b=typeNorm 
				{
					$node = new DefaultMutableTreeNode("\\power"); 
					DefaultMutableTreeNode cross = new DefaultMutableTreeNode("\\cross");
					$node.add(cross);
					cross.add($a.node); 
					cross.add($b.node);
				}
		|	'(' a=typeNorm ')' {$node = $a.node;}
		|	'\\num' {$node = new DefaultMutableTreeNode("\\num");}
		|	'\\nat_{1}' {$node = new DefaultMutableTreeNode("\\nat_{1}");}
		|	'\\nat' {$node = new DefaultMutableTreeNode("\\nat");}
		|	NAME {$node = new DefaultMutableTreeNode($NAME.text);}
		| 	e1=(NUM|NAME) '\\upto' e2=(NUM|NAME) {$node = new DefaultMutableTreeNode($e1.text + "\\upto" + $e2.text);}
		;		

BINOP	:	'\\rel'
		|	'\\pfun'
		|	'\\ffun'
		|	'\\fun'
		;
		
NAME:	('a'..'z' | 'A'..'Z' | '\\_ ' | '?' )+ ('0'..'9')*;
		
UNOP	:	'\\power'
		|	'seq_{1}' | 'seq_{1}~'
		|	'\\seq'
		|	'\\finset'
		;

NUM:	('0'..'9')+;
WS: 	(' '|'\t'|'\r'|'\n')+ {skip();} ;