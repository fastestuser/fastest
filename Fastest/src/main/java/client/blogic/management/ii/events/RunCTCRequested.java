package client.blogic.management.ii.events;


import client.blogic.testing.atcal.ConcreteTCase;
import compserver.abstraction.capture.execution.CompilationInfo;

/**
 * Represents the implicit invocation event that must be announced when the
 * the execution of a concrete test case is requested.
 * @author Cristian Rosa
 */
public class RunCTCRequested extends Event_ {

    private ConcreteTCase concreteTCase;        // the concrete test case
    private CompilationInfo compilationInfo;    // the compiler or interpreter information
    private String workingDirectory;            // the directory where the test case must be executed

    /**
     * Creates a new instance of a concrete test case execution request event
     * @param concreteTCase     the concrete test case to execute
     * @param compilationInfo   the compiler information associated to the request event
     * @param workingDirectory  the working directory where the test case must be executed
     */
    public RunCTCRequested(ConcreteTCase concreteTCase, CompilationInfo compilationInfo, String workingDirectory) {
        this.concreteTCase = concreteTCase;
        this.compilationInfo = compilationInfo;
        this.workingDirectory = workingDirectory;
        super.setEventName("runCTCRequested");
    }

    /**
     * Gets the concrete test case associated to the request event
     * @return  the concrete test case associated to the request event
     */
	public ConcreteTCase getConcreteTCase(){
        return concreteTCase;
	}

    /**
     * Gets the compiler information associated to the request event
     * @return  the compiler information associated to the request event
     */
    public CompilationInfo getCompilationInfo() {
        return compilationInfo;
    }

    /**
     * Gets the working directory where the test case must be executed
     * @return  the working directory where the test case must be executed
     */
    public String getWorkingDirectory(){
        return workingDirectory;
	}
}