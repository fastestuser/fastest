package client.blogic.management.ii.events;


import client.blogic.testing.atcal.ConcreteTCase;
import client.blogic.testing.execution.Execution;

/**
 * Represents the implicit invocation event that must be announced when a request of
 * execution was processed.
 */

public class RunCTCFinished extends Event_{

    private final ConcreteTCase concreteTCase;
	private final Execution execution;

    /**
     * Creates an instance of RunCTCFinished.
     */
	public RunCTCFinished(ConcreteTCase concreteTCase, Execution execution){
		super.setEventName("runCTCFinished");
        this.concreteTCase =  concreteTCase;
        this.execution = execution;
	}

    public ConcreteTCase getConcreteTCase() {
        return concreteTCase;
    }

    public Execution getExecution() {
        return execution;
    }
}