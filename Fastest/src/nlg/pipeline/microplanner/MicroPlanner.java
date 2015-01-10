package nlg.pipeline.microplanner;

import java.util.ArrayList;
import java.util.List;

import nlg.base.documentPlan.DocumentPlan;
import nlg.base.documentPlan.ExpVerbalization;
import nlg.base.documentPlan.TClassDescriptionPlan;
import nlg.base.textSpecification.PhraseSpec;
import nlg.base.textSpecification.TSDocument;
import nlg.base.textSpecification.TSItemisedList;
import nlg.base.textSpecification.TextSpec;
import client.blogic.management.Controller;

public class MicroPlanner {

	private PhraseSpecBuilder psBuilder;
	
	public MicroPlanner(Controller controller) {
		psBuilder = new PhraseSpecBuilder(controller.getDesigRepo());
	}
	
	public TextSpec createTSDocument(DocumentPlan dp) {
		
		TSDocument document = new TSDocument();
		document.setTitle(dp.getTitle());
	
		List<TextSpec> paragraphs = new ArrayList<TextSpec>();
		
		for (TClassDescriptionPlan tClassDesc : dp.gettClassDescPlanList()) {
			String opName = tClassDesc.getOpName();
			String name = tClassDesc.getName();
			String intro = tClassDesc.getIntroduction();
			
			TSItemisedList tsil = new TSItemisedList();
			tsil.setIntroduction(psBuilder.buildIntroduction(name, intro));
			
			List<PhraseSpec> pss = new ArrayList<PhraseSpec>();
			for (ExpVerbalization ev : tClassDesc.getExpressions()) {
				pss.add(psBuilder.buildExprZ(ev.getExpr(), opName));
			}
			
			tsil.setElements(pss);
			paragraphs.add(tsil);
		}
		
		document.setParagraphs(paragraphs);
		
		return document;
	}
	
}