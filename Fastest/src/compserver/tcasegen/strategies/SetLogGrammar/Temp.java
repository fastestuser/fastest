package compserver.tcasegen.strategies.SetLogGrammar;

import java.util.HashMap;

import javax.swing.tree.TreeNode;

public class Temp {
	static private int[] palabra = new int[100];
	
	private static String elemFromFreeType(String tipo, int i){
		String s;
		String aux[] = tipo.split(":");
		s = aux[2].substring(1, aux[2].length()-1);
		aux = s.split(",");
		return aux[i-1];
	}
	//devuelve la posicion de los bits encendidos de la representacion binaria del entero,
	private static int[] posEncendidas(int n){
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
	
	public  static String f(TreeNode nodo, int num,HashMap<String,String> tipos){
		String s = null;
		String ct = nodo.toString();
		if (ct.equals("\\power")){
			int n[]=posEncendidas(num);
			int numi,i;
			i=0;
			numi= n[i];
			s = "{";
			while(numi!=0){
				//numi - 1 es el numero decimal que representa la constante
				//el cual es la posicion del bit encendido - 1
				s = s + f(nodo.getChildAt(0),numi-1,tipos) + ",";
				i++;
				numi = n[i];
			}
			s = s.substring(0, s.length()-1) + "}";
		}
		else if(ct.equals("()")){
			s = f(nodo.getChildAt(0),num,tipos);
		}
		else {
			s = elemFromFreeType(tipos.get(nodo.toString()),num);	
		}
		
		return s;
	}
}
