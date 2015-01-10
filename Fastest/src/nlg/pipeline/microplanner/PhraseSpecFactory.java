package nlg.pipeline.microplanner;

import java.util.List;

import nlg.base.textSpecification.PSConcatenacion;
import nlg.base.textSpecification.PSElementosCoordinados;
import nlg.base.textSpecification.PSFraseVerbal;
import nlg.base.textSpecification.PSOracion;
import nlg.base.textSpecification.PSTextoEnlatado;
import nlg.base.textSpecification.PhraseSpec;

public class PhraseSpecFactory {
	
	private static final String TEXT_APLICA 		= "aplicada a";
	private static final String TEXT_DOM 			= "el dominio de";
	private static final String TEXT_RAN 			= "el rango de";
	private static final String TEXT_PERTENECE 	= "pertenece";
	private static final String TEXT_UNICO_ELEM 	= "es el único elemento de";
	private static final String TEXT_Y			= "y";
	private static final String TEXT_NO_ELEM_COM	= "no tienen ningún elemento en común";
	private static final String TEXT_ELEM_COM		= "tienen al menos un elemento en común";
	private static final String TEXT_NO_HAY_ELEM	= "no hay ningún elemento en";
	private static final String TEXT_ES			= "es";
	private static final String TEXT_IGUAL		= "igual";
	private static final String TEXT_A			= "a";
	private static final String TEXT_ELEM_EN		= "elementos en";
	private static final String TEXT_TAMBIEN_EN	= "que también se encuentran en";
	private static final String TEXT_PAR_ORDENADO	= "el par ordenado formado por";
	private static final String TEXT_HAY_ELEM		= "existe al menos un elemento en";
	private static final String TEXT_CONJ_VACIO	= "el conjunto vacío";
	private static final String TEXT_CONJ_FORM	= "el conjunto formado por";
	private static final String TEXT_ESTA			= "esta";
	private static final String TEXT_INCLUIDO		= "incluido";
	private static final String TEXT_EN			= "en";
	private static final String TEXT_INCLUIDO_IG	= "esta incluido o es igual a";
	private static final String TEXT_EXISTE_UN	= "existe al menos un elemento en";
	private static final String TEXT_NO_EN		= "que no está en";

	public PhraseSpec createPSApply(PhraseSpec psFun, PhraseSpec psArg) {
		// TODO podria trabajarse un poco mas esto
		// por ej, si la verbalizacion de f no habla en terminos de 
		// una funcion podria agregarse un texto que diga algo como
		// "la funcion que representa a " ... " aplicada a " ...
		
		PSTextoEnlatado psTexto = new PSTextoEnlatado(TEXT_APLICA);
		
		PSConcatenacion psConcat = new PSConcatenacion(psFun, psTexto, psArg);
		
		return psConcat;
	}
	
	public PhraseSpec createPSDom(PhraseSpec psFun) {
		PSTextoEnlatado psTexto = new PSTextoEnlatado(TEXT_DOM);
		
		PSConcatenacion psConcat = new PSConcatenacion(psTexto, psFun);
		
		return psConcat;
	}
	
	public PhraseSpec createPSElemUnico(PhraseSpec psElem, PhraseSpec psSet) {
		PSTextoEnlatado psTexto = new PSTextoEnlatado(TEXT_UNICO_ELEM);
		
		return new PSConcatenacion(psElem, psTexto, psSet);
	}
	
	
	public PhraseSpec createPSElemPertenece(PhraseSpec psElem, PhraseSpec psSet) {
		PSFraseVerbal psPred = new PSFraseVerbal();
		psPred.setVerbo(TEXT_PERTENECE);
		psPred.setNegado(false);
		psPred.setComplemento(psSet);
		
		return new PSOracion(psElem, psPred);
	}
	
	public PhraseSpec createPSElemNoPertenece(PhraseSpec psElem, PhraseSpec psSet) {
		PSFraseVerbal psPred = new PSFraseVerbal();
		psPred.setVerbo(TEXT_PERTENECE);
		psPred.setNegado(true);
		psPred.setComplemento(psSet);
		
		return new PSOracion(psElem, psPred);
	}
	
	public PhraseSpec createPSNoElemCom(PhraseSpec psSet1, PhraseSpec psSet2) {
		return new PSConcatenacion(
					psSet1, 
					new PSTextoEnlatado(TEXT_Y),
					psSet2, 
					new PSTextoEnlatado(TEXT_NO_ELEM_COM));
	}
	
	public PhraseSpec createPSNoHayElem(PhraseSpec psSet) {
		return new PSConcatenacion(
					new PSTextoEnlatado(TEXT_NO_HAY_ELEM),
					psSet);
	}
	
	public PhraseSpec createPSEsIgual(PhraseSpec ps1, PhraseSpec ps2) {
		PSFraseVerbal psPred = new PSFraseVerbal();
		psPred.setVerbo(TEXT_ES);
		psPred.setAtributo(TEXT_IGUAL);
		psPred.setComplemento(new PSConcatenacion(new PSTextoEnlatado(TEXT_A), ps2));
		
		return new PSOracion(ps1, psPred);
	}
	
	public PhraseSpec createPSElemEnYTambienEn(PhraseSpec ps1, PhraseSpec ps2) {
		PSTextoEnlatado psText1 = new PSTextoEnlatado(TEXT_ELEM_EN);
		PSTextoEnlatado psText2 = new PSTextoEnlatado(TEXT_TAMBIEN_EN);
		
		return new PSConcatenacion(psText1, ps1, psText2, ps2);
	}
	
	public PhraseSpec createPSElemEnYEn(PhraseSpec ps1, PhraseSpec ps2) {
		PSTextoEnlatado psText1 = new PSTextoEnlatado(TEXT_ELEM_EN);
		PSTextoEnlatado psText2 = new PSTextoEnlatado(TEXT_Y);
		PSTextoEnlatado psText3 = new PSTextoEnlatado(TEXT_EN);
		
		return new PSConcatenacion(psText1, ps1, psText2, psText3, ps2);
	}

	public PhraseSpec createPSParFormadoPor(PhraseSpec ps1, PhraseSpec ps2) {
		PSTextoEnlatado psText1 = new PSTextoEnlatado(TEXT_PAR_ORDENADO);
		PSTextoEnlatado psText2 = new PSTextoEnlatado(TEXT_Y);
		
		return new PSConcatenacion(psText1, ps1, psText2, ps2);
	}
	
	public PhraseSpec createPSHayElem(PhraseSpec ps1) {
		PSTextoEnlatado psText1 = new PSTextoEnlatado(TEXT_HAY_ELEM);
		
		return new PSConcatenacion(psText1, ps1);
	}
	
	public PhraseSpec createPSElemCom(PhraseSpec psSet1, PhraseSpec psSet2) {
		return new PSConcatenacion(
					psSet1, 
					new PSTextoEnlatado(TEXT_Y),
					psSet2, 
					new PSTextoEnlatado(TEXT_ELEM_COM));
	}
	
	public PhraseSpec createPSNoEsIgual(PhraseSpec ps1, PhraseSpec ps2) {
		PSFraseVerbal psPred = new PSFraseVerbal();
		psPred.setVerbo(TEXT_ES);
		psPred.setAtributo(TEXT_IGUAL);
		psPred.setNegado(true);
		psPred.setComplemento(new PSConcatenacion(new PSTextoEnlatado(TEXT_A), ps2));
		
		return new PSOracion(ps1, psPred);
	}
	
	public PhraseSpec createPSRan(PhraseSpec psFun) {
		PSTextoEnlatado psTexto = new PSTextoEnlatado(TEXT_RAN);
		
		PSConcatenacion psConcat = new PSConcatenacion(psTexto, psFun);
		
		return psConcat;
	}
	
	public PhraseSpec createPSConjVacio() {
		return 	new PSTextoEnlatado(TEXT_CONJ_VACIO);
	}
	
	
	public PhraseSpec createPSConj(List<PhraseSpec> pss) {
		PSElementosCoordinados ps = new PSElementosCoordinados(pss);
		
		return new PSConcatenacion(new PSTextoEnlatado(TEXT_CONJ_FORM), ps);
	}
	
	public PhraseSpec createPSIncluidoEn(PhraseSpec ps1, PhraseSpec ps2) {
		PSFraseVerbal psPred = new PSFraseVerbal();
		psPred.setVerbo(TEXT_ESTA);
		psPred.setAtributo(TEXT_INCLUIDO);
		psPred.setNegado(false);
		psPred.setComplemento(new PSConcatenacion(new PSTextoEnlatado(TEXT_EN), ps2));
		
		return new PSOracion(ps1, psPred);
	}
	
	public PhraseSpec createPSIncluidoIgual(PhraseSpec ps1, PhraseSpec ps2) {
		PSTextoEnlatado psText = new PSTextoEnlatado(TEXT_INCLUIDO_IG);
		return new PSConcatenacion(ps1, psText, ps2);
	}
	
	public PhraseSpec createPSNoIncluidoEn(PhraseSpec ps1, PhraseSpec ps2) {
		PSFraseVerbal psPred = new PSFraseVerbal();
		psPred.setVerbo(TEXT_ESTA);
		psPred.setAtributo(TEXT_INCLUIDO);
		psPred.setNegado(true);
		psPred.setComplemento(new PSConcatenacion(new PSTextoEnlatado(TEXT_EN), ps2));
		
		return new PSOracion(ps1, psPred);
	}
	
	public PhraseSpec createPSExisteUnElemNoEn(PhraseSpec ps1, PhraseSpec ps2) {
		PhraseSpec psText1 = new PSTextoEnlatado(TEXT_EXISTE_UN);
		PhraseSpec psText2 = new PSTextoEnlatado(TEXT_NO_EN);
		
		return new PSConcatenacion(psText1, ps1, psText2, ps2);
	}
	
	public PhraseSpec createPSPertenecen(List<PhraseSpec> pss, PhraseSpec ps2) {
		PSElementosCoordinados ps = new PSElementosCoordinados(pss);
		
		PSFraseVerbal psPred = new PSFraseVerbal();
		psPred.setVerbo(TEXT_PERTENECE);
		psPred.setAtributo(TEXT_A);
		psPred.setNegado(false);
		
		return new PSOracion(ps, psPred);
	}
	
	public PhraseSpec createPSNoPertenecen(List<PhraseSpec> pss, PhraseSpec ps2) {
		PSElementosCoordinados ps = new PSElementosCoordinados(pss);
		
		PSFraseVerbal psPred = new PSFraseVerbal();
		psPred.setVerbo(TEXT_PERTENECE);
		psPred.setAtributo(TEXT_A);
		psPred.setNegado(true);
		
		return new PSOracion(ps, psPred);
	}
}
