package nlg.pipeline.controller;

import java.util.List;

import client.blogic.management.Controller;
import nlg.pipeline.documentPlanner.DocumentPlanner;
import nlg.pipeline.microplanner.MicroPlanner;
import nlg.pipeline.realizer.SurfaceRealizer;

public class NLGPipeline {

	private Controller controller;
	private SurfaceRealizer surfaceRealizer;
	
	public NLGPipeline(Controller controller) {
		this.controller = controller;
	}
	
	public String run(List<String> names) throws Exception {
		DocumentPlanner documentPlanner = new DocumentPlanner(controller);
		MicroPlanner microplanner = new MicroPlanner(controller);

		return surfaceRealizer.realize(microplanner.createTSDocument(documentPlanner.createDP(names)));
	}

	public void setSurfaceRealizer(SurfaceRealizer surfaceRealizer) {
		this.surfaceRealizer = surfaceRealizer;
	}
}
