package nlg.util;

import nlg.base.linguistic.CategoriaGramatical;
import nlg.base.linguistic.GeneroGramatical;
import nlg.base.linguistic.InfoMorfologica;
import nlg.base.linguistic.NumeroGramatical;

public class FreeLingUtils {

	// extrae informacion morfologica como genero y numero 
	// de una etiqueta generada por FreeLing
	public static InfoMorfologica getInfoMorfologica(String tag) {
		InfoMorfologica ret = new InfoMorfologica();
		
		// identifico categoria
		if (tag.startsWith("DA")) {
			ret.setCatGramatical(CategoriaGramatical.ARTICULO);
		} else if (tag.startsWith("N")) {
			ret.setCatGramatical(CategoriaGramatical.NOMBRE);
		}
		
		// TODO faltaria analizar otros tipos de categorias 
		// (por el momento solo se necesitan estas dos)
		
		
		// analizo genero y numero
		if (tag.length() > 3) {
			if (tag.charAt(2) == 'F') {
				ret.setGenGramatical(GeneroGramatical.F);
			} else {
				ret.setGenGramatical(GeneroGramatical.M);
			}
			
			if (tag.charAt(3) == 'P') {
				ret.setNumGramatical(NumeroGramatical.P);
			} else {
				ret.setNumGramatical(NumeroGramatical.S);
			}
		}
		
		return ret;
	}
}
