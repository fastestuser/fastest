grammar SLog2Z;

@header {
package compserver.tcasegen.strategies.setlog.setlogtoz;
	import java.util.HashMap;
	import java.util.ArrayList;
	import java.util.regex.Matcher;
	import java.util.regex.Pattern;
	import java.util.Iterator;
	import javax.swing.tree.DefaultMutableTreeNode;
	import javax.swing.tree.DefaultTreeModel;
	import javax.swing.tree.TreeNode;
	import compserver.tcasegen.strategies.setlog.ztosetlog.ExprParser;
	import compserver.tcasegen.strategies.setlog.TypeManagerLexer;
	import compserver.tcasegen.strategies.setlog.TypeManagerParser;
	import compserver.tcasegen.strategies.setlog.SetLogUtils;
}

@members {
	HashMap<String,StringPointer> slvars = new HashMap();	
	HashMap<String,String> zNames = new HashMap();
	HashMap<String,String> tipos = new HashMap();
	HashMap<String,String> zVars = new HashMap();
	HashMap<String,String> valoresProhibidos = new HashMap();
	ConstantCreator cc;
	public HashMap<String,String> getZVars(){
		return zVars;
	}
	
	public ConstantCreator getCC(){
		return cc;
	}

    
	public void loadTablas(HashMap<String,String> zVars, HashMap<String,String> tipos, HashMap<String,String> zNames){
		this.zNames = zNames;
		this.tipos = tipos;
		this.zVars = zVars;
		
		
		System.out.println("\n");
		System.out.println("zNames: "); 
		printHashMap(zNames);
		System.out.println("\n tipos: "); 
		printHashMap(tipos);
		System.out.println("\n");
		System.out.println("\n");
		cc = new ConstantCreator(tipos,slvars,valoresProhibidos,this.zNames);
		
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
	
	private void printHashMap2(HashMap<String,String[]> map){
		Iterator<String> iterator = map.keySet().iterator();  
		String key;	String[] value;
		while (iterator.hasNext()) {  
		   key = iterator.next().toString();
		   if (map.get(key) == null){
			   System.out.println(key + " = " + "nullc");
			   continue;
		   }
		   else{ 
			   
			   value = map.get(key);
			   System.out.print(key + " = "); 
			   for (int i = 0; i<value.length;i++) 
				   System.out.print(value[i] + ",");
			   System.out.println(); 
		   }
		} 
	}
	
	public void llenarZVars(){
		Iterator iterator = slvars.keySet().iterator();  
		String slname,zname,valor;
		while (iterator.hasNext()) {  
			slname = iterator.next().toString();
			if (slvars.get(slname)!=null){	
				valor = slvars.get(slname).toString();
				
				
				zname = zNames.get(slname);
				if (zVars.containsKey(zname)){
					zVars.put(zname,valor);
				} 	
			}  
		} 
	}
	
}

lineas
	:	constr NL {
			System.out.println("\n valoresProhibidos desigualdades: ");
			printHashMap(valoresProhibidos);
			System.out.println("asaaaaaaa" + "\n");
		}
		(seqIgual NL?)+ 
		{
			System.out.println("\n**salida SLog2Z**: \n");
			System.out.println("constraint: " + $constr.text );
			System.out.println("\nslvars:");
			printHashMap( slvars );
			llenarZVars();
			System.out.println("\nzVars vacias +++++++++:");
			printHashMap(zVars);
			System.out.println("\n**fin SLog2Z**");
			
		}
	;

constr
	:	'_CONSTR' {System.out.println("CONTATNANTOANTs");} '=' '[' (restr(','restr)*)? ']' ','
	;
	
restr
locals [StringPointer valor;]
@init{$restr::valor = new StringPointer();}
	: 'set(' expr ')' {$restr::valor.setString("{}"); slvars.put($expr.text,$restr::valor);}
	| 'list(' expr ')' {$restr::valor.setString("[]"); slvars.put($expr.text,$restr::valor);}
	| 'integer(' expr ')' {$restr::valor.setString(cc.getNumber()); slvars.put($expr.text,$restr::valor);}
	| (NAME 'neq' expr | expr 'neq' NAME) 
		{
			String var = $NAME.text;
			String cte = $expr.text;
			String s = valoresProhibidos.get(var);
			 
			if (s!=null && !s.contains(cte)) 
				valoresProhibidos.put(var,s.concat("," + cte));
			else{
				s = new String(cte);
				valoresProhibidos.put(var, s);
				}
				
			s = valoresProhibidos.get(cte);
			if (SetLogUtils.esSLVariableSimple(cte)) {
				
				if (s!=null && !s.contains(var)) 
					valoresProhibidos.put(cte,s.concat("," + var));
				else{
					s = new String(var);
					valoresProhibidos.put(cte, s);
				}
			}
			
		}
		
	
	;

seqIgual
locals [StringPointer valor;]
@init{$seqIgual::valor = new StringPointer();}
	:	NAME '=' 'int(-10000000000, 10000000000),'  	 
	|	NAME '=' 'int(0, 10000000000),'
	|	(v1=NAME {slvars.put($v1.text,$seqIgual::valor);} '=' v2=expr {slvars.put($v2.text,$seqIgual::valor);} ',')+
		{
			String zname = zNames.get($v1.text);
			String tipo = tipos.get(zname);
			if (!tipo.startsWith("BasicType") && !tipo.startsWith("EnumerationType") && !tipo.startsWith("SchemaType") )
			{
				String var = $v2.valor;
				$seqIgual::valor.setString(cc.getCte(var,SetLogUtils.toTreeNorm(tipo)));
			}
			 	
		 }
	;
	
expr
returns [String valor]
	:	CTE {$valor = $CTE.text;}
	|   NAME {$valor = $NAME.text;} 
	|	'{' {$valor = "{";}
	    ( (','{$valor = $valor + ",";})?  e=expr {$valor = $valor + $e.valor;})*
	    ('\\' expr)*
	    '}' {$valor = $valor + "}";}
	|   '[' {$valor = "[";}
	    ( (','{$valor = $valor + ",";})?  e=expr {$valor = $valor + $e.valor;})*
	    ('|' expr)*
	    ']' {$valor = $valor + "]";} 
	|	'-' expr {$valor = "-" + $valor ;}
	;
      
NAME:	('_'|'A'..'Z' ) ('a'..'z' | 'A'..'Z' |'0'..'9')*;
CTE:    ('-'|'a'..'z' |'0'..'9') ('a'..'z' | 'A'..'Z' |'0'..'9')*;
NUM:	'0'..'9'+ ;

NL:	'\n';
WS: 	(' '|'\t'|'\r')+ {skip();} ;
SKIP:	'\\' '\\' {skip();} ;
