package client.blogic.testing.refinamiento;

import common.z.AbstractTCase;
import client.blogic.management.ii.events.Event_;
import client.blogic.management.ii.IIComponent;
import client.blogic.management.ii.events.TCaseRefineRequested;

public class TCaseRefClient extends IIComponent{

	public TCaseRefClient(){
	}

	public synchronized void manageEvent(Event_ event_)
			throws IllegalArgumentException{

		if (event_ instanceof TCaseRefineRequested){
			TCaseRefineRequested tCaseRefineRequested = (TCaseRefineRequested) event_;
			String opName = tCaseRefineRequested.getOpName();
			AbstractTCase absTCase = tCaseRefineRequested.getAbstractTCase();
			String refRuleName = tCaseRefineRequested.getRefRuleName();
			String pathUUT = tCaseRefineRequested.getPathUUT();
			String targetLanguaje = tCaseRefineRequested.getTargetLanguaje();
			(new Thread(new TCaseRefClientRunner(opName, absTCase, pathUUT, targetLanguaje, refRuleName))).start();
		}
		else
			throw new IllegalArgumentException();
	}

}