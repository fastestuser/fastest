package nlg.base.linguistic;

/**
 * Almacena informacion morfologica como genero y numero
 */
public class InfoMorfologica {
	private CategoriaGramatical catGramatical;
	private GeneroGramatical genGramatical;
	private NumeroGramatical numGramatical;
	
	public InfoMorfologica() {
		
	}
	
	public InfoMorfologica(GeneroGramatical generoGramatical, NumeroGramatical numeroGramatical, CategoriaGramatical categoriaGramatical) {
		this.genGramatical = generoGramatical;
		this.numGramatical = numeroGramatical;
		this.catGramatical = categoriaGramatical;
	}
	
	public GeneroGramatical getGenGramatical() {
		return genGramatical;
	}
	
	public void setGenGramatical(GeneroGramatical generoGramatical) {
		this.genGramatical = generoGramatical;
	}
	
	public NumeroGramatical getNumGramatical() {
		return numGramatical;
	}
	
	public void setNumGramatical(NumeroGramatical numeroGramatical) {
		this.numGramatical = numeroGramatical;
	}

	public CategoriaGramatical getCatGramatical() {
		return catGramatical;
	}

	public void setCatGramatical(CategoriaGramatical categoriaGramatical) {
		this.catGramatical = categoriaGramatical;
	}
	
	
}
