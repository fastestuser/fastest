package compserver.tcasegen.strategies.setlog.setlogtoz;

import java.util.HashMap;
import java.util.Iterator;

import javax.swing.tree.DefaultMutableTreeNode;


public class ConstantGenIterator implements Iterator {
	
	private HashMap<String,StringPointer> slVars;
	private HashMap<String, String> tipos;
	private HashMap<String, String> znames;
	
	public ConstantGenIterator(ExprIterator expr) {
		
		HashMap<String,String> vp = llenarValoresProhibidos(expr); 
		printHashMap(vp);
	}

	
	public boolean hasNext() {
		return false;
	}
	
	private void printHashMap(HashMap<String, String> map){
		Iterator<String> iterator = map.keySet().iterator();  
		String key,value;
		while (iterator.hasNext()) {  
			key = iterator.next().toString();
			if (map.get(key) == null)
				value = "nullc";
			else 
				value = map.get(key).toString();
			System.out.println(key + " = " + value);  
		} 
	}
	
	private HashMap<String,String> llenarValoresProhibidos(ExprIterator expr){
		HashMap<String,String> vp = new HashMap<String,String>();
		ExprIterator aux;
		String s = expr.toString();
		String key;
		while (expr.hasNext()){
			aux = new ExprIterator(s);
			key = expr.next();
			aux.remove(key);
			if (aux.hasElement())
				vp.put(key,aux.toString());
		}
		return vp;
	}
	
	private ExprIterator powerNext(DefaultMutableTreeNode tipo, ExprIterator expr){
		if (expr.esVariable())
			return null;
		return expr;
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Object next() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
