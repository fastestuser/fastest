package nlg.pipeline.realizer;

import nlg.base.textSpecification.PhraseSpec;

public class LinguisticRealizer {
	
	public String realize(PhraseSpec ps) {
		ArticleRealizer articleRealizer = new ArticleRealizer();
		VerbRealizer verbRealizer = new VerbRealizer();
		PhraseRealizer phraseRealizer = new PhraseRealizer();
		
		ps.accept(articleRealizer);
		ps.accept(verbRealizer);
		
		return ps.accept(phraseRealizer);
	}
	
	

}
