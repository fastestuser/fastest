package compserver.tcasegen.strategies.SetLogGrammar;

import java.util.HashMap;
import javax.swing.tree.DefaultMutableTreeNode;


public class IntExprMap {
	private int[] palabra = new int[100];
	private DefaultMutableTreeNode arbolTipo;
	private int num;
	private HashMap<String, String> tipos;
	
	private  class Par{
		int x,y;
		public String toString(){
			return "(" + x + "," + y + ")";
		}
	}	
	
	private  Par parFromInt(int card2, int num){
		Par p = new Par();
		if(card2>0){
			p.y = num % card2;
			p.x = num / card2 + ((p.y >0)?1:0);
			p.y = ((p.y ==0)?card2:p.y);
			return p;
		}
		p.x = 1; 
		p.y = num;
		return p;
	}
	
	/*private class Tipo{
		int cardinalidad;
		String nombre;
		public String toString(){
			return nombre;
		}
	}*/
	
	private  String elemFromFreeType(String tipo, int i){
		String s;
		String aux[] = tipo.split(":");
		s = aux[2].substring(1, aux[2].length()-1);
		aux = s.split(",");
		return aux[i-1];
	}
	
	//devuelve el bit que corresponde a la posicion, ej bitFromFreeType(FT::=a|b|c , a)
	// = 100 en binario = 4 en decimal
	private  int bitFromFreeType(String tipo,String elem){
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
	
	private  int cardFromFreeType(String tipo){
		String aux[] = tipo.split(":");
		aux = aux[2].split(",");
		return aux.length;
	}
	
	//devuelve la posicion de los bits encendidos de la representacion binaria del entero,
	private  int[] posEncendidas(int n){
		int[] palabra = new int[100];
		int res,resto,i,ni;
		res = n>>1;
		resto = n&1;
		i = 0;ni=1;
		while(res > 0 ){
			if(resto == 1){
				palabra[i] = ni;
				i++;
			}
			resto = res&1;
			res = res>>1;ni++;
		}
		
		palabra[i++] = ni*resto;
		return palabra;
	}

	private int cardinalidad(DefaultMutableTreeNode nodo){
		//Tipo t = new Tipo();
		String ct = nodo.toString();
		int c=0;
		
		if (ct.equals("\\power")){
			c = cardinalidad((DefaultMutableTreeNode) nodo.getChildAt(0));
			c = (2<<(c-1));
		}
		else if (ct.equals("()")){
			c = cardinalidad((DefaultMutableTreeNode) nodo.getChildAt(0));
		}
		else if(ct.equals("\\cross")){
			c = cardinalidad((DefaultMutableTreeNode) nodo.getChildAt(0));
			c = c * cardinalidad((DefaultMutableTreeNode) nodo.getChildAt(1));
		}
		else
			c = cardFromFreeType(tipos.get(ct));
			
		//t.cardinalidad = c;
		//t.nombre = ct;
		//nodo.setUserObject(t);
		
		return c;
	}
	
	private  String f(DefaultMutableTreeNode nodo, int num){
		String salida = null;
		String ctHijo;
		String ct = nodo.toString();
		
		if (ct.equals("\\power")){
			int n[]=posEncendidas(num);
			int card=0;
			int numi,i;
			i=0;
			numi= n[i];
			salida = "{";
			while(numi!=0){
				//numi - 1 es el numero decimal que representa la constante
				//el cual es la posicion del bit encendido - 1
				ctHijo = nodo.getChildAt(0).toString();
				if (ctHijo.equals("\\power") )
					salida = salida + f((DefaultMutableTreeNode) nodo.getChildAt(0),numi-1) + ",";
				
				else
					salida = salida + f((DefaultMutableTreeNode) nodo.getChildAt(0),numi) + ",";
				i++;
				numi = n[i];
			}
			if(salida.charAt(salida.length()-1)==',')
				salida = salida.substring(0, salida.length()-1) + "}";
			else
				salida = salida + "}";
		}else if(ct.equals("()")){
			salida = f((DefaultMutableTreeNode) nodo.getChildAt(0),num);
		}else if(ct.equals("\\cross")){
				//Tipo t2 = (Tipo) ((DefaultMutableTreeNode) nodo.getChildAt(1)).getUserObject();
				int c = cardinalidad(nodo);
				//int c2 =t2.cardinalidad;
				Par p = parFromInt(c,num);
				salida = "["+f((DefaultMutableTreeNode) nodo.getChildAt(0),p.x) + " , " + f((DefaultMutableTreeNode) nodo.getChildAt(1),p.y) +"]";
		}else {
			String tipo = tipos.get(nodo.toString());
			salida = elemFromFreeType(tipo,num);	
		}
		return salida;
	}
	
	
	
//	private  int f(DefaultMutableTreeNode nodo, String expr){
//		int salida = -1;
//		String ct = nodo.toString();
//		
//		if(ct.equals("\\power")){
//			//obtengo los elementos del conjunto
//			Expr expr
//			
//		}
//		return salida;
//	}
	
	public String toExpr(){
		//llenarCard(arbolTipo);
		return f(arbolTipo,num);
	}

	public int cardinalidad(){
		return cardinalidad(arbolTipo);
	}
	
	public IntExprMap(DefaultMutableTreeNode nodo,int num,HashMap<String,String> tipos){
		this.arbolTipo = nodo;
		this.num = num;
		this.tipos = tipos;
	}
}
