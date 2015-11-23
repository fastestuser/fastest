package nlg.pipeline.microplanner;

import java.util.List;

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

public class PhraseSpecFactory {

	// articulos
	private static final String TEXT_EL 						= "el";

	// sustantivos
	private static final String TEXT_DOMINIO					= "dominio";
	private static final String TEXT_RANGO					= "rango";
	private static final String TEXT_ELEMENTOS				= "elementos";
	private static final String TEXT_PAR						= "par";
	private static final String TEXT_CONJUNTO					= "conjunto";

	private static final InfoMorfologica infDominio 			= new InfoMorfologica(
																	GeneroGramatical.M,
																	NumeroGramatical.S, 
																	CategoriaGramatical.NOMBRE);
	private static final InfoMorfologica infRango				= new InfoMorfologica(
																	GeneroGramatical.M, 
																	NumeroGramatical.S, 
																	CategoriaGramatical.NOMBRE);
	private static final InfoMorfologica infElementos			= new InfoMorfologica(
																	GeneroGramatical.M, 
																	NumeroGramatical.P, 
																	CategoriaGramatical.NOMBRE);
	private static final InfoMorfologica infPar 				= new InfoMorfologica(
																	GeneroGramatical.M, 
																	NumeroGramatical.S, 
																	CategoriaGramatical.NOMBRE);
	private static final InfoMorfologica infConjunto			= new InfoMorfologica(
																	GeneroGramatical.M, 
																	NumeroGramatical.S, 
																	CategoriaGramatical.NOMBRE);

	// adjetivos
	private static final String TEXT_ORDENADO					= "ordenado";
	private static final String TEXT_VACIO					= "vacío";

	// verbos
	private static final String TEXT_ESTA						= "está";
	private static final String TEXT_ES						= "es";
	private static final String TEXT_PERTENECE				= "pertenece";

	// atributos
	private static final String TEXT_IGUAL					= "igual";
	private static final String TEXT_INCLUIDO					= "incluido";

	// otros
	private static final String TEXT_DE						= "de";
	private static final String TEXT_Y						= "y";
	private static final String TEXT_A						= "a";
	private static final String TEXT_EN						= "en";

	// texto enlatado
	private static final String TEXT_APLICADA					= "aplicada";
	private static final String TEXT_UNICO_ELEM				= "único elemento";
	private static final String TEXT_NO_ELEM_COM				= "no tienen ningún elemento en común";
	private static final String TEXT_ELEM_COM					= "tienen al menos un elemento en común";
	private static final String TEXT_NO_HAY_ELEM				= "no hay ningún elemento";
	private static final String TEXT_TAMBIEN_SE_ENCUENTRAN 	= "que también se encuentran";
	private static final String TEXT_FORMADO_POR				= "formado por";
	private static final String TEXT_HAY_ELEM					= "existe al menos un elemento";
	private static final String TEXT_INCLUIDO_IGUAL			= "está incluido o es igual";
	private static final String TEXT_EXISTE_UN				= "existe al menos un elemento";
	private static final String TEXT_NO_EN					= "que no está";

	
	// verb(psFun) + "aplicada a" + verb(psArg)
	public PhraseSpec createPSApply(PhraseSpec psFun, PhraseSpec psArg) {
		// TODO podria trabajarse un poco mas esto
		// por ej, si la verbalizacion de f no habla en terminos de
		// una funcion podria agregarse un texto que diga algo como
		// "la funcion que representa a " ... " aplicada a " ...

		PSTextoEnlatado t_aplicada = new PSTextoEnlatado(TEXT_APLICADA);
		PSTextoEnlatado t_a = new PSTextoEnlatado(TEXT_A);

		PSConcatenacion psConcat = new PSConcatenacion(psFun, t_aplicada, t_a, psArg);

		return psConcat;
	}

	// "el dominio de" + verb(psFun)
	public PhraseSpec createPSDom(PhraseSpec psFun) {
		PSFraseNominal fn = new PSFraseNominal();
		fn.setEspecificador(TEXT_EL);
		fn.setNucleo(TEXT_DOMINIO);
		fn.setInfoNucleo(infDominio);
		PhraseSpec comp = new PSConcatenacion(new PSTextoEnlatado(TEXT_DE), psFun);
		fn.setComplemento(comp);

		return fn;
	}

	
	// TODO revisar (son los unicos elementos ?)
	// verb(psElem) + "es el unico elemento en" + verb(psSet)
	public PhraseSpec createPSElemUnico(PhraseSpec psElem, PhraseSpec psSet) {
		PSTextoEnlatado t_es 			= new PSTextoEnlatado(TEXT_ES);
		PSTextoEnlatado t_el 			= new PSTextoEnlatado(TEXT_EL);
		PSTextoEnlatado t_unico_elem 	= new PSTextoEnlatado(TEXT_UNICO_ELEM);
		PSTextoEnlatado t_en 			= new PSTextoEnlatado(TEXT_EN);

		return new PSConcatenacion(psElem, t_es, t_el, t_unico_elem, t_en, psSet);
	}

	// verb(psElem) + "pertenece(n) a" + verb(psSet)
	public PhraseSpec createPSElemPertenece(PhraseSpec psElem, PhraseSpec psSet) {
		PSFraseVerbal psPred = new PSFraseVerbal();
		psPred.setVerbo(TEXT_PERTENECE);
		psPred.setNegado(false);
		PhraseSpec comp = new PSConcatenacion(new PSTextoEnlatado(TEXT_A), psSet);
		psPred.setComplemento(comp);

		return new PSOracion(psElem, psPred);
	}

	// verb(psElem) + "no pertenece(n) a" + verb(psSet)
	public PhraseSpec createPSElemNoPertenece(PhraseSpec psElem, PhraseSpec psSet) {
		PSFraseVerbal psPred = new PSFraseVerbal();
		psPred.setVerbo(TEXT_PERTENECE);
		psPred.setNegado(true);
		PhraseSpec comp = new PSConcatenacion(new PSTextoEnlatado(TEXT_A), psSet);
		psPred.setComplemento(comp);

		return new PSOracion(psElem, psPred);
	}

	// verb(psSet1) + "y" + verb(psSet2) + "no tienen ningun elemento en comun" 
	public PhraseSpec createPSNoElemCom(PhraseSpec psSet1, PhraseSpec psSet2) {
		return new PSConcatenacion(psSet1, new PSTextoEnlatado(TEXT_Y), psSet2,
				new PSTextoEnlatado(TEXT_NO_ELEM_COM));
	}

	// "no hay ningun elemento en" + verb(psSet)
	public PhraseSpec createPSNoHayElem(PhraseSpec psSet) {
		return new PSConcatenacion(
				new PSTextoEnlatado(TEXT_NO_HAY_ELEM),
				new PSTextoEnlatado(TEXT_EN),
				psSet);
	}

	// verb(ps1) + "es(son) igual(iguales) a" + verb(ps2)
	public PhraseSpec createPSEsIgual(PhraseSpec ps1, PhraseSpec ps2) {
		PSFraseVerbal psPred = new PSFraseVerbal();
		psPred.setVerbo(TEXT_ES);
		psPred.setNegado(false);
		psPred.setAtributo(TEXT_IGUAL);
		psPred.setComplemento(new PSConcatenacion(new PSTextoEnlatado(TEXT_A), ps2));

		return new PSOracion(ps1, psPred);
	}

	// "elementos en" + verb(ps1) + "que también se encuentran en" + verb(ps2)
	public PhraseSpec createPSElemEnYTambienEn(PhraseSpec ps1, PhraseSpec ps2) {
		PSFraseNominal fn = new PSFraseNominal();
		fn.setNucleo(TEXT_ELEMENTOS);
		fn.setInfoNucleo(infElementos);
		PhraseSpec comp = new PSConcatenacion(
				new PSTextoEnlatado(TEXT_EN),
				ps1,
				new PSTextoEnlatado(TEXT_TAMBIEN_SE_ENCUENTRAN),
				new PSTextoEnlatado(TEXT_EN),
				ps2);
		fn.setComplemento(comp);

		return fn;
	}

	// "elementos en" + verb(ps1) + "y en" + verb(ps2)
	public PhraseSpec createPSElemEnYEn(PhraseSpec ps1, PhraseSpec ps2) {
		PSFraseNominal fn = new PSFraseNominal();
		fn.setNucleo(TEXT_ELEMENTOS);
		fn.setInfoNucleo(infElementos);
		PSConcatenacion comp = new PSConcatenacion(
				new PSTextoEnlatado(TEXT_EN), 
				ps1,
				new PSTextoEnlatado(TEXT_Y),
				new PSTextoEnlatado(TEXT_EN), 
				ps2);
		fn.setComplemento(comp);

		return fn;
	}

	// "par ordenado formado por" + verb(ps1) + "y" + verb(ps2) 
	public PhraseSpec createPSParFormadoPor(PhraseSpec ps1, PhraseSpec ps2) {
		PSFraseNominal fn = new PSFraseNominal();
		fn.setNucleo(TEXT_PAR);
		fn.setInfoNucleo(infPar);
		PSConcatenacion comp = new PSConcatenacion(
				new PSTextoEnlatado(TEXT_ORDENADO),
				new PSTextoEnlatado(TEXT_FORMADO_POR), 
				ps1,
				new PSTextoEnlatado(TEXT_Y), 
				ps2);
		fn.setComplemento(comp);

		return fn;
	}

	// "existe al menos un elemento" + verb(ps1) 
	public PhraseSpec createPSHayElem(PhraseSpec ps1) {
		PSTextoEnlatado psText1 = new PSTextoEnlatado(TEXT_HAY_ELEM);

		return new PSConcatenacion(psText1, ps1);
	}

	// verb(ps1) + "y" + verb(ps2) + "tienen al menos un elemento en común"
	public PhraseSpec createPSElemCom(PhraseSpec psSet1, PhraseSpec psSet2) {
		return new PSConcatenacion(
				psSet1, 
				new PSTextoEnlatado(TEXT_Y), 
				psSet2,
				new PSTextoEnlatado(TEXT_ELEM_COM));
	}

	// verb(ps1) + "no es(son) igual(iguales) a" + verb(ps2)
	public PhraseSpec createPSNoEsIgual(PhraseSpec ps1, PhraseSpec ps2) {
		PSFraseVerbal psPred = new PSFraseVerbal();
		psPred.setVerbo(TEXT_ES);
		psPred.setNegado(true);
		psPred.setAtributo(TEXT_IGUAL);
		psPred.setComplemento(new PSConcatenacion(new PSTextoEnlatado(TEXT_A), ps2));

		return new PSOracion(ps1, psPred);
	}

	// "el rango de" + verb(psFun)
	public PhraseSpec createPSRan(PhraseSpec psFun) {
		PSFraseNominal fn = new PSFraseNominal();
		fn.setEspecificador(TEXT_EL);
		fn.setNucleo(TEXT_RANGO);
		fn.setInfoNucleo(infRango);
		PhraseSpec comp = new PSConcatenacion(new PSTextoEnlatado(TEXT_DE), psFun);
		fn.setComplemento(comp);

		return fn;
	}

	// "el conjunto vacio"
	public PhraseSpec createPSConjVacio() {
		PSFraseNominal fn = new PSFraseNominal();
		fn.setEspecificador(TEXT_EL);
		fn.setNucleo(TEXT_CONJUNTO);
		fn.setInfoNucleo(infConjunto);
		PhraseSpec comp = new PSConcatenacion(new PSTextoEnlatado(TEXT_VACIO));
		fn.setComplemento(comp);

		return fn;
	}

	// "el conjunto formado por" + verb(pss)
	public PhraseSpec createPSConj(List<PhraseSpec> pss) {
		PSFraseNominal fn = new PSFraseNominal();
		fn.setEspecificador(TEXT_EL);
		fn.setNucleo(TEXT_CONJUNTO);
		fn.setInfoNucleo(infConjunto);
		PhraseSpec comp = new PSConcatenacion(
				new PSTextoEnlatado(TEXT_FORMADO_POR),
				new PSElementosCoordinados(pss));
		fn.setComplemento(comp);
		
		return fn;
	}

	// verb(ps1) + "esta incluido" + verb(ps2)
	public PhraseSpec createPSIncluidoEn(PhraseSpec ps1, PhraseSpec ps2) {
		PSFraseVerbal psPred = new PSFraseVerbal();
		psPred.setVerbo(TEXT_ESTA);
		psPred.setAtributo(TEXT_INCLUIDO);
		psPred.setNegado(false);
		psPred.setComplemento(new PSConcatenacion(new PSTextoEnlatado(TEXT_EN), ps2));

		return new PSOracion(ps1, psPred);
	}
	
	// verb(ps1) + "esta incluido o es igual a" + verb(ps2)
	public PhraseSpec createPSIncluidoIgual(PhraseSpec ps1, PhraseSpec ps2) {
		PSTextoEnlatado psText = new PSTextoEnlatado(TEXT_INCLUIDO_IGUAL);
		return new PSConcatenacion(ps1, psText, ps2);
	}

	// verb(ps1) + "no esta incluido" + verb(ps2)
	public PhraseSpec createPSNoIncluidoEn(PhraseSpec ps1, PhraseSpec ps2) {
		PSFraseVerbal psPred = new PSFraseVerbal();
		psPred.setVerbo(TEXT_ESTA);
		psPred.setAtributo(TEXT_INCLUIDO);
		psPred.setNegado(true);
		psPred.setComplemento(new PSConcatenacion(new PSTextoEnlatado(TEXT_EN), ps2));

		return new PSOracion(ps1, psPred);
	}

	// "existe al menos un elemento en" + verb(ps1) + "que no esta en" + verb(ps2) 
	public PhraseSpec createPSExisteUnElemNoEn(PhraseSpec ps1, PhraseSpec ps2) {

		return new PSConcatenacion(
				new PSTextoEnlatado(TEXT_EXISTE_UN),
				new PSTextoEnlatado(TEXT_EN),
				ps1, 
				new PSTextoEnlatado(TEXT_NO_EN),
				new PSTextoEnlatado(TEXT_EN),
				ps2);
	}

	// verb(pss) + "pertenece(n) a" + verb(ps2)
	public PhraseSpec createPSPertenecen(List<PhraseSpec> pss, PhraseSpec ps2) {
		PSElementosCoordinados ps = new PSElementosCoordinados(pss);

		PSFraseVerbal psPred = new PSFraseVerbal();
		psPred.setVerbo(TEXT_PERTENECE);
		psPred.setNegado(false);
		PSConcatenacion psComp = new PSConcatenacion(new PSTextoEnlatado(TEXT_A), ps2);
		psPred.setComplemento(psComp);

		return new PSOracion(ps, psPred);
	}

	// verb(pss) + "no pertenece(n) a" + verb(ps2)
	public PhraseSpec createPSNoPertenecen(List<PhraseSpec> pss, PhraseSpec ps2) {
		PSElementosCoordinados ps = new PSElementosCoordinados(pss);

		PSFraseVerbal psPred = new PSFraseVerbal();
		psPred.setVerbo(TEXT_PERTENECE);
		psPred.setNegado(true);
		PSConcatenacion psComp = new PSConcatenacion(new PSTextoEnlatado(TEXT_A), ps2);
		psPred.setComplemento(psComp);

		return new PSOracion(ps, psPred);
	}
}