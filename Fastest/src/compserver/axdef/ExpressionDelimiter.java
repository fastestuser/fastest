package compserver.axdef;

public class ExpressionDelimiter {


	private static boolean finDeArg( int cantP, String pred, int i){
		char c1 = pred.charAt(i); 
		char c2 = i+1>=pred.length()?' ':pred.charAt(i+1);
		return ( cantP == 0 && c1 != '~' && c1 != ' '  && (c2 == ' ' || c2 =='~') );
	}
	
	private static boolean prinDeArg(int cantP, String pred, int i){
		char c1 = pred.charAt(i); 
		char c2 = i+1>=pred.length()?' ':pred.charAt(i+1);
		
		return ( cantP == 0 && (c1 == '~' || c1 == ' ') && c2 != ' ' && c2 !='~' );
	}
	
	private static class SPrima{
		public int i;
		public String salida;
	}
	
	
	private static SPrima marcarPredPrima(String pred, String nomvar, int argc){
		int argcint = argc; 
		int length = pred.length();
		int cantP = 0;
		pred = pred.substring(nomvar.length());
		String salida = "",prima = "";
		int i,prinArg=0,iprimaf = 0;
		SPrima sp = new SPrima();
		char c ; 
		for ( i=0; i<length && argcint>0 ; i++){
			c = pred.charAt(i);
			if ( pred.substring(i).startsWith(nomvar) && prima.isEmpty() ){
				sp = marcarPredPrima(pred.substring(i),nomvar,argc);
				prima =  pred.substring(prinArg,i) +  sp.salida ;
				iprimaf = i + sp.i + nomvar.length()-1;
			}
			
			if (c == '(' )
				cantP++;
			if (c == ')' )
				cantP--;

			if (cantP < 0){
				salida += pred.substring(prinArg,i) + "¬" ;
				argcint--;
			}
			
			if (prinDeArg(cantP,pred,i)){
				salida += "¬"; 
				prinArg = i+1;
			}
			
			if (finDeArg(cantP,pred,i) ){
				if (!prima.isEmpty()){
					salida +=  prima + pred.substring(iprimaf,i+1) + "¬" ;
					prima = "";
				}
				else
					salida += pred.substring(prinArg,i+1) + "¬" ;
				argcint--;
			}
		}
		SPrima sps = new SPrima();
		sps.i = i; sps.salida = "°" + nomvar + salida + "°";
		return sps;
	}
	
//	private static String marcarUnPred(String pred, String nomvar, int argc){
//		int argcint = argc; 
//		int length = pred.length();
//		int cantP = 0;
//		pred = pred.substring(nomvar.length());
//		String salida = "", prima = "";
//		int i,prinArg=0,iprimaf = 0;
//		SPrima sp = new SPrima();
//		char c ; 
//		for ( i=0; i<length && argcint>0 ; i++){
//			c = pred.charAt(i);
//			
//			if ( pred.substring(i).startsWith(nomvar) && prima.isEmpty() ){
//				sp = marcarPredPrima(pred.substring(i),nomvar,argc);
//				prima =  pred.substring(prinArg,i) +  sp.salida ;
//				iprimaf = i + sp.i + nomvar.length()-1;
//			}
//			
//			if (c == '(' )
//				cantP++;
//			if (c == ')' )
//				cantP--;
//
//			if (cantP < 0){
//				salida += pred.substring(prinArg,i) + "¬" ;
//				argcint--;
//			}
//			
//			if (prinDeArg(cantP,pred,i)){
//				salida += "¬"; 
//				prinArg = i+1;
//			}
//			
//			if (finDeArg(cantP,pred,i) ){
//				if (!prima.isEmpty()){
//					salida +=  prima + pred.substring(iprimaf,i+1) + "¬" ;
//					prima = "";
//				}
//				else
//					salida += pred.substring(prinArg,i+1) + "¬" ;
//				argcint--;
//			}
//		}
//		
//		return "°" + nomvar + salida + "°" + pred.substring(i,pred.length());
//	}
	
	public static String marcarPred(String pred, String nomvar, int argc){
		int length = pred.length(),iprimaf=0;
		SPrima sp = new SPrima();
		sp.salida = "";
		String salida = "",pedazo="";
		int c=0,f=0;
		int i;
		for (i = 0;i<length;i++){
		
			if(pred.substring(i).startsWith(nomvar)){
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
		String s = marcarPred("f~x~(f g h) d f a b","f",2);
		System.out.println(s);
	}

}
