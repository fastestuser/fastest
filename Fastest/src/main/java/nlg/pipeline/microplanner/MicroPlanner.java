package nlg.pipeline.microplanner;

import java.util.ArrayList;
import java.util.List;

import client.blogic.management.Controller;
import nlg.base.documentPlan.DocumentPlan;
import nlg.base.documentPlan.ExpVerbalization;
import nlg.base.documentPlan.TClassDescriptionPlan;
import nlg.base.textSpecification.PhraseSpec;
import nlg.base.textSpecification.TSDocument;
import nlg.base.textSpecification.TSItemisedList;

public class MicroPlanner {

	private PhraseSpecBuilder psBuilder;
	
	public MicroPlanner(Controller controller) {
		psBuilder = new PhraseSpecBuilder(controller.getDesigRepo());
	}
	
	public TSDocument createTSDocument(DocumentPlan dp) {
		
		TSDocument document = new TSDocument();
		document.setTitle(dp.getTitle());
	
		List<TSItemisedList> paragraphs = new ArrayList<TSItemisedList>();
		
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