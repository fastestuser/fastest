package compserver.tcasegen.strategies.setlog.setlogtoz;


/* Usado por setlogtoz, para permitir a varias variables setlog 
 * apuntar a un StringPointer y ahorrar mantener la invariante 
 * de igualdad de la secuencias de igualdades si se usara solo String.
 * */
public final class  StringPointer{
	
	private String valor;
	
	public StringPointer(){
		valor = "";
	}
	public StringPointer(String s){
		valor = s;
	}
	
	public StringPointer concat(StringPointer s2){
		valor = valor + s2.toString();
		return this;
	}
	public StringPointer concat(String s2){
		valor = valor + s2.toString();
		return this;
	}
	
	public void setString(String s){
		this.valor = s;		
	}
	public String toString(){
		return this.valor;		
	}
	public boolean contains(String s){
		return valor.contains(s);
	}
} 