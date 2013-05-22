package compserver.tcasegen.strategies.setlog.setlogtoz;

import java.util.HashMap;
import javax.swing.tree.DefaultMutableTreeNode;

public final class ConstantGenIterator  {
	
	private static HashMap<String,StringPointer> slVars;
	private static HashMap<String, String> tipos;
	private static HashMap<String, String> znames;
	private static Iterador it;
	private static DefaultMutableTreeNode nodo;
	
	public ConstantGenIterator(DefaultMutableTreeNode nodo,String exprS,HashMap<String, String> tipos){
		this.tipos = tipos;
		this.nodo = nodo;
		it = new Iterador(nodo,exprS);
	}
	
	public String generate(){
		int num = it.next();
		if (num != -1){
			IntExprMap map = new IntExprMap(tipos);
			return map.toExpr(nodo, num);
		}
		return "error";
	}
	
	private class Iterador {
		private int valorActual;
		private boolean esCte; 
		private Iterador[] hijos;
		private DefaultMutableTreeNode nodo;
		
		private Iterador(DefaultMutableTreeNode nodo,String exprS) {
			
			this.nodo = nodo;
			ExprIterator expr = new ExprIterator(exprS);
			String ct = nodo.toString();
			
			while(ct.equals("()")){
				nodo = (DefaultMutableTreeNode) nodo.getChildAt(0);
				ct = nodo.toString();
			}
			
			if(CCUtils.esVariable(exprS)){
				this.esCte = false;
				this.hijos = null;
				this.valorActual = (ct.equals("\\power") || ct.equals("\\seq"))?-1:0;
				return;
			}
			
			if(CCUtils.esCteSimple(exprS)){
				this.esCte = true;
				this.hijos = null;
				this.valorActual = CCUtils.numFromFreeType(tipos.get(ct), exprS);
				return;
			}
			
			//if (ct.equals("\\power")||ct.equals("\\seq")){
			//tiene al menos un elemento
			String elem;
			ExprIterator exprh;
			hijos = new Iterador[expr.cardinalidad()];
			int i = 0;
			while(expr.hasNext()){
				elem = expr.next();
				hijos[i++] = new Iterador((DefaultMutableTreeNode)nodo.getChildAt(0),elem);
			}
			esCte = true;
			i = 0 ;
			while (i<hijos.length){
				if (!hijos[i].esCte){
					esCte = false;
					this.valorActual = (ct.equals("\\power") || ct.equals("\\seq"))?-1:0;;
					break;
				}
				i++;
			}
			if (esCte){
				IntExprMap map = new IntExprMap(tipos);
				this.valorActual = map.toNum(nodo,exprS);
			}
			return;
			//}
			
		}
	
		private String getSExpr(){
			
			IntExprMap map = new IntExprMap(tipos);
			
			if (hijos == null){
				return map.toExpr(nodo, valorActual);
			}
			int i = 0;
			String ct = nodo.toString();
						
			String p1,p2;
			p1 = ct.charAt(1) == 'p'?"{":"[";
			p2 = ct.charAt(1) == 'p'?"}":"]";
			
			String salida = p1;
			while (i<hijos.length){
				salida = salida + hijos[i].getSExpr();
				if (i+1 < hijos.length)
					salida = salida + ",";
				i++;
			}
			salida = salida + p2;
			return salida;
		}
		
		private int next(){
			
			int n = CCUtils.cardinalidadTipoFinito(tipos, nodo);
			if (this.esCte) 
				return this.valorActual;
			if (this.hijos == null) {//es una variable sin estructura
				if(this.valorActual + 1 < CCUtils.cardinalidadTipoFinito(tipos, nodo))
					return ++this.valorActual;
				else
					return this.valorActual;
			}		
			
			String ct = this.nodo.toString();
			if (ct.equals("\\power")){
				
				int i,j,var;
				i = 0;
				
				while(i < hijos.length){
					if (hijos[i].esCte){
						i++;
						continue;
					}
					var = hijos[i].next();
					j = 0;
					while (j < hijos.length){
						if( i != j && var == hijos[j].valorActual){
							//var = hijos[i].next();
							i = -1;
							break;
						}
						else
							j++;
					}
					i++;
				}
				IntExprMap map = new IntExprMap(tipos);
				this.valorActual = map.toNum(nodo,this.getSExpr());
				return this.valorActual; 
			}
			
			if(ct.equals("\\seq")){
				int i = 0;
				while(i<hijos.length){
					hijos[i].next();
				}
			}
			
			if(ct.equals("\\cross")){
				int valorPrevio =  hijos[0].valorActual;
				hijos[0].next();
				if(valorPrevio == hijos[0].valorActual){
					hijos[1].next();
				}
				IntExprMap map = new IntExprMap(tipos);
				this.valorActual = map.toNum(nodo,this.getSExpr());
				return this.valorActual;
			}
			
			
			return -1;
		}
		
	}
}
