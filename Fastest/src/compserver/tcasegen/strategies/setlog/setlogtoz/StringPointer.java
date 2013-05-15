package compserver.tcasegen.strategies.setlog.setlogtoz;

class StringPointer{
	
	private String valor;
	
	public StringPointer(){}
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