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
}

@members {
	HashMap<String,StringValor> salida = new HashMap();	
	HashMap<String,String> zNames = new HashMap();
	HashMap<String,String> tipos = new HashMap();
	HashMap<String,String> zVars = new HashMap();
	
	public HashMap<String,String> getZVars(){
		return zVars;
	}
	
	public class StringValor{
		private String valor;
		public void setValor(String s){
			this.valor = s;		
		}
		public String toString(){
			return this.valor;		
		}
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
         
        
        
        ConstantCreator cc = new ConstantCreator(cte,root,tipos,zNames);
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
			   value = "null";
		   else 
			   value = map.get(key).toString();
		   System.out.println(key + " = " + value);  
		} 
	}
	
	public void llenarZVars(){
		Iterator iterator = salida.keySet().iterator();  
   		String slname,zname,valor;
		while (iterator.hasNext()) {  
		   slname = iterator.next().toString();
		   valor = salida.get(slname).toString(); 
		   if (zNames.containsKey(slname)){
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
			printHashMap( salida );llenarZVars();
			System.out.println("\nzVars:");
			printHashMap(zVars);
			System.out.println("const***** " + $constr.text);
		}
	;

constr
	:	'_CONSTR' '=' '[' (restr(','restr)*)? '],'
	;
	
restr
locals [StringValor valor;]
@init{$restr::valor = new StringValor();}
	: 'set(' expr ')' {$restr::valor.setValor("\\{\\}"); salida.put($expr.text,$restr::valor);}
	| 'list(' expr ')' {$restr::valor.setValor("\\langle\\rangle"); salida.put($expr.text,$restr::valor);}
	| 'integer(' expr ')' {$restr::valor.setValor("666"); salida.put($expr.text,$restr::valor);}
	| expr 'neq' expr 
	;

seqIgual
locals [StringValor valor;]
@init{$seqIgual::valor = new StringValor();}
	:	'NUM = int(-10000000000, 10000000000),'  	 
	|	'NAT = int(0, 10000000000),'
	|(a = NAME {salida.put($a.text,$seqIgual::valor);} '=' b = expr {salida.put($b.valor,$seqIgual::valor);} ',')+ 
		{
			String zname = zNames.get($a.text);
			String tipo = tipos.get(zname);
			if (!tipo.startsWith("BasicType") && !tipo.startsWith("EnumerationType")){
				String var = $b.valor;
				$seqIgual::valor.setValor(getCte(var,tipo));
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
