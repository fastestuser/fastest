package nlg.pipeline.realizer;

import nlg.base.textSpecification.PhraseSpec;
import nlg.base.textSpecification.TSDocument;
import nlg.base.textSpecification.TSItemisedList;

public class TextSurfaceRealizer implements SurfaceRealizer {
	
	private LinguisticRealizer lr = new LinguisticRealizer();

	@Override
	public String realize(TSDocument tsDocument) {
		
		String ret = "";
		
		for (TSItemisedList ti : tsDocument.getParagraphs()) {
			ret = lr.realize(ti.getIntroduction()) + '\n';
					
			for (PhraseSpec ps : ti.getElements()) {
				ret += " + " + lr.realize(ps) + '\n';
			}
			
			ret += '\n'; 
		}
		
		return ret;
	}

}
