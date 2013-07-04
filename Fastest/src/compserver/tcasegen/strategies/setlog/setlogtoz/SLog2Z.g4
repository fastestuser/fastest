grammar SLog2Z;

@header {
package compserver.tcasegen.strategies.setlog.setlogtoz;
	import java.util.LinkedList;
	import java.util.List;
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
	List<String> varNoGenerar = new LinkedList<String>();
	ConstantCreator cc;
	
	public HashMap<String,StringPointer> getSlvars(){
		return slvars;
	}
	
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
		
		
		//System.out.println("\n");
		//System.out.println("zNames: "); 
		//printHashMap(zNames);
		//System.out.println("\n tipos: "); 
		//printHashMap(tipos);
		//System.out.println("\n");
		//System.out.println("\n");
		cc = new ConstantCreator(tipos,slvars,valoresProhibidos);
		
	}
	
	
	private void printHashMap(HashMap map){
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
	
	private void preprocesarConstraint(){
	// por que pueden venir variables Z, que solo aparezcan en constraint, no hay que llenarlas en ZVarFiller
		// por que ahi ya pueden tener valor erroneor ej constraint [V neq [], list(V)], con list V se le da valors
			if(valoresProhibidos != null){
			Iterator<String> it = valoresProhibidos.keySet().iterator();
			String var,tipo;
			StringPointer valor;
			while (it.hasNext()) { 
				var = it.next().toString();
				if (zNames != null && zNames.get(var)!=null){
					tipo = tipos.get(zNames.get(var));
					DefaultMutableTreeNode nodo = SetLogUtils.toTreeNorm(tipo);
					valor = new StringPointer(cc.getCte(var,nodo));
					if(slvars != null)
						slvars.put(var, valor);
					}
				}
			}
	}
	
	private void llenarZVars(){
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
			//System.out.println("\n valoresProhibidos desigualdades: \n");
			//printHashMap(valoresProhibidos);
			//System.out.println("asaaaaaaa" + "\n");
			preprocesarConstraint();
		}
		(seqIgual NL?)+ 
		{
			//System.out.println("\n**salida SLog2Z**: \n");
			//System.out.println("constraint: " + $constr.text );
			//System.out.println("\nslvars:");
			//printHashMap( slvars );
			llenarZVars();
			//System.out.println("\nzVars vacias +++++++++:");
			//printHashMap(zVars);
			//System.out.println("\n**fin SLog2Z**");
			
		}
	;

constr
	:	'_CONSTR' {
	              	//System.out.println("CONTATNANTOANTs");
	              } 
		'=' '[' (restr(','restr)*)? ']' ','
	;
	
restr
locals [StringPointer valor;]
@init{$restr::valor = new StringPointer();}
	: 'set(' expr ')' {$restr::valor.setString("{}"); slvars.put($expr.text,$restr::valor);}
	| 'list(' expr ')' {$restr::valor.setString("[]"); slvars.put($expr.text,$restr::valor);}
	| 'integer(' expr ')' {$restr::valor.setString(cc.getNumber()); slvars.put($expr.text,$restr::valor);}
	| (a = NAME 'neq' b = NAME)
		{
			String var1 = $a.text;
			String var2 = $b.text;
			String s = valoresProhibidos.get(var1);
			 
			if (s!=null && !s.contains(var2)) 
				valoresProhibidos.put(var1,s.concat("," + var2));
			else{
				s = new String(var2);
				valoresProhibidos.put(var1, s);
				}
				
			s = valoresProhibidos.get(var2);
			if (s!=null && !s.contains(var1)) 
				valoresProhibidos.put(var2,s.concat("," + var1));
			else{
				s = new String(var1);
				valoresProhibidos.put(var2, s);
				}
		}
	| (NAME 'neq' exprCte | exprCte 'neq' NAME) 
		{
			String var = $NAME.text;
			String cte = $exprCte.text;
			String s = valoresProhibidos.get(var);
			if (s!=null && !s.contains(cte)) 
				valoresProhibidos.put(var,s.concat("," + cte));
			else{
				s = new String(cte);
				valoresProhibidos.put(var, s);
				}
		}
	| (NAME 'neq' expr | expr 'neq' NAME)
		{
			varNoGenerar.add($NAME.text);	
			slvars.put($NAME.text,new StringPointer("ValueNotAssigned"));
		}	
	
	;

seqIgual
locals [StringPointer valor;]
@init{$seqIgual::valor = new StringPointer();}
	:	(v1=NAME {slvars.put($v1.text,$seqIgual::valor);} '=' v2=expr {slvars.put($v2.text,$seqIgual::valor);} ',')+
		{
			String zname = zNames.get($v1.text);
			String tipo = tipos.get(zname);
			String var = $v2.valor;
			if (varNoGenerar.contains(var) || varNoGenerar.contains($v1.text)){
				$seqIgual::valor.setString("ValueNotAssigned");
				}			
			else if ( !$seqIgual::valor.contains("ValueNotAssigned") && !varNoGenerar.contains(var) && !zname.startsWith("\\n") && !tipo.startsWith("BasicType") && !tipo.startsWith("EnumerationType") && !tipo.startsWith("SchemaType") )
				$seqIgual::valor.setString(cc.getCte(var,SetLogUtils.toTreeNorm(tipo)));
			 	
		 }
	;
	
expr
returns [String valor]
	:	CTE {$valor = $CTE.text;}
	|   NAME {$valor = $NAME.text;}
	|   'int' '(' a=(NAME|CTE) ',' b=(NAME|CTE) ')' {$valor = "int(" + $a.text + "," + $b.text + ")";} 
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

exprCte
returns [String valor]
	:	CTE {$valor = $CTE.text;}
	|   'int' '(' a=(NAME|CTE) ',' b=(NAME|CTE) ')' {$valor = "int(" + $a.text + "," + $b.text + ")";} 
	|	'{' {$valor = "{";}
	    ( (','{$valor = $valor + ",";})?  e=exprCte {$valor = $valor + $e.valor;})*
	    ('\\' exprCte)*
	    '}' {$valor = $valor + "}";}
	|   '[' {$valor = "[";}
	    ( (','{$valor = $valor + ",";})?  e=exprCte {$valor = $valor + $e.valor;})*
	    ('|' exprCte)*
	    ']' {$valor = $valor + "]";} 
	|	'-' exprCte {$valor = "-" + $valor ;}
	;
		
      
NAME:	('_'|'A'..'Z' ) ('a'..'z' | 'A'..'Z' |'0'..'9')*;
CTE:    ('-'|'a'..'z' |'0'..'9') ('a'..'z' | 'A'..'Z' |'0'..'9')*;
NUM:	'0'..'9'+ ;

NL:	'\n';
WS: 	(' '|'\t'|'\r')+ {skip();} ;
SKIP:	'\\' '\\' {skip();} ;
