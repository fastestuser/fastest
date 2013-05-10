package compserver.tcasegen.strategies.SetLogGrammar;

import java.util.HashMap;
import java.util.Iterator;

import javax.swing.tree.DefaultMutableTreeNode;

public class PowerConstantGenIterator implements Iterator {
	
	private DefaultMutableTreeNode arbolTipo;
	private ExprIterator expr;
	private HashMap<String,StringPointer> slVars;
	private HashMap<String,String> valoresProhibidos;
	private HashMap<String, String> tipos;
	private HashMap<String, String> znames;
	
	public PowerConstantGenIterator(DefaultMutableTreeNode arbolTipo,ExprIterator expr, HashMap<String, String> tipos,HashMap<String, String> znames,HashMap<String,StringPointer> slvars,HashMap<String,String> valoresProhibidos) {
		this.arbolTipo = arbolTipo;
		this.expr = expr;
		this.tipos = tipos;
		this.slVars = slVars;
		this.valoresProhibidos = valoresProhibidos;
		this.znames = znames;
	}

	public boolean hasNext() {
		return false;
	}
	
	public ConstantGenIterator next() {
		
		if (exprActual.esVariable()){
			
			return 
		}
			
		
		Iterator<String> vp = valoresProhibidos.keySet().iterator();
		String expr,value;
		while (vp.hasNext()) {  
			expr = vp.next().toString();
			value = valoresProhibidos.get(key);
			value = value.replace(var, expr);
			valoresProhibidos.put(key, value);
		}
		
		return itTipado.next();
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}
	
}
