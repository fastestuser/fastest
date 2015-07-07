package nlg.pipeline.realizer;

import nlg.base.linguistic.ArticulosGramaticales;
import nlg.base.linguistic.GeneroGramatical;
import nlg.base.linguistic.NumeroGramatical;
import nlg.base.textSpecification.PSConcatenacion;
import nlg.base.textSpecification.PSElementosCoordinados;
import nlg.base.textSpecification.PSFraseNominal;
import nlg.base.textSpecification.PSFraseVerbal;
import nlg.base.textSpecification.PSOracion;
import nlg.base.textSpecification.PSTextoEnlatado;
import nlg.base.textSpecification.PhraseSpec;
import nlg.base.textSpecification.PhraseSpecVisitor;

// completa articulos faltantes en una frase nominal
public class ConcordanciaArticulo implements PhraseSpecVisitor<Void> {

	@Override
	public Void visitPSConcatenacion(PSConcatenacion ps) {
		for (PhraseSpec p : ps.getElementos()) {
			p.accept(this);
		}
		
		return null;
	}

	@Override
	public Void visitPSElementosCoordinados(PSElementosCoordinados ps) {
		for (PhraseSpec p : ps.getElementos()) {
			p.accept(this);
		}
		
		return null;
	}

	@Override
	public Void visitPSFraseNominal(PSFraseNominal ps) {
		// si no fue seteado el articulo seteo el correspondiente
		// segun numero y genero
		if (null == ps.getEspecificador()) {
			GeneroGramatical gg = ps.getInfoNucleo().getGenGramatical();
			NumeroGramatical ng = ps.getInfoNucleo().getNumGramatical();
			
			if (gg.equals(GeneroGramatical.M)) {
				if (ng.equals(NumeroGramatical.S)) {
					ps.setEspecificador(ArticulosGramaticales.EL);
				} else {
					ps.setEspecificador(ArticulosGramaticales.LOS);
				}
			} else {
				if (ng.equals(NumeroGramatical.S)) {
					ps.setEspecificador(ArticulosGramaticales.LA);
				} else {
					ps.setEspecificador(ArticulosGramaticales.LAS);
				}
			}
		}
		
		ps.getComplemento().accept(this);
		
		return null;
	}

	@Override
	public Void visitPSFraseVerbal(PSFraseVerbal ps) {
		ps.getComplemento().accept(this);
		
		return null;
	}

	@Override
	public Void visitPSOracion(PSOracion ps) {
		ps.getSujeto().accept(this);
		ps.getPredicado().accept(this);
		
		return null;
	}

	@Override
	public Void visitPSTextoEnlatado(PSTextoEnlatado ps) {
		return null;
	}

}
