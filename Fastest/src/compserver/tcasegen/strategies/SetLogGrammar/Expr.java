package compserver.tcasegen.strategies.SetLogGrammar;

import java.util.Iterator;

public class Expr {
	private ItertortorExpr it;
	static int posActual;
	static String tipo;
	static String expr;

	public Expr(String tipo, String expr){
		this.tipo = tipo;
		this.expr = expr;
		this.posActual = 0;
		it = new ItertortorExpr();
	}
	public Iterator<String> iterator(){
		return this.it;
	}
	private static class ItertortorExpr implements Iterator<String>{
		
		public boolean hasNext() {
			char c = expr.charAt(posActual);
			if ( c == '}' || c ==']' || c == ')')
				return false;
			return true;
		}
			
		public String next() {
			int length = expr.length();
			int abiertos = 0;
			int i = posActual+1;
			char c;
			String elem = null;
			for(;i<length;i++){
				c = expr.charAt(i);
				if (c == '{' || c == '(' || c == '[')
					abiertos++;
				if (c == '}' || c == ')' || c == ']')
					abiertos--;
				if(( c == ',' && abiertos == 0 ) ||(c == '}' && abiertos == -1)){
					elem = expr.substring(posActual+1,i);
					break;
				}
			}
			posActual = i;
			return elem;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	
	
}
