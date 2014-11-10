package nlg.pipeline;

import nlg.base.NLGDocument;
import nlg.base.documentPlan.DocumentPlan;
import client.blogic.management.Controller;

/**
 * Interfaz abstracta para el realizador linguistico
 * Engargado de generar texto en lenguaje natural 
 * a partir de un DocumentPlan
 *
 */
public interface LingRealizer {
	public NLGDocument realize(DocumentPlan documentPlan, Controller controller);
}
