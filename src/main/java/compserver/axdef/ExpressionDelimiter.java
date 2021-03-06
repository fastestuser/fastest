package compserver.axdef;

public final class ExpressionDelimiter {

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
		//int length = pred.length();
		int cantP = 0;
		pred = pred.substring(nomvar.length());
		int length = pred.length();
		StringBuilder salida = new StringBuilder();
		String prima = "";
		int i,prinArg=0,iprimaf = 0;
		SPrima sp = new SPrima();
		char c ;
		for ( i=0; i<length && argcint>0 ; i++){
			c = pred.charAt(i);
			//si es el principio de una funcion y chequea prima que es vacio si es la primera vez
			//que se entra,
			if ( prinFun(pred,nomvar,i) && prima.isEmpty() ){
				sp = marcarPredPrima(pred.substring(i),nomvar,argc);
				prima =  pred.substring(prinArg,i) +  sp.salida ;
				iprimaf = i + sp.i + nomvar.length();
				i = iprimaf -1 ;
			}
			
			if (c == '(' || c == '{' || c == '[')
				cantP++;
			if (c == ')' || c == '}' || c == ']')
				cantP--;
			
			if (cantP < 0 ){ 
				salida.append(pred.substring(prinArg,i) + "¬" );
				argcint--;
			}
			
			if (prinDeArg(cantP,pred,i)){
				salida.append("¬"); 
				prinArg = i+1;
			}
			
			if (finDeArg(cantP,pred,i) ){
				if (!prima.isEmpty()){
					salida.append(prima + pred.substring(iprimaf,i+1) + "¬" );
					prima = "";
				}
				else
					salida.append(pred.substring(prinArg,i+1) + "¬" );
				argcint--;
			}
		}
		SPrima sps = new SPrima();
		sps.i = i; sps.salida = /*"°" + */nomvar + salida /*+ "°"*/;
		return sps;
	}
	//dice si es el principio de funcion
	private static boolean prinFun(String pred, String nomvar, int i){
		char csig = i+nomvar.length()<pred.length()?pred.charAt(i+nomvar.length()):' ';
		return pred.substring(i).startsWith(nomvar) && (csig == ' ' || csig == '~');
	}
	
	/* 
	 * dado un string que tenga la funcion llamada nomvar varias veces, marca los argumentos.
	 * el string tiene que estar normalizado, es decir no haber dos espacios seguidos, los parentesis
	 * separados de los no parentesis por un espacio. 
	 */
	public static String marcarPred(String pred, String nomvar, int argc){
		
		pred = pred.replace("\\langle", "[");
		pred = pred.replace("\\rangle", "]");
		pred = pred.replace("\\{", "$");
		pred = pred.replace("$", "{");
		pred = pred.replace("\\}", "$");
		pred = pred.replace("$", "}");
		
		int length = pred.length();
		SPrima sp = new SPrima();
		sp.salida = "";
		StringBuilder salida = new StringBuilder();
		String pedazo="";
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
				salida.append(pedazo + sp.salida);
			}
		}
		
		salida.append(pred.substring(c,pred.length()));
		String s = salida.toString();
		s = s.replace("{", "$");
		s = s.replace("$", "\\{");
		s = s.replace("}", "$");
		s = s.replace("$", "\\}");
		s = s.replace("[", "\\langle");
		s = s.replace("]", "\\rangle");
		
		return s ;
	} 
	
	//For testing
	/*
	public static void main(String[] args) throws IOException, CommandException {
		//no anda "(f aa (f aa bb))" si anda "f aa (f aa bb) si anda "(f aa bb)""
		String predstr = "(5+6)+((1))";
		ZLive zLive = UniqueZLive.getInstance();
		ZLive zLive2 = UniqueZLive.getInstance();
		
		Pred pred = ParseUtils.parsePred(new StringSource(predstr),zLive.getCurrentSection(), zLive.getSectionManager());
		String predstr2 = SpecUtils.termToLatex(pred);
		String s = marcarPred(predstr2,"g",2);
		System.out.println(s);
		
	}*/
}
