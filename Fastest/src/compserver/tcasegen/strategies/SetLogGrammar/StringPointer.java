package compserver.tcasegen.strategies.SetLogGrammar;

class StringPointer{
	
	private String valor;
	
	public StringPointer(){}
	public StringPointer(String s){
		valor = s;
	}
	
	
	public void setString(String s){
		this.valor = s;		
	}
	public String toString(){
		return this.valor;		
	}
} 