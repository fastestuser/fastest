package nlg.pipeline.realizer;

import nlg.base.textSpecification.PhraseSpec;

public class LinguisticRealizer {
	
	public String realise(PhraseSpec ps) {
		ConcordanciaArticulo ca = new ConcordanciaArticulo();
		ConcordanciaVerbo cv = new ConcordanciaVerbo();
		Verbalizador converter = new Verbalizador();
		
		ps.accept(ca);
		ps.accept(cv);
		
		return ps.accept(converter);
	}
	
	

}
