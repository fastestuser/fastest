package nlg.pipeline.realizer;

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

// conjuga verbo de una oracion bimembre segun numero del sujeto
// para este trabaja los verbos se conjugarán siempre en 
// 3era persona tiempo presente
public class VerbRealizer implements PhraseSpecVisitor<Void> {

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
		PSFraseVerbal fv = ps.getPredicado();
		
		// analizo sujeto
		AnalizadorMorfologico vis = new AnalizadorMorfologico();
		InfoMorfologica infSujeto = ps.getSujeto().accept(vis);
		
		if (	null != infSujeto &&
				null != infSujeto.getGenGramatical() &&
				null != infSujeto.getNumGramatical()) {
			String verbo = ps.getPredicado().getVerbo();
			String atributo = ps.getPredicado().getAtributo();
			
			// TODO cambiar esto, echo solo solo para probar!
			if (infSujeto.getNumGramatical().equals(NumeroGramatical.P)) {
				if (verbo.equals("pertenece")) {
					fv.setVerbo("pertenecen");
				} else if (verbo.equals("está")) {
					fv.setVerbo("están");
				} else if (verbo.equals("es")) {
					fv.setVerbo("son");
				}
			}
			
			if (null != atributo) {
				if (atributo.equals("igual")) {
					if (infSujeto.getNumGramatical().equals(NumeroGramatical.P)) {
						fv.setAtributo("iguales");
					}
				} else if (atributo.equals("incluido")) {
					if (infSujeto.getNumGramatical().equals(NumeroGramatical.P)) {
						if (infSujeto.getGenGramatical().equals(GeneroGramatical.M)) {
							fv.setAtributo("incluidos");
						} else {
							fv.setAtributo("incluidas");
						}
					} else {
						if (infSujeto.getGenGramatical().equals(GeneroGramatical.F)) {
							fv.setAtributo("incluida");
						}
					}
				}
			}
		}
		
		return null;
	}

	@Override
	public Void visitPSTextoEnlatado(PSTextoEnlatado ps) {
		return null;
	}

}
