package compserver.tcasegen.strategies.setlog.setlogtoz;

import java.util.HashMap;
import java.util.Iterator;
import javax.swing.tree.DefaultMutableTreeNode;

import compserver.tcasegen.strategies.setlog.SetLogUtils;




public final class ConstantGenIterator implements Iterator {
	
	private HashMap<String,StringPointer> slVars;
	private HashMap<String, String> tipos;
	private HashMap<String, String> znames;
	
	public ConstantGenIterator(ExprIterator expr) {
		
		HashMap<String,String> vp = llenarValoresProhibidos(expr); 
		SetLogUtils.printHashMap(vp);
	}

	
	public boolean hasNext() {
		return false;
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
	
	private String getCteDesigual(DefaultMutableTreeNode nodo,String var,HashMap<String,String> vp, int varNat){
		String salida = null;
		ExprIterator exprs = new ExprIterator("{"+vp.get(var)+"}");
		int nats[] = new int[exprs.cardinalidad()];
		int i = 0;
		String expresion = null;
		IntExprMap varMap = new IntExprMap(tipos);
		while(exprs.hasNext()){
			expresion = exprs.next();
			//si no es varaible convierto la expresion a nat
			if (!CCUtils.esVariable(expresion)){
				nats[i] = varMap.toNum(nodo,expresion);
				i++;
			}
		}
		String tipo = SetLogUtils.tipoNoParentesis(nodo);
		
		//el 0 de tipo power y seq es {},el resto de los tipos empieza en 1
		if (!tipo.equals("\\power") && !tipo.equals("\\seq")){
			varNat = 1;
		}
		
		//m es la cantidad de constantes que fueron mapeadas a nat, y  a las cuales var debe ser distinta.
		int m = i;
		i = 0;
		while (i<m){
			if(varNat==nats[i]){
				next(nodo,varNat);
				i = 0;
			}
			else
				i++;
		}
		salida = varMap.toExpr(nodo, varNat);
		CCUtils.refrescarValoresProhibidos(var,salida,vp);
		
		return salida;
	}
	
	private String powerNext(DefaultMutableTreeNode nodo, String exprS, int valorActual){
		
		if (CCUtils.esVariable(exprS))
			return null;
		
		ExprIterator expr = new ExprIterator(exprS);
		HashMap<String,String> vp =  llenarValoresProhibidos(expr);
		
		Iterator<String> it = vp.keySet().iterator();
		String var,cte;
		while(it.hasNext()){
			var = it.next().toString();
			cte = CCUtils.getCteDesigual((DefaultMutableTreeNode) nodo.getChildAt(0), var, vp);
			
		}
		
		return null;
	}
	private ExprIterator powerNext(DefaultMutableTreeNode nodo, String exprS){
		
		if()
		
		
		return powerNext(nodo,exprS,0);
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
