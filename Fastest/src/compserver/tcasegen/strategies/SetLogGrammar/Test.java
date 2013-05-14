package compserver.tcasegen.strategies.SetLogGrammar;



import java.math.BigInteger;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import compserver.tcasegen.strategies.SetLogGrammar.ConstantGeneration.ConstantGenIterator;
import compserver.tcasegen.strategies.SetLogGrammar.ConstantGeneration.ExprIterator;
import compserver.tcasegen.strategies.SetLogGrammar.ConstantGeneration.IntExprMap;



public class Test {
	
	private class Tipo{
		int cardinalidad;
		String nombre;
		public String toString(){
			return nombre;
		}
	}
	private  static class Par{
		Par x,y;
		int valor;
		Tipo tipo;
		public String toString(){
			return "(" + x.toString2() + " \\mapsto " + y.toString2() + ")";
		}
		private String toString2(){
			if (esHoja())
				return String.valueOf(valor);
			return this.toString(); 
		}
		Par(Par p1,Par p2,Tipo t){
			x = p1; y = p2;valor = 0;tipo = t;
		}
		Par(int n,Tipo t){
			valor = n;x=y=null;tipo = t;
		}
		boolean esHoja(){
			return (x==null);
		}
	}	
	//devuelve el bit que corresponde a la posicion, ej bitFromFreeType(FT::=a|b|c , a)
	// = 100 en binario = 4 en decimal
	private static int numFromFreeType(String tipo,String elem){
		String s;
		String aux[] = tipo.split(":");
		s = aux[2].substring(1, aux[2].length()-1);
		aux = s.split(",");
		for(int i=0;i<aux.length;i++){
			if (aux[i].equals(elem))
				return i+1;
		}
		return 0;
	}
	private static String[] elemsFromExpr(String tipo, String expr){
		String[] elems = new String[10];
		char c;
		char exprC[] = expr.toCharArray();
		int s,f,ind,abierto,length; //abierto cantidad de parentesis o corchetes abierros
		ind = abierto = f = 0; 
		length = expr.length();
		s = 1;
		if (tipo.equals("\\power")){
			for(int i=1;i<length-1;++i){
				c = exprC[i];
				if ( c==',' && abierto ==0){
					elems[ind] = expr.substring(s, i-1);
					s = i+1;
					ind++;
				}
			}
		}
		return elems;
	}
	
	
	public static void main(String[] args) {
		
//		String tipo = "\\power (\\power FT)";
//		
//		ANTLRInputStream input = new ANTLRInputStream(tipo);
//		//ANTLRInputStream input = new ANTLRInputStream(" \\power ((\\power FT) \\cross FT)");
//        TypeManagerLexer lexer = new TypeManagerLexer(input);
//        CommonTokenStream tokens = new CommonTokenStream(lexer);
//        TypeManagerParser parser = new TypeManagerParser(tokens);
//        parser.typeManage();
//        DefaultMutableTreeNode root =  parser.getRoot();
//        
//        input = new ANTLRInputStream(tipo);
//		//ANTLRInputStream input = new ANTLRInputStream(" \\power ((\\power FT) \\cross FT)");
//        lexer = new TypeManagerLexer(input);
//        tokens = new CommonTokenStream(lexer);
//        parser = new TypeManagerParser(tokens);
//        parser.typeManage();
//        DefaultMutableTreeNode root2 =  parser.getRoot();
      
        
//        HashMap<String,String> tipos = new HashMap<String, String>();
//		tipos.put("FT", "EnumerationType:FT:{a,b,c}");
//		String s = "{[1,{a,X}]}";
//		
//       ConstantCreator cc = new ConstantCreator(tipos, null, null, null);
//		 String salida = cc.getCte(s,root);
//		
//		 System.out.println("ENTRADA\n" + s);
//		 System.out.println("SALIDA\n" + salida);
//        
        
        
        
        
        
//		HashMap<String,String> tipos = new HashMap<String, String>();
//		tipos.put("FT", "EnumerationType:FT:{a,b,c}");
//		IntExprMap tmp = new IntExprMap(tipos);
//		int num = 11;
//		String expr = tmp.toExpr(root,num);
//		
//		
//		System.out.println( num + " to expr = " + expr);
//		int num2 = tmp.toNum(root2,"{{a},{a,c},{a,b,c}}");
//		System.out.println( expr + " to num = " + num2);
//		
//		System.out.println("tamaño integer  " + Integer.SIZE);
		/*String tipo =  "EnumerationType:FT:{a,b,c,d}";
		System.out.println("posicion: " + numFromFreeType(tipo,""));
		*/
		/*Expr e = new Expr("","[a,a]");
		Iterator<String> it = e.iterator();
		while (it.hasNext())
			System.out.println(it.next());
		String s = "aaa}";
		System.out.println(s.charAt(s.length()-1));*/
		ExprIterator e = new ExprIterator("{aaa}");
		//e.remove();
		//System.out.println(e);
		ConstantGenIterator c = new ConstantGenIterator(e); 
		
	}

}
