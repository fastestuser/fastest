package client.blogic.testing.execution;

import client.blogic.management.ii.events.RunCTCRequested;
import client.blogic.management.ii.events.Event_;
import client.blogic.management.ii.IIComponent;
import compserver.abstraction.capture.execution.CompilationInfo;


/**
 * Instances of this class (although we assume there is only one in the system)
 * manages the requests for execute concrete test cases . These requests are
 * done in each event of type RunCTCRequested that is announced in the system and
 * each of them are processed in a different thread (to favour performance 
 * issues), running the method run() of RunTCaseClientRunner in each new thread.
 */
public class RunTCaseClient extends IIComponent {

	/**
	 * Manages an implicit invocation event.
	 * @param event_
	 * @throws java.lang.IllegalArgumentException if event_ is not instance of
	 * PruneTClassRequested
	 */
	public synchronized void manageEvent(Event_ event_)
			throws IllegalArgumentException{

		if(event_ instanceof RunCTCRequested){
			RunCTCRequested runRequest = (RunCTCRequested)event_;
			CompilationInfo compilationInfo = runRequest.getCompilationInfo();
			String runCode = null; //TODO: FIx

			(new Thread(new RunTCaseClientRunner(runCode, compilationInfo))).start();
		}
		else
			throw new IllegalArgumentException();
	}
}

