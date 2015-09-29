package client.blogic.management.ii.events;


import client.blogic.testing.execution.Execution;

/**
 * Represents the implicit invocation event that must be announced when a request of
 * execution was processed.
 */

public class RunCTCFinished extends Event_{

	private final Execution execution;

    /**
     * Creates an instance of RunCTCFinished.
     */
	public RunCTCFinished(Execution execution){
		super.setEventName("CTCaseRunFinished");
        this.execution = execution;
	}

    public Execution getExecution() {
        return execution;
    }
}