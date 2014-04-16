package client.blogic.testing.refinement.java;

public class RightSide {
	public String varName = ""; //java
	public String varType = ""; //java
	public String atribute = "";
	public boolean isPrivate = false; //si la variable es privada
	public String privateFieldVar = "";
	public String field = "";                                                                                                                                                                                                                                                                                               
	public String listPosition = ""; //Variable auxiliar para cuando se refinan expresions tipo "var[expression]
	
	RightSide(){
		this.varName = "";
		this.varType = "";
		this.atribute = "";
		this.privateFieldVar = "";
		this.field = "";
		this.listPosition = "";
		this.isPrivate = false;
	}

}
