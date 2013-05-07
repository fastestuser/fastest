package compserver.tcasegen.strategies.SetLogGrammar;

import java.util.Iterator;

public class ExprIterator implements Iterator<String>{
	private int posActual;
	private String expr;
	private char cierre;

	public ExprIterator(String expr){
		this.expr = expr;
		this.posActual = 0;
		// va a ser igual a '}' ó ']' ó ')'
		this.cierre = expr.charAt(expr.length()-1);
	}


	public boolean hasNext() {
		if ( expr.charAt(posActual)== cierre || expr.charAt(posActual+1) == cierre)
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
			if(( c == ',' && abiertos == 0 ) ||(c == cierre && abiertos == -1)){
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




