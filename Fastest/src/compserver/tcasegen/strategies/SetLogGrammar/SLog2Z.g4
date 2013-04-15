grammar SLog2Z;

@header {
package compserver.tcasegen.strategies.SetLogGrammar;
	import java.util.HashMap;
	import java.util.ArrayList;
	import java.util.regex.Matcher;
	import java.util.regex.Pattern;
	import java.util.Iterator;
	import javax.swing.tree.DefaultMutableTreeNode;
	import javax.swing.tree.DefaultTreeModel;
	import javax.swing.tree.TreeNode;
	import compserver.tcasegen.strategies.SetLogGrammar.StringPointer;
}

@members {
	HashMap<String,StringPointer> vars = new HashMap();	
	HashMap<String,String> zNames = new HashMap();
	HashMap<String,String> tipos = new HashMap();
	HashMap<String,String> zVars = new HashMap();
	
	public HashMap<String,String> getZVars(){
		return zVars;
	}
	
	
	public void print(String s){
		System.out.println(s);
	}
	public void loadTablas(ExprParser parser){
		zNames = invertMemory(parser.getMemory());
		tipos = parser.getTypes();
		zVars = parser.getZVars();
		
		System.out.println("\n");System.out.println("memory: "); printHashMap(zNames);
		System.out.println("\n tipos: "); printHashMap(tipos);System.out.println("\n");
		
	}
	private String getCte(String cte, String tipo) {
		ANTLRInputStream input = new ANTLRInputStream(tipo);
        TypeManagerLexer lexer = new TypeManagerLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        TypeManagerParser parser = new TypeManagerParser(tokens);
        parser.typeManage();
        DefaultMutableTreeNode root =  parser.getRoot();
        
        System.out.println("\narbol " + parser.printTree(root)); 
        System.out.println("cte " + cte);
        System.out.println("tipo " + tipo);
        System.out.println("root " + root.toString());
         
        
        
        ConstantCreator cc = new ConstantCreator(cte,root,tipos,zNames,vars);
        return cc.getCte();
	}
	
	private HashMap invertMemory(HashMap m){
		Iterator iterator = m.keySet().iterator();  
   		HashMap s = new HashMap();
   		
		while (iterator.hasNext()) {  
		   String key = iterator.next().toString();  
		   String value = m.get(key).toString();  
		   s.put(value,key);
		} 	
		return s;
	}
	
	public void printHashMap(HashMap map){
		Iterator iterator = map.keySet().iterator();  
		String key,value;
		while (iterator.hasNext()) {  
		   key = iterator.next().toString();
		   if (map.get(key) == null)
			   value = "nullc";
		   else 
			   value = map.get(key).toString();
		   System.out.println(key + " = " + value);  
		} 
	}
	
	public void llenarZVars(){
		Iterator iterator = vars.keySet().iterator();  
		String slname,zname,valor;
		while (iterator.hasNext()) {  
			slname = iterator.next().toString();
			if (vars.get(slname)!=null){	
				valor = vars.get(slname).toString();
				zname = zNames.get(slname);
				if (zVars.containsKey(zname)){
					zVars.put(zname,valor);
				} 	
			}  
		} 
	}
	
}

lineas
	:	constr NL 	
		( seqIgual NL)+ 
		{
			System.out.println("salida: \n");
			printHashMap( vars );llenarZVars();
			System.out.println("\nzVars:");
			printHashMap(zVars);
			System.out.println("const***** " + $constr.text);
		}
	;

constr
	:	'_CONSTR' '=' '[' (restr(','restr)*)? '],'
	;
	
restr
locals [StringPointer valor;]
@init{$restr::valor = new StringPointer();}
	: 'set(' expr ')' {$restr::valor.setString("\\{\\}"); vars.put($expr.text,$restr::valor);}
	| 'list(' expr ')' {$restr::valor.setString("\\langle\\rangle"); vars.put($expr.text,$restr::valor);}
	| 'integer(' expr ')' {$restr::valor.setString("666"); vars.put($expr.text,$restr::valor);}
	| expr 'neq' expr 
	;

seqIgual
locals [StringPointer valor;]
@init{$seqIgual::valor = new StringPointer();}
	:	'NUM = int(-10000000000, 10000000000),'  	 
	|	'NAT = int(0, 10000000000),'
	|	(v1=NAME {vars.put($v1.text,$seqIgual::valor);} '=' v2=expr {vars.put($v2.text,$seqIgual::valor);} ',')+
		{
			String zname = zNames.get($v1.text);
			String tipo = tipos.get(zname);
			if (!tipo.startsWith("BasicType") && !tipo.startsWith("EnumerationType") )
			{
				String var = $v2.valor;
				$seqIgual::valor.setString(getCte(var,tipo));
			}
			 	
		 }
	;
	
expr
returns [String valor]
	:	CTE {$valor = $CTE.text;}
	|   NAME {$valor = $NAME.text;} 
	|	'{' a=expr {$valor = "{" + $a.valor;} (','  b=expr {$valor = $valor + "," + $b.valor;})* ('\\' expr)* '}' {$valor = $valor + "}";} 
	|	'[' a=expr {$valor = "[" + $a.valor;} (','  b=expr {$valor = $valor + "," + $b.valor;})* ('|' expr)* ']' {$valor = $valor + "]";}
	|	'-' expr {$valor = "-" + $valor ;}
	;
      
NAME:	('A'..'Z' ) ('a'..'z' | 'A'..'Z' |'0'..'9')*;
CTE:    ('_'|'-'|'a'..'z' |'0'..'9') ('a'..'z' | 'A'..'Z' |'0'..'9')*;
NUM:	'0'..'9'+ ;

NL:	'\n';
WS: 	(' '|'\t'|'\r')+ {skip();} ;
SKIP:	'\\' '\\' {skip();} ;
