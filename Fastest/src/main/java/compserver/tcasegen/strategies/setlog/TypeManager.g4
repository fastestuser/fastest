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
	
	public static String printTree(DefaultMutableTreeNode tree){
		if (tree.isLeaf()) 
			return (String) tree.getUserObject();
		else if (tree.getChildCount() == 1)
			if ( ((String) tree.getUserObject()).equals("()"))
				return "(" + printTree((DefaultMutableTreeNode) tree.getChildAt(0)) + ")";
			else
				return (String) tree.getUserObject() + printTree((DefaultMutableTreeNode) tree.getChildAt(0));
		else if (tree.getChildCount() == 2)
			return printTree((DefaultMutableTreeNode) tree.getChildAt(0)) + ((String) tree.getUserObject()) + printTree((DefaultMutableTreeNode) tree.getChildAt(1));
		else {//tiene varios hijos, es un CROSS!
			String returnString = printTree((DefaultMutableTreeNode) tree.getChildAt(0));
			int i = 1;
			while (i < tree.getChildCount()) {
				returnString = returnString.concat("\\cross");
				returnString = returnString.concat(printTree((DefaultMutableTreeNode) tree.getChildAt(i)));
				i++;
			}
			return returnString;
		}
	}
}

typeManage: type {root = $type.node;};
typeManageNorm: typeNorm {root = $typeNorm.node;};

type returns [DefaultMutableTreeNode node]
		:	UNOP a=type {$node = new DefaultMutableTreeNode($UNOP.text); $node.add($a.node);}
		|	a=type {$node = new DefaultMutableTreeNode("\\cross"); $node.add($a.node);}
		    ('\\cross' c=typeCross {$node.add($c.node);})+ 
		|	a=type BINOP b=type {$node = new DefaultMutableTreeNode($BINOP.text); $node.add($a.node); $node.add($b.node);}
		|	'(' a=type ')' {$node = new DefaultMutableTreeNode("()"); $node.add($a.node);}
		|	'\\num' {$node = new DefaultMutableTreeNode("\\num");}
		|	'\\nat_{1}' {$node = new DefaultMutableTreeNode("\\nat_{1}");}
		|	'\\nat' {$node = new DefaultMutableTreeNode("\\nat");}
		|	NAME {$node = new DefaultMutableTreeNode($NAME.text);}
		| 	e1=(NUM|NAME) '\\upto' e2=(NUM|NAME) {$node = new DefaultMutableTreeNode($e1.text + "\\upto" + $e2.text);}
		;

typeCross returns [DefaultMutableTreeNode node]
		:	UNOP a=type {$node = new DefaultMutableTreeNode($UNOP.text); $node.add($a.node);}
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
		|	a=typeNorm {$node = new DefaultMutableTreeNode("\\cross"); $node.add($a.node);}
		    ('\\cross' c=typeNormCross {$node.add($c.node);})+ 	
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

typeNormCross returns [DefaultMutableTreeNode node]
		:	UNOP a=typeNorm {$node = new DefaultMutableTreeNode($UNOP.text); $node.add($a.node);}
		|	a=typeNorm BINOP b=typeNorm {$node = new DefaultMutableTreeNode($BINOP.text); $node.add($a.node); $node.add($b.node);}
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