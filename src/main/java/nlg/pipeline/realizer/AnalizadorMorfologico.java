package nlg.pipeline.realizer;

import edu.upc.freeling.ListWordIterator;
import edu.upc.freeling.Sentence;
import edu.upc.freeling.Word;
import nlg.base.linguistic.CategoriaGramatical;
import nlg.base.linguistic.GeneroGramatical;
import nlg.base.linguistic.InfoMorfologica;
import nlg.base.linguistic.NumeroGramatical;
import nlg.base.textSpecification.PSConcatenacion;
import nlg.base.textSpecification.PSElementosCoordinados;
import nlg.base.textSpecification.PSFraseNominal;
import nlg.base.textSpecification.PSFraseVerbal;
import nlg.base.textSpecification.PSOracion;
import nlg.base.textSpecification.PSTextoEnlatado;
import nlg.base.textSpecification.PhraseSpec;
import nlg.base.textSpecification.PhraseSpecVisitor;
import nlg.util.FreeLingAnalyzer;
import nlg.util.FreeLingUtils;

// analizador morfologico nucleo sujeto
public class AnalizadorMorfologico implements PhraseSpecVisitor<InfoMorfologica> {

	@Override
	public InfoMorfologica visitPSConcatenacion(PSConcatenacion ps) {
		// analizo recursivamente elemento por elemento
		for (PhraseSpec p : ps.getElementos()) {
			InfoMorfologica im = p.accept(this);
			
			if (null != im) {
				return im;
			}
		}
		
		return null;
	}

	@Override
	public InfoMorfologica visitPSElementosCoordinados(PSElementosCoordinados ps) {
		InfoMorfologica ret = new InfoMorfologica();
		
		// determino numero
		if (1 == ps.getElementos().size()) {
			ret.setNumGramatical(NumeroGramatical.S);
		} else {
			ret.setNumGramatical(NumeroGramatical.P);
		}
		
		// determino sexo segun elementos que lo componen
		boolean hayM = false;
		boolean hayF = false;
		for (PhraseSpec p : ps.getElementos()) {
			InfoMorfologica im = p.accept(this);
			
			if (null == im && null != im.getGenGramatical()) {
				if (im.getGenGramatical().equals(GeneroGramatical.M)) {
					hayM = true;
				} else {
					hayM = true;
				}
			}
		}
		
		// verifico si todos los elementos tienen genero femenino
		if (hayF && !hayM) {
			ret.setGenGramatical(GeneroGramatical.F);
		} else {
			ret.setGenGramatical(GeneroGramatical.M);
		}
		
		return ret;
	}

	@Override
	public InfoMorfologica visitPSFraseNominal(PSFraseNominal ps) {
		return ps.getInfoNucleo();
	}

	@Override
	public InfoMorfologica visitPSFraseVerbal(PSFraseVerbal ps) {
		// error, el sujeto no puede ser una frase verbal
		return null;
	}

	@Override
	public InfoMorfologica visitPSOracion(PSOracion ps) {
		// error, el sujeto no puede ser otra oracion
		return null;
	}

	@Override
	public InfoMorfologica visitPSTextoEnlatado(PSTextoEnlatado ps) {
		InfoMorfologica ret = null;
		
		// analizo texto
		Sentence s = new FreeLingAnalyzer().analyze(ps.getText());
		
		// busco palabra por palabra sustantivo o pronombre
		if (null != s) {
			ListWordIterator wIt = new ListWordIterator(s);
			
			if (wIt.hasNext()) {
				Word w = wIt.next();
				String tag = w.getTag();
				
				InfoMorfologica im = FreeLingUtils.getInfoMorfologica(tag);
				
				if (null != im.getCatGramatical() && 
						im.getCatGramatical().equals(CategoriaGramatical.NOMBRE)) {
					ret = im;
				}
				
			}
		}
		
		return ret;
	}

}
