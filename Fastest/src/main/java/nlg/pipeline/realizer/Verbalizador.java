package nlg.pipeline.realizer;

import nlg.base.textSpecification.PSConcatenacion;
import nlg.base.textSpecification.PSElementosCoordinados;
import nlg.base.textSpecification.PSFraseNominal;
import nlg.base.textSpecification.PSFraseVerbal;
import nlg.base.textSpecification.PSOracion;
import nlg.base.textSpecification.PSTextoEnlatado;
import nlg.base.textSpecification.PhraseSpec;
import nlg.base.textSpecification.PhraseSpecVisitor;

/**
 * Clase encargada del ultimo paso
 * Convierte a texto una especificacion ya trabajada
 */
public class Verbalizador implements PhraseSpecVisitor<String> {

	@Override
	public String visitPSConcatenacion(PSConcatenacion ps) {
		String ret = "";
		
		for (PhraseSpec p : ps.getElementos()) {
			ret +=  p.accept(this) + " ";
		}
		
		return ret;
	}

	@Override
	public String visitPSElementosCoordinados(PSElementosCoordinados ps) {
		// TODO Auto-generated method stub
		return "NO IMPLEMENTADO";
	}

	@Override
	public String visitPSFraseNominal(PSFraseNominal ps) {
		String ret = "";
		
		if (null != ps.getEspecificador()) {
			ret += ps.getEspecificador() + " ";
		}
		
		ret += ps.getNucleo() + " ";
		
		if (null != ps.getComplemento()) {
			ret += ps.getComplemento().accept(this);
		}
		
		return ret;
	}

	@Override
	public String visitPSFraseVerbal(PSFraseVerbal ps) {
		String ret = "";
		
		ret += ps.getVerbo() + " ";
		
		if (null != ps.getAtributo()) {
			ret += ps.getAtributo() + " ";
		}
		
		ret += ps.getComplemento().accept(this);
		
		return ret;
	}

	@Override
	public String visitPSOracion(PSOracion ps) {
		String ret = "";
		
		ret += ps.getSujeto() + " ";
		
		ret += ps.getPredicado().accept(this);
		
		return ret;
	}

	@Override
	public String visitPSTextoEnlatado(PSTextoEnlatado ps) {
		return ps.getText();
	}

}
