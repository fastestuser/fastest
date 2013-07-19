package compserver.axdef;

public class ExpressionDelimiter {

	//dice si es el principio de un argumento
	private static boolean finDeArg( int cantP, String pred, int i){
		char c1 = pred.charAt(i); 
		char c2 = i+1>=pred.length()?' ':pred.charAt(i+1);
		return ( cantP == 0 && c1 != '~' && c1 != ' '  && (c2 == ' ' || c2 =='~') );
	}
	//dice si es el final de un argumento
	private static boolean prinDeArg(int cantP, String pred, int i){
		char c1 = pred.charAt(i); 
		char c2 = i+1>=pred.length()?' ':pred.charAt(i+1);
		
		return ( cantP == 0 && (c1 == '~' || c1 == ' ') && c2 != ' ' && c2 !='~' );
	}
	
	private static class SPrima{
		public int i;
		public String salida;
	}
	
	/*
	* dada un string que comienza con nomvar, ej "fun sss (fun aa bb) dddd"
	* devuelve "°fun ¬sss¬¬(°fun ¬aa¬¬bb¬°)¬° dddd"
	*/
	private static SPrima marcarPredPrima(String pred, String nomvar, int argc){
		int argcint = argc; 
		int length = pred.length();
		int cantP = 0;
		pred = pred.substring(nomvar.length());
		String salida = "",prima = "";
		int i,prinArg=0,iprimaf = 0;
		SPrima sp = new SPrima();
		char c ;
		//boolean entrearg = true;
		for ( i=0; i<length && argcint>0 ; i++){
			c = pred.charAt(i);
			if ( prinFun(pred,nomvar,i) && prima.isEmpty() ){
				sp = marcarPredPrima(pred.substring(i),nomvar,argc);
				prima =  pred.substring(prinArg,i) +  sp.salida ;
				iprimaf = i + sp.i + nomvar.length()-1;
			}
			
			if (c == '(' )
				cantP++;
			if (c == ')' )
				cantP--;

			if (cantP < 0 ){ //agregado prima.isEmpty()
				salida += pred.substring(prinArg,i) + "¬"  ; // ")" agregado
				argcint--;
			}
			
			if (prinDeArg(cantP,pred,i)){
				salida += "¬"; 
				prinArg = i+1;
				//entrearg = false;
			}
			
			if (finDeArg(cantP,pred,i) ){
				if (!prima.isEmpty()){
					salida +=  prima + pred.substring(iprimaf,i+1) + "¬" ;
					prima = "";
				}
				else
					salida += pred.substring(prinArg,i+1) + "¬" ;
				argcint--;
				//entrearg = true;
			}
		}
		SPrima sps = new SPrima();
		sps.i = i; sps.salida = "°" + nomvar + salida + "°";
		return sps;
	}
	private static boolean prinFun(String pred, String nomvar, int i){
		char csig = i+nomvar.length()<pred.length()?pred.charAt(i+nomvar.length()):' ';
		return pred.substring(i).startsWith(nomvar) && (csig == ' ' || csig == '~');
	}
	public static String marcarPred(String pred, String nomvar, int argc){
		int length = pred.length();
		SPrima sp = new SPrima();
		sp.salida = "";
		String salida = "",pedazo="";
		int c=0,f=0;
		int i; 
		// "sssssss f x (f x y) ddd f x y hhh"
		// pedazo son los substring de pred que no son fun ej: sssssss,ddd,hhh
		// c y f marcan el comienzo i final de cada pedazo.
		for (i = 0;i<length;i++){
			
			if(prinFun(pred,nomvar,i)){
				f = i;
				pedazo = pred.substring(c, f);
				sp = marcarPredPrima(pred.substring(i),nomvar,argc);
				c = i + sp.i + nomvar.length();
				i = c;
				salida += pedazo + sp.salida ;
			}
			
		}
		return salida + pred.substring(c,pred.length());
	} 
	
	public static void main(String[] args) {
		//no anda "(f aa (f aa bb))" si anda "f aa (f aa bb) si anda "(f aa bb)""
		String s = marcarPred(" g~(g~1~2)~3","g",2);
		System.out.println(s);
		s = marcarPred("g x (g a b)","g",2);
		System.out.println(s);
		s = marcarPred("(g x ((g a (b))))","g",2);
		System.out.println(s);
		s = marcarPred("(g x (g a b)) pppp (g a b) ppp (g a (g a b))","g",2);
		System.out.println(s);
		s = marcarPred("ssss (g x (g a b)) ccccccc","g",2);
		System.out.println(s);
	}

}
