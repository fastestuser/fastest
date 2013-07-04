package compserver.tcasegen.strategies.setlog.setlogtoz;

import java.util.Iterator;

/* Dada una expresion permite iterar sobre sus elementos
 * ej: expr = {ccc,[XXX],dsad3,{{}{}},dsda} entonces cada elemento es ccc, [XXX], etc....*/
public final class ExprIterator implements Iterator<String>{
	private int posActual,posPrev;
	private String expr;
	private char cierre,open;

	public ExprIterator(String expr){
		this.expr = expr;
		this.posActual = this.posPrev = 0;
		// va a ser igual a '}' ó ']' ó ')'
		this.open = expr.charAt(0);
		this.cierre = expr.charAt(expr.length()-1);
	}

	public void reiniciar(){
		posActual = 0;
	}

	public int cardinalidad(){
		int backup = posActual;
		posActual = 0;
		int ac = 0;
		while (hasNext()){
			next();
			ac++;
		}
		posActual = backup;
		return ac;
	}

	public boolean hasNext() {
		if ( expr.charAt(posActual)== cierre || expr.charAt(posActual+1) == cierre)
			return false;
		return true;
	}

	public boolean hasElement(){
		return expr.length() != 2;
	}

	public String next() {
		posPrev = posActual;
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

	//borra el elemento actual y reinicia el iterador
	public void remove() {
		int a,b;
		a  = b = posActual;
		if(this.hasNext()){
			this.next();
			b = posActual;
		}
		String f = expr.substring(0,a);
		String l = expr.substring(b,expr.length());
		expr = f + l ;
		if (expr.length()>1)
			expr = String.valueOf(open) + expr.substring(1,expr.length()-1) + String.valueOf(cierre);
		else 
			expr = String.valueOf(open) + String.valueOf(cierre);
		posActual = 0;
	}
	//remueve el elemento
	public void remove(String elem){
		int backup = posActual;

		while (!elem.equals(next()));
		posActual = posPrev;
		remove();

		posActual = backup;

	}

	public String toString(){
		return expr;
	}

}




