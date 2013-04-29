package compserver.tcasegen.strategies.SetLogGrammar;


import java.math.BigInteger;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.tree.DefaultMutableTreeNode;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import compserver.tcasegen.strategies.SetLogGrammar.IntExprMap;



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
	private static int bitFromFreeType(String tipo,String elem){
		String s;
		String aux[] = tipo.split(":");
		s = aux[2].substring(1, aux[2].length()-1);
		aux = s.split(",");
		int bit = 1;
		for(int i=0;i<aux.length;i++){
			if (aux[i].equals(elem))
				return bit;
			bit = bit<<1;
		}
		return bit;
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
		
		ANTLRInputStream input = new ANTLRInputStream("\\power FT");
        TypeManagerLexer lexer = new TypeManagerLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        TypeManagerParser parser = new TypeManagerParser(tokens);
        parser.typeManage();
        DefaultMutableTreeNode root =  parser.getRoot();
//        
//        
//		String s = "[{X}]";
//		
//       ConstantCreator cc = new ConstantCreator(null, null, null, null);
//		 String salida = cc.getCte(s,root);
//		
//		 System.out.println("ENTRADA\n" + s);
//		 System.out.println("SALIDA\n" + salida);
        
//        Par p;Par p1; Par p2;Par p11;Par p12; Par p21;Par p22;
//        p11 = new Par(1);
//        p12 = new Par(2);
//        p21 = new Par(3);
//        p22 = new Par(4);
//        p1 = new Par(p11,p12);
//        p2 = new Par(p21,p22);
//        p = new Par(p1,p2);
//        
        
        
        
		HashMap<String,String> tipos = new HashMap<String, String>();
		tipos.put("FT", "EnumerationType:FT:{a,b,c}");
		IntExprMap tmp = new IntExprMap(root,7,tipos);
		System.out.println("\naaaaaaaaaa " + tmp.toExpr() + " " + tmp.cardinalidad());
	
		String tipo =  "EnumerationType:FT:{a,b,c}";
		System.out.println("posicion: " + bitFromFreeType(tipo,"c"));
		
		Expr e = new Expr("","{{aaa},(bbb),{(ccwde)}}");
		Iterator<String> it = e.iterator();
		while (it.hasNext())
			System.out.println(it.next());
		
	}

}
