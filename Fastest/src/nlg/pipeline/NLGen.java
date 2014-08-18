package nlg.pipeline;

import java.util.List;

import nlg.base.NLGDocument;
import nlg.base.NLGDocumentPlan;
import client.blogic.management.Controller;
import common.z.TClass;

public class NLGen {
	private DocumentPlanner documentPlaner;
	private LingRealizer linguisticRealizer;
	private StrtRealizer structureRealizer;
	
	public NLGen(DocumentPlanner documentPlaner, LingRealizer linguisticRealizer, StrtRealizer structureRealizer) {
		this.documentPlaner = documentPlaner;
		this.linguisticRealizer = linguisticRealizer;
		this.structureRealizer = structureRealizer;
	}

	/**
	 * Genera descripcion en lenguaje natural para un conjunto de clases de prueba
	 * @param tClasses Lista de clases de prueba a describir
	 * @param controller Referencia al controller de Fastest 
	 *   (con informacion sobre la especificacion y designaciones)
	 * @return Texto en lenguaje natural correspondiente a las descripciones generadas.
	 */
	public String genNLDescription(List<TClass> tClasses, Controller controller) {
		
		// Etapa 1: Document planning
		NLGDocumentPlan dp = documentPlaner.plan(tClasses, controller);
		
		// Etapa 2: Microplanning
		// ----------------------
		
		// Etapa 3: Realization 
		NLGDocument dd = linguisticRealizer.realize(dp, controller);
		String finalText = structureRealizer.convert(dd);
		
		return finalText;
	}
	
	public void setDocumentPlaner(DocumentPlanner documentPlaner) {
		this.documentPlaner = documentPlaner;
	}
	
	public void setLinguisticRealizer(LingRealizer linguisticRealizer) {
		this.linguisticRealizer = linguisticRealizer;
	}

	public void setStructureRealizer(StrtRealizer structureRealizer) {
		this.structureRealizer = structureRealizer;
	}
}
